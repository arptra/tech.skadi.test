package io.netty.resolver.dns;

import io.netty.util.collection.IntObjectMap;
import io.netty.util.internal.PlatformDependent;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

final class DnsQueryContextManager {
    final Map<InetSocketAddress, IntObjectMap<DnsQueryContext>> map = new HashMap();

    private IntObjectMap<DnsQueryContext> getContextMap(InetSocketAddress inetSocketAddress) {
        IntObjectMap<DnsQueryContext> intObjectMap;
        synchronized (this.map) {
            intObjectMap = this.map.get(inetSocketAddress);
        }
        return intObjectMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0079, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.netty.util.collection.IntObjectMap<io.netty.resolver.dns.DnsQueryContext> getOrCreateContextMap(java.net.InetSocketAddress r6) {
        /*
            r5 = this;
            java.util.Map<java.net.InetSocketAddress, io.netty.util.collection.IntObjectMap<io.netty.resolver.dns.DnsQueryContext>> r0 = r5.map
            monitor-enter(r0)
            java.util.Map<java.net.InetSocketAddress, io.netty.util.collection.IntObjectMap<io.netty.resolver.dns.DnsQueryContext>> r1 = r5.map     // Catch:{ all -> 0x000f }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x000f }
            io.netty.util.collection.IntObjectMap r1 = (io.netty.util.collection.IntObjectMap) r1     // Catch:{ all -> 0x000f }
            if (r1 == 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r1
        L_0x000f:
            r5 = move-exception
            goto L_0x007a
        L_0x0011:
            io.netty.util.collection.IntObjectHashMap r1 = new io.netty.util.collection.IntObjectHashMap     // Catch:{ all -> 0x000f }
            r1.<init>()     // Catch:{ all -> 0x000f }
            java.net.InetAddress r2 = r6.getAddress()     // Catch:{ all -> 0x000f }
            int r3 = r6.getPort()     // Catch:{ all -> 0x000f }
            java.util.Map<java.net.InetSocketAddress, io.netty.util.collection.IntObjectMap<io.netty.resolver.dns.DnsQueryContext>> r4 = r5.map     // Catch:{ all -> 0x000f }
            r4.put(r6, r1)     // Catch:{ all -> 0x000f }
            boolean r6 = r2 instanceof java.net.Inet4Address     // Catch:{ all -> 0x000f }
            if (r6 == 0) goto L_0x004b
            java.net.Inet4Address r2 = (java.net.Inet4Address) r2     // Catch:{ all -> 0x000f }
            boolean r6 = r2.isLoopbackAddress()     // Catch:{ all -> 0x000f }
            if (r6 == 0) goto L_0x003c
            java.util.Map<java.net.InetSocketAddress, io.netty.util.collection.IntObjectMap<io.netty.resolver.dns.DnsQueryContext>> r5 = r5.map     // Catch:{ all -> 0x000f }
            java.net.InetSocketAddress r6 = new java.net.InetSocketAddress     // Catch:{ all -> 0x000f }
            java.net.Inet6Address r2 = io.netty.util.NetUtil.LOCALHOST6     // Catch:{ all -> 0x000f }
            r6.<init>(r2, r3)     // Catch:{ all -> 0x000f }
            r5.put(r6, r1)     // Catch:{ all -> 0x000f }
            goto L_0x0078
        L_0x003c:
            java.util.Map<java.net.InetSocketAddress, io.netty.util.collection.IntObjectMap<io.netty.resolver.dns.DnsQueryContext>> r5 = r5.map     // Catch:{ all -> 0x000f }
            java.net.InetSocketAddress r6 = new java.net.InetSocketAddress     // Catch:{ all -> 0x000f }
            java.net.Inet6Address r2 = toCompactAddress(r2)     // Catch:{ all -> 0x000f }
            r6.<init>(r2, r3)     // Catch:{ all -> 0x000f }
            r5.put(r6, r1)     // Catch:{ all -> 0x000f }
            goto L_0x0078
        L_0x004b:
            boolean r6 = r2 instanceof java.net.Inet6Address     // Catch:{ all -> 0x000f }
            if (r6 == 0) goto L_0x0078
            java.net.Inet6Address r2 = (java.net.Inet6Address) r2     // Catch:{ all -> 0x000f }
            boolean r6 = r2.isLoopbackAddress()     // Catch:{ all -> 0x000f }
            if (r6 == 0) goto L_0x0064
            java.util.Map<java.net.InetSocketAddress, io.netty.util.collection.IntObjectMap<io.netty.resolver.dns.DnsQueryContext>> r5 = r5.map     // Catch:{ all -> 0x000f }
            java.net.InetSocketAddress r6 = new java.net.InetSocketAddress     // Catch:{ all -> 0x000f }
            java.net.Inet4Address r2 = io.netty.util.NetUtil.LOCALHOST4     // Catch:{ all -> 0x000f }
            r6.<init>(r2, r3)     // Catch:{ all -> 0x000f }
            r5.put(r6, r1)     // Catch:{ all -> 0x000f }
            goto L_0x0078
        L_0x0064:
            boolean r6 = r2.isIPv4CompatibleAddress()     // Catch:{ all -> 0x000f }
            if (r6 == 0) goto L_0x0078
            java.util.Map<java.net.InetSocketAddress, io.netty.util.collection.IntObjectMap<io.netty.resolver.dns.DnsQueryContext>> r5 = r5.map     // Catch:{ all -> 0x000f }
            java.net.InetSocketAddress r6 = new java.net.InetSocketAddress     // Catch:{ all -> 0x000f }
            java.net.Inet4Address r2 = toIPv4Address(r2)     // Catch:{ all -> 0x000f }
            r6.<init>(r2, r3)     // Catch:{ all -> 0x000f }
            r5.put(r6, r1)     // Catch:{ all -> 0x000f }
        L_0x0078:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r1
        L_0x007a:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.DnsQueryContextManager.getOrCreateContextMap(java.net.InetSocketAddress):io.netty.util.collection.IntObjectMap");
    }

    private static Inet6Address toCompactAddress(Inet4Address inet4Address) {
        byte[] address = inet4Address.getAddress();
        try {
            return (Inet6Address) InetAddress.getByAddress(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, address[0], address[1], address[2], address[3]});
        } catch (UnknownHostException e) {
            throw new Error(e);
        }
    }

    private static Inet4Address toIPv4Address(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        try {
            return (Inet4Address) InetAddress.getByAddress(new byte[]{address[12], address[13], address[14], address[15]});
        } catch (UnknownHostException e) {
            throw new Error(e);
        }
    }

    public int add(DnsQueryContext dnsQueryContext) {
        IntObjectMap<DnsQueryContext> orCreateContextMap = getOrCreateContextMap(dnsQueryContext.nameServerAddr());
        int nextInt = PlatformDependent.threadLocalRandom().nextInt(65535) + 1;
        synchronized (orCreateContextMap) {
            int i = 0;
            while (orCreateContextMap.containsKey(nextInt)) {
                try {
                    nextInt = (nextInt + 1) & 65535;
                    i++;
                    if (i >= 131070) {
                        throw new IllegalStateException("query ID space exhausted: " + dnsQueryContext.question());
                    }
                } finally {
                }
            }
            orCreateContextMap.put(nextInt, dnsQueryContext);
        }
        return nextInt;
    }

    public DnsQueryContext get(InetSocketAddress inetSocketAddress, int i) {
        DnsQueryContext dnsQueryContext;
        IntObjectMap<DnsQueryContext> contextMap = getContextMap(inetSocketAddress);
        if (contextMap == null) {
            return null;
        }
        synchronized (contextMap) {
            dnsQueryContext = contextMap.get(i);
        }
        return dnsQueryContext;
    }

    public DnsQueryContext remove(InetSocketAddress inetSocketAddress, int i) {
        DnsQueryContext remove;
        IntObjectMap<DnsQueryContext> contextMap = getContextMap(inetSocketAddress);
        if (contextMap == null) {
            return null;
        }
        synchronized (contextMap) {
            remove = contextMap.remove(i);
        }
        return remove;
    }
}
