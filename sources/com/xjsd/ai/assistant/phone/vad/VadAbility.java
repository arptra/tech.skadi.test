package com.xjsd.ai.assistant.phone.vad;

import com.xjsd.ai.assistant.annotation.AbilityKey;
import com.xjsd.ai.assistant.core.Ability;

@AbilityKey("vad")
public interface VadAbility extends Ability {
    void destroy();

    void feedData(byte[] bArr);

    /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    void setOneShotFlag();

    void setVadEventListener(VadEventListener vadEventListener);

    void start();

    void stop();
}
