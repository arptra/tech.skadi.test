package io.netty.resolver.dns;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class DnsServerAddressStreamProviders {
    private static final InternalLogger LOGGER;
    private static final String MACOS_PROVIDER_CLASS_NAME = "io.netty.resolver.dns.macos.MacOSDnsServerAddressStreamProvider";
    private static final Constructor<? extends DnsServerAddressStreamProvider> STREAM_PROVIDER_CONSTRUCTOR;

    public static final class DefaultProviderHolder {
        static final DnsServerAddressStreamProvider DEFAULT_DNS_SERVER_ADDRESS_STREAM_PROVIDER = new DnsServerAddressStreamProvider() {
            private volatile DnsServerAddressStreamProvider currentProvider = provider();
            private final AtomicLong lastRefresh = new AtomicLong(System.nanoTime());

            private DnsServerAddressStreamProvider provider() {
                return PlatformDependent.isWindows() ? DefaultDnsServerAddressStreamProvider.INSTANCE : UnixResolverDnsServerAddressStreamProvider.parseSilently();
            }

            public DnsServerAddressStream nameServerAddressStream(String str) {
                long j = this.lastRefresh.get();
                DnsServerAddressStreamProvider dnsServerAddressStreamProvider = this.currentProvider;
                if (System.nanoTime() - j > DefaultProviderHolder.REFRESH_INTERVAL && this.lastRefresh.compareAndSet(j, System.nanoTime())) {
                    dnsServerAddressStreamProvider = provider();
                    this.currentProvider = dnsServerAddressStreamProvider;
                }
                return dnsServerAddressStreamProvider.nameServerAddressStream(str);
            }
        };
        /* access modifiers changed from: private */
        public static final long REFRESH_INTERVAL = TimeUnit.MINUTES.toNanos(5);

        private DefaultProviderHolder() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        LOGGER.error("Unable to load {}, fallback to system defaults. This may result in incorrect DNS resolutions on MacOS. Check whether you have a dependency on 'io.netty:netty-resolver-dns-native-macos'", MACOS_PROVIDER_CLASS_NAME, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002e A[ExcHandler: all (r1v3 'th' java.lang.Object A[CUSTOM_DECLARE]), Splitter:B:2:0x0011] */
    static {
        /*
            java.lang.String r0 = "io.netty.resolver.dns.macos.MacOSDnsServerAddressStreamProvider"
            java.lang.Class<io.netty.resolver.dns.DnsServerAddressStreamProviders> r1 = io.netty.resolver.dns.DnsServerAddressStreamProviders.class
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.util.internal.logging.InternalLoggerFactory.getInstance((java.lang.Class<?>) r1)
            LOGGER = r1
            boolean r2 = io.netty.util.internal.PlatformDependent.isOsx()
            r3 = 0
            if (r2 == 0) goto L_0x0044
            io.netty.resolver.dns.DnsServerAddressStreamProviders$1 r2 = new io.netty.resolver.dns.DnsServerAddressStreamProviders$1     // Catch:{ ClassNotFoundException -> 0x003d, all -> 0x002e }
            r2.<init>()     // Catch:{ ClassNotFoundException -> 0x003d, all -> 0x002e }
            java.lang.Object r2 = java.security.AccessController.doPrivileged(r2)     // Catch:{ ClassNotFoundException -> 0x003d, all -> 0x002e }
            boolean r4 = r2 instanceof java.lang.Class     // Catch:{ ClassNotFoundException -> 0x003d, all -> 0x002e }
            if (r4 == 0) goto L_0x0032
            java.lang.Class r2 = (java.lang.Class) r2     // Catch:{ ClassNotFoundException -> 0x003d, all -> 0x002e }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r3)     // Catch:{ ClassNotFoundException -> 0x003d, all -> 0x002e }
            r2.newInstance(r3)     // Catch:{ ClassNotFoundException -> 0x0030, all -> 0x002e }
            java.lang.String r4 = "{}: available"
            r1.debug((java.lang.String) r4, (java.lang.Object) r0)     // Catch:{ ClassNotFoundException -> 0x0030, all -> 0x002e }
            r3 = r2
            goto L_0x0044
        L_0x002e:
            r1 = move-exception
            goto L_0x0035
        L_0x0030:
            r3 = r2
            goto L_0x003d
        L_0x0032:
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ ClassNotFoundException -> 0x003d, all -> 0x002e }
            throw r2     // Catch:{ ClassNotFoundException -> 0x003d, all -> 0x002e }
        L_0x0035:
            io.netty.util.internal.logging.InternalLogger r2 = LOGGER
            java.lang.String r4 = "Unable to load {}, fallback to system defaults. This may result in incorrect DNS resolutions on MacOS. Check whether you have a dependency on 'io.netty:netty-resolver-dns-native-macos'"
            r2.error(r4, r0, r1)
            goto L_0x0044
        L_0x003d:
            io.netty.util.internal.logging.InternalLogger r1 = LOGGER
            java.lang.String r2 = "Can not find {} in the classpath, fallback to system defaults. This may result in incorrect DNS resolutions on MacOS. Check whether you have a dependency on 'io.netty:netty-resolver-dns-native-macos'"
            r1.warn((java.lang.String) r2, (java.lang.Object) r0)
        L_0x0044:
            STREAM_PROVIDER_CONSTRUCTOR = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.DnsServerAddressStreamProviders.<clinit>():void");
    }

    private DnsServerAddressStreamProviders() {
    }

    public static DnsServerAddressStreamProvider platformDefault() {
        Constructor<? extends DnsServerAddressStreamProvider> constructor = STREAM_PROVIDER_CONSTRUCTOR;
        if (constructor != null) {
            try {
                return (DnsServerAddressStreamProvider) constructor.newInstance((Object[]) null);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            }
        }
        return unixDefault();
    }

    public static DnsServerAddressStreamProvider unixDefault() {
        return DefaultProviderHolder.DEFAULT_DNS_SERVER_ADDRESS_STREAM_PROVIDER;
    }
}
