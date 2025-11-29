package com.geetest.captcha;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public enum b0 {
    CENTER("center"),
    BOTTOM("bottom");
    
    @NotNull
    public String value;

    /* access modifiers changed from: public */
    b0(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public final void setValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.value = str;
    }
}
