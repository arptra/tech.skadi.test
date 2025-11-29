package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;

final class SequentialDnsServerAddressStream implements DnsServerAddressStream {
    private final List<? extends InetSocketAddress> addresses;
    private int i;

    public SequentialDnsServerAddressStream(List<? extends InetSocketAddress> list, int i2) {
        this.addresses = list;
        this.i = i2;
    }

    public InetSocketAddress next() {
        int i2 = this.i;
        InetSocketAddress inetSocketAddress = (InetSocketAddress) this.addresses.get(i2);
        int i3 = i2 + 1;
        if (i3 < this.addresses.size()) {
            this.i = i3;
        } else {
            this.i = 0;
        }
        return inetSocketAddress;
    }

    public int size() {
        return this.addresses.size();
    }

    public String toString() {
        return toString("sequential", this.i, this.addresses);
    }

    public static String toString(String str, int i2, Collection<? extends InetSocketAddress> collection) {
        StringBuilder sb = new StringBuilder(str.length() + 2 + (collection.size() * 16));
        sb.append(str);
        sb.append("(index: ");
        sb.append(i2);
        sb.append(", addrs: (");
        for (InetSocketAddress append : collection) {
            sb.append(append);
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("))");
        return sb.toString();
    }

    public SequentialDnsServerAddressStream duplicate() {
        return new SequentialDnsServerAddressStream(this.addresses, this.i);
    }
}
