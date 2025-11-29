package com.xjsd.ai.assistant.core.api.tts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xjsd.ai.assistant.annotation.AbilityKey;
import com.xjsd.ai.assistant.core.Ability;

@AbilityKey("tts")
public interface TtsAbility extends Ability {
    boolean cancelSpeak(@NonNull String str);

    /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    boolean isSpeaking();

    /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    String startSpeak(@NonNull TtsData ttsData, @Nullable TtsListener ttsListener);

    void startSpeakByLocal(@NonNull TtsData ttsData, @Nullable TtsListener ttsListener) {
    }

    void stopSpeak();
}
