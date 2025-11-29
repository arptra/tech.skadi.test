package com.honey.account.c8;

import com.upuphone.xr.sapp.adapter.TodoListAdapter;
import java.util.function.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d0 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f4207a;

    public /* synthetic */ d0(Function1 function1) {
        this.f4207a = function1;
    }

    public final void accept(Object obj) {
        TodoListAdapter.U(this.f4207a, obj);
    }
}
