package com.upuphone.xr.sapp.utils;

import androidx.navigation.NavOptionsBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/navigation/NavOptionsBuilder;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class StaticMethodUtilsKt$optionsRightAndLeft$1 extends Lambda implements Function1<NavOptionsBuilder, Unit> {
    public static final StaticMethodUtilsKt$optionsRightAndLeft$1 INSTANCE = new StaticMethodUtilsKt$optionsRightAndLeft$1();

    public StaticMethodUtilsKt$optionsRightAndLeft$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavOptionsBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull NavOptionsBuilder navOptionsBuilder) {
        Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navOptions");
        navOptionsBuilder.a(AnonymousClass1.INSTANCE);
    }
}
