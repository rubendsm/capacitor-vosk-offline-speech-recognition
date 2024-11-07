package com.mitmynid.plugins.vosk;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.speech.SpeechRecognizer;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import org.vosk.android.RecognitionListener;

@CapacitorPlugin(name = "Vosk")
public class VoskPlugin extends Plugin {

    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 1;
    private Vosk voskImplementation = new Vosk();


    @Override
    public void load() {
        super.load();
        bridge
                .getWebView()
                .post(
                        () -> {

                        }
                );
    }

    // Request microphone permission
    @PluginMethod
    public void requestMicrophonePermission(PluginCall call) {
        Context context = getContext();
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_RECORD_AUDIO_PERMISSION);
        } else {
            call.resolve();
        }
    }

    // Initialize speech recognition model
    @PluginMethod
    public void initModel(PluginCall call) {
        Context context = getContext();
        try {
            voskImplementation.initModel(context);
            call.resolve();
        } catch (RuntimeException e) {
            call.reject("Failed to initialize model: " + e.getMessage());
        }
    }

    // Start microphone listening
    @PluginMethod
    public void startListening(PluginCall call) {
        try {
            requestMicrophonePermission(call);

            RecognitionListener recognitionListener = new RecognitionListener() {
                @Override
                public void onPartialResult(String hypothesis) {
                    Log.d("Vosk", "Received partial result: " + hypothesis);
                    JSObject result = new JSObject();
                    result.put("partial", hypothesis);
                    notifyListeners("partialResult", result);
                }

                @Override
                public void onResult(String hypothesis) {
                    Log.d("Vosk", "Final result: " + hypothesis);
                    JSObject result = new JSObject();
                    result.put("result", hypothesis);
                    notifyListeners("onResult", result);
                }

                @Override
                public void onFinalResult(String hypothesis) {
                    Log.d("Vosk", "Final result (finalResult): " + hypothesis);
                    JSObject result = new JSObject();
                    result.put("finalResult", hypothesis);
                    notifyListeners("finalResult", result);
                }

                @Override
                public void onError(Exception exception) {
                    Log.e("Vosk", "Speech recognition error: " + exception.getMessage());
                    call.reject("Speech recognition error: " + exception.getMessage());
                }

                @Override
                public void onTimeout() {
                    Log.e("Vosk", "Speech recognition timed out.");
                    call.reject("Speech recognition timed out.");
                }
            };

            voskImplementation.startListening(recognitionListener);

        } catch (Exception e) {
            call.reject("Failed to start speech recognition: " + e.getMessage());
        }
    }

    // Stop microphone listening
    @PluginMethod
    public void stopListening(PluginCall call) {
        try {
            voskImplementation.stopListening();
            call.resolve();
        } catch (Exception e) {
            call.reject("Failed to stop speech recognition: " + e.getMessage());
        }
    }

    // Check if recognition is active
    @PluginMethod
    public void isListening(PluginCall call) {
        boolean isListening = voskImplementation.isListening();
        JSObject ret = new JSObject();
        ret.put("isListening", isListening);
        call.resolve(ret);
    }

    // Remove active listeners
    @PluginMethod
    public void removeListeners(PluginCall call) {
        try {
            if (recognitionListener != null) {
                voskImplementation.stopListening();
                recognitionListener = null; // Clear reference to avoid memory leak
                call.resolve();
            } else {
                call.reject("No active listener to remove.");
            }
        } catch (Exception e) {
            call.reject("Failed to remove listeners: " + e.getMessage());
        }
    }
}
