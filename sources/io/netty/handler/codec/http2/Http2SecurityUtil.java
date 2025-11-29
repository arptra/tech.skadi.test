package io.netty.handler.codec.http2;

import io.netty.handler.ssl.Ciphers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Http2SecurityUtil {
    public static final List<String> CIPHERS;
    private static final List<String> CIPHERS_JAVA_MOZILLA_MODERN_SECURITY;

    static {
        List<String> unmodifiableList = Collections.unmodifiableList(Arrays.asList(new String[]{Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, Ciphers.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, Ciphers.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, Ciphers.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, Ciphers.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, Ciphers.TLS_AES_128_GCM_SHA256, Ciphers.TLS_AES_256_GCM_SHA384, Ciphers.TLS_CHACHA20_POLY1305_SHA256}));
        CIPHERS_JAVA_MOZILLA_MODERN_SECURITY = unmodifiableList;
        CIPHERS = Collections.unmodifiableList(new ArrayList(unmodifiableList));
    }

    private Http2SecurityUtil() {
    }
}
