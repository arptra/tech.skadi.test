package com.xjsd.ai.assistant.asr.engine;

import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/xjsd/ai/assistant/asr/engine/AsrWsClient;", "", "Lcom/xjsd/ai/assistant/asr/engine/AsrWsClientListener;", "listener", "", "c", "(Lcom/xjsd/ai/assistant/asr/engine/AsrWsClientListener;)V", "", "isOpen", "()Z", "", "connect", "()I", "", "msg", "a", "(Ljava/lang/String;)V", "", "data", "b", "([B)V", "close", "()V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface AsrWsClient {
    void a(String str);

    void b(byte[] bArr);

    void c(AsrWsClientListener asrWsClientListener);

    void close();

    int connect();

    boolean isOpen();
}
