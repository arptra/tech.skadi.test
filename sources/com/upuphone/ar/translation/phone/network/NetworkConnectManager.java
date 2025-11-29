package com.upuphone.ar.translation.phone.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.utils.NetworkUtils;
import com.upuphone.starrynet.common.StarryNetConstant;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001B\u0018\u0000 F2\u00020\u0001:\u0001GB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ:\u0010$\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\b0\u001fH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00100\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00102R\u0016\u00107\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00102R\u0016\u00109\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00102R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lcom/upuphone/ar/translation/phone/network/NetworkConnectManager;", "Lcom/upuphone/ar/translation/phone/network/IConnectManager;", "Landroid/content/Context;", "context", "Lcom/upuphone/ar/translation/phone/network/INetworkConnectListener;", "networkConnectListener", "<init>", "(Landroid/content/Context;Lcom/upuphone/ar/translation/phone/network/INetworkConnectListener;)V", "", "y", "()V", "z", "", "state", "x", "(I)V", "", "v", "()Z", "t", "Landroid/net/Network;", "network", "", "r", "(Landroid/net/Network;)Ljava/lang/String;", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "s", "(Landroid/net/NetworkCapabilities;)Ljava/lang/String;", "p", "()Ljava/lang/String;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isAccessible", "callback", "u", "(Landroid/net/NetworkCapabilities;Lkotlin/jvm/functions/Function1;)V", "w", "a", "Landroid/content/Context;", "b", "Lcom/upuphone/ar/translation/phone/network/INetworkConnectListener;", "Landroid/net/ConnectivityManager;", "c", "Lkotlin/Lazy;", "q", "()Landroid/net/ConnectivityManager;", "mConnectManager", "d", "Z", "mAlreadyCallbackAvailable", "e", "mAlreadyPoorNetwork", "f", "mAlreadyGoodNetwork", "g", "mIsStartTrans", "Lkotlinx/coroutines/CoroutineScope;", "h", "Lkotlinx/coroutines/CoroutineScope;", "mIoCoroutineScope", "Lkotlinx/coroutines/Job;", "i", "Lkotlinx/coroutines/Job;", "mPingJob", "com/upuphone/ar/translation/phone/network/NetworkConnectManager$networkCallback$1", "j", "Lcom/upuphone/ar/translation/phone/network/NetworkConnectManager$networkCallback$1;", "networkCallback", "k", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NetworkConnectManager implements IConnectManager {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f6317a;
    public INetworkConnectListener b;
    public final Lazy c = LazyKt.lazy(new NetworkConnectManager$mConnectManager$2(this));
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public CoroutineScope h = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    public Job i;
    public final NetworkConnectManager$networkCallback$1 j = new NetworkConnectManager$networkCallback$1(this);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/translation/phone/network/NetworkConnectManager$Companion;", "", "()V", "NET_MOBILE", "", "NET_UNKNOWN", "NET_WIFI", "POOR_NETWORK_THRESHOLD", "", "TAG", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public NetworkConnectManager(Context context, INetworkConnectListener iNetworkConnectListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6317a = context;
        this.b = iNetworkConnectListener;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String p() {
        /*
            r1 = this;
            android.net.ConnectivityManager r0 = r1.q()
            android.net.Network r0 = r0.getActiveNetwork()
            if (r0 == 0) goto L_0x0010
            java.lang.String r1 = r1.r(r0)
            if (r1 != 0) goto L_0x0013
        L_0x0010:
            java.lang.String r1 = "unknown"
        L_0x0013:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.network.NetworkConnectManager.p():java.lang.String");
    }

    public final ConnectivityManager q() {
        return (ConnectivityManager) this.c.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = s(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String r(android.net.Network r2) {
        /*
            r1 = this;
            android.net.ConnectivityManager r0 = r1.q()
            android.net.NetworkCapabilities r2 = r0.getNetworkCapabilities(r2)
            if (r2 == 0) goto L_0x0010
            java.lang.String r1 = r1.s(r2)
            if (r1 != 0) goto L_0x0013
        L_0x0010:
            java.lang.String r1 = "unknown"
        L_0x0013:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.network.NetworkConnectManager.r(android.net.Network):java.lang.String");
    }

    public final String s(NetworkCapabilities networkCapabilities) {
        return networkCapabilities.hasTransport(1) ? "wifi" : networkCapabilities.hasTransport(0) ? "mobile" : StarryNetConstant.DEVICE_NAME_UNKNOWN;
    }

    public final boolean t() {
        return this.f;
    }

    public final void u(NetworkCapabilities networkCapabilities, Function1 function1) {
        Job unused = BuildersKt__Builders_commonKt.d(this.h, (CoroutineContext) null, (CoroutineStart) null, new NetworkConnectManager$isNetworkConnected$1(networkCapabilities, function1, (Continuation<? super NetworkConnectManager$isNetworkConnected$1>) null), 3, (Object) null);
    }

    public final boolean v() {
        return this.e;
    }

    public final void w() {
        this.i = BuildersKt__Builders_commonKt.d(this.h, (CoroutineContext) null, (CoroutineStart) null, new NetworkConnectManager$notifyNetworkDelay$1(this, (Continuation<? super NetworkConnectManager$notifyNetworkDelay$1>) null), 3, (Object) null);
    }

    public void x(int i2) {
        if (i2 == 4 && !this.g) {
            this.g = true;
            w();
            LogExt.i("notifyTransState 启动ping监听");
        }
        if (i2 == 2 && this.g) {
            this.g = false;
            Job job = this.i;
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
            }
            LogExt.j("notifyTransState 结束ping监听", "NetworkConnectManager");
        }
    }

    public void y() {
        NetworkUtils.f6368a.e(this.f6317a, new NetworkConnectManager$startMonitor$1(this));
    }

    public void z() {
        q().unregisterNetworkCallback(this.j);
        this.b = null;
        this.d = false;
        Job job = this.i;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        CoroutineScopeKt.e(this.h, (CancellationException) null, 1, (Object) null);
        this.e = false;
        this.f = false;
        this.g = false;
    }
}
