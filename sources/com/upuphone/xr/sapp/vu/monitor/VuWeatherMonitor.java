package com.upuphone.xr.sapp.vu.monitor;

import android.os.SystemClock;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.sapp.MainApplication;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H@¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H@¢\u0006\u0004\b\t\u0010\bJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\fH@¢\u0006\u0004\b\r\u0010\bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/sapp/vu/monitor/VuWeatherMonitor;", "", "<init>", "()V", "Lkotlin/Pair;", "", "Lcom/upuphone/xr/sapp/monitor/weather/model/ArWeatherModel;", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "", "c", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "d", "a", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "locationCache", "", "b", "J", "lastLocationTime", "", "Z", "g", "()Z", "setRequesting", "(Z)V", "isRequesting", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuWeatherMonitor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuWeatherMonitor.kt\ncom/upuphone/xr/sapp/vu/monitor/VuWeatherMonitor\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,122:1\n314#2,11:123\n*S KotlinDebug\n*F\n+ 1 VuWeatherMonitor.kt\ncom/upuphone/xr/sapp/vu/monitor/VuWeatherMonitor\n*L\n105#1:123,11\n*E\n"})
public final class VuWeatherMonitor {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public NaviLocationInfo f8080a;
    public long b;
    public boolean c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/vu/monitor/VuWeatherMonitor$Companion;", "", "()V", "ERROR_GET_LOCATION", "", "ERROR_GET_WEATHER", "ERROR_NO_INTERNET", "ERROR_NO_PERMISSION", "LOCATION_DURATION", "", "SUCCESS", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public final void c() {
        ULog.f6446a.a("VuWeatherMonitor", "destroy");
    }

    public final Object d(Continuation continuation) {
        if (this.f8080a != null && SystemClock.elapsedRealtime() - this.b < 300000) {
            return this.f8080a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        VuWeatherMonitor$getLocation$2$listener$1 vuWeatherMonitor$getLocation$2$listener$1 = new VuWeatherMonitor$getLocation$2$listener$1(this, cancellableContinuationImpl);
        MainApplication f = MainApplication.k.f();
        NaviManager.getInstance(f).startLocation(f, vuWeatherMonitor$getLocation$2$listener$1);
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(kotlin.coroutines.Continuation r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor$getWeather$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor$getWeather$1 r0 = (com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor$getWeather$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.label = r1
        L_0x0012:
            r5 = r0
            goto L_0x001a
        L_0x0014:
            com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor$getWeather$1 r0 = new com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor$getWeather$1
            r0.<init>(r10, r11)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r11 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 3
            r3 = 2
            r4 = 1
            java.lang.String r8 = "VuWeatherMonitor"
            r9 = 0
            if (r1 == 0) goto L_0x0050
            if (r1 == r4) goto L_0x0048
            if (r1 == r3) goto L_0x0040
            if (r1 != r2) goto L_0x0038
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ Exception -> 0x0035 }
            goto L_0x011c
        L_0x0035:
            r10 = move-exception
            goto L_0x011f
        L_0x0038:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ Exception -> 0x0045 }
            goto L_0x00e4
        L_0x0045:
            r10 = move-exception
            goto L_0x00e7
        L_0x0048:
            java.lang.Object r10 = r5.L$0
            com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor r10 = (com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00a1
        L_0x0050:
            kotlin.ResultKt.throwOnFailure(r11)
            com.upuphone.xr.sapp.MainApplication$Companion r11 = com.upuphone.xr.sapp.MainApplication.k
            com.upuphone.xr.sapp.MainApplication r11 = r11.f()
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r6 = "requestLocation: start"
            r1.a(r8, r6)
            com.upuphone.xr.sapp.permission.PermissionHelper r6 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a
            java.lang.String r7 = "android.permission.ACCESS_COARSE_LOCATION"
            java.lang.String[] r7 = new java.lang.String[]{r7}
            boolean r11 = r6.n(r11, r7)
            if (r11 != 0) goto L_0x007e
            java.lang.String r10 = "requestLocation: no permission"
            r1.a(r8, r10)
            r10 = 100
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r9)
            return r10
        L_0x007e:
            com.upuphone.xr.sapp.utils.NetworkUtils r11 = com.upuphone.xr.sapp.utils.NetworkUtils.f7898a
            boolean r11 = r11.g()
            if (r11 != 0) goto L_0x0096
            java.lang.String r10 = "requestLocation: no network"
            r1.a(r8, r10)
            r10 = 101(0x65, float:1.42E-43)
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r9)
            return r10
        L_0x0096:
            r5.L$0 = r10
            r5.label = r4
            java.lang.Object r11 = r10.d(r5)
            if (r11 != r0) goto L_0x00a1
            return r0
        L_0x00a1:
            com.upuphone.xr.interconnect.entity.NaviLocationInfo r11 = (com.upuphone.xr.interconnect.entity.NaviLocationInfo) r11
            if (r11 != 0) goto L_0x00a7
            com.upuphone.xr.interconnect.entity.NaviLocationInfo r11 = r10.f8080a
        L_0x00a7:
            if (r11 != 0) goto L_0x00bb
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r11 = "requestLocation: no location"
            r10.a(r8, r11)
            r10 = 102(0x66, float:1.43E-43)
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r9)
            return r10
        L_0x00bb:
            com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager r10 = com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager.f7749a
            boolean r10 = r10.B()
            if (r10 == 0) goto L_0x00ff
            com.upuphone.xr.sapp.monitor.weather.WeatherRequest r1 = com.upuphone.xr.sapp.monitor.weather.WeatherRequest.f7809a     // Catch:{ Exception -> 0x0045 }
            double r6 = r11.getLatitude()     // Catch:{ Exception -> 0x0045 }
            java.lang.String r2 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x0045 }
            double r10 = r11.getLongitude()     // Catch:{ Exception -> 0x0045 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0045 }
            r5.L$0 = r9     // Catch:{ Exception -> 0x0045 }
            r5.label = r3     // Catch:{ Exception -> 0x0045 }
            r4 = 0
            r6 = 4
            r7 = 0
            r3 = r10
            java.lang.Object r11 = com.upuphone.xr.sapp.monitor.weather.WeatherRequest.b(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0045 }
            if (r11 != r0) goto L_0x00e4
            return r0
        L_0x00e4:
            com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel r11 = (com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel) r11     // Catch:{ Exception -> 0x0045 }
            goto L_0x0136
        L_0x00e7:
            com.upuphone.star.core.log.ULog$Delegate r11 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "queryOverseaWeather error: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r11.c(r8, r10)
        L_0x00fd:
            r11 = r9
            goto L_0x0136
        L_0x00ff:
            com.upuphone.xr.sapp.monitor.weather.WeatherRequest r10 = com.upuphone.xr.sapp.monitor.weather.WeatherRequest.f7809a     // Catch:{ Exception -> 0x0035 }
            double r3 = r11.getLatitude()     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0035 }
            double r3 = r11.getLongitude()     // Catch:{ Exception -> 0x0035 }
            java.lang.String r11 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0035 }
            r5.L$0 = r9     // Catch:{ Exception -> 0x0035 }
            r5.label = r2     // Catch:{ Exception -> 0x0035 }
            java.lang.Object r11 = r10.c(r1, r11, r5)     // Catch:{ Exception -> 0x0035 }
            if (r11 != r0) goto L_0x011c
            return r0
        L_0x011c:
            com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel r11 = (com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel) r11     // Catch:{ Exception -> 0x0035 }
            goto L_0x0136
        L_0x011f:
            com.upuphone.star.core.log.ULog$Delegate r11 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "queryWeather error: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r11.c(r8, r10)
            goto L_0x00fd
        L_0x0136:
            if (r11 != 0) goto L_0x0143
            r10 = 103(0x67, float:1.44E-43)
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r9)
            return r10
        L_0x0143:
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = "queryWeather success"
            r10.a(r8, r0)
            r10 = 0
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor$getWeatherWithRetry$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor$getWeatherWithRetry$1 r0 = (com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor$getWeatherWithRetry$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor$getWeatherWithRetry$1 r0 = new com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor$getWeatherWithRetry$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x004a
            if (r2 == r5) goto L_0x0040
            if (r2 != r4) goto L_0x0038
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$1
            kotlin.Pair r2 = (kotlin.Pair) r2
            java.lang.Object r6 = r0.L$0
            com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor r6 = (com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor) r6
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r6
            goto L_0x0054
        L_0x0038:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0040:
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$0
            com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor r2 = (com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0068
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r10)
            r9.c = r5
            r10 = 3
            r2 = r3
            r8 = r10
            r10 = r9
            r9 = r8
        L_0x0054:
            if (r9 <= 0) goto L_0x0091
            r0.L$0 = r10
            r0.L$1 = r3
            r0.I$0 = r9
            r0.label = r5
            java.lang.Object r2 = r10.e(r0)
            if (r2 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r8 = r2
            r2 = r10
            r10 = r8
        L_0x0068:
            kotlin.Pair r10 = (kotlin.Pair) r10
            java.lang.Object r6 = r10.getFirst()
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            if (r6 != 0) goto L_0x007a
            r8 = r2
            r2 = r10
            r10 = r8
            goto L_0x0091
        L_0x007a:
            int r9 = r9 + -1
            r0.L$0 = r2
            r0.L$1 = r10
            r0.I$0 = r9
            r0.label = r4
            r6 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.b(r6, r0)
            if (r6 != r1) goto L_0x008d
            return r1
        L_0x008d:
            r8 = r2
            r2 = r10
            r10 = r8
            goto L_0x0054
        L_0x0091:
            r9 = 0
            r10.c = r9
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor.f(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean g() {
        return this.c;
    }
}
