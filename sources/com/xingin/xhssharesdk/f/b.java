package com.xingin.xhssharesdk.f;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public final class b implements Interceptor {
    public final Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        return (request.body() == null || request.header("Content-Encoding") != null) ? chain.proceed(request) : chain.proceed(request.newBuilder().header("Content-Encoding", "gzip").method(request.method(), new a(request.body())).build());
    }
}
