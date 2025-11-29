package com.xjsd.ai.assistant.cloud;

import com.xjsd.ai.assistant.annotation.AbilityKey;
import com.xjsd.ai.assistant.core.Ability;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData;
import java.util.concurrent.ExecutionException;

@AbilityKey("cloud")
public interface CloudAbility extends Ability {
    void feed(EndToEndServiceData... endToEndServiceDataArr);

    void feedData(byte[] bArr);

    void flush();

    int getErrorCode();

    /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    boolean launch(InitCloudParams initCloudParams) throws ExecutionException, InterruptedException;

    /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    void setCloudEventListener(CloudEventListener cloudEventListener);

    void stop();
}
