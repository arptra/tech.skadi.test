package com.upuphone.xr.sapp.vu.fragment;

import com.upuphone.xr.sapp.databinding.FragmentVuGlassesManagerBinding;
import com.upuphone.xr.sapp.view.CardItemView;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class VuGlassesManagerFragment$initObserve$1 extends Lambda implements Function1<VuGlassControlModel.ViewGlassesInfo, Unit> {
    final /* synthetic */ VuGlassesManagerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuGlassesManagerFragment$initObserve$1(VuGlassesManagerFragment vuGlassesManagerFragment) {
        super(1);
        this.this$0 = vuGlassesManagerFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VuGlassControlModel.ViewGlassesInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable VuGlassControlModel.ViewGlassesInfo viewGlassesInfo) {
        String str;
        FragmentVuGlassesManagerBinding M0 = this.this$0.j;
        if (M0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            M0 = null;
        }
        CardItemView cardItemView = M0.i;
        if (viewGlassesInfo == null || (str = viewGlassesInfo.b()) == null) {
            str = "";
        }
        cardItemView.setCardSubTitle(str);
    }
}
