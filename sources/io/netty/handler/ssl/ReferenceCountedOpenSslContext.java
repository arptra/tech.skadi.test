package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.util.LazyX509Certificate;
import io.netty.internal.tcnative.AsyncSSLPrivateKeyMethod;
import io.netty.internal.tcnative.CertificateCompressionAlgo;
import io.netty.internal.tcnative.CertificateVerifier;
import io.netty.internal.tcnative.ResultCallback;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SSLPrivateKeyMethod;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateRevokedException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

public abstract class ReferenceCountedOpenSslContext extends SslContext implements ReferenceCounted {
    static final boolean CLIENT_ENABLE_SESSION_CACHE = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.sessionCacheClient", false);
    static final boolean CLIENT_ENABLE_SESSION_TICKET = SystemPropertyUtil.getBoolean("jdk.tls.client.enableSessionTicketExtension", false);
    static final boolean CLIENT_ENABLE_SESSION_TICKET_TLSV13 = SystemPropertyUtil.getBoolean("jdk.tls.client.enableSessionTicketExtension", true);
    private static final int DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE = Math.max(1, SystemPropertyUtil.getInt("io.netty.handler.ssl.openssl.bioNonApplicationBufferSize", 2048));
    private static final Integer DH_KEY_LENGTH;
    static final OpenSslApplicationProtocolNegotiator NONE_PROTOCOL_NEGOTIATOR = new OpenSslApplicationProtocolNegotiator() {
        public ApplicationProtocolConfig.Protocol protocol() {
            return ApplicationProtocolConfig.Protocol.NONE;
        }

        public List<String> protocols() {
            return Collections.emptyList();
        }

        public ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
            return ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT;
        }

