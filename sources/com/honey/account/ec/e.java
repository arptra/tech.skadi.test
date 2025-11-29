package com.honey.account.ec;

import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f7292a;

    public /* synthetic */ e(List list) {
        this.f7292a = list;
    }

    public final void accept(Object obj) {
        this.f7292a.add((Method) obj);
    }
}
