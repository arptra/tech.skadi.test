package com.upuphone.xr.sapp.monitor.weather;

import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/monitor/weather/WeatherWorker$queryWeather$2$1$1$onWeatherUpdated$2", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "onFail", "", "p0", "", "p1", "", "onSuccess", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WeatherWorker$queryWeather$2$1$1$onWeatherUpdated$2 extends SendMessageListener {
    final /* synthetic */ CancellableContinuation<Boolean> $continuation;

    public WeatherWorker$queryWeather$2$1$1$onWeatherUpdated$2(CancellableContinuation<? super Boolean> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public void onFail(@Nullable String str, int i) {
        ILog.i("Weather-WeatherWorker", "刷新发送失败：" + str + " ---" + i + " ");
        if (StarryMessageHelper.f7799a.g() && this.$continuation.isActive()) {
            CancellableContinuation<Boolean> cancellableContinuation = this.$continuation;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(Boolean.FALSE));
        }
    }

    public void onSuccess(@Nullable String str) {
        ILog.i("Weather-WeatherWorker", "刷新发送成功");
        if (this.$continuation.isActive()) {
            CancellableContinuation<Boolean> cancellableContinuation = this.$continuation;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(Boolean.TRUE));
        }
    }
}
