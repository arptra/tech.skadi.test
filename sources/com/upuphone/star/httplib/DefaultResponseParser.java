package com.upuphone.star.httplib;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/star/httplib/DefaultResponseParser;", "Lcom/upuphone/star/httplib/ResponseParser;", "<init>", "()V", "T", "Lokhttp3/Response;", "response", "Ljava/lang/reflect/Type;", "type", "Lcom/upuphone/star/httplib/HttpResult;", "a", "(Lokhttp3/Response;Ljava/lang/reflect/Type;)Lcom/upuphone/star/httplib/HttpResult;", "super-http-lib_release"}, k = 1, mv = {1, 8, 0})
public final class DefaultResponseParser implements ResponseParser {

    /* renamed from: a  reason: collision with root package name */
    public static final DefaultResponseParser f6476a = new DefaultResponseParser();

    public HttpResult a(Response response, Type type) {
        String string;
        Type type2 = type;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(type2, "type");
        if (!response.isSuccessful()) {
            return new HttpResult(response.code(), "http error", (Object) null, (String) null, 12, (DefaultConstructorMarker) null);
        }
        ResponseBody body = response.body();
        if (body == null || (string = body.string()) == null) {
            return new HttpResult(-10, "bad response", (Object) null, (String) null, 12, (DefaultConstructorMarker) null);
        }
        if (Intrinsics.areEqual((Object) type2, (Object) String.class)) {
            return new HttpResult(200, "success", string, string);
        }
        if (Intrinsics.areEqual((Object) type2, (Object) Unit.class)) {
            return new HttpResult(200, "success", Unit.INSTANCE, string);
        }
        try {
            return new HttpResult(200, "success", JsonUtils.INSTANCE.fromJson(string, type2, true), string);
        } catch (Throwable th) {
            th.printStackTrace();
            return new HttpResult(-20, "parse json error", (Object) null, string, 4, (DefaultConstructorMarker) null);
        }
    }
}
