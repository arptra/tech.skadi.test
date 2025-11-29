package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import java.net.InetSocketAddress;

public final class NoopAuthoritativeDnsServerCache implements AuthoritativeDnsServerCache {
    public static final NoopAuthoritativeDnsServerCache INSTANCE = new NoopAuthoritativeDnsServerCache();

    private NoopAuthoritativeDnsServerCache() {
    }

    public void cache(String str, InetSocketAddress inetSocketAddress, long j, EventLoop eventLoop) {
    }

    public void clear() {
    }

    public DnsServerAddressStream get(String str) {
        return null;
    }

    public boolean clear(String str) {
        return false;
    }
}
