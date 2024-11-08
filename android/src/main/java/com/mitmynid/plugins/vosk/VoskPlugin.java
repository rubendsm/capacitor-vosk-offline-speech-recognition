package com.mitmynid.plugins.vosk;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.speech.SpeechRecognizer;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.getcapacitor.JSObject;
import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;

import org.vosk.android.RecognitionListener;

@CapacitorPlugin(name = "Vosk", permissions = { @Permission(strings = { Manifest.permission.RECORD_AUDIO }, alias = "speechRecognition") })
public class VoskPlugin extends Plugin {

    private Vosk voskImplementation = new Vosk();


    @Override
    public void load() {
        super.load();
        bridge
                .getWebView()
                .post(
                        () -> {
                            Context context = getContext();
                            voskImplementation.initModel(context);
                        }
                );
    }

    // Initialize speech recognition model
    // Does not use because now the model is loaded on plugin load(). Can use it after when i wanna especify the model on ionic interface
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

    @PluginMethod
    public void available(PluginCall call) {
        boolean val = isSpeechRecognitionAvailable();
        JSObject result = new JSObject();
        result.put("available", val);
        call.resolve(result);
    }

    private boolean isSpeechRecognitionAvailable() {
        return SpeechRecognizer.isRecognitionAvailable(bridge.getContext());
    }

    // Start microphone listening
    @PluginMethod
    public void startListening(PluginCall call) {
        try {

            if (!isSpeechRecognitionAvailable()) {
                call.unavailable("Speech recognition service is not available.");
                return;

            }
            if (getPermissionState("speechRecognition") != PermissionState.GRANTED) {
                call.reject("requestPermission");
                return;
            }

            RecognitionListener recognitionListener = new RecognitionListener() {
                /*Called when partial recognition result is available.*/
                @Override
                public void onPartialResult(String hypothesis) {
                    if (hypothesis != null && !hypothesis.isEmpty()) {
                        try {
                            JSObject hypothesisObj = new JSObject(hypothesis);
                            String partialResult = hypothesisObj.getString("partial");

                            JSObject result = new JSObject();
                            result.put("matches", partialResult);

                            notifyListeners("partialResult", result);

                            Log.d("Vosk", "Partial result enviado para listener: " + result);
                        } catch (Exception e) {
                            call.reject("Failed to process partial result: " + e.getMessage());
                        }
                    }
                }

                /*Called after silence occured*/
                @Override
                public void onResult(String hypothesis) {
                    //Log.d("Vosk", "result: " + hypothesis);
                    try {
                        JSObject hypothesisObj = new JSObject(hypothesis);
                        String resultText = hypothesisObj.getString("text");

                        JSObject result = new JSObject();
                        result.put("result", resultText);

                        notifyListeners("onResult", result);
                        Log.d("Vosk", "result: " + result);
                    } catch (Exception e) {
                        //Log.e("Vosk", "Erro ao processar hypothesis: " + e.getMessage());
                        call.reject("Failed to process result: " + e.getMessage());
                    }
                }

                /*Called after stream end*/
                @Override
                public void onFinalResult(String hypothesis) {
                    try {
                        JSObject hypothesisObj = new JSObject(hypothesis);
                        String finalText = hypothesisObj.getString("text");

                        JSObject result = new JSObject();
                        result.put("final", finalText);

                        notifyListeners("finalResult", result);
                    } catch (Exception e) {
                        //Log.e("Vosk", "Erro ao processar hypothesis: " + e.getMessage());
                        call.reject("Failed to process final result: " + e.getMessage());
                    }
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

    @PluginMethod
    public void pauseListening(PluginCall call) {
        try {
            voskImplementation.pause(true);
            call.resolve();
        } catch (Exception e) {
            call.reject("Failed to pause speech recognition: " + e.getMessage());
        }
    }

    @PluginMethod
    public void resumeListening(PluginCall call) {
        try {
            voskImplementation.pause(false);
            call.resolve();
        } catch (Exception e) {
            call.reject("Failed to resume speech recognition: " + e.getMessage());
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
}
