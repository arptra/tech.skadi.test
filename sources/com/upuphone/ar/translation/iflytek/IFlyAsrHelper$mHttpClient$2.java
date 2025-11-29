package com.upuphone.ar.translation.iflytek;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lokhttp3/OkHttpClient;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class IFlyAsrHelper$mHttpClient$2 extends Lambda implements Function0<OkHttpClient> {
    public static final IFlyAsrHelper$mHttpClient$2 INSTANCE = new IFlyAsrHelper$mHttpClient$2();

    public IFlyAsrHelper$mHttpClient$2() {
        super(0);
    }

    @NotNull
    public final OkHttpClient invoke() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.connectTimeout(3000, timeUnit).readTimeout(3000, timeUnit).build();
    }
}
