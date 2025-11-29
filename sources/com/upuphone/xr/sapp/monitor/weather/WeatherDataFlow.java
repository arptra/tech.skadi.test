package com.upuphone.xr.sapp.monitor.weather;

import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0007\u0010\bR\u001f\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/weather/WeatherDataFlow;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/monitor/weather/model/ArWeatherModel;", "weatherModel", "", "b", "(Lcom/upuphone/xr/sapp/monitor/weather/model/ArWeatherModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "a", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "weatherData", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WeatherDataFlow {

    /* renamed from: a  reason: collision with root package name */
    public static final WeatherDataFlow f7804a = new WeatherDataFlow();
    public static final MutableSharedFlow b = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);

    public final MutableSharedFlow a() {
        return b;
    }

    public final Object b(ArWeatherModel arWeatherModel, Continuation continuation) {
        ILog.d("WeatherDataFlow", "onWeatherDataChange: " + arWeatherModel);
        Object emit = b.emit(arWeatherModel, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }
}
