package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.text.TextUtils;
import android.widget.ImageView;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.utils.RecordDateUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nFastRecordHistoryDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordHistoryDetailActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity$initViewModel$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,1520:1\n262#2,2:1521\n*S KotlinDebug\n*F\n+ 1 FastRecordHistoryDetailActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordHistoryDetailActivity$initViewModel$1\n*L\n1236#1:1521,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$initViewModel$1 extends Lambda implements Function1<RecordEntity, Unit> {
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$initViewModel$1(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        super(1);
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecordEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RecordEntity recordEntity) {
        if (recordEntity != null) {
            FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity = this.this$0;
            fastRecordHistoryDetailActivity.getLayout().k.g.setText(recordEntity.getLocation());
            if (TextUtils.isEmpty(recordEntity.getLocation())) {
                ImageView imageView = fastRecordHistoryDetailActivity.getLayout().k.b;
                Intrinsics.checkNotNullExpressionValue(imageView, "ivSplit");
                imageView.setVisibility(8);
            }
            fastRecordHistoryDetailActivity.getLayout().k.f.setText(RecordDateUtil.INSTANCE.formatRecordDate(recordEntity.getCreateTime()));
            fastRecordHistoryDetailActivity.getLayout().k.e.getTitle().setText(recordEntity.getShortHandTitle());
            fastRecordHistoryDetailActivity.getLayout().k.h.setText("0:00:00");
            fastRecordHistoryDetailActivity.showAiAndCopyImage(fastRecordHistoryDetailActivity.getViewModel().isCanStartAiAsr());
            if (fastRecordHistoryDetailActivity.getViewModel().isFinishAsr()) {
                long recordId = recordEntity.getRecordId();
                LogExt.logE("isFinishAsr show content entiy.recordId = " + recordId, "FastRecordHistoryDetailActivity");
                fastRecordHistoryDetailActivity.checkMergeVoice(recordEntity);
            } else if (!recordEntity.isFinishFileMerge()) {
                fastRecordHistoryDetailActivity.getViewModel().mergeVoice(recordEntity, recordEntity.getType(), false);
            } else {
                fastRecordHistoryDetailActivity.initMediaAndShowNormalState();
            }
        }
    }
}
