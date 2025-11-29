package com.upuphone.xr.sapp.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.upuphone.star.core.log.ULog;
import com.xjsd.ai.assistant.phone.vui.todo.TodoRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR#\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/vm/TodoViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "", "accountId", "Landroidx/lifecycle/LiveData;", "", "Lcom/xjsd/ai/assistant/phone/vui/todo/TodoEntry;", "c", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "a", "Landroidx/lifecycle/LiveData;", "d", "()Landroidx/lifecycle/LiveData;", "allTodos", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TodoViewModel extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final LiveData f8012a = TodoRepository.f8656a.k().f();

    public final LiveData c(String str) {
        Intrinsics.checkNotNullParameter(str, "accountId");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("TodoViewModel", "查询用户->" + str + " 的待办");
        return TodoRepository.f8656a.k().g(str);
    }

    public final LiveData d() {
        return this.f8012a;
    }
}
