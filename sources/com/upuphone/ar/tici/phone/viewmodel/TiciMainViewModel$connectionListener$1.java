package com.upuphone.ar.tici.phone.viewmodel;

import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/ar/tici/phone/viewmodel/TiciMainViewModel$connectionListener$1", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciMainViewModel$connectionListener$1 extends DeviceConnectionListener {
    final /* synthetic */ TiciMainViewModel this$0;

    public TiciMainViewModel$connectionListener$1(TiciMainViewModel ticiMainViewModel) {
        this.this$0 = ticiMainViewModel;
    }

    public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
        CommonExtKt.e("onDeviceConnected-> " + starryNetDevice, "TiciMainViewModel");
        if (starryNetDevice != null && StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
            this.this$0.i.postValue(Boolean.TRUE);
            this.this$0.l(500);
        }
    }

    public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
        CommonExtKt.e("onDeviceDisconnected-> " + starryNetDevice, "TiciMainViewModel");
        if (starryNetDevice != null && StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
            this.this$0.i.postValue(Boolean.FALSE);
        }
    }
}
