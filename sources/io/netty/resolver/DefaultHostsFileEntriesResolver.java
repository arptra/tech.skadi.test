package io.netty.resolver;

import io.netty.resolver.HostsFileEntriesProvider;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class DefaultHostsFileEntriesResolver implements HostsFileEntriesResolver {
    private static final long DEFAULT_REFRESH_INTERVAL;
    private static final InternalLogger logger;
    private final HostsFileEntriesProvider.Parser hostsFileParser;
    private volatile Map<String, List<InetAddress>> inet4Entries;
    private volatile Map<String, List<InetAddress>> inet6Entries;
    private final AtomicLong lastRefresh;
    private final long refreshInterval;

    /* renamed from: io.netty.resolver.DefaultHostsFileEntriesResolver$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$resolver$ResolvedAddressTypes;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.netty.resolver.ResolvedAddressTypes[] r0 = io.netty.resolver.ResolvedAddressTypes.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes = r0
                io.netty.resolver.ResolvedAddressTypes r1 = io.netty.resolver.ResolvedAddressTypes.IPV4_ONLY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$resolver$ResolvedAddressTypes     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.resolver.ResolvedAddressTypes r1 = io.netty.resolver.ResolvedAddressTypes.IPV6_ONLY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$resolver$ResolvedAddressTypes     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.resolver.ResolvedAddressTypes r1 = io.netty.resolver.ResolvedAddressTypes.IPV4_PREFERRED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$resolver$ResolvedAddressTypes     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.resolver.ResolvedAddressTypes r1 = io.netty.resolver.ResolvedAddressTypes.IPV6_PREFERRED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.DefaultHostsFileEntriesResolver.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        InternalLogger instance = InternalLoggerFactory.getInstance((Class<?>) DefaultHostsFileEntriesResolver.class);
        logger = instance;
        long j = SystemPropertyUtil.getLong("io.netty.hostsFileRefreshInterval", 0);
        DEFAULT_REFRESH_INTERVAL = j;
        if (instance.isDebugEnabled()) {
            instance.debug("-Dio.netty.hostsFileRefreshInterval: {}", (Object) Long.valueOf(j));
        }
    }

    public DefaultHostsFileEntriesResolver() {
        this(HostsFileEntriesProvider.parser(), DEFAULT_REFRESH_INTERVAL);
    }

    private static List<InetAddress> allAddresses(List<InetAddress> list, List<InetAddress> list2) {
        ArrayList arrayList = new ArrayList(list.size() + (list2 == null ? 0 : list2.size()));
        arrayList.addAll(list);
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        return arrayList;
    }

    private void ensureHostsFileEntriesAreFresh() {
        long j = this.refreshInterval;
        if (j != 0) {
            long j2 = this.lastRefresh.get();
            long nanoTime = System.nanoTime();
            if (nanoTime - j2 > j && this.lastRefresh.compareAndSet(j2, nanoTime)) {
                HostsFileEntriesProvider parseEntries = parseEntries(this.hostsFileParser);
                this.inet4Entries = parseEntries.ipv4Entries();
                this.inet6Entries = parseEntries.ipv6Entries();
            }
        }
    }

    private static InetAddress firstAddress(List<InetAddress> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static HostsFileEntriesProvider parseEntries(HostsFileEntriesProvider.Parser parser) {
        return PlatformDependent.isWindows() ? parser.parseSilently(Charset.defaultCharset(), CharsetUtil.UTF_16, CharsetUtil.UTF_8) : parser.parseSilently();
    }

    public InetAddress address(String str, ResolvedAddressTypes resolvedAddressTypes) {
        return firstAddress(addresses(str, resolvedAddressTypes));
    }

    public List<InetAddress> addresses(String str, ResolvedAddressTypes resolvedAddressTypes) {
        String normalize = normalize(str);
        ensureHostsFileEntriesAreFresh();
        int i = AnonymousClass1.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[resolvedAddressTypes.ordinal()];
        if (i == 1) {
            return this.inet4Entries.get(normalize);
        }
        if (i == 2) {
            return this.inet6Entries.get(normalize);
        }
        if (i == 3) {
            List list = this.inet4Entries.get(normalize);
            Map<String, List<InetAddress>> map = this.inet6Entries;
            return list != null ? allAddresses(list, map.get(normalize)) : map.get(normalize);
        } else if (i == 4) {
            List list2 = this.inet6Entries.get(normalize);
            Map<String, List<InetAddress>> map2 = this.inet4Entries;
            return list2 != null ? allAddresses(list2, map2.get(normalize)) : map2.get(normalize);
        } else {
            throw new IllegalArgumentException("Unknown ResolvedAddressTypes " + resolvedAddressTypes);
        }
    }

    public String normalize(String str) {
        return str.toLowerCase(Locale.ENGLISH);
    }

    public DefaultHostsFileEntriesResolver(HostsFileEntriesProvider.Parser parser, long j) {
        this.lastRefresh = new AtomicLong(System.nanoTime());
        this.hostsFileParser = parser;
        this.refreshInterval = ObjectUtil.checkPositiveOrZero(j, "refreshInterval");
        HostsFileEntriesProvider parseEntries = parseEntries(parser);
        this.inet4Entries = parseEntries.ipv4Entries();
        this.inet6Entries = parseEntries.ipv6Entries();
    }
}
