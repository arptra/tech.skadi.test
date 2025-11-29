package com.upuphone.ai.ttsengine.flavor.service.connect;

import android.os.Handler;
import android.os.Message;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/ai/ttsengine/flavor/service/connect/Communicator$deviceConnectionListener$1", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Communicator$deviceConnectionListener$1 extends DeviceConnectionListener {
    final /* synthetic */ Communicator this$0;

    public Communicator$deviceConnectionListener$1(Communicator communicator) {
        this.this$0 = communicator;
    }

    public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
        Message obtainMessage;
        AILOG c = this.this$0.f5565a;
        c.m("onDeviceConnected " + starryNetDevice, new Object[0]);
        if (starryNetDevice != null && StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
            this.this$0.f5565a.m("entry master device", new Object[0]);
            DeviceUtils deviceUtils = DeviceUtils.f5567a;
            String modelId = starryNetDevice != null ? starryNetDevice.getModelId() : null;
            if (modelId == null) {
                modelId = "";
            }
            deviceUtils.b(modelId);
            this.this$0.h = true;
            Handler d = this.this$0.g;
            if (d != null && (obtainMessage = d.obtainMessage(1, Boolean.TRUE)) != null) {
                obtainMessage.sendToTarget();
            }
        }
    }

    public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
        Message obtainMessage;
        this.this$0.f5565a.m("onDeviceDisconnected", new Object[0]);
        if (starryNetDevice != null && StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
            this.this$0.f5565a.m("entry master device2", new Object[0]);
            DeviceUtils.f5567a.b("");
            this.this$0.h = false;
            Handler d = this.this$0.g;
            if (d != null && (obtainMessage = d.obtainMessage(1, Boolean.FALSE)) != null) {
                obtainMessage.sendToTarget();
            }
        }
    }
}
