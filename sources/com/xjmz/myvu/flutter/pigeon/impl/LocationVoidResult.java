package com.xjmz.myvu.flutter.pigeon.impl;

import com.xjmz.myvu.flutter.pigeon.AndroidLocationApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/LocationVoidResult;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidLocationApi$VoidResult;", "()V", "error", "", "", "success", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LocationVoidResult implements AndroidLocationApi.VoidResult {
    public void error(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
    }

    public void success() {
    }
}
