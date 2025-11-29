package com.honey.account.xb;

import java.util.List;
import java.util.function.Function;
import org.apache.commons.lang3.Streams;

public final /* synthetic */ class w implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Streams.ArrayCollector f7711a;

    public /* synthetic */ w(Streams.ArrayCollector arrayCollector) {
        this.f7711a = arrayCollector;
    }

    public final Object apply(Object obj) {
        return this.f7711a.lambda$finisher$1((List) obj);
    }
}
