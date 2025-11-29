package com.honey.account.c8;

import com.upuphone.xr.sapp.adapter.TodoListAdapter;
import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class v implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f4226a;

    public /* synthetic */ v(Function1 function1) {
        this.f4226a = function1;
    }

    public final boolean test(Object obj) {
        return TodoListAdapter.w(this.f4226a, obj);
    }
}
