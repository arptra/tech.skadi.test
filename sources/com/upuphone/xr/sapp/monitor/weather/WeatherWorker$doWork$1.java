package com.upuphone.xr.sapp.monitor.weather;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.weather.WeatherWorker", f = "WeatherWorker.kt", i = {}, l = {37}, m = "doWork", n = {}, s = {})
public final class WeatherWorker$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WeatherWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WeatherWorker$doWork$1(WeatherWorker weatherWorker, Continuation<? super WeatherWorker$doWork$1> continuation) {
        super(continuation);
        this.this$0 = weatherWorker;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.r(this);
    }
}
