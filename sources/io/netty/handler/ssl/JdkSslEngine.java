package io.netty.handler.ssl;

import io.netty.util.internal.SuppressJava6Requirement;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;

class JdkSslEngine extends SSLEngine implements ApplicationProtocolAccessor {
    private volatile String applicationProtocol;
    private final SSLEngine engine;

    public JdkSslEngine(SSLEngine sSLEngine) {
        this.engine = sSLEngine;
    }

    public void beginHandshake() throws SSLException {
        this.engine.beginHandshake();
    }

    public void closeInbound() throws SSLException {
        this.engine.closeInbound();
    }

    public void closeOutbound() {
        this.engine.closeOutbound();
    }

    public Runnable getDelegatedTask() {
        return this.engine.getDelegatedTask();
    }

    public boolean getEnableSessionCreation() {
        return this.engine.getEnableSessionCreation();
    }

    public String[] getEnabledCipherSuites() {
        return this.engine.getEnabledCipherSuites();
    }

    public String[] getEnabledProtocols() {
        return this.engine.getEnabledProtocols();
    }

    @SuppressJava6Requirement(reason = "Can only be called when running on JDK7+")
    public SSLSession getHandshakeSession() {
        return this.engine.getHandshakeSession();
    }

    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        return this.engine.getHandshakeStatus();
    }

    public boolean getNeedClientAuth() {
        return this.engine.getNeedClientAuth();
    }

    public String getNegotiatedApplicationProtocol() {
        return this.applicationProtocol;
    }

    public String getPeerHost() {
        return this.engine.getPeerHost();
    }

    public int getPeerPort() {
        return this.engine.getPeerPort();
    }

    public SSLParameters getSSLParameters() {
        return this.engine.getSSLParameters();
    }

    public SSLSession getSession() {
        return this.engine.getSession();
    }

    public String[] getSupportedCipherSuites() {
        return this.engine.getSupportedCipherSuites();
    }

    public String[] getSupportedProtocols() {
        return this.engine.getSupportedProtocols();
    }

    public boolean getUseClientMode() {
        return this.engine.getUseClientMode();
    }

    public boolean getWantClientAuth() {
        return this.engine.getWantClientAuth();
    }

    public SSLEngine getWrappedEngine() {
        return this.engine;
    }

    public boolean isInboundDone() {
        return this.engine.isInboundDone();
    }

    public boolean isOutboundDone() {
        return this.engine.isOutboundDone();
    }

    public void setEnableSessionCreation(boolean z) {
        this.engine.setEnableSessionCreation(z);
    }

    public void setEnabledCipherSuites(String[] strArr) {
        this.engine.setEnabledCipherSuites(strArr);
    }

    public void setEnabledProtocols(String[] strArr) {
        this.engine.setEnabledProtocols(strArr);
    }

    public void setNeedClientAuth(boolean z) {
        this.engine.setNeedClientAuth(z);
    }

    public void setNegotiatedApplicationProtocol(String str) {
        this.applicationProtocol = str;
    }

    public void setSSLParameters(SSLParameters sSLParameters) {
        this.engine.setSSLParameters(sSLParameters);
    }

    public void setUseClientMode(boolean z) {
        this.engine.setUseClientMode(z);
    }

    public void setWantClientAuth(boolean z) {
        this.engine.setWantClientAuth(z);
    }

    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBuffer2);
    }

    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return this.engine.wrap(byteBuffer, byteBuffer2);
    }

    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBufferArr);
    }

    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer) throws SSLException {
        return this.engine.wrap(byteBufferArr, byteBuffer);
    }

    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBufferArr, i, i2);
    }

    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer byteBuffer) throws SSLException {
        return this.engine.wrap(byteBufferArr, i, i2, byteBuffer);
    }
}
