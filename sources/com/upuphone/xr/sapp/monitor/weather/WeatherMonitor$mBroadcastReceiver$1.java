package com.upuphone.xr.sapp.monitor.weather;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/monitor/weather/WeatherMonitor$mBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WeatherMonitor$mBroadcastReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeatherMonitor f7806a;

    public WeatherMonitor$mBroadcastReceiver$1(WeatherMonitor weatherMonitor) {
        this.f7806a = weatherMonitor;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            WeatherMonitor weatherMonitor = this.f7806a;
            String action = intent.getAction();
            if (action != null) {
                int hashCode = action.hashCode();
                if (hashCode != -515955026) {
                    if (hashCode == 505380757 ? action.equals("android.intent.action.TIME_SET") : hashCode == 1041332296 && action.equals("android.intent.action.DATE_CHANGED")) {
                        ULog.f6446a.a("Weather-WeatherMonitor", "----time change-----");
                        weatherMonitor.e();
                        return;
                    }
                } else if (action.equals("action_discovery_device")) {
                    if (intent.getBooleanExtra("device_online", false)) {
                        ULog.Delegate delegate = ULog.f6446a;
                        delegate.a("Weather-WeatherMonitor", "--ACTION_DISCOVERY_DEVICE----" + weatherMonitor);
                        weatherMonitor.e();
                        return;
                    }
                    return;
                }
            }
            System.out.println("暂不处理");
        }
    }
}
