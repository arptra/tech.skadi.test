package com.upuphone.xr.sapp.monitor.weather;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.weather.ThirdWeatherProvider$getWeather$1", f = "ThirdWeatherProvider.kt", i = {}, l = {77, 79}, m = "invokeSuspend", n = {}, s = {})
public final class ThirdWeatherProvider$getWeather$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $latitude;
    final /* synthetic */ Object $longitude;
    int label;
    final /* synthetic */ ThirdWeatherProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThirdWeatherProvider$getWeather$1(Object obj, Object obj2, ThirdWeatherProvider thirdWeatherProvider, Continuation<? super ThirdWeatherProvider$getWeather$1> continuation) {
        super(2, continuation);
        this.$latitude = obj;
        this.$longitude = obj2;
        this.this$0 = thirdWeatherProvider;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ThirdWeatherProvider$getWeather$1(this.$latitude, this.$longitude, this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0071  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x005e
        L_0x0012:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0044
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r12)
            com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager r12 = com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager.f7749a
            boolean r12 = r12.B()
            if (r12 == 0) goto L_0x0047
            com.upuphone.xr.sapp.monitor.weather.WeatherRequest r4 = com.upuphone.xr.sapp.monitor.weather.WeatherRequest.f7809a
            java.lang.Object r12 = r11.$latitude
            java.lang.String r5 = java.lang.String.valueOf(r12)
            java.lang.Object r12 = r11.$longitude
            java.lang.String r6 = java.lang.String.valueOf(r12)
            r11.label = r3
            r7 = 0
            r9 = 4
            r10 = 0
            r8 = r11
            java.lang.Object r12 = com.upuphone.xr.sapp.monitor.weather.WeatherRequest.b(r4, r5, r6, r7, r8, r9, r10)
            if (r12 != r0) goto L_0x0044
            return r0
        L_0x0044:
            com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel r12 = (com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel) r12
            goto L_0x0060
        L_0x0047:
            com.upuphone.xr.sapp.monitor.weather.WeatherRequest r12 = com.upuphone.xr.sapp.monitor.weather.WeatherRequest.f7809a
            java.lang.Object r1 = r11.$latitude
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.Object r3 = r11.$longitude
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r11.label = r2
            java.lang.Object r12 = r12.c(r1, r3, r11)
            if (r12 != r0) goto L_0x005e
            return r0
        L_0x005e:
            com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel r12 = (com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel) r12
        L_0x0060:
            if (r12 != 0) goto L_0x0071
            com.upuphone.xr.sapp.monitor.weather.ThirdWeatherProvider r11 = r11.this$0
            com.upuphone.xr.sapp.monitor.weather.WeatherDataListener r11 = r11.a()
            if (r11 == 0) goto L_0x007c
            java.lang.String r12 = "请求天气失败"
            r11.a(r12)
            goto L_0x007c
        L_0x0071:
            com.upuphone.xr.sapp.monitor.weather.ThirdWeatherProvider r11 = r11.this$0
            com.upuphone.xr.sapp.monitor.weather.WeatherDataListener r11 = r11.a()
            if (r11 == 0) goto L_0x007c
            r11.b(r12)
        L_0x007c:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.weather.ThirdWeatherProvider$getWeather$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ThirdWeatherProvider$getWeather$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
