package io.netty.handler.ssl;

import com.honey.account.constant.AccountConstantKt;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.util.LazyJavaxX509Certificate;
import io.netty.handler.ssl.util.LazyX509Certificate;
import io.netty.internal.tcnative.AsyncTask;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.security.cert.X509Certificate;

public class ReferenceCountedOpenSslEngine extends SSLEngine implements ReferenceCounted, ApplicationProtocolAccessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING;
    static final int MAX_PLAINTEXT_LENGTH = SSL.SSL_MAX_PLAINTEXT_LENGTH;
    static final int MAX_RECORD_SIZE = SSL.SSL_MAX_RECORD_LENGTH;
    private static final SSLEngineResult NEED_UNWRAP_CLOSED;
    private static final SSLEngineResult NEED_UNWRAP_OK;
    private static final SSLEngineResult NEED_WRAP_CLOSED;
    private static final SSLEngineResult NEED_WRAP_OK;
    private static final int[] OPENSSL_OP_NO_PROTOCOLS = {SSL.SSL_OP_NO_SSLv2, SSL.SSL_OP_NO_SSLv3, SSL.SSL_OP_NO_TLSv1, SSL.SSL_OP_NO_TLSv1_1, SSL.SSL_OP_NO_TLSv1_2, SSL.SSL_OP_NO_TLSv1_3};
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV2 = 0;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV3 = 1;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1 = 2;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_1 = 3;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_2 = 4;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_3 = 5;
    private static final ResourceLeakDetector<ReferenceCountedOpenSslEngine> leakDetector;
    private static final InternalLogger logger;
    private Object algorithmConstraints;
    final ByteBufAllocator alloc;
    private final OpenSslApplicationProtocolNegotiator apn;
    private volatile String applicationProtocol;
    private volatile ClientAuth clientAuth;
    /* access modifiers changed from: private */
    public final boolean clientMode;
    private volatile boolean destroyed;
    /* access modifiers changed from: private */
    public final boolean enableOcsp;
    private String endPointIdentificationAlgorithm;
    private final OpenSslEngineMap engineMap;
    private String[] explicitlyEnabledProtocols;
    /* access modifiers changed from: private */
    public HandshakeState handshakeState = HandshakeState.NOT_STARTED;
    private boolean isInboundDone;
    final boolean jdkCompatibilityMode;
    /* access modifiers changed from: private */
    public volatile long lastAccessed;
    /* access modifiers changed from: private */
    public final ResourceLeakTracker<ReferenceCountedOpenSslEngine> leak;
    private volatile Collection<?> matchers;
    private int maxWrapBufferSize;
    private int maxWrapOverhead;
    private volatile boolean needTask;
    private long networkBIO;
    private boolean outboundClosed;
    /* access modifiers changed from: private */
    public final ReferenceCountedOpenSslContext parentContext;
    private Throwable pendingException;
    private boolean receivedShutdown;
    private final AbstractReferenceCounted refCnt = new AbstractReferenceCounted() {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public void deallocate() {
            ReferenceCountedOpenSslEngine.this.shutdown();
            if (ReferenceCountedOpenSslEngine.this.leak != null) {
                ReferenceCountedOpenSslEngine.this.leak.close(ReferenceCountedOpenSslEngine.this);
            }
            ReferenceCountedOpenSslEngine.this.parentContext.release();
        }

        public ReferenceCounted touch(Object obj) {
            if (ReferenceCountedOpenSslEngine.this.leak != null) {
                ReferenceCountedOpenSslEngine.this.leak.record(obj);
            }
            return ReferenceCountedOpenSslEngine.this;
        }
    };
    /* access modifiers changed from: private */
    public final OpenSslSession session;
    private boolean sessionSet;
    private final ByteBuffer[] singleDstBuffer;
    private final ByteBuffer[] singleSrcBuffer;
    /* access modifiers changed from: private */
    public List<String> sniHostNames;
    /* access modifiers changed from: private */
    public long ssl;

    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslEngine$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ClientAuth;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007d */
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
                r3 = 4
                int[] r4 = $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.ssl.ApplicationProtocolConfig$Protocol r5 = io.netty.handler.ssl.ApplicationProtocolConfig.Protocol.NPN_AND_ALPN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                io.netty.handler.ssl.ClientAuth[] r4 = io.netty.handler.ssl.ClientAuth.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$io$netty$handler$ssl$ClientAuth = r4
                io.netty.handler.ssl.ClientAuth r5 = io.netty.handler.ssl.ClientAuth.NONE     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r4 = $SwitchMap$io$netty$handler$ssl$ClientAuth     // Catch:{ NoSuchFieldError -> 0x004e }
                io.netty.handler.ssl.ClientAuth r5 = io.netty.handler.ssl.ClientAuth.REQUIRE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r4 = $SwitchMap$io$netty$handler$ssl$ClientAuth     // Catch:{ NoSuchFieldError -> 0x0058 }
                io.netty.handler.ssl.ClientAuth r5 = io.netty.handler.ssl.ClientAuth.OPTIONAL     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState[] r4 = io.netty.handler.ssl.ReferenceCountedOpenSslEngine.HandshakeState.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState = r4
                io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r5 = io.netty.handler.ssl.ReferenceCountedOpenSslEngine.HandshakeState.NOT_STARTED     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r1 = $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState     // Catch:{ NoSuchFieldError -> 0x0073 }
                io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r4 = io.netty.handler.ssl.ReferenceCountedOpenSslEngine.HandshakeState.FINISHED     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                int[] r0 = $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState     // Catch:{ NoSuchFieldError -> 0x007d }
                io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r1 = io.netty.handler.ssl.ReferenceCountedOpenSslEngine.HandshakeState.STARTED_IMPLICITLY     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r0 = $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState     // Catch:{ NoSuchFieldError -> 0x0087 }
                io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r1 = io.netty.handler.ssl.ReferenceCountedOpenSslEngine.HandshakeState.STARTED_EXPLICITLY     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.AnonymousClass3.<clinit>():void");
        }
    }

    public final class AsyncTaskDecorator extends TaskDecorator<AsyncTask> implements AsyncRunnable {
        public AsyncTaskDecorator(AsyncTask asyncTask) {
            super(asyncTask);
        }

        public void run(Runnable runnable) {
            if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                ((AsyncTask) this.task).runAsync(new TaskDecorator(runnable));
            }
        }
    }

    public final class DefaultOpenSslSession implements OpenSslSession {
        private volatile int applicationBufferSize = ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH;
        private String cipher;
        private volatile long creationTime;
        private OpenSslSessionId id = OpenSslSessionId.NULL_ID;
        private volatile Certificate[] localCertificateChain;
        private Certificate[] peerCerts;
        private String protocol;
        private final OpenSslSessionContext sessionContext;
        private boolean valid = true;
        private Map<String, Object> values;
        private X509Certificate[] x509PeerCerts;

        public DefaultOpenSslSession(OpenSslSessionContext openSslSessionContext) {
            this.sessionContext = openSslSessionContext;
        }

        private void initCerts(byte[][] bArr, int i) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i3 = i + i2;
                this.peerCerts[i3] = new LazyX509Certificate(bArr[i2]);
                this.x509PeerCerts[i3] = new LazyJavaxX509Certificate(bArr[i2]);
            }
        }

        private SSLSessionBindingEvent newSSLSessionBindingEvent(String str) {
            return new SSLSessionBindingEvent(ReferenceCountedOpenSslEngine.this.session, str);
        }

        private void notifyUnbound(Object obj, String str) {
            if (obj instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) obj).valueUnbound(newSSLSessionBindingEvent(str));
            }
        }

        public int getApplicationBufferSize() {
            return this.applicationBufferSize;
        }

        public String getCipherSuite() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    String str = this.cipher;
                    return str == null ? "SSL_NULL_WITH_NULL_NULL" : str;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public long getCreationTime() {
            long j;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                j = this.creationTime;
            }
            return j;
        }

        public byte[] getId() {
            return sessionId().cloneBytes();
        }

        public long getLastAccessedTime() {
            long access$900 = ReferenceCountedOpenSslEngine.this.lastAccessed;
            return access$900 == -1 ? getCreationTime() : access$900;
        }

        public Certificate[] getLocalCertificates() {
            Certificate[] certificateArr = this.localCertificateChain;
            if (certificateArr == null) {
                return null;
            }
            return (Certificate[]) certificateArr.clone();
        }

        public Principal getLocalPrincipal() {
            Certificate[] certificateArr = this.localCertificateChain;
            if (certificateArr == null || certificateArr.length == 0) {
                return null;
            }
            return ((java.security.cert.X509Certificate) certificateArr[0]).getSubjectX500Principal();
        }

        public int getPacketBufferSize() {
            return ReferenceCountedOpenSslEngine.this.maxEncryptedPacketLength();
        }

        public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
            X509Certificate[] x509CertificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (!ReferenceCountedOpenSslEngine.isEmpty((Object[]) this.x509PeerCerts)) {
                        x509CertificateArr = (X509Certificate[]) this.x509PeerCerts.clone();
                    } else {
                        throw new SSLPeerUnverifiedException("peer not verified");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return x509CertificateArr;
        }

        public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
            Certificate[] certificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (!ReferenceCountedOpenSslEngine.isEmpty((Object[]) this.peerCerts)) {
                        certificateArr = (Certificate[]) this.peerCerts.clone();
                    } else {
                        throw new SSLPeerUnverifiedException("peer not verified");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return certificateArr;
        }

        public String getPeerHost() {
            return ReferenceCountedOpenSslEngine.this.getPeerHost();
        }

        public int getPeerPort() {
            return ReferenceCountedOpenSslEngine.this.getPeerPort();
        }

        public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
            return ((java.security.cert.X509Certificate) getPeerCertificates()[0]).getSubjectX500Principal();
        }

        public String getProtocol() {
            String str = this.protocol;
            if (str == null) {
                synchronized (ReferenceCountedOpenSslEngine.this) {
                    try {
                        str = !ReferenceCountedOpenSslEngine.this.isDestroyed() ? SSL.getVersion(ReferenceCountedOpenSslEngine.this.ssl) : "";
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return str;
        }

        public Object getValue(String str) {
            ObjectUtil.checkNotNull(str, "name");
            synchronized (this) {
                try {
                    Map<String, Object> map = this.values;
                    if (map == null) {
                        return null;
                    }
                    Object obj = map.get(str);
                    return obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public String[] getValueNames() {
            synchronized (this) {
                try {
                    Map<String, Object> map = this.values;
                    if (map != null) {
                        if (!map.isEmpty()) {
                            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                            return strArr;
                        }
                    }
                    String[] strArr2 = EmptyArrays.EMPTY_STRINGS;
                    return strArr2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void handshakeFinished(byte[] bArr, String str, String str2, byte[] bArr2, byte[][] bArr3, long j, long j2) throws SSLException {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                        this.creationTime = j;
                        OpenSslSessionId openSslSessionId = this.id;
                        OpenSslSessionId openSslSessionId2 = OpenSslSessionId.NULL_ID;
                        if (openSslSessionId == openSslSessionId2) {
                            if (bArr != null) {
                                openSslSessionId2 = new OpenSslSessionId(bArr);
                            }
                            this.id = openSslSessionId2;
                        }
                        this.cipher = ReferenceCountedOpenSslEngine.this.toJavaCipherSuite(str);
                        this.protocol = str2;
                        if (ReferenceCountedOpenSslEngine.this.clientMode) {
                            if (ReferenceCountedOpenSslEngine.isEmpty((Object[]) bArr3)) {
                                this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                                this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
                            } else {
                                this.peerCerts = new Certificate[bArr3.length];
                                this.x509PeerCerts = new X509Certificate[bArr3.length];
                                initCerts(bArr3, 0);
                            }
                        } else if (ReferenceCountedOpenSslEngine.isEmpty(bArr2)) {
                            this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                            this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
                        } else if (ReferenceCountedOpenSslEngine.isEmpty((Object[]) bArr3)) {
                            this.peerCerts = new Certificate[]{new LazyX509Certificate(bArr2)};
                            this.x509PeerCerts = new X509Certificate[]{new LazyJavaxX509Certificate(bArr2)};
                        } else {
                            Certificate[] certificateArr = new Certificate[(bArr3.length + 1)];
                            this.peerCerts = certificateArr;
                            this.x509PeerCerts = new X509Certificate[(bArr3.length + 1)];
                            certificateArr[0] = new LazyX509Certificate(bArr2);
                            this.x509PeerCerts[0] = new LazyJavaxX509Certificate(bArr2);
                            initCerts(bArr3, 1);
                        }
                        ReferenceCountedOpenSslEngine.this.calculateMaxWrapOverhead();
                        HandshakeState unused = ReferenceCountedOpenSslEngine.this.handshakeState = HandshakeState.FINISHED;
                    } else {
                        throw new SSLException("Already closed");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void invalidate() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                this.valid = false;
                this.sessionContext.removeFromCache(this.id);
            }
        }

        public boolean isValid() {
            boolean z;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (!this.valid) {
                        if (!this.sessionContext.isInCache(this.id)) {
                            z = false;
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }

        public void putValue(String str, Object obj) {
            Object put;
            ObjectUtil.checkNotNull(str, "name");
            ObjectUtil.checkNotNull(obj, AccountConstantKt.RESPONSE_VALUE);
            synchronized (this) {
                try {
                    Map map = this.values;
                    if (map == null) {
                        map = new HashMap(2);
                        this.values = map;
                    }
                    put = map.put(str, obj);
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (obj instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) obj).valueBound(newSSLSessionBindingEvent(str));
            }
            notifyUnbound(put, str);
        }

        public void removeValue(String str) {
            ObjectUtil.checkNotNull(str, "name");
            synchronized (this) {
                try {
                    Map<String, Object> map = this.values;
                    if (map != null) {
                        Object remove = map.remove(str);
                        notifyUnbound(remove, str);
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public OpenSslSessionId sessionId() {
            OpenSslSessionId openSslSessionId;
            byte[] sessionId;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (this.id == OpenSslSessionId.NULL_ID && !ReferenceCountedOpenSslEngine.this.isDestroyed() && (sessionId = SSL.getSessionId(ReferenceCountedOpenSslEngine.this.ssl)) != null) {
                        this.id = new OpenSslSessionId(sessionId);
                    }
                    openSslSessionId = this.id;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return openSslSessionId;
        }

        public void setLocalCertificate(Certificate[] certificateArr) {
            this.localCertificateChain = certificateArr;
        }

        public void setSessionId(OpenSslSessionId openSslSessionId) {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (this.id == OpenSslSessionId.NULL_ID) {
                        this.id = openSslSessionId;
                        this.creationTime = System.currentTimeMillis();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public String toString() {
            return "DefaultOpenSslSession{sessionContext=" + this.sessionContext + ", id=" + this.id + '}';
        }

        public void tryExpandApplicationBufferSize(int i) {
            int i2;
            if (i > ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH && this.applicationBufferSize != (i2 = ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE)) {
                this.applicationBufferSize = i2;
            }
        }

        public OpenSslSessionContext getSessionContext() {
            return this.sessionContext;
        }
    }

    public enum HandshakeState {
        NOT_STARTED,
        STARTED_IMPLICITLY,
        STARTED_EXPLICITLY,
        FINISHED
    }

    public class TaskDecorator<R extends Runnable> implements Runnable {
        protected final R task;

        public TaskDecorator(R r) {
            this.task = r;
        }

        public void run() {
            ReferenceCountedOpenSslEngine.this.runAndResetNeedTask(this.task);
        }
    }

    static {
        Class<ReferenceCountedOpenSslEngine> cls = ReferenceCountedOpenSslEngine.class;
        logger = InternalLoggerFactory.getInstance((Class<?>) cls);
        leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(cls);
        SSLEngineResult.Status status = SSLEngineResult.Status.OK;
        SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        NEED_UNWRAP_OK = new SSLEngineResult(status, handshakeStatus, 0, 0);
        SSLEngineResult.Status status2 = SSLEngineResult.Status.CLOSED;
        NEED_UNWRAP_CLOSED = new SSLEngineResult(status2, handshakeStatus, 0, 0);
        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.NEED_WRAP;
        NEED_WRAP_OK = new SSLEngineResult(status, handshakeStatus2, 0, 0);
        NEED_WRAP_CLOSED = new SSLEngineResult(status2, handshakeStatus2, 0, 0);
        CLOSED_NOT_HANDSHAKING = new SSLEngineResult(status2, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
    }

    public ReferenceCountedOpenSslEngine(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, ByteBufAllocator byteBufAllocator, String str, int i, boolean z, boolean z2) {
        super(str, i);
        ClientAuth clientAuth2 = ClientAuth.NONE;
        this.clientAuth = clientAuth2;
        this.lastAccessed = -1;
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        OpenSsl.ensureAvailability();
        this.engineMap = referenceCountedOpenSslContext.engineMap;
        boolean z3 = referenceCountedOpenSslContext.enableOcsp;
        this.enableOcsp = z3;
        this.jdkCompatibilityMode = z;
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        this.apn = (OpenSslApplicationProtocolNegotiator) referenceCountedOpenSslContext.applicationProtocolNegotiator();
        boolean isClient = referenceCountedOpenSslContext.isClient();
        this.clientMode = isClient;
        if (PlatformDependent.javaVersion() >= 7) {
            this.session = new ExtendedOpenSslSession(new DefaultOpenSslSession(referenceCountedOpenSslContext.sessionContext())) {
                private String[] peerSupportedSignatureAlgorithms;
                private List requestedServerNames;

                public String[] getPeerSupportedSignatureAlgorithms() {
                    String[] strArr;
                    synchronized (ReferenceCountedOpenSslEngine.this) {
                        try {
                            if (this.peerSupportedSignatureAlgorithms == null) {
                                if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                                    this.peerSupportedSignatureAlgorithms = EmptyArrays.EMPTY_STRINGS;
                                } else {
                                    String[] sigAlgs = SSL.getSigAlgs(ReferenceCountedOpenSslEngine.this.ssl);
                                    if (sigAlgs == null) {
                                        this.peerSupportedSignatureAlgorithms = EmptyArrays.EMPTY_STRINGS;
                                    } else {
                                        LinkedHashSet linkedHashSet = new LinkedHashSet(sigAlgs.length);
                                        for (String javaName : sigAlgs) {
                                            String javaName2 = SignatureAlgorithmConverter.toJavaName(javaName);
                                            if (javaName2 != null) {
                                                linkedHashSet.add(javaName2);
                                            }
                                        }
                                        this.peerSupportedSignatureAlgorithms = (String[]) linkedHashSet.toArray(new String[0]);
                                    }
                                }
                            }
                            strArr = (String[]) this.peerSupportedSignatureAlgorithms.clone();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return strArr;
                }

                public List getRequestedServerNames() {
                    List list;
                    if (ReferenceCountedOpenSslEngine.this.clientMode) {
                        return Java8SslUtils.getSniHostNames((List<String>) ReferenceCountedOpenSslEngine.this.sniHostNames);
                    }
                    synchronized (ReferenceCountedOpenSslEngine.this) {
                        try {
                            if (this.requestedServerNames == null) {
                                if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                                    this.requestedServerNames = Collections.emptyList();
                                } else if (SSL.getSniHostname(ReferenceCountedOpenSslEngine.this.ssl) == null) {
                                    this.requestedServerNames = Collections.emptyList();
                                } else {
                                    this.requestedServerNames = Java8SslUtils.getSniHostName(SSL.getSniHostname(ReferenceCountedOpenSslEngine.this.ssl).getBytes(CharsetUtil.UTF_8));
                                }
                            }
                            list = this.requestedServerNames;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return list;
                }

                public List<byte[]> getStatusResponses() {
                    byte[] bArr = null;
                    if (ReferenceCountedOpenSslEngine.this.enableOcsp && ReferenceCountedOpenSslEngine.this.clientMode) {
                        synchronized (ReferenceCountedOpenSslEngine.this) {
                            try {
                                if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                                    bArr = SSL.getOcspResponse(ReferenceCountedOpenSslEngine.this.ssl);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    return bArr == null ? Collections.emptyList() : Collections.singletonList(bArr);
                }
            };
        } else {
            this.session = new DefaultOpenSslSession(referenceCountedOpenSslContext.sessionContext());
        }
        if (!referenceCountedOpenSslContext.sessionContext().useKeyManager()) {
            this.session.setLocalCertificate(referenceCountedOpenSslContext.keyCertChain);
        }
        Lock readLock = referenceCountedOpenSslContext.ctxLock.readLock();
        readLock.lock();
        try {
            long newSSL = SSL.newSSL(referenceCountedOpenSslContext.ctx, !referenceCountedOpenSslContext.isClient());
            synchronized (this) {
                this.ssl = newSSL;
                try {
                    this.networkBIO = SSL.bioNewByteBuffer(newSSL, referenceCountedOpenSslContext.getBioNonApplicationBufferSize());
                    if (!isClient) {
                        clientAuth2 = referenceCountedOpenSslContext.clientAuth;
                    }
                    setClientAuth(clientAuth2);
                    String[] strArr = referenceCountedOpenSslContext.protocols;
                    if (strArr != null) {
                        setEnabledProtocols0(strArr, true);
                    } else {
                        this.explicitlyEnabledProtocols = getEnabledProtocols();
                    }
                    if (isClient && SslUtils.isValidHostNameForSNI(str)) {
                        if (PlatformDependent.javaVersion() < 8) {
                            SSL.setTlsExtHostName(this.ssl, str);
                            this.sniHostNames = Collections.singletonList(str);
                        } else if (Java8SslUtils.isValidHostNameForSNI(str)) {
                            SSL.setTlsExtHostName(this.ssl, str);
                            this.sniHostNames = Collections.singletonList(str);
                        }
                    }
                    if (z3) {
                        SSL.enableOcsp(this.ssl);
                    }
                    if (!z) {
                        long j = this.ssl;
                        SSL.setMode(j, SSL.getMode(j) | SSL.SSL_MODE_ENABLE_PARTIAL_WRITE);
                    }
                    if (isProtocolEnabled(SSL.getOptions(this.ssl), SSL.SSL_OP_NO_TLSv1_3, SslProtocols.TLS_v1_3)) {
                        if (isClient ? ReferenceCountedOpenSslContext.CLIENT_ENABLE_SESSION_TICKET_TLSV13 : ReferenceCountedOpenSslContext.SERVER_ENABLE_SESSION_TICKET_TLSV13) {
                            SSL.clearOptions(this.ssl, SSL.SSL_OP_NO_TICKET);
                        }
                    }
                    if (OpenSsl.isBoringSSL() && isClient) {
                        SSL.setRenegotiateMode(this.ssl, SSL.SSL_RENEGOTIATE_ONCE);
                    }
                    calculateMaxWrapOverhead();
                } catch (Throwable th) {
                    shutdown();
                    PlatformDependent.throwException(th);
                }
            }
            this.parentContext = referenceCountedOpenSslContext;
            referenceCountedOpenSslContext.retain();
            this.leak = z2 ? leakDetector.track(this) : null;
        } finally {
            readLock.unlock();
        }
    }

    private static long bufferAddress(ByteBuffer byteBuffer) {
        return PlatformDependent.hasUnsafe() ? PlatformDependent.directBufferAddress(byteBuffer) : Buffer.address(byteBuffer);
    }

    /* access modifiers changed from: private */
    public void calculateMaxWrapOverhead() {
        this.maxWrapOverhead = SSL.getMaxWrapOverhead(this.ssl);
        this.maxWrapBufferSize = this.jdkCompatibilityMode ? maxEncryptedPacketLength0() : maxEncryptedPacketLength0() << 4;
    }

    private void checkEngineClosed() throws SSLException {
        if (isDestroyed()) {
            throw new SSLException("engine closed");
        }
    }

    private void closeAll() throws SSLException {
        this.receivedShutdown = true;
        closeOutbound();
        closeInbound();
    }

    private boolean doSSLShutdown() {
        if (SSL.isInInit(this.ssl) != 0) {
            return false;
        }
        int shutdownSSL = SSL.shutdownSSL(this.ssl);
        if (shutdownSSL >= 0) {
            return true;
        }
        int error = SSL.getError(this.ssl, shutdownSSL);
        if (error == SSL.SSL_ERROR_SYSCALL || error == SSL.SSL_ERROR_SSL) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                int lastErrorNumber = SSL.getLastErrorNumber();
                internalLogger.debug("SSL_shutdown failed: OpenSSL error: {} {}", Integer.valueOf(lastErrorNumber), SSL.getErrorString((long) lastErrorNumber));
            }
            shutdown();
            return false;
        }
        SSL.clearError();
        return true;
    }

    private SSLEngineResult handleUnwrapException(int i, int i2, SSLException sSLException) throws SSLException {
        int lastErrorNumber = SSL.getLastErrorNumber();
        if (lastErrorNumber != 0) {
            return sslReadErrorResult(SSL.SSL_ERROR_SSL, lastErrorNumber, i, i2);
        }
        throw sSLException;
    }

    private SSLEngineResult.HandshakeStatus handshake() throws SSLException {
        if (this.needTask) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        if (this.handshakeState == HandshakeState.FINISHED) {
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
        checkEngineClosed();
        if (this.pendingException != null) {
            if (SSL.doHandshake(this.ssl) <= 0) {
                SSL.clearError();
            }
            return handshakeException();
        }
        this.engineMap.add(this);
        if (!this.sessionSet) {
            this.parentContext.sessionContext().setSessionFromCache(getPeerHost(), getPeerPort(), this.ssl);
            this.sessionSet = true;
        }
        if (this.lastAccessed == -1) {
            this.lastAccessed = System.currentTimeMillis();
        }
        int doHandshake = SSL.doHandshake(this.ssl);
        if (doHandshake <= 0) {
            int error = SSL.getError(this.ssl, doHandshake);
            if (error == SSL.SSL_ERROR_WANT_READ || error == SSL.SSL_ERROR_WANT_WRITE) {
                return pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
            }
            if (error == SSL.SSL_ERROR_WANT_X509_LOOKUP || error == SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY || error == SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) {
                return SSLEngineResult.HandshakeStatus.NEED_TASK;
            }
            if (needWrapAgain(SSL.getLastErrorNumber())) {
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            }
            if (this.pendingException != null) {
                return handshakeException();
            }
            throw shutdownWithError("SSL_do_handshake", error);
        } else if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        } else {
            this.session.handshakeFinished(SSL.getSessionId(this.ssl), SSL.getCipherForSSL(this.ssl), SSL.getVersion(this.ssl), SSL.getPeerCertificate(this.ssl), SSL.getPeerCertChain(this.ssl), SSL.getTime(this.ssl) * 1000, 1000 * this.parentContext.sessionTimeout());
            selectApplicationProtocol();
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
    }

    private SSLEngineResult.HandshakeStatus handshakeException() throws SSLException {
        if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        }
        Throwable th = this.pendingException;
        this.pendingException = null;
        shutdown();
        if (th instanceof SSLHandshakeException) {
            throw ((SSLHandshakeException) th);
        }
        SSLHandshakeException sSLHandshakeException = new SSLHandshakeException("General OpenSslEngine problem");
        sSLHandshakeException.initCause(th);
        throw sSLHandshakeException;
    }

    private boolean isBytesAvailableEnoughForWrap(int i, int i2, int i3) {
        return ((long) i) - (((long) this.maxWrapOverhead) * ((long) i3)) >= ((long) i2);
    }

    /* access modifiers changed from: private */
    public boolean isDestroyed() {
        return this.destroyed;
    }

    /* access modifiers changed from: private */
    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    private static boolean isEndPointVerificationEnabled(String str) {
        return str != null && !str.isEmpty();
    }

    private static boolean isProtocolEnabled(int i, int i2, String str) {
        return (i & i2) == 0 && OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(str);
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus, int i, int i2) throws SSLException {
        if ((handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP && i2 > 0) || (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP && i > 0)) {
            return handshake();
        }
        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.FINISHED;
        if (handshakeStatus != handshakeStatus2) {
            handshakeStatus2 = getHandshakeStatus();
        }
        return mayFinishHandshake(handshakeStatus2);
    }

    private boolean needPendingStatus() {
        return this.handshakeState != HandshakeState.NOT_STARTED && !isDestroyed() && (this.handshakeState != HandshakeState.FINISHED || isInboundDone() || isOutboundDone());
    }

    private boolean needWrapAgain(int i) {
        if (SSL.bioLengthNonApplication(this.networkBIO) <= 0) {
            return false;
        }
        String errorString = SSL.getErrorString((long) i);
        Throwable sSLException = this.handshakeState == HandshakeState.FINISHED ? new SSLException(errorString) : new SSLHandshakeException(errorString);
        Throwable th = this.pendingException;
        if (th == null) {
            this.pendingException = sSLException;
        } else {
            ThrowableUtil.addSuppressed(th, sSLException);
        }
        SSL.clearError();
        return true;
    }

    private SSLEngineResult newResult(SSLEngineResult.HandshakeStatus handshakeStatus, int i, int i2) {
        return newResult(SSLEngineResult.Status.OK, handshakeStatus, i, i2);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus, int i, int i2) throws SSLException {
        return newResult(mayFinishHandshake(handshakeStatus, i, i2), i, i2);
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int i) {
        return i > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    private int readPlaintextData(ByteBuffer byteBuffer) throws SSLException {
        int i;
        int position = byteBuffer.position();
        if (byteBuffer.isDirect()) {
            i = SSL.readFromSSL(this.ssl, bufferAddress(byteBuffer) + ((long) position), byteBuffer.limit() - position);
            if (i > 0) {
                byteBuffer.position(position + i);
            }
        } else {
            int limit = byteBuffer.limit();
            int min = Math.min(maxEncryptedPacketLength0(), limit - position);
            ByteBuf directBuffer = this.alloc.directBuffer(min);
            try {
                i = SSL.readFromSSL(this.ssl, OpenSsl.memoryAddress(directBuffer), min);
                if (i > 0) {
                    byteBuffer.limit(position + i);
                    directBuffer.getBytes(directBuffer.readerIndex(), byteBuffer);
                    byteBuffer.limit(limit);
                }
            } finally {
                directBuffer.release();
            }
        }
        return i;
    }

    private void rejectRemoteInitiatedRenegotiation() throws SSLHandshakeException {
        if (isDestroyed()) {
            return;
        }
        if (((!this.clientMode && SSL.getHandshakeCount(this.ssl) > 1) || (this.clientMode && SSL.getHandshakeCount(this.ssl) > 2)) && !SslProtocols.TLS_v1_3.equals(this.session.getProtocol()) && this.handshakeState == HandshakeState.FINISHED) {
            shutdown();
            throw new SSLHandshakeException("remote-initiated renegotiation not allowed");
        }
    }

    private void resetSingleDstBuffer() {
        this.singleDstBuffer[0] = null;
    }

    private void resetSingleSrcBuffer() {
        this.singleSrcBuffer[0] = null;
    }

    /* access modifiers changed from: private */
    public synchronized void runAndResetNeedTask(Runnable runnable) {
        try {
            if (isDestroyed()) {
                this.needTask = false;
                return;
            }
            runnable.run();
            this.needTask = false;
        } catch (Throwable th) {
            this.needTask = false;
            throw th;
        }
    }

    private void selectApplicationProtocol() throws SSLException {
        ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior = this.apn.selectedListenerFailureBehavior();
        List<String> protocols = this.apn.protocols();
        int i = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[this.apn.protocol().ordinal()];
        if (i == 1) {
            return;
        }
        if (i == 2) {
            String alpnSelected = SSL.getAlpnSelected(this.ssl);
            if (alpnSelected != null) {
                this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, alpnSelected);
            }
        } else if (i == 3) {
            String nextProtoNegotiated = SSL.getNextProtoNegotiated(this.ssl);
            if (nextProtoNegotiated != null) {
                this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, nextProtoNegotiated);
            }
        } else if (i == 4) {
            String alpnSelected2 = SSL.getAlpnSelected(this.ssl);
            if (alpnSelected2 == null) {
                alpnSelected2 = SSL.getNextProtoNegotiated(this.ssl);
            }
            if (alpnSelected2 != null) {
                this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, alpnSelected2);
            }
        } else {
            throw new Error();
        }
    }

    private void setClientAuth(ClientAuth clientAuth2) {
        if (!this.clientMode) {
            synchronized (this) {
                try {
                    if (this.clientAuth != clientAuth2) {
                        if (!isDestroyed()) {
                            int i = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ClientAuth[clientAuth2.ordinal()];
                            if (i == 1) {
                                SSL.setVerify(this.ssl, 0, 10);
                            } else if (i == 2) {
                                SSL.setVerify(this.ssl, 2, 10);
                            } else if (i == 3) {
                                SSL.setVerify(this.ssl, 1, 10);
                            } else {
                                throw new Error(clientAuth2.toString());
                            }
                        }
                        this.clientAuth = clientAuth2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private void setEnabledProtocols0(String[] strArr, boolean z) {
        ObjectUtil.checkNotNullWithIAE(strArr, "protocols");
        int length = OPENSSL_OP_NO_PROTOCOLS.length;
        int length2 = strArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i < length2) {
                String str = strArr[i];
                if (OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(str)) {
                    if (str.equals(SslProtocols.SSL_v2)) {
                        if (length > 0) {
                            length = 0;
                        }
                        if (i2 < 0) {
                            i2 = 0;
                        }
                    } else {
                        if (str.equals(SslProtocols.SSL_v3)) {
                            if (length > 1) {
                                length = 1;
                            }
                            if (i2 >= 1) {
                            }
                        } else if (str.equals(SslProtocols.TLS_v1)) {
                            i3 = 2;
                            if (length > 2) {
                                length = 2;
                            }
                            if (i2 >= 2) {
                            }
                        } else if (str.equals(SslProtocols.TLS_v1_1)) {
                            i3 = 3;
                            if (length > 3) {
                                length = 3;
                            }
                            if (i2 >= 3) {
                            }
                        } else if (str.equals(SslProtocols.TLS_v1_2)) {
                            i3 = 4;
                            if (length > 4) {
                                length = 4;
                            }
                            if (i2 >= 4) {
                            }
                        } else if (str.equals(SslProtocols.TLS_v1_3)) {
                            i3 = 5;
                            if (length > 5) {
                                length = 5;
                            }
                            if (i2 >= 5) {
                            }
                        }
                        i2 = i3;
                    }
                    i++;
                } else {
                    throw new IllegalArgumentException("Protocol " + str + " is not supported.");
                }
            } else {
                synchronized (this) {
                    if (z) {
                        try {
                            this.explicitlyEnabledProtocols = strArr;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (!isDestroyed()) {
                        SSL.clearOptions(this.ssl, SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_NO_TLSv1_2 | SSL.SSL_OP_NO_TLSv1_3);
                        int i4 = 0;
                        for (int i5 = 0; i5 < length; i5++) {
                            i4 |= OPENSSL_OP_NO_PROTOCOLS[i5];
                        }
                        int i6 = i2 + 1;
                        while (true) {
                            int[] iArr = OPENSSL_OP_NO_PROTOCOLS;
                            if (i6 < iArr.length) {
                                i4 |= iArr[i6];
                                i6++;
                            } else {
                                SSL.setOptions(this.ssl, i4);
                            }
                        }
                    } else {
                        throw new IllegalStateException("failed to enable protocols: " + Arrays.asList(strArr));
                    }
                }
                return;
            }
        }
    }

    private SSLException shutdownWithError(String str, int i) {
        return shutdownWithError(str, i, SSL.getLastErrorNumber());
    }

    private ByteBuffer[] singleDstBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleDstBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private ByteBuffer[] singleSrcBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleSrcBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private int sslPending0() {
        if (this.handshakeState != HandshakeState.FINISHED) {
            return 0;
        }
        return SSL.sslPending(this.ssl);
    }

    private SSLEngineResult sslReadErrorResult(int i, int i2, int i3, int i4) throws SSLException {
        if (needWrapAgain(i2)) {
            return new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, i3, i4);
        }
        throw shutdownWithError("SSL_read", i, i2);
    }

    /* access modifiers changed from: private */
    public String toJavaCipherSuite(String str) {
        if (str == null) {
            return null;
        }
        return CipherSuiteConverter.toJava(str, toJavaCipherSuitePrefix(SSL.getVersion(this.ssl)));
    }

    private static String toJavaCipherSuitePrefix(String str) {
        char c = 0;
        if (str != null && !str.isEmpty()) {
            c = str.charAt(0);
        }
        return c != 'S' ? c != 'T' ? "UNKNOWN" : "TLS" : "SSL";
    }

    private ByteBuf writeEncryptedData(ByteBuffer byteBuffer, int i) throws SSLException {
        int position = byteBuffer.position();
        if (byteBuffer.isDirect()) {
            SSL.bioSetByteBuffer(this.networkBIO, bufferAddress(byteBuffer) + ((long) position), i, false);
            return null;
        }
        ByteBuf directBuffer = this.alloc.directBuffer(i);
        try {
            int limit = byteBuffer.limit();
            byteBuffer.limit(position + i);
            directBuffer.writeBytes(byteBuffer);
            byteBuffer.position(position);
            byteBuffer.limit(limit);
            SSL.bioSetByteBuffer(this.networkBIO, OpenSsl.memoryAddress(directBuffer), i, false);
            return directBuffer;
        } catch (Throwable th) {
            directBuffer.release();
            PlatformDependent.throwException(th);
            return null;
        }
    }

    private int writePlaintextData(ByteBuffer byteBuffer, int i) {
        int i2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        if (byteBuffer.isDirect()) {
            i2 = SSL.writeToSSL(this.ssl, bufferAddress(byteBuffer) + ((long) position), i);
            if (i2 > 0) {
                byteBuffer.position(position + i2);
            }
        } else {
            ByteBuf directBuffer = this.alloc.directBuffer(i);
            try {
                byteBuffer.limit(position + i);
                directBuffer.setBytes(0, byteBuffer);
                byteBuffer.limit(limit);
                i2 = SSL.writeToSSL(this.ssl, OpenSsl.memoryAddress(directBuffer), i);
                if (i2 > 0) {
                    byteBuffer.position(position + i2);
                } else {
                    byteBuffer.position(position);
                }
            } finally {
                directBuffer.release();
            }
        }
        return i2;
    }

    public final synchronized String[] authMethods() {
        if (isDestroyed()) {
            return EmptyArrays.EMPTY_STRINGS;
        }
        return SSL.authenticationMethods(this.ssl);
    }

    public final synchronized void beginHandshake() throws SSLException {
        try {
            int i = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[this.handshakeState.ordinal()];
            if (i == 1) {
                this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                if (handshake() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                    this.needTask = true;
                }
                calculateMaxWrapOverhead();
            } else if (i == 2) {
                throw new SSLException("renegotiation unsupported");
            } else if (i == 3) {
                checkEngineClosed();
                this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                calculateMaxWrapOverhead();
            } else if (i != 4) {
                throw new Error();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void bioSetFd(int i) {
        if (!isDestroyed()) {
            SSL.bioSetFd(this.ssl, i);
        }
    }

    public final int calculateMaxLengthForWrap(int i, int i2) {
        return (int) Math.min((long) this.maxWrapBufferSize, ((long) i) + (((long) this.maxWrapOverhead) * ((long) i2)));
    }

    public final boolean checkSniHostnameMatch(byte[] bArr) {
        return Java8SslUtils.checkSniHostnameMatch(this.matchers, bArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void closeInbound() throws javax.net.ssl.SSLException {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isInboundDone     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 1
            r2.isInboundDone = r0     // Catch:{ all -> 0x0014 }
            boolean r0 = r2.isOutboundDone()     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x0016
            r2.shutdown()     // Catch:{ all -> 0x0014 }
            goto L_0x0016
        L_0x0014:
            r0 = move-exception
            goto L_0x002b
        L_0x0016:
            io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r0 = r2.handshakeState     // Catch:{ all -> 0x0014 }
            io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r1 = io.netty.handler.ssl.ReferenceCountedOpenSslEngine.HandshakeState.NOT_STARTED     // Catch:{ all -> 0x0014 }
            if (r0 == r1) goto L_0x0029
            boolean r0 = r2.receivedShutdown     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x0021
            goto L_0x0029
        L_0x0021:
            javax.net.ssl.SSLException r0 = new javax.net.ssl.SSLException     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = "Inbound closed before receiving peer's close_notify: possible truncation attack?"
            r0.<init>(r1)     // Catch:{ all -> 0x0014 }
            throw r0     // Catch:{ all -> 0x0014 }
        L_0x0029:
            monitor-exit(r2)
            return
        L_0x002b:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.closeInbound():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void closeOutbound() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.outboundClosed     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 1
            r2.outboundClosed = r0     // Catch:{ all -> 0x0027 }
            io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r0 = r2.handshakeState     // Catch:{ all -> 0x0027 }
            io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r1 = io.netty.handler.ssl.ReferenceCountedOpenSslEngine.HandshakeState.NOT_STARTED     // Catch:{ all -> 0x0027 }
            if (r0 == r1) goto L_0x0029
            boolean r0 = r2.isDestroyed()     // Catch:{ all -> 0x0027 }
            if (r0 != 0) goto L_0x0029
            long r0 = r2.ssl     // Catch:{ all -> 0x0027 }
            int r0 = io.netty.internal.tcnative.SSL.getShutdown(r0)     // Catch:{ all -> 0x0027 }
            int r1 = io.netty.internal.tcnative.SSL.SSL_SENT_SHUTDOWN     // Catch:{ all -> 0x0027 }
            r0 = r0 & r1
            int r1 = io.netty.internal.tcnative.SSL.SSL_SENT_SHUTDOWN     // Catch:{ all -> 0x0027 }
            if (r0 == r1) goto L_0x002c
            r2.doSSLShutdown()     // Catch:{ all -> 0x0027 }
            goto L_0x002c
        L_0x0027:
            r0 = move-exception
            goto L_0x002e
        L_0x0029:
            r2.shutdown()     // Catch:{ all -> 0x0027 }
        L_0x002c:
            monitor-exit(r2)
            return
        L_0x002e:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.closeOutbound():void");
    }

    public String getApplicationProtocol() {
        return this.applicationProtocol;
    }

    public final synchronized Runnable getDelegatedTask() {
        if (isDestroyed()) {
            return null;
        }
        AsyncTask task = SSL.getTask(this.ssl);
        if (task == null) {
            return null;
        }
        if (task instanceof AsyncTask) {
            return new AsyncTaskDecorator(task);
        }
        return new TaskDecorator(task);
    }

    public final boolean getEnableSessionCreation() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r0 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        return io.netty.util.internal.EmptyArrays.EMPTY_STRINGS;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        r4 = new java.util.LinkedHashSet(r0.length + r1.length);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        if (r5 >= r0.length) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        r6 = toJavaCipherSuite(r0[r5]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        if (r6 != null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
        r6 = r0[r5];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        if (r3 == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        if (io.netty.handler.ssl.OpenSsl.isTlsv13Supported() != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        if (io.netty.handler.ssl.SslUtils.isTLSv13Cipher(r6) == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
        r4.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005c, code lost:
        java.util.Collections.addAll(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005f, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0068, code lost:
        return (java.lang.String[]) r4.toArray(new java.lang.String[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x006a, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String[] getEnabledCipherSuites() {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.isDestroyed()     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x006b
            long r0 = r8.ssl     // Catch:{ all -> 0x0022 }
            java.lang.String[] r0 = io.netty.internal.tcnative.SSL.getCiphers(r0)     // Catch:{ all -> 0x0022 }
            long r1 = r8.ssl     // Catch:{ all -> 0x0022 }
            int r1 = io.netty.internal.tcnative.SSL.getOptions(r1)     // Catch:{ all -> 0x0022 }
            int r2 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1_3     // Catch:{ all -> 0x0022 }
            java.lang.String r3 = "TLSv1.3"
            boolean r1 = isProtocolEnabled(r1, r2, r3)     // Catch:{ all -> 0x0022 }
            r2 = 0
            if (r1 == 0) goto L_0x0024
            java.lang.String[] r1 = io.netty.handler.ssl.OpenSsl.EXTRA_SUPPORTED_TLS_1_3_CIPHERS     // Catch:{ all -> 0x0022 }
            r3 = 1
            goto L_0x0027
        L_0x0022:
            r0 = move-exception
            goto L_0x006f
        L_0x0024:
            java.lang.String[] r1 = io.netty.util.internal.EmptyArrays.EMPTY_STRINGS     // Catch:{ all -> 0x0022 }
            r3 = r2
        L_0x0027:
            monitor-exit(r8)     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x002d
            java.lang.String[] r8 = io.netty.util.internal.EmptyArrays.EMPTY_STRINGS
            return r8
        L_0x002d:
            java.util.LinkedHashSet r4 = new java.util.LinkedHashSet
            int r5 = r0.length
            int r6 = r1.length
            int r5 = r5 + r6
            r4.<init>(r5)
            monitor-enter(r8)
            r5 = r2
        L_0x0037:
            int r6 = r0.length     // Catch:{ all -> 0x0045 }
            if (r5 >= r6) goto L_0x005c
            r6 = r0[r5]     // Catch:{ all -> 0x0045 }
            java.lang.String r6 = r8.toJavaCipherSuite(r6)     // Catch:{ all -> 0x0045 }
            if (r6 != 0) goto L_0x0047
            r6 = r0[r5]     // Catch:{ all -> 0x0045 }
            goto L_0x0047
        L_0x0045:
            r0 = move-exception
            goto L_0x0069
        L_0x0047:
            if (r3 == 0) goto L_0x004f
            boolean r7 = io.netty.handler.ssl.OpenSsl.isTlsv13Supported()     // Catch:{ all -> 0x0045 }
            if (r7 != 0) goto L_0x0056
        L_0x004f:
            boolean r7 = io.netty.handler.ssl.SslUtils.isTLSv13Cipher(r6)     // Catch:{ all -> 0x0045 }
            if (r7 == 0) goto L_0x0056
            goto L_0x0059
        L_0x0056:
            r4.add(r6)     // Catch:{ all -> 0x0045 }
        L_0x0059:
            int r5 = r5 + 1
            goto L_0x0037
        L_0x005c:
            java.util.Collections.addAll(r4, r1)     // Catch:{ all -> 0x0045 }
            monitor-exit(r8)     // Catch:{ all -> 0x0045 }
            java.lang.String[] r8 = new java.lang.String[r2]
            java.lang.Object[] r8 = r4.toArray(r8)
            java.lang.String[] r8 = (java.lang.String[]) r8
            return r8
        L_0x0069:
            monitor-exit(r8)     // Catch:{ all -> 0x0045 }
            throw r0
        L_0x006b:
            java.lang.String[] r0 = io.netty.util.internal.EmptyArrays.EMPTY_STRINGS     // Catch:{ all -> 0x0022 }
            monitor-exit(r8)     // Catch:{ all -> 0x0022 }
            return r0
        L_0x006f:
            monitor-exit(r8)     // Catch:{ all -> 0x0022 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.getEnabledCipherSuites():java.lang.String[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        if (isProtocolEnabled(r1, io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1_1, io.netty.handler.ssl.SslProtocols.TLS_v1_1) == false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        r0.add(io.netty.handler.ssl.SslProtocols.TLS_v1_1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        if (isProtocolEnabled(r1, io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1_2, io.netty.handler.ssl.SslProtocols.TLS_v1_2) == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        r0.add(io.netty.handler.ssl.SslProtocols.TLS_v1_2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        if (isProtocolEnabled(r1, io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1_3, io.netty.handler.ssl.SslProtocols.TLS_v1_3) == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        r0.add(io.netty.handler.ssl.SslProtocols.TLS_v1_3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005e, code lost:
        if (isProtocolEnabled(r1, io.netty.internal.tcnative.SSL.SSL_OP_NO_SSLv2, io.netty.handler.ssl.SslProtocols.SSL_v2) == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0060, code lost:
        r0.add(io.netty.handler.ssl.SslProtocols.SSL_v2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
        if (isProtocolEnabled(r1, io.netty.internal.tcnative.SSL.SSL_OP_NO_SSLv3, io.netty.handler.ssl.SslProtocols.SSL_v3) == false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006f, code lost:
        r0.add(io.netty.handler.ssl.SslProtocols.SSL_v3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007c, code lost:
        return (java.lang.String[]) r0.toArray(new java.lang.String[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (isProtocolEnabled(r1, io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1, io.netty.handler.ssl.SslProtocols.TLS_v1) == false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        r0.add(io.netty.handler.ssl.SslProtocols.TLS_v1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String[] getEnabledProtocols() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 6
            r0.<init>(r1)
            java.lang.String r1 = "SSLv2Hello"
            r0.add(r1)
            monitor-enter(r5)
            boolean r1 = r5.isDestroyed()     // Catch:{ all -> 0x007d }
            r2 = 0
            if (r1 != 0) goto L_0x007f
            long r3 = r5.ssl     // Catch:{ all -> 0x007d }
            int r1 = io.netty.internal.tcnative.SSL.getOptions(r3)     // Catch:{ all -> 0x007d }
            monitor-exit(r5)     // Catch:{ all -> 0x007d }
            int r5 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1
            java.lang.String r3 = "TLSv1"
            boolean r5 = isProtocolEnabled(r1, r5, r3)
            if (r5 == 0) goto L_0x0029
            java.lang.String r5 = "TLSv1"
            r0.add(r5)
        L_0x0029:
            int r5 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1_1
            java.lang.String r3 = "TLSv1.1"
            boolean r5 = isProtocolEnabled(r1, r5, r3)
            if (r5 == 0) goto L_0x0038
            java.lang.String r5 = "TLSv1.1"
            r0.add(r5)
        L_0x0038:
            int r5 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1_2
            java.lang.String r3 = "TLSv1.2"
            boolean r5 = isProtocolEnabled(r1, r5, r3)
            if (r5 == 0) goto L_0x0047
            java.lang.String r5 = "TLSv1.2"
            r0.add(r5)
        L_0x0047:
            int r5 = io.netty.internal.tcnative.SSL.SSL_OP_NO_TLSv1_3
            java.lang.String r3 = "TLSv1.3"
            boolean r5 = isProtocolEnabled(r1, r5, r3)
            if (r5 == 0) goto L_0x0056
            java.lang.String r5 = "TLSv1.3"
            r0.add(r5)
        L_0x0056:
            int r5 = io.netty.internal.tcnative.SSL.SSL_OP_NO_SSLv2
            java.lang.String r3 = "SSLv2"
            boolean r5 = isProtocolEnabled(r1, r5, r3)
            if (r5 == 0) goto L_0x0065
            java.lang.String r5 = "SSLv2"
            r0.add(r5)
        L_0x0065:
            int r5 = io.netty.internal.tcnative.SSL.SSL_OP_NO_SSLv3
            java.lang.String r3 = "SSLv3"
            boolean r5 = isProtocolEnabled(r1, r5, r3)
            if (r5 == 0) goto L_0x0074
            java.lang.String r5 = "SSLv3"
            r0.add(r5)
        L_0x0074:
            java.lang.String[] r5 = new java.lang.String[r2]
            java.lang.Object[] r5 = r0.toArray(r5)
            java.lang.String[] r5 = (java.lang.String[]) r5
            return r5
        L_0x007d:
            r0 = move-exception
            goto L_0x0089
        L_0x007f:
            java.lang.String[] r1 = new java.lang.String[r2]     // Catch:{ all -> 0x007d }
            java.lang.Object[] r0 = r0.toArray(r1)     // Catch:{ all -> 0x007d }
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ all -> 0x007d }
            monitor-exit(r5)     // Catch:{ all -> 0x007d }
            return r0
        L_0x0089:
            monitor-exit(r5)     // Catch:{ all -> 0x007d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.getEnabledProtocols():java.lang.String[]");
    }

    public String getHandshakeApplicationProtocol() {
        return this.applicationProtocol;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized javax.net.ssl.SSLSession getHandshakeSession() {
        /*
            r2 = this;
            monitor-enter(r2)
            int[] r0 = io.netty.handler.ssl.ReferenceCountedOpenSslEngine.AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState     // Catch:{ all -> 0x0015 }
            io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r1 = r2.handshakeState     // Catch:{ all -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x0015 }
            r0 = r0[r1]     // Catch:{ all -> 0x0015 }
            r1 = 1
            if (r0 == r1) goto L_0x0017
            r1 = 2
            if (r0 == r1) goto L_0x0017
            io.netty.handler.ssl.OpenSslSession r0 = r2.session     // Catch:{ all -> 0x0015 }
            monitor-exit(r2)
            return r0
        L_0x0015:
            r0 = move-exception
            goto L_0x001a
        L_0x0017:
            monitor-exit(r2)
            r2 = 0
            return r2
        L_0x001a:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.getHandshakeSession():javax.net.ssl.SSLSession");
    }

    public final synchronized SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        if (!needPendingStatus()) {
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        } else if (this.needTask) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        } else {
            return pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
        }
    }

    public final boolean getNeedClientAuth() {
        return this.clientAuth == ClientAuth.REQUIRE;
    }

    public String getNegotiatedApplicationProtocol() {
        return this.applicationProtocol;
    }

    public byte[] getOcspResponse() {
        if (!this.enableOcsp) {
            throw new IllegalStateException("OCSP stapling is not enabled");
        } else if (this.clientMode) {
            synchronized (this) {
                try {
                    if (isDestroyed()) {
                        byte[] bArr = EmptyArrays.EMPTY_BYTES;
                        return bArr;
                    }
                    byte[] ocspResponse = SSL.getOcspResponse(this.ssl);
                    return ocspResponse;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            throw new IllegalStateException("Not a client SSLEngine");
        }
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public final synchronized SSLParameters getSSLParameters() {
        SSLParameters sSLParameters;
        try {
            sSLParameters = super.getSSLParameters();
            int javaVersion = PlatformDependent.javaVersion();
            if (javaVersion >= 7) {
                sSLParameters.setEndpointIdentificationAlgorithm(this.endPointIdentificationAlgorithm);
                Java7SslParametersUtils.setAlgorithmConstraints(sSLParameters, this.algorithmConstraints);
                if (javaVersion >= 8) {
                    List<String> list = this.sniHostNames;
                    if (list != null) {
                        Java8SslUtils.setSniHostNames(sSLParameters, list);
                    }
                    if (!isDestroyed()) {
                        Java8SslUtils.setUseCipherSuitesOrder(sSLParameters, (SSL.getOptions(this.ssl) & SSL.SSL_OP_CIPHER_SERVER_PREFERENCE) != 0);
                    }
                    Java8SslUtils.setSNIMatchers(sSLParameters, this.matchers);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return sSLParameters;
    }

    public final SSLSession getSession() {
        return this.session;
    }

    public final String[] getSupportedCipherSuites() {
        return (String[]) OpenSsl.AVAILABLE_CIPHER_SUITES.toArray(new String[0]);
    }

    public final String[] getSupportedProtocols() {
        return (String[]) OpenSsl.SUPPORTED_PROTOCOLS_SET.toArray(new String[0]);
    }

    public final boolean getUseClientMode() {
        return this.clientMode;
    }

    public final boolean getWantClientAuth() {
        return this.clientAuth == ClientAuth.OPTIONAL;
    }

    public final void initHandshakeException(Throwable th) {
        Throwable th2 = this.pendingException;
        if (th2 == null) {
            this.pendingException = th;
        } else {
            ThrowableUtil.addSuppressed(th2, th);
        }
    }

    public final synchronized boolean isInboundDone() {
        return this.isInboundDone;
    }

    public final synchronized boolean isOutboundDone() {
        boolean z;
        if (this.outboundClosed) {
            long j = this.networkBIO;
            if (j == 0 || SSL.bioLengthNonApplication(j) == 0) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    public synchronized boolean isSessionReused() {
        if (isDestroyed()) {
            return false;
        }
        return SSL.isSessionReused(this.ssl);
    }

    public final synchronized SecretKeySpec masterKey() {
        if (isDestroyed()) {
            return null;
        }
        return new SecretKeySpec(SSL.getMasterKey(this.ssl), "AES");
    }

    public final synchronized int maxEncryptedPacketLength() {
        return maxEncryptedPacketLength0();
    }

    public final int maxEncryptedPacketLength0() {
        return this.maxWrapOverhead + MAX_PLAINTEXT_LENGTH;
    }

    public final synchronized int maxWrapOverhead() {
        return this.maxWrapOverhead;
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

    public final void setEnableSessionCreation(boolean z) {
        if (z) {
            throw new UnsupportedOperationException();
        }
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        ObjectUtil.checkNotNull(strArr, "cipherSuites");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        CipherSuiteConverter.convertToCipherStrings(Arrays.asList(strArr), sb, sb2, OpenSsl.isBoringSSL());
        String sb3 = sb.toString();
        String sb4 = sb2.toString();
        if (OpenSsl.isTlsv13Supported() || sb4.isEmpty()) {
            synchronized (this) {
                try {
                    if (!isDestroyed()) {
                        SSL.setCipherSuites(this.ssl, sb3, false);
                        if (OpenSsl.isTlsv13Supported()) {
                            SSL.setCipherSuites(this.ssl, OpenSsl.checkTls13Ciphers(logger, sb4), true);
                        }
                        HashSet hashSet = new HashSet(this.explicitlyEnabledProtocols.length);
                        Collections.addAll(hashSet, this.explicitlyEnabledProtocols);
                        if (sb3.isEmpty()) {
                            hashSet.remove(SslProtocols.TLS_v1);
                            hashSet.remove(SslProtocols.TLS_v1_1);
                            hashSet.remove(SslProtocols.TLS_v1_2);
                            hashSet.remove(SslProtocols.SSL_v3);
                            hashSet.remove(SslProtocols.SSL_v2);
                            hashSet.remove(SslProtocols.SSL_v2_HELLO);
                        }
                        if (sb4.isEmpty()) {
                            hashSet.remove(SslProtocols.TLS_v1_3);
                        }
                        setEnabledProtocols0((String[]) hashSet.toArray(EmptyArrays.EMPTY_STRINGS), false);
                    } else {
                        throw new IllegalStateException("failed to enable cipher suites: " + sb3);
                    }
                } catch (Exception e) {
                    throw new IllegalStateException("failed to enable cipher suites: " + sb3, e);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        throw new IllegalArgumentException("TLSv1.3 is not supported by this java version.");
    }

    public final void setEnabledProtocols(String[] strArr) {
        setEnabledProtocols0(strArr, true);
    }

    public final boolean setKeyMaterial(OpenSslKeyMaterial openSslKeyMaterial) throws Exception {
        synchronized (this) {
            try {
                if (isDestroyed()) {
                    return false;
                }
                SSL.setKeyMaterial(this.ssl, openSslKeyMaterial.certificateChainAddress(), openSslKeyMaterial.privateKeyAddress());
                this.session.setLocalCertificate(openSslKeyMaterial.certificateChain());
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final void setNeedClientAuth(boolean z) {
        setClientAuth(z ? ClientAuth.REQUIRE : ClientAuth.NONE);
    }

    public void setOcspResponse(byte[] bArr) {
        if (!this.enableOcsp) {
            throw new IllegalStateException("OCSP stapling is not enabled");
        } else if (!this.clientMode) {
            synchronized (this) {
                try {
                    if (!isDestroyed()) {
                        SSL.setOcspResponse(this.ssl, bArr);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            throw new IllegalStateException("Not a server SSLEngine");
        }
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public final synchronized void setSSLParameters(SSLParameters sSLParameters) {
        try {
            int javaVersion = PlatformDependent.javaVersion();
            if (javaVersion >= 7) {
                if (sSLParameters.getAlgorithmConstraints() == null) {
                    boolean isDestroyed = isDestroyed();
                    if (javaVersion >= 8) {
                        if (!isDestroyed) {
                            if (this.clientMode) {
                                List<String> sniHostNames2 = Java8SslUtils.getSniHostNames(sSLParameters);
                                for (String tlsExtHostName : sniHostNames2) {
                                    SSL.setTlsExtHostName(this.ssl, tlsExtHostName);
                                }
                                this.sniHostNames = sniHostNames2;
                            }
                            if (Java8SslUtils.getUseCipherSuitesOrder(sSLParameters)) {
                                SSL.setOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
                            } else {
                                SSL.clearOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
                            }
                        }
                        this.matchers = sSLParameters.getSNIMatchers();
                    }
                    String endpointIdentificationAlgorithm = sSLParameters.getEndpointIdentificationAlgorithm();
                    if (!isDestroyed && this.clientMode && isEndPointVerificationEnabled(endpointIdentificationAlgorithm)) {
                        SSL.setVerify(this.ssl, 2, -1);
                    }
                    this.endPointIdentificationAlgorithm = endpointIdentificationAlgorithm;
                    this.algorithmConstraints = sSLParameters.getAlgorithmConstraints();
                } else {
                    throw new IllegalArgumentException("AlgorithmConstraints are not supported.");
                }
            }
            super.setSSLParameters(sSLParameters);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void setSessionId(OpenSslSessionId openSslSessionId) {
        this.session.setSessionId(openSslSessionId);
    }

    public final void setUseClientMode(boolean z) {
        if (z != this.clientMode) {
            throw new UnsupportedOperationException();
        }
    }

    public final synchronized void setVerify(int i, int i2) {
        if (!isDestroyed()) {
            SSL.setVerify(this.ssl, i, i2);
        }
    }

    public final void setWantClientAuth(boolean z) {
        setClientAuth(z ? ClientAuth.OPTIONAL : ClientAuth.NONE);
    }

    public final synchronized void shutdown() {
        try {
            if (!this.destroyed) {
                this.destroyed = true;
                OpenSslEngineMap openSslEngineMap = this.engineMap;
                if (openSslEngineMap != null) {
                    openSslEngineMap.remove(this.ssl);
                }
                SSL.freeSSL(this.ssl);
                this.networkBIO = 0;
                this.ssl = 0;
                this.outboundClosed = true;
                this.isInboundDone = true;
            }
            SSL.clearError();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized int sslPending() {
        return sslPending0();
    }

    public final synchronized long sslPointer() {
        return this.ssl;
    }

    public final ReferenceCounted touch() {
        this.refCnt.touch();
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0183, code lost:
        if (r13 != null) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
        r13.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01b8, code lost:
        if (r10 <= 0) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01ba, code lost:
        r0 = newResult(javax.net.ssl.SSLEngineResult.Status.BUFFER_OVERFLOW, r17, r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01c6, code lost:
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01cc, code lost:
        if (isInboundDone() == false) goto L_0x01d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01ce, code lost:
        r0 = javax.net.ssl.SSLEngineResult.Status.CLOSED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01d1, code lost:
        r0 = javax.net.ssl.SSLEngineResult.Status.OK;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01d3, code lost:
        r0 = newResultMayFinishHandshake(r0, r6, r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01d7, code lost:
        if (r13 == null) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        r13.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:?, code lost:
        io.netty.internal.tcnative.SSL.bioClearByteBuffer(r1.networkBIO);
        rejectRemoteInitiatedRenegotiation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01e5, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x01f7, code lost:
        if (r13 == null) goto L_0x0283;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x01fa, code lost:
        r6 = r17;
        r7 = io.netty.internal.tcnative.SSL.getError(r1.ssl, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0204, code lost:
        if (r7 == io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_READ) goto L_0x0279;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0208, code lost:
        if (r7 != io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_WRITE) goto L_0x020c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x020e, code lost:
        if (r7 != io.netty.internal.tcnative.SSL.SSL_ERROR_ZERO_RETURN) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0212, code lost:
        if (r1.receivedShutdown != false) goto L_0x0217;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0214, code lost:
        closeAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x021b, code lost:
        if (isInboundDone() == false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x021d, code lost:
        r0 = javax.net.ssl.SSLEngineResult.Status.CLOSED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0220, code lost:
        r0 = javax.net.ssl.SSLEngineResult.Status.OK;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0222, code lost:
        r0 = newResultMayFinishHandshake(r0, r6, r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0226, code lost:
        if (r13 == null) goto L_0x022b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:?, code lost:
        r13.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:?, code lost:
        io.netty.internal.tcnative.SSL.bioClearByteBuffer(r1.networkBIO);
        rejectRemoteInitiatedRenegotiation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0234, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0237, code lost:
        if (r7 == io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_X509_LOOKUP) goto L_0x0259;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x023b, code lost:
        if (r7 == io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY) goto L_0x0259;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x023f, code lost:
        if (r7 != io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) goto L_0x0242;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0242, code lost:
        r0 = sslReadErrorResult(r7, io.netty.internal.tcnative.SSL.getLastErrorNumber(), r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x024a, code lost:
        if (r13 == null) goto L_0x024f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:?, code lost:
        r13.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:?, code lost:
        io.netty.internal.tcnative.SSL.bioClearByteBuffer(r1.networkBIO);
        rejectRemoteInitiatedRenegotiation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0258, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x025d, code lost:
        if (isInboundDone() == false) goto L_0x0262;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x025f, code lost:
        r0 = javax.net.ssl.SSLEngineResult.Status.CLOSED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0262, code lost:
        r0 = javax.net.ssl.SSLEngineResult.Status.OK;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0264, code lost:
        r0 = newResult(r0, javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_TASK, r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x026a, code lost:
        if (r13 == null) goto L_0x026f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:?, code lost:
        r13.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:?, code lost:
        io.netty.internal.tcnative.SSL.bioClearByteBuffer(r1.networkBIO);
        rejectRemoteInitiatedRenegotiation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0278, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0279, code lost:
        r2 = r2 + 1;
        r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x027d, code lost:
        if (r2 < r7) goto L_0x02b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x027f, code lost:
        if (r13 == null) goto L_0x0283;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x02b0, code lost:
        if (r13 == null) goto L_0x02b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:?, code lost:
        r13.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x02b5, code lost:
        r10 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0081, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x018a  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:230:0x02c4=Splitter:B:230:0x02c4, B:170:0x022b=Splitter:B:170:0x022b, B:137:0x01dc=Splitter:B:137:0x01dc, B:186:0x024f=Splitter:B:186:0x024f, B:199:0x026f=Splitter:B:199:0x026f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final javax.net.ssl.SSLEngineResult unwrap(java.nio.ByteBuffer[] r19, int r20, int r21, java.nio.ByteBuffer[] r22, int r23, int r24) throws javax.net.ssl.SSLException {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            java.lang.String r7 = "srcs"
            io.netty.util.internal.ObjectUtil.checkNotNullWithIAE(r0, r7)
            int r7 = r0.length
            if (r2 >= r7) goto L_0x031c
            int r7 = r2 + r3
            int r8 = r0.length
            if (r7 > r8) goto L_0x031c
            java.lang.String r3 = "dsts"
            io.netty.util.internal.ObjectUtil.checkNotNullWithIAE(r4, r3)
            int r3 = r4.length
            if (r5 >= r3) goto L_0x02ef
            int r3 = r5 + r6
            int r8 = r4.length
            if (r3 > r8) goto L_0x02ef
            r6 = r5
            r10 = 0
        L_0x002b:
            if (r6 >= r3) goto L_0x004c
            r12 = r4[r6]
            java.lang.String r13 = "dsts"
            java.lang.Object r12 = io.netty.util.internal.ObjectUtil.checkNotNullArrayParam(r12, r6, r13)
            java.nio.ByteBuffer r12 = (java.nio.ByteBuffer) r12
            boolean r13 = r12.isReadOnly()
            if (r13 != 0) goto L_0x0046
            int r12 = r12.remaining()
            long r12 = (long) r12
            long r10 = r10 + r12
            int r6 = r6 + 1
            goto L_0x002b
        L_0x0046:
            java.nio.ReadOnlyBufferException r0 = new java.nio.ReadOnlyBufferException
            r0.<init>()
            throw r0
        L_0x004c:
            r6 = r2
            r12 = 0
        L_0x004f:
            if (r6 >= r7) goto L_0x0064
            r14 = r0[r6]
            java.lang.String r15 = "srcs"
            java.lang.Object r14 = io.netty.util.internal.ObjectUtil.checkNotNullArrayParam(r14, r6, r15)
            java.nio.ByteBuffer r14 = (java.nio.ByteBuffer) r14
            int r14 = r14.remaining()
            long r14 = (long) r14
            long r12 = r12 + r14
            int r6 = r6 + 1
            goto L_0x004f
        L_0x0064:
            monitor-enter(r18)
            boolean r6 = r18.isInboundDone()     // Catch:{ all -> 0x007b }
            if (r6 == 0) goto L_0x0082
            boolean r0 = r18.isOutboundDone()     // Catch:{ all -> 0x007b }
            if (r0 != 0) goto L_0x007e
            boolean r0 = r18.isDestroyed()     // Catch:{ all -> 0x007b }
            if (r0 == 0) goto L_0x0078
            goto L_0x007e
        L_0x0078:
            javax.net.ssl.SSLEngineResult r0 = NEED_WRAP_CLOSED     // Catch:{ all -> 0x007b }
            goto L_0x0080
        L_0x007b:
            r0 = move-exception
            goto L_0x02ed
        L_0x007e:
            javax.net.ssl.SSLEngineResult r0 = CLOSED_NOT_HANDSHAKING     // Catch:{ all -> 0x007b }
        L_0x0080:
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x0082:
            javax.net.ssl.SSLEngineResult$HandshakeStatus r6 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING     // Catch:{ all -> 0x007b }
            io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r14 = r1.handshakeState     // Catch:{ all -> 0x007b }
            io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r15 = io.netty.handler.ssl.ReferenceCountedOpenSslEngine.HandshakeState.FINISHED     // Catch:{ all -> 0x007b }
            r8 = 0
            if (r14 == r15) goto L_0x00b1
            io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r6 = io.netty.handler.ssl.ReferenceCountedOpenSslEngine.HandshakeState.STARTED_EXPLICITLY     // Catch:{ all -> 0x007b }
            if (r14 == r6) goto L_0x0093
            io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r6 = io.netty.handler.ssl.ReferenceCountedOpenSslEngine.HandshakeState.STARTED_IMPLICITLY     // Catch:{ all -> 0x007b }
            r1.handshakeState = r6     // Catch:{ all -> 0x007b }
        L_0x0093:
            javax.net.ssl.SSLEngineResult$HandshakeStatus r6 = r18.handshake()     // Catch:{ all -> 0x007b }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r9 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_TASK     // Catch:{ all -> 0x007b }
            if (r6 != r9) goto L_0x00a1
            javax.net.ssl.SSLEngineResult r0 = r1.newResult(r6, r8, r8)     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x00a1:
            javax.net.ssl.SSLEngineResult$HandshakeStatus r9 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP     // Catch:{ all -> 0x007b }
            if (r6 != r9) goto L_0x00a9
            javax.net.ssl.SSLEngineResult r0 = NEED_WRAP_OK     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x00a9:
            boolean r9 = r1.isInboundDone     // Catch:{ all -> 0x007b }
            if (r9 == 0) goto L_0x00b1
            javax.net.ssl.SSLEngineResult r0 = NEED_WRAP_CLOSED     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x00b1:
            int r9 = r18.sslPending0()     // Catch:{ all -> 0x007b }
            boolean r14 = r1.jdkCompatibilityMode     // Catch:{ all -> 0x007b }
            if (r14 == 0) goto L_0x0126
            r14 = 5
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x00c7
            javax.net.ssl.SSLEngineResult$Status r0 = javax.net.ssl.SSLEngineResult.Status.BUFFER_UNDERFLOW     // Catch:{ all -> 0x007b }
            javax.net.ssl.SSLEngineResult r0 = r1.newResultMayFinishHandshake(r0, r6, r8, r8)     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x00c7:
            int r14 = io.netty.handler.ssl.SslUtils.getEncryptedPacketLength((java.nio.ByteBuffer[]) r19, (int) r20)     // Catch:{ all -> 0x007b }
            r15 = -2
            if (r14 == r15) goto L_0x011e
            int r15 = r14 + -5
            r21 = r9
            long r8 = (long) r15     // Catch:{ all -> 0x007b }
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 <= 0) goto L_0x010e
            int r0 = MAX_RECORD_SIZE     // Catch:{ all -> 0x007b }
            if (r15 > r0) goto L_0x00e9
            io.netty.handler.ssl.OpenSslSession r0 = r1.session     // Catch:{ all -> 0x007b }
            r0.tryExpandApplicationBufferSize(r15)     // Catch:{ all -> 0x007b }
            javax.net.ssl.SSLEngineResult$Status r0 = javax.net.ssl.SSLEngineResult.Status.BUFFER_OVERFLOW     // Catch:{ all -> 0x007b }
            r2 = 0
            javax.net.ssl.SSLEngineResult r0 = r1.newResultMayFinishHandshake(r0, r6, r2, r2)     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x00e9:
            javax.net.ssl.SSLException r0 = new javax.net.ssl.SSLException     // Catch:{ all -> 0x007b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x007b }
            r2.<init>()     // Catch:{ all -> 0x007b }
            java.lang.String r3 = "Illegal packet length: "
            r2.append(r3)     // Catch:{ all -> 0x007b }
            r2.append(r15)     // Catch:{ all -> 0x007b }
            java.lang.String r3 = " > "
            r2.append(r3)     // Catch:{ all -> 0x007b }
            io.netty.handler.ssl.OpenSslSession r3 = r1.session     // Catch:{ all -> 0x007b }
            int r3 = r3.getApplicationBufferSize()     // Catch:{ all -> 0x007b }
            r2.append(r3)     // Catch:{ all -> 0x007b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x007b }
            r0.<init>(r2)     // Catch:{ all -> 0x007b }
            throw r0     // Catch:{ all -> 0x007b }
        L_0x010e:
            long r8 = (long) r14     // Catch:{ all -> 0x007b }
            int r8 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x011c
            javax.net.ssl.SSLEngineResult$Status r0 = javax.net.ssl.SSLEngineResult.Status.BUFFER_UNDERFLOW     // Catch:{ all -> 0x007b }
            r2 = 0
            javax.net.ssl.SSLEngineResult r0 = r1.newResultMayFinishHandshake(r0, r6, r2, r2)     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x011c:
            r8 = 0
            goto L_0x0151
        L_0x011e:
            io.netty.handler.ssl.NotSslRecordException r0 = new io.netty.handler.ssl.NotSslRecordException     // Catch:{ all -> 0x007b }
            java.lang.String r2 = "not an SSL/TLS record"
            r0.<init>((java.lang.String) r2)     // Catch:{ all -> 0x007b }
            throw r0     // Catch:{ all -> 0x007b }
        L_0x0126:
            r21 = r9
            r8 = 0
            int r14 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r14 != 0) goto L_0x0139
            if (r21 > 0) goto L_0x0139
            javax.net.ssl.SSLEngineResult$Status r0 = javax.net.ssl.SSLEngineResult.Status.BUFFER_UNDERFLOW     // Catch:{ all -> 0x007b }
            r2 = 0
            javax.net.ssl.SSLEngineResult r0 = r1.newResultMayFinishHandshake(r0, r6, r2, r2)     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x0139:
            r8 = 0
            int r8 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x0148
            javax.net.ssl.SSLEngineResult$Status r0 = javax.net.ssl.SSLEngineResult.Status.BUFFER_OVERFLOW     // Catch:{ all -> 0x007b }
            r8 = 0
            javax.net.ssl.SSLEngineResult r0 = r1.newResultMayFinishHandshake(r0, r6, r8, r8)     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x0148:
            r8 = 0
            r9 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r9 = java.lang.Math.min(r9, r12)     // Catch:{ all -> 0x007b }
            int r14 = (int) r9
        L_0x0151:
            r10 = r21
            r9 = r8
        L_0x0154:
            r11 = r0[r2]     // Catch:{ all -> 0x016c }
            int r12 = r11.remaining()     // Catch:{ all -> 0x016c }
            if (r12 != 0) goto L_0x016f
            if (r10 > 0) goto L_0x0164
            int r2 = r2 + 1
            if (r2 < r7) goto L_0x0154
            goto L_0x0283
        L_0x0164:
            long r12 = r1.networkBIO     // Catch:{ all -> 0x016c }
            int r12 = io.netty.internal.tcnative.SSL.bioLengthByteBuffer(r12)     // Catch:{ all -> 0x016c }
            r13 = 0
            goto L_0x0177
        L_0x016c:
            r0 = move-exception
            goto L_0x02e4
        L_0x016f:
            int r12 = java.lang.Math.min(r14, r12)     // Catch:{ all -> 0x016c }
            io.netty.buffer.ByteBuf r13 = r1.writeEncryptedData(r11, r12)     // Catch:{ SSLException -> 0x02d4 }
        L_0x0177:
            r15 = r4[r5]     // Catch:{ all -> 0x01c3 }
            boolean r16 = r15.hasRemaining()     // Catch:{ all -> 0x01c3 }
            if (r16 != 0) goto L_0x018a
            int r5 = r5 + 1
            if (r5 < r3) goto L_0x0177
            if (r13 == 0) goto L_0x0283
        L_0x0185:
            r13.release()     // Catch:{ all -> 0x016c }
            goto L_0x0283
        L_0x018a:
            r20 = r10
            int r10 = r1.readPlaintextData(r15)     // Catch:{ SSLException -> 0x02b9 }
            r17 = r6
            r16 = r7
            long r6 = r1.networkBIO     // Catch:{ all -> 0x01c3 }
            int r6 = io.netty.internal.tcnative.SSL.bioLengthByteBuffer(r6)     // Catch:{ all -> 0x01c3 }
            int r6 = r12 - r6
            int r8 = r8 + r6
            int r14 = r14 - r6
            int r12 = r12 - r6
            int r7 = r11.position()     // Catch:{ all -> 0x01c3 }
            int r7 = r7 + r6
            r11.position(r7)     // Catch:{ all -> 0x01c3 }
            if (r10 <= 0) goto L_0x01fa
            int r9 = r9 + r10
            boolean r6 = r15.hasRemaining()     // Catch:{ all -> 0x01c3 }
            if (r6 != 0) goto L_0x01e9
            int r10 = r18.sslPending0()     // Catch:{ all -> 0x01c3 }
            int r5 = r5 + 1
            if (r5 < r3) goto L_0x01e6
            if (r10 <= 0) goto L_0x01c6
            javax.net.ssl.SSLEngineResult$Status r0 = javax.net.ssl.SSLEngineResult.Status.BUFFER_OVERFLOW     // Catch:{ all -> 0x01c3 }
            r6 = r17
            javax.net.ssl.SSLEngineResult r0 = r1.newResult(r0, r6, r8, r9)     // Catch:{ all -> 0x01c3 }
            goto L_0x01d7
        L_0x01c3:
            r0 = move-exception
            goto L_0x02ce
        L_0x01c6:
            r6 = r17
            boolean r0 = r18.isInboundDone()     // Catch:{ all -> 0x01c3 }
            if (r0 == 0) goto L_0x01d1
            javax.net.ssl.SSLEngineResult$Status r0 = javax.net.ssl.SSLEngineResult.Status.CLOSED     // Catch:{ all -> 0x01c3 }
            goto L_0x01d3
        L_0x01d1:
            javax.net.ssl.SSLEngineResult$Status r0 = javax.net.ssl.SSLEngineResult.Status.OK     // Catch:{ all -> 0x01c3 }
        L_0x01d3:
            javax.net.ssl.SSLEngineResult r0 = r1.newResultMayFinishHandshake(r0, r6, r8, r9)     // Catch:{ all -> 0x01c3 }
        L_0x01d7:
            if (r13 == 0) goto L_0x01dc
            r13.release()     // Catch:{ all -> 0x016c }
        L_0x01dc:
            long r2 = r1.networkBIO     // Catch:{ all -> 0x007b }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r2)     // Catch:{ all -> 0x007b }
            r18.rejectRemoteInitiatedRenegotiation()     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x01e6:
            r6 = r17
            goto L_0x01f4
        L_0x01e9:
            r6 = r17
            if (r14 == 0) goto L_0x01f7
            boolean r7 = r1.jdkCompatibilityMode     // Catch:{ all -> 0x01c3 }
            if (r7 == 0) goto L_0x01f2
            goto L_0x01f7
        L_0x01f2:
            r10 = r20
        L_0x01f4:
            r7 = r16
            goto L_0x0177
        L_0x01f7:
            if (r13 == 0) goto L_0x0283
            goto L_0x0185
        L_0x01fa:
            r6 = r17
            long r11 = r1.ssl     // Catch:{ all -> 0x01c3 }
            int r7 = io.netty.internal.tcnative.SSL.getError(r11, r10)     // Catch:{ all -> 0x01c3 }
            int r10 = io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_READ     // Catch:{ all -> 0x01c3 }
            if (r7 == r10) goto L_0x0279
            int r10 = io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_WRITE     // Catch:{ all -> 0x01c3 }
            if (r7 != r10) goto L_0x020c
            goto L_0x0279
        L_0x020c:
            int r0 = io.netty.internal.tcnative.SSL.SSL_ERROR_ZERO_RETURN     // Catch:{ all -> 0x01c3 }
            if (r7 != r0) goto L_0x0235
            boolean r0 = r1.receivedShutdown     // Catch:{ all -> 0x01c3 }
            if (r0 != 0) goto L_0x0217
            r18.closeAll()     // Catch:{ all -> 0x01c3 }
        L_0x0217:
            boolean r0 = r18.isInboundDone()     // Catch:{ all -> 0x01c3 }
            if (r0 == 0) goto L_0x0220
            javax.net.ssl.SSLEngineResult$Status r0 = javax.net.ssl.SSLEngineResult.Status.CLOSED     // Catch:{ all -> 0x01c3 }
            goto L_0x0222
        L_0x0220:
            javax.net.ssl.SSLEngineResult$Status r0 = javax.net.ssl.SSLEngineResult.Status.OK     // Catch:{ all -> 0x01c3 }
        L_0x0222:
            javax.net.ssl.SSLEngineResult r0 = r1.newResultMayFinishHandshake(r0, r6, r8, r9)     // Catch:{ all -> 0x01c3 }
            if (r13 == 0) goto L_0x022b
            r13.release()     // Catch:{ all -> 0x016c }
        L_0x022b:
            long r2 = r1.networkBIO     // Catch:{ all -> 0x007b }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r2)     // Catch:{ all -> 0x007b }
            r18.rejectRemoteInitiatedRenegotiation()     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x0235:
            int r0 = io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_X509_LOOKUP     // Catch:{ all -> 0x01c3 }
            if (r7 == r0) goto L_0x0259
            int r0 = io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY     // Catch:{ all -> 0x01c3 }
            if (r7 == r0) goto L_0x0259
            int r0 = io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION     // Catch:{ all -> 0x01c3 }
            if (r7 != r0) goto L_0x0242
            goto L_0x0259
        L_0x0242:
            int r0 = io.netty.internal.tcnative.SSL.getLastErrorNumber()     // Catch:{ all -> 0x01c3 }
            javax.net.ssl.SSLEngineResult r0 = r1.sslReadErrorResult(r7, r0, r8, r9)     // Catch:{ all -> 0x01c3 }
            if (r13 == 0) goto L_0x024f
            r13.release()     // Catch:{ all -> 0x016c }
        L_0x024f:
            long r2 = r1.networkBIO     // Catch:{ all -> 0x007b }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r2)     // Catch:{ all -> 0x007b }
            r18.rejectRemoteInitiatedRenegotiation()     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x0259:
            boolean r0 = r18.isInboundDone()     // Catch:{ all -> 0x01c3 }
            if (r0 == 0) goto L_0x0262
            javax.net.ssl.SSLEngineResult$Status r0 = javax.net.ssl.SSLEngineResult.Status.CLOSED     // Catch:{ all -> 0x01c3 }
            goto L_0x0264
        L_0x0262:
            javax.net.ssl.SSLEngineResult$Status r0 = javax.net.ssl.SSLEngineResult.Status.OK     // Catch:{ all -> 0x01c3 }
        L_0x0264:
            javax.net.ssl.SSLEngineResult$HandshakeStatus r2 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_TASK     // Catch:{ all -> 0x01c3 }
            javax.net.ssl.SSLEngineResult r0 = r1.newResult(r0, r2, r8, r9)     // Catch:{ all -> 0x01c3 }
            if (r13 == 0) goto L_0x026f
            r13.release()     // Catch:{ all -> 0x016c }
        L_0x026f:
            long r2 = r1.networkBIO     // Catch:{ all -> 0x007b }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r2)     // Catch:{ all -> 0x007b }
            r18.rejectRemoteInitiatedRenegotiation()     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x0279:
            int r2 = r2 + 1
            r7 = r16
            if (r2 < r7) goto L_0x02b0
            if (r13 == 0) goto L_0x0283
            goto L_0x0185
        L_0x0283:
            long r2 = r1.networkBIO     // Catch:{ all -> 0x007b }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r2)     // Catch:{ all -> 0x007b }
            r18.rejectRemoteInitiatedRenegotiation()     // Catch:{ all -> 0x007b }
            boolean r0 = r1.receivedShutdown     // Catch:{ all -> 0x007b }
            if (r0 != 0) goto L_0x029f
            long r2 = r1.ssl     // Catch:{ all -> 0x007b }
            int r0 = io.netty.internal.tcnative.SSL.getShutdown(r2)     // Catch:{ all -> 0x007b }
            int r2 = io.netty.internal.tcnative.SSL.SSL_RECEIVED_SHUTDOWN     // Catch:{ all -> 0x007b }
            r0 = r0 & r2
            int r2 = io.netty.internal.tcnative.SSL.SSL_RECEIVED_SHUTDOWN     // Catch:{ all -> 0x007b }
            if (r0 != r2) goto L_0x029f
            r18.closeAll()     // Catch:{ all -> 0x007b }
        L_0x029f:
            boolean r0 = r18.isInboundDone()     // Catch:{ all -> 0x007b }
            if (r0 == 0) goto L_0x02a8
            javax.net.ssl.SSLEngineResult$Status r0 = javax.net.ssl.SSLEngineResult.Status.CLOSED     // Catch:{ all -> 0x007b }
            goto L_0x02aa
        L_0x02a8:
            javax.net.ssl.SSLEngineResult$Status r0 = javax.net.ssl.SSLEngineResult.Status.OK     // Catch:{ all -> 0x007b }
        L_0x02aa:
            javax.net.ssl.SSLEngineResult r0 = r1.newResultMayFinishHandshake(r0, r6, r8, r9)     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x02b0:
            if (r13 == 0) goto L_0x02b5
            r13.release()     // Catch:{ all -> 0x016c }
        L_0x02b5:
            r10 = r20
            goto L_0x0154
        L_0x02b9:
            r0 = move-exception
            r2 = r0
            javax.net.ssl.SSLEngineResult r0 = r1.handleUnwrapException(r8, r9, r2)     // Catch:{ all -> 0x01c3 }
            if (r13 == 0) goto L_0x02c4
            r13.release()     // Catch:{ all -> 0x016c }
        L_0x02c4:
            long r2 = r1.networkBIO     // Catch:{ all -> 0x007b }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r2)     // Catch:{ all -> 0x007b }
            r18.rejectRemoteInitiatedRenegotiation()     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x02ce:
            if (r13 == 0) goto L_0x02d3
            r13.release()     // Catch:{ all -> 0x016c }
        L_0x02d3:
            throw r0     // Catch:{ all -> 0x016c }
        L_0x02d4:
            r0 = move-exception
            r2 = r0
            javax.net.ssl.SSLEngineResult r0 = r1.handleUnwrapException(r8, r9, r2)     // Catch:{ all -> 0x016c }
            long r2 = r1.networkBIO     // Catch:{ all -> 0x007b }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r2)     // Catch:{ all -> 0x007b }
            r18.rejectRemoteInitiatedRenegotiation()     // Catch:{ all -> 0x007b }
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            return r0
        L_0x02e4:
            long r2 = r1.networkBIO     // Catch:{ all -> 0x007b }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r2)     // Catch:{ all -> 0x007b }
            r18.rejectRemoteInitiatedRenegotiation()     // Catch:{ all -> 0x007b }
            throw r0     // Catch:{ all -> 0x007b }
        L_0x02ed:
            monitor-exit(r18)     // Catch:{ all -> 0x007b }
            throw r0
        L_0x02ef:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "offset: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = ", length: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " (expected: offset <= offset + length <= dsts.length ("
            r1.append(r2)
            int r2 = r4.length
            r1.append(r2)
            java.lang.String r2 = "))"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x031c:
            java.lang.IndexOutOfBoundsException r1 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "offset: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = ", length: "
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = " (expected: offset <= offset + length <= srcs.length ("
            r4.append(r2)
            int r0 = r0.length
            r4.append(r0)
            java.lang.String r0 = "))"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.unwrap(java.nio.ByteBuffer[], int, int, java.nio.ByteBuffer[], int, int):javax.net.ssl.SSLEngineResult");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0184, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01b1, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01e5, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0222, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0251, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x027f, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x02f0, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x031c, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0035, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0370, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x03b7, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x0410, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0436, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x0460, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x048c, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x04b2, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x04ec, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x0510, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ae, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e0, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0110, code lost:
        return r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x013d, code lost:
        return r12;
     */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x0523 A[Catch:{ all -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x0532 A[Catch:{ all -> 0x002f }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:147:0x0232=Splitter:B:147:0x0232, B:341:0x051c=Splitter:B:341:0x051c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final javax.net.ssl.SSLEngineResult wrap(java.nio.ByteBuffer[] r12, int r13, int r14, java.nio.ByteBuffer r15) throws javax.net.ssl.SSLException {
        /*
            r11 = this;
            java.lang.String r0 = "srcs"
            io.netty.util.internal.ObjectUtil.checkNotNullWithIAE(r12, r0)
            java.lang.String r0 = "dst"
            io.netty.util.internal.ObjectUtil.checkNotNullWithIAE(r15, r0)
            int r0 = r12.length
            if (r13 >= r0) goto L_0x0543
            int r0 = r13 + r14
            int r1 = r12.length
            if (r0 > r1) goto L_0x0543
            boolean r14 = r15.isReadOnly()
            if (r14 != 0) goto L_0x053d
            monitor-enter(r11)
            boolean r14 = r11.isOutboundDone()     // Catch:{ all -> 0x002f }
            if (r14 == 0) goto L_0x0036
            boolean r12 = r11.isInboundDone()     // Catch:{ all -> 0x002f }
            if (r12 != 0) goto L_0x0032
            boolean r12 = r11.isDestroyed()     // Catch:{ all -> 0x002f }
            if (r12 == 0) goto L_0x002c
            goto L_0x0032
        L_0x002c:
            javax.net.ssl.SSLEngineResult r12 = NEED_UNWRAP_CLOSED     // Catch:{ all -> 0x002f }
            goto L_0x0034
        L_0x002f:
            r12 = move-exception
            goto L_0x053b
        L_0x0032:
            javax.net.ssl.SSLEngineResult r12 = CLOSED_NOT_HANDSHAKING     // Catch:{ all -> 0x002f }
        L_0x0034:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x0036:
            r14 = 0
            r1 = 0
            boolean r2 = r15.isDirect()     // Catch:{ all -> 0x0054 }
            if (r2 == 0) goto L_0x0057
            long r3 = r11.networkBIO     // Catch:{ all -> 0x0054 }
            long r5 = bufferAddress(r15)     // Catch:{ all -> 0x0054 }
            int r2 = r15.position()     // Catch:{ all -> 0x0054 }
            long r7 = (long) r2     // Catch:{ all -> 0x0054 }
            long r5 = r5 + r7
            int r7 = r15.remaining()     // Catch:{ all -> 0x0054 }
            r8 = 1
            io.netty.internal.tcnative.SSL.bioSetByteBuffer(r3, r5, r7, r8)     // Catch:{ all -> 0x0054 }
            r2 = r14
            goto L_0x006f
        L_0x0054:
            r12 = move-exception
            goto L_0x051c
        L_0x0057:
            io.netty.buffer.ByteBufAllocator r2 = r11.alloc     // Catch:{ all -> 0x0054 }
            int r3 = r15.remaining()     // Catch:{ all -> 0x0054 }
            io.netty.buffer.ByteBuf r2 = r2.directBuffer(r3)     // Catch:{ all -> 0x0054 }
            long r3 = r11.networkBIO     // Catch:{ all -> 0x00af }
            long r5 = io.netty.handler.ssl.OpenSsl.memoryAddress(r2)     // Catch:{ all -> 0x00af }
            int r7 = r2.writableBytes()     // Catch:{ all -> 0x00af }
            r8 = 1
            io.netty.internal.tcnative.SSL.bioSetByteBuffer(r3, r5, r7, r8)     // Catch:{ all -> 0x00af }
        L_0x006f:
            long r3 = r11.networkBIO     // Catch:{ all -> 0x00af }
            int r3 = io.netty.internal.tcnative.SSL.bioLengthByteBuffer(r3)     // Catch:{ all -> 0x00af }
            boolean r4 = r11.outboundClosed     // Catch:{ all -> 0x00af }
            r5 = 1
            if (r4 == 0) goto L_0x0143
            int r12 = r15.remaining()     // Catch:{ all -> 0x00af }
            r13 = 2
            boolean r12 = r11.isBytesAvailableEnoughForWrap(r12, r13, r5)     // Catch:{ all -> 0x00af }
            if (r12 != 0) goto L_0x00b3
            javax.net.ssl.SSLEngineResult r12 = new javax.net.ssl.SSLEngineResult     // Catch:{ all -> 0x00af }
            javax.net.ssl.SSLEngineResult$Status r13 = javax.net.ssl.SSLEngineResult.Status.BUFFER_OVERFLOW     // Catch:{ all -> 0x00af }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r14 = r11.getHandshakeStatus()     // Catch:{ all -> 0x00af }
            r12.<init>(r13, r14, r1, r1)     // Catch:{ all -> 0x00af }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x009f
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x00ad
        L_0x009f:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r1)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x00ad:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x00af:
            r12 = move-exception
        L_0x00b0:
            r14 = r2
            goto L_0x051c
        L_0x00b3:
            long r12 = r11.networkBIO     // Catch:{ all -> 0x00af }
            int r12 = io.netty.internal.tcnative.SSL.bioFlushByteBuffer(r12)     // Catch:{ all -> 0x00af }
            if (r12 > 0) goto L_0x00e5
            javax.net.ssl.SSLEngineResult$HandshakeStatus r13 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING     // Catch:{ all -> 0x00e1 }
            javax.net.ssl.SSLEngineResult r13 = r11.newResultMayFinishHandshake(r13, r1, r1)     // Catch:{ all -> 0x00e1 }
            long r0 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r0)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x00d1
            int r14 = r15.position()     // Catch:{ all -> 0x002f }
            int r14 = r14 + r12
            r15.position(r14)     // Catch:{ all -> 0x002f }
            goto L_0x00df
        L_0x00d1:
            int r14 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r12 = r2.internalNioBuffer(r14, r12)     // Catch:{ all -> 0x002f }
            r15.put(r12)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x00df:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r13
        L_0x00e1:
            r13 = move-exception
            r1 = r12
            r12 = r13
            goto L_0x00b0
        L_0x00e5:
            boolean r13 = r11.doSSLShutdown()     // Catch:{ all -> 0x00e1 }
            if (r13 != 0) goto L_0x0111
            javax.net.ssl.SSLEngineResult$HandshakeStatus r13 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING     // Catch:{ all -> 0x00e1 }
            javax.net.ssl.SSLEngineResult r13 = r11.newResultMayFinishHandshake(r13, r1, r12)     // Catch:{ all -> 0x00e1 }
            long r0 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r0)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0101
            int r14 = r15.position()     // Catch:{ all -> 0x002f }
            int r14 = r14 + r12
            r15.position(r14)     // Catch:{ all -> 0x002f }
            goto L_0x010f
        L_0x0101:
            int r14 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r12 = r2.internalNioBuffer(r14, r12)     // Catch:{ all -> 0x002f }
            r15.put(r12)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x010f:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r13
        L_0x0111:
            long r13 = r11.networkBIO     // Catch:{ all -> 0x00e1 }
            int r12 = io.netty.internal.tcnative.SSL.bioLengthByteBuffer(r13)     // Catch:{ all -> 0x00e1 }
            int r3 = r3 - r12
            javax.net.ssl.SSLEngineResult$HandshakeStatus r12 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP     // Catch:{ all -> 0x013e }
            javax.net.ssl.SSLEngineResult r12 = r11.newResultMayFinishHandshake(r12, r1, r3)     // Catch:{ all -> 0x013e }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x012e
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r3
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x013c
        L_0x012e:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r3)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x013c:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x013e:
            r12 = move-exception
            r14 = r2
            r1 = r3
            goto L_0x051c
        L_0x0143:
            javax.net.ssl.SSLEngineResult$HandshakeStatus r4 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING     // Catch:{ all -> 0x00af }
            io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r6 = r11.handshakeState     // Catch:{ all -> 0x00af }
            io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r7 = io.netty.handler.ssl.ReferenceCountedOpenSslEngine.HandshakeState.FINISHED     // Catch:{ all -> 0x00af }
            if (r6 == r7) goto L_0x0280
            io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r4 = io.netty.handler.ssl.ReferenceCountedOpenSslEngine.HandshakeState.STARTED_EXPLICITLY     // Catch:{ all -> 0x00af }
            if (r6 == r4) goto L_0x0153
            io.netty.handler.ssl.ReferenceCountedOpenSslEngine$HandshakeState r4 = io.netty.handler.ssl.ReferenceCountedOpenSslEngine.HandshakeState.STARTED_IMPLICITLY     // Catch:{ all -> 0x00af }
            r11.handshakeState = r4     // Catch:{ all -> 0x00af }
        L_0x0153:
            long r6 = r11.networkBIO     // Catch:{ all -> 0x00af }
            int r4 = io.netty.internal.tcnative.SSL.bioFlushByteBuffer(r6)     // Catch:{ all -> 0x00af }
            java.lang.Throwable r6 = r11.pendingException     // Catch:{ all -> 0x0185 }
            if (r6 == 0) goto L_0x01b2
            if (r4 <= 0) goto L_0x018a
            javax.net.ssl.SSLEngineResult$HandshakeStatus r12 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP     // Catch:{ all -> 0x0185 }
            javax.net.ssl.SSLEngineResult r12 = r11.newResult(r12, r1, r4)     // Catch:{ all -> 0x0185 }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0175
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r4
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x0183
        L_0x0175:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r4)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x0183:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x0185:
            r12 = move-exception
            r14 = r2
            r1 = r4
            goto L_0x051c
        L_0x018a:
            javax.net.ssl.SSLEngineResult$HandshakeStatus r12 = r11.handshakeException()     // Catch:{ all -> 0x0185 }
            javax.net.ssl.SSLEngineResult r12 = r11.newResult(r12, r1, r1)     // Catch:{ all -> 0x0185 }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x01a2
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r4
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x01b0
        L_0x01a2:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r4)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x01b0:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x01b2:
            javax.net.ssl.SSLEngineResult$HandshakeStatus r6 = r11.handshake()     // Catch:{ all -> 0x0185 }
            long r7 = r11.networkBIO     // Catch:{ all -> 0x0185 }
            int r4 = io.netty.internal.tcnative.SSL.bioLengthByteBuffer(r7)     // Catch:{ all -> 0x0185 }
            int r4 = r3 - r4
            javax.net.ssl.SSLEngineResult$HandshakeStatus r7 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_TASK     // Catch:{ all -> 0x0185 }
            if (r6 != r7) goto L_0x01e6
            javax.net.ssl.SSLEngineResult r12 = r11.newResult(r6, r1, r4)     // Catch:{ all -> 0x0185 }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x01d6
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r4
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x01e4
        L_0x01d6:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r4)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x01e4:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x01e6:
            if (r4 <= 0) goto L_0x0223
            javax.net.ssl.SSLEngineResult$HandshakeStatus r12 = javax.net.ssl.SSLEngineResult.HandshakeStatus.FINISHED     // Catch:{ all -> 0x0185 }
            if (r6 == r12) goto L_0x01fb
            if (r4 != r3) goto L_0x01f1
            javax.net.ssl.SSLEngineResult$HandshakeStatus r12 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP     // Catch:{ all -> 0x0185 }
            goto L_0x01fb
        L_0x01f1:
            long r12 = r11.networkBIO     // Catch:{ all -> 0x0185 }
            int r12 = io.netty.internal.tcnative.SSL.bioLengthNonApplication(r12)     // Catch:{ all -> 0x0185 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r12 = r11.getHandshakeStatus(r12)     // Catch:{ all -> 0x0185 }
        L_0x01fb:
            javax.net.ssl.SSLEngineResult$HandshakeStatus r12 = r11.mayFinishHandshake(r12)     // Catch:{ all -> 0x0185 }
            javax.net.ssl.SSLEngineResult r12 = r11.newResult(r12, r1, r4)     // Catch:{ all -> 0x0185 }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0213
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r4
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x0221
        L_0x0213:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r4)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x0221:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x0223:
            javax.net.ssl.SSLEngineResult$HandshakeStatus r7 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_UNWRAP     // Catch:{ all -> 0x0185 }
            if (r6 != r7) goto L_0x0252
            boolean r12 = r11.isOutboundDone()     // Catch:{ all -> 0x0185 }
            if (r12 == 0) goto L_0x0230
            javax.net.ssl.SSLEngineResult r12 = NEED_UNWRAP_CLOSED     // Catch:{ all -> 0x0185 }
            goto L_0x0232
        L_0x0230:
            javax.net.ssl.SSLEngineResult r12 = NEED_UNWRAP_OK     // Catch:{ all -> 0x0185 }
        L_0x0232:
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0242
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r4
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x0250
        L_0x0242:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r4)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x0250:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x0252:
            boolean r7 = r11.outboundClosed     // Catch:{ all -> 0x0185 }
            if (r7 == 0) goto L_0x0282
            long r12 = r11.networkBIO     // Catch:{ all -> 0x0185 }
            int r12 = io.netty.internal.tcnative.SSL.bioFlushByteBuffer(r12)     // Catch:{ all -> 0x0185 }
            javax.net.ssl.SSLEngineResult r13 = r11.newResultMayFinishHandshake(r6, r1, r12)     // Catch:{ all -> 0x00e1 }
            long r0 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r0)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0270
            int r14 = r15.position()     // Catch:{ all -> 0x002f }
            int r14 = r14 + r12
            r15.position(r14)     // Catch:{ all -> 0x002f }
            goto L_0x027e
        L_0x0270:
            int r14 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r12 = r2.internalNioBuffer(r14, r12)     // Catch:{ all -> 0x002f }
            r15.put(r12)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x027e:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r13
        L_0x0280:
            r6 = r4
            r4 = r1
        L_0x0282:
            boolean r7 = r11.jdkCompatibilityMode     // Catch:{ all -> 0x0185 }
            if (r7 == 0) goto L_0x02f1
            r7 = r13
            r8 = r1
        L_0x0288:
            if (r7 >= r0) goto L_0x02bc
            r9 = r12[r7]     // Catch:{ all -> 0x0185 }
            if (r9 == 0) goto L_0x02a0
            int r10 = MAX_PLAINTEXT_LENGTH     // Catch:{ all -> 0x0185 }
            if (r8 != r10) goto L_0x0293
            goto L_0x029d
        L_0x0293:
            int r9 = r9.remaining()     // Catch:{ all -> 0x0185 }
            int r8 = r8 + r9
            if (r8 > r10) goto L_0x029c
            if (r8 >= 0) goto L_0x029d
        L_0x029c:
            r8 = r10
        L_0x029d:
            int r7 = r7 + 1
            goto L_0x0288
        L_0x02a0:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0185 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0185 }
            r13.<init>()     // Catch:{ all -> 0x0185 }
            java.lang.String r14 = "srcs["
            r13.append(r14)     // Catch:{ all -> 0x0185 }
            r13.append(r7)     // Catch:{ all -> 0x0185 }
            java.lang.String r14 = "] is null"
            r13.append(r14)     // Catch:{ all -> 0x0185 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0185 }
            r12.<init>(r13)     // Catch:{ all -> 0x0185 }
            throw r12     // Catch:{ all -> 0x0185 }
        L_0x02bc:
            int r7 = r15.remaining()     // Catch:{ all -> 0x0185 }
            boolean r5 = r11.isBytesAvailableEnoughForWrap(r7, r8, r5)     // Catch:{ all -> 0x0185 }
            if (r5 != 0) goto L_0x02f1
            javax.net.ssl.SSLEngineResult r12 = new javax.net.ssl.SSLEngineResult     // Catch:{ all -> 0x0185 }
            javax.net.ssl.SSLEngineResult$Status r13 = javax.net.ssl.SSLEngineResult.Status.BUFFER_OVERFLOW     // Catch:{ all -> 0x0185 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r14 = r11.getHandshakeStatus()     // Catch:{ all -> 0x0185 }
            r12.<init>(r13, r14, r1, r1)     // Catch:{ all -> 0x0185 }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x02e1
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r4
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x02ef
        L_0x02e1:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r4)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x02ef:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x02f1:
            long r7 = r11.networkBIO     // Catch:{ all -> 0x0185 }
            int r4 = io.netty.internal.tcnative.SSL.bioFlushByteBuffer(r7)     // Catch:{ all -> 0x0185 }
            if (r4 <= 0) goto L_0x031d
            javax.net.ssl.SSLEngineResult r12 = r11.newResultMayFinishHandshake(r6, r1, r4)     // Catch:{ all -> 0x0185 }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x030d
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r4
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x031b
        L_0x030d:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r4)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x031b:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x031d:
            java.lang.Throwable r5 = r11.pendingException     // Catch:{ all -> 0x0185 }
            if (r5 != 0) goto L_0x0511
        L_0x0321:
            if (r13 >= r0) goto L_0x04ed
            r14 = r12[r13]     // Catch:{ all -> 0x0185 }
            int r5 = r14.remaining()     // Catch:{ all -> 0x0185 }
            if (r5 != 0) goto L_0x032c
            goto L_0x0391
        L_0x032c:
            boolean r7 = r11.jdkCompatibilityMode     // Catch:{ all -> 0x0185 }
            if (r7 == 0) goto L_0x033c
            int r7 = MAX_PLAINTEXT_LENGTH     // Catch:{ all -> 0x0185 }
            int r7 = r7 - r1
            int r5 = java.lang.Math.min(r5, r7)     // Catch:{ all -> 0x0185 }
            int r14 = r11.writePlaintextData(r14, r5)     // Catch:{ all -> 0x0185 }
            goto L_0x0379
        L_0x033c:
            int r7 = r15.remaining()     // Catch:{ all -> 0x0185 }
            int r7 = r7 - r4
            int r8 = r11.maxWrapOverhead     // Catch:{ all -> 0x0185 }
            int r7 = r7 - r8
            if (r7 > 0) goto L_0x0371
            javax.net.ssl.SSLEngineResult r12 = new javax.net.ssl.SSLEngineResult     // Catch:{ all -> 0x0185 }
            javax.net.ssl.SSLEngineResult$Status r13 = javax.net.ssl.SSLEngineResult.Status.BUFFER_OVERFLOW     // Catch:{ all -> 0x0185 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r14 = r11.getHandshakeStatus()     // Catch:{ all -> 0x0185 }
            r12.<init>(r13, r14, r1, r4)     // Catch:{ all -> 0x0185 }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0361
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r4
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x036f
        L_0x0361:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r4)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x036f:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x0371:
            int r5 = java.lang.Math.min(r5, r7)     // Catch:{ all -> 0x0185 }
            int r14 = r11.writePlaintextData(r14, r5)     // Catch:{ all -> 0x0185 }
        L_0x0379:
            long r7 = r11.networkBIO     // Catch:{ all -> 0x0185 }
            int r5 = io.netty.internal.tcnative.SSL.bioLengthByteBuffer(r7)     // Catch:{ all -> 0x0185 }
            int r3 = r3 - r5
            int r3 = r3 + r4
            if (r14 <= 0) goto L_0x03b8
            int r1 = r1 + r14
            boolean r14 = r11.jdkCompatibilityMode     // Catch:{ all -> 0x013e }
            if (r14 != 0) goto L_0x0394
            int r14 = r15.remaining()     // Catch:{ all -> 0x013e }
            if (r3 != r14) goto L_0x038f
            goto L_0x0394
        L_0x038f:
            r4 = r3
            r3 = r5
        L_0x0391:
            int r13 = r13 + 1
            goto L_0x0321
        L_0x0394:
            javax.net.ssl.SSLEngineResult r12 = r11.newResultMayFinishHandshake(r6, r1, r3)     // Catch:{ all -> 0x013e }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x03a8
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r3
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x03b6
        L_0x03a8:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r3)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x03b6:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x03b8:
            long r12 = r11.ssl     // Catch:{ all -> 0x013e }
            int r12 = io.netty.internal.tcnative.SSL.getError(r12, r14)     // Catch:{ all -> 0x013e }
            int r13 = io.netty.internal.tcnative.SSL.SSL_ERROR_ZERO_RETURN     // Catch:{ all -> 0x013e }
            if (r12 != r13) goto L_0x0437
            boolean r12 = r11.receivedShutdown     // Catch:{ all -> 0x013e }
            if (r12 != 0) goto L_0x0411
            r11.closeAll()     // Catch:{ all -> 0x013e }
            long r12 = r11.networkBIO     // Catch:{ all -> 0x013e }
            int r12 = io.netty.internal.tcnative.SSL.bioLengthByteBuffer(r12)     // Catch:{ all -> 0x013e }
            int r5 = r5 - r12
            int r12 = r3 + r5
            javax.net.ssl.SSLEngineResult$HandshakeStatus r13 = javax.net.ssl.SSLEngineResult.HandshakeStatus.FINISHED     // Catch:{ all -> 0x00e1 }
            if (r6 == r13) goto L_0x03e9
            int r13 = r15.remaining()     // Catch:{ all -> 0x00e1 }
            if (r12 != r13) goto L_0x03df
            javax.net.ssl.SSLEngineResult$HandshakeStatus r13 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP     // Catch:{ all -> 0x00e1 }
            goto L_0x03e9
        L_0x03df:
            long r13 = r11.networkBIO     // Catch:{ all -> 0x00e1 }
            int r13 = io.netty.internal.tcnative.SSL.bioLengthNonApplication(r13)     // Catch:{ all -> 0x00e1 }
            javax.net.ssl.SSLEngineResult$HandshakeStatus r13 = r11.getHandshakeStatus(r13)     // Catch:{ all -> 0x00e1 }
        L_0x03e9:
            javax.net.ssl.SSLEngineResult$HandshakeStatus r13 = r11.mayFinishHandshake(r13)     // Catch:{ all -> 0x00e1 }
            javax.net.ssl.SSLEngineResult r13 = r11.newResult(r13, r1, r12)     // Catch:{ all -> 0x00e1 }
            long r0 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r0)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0401
            int r14 = r15.position()     // Catch:{ all -> 0x002f }
            int r14 = r14 + r12
            r15.position(r14)     // Catch:{ all -> 0x002f }
            goto L_0x040f
        L_0x0401:
            int r14 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r12 = r2.internalNioBuffer(r14, r12)     // Catch:{ all -> 0x002f }
            r15.put(r12)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x040f:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r13
        L_0x0411:
            javax.net.ssl.SSLEngineResult$HandshakeStatus r12 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING     // Catch:{ all -> 0x013e }
            javax.net.ssl.SSLEngineResult r12 = r11.newResult(r12, r1, r3)     // Catch:{ all -> 0x013e }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0427
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r3
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x0435
        L_0x0427:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r3)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x0435:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x0437:
            int r13 = io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_READ     // Catch:{ all -> 0x013e }
            if (r12 != r13) goto L_0x0461
            javax.net.ssl.SSLEngineResult$HandshakeStatus r12 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_UNWRAP     // Catch:{ all -> 0x013e }
            javax.net.ssl.SSLEngineResult r12 = r11.newResult(r12, r1, r3)     // Catch:{ all -> 0x013e }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0451
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r3
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x045f
        L_0x0451:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r3)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x045f:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x0461:
            int r13 = io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_WRITE     // Catch:{ all -> 0x013e }
            if (r12 != r13) goto L_0x04b3
            if (r3 <= 0) goto L_0x048d
            javax.net.ssl.SSLEngineResult$HandshakeStatus r12 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP     // Catch:{ all -> 0x013e }
            javax.net.ssl.SSLEngineResult r12 = r11.newResult(r12, r1, r3)     // Catch:{ all -> 0x013e }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x047d
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r3
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x048b
        L_0x047d:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r3)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x048b:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x048d:
            javax.net.ssl.SSLEngineResult$Status r12 = javax.net.ssl.SSLEngineResult.Status.BUFFER_OVERFLOW     // Catch:{ all -> 0x013e }
            javax.net.ssl.SSLEngineResult r12 = r11.newResult(r12, r6, r1, r3)     // Catch:{ all -> 0x013e }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x04a3
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r3
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x04b1
        L_0x04a3:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r3)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x04b1:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x04b3:
            int r13 = io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_X509_LOOKUP     // Catch:{ all -> 0x013e }
            if (r12 == r13) goto L_0x04c7
            int r13 = io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY     // Catch:{ all -> 0x013e }
            if (r12 == r13) goto L_0x04c7
            int r13 = io.netty.internal.tcnative.SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION     // Catch:{ all -> 0x013e }
            if (r12 != r13) goto L_0x04c0
            goto L_0x04c7
        L_0x04c0:
            java.lang.String r13 = "SSL_write"
            javax.net.ssl.SSLException r12 = r11.shutdownWithError(r13, r12)     // Catch:{ all -> 0x013e }
            throw r12     // Catch:{ all -> 0x013e }
        L_0x04c7:
            javax.net.ssl.SSLEngineResult$HandshakeStatus r12 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_TASK     // Catch:{ all -> 0x013e }
            javax.net.ssl.SSLEngineResult r12 = r11.newResult(r12, r1, r3)     // Catch:{ all -> 0x013e }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x04dd
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r3
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x04eb
        L_0x04dd:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r3)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x04eb:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x04ed:
            javax.net.ssl.SSLEngineResult r12 = r11.newResultMayFinishHandshake(r6, r1, r4)     // Catch:{ all -> 0x0185 }
            long r13 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r13)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0501
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r4
            r15.position(r13)     // Catch:{ all -> 0x002f }
            goto L_0x050f
        L_0x0501:
            int r13 = r2.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r2.internalNioBuffer(r13, r4)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r2.release()     // Catch:{ all -> 0x002f }
        L_0x050f:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            return r12
        L_0x0511:
            r11.pendingException = r14     // Catch:{ all -> 0x0185 }
            r11.shutdown()     // Catch:{ all -> 0x0185 }
            javax.net.ssl.SSLException r12 = new javax.net.ssl.SSLException     // Catch:{ all -> 0x0185 }
            r12.<init>(r5)     // Catch:{ all -> 0x0185 }
            throw r12     // Catch:{ all -> 0x0185 }
        L_0x051c:
            long r2 = r11.networkBIO     // Catch:{ all -> 0x002f }
            io.netty.internal.tcnative.SSL.bioClearByteBuffer(r2)     // Catch:{ all -> 0x002f }
            if (r14 == 0) goto L_0x0532
            int r13 = r14.readerIndex()     // Catch:{ all -> 0x002f }
            java.nio.ByteBuffer r13 = r14.internalNioBuffer(r13, r1)     // Catch:{ all -> 0x002f }
            r15.put(r13)     // Catch:{ all -> 0x002f }
            r14.release()     // Catch:{ all -> 0x002f }
            goto L_0x053a
        L_0x0532:
            int r13 = r15.position()     // Catch:{ all -> 0x002f }
            int r13 = r13 + r1
            r15.position(r13)     // Catch:{ all -> 0x002f }
        L_0x053a:
            throw r12     // Catch:{ all -> 0x002f }
        L_0x053b:
            monitor-exit(r11)     // Catch:{ all -> 0x002f }
            throw r12
        L_0x053d:
            java.nio.ReadOnlyBufferException r11 = new java.nio.ReadOnlyBufferException
            r11.<init>()
            throw r11
        L_0x0543:
            java.lang.IndexOutOfBoundsException r11 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "offset: "
            r15.append(r0)
            r15.append(r13)
            java.lang.String r13 = ", length: "
            r15.append(r13)
            r15.append(r14)
            java.lang.String r13 = " (expected: offset <= offset + length <= srcs.length ("
            r15.append(r13)
            int r12 = r12.length
            r15.append(r12)
            java.lang.String r12 = "))"
            r15.append(r12)
            java.lang.String r12 = r15.toString()
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.wrap(java.nio.ByteBuffer[], int, int, java.nio.ByteBuffer):javax.net.ssl.SSLEngineResult");
    }

    /* access modifiers changed from: private */
    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    private SSLEngineResult newResult(SSLEngineResult.Status status, SSLEngineResult.HandshakeStatus handshakeStatus, int i, int i2) {
        if (isOutboundDone()) {
            if (isInboundDone()) {
                handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                shutdown();
            }
            return new SSLEngineResult(SSLEngineResult.Status.CLOSED, handshakeStatus, i, i2);
        }
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            this.needTask = true;
        }
        return new SSLEngineResult(status, handshakeStatus, i, i2);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.Status status, SSLEngineResult.HandshakeStatus handshakeStatus, int i, int i2) throws SSLException {
        return newResult(status, mayFinishHandshake(handshakeStatus, i, i2), i, i2);
    }

    private SSLException shutdownWithError(String str, int i, int i2) {
        String errorString = SSL.getErrorString((long) i2);
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} failed with {}: OpenSSL error: {} {}", str, Integer.valueOf(i), Integer.valueOf(i2), errorString);
        }
        shutdown();
        if (this.handshakeState == HandshakeState.FINISHED) {
            return new SSLException(errorString);
        }
        SSLHandshakeException sSLHandshakeException = new SSLHandshakeException(errorString);
        Throwable th = this.pendingException;
        if (th != null) {
            sSLHandshakeException.initCause(th);
            this.pendingException = null;
        }
        return sSLHandshakeException;
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

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            if (this.handshakeState != HandshakeState.FINISHED) {
                return handshake();
            }
            if (!isDestroyed() && SSL.bioLengthNonApplication(this.networkBIO) > 0) {
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            }
        }
        return handshakeStatus;
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int i) {
        if (!needPendingStatus()) {
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
        if (this.needTask) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        return pendingStatus(i);
    }

    private String selectApplicationProtocol(List<String> list, ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior, String str) throws SSLException {
        if (selectedListenerFailureBehavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT) {
            return str;
        }
        int size = list.size();
        if (list.contains(str)) {
            return str;
        }
        if (selectedListenerFailureBehavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL) {
            return list.get(size - 1);
        }
        throw new SSLException("unknown protocol " + str);
    }

    public final SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) throws SSLException {
        return unwrap(byteBufferArr, 0, byteBufferArr.length, byteBufferArr2, 0, byteBufferArr2.length);
    }

    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) throws SSLException {
        SSLEngineResult unwrap;
        try {
            unwrap = unwrap(singleSrcBuffer(byteBuffer), 0, 1, byteBufferArr, i, i2);
            resetSingleSrcBuffer();
        } catch (Throwable th) {
            resetSingleSrcBuffer();
            throw th;
        }
        return unwrap;
    }

    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        SSLEngineResult unwrap;
        try {
            unwrap = unwrap(singleSrcBuffer(byteBuffer), singleDstBuffer(byteBuffer2));
            resetSingleSrcBuffer();
            resetSingleDstBuffer();
        } catch (Throwable th) {
            resetSingleSrcBuffer();
            resetSingleDstBuffer();
            throw th;
        }
        return unwrap;
    }

    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        SSLEngineResult unwrap;
        try {
            unwrap = unwrap(singleSrcBuffer(byteBuffer), byteBufferArr);
            resetSingleSrcBuffer();
        } catch (Throwable th) {
            resetSingleSrcBuffer();
            throw th;
        }
        return unwrap;
    }

    public final synchronized SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        SSLEngineResult wrap;
        try {
            wrap = wrap(singleSrcBuffer(byteBuffer), byteBuffer2);
            resetSingleSrcBuffer();
        } catch (Throwable th) {
            resetSingleSrcBuffer();
            throw th;
        }
        return wrap;
    }
}
