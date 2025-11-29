package io.netty.handler.ssl;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class OpenSslX509TrustManagerWrapper {
    private static final InternalLogger LOGGER;
    private static final TrustManagerWrapper WRAPPER;

    public interface TrustManagerWrapper {
        X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager);
    }

    public static final class UnsafeTrustManagerWrapper implements TrustManagerWrapper {
        private final long spiOffset;
        private final long tmOffset;

        public UnsafeTrustManagerWrapper(long j, long j2) {
            this.spiOffset = j;
            this.tmOffset = j2;
        }

        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        public X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager) {
            if (!(x509TrustManager instanceof X509ExtendedTrustManager)) {
                try {
                    SSLContext access$000 = OpenSslX509TrustManagerWrapper.newSSLContext();
                    access$000.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
                    Object object = PlatformDependent.getObject(access$000, this.spiOffset);
                    if (object != null) {
                        Object object2 = PlatformDependent.getObject(object, this.tmOffset);
                        if (object2 instanceof X509ExtendedTrustManager) {
                            return (X509TrustManager) object2;
                        }
                    }
                } catch (NoSuchAlgorithmException e) {
                    PlatformDependent.throwException(e);
                } catch (KeyManagementException e2) {
                    PlatformDependent.throwException(e2);
                } catch (NoSuchProviderException e3) {
                    PlatformDependent.throwException(e3);
                }
            }
            return x509TrustManager;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: io.netty.handler.ssl.OpenSslX509TrustManagerWrapper$TrustManagerWrapper} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<io.netty.handler.ssl.OpenSslX509TrustManagerWrapper> r0 = io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.class
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.util.internal.logging.InternalLoggerFactory.getInstance((java.lang.Class<?>) r0)
            LOGGER = r0
            io.netty.handler.ssl.OpenSslX509TrustManagerWrapper$1 r1 = new io.netty.handler.ssl.OpenSslX509TrustManagerWrapper$1
            r1.<init>()
            java.lang.Throwable r2 = io.netty.util.internal.PlatformDependent.getUnsafeUnavailabilityCause()
            java.lang.String r3 = "Unable to access wrapped TrustManager"
            r4 = 0
            if (r2 != 0) goto L_0x004e
            javax.net.ssl.SSLContext r0 = newSSLContext()     // Catch:{ all -> 0x0029 }
            io.netty.handler.ssl.OpenSslX509TrustManagerWrapper$2 r2 = new io.netty.handler.ssl.OpenSslX509TrustManagerWrapper$2     // Catch:{ all -> 0x0029 }
            r2.<init>()     // Catch:{ all -> 0x0029 }
            r5 = 1
            javax.net.ssl.TrustManager[] r5 = new javax.net.ssl.TrustManager[r5]     // Catch:{ all -> 0x0029 }
            r6 = 0
            r5[r6] = r2     // Catch:{ all -> 0x0029 }
            r0.init(r4, r5, r4)     // Catch:{ all -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r0 = move-exception
            r7 = r4
            r4 = r0
            r0 = r7
        L_0x002d:
            if (r4 == 0) goto L_0x0035
            io.netty.util.internal.logging.InternalLogger r0 = LOGGER
            r0.debug((java.lang.String) r3, (java.lang.Throwable) r4)
            goto L_0x0051
        L_0x0035:
            io.netty.handler.ssl.OpenSslX509TrustManagerWrapper$3 r2 = new io.netty.handler.ssl.OpenSslX509TrustManagerWrapper$3
            r2.<init>(r0)
            java.lang.Object r0 = java.security.AccessController.doPrivileged(r2)
            boolean r2 = r0 instanceof java.lang.Throwable
            if (r2 == 0) goto L_0x004a
            io.netty.util.internal.logging.InternalLogger r2 = LOGGER
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r2.debug((java.lang.String) r3, (java.lang.Throwable) r0)
            goto L_0x0051
        L_0x004a:
            r1 = r0
            io.netty.handler.ssl.OpenSslX509TrustManagerWrapper$TrustManagerWrapper r1 = (io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.TrustManagerWrapper) r1
            goto L_0x0051
        L_0x004e:
            r0.debug((java.lang.String) r3, (java.lang.Throwable) r4)
        L_0x0051:
            WRAPPER = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.<clinit>():void");
    }

    private OpenSslX509TrustManagerWrapper() {
    }

    /* access modifiers changed from: private */
    public static SSLContext newSSLContext() throws NoSuchAlgorithmException, NoSuchProviderException {
        return SSLContext.getInstance("TLS", "SunJSSE");
    }

    public static X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager) {
        return WRAPPER.wrapIfNeeded(x509TrustManager);
    }
}
