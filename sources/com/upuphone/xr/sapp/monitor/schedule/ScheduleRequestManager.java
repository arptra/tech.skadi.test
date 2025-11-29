package com.upuphone.xr.sapp.monitor.schedule;

import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.monitor.net.TokenInterceptor;
import com.upuphone.xr.sapp.monitor.schedule.request.ScheduleApi;
import com.upuphone.xr.sapp.monitor.schedule.request.ScheduleErrorInterceptor;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/ScheduleRequestManager;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/monitor/schedule/request/ScheduleApi;", "c", "()Lcom/upuphone/xr/sapp/monitor/schedule/request/ScheduleApi;", "Lokhttp3/OkHttpClient$Builder;", "a", "()Lokhttp3/OkHttpClient$Builder;", "", "baseUrl", "builder", "Lretrofit2/Retrofit;", "b", "(Ljava/lang/String;Lokhttp3/OkHttpClient$Builder;)Lretrofit2/Retrofit;", "Lcom/upuphone/xr/sapp/monitor/schedule/request/ScheduleApi;", "api", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ScheduleRequestManager {

    /* renamed from: a  reason: collision with root package name */
    public static final ScheduleRequestManager f7781a = new ScheduleRequestManager();
    public static ScheduleApi b;

    public final OkHttpClient.Builder a() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).addInterceptor(new TokenInterceptor()).addInterceptor(new ScheduleErrorInterceptor());
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return addInterceptor.connectTimeout(10, timeUnit).readTimeout(10, timeUnit).proxy(Proxy.NO_PROXY);
    }

    public final Retrofit b(String str, OkHttpClient.Builder builder) {
        Retrofit build = new Retrofit.Builder().baseUrl(str).addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public final ScheduleApi c() {
        synchronized (this) {
            try {
                if (b == null) {
                    ScheduleRequestManager scheduleRequestManager = f7781a;
                    OkHttpClient.Builder a2 = scheduleRequestManager.a();
                    String u = NetConfig.f6666a.u();
                    b = (ScheduleApi) scheduleRequestManager.b(u + "/", a2).create(ScheduleApi.class);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        ScheduleApi scheduleApi = b;
        Intrinsics.checkNotNull(scheduleApi);
        return scheduleApi;
    }
}
