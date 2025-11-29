package com.upuphone.ar.fastrecord.phone.ui.activity;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "data", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$initAiSummaryStateObserver$1 extends Lambda implements Function1<ArrayList<Long>, Unit> {
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$initAiSummaryStateObserver$1(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        super(1);
        this.this$0 = fastRecordHistoryDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<Long>) (ArrayList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ArrayList<Long> arrayList) {
        RecordEntity curRecordEntity = this.this$0.getViewModel().getCurRecordEntity();
        if (curRecordEntity != null) {
            FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity = this.this$0;
            if (arrayList != null) {
                LogExt.logW("recordAiSummaryFinish list id = " + arrayList, "FastRecordHistoryDetailActivity");
            }
            long recordId = curRecordEntity.getRecordId();
            LogExt.logW("recordAiSummaryFinish curRecord recordId = " + recordId, "FastRecordHistoryDetailActivity");
            if (arrayList != null && arrayList.contains(Long.valueOf(curRecordEntity.getRecordId()))) {
                fastRecordHistoryDetailActivity.getViewModel().getSummaryAndTodoFromLocal(curRecordEntity.getRecordId());
            }
        }
    }
}
