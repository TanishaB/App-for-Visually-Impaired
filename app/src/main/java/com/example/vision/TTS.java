package com.example.vision;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

public class TTS{

    TextToSpeech textToSpeech = null;

    public void initializeTTS(String text, Context context) {

        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                    convertTTS(text, textToSpeech);
                }else{
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void convertTTS(String text, TextToSpeech textToSpeech){
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,null);
    }
}