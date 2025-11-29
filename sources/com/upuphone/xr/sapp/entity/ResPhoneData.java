package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/ResPhoneData;", "", "()V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "value", "", "getValue", "()I", "setValue", "(I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ResPhoneData {
    public String action;
    private int value;

    @NotNull
    public final String getAction() {
        String str = this.action;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(WebJs.ACTION);
        return null;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setAction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.action = str;
    }

    public final void setValue(int i) {
        this.value = i;
    }
}
