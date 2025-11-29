package com.honey.account.ea;

import com.xjsd.ai.assistant.net.http.OkHttpClientManager;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public final /* synthetic */ class a implements HostnameVerifier {
    public final boolean verify(String str, SSLSession sSLSession) {
        return OkHttpClientManager.e(str, sSLSession);
    }
}
