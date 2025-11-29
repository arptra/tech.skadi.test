package com.honey.account.qc;

import java.security.PrivilegedAction;
import java.util.ServiceLoader;
import org.slf4j.spi.SLF4JServiceProvider;

public final /* synthetic */ class a implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassLoader f3229a;

    public /* synthetic */ a(ClassLoader classLoader) {
        this.f3229a = classLoader;
    }

    public final Object run() {
        return ServiceLoader.load(SLF4JServiceProvider.class, this.f3229a);
    }
}
