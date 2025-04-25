package com.example.apodimage;

public class TranslateResponse {
    class Translate{
        String text;
        String detectedLanguageCode;
    }
    Translate [] translations;
}
