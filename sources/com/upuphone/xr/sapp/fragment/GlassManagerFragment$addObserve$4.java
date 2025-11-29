package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentGlassManagerBinding;
import com.upuphone.xr.sapp.entity.GlassFontSize;
import com.upuphone.xr.sapp.view.CardItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/GlassFontSize;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class GlassManagerFragment$addObserve$4 extends Lambda implements Function1<GlassFontSize, Unit> {
    final /* synthetic */ GlassManagerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassManagerFragment$addObserve$4(GlassManagerFragment glassManagerFragment) {
        super(1);
        this.this$0 = glassManagerFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GlassFontSize) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GlassFontSize glassFontSize) {
        int i;
        FragmentGlassManagerBinding W0 = this.this$0.j;
        if (W0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            W0 = null;
        }
        CardItemView cardItemView = W0.j;
        GlassFontSize glassFontSize2 = GlassFontSize.NORMAL;
        GlassManagerFragment glassManagerFragment = this.this$0;
        if (glassFontSize == glassFontSize2) {
            i = R.string.font_size_normal_txt;
        } else {
            i = R.string.font_size_big_txt;
        }
        cardItemView.setCardSubTitle(glassManagerFragment.getString(i));
    }
}
