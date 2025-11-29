package com.upuphone.xr.sapp.monitor.weather;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0003R$\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/weather/WeatherProvider;", "", "<init>", "()V", "", "b", "Lcom/upuphone/xr/sapp/monitor/weather/WeatherDataListener;", "a", "Lcom/upuphone/xr/sapp/monitor/weather/WeatherDataListener;", "()Lcom/upuphone/xr/sapp/monitor/weather/WeatherDataListener;", "c", "(Lcom/upuphone/xr/sapp/monitor/weather/WeatherDataListener;)V", "listener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class WeatherProvider {

    /* renamed from: a  reason: collision with root package name */
    public WeatherDataListener f7808a;

    public final WeatherDataListener a() {
        return this.f7808a;
    }

    public abstract void b();

    public final void c(WeatherDataListener weatherDataListener) {
        this.f7808a = weatherDataListener;
    }
}
