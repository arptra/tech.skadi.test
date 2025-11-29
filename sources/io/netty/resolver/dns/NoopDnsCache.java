package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;

public final class NoopDnsCache implements DnsCache {
    public static final NoopDnsCache INSTANCE = new NoopDnsCache();

    public static final class NoopDnsCacheEntry implements DnsCacheEntry {
        private final InetAddress address;

        public NoopDnsCacheEntry(InetAddress inetAddress) {
            this.address = inetAddress;
        }

        public InetAddress address() {
            return this.address;
        }

        public Throwable cause() {
            return null;
        }

        public String toString() {
            return this.address.toString();
        }
    }

    private NoopDnsCache() {
    }

    public DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, Throwable th, EventLoop eventLoop) {
        return null;
    }

    public void clear() {
    }

    public List<? extends DnsCacheEntry> get(String str, DnsRecord[] dnsRecordArr) {
        return Collections.emptyList();
    }

    public String toString() {
        return NoopDnsCache.class.getSimpleName();
    }

    public DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, InetAddress inetAddress, long j, EventLoop eventLoop) {
        return new NoopDnsCacheEntry(inetAddress);
    }

    public boolean clear(String str) {
        return false;
    }
}
