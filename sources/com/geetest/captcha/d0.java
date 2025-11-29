package com.geetest.captcha;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public enum d0 {
    WEB_VIEW_NEW("0"),
    PARAM("1"),
    WEB_VIEW_HTTP("2"),
    WEB_VIEW_SSL("3"),
    USER_ERROR("4"),
    WEB_CALLBACK_ERROR("5"),
    NET("6");
    
    @NotNull
    public String type;

    /* access modifiers changed from: public */
    d0(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }
}
