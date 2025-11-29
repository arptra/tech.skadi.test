package io.netty.resolver.dns;

import java.net.InetSocketAddress;

public interface DnsServerAddressStream {
    DnsServerAddressStream duplicate();

    InetSocketAddress next();

    int size();
}
