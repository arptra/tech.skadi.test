package com.upuphone.ar.fastrecord.phone.ui.fragment;

import com.upuphone.ar.fastrecord.databinding.FastRecordSummaryFragmentLayoutBinding;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordLoadingView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nFastRecordSummaryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordSummaryFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment$initViewModel$4\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,429:1\n302#2:430\n*S KotlinDebug\n*F\n+ 1 FastRecordSummaryFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment$initViewModel$4\n*L\n314#1:430\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSummaryFragment$initViewModel$4 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ FastRecordSummaryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordSummaryFragment$initViewModel$4(FastRecordSummaryFragment fastRecordSummaryFragment) {
        super(1);
        this.this$0 = fastRecordSummaryFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        FastRecordSummaryFragmentLayoutBinding access$getBinding$p = this.this$0.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        FastRecordLoadingView fastRecordLoadingView = access$getBinding$p.j;
        Intrinsics.checkNotNullExpressionValue(fastRecordLoadingView, "summaryExtractLoading");
        boolean z = fastRecordLoadingView.getVisibility() == 8;
        LogExt.logE("summaryEditModeLiveData isNotLoadingData = " + z, "SummaryFragment");
        if (z) {
            this.this$0.exitEditMode();
        }
    }
}
