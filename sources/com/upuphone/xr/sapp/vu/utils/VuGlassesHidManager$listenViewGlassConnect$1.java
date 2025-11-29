package com.upuphone.xr.sapp.vu.utils;

import android.hardware.usb.UsbDevice;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/hardware/usb/UsbDevice;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuGlassesHidManager$listenViewGlassConnect$1 extends Lambda implements Function1<UsbDevice, Unit> {
    public static final VuGlassesHidManager$listenViewGlassConnect$1 INSTANCE = new VuGlassesHidManager$listenViewGlassConnect$1();

    public VuGlassesHidManager$listenViewGlassConnect$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((UsbDevice) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable UsbDevice usbDevice) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassesHidManager", "listenViewGlassConnect connectState: " + usbDevice);
        if (usbDevice != null) {
            VuGlassesHidManager.f8100a.q(usbDevice);
        } else {
            VuGlassesHidManager.f8100a.r();
        }
    }
}
