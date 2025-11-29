package com.yalantis.ucrop;

import okhttp3.OkHttpClient;

public class OkHttpClientStore {
    public static final OkHttpClientStore b = new OkHttpClientStore();

    /* renamed from: a  reason: collision with root package name */
    public OkHttpClient f8716a;

    public OkHttpClient a() {
        if (this.f8716a == null) {
            this.f8716a = new OkHttpClient();
        }
        return this.f8716a;
    }
}
