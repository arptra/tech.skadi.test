package com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai;

import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperatorManager;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nFastRecordAiTodoOperatorManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordAiTodoOperatorManager.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiTodoOperatorManager$startAiTodoOperator$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,168:1\n1855#2,2:169\n*S KotlinDebug\n*F\n+ 1 FastRecordAiTodoOperatorManager.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiTodoOperatorManager$startAiTodoOperator$2\n*L\n99#1:169,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordAiTodoOperatorManager$startAiTodoOperator$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ SummaryRequestBean $mSummaryRequestBean;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordAiTodoOperatorManager$startAiTodoOperator$2(SummaryRequestBean summaryRequestBean) {
        super(1);
        this.$mSummaryRequestBean = summaryRequestBean;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        FastRecordAiTodoOperatorManager.AiTodoCallbackInterface aiTodoCallbackInterface = (FastRecordAiTodoOperatorManager.AiTodoCallbackInterface) FastRecordAiTodoOperatorManager.callBackMap.get(str);
        if (aiTodoCallbackInterface != null) {
            aiTodoCallbackInterface.onGetToDoSuccess(str);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<Number> arrayList2 = (ArrayList) FastRecordAiTodoOperatorManager._recordAiTodFinishData.getValue();
        if (arrayList2 != null) {
            for (Number longValue : arrayList2) {
                arrayList.add(Long.valueOf(longValue.longValue()));
            }
        }
        arrayList.add(this.$mSummaryRequestBean.getRecordId());
        FastRecordAiTodoOperatorManager._recordAiTodFinishData.postValue(arrayList);
        FastRecordAiTodoOperatorManager fastRecordAiTodoOperatorManager = FastRecordAiTodoOperatorManager.INSTANCE;
        String recognizeId = this.$mSummaryRequestBean.getRecognizeId();
        Intrinsics.checkNotNullExpressionValue(recognizeId, "getRecognizeId(...)");
        fastRecordAiTodoOperatorManager.removeWorkingTask(recognizeId);
        fastRecordAiTodoOperatorManager.startWaitTask();
    }
}
