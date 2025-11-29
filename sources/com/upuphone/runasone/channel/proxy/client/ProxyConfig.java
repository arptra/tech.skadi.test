package com.upuphone.runasone.channel.proxy.client;

import com.meizu.net.pedometerprovider.manager.PedoManager;

public class ProxyConfig {
    private static final ProxyConfig instance = new ProxyConfig();
    private int MTU;

    public static ProxyConfig getInstance() {
        return instance;
    }

    public IPAddress getDefaultLocalIP() {
        return new IPAddress("10.8.0.2", 32);
    }

    public int getMTU() {
        int i = this.MTU;
        return (i <= 1400 || i > 20000) ? PedoManager.HOUR_MAX_STEP : i;
    }

    public void setMtu(int i) {
        this.MTU = i;
    }

    public static class IPAddress {
        public final String Address;
        public final int PrefixLength;

        public IPAddress(String str, int i) {
            this.Address = str;
            this.PrefixLength = i;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof IPAddress)) {
                return false;
            }
            return toString().equals(obj.toString());
        }

        public String toString() {
            return String.format("%s/%d", new Object[]{this.Address, Integer.valueOf(this.PrefixLength)});
        }

        public IPAddress(String str) {
            String[] split = str.split("/");
            String str2 = split[0];
            int parseInt = split.length > 1 ? Integer.parseInt(split[1]) : 32;
            this.Address = str2;
            this.PrefixLength = parseInt;
        }
    }
}
