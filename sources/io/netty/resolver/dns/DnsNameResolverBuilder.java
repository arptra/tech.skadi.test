package io.netty.resolver.dns;

import io.netty.channel.ChannelFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.SocketChannel;
import io.netty.resolver.HostsFileEntriesResolver;
import io.netty.resolver.ResolvedAddressTypes;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class DnsNameResolverBuilder {
    private AuthoritativeDnsServerCache authoritativeDnsServerCache;
    private ChannelFactory<? extends DatagramChannel> channelFactory;
    private DnsCnameCache cnameCache;
    private boolean completeOncePreferredResolved;
    private boolean decodeIdn = true;
    private DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory = NoopDnsQueryLifecycleObserverFactory.INSTANCE;
    private DnsServerAddressStreamProvider dnsServerAddressStreamProvider = DnsServerAddressStreamProviders.platformDefault();
    volatile EventLoop eventLoop;
    private HostsFileEntriesResolver hostsFileEntriesResolver = HostsFileEntriesResolver.DEFAULT;
    private SocketAddress localAddress;
    private int maxPayloadSize = 4096;
    private int maxQueriesPerResolve = -1;
    private Integer maxTtl;
    private Integer minTtl;
    private int ndots = -1;
    private Integer negativeTtl;
    private boolean optResourceEnabled = true;
    private long queryTimeoutMillis = -1;
    private boolean recursionDesired = true;
    private DnsCache resolveCache;
    private ResolvedAddressTypes resolvedAddressTypes = DnsNameResolver.DEFAULT_RESOLVE_ADDRESS_TYPES;
    private String[] searchDomains;
    private ChannelFactory<? extends SocketChannel> socketChannelFactory;
    private boolean traceEnabled;

    /* renamed from: io.netty.resolver.dns.DnsNameResolverBuilder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$socket$InternetProtocolFamily;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.netty.channel.socket.InternetProtocolFamily[] r0 = io.netty.channel.socket.InternetProtocolFamily.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$channel$socket$InternetProtocolFamily = r0
                io.netty.channel.socket.InternetProtocolFamily r1 = io.netty.channel.socket.InternetProtocolFamily.IPv4     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$channel$socket$InternetProtocolFamily     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.channel.socket.InternetProtocolFamily r1 = io.netty.channel.socket.InternetProtocolFamily.IPv6     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.DnsNameResolverBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    public DnsNameResolverBuilder() {
    }

    public static ResolvedAddressTypes computeResolvedAddressTypes(InternetProtocolFamily... internetProtocolFamilyArr) {
        if (internetProtocolFamilyArr == null || internetProtocolFamilyArr.length == 0) {
            return DnsNameResolver.DEFAULT_RESOLVE_ADDRESS_TYPES;
        }
        if (internetProtocolFamilyArr.length <= 2) {
            int i = AnonymousClass1.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[internetProtocolFamilyArr[0].ordinal()];
            if (i == 1) {
                return (internetProtocolFamilyArr.length < 2 || internetProtocolFamilyArr[1] != InternetProtocolFamily.IPv6) ? ResolvedAddressTypes.IPV4_ONLY : ResolvedAddressTypes.IPV4_PREFERRED;
            }
            if (i == 2) {
                return (internetProtocolFamilyArr.length < 2 || internetProtocolFamilyArr[1] != InternetProtocolFamily.IPv4) ? ResolvedAddressTypes.IPV6_ONLY : ResolvedAddressTypes.IPV6_PREFERRED;
            }
            throw new IllegalArgumentException("Couldn't resolve ResolvedAddressTypes from InternetProtocolFamily array");
        }
        throw new IllegalArgumentException("No more than 2 InternetProtocolFamilies");
    }

    private AuthoritativeDnsServerCache newAuthoritativeDnsServerCache() {
        return new DefaultAuthoritativeDnsServerCache(ObjectUtil.intValue(this.minTtl, 0), ObjectUtil.intValue(this.maxTtl, Integer.MAX_VALUE), new NameServerComparator(DnsNameResolver.preferredAddressType(this.resolvedAddressTypes).addressType()));
    }

    private DnsCache newCache() {
        return new DefaultDnsCache(ObjectUtil.intValue(this.minTtl, 0), ObjectUtil.intValue(this.maxTtl, Integer.MAX_VALUE), ObjectUtil.intValue(this.negativeTtl, 0));
    }

    private DnsCnameCache newCnameCache() {
        return new DefaultDnsCnameCache(ObjectUtil.intValue(this.minTtl, 0), ObjectUtil.intValue(this.maxTtl, Integer.MAX_VALUE));
    }

    @Deprecated
    public DnsNameResolverBuilder authoritativeDnsServerCache(DnsCache dnsCache) {
        this.authoritativeDnsServerCache = new AuthoritativeDnsServerCacheAdapter(dnsCache);
        return this;
    }

    public DnsNameResolver build() {
        if (this.eventLoop != null) {
            DnsCache dnsCache = this.resolveCache;
            if (dnsCache != null && (this.minTtl != null || this.maxTtl != null || this.negativeTtl != null)) {
                throw new IllegalStateException("resolveCache and TTLs are mutually exclusive");
            } else if (this.authoritativeDnsServerCache == null || (this.minTtl == null && this.maxTtl == null && this.negativeTtl == null)) {
                if (dnsCache == null) {
                    dnsCache = newCache();
                }
                DnsCache dnsCache2 = dnsCache;
                DnsCnameCache dnsCnameCache = this.cnameCache;
                if (dnsCnameCache == null) {
                    dnsCnameCache = newCnameCache();
                }
                DnsCnameCache dnsCnameCache2 = dnsCnameCache;
                AuthoritativeDnsServerCache authoritativeDnsServerCache2 = this.authoritativeDnsServerCache;
                if (authoritativeDnsServerCache2 == null) {
                    authoritativeDnsServerCache2 = newAuthoritativeDnsServerCache();
                }
                DnsNameResolver dnsNameResolver = r2;
                DnsNameResolver dnsNameResolver2 = new DnsNameResolver(this.eventLoop, this.channelFactory, this.socketChannelFactory, dnsCache2, dnsCnameCache2, authoritativeDnsServerCache2, this.localAddress, this.dnsQueryLifecycleObserverFactory, this.queryTimeoutMillis, this.resolvedAddressTypes, this.recursionDesired, this.maxQueriesPerResolve, this.traceEnabled, this.maxPayloadSize, this.optResourceEnabled, this.hostsFileEntriesResolver, this.dnsServerAddressStreamProvider, this.searchDomains, this.ndots, this.decodeIdn, this.completeOncePreferredResolved);
                return dnsNameResolver;
            } else {
                throw new IllegalStateException("authoritativeDnsServerCache and TTLs are mutually exclusive");
            }
        } else {
            throw new IllegalStateException("eventLoop should be specified to build a DnsNameResolver.");
        }
    }

    public ChannelFactory<? extends DatagramChannel> channelFactory() {
        return this.channelFactory;
    }

    public DnsNameResolverBuilder channelType(Class<? extends DatagramChannel> cls) {
        return channelFactory(new ReflectiveChannelFactory(cls));
    }

    public DnsNameResolverBuilder cnameCache(DnsCnameCache dnsCnameCache) {
        this.cnameCache = dnsCnameCache;
        return this;
    }

    public DnsNameResolverBuilder completeOncePreferredResolved(boolean z) {
        this.completeOncePreferredResolved = z;
        return this;
    }

    public DnsNameResolverBuilder copy() {
        Integer num;
        DnsNameResolverBuilder dnsNameResolverBuilder = new DnsNameResolverBuilder();
        if (this.eventLoop != null) {
            dnsNameResolverBuilder.eventLoop(this.eventLoop);
        }
        ChannelFactory<? extends DatagramChannel> channelFactory2 = this.channelFactory;
        if (channelFactory2 != null) {
            dnsNameResolverBuilder.channelFactory(channelFactory2);
        }
        ChannelFactory<? extends SocketChannel> channelFactory3 = this.socketChannelFactory;
        if (channelFactory3 != null) {
            dnsNameResolverBuilder.socketChannelFactory(channelFactory3);
        }
        DnsCache dnsCache = this.resolveCache;
        if (dnsCache != null) {
            dnsNameResolverBuilder.resolveCache(dnsCache);
        }
        DnsCnameCache dnsCnameCache = this.cnameCache;
        if (dnsCnameCache != null) {
            dnsNameResolverBuilder.cnameCache(dnsCnameCache);
        }
        if (!(this.maxTtl == null || (num = this.minTtl) == null)) {
            dnsNameResolverBuilder.ttl(num.intValue(), this.maxTtl.intValue());
        }
        Integer num2 = this.negativeTtl;
        if (num2 != null) {
            dnsNameResolverBuilder.negativeTtl(num2.intValue());
        }
        AuthoritativeDnsServerCache authoritativeDnsServerCache2 = this.authoritativeDnsServerCache;
        if (authoritativeDnsServerCache2 != null) {
            dnsNameResolverBuilder.authoritativeDnsServerCache(authoritativeDnsServerCache2);
        }
        DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory2 = this.dnsQueryLifecycleObserverFactory;
        if (dnsQueryLifecycleObserverFactory2 != null) {
            dnsNameResolverBuilder.dnsQueryLifecycleObserverFactory(dnsQueryLifecycleObserverFactory2);
        }
        dnsNameResolverBuilder.queryTimeoutMillis(this.queryTimeoutMillis);
        dnsNameResolverBuilder.resolvedAddressTypes(this.resolvedAddressTypes);
        dnsNameResolverBuilder.recursionDesired(this.recursionDesired);
        dnsNameResolverBuilder.maxQueriesPerResolve(this.maxQueriesPerResolve);
        dnsNameResolverBuilder.traceEnabled(this.traceEnabled);
        dnsNameResolverBuilder.maxPayloadSize(this.maxPayloadSize);
        dnsNameResolverBuilder.optResourceEnabled(this.optResourceEnabled);
        dnsNameResolverBuilder.hostsFileEntriesResolver(this.hostsFileEntriesResolver);
        DnsServerAddressStreamProvider dnsServerAddressStreamProvider2 = this.dnsServerAddressStreamProvider;
        if (dnsServerAddressStreamProvider2 != null) {
            dnsNameResolverBuilder.nameServerProvider(dnsServerAddressStreamProvider2);
        }
        String[] strArr = this.searchDomains;
        if (strArr != null) {
            dnsNameResolverBuilder.searchDomains(Arrays.asList(strArr));
        }
        dnsNameResolverBuilder.ndots(this.ndots);
        dnsNameResolverBuilder.decodeIdn(this.decodeIdn);
        dnsNameResolverBuilder.completeOncePreferredResolved(this.completeOncePreferredResolved);
        dnsNameResolverBuilder.localAddress(this.localAddress);
        return dnsNameResolverBuilder;
    }

    public DnsNameResolverBuilder decodeIdn(boolean z) {
        this.decodeIdn = z;
        return this;
    }

    public DnsNameResolverBuilder dnsQueryLifecycleObserverFactory(DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory2) {
        this.dnsQueryLifecycleObserverFactory = (DnsQueryLifecycleObserverFactory) ObjectUtil.checkNotNull(dnsQueryLifecycleObserverFactory2, "lifecycleObserverFactory");
        return this;
    }

    public DnsNameResolverBuilder eventLoop(EventLoop eventLoop2) {
        this.eventLoop = eventLoop2;
        return this;
    }

    public DnsNameResolverBuilder hostsFileEntriesResolver(HostsFileEntriesResolver hostsFileEntriesResolver2) {
        this.hostsFileEntriesResolver = hostsFileEntriesResolver2;
        return this;
    }

    public DnsNameResolverBuilder localAddress(SocketAddress socketAddress) {
        this.localAddress = socketAddress;
        return this;
    }

    public DnsNameResolverBuilder maxPayloadSize(int i) {
        this.maxPayloadSize = i;
        return this;
    }

    public DnsNameResolverBuilder maxQueriesPerResolve(int i) {
        this.maxQueriesPerResolve = i;
        return this;
    }

    public DnsServerAddressStreamProvider nameServerProvider() {
        return this.dnsServerAddressStreamProvider;
    }

    public DnsNameResolverBuilder ndots(int i) {
        this.ndots = i;
        return this;
    }

    public DnsNameResolverBuilder negativeTtl(int i) {
        this.negativeTtl = Integer.valueOf(i);
        return this;
    }

    public DnsNameResolverBuilder optResourceEnabled(boolean z) {
        this.optResourceEnabled = z;
        return this;
    }

    public DnsNameResolverBuilder queryTimeoutMillis(long j) {
        this.queryTimeoutMillis = j;
        return this;
    }

    public DnsNameResolverBuilder recursionDesired(boolean z) {
        this.recursionDesired = z;
        return this;
    }

    public DnsNameResolverBuilder resolveCache(DnsCache dnsCache) {
        this.resolveCache = dnsCache;
        return this;
    }

    public DnsNameResolverBuilder resolvedAddressTypes(ResolvedAddressTypes resolvedAddressTypes2) {
        this.resolvedAddressTypes = resolvedAddressTypes2;
        return this;
    }

    public DnsNameResolverBuilder searchDomains(Iterable<String> iterable) {
        String next;
        ObjectUtil.checkNotNull(iterable, "searchDomains");
        ArrayList arrayList = new ArrayList(4);
        Iterator<String> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (!arrayList.contains(next)) {
                arrayList.add(next);
            }
        }
        this.searchDomains = (String[]) arrayList.toArray(new String[0]);
        return this;
    }

    public DnsNameResolverBuilder socketChannelFactory(ChannelFactory<? extends SocketChannel> channelFactory2) {
        this.socketChannelFactory = channelFactory2;
        return this;
    }

    public DnsNameResolverBuilder socketChannelType(Class<? extends SocketChannel> cls) {
        return cls == null ? socketChannelFactory((ChannelFactory<? extends SocketChannel>) null) : socketChannelFactory(new ReflectiveChannelFactory(cls));
    }

    @Deprecated
    public DnsNameResolverBuilder traceEnabled(boolean z) {
        this.traceEnabled = z;
        return this;
    }

    public DnsNameResolverBuilder ttl(int i, int i2) {
        this.maxTtl = Integer.valueOf(i2);
        this.minTtl = Integer.valueOf(i);
        return this;
    }

    public DnsNameResolverBuilder authoritativeDnsServerCache(AuthoritativeDnsServerCache authoritativeDnsServerCache2) {
        this.authoritativeDnsServerCache = authoritativeDnsServerCache2;
        return this;
    }

    public DnsNameResolverBuilder channelFactory(ChannelFactory<? extends DatagramChannel> channelFactory2) {
        this.channelFactory = channelFactory2;
        return this;
    }

    public DnsNameResolverBuilder nameServerProvider(DnsServerAddressStreamProvider dnsServerAddressStreamProvider2) {
        this.dnsServerAddressStreamProvider = (DnsServerAddressStreamProvider) ObjectUtil.checkNotNull(dnsServerAddressStreamProvider2, "dnsServerAddressStreamProvider");
        return this;
    }

    public DnsNameResolverBuilder(EventLoop eventLoop2) {
        eventLoop(eventLoop2);
    }
}
