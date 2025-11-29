package com.honey.account.c8;

import com.upuphone.xr.sapp.adapter.TodoListAdapter;
import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class e0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f4209a;

    public /* synthetic */ e0(Function1 function1) {
        this.f4209a = function1;
    }

    public final boolean test(Object obj) {
        return TodoListAdapter.V(this.f4209a, obj);
    }
}
