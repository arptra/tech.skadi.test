package com.xjsd.xr.sapp.asr.callback;

import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.SmartExSummary;
import com.xjsd.xr.sapp.asr.dao.SmartExTodo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\r"}, d2 = {"Lcom/xjsd/xr/sapp/asr/callback/ISmartExCallback;", "", "onSummary", "", "summary", "Lcom/xjsd/xr/sapp/asr/dao/SmartExSummary;", "onSummarySensitive", "sensitive", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "onTodo", "exTodo", "Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo;", "onTodoSensitive", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ISmartExCallback {
    void onSummary(@Nullable SmartExSummary smartExSummary);

    void onSummarySensitive(@Nullable SensitivePayload sensitivePayload);

    void onTodo(@Nullable SmartExTodo smartExTodo);

    void onTodoSensitive(@Nullable SensitivePayload sensitivePayload);
}
