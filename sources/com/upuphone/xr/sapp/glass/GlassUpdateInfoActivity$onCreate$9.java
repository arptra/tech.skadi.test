package com.upuphone.xr.sapp.glass;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.GlassCheckUpdateState;
import com.upuphone.xr.sapp.entity.GlassUpdateProgress;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "progress", "Lcom/upuphone/xr/sapp/entity/GlassUpdateProgress;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassUpdateInfoActivity$onCreate$9 extends Lambda implements Function1<GlassUpdateProgress, Unit> {
    final /* synthetic */ GlassUpdateInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateInfoActivity$onCreate$9(GlassUpdateInfoActivity glassUpdateInfoActivity) {
        super(1);
        this.this$0 = glassUpdateInfoActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GlassUpdateProgress) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable GlassUpdateProgress glassUpdateProgress) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassUpdateInfoActivity", "glassUpdateProgressData: " + glassUpdateProgress);
        GlassCheckUpdateState A0 = this.this$0.g;
        if (A0 != null) {
            GlassUpdateInfoActivity glassUpdateInfoActivity = this.this$0;
            delegate.a("GlassUpdateInfoActivity", "glassUpdateProgressData, handleGlassUpdateState");
            GlassUpdateInfoActivity.S0(glassUpdateInfoActivity, A0, (GlassUpdateState) glassUpdateInfoActivity.N0().e().getValue(), glassUpdateProgress, false, 8, (Object) null);
        }
    }
}
