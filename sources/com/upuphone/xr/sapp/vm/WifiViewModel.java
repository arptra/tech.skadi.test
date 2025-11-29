package com.upuphone.xr.sapp.vm;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.SingleLiveData;
import com.xjmz.myvu.ext.ContextExtKt;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\f\u0010\bJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\b\u0018\u00010\u0012R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u00198\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u00198\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001e\u0010\u001c¨\u0006\""}, d2 = {"Lcom/upuphone/xr/sapp/vm/WifiViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "", "d", "()V", "", "e", "()Ljava/lang/String;", "onCleared", "f", "Landroid/net/wifi/WifiManager;", "b", "Landroid/net/wifi/WifiManager;", "wifiManager", "Lcom/upuphone/xr/sapp/vm/WifiViewModel$WifiReceiver;", "c", "Lcom/upuphone/xr/sapp/vm/WifiViewModel$WifiReceiver;", "mWifiReceiver", "", "Z", "mFirstInit", "Lcom/upuphone/xr/sapp/utils/SingleLiveData;", "Lcom/upuphone/xr/sapp/utils/SingleLiveData;", "h", "()Lcom/upuphone/xr/sapp/utils/SingleLiveData;", "mPhoneConnectWifiInfo", "g", "mAutoConnectInfo", "Companion", "WifiReceiver", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WifiViewModel extends AndroidViewModel {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public WifiManager b;
    public WifiReceiver c;
    public boolean d = true;
    public final SingleLiveData e = new SingleLiveData();
    public final SingleLiveData f = new SingleLiveData();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/vm/WifiViewModel$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/vm/WifiViewModel$WifiReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/upuphone/xr/sapp/vm/WifiViewModel;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class WifiReceiver extends BroadcastReceiver {
        public WifiReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent != null && (action = intent.getAction()) != null && action.hashCode() == -343630553 && action.equals("android.net.wifi.STATE_CHANGE")) {
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WifiViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        ULog.f6446a.a("WifiViewModel", "WifiViewModel do init");
        Object systemService = ContextCompat.getSystemService(((MainApplication) c()).getApplicationContext(), WifiManager.class);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        this.b = (WifiManager) systemService;
        this.c = new WifiReceiver();
        Context applicationContext = ((MainApplication) c()).getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        WifiReceiver wifiReceiver = this.c;
        Intrinsics.checkNotNull(wifiReceiver);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        Unit unit = Unit.INSTANCE;
        ContextExtKt.a(applicationContext, wifiReceiver, intentFilter);
    }

    public final void d() {
        String e2;
        boolean booleanValue = ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "wifi_auto_connect", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WifiViewModel", "autoConnect switch is " + booleanValue);
        if (booleanValue && (e2 = e()) != null) {
            this.f.postValue(StringsKt.replace$default(e2, "\"", "", false, 4, (Object) null));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0044, code lost:
        r12 = r12.getConnectionInfo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00da, code lost:
        if (r4 == null) goto L_0x00dc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String e() {
        /*
            r12 = this;
            java.lang.Boolean r0 = com.upuphone.xr.sapp.BuildConfig.b
            java.lang.String r1 = "THIRD_PLATFOM"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r0 = r0.booleanValue()
            r1 = 0
            java.lang.String r2 = "WifiViewModel"
            if (r0 == 0) goto L_0x0018
            com.upuphone.star.core.log.ULog$Delegate r12 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = "connect phone connected wifiInfo failed is third platform"
            r12.a(r2, r0)
            return r1
        L_0x0018:
            com.upuphone.xr.interconnect.InterconnectManager r0 = com.upuphone.xr.interconnect.InterconnectManager.getInstance()
            com.upuphone.xr.interconnect.api.StarryNetDeviceManager r0 = r0.getStarryNetDeviceManager()
            java.lang.String[] r0 = r0.getWifiInfo()
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "connect phone connected wifiInfo : "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r3.a(r2, r4)
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0053 }
            r5 = 31
            if (r4 < r5) goto L_0x0058
            android.net.wifi.WifiManager r12 = r12.b     // Catch:{ Exception -> 0x0053 }
            if (r12 == 0) goto L_0x0056
            android.net.wifi.WifiInfo r12 = r12.getConnectionInfo()     // Catch:{ Exception -> 0x0053 }
            if (r12 == 0) goto L_0x0056
            int r12 = r12.getCurrentSecurityType()     // Catch:{ Exception -> 0x0053 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x0053 }
            goto L_0x005d
        L_0x0053:
            r12 = move-exception
            goto L_0x00e8
        L_0x0056:
            r12 = r1
            goto L_0x005d
        L_0x0058:
            r12 = -1
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x0053 }
        L_0x005d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0053 }
            r4.<init>()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r5 = "WifiViewModel security type is: "
            r4.append(r5)     // Catch:{ Exception -> 0x0053 }
            r4.append(r12)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0053 }
            r3.a(r2, r4)     // Catch:{ Exception -> 0x0053 }
            r4 = 1
            if (r12 != 0) goto L_0x0075
            goto L_0x0081
        L_0x0075:
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x0053 }
            if (r12 != r4) goto L_0x0081
            java.lang.String r12 = "WifiViewModel security type invalid"
            r3.a(r2, r12)     // Catch:{ Exception -> 0x0053 }
            return r1
        L_0x0081:
            if (r0 == 0) goto L_0x0102
            r12 = 0
            r5 = r0[r12]     // Catch:{ Exception -> 0x0053 }
            if (r5 == 0) goto L_0x0102
            java.lang.String r6 = "<unknown ssid>"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)     // Catch:{ Exception -> 0x0053 }
            if (r5 != 0) goto L_0x0102
            r5 = r0[r12]     // Catch:{ Exception -> 0x0053 }
            r6 = r0[r4]     // Catch:{ Exception -> 0x0053 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0053 }
            r7.<init>()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r8 = "WifiViewModel wifiInfo is: "
            r7.append(r8)     // Catch:{ Exception -> 0x0053 }
            r7.append(r5)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r5 = ":"
            r7.append(r5)     // Catch:{ Exception -> 0x0053 }
            r7.append(r6)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x0053 }
            r3.a(r2, r5)     // Catch:{ Exception -> 0x0053 }
            com.upuphone.xr.sapp.vm.internal.SuperMessageManger$Companion r3 = com.upuphone.xr.sapp.vm.internal.SuperMessageManger.m     // Catch:{ Exception -> 0x0053 }
            com.upuphone.xr.sapp.vm.internal.SuperMessageManger r3 = r3.a()     // Catch:{ Exception -> 0x0053 }
            r5 = r0[r12]     // Catch:{ Exception -> 0x0053 }
            java.lang.String r6 = "get(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r6 = "\""
            java.lang.String r7 = ""
            r9 = 4
            r10 = 0
            r8 = 0
            java.lang.String r5 = kotlin.text.StringsKt.replace$default((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (boolean) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x0053 }
            r6 = r0[r4]     // Catch:{ Exception -> 0x0053 }
            if (r6 == 0) goto L_0x00dc
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r7 = "\""
            java.lang.String r8 = ""
            r10 = 4
            r11 = 0
            r9 = 0
            java.lang.String r4 = kotlin.text.StringsKt.replace$default((java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (boolean) r9, (int) r10, (java.lang.Object) r11)     // Catch:{ Exception -> 0x0053 }
            if (r4 != 0) goto L_0x00de
        L_0x00dc:
            java.lang.String r4 = ""
        L_0x00de:
            java.lang.String r6 = "req_change_wifi_state"
            java.lang.String r7 = "0"
            r3.g0(r5, r4, r6, r7)     // Catch:{ Exception -> 0x0053 }
            r12 = r0[r12]     // Catch:{ Exception -> 0x0053 }
            return r12
        L_0x00e8:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r12 = r12.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "autoConnect error: "
            r3.append(r4)
            r3.append(r12)
            java.lang.String r12 = r3.toString()
            r0.c(r2, r12)
        L_0x0102:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vm.WifiViewModel.e():java.lang.String");
    }

    public final String f() {
        WifiInfo connectionInfo;
        String str;
        List list = null;
        if (!BuildConfig.b.booleanValue()) {
            String[] wifiInfo = InterconnectManager.getInstance().getStarryNetDeviceManager().getWifiInfo();
            ULog.Delegate delegate = ULog.f6446a;
            if (wifiInfo != null) {
                list = ArraysKt.toList((T[]) wifiInfo);
            }
            delegate.a("WifiViewModel", "getConnectWifiInfo::mars connectionInfo is: " + list);
            if (wifiInfo == null || (str = wifiInfo[0]) == null) {
                return "<unknown ssid>";
            }
            Intrinsics.checkNotNull(str);
            String replace$default = StringsKt.replace$default(str, "\"", "", false, 4, (Object) null);
            return replace$default == null ? "<unknown ssid>" : replace$default;
        }
        WifiManager wifiManager = this.b;
        Integer valueOf = wifiManager != null ? Integer.valueOf(wifiManager.getWifiState()) : null;
        if (valueOf == null || valueOf.intValue() != 3) {
            return "<unknown ssid>";
        }
        ULog.Delegate delegate2 = ULog.f6446a;
        WifiManager wifiManager2 = this.b;
        WifiInfo connectionInfo2 = wifiManager2 != null ? wifiManager2.getConnectionInfo() : null;
        delegate2.a("WifiViewModel", "getConnectWifiInfo::third connectionInfo is: " + connectionInfo2);
        WifiManager wifiManager3 = this.b;
        if (!(wifiManager3 == null || (connectionInfo = wifiManager3.getConnectionInfo()) == null)) {
            list = connectionInfo.getSSID();
        }
        return list == null ? "<unknown ssid>" : list;
    }

    public final SingleLiveData g() {
        return this.f;
    }

    public final SingleLiveData h() {
        return this.e;
    }

    public void onCleared() {
        super.onCleared();
        WifiReceiver wifiReceiver = this.c;
        if (wifiReceiver != null) {
            try {
                ((MainApplication) c()).unregisterReceiver(wifiReceiver);
            } catch (Exception unused) {
            }
        }
    }
}
