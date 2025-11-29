package com.xjsd.ai.assistant.asr;

import com.xjsd.ai.assistant.annotation.AbilityKey;
import com.xjsd.ai.assistant.core.Ability;
import java.util.List;
import java.util.concurrent.ExecutionException;

@AbilityKey("asr")
public interface AsrAbility extends Ability {
    void feedData(byte[] bArr, int i);

    void flush();

    int getErrorCode();

    /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    boolean isReady();

    /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    void setOnAsrEventListener(AsrEventListener asrEventListener);

    boolean startRecognize(String str, List<String> list) throws ExecutionException, InterruptedException;

    void stopRecognize();
}
