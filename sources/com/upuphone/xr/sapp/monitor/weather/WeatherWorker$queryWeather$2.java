package com.upuphone.xr.sapp.monitor.weather;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nWeatherWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeatherWorker.kt\ncom/upuphone/xr/sapp/monitor/weather/WeatherWorker$queryWeather$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,114:1\n314#2,11:115\n*S KotlinDebug\n*F\n+ 1 WeatherWorker.kt\ncom/upuphone/xr/sapp/monitor/weather/WeatherWorker$queryWeather$2\n*L\n70#1:115,11\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.weather.WeatherWorker$queryWeather$2", f = "WeatherWorker.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
public final class WeatherWorker$queryWeather$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ WeatherWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WeatherWorker$queryWeather$2(WeatherWorker weatherWorker, Continuation<? super WeatherWorker$queryWeather$2> continuation) {
        super(2, continuation);
        this.this$0 = weatherWorker;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WeatherWorker$queryWeather$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WeatherWorker weatherWorker = this.this$0;
            this.L$0 = weatherWorker;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            WeatherProvider w = weatherWorker.z();
            w.c(new WeatherWorker$queryWeather$2$1$1(weatherWorker, cancellableContinuationImpl));
            if (w instanceof ThirdWeatherProvider) {
                w.b();
            }
            obj = cancellableContinuationImpl.u();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            WeatherWorker weatherWorker2 = (WeatherWorker) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((WeatherWorker$queryWeather$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
