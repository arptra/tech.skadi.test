package com.honey.account.ec;

import java.lang.reflect.Method;
import java.util.function.Predicate;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7290a;

    public /* synthetic */ a(String str) {
        this.f7290a = str;
    }

    public final boolean test(Object obj) {
        return ((Method) obj).getName().equals(this.f7290a);
    }
}
