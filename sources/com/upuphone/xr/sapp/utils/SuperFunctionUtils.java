package com.upuphone.xr.sapp.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.sapp.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/utils/SuperFunctionUtils;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "e", "(Landroid/content/Context;)V", "f", "g", "c", "", "b", "(Landroid/content/Context;)Z", "d", "()Z", "Landroid/net/wifi/WifiManager;", "a", "Landroid/net/wifi/WifiManager;", "mWifiManager", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SuperFunctionUtils {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static final Lazy c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SuperFunctionUtils$Companion$instance$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public WifiManager f7923a;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/utils/SuperFunctionUtils$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/utils/SuperFunctionUtils;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/upuphone/xr/sapp/utils/SuperFunctionUtils;", "instance", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SuperFunctionUtils a() {
            return (SuperFunctionUtils) SuperFunctionUtils.c.getValue();
        }

        public Companion() {
        }
    }

    public final boolean b(Context context) {
        if (PermissionAndStateCheckUtils.f7907a.f(context)) {
            return true;
        }
        UToast.f6444a.d(context, GlobalExtKt.h(R.string.location_not_enable_toast));
        return false;
    }

    public final void c() {
        NaviManager.getInstance(GlobalExtKt.f()).stopNavi();
    }

    public final boolean d() {
        try {
            if (this.f7923a == null) {
                Object systemService = GlobalExtKt.f().getSystemService("wifi");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
                this.f7923a = (WifiManager) systemService;
            }
            WifiManager wifiManager = this.f7923a;
            if (wifiManager != null) {
                return wifiManager.isWifiEnabled();
            }
            return false;
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.a("SuperFunctionUtils", "funCheckWifiState error: " + message);
            return false;
        }
    }

    public final void e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean b2 = b(context);
        Boolean valueOf = Boolean.valueOf(b2);
        Unit unit = null;
        if (!b2) {
            valueOf = null;
        }
        if (valueOf == null) {
            return;
        }
        if (!d()) {
            UToast.f6444a.d(context, GlobalExtKt.h(R.string.wifi_not_enable_toast));
            return;
        }
        StarryDevice connectedDevice = InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice();
        if (connectedDevice == null) {
            connectedDevice = null;
        }
        if (connectedDevice != null) {
            UToast.f6444a.d(context, "web抖音功能已经去除");
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            UToast.f6444a.d(context, GlobalExtKt.h(R.string.glass_not_connect_toast));
        }
    }

    public final void f() {
        NaviManager.getInstance(GlobalExtKt.f()).startSearch(GlobalExtKt.f());
    }

    public final void g() {
        NaviManager.getInstance(GlobalExtKt.f()).startNaviFromAI(GlobalExtKt.f());
    }
}
