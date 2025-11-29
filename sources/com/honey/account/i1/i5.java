package com.honey.account.i1;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

public final /* synthetic */ class i5 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialDynamicColors f9749a;

    public /* synthetic */ i5(MaterialDynamicColors materialDynamicColors) {
        this.f9749a = materialDynamicColors;
    }

    public final Object apply(Object obj) {
        return this.f9749a.highestSurface((DynamicScheme) obj);
    }
}
