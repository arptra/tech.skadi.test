package com.upuphone.xr.sapp.monitor.net;

import android.content.Context;
import com.upuphone.xr.sapp.monitor.net.GwTokenResBody;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/net/TokenInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "", "validToken", "a", "(Lokhttp3/Interceptor$Chain;Z)Lokhttp3/Response;", "Lokhttp3/Request;", "request", "c", "(Lokhttp3/Request;)Lokhttp3/Request;", "d", "", "b", "()Ljava/lang/String;", "deviceId", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTokenInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TokenInterceptor.kt\ncom/upuphone/xr/sapp/monitor/net/TokenInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,117:1\n1271#2,2:118\n1285#2,4:120\n1271#2,2:126\n1285#2,4:128\n215#3,2:124\n215#3,2:132\n*S KotlinDebug\n*F\n+ 1 TokenInterceptor.kt\ncom/upuphone/xr/sapp/monitor/net/TokenInterceptor\n*L\n73#1:118,2\n73#1:120,4\n95#1:126,2\n95#1:128,4\n78#1:124,2\n100#1:132,2\n*E\n"})
public final class TokenInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7743a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/net/TokenInterceptor$Companion;", "", "()V", "DEFAULT_ANDROID_ID", "", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final Response a(Interceptor.Chain chain, boolean z) {
        Request request = chain.request();
        TokenUtil tokenUtil = TokenUtil.f7744a;
        Request c = tokenUtil.b().contains(request.url().host()) ? c(request) : d(request);
        HttpUrl url = c.url();
        TokenInterceptorKt.a("请求的地址--:" + url, "TokenInterceptor");
        Headers headers = c.headers();
        TokenInterceptorKt.a("请求接口header列表--\n" + headers, "TokenInterceptor");
        Response proceed = chain.proceed(c);
        int code = proceed.code();
        TokenInterceptorKt.a("请求返回response code--" + code, "TokenInterceptor");
        TokenInterceptorKt.a("validToken: " + z, "TokenInterceptor");
        if (!z || proceed.code() != 401) {
            return proceed;
        }
        proceed.close();
        return (tokenUtil.b().contains(c.url().host()) ? tokenUtil.j(chain) : tokenUtil.k(chain)).length() == 0 ? chain.proceed(c) : a(chain, false);
    }

    public final String b() {
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        String str = (String) DataStoreUtils.i(companion.a(), "device_id", "test111", (Context) null, 4, (Object) null);
        if (!Intrinsics.areEqual((Object) str, (Object) "test111")) {
            return str;
        }
        String e = AppUtils.f7842a.e();
        companion.a().o("device_id", e);
        return e;
    }

    public final Request c(Request request) {
        Set<String> queryParameterNames = request.url().queryParameterNames();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(queryParameterNames, 10)), 16));
        for (T next : queryParameterNames) {
            String queryParameter = request.url().queryParameter((String) next);
            if (queryParameter == null) {
                queryParameter = "";
            }
            linkedHashMap.put(next, queryParameter);
        }
        Map g = TokenUtil.f7744a.g(linkedHashMap);
        HttpUrl.Builder newBuilder = request.url().newBuilder();
        for (Map.Entry entry : g.entrySet()) {
            newBuilder.addQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String e = TokenUtil.e(TokenUtil.f7744a, (GwTokenResBody.GwTokenData) null, 1, (Object) null);
        TokenInterceptorKt.a("addGwToken: " + e, "TokenInterceptor");
        return request.newBuilder().header("Authorization", e).url(newBuilder.build()).build();
    }

    public final Request d(Request request) {
        Set<String> queryParameterNames = request.url().queryParameterNames();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(queryParameterNames, 10)), 16));
        for (T next : queryParameterNames) {
            String queryParameter = request.url().queryParameter((String) next);
            if (queryParameter == null) {
                queryParameter = "";
            }
            linkedHashMap.put(next, queryParameter);
        }
        Map g = TokenUtil.f7744a.g(linkedHashMap);
        HttpUrl.Builder newBuilder = request.url().newBuilder();
        for (Map.Entry entry : g.entrySet()) {
            newBuilder.addQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String f = HttpConfig.f7742a.f();
        String i = TokenUtil.f7744a.i();
        TokenInterceptorKt.a("addXjToken: " + i, "TokenInterceptor");
        return request.newBuilder().header("WR-Authorization", i).header("WR-Client-Id", b()).header("WR-ukey", f).url(newBuilder.build()).build();
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return a(chain, true);
    }
}
