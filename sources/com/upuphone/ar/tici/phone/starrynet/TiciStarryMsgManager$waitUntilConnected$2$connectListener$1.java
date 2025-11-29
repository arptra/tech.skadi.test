package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager$waitUntilConnected$2$connectListener$1", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "p0", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciStarryMsgManager$waitUntilConnected$2$connectListener$1 extends DeviceConnectionListener {
    final /* synthetic */ CancellableContinuation<Unit> $cont;

    public TiciStarryMsgManager$waitUntilConnected$2$connectListener$1(CancellableContinuation<? super Unit> cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
        if (starryNetDevice != null && StarryNetDeviceExt.isXrDevice(starryNetDevice) && this.$cont.isActive()) {
            CancellableContinuation<Unit> cancellableContinuation = this.$cont;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(Unit.INSTANCE));
        }
    }

    public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
    }
}
