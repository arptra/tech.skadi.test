package com.xjsd.xr.sapp.asr.callback;

import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.SmartExSummary;
import com.xjsd.xr.sapp.asr.dao.SmartExTodo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000e"}, d2 = {"Lcom/xjsd/xr/sapp/asr/callback/SmartExCallback;", "Lcom/xjsd/xr/sapp/asr/callback/ISmartExCallback;", "()V", "onSummary", "", "summary", "Lcom/xjsd/xr/sapp/asr/dao/SmartExSummary;", "onSummarySensitive", "sensitive", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "onTodo", "exTodo", "Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo;", "onTodoSensitive", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class SmartExCallback implements ISmartExCallback {
    public void onSummary(@Nullable SmartExSummary smartExSummary) {
    }

    public void onSummarySensitive(@Nullable SensitivePayload sensitivePayload) {
    }

    public void onTodo(@Nullable SmartExTodo smartExTodo) {
    }

    public void onTodoSensitive(@Nullable SensitivePayload sensitivePayload) {
    }
}
