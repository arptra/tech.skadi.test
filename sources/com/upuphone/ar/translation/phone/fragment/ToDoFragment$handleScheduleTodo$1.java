package com.upuphone.ar.translation.phone.fragment;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.vm.IntelExtnTodoViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ToDoFragment$handleScheduleTodo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ToDoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToDoFragment$handleScheduleTodo$1(ToDoFragment toDoFragment) {
        super(0);
        this.this$0 = toDoFragment;
    }

    public final void invoke() {
        NoteBean o0 = this.this$0.c;
        if (o0 != null) {
            ToDoFragment toDoFragment = this.this$0;
            if (!StringsKt.isBlank(o0.getAccountId()) && !StringsKt.isBlank(o0.getRecognizeId())) {
                LogExt.j("addSchedule 从无权限切换到有权限再次从数据库加载数据", "ToDoFragment");
                IntelExtnTodoViewModel.M(toDoFragment.D0(), o0, false, 2, (Object) null);
            }
        }
    }
}
