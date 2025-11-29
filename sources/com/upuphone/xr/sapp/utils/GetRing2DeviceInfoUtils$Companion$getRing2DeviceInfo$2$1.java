package com.upuphone.xr.sapp.utils;

import com.upuphone.star.core.log.ULog;
import com.xjmz.myvu.flutter.pigeon.AndroidBindingDeviceApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/upuphone/xr/sapp/utils/GetRing2DeviceInfoUtils$Companion$getRing2DeviceInfo$2$1", "Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$Result;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$Ring2DeviceInfo;", "result", "", "a", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$Ring2DeviceInfo;)V", "", "error", "(Ljava/lang/Throwable;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GetRing2DeviceInfoUtils$Companion$getRing2DeviceInfo$2$1 implements AndroidBindingDeviceApi.Result<AndroidBindingDeviceApi.Ring2DeviceInfo> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation f7888a;

    public GetRing2DeviceInfoUtils$Companion$getRing2DeviceInfo$2$1(CancellableContinuation cancellableContinuation) {
        this.f7888a = cancellableContinuation;
    }

    /* renamed from: a */
    public void success(AndroidBindingDeviceApi.Ring2DeviceInfo ring2DeviceInfo) {
        Intrinsics.checkNotNullParameter(ring2DeviceInfo, "result");
        ULog.Delegate delegate = ULog.f6446a;
        String b = GetRing2DeviceInfoUtils.b;
        String c = ring2DeviceInfo.c();
        String b2 = ring2DeviceInfo.b();
        String d = ring2DeviceInfo.d();
        delegate.a(b, "getRing2DeviceInfo->success result.sn:" + c + " result.model=" + b2 + " result.version=" + d);
        if (this.f7888a.isActive()) {
            this.f7888a.resumeWith(Result.m20constructorimpl(ring2DeviceInfo));
        }
    }

    public void error(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        ULog.Delegate delegate = ULog.f6446a;
        String b = GetRing2DeviceInfoUtils.b;
        delegate.a(b, "getRing2DeviceInfo->error error:" + th);
        if (this.f7888a.isActive()) {
            CancellableContinuation cancellableContinuation = this.f7888a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(th)));
        }
    }
}
