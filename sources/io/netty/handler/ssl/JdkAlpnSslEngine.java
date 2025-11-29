package io.netty.handler.ssl;

import io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import io.netty.util.internal.SuppressJava6Requirement;
import java.nio.ByteBuffer;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
class JdkAlpnSslEngine extends JdkSslEngine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AlpnSelector alpnSelector;
    private final JdkApplicationProtocolNegotiator.ProtocolSelectionListener selectionListener;

    public final class AlpnSelector implements BiFunction<SSLEngine, List<String>, String> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean called;
        private final JdkApplicationProtocolNegotiator.ProtocolSelector selector;

        public AlpnSelector(JdkApplicationProtocolNegotiator.ProtocolSelector protocolSelector) {
            this.selector = protocolSelector;
        }

        public void checkUnsupported() {
            if (!this.called && JdkAlpnSslEngine.this.getApplicationProtocol().isEmpty()) {
                this.selector.unsupported();
            }
        }

        public String apply(SSLEngine sSLEngine, List<String> list) {
            this.called = true;
            try {
                String select = this.selector.select(list);
                return select == null ? "" : select;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public JdkAlpnSslEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z, BiConsumer<SSLEngine, AlpnSelector> biConsumer, BiConsumer<SSLEngine, List<String>> biConsumer2) {
        super(sSLEngine);
        if (z) {
            this.selectionListener = null;
            AlpnSelector alpnSelector2 = new AlpnSelector(jdkApplicationProtocolNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator.protocols())));
            this.alpnSelector = alpnSelector2;
            biConsumer.accept(sSLEngine, alpnSelector2);
            return;
        }
        this.selectionListener = jdkApplicationProtocolNegotiator.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator.protocols());
        this.alpnSelector = null;
        biConsumer2.accept(sSLEngine, jdkApplicationProtocolNegotiator.protocols());
    }

    private SSLEngineResult verifyProtocolSelection(SSLEngineResult sSLEngineResult) throws SSLException {
        if (sSLEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
            AlpnSelector alpnSelector2 = this.alpnSelector;
            if (alpnSelector2 == null) {
                try {
                    String applicationProtocol = getApplicationProtocol();
                    if (applicationProtocol.isEmpty()) {
                        this.selectionListener.unsupported();
                    } else {
                        this.selectionListener.selected(applicationProtocol);
                    }
                } catch (Throwable th) {
                    throw SslUtils.toSSLHandshakeException(th);
                }
            } else {
                alpnSelector2.checkUnsupported();
            }
        }
        return sSLEngineResult;
    }

    public String getApplicationProtocol() {
        return JdkAlpnSslUtils.getApplicationProtocol(getWrappedEngine());
    }

    public String getHandshakeApplicationProtocol() {
        return JdkAlpnSslUtils.getHandshakeApplicationProtocol(getWrappedEngine());
    }

    public BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return JdkAlpnSslUtils.getHandshakeApplicationProtocolSelector(getWrappedEngine());
    }

    public String getNegotiatedApplicationProtocol() {
        String applicationProtocol = getApplicationProtocol();
        if (applicationProtocol == null) {
            return null;
        }
        if (applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }

    public void setHandshakeApplicationProtocolSelector(BiFunction<SSLEngine, List<String>, String> biFunction) {
        JdkAlpnSslUtils.setHandshakeApplicationProtocolSelector(getWrappedEngine(), biFunction);
    }

    public void setNegotiatedApplicationProtocol(String str) {
    }

    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return verifyProtocolSelection(super.unwrap(byteBuffer, byteBuffer2));
    }

    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return verifyProtocolSelection(super.wrap(byteBuffer, byteBuffer2));
    }

    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        return verifyProtocolSelection(super.unwrap(byteBuffer, byteBufferArr));
    }

    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer) throws SSLException {
        return verifyProtocolSelection(super.wrap(byteBufferArr, byteBuffer));
    }

    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) throws SSLException {
        return verifyProtocolSelection(super.unwrap(byteBuffer, byteBufferArr, i, i2));
    }

    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer byteBuffer) throws SSLException {
        return verifyProtocolSelection(super.wrap(byteBufferArr, i, i2, byteBuffer));
    }

    public JdkAlpnSslEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z) {
        this(sSLEngine, jdkApplicationProtocolNegotiator, z, new BiConsumer<SSLEngine, AlpnSelector>() {
            public void accept(SSLEngine sSLEngine, AlpnSelector alpnSelector) {
                JdkAlpnSslUtils.setHandshakeApplicationProtocolSelector(sSLEngine, alpnSelector);
            }
        }, new BiConsumer<SSLEngine, List<String>>() {
            public void accept(SSLEngine sSLEngine, List<String> list) {
                JdkAlpnSslUtils.setApplicationProtocols(sSLEngine, list);
            }
        });
    }
}
