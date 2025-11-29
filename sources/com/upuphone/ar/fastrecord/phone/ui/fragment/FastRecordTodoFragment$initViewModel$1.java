package com.upuphone.ar.fastrecord.phone.ui.fragment;

import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordTodoFragmentLayoutBinding;
import com.upuphone.star.common.phone.UToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nFastRecordTodoFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTodoFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment$initViewModel$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,475:1\n262#2,2:476\n*S KotlinDebug\n*F\n+ 1 FastRecordTodoFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment$initViewModel$1\n*L\n290#1:476,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTodoFragment$initViewModel$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ FastRecordTodoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTodoFragment$initViewModel$1(FastRecordTodoFragment fastRecordTodoFragment) {
        super(1);
        this.this$0 = fastRecordTodoFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        FastRecordTodoFragmentLayoutBinding access$getBinding$p = this.this$0.binding;
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding = null;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.g.setVisibility(8);
        FastRecordTodoFragmentLayoutBinding access$getBinding$p2 = this.this$0.binding;
        if (access$getBinding$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p2 = null;
        }
        TextView textView = access$getBinding$p2.i;
        Intrinsics.checkNotNullExpressionValue(textView, "tvExtractTip");
        textView.setVisibility(8);
        if (num != null && num.intValue() == 0) {
            FastRecordTodoFragmentLayoutBinding access$getBinding$p3 = this.this$0.binding;
            if (access$getBinding$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p3 = null;
            }
            access$getBinding$p3.f.setVisibility(8);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p4 = this.this$0.binding;
            if (access$getBinding$p4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p4 = null;
            }
            access$getBinding$p4.l.setVisibility(8);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p5 = this.this$0.binding;
            if (access$getBinding$p5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p5 = null;
            }
            access$getBinding$p5.c.setVisibility(8);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p6 = this.this$0.binding;
            if (access$getBinding$p6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p6 = null;
            }
            access$getBinding$p6.d.setVisibility(8);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p7 = this.this$0.binding;
            if (access$getBinding$p7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p7 = null;
            }
            access$getBinding$p7.h.setVisibility(0);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p8 = this.this$0.binding;
            if (access$getBinding$p8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordTodoFragmentLayoutBinding = access$getBinding$p8;
            }
            fastRecordTodoFragmentLayoutBinding.k.setVisibility(0);
            this.this$0.showFeedBackState(true);
        } else if (num != null && num.intValue() == 1) {
            FastRecordTodoFragmentLayoutBinding access$getBinding$p9 = this.this$0.binding;
            if (access$getBinding$p9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p9 = null;
            }
            access$getBinding$p9.f.setVisibility(0);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p10 = this.this$0.binding;
            if (access$getBinding$p10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p10 = null;
            }
            access$getBinding$p10.l.setVisibility(0);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p11 = this.this$0.binding;
            if (access$getBinding$p11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p11 = null;
            }
            access$getBinding$p11.c.setVisibility(0);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p12 = this.this$0.binding;
            if (access$getBinding$p12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p12 = null;
            }
            access$getBinding$p12.d.setVisibility(0);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p13 = this.this$0.binding;
            if (access$getBinding$p13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p13 = null;
            }
            access$getBinding$p13.h.setVisibility(8);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p14 = this.this$0.binding;
            if (access$getBinding$p14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordTodoFragmentLayoutBinding = access$getBinding$p14;
            }
            fastRecordTodoFragmentLayoutBinding.k.setVisibility(4);
            this.this$0.showFeedBackState(false);
            this.this$0.setBottomBtnState();
            UToast.Companion companion = UToast.f6444a;
            FragmentActivity requireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            String string = this.this$0.getString(R.string.fr_extract_todo_no);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(requireActivity, string);
        } else if (num != null && num.intValue() == 2) {
            FastRecordTodoFragmentLayoutBinding access$getBinding$p15 = this.this$0.binding;
            if (access$getBinding$p15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p15 = null;
            }
            access$getBinding$p15.f.setVisibility(0);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p16 = this.this$0.binding;
            if (access$getBinding$p16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p16 = null;
            }
            access$getBinding$p16.l.setVisibility(0);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p17 = this.this$0.binding;
            if (access$getBinding$p17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p17 = null;
            }
            access$getBinding$p17.c.setVisibility(0);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p18 = this.this$0.binding;
            if (access$getBinding$p18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p18 = null;
            }
            access$getBinding$p18.d.setVisibility(0);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p19 = this.this$0.binding;
            if (access$getBinding$p19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p19 = null;
            }
            access$getBinding$p19.h.setVisibility(8);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p20 = this.this$0.binding;
            if (access$getBinding$p20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordTodoFragmentLayoutBinding = access$getBinding$p20;
            }
            fastRecordTodoFragmentLayoutBinding.k.setVisibility(4);
            this.this$0.showFeedBackState(false);
            this.this$0.setBottomBtnState();
            UToast.Companion companion2 = UToast.f6444a;
            FragmentActivity requireActivity2 = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
            String string2 = this.this$0.getString(R.string.fr_extract_fialed);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            companion2.d(requireActivity2, string2);
        } else if (num != null && num.intValue() == 3) {
            FastRecordTodoFragmentLayoutBinding access$getBinding$p21 = this.this$0.binding;
            if (access$getBinding$p21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p21 = null;
            }
            access$getBinding$p21.f.setVisibility(0);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p22 = this.this$0.binding;
            if (access$getBinding$p22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p22 = null;
            }
            access$getBinding$p22.l.setVisibility(0);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p23 = this.this$0.binding;
            if (access$getBinding$p23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p23 = null;
            }
            access$getBinding$p23.c.setVisibility(0);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p24 = this.this$0.binding;
            if (access$getBinding$p24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p24 = null;
            }
            access$getBinding$p24.d.setVisibility(0);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p25 = this.this$0.binding;
            if (access$getBinding$p25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p25 = null;
            }
            access$getBinding$p25.h.setVisibility(8);
            FastRecordTodoFragmentLayoutBinding access$getBinding$p26 = this.this$0.binding;
            if (access$getBinding$p26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordTodoFragmentLayoutBinding = access$getBinding$p26;
            }
            fastRecordTodoFragmentLayoutBinding.k.setVisibility(4);
            this.this$0.showFeedBackState(false);
            this.this$0.setBottomBtnState();
        }
    }
}
