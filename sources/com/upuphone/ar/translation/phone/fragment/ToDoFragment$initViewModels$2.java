package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "list", "", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnTodo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ToDoFragment$initViewModels$2 extends Lambda implements Function1<List<IntelExtnTodo>, Unit> {
    final /* synthetic */ ToDoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToDoFragment$initViewModels$2(ToDoFragment toDoFragment) {
        super(1);
        this.this$0 = toDoFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<IntelExtnTodo>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<IntelExtnTodo> list) {
        ToDoFragment toDoFragment = this.this$0;
        Intrinsics.checkNotNull(list);
        toDoFragment.H0(list);
    }
}
