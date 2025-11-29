package com.upuphone.xr.sapp.vu.utils;

import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.view.Display;
import com.upuphone.xr.sapp.MainApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/VuGlassesHelper;", "", "<init>", "()V", "Landroid/hardware/usb/UsbDevice;", "usbDevice", "", "f", "(Landroid/hardware/usb/UsbDevice;)Z", "Landroid/view/Display;", "display", "e", "(Landroid/view/Display;)Z", "a", "()Landroid/hardware/usb/UsbDevice;", "c", "()Landroid/view/Display;", "b", "Landroid/graphics/Point;", "d", "(Landroid/view/Display;)Landroid/graphics/Point;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuGlassesHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final VuGlassesHelper f8099a = new VuGlassesHelper();

    public final UsbDevice a() {
        for (UsbDevice next : ((UsbManager) MainApplication.k.f().getSystemService(UsbManager.class)).getDeviceList().values()) {
            Intrinsics.checkNotNull(next);
            if (f(next)) {
                return next;
            }
        }
        return null;
    }

    public final UsbDevice b() {
        for (UsbDevice next : ((UsbManager) MainApplication.k.f().getSystemService(UsbManager.class)).getDeviceList().values()) {
            Intrinsics.checkNotNull(next);
            if (f(next)) {
                return next;
            }
        }
        return null;
    }

    public final Display c() {
        Display[] displays = ((DisplayManager) MainApplication.k.f().getSystemService(DisplayManager.class)).getDisplays();
        Intrinsics.checkNotNullExpressionValue(displays, "getDisplays(...)");
        Display display = null;
        for (Display display2 : displays) {
            if (e(display2)) {
                display = display2;
            }
        }
        return display;
    }

    public final Point d(Display display) {
        if (display == null) {
            return new Point();
        }
        Point point = new Point();
        Point point2 = new Point();
        display.getCurrentSizeRange(point, point2);
        return point2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r4 = r4.getName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(android.view.Display r4) {
        /*
            r3 = this;
            r3 = 0
            if (r4 != 0) goto L_0x0004
            return r3
        L_0x0004:
            java.lang.String r4 = r4.getName()
            if (r4 == 0) goto L_0x0016
            r0 = 2
            r1 = 0
            java.lang.String r2 = "HDMI"
            boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r2, (boolean) r3, (int) r0, (java.lang.Object) r1)
            r0 = 1
            if (r4 != r0) goto L_0x0016
            r3 = r0
        L_0x0016:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.utils.VuGlassesHelper.e(android.view.Display):boolean");
    }

    public final boolean f(UsbDevice usbDevice) {
        Intrinsics.checkNotNullParameter(usbDevice, "usbDevice");
        return usbDevice.getProductId() == 8272 && usbDevice.getVendorId() == 10821;
    }
}
