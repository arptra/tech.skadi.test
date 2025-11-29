package com.upuphone.ar.fastrecord.phone.ui.fragment;

import android.widget.ImageView;
import android.widget.TextView;
import com.upuphone.ar.fastrecord.databinding.FastRecordTodoFragmentLayoutBinding;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel;
import com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse;
import com.upuphone.xr.audio.record.ai.feedback.ReportCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nFastRecordTodoFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTodoFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment$initTodoView$3$1$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,475:1\n262#2,2:476\n262#2,2:478\n*S KotlinDebug\n*F\n+ 1 FastRecordTodoFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment$initTodoView$3$1$1\n*L\n127#1:476,2\n128#1:478,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment$initTodoView$3$1$1", "Lcom/upuphone/xr/audio/record/ai/feedback/ReportCallback;", "onFail", "", "result", "Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackResponse;", "onSuccess", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTodoFragment$initTodoView$3$1$1 implements ReportCallback {
    final /* synthetic */ FastRecordTodoFragment this$0;

    public FastRecordTodoFragment$initTodoView$3$1$1(FastRecordTodoFragment fastRecordTodoFragment) {
        this.this$0 = fastRecordTodoFragment;
    }

    public void onFail(@NotNull AiFeedBackResponse aiFeedBackResponse) {
        Intrinsics.checkNotNullParameter(aiFeedBackResponse, "result");
        LogExt.logE("onFail result = " + aiFeedBackResponse, "TodoFragment");
    }

    public void onSuccess(@NotNull AiFeedBackResponse aiFeedBackResponse) {
        Intrinsics.checkNotNullParameter(aiFeedBackResponse, "result");
        LogExt.logE("onSuccess result = " + aiFeedBackResponse, "TodoFragment");
        FastRecordTodoViewModel access$getViewModel$p = this.this$0.viewModel;
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding = null;
        if (access$getViewModel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            access$getViewModel$p = null;
        }
        access$getViewModel$p.updateReportStateSuccess();
        FastRecordTodoFragmentLayoutBinding access$getBinding$p = this.this$0.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        ImageView imageView = access$getBinding$p.b;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivFeedback");
        imageView.setVisibility(8);
        FastRecordTodoFragmentLayoutBinding access$getBinding$p2 = this.this$0.binding;
        if (access$getBinding$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordTodoFragmentLayoutBinding = access$getBinding$p2;
        }
        TextView textView = fastRecordTodoFragmentLayoutBinding.j;
        Intrinsics.checkNotNullExpressionValue(textView, "tvFeedback");
        textView.setVisibility(0);
    }
}
