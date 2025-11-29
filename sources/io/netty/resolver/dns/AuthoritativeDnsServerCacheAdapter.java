package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

final class AuthoritativeDnsServerCacheAdapter implements AuthoritativeDnsServerCache {
    private static final DnsRecord[] EMPTY = new DnsRecord[0];
    private final DnsCache cache;

    public AuthoritativeDnsServerCacheAdapter(DnsCache dnsCache) {
        this.cache = (DnsCache) ObjectUtil.checkNotNull(dnsCache, "cache");
    }

    public void cache(String str, InetSocketAddress inetSocketAddress, long j, EventLoop eventLoop) {
        if (!inetSocketAddress.isUnresolved()) {
            this.cache.cache(str, EMPTY, inetSocketAddress.getAddress(), j, eventLoop);
        }
    }

    public void clear() {
        this.cache.clear();
    }

    public DnsServerAddressStream get(String str) {
        List<? extends DnsCacheEntry> list = this.cache.get(str, EMPTY);
        if (list == null || list.isEmpty() || ((DnsCacheEntry) list.get(0)).cause() != null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        do {
            arrayList.add(new InetSocketAddress(((DnsCacheEntry) list.get(i)).address(), 53));
            i++;
        } while (i < list.size());
        return new SequentialDnsServerAddressStream(arrayList, 0);
    }

    public boolean clear(String str) {
        return this.cache.clear(str);
    }
}
