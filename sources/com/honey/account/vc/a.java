package com.honey.account.vc;

import okhttp3.Interceptor;
import okhttp3.Response;
import sdk.meizu.account.factor.authentication.sdk.module.NetworkModule;

public final /* synthetic */ class a implements Interceptor {
    public final Response intercept(Interceptor.Chain chain) {
        return NetworkModule.provideRetrofit$lambda$1(chain);
    }
}
