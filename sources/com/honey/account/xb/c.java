package com.honey.account.xb;

import java.util.Iterator;
import org.apache.commons.lang3.ClassUtils;

public final /* synthetic */ class c implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f7685a;

    public /* synthetic */ c(Class cls) {
        this.f7685a = cls;
    }

    public final Iterator iterator() {
        return ClassUtils.lambda$hierarchy$0(this.f7685a);
    }
}
