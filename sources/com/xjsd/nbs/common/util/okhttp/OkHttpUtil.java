package com.xjsd.nbs.common.util.okhttp;

import com.xjsd.nbs.common.domain.response.CommonErrorCode;
import com.xjsd.nbs.common.domain.response.CommonResponse;
import com.xjsd.nbs.common.util.LogUtil;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.Objects;
import java.util.concurrent.Semaphore;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class OkHttpUtil {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Semaphore f8713a;

    /* renamed from: com.xjsd.nbs.common.util.okhttp.OkHttpUtil$1  reason: invalid class name */
    class AnonymousClass1 implements HostnameVerifier {
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* renamed from: com.xjsd.nbs.common.util.okhttp.OkHttpUtil$2  reason: invalid class name */
    class AnonymousClass2 implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f8714a;

        public void onFailure(Call call, IOException iOException) {
            LogUtil.a("[token-manager]", iOException.getMessage());
            this.f8714a.append(CommonResponse.failString(CommonErrorCode.REMOTE_ERROR, iOException.getMessage()));
            OkHttpUtil.a().release();
        }

        public void onResponse(Call call, Response response) {
            if (response.body() != null) {
                StringBuilder sb = this.f8714a;
                ResponseBody body = response.body();
                Objects.requireNonNull(body);
                sb.append(body.string());
            }
            OkHttpUtil.a().release();
        }
    }

    /* renamed from: com.xjsd.nbs.common.util.okhttp.OkHttpUtil$3  reason: invalid class name */
    class AnonymousClass3 implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ICallBack f8715a;

        public void onFailure(Call call, IOException iOException) {
            this.f8715a.b(call, iOException.getMessage());
        }

        public void onResponse(Call call, Response response) {
            ICallBack iCallBack = this.f8715a;
            ResponseBody body = response.body();
            Objects.requireNonNull(body);
            iCallBack.a(call, body.string());
        }
    }

    /* renamed from: com.xjsd.nbs.common.util.okhttp.OkHttpUtil$4  reason: invalid class name */
    class AnonymousClass4 implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public interface ICallBack {
        void a(Call call, String str);

        void b(Call call, String str);
    }

    public static Semaphore a() {
        synchronized (OkHttpUtil.class) {
            try {
                if (f8713a == null) {
                    f8713a = new Semaphore(0);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return f8713a;
    }
}
