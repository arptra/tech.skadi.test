package io.netty.handler.ssl;

import java.security.Provider;

public enum SslProvider {
    JDK,
    OPENSSL,
    OPENSSL_REFCNT;

    /* renamed from: io.netty.handler.ssl.SslProvider$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$SslProvider = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.netty.handler.ssl.SslProvider[] r0 = io.netty.handler.ssl.SslProvider.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$ssl$SslProvider = r0
                io.netty.handler.ssl.SslProvider r1 = io.netty.handler.ssl.SslProvider.JDK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$ssl$SslProvider     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.ssl.SslProvider r1 = io.netty.handler.ssl.SslProvider.OPENSSL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$ssl$SslProvider     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.ssl.SslProvider r1 = io.netty.handler.ssl.SslProvider.OPENSSL_REFCNT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public static boolean isAlpnSupported(SslProvider sslProvider) {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i == 1) {
            return JdkAlpnApplicationProtocolNegotiator.isAlpnSupported();
        }
        if (i == 2 || i == 3) {
            return OpenSsl.isAlpnSupported();
        }
        throw new Error("Unknown SslProvider: " + sslProvider);
    }

    public static boolean isTlsv13EnabledByDefault(SslProvider sslProvider, Provider provider) {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i == 1) {
            return SslUtils.isTLSv13EnabledByJDK(provider);
        }
        if (i == 2 || i == 3) {
            return OpenSsl.isTlsv13Supported();
        }
        throw new Error("Unknown SslProvider: " + sslProvider);
    }

    public static boolean isTlsv13Supported(SslProvider sslProvider) {
        return isTlsv13Supported(sslProvider, (Provider) null);
    }

    public static boolean isTlsv13Supported(SslProvider sslProvider, Provider provider) {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i == 1) {
            return SslUtils.isTLSv13SupportedByJDK(provider);
        }
        if (i == 2 || i == 3) {
            return OpenSsl.isTlsv13Supported();
        }
        throw new Error("Unknown SslProvider: " + sslProvider);
    }
}
