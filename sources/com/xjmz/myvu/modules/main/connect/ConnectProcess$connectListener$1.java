package com.xjmz.myvu.modules.main.connect;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/xjmz/myvu/modules/main/connect/ConnectProcess$connectListener$1", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "", "onDeviceConnected", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)V", "onDeviceDisconnected", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ConnectProcess$connectListener$1 extends DeviceConnectionListener {
    final /* synthetic */ ConnectProcess this$0;

    public ConnectProcess$connectListener$1(ConnectProcess connectProcess) {
        this.this$0 = connectProcess;
    }

    public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("ConnectProcess", "onDeviceConnected-> " + starryNetDevice);
        this.this$0.i();
        this.this$0.j();
        Function1 e = this.this$0.c;
        if (e != null) {
            e.invoke(starryNetDevice);
        }
    }

    public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
        ULog.f6446a.g("ConnectProcess", "onDeviceDisconnected-> ");
        this.this$0.i();
        this.this$0.o();
    }
}
