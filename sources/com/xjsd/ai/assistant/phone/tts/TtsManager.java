package com.xjsd.ai.assistant.phone.tts;

import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.phone.session.Session;
import com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt;
import com.xjsd.ai.assistant.phone.tts.PhoneTtsPlayBuilder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00072\u00020\u0001:\u0001$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010#\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/TtsManager;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/core/api/tts/TtsData;", "data", "", "f", "(Lcom/xjsd/ai/assistant/core/api/tts/TtsData;)V", "Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;", "tts", "c", "(Lcom/xjsd/ai/assistant/phone/tts/PhoneTtsPlayBuilder$PhoneTts;)V", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "a", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_ttsFlow", "b", "_phoneTtsFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/Flow;", "e", "()Lkotlinx/coroutines/flow/Flow;", "setTtsFlow", "(Lkotlinx/coroutines/flow/Flow;)V", "ttsFlow", "d", "setPhoneTtsFlow", "phoneTtsFlow", "Lcom/xjsd/ai/assistant/phone/session/Session;", "Lcom/xjsd/ai/assistant/phone/session/Session;", "getSession", "()Lcom/xjsd/ai/assistant/phone/session/Session;", "g", "(Lcom/xjsd/ai/assistant/phone/session/Session;)V", "session", "Companion", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TtsManager {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);
    public static final TtsManager g = new TtsManager();

    /* renamed from: a  reason: collision with root package name */
    public final MutableSharedFlow f8608a;
    public final MutableSharedFlow b;
    public Flow c;
    public Flow d;
    public Session e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/xjsd/ai/assistant/phone/tts/TtsManager$Companion;", "", "()V", "INSTANCE", "Lcom/xjsd/ai/assistant/phone/tts/TtsManager;", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public TtsManager() {
        MutableSharedFlow b2 = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.f8608a = b2;
        MutableSharedFlow b3 = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.b = b3;
        this.c = b2;
        this.d = b3;
    }

    public final void c(PhoneTtsPlayBuilder.PhoneTts phoneTts) {
        Intrinsics.checkNotNullParameter(phoneTts, "tts");
        Session session = this.e;
        if (session != null) {
            Job unused = BuildersKt__Builders_commonKt.d(SeesionExtensionsKt.a(session), (CoroutineContext) null, (CoroutineStart) null, new TtsManager$enqueueTtsReq$1$1(session, this, phoneTts, (Continuation<? super TtsManager$enqueueTtsReq$1$1>) null), 3, (Object) null);
        }
    }

    public final Flow d() {
        return this.d;
    }

    public final Flow e() {
        return this.c;
    }

    public final void f(TtsData ttsData) {
        Intrinsics.checkNotNullParameter(ttsData, "data");
        Session session = this.e;
        if (session != null) {
            Job unused = BuildersKt__Builders_commonKt.d(SeesionExtensionsKt.a(session), (CoroutineContext) null, (CoroutineStart) null, new TtsManager$playTts$1$1(session, this, ttsData, (Continuation<? super TtsManager$playTts$1$1>) null), 3, (Object) null);
        }
    }

    public final void g(Session session) {
        this.e = session;
    }
}
