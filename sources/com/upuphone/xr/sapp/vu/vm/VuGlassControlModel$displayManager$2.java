package com.upuphone.xr.sapp.vu.vm;

import android.hardware.display.DisplayManager;
import com.upuphone.xr.sapp.MainApplication;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/hardware/display/DisplayManager;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuGlassControlModel$displayManager$2 extends Lambda implements Function0<DisplayManager> {
    public static final VuGlassControlModel$displayManager$2 INSTANCE = new VuGlassControlModel$displayManager$2();

    public VuGlassControlModel$displayManager$2() {
        super(0);
    }

    public final DisplayManager invoke() {
        return (DisplayManager) MainApplication.k.f().getSystemService(DisplayManager.class);
    }
}
