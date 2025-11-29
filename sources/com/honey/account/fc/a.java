package com.honey.account.fc;

import java.util.List;
import java.util.function.Function;
import org.apache.commons.lang3.stream.Streams;

public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Streams.ArrayCollector f7318a;

    public /* synthetic */ a(Streams.ArrayCollector arrayCollector) {
        this.f7318a = arrayCollector;
    }

    public final Object apply(Object obj) {
        return this.f7318a.lambda$finisher$1((List) obj);
    }
}
