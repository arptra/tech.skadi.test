package com.upuphone.star.httplib;

import com.upuphone.starrynet.payload.PayloadConstant;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u00020\t2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJG\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019JC\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0016\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u001b\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u00020!2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0004\b\"\u0010#J-\u0010$\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00112\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0004\b$\u0010%JA\u0010&\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00132\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0004\b&\u0010'J5\u0010)\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010(\u001a\u00020!2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0004\b)\u0010*JO\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J5\u0010.\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020!2\u0006\u0010+\u001a\u00020\u0001¢\u0006\u0004\b0\u00101R\u0014\u00104\u001a\u0002028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u00103R\u001b\u00108\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b$\u00105\u001a\u0004\b6\u00107R\u001b\u0010<\u001a\u0002098BX\u0002¢\u0006\f\n\u0004\b.\u00105\u001a\u0004\b:\u0010;\u0002\u0004\n\u0002\b\u0019¨\u0006="}, d2 = {"Lcom/upuphone/star/httplib/HttpUtils;", "", "<init>", "()V", "Lkotlin/Function1;", "Lokhttp3/OkHttpClient$Builder;", "", "Lkotlin/ExtensionFunctionType;", "callback", "Lokhttp3/OkHttpClient;", "j", "(Lkotlin/jvm/functions/Function1;)Lokhttp3/OkHttpClient;", "", "enable", "k", "(Z)V", "T", "", "url", "", "headers", "Ljava/lang/reflect/Type;", "type", "Lcom/upuphone/star/httplib/HttpResult;", "l", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/reflect/Type;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "params", "o", "Lokhttp3/Request;", "request", "Lokhttp3/Response;", "b", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokhttp3/RequestBody;", "i", "(Ljava/util/Map;)Lokhttp3/RequestBody;", "c", "(Ljava/lang/String;Ljava/util/Map;)Lokhttp3/Request;", "f", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lokhttp3/Request;", "requestBody", "g", "(Ljava/lang/String;Lokhttp3/RequestBody;Ljava/util/Map;)Lokhttp3/Request;", "obj", "p", "(Ljava/lang/String;Ljava/lang/Object;Ljava/util/Map;Ljava/lang/reflect/Type;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "(Ljava/lang/String;Ljava/lang/Object;Ljava/util/Map;)Lokhttp3/Request;", "e", "(Ljava/lang/Object;)Lokhttp3/RequestBody;", "Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/logging/HttpLoggingInterceptor;", "httpLoggingInterceptor", "Lkotlin/Lazy;", "m", "()Lokhttp3/OkHttpClient;", "httpClient", "Lcom/upuphone/star/httplib/HttpInstance;", "n", "()Lcom/upuphone/star/httplib/HttpInstance;", "httpInstance", "super-http-lib_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpUtils.kt\ncom/upuphone/star/httplib/HttpUtils\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,439:1\n215#2,2:440\n215#2,2:442\n215#2,2:444\n*S KotlinDebug\n*F\n+ 1 HttpUtils.kt\ncom/upuphone/star/httplib/HttpUtils\n*L\n313#1:440,2\n333#1:442,2\n369#1:444,2\n*E\n"})
public final class HttpUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final HttpUtils f6479a = new HttpUtils();
    public static final HttpLoggingInterceptor b = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
    public static final Lazy c = LazyKt.lazy(HttpUtils$httpClient$2.INSTANCE);
    public static final Lazy d = LazyKt.lazy(HttpUtils$httpInstance$2.INSTANCE);

    public static /* synthetic */ Request h(HttpUtils httpUtils, String str, Map map, Map map2, int i, Object obj) {
        if ((i & 4) != 0) {
            map2 = MapsKt.emptyMap();
        }
        return httpUtils.f(str, map, map2);
    }

    public final Object b(Request request, Continuation continuation) {
        return n().c(request, continuation);
    }

    public final Request c(String str, Map map) {
        Intrinsics.checkNotNullParameter(str, "url");
        Request.Builder builder = new Request.Builder();
        builder.url(str);
        builder.get();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                builder.header((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return builder.build();
    }

    public final Request d(String str, Object obj, Map map) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(obj, "obj");
        return g(str, e(obj), map);
    }

    public final RequestBody e(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return RequestBody.Companion.create(JsonUtils.INSTANCE.toJson(obj), MediaType.Companion.parse("application/json;charset=utf-8"));
    }

    public final Request f(String str, Map map, Map map2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(map, PayloadConstant.KEY_PARAMS);
        return g(str, i(map), map2);
    }

    public final Request g(String str, RequestBody requestBody, Map map) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        Request.Builder builder = new Request.Builder();
        builder.url(str);
        builder.post(requestBody);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                builder.header((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return builder.build();
    }

    public final RequestBody i(Map map) {
        Intrinsics.checkNotNullParameter(map, PayloadConstant.KEY_PARAMS);
        FormBody.Builder builder = new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null);
        for (Map.Entry entry : map.entrySet()) {
            builder.add((String) entry.getKey(), (String) entry.getValue());
        }
        return builder.build();
    }

    public final OkHttpClient j(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        OkHttpClient.Builder newBuilder = m().newBuilder();
        function1.invoke(newBuilder);
        return newBuilder.build();
    }

    public final void k(boolean z) {
        if (z) {
            b.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            b.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
    }

    public final Object l(String str, Map map, Type type, Continuation continuation) {
        return n().d(str, map, type, continuation);
    }

    public final OkHttpClient m() {
        return (OkHttpClient) c.getValue();
    }

    public final HttpInstance n() {
        return (HttpInstance) d.getValue();
    }

    public final Object o(String str, Map map, Type type, Continuation continuation) {
        return n().f(str, map, (Map) null, type, continuation);
    }

    public final Object p(String str, Object obj, Map map, Type type, Continuation continuation) {
        return n().g(str, obj, map, type, continuation);
    }
}
