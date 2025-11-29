package com.upuphone.xr.sapp.vu.monitor;

import android.os.SystemClock;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.common.INaviLocationCallback;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.sapp.MainApplication;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/xr/sapp/vu/monitor/VuWeatherMonitor$getLocation$2$listener$1", "Lcom/upuphone/xr/interconnect/common/INaviLocationCallback$Stub;", "onLocationChanged", "", "locationInfo", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VuWeatherMonitor$getLocation$2$listener$1 extends INaviLocationCallback.Stub {
    final /* synthetic */ CancellableContinuation<NaviLocationInfo> $continuation;
    final /* synthetic */ VuWeatherMonitor this$0;

    public VuWeatherMonitor$getLocation$2$listener$1(VuWeatherMonitor vuWeatherMonitor, CancellableContinuation<? super NaviLocationInfo> cancellableContinuation) {
        this.this$0 = vuWeatherMonitor;
        this.$continuation = cancellableContinuation;
    }

    public void onLocationChanged(@Nullable NaviLocationInfo naviLocationInfo) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuWeatherMonitor", "onLocationChanged: " + naviLocationInfo);
        this.this$0.f8080a = naviLocationInfo;
        this.this$0.b = SystemClock.elapsedRealtime();
        NaviManager.getInstance(MainApplication.k.f()).stopLocation(this);
        if (this.$continuation.isActive()) {
            this.$continuation.resumeWith(Result.m20constructorimpl(naviLocationInfo));
        }
    }
}
