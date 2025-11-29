package com.honey.account.c8;

import com.upuphone.xr.sapp.adapter.TodoListAdapter;
import java.util.function.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class w implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f4227a;

    public /* synthetic */ w(Function1 function1) {
        this.f4227a = function1;
    }

    public final void accept(Object obj) {
        TodoListAdapter.x(this.f4227a, obj);
    }
}
