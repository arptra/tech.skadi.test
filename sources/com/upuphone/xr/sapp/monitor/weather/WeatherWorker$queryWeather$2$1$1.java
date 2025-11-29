package com.upuphone.xr.sapp.monitor.weather;

import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/upuphone/xr/sapp/monitor/weather/WeatherWorker$queryWeather$2$1$1", "Lcom/upuphone/xr/sapp/monitor/weather/WeatherDataListener;", "Lcom/upuphone/xr/sapp/monitor/weather/model/ArWeatherModel;", "weather", "", "b", "(Lcom/upuphone/xr/sapp/monitor/weather/model/ArWeatherModel;)V", "", "error", "a", "(Ljava/lang/String;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WeatherWorker$queryWeather$2$1$1 implements WeatherDataListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeatherWorker f7810a;
    public final /* synthetic */ CancellableContinuation b;

    public WeatherWorker$queryWeather$2$1$1(WeatherWorker weatherWorker, CancellableContinuation cancellableContinuation) {
        this.f7810a = weatherWorker;
        this.b = cancellableContinuation;
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        ILog.i("Weather-WeatherWorker", "WeatherWorker onWeatherError:" + str);
        if (this.b.isActive()) {
            CancellableContinuation cancellableContinuation = this.b;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(Boolean.FALSE));
        }
    }

    public void b(ArWeatherModel arWeatherModel) {
        Intrinsics.checkNotNullParameter(arWeatherModel, VuiModelType.WEATHER);
        ILog.i("Weather-WeatherWorker", "WeatherWorker onWeatherUpdated");
        Job unused = BuildersKt__Builders_commonKt.d(this.f7810a.h, (CoroutineContext) null, (CoroutineStart) null, new WeatherWorker$queryWeather$2$1$1$onWeatherUpdated$1(arWeatherModel, (Continuation<? super WeatherWorker$queryWeather$2$1$1$onWeatherUpdated$1>) null), 3, (Object) null);
        StarryMessageHelper.p(StarryMessageHelper.f7799a, (byte[]) null, VuiModelType.WEATHER, arWeatherModel, new WeatherWorker$queryWeather$2$1$1$onWeatherUpdated$2(this.b), (String) null, 17, (Object) null);
    }
}
