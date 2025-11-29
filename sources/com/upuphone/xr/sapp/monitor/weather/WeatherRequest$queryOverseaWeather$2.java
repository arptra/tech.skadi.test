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
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryOverseaWeather$2", f = "WeatherRequest.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WeatherRequest$queryOverseaWeather$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $latitude;
    final /* synthetic */ String $longitude;
    final /* synthetic */ String $unit;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WeatherRequest$queryOverseaWeather$2(String str, String str2, String str3, Continuation<? super WeatherRequest$queryOverseaWeather$2> continuation) {
        super(2, continuation);
        this.$longitude = str;
        this.$latitude = str2;
        this.$unit = str3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WeatherRequest$queryOverseaWeather$2(this.$longitude, this.$latitude, this.$unit, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String i = HttpConfig.f7742a.i();
            String str = this.$longitude;
            String str2 = this.$latitude;
            String str3 = this.$unit;
            return URLDecoder.decode(i + "/weather/now?longitude=" + str + "&latitude=" + str2 + "&unit=" + str3, "UTF-8");
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((WeatherRequest$queryOverseaWeather$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
