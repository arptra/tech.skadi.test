package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManager;

public class JdkSslContext extends SslContext {
    private static final List<String> DEFAULT_CIPHERS;
    private static final List<String> DEFAULT_CIPHERS_NON_TLSV13;
    private static final String[] DEFAULT_PROTOCOLS;
    private static final Provider DEFAULT_PROVIDER;
    static final String PROTOCOL = "TLS";
    private static final Set<String> SUPPORTED_CIPHERS;
    private static final Set<String> SUPPORTED_CIPHERS_NON_TLSV13;
    private static final InternalLogger logger;
    private final JdkApplicationProtocolNegotiator apn;
    private final String[] cipherSuites;
    private final ClientAuth clientAuth;
    private final boolean isClient;
    private final String[] protocols;
    private final SSLContext sslContext;
    private final List<String> unmodifiableCipherSuites;

    /* renamed from: io.netty.handler.ssl.JdkSslContext$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ClientAuth;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|(2:15|16)|17|19|20|21|22|23|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|19|20|21|22|23|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0079 */
        static {
            /*
                io.netty.handler.ssl.ApplicationProtocolConfig$Protocol[] r0 = io.netty.handler.ssl.ApplicationProtocolConfig.Protocol.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol = r0
                r1 = 1
                io.netty.handler.ssl.ApplicationProtocolConfig$Protocol r2 = io.netty.handler.ssl.ApplicationProtocolConfig.Protocol.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.ssl.ApplicationProtocolConfig$Protocol r3 = io.netty.handler.ssl.ApplicationProtocolConfig.Protocol.ALPN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.ssl.ApplicationProtocolConfig$Protocol r4 = io.netty.handler.ssl.ApplicationProtocolConfig.Protocol.NPN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                io.netty.handler.ssl.ApplicationProtocolConfig$SelectedListenerFailureBehavior[] r3 = io.netty.handler.ssl.ApplicationProtocolConfig.SelectedListenerFailureBehavior.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior = r3
                io.netty.handler.ssl.ApplicationProtocolConfig$SelectedListenerFailureBehavior r4 = io.netty.handler.ssl.ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior     // Catch:{ NoSuchFieldError -> 0x0043 }
                io.netty.handler.ssl.ApplicationProtocolConfig$SelectedListenerFailureBehavior r4 = io.netty.handler.ssl.ApplicationProtocolConfig.SelectedListenerFailureBehavior.FATAL_ALERT     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                io.netty.handler.ssl.ApplicationProtocolConfig$SelectorFailureBehavior[] r3 = io.netty.handler.ssl.ApplicationProtocolConfig.SelectorFailureBehavior.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior = r3
                io.netty.handler.ssl.ApplicationProtocolConfig$SelectorFailureBehavior r4 = io.netty.handler.ssl.ApplicationProtocolConfig.SelectorFailureBehavior.FATAL_ALERT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r3 = $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior     // Catch:{ NoSuchFieldError -> 0x005e }
                io.netty.handler.ssl.ApplicationProtocolConfig$SelectorFailureBehavior r4 = io.netty.handler.ssl.ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE     // Catch:{ NoSuchFieldError -> 0x005e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                io.netty.handler.ssl.ClientAuth[] r3 = io.netty.handler.ssl.ClientAuth.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$io$netty$handler$ssl$ClientAuth = r3
                io.netty.handler.ssl.ClientAuth r4 = io.netty.handler.ssl.ClientAuth.OPTIONAL     // Catch:{ NoSuchFieldError -> 0x006f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r1 = $SwitchMap$io$netty$handler$ssl$ClientAuth     // Catch:{ NoSuchFieldError -> 0x0079 }
                io.netty.handler.ssl.ClientAuth r3 = io.netty.handler.ssl.ClientAuth.REQUIRE     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r0 = $SwitchMap$io$netty$handler$ssl$ClientAuth     // Catch:{ NoSuchFieldError -> 0x0083 }
                io.netty.handler.ssl.ClientAuth r1 = io.netty.handler.ssl.ClientAuth.NONE     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.JdkSslContext.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Defaults {
        List<String> defaultCiphers;
        List<String> defaultCiphersNonTLSv13;
        String[] defaultProtocols;
        Provider defaultProvider;
        Set<String> supportedCiphers;
        Set<String> supportedCiphersNonTLSv13;

        private Defaults() {
        }

        public void init() {
            try {
                SSLContext instance = SSLContext.getInstance(JdkSslContext.PROTOCOL);
                instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                this.defaultProvider = instance.getProvider();
                SSLEngine createSSLEngine = instance.createSSLEngine();
                this.defaultProtocols = JdkSslContext.defaultProtocols(instance, createSSLEngine);
                Set<String> unmodifiableSet = Collections.unmodifiableSet(JdkSslContext.supportedCiphers(createSSLEngine));
                this.supportedCiphers = unmodifiableSet;
                this.defaultCiphers = Collections.unmodifiableList(JdkSslContext.defaultCiphers(createSSLEngine, unmodifiableSet));
                ArrayList arrayList = new ArrayList(this.defaultCiphers);
                String[] strArr = SslUtils.DEFAULT_TLSV13_CIPHER_SUITES;
                arrayList.removeAll(Arrays.asList(strArr));
                this.defaultCiphersNonTLSv13 = Collections.unmodifiableList(arrayList);
                LinkedHashSet linkedHashSet = new LinkedHashSet(this.supportedCiphers);
                linkedHashSet.removeAll(Arrays.asList(strArr));
                this.supportedCiphersNonTLSv13 = Collections.unmodifiableSet(linkedHashSet);
            } catch (Exception e) {
                throw new Error("failed to initialize the default SSL context", e);
            }
        }

        public /* synthetic */ Defaults(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        InternalLogger instance = InternalLoggerFactory.getInstance((Class<?>) JdkSslContext.class);
        logger = instance;
        Defaults defaults = new Defaults((AnonymousClass1) null);
        defaults.init();
        DEFAULT_PROVIDER = defaults.defaultProvider;
        String[] strArr = defaults.defaultProtocols;
        DEFAULT_PROTOCOLS = strArr;
        SUPPORTED_CIPHERS = defaults.supportedCiphers;
        List<String> list = defaults.defaultCiphers;
        DEFAULT_CIPHERS = list;
        DEFAULT_CIPHERS_NON_TLSV13 = defaults.defaultCiphersNonTLSv13;
        SUPPORTED_CIPHERS_NON_TLSV13 = defaults.supportedCiphersNonTLSv13;
        if (instance.isDebugEnabled()) {
            instance.debug("Default protocols (JDK): {} ", (Object) Arrays.asList(strArr));
            instance.debug("Default cipher suites (JDK): {}", (Object) list);
        }
    }

    @Deprecated
    public JdkSslContext(SSLContext sSLContext, boolean z, ClientAuth clientAuth2) {
        this(sSLContext, z, (Iterable<String>) null, (CipherSuiteFilter) IdentityCipherSuiteFilter.INSTANCE, (JdkApplicationProtocolNegotiator) JdkDefaultApplicationProtocolNegotiator.INSTANCE, clientAuth2, (String[]) null, false);
    }

    public static KeyManagerFactory buildKeyManagerFactory(File file, File file2, String str, KeyManagerFactory keyManagerFactory, String str2) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, CertificateException, KeyException, IOException {
        String property = Security.getProperty("ssl.KeyManagerFactory.algorithm");
        if (property == null) {
            property = "SunX509";
        }
        return buildKeyManagerFactory(file, property, file2, str, keyManagerFactory, str2);
    }

    private SSLEngine configureAndWrapEngine(SSLEngine sSLEngine, ByteBufAllocator byteBufAllocator) {
        sSLEngine.setEnabledCipherSuites(this.cipherSuites);
        sSLEngine.setEnabledProtocols(this.protocols);
        sSLEngine.setUseClientMode(isClient());
        if (isServer()) {
            int i = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$ClientAuth[this.clientAuth.ordinal()];
            if (i == 1) {
                sSLEngine.setWantClientAuth(true);
            } else if (i == 2) {
                sSLEngine.setNeedClientAuth(true);
            } else if (i != 3) {
                throw new Error("Unknown auth " + this.clientAuth);
            }
        }
        JdkApplicationProtocolNegotiator.SslEngineWrapperFactory wrapperFactory = this.apn.wrapperFactory();
        return wrapperFactory instanceof JdkApplicationProtocolNegotiator.AllocatorAwareSslEngineWrapperFactory ? ((JdkApplicationProtocolNegotiator.AllocatorAwareSslEngineWrapperFactory) wrapperFactory).wrapSslEngine(sSLEngine, byteBufAllocator, this.apn, isServer()) : wrapperFactory.wrapSslEngine(sSLEngine, this.apn, isServer());
    }

    /* access modifiers changed from: private */
    public static List<String> defaultCiphers(SSLEngine sSLEngine, Set<String> set) {
        ArrayList arrayList = new ArrayList();
        SslUtils.addIfSupported(set, arrayList, SslUtils.DEFAULT_CIPHER_SUITES);
        SslUtils.useFallbackCiphersIfDefaultIsEmpty((List<String>) arrayList, sSLEngine.getEnabledCipherSuites());
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static String[] defaultProtocols(SSLContext sSLContext, SSLEngine sSLEngine) {
        String[] protocols2 = sSLContext.getDefaultSSLParameters().getProtocols();
        HashSet hashSet = new HashSet(protocols2.length);
        Collections.addAll(hashSet, protocols2);
        ArrayList arrayList = new ArrayList();
        SslUtils.addIfSupported(hashSet, arrayList, SslProtocols.TLS_v1_3, SslProtocols.TLS_v1_2, SslProtocols.TLS_v1_1, SslProtocols.TLS_v1);
        return !arrayList.isEmpty() ? (String[]) arrayList.toArray(EmptyArrays.EMPTY_STRINGS) : sSLEngine.getEnabledProtocols();
    }

    private static boolean isTlsV13Supported(String[] strArr) {
        for (String equals : strArr) {
            if (SslProtocols.TLS_v1_3.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static Set<String> supportedCiphers(SSLEngine sSLEngine) {
        String[] supportedCipherSuites = sSLEngine.getSupportedCipherSuites();
        LinkedHashSet linkedHashSet = new LinkedHashSet(supportedCipherSuites.length);
        for (String str : supportedCipherSuites) {
            linkedHashSet.add(str);
            if (str.startsWith("SSL_")) {
                String str2 = "TLS_" + str.substring(4);
                try {
                    sSLEngine.setEnabledCipherSuites(new String[]{str2});
                    linkedHashSet.add(str2);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return linkedHashSet;
    }

    public static JdkApplicationProtocolNegotiator toNegotiator(ApplicationProtocolConfig applicationProtocolConfig, boolean z) {
        if (applicationProtocolConfig == null) {
            return JdkDefaultApplicationProtocolNegotiator.INSTANCE;
        }
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[applicationProtocolConfig.protocol().ordinal()];
        if (i == 1) {
            return JdkDefaultApplicationProtocolNegotiator.INSTANCE;
        }
        if (i != 2) {
            if (i != 3) {
                throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.protocol() + " protocol");
            } else if (z) {
                int i2 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[applicationProtocolConfig.selectedListenerFailureBehavior().ordinal()];
                if (i2 == 1) {
                    return new JdkNpnApplicationProtocolNegotiator(false, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
                }
                if (i2 == 2) {
                    return new JdkNpnApplicationProtocolNegotiator(true, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
                }
                throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.selectedListenerFailureBehavior() + " failure behavior");
            } else {
                int i3 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[applicationProtocolConfig.selectorFailureBehavior().ordinal()];
                if (i3 == 1) {
                    return new JdkNpnApplicationProtocolNegotiator(true, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
                }
                if (i3 == 2) {
                    return new JdkNpnApplicationProtocolNegotiator(false, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
                }
                throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.selectorFailureBehavior() + " failure behavior");
            }
        } else if (z) {
            int i4 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[applicationProtocolConfig.selectorFailureBehavior().ordinal()];
            if (i4 == 1) {
                return new JdkAlpnApplicationProtocolNegotiator(true, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
            }
            if (i4 == 2) {
                return new JdkAlpnApplicationProtocolNegotiator(false, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
            }
            throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.selectorFailureBehavior() + " failure behavior");
        } else {
            int i5 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[applicationProtocolConfig.selectedListenerFailureBehavior().ordinal()];
            if (i5 == 1) {
                return new JdkAlpnApplicationProtocolNegotiator(false, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
            }
            if (i5 == 2) {
                return new JdkAlpnApplicationProtocolNegotiator(true, (Iterable<String>) applicationProtocolConfig.supportedProtocols());
            }
            throw new UnsupportedOperationException("JDK provider does not support " + applicationProtocolConfig.selectedListenerFailureBehavior() + " failure behavior");
        }
    }

    public final List<String> cipherSuites() {
        return this.unmodifiableCipherSuites;
    }

    public final SSLContext context() {
        return this.sslContext;
    }

    public final boolean isClient() {
        return this.isClient;
    }

    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator) {
        return configureAndWrapEngine(context().createSSLEngine(), byteBufAllocator);
    }

    public final SSLSessionContext sessionContext() {
        return isServer() ? context().getServerSessionContext() : context().getClientSessionContext();
    }

    @Deprecated
    public JdkSslContext(SSLContext sSLContext, boolean z, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, ClientAuth clientAuth2) {
        this(sSLContext, z, iterable, cipherSuiteFilter, applicationProtocolConfig, clientAuth2, (String[]) null, false);
    }

    public final JdkApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.apn;
    }

    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i) {
        return configureAndWrapEngine(context().createSSLEngine(str, i), byteBufAllocator);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JdkSslContext(javax.net.ssl.SSLContext r10, boolean r11, java.lang.Iterable<java.lang.String> r12, io.netty.handler.ssl.CipherSuiteFilter r13, io.netty.handler.ssl.ApplicationProtocolConfig r14, io.netty.handler.ssl.ClientAuth r15, java.lang.String[] r16, boolean r17) {
        /*
            r9 = this;
            r0 = r11 ^ 1
            r1 = r14
            io.netty.handler.ssl.JdkApplicationProtocolNegotiator r5 = toNegotiator(r14, r0)
            if (r16 != 0) goto L_0x000c
            r0 = 0
        L_0x000a:
            r7 = r0
            goto L_0x0013
        L_0x000c:
            java.lang.Object r0 = r16.clone()
            java.lang.String[] r0 = (java.lang.String[]) r0
            goto L_0x000a
        L_0x0013:
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r6 = r15
            r8 = r17
            r0.<init>((javax.net.ssl.SSLContext) r1, (boolean) r2, (java.lang.Iterable<java.lang.String>) r3, (io.netty.handler.ssl.CipherSuiteFilter) r4, (io.netty.handler.ssl.JdkApplicationProtocolNegotiator) r5, (io.netty.handler.ssl.ClientAuth) r6, (java.lang.String[]) r7, (boolean) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.JdkSslContext.<init>(javax.net.ssl.SSLContext, boolean, java.lang.Iterable, io.netty.handler.ssl.CipherSuiteFilter, io.netty.handler.ssl.ApplicationProtocolConfig, io.netty.handler.ssl.ClientAuth, java.lang.String[], boolean):void");
    }

    @Deprecated
    public static KeyManagerFactory buildKeyManagerFactory(File file, File file2, String str, KeyManagerFactory keyManagerFactory) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, CertificateException, KeyException, IOException {
        return buildKeyManagerFactory(file, file2, str, keyManagerFactory, KeyStore.getDefaultType());
    }

    public static KeyManagerFactory buildKeyManagerFactory(File file, String str, File file2, String str2, KeyManagerFactory keyManagerFactory, String str3) throws KeyStoreException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, IOException, CertificateException, KeyException, UnrecoverableKeyException {
        return SslContext.buildKeyManagerFactory(SslContext.toX509Certificates(file), str, SslContext.toPrivateKey(file2, str2), str2, keyManagerFactory, str3);
    }

    public JdkSslContext(SSLContext sSLContext, boolean z, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, ClientAuth clientAuth2, String[] strArr, boolean z2) {
        super(z2);
        List<String> list;
        Set<String> set;
        this.apn = (JdkApplicationProtocolNegotiator) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator, "apn");
        this.clientAuth = (ClientAuth) ObjectUtil.checkNotNull(clientAuth2, "clientAuth");
        this.sslContext = (SSLContext) ObjectUtil.checkNotNull(sSLContext, "sslContext");
        if (DEFAULT_PROVIDER.equals(sSLContext.getProvider())) {
            strArr = strArr == null ? DEFAULT_PROTOCOLS : strArr;
            this.protocols = strArr;
            if (isTlsV13Supported(strArr)) {
                set = SUPPORTED_CIPHERS;
                list = DEFAULT_CIPHERS;
            } else {
                set = SUPPORTED_CIPHERS_NON_TLSV13;
                list = DEFAULT_CIPHERS_NON_TLSV13;
            }
        } else {
            SSLEngine createSSLEngine = sSLContext.createSSLEngine();
            if (strArr == null) {
                try {
                    this.protocols = defaultProtocols(sSLContext, createSSLEngine);
                } catch (Throwable th) {
                    ReferenceCountUtil.release(createSSLEngine);
                    throw th;
                }
            } else {
                this.protocols = strArr;
            }
            set = supportedCiphers(createSSLEngine);
            List<String> defaultCiphers = defaultCiphers(createSSLEngine, set);
            if (!isTlsV13Supported(this.protocols)) {
                for (String str : SslUtils.DEFAULT_TLSV13_CIPHER_SUITES) {
                    set.remove(str);
                    defaultCiphers.remove(str);
                }
            }
            ReferenceCountUtil.release(createSSLEngine);
            list = defaultCiphers;
        }
        String[] filterCipherSuites = ((CipherSuiteFilter) ObjectUtil.checkNotNull(cipherSuiteFilter, "cipherFilter")).filterCipherSuites(iterable, list, set);
        this.cipherSuites = filterCipherSuites;
        this.unmodifiableCipherSuites = Collections.unmodifiableList(Arrays.asList(filterCipherSuites));
        this.isClient = z;
    }

    @Deprecated
    public static KeyManagerFactory buildKeyManagerFactory(File file, String str, File file2, String str2, KeyManagerFactory keyManagerFactory) throws KeyStoreException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidAlgorithmParameterException, IOException, CertificateException, KeyException, UnrecoverableKeyException {
        return SslContext.buildKeyManagerFactory(SslContext.toX509Certificates(file), str, SslContext.toPrivateKey(file2, str2), str2, keyManagerFactory, KeyStore.getDefaultType());
    }
}
