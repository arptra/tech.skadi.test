package com.upuphone.xr.sapp.vu.ota;

import com.upuphone.xr.sapp.vu.utils.VuGlassesEventDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuGlassUpdateHelper$installRom$2$1$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ VuGlassUpdateHelper$installRom$2$1$listener$1 $listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassUpdateHelper$installRom$2$1$1(VuGlassUpdateHelper$installRom$2$1$listener$1 vuGlassUpdateHelper$installRom$2$1$listener$1) {
        super(1);
        this.$listener = vuGlassUpdateHelper$installRom$2$1$listener$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        VuGlassesEventDispatcher.f8098a.q(this.$listener);
    }
}
