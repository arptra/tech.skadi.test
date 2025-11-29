package com.upuphone.xr.sapp.vm;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.sapp.entity.NetDevice;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/sapp/entity/NetDevice;", "it", "Lcom/upuphone/runasone/device/StarryDevice;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class Ring2ControlViewModel$getBoundedRing2$2 extends Lambda implements Function1<StarryDevice, NetDevice> {
    final /* synthetic */ Ring2ControlViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Ring2ControlViewModel$getBoundedRing2$2(Ring2ControlViewModel ring2ControlViewModel) {
        super(1);
        this.this$0 = ring2ControlViewModel;
    }

    @NotNull
    public final NetDevice invoke(StarryDevice starryDevice) {
        Ring2ControlViewModel ring2ControlViewModel = this.this$0;
        Intrinsics.checkNotNull(starryDevice);
        return ring2ControlViewModel.q(starryDevice);
    }
}
