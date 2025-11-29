package com.upuphone.xr.sapp.monitor.weather;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.weather.WeatherRequest", f = "WeatherRequest.kt", i = {}, l = {91, 120}, m = "queryOverseaWeather", n = {}, s = {})
public final class WeatherRequest$queryOverseaWeather$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WeatherRequest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WeatherRequest$queryOverseaWeather$1(WeatherRequest weatherRequest, Continuation<? super WeatherRequest$queryOverseaWeather$1> continuation) {
        super(continuation);
        this.this$0 = weatherRequest;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((String) null, (String) null, (String) null, this);
    }
}
