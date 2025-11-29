package com.upuphone.xr.sapp.air;

import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/upuphone/xr/sapp/air/AirHelper$waitForGlassUpdateAppReady$2$1$listener$1", "Ljava/lang/Runnable;", "run", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AirHelper$waitForGlassUpdateAppReady$2$1$listener$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f6631a;

    public AirHelper$waitForGlassUpdateAppReady$2$1$listener$1(CancellableContinuation cancellableContinuation) {
        this.f6631a = cancellableContinuation;
    }

    public void run() {
        AirHelper.b.L(this);
        if (this.f6631a.isActive()) {
            CancellableContinuation cancellableContinuation = this.f6631a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(Boolean.TRUE));
        }
    }
}
