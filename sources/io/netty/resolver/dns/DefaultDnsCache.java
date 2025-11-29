package io.netty.resolver.dns;

import com.meizu.common.widget.MzContactsContract;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;

public class DefaultDnsCache implements DnsCache {
    private final int maxTtl;
    private final int minTtl;
    private final int negativeTtl;
    private final Cache<DefaultDnsCacheEntry> resolveCache;

    public DefaultDnsCache() {
        this(0, Cache.MAX_SUPPORTED_TTL_SECS, 0);
    }

    private static String appendDot(String str) {
        if (StringUtil.endsWith(str, '.')) {
            return str;
        }
        return str + '.';
    }

    private static boolean emptyAdditionals(DnsRecord[] dnsRecordArr) {
        return dnsRecordArr == null || dnsRecordArr.length == 0;
    }

    public DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, InetAddress inetAddress, long j, EventLoop eventLoop) {
        ObjectUtil.checkNotNull(str, "hostname");
        ObjectUtil.checkNotNull(inetAddress, MzContactsContract.MzContactColumns.ADDRESS);
        ObjectUtil.checkNotNull(eventLoop, "loop");
        DefaultDnsCacheEntry defaultDnsCacheEntry = new DefaultDnsCacheEntry(str, inetAddress);
        if (this.maxTtl != 0 && emptyAdditionals(dnsRecordArr)) {
            this.resolveCache.cache(appendDot(str), defaultDnsCacheEntry, Math.max(this.minTtl, (int) Math.min((long) this.maxTtl, j)), eventLoop);
        }
        return defaultDnsCacheEntry;
    }

    public void clear() {
        this.resolveCache.clear();
    }

    public List<? extends DnsCacheEntry> get(String str, DnsRecord[] dnsRecordArr) {
        ObjectUtil.checkNotNull(str, "hostname");
        return !emptyAdditionals(dnsRecordArr) ? Collections.emptyList() : this.resolveCache.get(appendDot(str));
    }

    public int maxTtl() {
        return this.maxTtl;
    }

    public int minTtl() {
        return this.minTtl;
    }

    public int negativeTtl() {
        return this.negativeTtl;
    }

    public String toString() {
        return "DefaultDnsCache(minTtl=" + this.minTtl + ", maxTtl=" + this.maxTtl + ", negativeTtl=" + this.negativeTtl + ", cached resolved hostname=" + this.resolveCache.size() + ')';
    }

    public DefaultDnsCache(int i, int i2, int i3) {
        this.resolveCache = new Cache<DefaultDnsCacheEntry>() {
            public boolean equals(DefaultDnsCacheEntry defaultDnsCacheEntry, DefaultDnsCacheEntry defaultDnsCacheEntry2) {
                if (defaultDnsCacheEntry.address() != null) {
                    return defaultDnsCacheEntry.address().equals(defaultDnsCacheEntry2.address());
                }
                if (defaultDnsCacheEntry2.address() != null) {
                    return false;
                }
                return defaultDnsCacheEntry.cause().equals(defaultDnsCacheEntry2.cause());
            }

            public boolean shouldReplaceAll(DefaultDnsCacheEntry defaultDnsCacheEntry) {
                return defaultDnsCacheEntry.cause() != null;
            }
        };
        int i4 = Cache.MAX_SUPPORTED_TTL_SECS;
        this.minTtl = Math.min(i4, ObjectUtil.checkPositiveOrZero(i, "minTtl"));
        this.maxTtl = Math.min(i4, ObjectUtil.checkPositiveOrZero(i2, "maxTtl"));
        if (i <= i2) {
            this.negativeTtl = ObjectUtil.checkPositiveOrZero(i3, "negativeTtl");
            return;
        }
        throw new IllegalArgumentException("minTtl: " + i + ", maxTtl: " + i2 + " (expected: 0 <= minTtl <= maxTtl)");
    }

    public boolean clear(String str) {
        ObjectUtil.checkNotNull(str, "hostname");
        return this.resolveCache.clear(appendDot(str));
    }

    public static final class DefaultDnsCacheEntry implements DnsCacheEntry {
        private final InetAddress address;
        private final Throwable cause;
        private final String hostname;

        public DefaultDnsCacheEntry(String str, InetAddress inetAddress) {
            this.hostname = str;
            this.address = inetAddress;
            this.cause = null;
        }

        public InetAddress address() {
            return this.address;
        }

        public Throwable cause() {
            return this.cause;
        }

        public String hostname() {
            return this.hostname;
        }

        public String toString() {
            if (this.cause == null) {
                return this.address.toString();
            }
            return this.hostname + '/' + this.cause;
        }

        public DefaultDnsCacheEntry(String str, Throwable th) {
            this.hostname = str;
            this.cause = th;
            this.address = null;
        }
    }

    public DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, Throwable th, EventLoop eventLoop) {
        ObjectUtil.checkNotNull(str, "hostname");
        ObjectUtil.checkNotNull(th, "cause");
        ObjectUtil.checkNotNull(eventLoop, "loop");
        DefaultDnsCacheEntry defaultDnsCacheEntry = new DefaultDnsCacheEntry(str, th);
        if (this.negativeTtl != 0 && emptyAdditionals(dnsRecordArr)) {
            this.resolveCache.cache(appendDot(str), defaultDnsCacheEntry, this.negativeTtl, eventLoop);
        }
        return defaultDnsCacheEntry;
    }
}
