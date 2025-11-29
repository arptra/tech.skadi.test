package com.xjmz.myvu.modules.home;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.GlassBatteryInfo;
import com.upuphone.xr.sapp.entity.NetDevice;
import com.xjmz.myvu.common.ConnectVoidResult;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "glassBattery", "Lcom/upuphone/xr/sapp/entity/GlassBatteryInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HomeFragment$initViewModel$6 extends Lambda implements Function1<GlassBatteryInfo, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$initViewModel$6(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GlassBatteryInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GlassBatteryInfo glassBatteryInfo) {
        String str;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HomeFragment", "glassBattery = " + glassBatteryInfo);
        AndroidConnectApi.FlutterConnectApi k0 = this.this$0.k0();
        AndroidConnectApi.BatteryInfo.Builder d = new AndroidConnectApi.BatteryInfo.Builder().b(Long.valueOf((long) glassBatteryInfo.getBattery())).d(Boolean.valueOf(glassBatteryInfo.isCharging()));
        NetDevice netDevice = (NetDevice) this.this$0.m0().L().getValue();
        if (netDevice == null || (str = netDevice.getMIdentifier()) == null) {
            str = "";
        }
        k0.h(d.c(str).a(), new ConnectVoidResult());
    }
}
