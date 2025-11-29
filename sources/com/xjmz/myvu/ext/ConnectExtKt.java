package com.xjmz.myvu.ext;

import com.upuphone.xr.interconnect.Constants;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.entity.NetDevice;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a\u000f\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\n¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\r*\u00020\n¢\u0006\u0004\b\u0010\u0010\u000f\u001a\u0011\u0010\u0011\u001a\u00020\r*\u00020\n¢\u0006\u0004\b\u0011\u0010\u000f\u001a\u0019\u0010\u0016\u001a\u00020\u0015*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0019\u0010\u0018\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0011\u0010\u001a\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001b\"\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u00078\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u001c\u001a\u0004\b\u001d\u0010\t\"\u0015\u0010 \u001a\u00020\r*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000f\"\u0015\u0010\"\u001a\u00020\r*\u00020\n8F¢\u0006\u0006\u001a\u0004\b!\u0010\u000f\"\u0015\u0010$\u001a\u00020\r*\u00020\n8F¢\u0006\u0006\u001a\u0004\b#\u0010\u000f\"\u0015\u0010&\u001a\u00020\r*\u00020\n8F¢\u0006\u0006\u001a\u0004\b%\u0010\u000f¨\u0006'"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "a", "()Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "c", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$DeviceInfo;", "d", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$DeviceInfo;", "", "b", "()Ljava/util/List;", "", "o", "(Ljava/lang/String;)Ljava/lang/String;", "", "f", "(Ljava/lang/String;)Z", "g", "h", "Lcom/upuphone/xr/sapp/entity/NetDevice;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$StateEnum;", "state", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$ConnectState;", "m", "(Lcom/upuphone/xr/sapp/entity/NetDevice;Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$StateEnum;)Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$ConnectState;", "l", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$StateEnum;)Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$ConnectState;", "n", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$DeviceInfo;", "Ljava/util/List;", "getDeviceAllModel", "deviceAllModel", "e", "isAnyKindOfAirGlass", "k", "isViewGlass", "i", "isGlass", "j", "isRing", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nConnectExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectExt.kt\ncom/xjmz/myvu/ext/ConnectExtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,203:1\n1#2:204\n1#2:218\n1#2:231\n766#3:205\n857#3,2:206\n1603#3,9:208\n1855#3:217\n1856#3:219\n1612#3:220\n1603#3,9:221\n1855#3:230\n1856#3:232\n1612#3:233\n*S KotlinDebug\n*F\n+ 1 ConnectExt.kt\ncom/xjmz/myvu/ext/ConnectExtKt\n*L\n42#1:218\n51#1:231\n41#1:205\n41#1:206,2\n42#1:208,9\n42#1:217\n42#1:219\n42#1:220\n51#1:221,9\n51#1:230\n51#1:232\n51#1:233\n*E\n"})
public final class ConnectExtKt {

    /* renamed from: a  reason: collision with root package name */
    public static final List f8241a = CollectionsKt.listOf(Constants.GLASS_DEVICE_ARI, "air_pro", "air_intl", "air_pro_intl", "view", "ring2");

