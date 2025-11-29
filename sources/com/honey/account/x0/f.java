package com.honey.account.x0;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import java.util.function.BiFunction;

public final /* synthetic */ class f implements BiFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstantDeserializer f3139a;
    public final /* synthetic */ DeserializationContext b;

    public /* synthetic */ f(InstantDeserializer instantDeserializer, DeserializationContext deserializationContext) {
        this.f3139a = instantDeserializer;
        this.b = deserializationContext;
    }

    public final Object apply(Object obj, Object obj2) {
        return this.f3139a.lambda$_fromDecimal$8(this.b, (Long) obj, (Integer) obj2);
    }
}
