package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.adapter.IntelExtnTodoAdapter;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "position", "", "extnTodo", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ToDoFragment$initViews$3 extends Lambda implements Function2<Integer, IntelExtnTodo, Unit> {
    final /* synthetic */ ToDoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToDoFragment$initViews$3(ToDoFragment toDoFragment) {
        super(2);
        this.this$0 = toDoFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (IntelExtnTodo) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, @NotNull IntelExtnTodo intelExtnTodo) {
        Intrinsics.checkNotNullParameter(intelExtnTodo, "extnTodo");
        LogExt.j("isDoneTodo position=" + i + ", extnTodo=" + intelExtnTodo, "ToDoFragment");
        IntelExtnTodoViewModel.a0(this.this$0.D0(), intelExtnTodo, true, (Function0) null, 4, (Object) null);
        IntelExtnTodoAdapter n0 = this.this$0.b;
        if (n0 != null) {
            n0.j0(i, intelExtnTodo);
        }
    }
}