    public static final StarryNetDevice a() {
        StarryNetDevice bondedDevice = XrSdkBondDeviceUtil.INSTANCE.getBondedDevice(MainApplication.k.d());
        if (bondedDevice == null || !StarryNetDeviceExt.isXrDevice(bondedDevice)) {
            return null;
        }
        return bondedDevice;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0082 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List b() {
        /*
            com.upuphone.xr.sapp.vu.utils.GlassDataStoreHelper r0 = com.upuphone.xr.sapp.vu.utils.GlassDataStoreHelper.f8091a
            java.util.List r0 = r0.a()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r0.iterator()
        L_0x000f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0028
            java.lang.Object r3 = r2.next()
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            java.util.List r5 = f8241a
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L_0x000f
            r1.add(r3)
            goto L_0x000f
        L_0x0028:
            java.util.List r2 = f8241a
            java.util.Set r0 = kotlin.collections.CollectionsKt.toSet(r0)
            java.util.List r0 = kotlin.collections.CollectionsKt.minus(r2, r0)
            java.util.List r0 = kotlin.collections.CollectionsKt.plus(r1, r0)
            java.util.List r0 = kotlin.collections.CollectionsKt.reversed(r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0043:
            boolean r2 = r0.hasNext()
            java.lang.String r3 = "air"
            java.lang.String r4 = "ring2"
            java.lang.String r5 = "view"
            r6 = 0
            if (r2 == 0) goto L_0x0075
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r7 = e(r2)
            if (r7 == 0) goto L_0x005e
            goto L_0x006f
        L_0x005e:
            boolean r3 = k(r2)
            if (r3 == 0) goto L_0x0066
            r3 = r5
            goto L_0x006f
        L_0x0066:
            boolean r2 = j(r2)
            if (r2 == 0) goto L_0x006e
            r3 = r4
            goto L_0x006f
        L_0x006e:
            r3 = r6
        L_0x006f:
            if (r3 == 0) goto L_0x0043
            r1.add(r3)
            goto L_0x0043
        L_0x0075:
            java.util.Set r0 = kotlin.collections.CollectionsKt.toSet(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0082:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00d8
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            int r7 = r2.hashCode()
            r8 = 96586(0x1794a, float:1.35346E-40)
            if (r7 == r8) goto L_0x00c2
            r8 = 3619493(0x373aa5, float:5.07199E-39)
            if (r7 == r8) goto L_0x00b6
            r8 = 108518402(0x677dc02, float:4.6617173E-35)
            if (r7 == r8) goto L_0x00a2
            goto L_0x00b4
        L_0x00a2:
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x00a9
            goto L_0x00b4
        L_0x00a9:
            com.upuphone.xr.interconnect.entity.StarryNetDevice r2 = c()
            if (r2 == 0) goto L_0x00b4
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo r2 = n(r2)
            goto L_0x00d2
        L_0x00b4:
            r2 = r6
            goto L_0x00d2
        L_0x00b6:
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x00bd
            goto L_0x00b4
        L_0x00bd:
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo r2 = d()
            goto L_0x00d2
        L_0x00c2:
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00b4
            com.upuphone.xr.interconnect.entity.StarryNetDevice r2 = a()
            if (r2 == 0) goto L_0x00b4
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo r2 = n(r2)
        L_0x00d2:
            if (r2 == 0) goto L_0x0082
            r1.add(r2)
            goto L_0x0082
        L_0x00d8:
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r1)
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r1 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r6 = r1.a()
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            r10 = 4
            r11 = 0
            java.lang.String r7 = "KEY_OPEN_FORCE_MULTI_DEVICE"
            r9 = 0
            java.lang.Object r1 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r6, r7, r8, r9, r10, r11)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0151
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder r1 = new com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder
            r1.<init>()
            java.lang.String r2 = "airpro_fake_1"
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder r1 = r1.b(r2)
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder r1 = r1.c(r2)
            java.lang.String r2 = "air_pro"
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder r1 = r1.d(r2)
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo r1 = r1.a()
            java.lang.String r2 = "build(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.add(r1)
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder r1 = new com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder
            r1.<init>()
            java.lang.String r3 = "view_fake_1"
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder r1 = r1.b(r3)
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder r1 = r1.c(r3)
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder r1 = r1.d(r5)
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo r1 = r1.a()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.add(r1)
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder r1 = new com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder
            r1.<init>()
            java.lang.String r3 = "ring_fake_2"
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder r1 = r1.b(r3)
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder r1 = r1.c(r3)
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo$Builder r1 = r1.d(r4)
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo r1 = r1.a()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.add(r1)
        L_0x0151:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.ext.ConnectExtKt.b():java.util.List");
    }

    public static final StarryNetDevice c() {
        return XrSdkBondDeviceUtil.INSTANCE.getBondedRingDevice(MainApplication.k.d());
    }

    public static final AndroidConnectApi.DeviceInfo d() {
        VuGlassControlModel.ViewGlassesInfo viewGlassesInfo = (VuGlassControlModel.ViewGlassesInfo) VuGlassControlModel.f8109a.v().getValue();
        if (viewGlassesInfo == null) {
            return null;
        }
        AndroidConnectApi.DeviceInfo a2 = new AndroidConnectApi.DeviceInfo.Builder().c(viewGlassesInfo.b()).b("view").d("view").a();
        Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
        return a2;
    }

    public static final boolean e(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.areEqual((Object) str, (Object) Constants.GLASS_DEVICE_ARI) || Intrinsics.areEqual((Object) str, (Object) "air_pro") || Intrinsics.areEqual((Object) str, (Object) "air_intl") || Intrinsics.areEqual((Object) str, (Object) "air_pro_intl");
    }

    public static final boolean f(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.areEqual((Object) str, (Object) Constants.GLASS_DEVICE_ARI) || Intrinsics.areEqual((Object) str, (Object) "air_intl");
    }

    public static final boolean g(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.areEqual((Object) str, (Object) "air_pro") || Intrinsics.areEqual((Object) str, (Object) "air_pro_intl");
    }

    public static final boolean h(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.areEqual((Object) str, (Object) "ring2");
    }

    public static final boolean i(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return k(str) || e(str);
    }

    public static final boolean j(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.areEqual((Object) str, (Object) "ring2");
    }

    public static final boolean k(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.areEqual((Object) str, (Object) "view");
    }

    public static final AndroidConnectApi.ConnectState l(StarryNetDevice starryNetDevice, AndroidConnectApi.StateEnum stateEnum) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "<this>");
        Intrinsics.checkNotNullParameter(stateEnum, "state");
        AndroidConnectApi.ConnectState.Builder builder = new AndroidConnectApi.ConnectState.Builder();
        String deviceName = starryNetDevice.getDeviceName();
        String str = "";
        if (deviceName == null) {
            deviceName = str;
        }
        AndroidConnectApi.ConnectState.Builder c = builder.c(deviceName);
        String deviceId = starryNetDevice.getDeviceId();
        if (deviceId != null) {
            str = deviceId;
        }
        AndroidConnectApi.ConnectState.Builder b = c.b(str);
        String modelId = starryNetDevice.getModelId();
        Intrinsics.checkNotNullExpressionValue(modelId, "getModelId(...)");
        AndroidConnectApi.ConnectState a2 = b.d(o(modelId)).e(stateEnum).a();
        Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
        return a2;
    }

    public static final AndroidConnectApi.ConnectState m(NetDevice netDevice, AndroidConnectApi.StateEnum stateEnum) {
        Intrinsics.checkNotNullParameter(netDevice, "<this>");
        Intrinsics.checkNotNullParameter(stateEnum, "state");
        AndroidConnectApi.ConnectState.Builder builder = new AndroidConnectApi.ConnectState.Builder();
        String mDeviceName = netDevice.getMDeviceName();
        String str = "";
        if (mDeviceName == null) {
            mDeviceName = str;
        }
        AndroidConnectApi.ConnectState.Builder c = builder.c(mDeviceName);
        String mIdentifier = netDevice.getMIdentifier();
        if (mIdentifier != null) {
            str = mIdentifier;
        }
        AndroidConnectApi.ConnectState a2 = c.b(str).d(o(netDevice.getModelID())).e(stateEnum).a();
        Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
        return a2;
    }

    public static final AndroidConnectApi.DeviceInfo n(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "<this>");
        AndroidConnectApi.DeviceInfo.Builder builder = new AndroidConnectApi.DeviceInfo.Builder();
        String deviceName = starryNetDevice.getDeviceName();
        String str = "";
        if (deviceName == null) {
            deviceName = str;
        }
        AndroidConnectApi.DeviceInfo.Builder c = builder.c(deviceName);
        String deviceId = starryNetDevice.getDeviceId();
        if (deviceId != null) {
            str = deviceId;
        }
        AndroidConnectApi.DeviceInfo.Builder b = c.b(str);
        String modelId = starryNetDevice.getModelId();
        Intrinsics.checkNotNullExpressionValue(modelId, "getModelId(...)");
        AndroidConnectApi.DeviceInfo a2 = b.d(o(modelId)).a();
        Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String o(java.lang.String r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            int r0 = r2.hashCode()
            java.lang.String r1 = "ring2"
            switch(r0) {
                case 1507424: goto L_0x005d;
                case 1507425: goto L_0x0051;
                case 1507426: goto L_0x0045;
                case 1507427: goto L_0x0039;
                case 1509346: goto L_0x0030;
                case 1509347: goto L_0x0027;
                case 1626588: goto L_0x001b;
                case 1626589: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0068
        L_0x000f:
            java.lang.String r0 = "5002"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0018
            goto L_0x0068
        L_0x0018:
            java.lang.String r1 = "air_pro_intl"
            goto L_0x006a
        L_0x001b:
            java.lang.String r0 = "5001"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0024
            goto L_0x0068
        L_0x0024:
            java.lang.String r1 = "air_intl"
            goto L_0x006a
        L_0x0027:
            java.lang.String r0 = "1202"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x006a
            goto L_0x0068
        L_0x0030:
            java.lang.String r0 = "1201"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x006a
            goto L_0x0068
        L_0x0039:
            java.lang.String r0 = "1004"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0042
            goto L_0x0068
        L_0x0042:
            java.lang.String r1 = "air_pro"
            goto L_0x006a
        L_0x0045:
            java.lang.String r0 = "1003"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x004e
            goto L_0x0068
        L_0x004e:
            java.lang.String r1 = "air"
            goto L_0x006a
        L_0x0051:
            java.lang.String r0 = "1002"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x005a
            goto L_0x0068
        L_0x005a:
            java.lang.String r1 = "star"
            goto L_0x006a
        L_0x005d:
            java.lang.String r0 = "1001"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0068
            java.lang.String r1 = "concept"
            goto L_0x006a
        L_0x0068:
            java.lang.String r1 = ""
        L_0x006a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.ext.ConnectExtKt.o(java.lang.String):java.lang.String");
    }
}
