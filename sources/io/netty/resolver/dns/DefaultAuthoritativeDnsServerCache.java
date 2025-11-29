package io.netty.resolver.dns;

import com.meizu.common.widget.MzContactsContract;
import io.netty.channel.EventLoop;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultAuthoritativeDnsServerCache implements AuthoritativeDnsServerCache {
    /* access modifiers changed from: private */
    public final Comparator<InetSocketAddress> comparator;
    private final int maxTtl;
    private final int minTtl;
    private final Cache<InetSocketAddress> resolveCache;

    public DefaultAuthoritativeDnsServerCache() {
        this(0, Cache.MAX_SUPPORTED_TTL_SECS, (Comparator<InetSocketAddress>) null);
    }

    public void cache(String str, InetSocketAddress inetSocketAddress, long j, EventLoop eventLoop) {
        ObjectUtil.checkNotNull(str, "hostname");
        ObjectUtil.checkNotNull(inetSocketAddress, MzContactsContract.MzContactColumns.ADDRESS);
        ObjectUtil.checkNotNull(eventLoop, "loop");
        if (PlatformDependent.javaVersion() < 7 || inetSocketAddress.getHostString() != null) {
            this.resolveCache.cache(str, inetSocketAddress, Math.max(this.minTtl, (int) Math.min((long) this.maxTtl, j)), eventLoop);
        }
    }

    public void clear() {
        this.resolveCache.clear();
    }

    public DnsServerAddressStream get(String str) {
        ObjectUtil.checkNotNull(str, "hostname");
        List<? extends InetSocketAddress> list = this.resolveCache.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return new SequentialDnsServerAddressStream(list, 0);
    }

    public String toString() {
        return "DefaultAuthoritativeDnsServerCache(minTtl=" + this.minTtl + ", maxTtl=" + this.maxTtl + ", cached nameservers=" + this.resolveCache.size() + ')';
    }

    public DefaultAuthoritativeDnsServerCache(int i, int i2, Comparator<InetSocketAddress> comparator2) {
        this.resolveCache = new Cache<InetSocketAddress>() {
            public boolean shouldReplaceAll(InetSocketAddress inetSocketAddress) {
                return false;
            }

            public void sortEntries(String str, List<InetSocketAddress> list) {
                if (DefaultAuthoritativeDnsServerCache.this.comparator != null) {
                    Collections.sort(list, DefaultAuthoritativeDnsServerCache.this.comparator);
                }
            }

            public boolean equals(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
                if (PlatformDependent.javaVersion() >= 7) {
                    return inetSocketAddress.getHostString().equalsIgnoreCase(inetSocketAddress2.getHostString());
                }
                return inetSocketAddress.getHostName().equalsIgnoreCase(inetSocketAddress2.getHostName());
            }
        };
        int i3 = Cache.MAX_SUPPORTED_TTL_SECS;
        this.minTtl = Math.min(i3, ObjectUtil.checkPositiveOrZero(i, "minTtl"));
        this.maxTtl = Math.min(i3, ObjectUtil.checkPositive(i2, "maxTtl"));
        if (i <= i2) {
            this.comparator = comparator2;
            return;
        }
        throw new IllegalArgumentException("minTtl: " + i + ", maxTtl: " + i2 + " (expected: 0 <= minTtl <= maxTtl)");
    }

    public boolean clear(String str) {
        return this.resolveCache.clear((String) ObjectUtil.checkNotNull(str, "hostname"));
    }
}
