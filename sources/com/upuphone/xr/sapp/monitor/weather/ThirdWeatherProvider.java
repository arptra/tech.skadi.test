package com.upuphone.xr.sapp.monitor.weather;

import com.upuphone.xr.interconnect.api.NaviAbilityOperator;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/weather/ThirdWeatherProvider;", "Lcom/upuphone/xr/sapp/monitor/weather/WeatherProvider;", "<init>", "()V", "", "b", "com/upuphone/xr/sapp/monitor/weather/ThirdWeatherProvider$locationCall$1", "Lcom/upuphone/xr/sapp/monitor/weather/ThirdWeatherProvider$locationCall$1;", "locationCall", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "c", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptionHandler", "d", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nThirdWeatherProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThirdWeatherProvider.kt\ncom/upuphone/xr/sapp/monitor/weather/ThirdWeatherProvider\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,88:1\n48#2,4:89\n*S KotlinDebug\n*F\n+ 1 ThirdWeatherProvider.kt\ncom/upuphone/xr/sapp/monitor/weather/ThirdWeatherProvider\n*L\n45#1:89,4\n*E\n"})
public final class ThirdWeatherProvider extends WeatherProvider {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);
    public static long e;
    public static NaviLocationInfo f;
    public ThirdWeatherProvider$locationCall$1 b = new ThirdWeatherProvider$locationCall$1(this);
    public final CoroutineExceptionHandler c = new ThirdWeatherProvider$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.a0, this);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/weather/ThirdWeatherProvider$Companion;", "", "()V", "TAG", "", "lastLocationTime", "", "location", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public void b() {
        NaviAbilityOperator naviAbilityOperator;
        StarryMessageHelper starryMessageHelper = StarryMessageHelper.f7799a;
        if (!starryMessageHelper.g()) {
            WeatherDataListener a2 = a();
            if (a2 != null) {
                a2.a("互联未连接");
                return;
            }
            return;
        }
        if (System.currentTimeMillis() - e > 600000) {
            ILog.i("Weather-ThirdWeatherProvider", "定位数据过期，清除重新获取");
            f = null;
        }
        NaviLocationInfo naviLocationInfo = f;
        if (naviLocationInfo == null) {
            ILog.i("Weather-ThirdWeatherProvider", "定位数据为空,获取定位信息");
            OperatorManager f2 = starryMessageHelper.f();
            if (f2 != null && (naviAbilityOperator = f2.getNaviAbilityOperator()) != null) {
                naviAbilityOperator.startLocation(this.b);
                return;
            }
            return;
        }
        String city = naviLocationInfo != null ? naviLocationInfo.getCity() : null;
        if (city != null) {
            boolean isBlank = StringsKt.isBlank(city);
        }
        NaviLocationInfo naviLocationInfo2 = f;
        String district = naviLocationInfo2 != null ? naviLocationInfo2.getDistrict() : null;
        if (district != null) {
            boolean isBlank2 = StringsKt.isBlank(district);
        }
        NaviLocationInfo naviLocationInfo3 = f;
        Object obj = "";
        Object valueOf = naviLocationInfo3 != null ? Double.valueOf(naviLocationInfo3.getLatitude()) : obj;
        NaviLocationInfo naviLocationInfo4 = f;
        if (naviLocationInfo4 != null) {
            obj = Double.valueOf(naviLocationInfo4.getLongitude());
        }
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), this.c, (CoroutineStart) null, new ThirdWeatherProvider$getWeather$1(valueOf, obj, this, (Continuation<? super ThirdWeatherProvider$getWeather$1>) null), 2, (Object) null);
    }
}
