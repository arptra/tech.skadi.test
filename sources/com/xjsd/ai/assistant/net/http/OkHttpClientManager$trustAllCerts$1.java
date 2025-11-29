package com.xjsd.ai.assistant.net.http;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ#\u0010\n\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"com/xjsd/ai/assistant/net/http/OkHttpClientManager$trustAllCerts$1", "Ljavax/net/ssl/X509TrustManager;", "checkClientTrusted", "", "chain", "", "Ljava/security/cert/X509Certificate;", "authType", "", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "checkServerTrusted", "getAcceptedIssuers", "()[Ljava/security/cert/X509Certificate;", "lib_assistant_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OkHttpClientManager$trustAllCerts$1 implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        Intrinsics.checkNotNullParameter(x509CertificateArr, "chain");
        Intrinsics.checkNotNullParameter(str, "authType");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        Intrinsics.checkNotNullParameter(x509CertificateArr, "chain");
        Intrinsics.checkNotNullParameter(str, "authType");
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
