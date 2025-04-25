package com.example.apodimage;

public class TranslateBody {
    String targetLanguageCode;
    String [] texts;
    String folderId;
    public TranslateBody(String targetLanguageCode, String text, String folderId){
        this.folderId = folderId;
        this.targetLanguageCode = targetLanguageCode;
        texts = new String[1];
        texts[0] = text;
    }
}
