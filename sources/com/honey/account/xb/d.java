package com.honey.account.xb;

import java.util.Iterator;
import org.apache.commons.lang3.ClassUtils;

public final /* synthetic */ class d implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Iterable f7686a;

    public /* synthetic */ d(Iterable iterable) {
        this.f7686a = iterable;
    }

    public final Iterator iterator() {
        return ClassUtils.lambda$hierarchy$1(this.f7686a);
    }
}
