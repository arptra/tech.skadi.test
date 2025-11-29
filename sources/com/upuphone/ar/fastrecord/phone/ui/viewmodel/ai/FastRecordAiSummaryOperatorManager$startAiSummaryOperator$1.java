package com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai;

import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiSummaryOperatorManager;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "recognizeId", "", "data", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordAiSummaryOperatorManager$startAiSummaryOperator$1 extends Lambda implements Function2<String, SensitivePayload, Unit> {
    final /* synthetic */ SummaryRequestBean $mSummaryRequestBean;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordAiSummaryOperatorManager$startAiSummaryOperator$1(SummaryRequestBean summaryRequestBean) {
        super(2);
        this.$mSummaryRequestBean = summaryRequestBean;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (SensitivePayload) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @Nullable SensitivePayload sensitivePayload) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        FastRecordAiSummaryOperatorManager.AiSummaryCallbackInterface aiSummaryCallbackInterface = (FastRecordAiSummaryOperatorManager.AiSummaryCallbackInterface) FastRecordAiSummaryOperatorManager.callBackMap.get(str);
        if (aiSummaryCallbackInterface != null) {
            aiSummaryCallbackInterface.onSummarySensitive(str, sensitivePayload);
        }
        FastRecordAiSummaryOperatorManager fastRecordAiSummaryOperatorManager = FastRecordAiSummaryOperatorManager.INSTANCE;
        String recognizeId = this.$mSummaryRequestBean.getRecognizeId();
        Intrinsics.checkNotNullExpressionValue(recognizeId, "getRecognizeId(...)");
        fastRecordAiSummaryOperatorManager.removeWorkingTask(recognizeId);
        fastRecordAiSummaryOperatorManager.startWaitTask();
    }
}
