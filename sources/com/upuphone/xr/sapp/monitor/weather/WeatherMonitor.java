package com.upuphone.xr.sapp.monitor.weather;

import android.content.IntentFilter;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.httplib.HttpUtils;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.xjmz.myvu.ext.ContextExtKt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0005*\u0001\u0010\u0018\u0000 \t2\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/weather/WeatherMonitor;", "", "<init>", "()V", "", "d", "e", "", "cycleTime", "c", "(Ljava/lang/Long;)V", "b", "", "a", "Z", "isInit", "com/upuphone/xr/sapp/monitor/weather/WeatherMonitor$mBroadcastReceiver$1", "Lcom/upuphone/xr/sapp/monitor/weather/WeatherMonitor$mBroadcastReceiver$1;", "mBroadcastReceiver", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WeatherMonitor {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public boolean f7805a;
    public final WeatherMonitor$mBroadcastReceiver$1 b = new WeatherMonitor$mBroadcastReceiver$1(this);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/weather/WeatherMonitor$Companion;", "", "()V", "ERROR_TIME", "", "REFRESH_TIME", "TAG", "", "WEATHER_WORKER_TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final void b() {
        ULog.f6446a.a("Weather-WeatherMonitor", "closeQueryWork");
        WorkManager.d(GlobalExtKt.f()).a("weather_worker_tag");
    }

    public final void c(Long l) {
        ULog.f6446a.a("Weather-WeatherMonitor", "createQueryWorker");
        b();
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(WeatherWorker.class);
        builder.a("weather_worker_tag");
        if (l != null) {
            builder.j(l.longValue(), TimeUnit.SECONDS);
        }
        OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) builder.b();
        WorkManager.d(GlobalExtKt.f()).b(oneTimeWorkRequest);
        WorkManager.d(GlobalExtKt.f()).e(oneTimeWorkRequest.a()).observeForever(new WeatherMonitor$sam$androidx_lifecycle_Observer$0(new WeatherMonitor$createQueryWorker$1(this)));
    }

    public final void d() {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = this.f7805a;
        delegate.a("Weather-WeatherMonitor", "init weather monitor isInit:" + z);
        if (!this.f7805a) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_discovery_device");
            intentFilter.addAction("action_client_connect_state_change");
            intentFilter.addAction("android.intent.action.DATE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_SET");
            ContextExtKt.a(MainApplication.k.f(), this.b, intentFilter);
            HttpUtils httpUtils = HttpUtils.f6479a;
            httpUtils.k(true);
            httpUtils.m().interceptors();
            e();
            this.f7805a = true;
        }
    }

    public final void e() {
        ULog.f6446a.a("Weather-WeatherMonitor", "queryWeather");
        c((Long) null);
    }
}
