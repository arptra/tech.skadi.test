package io.netty.handler.ssl;

import io.netty.util.ReferenceCounted;
import java.security.cert.X509Certificate;

interface OpenSslKeyMaterial extends ReferenceCounted {
    X509Certificate[] certificateChain();

    long certificateChainAddress();

    long privateKeyAddress();

    boolean release();

    boolean release(int i);

    OpenSslKeyMaterial retain();

    OpenSslKeyMaterial retain(int i);

    OpenSslKeyMaterial touch();

    OpenSslKeyMaterial touch(Object obj);
}
