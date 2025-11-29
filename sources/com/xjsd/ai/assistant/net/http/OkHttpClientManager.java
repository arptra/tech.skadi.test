package com.xjsd.ai.assistant.net.http;

import com.honey.account.ea.a;
import com.xjsd.ai.assistant.log.ILog;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/xjsd/ai/assistant/net/http/OkHttpClientManager;", "", "<init>", "()V", "Lokhttp3/OkHttpClient;", "d", "()Lokhttp3/OkHttpClient;", "Lokhttp3/Request;", "request", "", "c", "(Lokhttp3/Request;)Ljava/lang/String;", "Lokhttp3/Call;", "call", "b", "(Lokhttp3/Call;)Ljava/lang/String;", "Ljavax/net/ssl/HostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "verifiedAllHostname", "", "Ljavax/net/ssl/TrustManager;", "[Ljavax/net/ssl/TrustManager;", "trustAllCerts", "Ljavax/net/ssl/SSLContext;", "Ljavax/net/ssl/SSLContext;", "sslContext", "Ljavax/net/ssl/SSLSocketFactory;", "e", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "f", "Lokhttp3/OkHttpClient;", "mHttpClient", "lib_assistant_release"}, k = 1, mv = {1, 9, 0})
public final class OkHttpClientManager {

    /* renamed from: a  reason: collision with root package name */
    public static final OkHttpClientManager f8504a = new OkHttpClientManager();
    public static final HostnameVerifier b = new a();
    public static final TrustManager[] c;
    public static SSLContext d;
    public static SSLSocketFactory e;
    public static OkHttpClient f;

    static {
        TrustManager[] trustManagerArr = {new OkHttpClientManager$trustAllCerts$1()};
        c = trustManagerArr;
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(128);
        dispatcher.setMaxRequestsPerHost(128);
        ConnectionPool connectionPool = new ConnectionPool(15, 15, TimeUnit.MILLISECONDS);
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            d = instance;
            Intrinsics.checkNotNull(instance);
            instance.init((KeyManager[]) null, trustManagerArr, new SecureRandom());
        } catch (NoSuchAlgorithmException e2) {
            ILog.h("OkHttpClientManager", "NoSuchAlgorithmException", e2);
        } catch (KeyManagementException e3) {
            ILog.h("OkHttpClientManager", "KeyManagementException", e3);
        }
        SSLContext sSLContext = d;
        Intrinsics.checkNotNull(sSLContext);
        e = sSLContext.getSocketFactory();
        OkHttpClient.Builder protocols = new OkHttpClient.Builder().protocols(CollectionsKt.listOf(Protocol.HTTP_1_1));
        SSLSocketFactory sSLSocketFactory = e;
        Intrinsics.checkNotNull(sSLSocketFactory);
        TrustManager trustManager = c[0];
        Intrinsics.checkNotNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        OkHttpClient.Builder hostnameVerifier = protocols.sslSocketFactory(sSLSocketFactory, (X509TrustManager) trustManager).hostnameVerifier(b);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f = hostnameVerifier.connectTimeout(10, timeUnit).readTimeout(10, timeUnit).writeTimeout(10, timeUnit).connectionPool(connectionPool).dispatcher(dispatcher).retryOnConnectionFailure(true).addInterceptor(new GeneralInterceptor()).build();
    }

    public static final boolean e(String str, SSLSession sSLSession) {
        ILog.a("OkHttpClientManager", "hostname->" + str + ", session->" + sSLSession);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003d, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(okhttp3.Call r4) {
        /*
            r3 = this;
            java.lang.String r3 = "OkHttpClientManager"
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            okhttp3.Response r4 = r4.execute()     // Catch:{ Exception -> 0x001c }
            okhttp3.ResponseBody r1 = r4.body()     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x0020
            java.lang.String r1 = "请求响应体为空"
            com.xjsd.ai.assistant.log.ILog.g(r3, r1)     // Catch:{ all -> 0x001e }
            kotlin.io.CloseableKt.closeFinally(r4, r0)     // Catch:{ Exception -> 0x001c }
            return r0
        L_0x001c:
            r4 = move-exception
            goto L_0x003e
        L_0x001e:
            r1 = move-exception
            goto L_0x0038
        L_0x0020:
            java.lang.String r1 = r1.string()     // Catch:{ all -> 0x001e }
            boolean r2 = org.apache.commons.lang3.StringUtils.isEmpty(r1)     // Catch:{ all -> 0x001e }
            if (r2 == 0) goto L_0x0034
            java.lang.String r1 = "请求响应体内容为空"
            com.xjsd.ai.assistant.log.ILog.g(r3, r1)     // Catch:{ all -> 0x001e }
            kotlin.io.CloseableKt.closeFinally(r4, r0)     // Catch:{ Exception -> 0x001c }
            return r0
        L_0x0034:
            kotlin.io.CloseableKt.closeFinally(r4, r0)     // Catch:{ Exception -> 0x001c }
            return r1
        L_0x0038:
            throw r1     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r1)     // Catch:{ Exception -> 0x001c }
            throw r2     // Catch:{ Exception -> 0x001c }
        L_0x003e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "请求抛出异常 "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.xjsd.ai.assistant.log.ILog.h(r3, r1, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.net.http.OkHttpClientManager.b(okhttp3.Call):java.lang.String");
    }

    public final String c(Request request) {
        OkHttpClient okHttpClient = f;
        Intrinsics.checkNotNull(request);
        return b(okHttpClient.newCall(request));
    }

    public final OkHttpClient d() {
        return f;
    }
}
