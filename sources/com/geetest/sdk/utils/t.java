package com.geetest.sdk.utils;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class t implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public int f2971a;
    public String b;
    public String[] c;

    public t(String[] strArr) {
        this.c = strArr;
        this.f2971a = strArr.length;
    }

    public final String a(String str) {
        int i = 0;
        while (i < this.f2971a) {
            if (!str.contains(this.c[i]) || i >= this.f2971a - 1) {
                i++;
            } else {
                String[] strArr = this.c;
                String str2 = strArr[i];
                int i2 = i + 1;
                String replace = str.replace(str2, strArr[i2]);
                String str3 = this.c[i2];
                int indexOf = str3.indexOf("/");
                if (indexOf > 0) {
                    str3 = str3.substring(0, indexOf);
                }
                this.b = str3;
                return replace;
            }
        }
        return str;
    }

    public final Response b(Interceptor.Chain chain, Request request) {
        try {
            return chain.proceed(request);
        } catch (Exception unused) {
            return null;
        }
    }

    public Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        Response b2 = b(chain, request);
        String httpUrl = request.url().toString();
        if (httpUrl.contains("/ajax.php?gt=")) {
            return b2;
        }
        int i = 0;
        while (true) {
            if ((b2 == null || !b2.isSuccessful()) && i < this.f2971a) {
                httpUrl = a(httpUrl);
                i++;
                b2 = b(chain, request.newBuilder().header("Host", this.b).url(httpUrl).build());
            }
        }
        if (b2 != null) {
            return b2;
        }
        throw new IOException();
    }
}
