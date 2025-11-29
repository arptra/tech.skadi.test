package com.here.sdk.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.InetAddress;
import java.util.Objects;

public final class NetworkEndpoint {
    @NonNull
    public InetAddress address;
    @Nullable
    public Integer port;

    public NetworkEndpoint(@NonNull InetAddress inetAddress, @Nullable Integer num) {
        this.address = inetAddress;
        this.port = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkEndpoint)) {
            return false;
        }
        NetworkEndpoint networkEndpoint = (NetworkEndpoint) obj;
        return Objects.equals(this.address, networkEndpoint.address) && Objects.equals(this.port, networkEndpoint.port);
    }

    public int hashCode() {
        InetAddress inetAddress = this.address;
        int i = 0;
        int hashCode = (217 + (inetAddress != null ? inetAddress.hashCode() : 0)) * 31;
        Integer num = this.port;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public NetworkEndpoint(@NonNull InetAddress inetAddress) {
        this.address = inetAddress;
        this.port = null;
    }
}
