package com.upuphone.xr.sapp.vu.fragment;

import com.upuphone.xr.sapp.databinding.FragmentVuAboutGlassBinding;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuAboutGlassFragment$addObserver$1 extends Lambda implements Function1<VuGlassControlModel.ViewGlassesInfo, Unit> {
    final /* synthetic */ VuAboutGlassFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuAboutGlassFragment$addObserver$1(VuAboutGlassFragment vuAboutGlassFragment) {
        super(1);
        this.this$0 = vuAboutGlassFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VuGlassControlModel.ViewGlassesInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable VuGlassControlModel.ViewGlassesInfo viewGlassesInfo) {
        FragmentVuAboutGlassBinding fragmentVuAboutGlassBinding = null;
        if (viewGlassesInfo == null || !viewGlassesInfo.e()) {
            FragmentVuAboutGlassBinding C0 = this.this$0.j;
            if (C0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                C0 = null;
            }
            C0.c.setAlpha(0.5f);
            FragmentVuAboutGlassBinding C02 = this.this$0.j;
            if (C02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVuAboutGlassBinding = C02;
            }
            fragmentVuAboutGlassBinding.i.setAlpha(0.5f);
            return;
        }
        FragmentVuAboutGlassBinding C03 = this.this$0.j;
        if (C03 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            C03 = null;
        }
        C03.c.setAlpha(1.0f);
        FragmentVuAboutGlassBinding C04 = this.this$0.j;
        if (C04 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuAboutGlassBinding = C04;
        }
        fragmentVuAboutGlassBinding.i.setAlpha(1.0f);
    }
}
