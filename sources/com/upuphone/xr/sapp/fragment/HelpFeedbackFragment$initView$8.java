package com.upuphone.xr.sapp.fragment;

import android.widget.TextView;
import com.upuphone.xr.sapp.databinding.FragmentHelpFeedbackBinding;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nHelpFeedbackFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HelpFeedbackFragment.kt\ncom/upuphone/xr/sapp/fragment/HelpFeedbackFragment$initView$8\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,194:1\n256#2,2:195\n*S KotlinDebug\n*F\n+ 1 HelpFeedbackFragment.kt\ncom/upuphone/xr/sapp/fragment/HelpFeedbackFragment$initView$8\n*L\n136#1:195,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HelpFeedbackFragment$initView$8 extends Lambda implements Function1<VuGlassControlModel.ViewGlassesInfo, Unit> {
    final /* synthetic */ HelpFeedbackFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HelpFeedbackFragment$initView$8(HelpFeedbackFragment helpFeedbackFragment) {
        super(1);
        this.this$0 = helpFeedbackFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VuGlassControlModel.ViewGlassesInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable VuGlassControlModel.ViewGlassesInfo viewGlassesInfo) {
        FragmentHelpFeedbackBinding I0 = this.this$0.j;
        if (I0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            I0 = null;
        }
        TextView textView = I0.c;
        Intrinsics.checkNotNullExpressionValue(textView, "frequentlyAsked");
        int i = 0;
        if (!(viewGlassesInfo != null)) {
            i = 8;
        }
        textView.setVisibility(i);
    }
}
