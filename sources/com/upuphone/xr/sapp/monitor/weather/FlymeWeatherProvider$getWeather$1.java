package com.upuphone.xr.sapp.monitor.weather;

import com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/upuphone/xr/sapp/monitor/weather/FlymeWeatherProvider$getWeather$1", "Lcom/upuphone/xr/sapp/monitor/weather/WeatherDataListener;", "Lcom/upuphone/xr/sapp/monitor/weather/model/ArWeatherModel;", "weather", "", "b", "(Lcom/upuphone/xr/sapp/monitor/weather/model/ArWeatherModel;)V", "", "error", "a", "(Ljava/lang/String;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FlymeWeatherProvider$getWeather$1 implements WeatherDataListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlymeWeatherProvider f7801a;

    public FlymeWeatherProvider$getWeather$1(FlymeWeatherProvider flymeWeatherProvider) {
        this.f7801a = flymeWeatherProvider;
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        WeatherDataListener a2 = this.f7801a.a();
        if (a2 != null) {
            a2.a("weatherString is null");
        }
    }

    public void b(ArWeatherModel arWeatherModel) {
        Intrinsics.checkNotNullParameter(arWeatherModel, VuiModelType.WEATHER);
        WeatherDataListener a2 = this.f7801a.a();
        if (a2 != null) {
            a2.b(arWeatherModel);
        }
    }
}
