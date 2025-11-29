package com.upuphone.star.httplib;

import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JG\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\b2\u0006\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J[\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\b2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJO\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010$R\u0014\u0010(\u001a\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/upuphone/star/httplib/HttpInstance;", "", "Lokhttp3/OkHttpClient;", "httpClient", "Lcom/upuphone/star/httplib/ResponseParser;", "responseParser", "<init>", "(Lokhttp3/OkHttpClient;Lcom/upuphone/star/httplib/ResponseParser;)V", "T", "", "url", "", "headers", "Ljava/lang/reflect/Type;", "type", "Lcom/upuphone/star/httplib/HttpResult;", "d", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/reflect/Type;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "params", "f", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/reflect/Type;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokhttp3/Request;", "request", "h", "(Lokhttp3/Request;Ljava/lang/reflect/Type;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokhttp3/Response;", "c", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "obj", "g", "(Ljava/lang/String;Ljava/lang/Object;Ljava/util/Map;Ljava/lang/reflect/Type;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lokhttp3/OkHttpClient;", "b", "Lcom/upuphone/star/httplib/ResponseParser;", "", "Z", "debug", "e", "()Lokhttp3/OkHttpClient;", "ensureHttpClient", "super-http-lib_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHttpInstance.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpInstance.kt\ncom/upuphone/star/httplib/HttpInstance\n*L\n1#1,260:1\n178#1,6:261\n*S KotlinDebug\n*F\n+ 1 HttpInstance.kt\ncom/upuphone/star/httplib/HttpInstance\n*L\n-1#1:261,6\n*E\n"})
public final class HttpInstance {

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f6477a;
    public final ResponseParser b;
    public boolean c;

    public HttpInstance(OkHttpClient okHttpClient, ResponseParser responseParser) {
        Intrinsics.checkNotNullParameter(responseParser, "responseParser");
        this.f6477a = okHttpClient;
        this.b = responseParser;
    }

    public final Object c(Request request, Continuation continuation) {
        return CallExtKt.a(e().newCall(request), continuation);
    }

    public final Object d(String str, Map map, Type type, Continuation continuation) {
        return h(HttpUtils.f6479a.c(str, map), type, continuation);
    }

    public final OkHttpClient e() {
        OkHttpClient okHttpClient = this.f6477a;
        return okHttpClient == null ? HttpUtils.f6479a.m() : okHttpClient;
    }

    public final Object f(String str, Map map, Map map2, Type type, Continuation continuation) {
        return h(HttpUtils.f6479a.f(str, map, map2), type, continuation);
    }

    public final Object g(String str, Object obj, Map map, Type type, Continuation continuation) {
        return h(HttpUtils.f6479a.d(str, obj, map), type, continuation);
    }

    public final Object h(Request request, Type type, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new HttpInstance$request$4(this, request, type, (Continuation<? super HttpInstance$request$4>) null), continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HttpInstance(OkHttpClient okHttpClient, ResponseParser responseParser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : okHttpClient, (i & 2) != 0 ? DefaultResponseParser.f6476a : responseParser);
    }
}
