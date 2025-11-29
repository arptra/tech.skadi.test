package com.honey.account.i1;

import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.TonalPalette;
import java.util.function.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TonalPalette f9728a;

    public /* synthetic */ a(TonalPalette tonalPalette) {
        this.f9728a = tonalPalette;
    }

    public final Object apply(Object obj) {
        return DynamicColor.lambda$fromArgb$0(this.f9728a, (DynamicScheme) obj);
    }
}
