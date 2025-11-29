package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.databinding.FragmentGlassManagerBinding;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.view.CardItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassManagerFragment$addObserve$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ GlassManagerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassManagerFragment$addObserve$2(GlassManagerFragment glassManagerFragment) {
        super(1);
        this.this$0 = glassManagerFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        FragmentGlassManagerBinding W0 = this.this$0.j;
        if (W0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            W0 = null;
        }
        CardItemView cardItemView = W0.g;
        ControlUtils controlUtils = ControlUtils.f7858a;
        Intrinsics.checkNotNull(num);
        cardItemView.setCardSubTitle(controlUtils.v(num.intValue()));
    }
}
