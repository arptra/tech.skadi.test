package com.upuphone.ai.ttsengine.base.utils;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SystemUtils$isHUAWEI$2 extends Lambda implements Function0<Boolean> {
    public static final SystemUtils$isHUAWEI$2 INSTANCE = new SystemUtils$isHUAWEI$2();

    public SystemUtils$isHUAWEI$2() {
        super(0);
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(StringsKt.contentEquals("huawei", Build.MANUFACTURER, true));
    }
}
