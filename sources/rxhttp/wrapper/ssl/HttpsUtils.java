package rxhttp.wrapper.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class HttpsUtils {

    public static class MyTrustManager implements X509TrustManager {

        /* renamed from: a  reason: collision with root package name */
        public X509TrustManager f3568a;
        public X509TrustManager b;

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                this.f3568a.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                this.b.checkServerTrusted(x509CertificateArr, str);
            }
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static class SSLParams {
    }

    public static class UnSafeTrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}
