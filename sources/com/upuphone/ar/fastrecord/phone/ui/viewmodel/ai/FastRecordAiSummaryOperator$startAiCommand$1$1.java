package com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai;

import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import com.xjsd.xr.sapp.asr.callback.SmartExCallback;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.SmartExSummary;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiSummaryOperator$startAiCommand$1$1", "Lcom/xjsd/xr/sapp/asr/callback/SmartExCallback;", "onSummary", "", "summary", "Lcom/xjsd/xr/sapp/asr/dao/SmartExSummary;", "onSummarySensitive", "sensitive", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordAiSummaryOperator$startAiCommand$1$1 extends SmartExCallback {
    final /* synthetic */ SummaryRequestBean $requestBean;
    final /* synthetic */ FastRecordAiSummaryOperator this$0;

    public FastRecordAiSummaryOperator$startAiCommand$1$1(FastRecordAiSummaryOperator fastRecordAiSummaryOperator, SummaryRequestBean summaryRequestBean) {
        this.this$0 = fastRecordAiSummaryOperator;
        this.$requestBean = summaryRequestBean;
    }

    public void onSummary(@Nullable SmartExSummary smartExSummary) {
        String str = "";
        String str2 = null;
        if (smartExSummary == null) {
            Function2<String, Integer, Unit> aiResultFailCallback = this.this$0.getAiResultFailCallback();
            if (aiResultFailCallback != null) {
                SummaryRequestBean summaryRequestBean = this.$requestBean;
                if (summaryRequestBean != null) {
                    str2 = summaryRequestBean.getRecognizeId();
                }
                if (str2 != null) {
                    str = str2;
                }
                aiResultFailCallback.invoke(str, 2);
            }
        } else if (smartExSummary.getBaseStatus() != 0) {
            Function2<String, Integer, Unit> aiResultFailCallback2 = this.this$0.getAiResultFailCallback();
            if (aiResultFailCallback2 != null) {
                SummaryRequestBean summaryRequestBean2 = this.$requestBean;
                if (summaryRequestBean2 != null) {
                    str2 = summaryRequestBean2.getRecognizeId();
                }
                if (str2 != null) {
                    str = str2;
                }
                aiResultFailCallback2.invoke(str, 1);
            }
        } else if (smartExSummary.getSummary().length() == 0) {
            Function2<String, Integer, Unit> aiResultFailCallback3 = this.this$0.getAiResultFailCallback();
            if (aiResultFailCallback3 != null) {
                SummaryRequestBean summaryRequestBean3 = this.$requestBean;
                if (summaryRequestBean3 != null) {
                    str2 = summaryRequestBean3.getRecognizeId();
                }
                if (str2 != null) {
                    str = str2;
                }
                aiResultFailCallback3.invoke(str, 1);
            }
        } else {
            FastRecordAiSummaryOperator fastRecordAiSummaryOperator = this.this$0;
            fastRecordAiSummaryOperator.insertSummary(fastRecordAiSummaryOperator.summaryBeanToEntity(this.$requestBean, smartExSummary.getSummary(), smartExSummary.getVersionCode(), smartExSummary.getRequestId()));
        }
    }

    public void onSummarySensitive(@Nullable SensitivePayload sensitivePayload) {
        super.onTodoSensitive(sensitivePayload);
        Function2<String, SensitivePayload, Unit> aiSensitiveFailCallback = this.this$0.getAiSensitiveFailCallback();
        if (aiSensitiveFailCallback != null) {
            SummaryRequestBean summaryRequestBean = this.$requestBean;
            String recognizeId = summaryRequestBean != null ? summaryRequestBean.getRecognizeId() : null;
            if (recognizeId == null) {
                recognizeId = "";
            }
            aiSensitiveFailCallback.invoke(recognizeId, sensitivePayload);
        }
    }
}
