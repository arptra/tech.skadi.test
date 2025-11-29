package com.honey.account.c8;

import com.upuphone.xr.sapp.adapter.TodoListAdapter;
import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f4205a;

    public /* synthetic */ c0(Function1 function1) {
        this.f4205a = function1;
    }

    public final boolean test(Object obj) {
        return TodoListAdapter.T(this.f4205a, obj);
    }
}
