package com.xjmz.myvu.common;

import com.upuphone.star.core.log.ULog;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/xjmz/myvu/common/ConnectVoidResult;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$VoidResult;", "()V", "error", "", "", "success", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConnectVoidResult implements AndroidConnectApi.VoidResult {
    public void error(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        ULog.Delegate delegate = ULog.f6446a;
        String message = th.getMessage();
        delegate.a("ConnectVoidResult", "error:" + message);
    }

    public void success() {
        ULog.f6446a.a("ConnectVoidResult", "notifyConnectState api success");
    }
}
