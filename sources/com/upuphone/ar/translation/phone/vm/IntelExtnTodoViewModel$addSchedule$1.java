package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class IntelExtnTodoViewModel$addSchedule$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ IntelExtnTodo $extnTodo;
    final /* synthetic */ IntelExtnTodoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnTodoViewModel$addSchedule$1(IntelExtnTodoViewModel intelExtnTodoViewModel, IntelExtnTodo intelExtnTodo) {
        super(1);
        this.this$0 = intelExtnTodoViewModel;
        this.$extnTodo = intelExtnTodo;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        LogExt.j("addSchedule request permission=" + z, "IntelExtnTodoViewModel");
        if (z) {
            this.this$0.r = true;
            this.this$0.t(this.$extnTodo);
        }
    }
}
