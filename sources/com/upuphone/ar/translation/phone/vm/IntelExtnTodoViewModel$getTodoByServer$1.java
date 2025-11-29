package com.upuphone.ar.translation.phone.vm;

import androidx.lifecycle.ViewModelKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.xjsd.xr.sapp.asr.callback.SmartExCallback;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.SmartExTodo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/upuphone/ar/translation/phone/vm/IntelExtnTodoViewModel$getTodoByServer$1", "Lcom/xjsd/xr/sapp/asr/callback/SmartExCallback;", "onTodo", "", "exTodo", "Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo;", "onTodoSensitive", "sensitive", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IntelExtnTodoViewModel$getTodoByServer$1 extends SmartExCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntelExtnTodoViewModel f6344a;

    public IntelExtnTodoViewModel$getTodoByServer$1(IntelExtnTodoViewModel intelExtnTodoViewModel) {
        this.f6344a = intelExtnTodoViewModel;
    }

    public void onTodo(SmartExTodo smartExTodo) {
        super.onTodo(smartExTodo);
        LogExt.j("getTodoByServer todo=" + smartExTodo, "IntelExtnTodoViewModel");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this.f6344a), Dispatchers.c(), (CoroutineStart) null, new IntelExtnTodoViewModel$getTodoByServer$1$onTodo$1(this.f6344a, smartExTodo, (Continuation<? super IntelExtnTodoViewModel$getTodoByServer$1$onTodo$1>) null), 2, (Object) null);
    }

    public void onTodoSensitive(SensitivePayload sensitivePayload) {
        super.onTodoSensitive(sensitivePayload);
        LogExt.j("getTodoByServer sensitive=" + sensitivePayload, "IntelExtnTodoViewModel");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this.f6344a), Dispatchers.c(), (CoroutineStart) null, new IntelExtnTodoViewModel$getTodoByServer$1$onTodoSensitive$1(this.f6344a, sensitivePayload, (Continuation<? super IntelExtnTodoViewModel$getTodoByServer$1$onTodoSensitive$1>) null), 2, (Object) null);
    }
}
