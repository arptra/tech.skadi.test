package com.upuphone.xr.sapp.monitor.weather;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.meizu.flyme.weather.common.IWeatherInformationService;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.WeatherAIDLInfo;
import com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.xjsd.xr.sapp.asr.utils.GsonHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u0001\u0015\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J!\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/weather/FlymeWeatherProvider;", "Lcom/upuphone/xr/sapp/monitor/weather/WeatherProvider;", "<init>", "()V", "", "b", "g", "i", "Landroid/content/Context;", "context", "", "packageName", "", "h", "(Landroid/content/Context;Ljava/lang/String;)Z", "Lcom/meizu/flyme/weather/common/IWeatherInformationService;", "Lcom/meizu/flyme/weather/common/IWeatherInformationService;", "mIWeatherInformationService", "c", "Z", "mIsBind", "com/upuphone/xr/sapp/monitor/weather/FlymeWeatherProvider$mServiceConnection$1", "d", "Lcom/upuphone/xr/sapp/monitor/weather/FlymeWeatherProvider$mServiceConnection$1;", "mServiceConnection", "e", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class FlymeWeatherProvider extends WeatherProvider {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public IWeatherInformationService b;
    public boolean c;
    public final FlymeWeatherProvider$mServiceConnection$1 d = new FlymeWeatherProvider$mServiceConnection$1(this);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/weather/FlymeWeatherProvider$Companion;", "", "()V", "NEW_WEATHER_PACK_NAME", "", "OLD_WEATHER_PACK_NAME", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public FlymeWeatherProvider() {
        g();
    }

    public void b() {
        IWeatherInformationService iWeatherInformationService = this.b;
        if (iWeatherInformationService != null) {
            String widgetCityWeatherInfo = iWeatherInformationService != null ? iWeatherInformationService.getWidgetCityWeatherInfo() : null;
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("Weather-FlymeWeatherProvider", "weatherString:" + widgetCityWeatherInfo);
            if (widgetCityWeatherInfo != null) {
                WeatherAIDLInfo weatherAIDLInfo = (WeatherAIDLInfo) GsonHelper.fromJson(widgetCityWeatherInfo, WeatherAIDLInfo.class);
                Integer intOrNull = StringsKt.toIntOrNull(weatherAIDLInfo.getWidget().getTemp());
                Integer valueOf = Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 0);
                String weather = weatherAIDLInfo.getWidget().getWeather();
                String cityName = weatherAIDLInfo.getWidget().getCityName();
                String img = weatherAIDLInfo.getWidget().getImg();
                Integer intOrNull2 = StringsKt.toIntOrNull(weatherAIDLInfo.getWidget().getAqi());
                ArWeatherModel arWeatherModel = new ArWeatherModel(valueOf, weather, (Integer) null, (Integer) null, cityName, img, (String) null, (String) null, (String) null, intOrNull2 != null ? intOrNull2.intValue() : 0, weatherAIDLInfo.getWidget().getQuality(), new ArrayList());
                WeatherDataListener a2 = a();
                if (a2 != null) {
                    a2.b(arWeatherModel);
                }
            } else {
                ThirdWeatherProvider thirdWeatherProvider = new ThirdWeatherProvider();
                thirdWeatherProvider.c(new FlymeWeatherProvider$getWeather$1(this));
                thirdWeatherProvider.b();
            }
            i();
        }
    }

    public final void g() {
        if (this.b == null) {
            Intent intent = new Intent();
            if (h(GlobalExtKt.f(), "com.hy.weather.mz")) {
                intent.setPackage("com.hy.weather.mz");
            } else {
                intent.setPackage("com.meizu.flyme.weather");
            }
            intent.setAction(IWeatherInformationService.DESCRIPTOR);
            boolean bindService = GlobalExtKt.f().bindService(intent, this.d, 1);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("Weather-FlymeWeatherProvider", "can bind weather service:" + bindService);
        }
    }

    public final boolean h(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            Intrinsics.checkNotNull(str);
            packageManager.getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final void i() {
        try {
            if (this.c) {
                GlobalExtKt.f().unbindService(this.d);
                this.c = false;
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("Weather-FlymeWeatherProvider", "unbindService() mIsBind:" + false);
            }
        } catch (IllegalArgumentException unused) {
            ULog.f6446a.a("Weather-FlymeWeatherProvider", "unbindService() Service not registered");
        }
    }
}
