package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.api.info.DeviceInfoOperator;
import com.upuphone.xr.interconnect.api.info.InfoMapOperator;
import com.upuphone.xr.interconnect.api.info.PeerInfoOperator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/interconnect/api/InfoOperator;", "", "device", "Lcom/upuphone/xr/interconnect/api/info/InfoMapOperator;", "Lcom/upuphone/xr/interconnect/api/info/DeviceInfoOperator;", "getDevice", "()Lcom/upuphone/xr/interconnect/api/info/InfoMapOperator;", "peer", "Lcom/upuphone/xr/interconnect/api/info/PeerInfoOperator;", "getPeer", "()Lcom/upuphone/xr/interconnect/api/info/PeerInfoOperator;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface InfoOperator {
    @NotNull
    InfoMapOperator<DeviceInfoOperator> getDevice();

    @NotNull
    PeerInfoOperator getPeer();
}
