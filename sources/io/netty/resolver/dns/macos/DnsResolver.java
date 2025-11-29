package io.netty.resolver.dns.macos;

import io.netty.channel.unix.NativeInetAddress;
import java.net.InetSocketAddress;

final class DnsResolver {
    private final String domain;
    private final InetSocketAddress[] nameservers;
    private final String options;
    private final int port;
    private final int searchOrder;
    private final String[] searches;
    private final int timeout;

    public DnsResolver(String str, byte[][] bArr, int i, String[] strArr, String str2, int i2, int i3) {
        this.domain = str;
        if (bArr == null) {
            this.nameservers = new InetSocketAddress[0];
        } else {
            this.nameservers = new InetSocketAddress[bArr.length];
            for (int i4 = 0; i4 < bArr.length; i4++) {
                byte[] bArr2 = bArr[i4];
                this.nameservers[i4] = NativeInetAddress.address(bArr2, 0, bArr2.length);
            }
        }
        this.port = i;
        this.searches = strArr;
        this.options = str2;
        this.timeout = i2;
        this.searchOrder = i3;
    }

    public String domain() {
        return this.domain;
    }

    public InetSocketAddress[] nameservers() {
        return this.nameservers;
    }

    public String options() {
        return this.options;
    }

    public int port() {
        return this.port;
    }

    public int searchOrder() {
        return this.searchOrder;
    }

    public String[] searches() {
        return this.searches;
    }

    public int timeout() {
        return this.timeout;
    }
}
