package com.xjmz.myvu.modules.home;

import com.upuphone.star.core.log.ULog;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/xjmz/myvu/modules/home/HomeFragment$sendHistory$2$1", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$VoidResult;", "error", "", "", "success", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HomeFragment$sendHistory$2$1 implements AndroidConnectApi.VoidResult {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f8366a;

    public HomeFragment$sendHistory$2$1(CancellableContinuation cancellableContinuation) {
        this.f8366a = cancellableContinuation;
    }

    public void error(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        ULog.Delegate delegate = ULog.f6446a;
        String message = th.getMessage();
        delegate.g("HomeFragment", "notifyHistoryDevices() error" + message);
        CancellableContinuation cancellableContinuation = this.f8366a;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(Boolean.FALSE));
    }

    public void success() {
        ULog.f6446a.g("HomeFragment", "notifyHistoryDevices() success");
        CancellableContinuation cancellableContinuation = this.f8366a;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(Boolean.TRUE));
    }
}
