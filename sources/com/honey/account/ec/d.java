package com.honey.account.ec;

import java.lang.reflect.Method;
import java.util.function.Predicate;

public final /* synthetic */ class d implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7291a;

    public /* synthetic */ d(String str) {
        this.f7291a = str;
    }

    public final boolean test(Object obj) {
        return ((Method) obj).getName().equals(this.f7291a);
    }
}
