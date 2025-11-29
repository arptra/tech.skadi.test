package com.honey.account.ec;

import java.lang.reflect.Method;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Consumer;
import org.apache.commons.lang3.reflect.MethodUtils;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class[] f7294a;
    public final /* synthetic */ TreeMap b;

    public /* synthetic */ g(Class[] clsArr, TreeMap treeMap) {
        this.f7294a = clsArr;
        this.b = treeMap;
    }

    public final void accept(Object obj) {
        ((List) this.b.computeIfAbsent(Integer.valueOf(MethodUtils.distance(this.f7294a, ((Method) obj).getParameterTypes())), new j())).add((Method) obj);
    }
}
