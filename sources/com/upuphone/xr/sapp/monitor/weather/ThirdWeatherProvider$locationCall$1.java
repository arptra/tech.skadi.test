package com.upuphone.xr.sapp.monitor.weather;

import com.upuphone.xr.interconnect.api.NaviAbilityOperator;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.interconnect.listener.NaviLocationCallback;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/monitor/weather/ThirdWeatherProvider$locationCall$1", "Lcom/upuphone/xr/interconnect/listener/NaviLocationCallback;", "onLocationChanged", "", "locationInfo", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ThirdWeatherProvider$locationCall$1 extends NaviLocationCallback {
    final /* synthetic */ ThirdWeatherProvider this$0;

    public ThirdWeatherProvider$locationCall$1(ThirdWeatherProvider thirdWeatherProvider) {
        this.this$0 = thirdWeatherProvider;
    }

    public void onLocationChanged(@Nullable NaviLocationInfo naviLocationInfo) {
        NaviAbilityOperator naviAbilityOperator;
        ILog.i("Weather-ThirdWeatherProvider", "onLocationChanged");
        if (naviLocationInfo != null) {
            ThirdWeatherProvider thirdWeatherProvider = this.this$0;
            if (naviLocationInfo.getLatitude() > 0.0d && naviLocationInfo.getLongitude() > 0.0d) {
                double latitude = naviLocationInfo.getLatitude();
                double longitude = naviLocationInfo.getLongitude();
                ILog.i("Weather-ThirdWeatherProvider", "latitude:" + latitude + "-longitude:$" + longitude);
                ThirdWeatherProvider.f = naviLocationInfo;
                ThirdWeatherProvider.e = System.currentTimeMillis();
                thirdWeatherProvider.b();
            }
        }
        OperatorManager f = StarryMessageHelper.f7799a.f();
        if (f != null && (naviAbilityOperator = f.getNaviAbilityOperator()) != null) {
            naviAbilityOperator.stopLocation(this);
        }
    }
}
