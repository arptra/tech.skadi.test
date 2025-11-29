package com.upuphone.xr.sapp.contract;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.base.ULocation;
import com.upuphone.ar.navi.lite.location.LocationManager;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH@¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010#R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010'¨\u0006)"}, d2 = {"Lcom/upuphone/xr/sapp/contract/ReceiveLocationEventManager;", "", "<init>", "()V", "", "j", "Lcom/upuphone/ar/navi/lite/base/ULocation;", "event", "", "e", "(Lcom/upuphone/ar/navi/lite/base/ULocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "countryCode", "", "d", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "isSupport", "h", "(Landroid/content/Context;Z)V", "", "lat1", "lon1", "lat2", "lon2", "g", "(DDDD)Z", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "lastCountryCode", "c", "D", "lastLat", "lastLon", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ReceiveLocationEventManager {

    /* renamed from: a  reason: collision with root package name */
    public static final ReceiveLocationEventManager f6703a = new ReceiveLocationEventManager();
    public static String b = "";
    public static double c;
    public static double d;
    public static CoroutineScope e = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.upuphone.xr.sapp.contract.ReceiveLocationEventManager$checkNavSupport$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.upuphone.xr.sapp.contract.ReceiveLocationEventManager$checkNavSupport$1 r0 = (com.upuphone.xr.sapp.contract.ReceiveLocationEventManager$checkNavSupport$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.contract.ReceiveLocationEventManager$checkNavSupport$1 r0 = new com.upuphone.xr.sapp.contract.ReceiveLocationEventManager$checkNavSupport$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0045
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            com.upuphone.xr.sapp.contract.ReceiveLocationEventManager$checkNavSupport$2 r5 = new com.upuphone.xr.sapp.contract.ReceiveLocationEventManager$checkNavSupport$2
            r1 = 0
            r5.<init>(r6, r1)
            r0.label = r2
            r3 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r5 = kotlinx.coroutines.TimeoutKt.d(r3, r5, r0)
            if (r5 != r7) goto L_0x0045
            return r7
        L_0x0045:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            if (r5 == 0) goto L_0x004d
            boolean r2 = r5.booleanValue()
        L_0x004d:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.contract.ReceiveLocationEventManager.d(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object e(ULocation uLocation, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new ReceiveLocationEventManager$getCountryCode$2(new ULatLng(uLocation.getLatitude(), uLocation.getLongitude()), (Continuation<? super ReceiveLocationEventManager$getCountryCode$2>) null), continuation);
    }

    public final String f() {
        return b;
    }

    public final boolean g(double d2, double d3, double d4, double d5) {
        float[] fArr = new float[1];
        Location.distanceBetween(d2, d3, d4, d5, fArr);
        return fArr[0] <= 500.0f;
    }

    public final void h(Context context, boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ReceiveLocationEventManager", "setIsSupport " + z);
        SharedPreferences.Editor edit = context.getSharedPreferences("navi_support_preferences", 0).edit();
        edit.putBoolean("isSupport", z);
        edit.apply();
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        b = str;
    }

    public final void j() {
        ULocation g = LocationManager.f().g();
        if (g != null) {
            ULog.Delegate delegate = ULog.f6446a;
            double latitude = g.getLatitude();
            double longitude = g.getLongitude();
            delegate.a("ReceiveLocationEventManager", "latitude=" + latitude + "longitude=" + longitude);
            if (!(c == 0.0d || d == 0.0d)) {
                if (g(g.getLatitude(), g.getLongitude(), c, d)) {
                    delegate.a("ReceiveLocationEventManager", "距离上次位置变化小于500米");
                    return;
                }
            }
            c = g.getLatitude();
            d = g.getLongitude();
            Job unused = BuildersKt__Builders_commonKt.d(e, (CoroutineContext) null, (CoroutineStart) null, new ReceiveLocationEventManager$startNaviCheckSupportWork$1(g, (Continuation<? super ReceiveLocationEventManager$startNaviCheckSupportWork$1>) null), 3, (Object) null);
        }
    }
}
