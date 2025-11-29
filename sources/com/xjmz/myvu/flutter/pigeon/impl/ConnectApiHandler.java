package com.xjmz.myvu.flutter.pigeon.impl;

import androidx.fragment.app.FragmentActivity;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.entity.ConnectState;
import com.upuphone.xr.sapp.entity.NetDevice;
import com.upuphone.xr.sapp.utils.DeviceHelper;
import com.upuphone.xr.sapp.utils.StarryNetHelper;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.xjmz.myvu.common.ConnectVoidResult;
import com.xjmz.myvu.ext.ConnectExtKt;
import com.xjmz.myvu.ext.DeviceInfoExtKt;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import com.xjmz.myvu.modules.home.SearchGlassHandler;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u00010B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u00020\r2\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00160\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001a\u0010\u000fJ%\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0010H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010\u000fJ\u0011\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010,R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010/¨\u00061"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/ConnectApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$ConnectApi;", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "deviceControlModel", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$FlutterConnectApi;", "flutterConnectApi", "Lcom/xjmz/myvu/modules/home/SearchGlassHandler;", "searchGlassTimeoutHandler", "Lkotlin/Function0;", "Landroidx/fragment/app/FragmentActivity;", "activityProvider", "<init>", "(Lcom/upuphone/xr/sapp/vm/DeviceControlModel;Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$FlutterConnectApi;Lcom/xjmz/myvu/modules/home/SearchGlassHandler;Lkotlin/jvm/functions/Function0;)V", "", "r", "()V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$Result;", "", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$DeviceInfo;", "result", "p", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$Result;)V", "", "modelId", "t", "(Ljava/lang/String;Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$Result;)V", "d", "deviceInfo", "", "e", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$DeviceInfo;Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$Result;)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$VoidResult;", "b", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$DeviceInfo;Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$VoidResult;)V", "u", "Lcom/upuphone/xr/sapp/entity/NetDevice;", "v", "()Lcom/upuphone/xr/sapp/entity/NetDevice;", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "starryNetDevice", "w", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)V", "a", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$FlutterConnectApi;", "c", "Lcom/xjmz/myvu/modules/home/SearchGlassHandler;", "Lkotlin/jvm/functions/Function0;", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nConnectApiHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectApiHandler.kt\ncom/xjmz/myvu/flutter/pigeon/impl/ConnectApiHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n1855#2,2:195\n288#2,2:197\n*S KotlinDebug\n*F\n+ 1 ConnectApiHandler.kt\ncom/xjmz/myvu/flutter/pigeon/impl/ConnectApiHandler\n*L\n55#1:195,2\n145#1:197,2\n*E\n"})
public final class ConnectApiHandler implements AndroidConnectApi.ConnectApi {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final DeviceControlModel f8347a;
    public final AndroidConnectApi.FlutterConnectApi b;
    public final SearchGlassHandler c;
    public final Function0 d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/ConnectApiHandler$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public ConnectApiHandler(DeviceControlModel deviceControlModel, AndroidConnectApi.FlutterConnectApi flutterConnectApi, SearchGlassHandler searchGlassHandler, Function0 function0) {
        Intrinsics.checkNotNullParameter(deviceControlModel, "deviceControlModel");
        Intrinsics.checkNotNullParameter(flutterConnectApi, "flutterConnectApi");
        Intrinsics.checkNotNullParameter(searchGlassHandler, "searchGlassTimeoutHandler");
        Intrinsics.checkNotNullParameter(function0, "activityProvider");
        this.f8347a = deviceControlModel;
        this.b = flutterConnectApi;
        this.c = searchGlassHandler;
        this.d = function0;
    }

