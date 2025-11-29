package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "todo", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ToDoFragment$initViewModels$4 extends Lambda implements Function1<IntelExtnTodo, Unit> {
    final /* synthetic */ ToDoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToDoFragment$initViewModels$4(ToDoFragment toDoFragment) {
        super(1);
        this.this$0 = toDoFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IntelExtnTodo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IntelExtnTodo intelExtnTodo) {
        ToDoFragment toDoFragment = this.this$0;
        Intrinsics.checkNotNull(intelExtnTodo);
        toDoFragment.K0(intelExtnTodo);
    }
}
