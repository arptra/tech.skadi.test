package com.upuphone.xr.sapp.utils;

import com.upuphone.xr.sapp.monitor.net.TokenInterceptor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lokhttp3/OkHttpClient;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HttpRequestUtil$client$2 extends Lambda implements Function0<OkHttpClient> {
    public static final HttpRequestUtil$client$2 INSTANCE = new HttpRequestUtil$client$2();

    public HttpRequestUtil$client$2() {
        super(0);
    }

    @NotNull
    public final OkHttpClient invoke() {
        return new OkHttpClient().newBuilder().addInterceptor(new TokenInterceptor()).build();
    }
}
