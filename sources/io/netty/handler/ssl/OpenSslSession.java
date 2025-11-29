package io.netty.handler.ssl;

import java.security.cert.Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

interface OpenSslSession extends SSLSession {
    OpenSslSessionContext getSessionContext();

    void handshakeFinished(byte[] bArr, String str, String str2, byte[] bArr2, byte[][] bArr3, long j, long j2) throws SSLException;

    OpenSslSessionId sessionId();

    void setLocalCertificate(Certificate[] certificateArr);

    void setSessionId(OpenSslSessionId openSslSessionId);

    void tryExpandApplicationBufferSize(int i);
}
