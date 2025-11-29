package com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai;

import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperatorManager;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "recognizeId", "", "code", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordAiTodoOperatorManager$startAiTodoOperator$3 extends Lambda implements Function2<String, Integer, Unit> {
    final /* synthetic */ SummaryRequestBean $mSummaryRequestBean;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordAiTodoOperatorManager$startAiTodoOperator$3(SummaryRequestBean summaryRequestBean) {
        super(2);
        this.$mSummaryRequestBean = summaryRequestBean;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        FastRecordAiTodoOperatorManager.AiTodoCallbackInterface aiTodoCallbackInterface = (FastRecordAiTodoOperatorManager.AiTodoCallbackInterface) FastRecordAiTodoOperatorManager.callBackMap.get(str);
        if (aiTodoCallbackInterface != null) {
            aiTodoCallbackInterface.onGetToDoFail(str, i);
        }
        FastRecordAiTodoOperatorManager fastRecordAiTodoOperatorManager = FastRecordAiTodoOperatorManager.INSTANCE;
        String recognizeId = this.$mSummaryRequestBean.getRecognizeId();
        Intrinsics.checkNotNullExpressionValue(recognizeId, "getRecognizeId(...)");
        fastRecordAiTodoOperatorManager.removeWorkingTask(recognizeId);
        fastRecordAiTodoOperatorManager.startWaitTask();
    }
}
