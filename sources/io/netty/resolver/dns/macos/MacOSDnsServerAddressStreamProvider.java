package io.netty.resolver.dns.macos;

import io.netty.resolver.dns.DnsServerAddressStream;
import io.netty.resolver.dns.DnsServerAddressStreamProvider;
import io.netty.resolver.dns.DnsServerAddressStreamProviders;
import io.netty.resolver.dns.DnsServerAddresses;
import io.netty.util.internal.ClassInitializerUtil;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class MacOSDnsServerAddressStreamProvider implements DnsServerAddressStreamProvider {
    private static final long REFRESH_INTERVAL = TimeUnit.SECONDS.toNanos(10);
    private static final Comparator<DnsResolver> RESOLVER_COMPARATOR = new Comparator<DnsResolver>() {
        public int compare(DnsResolver dnsResolver, DnsResolver dnsResolver2) {
            if (dnsResolver.searchOrder() < dnsResolver2.searchOrder()) {
                return 1;
            }
            return dnsResolver.searchOrder() == dnsResolver2.searchOrder() ? 0 : -1;
        }
    };
    private static final Throwable UNAVAILABILITY_CAUSE;
    private static final InternalLogger logger;
    private volatile Map<String, DnsServerAddresses> currentMappings = retrieveCurrentMappings();
    private final AtomicLong lastRefresh = new AtomicLong(System.nanoTime());

    static {
        Class<MacOSDnsServerAddressStreamProvider> cls = MacOSDnsServerAddressStreamProvider.class;
        logger = InternalLoggerFactory.getInstance((Class<?>) cls);
        ClassInitializerUtil.tryLoadClasses(cls, byte[].class, String.class);
        try {
            loadNativeLibrary();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        UNAVAILABILITY_CAUSE = th;
    }

    public MacOSDnsServerAddressStreamProvider() {
        ensureAvailability();
    }

    public static void ensureAvailability() {
        Throwable th = UNAVAILABILITY_CAUSE;
        if (th != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(th));
        }
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    private static void loadNativeLibrary() {
        if (PlatformDependent.isOsx()) {
            String str = "netty_resolver_dns_native_macos" + '_' + PlatformDependent.normalizedArch();
            ClassLoader classLoader = PlatformDependent.getClassLoader(MacOSDnsServerAddressStreamProvider.class);
            try {
                NativeLibraryLoader.load(str, classLoader);
            } catch (UnsatisfiedLinkError e) {
                try {
                    NativeLibraryLoader.load("netty_resolver_dns_native_macos", classLoader);
                    logger.debug("Failed to load {}", str, e);
                } catch (UnsatisfiedLinkError e2) {
                    ThrowableUtil.addSuppressed((Throwable) e, (Throwable) e2);
                    throw e;
                }
            }
        } else {
            throw new IllegalStateException("Only supported on MacOS/OSX");
        }
    }

    private static native DnsResolver[] resolvers();

    private static Map<String, DnsServerAddresses> retrieveCurrentMappings() {
        InetSocketAddress[] nameservers;
        DnsResolver[] resolvers = resolvers();
        if (resolvers == null || resolvers.length == 0) {
            return Collections.emptyMap();
        }
        Arrays.sort(resolvers, RESOLVER_COMPARATOR);
        HashMap hashMap = new HashMap(resolvers.length);
        for (DnsResolver dnsResolver : resolvers) {
            if (!("mdns".equalsIgnoreCase(dnsResolver.options()) || (nameservers = dnsResolver.nameservers()) == null || nameservers.length == 0)) {
                String domain = dnsResolver.domain();
                if (domain == null) {
                    domain = "";
                }
                InetSocketAddress[] nameservers2 = dnsResolver.nameservers();
                for (int i = 0; i < nameservers2.length; i++) {
                    InetSocketAddress inetSocketAddress = nameservers2[i];
                    if (inetSocketAddress.getPort() == 0) {
                        int port = dnsResolver.port();
                        if (port == 0) {
                            port = 53;
                        }
                        nameservers2[i] = new InetSocketAddress(inetSocketAddress.getAddress(), port);
                    }
                }
                hashMap.put(domain, DnsServerAddresses.sequential(nameservers2));
            }
        }
        return hashMap;
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    public DnsServerAddressStream nameServerAddressStream(String str) {
        long j = this.lastRefresh.get();
        Map<String, DnsServerAddresses> map = this.currentMappings;
        if (System.nanoTime() - j > REFRESH_INTERVAL && this.lastRefresh.compareAndSet(j, System.nanoTime())) {
            map = retrieveCurrentMappings();
            this.currentMappings = map;
        }
        String str2 = str;
        while (true) {
            int indexOf = str2.indexOf(46, 1);
            if (indexOf < 0 || indexOf == str2.length() - 1) {
                DnsServerAddresses dnsServerAddresses = map.get("");
            } else {
                DnsServerAddresses dnsServerAddresses2 = map.get(str2);
                if (dnsServerAddresses2 != null) {
                    return dnsServerAddresses2.stream();
                }
                str2 = str2.substring(indexOf + 1);
            }
        }
        DnsServerAddresses dnsServerAddresses3 = map.get("");
        return dnsServerAddresses3 != null ? dnsServerAddresses3.stream() : DnsServerAddressStreamProviders.unixDefault().nameServerAddressStream(str);
    }
}
