package com.upuphone.xr.sapp.vm;

import android.content.Context;
import com.honey.account.z8.f;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceDiscoverListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.entity.DeviceState;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"com/upuphone/xr/sapp/vm/DeviceControlModel$initListener$1", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceDiscoverListener;", "onDeviceFound", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceLose", "onError", "code", "", "onFastFound", "type", "beaconId", "onTimeout", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceControlModel$initListener$1 implements StarryNetDeviceDiscoverListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlModel f7997a;

    public DeviceControlModel$initListener$1(DeviceControlModel deviceControlModel) {
        this.f7997a = deviceControlModel;
    }

    public static final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "$deviceId");
        InterconnectManager.getInstance().getStarryNetDeviceManager().connectDevice(str);
    }

    public void onDeviceFound(StarryNetDevice starryNetDevice) {
        if (!XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsGlass(starryNetDevice != null ? starryNetDevice.getTerminalType() : 0)) {
            ULog.f6446a.c("DeviceControlModel", "onFastFound is not glass");
            return;
        }
        ULog.Delegate delegate = ULog.f6446a;
        Boolean bool = BuildConfig.b;
        StringBuilder sb = new StringBuilder();
        sb.append("onDeviceFound::device is: ");
        sb.append(starryNetDevice);
        sb.append(", device type is mars = ");
        sb.append(!bool.booleanValue());
        delegate.a("DeviceControlModel", sb.toString());
        if (starryNetDevice != null) {
            DeviceControlModel deviceControlModel = this.f7997a;
            if (starryNetDevice.getTerminalType() == 2) {
                String modelId = starryNetDevice.getModelId();
                Intrinsics.checkNotNullExpressionValue(modelId, "getModelId(...)");
                if (ModelIdExtKt.d(modelId) && !bool.booleanValue()) {
                    delegate.a("DeviceControlModel", "glass is ar pro,show error tip,FLY_ME_ROM_UPDATE_TYPE ");
                    deviceControlModel.O().setValue(new DeviceState(-202020, starryNetDevice, 0, System.currentTimeMillis(), 127, false, 0, 0, 224, (DefaultConstructorMarker) null));
                }
            }
        }
    }

    public void onDeviceLose(StarryNetDevice starryNetDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DeviceControlModel", "onDeviceLose::device is: " + starryNetDevice);
    }

    public void onError(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DeviceControlModel", "onError::" + i);
    }

    public void onFastFound(StarryNetDevice starryNetDevice, int i, int i2) {
        StarryNetDevice starryNetDevice2 = starryNetDevice;
        super.onFastFound(starryNetDevice, i, i2);
        if (!XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsGlass(starryNetDevice2 != null ? starryNetDevice.getTerminalType() : 0)) {
            ULog.f6446a.c("DeviceControlModel", "onFastFound is not glass");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ULog.Delegate delegate = ULog.f6446a;
        String str = null;
        String modelId = starryNetDevice2 != null ? starryNetDevice.getModelId() : null;
        StringBuilder sb = new StringBuilder();
        sb.append("onFastFound::device  is: ");
        sb.append(starryNetDevice2);
        sb.append(",modelID = ");
        sb.append(modelId);
        sb.append(" and type is: ");
        sb.append(i);
        sb.append(" currentTimeMillis is: ");
        sb.append(currentTimeMillis);
        sb.append(" with beaconId: ");
        int i3 = i2;
        sb.append(i3);
        delegate.a("DeviceControlModel", sb.toString());
        DeviceState deviceState = r1;
        DeviceState deviceState2 = new DeviceState(i, starryNetDevice, 0, currentTimeMillis, i3, false, 0, 0, 224, (DefaultConstructorMarker) null);
        this.f7997a.O().setValue(deviceState);
        String str2 = (String) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_current_bond_device_id", "", (Context) null, 4, (Object) null);
        if (str2.length() > 0) {
            if (starryNetDevice2 != null) {
                str = starryNetDevice.getDeviceId();
            }
            if (Intrinsics.areEqual((Object) str2, (Object) str)) {
                if (this.f7997a.u) {
                    this.f7997a.u = false;
                    this.f7997a.s.postDelayed(new f(str2), AssistantConstants.TIMEOUT_VAD_MUTE);
                }
            }
        }
    }

    public void onTimeout() {
        ULog.f6446a.a("DeviceControlModel", "discover onTimeout");
    }
}
