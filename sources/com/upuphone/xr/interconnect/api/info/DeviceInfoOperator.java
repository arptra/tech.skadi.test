package com.upuphone.xr.interconnect.api.info;

import com.upuphone.xr.interconnect.api.connection.ConnectionLevel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/interconnect/api/info/DeviceInfoOperator;", "", "connectionLevel", "Lcom/upuphone/xr/interconnect/api/info/InfoEndpoint;", "Lcom/upuphone/xr/interconnect/api/connection/ConnectionLevel;", "getConnectionLevel", "()Lcom/upuphone/xr/interconnect/api/info/InfoEndpoint;", "ipv4Address", "", "getIpv4Address", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DeviceInfoOperator {
    @NotNull
    InfoEndpoint<ConnectionLevel> getConnectionLevel();

    @NotNull
    InfoEndpoint<String> getIpv4Address();
}
