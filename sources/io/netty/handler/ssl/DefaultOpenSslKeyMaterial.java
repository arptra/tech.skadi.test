package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import java.security.cert.X509Certificate;

final class DefaultOpenSslKeyMaterial extends AbstractReferenceCounted implements OpenSslKeyMaterial {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ResourceLeakDetector<DefaultOpenSslKeyMaterial> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(DefaultOpenSslKeyMaterial.class);
    private long chain;
    private final ResourceLeakTracker<DefaultOpenSslKeyMaterial> leak = leakDetector.track(this);
    private long privateKey;
    private final X509Certificate[] x509CertificateChain;

    public DefaultOpenSslKeyMaterial(long j, long j2, X509Certificate[] x509CertificateArr) {
        this.chain = j;
        this.privateKey = j2;
        this.x509CertificateChain = x509CertificateArr;
    }

    public X509Certificate[] certificateChain() {
        return (X509Certificate[]) this.x509CertificateChain.clone();
    }

    public long certificateChainAddress() {
        if (refCnt() > 0) {
            return this.chain;
        }
        throw new IllegalReferenceCountException();
    }

    public void deallocate() {
        SSL.freeX509Chain(this.chain);
        this.chain = 0;
        SSL.freePrivateKey(this.privateKey);
        this.privateKey = 0;
        ResourceLeakTracker<DefaultOpenSslKeyMaterial> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.close(this);
        }
    }

    public long privateKeyAddress() {
        if (refCnt() > 0) {
            return this.privateKey;
        }
        throw new IllegalReferenceCountException();
    }

    public boolean release() {
        ResourceLeakTracker<DefaultOpenSslKeyMaterial> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record();
        }
        return super.release();
    }

    public boolean release(int i) {
        ResourceLeakTracker<DefaultOpenSslKeyMaterial> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record();
        }
        return super.release(i);
    }

    public DefaultOpenSslKeyMaterial retain() {
        ResourceLeakTracker<DefaultOpenSslKeyMaterial> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record();
        }
        super.retain();
        return this;
    }

    public DefaultOpenSslKeyMaterial touch() {
        ResourceLeakTracker<DefaultOpenSslKeyMaterial> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record();
        }
        super.touch();
        return this;
    }

    public DefaultOpenSslKeyMaterial retain(int i) {
        ResourceLeakTracker<DefaultOpenSslKeyMaterial> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record();
        }
        super.retain(i);
        return this;
    }

    public DefaultOpenSslKeyMaterial touch(Object obj) {
        ResourceLeakTracker<DefaultOpenSslKeyMaterial> resourceLeakTracker = this.leak;
        if (resourceLeakTracker != null) {
            resourceLeakTracker.record(obj);
        }
        return this;
    }
}
