package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.view.View;
import android.widget.TextView;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nFastRecordMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordMainActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity$initViewModel$3\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,558:1\n262#2,2:559\n*S KotlinDebug\n*F\n+ 1 FastRecordMainActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity$initViewModel$3\n*L\n354#1:559,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000120\u0010\u0002\u001a,\u0012\u0004\u0012\u00020\u0004 \u0006*\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00050\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "Lkotlin/collections/ArrayList;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordMainActivity$initViewModel$3 extends Lambda implements Function1<ArrayList<RecordEntity>, Unit> {
    final /* synthetic */ FastRecordMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainActivity$initViewModel$3(FastRecordMainActivity fastRecordMainActivity) {
        super(1);
        this.this$0 = fastRecordMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<RecordEntity>) (ArrayList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ArrayList<RecordEntity> arrayList) {
        int size = arrayList.size();
        FastRecordMainViewModel fastRecordMainViewModel = null;
        if (size == 0) {
            this.this$0.getLayout().h.c.setText(this.this$0.getString(R.string.please_choose_record_item));
        } else {
            TextView textView = this.this$0.getLayout().h.c;
            FastRecordMainActivity fastRecordMainActivity = this.this$0;
            int i = R.string.fast_choose_num;
            FastRecordMainViewModel access$getViewModel$p = fastRecordMainActivity.viewModel;
            if (access$getViewModel$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                access$getViewModel$p = null;
            }
            textView.setText(fastRecordMainActivity.getString(i, new Object[]{Integer.valueOf(access$getViewModel$p.getChooseRecordEntityListSize())}));
        }
        LogExt.logW("mChooseRecordEntityList size = " + size, "FastRecordMainActivity");
        View view = this.this$0.getLayout().e.d;
        Intrinsics.checkNotNullExpressionValue(view, "vUnEnable");
        int i2 = 0;
        if (!(size == 0)) {
            i2 = 8;
        }
        view.setVisibility(i2);
        FastRecordMainViewModel access$getViewModel$p2 = this.this$0.viewModel;
        if (access$getViewModel$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            access$getViewModel$p2 = null;
        }
        int chooseRecordEntityListSize = access$getViewModel$p2.getChooseRecordEntityListSize();
        FastRecordMainViewModel access$getViewModel$p3 = this.this$0.viewModel;
        if (access$getViewModel$p3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordMainViewModel = access$getViewModel$p3;
        }
        if (chooseRecordEntityListSize != fastRecordMainViewModel.getCurPageItemSize()) {
            this.this$0.getLayout().h.e.setText(this.this$0.getString(R.string.fast_all_select));
        } else {
            this.this$0.getLayout().h.e.setText(this.this$0.getString(R.string.fast_all_no_select));
        }
    }
}
