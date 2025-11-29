package com.upuphone.xr.sapp.monitor.weather;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.utils.VersionMatchHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH@¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH@¢\u0006\u0004\b\u000f\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/weather/WeatherWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/ListenableWorker$Result;", "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/monitor/weather/WeatherProvider;", "z", "()Lcom/upuphone/xr/sapp/monitor/weather/WeatherProvider;", "", "A", "Lkotlinx/coroutines/CoroutineScope;", "h", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "i", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WeatherWorker extends CoroutineWorker {
    public static final Companion i = new Companion((DefaultConstructorMarker) null);
    public final CoroutineScope h = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/weather/WeatherWorker$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WeatherWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object A(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.upuphone.xr.sapp.monitor.weather.WeatherWorker$queryWeather$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.upuphone.xr.sapp.monitor.weather.WeatherWorker$queryWeather$1 r0 = (com.upuphone.xr.sapp.monitor.weather.WeatherWorker$queryWeather$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.monitor.weather.WeatherWorker$queryWeather$1 r0 = new com.upuphone.xr.sapp.monitor.weather.WeatherWorker$queryWeather$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0045
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            com.upuphone.xr.sapp.monitor.weather.WeatherWorker$queryWeather$2 r5 = new com.upuphone.xr.sapp.monitor.weather.WeatherWorker$queryWeather$2
            r2 = 0
            r5.<init>(r4, r2)
            r0.label = r3
            r2 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r5 = kotlinx.coroutines.TimeoutKt.d(r2, r5, r0)
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            if (r5 == 0) goto L_0x004e
            boolean r4 = r5.booleanValue()
            goto L_0x004f
        L_0x004e:
            r4 = 0
        L_0x004f:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.weather.WeatherWorker.A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object r(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.upuphone.xr.sapp.monitor.weather.WeatherWorker$doWork$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.upuphone.xr.sapp.monitor.weather.WeatherWorker$doWork$1 r0 = (com.upuphone.xr.sapp.monitor.weather.WeatherWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.monitor.weather.WeatherWorker$doWork$1 r0 = new com.upuphone.xr.sapp.monitor.weather.WeatherWorker$doWork$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = r4.A(r0)
            if (r5 != r1) goto L_0x003d
            return r1
        L_0x003d:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r4 = r5.booleanValue()
            if (r4 == 0) goto L_0x004a
            androidx.work.ListenableWorker$Result r4 = androidx.work.ListenableWorker.Result.c()
            goto L_0x004e
        L_0x004a:
            androidx.work.ListenableWorker$Result r4 = androidx.work.ListenableWorker.Result.a()
        L_0x004e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "WeatherWorker result:"
            r5.append(r0)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            java.lang.String r0 = "Weather-WeatherWorker"
            com.upuphone.xr.interconnect.util.log.ILog.i(r0, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.weather.WeatherWorker.r(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final WeatherProvider z() {
        boolean g = VersionMatchHelper.g(VersionMatchHelper.f7930a, false, false, false, GlassInfoExtKt.c(GlassInfoExtKt.d("Flyme AR 1.0.9.0.20240424_Air_FR")), (String) null, GlassInfoExtKt.c(GlassInfoExtKt.d("1.1.0.274")), (String) null, 86, (Object) null);
        Boolean bool = BuildConfig.b;
        if (!bool.booleanValue() && !BuildConfig.f6575a.booleanValue() && g) {
            return new FlymeWeatherProvider();
        }
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        return bool.booleanValue() ? new ThirdWeatherProvider() : new ThirdWeatherProvider();
    }
}
