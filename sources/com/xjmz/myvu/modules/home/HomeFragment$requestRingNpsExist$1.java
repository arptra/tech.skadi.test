package com.xjmz.myvu.modules.home;

import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.star.core.log.ULog;
import com.xjmz.myvu.flutter.pigeon.AndroidBindingDeviceApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/xjmz/myvu/modules/home/HomeFragment$requestRingNpsExist$1", "Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$Result;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$Ring2DeviceInfo;", "result", "", "a", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$Ring2DeviceInfo;)V", "", "error", "(Ljava/lang/Throwable;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class HomeFragment$requestRingNpsExist$1 implements AndroidBindingDeviceApi.Result<AndroidBindingDeviceApi.Ring2DeviceInfo> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f8364a;

    public HomeFragment$requestRingNpsExist$1(HomeFragment homeFragment) {
        this.f8364a = homeFragment;
    }

    /* renamed from: a */
    public void success(AndroidBindingDeviceApi.Ring2DeviceInfo ring2DeviceInfo) {
        Intrinsics.checkNotNullParameter(ring2DeviceInfo, "result");
        ULog.Delegate delegate = ULog.f6446a;
        String c = ring2DeviceInfo.c();
        String b = ring2DeviceInfo.b();
        String d = ring2DeviceInfo.d();
        delegate.a("HomeFragment", "requestRingNpsExist->success result.sn:" + c + " result.model=" + b + " result.version=" + d);
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this.f8364a), Dispatchers.b(), (CoroutineStart) null, new HomeFragment$requestRingNpsExist$1$success$1(ring2DeviceInfo, (Continuation<? super HomeFragment$requestRingNpsExist$1$success$1>) null), 2, (Object) null);
    }

    public void error(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("HomeFragment", "requestRingNpsExist->error error:" + th);
    }
}
