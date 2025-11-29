package com.upuphone.xr.sapp.fragment;

import com.meizu.common.app.LoadingDialog;
import com.upuphone.xr.sapp.databinding.FragmentGlassStabilizationBinding;
import com.upuphone.xr.sapp.entity.StabilizationMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/StabilizationMode;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassStabilizationFragment$initObserve$1 extends Lambda implements Function1<StabilizationMode, Unit> {
    final /* synthetic */ GlassStabilizationFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassStabilizationFragment$initObserve$1(GlassStabilizationFragment glassStabilizationFragment) {
        super(1);
        this.this$0 = glassStabilizationFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StabilizationMode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(StabilizationMode stabilizationMode) {
        FragmentGlassStabilizationBinding E0 = this.this$0.j;
        FragmentGlassStabilizationBinding fragmentGlassStabilizationBinding = null;
        if (E0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            E0 = null;
        }
        E0.c.getBinding().i.setChecked(stabilizationMode.getGlobalSwitch());
        FragmentGlassStabilizationBinding E02 = this.this$0.j;
        if (E02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            E02 = null;
        }
        E02.d.getBinding().i.setChecked(stabilizationMode.getNaviSwitch());
        FragmentGlassStabilizationBinding E03 = this.this$0.j;
        if (E03 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentGlassStabilizationBinding = E03;
        }
        fragmentGlassStabilizationBinding.d.getBinding().i.setEnabled(!stabilizationMode.getGlobalSwitch());
        LoadingDialog F0 = this.this$0.n;
        if (F0 != null) {
            F0.dismiss();
        }
    }
}
