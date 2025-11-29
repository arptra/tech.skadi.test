package com.xjsd.ai.assistant.asr.engine;

import com.upuphone.starrynet.payload.PayloadConstant;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/xjsd/ai/assistant/asr/engine/AsrWsClientProxy;", "Lcom/xjsd/ai/assistant/asr/engine/AsrWsClient;", "Ljava/net/URI;", "serverUri", "<init>", "(Ljava/net/URI;)V", "Lcom/xjsd/ai/assistant/asr/engine/AsrWsClientListener;", "listener", "", "c", "(Lcom/xjsd/ai/assistant/asr/engine/AsrWsClientListener;)V", "", "isOpen", "()Z", "", "connect", "()I", "", "msg", "a", "(Ljava/lang/String;)V", "", "data", "b", "([B)V", "close", "()V", "Lcom/xjsd/ai/assistant/asr/engine/AsrWsClientWrapper;", "Lcom/xjsd/ai/assistant/asr/engine/AsrWsClientWrapper;", "mClient", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AsrWsClientProxy implements AsrWsClient {

    /* renamed from: a  reason: collision with root package name */
    public final AsrWsClientWrapper f8387a;

    public AsrWsClientProxy(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "serverUri");
        this.f8387a = new AsrWsClientWrapper(uri);
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        this.f8387a.h0(str);
    }

    public void b(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        this.f8387a.i0(bArr);
    }

    public void c(AsrWsClientListener asrWsClientListener) {
        this.f8387a.m0(asrWsClientListener);
    }

    public void close() {
        if (this.f8387a.V()) {
            this.f8387a.M();
        }
    }

    public int connect() {
        return this.f8387a.l0();
    }

    public boolean isOpen() {
        return this.f8387a.V();
    }
}
