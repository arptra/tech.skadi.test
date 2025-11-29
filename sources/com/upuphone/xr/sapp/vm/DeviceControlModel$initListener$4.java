package com.upuphone.xr.sapp.vm;

import android.content.Context;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.xr.interconnect.api.StarryNetDeviceStateChangeListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.datatrack.ConnectEventReporter;
import com.upuphone.xr.sapp.guide.model.ConnectResult;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ)\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00048\u0002XD¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/upuphone/xr/sapp/vm/DeviceControlModel$initListener$4", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceStateChangeListener;", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "", "newState", "", "onBondStateChanged", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;I)V", "", "pairingKey", "onReceivePairingKey", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;Ljava/lang/String;)V", "onConnectStateChanged", "type", "Lcom/upuphone/runasone/device/StarryDevice;", "starryDevice", "code", "onConnectFail", "(ILcom/upuphone/runasone/device/StarryDevice;I)V", "a", "I", "ERROR_CODE_PAIR_FAILED", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DeviceControlModel$initListener$4 implements StarryNetDeviceStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final int f7998a = StErrorCode.CONNECT_STRATEGY_BR_EDR_CONNECT_FAIL;
    public final /* synthetic */ DeviceControlModel b;

    public DeviceControlModel$initListener$4(DeviceControlModel deviceControlModel) {
        this.b = deviceControlModel;
    }

    public void onBondStateChanged(StarryNetDevice starryNetDevice, int i) {
    }

    public void onConnectFail(int i, StarryDevice starryDevice, int i2) {
        String str;
        super.onConnectFail(i, starryDevice, i2);
        if (!XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsGlass(starryDevice != null ? starryDevice.getTerminalType() : 0)) {
            ULog.f6446a.c("DeviceControlModel", "onConnectFail is not glass");
            return;
        }
        if (starryDevice != null) {
            str = starryDevice.getId();
            Intrinsics.checkNotNullExpressionValue(str, "getId(...)");
        } else {
            str = "";
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DeviceControlModel", "onConnectFail::type is: " + i + " and code is: " + i2);
        if (112305 == i2) {
            delegate.c("DeviceControlModel", "CONNECT_CORE_SPP_CLIENT_FAIL_BR_NOT_BOND not command");
            return;
        }
        if (((CharSequence) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_device_connect_history", "", (Context) null, 4, (Object) null)).length() <= 0 || MainApplication.k.i() || i2 == this.f7998a) {
            delegate.a("DeviceControlModel", "onConnectFail::send match failed");
            ConnectEventReporter.b.h(1, String.valueOf(i2));
        } else {
            delegate.a("DeviceControlModel", "onConnectFail::send reconnect failed");
            ConnectEventReporter.b.e(1, String.valueOf(i2));
        }
        if (i == 1 || i == 8) {
            this.b.N().postValue(new ConnectResult(false, str, this.b.K(i2)));
        }
    }

    public void onConnectStateChanged(StarryNetDevice starryNetDevice, int i) {
    }

    public void onReceivePairingKey(StarryNetDevice starryNetDevice, String str) {
    }
}
