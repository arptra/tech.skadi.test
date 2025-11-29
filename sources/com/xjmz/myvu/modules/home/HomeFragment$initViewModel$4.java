package com.xjmz.myvu.modules.home;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.DeviceCaptifyHelper;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "selectDevice", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$DeviceInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HomeFragment$initViewModel$4 extends Lambda implements Function1<AndroidConnectApi.DeviceInfo, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$initViewModel$4(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AndroidConnectApi.DeviceInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AndroidConnectApi.DeviceInfo deviceInfo) {
        ULog.Delegate delegate = ULog.f6446a;
        String b = deviceInfo.b();
        delegate.g("HomeFragment", "selectDevice = " + b);
        HomeFragment homeFragment = this.this$0;
        Intrinsics.checkNotNull(deviceInfo);
        homeFragment.R0(deviceInfo);
        DeviceCaptifyHelper deviceCaptifyHelper = DeviceCaptifyHelper.f7877a;
        String b2 = deviceInfo.b();
        Intrinsics.checkNotNullExpressionValue(b2, "getDeviceId(...)");
        deviceCaptifyHelper.d(b2);
        HomeFragment homeFragment2 = this.this$0;
        String d = deviceInfo.d();
        Intrinsics.checkNotNullExpressionValue(d, "getModelId(...)");
        homeFragment2.U0(d);
    }
}
