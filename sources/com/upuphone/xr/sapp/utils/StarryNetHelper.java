package com.upuphone.xr.sapp.utils;

import android.os.Build;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0003J\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0003J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001eR\u0017\u0010$\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010'R\u0014\u0010+\u001a\u00020)8\u0002XD¢\u0006\u0006\n\u0004\b\u000f\u0010*¨\u0006-"}, d2 = {"Lcom/upuphone/xr/sapp/utils/StarryNetHelper;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/utils/StarryNetHelper$StartDiscoveryCondition;", "e", "()Lcom/upuphone/xr/sapp/utils/StarryNetHelper$StartDiscoveryCondition;", "Lkotlin/Function0;", "", "callback", "c", "(Lkotlin/jvm/functions/Function0;)V", "state", "i", "(Lcom/upuphone/xr/sapp/utils/StarryNetHelper$StartDiscoveryCondition;)V", "g", "j", "k", "f", "", "devId", "d", "(Ljava/lang/String;)Ljava/lang/String;", "", "h", "(Z)V", "b", "Z", "isFinishStarryNetInit", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "startDiscoveryState", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "finishReg", "", "J", "startDiscoveryTime", "", "I", "maxIntervalTime", "StartDiscoveryCondition", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class StarryNetHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final StarryNetHelper f7917a = new StarryNetHelper();
    public static boolean b;
    public static MutableStateFlow c = StateFlowKt.a(new StartDiscoveryCondition(false, false, 3, (DefaultConstructorMarker) null));
    public static final CoroutineScope d = CoroutineScopeKt.a(Dispatchers.b());
    public static boolean e;
    public static long f;
    public static final int g = 15000;

    public final void c(Function0 function0) {
        long currentTimeMillis = System.currentTimeMillis() - f;
        ULog.Delegate delegate = ULog.f6446a;
        long j = f;
        int i = g;
        boolean z = false;
        delegate.c("StarryNetHelper", "startDiscoveryTime = " + j + ",isForeground ,intervalTime = " + currentTimeMillis + ",intervalTime > maxIntervalTime = " + (currentTimeMillis > ((long) i)));
        if (currentTimeMillis > ((long) i)) {
            f = System.currentTimeMillis();
            StarryDevice connectedDevice = InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice();
            boolean z2 = connectedDevice == null;
            XrSdkBondDeviceUtil xrSdkBondDeviceUtil = XrSdkBondDeviceUtil.INSTANCE;
            MainApplication.Companion companion = MainApplication.k;
            if (xrSdkBondDeviceUtil.getBondedDevice(companion.d()) != null) {
                z = true;
            }
            delegate.c("StarryNetHelper", "startDiscoveryTime connectDevice is null = " + z2 + ", bound device = " + z);
            if (connectedDevice == null && xrSdkBondDeviceUtil.getBondedDevice(companion.d()) != null) {
                delegate.c("StarryNetHelper", "startDiscoveryTime notifyForegroundState startDiscoveryWhenFinishMeet");
                j();
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }
    }

    public final String d(String str) {
        Intrinsics.checkNotNullParameter(str, "devId");
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getDeviceInfo(str, 0);
    }

    public final StartDiscoveryCondition e() {
        return (StartDiscoveryCondition) c.getValue();
    }

    public final void f() {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = b;
        delegate.c("StarryNetHelper", "initInterconnectManager start isFinishStarryNetInit = " + z);
        if (!b) {
            Boolean bool = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
            if (bool.booleanValue()) {
                int i = Build.VERSION.SDK_INT;
                delegate.c("StarryNetHelper", "initThirdStarryNet Build.VERSION.SDK_INT = " + i);
                if (i < 31 || GlobalExtKt.f().checkSelfPermission("android.permission.BLUETOOTH_CONNECT") != 0) {
                    delegate.a("StarryNetHelper", "initThirdStarrySDK android 9==================");
                    InterconnectManager.getInstance().init(MainApplication.k.f(), 0);
                    return;
                }
                delegate.a("StarryNetHelper", "initThirdStarrySDK==================");
                InterconnectManager.getInstance().init(MainApplication.k.f(), 0);
                return;
            }
            delegate.c("StarryNetHelper", "initThirdStarryNet for Mars");
            InterconnectManager.getInstance().init(MainApplication.k.f(), 0);
        }
    }

    public final void g() {
        if (e) {
            ULog.f6446a.c("StarryNetHelper", "registerStartDiscovery has finish");
            return;
        }
        e = true;
        Job unused = BuildersKt__Builders_commonKt.d(d, (CoroutineContext) null, (CoroutineStart) null, new StarryNetHelper$registerStartDiscovery$1((Continuation<? super StarryNetHelper$registerStartDiscovery$1>) null), 3, (Object) null);
    }

    public final void h(boolean z) {
        b = z;
    }

    public final void i(StartDiscoveryCondition startDiscoveryCondition) {
        Intrinsics.checkNotNullParameter(startDiscoveryCondition, "state");
        Job unused = BuildersKt__Builders_commonKt.d(d, (CoroutineContext) null, (CoroutineStart) null, new StarryNetHelper$setStartDiscoveryState$1(startDiscoveryCondition, (Continuation<? super StarryNetHelper$setStartDiscoveryState$1>) null), 3, (Object) null);
    }

    public final void j() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("StarryNetHelper", "startDiscoveryWhenFinishMeet start");
        g();
        StartDiscoveryCondition e2 = e();
        delegate.c("StarryNetHelper", "startDiscoveryWhenFinishMeet state = " + e2);
        if (e2.a() && e2.b()) {
            try {
                StarryNetHelper starryNetHelper = f7917a;
                starryNetHelper.h(true);
                starryNetHelper.k();
            } catch (Exception e3) {
                ULog.Delegate delegate2 = ULog.f6446a;
                String message = e3.getMessage();
                delegate2.c("SAS@MainApplication", "startDiscoveryWhenFinishMeet error: " + message);
            }
        }
    }

    public final void k() {
        ULog.f6446a.c("StarryNetHelper", "startStarryNetDiscovery start");
        InterconnectManager.getInstance().getStarryNetDeviceManager().stopDiscovery();
        InterconnectManager.getInstance().getStarryNetDeviceManager().startDiscovery();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/sapp/utils/StarryNetHelper$StartDiscoveryCondition;", "", "", "stateNetState", "isHaveLogin", "<init>", "(ZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "()Z", "d", "(Z)V", "b", "c", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class StartDiscoveryCondition {

        /* renamed from: a  reason: collision with root package name */
        public boolean f7918a;
        public boolean b;

        public StartDiscoveryCondition(boolean z, boolean z2) {
            this.f7918a = z;
            this.b = z2;
        }

        public final boolean a() {
            return this.f7918a;
        }

        public final boolean b() {
            return this.b;
        }

        public final void c(boolean z) {
            this.b = z;
        }

        public final void d(boolean z) {
            this.f7918a = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StartDiscoveryCondition)) {
                return false;
            }
            StartDiscoveryCondition startDiscoveryCondition = (StartDiscoveryCondition) obj;
            return this.f7918a == startDiscoveryCondition.f7918a && this.b == startDiscoveryCondition.b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f7918a) * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            boolean z = this.f7918a;
            boolean z2 = this.b;
            return "StartDiscoveryCondition(stateNetState=" + z + ", isHaveLogin=" + z2 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ StartDiscoveryCondition(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
        }
    }
}
