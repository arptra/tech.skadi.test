package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.internal.tcnative.SSL;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509KeyManager;

class OpenSslKeyMaterialProvider {
    private final X509KeyManager keyManager;
    private final String password;

    public OpenSslKeyMaterialProvider(X509KeyManager x509KeyManager, String str) {
        this.keyManager = x509KeyManager;
        this.password = str;
    }

    public static void validateKeyMaterialSupported(X509Certificate[] x509CertificateArr, PrivateKey privateKey, String str) throws SSLException {
        validateSupported(x509CertificateArr);
        validateSupported(privateKey, str);
    }

    private static void validateSupported(PrivateKey privateKey, String str) throws SSLException {
        if (privateKey != null) {
            long j = 0;
            try {
                long bio = ReferenceCountedOpenSslContext.toBIO((ByteBufAllocator) UnpooledByteBufAllocator.DEFAULT, privateKey);
                try {
                    long parsePrivateKey = SSL.parsePrivateKey(bio, str);
                    SSL.freeBIO(bio);
                    if (parsePrivateKey != 0) {
                        SSL.freePrivateKey(parsePrivateKey);
                    }
                } catch (Exception e) {
                    e = e;
                    j = bio;
                    try {
                        throw new SSLException("PrivateKey type not supported " + privateKey.getFormat(), e);
                    } catch (Throwable th) {
                        th = th;
                        SSL.freeBIO(j);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    j = bio;
                    SSL.freeBIO(j);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                throw new SSLException("PrivateKey type not supported " + privateKey.getFormat(), e);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v14, types: [io.netty.handler.ssl.OpenSslKeyMaterial] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.netty.handler.ssl.OpenSslKeyMaterial chooseKeyMaterial(io.netty.buffer.ByteBufAllocator r19, java.lang.String r20) throws java.lang.Exception {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            javax.net.ssl.X509KeyManager r3 = r0.keyManager
            java.security.cert.X509Certificate[] r9 = r3.getCertificateChain(r2)
            if (r9 == 0) goto L_0x008f
            int r3 = r9.length
            if (r3 != 0) goto L_0x0013
            goto L_0x008f
        L_0x0013:
            javax.net.ssl.X509KeyManager r3 = r0.keyManager
            java.security.PrivateKey r2 = r3.getPrivateKey(r2)
            r3 = 1
            io.netty.handler.ssl.PemEncoded r3 = io.netty.handler.ssl.PemX509Certificate.toPEM(r1, r3, r9)
            r10 = 0
            io.netty.handler.ssl.PemEncoded r4 = r3.retain()     // Catch:{ all -> 0x0072 }
            long r12 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO((io.netty.buffer.ByteBufAllocator) r1, (io.netty.handler.ssl.PemEncoded) r4)     // Catch:{ all -> 0x0072 }
            long r14 = io.netty.internal.tcnative.SSL.parseX509Chain(r12)     // Catch:{ all -> 0x006d }
            boolean r4 = r2 instanceof io.netty.handler.ssl.OpenSslPrivateKey     // Catch:{ all -> 0x0037 }
            if (r4 == 0) goto L_0x003b
            io.netty.handler.ssl.OpenSslPrivateKey r2 = (io.netty.handler.ssl.OpenSslPrivateKey) r2     // Catch:{ all -> 0x0037 }
            io.netty.handler.ssl.OpenSslKeyMaterial r0 = r2.newKeyMaterial(r14, r9)     // Catch:{ all -> 0x0037 }
            goto L_0x0056
        L_0x0037:
            r0 = move-exception
            r1 = r10
            r7 = r1
            goto L_0x0077
        L_0x003b:
            long r7 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO((io.netty.buffer.ByteBufAllocator) r1, (java.security.PrivateKey) r2)     // Catch:{ all -> 0x0037 }
            if (r2 != 0) goto L_0x0043
            r1 = r10
            goto L_0x004a
        L_0x0043:
            java.lang.String r0 = r0.password     // Catch:{ all -> 0x0068 }
            long r0 = io.netty.internal.tcnative.SSL.parsePrivateKey(r7, r0)     // Catch:{ all -> 0x0068 }
            r1 = r0
        L_0x004a:
            io.netty.handler.ssl.DefaultOpenSslKeyMaterial r0 = new io.netty.handler.ssl.DefaultOpenSslKeyMaterial     // Catch:{ all -> 0x0064 }
            r4 = r0
            r5 = r14
            r16 = r7
            r7 = r1
            r4.<init>(r5, r7, r9)     // Catch:{ all -> 0x0060 }
            r10 = r16
        L_0x0056:
            io.netty.internal.tcnative.SSL.freeBIO(r12)
            io.netty.internal.tcnative.SSL.freeBIO(r10)
            r3.release()
            return r0
        L_0x0060:
            r0 = move-exception
            r7 = r16
            goto L_0x0077
        L_0x0064:
            r0 = move-exception
            r16 = r7
            goto L_0x0077
        L_0x0068:
            r0 = move-exception
            r16 = r7
            r1 = r10
            goto L_0x0077
        L_0x006d:
            r0 = move-exception
            r1 = r10
            r7 = r1
            r14 = r7
            goto L_0x0077
        L_0x0072:
            r0 = move-exception
            r1 = r10
            r7 = r1
            r12 = r7
            r14 = r12
        L_0x0077:
            io.netty.internal.tcnative.SSL.freeBIO(r12)
            io.netty.internal.tcnative.SSL.freeBIO(r7)
            int r4 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x0084
            io.netty.internal.tcnative.SSL.freeX509Chain(r14)
        L_0x0084:
            int r4 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x008b
            io.netty.internal.tcnative.SSL.freePrivateKey(r1)
        L_0x008b:
            r3.release()
            throw r0
        L_0x008f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSslKeyMaterialProvider.chooseKeyMaterial(io.netty.buffer.ByteBufAllocator, java.lang.String):io.netty.handler.ssl.OpenSslKeyMaterial");
    }

    public void destroy() {
    }

    public X509KeyManager keyManager() {
        return this.keyManager;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void validateSupported(java.security.cert.X509Certificate[] r7) throws javax.net.ssl.SSLException {
        /*
            if (r7 == 0) goto L_0x0044
            int r0 = r7.length
            if (r0 != 0) goto L_0x0006
            goto L_0x0044
        L_0x0006:
            r0 = 0
            r2 = 0
            io.netty.buffer.UnpooledByteBufAllocator r3 = io.netty.buffer.UnpooledByteBufAllocator.DEFAULT     // Catch:{ Exception -> 0x0032 }
            r4 = 1
            io.netty.handler.ssl.PemEncoded r2 = io.netty.handler.ssl.PemX509Certificate.toPEM(r3, r4, r7)     // Catch:{ Exception -> 0x0032 }
            io.netty.handler.ssl.PemEncoded r7 = r2.retain()     // Catch:{ Exception -> 0x0032 }
            long r3 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO((io.netty.buffer.ByteBufAllocator) r3, (io.netty.handler.ssl.PemEncoded) r7)     // Catch:{ Exception -> 0x0032 }
            long r5 = io.netty.internal.tcnative.SSL.parseX509Chain(r3)     // Catch:{ Exception -> 0x002d, all -> 0x002a }
            io.netty.internal.tcnative.SSL.freeBIO(r3)
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x0026
            io.netty.internal.tcnative.SSL.freeX509Chain(r5)
        L_0x0026:
            r2.release()
            return
        L_0x002a:
            r7 = move-exception
            r0 = r3
            goto L_0x003b
        L_0x002d:
            r7 = move-exception
            r0 = r3
            goto L_0x0033
        L_0x0030:
            r7 = move-exception
            goto L_0x003b
        L_0x0032:
            r7 = move-exception
        L_0x0033:
            javax.net.ssl.SSLException r3 = new javax.net.ssl.SSLException     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = "Certificate type not supported"
            r3.<init>(r4, r7)     // Catch:{ all -> 0x0030 }
            throw r3     // Catch:{ all -> 0x0030 }
        L_0x003b:
            io.netty.internal.tcnative.SSL.freeBIO(r0)
            if (r2 == 0) goto L_0x0043
            r2.release()
        L_0x0043:
            throw r7
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSslKeyMaterialProvider.validateSupported(java.security.cert.X509Certificate[]):void");
    }
}
