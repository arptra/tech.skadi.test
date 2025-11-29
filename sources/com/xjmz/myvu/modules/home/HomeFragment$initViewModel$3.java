package com.xjmz.myvu.modules.home;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.entity.NetDevice;
import com.upuphone.xr.sapp.entity.NetDeviceKt;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import com.xjmz.myvu.common.ConnectVoidResult;
import com.xjmz.myvu.ext.ConnectExtKt;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "connectDevice", "Lcom/upuphone/xr/sapp/entity/NetDevice;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HomeFragment$initViewModel$3 extends Lambda implements Function1<NetDevice, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$initViewModel$3(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NetDevice) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NetDevice netDevice) {
        AndroidConnectApi.StateEnum stateEnum;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HomeFragment", "connectDevice = " + netDevice);
        if (NetDeviceKt.isConnected(netDevice.getState())) {
            this.this$0.a1().x();
            SuperMessageManger.Companion companion = SuperMessageManger.m;
            companion.a().l();
            companion.a().B();
        }
        this.this$0.n0().a();
        if (NetDeviceKt.isConnected(netDevice.getState())) {
            stateEnum = AndroidConnectApi.StateEnum.CONNECT_SUCC;
        } else {
            PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (!permissionAndStateCheckUtils.b(requireContext)) {
                stateEnum = AndroidConnectApi.StateEnum.SCAN_NEED_BLUETOOTH;
            } else {
                stateEnum = AndroidConnectApi.StateEnum.SCANING;
            }
            SearchGlassHandler H0 = this.this$0.n0();
            StarryNetDevice starryNetDevice = new StarryNetDevice();
            starryNetDevice.setModelId(netDevice.getModelID());
            starryNetDevice.setDeviceId(netDevice.getMIdentifier());
            starryNetDevice.setDeviceName(netDevice.getMDeviceName());
            H0.b(starryNetDevice);
        }
        AndroidConnectApi.FlutterConnectApi k0 = this.this$0.k0();
        Intrinsics.checkNotNull(netDevice);
        k0.i(ConnectExtKt.m(netDevice, stateEnum), new ConnectVoidResult());
    }
}
