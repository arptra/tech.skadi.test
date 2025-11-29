package com.upuphone.ar.transcribe.statemachine.handler;

import com.upuphone.ar.transcribe.statemachine.listener.TranscribeResultListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/transcribe/statemachine/handler/TranscribeResultHandler;", "", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lcom/upuphone/ar/transcribe/statemachine/listener/TranscribeResultListener;", "transResultListener", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/upuphone/ar/transcribe/statemachine/listener/TranscribeResultListener;)V", "obj", "", "c", "(Ljava/lang/Object;)V", "b", "d", "a", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/upuphone/ar/transcribe/statemachine/listener/TranscribeResultListener;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranscribeResultHandler {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineScope f6163a;
    public final TranscribeResultListener b;

    public TranscribeResultHandler(CoroutineScope coroutineScope, TranscribeResultListener transcribeResultListener) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(transcribeResultListener, "transResultListener");
        this.f6163a = coroutineScope;
        this.b = transcribeResultListener;
    }

    public final void b(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Job unused = BuildersKt__Builders_commonKt.d(this.f6163a, (CoroutineContext) null, (CoroutineStart) null, new TranscribeResultHandler$notifyProximalTranslateResult$1(this, obj, (Continuation<? super TranscribeResultHandler$notifyProximalTranslateResult$1>) null), 3, (Object) null);
    }

    public final void c(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Job unused = BuildersKt__Builders_commonKt.d(this.f6163a, (CoroutineContext) null, (CoroutineStart) null, new TranscribeResultHandler$notifyRemoteTranslateResult$1(this, obj, (Continuation<? super TranscribeResultHandler$notifyRemoteTranslateResult$1>) null), 3, (Object) null);
    }

    public final void d(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Job unused = BuildersKt__Builders_commonKt.d(this.f6163a, (CoroutineContext) null, (CoroutineStart) null, new TranscribeResultHandler$notifyTranslateServerRunningState$1(this, obj, (Continuation<? super TranscribeResultHandler$notifyTranslateServerRunningState$1>) null), 3, (Object) null);
    }
}
