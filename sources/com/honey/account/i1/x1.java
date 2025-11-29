package com.honey.account.i1;

import com.google.android.material.color.utilities.DynamicScheme;
import java.util.function.Function;

public final /* synthetic */ class x1 implements Function {
    public final Object apply(Object obj) {
        return Double.valueOf(((DynamicScheme) obj).primaryPalette.getKeyColor().getTone());
    }
}
