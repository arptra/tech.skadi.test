package com.honey.account.h8;

import com.upuphone.xr.sapp.fragment.PermissionManagerFragment;
import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c8 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f4561a;

    public /* synthetic */ c8(Function1 function1) {
        this.f4561a = function1;
    }

    public final boolean test(Object obj) {
        return PermissionManagerFragment.e1(this.f4561a, obj);
    }
}
