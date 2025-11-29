package com.upuphone.xr.sapp.vm;

import android.content.Context;
import android.content.Intent;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.common.IDeviceBondStateListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.datatrack.ConnectEventReporter;
import com.upuphone.xr.sapp.entity.DeviceState;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DeviceCaptifyHelper;
import com.upuphone.xr.sapp.vu.utils.GlassDataStoreHelper;
import com.xjmz.myvu.ext.ConnectExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/vm/DeviceControlModel$initListener$2", "Lcom/upuphone/xr/interconnect/common/IDeviceBondStateListener$Stub;", "onDeviceBondStateChange", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "newState", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceControlModel$initListener$2 extends IDeviceBondStateListener.Stub {
    final /* synthetic */ DeviceControlModel this$0;

    public DeviceControlModel$initListener$2(DeviceControlModel deviceControlModel) {
        this.this$0 = deviceControlModel;
    }

    public void onDeviceBondStateChange(@Nullable StarryNetDevice starryNetDevice, int i) {
        String deviceId;
        String modelId;
        String modelId2;
        StarryNetDevice starryNetDevice2 = starryNetDevice;
        int i2 = i;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("DeviceControlModel", "onDeviceBondStateChange device = " + starryNetDevice2);
        if (!XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsGlass(starryNetDevice2 != null ? starryNetDevice.getTerminalType() : 0)) {
            delegate.c("DeviceControlModel", "onDeviceBondStateChange is not glass");
            return;
        }
        delegate.a("DeviceControlModel", "onDeviceBondStateChange newState is: " + i2);
        if (i2 != 1) {
            DeviceState deviceState = r1;
            DeviceState deviceState2 = new DeviceState(i, starryNetDevice, 0, 0, 0, false, 0, 0, 248, (DefaultConstructorMarker) null);
            DeviceState deviceState3 = deviceState;
            deviceState3.setValidTime(System.currentTimeMillis());
            this.this$0.c.setValue(deviceState3);
            String str = null;
            if (i2 == 0) {
                ControlUtils controlUtils = ControlUtils.f7858a;
                Boolean bool = BuildConfig.f6575a;
                Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
                controlUtils.i0(bool.booleanValue() ? "MYVU AR" : "MYVU");
                DataStoreUtils.Companion companion = DataStoreUtils.e;
                companion.a().o("sp_device_connect_history", "null");
                ConnectEventReporter.l(ConnectEventReporter.b, false, 1, (Object) null);
                companion.a().o("tici_need_hide", Boolean.FALSE);
                Intent intent = new Intent("clear_notification");
                intent.putExtra("close_by_permission", true);
                ((MainApplication) this.this$0.c()).sendBroadcast(intent);
                companion.a().o("device_info", "");
                if (!(starryNetDevice == null || (modelId = starryNetDevice.getModelId()) == null)) {
                    GlassDataStoreHelper.f8091a.h(ConnectExtKt.o(modelId));
                }
                if (starryNetDevice != null && (deviceId = starryNetDevice.getDeviceId()) != null) {
                    DeviceCaptifyHelper.f7877a.a(deviceId);
                }
            } else if (i2 == 2) {
                this.this$0.o0();
                ConnectEventReporter.j(ConnectEventReporter.b, 0, (String) null, 2, (Object) null);
                DataStoreUtils.Companion companion2 = DataStoreUtils.e;
                if (Intrinsics.areEqual((Object) (String) DataStoreUtils.i(companion2.a(), "sp_device_connect_history", "null", (Context) null, 4, (Object) null), (Object) "null")) {
                    this.this$0.W();
                }
                DataStoreUtils a2 = companion2.a();
                if (starryNetDevice != null) {
                    str = starryNetDevice.getDeviceId();
                }
                a2.o("sp_device_connect_history", str);
                if (starryNetDevice != null && (modelId2 = starryNetDevice.getModelId()) != null) {
                    GlassDataStoreHelper.f8091a.k(ConnectExtKt.o(modelId2));
                }
            }
        }
    }
}
