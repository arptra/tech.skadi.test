package com.upuphone.ar.transcribe.statemachine.handler;

import com.upuphone.ar.transcribe.statemachine.listener.UiStateListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/transcribe/statemachine/handler/UiStateHandler;", "", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lcom/upuphone/ar/transcribe/statemachine/listener/UiStateListener;", "uiStateListener", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/upuphone/ar/transcribe/statemachine/listener/UiStateListener;)V", "", "state", "expCode", "", "b", "(II)V", "a", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/upuphone/ar/transcribe/statemachine/listener/UiStateListener;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class UiStateHandler {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineScope f6164a;
    public final UiStateListener b;

    public UiStateHandler(CoroutineScope coroutineScope, UiStateListener uiStateListener) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(uiStateListener, "uiStateListener");
        this.f6164a = coroutineScope;
        this.b = uiStateListener;
    }

    public final void b(int i, int i2) {
        Job unused = BuildersKt__Builders_commonKt.d(this.f6164a, (CoroutineContext) null, (CoroutineStart) null, new UiStateHandler$notifyStateChanged$1(this, i, i2, (Continuation<? super UiStateHandler$notifyStateChanged$1>) null), 3, (Object) null);
    }
}
