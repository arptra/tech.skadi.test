package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.phone.cmd.AudioDataTransCmdHandler;
import com.xjsd.ai.assistant.phone.session.Session;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00158\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/xjsd/ai/assistant/phone/session/interceptor/AudioDataInterceptor;", "Lcom/xjsd/ai/assistant/phone/session/interceptor/AbsInterceptor;", "Lcom/xjsd/ai/assistant/phone/session/Session;", "session", "Lcom/xjsd/ai/assistant/phone/cmd/AudioDataTransCmdHandler;", "audioHandler", "<init>", "(Lcom/xjsd/ai/assistant/phone/session/Session;Lcom/xjsd/ai/assistant/phone/cmd/AudioDataTransCmdHandler;)V", "", "f", "()V", "h", "i", "g", "d", "Lcom/xjsd/ai/assistant/phone/cmd/AudioDataTransCmdHandler;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "e", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_audioFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/Flow;", "m", "()Lkotlinx/coroutines/flow/Flow;", "audioFlow", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AudioDataInterceptor extends AbsInterceptor {
    public final AudioDataTransCmdHandler d;
    public final MutableSharedFlow e;
    public final Flow f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AudioDataInterceptor(Session session, AudioDataTransCmdHandler audioDataTransCmdHandler) {
        super(session);
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(audioDataTransCmdHandler, "audioHandler");
        this.d = audioDataTransCmdHandler;
        MutableSharedFlow b = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.e = b;
        this.f = b;
    }

    public void f() {
        j(c(), new AudioDataInterceptor$onCreate$1(FlowKt.f(new AudioDataInterceptor$onCreate$flow$1(this, (Continuation<? super AudioDataInterceptor$onCreate$flow$1>) null)), this, (Continuation<? super AudioDataInterceptor$onCreate$1>) null));
    }

    public void g() {
    }

    public void h() {
    }

    public void i() {
        this.d.b((AudioDataTransCmdHandler.OnDataListener) null);
    }

    public final Flow m() {
        return this.f;
    }
}