    public void b(AndroidConnectApi.DeviceInfo deviceInfo, AndroidConnectApi.VoidResult voidResult) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(voidResult, "result");
        ULog.Delegate delegate = ULog.f6446a;
        String c2 = deviceInfo.c();
        String d2 = deviceInfo.d();
        delegate.a("ConnectApiHandler", "onDeviceSelect deviceInfo:" + c2 + " " + d2);
        AndroidConnectApi.DeviceInfo deviceInfo2 = (AndroidConnectApi.DeviceInfo) this.f8347a.P().getValue();
        if (Intrinsics.areEqual((Object) deviceInfo2 != null ? deviceInfo2.b() : null, (Object) deviceInfo.b())) {
            delegate.a("ConnectApiHandler", "onDeviceSelect deviceInfo return");
        } else {
            this.f8347a.Q().postValue(deviceInfo);
        }
    }

    public void d() {
        List<StarryDevice> connectedDevices;
        T t;
        VuGlassControlModel.ViewGlassesInfo viewGlassesInfo;
        NetDevice v;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ConnectApiHandler", "refreshConnectState");
        delegate.c("ConnectApiHandler", "getHistoryDevices start refreshConnectState");
        StarryNetDevice a2 = ConnectExtKt.a();
        if (!(a2 == null || (v = v()) == null)) {
            this.b.i(ConnectExtKt.l(a2, v.getState() == ConnectState.CONNECTED ? AndroidConnectApi.StateEnum.CONNECT_SUCC : AndroidConnectApi.StateEnum.CONNECT_FAILED), new ConnectVoidResult());
        }
        if (!(ConnectExtKt.d() == null || (viewGlassesInfo = (VuGlassControlModel.ViewGlassesInfo) VuGlassControlModel.f8109a.v().getValue()) == null)) {
            AndroidConnectApi.ConnectState.Builder e2 = new AndroidConnectApi.ConnectState.Builder().c(viewGlassesInfo.b()).b("view").d("view").e(viewGlassesInfo.f() ? AndroidConnectApi.StateEnum.CONNECT_SUCC : AndroidConnectApi.StateEnum.CONNECT_FAILED);
            Intrinsics.checkNotNullExpressionValue(e2, "setState(...)");
            this.b.i(e2.a(), new ConnectVoidResult());
        }
        if (ConnectExtKt.c() != null && (connectedDevices = DevicesConnector.getInstance().getConnectedDevices()) != null) {
            Iterator<T> it = connectedDevices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                StarryDevice starryDevice = (StarryDevice) t;
                if (starryDevice != null && starryDevice.getTerminalType() == 5) {
                    break;
                }
            }
            StarryDevice starryDevice2 = (StarryDevice) t;
            if (starryDevice2 != null) {
                AndroidConnectApi.ConnectState.Builder e3 = new AndroidConnectApi.ConnectState.Builder().c(starryDevice2.getName()).b(starryDevice2.getId()).d("ring2").e(AndroidConnectApi.StateEnum.CONNECT_SUCC);
                Intrinsics.checkNotNullExpressionValue(e3, "setState(...)");
                this.b.i(e3.a(), new ConnectVoidResult());
            }
        }
    }

    public void e(AndroidConnectApi.DeviceInfo deviceInfo, AndroidConnectApi.Result result) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(result, "result");
        ULog.Delegate delegate = ULog.f6446a;
        String a2 = DeviceInfoExtKt.a(deviceInfo);
        delegate.a("ConnectApiHandler", "unbindDevice, deviceInfo: " + a2);
        String d2 = deviceInfo.d();
        Intrinsics.checkNotNullExpressionValue(d2, "getModelId(...)");
        if (ConnectExtKt.e(d2)) {
            String b2 = deviceInfo.b();
            Intrinsics.checkNotNullExpressionValue(b2, "getDeviceId(...)");
            DeviceHelper.f7878a.a((FragmentActivity) this.d.invoke(), b2, new ConnectApiHandler$unbindDevice$1(result));
            return;
        }
        String b3 = deviceInfo.b();
        Intrinsics.checkNotNullExpressionValue(b3, "getDeviceId(...)");
        if (!ConnectExtKt.k(b3)) {
            delegate.c("ConnectApiHandler", "unbindDevice, unsupported");
        } else if (!VuGlassControlModel.f8109a.z()) {
            DeviceHelper.f7878a.b((FragmentActivity) this.d.invoke(), new ConnectApiHandler$unbindDevice$2(result));
        } else {
            UToast.Companion companion = UToast.f6444a;
            MainApplication.Companion companion2 = MainApplication.k;
            MainApplication f = companion2.f();
            String string = companion2.f().getString(R.string.unplugin_view_tip);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(f, string);
            result.success(Boolean.FALSE);
        }
    }

    public void p(AndroidConnectApi.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ULog.f6446a.c("ConnectApiHandler", "getHistoryDevices start");
        List<AndroidConnectApi.DeviceInfo> mutableList = CollectionsKt.toMutableList(ConnectExtKt.b());
        for (AndroidConnectApi.DeviceInfo deviceInfo : mutableList) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("ConnectApiHandler", "getHistoryDevices-> " + deviceInfo);
        }
        result.success(mutableList);
    }

    public void r() {
        ULog.f6446a.g("ConnectApiHandler", "reconnectDevice() called");
        u();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004f, code lost:
        r5.success(r2);
        r3.g("ConnectApiHandler", "getGlassSn() result model id error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0058, code lost:
        r4 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a.g().getSerialNo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0062, code lost:
        if (r4 != null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0065, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0066, code lost:
        r5.success(r2);
        r3.g("ConnectApiHandler", "getGlassSn() result = " + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0032, code lost:
        if (r4.equals(com.upuphone.xr.interconnect.Constants.GLASS_DEVICE_ARI) != false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003b, code lost:
        if (r4.equals("air_intl") == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0044, code lost:
        if (r4.equals("air_pro") == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004d, code lost:
        if (r4.equals("air_pro_intl") == false) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void t(java.lang.String r4, com.xjmz.myvu.flutter.pigeon.AndroidConnectApi.Result r5) {
        /*
            r3 = this;
            java.lang.String r3 = "modelId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            java.lang.String r3 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getGlassSn() : modelId = "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ConnectApiHandler"
            r3.g(r1, r0)
            int r0 = r4.hashCode()
            java.lang.String r2 = ""
            switch(r0) {
                case -1911120892: goto L_0x0047;
                case -992172488: goto L_0x003e;
                case -692788174: goto L_0x0035;
                case 96586: goto L_0x002c;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x004f
        L_0x002c:
            java.lang.String r0 = "air"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x004f
            goto L_0x0058
        L_0x0035:
            java.lang.String r0 = "air_intl"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0058
            goto L_0x004f
        L_0x003e:
            java.lang.String r0 = "air_pro"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0058
            goto L_0x004f
        L_0x0047:
            java.lang.String r0 = "air_pro_intl"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0058
        L_0x004f:
            r5.success(r2)
            java.lang.String r4 = "getGlassSn() result model id error"
            r3.g(r1, r4)
            goto L_0x007d
        L_0x0058:
            com.upuphone.xr.sapp.utils.ControlUtils r4 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            com.upuphone.xr.sapp.entity.DeviceInfo r4 = r4.g()
            java.lang.String r4 = r4.getSerialNo()
            if (r4 != 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r2 = r4
        L_0x0066:
            r5.success(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getGlassSn() result = "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.g(r1, r4)
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.flutter.pigeon.impl.ConnectApiHandler.t(java.lang.String, com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$Result):void");
    }

    public final void u() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("ConnectApiHandler", "getHistoryDevices start autoConnectLastDevice");
        StarryNetDevice a2 = ConnectExtKt.a();
        if (a2 != null) {
            NetDevice v = v();
            if (v == null || v.getState() == ConnectState.UNCONNECTED) {
                delegate.g("ConnectApiHandler", "autoConnectLastDevice-> 当前没有连接设备或断连,触发重连");
                AndroidConnectApi.FlutterConnectApi flutterConnectApi = this.b;
                AndroidConnectApi.ConnectState.Builder c2 = new AndroidConnectApi.ConnectState.Builder().e(AndroidConnectApi.StateEnum.SCANING).b(a2.getDeviceId()).c(a2.getDeviceName());
                String modelId = a2.getModelId();
                Intrinsics.checkNotNullExpressionValue(modelId, "getModelId(...)");
                flutterConnectApi.i(c2.d(ConnectExtKt.o(modelId)).a(), new ConnectVoidResult());
                w(a2);
                StarryNetHelper.f7917a.c(ConnectApiHandler$autoConnectLastDevice$1$1.INSTANCE);
                return;
            }
            delegate.g("ConnectApiHandler", "autoConnectLastDevice-> 已经连上了, 忽略");
        }
    }

    public final NetDevice v() {
        return (NetDevice) this.f8347a.L().getValue();
    }

    public final void w(StarryNetDevice starryNetDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ConnectApiHandler", "resetConnectTimeout-> " + starryNetDevice);
        this.c.a();
        this.c.b(starryNetDevice);
    }
}
