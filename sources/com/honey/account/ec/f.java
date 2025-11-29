package com.honey.account.ec;

import java.lang.reflect.Method;
import java.util.function.Predicate;
import org.apache.commons.lang3.ClassUtils;

public final /* synthetic */ class f implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class[] f7293a;

    public /* synthetic */ f(Class[] clsArr) {
        this.f7293a = clsArr;
    }

    public final boolean test(Object obj) {
        return ClassUtils.isAssignable((Class<?>[]) this.f7293a, (Class<?>[]) ((Method) obj).getParameterTypes(), true);
    }
}
