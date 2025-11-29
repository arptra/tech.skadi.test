package com.upuphone.xr.sapp.monitor.weather;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.meizu.flyme.weather.common.IWeatherInformationService;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/monitor/weather/FlymeWeatherProvider$mServiceConnection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FlymeWeatherProvider$mServiceConnection$1 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlymeWeatherProvider f7802a;

    public FlymeWeatherProvider$mServiceConnection$1(FlymeWeatherProvider flymeWeatherProvider) {
        this.f7802a = flymeWeatherProvider;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f7802a.b = IWeatherInformationService.Stub.asInterface(iBinder);
        this.f7802a.c = true;
        ULog.Delegate delegate = ULog.f6446a;
        boolean d = this.f7802a.c;
        delegate.a("Weather-FlymeWeatherProvider", "mServiceConnection is connected mIsBind:" + d);
        this.f7802a.b();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f7802a.b = null;
        this.f7802a.c = false;
        ULog.Delegate delegate = ULog.f6446a;
        boolean d = this.f7802a.c;
        delegate.a("Weather-FlymeWeatherProvider", "mServiceConnection is disconnected mIsBind:" + d);
    }
}
