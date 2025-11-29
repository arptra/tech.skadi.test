package com.upuphone.xr.sapp.vu.vm;

import android.hardware.usb.UsbDevice;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\t\u0018\u00010\u0001¢\u0006\u0002\b\u00022\r\u0010\u0003\u001a\t\u0018\u00010\u0004¢\u0006\u0002\b\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroid/hardware/usb/UsbDevice;", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuGlassControlModel$glassesDevice$1 extends Lambda implements Function1<VuGlassControlModel.ViewGlassesInfo, UsbDevice> {
    public static final VuGlassControlModel$glassesDevice$1 INSTANCE = new VuGlassControlModel$glassesDevice$1();

    public VuGlassControlModel$glassesDevice$1() {
        super(1);
    }

    @Nullable
    public final UsbDevice invoke(@Nullable VuGlassControlModel.ViewGlassesInfo viewGlassesInfo) {
        if (viewGlassesInfo != null) {
            return viewGlassesInfo.c();
        }
        return null;
    }
}
