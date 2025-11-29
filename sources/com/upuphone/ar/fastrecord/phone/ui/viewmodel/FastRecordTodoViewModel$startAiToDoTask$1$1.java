package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperatorManager;
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

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel$startAiToDoTask$1$1", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiTodoOperatorManager$AiTodoCallbackInterface;", "onGetToDoFail", "", "recognizeId", "", "code", "", "onGetToDoSuccess", "onTodoSensitive", "sensitive", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTodoViewModel$startAiToDoTask$1$1 implements FastRecordAiTodoOperatorManager.AiTodoCallbackInterface {
    final /* synthetic */ SummaryRequestBean $data;
    final /* synthetic */ FastRecordTodoViewModel this$0;

    public FastRecordTodoViewModel$startAiToDoTask$1$1(SummaryRequestBean summaryRequestBean, FastRecordTodoViewModel fastRecordTodoViewModel) {
        this.$data = summaryRequestBean;
        this.this$0 = fastRecordTodoViewModel;
    }

    public void onGetToDoFail(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        FastRecordAiTodoOperatorManager.AiTodoCallbackInterface.DefaultImpls.onGetToDoFail(this, str, i);
        LogExt.logE("onGetToDoFail  recognizeId = " + str + ",code = " + i, "TodoViewModel");
        if (Intrinsics.areEqual((Object) this.$data.getRecognizeId(), (Object) str)) {
            LogExt.logE("onGetToDoFail post value", "TodoViewModel");
            this.this$0._mTodoResult.postValue(Integer.valueOf(i));
        }
    }

    public void onGetToDoSuccess(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        FastRecordAiTodoOperatorManager.AiTodoCallbackInterface.DefaultImpls.onGetToDoSuccess(this, str);
        LogExt.logE("onGetToDoSuccess  recognizeId = " + str + ",code = success", "TodoViewModel");
        if (Intrinsics.areEqual((Object) this.$data.getRecognizeId(), (Object) str)) {
            LogExt.logE("onGetToDoSuccess post value", "TodoViewModel");
            this.this$0.getTodoListFromLocal(FastRecordTodoViewModel$startAiToDoTask$1$1$onGetToDoSuccess$1.INSTANCE);
        }
    }

    public void onTodoSensitive(@NotNull String str, @Nullable SensitivePayload sensitivePayload) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        FastRecordAiTodoOperatorManager.AiTodoCallbackInterface.DefaultImpls.onTodoSensitive(this, str, sensitivePayload);
        if (Intrinsics.areEqual((Object) this.$data.getRecognizeId(), (Object) str)) {
            LogExt.logE("onGetToDoFail post value", "TodoViewModel");
            Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this.this$0), Dispatchers.c(), (CoroutineStart) null, new FastRecordTodoViewModel$startAiToDoTask$1$1$onTodoSensitive$1(sensitivePayload, this.this$0, (Continuation<? super FastRecordTodoViewModel$startAiToDoTask$1$1$onTodoSensitive$1>) null), 2, (Object) null);
        }
    }
}