        public ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior() {
            return ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
        }
    };
    static final boolean SERVER_ENABLE_SESSION_CACHE = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.sessionCacheServer", true);
    static final boolean SERVER_ENABLE_SESSION_TICKET = SystemPropertyUtil.getBoolean("jdk.tls.server.enableSessionTicketExtension", false);
    static final boolean SERVER_ENABLE_SESSION_TICKET_TLSV13 = SystemPropertyUtil.getBoolean("jdk.tls.server.enableSessionTicketExtension", true);
    static final boolean USE_TASKS = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.useTasks", true);
    protected static final int VERIFY_DEPTH = 10;
    private static final ResourceLeakDetector<ReferenceCountedOpenSslContext> leakDetector;
    /* access modifiers changed from: private */
    public static final InternalLogger logger;
    private final OpenSslApplicationProtocolNegotiator apn;
    private volatile int bioNonApplicationBufferSize = DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE;
    final ClientAuth clientAuth;
    protected long ctx;
    final ReadWriteLock ctxLock = new ReentrantReadWriteLock();
    final boolean enableOcsp;
    final OpenSslEngineMap engineMap = new DefaultOpenSslEngineMap();
    final Certificate[] keyCertChain;
    /* access modifiers changed from: private */
    public final ResourceLeakTracker<ReferenceCountedOpenSslContext> leak;
    private final int mode;
    final String[] protocols;
    private final AbstractReferenceCounted refCnt = new AbstractReferenceCounted() {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public void deallocate() {
            ReferenceCountedOpenSslContext.this.destroy();
            if (ReferenceCountedOpenSslContext.this.leak != null) {
                ReferenceCountedOpenSslContext.this.leak.close(ReferenceCountedOpenSslContext.this);
            }
        }

        public ReferenceCounted touch(Object obj) {
            if (ReferenceCountedOpenSslContext.this.leak != null) {
                ReferenceCountedOpenSslContext.this.leak.record(obj);
            }
            return ReferenceCountedOpenSslContext.this;
        }
    };
    final boolean tlsFalseStart;
    private final List<String> unmodifiableCiphers;

    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslContext$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$OpenSslCertificateCompressionConfig$AlgorithmMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|(2:17|18)|19|(2:21|22)|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|(2:17|18)|19|(2:21|22)|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|18|19|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        static {
            /*
                io.netty.handler.ssl.ApplicationProtocolConfig$SelectedListenerFailureBehavior[] r0 = io.netty.handler.ssl.ApplicationProtocolConfig.SelectedListenerFailureBehavior.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior = r0
                r1 = 1
                io.netty.handler.ssl.ApplicationProtocolConfig$SelectedListenerFailureBehavior r2 = io.netty.handler.ssl.ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.ssl.ApplicationProtocolConfig$SelectedListenerFailureBehavior r3 = io.netty.handler.ssl.ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                io.netty.handler.ssl.ApplicationProtocolConfig$SelectorFailureBehavior[] r2 = io.netty.handler.ssl.ApplicationProtocolConfig.SelectorFailureBehavior.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior = r2
                io.netty.handler.ssl.ApplicationProtocolConfig$SelectorFailureBehavior r3 = io.netty.handler.ssl.ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior     // Catch:{ NoSuchFieldError -> 0x0038 }
                io.netty.handler.ssl.ApplicationProtocolConfig$SelectorFailureBehavior r3 = io.netty.handler.ssl.ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                io.netty.handler.ssl.OpenSslCertificateCompressionConfig$AlgorithmMode[] r2 = io.netty.handler.ssl.OpenSslCertificateCompressionConfig.AlgorithmMode.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$io$netty$handler$ssl$OpenSslCertificateCompressionConfig$AlgorithmMode = r2
                io.netty.handler.ssl.OpenSslCertificateCompressionConfig$AlgorithmMode r3 = io.netty.handler.ssl.OpenSslCertificateCompressionConfig.AlgorithmMode.Decompress     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r2 = $SwitchMap$io$netty$handler$ssl$OpenSslCertificateCompressionConfig$AlgorithmMode     // Catch:{ NoSuchFieldError -> 0x0053 }
                io.netty.handler.ssl.OpenSslCertificateCompressionConfig$AlgorithmMode r3 = io.netty.handler.ssl.OpenSslCertificateCompressionConfig.AlgorithmMode.Compress     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                r2 = 3
                int[] r3 = $SwitchMap$io$netty$handler$ssl$OpenSslCertificateCompressionConfig$AlgorithmMode     // Catch:{ NoSuchFieldError -> 0x005e }
                io.netty.handler.ssl.OpenSslCertificateCompressionConfig$AlgorithmMode r4 = io.netty.handler.ssl.OpenSslCertificateCompressionConfig.AlgorithmMode.Both     // Catch:{ NoSuchFieldError -> 0x005e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                io.netty.handler.ssl.ApplicationProtocolConfig$Protocol[] r3 = io.netty.handler.ssl.ApplicationProtocolConfig.Protocol.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol = r3
                io.netty.handler.ssl.ApplicationProtocolConfig$Protocol r4 = io.netty.handler.ssl.ApplicationProtocolConfig.Protocol.NPN     // Catch:{ NoSuchFieldError -> 0x006f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r1 = $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol     // Catch:{ NoSuchFieldError -> 0x0079 }
                io.netty.handler.ssl.ApplicationProtocolConfig$Protocol r3 = io.netty.handler.ssl.ApplicationProtocolConfig.Protocol.ALPN     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r0 = $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol     // Catch:{ NoSuchFieldError -> 0x0083 }
                io.netty.handler.ssl.ApplicationProtocolConfig$Protocol r1 = io.netty.handler.ssl.ApplicationProtocolConfig.Protocol.NPN_AND_ALPN     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol     // Catch:{ NoSuchFieldError -> 0x008e }
                io.netty.handler.ssl.ApplicationProtocolConfig$Protocol r1 = io.netty.handler.ssl.ApplicationProtocolConfig.Protocol.NONE     // Catch:{ NoSuchFieldError -> 0x008e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008e }
            L_0x008e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslContext.AnonymousClass3.<clinit>():void");
        }
    }

    public static abstract class AbstractCertificateVerifier extends CertificateVerifier {
        private final OpenSslEngineMap engineMap;

        public AbstractCertificateVerifier(OpenSslEngineMap openSslEngineMap) {
            this.engineMap = openSslEngineMap;
        }

        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        private static int translateToError(Throwable th) {
            if (th instanceof CertificateRevokedException) {
                return CertificateVerifier.X509_V_ERR_CERT_REVOKED;
            }
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                if (cause instanceof CertPathValidatorException) {
                    CertPathValidatorException.Reason reason = ((CertPathValidatorException) cause).getReason();
                    if (reason == CertPathValidatorException.BasicReason.EXPIRED) {
                        return CertificateVerifier.X509_V_ERR_CERT_HAS_EXPIRED;
                    }
                    if (reason == CertPathValidatorException.BasicReason.NOT_YET_VALID) {
                        return CertificateVerifier.X509_V_ERR_CERT_NOT_YET_VALID;
                    }
                    if (reason == CertPathValidatorException.BasicReason.REVOKED) {
                        return CertificateVerifier.X509_V_ERR_CERT_REVOKED;
                    }
                }
            }
            return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
        }

        public final int verify(long j, byte[][] bArr, String str) {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j);
            if (referenceCountedOpenSslEngine == null) {
                return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
            }
            try {
                verify(referenceCountedOpenSslEngine, ReferenceCountedOpenSslContext.certificates(bArr), str);
                return CertificateVerifier.X509_V_OK;
            } catch (Throwable th) {
                ReferenceCountedOpenSslContext.logger.debug("verification of certificate failed", (Throwable) th);
                referenceCountedOpenSslEngine.initHandshakeException(th);
                if (th instanceof OpenSslCertificateException) {
                    return th.errorCode();
                }
                if (th instanceof CertificateExpiredException) {
                    return CertificateVerifier.X509_V_ERR_CERT_HAS_EXPIRED;
                }
                if (th instanceof CertificateNotYetValidException) {
                    return CertificateVerifier.X509_V_ERR_CERT_NOT_YET_VALID;
                }
                if (PlatformDependent.javaVersion() >= 7) {
                    return translateToError(th);
                }
                return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
            }
        }

        public abstract void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception;
    }

    public static final class AsyncPrivateKeyMethod implements AsyncSSLPrivateKeyMethod {
        private final OpenSslEngineMap engineMap;
        private final OpenSslAsyncPrivateKeyMethod keyMethod;

        public static final class ResultCallbackListener implements FutureListener<byte[]> {
            private final ReferenceCountedOpenSslEngine engine;
            private final ResultCallback<byte[]> resultCallback;
            private final long ssl;

            public ResultCallbackListener(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, long j, ResultCallback<byte[]> resultCallback2) {
                this.engine = referenceCountedOpenSslEngine;
                this.ssl = j;
                this.resultCallback = resultCallback2;
            }

            public void operationComplete(Future<byte[]> future) {
                Throwable cause = future.cause();
                if (cause == null) {
                    try {
                        this.resultCallback.onSuccess(this.ssl, ReferenceCountedOpenSslContext.verifyResult(future.getNow()));
                        return;
                    } catch (SignatureException e) {
                        cause = e;
                        this.engine.initHandshakeException(cause);
                    }
                }
                this.resultCallback.onError(this.ssl, cause);
            }
        }

        public AsyncPrivateKeyMethod(OpenSslEngineMap openSslEngineMap, OpenSslAsyncPrivateKeyMethod openSslAsyncPrivateKeyMethod) {
            this.engineMap = openSslEngineMap;
            this.keyMethod = openSslAsyncPrivateKeyMethod;
        }

        public void decrypt(long j, byte[] bArr, ResultCallback<byte[]> resultCallback) {
            try {
                ReferenceCountedOpenSslEngine access$400 = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j);
                this.keyMethod.decrypt(access$400, bArr).addListener(new ResultCallbackListener(access$400, j, resultCallback));
            } catch (SSLException e) {
                resultCallback.onError(j, e);
            }
        }

        public void sign(long j, int i, byte[] bArr, ResultCallback<byte[]> resultCallback) {
            try {
                ReferenceCountedOpenSslEngine access$400 = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j);
                this.keyMethod.sign(access$400, i, bArr).addListener(new ResultCallbackListener(access$400, j, resultCallback));
            } catch (SSLException e) {
                resultCallback.onError(j, e);
            }
        }
    }

    public static final class CompressionAlgorithm implements CertificateCompressionAlgo {
        private final OpenSslCertificateCompressionAlgorithm compressionAlgorithm;
        private final OpenSslEngineMap engineMap;

        public CompressionAlgorithm(OpenSslEngineMap openSslEngineMap, OpenSslCertificateCompressionAlgorithm openSslCertificateCompressionAlgorithm) {
            this.engineMap = openSslEngineMap;
            this.compressionAlgorithm = openSslCertificateCompressionAlgorithm;
        }

        public int algorithmId() {
            return this.compressionAlgorithm.algorithmId();
        }

        public byte[] compress(long j, byte[] bArr) throws Exception {
            return this.compressionAlgorithm.compress(ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j), bArr);
        }

        public byte[] decompress(long j, int i, byte[] bArr) throws Exception {
            return this.compressionAlgorithm.decompress(ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j), i, bArr);
        }
    }

    public static final class DefaultOpenSslEngineMap implements OpenSslEngineMap {
        private final Map<Long, ReferenceCountedOpenSslEngine> engines;

        private DefaultOpenSslEngineMap() {
            this.engines = PlatformDependent.newConcurrentHashMap();
        }

        public void add(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine) {
            this.engines.put(Long.valueOf(referenceCountedOpenSslEngine.sslPointer()), referenceCountedOpenSslEngine);
        }

        public ReferenceCountedOpenSslEngine get(long j) {
            return this.engines.get(Long.valueOf(j));
        }

        public ReferenceCountedOpenSslEngine remove(long j) {
            return this.engines.remove(Long.valueOf(j));
        }
    }

    public static final class PrivateKeyMethod implements SSLPrivateKeyMethod {
        private final OpenSslEngineMap engineMap;
        private final OpenSslPrivateKeyMethod keyMethod;

        public PrivateKeyMethod(OpenSslEngineMap openSslEngineMap, OpenSslPrivateKeyMethod openSslPrivateKeyMethod) {
            this.engineMap = openSslEngineMap;
            this.keyMethod = openSslPrivateKeyMethod;
        }

        public byte[] decrypt(long j, byte[] bArr) throws Exception {
            ReferenceCountedOpenSslEngine access$400 = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j);
            try {
                return ReferenceCountedOpenSslContext.verifyResult(this.keyMethod.decrypt(access$400, bArr));
            } catch (Exception e) {
                access$400.initHandshakeException(e);
                throw e;
            }
        }

        public byte[] sign(long j, int i, byte[] bArr) throws Exception {
            ReferenceCountedOpenSslEngine access$400 = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j);
            try {
                return ReferenceCountedOpenSslContext.verifyResult(this.keyMethod.sign(access$400, i, bArr));
            } catch (Exception e) {
                access$400.initHandshakeException(e);
                throw e;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r2 = logger;
        r2.debug("ReferenceCountedOpenSslContext supports -Djdk.tls.ephemeralDHKeySize={int}, but got: " + r1);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x006b */
    static {
        /*
            java.lang.Class<io.netty.handler.ssl.ReferenceCountedOpenSslContext> r0 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.class
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.util.internal.logging.InternalLoggerFactory.getInstance((java.lang.Class<?>) r0)
            logger = r1
            java.lang.String r1 = "io.netty.handler.ssl.openssl.bioNonApplicationBufferSize"
            r2 = 2048(0x800, float:2.87E-42)
            int r1 = io.netty.util.internal.SystemPropertyUtil.getInt(r1, r2)
            r2 = 1
            int r1 = java.lang.Math.max(r2, r1)
            DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE = r1
            java.lang.String r1 = "io.netty.handler.ssl.openssl.useTasks"
            boolean r1 = io.netty.util.internal.SystemPropertyUtil.getBoolean(r1, r2)
            USE_TASKS = r1
            io.netty.util.ResourceLeakDetectorFactory r1 = io.netty.util.ResourceLeakDetectorFactory.instance()
            io.netty.util.ResourceLeakDetector r0 = r1.newResourceLeakDetector(r0)
            leakDetector = r0
            java.lang.String r0 = "jdk.tls.client.enableSessionTicketExtension"
            r1 = 0
            boolean r3 = io.netty.util.internal.SystemPropertyUtil.getBoolean(r0, r1)
            CLIENT_ENABLE_SESSION_TICKET = r3
            boolean r0 = io.netty.util.internal.SystemPropertyUtil.getBoolean(r0, r2)
            CLIENT_ENABLE_SESSION_TICKET_TLSV13 = r0
            java.lang.String r0 = "jdk.tls.server.enableSessionTicketExtension"
            boolean r3 = io.netty.util.internal.SystemPropertyUtil.getBoolean(r0, r1)
            SERVER_ENABLE_SESSION_TICKET = r3
            boolean r0 = io.netty.util.internal.SystemPropertyUtil.getBoolean(r0, r2)
            SERVER_ENABLE_SESSION_TICKET_TLSV13 = r0
            java.lang.String r0 = "io.netty.handler.ssl.openssl.sessionCacheServer"
            boolean r0 = io.netty.util.internal.SystemPropertyUtil.getBoolean(r0, r2)
            SERVER_ENABLE_SESSION_CACHE = r0
            java.lang.String r0 = "io.netty.handler.ssl.openssl.sessionCacheClient"
            boolean r0 = io.netty.util.internal.SystemPropertyUtil.getBoolean(r0, r1)
            CLIENT_ENABLE_SESSION_CACHE = r0
            io.netty.handler.ssl.ReferenceCountedOpenSslContext$2 r0 = new io.netty.handler.ssl.ReferenceCountedOpenSslContext$2
            r0.<init>()
            NONE_PROTOCOL_NEGOTIATOR = r0
            r0 = 0
            java.lang.String r1 = "jdk.tls.ephemeralDHKeySize"
            java.lang.String r1 = io.netty.util.internal.SystemPropertyUtil.get(r1)     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0081
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x006b }
            goto L_0x0081
        L_0x006b:
            io.netty.util.internal.logging.InternalLogger r2 = logger     // Catch:{ all -> 0x0081 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r3.<init>()     // Catch:{ all -> 0x0081 }
            java.lang.String r4 = "ReferenceCountedOpenSslContext supports -Djdk.tls.ephemeralDHKeySize={int}, but got: "
            r3.append(r4)     // Catch:{ all -> 0x0081 }
            r3.append(r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0081 }
            r2.debug((java.lang.String) r1)     // Catch:{ all -> 0x0081 }
        L_0x0081:
            DH_KEY_LENGTH = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslContext.<clinit>():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: java.security.cert.Certificate[]} */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ReferenceCountedOpenSslContext(java.lang.Iterable<java.lang.String> r18, io.netty.handler.ssl.CipherSuiteFilter r19, io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator r20, int r21, java.security.cert.Certificate[] r22, io.netty.handler.ssl.ClientAuth r23, java.lang.String[] r24, boolean r25, boolean r26, boolean r27, java.util.Map.Entry<io.netty.handler.ssl.SslContextOption<?>, java.lang.Object>... r28) throws javax.net.ssl.SSLException {
        /*
            r17 = this;
            r1 = r17
            r0 = r21
            r2 = r26
            r3 = r28
            java.lang.String r4 = ""
            r5 = r25
            r1.<init>(r5)
            io.netty.handler.ssl.ReferenceCountedOpenSslContext$1 r5 = new io.netty.handler.ssl.ReferenceCountedOpenSslContext$1
            r5.<init>()
            r1.refCnt = r5
            io.netty.handler.ssl.ReferenceCountedOpenSslContext$DefaultOpenSslEngineMap r5 = new io.netty.handler.ssl.ReferenceCountedOpenSslContext$DefaultOpenSslEngineMap
            r6 = 0
            r5.<init>()
            r1.engineMap = r5
            java.util.concurrent.locks.ReentrantReadWriteLock r5 = new java.util.concurrent.locks.ReentrantReadWriteLock
            r5.<init>()
            r1.ctxLock = r5
            int r5 = DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE
            r1.bioNonApplicationBufferSize = r5
            io.netty.handler.ssl.OpenSsl.ensureAvailability()
            if (r2 == 0) goto L_0x003d
            boolean r5 = io.netty.handler.ssl.OpenSsl.isOcspSupported()
            if (r5 == 0) goto L_0x0035
            goto L_0x003d
        L_0x0035:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "OCSP is not supported."
            r0.<init>(r1)
            throw r0
        L_0x003d:
            r5 = 1
            if (r0 == r5) goto L_0x004b
            if (r0 != 0) goto L_0x0043
            goto L_0x004b
        L_0x0043:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "mode most be either SSL.SSL_MODE_SERVER or SSL.SSL_MODE_CLIENT"
            r0.<init>(r1)
            throw r0
        L_0x004b:
            boolean r7 = USE_TASKS
            if (r3 == 0) goto L_0x00d1
            int r9 = r3.length
            r12 = r6
            r13 = r12
            r14 = r13
            r10 = 0
            r11 = 0
        L_0x0055:
            if (r10 >= r9) goto L_0x00d5
            r15 = r3[r10]
            java.lang.Object r16 = r15.getKey()
            r6 = r16
            io.netty.handler.ssl.SslContextOption r6 = (io.netty.handler.ssl.SslContextOption) r6
            io.netty.handler.ssl.OpenSslContextOption<java.lang.Boolean> r5 = io.netty.handler.ssl.OpenSslContextOption.TLS_FALSE_START
            if (r6 != r5) goto L_0x0070
            java.lang.Object r5 = r15.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r11 = r5.booleanValue()
            goto L_0x00cc
        L_0x0070:
            io.netty.handler.ssl.OpenSslContextOption<java.lang.Boolean> r5 = io.netty.handler.ssl.OpenSslContextOption.USE_TASKS
            if (r6 != r5) goto L_0x0080
            java.lang.Object r5 = r15.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r7 = r5
            goto L_0x00cc
        L_0x0080:
            io.netty.handler.ssl.OpenSslContextOption<io.netty.handler.ssl.OpenSslPrivateKeyMethod> r5 = io.netty.handler.ssl.OpenSslContextOption.PRIVATE_KEY_METHOD
            if (r6 != r5) goto L_0x008c
            java.lang.Object r5 = r15.getValue()
            r12 = r5
            io.netty.handler.ssl.OpenSslPrivateKeyMethod r12 = (io.netty.handler.ssl.OpenSslPrivateKeyMethod) r12
            goto L_0x00cc
        L_0x008c:
            io.netty.handler.ssl.OpenSslContextOption<io.netty.handler.ssl.OpenSslAsyncPrivateKeyMethod> r5 = io.netty.handler.ssl.OpenSslContextOption.ASYNC_PRIVATE_KEY_METHOD
            if (r6 != r5) goto L_0x0098
            java.lang.Object r5 = r15.getValue()
            r13 = r5
            io.netty.handler.ssl.OpenSslAsyncPrivateKeyMethod r13 = (io.netty.handler.ssl.OpenSslAsyncPrivateKeyMethod) r13
            goto L_0x00cc
        L_0x0098:
            io.netty.handler.ssl.OpenSslContextOption<io.netty.handler.ssl.OpenSslCertificateCompressionConfig> r5 = io.netty.handler.ssl.OpenSslContextOption.CERTIFICATE_COMPRESSION_ALGORITHMS
            if (r6 != r5) goto L_0x00a4
            java.lang.Object r5 = r15.getValue()
            r14 = r5
            io.netty.handler.ssl.OpenSslCertificateCompressionConfig r14 = (io.netty.handler.ssl.OpenSslCertificateCompressionConfig) r14
            goto L_0x00cc
        L_0x00a4:
            io.netty.util.internal.logging.InternalLogger r5 = logger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "Skipping unsupported "
            r6.append(r8)
            java.lang.Class<io.netty.handler.ssl.SslContextOption> r8 = io.netty.handler.ssl.SslContextOption.class
            java.lang.String r8 = r8.getSimpleName()
            r6.append(r8)
            java.lang.String r8 = ": "
            r6.append(r8)
            java.lang.Object r8 = r15.getKey()
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r5.debug((java.lang.String) r6)
        L_0x00cc:
            int r10 = r10 + 1
            r5 = 1
            r6 = 0
            goto L_0x0055
        L_0x00d1:
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x00d5:
            if (r12 == 0) goto L_0x0105
            if (r13 != 0) goto L_0x00da
            goto L_0x0105
        L_0x00da:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "You can either only use "
            r1.append(r2)
            java.lang.Class<io.netty.handler.ssl.OpenSslAsyncPrivateKeyMethod> r2 = io.netty.handler.ssl.OpenSslAsyncPrivateKeyMethod.class
            java.lang.String r2 = r2.getSimpleName()
            r1.append(r2)
            java.lang.String r2 = " or "
            r1.append(r2)
            java.lang.Class<io.netty.handler.ssl.OpenSslPrivateKeyMethod> r2 = io.netty.handler.ssl.OpenSslPrivateKeyMethod.class
            java.lang.String r2 = r2.getSimpleName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0105:
            r1.tlsFalseStart = r11
            if (r27 == 0) goto L_0x0110
            io.netty.util.ResourceLeakDetector<io.netty.handler.ssl.ReferenceCountedOpenSslContext> r3 = leakDetector
            io.netty.util.ResourceLeakTracker r3 = r3.track(r1)
            goto L_0x0111
        L_0x0110:
            r3 = 0
        L_0x0111:
            r1.leak = r3
            r1.mode = r0
            boolean r3 = r17.isServer()
            if (r3 == 0) goto L_0x0126
            java.lang.String r3 = "clientAuth"
            r5 = r23
            java.lang.Object r3 = io.netty.util.internal.ObjectUtil.checkNotNull(r5, r3)
            io.netty.handler.ssl.ClientAuth r3 = (io.netty.handler.ssl.ClientAuth) r3
            goto L_0x0128
        L_0x0126:
            io.netty.handler.ssl.ClientAuth r3 = io.netty.handler.ssl.ClientAuth.NONE
        L_0x0128:
            r1.clientAuth = r3
            r3 = r24
            r1.protocols = r3
            r1.enableOcsp = r2
            if (r22 != 0) goto L_0x0134
            r6 = 0
            goto L_0x013b
        L_0x0134:
            java.lang.Object r3 = r22.clone()
            r6 = r3
            java.security.cert.Certificate[] r6 = (java.security.cert.Certificate[]) r6
        L_0x013b:
            r1.keyCertChain = r6
            java.lang.String r3 = "cipherFilter"
            r5 = r19
            java.lang.Object r3 = io.netty.util.internal.ObjectUtil.checkNotNull(r5, r3)
            io.netty.handler.ssl.CipherSuiteFilter r3 = (io.netty.handler.ssl.CipherSuiteFilter) r3
            java.util.List<java.lang.String> r5 = io.netty.handler.ssl.OpenSsl.DEFAULT_CIPHERS
            java.util.Set r6 = io.netty.handler.ssl.OpenSsl.availableJavaCipherSuites()
            r8 = r18
            java.lang.String[] r3 = r3.filterCipherSuites(r8, r5, r6)
            java.util.LinkedHashSet r5 = new java.util.LinkedHashSet
            int r6 = r3.length
            r5.<init>(r6)
            java.util.Collections.addAll(r5, r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r5)
            r1.unmodifiableCiphers = r3
            java.lang.String r5 = "apn"
            r6 = r20
            java.lang.Object r5 = io.netty.util.internal.ObjectUtil.checkNotNull(r6, r5)
            io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator r5 = (io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator) r5
            r1.apn = r5
            boolean r5 = io.netty.handler.ssl.OpenSsl.isTlsv13Supported()     // Catch:{ all -> 0x019f }
            if (r5 == 0) goto L_0x0178
            r8 = 62
            goto L_0x017a
        L_0x0178:
            r8 = 30
        L_0x017a:
            long r8 = io.netty.internal.tcnative.SSLContext.make(r8, r0)     // Catch:{ Exception -> 0x0301 }
            r1.ctx = r8     // Catch:{ Exception -> 0x0301 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x019f }
            r0.<init>()     // Catch:{ all -> 0x019f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x019f }
            r8.<init>()     // Catch:{ all -> 0x019f }
            boolean r9 = r3.isEmpty()     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
            if (r9 == 0) goto L_0x01a8
            long r8 = r1.ctx     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
            r3 = 0
            io.netty.internal.tcnative.SSLContext.setCipherSuite(r8, r4, r3)     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
            if (r5 == 0) goto L_0x01cb
            long r8 = r1.ctx     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
            r3 = 1
            io.netty.internal.tcnative.SSLContext.setCipherSuite(r8, r4, r3)     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
            goto L_0x01cb
        L_0x019f:
            r0 = move-exception
            goto L_0x030a
        L_0x01a2:
            r0 = move-exception
            goto L_0x02e7
        L_0x01a5:
            r0 = move-exception
            goto L_0x0300
        L_0x01a8:
            boolean r4 = io.netty.handler.ssl.OpenSsl.isBoringSSL()     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
            io.netty.handler.ssl.CipherSuiteConverter.convertToCipherStrings(r3, r0, r8, r4)     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
            long r3 = r1.ctx     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
            java.lang.String r9 = r0.toString()     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
            r10 = 0
            io.netty.internal.tcnative.SSLContext.setCipherSuite(r3, r9, r10)     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
            if (r5 == 0) goto L_0x01cb
            long r3 = r1.ctx     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
            io.netty.util.internal.logging.InternalLogger r5 = logger     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
            java.lang.String r8 = r8.toString()     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
            java.lang.String r5 = io.netty.handler.ssl.OpenSsl.checkTls13Ciphers(r5, r8)     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
            r8 = 1
            io.netty.internal.tcnative.SSLContext.setCipherSuite(r3, r5, r8)     // Catch:{ SSLException -> 0x01a5, Exception -> 0x01a2 }
        L_0x01cb:
            long r3 = r1.ctx     // Catch:{ all -> 0x019f }
            int r3 = io.netty.internal.tcnative.SSLContext.getOptions(r3)     // Catch:{ all -> 0x019f }
            int r4 = io.netty.internal.tcnative.SSL.SSL_OP_NO_SSLv2     // Catch:{ all -> 0x019f }
            r3 = r3 | r4
            int r4 = io.netty.internal.tcnative.SSL.SSL_OP_NO_SSLv3     // Catch:{ all -> 0x019f }
            r3 = r3 | r4
            int r4 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1     // Catch:{ all -> 0x019f }
            r3 = r3 | r4
            int r4 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1_1     // Catch:{ all -> 0x019f }
            r3 = r3 | r4
            int r4 = io.netty.internal.tcnative.SSL.SSL_OP_CIPHER_SERVER_PREFERENCE     // Catch:{ all -> 0x019f }
            r3 = r3 | r4
            int r4 = io.netty.internal.tcnative.SSL.SSL_OP_NO_COMPRESSION     // Catch:{ all -> 0x019f }
            r3 = r3 | r4
            int r4 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TICKET     // Catch:{ all -> 0x019f }
            r3 = r3 | r4
            int r0 = r0.length()     // Catch:{ all -> 0x019f }
            if (r0 != 0) goto L_0x01fb
            int r0 = io.netty.internal.tcnative.SSL.SSL_OP_NO_SSLv2     // Catch:{ all -> 0x019f }
            int r4 = io.netty.internal.tcnative.SSL.SSL_OP_NO_SSLv3     // Catch:{ all -> 0x019f }
            r0 = r0 | r4
            int r4 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1     // Catch:{ all -> 0x019f }
            r0 = r0 | r4
            int r4 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1_1     // Catch:{ all -> 0x019f }
            r0 = r0 | r4
            int r4 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1_2     // Catch:{ all -> 0x019f }
            r0 = r0 | r4
            r3 = r3 | r0
        L_0x01fb:
            long r4 = r1.ctx     // Catch:{ all -> 0x019f }
            io.netty.internal.tcnative.SSLContext.setOptions(r4, r3)     // Catch:{ all -> 0x019f }
            long r3 = r1.ctx     // Catch:{ all -> 0x019f }
            int r0 = io.netty.internal.tcnative.SSLContext.getMode(r3)     // Catch:{ all -> 0x019f }
            int r5 = io.netty.internal.tcnative.SSL.SSL_MODE_ACCEPT_MOVING_WRITE_BUFFER     // Catch:{ all -> 0x019f }
            r0 = r0 | r5
            io.netty.internal.tcnative.SSLContext.setMode(r3, r0)     // Catch:{ all -> 0x019f }
            java.lang.Integer r0 = DH_KEY_LENGTH     // Catch:{ all -> 0x019f }
            if (r0 == 0) goto L_0x0219
            long r3 = r1.ctx     // Catch:{ all -> 0x019f }
            int r0 = r0.intValue()     // Catch:{ all -> 0x019f }
            io.netty.internal.tcnative.SSLContext.setTmpDHLength(r3, r0)     // Catch:{ all -> 0x019f }
        L_0x0219:
            java.util.List r0 = r20.protocols()     // Catch:{ all -> 0x019f }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x019f }
            r4 = 3
            r5 = 2
            if (r3 != 0) goto L_0x0265
            r3 = 0
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ all -> 0x019f }
            java.lang.Object[] r0 = r0.toArray(r3)     // Catch:{ all -> 0x019f }
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ all -> 0x019f }
            io.netty.handler.ssl.ApplicationProtocolConfig$SelectorFailureBehavior r3 = r20.selectorFailureBehavior()     // Catch:{ all -> 0x019f }
            int r3 = opensslSelectorFailureBehavior(r3)     // Catch:{ all -> 0x019f }
            int[] r8 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol     // Catch:{ all -> 0x019f }
            io.netty.handler.ssl.ApplicationProtocolConfig$Protocol r6 = r20.protocol()     // Catch:{ all -> 0x019f }
            int r6 = r6.ordinal()     // Catch:{ all -> 0x019f }
            r6 = r8[r6]     // Catch:{ all -> 0x019f }
            r8 = 1
            if (r6 == r8) goto L_0x0260
            if (r6 == r5) goto L_0x025a
            if (r6 != r4) goto L_0x0254
            long r8 = r1.ctx     // Catch:{ all -> 0x019f }
            io.netty.internal.tcnative.SSLContext.setNpnProtos(r8, r0, r3)     // Catch:{ all -> 0x019f }
            long r8 = r1.ctx     // Catch:{ all -> 0x019f }
            io.netty.internal.tcnative.SSLContext.setAlpnProtos(r8, r0, r3)     // Catch:{ all -> 0x019f }
            goto L_0x0265
        L_0x0254:
            java.lang.Error r0 = new java.lang.Error     // Catch:{ all -> 0x019f }
            r0.<init>()     // Catch:{ all -> 0x019f }
            throw r0     // Catch:{ all -> 0x019f }
        L_0x025a:
            long r8 = r1.ctx     // Catch:{ all -> 0x019f }
            io.netty.internal.tcnative.SSLContext.setAlpnProtos(r8, r0, r3)     // Catch:{ all -> 0x019f }
            goto L_0x0265
        L_0x0260:
            long r8 = r1.ctx     // Catch:{ all -> 0x019f }
            io.netty.internal.tcnative.SSLContext.setNpnProtos(r8, r0, r3)     // Catch:{ all -> 0x019f }
        L_0x0265:
            if (r2 == 0) goto L_0x0270
            long r2 = r1.ctx     // Catch:{ all -> 0x019f }
            boolean r0 = r17.isClient()     // Catch:{ all -> 0x019f }
            io.netty.internal.tcnative.SSLContext.enableOcsp(r2, r0)     // Catch:{ all -> 0x019f }
        L_0x0270:
            long r2 = r1.ctx     // Catch:{ all -> 0x019f }
            io.netty.internal.tcnative.SSLContext.setUseTasks(r2, r7)     // Catch:{ all -> 0x019f }
            if (r12 == 0) goto L_0x0283
            long r2 = r1.ctx     // Catch:{ all -> 0x019f }
            io.netty.handler.ssl.ReferenceCountedOpenSslContext$PrivateKeyMethod r0 = new io.netty.handler.ssl.ReferenceCountedOpenSslContext$PrivateKeyMethod     // Catch:{ all -> 0x019f }
            io.netty.handler.ssl.OpenSslEngineMap r6 = r1.engineMap     // Catch:{ all -> 0x019f }
            r0.<init>(r6, r12)     // Catch:{ all -> 0x019f }
            io.netty.internal.tcnative.SSLContext.setPrivateKeyMethod(r2, r0)     // Catch:{ all -> 0x019f }
        L_0x0283:
            if (r13 == 0) goto L_0x0291
            long r2 = r1.ctx     // Catch:{ all -> 0x019f }
            io.netty.handler.ssl.ReferenceCountedOpenSslContext$AsyncPrivateKeyMethod r0 = new io.netty.handler.ssl.ReferenceCountedOpenSslContext$AsyncPrivateKeyMethod     // Catch:{ all -> 0x019f }
            io.netty.handler.ssl.OpenSslEngineMap r6 = r1.engineMap     // Catch:{ all -> 0x019f }
            r0.<init>(r6, r13)     // Catch:{ all -> 0x019f }
            io.netty.internal.tcnative.SSLContext.setPrivateKeyMethod(r2, r0)     // Catch:{ all -> 0x019f }
        L_0x0291:
            if (r14 == 0) goto L_0x02df
            java.util.Iterator r0 = r14.iterator()     // Catch:{ all -> 0x019f }
        L_0x0297:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x019f }
            if (r2 == 0) goto L_0x02df
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x019f }
            io.netty.handler.ssl.OpenSslCertificateCompressionConfig$AlgorithmConfig r2 = (io.netty.handler.ssl.OpenSslCertificateCompressionConfig.AlgorithmConfig) r2     // Catch:{ all -> 0x019f }
            io.netty.handler.ssl.ReferenceCountedOpenSslContext$CompressionAlgorithm r3 = new io.netty.handler.ssl.ReferenceCountedOpenSslContext$CompressionAlgorithm     // Catch:{ all -> 0x019f }
            io.netty.handler.ssl.OpenSslEngineMap r6 = r1.engineMap     // Catch:{ all -> 0x019f }
            io.netty.handler.ssl.OpenSslCertificateCompressionAlgorithm r7 = r2.algorithm()     // Catch:{ all -> 0x019f }
            r3.<init>(r6, r7)     // Catch:{ all -> 0x019f }
            int[] r6 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.AnonymousClass3.$SwitchMap$io$netty$handler$ssl$OpenSslCertificateCompressionConfig$AlgorithmMode     // Catch:{ all -> 0x019f }
            io.netty.handler.ssl.OpenSslCertificateCompressionConfig$AlgorithmMode r2 = r2.mode()     // Catch:{ all -> 0x019f }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x019f }
            r2 = r6[r2]     // Catch:{ all -> 0x019f }
            r6 = 1
            if (r2 == r6) goto L_0x02d7
            if (r2 == r5) goto L_0x02cf
            if (r2 != r4) goto L_0x02c9
            long r7 = r1.ctx     // Catch:{ all -> 0x019f }
            int r2 = io.netty.internal.tcnative.SSL.SSL_CERT_COMPRESSION_DIRECTION_BOTH     // Catch:{ all -> 0x019f }
            io.netty.internal.tcnative.SSLContext.addCertificateCompressionAlgorithm(r7, r2, r3)     // Catch:{ all -> 0x019f }
            goto L_0x0297
        L_0x02c9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x019f }
            r0.<init>()     // Catch:{ all -> 0x019f }
            throw r0     // Catch:{ all -> 0x019f }
        L_0x02cf:
            long r7 = r1.ctx     // Catch:{ all -> 0x019f }
            int r2 = io.netty.internal.tcnative.SSL.SSL_CERT_COMPRESSION_DIRECTION_COMPRESS     // Catch:{ all -> 0x019f }
            io.netty.internal.tcnative.SSLContext.addCertificateCompressionAlgorithm(r7, r2, r3)     // Catch:{ all -> 0x019f }
            goto L_0x0297
        L_0x02d7:
            long r7 = r1.ctx     // Catch:{ all -> 0x019f }
            int r2 = io.netty.internal.tcnative.SSL.SSL_CERT_COMPRESSION_DIRECTION_DECOMPRESS     // Catch:{ all -> 0x019f }
            io.netty.internal.tcnative.SSLContext.addCertificateCompressionAlgorithm(r7, r2, r3)     // Catch:{ all -> 0x019f }
            goto L_0x0297
        L_0x02df:
            long r2 = r1.ctx     // Catch:{ all -> 0x019f }
            java.lang.String[] r0 = io.netty.handler.ssl.OpenSsl.NAMED_GROUPS     // Catch:{ all -> 0x019f }
            io.netty.internal.tcnative.SSLContext.setCurvesList(r2, r0)     // Catch:{ all -> 0x019f }
            return
        L_0x02e7:
            javax.net.ssl.SSLException r2 = new javax.net.ssl.SSLException     // Catch:{ all -> 0x019f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x019f }
            r3.<init>()     // Catch:{ all -> 0x019f }
            java.lang.String r4 = "failed to set cipher suite: "
            r3.append(r4)     // Catch:{ all -> 0x019f }
            java.util.List<java.lang.String> r4 = r1.unmodifiableCiphers     // Catch:{ all -> 0x019f }
            r3.append(r4)     // Catch:{ all -> 0x019f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x019f }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x019f }
            throw r2     // Catch:{ all -> 0x019f }
        L_0x0300:
            throw r0     // Catch:{ all -> 0x019f }
        L_0x0301:
            r0 = move-exception
            javax.net.ssl.SSLException r2 = new javax.net.ssl.SSLException     // Catch:{ all -> 0x019f }
            java.lang.String r3 = "failed to create an SSL_CTX"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x019f }
            throw r2     // Catch:{ all -> 0x019f }
        L_0x030a:
            r17.release()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslContext.<init>(java.lang.Iterable, io.netty.handler.ssl.CipherSuiteFilter, io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator, int, java.security.cert.Certificate[], io.netty.handler.ssl.ClientAuth, java.lang.String[], boolean, boolean, boolean, java.util.Map$Entry[]):void");
    }

    public static X509Certificate[] certificates(byte[][] bArr) {
        int length = bArr.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        for (int i = 0; i < length; i++) {
            x509CertificateArr[i] = new LazyX509Certificate(bArr[i]);
        }
        return x509CertificateArr;
    }

    public static X509TrustManager chooseTrustManager(TrustManager[] trustManagerArr) {
        for (X509TrustManager x509TrustManager : trustManagerArr) {
            if (x509TrustManager instanceof X509TrustManager) {
                return PlatformDependent.javaVersion() >= 7 ? OpenSslX509TrustManagerWrapper.wrapIfNeeded(x509TrustManager) : x509TrustManager;
            }
        }
        throw new IllegalStateException("no X509TrustManager found");
    }

    public static X509KeyManager chooseX509KeyManager(KeyManager[] keyManagerArr) {
        for (X509KeyManager x509KeyManager : keyManagerArr) {
            if (x509KeyManager instanceof X509KeyManager) {
                return x509KeyManager;
            }
        }
        throw new IllegalStateException("no X509KeyManager found");
    }

    /* access modifiers changed from: private */
    public void destroy() {
        Lock writeLock = this.ctxLock.writeLock();
        writeLock.lock();
        try {
            long j = this.ctx;
            if (j != 0) {
                if (this.enableOcsp) {
                    SSLContext.disableOcsp(j);
                }
                SSLContext.free(this.ctx);
                this.ctx = 0;
                OpenSslSessionContext sessionContext = sessionContext();
                if (sessionContext != null) {
                    sessionContext.destroy();
                }
            }
            writeLock.unlock();
        } catch (Throwable th) {
            writeLock.unlock();
            throw th;
        }
    }

    public static void freeBio(long j) {
        if (j != 0) {
            SSL.freeBIO(j);
        }
    }

    private static long newBIO(ByteBuf byteBuf) throws Exception {
        try {
            long newMemBIO = SSL.newMemBIO();
            int readableBytes = byteBuf.readableBytes();
            if (SSL.bioWrite(newMemBIO, OpenSsl.memoryAddress(byteBuf) + ((long) byteBuf.readerIndex()), readableBytes) == readableBytes) {
                return newMemBIO;
            }
            SSL.freeBIO(newMemBIO);
            throw new IllegalStateException("Could not write data to memory BIO");
        } finally {
            byteBuf.release();
        }
    }

    private static int opensslSelectorFailureBehavior(ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior) {
        int i = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[selectorFailureBehavior.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        throw new Error();
    }

    public static OpenSslKeyMaterialProvider providerFor(KeyManagerFactory keyManagerFactory, String str) {
        return keyManagerFactory instanceof OpenSslX509KeyManagerFactory ? ((OpenSslX509KeyManagerFactory) keyManagerFactory).newProvider() : keyManagerFactory instanceof OpenSslCachingX509KeyManagerFactory ? ((OpenSslCachingX509KeyManagerFactory) keyManagerFactory).newProvider(str) : new OpenSslKeyMaterialProvider(chooseX509KeyManager(keyManagerFactory.getKeyManagers()), str);
    }

    /* access modifiers changed from: private */
    public static ReferenceCountedOpenSslEngine retrieveEngine(OpenSslEngineMap openSslEngineMap, long j) throws SSLException {
        ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = openSslEngineMap.get(j);
        if (referenceCountedOpenSslEngine != null) {
            return referenceCountedOpenSslEngine;
        }
        throw new SSLException("Could not find a " + StringUtil.simpleClassName((Class<?>) ReferenceCountedOpenSslEngine.class) + " for sslPointer " + j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setKeyMaterial(long r16, java.security.cert.X509Certificate[] r18, java.security.PrivateKey r19, java.lang.String r20) throws javax.net.ssl.SSLException {
        /*
            r0 = r19
            r1 = 0
            r3 = 0
            io.netty.buffer.ByteBufAllocator r4 = io.netty.buffer.ByteBufAllocator.DEFAULT     // Catch:{ SSLException -> 0x0086, Exception -> 0x0084, all -> 0x0082 }
            r5 = 1
            r6 = r18
            io.netty.handler.ssl.PemEncoded r3 = io.netty.handler.ssl.PemX509Certificate.toPEM(r4, r5, r6)     // Catch:{ SSLException -> 0x0086, Exception -> 0x0084, all -> 0x0082 }
            io.netty.handler.ssl.PemEncoded r6 = r3.retain()     // Catch:{ SSLException -> 0x007c, Exception -> 0x0076, all -> 0x0070 }
            long r14 = toBIO((io.netty.buffer.ByteBufAllocator) r4, (io.netty.handler.ssl.PemEncoded) r6)     // Catch:{ SSLException -> 0x007c, Exception -> 0x0076, all -> 0x0070 }
            io.netty.handler.ssl.PemEncoded r6 = r3.retain()     // Catch:{ SSLException -> 0x006b, Exception -> 0x0066, all -> 0x0061 }
            long r11 = toBIO((io.netty.buffer.ByteBufAllocator) r4, (io.netty.handler.ssl.PemEncoded) r6)     // Catch:{ SSLException -> 0x006b, Exception -> 0x0066, all -> 0x0061 }
            if (r0 == 0) goto L_0x002e
            long r1 = toBIO((io.netty.buffer.ByteBufAllocator) r4, (java.security.PrivateKey) r0)     // Catch:{ SSLException -> 0x002b, Exception -> 0x0028 }
            goto L_0x002e
        L_0x0025:
            r0 = move-exception
            goto L_0x0091
        L_0x0028:
            r0 = move-exception
            goto L_0x0088
        L_0x002b:
            r0 = move-exception
            goto L_0x0090
        L_0x002e:
            if (r20 != 0) goto L_0x0034
            java.lang.String r0 = ""
            r13 = r0
            goto L_0x0036
        L_0x0034:
            r13 = r20
        L_0x0036:
            r7 = r16
            r9 = r14
            r18 = r3
            r3 = r11
            r11 = r1
            io.netty.internal.tcnative.SSLContext.setCertificateBio(r7, r9, r11, r13)     // Catch:{ SSLException -> 0x005c, Exception -> 0x0057, all -> 0x0052 }
            r6 = r16
            io.netty.internal.tcnative.SSLContext.setCertificateChainBio(r6, r3, r5)     // Catch:{ SSLException -> 0x005c, Exception -> 0x0057, all -> 0x0052 }
            freeBio(r1)
            freeBio(r14)
            freeBio(r3)
            r18.release()
            return
        L_0x0052:
            r0 = move-exception
            r11 = r3
            r3 = r18
            goto L_0x0091
        L_0x0057:
            r0 = move-exception
            r11 = r3
            r3 = r18
            goto L_0x0088
        L_0x005c:
            r0 = move-exception
            r11 = r3
            r3 = r18
            goto L_0x0090
        L_0x0061:
            r0 = move-exception
            r18 = r3
            r11 = r1
            goto L_0x0091
        L_0x0066:
            r0 = move-exception
            r18 = r3
            r11 = r1
            goto L_0x0088
        L_0x006b:
            r0 = move-exception
            r18 = r3
            r11 = r1
            goto L_0x0090
        L_0x0070:
            r0 = move-exception
            r18 = r3
        L_0x0073:
            r11 = r1
            r14 = r11
            goto L_0x0091
        L_0x0076:
            r0 = move-exception
            r18 = r3
        L_0x0079:
            r11 = r1
            r14 = r11
            goto L_0x0088
        L_0x007c:
            r0 = move-exception
            r18 = r3
        L_0x007f:
            r11 = r1
            r14 = r11
            goto L_0x0090
        L_0x0082:
            r0 = move-exception
            goto L_0x0073
        L_0x0084:
            r0 = move-exception
            goto L_0x0079
        L_0x0086:
            r0 = move-exception
            goto L_0x007f
        L_0x0088:
            javax.net.ssl.SSLException r4 = new javax.net.ssl.SSLException     // Catch:{ all -> 0x0025 }
            java.lang.String r5 = "failed to set certificate and key"
            r4.<init>(r5, r0)     // Catch:{ all -> 0x0025 }
            throw r4     // Catch:{ all -> 0x0025 }
        L_0x0090:
            throw r0     // Catch:{ all -> 0x0025 }
        L_0x0091:
            freeBio(r1)
            freeBio(r14)
            freeBio(r11)
            if (r3 == 0) goto L_0x009f
            r3.release()
        L_0x009f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslContext.setKeyMaterial(long, java.security.cert.X509Certificate[], java.security.PrivateKey, java.lang.String):void");
    }

    public static long toBIO(ByteBufAllocator byteBufAllocator, PrivateKey privateKey) throws Exception {
        if (privateKey == null) {
            return 0;
        }
        PemEncoded pem = PemPrivateKey.toPEM(byteBufAllocator, true, privateKey);
        try {
            return toBIO(byteBufAllocator, pem.retain());
        } finally {
            pem.release();
        }
    }

    public static OpenSslApplicationProtocolNegotiator toNegotiator(ApplicationProtocolConfig applicationProtocolConfig) {
        if (applicationProtocolConfig == null) {
            return NONE_PROTOCOL_NEGOTIATOR;
        }
        int i = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[applicationProtocolConfig.protocol().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            int i2 = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[applicationProtocolConfig.selectedListenerFailureBehavior().ordinal()];
            if (i2 == 1 || i2 == 2) {
                int i3 = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[applicationProtocolConfig.selectorFailureBehavior().ordinal()];
                if (i3 == 1 || i3 == 2) {
                    return new OpenSslDefaultApplicationProtocolNegotiator(applicationProtocolConfig);
                }
                throw new UnsupportedOperationException("OpenSSL provider does not support " + applicationProtocolConfig.selectorFailureBehavior() + " behavior");
            }
            throw new UnsupportedOperationException("OpenSSL provider does not support " + applicationProtocolConfig.selectedListenerFailureBehavior() + " behavior");
        } else if (i == 4) {
            return NONE_PROTOCOL_NEGOTIATOR;
        } else {
            throw new Error();
        }
    }

    @SuppressJava6Requirement(reason = "Guarded by java version check")
    public static boolean useExtendedTrustManager(X509TrustManager x509TrustManager) {
        return PlatformDependent.javaVersion() >= 7 && (x509TrustManager instanceof X509ExtendedTrustManager);
    }

    /* access modifiers changed from: private */
    public static byte[] verifyResult(byte[] bArr) throws SignatureException {
        if (bArr != null) {
            return bArr;
        }
        throw new SignatureException();
    }

    public ApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.apn;
    }

    public final List<String> cipherSuites() {
        return this.unmodifiableCiphers;
    }

    @Deprecated
    public final long context() {
        return sslCtxPointer();
    }

    public int getBioNonApplicationBufferSize() {
        return this.bioNonApplicationBufferSize;
    }

    @Deprecated
    public boolean getRejectRemoteInitiatedRenegotiation() {
        return true;
    }

    public final boolean isClient() {
        return this.mode == 0;
    }

    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i) {
        return newEngine0(byteBufAllocator, str, i, true);
    }

    public SSLEngine newEngine0(ByteBufAllocator byteBufAllocator, String str, int i, boolean z) {
        return new ReferenceCountedOpenSslEngine(this, byteBufAllocator, str, i, z, true);
    }

    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z) {
        return new SslHandler(newEngine0(byteBufAllocator, (String) null, -1, false), z);
    }

    public final int refCnt() {
        return this.refCnt.refCnt();
    }

    public final boolean release() {
        return this.refCnt.release();
    }

    public final ReferenceCounted retain() {
        this.refCnt.retain();
        return this;
    }

    public abstract OpenSslSessionContext sessionContext();

    public void setBioNonApplicationBufferSize(int i) {
        this.bioNonApplicationBufferSize = ObjectUtil.checkPositiveOrZero(i, "bioNonApplicationBufferSize");
    }

    @Deprecated
    public final void setPrivateKeyMethod(OpenSslPrivateKeyMethod openSslPrivateKeyMethod) {
        ObjectUtil.checkNotNull(openSslPrivateKeyMethod, "method");
        Lock writeLock = this.ctxLock.writeLock();
        writeLock.lock();
        try {
            SSLContext.setPrivateKeyMethod(this.ctx, new PrivateKeyMethod(this.engineMap, openSslPrivateKeyMethod));
        } finally {
            writeLock.unlock();
        }
    }

    @Deprecated
    public void setRejectRemoteInitiatedRenegotiation(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Renegotiation is not supported");
        }
    }

    @Deprecated
    public final void setTicketKeys(byte[] bArr) {
        sessionContext().setTicketKeys(bArr);
    }

    @Deprecated
    public final void setUseTasks(boolean z) {
        Lock writeLock = this.ctxLock.writeLock();
        writeLock.lock();
        try {
            SSLContext.setUseTasks(this.ctx, z);
        } finally {
            writeLock.unlock();
        }
    }

    @Deprecated
    public final long sslCtxPointer() {
        Lock readLock = this.ctxLock.readLock();
        readLock.lock();
        try {
            return SSLContext.getSslCtx(this.ctx);
        } finally {
            readLock.unlock();
        }
    }

    @Deprecated
    public final OpenSslSessionStats stats() {
        return sessionContext().stats();
    }

    public final ReferenceCounted touch() {
        this.refCnt.touch();
        return this;
    }

    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator) {
        return newEngine(byteBufAllocator, (String) null, -1);
    }

    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i, boolean z) {
        return new SslHandler(newEngine0(byteBufAllocator, str, i, false), z);
    }

    public final boolean release(int i) {
        return this.refCnt.release(i);
    }

    public final ReferenceCounted retain(int i) {
        this.refCnt.retain(i);
        return this;
    }

    public final ReferenceCounted touch(Object obj) {
        this.refCnt.touch(obj);
        return this;
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z, Executor executor) {
        return new SslHandler(newEngine0(byteBufAllocator, (String) null, -1, false), z, executor);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i, boolean z, Executor executor) {
        return new SslHandler(newEngine0(byteBufAllocator, str, i, false), executor);
    }

    public static long toBIO(ByteBufAllocator byteBufAllocator, X509Certificate... x509CertificateArr) throws Exception {
        if (x509CertificateArr == null) {
            return 0;
        }
        ObjectUtil.checkNonEmpty((T[]) x509CertificateArr, "certChain");
        PemEncoded pem = PemX509Certificate.toPEM(byteBufAllocator, true, x509CertificateArr);
        try {
            return toBIO(byteBufAllocator, pem.retain());
        } finally {
            pem.release();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0055, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005e, code lost:
        throw r0;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=io.netty.handler.ssl.PemEncoded, code=io.netty.buffer.ByteBuf, for r4v0, types: [io.netty.handler.ssl.PemEncoded, io.netty.util.ReferenceCounted, io.netty.buffer.ByteBufHolder] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long toBIO(io.netty.buffer.ByteBufAllocator r3, io.netty.buffer.ByteBuf r4) throws java.lang.Exception {
        /*
            io.netty.buffer.ByteBuf r0 = r4.content()     // Catch:{ all -> 0x0016 }
            boolean r1 = r0.isDirect()     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0018
            io.netty.buffer.ByteBuf r3 = r0.retainedSlice()     // Catch:{ all -> 0x0016 }
            long r0 = newBIO(r3)     // Catch:{ all -> 0x0016 }
            r4.release()
            return r0
        L_0x0016:
            r3 = move-exception
            goto L_0x005f
        L_0x0018:
            int r1 = r0.readableBytes()     // Catch:{ all -> 0x0016 }
            io.netty.buffer.ByteBuf r3 = r3.directBuffer(r1)     // Catch:{ all -> 0x0016 }
            int r1 = r0.readerIndex()     // Catch:{ all -> 0x004a }
            int r2 = r0.readableBytes()     // Catch:{ all -> 0x004a }
            r3.writeBytes((io.netty.buffer.ByteBuf) r0, (int) r1, (int) r2)     // Catch:{ all -> 0x004a }
            io.netty.buffer.ByteBuf r0 = r3.retainedSlice()     // Catch:{ all -> 0x004a }
            long r0 = newBIO(r0)     // Catch:{ all -> 0x004a }
            boolean r2 = r4.isSensitive()     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x003f
            io.netty.handler.ssl.SslUtils.zeroout(r3)     // Catch:{ all -> 0x003d }
            goto L_0x003f
        L_0x003d:
            r0 = move-exception
            goto L_0x0046
        L_0x003f:
            r3.release()     // Catch:{ all -> 0x0016 }
            r4.release()
            return r0
        L_0x0046:
            r3.release()     // Catch:{ all -> 0x0016 }
            throw r0     // Catch:{ all -> 0x0016 }
        L_0x004a:
            r0 = move-exception
            boolean r1 = r4.isSensitive()     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x0057
            io.netty.handler.ssl.SslUtils.zeroout(r3)     // Catch:{ all -> 0x0055 }
            goto L_0x0057
        L_0x0055:
            r0 = move-exception
            goto L_0x005b
        L_0x0057:
            r3.release()     // Catch:{ all -> 0x0016 }
            throw r0     // Catch:{ all -> 0x0016 }
        L_0x005b:
            r3.release()     // Catch:{ all -> 0x0016 }
            throw r0     // Catch:{ all -> 0x0016 }
        L_0x005f:
            r4.release()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO(io.netty.buffer.ByteBufAllocator, io.netty.handler.ssl.PemEncoded):long");
    }
}
