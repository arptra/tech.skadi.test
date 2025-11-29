package com.upuphone.xr.sapp.monitor.weather;

import com.upuphone.star.httplib.HttpInstance;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import com.upuphone.xr.sapp.monitor.net.HttpConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H@¢\u0006\u0004\b\b\u0010\tJ,\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004H@¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/weather/WeatherRequest;", "", "<init>", "()V", "", "latitude", "longitude", "Lcom/upuphone/xr/sapp/monitor/weather/model/ArWeatherModel;", "c", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unit", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/star/httplib/HttpInstance;", "b", "Lcom/upuphone/star/httplib/HttpInstance;", "http", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nWeatherRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeatherRequest.kt\ncom/upuphone/xr/sapp/monitor/weather/WeatherRequest\n+ 2 HttpInstance.kt\ncom/upuphone/star/httplib/HttpInstance\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,115:1\n92#2,5:116\n92#2,5:123\n1855#3,2:121\n*S KotlinDebug\n*F\n+ 1 WeatherRequest.kt\ncom/upuphone/xr/sapp/monitor/weather/WeatherRequest\n*L\n31#1:116,5\n91#1:123,5\n46#1:121,2\n*E\n"})
public final class WeatherRequest {

    /* renamed from: a  reason: collision with root package name */
    public static final WeatherRequest f7809a = new WeatherRequest();
    public static final HttpInstance b = HttpConfig.f7742a.d();

