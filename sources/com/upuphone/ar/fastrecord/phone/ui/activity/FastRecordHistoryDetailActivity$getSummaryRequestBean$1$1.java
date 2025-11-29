package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.text.TextUtils;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel;
import com.upuphone.ar.fastrecord.phone.utils.RecordConstants;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "entity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordHistoryDetailActivity$getSummaryRequestBean$1$1 extends Lambda implements Function1<RecordEntity, Unit> {
    final /* synthetic */ Function1<SummaryRequestBean, Unit> $callBack;
    final /* synthetic */ FastRecordHistoryDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryDetailActivity$getSummaryRequestBean$1$1(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, Function1<? super SummaryRequestBean, Unit> function1) {
        super(1);
        this.this$0 = fastRecordHistoryDetailActivity;
        this.$callBack = function1;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity, boolean z, RecordEntity recordEntity, Function1 function1, SummaryRequestBean summaryRequestBean) {
        Intrinsics.checkNotNullParameter(fastRecordHistoryDetailActivity, "this$0");
        Intrinsics.checkNotNullParameter(recordEntity, "$entity");
        Intrinsics.checkNotNullParameter(function1, "$callBack");
        Intrinsics.checkNotNullParameter(summaryRequestBean, "$mSummaryRequestBean");
        boolean isHasAiData = fastRecordHistoryDetailActivity.getViewModel().isHasAiData();
        LogExt.logE("entity.shortHandText is empty do not invoke,viewModel.isHasAiData = " + isHasAiData + ",isAiWorking = " + z, "FastRecordHistoryDetailActivity");
        if (!TextUtils.isEmpty(recordEntity.getShortHandText()) || fastRecordHistoryDetailActivity.getViewModel().isHasAiData() || z) {
            function1.invoke(summaryRequestBean);
        } else {
            LogExt.logW("no need to ai page", "FastRecordHistoryDetailActivity");
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecordEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull RecordEntity recordEntity) {
        Intrinsics.checkNotNullParameter(recordEntity, "entity");
        SummaryRequestBean summaryRequestBean = new SummaryRequestBean();
        summaryRequestBean.setShortHandTitle(recordEntity.getShortHandTitle());
        summaryRequestBean.setRequestId(recordEntity.getRequestId());
        summaryRequestBean.setAppName(RecordConstants.APP_NAME);
        String requestId = recordEntity.getRequestId();
        UUID randomUUID = UUID.randomUUID();
        summaryRequestBean.setTraceId(requestId + randomUUID);
        summaryRequestBean.setAccountId(recordEntity.getAccountId());
        summaryRequestBean.setRecognizeId(recordEntity.getRecognizeId());
        summaryRequestBean.setRecordId(Long.valueOf(recordEntity.getRecordId()));
        FastRecordDetailRecordHistoryViewModel access$getViewModel = this.this$0.getViewModel();
        Long recordId = summaryRequestBean.getRecordId();
        Intrinsics.checkNotNullExpressionValue(recordId, "getRecordId(...)");
        boolean isAiWorking = access$getViewModel.isAiWorking(recordId.longValue());
        FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity = this.this$0;
        fastRecordHistoryDetailActivity.runOnUiThread(new b(fastRecordHistoryDetailActivity, isAiWorking, recordEntity, this.$callBack, summaryRequestBean));
    }
}
