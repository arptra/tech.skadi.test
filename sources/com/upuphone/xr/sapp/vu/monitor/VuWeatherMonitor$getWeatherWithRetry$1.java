package com.upuphone.xr.sapp.vu.monitor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor", f = "VuWeatherMonitor.kt", i = {0, 0, 1, 1, 1}, l = {45, 50}, m = "getWeatherWithRetry", n = {"this", "retryCount", "this", "result", "retryCount"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
public final class VuWeatherMonitor$getWeatherWithRetry$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VuWeatherMonitor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuWeatherMonitor$getWeatherWithRetry$1(VuWeatherMonitor vuWeatherMonitor, Continuation<? super VuWeatherMonitor$getWeatherWithRetry$1> continuation) {
        super(continuation);
        this.this$0 = vuWeatherMonitor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(this);
    }
}
