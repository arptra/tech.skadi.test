package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.InetAddress;
import java.util.Objects;

public final class ProxySettings {
    @Nullable
    public Credentials credentials;
    @NonNull
    public InetAddress ipAddress;
    @Nullable
    public String networkInterface = "wlan0";
    public int port;
    @NonNull
    public ProxyType type;

    public static final class Credentials {
        @NonNull
        public String password;
        @NonNull
        public String userName;

        public Credentials(@NonNull String str, @NonNull String str2) {
            this.userName = str;
            this.password = str2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Credentials)) {
                return false;
            }
            Credentials credentials = (Credentials) obj;
            return Objects.equals(this.userName, credentials.userName) && Objects.equals(this.password, credentials.password);
        }

        public int hashCode() {
            String str = this.userName;
            int i = 0;
            int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.password;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }
    }

    public enum ProxyType {
        HTTP(0),
        HTTPS(1),
        SOCKS5(2);
        
        public final int value;

        private ProxyType(int i) {
            this.value = i;
        }
    }

    public ProxySettings(@NonNull ProxyType proxyType, @NonNull InetAddress inetAddress, int i) {
        this.type = proxyType;
        this.ipAddress = inetAddress;
        this.port = i;
        this.credentials = null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProxySettings)) {
            return false;
        }
        ProxySettings proxySettings = (ProxySettings) obj;
        return Objects.equals(this.type, proxySettings.type) && Objects.equals(this.ipAddress, proxySettings.ipAddress) && Objects.equals(this.networkInterface, proxySettings.networkInterface) && this.port == proxySettings.port && Objects.equals(this.credentials, proxySettings.credentials);
    }

    public int hashCode() {
        ProxyType proxyType = this.type;
        int i = 0;
        int hashCode = (217 + (proxyType != null ? proxyType.hashCode() : 0)) * 31;
        InetAddress inetAddress = this.ipAddress;
        int hashCode2 = (hashCode + (inetAddress != null ? inetAddress.hashCode() : 0)) * 31;
        String str = this.networkInterface;
        int hashCode3 = (((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.port) * 31;
        Credentials credentials2 = this.credentials;
        if (credentials2 != null) {
            i = credentials2.hashCode();
        }
        return hashCode3 + i;
    }
}
