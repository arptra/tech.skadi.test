package com.honey.account.oc;

import java.lang.reflect.AccessibleObject;
import java.security.PrivilegedAction;

public final /* synthetic */ class a implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccessibleObject f3224a;

    public /* synthetic */ a(AccessibleObject accessibleObject) {
        this.f3224a = accessibleObject;
    }

    public final Object run() {
        return this.f3224a.setAccessible(true);
    }
}
