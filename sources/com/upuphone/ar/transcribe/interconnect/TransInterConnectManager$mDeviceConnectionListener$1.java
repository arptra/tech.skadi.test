package com.upuphone.ar.transcribe.interconnect;

import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.interconnect.entity.InterConnectDeviceExtKt;
import com.upuphone.ar.transcribe.interconnect.listener.OnDeviceConnectedListener;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/ar/transcribe/interconnect/TransInterConnectManager$mDeviceConnectionListener$1", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransInterConnectManager$mDeviceConnectionListener$1 extends DeviceConnectionListener {
    final /* synthetic */ TransInterConnectManager this$0;

    public TransInterConnectManager$mDeviceConnectionListener$1(TransInterConnectManager transInterConnectManager) {
        this.this$0 = transInterConnectManager;
    }

    public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
        LogExt.g("互联互通连接成功:: " + starryNetDevice, "TranscribeConnectManager");
        if (starryNetDevice != null) {
            TransInterConnectManager transInterConnectManager = this.this$0;
            if (StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
                LogExt.g("connected 眼镜和手机设备连接成功=" + starryNetDevice, "TranscribeConnectManager");
                transInterConnectManager.n = true;
                OnDeviceConnectedListener e = transInterConnectManager.l;
                if (e != null) {
                    e.a(InterConnectDeviceExtKt.append(starryNetDevice));
                }
            }
        }
    }

    public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
        LogExt.g("互联互通断开连接:: " + starryNetDevice, "TranscribeConnectManager");
        if (starryNetDevice != null) {
            TransInterConnectManager transInterConnectManager = this.this$0;
            if (StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
                LogExt.g("disConnected 眼镜和手机设备断开连接=" + starryNetDevice, "TranscribeConnectManager");
                transInterConnectManager.n = false;
                OnDeviceConnectedListener e = transInterConnectManager.l;
                if (e != null) {
                    e.b(InterConnectDeviceExtKt.append(starryNetDevice));
                }
            }
        }
    }
}
