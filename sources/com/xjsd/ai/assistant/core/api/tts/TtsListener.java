package com.xjsd.ai.assistant.core.api.tts;

public interface TtsListener {
    void onDiscard();

    void onSpeakEnd();

    void onSpeakError(String str);

    void onSpeakStart();
}
