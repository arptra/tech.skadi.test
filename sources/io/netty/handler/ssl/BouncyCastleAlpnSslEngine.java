package io.netty.handler.ssl;

import io.netty.handler.ssl.JdkAlpnSslEngine;
import io.netty.util.internal.SuppressJava6Requirement;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class BouncyCastleAlpnSslEngine extends JdkAlpnSslEngine {
    public BouncyCastleAlpnSslEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z) {
        super(sSLEngine, jdkApplicationProtocolNegotiator, z, new BiConsumer<SSLEngine, JdkAlpnSslEngine.AlpnSelector>() {
            public void accept(SSLEngine sSLEngine, JdkAlpnSslEngine.AlpnSelector alpnSelector) {
                BouncyCastleAlpnSslUtils.setHandshakeApplicationProtocolSelector(sSLEngine, alpnSelector);
            }
        }, new BiConsumer<SSLEngine, List<String>>() {
            public void accept(SSLEngine sSLEngine, List<String> list) {
                BouncyCastleAlpnSslUtils.setApplicationProtocols(sSLEngine, list);
            }
        });
    }

    public String getApplicationProtocol() {
        return BouncyCastleAlpnSslUtils.getApplicationProtocol(getWrappedEngine());
    }

    public String getHandshakeApplicationProtocol() {
        return BouncyCastleAlpnSslUtils.getHandshakeApplicationProtocol(getWrappedEngine());
    }

    public BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return BouncyCastleAlpnSslUtils.getHandshakeApplicationProtocolSelector(getWrappedEngine());
    }

    public void setHandshakeApplicationProtocolSelector(BiFunction<SSLEngine, List<String>, String> biFunction) {
        BouncyCastleAlpnSslUtils.setHandshakeApplicationProtocolSelector(getWrappedEngine(), biFunction);
    }
}
