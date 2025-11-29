package com.upuphone.xr.sapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.wifi.WifiManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.context.SdkContext;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.joor.Reflect;

@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u001f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\u0006J\u0010\u0010\t\u001a\u00020\u0004H@¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0013J(\u0010\u0017\u001a\u00020\u000f2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\u0002\b\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u0003R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010$R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0011\u0010+\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b&\u0010*R\u0017\u0010/\u001a\u00020\u0004*\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u00101\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b0\u0010\u0006R\u0011\u00103\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b2\u0010\u0006¨\u00064"}, d2 = {"Lcom/upuphone/xr/sapp/utils/NetworkUtils;", "", "<init>", "()V", "", "i", "()Z", "f", "g", "h", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroid/net/ConnectivityManager$NetworkCallback;", "callback", "", "o", "(Landroidx/lifecycle/LifecycleOwner;Landroid/net/ConnectivityManager$NetworkCallback;)V", "n", "(Landroid/net/ConnectivityManager$NetworkCallback;)V", "q", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "d", "(Lkotlin/jvm/functions/Function1;)V", "m", "p", "Ljava/util/concurrent/CopyOnWriteArraySet;", "b", "Ljava/util/concurrent/CopyOnWriteArraySet;", "networkCallbacks", "com/upuphone/xr/sapp/utils/NetworkUtils$innerNetworkCallback$1", "c", "Lcom/upuphone/xr/sapp/utils/NetworkUtils$innerNetworkCallback$1;", "innerNetworkCallback", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "networkCallbackRegistered", "e", "Z", "isCompatHotspotEnabled", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "Landroid/net/NetworkCapabilities;", "j", "(Landroid/net/NetworkCapabilities;)Z", "isAvailable", "l", "isWifiEnabled", "k", "isHotspotEnabled", "lib_common_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nNetworkUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkUtils.kt\ncom/upuphone/xr/sapp/utils/NetworkUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,323:1\n1855#2,2:324\n*S KotlinDebug\n*F\n+ 1 NetworkUtils.kt\ncom/upuphone/xr/sapp/utils/NetworkUtils\n*L\n75#1:324,2\n*E\n"})
public final class NetworkUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final NetworkUtils f7898a = new NetworkUtils();
    public static final CopyOnWriteArraySet b = new CopyOnWriteArraySet();
    public static final NetworkUtils$innerNetworkCallback$1 c = new NetworkUtils$innerNetworkCallback$1();
    public static final AtomicBoolean d = new AtomicBoolean(false);
    public static volatile boolean e;

    public final void d(Function1 function1) {
        for (ConnectivityManager.NetworkCallback networkCallback : b) {
            try {
                Intrinsics.checkNotNull(networkCallback);
                function1.invoke(networkCallback);
            } catch (Exception e2) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.c("NetworkUtils", "dispatchNetworkCallback error: " + e2);
            }
        }
    }

    public final Context e() {
        return SdkContext.f6675a.c().getContext();
    }

    public final boolean f() {
        ConnectivityManager connectivityManager = (ConnectivityManager) e().getSystemService(ConnectivityManager.class);
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.hasTransport(0);
    }

    public final boolean g() {
        ConnectivityManager connectivityManager = (ConnectivityManager) e().getSystemService(ConnectivityManager.class);
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities == null) {
            return false;
        }
        Intrinsics.checkNotNull(networkCapabilities);
        return networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1);
    }

    public final Object h(Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new NetworkUtils$hasNetworkSuspend$2((Continuation<? super NetworkUtils$hasNetworkSuspend$2>) null), continuation);
    }

    public final boolean i() {
        ConnectivityManager connectivityManager = (ConnectivityManager) e().getSystemService(ConnectivityManager.class);
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.hasTransport(1);
    }

    public final boolean j(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities != null) {
            return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0);
        }
        return false;
    }

    public final boolean k() {
        Object systemService = e().getSystemService("wifi");
        WifiManager wifiManager = systemService instanceof WifiManager ? (WifiManager) systemService : null;
        if (wifiManager == null) {
            return false;
        }
        try {
            Object k = Reflect.p(wifiManager).f("getWifiApState").k();
            Intrinsics.checkNotNullExpressionValue(k, "get(...)");
            int intValue = ((Number) k).intValue();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("NetworkUtils", "isHotspotEnabled, getWifiApState: " + intValue);
            if (intValue == 12 || intValue == 13) {
                return true;
            }
            boolean z = e;
            delegate.a("NetworkUtils", "isHotspotEnabled, isCompatHotspotEnabled: " + z);
            return e;
        } catch (Throwable th) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("NetworkUtils", "isHotspotEnabled, getWifiApState-error: " + th);
        }
    }

    public final boolean l() {
        Object systemService = e().getSystemService("wifi");
        WifiManager wifiManager = systemService instanceof WifiManager ? (WifiManager) systemService : null;
        if (wifiManager != null) {
            return wifiManager.isWifiEnabled();
        }
        return false;
    }

    public final void m() {
        ULog.Delegate delegate = ULog.f6446a;
        CopyOnWriteArraySet copyOnWriteArraySet = b;
        int size = copyOnWriteArraySet.size();
        delegate.a("NetworkUtils", "registerInnerNetworkCallback, networkCallbacks: " + size);
        if (!copyOnWriteArraySet.isEmpty() && d.compareAndSet(false, true)) {
            delegate.a("NetworkUtils", "registerInnerNetworkCallback, real");
            n(c);
        }
    }

    public final void n(ConnectivityManager.NetworkCallback networkCallback) {
        Intrinsics.checkNotNullParameter(networkCallback, "callback");
        ((ConnectivityManager) e().getSystemService(ConnectivityManager.class)).registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).addTransportType(0).build(), networkCallback);
    }

    public final void o(LifecycleOwner lifecycleOwner, ConnectivityManager.NetworkCallback networkCallback) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(networkCallback, "callback");
        b.add(networkCallback);
        if (!(lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
            lifecycle.a(new NetworkUtils$registerNetworkCallback$1(networkCallback));
        }
        m();
    }

    public final void p() {
        ULog.Delegate delegate = ULog.f6446a;
        CopyOnWriteArraySet copyOnWriteArraySet = b;
        int size = copyOnWriteArraySet.size();
        delegate.a("NetworkUtils", "unregisterInnerNetworkCallback, networkCallbacks: " + size);
        if (copyOnWriteArraySet.isEmpty() && d.compareAndSet(true, false)) {
            delegate.a("NetworkUtils", "unregisterInnerNetworkCallback, real");
            q(c);
        }
    }

    public final void q(ConnectivityManager.NetworkCallback networkCallback) {
        Intrinsics.checkNotNullParameter(networkCallback, "callback");
        ((ConnectivityManager) e().getSystemService(ConnectivityManager.class)).unregisterNetworkCallback(networkCallback);
    }
}
