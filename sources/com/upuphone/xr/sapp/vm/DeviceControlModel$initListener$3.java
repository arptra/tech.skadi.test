package com.upuphone.xr.sapp.vm;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.music.phone.helper.MusicPhoneUniversalHelper;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.datatrack.ConnectEventReporter;
import com.upuphone.xr.sapp.entity.DeviceState;
import com.upuphone.xr.sapp.monitor.GlassWearStateMonitor;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.utils.DynamicOperateUtil;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/vm/DeviceControlModel$initListener$3", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceControlModel$initListener$3 extends DeviceConnectionListener {
    final /* synthetic */ DeviceControlModel this$0;

    public DeviceControlModel$initListener$3(DeviceControlModel deviceControlModel) {
        this.this$0 = deviceControlModel;
    }

    public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
        MainApplication.Companion companion;
        String str;
        StarryNetDevice starryNetDevice2 = starryNetDevice;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("DeviceControlModel", "onDeviceConnected device = " + starryNetDevice2);
        if (!XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsGlass(starryNetDevice2 != null ? starryNetDevice.getTerminalType() : 0)) {
            delegate.c("DeviceControlModel", "onDeviceConnected is not glass");
            return;
        }
        String deviceName = starryNetDevice2 != null ? starryNetDevice.getDeviceName() : null;
        Byte valueOf = starryNetDevice2 != null ? Byte.valueOf(starryNetDevice.getTerminalType()) : null;
        delegate.a("DeviceControlModel", "onDeviceConnected device is: " + deviceName + " and terminalType is: " + valueOf);
        if (starryNetDevice2 != null && starryNetDevice.getTerminalType() == 2) {
            MainApplication.Companion companion2 = MainApplication.k;
            companion2.m(false);
            DataStoreUtils.Companion companion3 = DataStoreUtils.e;
            companion3.a().o("sp_device_connect_history", starryNetDevice.getDeviceId());
            companion3.a().o("sp_current_bond_device_id", starryNetDevice.getDeviceId());
            if (this.this$0.c.getValue() == null) {
                DeviceState deviceState = r1;
                companion = companion2;
                str = "DeviceControlModel";
                DeviceState deviceState2 = new DeviceState(2, starryNetDevice, 0, 0, 0, false, 0, 0, 248, (DefaultConstructorMarker) null);
                DeviceState deviceState3 = deviceState;
                deviceState3.setValidTime(System.currentTimeMillis());
                this.this$0.c.setValue(deviceState3);
            } else {
                companion = companion2;
                str = "DeviceControlModel";
            }
            CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
            if (cacheAbility != null) {
                cacheAbility.getPersistValue("IotDeviceId");
            }
            ControlUtils controlUtils = ControlUtils.f7858a;
            String packageName = ((MainApplication) this.this$0.c()).getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            controlUtils.h(packageName);
            ConnectEventReporter.f(ConnectEventReporter.b, 0, (String) null, 2, (Object) null);
            this.this$0.B0(starryNetDevice.getDeviceId());
            SuperMessageManger.Companion companion4 = SuperMessageManger.m;
            companion4.a().E();
            String packageName2 = ((MainApplication) this.this$0.c()).getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName2, "getPackageName(...)");
            controlUtils.c(packageName2);
            controlUtils.l(((MainApplication) this.this$0.c()).getPackageName());
            String packageName3 = ((MainApplication) this.this$0.c()).getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName3, "getPackageName(...)");
            controlUtils.z(packageName3);
            delegate.o(str, "initMusicForPhone when onDeviceConnected ");
            MusicPhoneUniversalHelper musicPhoneUniversalHelper = MusicPhoneUniversalHelper.f5631a;
            MainApplication f = companion.f();
            Boolean bool = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
            musicPhoneUniversalHelper.a(f, bool.booleanValue());
            StarryNetDevice starryNetDevice3 = starryNetDevice;
            FastRecordManager.Companion.getInstance().setConnectDevice(starryNetDevice3);
            DynamicOperateUtil dynamicOperateUtil = DynamicOperateUtil.f7880a;
            String modelId = starryNetDevice.getModelId();
            if (modelId == null) {
                modelId = "";
            }
            dynamicOperateUtil.H(modelId);
            this.this$0.D(starryNetDevice3, true);
            this.this$0.B(starryNetDevice.getDeviceId());
            controlUtils.j(((MainApplication) this.this$0.c()).getPackageName());
            companion4.a().m0();
            this.this$0.e0();
            companion4.a().i0();
            DeviceControlModel deviceControlModel = this.this$0;
            String deviceId = starryNetDevice.getDeviceId();
            Intrinsics.checkNotNullExpressionValue(deviceId, "getDeviceId(...)");
            deviceControlModel.F(deviceId);
            StaticMethodUtilsKt.V(companion.f());
            DataTrackUtil.f7875a.c();
            TranslationApp.initConnectedSuccess();
            MzAccountManager.c.d();
            GenericWindowManger.c.a().j(110);
            companion4.a().h0();
            String packageName4 = ((MainApplication) this.this$0.c()).getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName4, "getPackageName(...)");
            controlUtils.w0(packageName4);
            String packageName5 = ((MainApplication) this.this$0.c()).getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName5, "getPackageName(...)");
            controlUtils.x0(packageName5);
        }
    }

    public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("DeviceControlModel", "onDeviceDisconnected device = " + starryNetDevice);
        if (!XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsGlass(starryNetDevice != null ? starryNetDevice.getTerminalType() : 0)) {
            delegate.c("DeviceControlModel", "onDeviceDisconnected is not glass");
            return;
        }
        Byte b = null;
        String deviceName = starryNetDevice != null ? starryNetDevice.getDeviceName() : null;
        if (starryNetDevice != null) {
            b = Byte.valueOf(starryNetDevice.getTerminalType());
        }
        delegate.a("DeviceControlModel", "onDeviceDisconnected device is: " + deviceName + " and terminalType is: " + b);
        if (starryNetDevice != null && starryNetDevice.getTerminalType() == 2 && !this.this$0.u) {
            MainApplication.k.m(false);
            ConnectEventReporter.b.g();
            this.this$0.D(starryNetDevice, false);
            SuperViewModel q = this.this$0.r;
            if (q != null) {
                q.g(false);
            }
            SuperViewModel q2 = this.this$0.r;
            if (q2 != null) {
                q2.j();
            }
            GlassWearStateMonitor.f7735a.b(false);
            this.this$0.c0(starryNetDevice.getDeviceId());
            DynamicOperateUtil.f7880a.w();
        }
    }
}
