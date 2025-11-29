package com.honey.account.f2;

import com.honey.account.module.NetworkModule;
import okhttp3.Interceptor;
import okhttp3.Response;

public final /* synthetic */ class a implements Interceptor {
    public final Response intercept(Interceptor.Chain chain) {
        return NetworkModule.provideRetrofit$lambda$1(chain);
    }
}
