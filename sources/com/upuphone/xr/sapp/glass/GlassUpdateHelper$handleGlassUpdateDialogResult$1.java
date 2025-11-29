package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.entity.GlassUpdateState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassUpdateHelper$handleGlassUpdateDialogResult$1 extends Lambda implements Function1<GlassUpdateState, Unit> {
    public static final GlassUpdateHelper$handleGlassUpdateDialogResult$1 INSTANCE = new GlassUpdateHelper$handleGlassUpdateDialogResult$1();

    public GlassUpdateHelper$handleGlassUpdateDialogResult$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GlassUpdateState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GlassUpdateState glassUpdateState) {
        Intrinsics.checkNotNullParameter(glassUpdateState, "it");
        GlassUpdateHelper.b.v1(glassUpdateState);
    }
}
