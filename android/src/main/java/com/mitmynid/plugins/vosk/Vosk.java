package com.mitmynid.plugins.vosk;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.vosk.LibVosk;
import org.vosk.Model;
import org.vosk.Recognizer;
import org.vosk.android.SpeechService;
import org.vosk.android.RecognitionListener;
import org.vosk.android.StorageService;

import java.io.IOException;
import java.io.InputStream;

public class Vosk implements RecognitionListener {

    private Model model;
    private Recognizer recognizer;
    private SpeechService speechService;
    private boolean isListening = false;
    private StringBuilder partialResults = new StringBuilder();
    private String finalResult = "";

    // Método para inicializar o modelo
    public void initModel(Context context) {
        try {
            AssetManager assetManager = context.getAssets();
            StorageService.unpack(context, "vosk-model-small-pt", "model",
                    (unpackedModel) -> {
                        this.model = unpackedModel;
                        Log.d("Vosk", "Modelo carregado com sucesso!");
                    },
                    (exception) -> {
                        throw new RuntimeException("Falha ao descompactar o modelo: " + exception.getMessage());
                    });
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inicializar o modelo: " + e.getMessage());
        }
    }

    // Inicia o reconhecimento de voz
    public void startListening(RecognitionListener listener) throws IOException {
        if (model == null) {
            throw new RuntimeException("Modelo não carregado.");
        }

        recognizer = new Recognizer(model, 16000.0f);
        speechService = new SpeechService(recognizer, 16000.0f);
        speechService.startListening(listener);
        isListening = true;
    }

    public void stopListening() {
        if (speechService != null) {
            speechService.stop();
            isListening = false;
        }
    }

    // Métodos para os listeners do reconhecimento de fala
    @Override
    public void onPartialResult(String hypothesis) {
        if (hypothesis != null && !hypothesis.isEmpty()) {
            partialResults.append(hypothesis).append(" ");
        }
    }

    @Override
    public void onResult(String hypothesis) {
        finalResult = hypothesis;
    }

    @Override
    public void onFinalResult(String hypothesis) {
        finalResult = hypothesis;
    }

    @Override
    public void onError(Exception exception) {
        Log.e("Vosk", "Erro no reconhecimento de fala: " + exception.getMessage());
    }

    @Override
    public void onTimeout() {
        Log.e("Vosk", "Reconhecimento de fala expirou.");
    }

    // Getter para o estado de escuta
    public boolean isListening() {
        return isListening;
    }

    public String getPartialResults() {
        return partialResults.toString();
    }

    public String getFinalResult() {
        return finalResult;
    }



}
