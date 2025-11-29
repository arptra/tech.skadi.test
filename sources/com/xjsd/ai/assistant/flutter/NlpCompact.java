package com.xjsd.ai.assistant.flutter;

import com.xjsd.ai.assistant.nlu.bean.NluRequest;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\u0003R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/xjsd/ai/assistant/flutter/NlpCompact;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/nlu/bean/NluRequest;", "request", "", "b", "(Lcom/xjsd/ai/assistant/nlu/bean/NluRequest;)V", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cleanContextRef", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NlpCompact {

    /* renamed from: a  reason: collision with root package name */
    public static final NlpCompact f8481a = new NlpCompact();
    public static final AtomicBoolean b = new AtomicBoolean(true);

    public static final void a() {
        b.set(true);
    }

    public static final void b(NluRequest nluRequest) {
        Intrinsics.checkNotNullParameter(nluRequest, "request");
        AtomicBoolean atomicBoolean = b;
        if (atomicBoolean.get()) {
            nluRequest.getContext().get(0).getHeader().setNamespace("context");
            nluRequest.getContext().get(0).getHeader().setName("clean_context");
            atomicBoolean.set(false);
            return;
        }
        nluRequest.getContext().get(0).getHeader().setNamespace("env");
        nluRequest.getContext().get(0).getHeader().setName("assistant");
    }
}
