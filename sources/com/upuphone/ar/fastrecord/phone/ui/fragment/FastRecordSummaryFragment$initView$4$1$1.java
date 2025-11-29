package com.upuphone.ar.fastrecord.phone.ui.fragment;

import android.widget.ImageView;
import android.widget.TextView;
import com.upuphone.ar.fastrecord.databinding.FastRecordSummaryFragmentLayoutBinding;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordSummaryViewModel;
import com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse;
import com.upuphone.xr.audio.record.ai.feedback.ReportCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nFastRecordSummaryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordSummaryFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment$initView$4$1$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,429:1\n262#2,2:430\n262#2,2:432\n*S KotlinDebug\n*F\n+ 1 FastRecordSummaryFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment$initView$4$1$1\n*L\n152#1:430,2\n153#1:432,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment$initView$4$1$1", "Lcom/upuphone/xr/audio/record/ai/feedback/ReportCallback;", "onFail", "", "result", "Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackResponse;", "onSuccess", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSummaryFragment$initView$4$1$1 implements ReportCallback {
    final /* synthetic */ FastRecordSummaryFragment this$0;

    public FastRecordSummaryFragment$initView$4$1$1(FastRecordSummaryFragment fastRecordSummaryFragment) {
        this.this$0 = fastRecordSummaryFragment;
    }

    public void onFail(@NotNull AiFeedBackResponse aiFeedBackResponse) {
        Intrinsics.checkNotNullParameter(aiFeedBackResponse, "result");
        LogExt.logE("onFail result = " + aiFeedBackResponse, "SummaryFragment");
    }

    public void onSuccess(@NotNull AiFeedBackResponse aiFeedBackResponse) {
        Intrinsics.checkNotNullParameter(aiFeedBackResponse, "result");
        LogExt.logE("onSuccess result = " + aiFeedBackResponse, "SummaryFragment");
        FastRecordSummaryFragmentLayoutBinding access$getBinding$p = this.this$0.binding;
        FastRecordSummaryViewModel fastRecordSummaryViewModel = null;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        ImageView imageView = access$getBinding$p.e;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivFeedback");
        imageView.setVisibility(8);
        FastRecordSummaryFragmentLayoutBinding access$getBinding$p2 = this.this$0.binding;
        if (access$getBinding$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p2 = null;
        }
        TextView textView = access$getBinding$p2.n;
        Intrinsics.checkNotNullExpressionValue(textView, "tvFeedback");
        textView.setVisibility(0);
        FastRecordSummaryViewModel access$getViewModel$p = this.this$0.viewModel;
        if (access$getViewModel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordSummaryViewModel = access$getViewModel$p;
        }
        fastRecordSummaryViewModel.updateReportStateSuccess();
    }
}
