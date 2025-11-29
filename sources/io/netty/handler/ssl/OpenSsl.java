package io.netty.handler.ssl;

import com.honey.account.constant.AccountConstantKt;
import io.netty.buffer.ByteBuf;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.Library;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class OpenSsl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Set<String> AVAILABLE_CIPHER_SUITES;
    private static final Set<String> AVAILABLE_JAVA_CIPHER_SUITES;
    private static final Set<String> AVAILABLE_OPENSSL_CIPHER_SUITES;
    private static final String CERT = "-----BEGIN CERTIFICATE-----\nMIICrjCCAZagAwIBAgIIdSvQPv1QAZQwDQYJKoZIhvcNAQELBQAwFjEUMBIGA1UEAxMLZXhhbXBs\nZS5jb20wIBcNMTgwNDA2MjIwNjU5WhgPOTk5OTEyMzEyMzU5NTlaMBYxFDASBgNVBAMTC2V4YW1w\nbGUuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAggbWsmDQ6zNzRZ5AW8E3eoGl\nqWvOBDb5Fs1oBRrVQHuYmVAoaqwDzXYJ0LOwa293AgWEQ1jpcbZ2hpoYQzqEZBTLnFhMrhRFlH6K\nbJND8Y33kZ/iSVBBDuGbdSbJShlM+4WwQ9IAso4MZ4vW3S1iv5fGGpLgbtXRmBf/RU8omN0Gijlv\nWlLWHWijLN8xQtySFuBQ7ssW8RcKAary3pUm6UUQB+Co6lnfti0Tzag8PgjhAJq2Z3wbsGRnP2YS\nvYoaK6qzmHXRYlp/PxrjBAZAmkLJs4YTm/XFF+fkeYx4i9zqHbyone5yerRibsHaXZWLnUL+rFoe\nMdKvr0VS3sGmhQIDAQABMA0GCSqGSIb3DQEBCwUAA4IBAQADQi441pKmXf9FvUV5EHU4v8nJT9Iq\nyqwsKwXnr7AsUlDGHBD7jGrjAXnG5rGxuNKBQ35wRxJATKrUtyaquFUL6H8O6aGQehiFTk6zmPbe\n12Gu44vqqTgIUxnv3JQJiox8S2hMxsSddpeCmSdvmalvD6WG4NthH6B9ZaBEiep1+0s0RUaBYn73\nI7CCUaAtbjfR6pcJjrFk5ei7uwdQZFSJtkP2z8r7zfeANJddAKFlkaMWn7u+OIVuB4XPooWicObk\nNAHFtP65bocUYnDpTVdiyvn8DdqyZ/EO8n1bBKBzuSLplk2msW4pdgaFgY7Vw/0wzcFXfUXmL1uy\nG8sQD/wx\n-----END CERTIFICATE-----";
    static final List<String> DEFAULT_CIPHERS;
    private static final String[] DEFAULT_NAMED_GROUPS = {"x25519", "secp256r1", "secp384r1", "secp521r1"};
    static final String[] EXTRA_SUPPORTED_TLS_1_3_CIPHERS;
    static final String EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING;
    private static final boolean IS_BORINGSSL;
    private static final String KEY = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCBtayYNDrM3NFnkBbwTd6gaWp\na84ENvkWzWgFGtVAe5iZUChqrAPNdgnQs7Brb3cCBYRDWOlxtnaGmhhDOoRkFMucWEyuFEWUfops\nk0PxjfeRn+JJUEEO4Zt1JslKGUz7hbBD0gCyjgxni9bdLWK/l8YakuBu1dGYF/9FTyiY3QaKOW9a\nUtYdaKMs3zFC3JIW4FDuyxbxFwoBqvLelSbpRRAH4KjqWd+2LRPNqDw+COEAmrZnfBuwZGc/ZhK9\nihorqrOYddFiWn8/GuMEBkCaQsmzhhOb9cUX5+R5jHiL3OodvKid7nJ6tGJuwdpdlYudQv6sWh4x\n0q+vRVLewaaFAgMBAAECggEAP8tPJvFtTxhNJAkCloHz0D0vpDHqQBMgntlkgayqmBqLwhyb18pR\ni0qwgh7HHc7wWqOOQuSqlEnrWRrdcI6TSe8R/sErzfTQNoznKWIPYcI/hskk4sdnQ//Yn9/Jvnsv\nU/BBjOTJxtD+sQbhAl80JcA3R+5sArURQkfzzHOL/YMqzAsn5hTzp7HZCxUqBk3KaHRxV7NefeOE\nxlZuWSmxYWfbFIs4kx19/1t7h8CHQWezw+G60G2VBtSBBxDnhBWvqG6R/wpzJ3nEhPLLY9T+XIHe\nipzdMOOOUZorfIg7M+pyYPji+ZIZxIpY5OjrOzXHciAjRtr5Y7l99K1CG1LguQKBgQDrQfIMxxtZ\nvxU/1cRmUV9l7pt5bjV5R6byXq178LxPKVYNjdZ840Q0/OpZEVqaT1xKVi35ohP1QfNjxPLlHD+K\niDAR9z6zkwjIrbwPCnb5kuXy4lpwPcmmmkva25fI7qlpHtbcuQdoBdCfr/KkKaUCMPyY89LCXgEw\n5KTDj64UywKBgQCNfbO+eZLGzhiHhtNJurresCsIGWlInv322gL8CSfBMYl6eNfUTZvUDdFhPISL\nUljKWzXDrjw0ujFSPR0XhUGtiq89H+HUTuPPYv25gVXO+HTgBFZEPl4PpA+BUsSVZy0NddneyqLk\n42Wey9omY9Q8WsdNQS5cbUvy0uG6WFoX7wKBgQDZ1jpW8pa0x2bZsQsm4vo+3G5CRnZlUp+XlWt2\ndDcp5dC0xD1zbs1dc0NcLeGDOTDv9FSl7hok42iHXXq8AygjEm/QcuwwQ1nC2HxmQP5holAiUs4D\nWHM8PWs3wFYPzE459EBoKTxeaeP/uWAn+he8q7d5uWvSZlEcANs/6e77eQKBgD21Ar0hfFfj7mK8\n9E0FeRZBsqK3omkfnhcYgZC11Xa2SgT1yvs2Va2n0RcdM5kncr3eBZav2GYOhhAdwyBM55XuE/sO\neokDVutNeuZ6d5fqV96TRaRBpvgfTvvRwxZ9hvKF4Vz+9wfn/JvCwANaKmegF6ejs7pvmF3whq2k\ndrZVAoGAX5YxQ5XMTD0QbMAl7/6qp6S58xNoVdfCkmkj1ZLKaHKIjS/benkKGlySVQVPexPfnkZx\np/Vv9yyphBoudiTBS9Uog66ueLYZqpgxlM/6OhYg86Gm3U2ycvMxYjBM1NFiyze21AqAhI+HX+Ot\nmraV2/guSgDgZAhukRZzeQ2RucI=\n-----END PRIVATE KEY-----";
    static final String[] NAMED_GROUPS;
    static final Set<String> SUPPORTED_PROTOCOLS_SET;
    private static final boolean SUPPORTS_KEYMANAGER_FACTORY;
    private static final boolean SUPPORTS_OCSP;
    private static final boolean TLSV13_SUPPORTED;
    private static final Throwable UNAVAILABILITY_CAUSE;
    private static final boolean USE_KEYMANAGER_FACTORY;
    private static final InternalLogger logger;

    /* JADX WARNING: type inference failed for: r22v0, types: [io.netty.handler.ssl.PemPrivateKey, io.netty.handler.ssl.PemEncoded, io.netty.util.ReferenceCounted] */
    /* JADX WARNING: type inference failed for: r0v49, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x023c A[Catch:{ all -> 0x024c }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02dc A[SYNTHETIC, Splitter:B:167:0x02dc] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x02e7 A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x02ee A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x02f5 A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0300 A[Catch:{ all -> 0x0345, all -> 0x0336 }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x03c9 A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x03d0 A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x03d7 A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x03de A[Catch:{ all -> 0x02e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0418  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0489  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x04a4  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x04b3  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x04c2  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x04d3  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x04dc  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x04f3  */
    /* JADX WARNING: Removed duplicated region for block: B:299:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01bb A[SYNTHETIC, Splitter:B:72:0x01bb] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01ea A[SYNTHETIC, Splitter:B:90:0x01ea] */
    /* JADX WARNING: Unknown variable types count: 1 */
    static {
        /*
            r1 = 1
            java.lang.String r2 = "io.netty.handler.ssl.openssl.useKeyManagerFactory"
            java.lang.Class<io.netty.handler.ssl.OpenSsl> r0 = io.netty.handler.ssl.OpenSsl.class
            io.netty.util.internal.logging.InternalLogger r3 = io.netty.util.internal.logging.InternalLoggerFactory.getInstance((java.lang.Class<?>) r0)
            logger = r3
            java.lang.String r4 = "secp384r1"
            java.lang.String r5 = "secp521r1"
            java.lang.String r6 = "x25519"
            java.lang.String r7 = "secp256r1"
            java.lang.String[] r4 = new java.lang.String[]{r6, r7, r4, r5}
            DEFAULT_NAMED_GROUPS = r4
            java.lang.String r4 = "io.netty.handler.ssl.noOpenSsl"
            r5 = 0
            boolean r4 = io.netty.util.internal.SystemPropertyUtil.getBoolean(r4, r5)
            java.lang.String r6 = " will be unavailable."
            java.lang.Class<io.netty.handler.ssl.OpenSslEngine> r7 = io.netty.handler.ssl.OpenSslEngine.class
            r8 = 0
            if (r4 == 0) goto L_0x004b
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r4 = "OpenSSL was explicit disabled with -Dio.netty.handler.ssl.noOpenSsl=true"
            r0.<init>(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r9 = "netty-tcnative explicit disabled; "
            r4.append(r9)
            java.lang.String r7 = r7.getSimpleName()
            r4.append(r7)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r3.debug((java.lang.String) r4, (java.lang.Throwable) r0)
            goto L_0x00dd
        L_0x004b:
            java.lang.String r3 = "io.netty.internal.tcnative.SSLContext"
            java.lang.ClassLoader r0 = io.netty.util.internal.PlatformDependent.getClassLoader(r0)     // Catch:{ ClassNotFoundException -> 0x0056 }
            java.lang.Class.forName(r3, r5, r0)     // Catch:{ ClassNotFoundException -> 0x0056 }
            r0 = r8
            goto L_0x0074
        L_0x0056:
            r0 = move-exception
            io.netty.util.internal.logging.InternalLogger r3 = logger
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r9 = "netty-tcnative not in the classpath; "
            r4.append(r9)
            java.lang.String r9 = r7.getSimpleName()
            r4.append(r9)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r3.debug((java.lang.String) r4)
        L_0x0074:
            if (r0 != 0) goto L_0x00dd
            loadTcNative()     // Catch:{ all -> 0x007b }
            r3 = r0
            goto L_0x009c
        L_0x007b:
            r0 = move-exception
            r3 = r0
            io.netty.util.internal.logging.InternalLogger r0 = logger
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Failed to load netty-tcnative; "
            r4.append(r6)
            java.lang.String r6 = r7.getSimpleName()
            r4.append(r6)
            java.lang.String r6 = " will be unavailable, unless the application has already loaded the symbols by some other means. See https://netty.io/wiki/forked-tomcat-native.html for more information."
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r0.debug((java.lang.String) r4, (java.lang.Throwable) r3)
        L_0x009c:
            java.lang.String r0 = "io.netty.handler.ssl.openssl.engine"
            java.lang.String r0 = io.netty.util.internal.SystemPropertyUtil.get(r0, r8)     // Catch:{ all -> 0x00ac }
            if (r0 != 0) goto L_0x00ae
            io.netty.util.internal.logging.InternalLogger r4 = logger     // Catch:{ all -> 0x00ac }
            java.lang.String r6 = "Initialize netty-tcnative using engine: 'default'"
            r4.debug((java.lang.String) r6)     // Catch:{ all -> 0x00ac }
            goto L_0x00b5
        L_0x00ac:
            r0 = move-exception
            goto L_0x00ba
        L_0x00ae:
            io.netty.util.internal.logging.InternalLogger r4 = logger     // Catch:{ all -> 0x00ac }
            java.lang.String r6 = "Initialize netty-tcnative using engine: '{}'"
            r4.debug((java.lang.String) r6, (java.lang.Object) r0)     // Catch:{ all -> 0x00ac }
        L_0x00b5:
            initializeTcNative(r0)     // Catch:{ all -> 0x00ac }
            r0 = r8
            goto L_0x00dd
        L_0x00ba:
            if (r3 != 0) goto L_0x00bd
            r3 = r0
        L_0x00bd:
            io.netty.util.internal.logging.InternalLogger r4 = logger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r9 = "Failed to initialize netty-tcnative; "
            r6.append(r9)
            java.lang.String r7 = r7.getSimpleName()
            r6.append(r7)
            java.lang.String r7 = " will be unavailable. See https://netty.io/wiki/forked-tomcat-native.html for more information."
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r4.debug((java.lang.String) r6, (java.lang.Throwable) r0)
            r0 = r3
        L_0x00dd:
            UNAVAILABILITY_CAUSE = r0
            java.lang.String r3 = ""
            if (r0 != 0) goto L_0x04fe
            io.netty.util.internal.logging.InternalLogger r0 = logger
            java.lang.String r4 = "netty-tcnative using native library: {}"
            java.lang.String r6 = io.netty.internal.tcnative.SSL.versionString()
            r0.debug((java.lang.String) r4, (java.lang.Object) r6)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.LinkedHashSet r6 = new java.util.LinkedHashSet
            r0 = 128(0x80, float:1.794E-43)
            r6.<init>(r0)
            java.lang.String[] r7 = DEFAULT_NAMED_GROUPS
            int r9 = r7.length
            java.lang.String[] r9 = new java.lang.String[r9]
            r10 = r5
        L_0x0100:
            int r11 = r7.length
            if (r10 >= r11) goto L_0x010d
            r11 = r7[r10]
            java.lang.String r11 = io.netty.handler.ssl.GroupsConverter.toOpenSsl(r11)
            r9[r10] = r11
            int r10 = r10 + r1
            goto L_0x0100
        L_0x010d:
            java.lang.String r10 = "BoringSSL"
            java.lang.String r11 = versionString()
            boolean r10 = r10.equals(r11)
            IS_BORINGSSL = r10
            if (r10 == 0) goto L_0x014b
            java.lang.String r3 = "TLS_AES_256_GCM_SHA384"
            java.lang.String r10 = "TLS_CHACHA20_POLY1305_SHA256"
            java.lang.String r11 = "TLS_AES_128_GCM_SHA256"
            java.lang.String[] r3 = new java.lang.String[]{r11, r3, r10}
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS = r3
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r0)
            int r0 = r3.length
            r11 = r5
        L_0x012e:
            if (r11 >= r0) goto L_0x013c
            r12 = r3[r11]
            r10.append(r12)
            java.lang.String r12 = ":"
            r10.append(r12)
            int r11 = r11 + r1
            goto L_0x012e
        L_0x013c:
            int r0 = r10.length()
            int r0 = r0 - r1
            r10.setLength(r0)
            java.lang.String r0 = r10.toString()
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = r0
            goto L_0x0151
        L_0x014b:
            java.lang.String[] r0 = io.netty.util.internal.EmptyArrays.EMPTY_STRINGS
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS = r0
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = r3
        L_0x0151:
            r0 = 63
            long r10 = io.netty.internal.tcnative.SSLContext.make(r0, r1)     // Catch:{ Exception -> 0x03f0 }
            io.netty.handler.ssl.SslProvider r0 = io.netty.handler.ssl.SslProvider.JDK     // Catch:{ all -> 0x03e6 }
            boolean r0 = io.netty.handler.ssl.SslProvider.isTlsv13Supported(r0)     // Catch:{ all -> 0x03e6 }
            if (r0 == 0) goto L_0x01a7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            r0.<init>()     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            java.util.Set<java.lang.String> r3 = io.netty.handler.ssl.SslUtils.TLSV13_CIPHERS     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
        L_0x016a:
            boolean r12 = r3.hasNext()     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            if (r12 == 0) goto L_0x018d
            java.lang.Object r12 = r3.next()     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            boolean r13 = IS_BORINGSSL     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            java.lang.String r12 = io.netty.handler.ssl.CipherSuiteConverter.toOpenSsl(r12, r13)     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            if (r12 == 0) goto L_0x016a
            r0.append(r12)     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            r12 = 58
            r0.append(r12)     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            goto L_0x016a
        L_0x0187:
            r0 = move-exception
            r2 = r5
            r3 = r2
            r12 = r3
            goto L_0x03ea
        L_0x018d:
            int r3 = r0.length()     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            if (r3 != 0) goto L_0x0195
            r0 = r5
            goto L_0x01a5
        L_0x0195:
            int r3 = r0.length()     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            int r3 = r3 - r1
            r0.setLength(r3)     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            io.netty.internal.tcnative.SSLContext.setCipherSuite(r10, r0, r1)     // Catch:{ Exception -> 0x01a7, all -> 0x0187 }
            r0 = r1
        L_0x01a5:
            r3 = r0
            goto L_0x01a8
        L_0x01a7:
            r3 = r5
        L_0x01a8:
            java.lang.String r0 = "ALL"
            io.netty.internal.tcnative.SSLContext.setCipherSuite(r10, r0, r5)     // Catch:{ all -> 0x03e2 }
            long r18 = io.netty.internal.tcnative.SSL.newSSL(r10, r1)     // Catch:{ all -> 0x03e2 }
            r20 = 0
            java.lang.String[] r0 = io.netty.internal.tcnative.SSL.getCiphers(r18)     // Catch:{ all -> 0x03b7 }
            int r12 = r0.length     // Catch:{ all -> 0x03b7 }
            r13 = r5
        L_0x01b9:
            if (r13 >= r12) goto L_0x01e6
            r14 = r0[r13]     // Catch:{ all -> 0x01d4 }
            if (r14 == 0) goto L_0x01e4
            boolean r15 = r14.isEmpty()     // Catch:{ all -> 0x01d4 }
            if (r15 != 0) goto L_0x01e4
            boolean r15 = r6.contains(r14)     // Catch:{ all -> 0x01d4 }
            if (r15 != 0) goto L_0x01e4
            if (r3 != 0) goto L_0x01e1
            boolean r15 = io.netty.handler.ssl.SslUtils.isTLSv13Cipher(r14)     // Catch:{ all -> 0x01d4 }
            if (r15 == 0) goto L_0x01e1
            goto L_0x01e4
        L_0x01d4:
            r0 = move-exception
            r2 = r5
            r12 = r2
            r14 = r20
            r23 = r14
            r25 = r23
            r27 = r25
            goto L_0x03c2
        L_0x01e1:
            r6.add(r14)     // Catch:{ all -> 0x01d4 }
        L_0x01e4:
            int r13 = r13 + r1
            goto L_0x01b9
        L_0x01e6:
            boolean r0 = IS_BORINGSSL     // Catch:{ all -> 0x03b7 }
            if (r0 == 0) goto L_0x01fc
            java.lang.String[] r12 = EXTRA_SUPPORTED_TLS_1_3_CIPHERS     // Catch:{ all -> 0x01d4 }
            java.util.Collections.addAll(r6, r12)     // Catch:{ all -> 0x01d4 }
            java.lang.String r12 = "AEAD-AES128-GCM-SHA256"
            java.lang.String r13 = "AEAD-AES256-GCM-SHA384"
            java.lang.String r14 = "AEAD-CHACHA20-POLY1305-SHA256"
            java.lang.String[] r12 = new java.lang.String[]{r12, r13, r14}     // Catch:{ all -> 0x01d4 }
            java.util.Collections.addAll(r6, r12)     // Catch:{ all -> 0x01d4 }
        L_0x01fc:
            java.lang.String r12 = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCBtayYNDrM3NFnkBbwTd6gaWp\na84ENvkWzWgFGtVAe5iZUChqrAPNdgnQs7Brb3cCBYRDWOlxtnaGmhhDOoRkFMucWEyuFEWUfops\nk0PxjfeRn+JJUEEO4Zt1JslKGUz7hbBD0gCyjgxni9bdLWK/l8YakuBu1dGYF/9FTyiY3QaKOW9a\nUtYdaKMs3zFC3JIW4FDuyxbxFwoBqvLelSbpRRAH4KjqWd+2LRPNqDw+COEAmrZnfBuwZGc/ZhK9\nihorqrOYddFiWn8/GuMEBkCaQsmzhhOb9cUX5+R5jHiL3OodvKid7nJ6tGJuwdpdlYudQv6sWh4x\n0q+vRVLewaaFAgMBAAECggEAP8tPJvFtTxhNJAkCloHz0D0vpDHqQBMgntlkgayqmBqLwhyb18pR\ni0qwgh7HHc7wWqOOQuSqlEnrWRrdcI6TSe8R/sErzfTQNoznKWIPYcI/hskk4sdnQ//Yn9/Jvnsv\nU/BBjOTJxtD+sQbhAl80JcA3R+5sArURQkfzzHOL/YMqzAsn5hTzp7HZCxUqBk3KaHRxV7NefeOE\nxlZuWSmxYWfbFIs4kx19/1t7h8CHQWezw+G60G2VBtSBBxDnhBWvqG6R/wpzJ3nEhPLLY9T+XIHe\nipzdMOOOUZorfIg7M+pyYPji+ZIZxIpY5OjrOzXHciAjRtr5Y7l99K1CG1LguQKBgQDrQfIMxxtZ\nvxU/1cRmUV9l7pt5bjV5R6byXq178LxPKVYNjdZ840Q0/OpZEVqaT1xKVi35ohP1QfNjxPLlHD+K\niDAR9z6zkwjIrbwPCnb5kuXy4lpwPcmmmkva25fI7qlpHtbcuQdoBdCfr/KkKaUCMPyY89LCXgEw\n5KTDj64UywKBgQCNfbO+eZLGzhiHhtNJurresCsIGWlInv322gL8CSfBMYl6eNfUTZvUDdFhPISL\nUljKWzXDrjw0ujFSPR0XhUGtiq89H+HUTuPPYv25gVXO+HTgBFZEPl4PpA+BUsSVZy0NddneyqLk\n42Wey9omY9Q8WsdNQS5cbUvy0uG6WFoX7wKBgQDZ1jpW8pa0x2bZsQsm4vo+3G5CRnZlUp+XlWt2\ndDcp5dC0xD1zbs1dc0NcLeGDOTDv9FSl7hok42iHXXq8AygjEm/QcuwwQ1nC2HxmQP5holAiUs4D\nWHM8PWs3wFYPzE459EBoKTxeaeP/uWAn+he8q7d5uWvSZlEcANs/6e77eQKBgD21Ar0hfFfj7mK8\n9E0FeRZBsqK3omkfnhcYgZC11Xa2SgT1yvs2Va2n0RcdM5kncr3eBZav2GYOhhAdwyBM55XuE/sO\neokDVutNeuZ6d5fqV96TRaRBpvgfTvvRwxZ9hvKF4Vz+9wfn/JvCwANaKmegF6ejs7pvmF3whq2k\ndrZVAoGAX5YxQ5XMTD0QbMAl7/6qp6S58xNoVdfCkmkj1ZLKaHKIjS/benkKGlySVQVPexPfnkZx\np/Vv9yyphBoudiTBS9Uog66ueLYZqpgxlM/6OhYg86Gm3U2ycvMxYjBM1NFiyze21AqAhI+HX+Ot\nmraV2/guSgDgZAhukRZzeQ2RucI=\n-----END PRIVATE KEY-----"
            java.nio.charset.Charset r13 = io.netty.util.CharsetUtil.US_ASCII     // Catch:{ all -> 0x03b7 }
            byte[] r12 = r12.getBytes(r13)     // Catch:{ all -> 0x03b7 }
            io.netty.handler.ssl.PemPrivateKey r22 = io.netty.handler.ssl.PemPrivateKey.valueOf((byte[]) r12)     // Catch:{ all -> 0x03b7 }
            io.netty.internal.tcnative.SSLContext.setCertificateCallback(r10, r8)     // Catch:{ Error -> 0x02c2, all -> 0x02b8 }
            java.security.cert.X509Certificate r12 = selfSignedCertificate()     // Catch:{ Error -> 0x02c2, all -> 0x02b8 }
            io.netty.buffer.ByteBufAllocator r13 = io.netty.buffer.ByteBufAllocator.DEFAULT     // Catch:{ Error -> 0x02c2, all -> 0x02b8 }
            java.security.cert.X509Certificate[] r12 = new java.security.cert.X509Certificate[]{r12}     // Catch:{ Error -> 0x02c2, all -> 0x02b8 }
            long r23 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO((io.netty.buffer.ByteBufAllocator) r13, (java.security.cert.X509Certificate[]) r12)     // Catch:{ Error -> 0x02c2, all -> 0x02b8 }
            long r25 = io.netty.internal.tcnative.SSL.parseX509Chain(r23)     // Catch:{ Error -> 0x02af, all -> 0x02a4 }
            io.netty.buffer.UnpooledByteBufAllocator r12 = io.netty.buffer.UnpooledByteBufAllocator.DEFAULT     // Catch:{ Error -> 0x029d, all -> 0x0294 }
            io.netty.handler.ssl.PemEncoded r13 = r22.retain()     // Catch:{ Error -> 0x029d, all -> 0x0294 }
            long r14 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO((io.netty.buffer.ByteBufAllocator) r12, (io.netty.handler.ssl.PemEncoded) r13)     // Catch:{ Error -> 0x029d, all -> 0x0294 }
            long r27 = io.netty.internal.tcnative.SSL.parsePrivateKey(r14, r8)     // Catch:{ Error -> 0x028d, all -> 0x0284 }
            r12 = r18
            r29 = r14
            r14 = r25
            r16 = r27
            io.netty.internal.tcnative.SSL.setKeyMaterial(r12, r14, r16)     // Catch:{ Error -> 0x0281, all -> 0x027d }
            boolean r12 = io.netty.util.internal.SystemPropertyUtil.contains(r2)     // Catch:{ all -> 0x024c }
            if (r0 != 0) goto L_0x024e
            boolean r0 = io.netty.util.internal.SystemPropertyUtil.getBoolean(r2, r1)     // Catch:{ all -> 0x024c }
            if (r12 == 0) goto L_0x025b
            io.netty.util.internal.logging.InternalLogger r2 = logger     // Catch:{ all -> 0x024a }
            java.lang.String r12 = "System property 'io.netty.handler.ssl.openssl.useKeyManagerFactory' is deprecated and so will be ignored in the future"
            r2.info((java.lang.String) r12)     // Catch:{ all -> 0x024a }
            goto L_0x025b
        L_0x024a:
            r2 = r0
            goto L_0x025d
        L_0x024c:
            r2 = r5
            goto L_0x025d
        L_0x024e:
            if (r12 == 0) goto L_0x025a
            io.netty.util.internal.logging.InternalLogger r0 = logger     // Catch:{ all -> 0x0258 }
            java.lang.String r2 = "System property 'io.netty.handler.ssl.openssl.useKeyManagerFactory' is deprecated and will be ignored when using BoringSSL"
            r0.info((java.lang.String) r2)     // Catch:{ all -> 0x0258 }
            goto L_0x025a
        L_0x0258:
            r2 = r1
            goto L_0x025d
        L_0x025a:
            r0 = r1
        L_0x025b:
            r2 = r0
            goto L_0x0264
        L_0x025d:
            io.netty.util.internal.logging.InternalLogger r0 = logger     // Catch:{ Error -> 0x0278, all -> 0x0272 }
            java.lang.String r12 = "Failed to get useKeyManagerFactory system property."
            r0.debug((java.lang.String) r12)     // Catch:{ Error -> 0x0278, all -> 0x0272 }
        L_0x0264:
            r22.release()     // Catch:{ all -> 0x026c }
            r12 = r1
            r14 = r29
            goto L_0x02d5
        L_0x026c:
            r0 = move-exception
            r12 = r1
            r14 = r29
            goto L_0x03c2
        L_0x0272:
            r0 = move-exception
            r12 = r1
        L_0x0274:
            r14 = r29
            goto L_0x03b3
        L_0x0278:
            r12 = r1
        L_0x0279:
            r14 = r29
            goto L_0x02cb
        L_0x027d:
            r0 = move-exception
            r2 = r5
            r12 = r2
            goto L_0x0274
        L_0x0281:
            r2 = r5
            r12 = r2
            goto L_0x0279
        L_0x0284:
            r0 = move-exception
            r29 = r14
            r2 = r5
            r12 = r2
            r27 = r20
            goto L_0x03b3
        L_0x028d:
            r29 = r14
            r2 = r5
            r12 = r2
            r27 = r20
            goto L_0x02cb
        L_0x0294:
            r0 = move-exception
            r2 = r5
            r12 = r2
            r14 = r20
            r27 = r14
            goto L_0x03b3
        L_0x029d:
            r2 = r5
            r12 = r2
            r14 = r20
            r27 = r14
            goto L_0x02cb
        L_0x02a4:
            r0 = move-exception
            r2 = r5
            r12 = r2
            r14 = r20
            r25 = r14
        L_0x02ab:
            r27 = r25
            goto L_0x03b3
        L_0x02af:
            r2 = r5
            r12 = r2
            r14 = r20
            r25 = r14
        L_0x02b5:
            r27 = r25
            goto L_0x02cb
        L_0x02b8:
            r0 = move-exception
            r2 = r5
            r12 = r2
            r14 = r20
            r23 = r14
            r25 = r23
            goto L_0x02ab
        L_0x02c2:
            r2 = r5
            r12 = r2
            r14 = r20
            r23 = r14
            r25 = r23
            goto L_0x02b5
        L_0x02cb:
            io.netty.util.internal.logging.InternalLogger r0 = logger     // Catch:{ all -> 0x03b2 }
            java.lang.String r13 = "KeyManagerFactory not supported."
            r0.debug((java.lang.String) r13)     // Catch:{ all -> 0x03b2 }
            r22.release()     // Catch:{ all -> 0x03b0 }
        L_0x02d5:
            io.netty.internal.tcnative.SSL.freeSSL(r18)     // Catch:{ all -> 0x0345 }
            int r0 = (r23 > r20 ? 1 : (r23 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x02e3
            io.netty.internal.tcnative.SSL.freeBIO(r23)     // Catch:{ all -> 0x02e0 }
            goto L_0x02e3
        L_0x02e0:
            r0 = move-exception
            goto L_0x03ea
        L_0x02e3:
            int r0 = (r14 > r20 ? 1 : (r14 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x02ea
            io.netty.internal.tcnative.SSL.freeBIO(r14)     // Catch:{ all -> 0x02e0 }
        L_0x02ea:
            int r0 = (r25 > r20 ? 1 : (r25 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x02f1
            io.netty.internal.tcnative.SSL.freeX509Chain(r25)     // Catch:{ all -> 0x02e0 }
        L_0x02f1:
            int r0 = (r27 > r20 ? 1 : (r27 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x02f8
            io.netty.internal.tcnative.SSL.freePrivateKey(r27)     // Catch:{ all -> 0x02e0 }
        L_0x02f8:
            java.lang.String r0 = "jdk.tls.namedGroups"
            java.lang.String r0 = io.netty.util.internal.SystemPropertyUtil.get(r0, r8)     // Catch:{ all -> 0x0345 }
            if (r0 == 0) goto L_0x03a3
            java.lang.String r8 = ","
            java.lang.String[] r0 = r0.split(r8)     // Catch:{ all -> 0x0345 }
            java.util.LinkedHashSet r8 = new java.util.LinkedHashSet     // Catch:{ all -> 0x0345 }
            int r13 = r0.length     // Catch:{ all -> 0x0345 }
            r8.<init>(r13)     // Catch:{ all -> 0x0345 }
            java.util.LinkedHashSet r13 = new java.util.LinkedHashSet     // Catch:{ all -> 0x0345 }
            int r14 = r0.length     // Catch:{ all -> 0x0345 }
            r13.<init>(r14)     // Catch:{ all -> 0x0345 }
            java.util.LinkedHashSet r14 = new java.util.LinkedHashSet     // Catch:{ all -> 0x0345 }
            r14.<init>()     // Catch:{ all -> 0x0345 }
            int r15 = r0.length     // Catch:{ all -> 0x0345 }
        L_0x0318:
            if (r5 >= r15) goto L_0x034a
            r1 = r0[r5]     // Catch:{ all -> 0x0345 }
            r18 = r0
            java.lang.String r0 = io.netty.handler.ssl.GroupsConverter.toOpenSsl(r1)     // Catch:{ all -> 0x0345 }
            r22 = r2
            java.lang.String[] r2 = new java.lang.String[]{r0}     // Catch:{ all -> 0x0336 }
            boolean r2 = io.netty.internal.tcnative.SSLContext.setCurvesList(r10, r2)     // Catch:{ all -> 0x0336 }
            if (r2 == 0) goto L_0x033b
            r13.add(r0)     // Catch:{ all -> 0x0336 }
            r8.add(r1)     // Catch:{ all -> 0x0336 }
        L_0x0334:
            r1 = 1
            goto L_0x033f
        L_0x0336:
            r0 = move-exception
        L_0x0337:
            r2 = r22
            goto L_0x03ea
        L_0x033b:
            r14.add(r1)     // Catch:{ all -> 0x0336 }
            goto L_0x0334
        L_0x033f:
            int r5 = r5 + r1
            r0 = r18
            r2 = r22
            goto L_0x0318
        L_0x0345:
            r0 = move-exception
            r22 = r2
            goto L_0x03ea
        L_0x034a:
            r22 = r2
            boolean r0 = r8.isEmpty()     // Catch:{ all -> 0x0336 }
            if (r0 == 0) goto L_0x036d
            io.netty.util.internal.logging.InternalLogger r0 = logger     // Catch:{ all -> 0x036a }
            java.lang.String r1 = "All configured namedGroups are not supported: {}. Use default: {}."
            java.lang.String[] r2 = io.netty.util.internal.EmptyArrays.EMPTY_STRINGS     // Catch:{ all -> 0x036a }
            java.lang.Object[] r2 = r14.toArray(r2)     // Catch:{ all -> 0x036a }
            java.lang.String r2 = java.util.Arrays.toString(r2)     // Catch:{ all -> 0x036a }
            java.lang.String[] r5 = DEFAULT_NAMED_GROUPS     // Catch:{ all -> 0x036a }
            java.lang.String r5 = java.util.Arrays.toString(r5)     // Catch:{ all -> 0x036a }
            r0.info(r1, r2, r5)     // Catch:{ all -> 0x036a }
            goto L_0x03a1
        L_0x036a:
            r0 = move-exception
            r7 = r9
            goto L_0x0337
        L_0x036d:
            java.lang.String[] r0 = io.netty.util.internal.EmptyArrays.EMPTY_STRINGS     // Catch:{ all -> 0x0336 }
            java.lang.Object[] r1 = r8.toArray(r0)     // Catch:{ all -> 0x0336 }
            java.lang.String[] r1 = (java.lang.String[]) r1     // Catch:{ all -> 0x0336 }
            boolean r2 = r14.isEmpty()     // Catch:{ all -> 0x0336 }
            if (r2 == 0) goto L_0x0387
            io.netty.util.internal.logging.InternalLogger r2 = logger     // Catch:{ all -> 0x0336 }
            java.lang.String r5 = "Using configured namedGroups -D 'jdk.tls.namedGroup': {} "
            java.lang.String r1 = java.util.Arrays.toString(r1)     // Catch:{ all -> 0x0336 }
            r2.info((java.lang.String) r5, (java.lang.Object) r1)     // Catch:{ all -> 0x0336 }
            goto L_0x039a
        L_0x0387:
            io.netty.util.internal.logging.InternalLogger r2 = logger     // Catch:{ all -> 0x0336 }
            java.lang.String r5 = "Using supported configured namedGroups: {}. Unsupported namedGroups: {}. "
            java.lang.String r1 = java.util.Arrays.toString(r1)     // Catch:{ all -> 0x0336 }
            java.lang.Object[] r8 = r14.toArray(r0)     // Catch:{ all -> 0x0336 }
            java.lang.String r8 = java.util.Arrays.toString(r8)     // Catch:{ all -> 0x0336 }
            r2.info(r5, r1, r8)     // Catch:{ all -> 0x0336 }
        L_0x039a:
            java.lang.Object[] r0 = r13.toArray(r0)     // Catch:{ all -> 0x0336 }
            r9 = r0
            java.lang.String[] r9 = (java.lang.String[]) r9     // Catch:{ all -> 0x0336 }
        L_0x03a1:
            r7 = r9
            goto L_0x03a6
        L_0x03a3:
            r22 = r2
            goto L_0x03a1
        L_0x03a6:
            io.netty.internal.tcnative.SSLContext.free(r10)     // Catch:{ Exception -> 0x03ac }
            r2 = r22
            goto L_0x03fb
        L_0x03ac:
            r0 = move-exception
            r2 = r22
            goto L_0x03f4
        L_0x03b0:
            r0 = move-exception
            goto L_0x03c2
        L_0x03b2:
            r0 = move-exception
        L_0x03b3:
            r22.release()     // Catch:{ all -> 0x03b0 }
            throw r0     // Catch:{ all -> 0x03b0 }
        L_0x03b7:
            r0 = move-exception
            r14 = r20
            r23 = r14
            r25 = r23
            r27 = r25
            r2 = 0
            r12 = 0
        L_0x03c2:
            io.netty.internal.tcnative.SSL.freeSSL(r18)     // Catch:{ all -> 0x02e0 }
            int r1 = (r23 > r20 ? 1 : (r23 == r20 ? 0 : -1))
            if (r1 == 0) goto L_0x03cc
            io.netty.internal.tcnative.SSL.freeBIO(r23)     // Catch:{ all -> 0x02e0 }
        L_0x03cc:
            int r1 = (r14 > r20 ? 1 : (r14 == r20 ? 0 : -1))
            if (r1 == 0) goto L_0x03d3
            io.netty.internal.tcnative.SSL.freeBIO(r14)     // Catch:{ all -> 0x02e0 }
        L_0x03d3:
            int r1 = (r25 > r20 ? 1 : (r25 == r20 ? 0 : -1))
            if (r1 == 0) goto L_0x03da
            io.netty.internal.tcnative.SSL.freeX509Chain(r25)     // Catch:{ all -> 0x02e0 }
        L_0x03da:
            int r1 = (r27 > r20 ? 1 : (r27 == r20 ? 0 : -1))
            if (r1 == 0) goto L_0x03e1
            io.netty.internal.tcnative.SSL.freePrivateKey(r27)     // Catch:{ all -> 0x02e0 }
        L_0x03e1:
            throw r0     // Catch:{ all -> 0x02e0 }
        L_0x03e2:
            r0 = move-exception
            r2 = 0
        L_0x03e4:
            r12 = 0
            goto L_0x03ea
        L_0x03e6:
            r0 = move-exception
            r2 = 0
            r3 = 0
            goto L_0x03e4
        L_0x03ea:
            io.netty.internal.tcnative.SSLContext.free(r10)     // Catch:{ Exception -> 0x03ee }
            throw r0     // Catch:{ Exception -> 0x03ee }
        L_0x03ee:
            r0 = move-exception
            goto L_0x03f4
        L_0x03f0:
            r0 = move-exception
            r2 = 0
            r3 = 0
            r12 = 0
        L_0x03f4:
            io.netty.util.internal.logging.InternalLogger r1 = logger
            java.lang.String r5 = "Failed to get the list of available OpenSSL cipher suites."
            r1.warn((java.lang.String) r5, (java.lang.Throwable) r0)
        L_0x03fb:
            NAMED_GROUPS = r7
            java.util.Set r0 = java.util.Collections.unmodifiableSet(r6)
            AVAILABLE_OPENSSL_CIPHER_SUITES = r0
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            int r5 = r0.size()
            r6 = 2
            int r5 = r5 * r6
            r1.<init>(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x0412:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x043b
            java.lang.Object r5 = r0.next()
            java.lang.String r5 = (java.lang.String) r5
            boolean r7 = io.netty.handler.ssl.SslUtils.isTLSv13Cipher(r5)
            if (r7 != 0) goto L_0x0437
            java.lang.String r7 = "TLS"
            java.lang.String r7 = io.netty.handler.ssl.CipherSuiteConverter.toJava(r5, r7)
            r1.add(r7)
            java.lang.String r7 = "SSL"
            java.lang.String r5 = io.netty.handler.ssl.CipherSuiteConverter.toJava(r5, r7)
            r1.add(r5)
            goto L_0x0412
        L_0x0437:
            r1.add(r5)
            goto L_0x0412
        L_0x043b:
            java.lang.String[] r0 = io.netty.handler.ssl.SslUtils.DEFAULT_CIPHER_SUITES
            io.netty.handler.ssl.SslUtils.addIfSupported(r1, r4, r0)
            java.lang.String[] r0 = io.netty.handler.ssl.SslUtils.TLSV13_CIPHER_SUITES
            io.netty.handler.ssl.SslUtils.addIfSupported(r1, r4, r0)
            java.lang.String[] r0 = EXTRA_SUPPORTED_TLS_1_3_CIPHERS
            io.netty.handler.ssl.SslUtils.addIfSupported(r1, r4, r0)
            io.netty.handler.ssl.SslUtils.useFallbackCiphersIfDefaultIsEmpty((java.util.List<java.lang.String>) r4, (java.lang.Iterable<java.lang.String>) r1)
            java.util.List r0 = java.util.Collections.unmodifiableList(r4)
            DEFAULT_CIPHERS = r0
            java.util.Set r1 = java.util.Collections.unmodifiableSet(r1)
            AVAILABLE_JAVA_CIPHER_SUITES = r1
            java.util.LinkedHashSet r4 = new java.util.LinkedHashSet
            java.util.Set<java.lang.String> r5 = AVAILABLE_OPENSSL_CIPHER_SUITES
            int r7 = r5.size()
            int r8 = r1.size()
            int r7 = r7 + r8
            r4.<init>(r7)
            r4.addAll(r5)
            r4.addAll(r1)
            AVAILABLE_CIPHER_SUITES = r4
            SUPPORTS_KEYMANAGER_FACTORY = r12
            USE_KEYMANAGER_FACTORY = r2
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r2 = 6
            r1.<init>(r2)
            java.lang.String r2 = "SSLv2Hello"
            r1.add(r2)
            int r2 = io.netty.internal.tcnative.SSL.SSL_OP_NO_SSLv2
            r4 = 1
            boolean r2 = doesSupportProtocol(r4, r2)
            if (r2 == 0) goto L_0x048e
            java.lang.String r2 = "SSLv2"
            r1.add(r2)
        L_0x048e:
            int r2 = io.netty.internal.tcnative.SSL.SSL_OP_NO_SSLv3
            boolean r2 = doesSupportProtocol(r6, r2)
            if (r2 == 0) goto L_0x049b
            java.lang.String r2 = "SSLv3"
            r1.add(r2)
        L_0x049b:
            r2 = 4
            int r4 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1
            boolean r2 = doesSupportProtocol(r2, r4)
            if (r2 == 0) goto L_0x04a9
            java.lang.String r2 = "TLSv1"
            r1.add(r2)
        L_0x04a9:
            r2 = 8
            int r4 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1_1
            boolean r2 = doesSupportProtocol(r2, r4)
            if (r2 == 0) goto L_0x04b8
            java.lang.String r2 = "TLSv1.1"
            r1.add(r2)
        L_0x04b8:
            r2 = 16
            int r4 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1_2
            boolean r2 = doesSupportProtocol(r2, r4)
            if (r2 == 0) goto L_0x04c7
            java.lang.String r2 = "TLSv1.2"
            r1.add(r2)
        L_0x04c7:
            if (r3 == 0) goto L_0x04dc
            r2 = 32
            int r3 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1_3
            boolean r2 = doesSupportProtocol(r2, r3)
            if (r2 == 0) goto L_0x04dc
            java.lang.String r2 = "TLSv1.3"
            r1.add(r2)
            r2 = 1
            TLSV13_SUPPORTED = r2
            goto L_0x04df
        L_0x04dc:
            r2 = 0
            TLSV13_SUPPORTED = r2
        L_0x04df:
            java.util.Set r1 = java.util.Collections.unmodifiableSet(r1)
            SUPPORTED_PROTOCOLS_SET = r1
            boolean r2 = doesSupportOcsp()
            SUPPORTS_OCSP = r2
            io.netty.util.internal.logging.InternalLogger r2 = logger
            boolean r3 = r2.isDebugEnabled()
            if (r3 == 0) goto L_0x0531
            java.lang.String r3 = "Supported protocols (OpenSSL): {} "
            r2.debug((java.lang.String) r3, (java.lang.Object) r1)
            java.lang.String r1 = "Default cipher suites (OpenSSL): {}"
            r2.debug((java.lang.String) r1, (java.lang.Object) r0)
            goto L_0x0531
        L_0x04fe:
            java.util.List r0 = java.util.Collections.emptyList()
            DEFAULT_CIPHERS = r0
            java.util.Set r0 = java.util.Collections.emptySet()
            AVAILABLE_OPENSSL_CIPHER_SUITES = r0
            java.util.Set r0 = java.util.Collections.emptySet()
            AVAILABLE_JAVA_CIPHER_SUITES = r0
            java.util.Set r0 = java.util.Collections.emptySet()
            AVAILABLE_CIPHER_SUITES = r0
            r1 = 0
            SUPPORTS_KEYMANAGER_FACTORY = r1
            USE_KEYMANAGER_FACTORY = r1
            java.util.Set r0 = java.util.Collections.emptySet()
            SUPPORTED_PROTOCOLS_SET = r0
            SUPPORTS_OCSP = r1
            TLSV13_SUPPORTED = r1
            IS_BORINGSSL = r1
            java.lang.String[] r0 = io.netty.util.internal.EmptyArrays.EMPTY_STRINGS
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS = r0
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = r3
            java.lang.String[] r0 = DEFAULT_NAMED_GROUPS
            NAMED_GROUPS = r0
        L_0x0531:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSsl.<clinit>():void");
    }

    private OpenSsl() {
    }

    @Deprecated
    public static Set<String> availableCipherSuites() {
        return availableOpenSslCipherSuites();
    }

    public static Set<String> availableJavaCipherSuites() {
        return AVAILABLE_JAVA_CIPHER_SUITES;
    }

    public static Set<String> availableOpenSslCipherSuites() {
        return AVAILABLE_OPENSSL_CIPHER_SUITES;
    }

    public static String checkTls13Ciphers(InternalLogger internalLogger, String str) {
        boolean z;
        if (IS_BORINGSSL && !str.isEmpty()) {
            String[] strArr = EXTRA_SUPPORTED_TLS_1_3_CIPHERS;
            HashSet hashSet = new HashSet(strArr.length);
            Collections.addAll(hashSet, strArr);
            String[] split = str.split(AccountConstantKt.CODE_SEPARTOR);
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                String str2 = split[i];
                if (!hashSet.isEmpty() && (hashSet.remove(str2) || hashSet.remove(CipherSuiteConverter.toJava(str2, "TLS")))) {
                    i++;
                }
            }
            z = true;
            if ((!hashSet.isEmpty()) || z) {
                if (internalLogger.isInfoEnabled()) {
                    StringBuilder sb = new StringBuilder(128);
                    for (String java : str.split(AccountConstantKt.CODE_SEPARTOR)) {
                        sb.append(CipherSuiteConverter.toJava(java, "TLS"));
                        sb.append(AccountConstantKt.CODE_SEPARTOR);
                    }
                    sb.setLength(sb.length() - 1);
                    internalLogger.info("BoringSSL doesn't allow to enable or disable TLSv1.3 ciphers explicitly. Provided TLSv1.3 ciphers: '{}', default TLSv1.3 ciphers that will be used: '{}'.", sb, EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING);
                }
                return EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING;
            }
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean doesSupportOcsp() {
        /*
            int r0 = version()
            long r0 = (long) r0
            r2 = 268443648(0x10002000, double:1.326287843E-315)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            if (r0 < 0) goto L_0x0036
            r0 = 16
            r2 = 1
            r3 = -1
            long r5 = io.netty.internal.tcnative.SSLContext.make(r0, r2)     // Catch:{ Exception -> 0x002e, all -> 0x0024 }
            io.netty.internal.tcnative.SSLContext.enableOcsp(r5, r1)     // Catch:{ Exception -> 0x002f, all -> 0x0022 }
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0020
            io.netty.internal.tcnative.SSLContext.free(r5)
        L_0x0020:
            r1 = r2
            goto L_0x0036
        L_0x0022:
            r0 = move-exception
            goto L_0x0026
        L_0x0024:
            r0 = move-exception
            r5 = r3
        L_0x0026:
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x002d
            io.netty.internal.tcnative.SSLContext.free(r5)
        L_0x002d:
            throw r0
        L_0x002e:
            r5 = r3
        L_0x002f:
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0036
            io.netty.internal.tcnative.SSLContext.free(r5)
        L_0x0036:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSsl.doesSupportOcsp():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean doesSupportProtocol(int r2, int r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r3 = 2
            long r2 = io.netty.internal.tcnative.SSLContext.make(r2, r3)     // Catch:{ Exception -> 0x0016, all -> 0x0014 }
            r0 = -1
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x0012
            io.netty.internal.tcnative.SSLContext.free(r2)
        L_0x0012:
            r2 = 1
            return r2
        L_0x0014:
            r2 = move-exception
            throw r2
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSsl.doesSupportProtocol(int, int):boolean");
    }

    public static void ensureAvailability() {
        Throwable th = UNAVAILABILITY_CAUSE;
        if (th != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(th));
        }
    }

    private static boolean initializeTcNative(String str) throws Exception {
        return Library.initialize("provided", str);
    }

    @Deprecated
    public static boolean isAlpnSupported() {
        return ((long) version()) >= 268443648;
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static boolean isBoringSSL() {
        return IS_BORINGSSL;
    }

    public static boolean isCipherSuiteAvailable(String str) {
        String openSsl = CipherSuiteConverter.toOpenSsl(str, IS_BORINGSSL);
        if (openSsl != null) {
            str = openSsl;
        }
        return AVAILABLE_OPENSSL_CIPHER_SUITES.contains(str);
    }

    public static boolean isOcspSupported() {
        return SUPPORTS_OCSP;
    }

    public static boolean isSessionCacheSupported() {
        return ((long) version()) >= 269484032;
    }

    public static boolean isTlsv13Supported() {
        return TLSV13_SUPPORTED;
    }

    private static void loadTcNative() throws Exception {
        String normalizedOs = PlatformDependent.normalizedOs();
        String normalizedArch = PlatformDependent.normalizedArch();
        LinkedHashSet linkedHashSet = new LinkedHashSet(5);
        if ("linux".equals(normalizedOs)) {
            for (String str : PlatformDependent.normalizedLinuxClassifiers()) {
                linkedHashSet.add("netty_tcnative" + AccountConstantKt.DEFAULT_SEGMENT + normalizedOs + '_' + normalizedArch + AccountConstantKt.DEFAULT_SEGMENT + str);
            }
            linkedHashSet.add("netty_tcnative" + AccountConstantKt.DEFAULT_SEGMENT + normalizedOs + '_' + normalizedArch);
            linkedHashSet.add("netty_tcnative" + AccountConstantKt.DEFAULT_SEGMENT + normalizedOs + '_' + normalizedArch + "_fedora");
        } else {
            linkedHashSet.add("netty_tcnative" + AccountConstantKt.DEFAULT_SEGMENT + normalizedOs + '_' + normalizedArch);
        }
        linkedHashSet.add("netty_tcnative" + AccountConstantKt.DEFAULT_SEGMENT + normalizedArch);
        linkedHashSet.add("netty_tcnative");
        NativeLibraryLoader.loadFirstAvailable(PlatformDependent.getClassLoader(SSLContext.class), (String[]) linkedHashSet.toArray(new String[0]));
    }

    public static long memoryAddress(ByteBuf byteBuf) {
        return byteBuf.hasMemoryAddress() ? byteBuf.memoryAddress() : Buffer.address(byteBuf.internalNioBuffer(0, byteBuf.readableBytes()));
    }

    public static void releaseIfNeeded(ReferenceCounted referenceCounted) {
        if (referenceCounted.refCnt() > 0) {
            ReferenceCountUtil.safeRelease(referenceCounted);
        }
    }

    public static X509Certificate selfSignedCertificate() throws CertificateException {
        return (X509Certificate) SslContext.X509_CERT_FACTORY.generateCertificate(new ByteArrayInputStream(CERT.getBytes(CharsetUtil.US_ASCII)));
    }

    @Deprecated
    public static boolean supportsHostnameValidation() {
        return isAvailable();
    }

    public static boolean supportsKeyManagerFactory() {
        return SUPPORTS_KEYMANAGER_FACTORY;
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    public static boolean useKeyManagerFactory() {
        return USE_KEYMANAGER_FACTORY;
    }

    public static int version() {
        if (isAvailable()) {
            return SSL.version();
        }
        return -1;
    }

    public static String versionString() {
        if (isAvailable()) {
            return SSL.versionString();
        }
        return null;
    }
}
