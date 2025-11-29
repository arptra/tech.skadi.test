package com.honey.account.jb;

import io.ktor.util.collections.ConcurrentMap;
import java.util.function.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f7454a;

    public /* synthetic */ a(Function1 function1) {
        this.f7454a = function1;
    }

    public final Object apply(Object obj) {
        return ConcurrentMap.d(this.f7454a, obj);
    }
}
