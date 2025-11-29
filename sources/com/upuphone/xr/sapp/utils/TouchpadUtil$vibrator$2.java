package com.upuphone.xr.sapp.utils;

import android.os.Vibrator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Vibrator;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TouchpadUtil$vibrator$2 extends Lambda implements Function0<Vibrator> {
    public static final TouchpadUtil$vibrator$2 INSTANCE = new TouchpadUtil$vibrator$2();

    public TouchpadUtil$vibrator$2() {
        super(0);
    }

    @NotNull
    public final Vibrator invoke() {
        Object systemService = GlobalExtKt.f().getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        return (Vibrator) systemService;
    }
}
