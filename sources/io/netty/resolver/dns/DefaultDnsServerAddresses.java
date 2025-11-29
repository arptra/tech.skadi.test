package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import java.util.List;

abstract class DefaultDnsServerAddresses extends DnsServerAddresses {
    protected final List<InetSocketAddress> addresses;
    private final String strVal;

    public DefaultDnsServerAddresses(String str, List<InetSocketAddress> list) {
        this.addresses = list;
        StringBuilder sb = new StringBuilder(str.length() + 2 + (list.size() * 16));
        sb.append(str);
        sb.append('(');
        for (InetSocketAddress append : list) {
            sb.append(append);
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(')');
        this.strVal = sb.toString();
    }

    public String toString() {
        return this.strVal;
    }
}
