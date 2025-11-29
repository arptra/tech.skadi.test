package com.upuphone.xr.sapp.monitor.weather;

import com.upuphone.xr.sapp.monitor.net.HttpConfig;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryWeather$2", f = "WeatherRequest.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WeatherRequest$queryWeather$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $latitude;
    final /* synthetic */ String $longitude;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WeatherRequest$queryWeather$2(String str, String str2, Continuation<? super WeatherRequest$queryWeather$2> continuation) {
        super(2, continuation);
        this.$longitude = str;
        this.$latitude = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WeatherRequest$queryWeather$2(this.$longitude, this.$latitude, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String h = HttpConfig.f7742a.h();
            String str = this.$longitude;
            String str2 = this.$latitude;
            return URLDecoder.decode(h + "/search4WeatherByLatLon?lon=" + str + "&lat=" + str2, "UTF-8");
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((WeatherRequest$queryWeather$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
