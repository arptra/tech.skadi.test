package com.upuphone.ar.translation.phone.fragment;

import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.databinding.FragmentSummaryBinding;
import com.upuphone.ar.translation.phone.view.TranslatorLoadingView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nSummaryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SummaryFragment.kt\ncom/upuphone/ar/translation/phone/fragment/SummaryFragment$notAgreeAiState$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,678:1\n262#2,2:679\n262#2,2:681\n262#2,2:683\n*S KotlinDebug\n*F\n+ 1 SummaryFragment.kt\ncom/upuphone/ar/translation/phone/fragment/SummaryFragment$notAgreeAiState$1\n*L\n265#1:679,2\n266#1:681,2\n267#1:683,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isAgree", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SummaryFragment$notAgreeAiState$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ NoteBean $noteBean;
    final /* synthetic */ SummaryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SummaryFragment$notAgreeAiState$1(SummaryFragment summaryFragment, NoteBean noteBean) {
        super(1);
        this.this$0 = summaryFragment;
        this.$noteBean = noteBean;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        LogExt.j("getSummary requestAiModelPermission isAgree=" + z, "SummaryFragment");
        if (z) {
            FragmentSummaryBinding m0 = this.this$0.f6284a;
            FragmentSummaryBinding fragmentSummaryBinding = null;
            if (m0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                m0 = null;
            }
            Group group = m0.d;
            Intrinsics.checkNotNullExpressionValue(group, "gpSummaryTip");
            group.setVisibility(8);
            FragmentSummaryBinding m02 = this.this$0.f6284a;
            if (m02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                m02 = null;
            }
            TranslatorLoadingView translatorLoadingView = m02.f;
            Intrinsics.checkNotNullExpressionValue(translatorLoadingView, "loadingView");
            translatorLoadingView.setVisibility(0);
            FragmentSummaryBinding m03 = this.this$0.f6284a;
            if (m03 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentSummaryBinding = m03;
            }
            TextView textView = fragmentSummaryBinding.k;
            Intrinsics.checkNotNullExpressionValue(textView, "tvLoadingBackground");
            textView.setVisibility(0);
            this.this$0.z0().m(this.$noteBean);
        }
    }
}
