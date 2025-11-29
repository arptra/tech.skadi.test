package com.upuphone.xr.sapp.vm;

import com.upuphone.runasone.device.StarryDevice;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/runasone/device/StarryDevice;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/upuphone/runasone/device/StarryDevice;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class Ring2ControlViewModel$getBoundedRing2$1 extends Lambda implements Function1<StarryDevice, Boolean> {
    public static final Ring2ControlViewModel$getBoundedRing2$1 INSTANCE = new Ring2ControlViewModel$getBoundedRing2$1();

    public Ring2ControlViewModel$getBoundedRing2$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(StarryDevice starryDevice) {
        return Boolean.valueOf(starryDevice.getTerminalType() == 5);
    }
}
