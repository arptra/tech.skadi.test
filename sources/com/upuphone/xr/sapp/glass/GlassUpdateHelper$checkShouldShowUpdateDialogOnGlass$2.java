package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.entity.GlassUpdateDialogReminder;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassUpdateHelper$checkShouldShowUpdateDialogOnGlass$2 extends Lambda implements Function1<GlassUpdateState, Unit> {
    final /* synthetic */ String $latestVersion;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateHelper$checkShouldShowUpdateDialogOnGlass$2(String str) {
        super(1);
        this.$latestVersion = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GlassUpdateState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GlassUpdateState glassUpdateState) {
        Intrinsics.checkNotNullParameter(glassUpdateState, "it");
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        glassUpdateHelper.v1(glassUpdateState);
        if (glassUpdateState instanceof GlassUpdateState.WaitingUpdateDialogResult) {
            glassUpdateHelper.z1(new GlassUpdateDialogReminder(false, this.$latestVersion, (Long) null, (String) null, (Boolean) null, (String) null, 60, (DefaultConstructorMarker) null));
        }
    }
}
