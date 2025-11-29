package com.upuphone.xr.sapp.glass;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.P2pAcquireCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/glass/GlassHelper$enableP2pConnection$2$1$1", "Lcom/upuphone/xr/interconnect/listener/P2pAcquireCallback;", "onFail", "", "code", "", "onSuccess", "onTimeout", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassHelper$enableP2pConnection$2$1$1 extends P2pAcquireCallback {
    final /* synthetic */ CancellableContinuation<Boolean> $cont;

    public GlassHelper$enableP2pConnection$2$1$1(CancellableContinuation<? super Boolean> cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    public void onFail(int i) {
        ULog.f6446a.a("GlassHelper", "enableP2pConnection-tryAcquireP2p-onFail");
        if (this.$cont.isActive()) {
            CancellableContinuation<Boolean> cancellableContinuation = this.$cont;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(Boolean.FALSE));
        }
    }

    public void onSuccess() {
        ULog.f6446a.a("GlassHelper", "enableP2pConnection-tryAcquireP2p-onSuccess");
        if (this.$cont.isActive()) {
            CancellableContinuation<Boolean> cancellableContinuation = this.$cont;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(Boolean.TRUE));
        }
    }

    public void onTimeout() {
        ULog.f6446a.a("GlassHelper", "enableP2pConnection-tryAcquireP2p-onTimeout");
        if (this.$cont.isActive()) {
            CancellableContinuation<Boolean> cancellableContinuation = this.$cont;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(Boolean.FALSE));
        }
    }
}
