package com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai;

import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiSummaryOperatorManager;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nFastRecordAiSummaryOperatorManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordAiSummaryOperatorManager.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiSummaryOperatorManager$startAiSummaryOperator$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,171:1\n1855#2,2:172\n*S KotlinDebug\n*F\n+ 1 FastRecordAiSummaryOperatorManager.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiSummaryOperatorManager$startAiSummaryOperator$2\n*L\n115#1:172,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "recognizeId", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordAiSummaryOperatorManager$startAiSummaryOperator$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ SummaryRequestBean $mSummaryRequestBean;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordAiSummaryOperatorManager$startAiSummaryOperator$2(SummaryRequestBean summaryRequestBean) {
        super(1);
        this.$mSummaryRequestBean = summaryRequestBean;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        FastRecordAiSummaryOperatorManager.AiSummaryCallbackInterface aiSummaryCallbackInterface = (FastRecordAiSummaryOperatorManager.AiSummaryCallbackInterface) FastRecordAiSummaryOperatorManager.callBackMap.get(str);
        if (aiSummaryCallbackInterface != null) {
            aiSummaryCallbackInterface.onGetSummarySuccess(str);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<Number> arrayList2 = (ArrayList) FastRecordAiSummaryOperatorManager._recordAiSummaryFinishData.getValue();
        if (arrayList2 != null) {
            for (Number longValue : arrayList2) {
                arrayList.add(Long.valueOf(longValue.longValue()));
            }
        }
        arrayList.add(this.$mSummaryRequestBean.getRecordId());
        FastRecordAiSummaryOperatorManager._recordAiSummaryFinishData.postValue(arrayList);
        FastRecordAiSummaryOperatorManager fastRecordAiSummaryOperatorManager = FastRecordAiSummaryOperatorManager.INSTANCE;
        String recognizeId = this.$mSummaryRequestBean.getRecognizeId();
        Intrinsics.checkNotNullExpressionValue(recognizeId, "getRecognizeId(...)");
        fastRecordAiSummaryOperatorManager.removeWorkingTask(recognizeId);
        fastRecordAiSummaryOperatorManager.startWaitTask();
    }
}
