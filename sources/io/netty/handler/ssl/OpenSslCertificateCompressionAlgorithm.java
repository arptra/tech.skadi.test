package io.netty.handler.ssl;

import javax.net.ssl.SSLEngine;

public interface OpenSslCertificateCompressionAlgorithm {
    int algorithmId();

    byte[] compress(SSLEngine sSLEngine, byte[] bArr) throws Exception;

    byte[] decompress(SSLEngine sSLEngine, int i, byte[] bArr) throws Exception;
}
