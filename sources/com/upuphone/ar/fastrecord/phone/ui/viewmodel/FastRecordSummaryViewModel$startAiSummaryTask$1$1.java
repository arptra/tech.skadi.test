package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiSummaryOperatorManager;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordSummaryViewModel$startAiSummaryTask$1$1", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiSummaryOperatorManager$AiSummaryCallbackInterface;", "onGetSummaryFail", "", "recognizeId", "", "code", "", "onGetSummarySuccess", "onSummarySensitive", "sensitive", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSummaryViewModel$startAiSummaryTask$1$1 implements FastRecordAiSummaryOperatorManager.AiSummaryCallbackInterface {
    final /* synthetic */ SummaryRequestBean $data;
    final /* synthetic */ FastRecordSummaryViewModel this$0;

    public FastRecordSummaryViewModel$startAiSummaryTask$1$1(SummaryRequestBean summaryRequestBean, FastRecordSummaryViewModel fastRecordSummaryViewModel) {
        this.$data = summaryRequestBean;
        this.this$0 = fastRecordSummaryViewModel;
    }

    public void onGetSummaryFail(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        FastRecordAiSummaryOperatorManager.AiSummaryCallbackInterface.DefaultImpls.onGetSummaryFail(this, str, i);
        LogExt.logE("onGetSummaryFail  recognizeId = " + str + ",code = " + i, "SummaryViewModel");
        if (Intrinsics.areEqual((Object) this.$data.getRecognizeId(), (Object) str)) {
            LogExt.logE("_mSummaryResult post value", "SummaryViewModel");
            this.this$0._mSummaryResult.postValue(Integer.valueOf(i));
        }
    }

    public void onGetSummarySuccess(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        FastRecordAiSummaryOperatorManager.AiSummaryCallbackInterface.DefaultImpls.onGetSummarySuccess(this, str);
        LogExt.logE("onGetSummarySuccess  recognizeId = " + str + ",success", "SummaryViewModel");
        if (Intrinsics.areEqual((Object) this.$data.getRecognizeId(), (Object) str)) {
            LogExt.logE("onGetSummarySuccess data.recognizeId == recognizeId", "SummaryViewModel");
            this.this$0.getSummaryFromLocal();
            this.this$0._mSummaryResult.postValue(0);
        }
    }

    public void onSummarySensitive(@NotNull String str, @Nullable SensitivePayload sensitivePayload) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        FastRecordAiSummaryOperatorManager.AiSummaryCallbackInterface.DefaultImpls.onSummarySensitive(this, str, sensitivePayload);
        LogExt.logE("onSummarySensitive  recognizeId = " + str + ",sensitive = " + sensitivePayload, "SummaryViewModel");
        if (!Intrinsics.areEqual((Object) this.$data.getRecognizeId(), (Object) str)) {
            LogExt.logE("onSummarySensitive data.recognizeId != recognizeId", "SummaryViewModel");
        } else {
            Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this.this$0), Dispatchers.c(), (CoroutineStart) null, new FastRecordSummaryViewModel$startAiSummaryTask$1$1$onSummarySensitive$1(sensitivePayload, this.this$0, (Continuation<? super FastRecordSummaryViewModel$startAiSummaryTask$1$1$onSummarySensitive$1>) null), 2, (Object) null);
        }
    }
}
