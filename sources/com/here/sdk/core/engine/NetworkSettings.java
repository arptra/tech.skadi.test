package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.NetworkEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class NetworkSettings {
    @Nullable
    public CertificateSettings certificates = null;
    @NonNull
    public List<NetworkEndpoint> domainNameSystemServers = new ArrayList();
    @Nullable
    public ProxySettings proxySettings = null;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkSettings)) {
            return false;
        }
        NetworkSettings networkSettings = (NetworkSettings) obj;
        return Objects.equals(this.proxySettings, networkSettings.proxySettings) && Objects.equals(this.domainNameSystemServers, networkSettings.domainNameSystemServers) && Objects.equals(this.certificates, networkSettings.certificates);
    }

    public int hashCode() {
        ProxySettings proxySettings2 = this.proxySettings;
        int i = 0;
        int hashCode = (217 + (proxySettings2 != null ? proxySettings2.hashCode() : 0)) * 31;
        List<NetworkEndpoint> list = this.domainNameSystemServers;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        CertificateSettings certificateSettings = this.certificates;
        if (certificateSettings != null) {
            i = certificateSettings.hashCode();
        }
        return hashCode2 + i;
    }
}
