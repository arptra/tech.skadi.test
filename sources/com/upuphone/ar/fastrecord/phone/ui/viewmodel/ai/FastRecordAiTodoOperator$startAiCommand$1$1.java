package com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import com.xjsd.xr.sapp.asr.callback.SmartExCallback;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.SmartExTodo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiTodoOperator$startAiCommand$1$1", "Lcom/xjsd/xr/sapp/asr/callback/SmartExCallback;", "onTodo", "", "exTodo", "Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo;", "onTodoSensitive", "sensitive", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordAiTodoOperator$startAiCommand$1$1 extends SmartExCallback {
    final /* synthetic */ FastRecordAiTodoOperator this$0;

    public FastRecordAiTodoOperator$startAiCommand$1$1(FastRecordAiTodoOperator fastRecordAiTodoOperator) {
        this.this$0 = fastRecordAiTodoOperator;
    }

    public void onTodo(@Nullable SmartExTodo smartExTodo) {
        super.onTodo(smartExTodo);
        String str = "";
        String str2 = null;
        if (smartExTodo == null) {
            LogExt.logE("exTodo is null", "FastRecordAiTodoOperator");
            Function2<String, Integer, Unit> aiResultFailCallback = this.this$0.getAiResultFailCallback();
            if (aiResultFailCallback != null) {
                SummaryRequestBean access$getMTodoRequestBean$p = this.this$0.mTodoRequestBean;
                if (access$getMTodoRequestBean$p != null) {
                    str2 = access$getMTodoRequestBean$p.getRecognizeId();
                }
                if (str2 != null) {
                    str = str2;
                }
                aiResultFailCallback.invoke(str, 2);
                return;
            }
            return;
        }
        LogExt.logE("getTodoByServer todo=" + smartExTodo, "FastRecordAiTodoOperator");
        if (smartExTodo.getTodoList().isEmpty() || smartExTodo.getBaseStatus() != 0) {
            Function2<String, Integer, Unit> aiResultFailCallback2 = this.this$0.getAiResultFailCallback();
            if (aiResultFailCallback2 != null) {
                SummaryRequestBean access$getMTodoRequestBean$p2 = this.this$0.mTodoRequestBean;
                if (access$getMTodoRequestBean$p2 != null) {
                    str2 = access$getMTodoRequestBean$p2.getRecognizeId();
                }
                if (str2 != null) {
                    str = str2;
                }
                aiResultFailCallback2.invoke(str, 1);
                return;
            }
            return;
        }
        this.this$0.commandTodoList(smartExTodo.getTodoList(), smartExTodo.getRequestId());
    }

    public void onTodoSensitive(@Nullable SensitivePayload sensitivePayload) {
        super.onTodoSensitive(sensitivePayload);
        Function2<String, SensitivePayload, Unit> aiSensitiveFailCallback = this.this$0.getAiSensitiveFailCallback();
        if (aiSensitiveFailCallback != null) {
            SummaryRequestBean access$getMTodoRequestBean$p = this.this$0.mTodoRequestBean;
            String recognizeId = access$getMTodoRequestBean$p != null ? access$getMTodoRequestBean$p.getRecognizeId() : null;
            if (recognizeId == null) {
                recognizeId = "";
            }
            aiSensitiveFailCallback.invoke(recognizeId, sensitivePayload);
        }
    }
}
