package com.meizu.flyme.policy.sdk.f;

import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012¢\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\u0002H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012H\b¢\u0006\u0002\u0010\u0013R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/meizu/flyme/policy/sdk/net/PolicySdkRetrofitCreator;", "", "()V", "okHttpClient", "Lokhttp3/OkHttpClient$Builder;", "kotlin.jvm.PlatformType", "getOkHttpClient", "()Lokhttp3/OkHttpClient$Builder;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "retrofit$delegate", "create", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "createService", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f3201a = new a();
    @NotNull
    public static final Lazy b = LazyKt.lazy(C0021a.f3202a);
    @NotNull
    public static final Lazy c = LazyKt.lazy(b.f3203a);

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lokhttp3/OkHttpClient$Builder;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: com.meizu.flyme.policy.sdk.f.a$a  reason: collision with other inner class name */
    public static final class C0021a extends Lambda implements Function0<OkHttpClient.Builder> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0021a f3202a = new C0021a();

        public C0021a() {
            super(0);
        }

        public Object invoke() {
            return new OkHttpClient().newBuilder();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<Retrofit> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f3203a = new b();

        public b() {
            super(0);
        }

        public Object invoke() {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            Retrofit.Builder addConverterFactory = new Retrofit.Builder().baseUrl("https://policy-global.flyme.com/").addConverterFactory(GsonConverterFactory.create());
            Lazy lazy = a.b;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            ((OkHttpClient.Builder) lazy.getValue()).connectTimeout(10, timeUnit).writeTimeout(10, timeUnit).readTimeout(10, timeUnit).addInterceptor(httpLoggingInterceptor);
            return addConverterFactory.client(((OkHttpClient.Builder) lazy.getValue()).build()).build();
        }
    }
}