    public static /* synthetic */ Object b(WeatherRequest weatherRequest, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = ProtocolVersions.PROTOCOL_KEY_MAX_MTU_SIZE;
        }
        return weatherRequest.a(str, str2, str3, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0080 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00dc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r23, java.lang.String r24, java.lang.String r25, kotlin.coroutines.Continuation r26) {
        /*
            r22 = this;
            r0 = r26
            boolean r1 = r0 instanceof com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryOverseaWeather$1
            if (r1 == 0) goto L_0x0015
            r1 = r0
            com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryOverseaWeather$1 r1 = (com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryOverseaWeather$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001c
        L_0x0015:
            com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryOverseaWeather$1 r1 = new com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryOverseaWeather$1
            r2 = r22
            r1.<init>(r2, r0)
        L_0x001c:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 2
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L_0x0041
            if (r3 == r5) goto L_0x0039
            if (r3 != r4) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0081
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            java.lang.Object r3 = r1.L$0
            com.upuphone.star.httplib.HttpInstance r3 = (com.upuphone.star.httplib.HttpInstance) r3
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0060
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r0)
            com.upuphone.star.httplib.HttpInstance r3 = b
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryOverseaWeather$2 r7 = new com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryOverseaWeather$2
            r8 = r23
            r9 = r24
            r10 = r25
            r7.<init>(r9, r8, r10, r6)
            r1.L$0 = r3
            r1.label = r5
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r0, r7, r1)
            if (r0 != r2) goto L_0x0060
            return r2
        L_0x0060:
            java.lang.String r5 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            java.lang.String r0 = (java.lang.String) r0
            com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryOverseaWeather$$inlined$get$default$1 r5 = new com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryOverseaWeather$$inlined$get$default$1
            r5.<init>()
            java.lang.reflect.Type r5 = r5.getType()
            java.lang.String r7 = "object : TypeToken<T>() {}.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            r1.L$0 = r6
            r1.label = r4
            java.lang.Object r0 = r3.d(r0, r6, r5, r1)
            if (r0 != r2) goto L_0x0081
            return r2
        L_0x0081:
            com.upuphone.star.httplib.HttpResult r0 = (com.upuphone.star.httplib.HttpResult) r0
            java.lang.Object r0 = com.upuphone.star.httplib.HttpResultKt.a(r0)
            com.upuphone.xr.sapp.entity.OverseaWeatherResponse r0 = (com.upuphone.xr.sapp.entity.OverseaWeatherResponse) r0
            if (r0 == 0) goto L_0x00dc
            com.upuphone.xr.sapp.entity.OverseaWeatherResponse$Data r0 = r0.getData()
            if (r0 == 0) goto L_0x00dc
            java.lang.String r1 = r0.getTemp()
            java.lang.Double r1 = kotlin.text.StringsKt.toDoubleOrNull(r1)
            if (r1 == 0) goto L_0x00a4
            double r1 = r1.doubleValue()
            int r1 = (int) r1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
        L_0x00a4:
            r8 = r6
            int r1 = r0.getIconCode()
            java.lang.String r13 = java.lang.String.valueOf(r1)
            java.lang.String r9 = r0.getQweather()
            java.lang.String r14 = r0.getLastUpdate()
            java.lang.String r15 = r0.getSunriseTime()
            java.lang.String r16 = r0.getSunsetTime()
            java.util.ArrayList r19 = new java.util.ArrayList
            r19.<init>()
            com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel r0 = new com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel
            r1 = 0
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r20 = 1536(0x600, float:2.152E-42)
            r21 = 0
            java.lang.String r12 = ""
            r17 = 0
            r18 = 0
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        L_0x00dc:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.weather.WeatherRequest.a(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01ad A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(java.lang.String r23, java.lang.String r24, kotlin.coroutines.Continuation r25) {
        /*
            r22 = this;
            r0 = r25
            boolean r1 = r0 instanceof com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryWeather$1
            if (r1 == 0) goto L_0x0015
            r1 = r0
            com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryWeather$1 r1 = (com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryWeather$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001c
        L_0x0015:
            com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryWeather$1 r1 = new com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryWeather$1
            r2 = r22
            r1.<init>(r2, r0)
        L_0x001c:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 2
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x0041
            if (r3 == r6) goto L_0x0039
            if (r3 != r4) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x007f
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            java.lang.Object r3 = r1.L$0
            com.upuphone.star.httplib.HttpInstance r3 = (com.upuphone.star.httplib.HttpInstance) r3
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x005e
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r0)
            com.upuphone.star.httplib.HttpInstance r3 = b
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryWeather$2 r7 = new com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryWeather$2
            r8 = r23
            r9 = r24
            r7.<init>(r9, r8, r5)
            r1.L$0 = r3
            r1.label = r6
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r0, r7, r1)
            if (r0 != r2) goto L_0x005e
            return r2
        L_0x005e:
            java.lang.String r7 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r7)
            java.lang.String r0 = (java.lang.String) r0
            com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryWeather$$inlined$get$default$1 r7 = new com.upuphone.xr.sapp.monitor.weather.WeatherRequest$queryWeather$$inlined$get$default$1
            r7.<init>()
            java.lang.reflect.Type r7 = r7.getType()
            java.lang.String r8 = "object : TypeToken<T>() {}.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            r1.L$0 = r5
            r1.label = r4
            java.lang.Object r0 = r3.d(r0, r5, r7, r1)
            if (r0 != r2) goto L_0x007f
            return r2
        L_0x007f:
            com.upuphone.star.httplib.HttpResult r0 = (com.upuphone.star.httplib.HttpResult) r0
            java.lang.Object r0 = com.upuphone.star.httplib.HttpResultKt.a(r0)
            com.upuphone.xr.sapp.entity.WeatherResponse r0 = (com.upuphone.xr.sapp.entity.WeatherResponse) r0
            if (r0 == 0) goto L_0x01ad
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "查询天气结果 "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "Weather-WeatherMonitor"
            com.upuphone.xr.interconnect.util.log.ILog.i(r2, r1)
            java.util.List r1 = r0.getFutureDays()
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r6
            r2 = 0
            if (r1 == 0) goto L_0x00d7
            java.util.List r1 = r0.getFutureDays()
            int r1 = r1.size()
            if (r1 <= r4) goto L_0x00d7
            java.util.List r1 = r0.getFutureDays()
            java.lang.Object r1 = r1.get(r6)
            com.upuphone.xr.sapp.entity.WeatherResponse$FutureDay r1 = (com.upuphone.xr.sapp.entity.WeatherResponse.FutureDay) r1
            int r1 = r1.getDayTemp()
            java.util.List r3 = r0.getFutureDays()
            java.lang.Object r3 = r3.get(r6)
            com.upuphone.xr.sapp.entity.WeatherResponse$FutureDay r3 = (com.upuphone.xr.sapp.entity.WeatherResponse.FutureDay) r3
            java.lang.String r3 = r3.getNightTemp()
            int r3 = java.lang.Integer.parseInt(r3)
            goto L_0x00d9
        L_0x00d7:
            r1 = r2
            r3 = r1
        L_0x00d9:
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            com.upuphone.xr.sapp.utils.DateUtil r4 = com.upuphone.xr.sapp.utils.DateUtil.f7876a
            com.upuphone.xr.sapp.entity.WeatherResponse$Weather r5 = r0.getWeather()
            java.lang.String r5 = r5.getLastUpdate()
            java.lang.String r6 = "yyyy-MM-dd"
            java.util.Date r4 = r4.c(r5, r6)
            java.util.List r5 = r0.getFutureDays()
            java.util.Iterator r5 = r5.iterator()
        L_0x00f7:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0145
            java.lang.Object r7 = r5.next()
            com.upuphone.xr.sapp.entity.WeatherResponse$FutureDay r7 = (com.upuphone.xr.sapp.entity.WeatherResponse.FutureDay) r7
            com.upuphone.xr.sapp.utils.DateUtil r8 = com.upuphone.xr.sapp.utils.DateUtil.f7876a
            java.lang.String r9 = r7.getDate()
            java.util.Date r8 = r8.c(r9, r6)
            boolean r8 = r8.before(r4)
            if (r8 != 0) goto L_0x00f7
            int r8 = r15.size()
            r9 = 7
            if (r8 >= r9) goto L_0x00f7
            com.upuphone.xr.sapp.monitor.weather.model.ArFutureDay r8 = new com.upuphone.xr.sapp.monitor.weather.model.ArFutureDay
            java.lang.String r17 = r7.getDate()
            int r9 = r7.getDayTemp()
            java.lang.Integer r18 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            java.lang.String r9 = r7.getNightTemp()
            int r9 = java.lang.Integer.parseInt(r9)
            java.lang.Integer r19 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            java.lang.String r20 = r7.getWeather()
            java.lang.String r21 = r7.getWeatherIconCode()
            r16 = r8
            r16.<init>(r17, r18, r19, r20, r21)
            r15.add(r8)
            goto L_0x00f7
        L_0x0145:
            com.upuphone.xr.sapp.entity.WeatherResponse$Weather r4 = r0.getWeather()
            int r4 = r4.getTemp()
            com.upuphone.xr.sapp.entity.WeatherResponse$Weather r5 = r0.getWeather()
            java.lang.String r9 = r5.getAreaName()
            com.upuphone.xr.sapp.entity.WeatherResponse$Weather r5 = r0.getWeather()
            java.lang.String r10 = r5.getIconCode()
            com.upuphone.xr.sapp.entity.WeatherResponse$Weather r5 = r0.getWeather()
            java.lang.String r6 = r5.getWeather()
            com.upuphone.xr.sapp.entity.WeatherResponse$Weather r5 = r0.getWeather()
            java.lang.String r11 = r5.getLastUpdate()
            com.upuphone.xr.sapp.entity.WeatherResponse$Weather r5 = r0.getWeather()
            java.lang.String r12 = r5.getSunriseTime()
            com.upuphone.xr.sapp.entity.WeatherResponse$Weather r5 = r0.getWeather()
            java.lang.String r13 = r5.getSunsetTime()
            com.upuphone.xr.sapp.entity.WeatherResponse$Aqi r5 = r0.getAqi()
            if (r5 == 0) goto L_0x0187
            int r2 = r5.getAqi()
        L_0x0187:
            r14 = r2
            com.upuphone.xr.sapp.entity.WeatherResponse$Aqi r0 = r0.getAqi()
            if (r0 == 0) goto L_0x0194
            java.lang.String r0 = r0.getQuality()
            if (r0 != 0) goto L_0x0196
        L_0x0194:
            java.lang.String r0 = ""
        L_0x0196:
            com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel r2 = new com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            r4 = r2
            r1 = r15
            r15 = r0
            r16 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r2
        L_0x01ad:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.weather.WeatherRequest.c(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
