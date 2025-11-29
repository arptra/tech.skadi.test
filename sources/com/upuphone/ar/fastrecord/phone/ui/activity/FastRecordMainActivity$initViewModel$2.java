package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.view.View;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nFastRecordMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordMainActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity$initViewModel$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,558:1\n262#2,2:559\n262#2,2:561\n*S KotlinDebug\n*F\n+ 1 FastRecordMainActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity$initViewModel$2\n*L\n327#1:559,2\n334#1:561,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordMainActivity$initViewModel$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ FastRecordMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainActivity$initViewModel$2(FastRecordMainActivity fastRecordMainActivity) {
        super(1);
        this.this$0 = fastRecordMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        FastRecordMainViewModel access$getViewModel$p = this.this$0.viewModel;
        if (access$getViewModel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            access$getViewModel$p = null;
        }
        String curPage = access$getViewModel$p.getCurPage();
        LogExt.logV("mPageStatus = " + num + ",curPage = " + curPage, "FastRecordMainActivity");
        if (num != null && num.intValue() == 1) {
            this.this$0.setPageChooseMode(true);
            View view = this.this$0.getLayout().b.f;
            Intrinsics.checkNotNullExpressionValue(view, "vTranDownload");
            view.setVisibility(0);
            this.this$0.getLayout().i.setCanMove(false);
        } else if (num != null && num.intValue() == 2) {
            this.this$0.setPageChooseMode(false);
            View view2 = this.this$0.getLayout().b.f;
            Intrinsics.checkNotNullExpressionValue(view2, "vTranDownload");
            view2.setVisibility(8);
            this.this$0.getLayout().i.setCanMove(true);
        }
    }
}
