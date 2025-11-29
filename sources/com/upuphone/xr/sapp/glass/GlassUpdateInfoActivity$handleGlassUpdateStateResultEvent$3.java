package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.entity.GlassUpdateState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassUpdateInfoActivity$handleGlassUpdateStateResultEvent$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GlassUpdateState $glassUpdateState;
    final /* synthetic */ GlassUpdateInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateInfoActivity$handleGlassUpdateStateResultEvent$3(GlassUpdateInfoActivity glassUpdateInfoActivity, GlassUpdateState glassUpdateState) {
        super(0);
        this.this$0 = glassUpdateInfoActivity;
        this.$glassUpdateState = glassUpdateState;
    }

    public final void invoke() {
        this.this$0.e1(((GlassUpdateState.InstallFail) this.$glassUpdateState).getErrorCode());
    }
}
