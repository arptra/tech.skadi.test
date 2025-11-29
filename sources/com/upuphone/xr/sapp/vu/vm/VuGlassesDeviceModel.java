package com.upuphone.xr.sapp.vu.vm;

import android.hardware.usb.UsbDevice;
import com.upuphone.xr.sapp.vu.receiver.ViewGlassesConnectListener;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\tR\u001f\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b8\u0006¢\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/vu/vm/VuGlassesDeviceModel;", "Lcom/upuphone/xr/sapp/vu/receiver/ViewGlassesConnectListener;", "<init>", "()V", "", "d", "Landroid/hardware/usb/UsbDevice;", "device", "b", "(Landroid/hardware/usb/UsbDevice;)V", "a", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "c", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "glassesDevice", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuGlassesDeviceModel implements ViewGlassesConnectListener {

    /* renamed from: a  reason: collision with root package name */
    public static final VuGlassesDeviceModel f8113a;
    public static final MutableStateFlow b = StateFlowKt.a((Object) null);

    static {
        VuGlassesDeviceModel vuGlassesDeviceModel = new VuGlassesDeviceModel();
        f8113a = vuGlassesDeviceModel;
        vuGlassesDeviceModel.d();
    }

    public void a(UsbDevice usbDevice) {
        Intrinsics.checkNotNullParameter(usbDevice, "device");
        b.setValue((Object) null);
    }

    public void b(UsbDevice usbDevice) {
        Intrinsics.checkNotNullParameter(usbDevice, "device");
        b.setValue(usbDevice);
    }

    public final MutableStateFlow c() {
        return b;
    }

    public final void d() {
        b.setValue(VuGlassesHelper.f8099a.a());
    }
}
