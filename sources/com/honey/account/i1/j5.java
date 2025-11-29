package com.honey.account.i1;

import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.TemperatureCache;
import java.util.function.Function;

public final /* synthetic */ class j5 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TemperatureCache f9752a;

    public /* synthetic */ j5(TemperatureCache temperatureCache) {
        this.f9752a = temperatureCache;
    }

    public final Object apply(Object obj) {
        return this.f9752a.lambda$getHctsByTemp$0((Hct) obj);
    }
}
