package com.upuphone.xr.sapp.vu.utils;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.vu.utils.GlassesManager;
import com.xjmz.glasses.usb.hid.IGlassesEventCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u001a¢\u0006\u0004\b!\u0010\u001cJ\r\u0010\"\u001a\u00020\u001a¢\u0006\u0004\b\"\u0010\u001cJ\r\u0010#\u001a\u00020\u0017¢\u0006\u0004\b#\u0010\u0019J\r\u0010$\u001a\u00020\u0017¢\u0006\u0004\b$\u0010\u0019J\r\u0010%\u001a\u00020\u001a¢\u0006\u0004\b%\u0010\u001cJ\u0015\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u001a¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0017¢\u0006\u0004\b)\u0010\u0019J\u0015\u0010+\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0004¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0004¢\u0006\u0004\b-\u0010\u0006J\r\u0010.\u001a\u00020\u001a¢\u0006\u0004\b.\u0010\u001cJ\r\u0010/\u001a\u00020\u001a¢\u0006\u0004\b/\u0010\u001cJ\u0015\u00101\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001a¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u0004¢\u0006\u0004\b3\u0010\u0006J\r\u00104\u001a\u00020\u0004¢\u0006\u0004\b4\u0010\u0006J\u0015\u00106\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001a¢\u0006\u0004\b6\u00102J\r\u00107\u001a\u00020\u001a¢\u0006\u0004\b7\u0010\u001cJ\u001d\u0010:\u001a\u00020\u00172\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u001a¢\u0006\u0004\b:\u0010;J\u0010\u0010<\u001a\u00020\u0004H@¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\bA\u0010BJ\r\u0010C\u001a\u00020\u0017¢\u0006\u0004\bC\u0010\u0019R\u0016\u0010E\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u0010D¨\u0006F"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/VuGlassesHidUtil;", "", "<init>", "()V", "", "c", "()Ljava/lang/String;", "k", "f", "Lcom/upuphone/xr/sapp/vu/utils/GlassesManager$IGlassesServiceConnection;", "connection", "", "v", "(Lcom/upuphone/xr/sapp/vu/utils/GlassesManager$IGlassesServiceConnection;)V", "E", "Lcom/xjmz/glasses/usb/hid/IGlassesEventCallback;", "callback", "u", "(Lcom/xjmz/glasses/usb/hid/IGlassesEventCallback;)V", "Landroid/content/Context;", "context", "D", "(Landroid/content/Context;)V", "", "q", "()Z", "", "e", "()I", "Landroid/hardware/usb/UsbDevice;", "device", "s", "(Landroid/hardware/usb/UsbDevice;)Z", "w", "x", "n", "m", "a", "brightness", "y", "(I)V", "p", "name", "B", "(Ljava/lang/String;)Z", "d", "t", "i", "timeSeconds", "C", "(I)I", "j", "g", "mode", "z", "b", "filepath", "type", "A", "(Ljava/lang/String;I)Z", "l", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "version", "h", "(Ljava/lang/String;)Ljava/lang/String;", "r", "(Landroid/hardware/usb/UsbDevice;)V", "o", "Z", "isGettingVersion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuGlassesHidUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final VuGlassesHidUtil f8104a = new VuGlassesHidUtil();
    public static volatile boolean b;

    public final boolean A(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "filepath");
        try {
            return GlassesManager.n().G(str, i) == 0;
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("VuGlassInfoUtil", "setFirmwareFilepath: " + e);
            return false;
        }
    }

    public final boolean B(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        try {
            return GlassesManager.n().E(str) == 0;
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("VuGlassInfoUtil", "setGlassesName: " + e);
            return false;
        }
    }

    public final int C(int i) {
        try {
            return GlassesManager.n().H(i);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("VuGlassInfoUtil", "setSleepTime: " + e);
            return -1;
        }
    }

    public final void D(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GlassesManager.n().I(context);
    }

    public final void E(GlassesManager.IGlassesServiceConnection iGlassesServiceConnection) {
        Intrinsics.checkNotNullParameter(iGlassesServiceConnection, "connection");
        GlassesManager.n().K(iGlassesServiceConnection);
    }

    public final int a() {
        try {
            return GlassesManager.n().i();
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("VuGlassInfoUtil", "getBrightness: " + e);
            return -1;
        }
    }

    public final int b() {
        try {
            return GlassesManager.n().l();
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("VuGlassInfoUtil", "getDisplayStyleMode: " + e);
            return -1;
        }
    }

    public final String c() {
        try {
            String h = GlassesManager.n().h();
            Intrinsics.checkNotNullExpressionValue(h, "getAiDspVersion(...)");
            String obj = StringsKt.trim((CharSequence) h).toString();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("VuGlassInfoUtil", "getDspVersion: " + obj);
            return StringsKt.substringAfter(StringsKt.substringBefore$default(obj, ".", (String) null, 2, (Object) null), "sa1401_V", "0");
        } catch (Exception e) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("VuGlassInfoUtil", "getDspVersion: " + e);
            return "0";
        }
    }

    public final String d() {
        try {
            String j = GlassesManager.n().j();
            return j == null ? "" : j;
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("VuGlassInfoUtil", "getGlassesName: " + e);
            return "";
        }
    }

    public final int e() {
        return GlassesManager.n().m();
    }

    public final String f() {
        try {
            String k = GlassesManager.n().k();
            Intrinsics.checkNotNullExpressionValue(k, "getDisplayChipVersion(...)");
            String obj = StringsKt.trim((CharSequence) k).toString();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("VuGlassInfoUtil", "getLt7911Version: " + obj);
            return StringsKt.substringAfter(StringsKt.substringBefore$default(obj, ".", (String) null, 2, (Object) null), "sa1401_V", "0");
        } catch (Exception e) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("VuGlassInfoUtil", "getLt7911Version: " + e);
            return "0";
        }
    }

    public final String g() {
        try {
            String p = GlassesManager.n().p();
            return p == null ? "" : p;
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("VuGlassInfoUtil", "getModel: " + e);
            return "";
        }
    }

    public final String h(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return "Flyme XR " + str;
    }

    public final int i() {
        try {
            return GlassesManager.n().q();
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("VuGlassInfoUtil", "getSleepTime: " + e);
            return -1;
        }
    }

    public final String j() {
        try {
            String r = GlassesManager.n().r();
            return r == null ? "" : r;
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("VuGlassInfoUtil", "getSn: " + e);
            return "";
        }
    }

    public final String k() {
        try {
            String o = GlassesManager.n().o();
            Intrinsics.checkNotNullExpressionValue(o, "getMCUAPPVersion(...)");
            String obj = StringsKt.trim((CharSequence) o).toString();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("VuGlassInfoUtil", "getStm32Version: " + obj);
            return StringsKt.substringAfter(StringsKt.substringBefore$default(obj, ".", (String) null, 2, (Object) null), "sa1401_V", "0");
        } catch (Exception e) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("VuGlassInfoUtil", "getStm32Version: " + e);
            return "0";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b1 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object l(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil$getVersion$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil$getVersion$1 r0 = (com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil$getVersion$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil$getVersion$1 r0 = new com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil$getVersion$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            java.lang.Object r6 = r0.L$0
            com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil r6 = (com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil) r6
            goto L_0x0032
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
        L_0x0035:
            boolean r7 = b
            if (r7 == 0) goto L_0x0046
            r0.L$0 = r6
            r0.label = r3
            r4 = 50
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r4, r0)
            if (r7 != r1) goto L_0x0035
            return r1
        L_0x0046:
            b = r3
            java.lang.String r7 = r6.c()
            java.lang.String r0 = r6.f()
            java.lang.String r6 = r6.k()
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getVersion: dspVersion="
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = ", lt7911Version="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = ", stm32Version="
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "VuGlassInfoUtil"
            r1.a(r3, r2)
            r1 = 0
            b = r1
            int r1 = r7.length()
            if (r1 <= 0) goto L_0x00b1
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x00b1
            int r1 = r6.length()
            if (r1 <= 0) goto L_0x00b1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "1."
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = "."
            r1.append(r7)
            r1.append(r0)
            r1.append(r7)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            goto L_0x00b3
        L_0x00b1:
            java.lang.String r6 = ""
        L_0x00b3:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil.l(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean m() {
        try {
            int g = GlassesManager.n().g();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("VuGlassInfoUtil", "get2D3DMode: " + g);
            return g == 1;
        } catch (Exception e) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("VuGlassInfoUtil", "is2DMode: " + e);
            return false;
        }
    }

    public final boolean n() {
        try {
            int g = GlassesManager.n().g();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("VuGlassInfoUtil", "get2D3DMode: " + g);
            return g == 2;
        } catch (Exception e) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("VuGlassInfoUtil", "is3DMode: " + e);
            return false;
        }
    }

    public final boolean o() {
        return GlassesManager.n().u();
    }

    public final boolean p() {
        try {
            return GlassesManager.n().s();
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("VuGlassInfoUtil", "isGlassesWorn: " + e);
            return true;
        }
    }

    public final boolean q() {
        return GlassesManager.n().v();
    }

    public final void r(UsbDevice usbDevice) {
        Intrinsics.checkNotNullParameter(usbDevice, "device");
        GlassesManager.n().x(usbDevice);
    }

    public final boolean s(UsbDevice usbDevice) {
        if (usbDevice == null) {
            return false;
        }
        return GlassesManager.n().y(usbDevice);
    }

    public final int t() {
        try {
            return GlassesManager.n().z();
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("VuGlassInfoUtil", "reboot: " + e);
            return -1;
        }
    }

    public final void u(IGlassesEventCallback iGlassesEventCallback) {
        Intrinsics.checkNotNullParameter(iGlassesEventCallback, "callback");
        GlassesManager.n().A(iGlassesEventCallback);
    }

    public final void v(GlassesManager.IGlassesServiceConnection iGlassesServiceConnection) {
        Intrinsics.checkNotNullParameter(iGlassesServiceConnection, "connection");
        GlassesManager.n().B(iGlassesServiceConnection);
    }

    public final int w() {
        if (m()) {
            ULog.f6446a.a("VuGlassInfoUtil", "set3DMode: already in 2d mode");
            return 0;
        }
        try {
            int C = GlassesManager.n().C(1);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("VuGlassInfoUtil", "set2DMode result: " + C);
            return C;
        } catch (Exception e) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("VuGlassInfoUtil", "set2DMode: " + e);
            return -1;
        }
    }

    public final int x() {
        if (n()) {
            ULog.f6446a.a("VuGlassInfoUtil", "set3DMode: already in 3d mode");
            return 0;
        }
        try {
            int C = GlassesManager.n().C(2);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("VuGlassInfoUtil", "set3DMode result: " + C);
            return C;
        } catch (Exception e) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("VuGlassInfoUtil", "set3DMode: " + e);
            return -1;
        }
    }

    public final void y(int i) {
        try {
            GlassesManager.n().D(i);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("VuGlassInfoUtil", "setBrightness: " + e);
        }
    }

    public final int z(int i) {
        try {
            return GlassesManager.n().F(i);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("VuGlassInfoUtil", "setDisplayStyleMode: " + e);
            return -1;
        }
    }
}
