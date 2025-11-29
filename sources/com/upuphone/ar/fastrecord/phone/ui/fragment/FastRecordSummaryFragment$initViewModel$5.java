package com.upuphone.ar.fastrecord.phone.ui.fragment;

import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordSummaryFragmentLayoutBinding;
import com.upuphone.star.common.phone.UToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nFastRecordSummaryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordSummaryFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment$initViewModel$5\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,429:1\n262#2,2:430\n*S KotlinDebug\n*F\n+ 1 FastRecordSummaryFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment$initViewModel$5\n*L\n322#1:430,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSummaryFragment$initViewModel$5 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ FastRecordSummaryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSummaryFragment$initViewModel$5(FastRecordSummaryFragment fastRecordSummaryFragment) {
        super(1);
        this.this$0 = fastRecordSummaryFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        FastRecordSummaryFragmentLayoutBinding access$getBinding$p = this.this$0.binding;
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding = null;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.j.setVisibility(8);
        FastRecordSummaryFragmentLayoutBinding access$getBinding$p2 = this.this$0.binding;
        if (access$getBinding$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p2 = null;
        }
        TextView textView = access$getBinding$p2.m;
        Intrinsics.checkNotNullExpressionValue(textView, "tvExtractTip");
        textView.setVisibility(8);
        if (num != null && num.intValue() == 0) {
            FastRecordSummaryFragmentLayoutBinding access$getBinding$p3 = this.this$0.binding;
            if (access$getBinding$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordSummaryFragmentLayoutBinding = access$getBinding$p3;
            }
            fastRecordSummaryFragmentLayoutBinding.o.setVisibility(0);
            this.this$0.showFeedBackState(true);
        } else if (num != null && num.intValue() == 1) {
            UToast.Companion companion = UToast.f6444a;
            FragmentActivity requireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            String string = this.this$0.getString(R.string.fr_extract_summary_no);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(requireActivity, string);
            FastRecordSummaryFragmentLayoutBinding access$getBinding$p4 = this.this$0.binding;
            if (access$getBinding$p4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordSummaryFragmentLayoutBinding = access$getBinding$p4;
            }
            fastRecordSummaryFragmentLayoutBinding.o.setVisibility(4);
            this.this$0.showFeedBackState(false);
            this.this$0.refreshViewShow(true);
            this.this$0.setBottomBtnState();
        } else if (num != null && num.intValue() == 2) {
            FastRecordSummaryFragmentLayoutBinding access$getBinding$p5 = this.this$0.binding;
            if (access$getBinding$p5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordSummaryFragmentLayoutBinding = access$getBinding$p5;
            }
            fastRecordSummaryFragmentLayoutBinding.o.setVisibility(4);
            this.this$0.showFeedBackState(false);
            this.this$0.refreshViewShow(true);
            UToast.Companion companion2 = UToast.f6444a;
            FragmentActivity requireActivity2 = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
            String string2 = this.this$0.getString(R.string.fr_extract_fialed);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            companion2.d(requireActivity2, string2);
        }
    }
}
