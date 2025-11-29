package com.meizu.flyme.policy.sdk.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/meizu/flyme/policy/sdk/util/HookMacAddressUtils;", "", "()V", "cacheWifiInfo", "Landroid/net/wifi/WifiInfo;", "isHookMacAddress", "", "closeHookMacAddress", "", "getMacAddress", "", "context", "Landroid/content/Context;", "hookMacAddress", "MacAddressInvocationHandler", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HookMacAddressUtils {
    @NotNull
    public static final HookMacAddressUtils INSTANCE = new HookMacAddressUtils();
    /* access modifiers changed from: private */
    @Nullable
    public static WifiInfo cacheWifiInfo;
    /* access modifiers changed from: private */
    public static boolean isHookMacAddress = true;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J.\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0002¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/meizu/flyme/policy/sdk/util/HookMacAddressUtils$MacAddressInvocationHandler;", "Ljava/lang/reflect/InvocationHandler;", "methodName", "", "real", "", "(Ljava/lang/String;Ljava/lang/Object;)V", "invoke", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MacAddressInvocationHandler implements InvocationHandler {
        @NotNull
        private final String methodName;
        @Nullable
        private final Object real;

        public MacAddressInvocationHandler(@NotNull String str, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(str, "methodName");
            this.methodName = str;
            this.real = obj;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object invoke(@org.jetbrains.annotations.NotNull java.lang.Object r2, @org.jetbrains.annotations.NotNull java.lang.reflect.Method r3, @org.jetbrains.annotations.NotNull java.lang.Object[] r4) {
            /*
                r1 = this;
                java.lang.String r0 = "proxy"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r2 = "method"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
                java.lang.String r2 = "args"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
                boolean r2 = com.meizu.flyme.policy.sdk.util.HookMacAddressUtils.isHookMacAddress
                if (r2 == 0) goto L_0x005b
                java.lang.String r2 = r1.methodName
                java.lang.String r0 = r3.getName()
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r0)
                if (r2 == 0) goto L_0x005b
                android.net.wifi.WifiInfo r1 = com.meizu.flyme.policy.sdk.util.HookMacAddressUtils.cacheWifiInfo
                if (r1 != 0) goto L_0x005a
                r1 = 0
                java.lang.Class<android.net.wifi.WifiInfo> r2 = android.net.wifi.WifiInfo.class
                java.lang.Object r3 = r2.newInstance()     // Catch:{ Exception -> 0x0047 }
                if (r3 == 0) goto L_0x004a
                android.net.wifi.WifiInfo r3 = (android.net.wifi.WifiInfo) r3     // Catch:{ Exception -> 0x0047 }
                java.lang.String r4 = "mMacAddress"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r4)     // Catch:{ Exception -> 0x0045 }
                r4 = 1
                r2.setAccessible(r4)     // Catch:{ Exception -> 0x0045 }
                java.lang.String r4 = ""
                r2.set(r3, r4)     // Catch:{ Exception -> 0x0045 }
                com.meizu.flyme.policy.sdk.util.HookMacAddressUtils.cacheWifiInfo = r3     // Catch:{ Exception -> 0x0045 }
                goto L_0x0055
            L_0x0045:
                r2 = move-exception
                goto L_0x0052
            L_0x0047:
                r2 = move-exception
                r3 = r1
                goto L_0x0052
            L_0x004a:
                java.lang.NullPointerException r2 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0047 }
                java.lang.String r3 = "null cannot be cast to non-null type android.net.wifi.WifiInfo"
                r2.<init>(r3)     // Catch:{ Exception -> 0x0047 }
                throw r2     // Catch:{ Exception -> 0x0047 }
            L_0x0052:
                r2.printStackTrace()
            L_0x0055:
                if (r3 != 0) goto L_0x0058
                goto L_0x0066
            L_0x0058:
                r1 = r3
                goto L_0x0066
            L_0x005a:
                return r1
            L_0x005b:
                java.lang.Object r1 = r1.real
                int r2 = r4.length
                java.lang.Object[] r2 = java.util.Arrays.copyOf(r4, r2)
                java.lang.Object r1 = r3.invoke(r1, r2)
            L_0x0066:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.flyme.policy.sdk.util.HookMacAddressUtils.MacAddressInvocationHandler.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
        }
    }

    private HookMacAddressUtils() {
    }

    public final void closeHookMacAddress() {
        isHookMacAddress = false;
    }

    @Nullable
    public final String getMacAddress(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("wifi");
        if (systemService != null) {
            WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
            Intrinsics.checkNotNullExpressionValue(connectionInfo, "wifiManager.getConnectionInfo()");
            return connectionInfo.getMacAddress();
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.wifi.WifiManager");
    }

    @SuppressLint({"PrivateApi", "WifiManagerPotentialLeak"})
    public final void hookMacAddress(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            isHookMacAddress = true;
            Class<?> cls = Class.forName("android.net.wifi.IWifiManager");
            Field declaredField = WifiManager.class.getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object systemService = context.getSystemService("wifi");
            if (systemService != null) {
                WifiManager wifiManager = (WifiManager) systemService;
                declaredField.set(wifiManager, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new MacAddressInvocationHandler("getConnectionInfo", declaredField.get(wifiManager))));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.wifi.WifiManager");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
