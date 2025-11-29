package com.upuphone.star.httplib;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"T", "Lcom/upuphone/star/httplib/HttpResult;", "b", "(Lcom/upuphone/star/httplib/HttpResult;)Ljava/lang/Object;", "a", "super-http-lib_release"}, k = 2, mv = {1, 8, 0})
public final class HttpResultKt {
    public static final Object a(HttpResult httpResult) {
        Intrinsics.checkNotNullParameter(httpResult, "<this>");
        if (httpResult.e()) {
            return httpResult.b();
        }
        return null;
    }

    public static final Object b(HttpResult httpResult) {
        Intrinsics.checkNotNullParameter(httpResult, "<this>");
        if (httpResult.e() && httpResult.b() != null) {
            return httpResult.b();
        }
        throw new HttpResultException(httpResult.a(), httpResult.c(), httpResult.d());
    }
}
