package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.phone.session.interceptor.TtsInterceptor2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TtsInterceptor2$TtsPlayCallback$onDiscard$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TtsInterceptor2.TtsPlayCallback this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TtsInterceptor2$TtsPlayCallback$onDiscard$1(TtsInterceptor2.TtsPlayCallback ttsPlayCallback) {
        super(0);
        this.this$0 = ttsPlayCallback;
    }

    public final void invoke() {
        Function0 c = this.this$0.b.c();
        if (c != null) {
            c.invoke();
        }
    }
}
