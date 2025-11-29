package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/BaseActionData;", "", "()V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "data", "Lcom/upuphone/xr/sapp/entity/BaseActionValue;", "getData", "()Lcom/upuphone/xr/sapp/entity/BaseActionValue;", "setData", "(Lcom/upuphone/xr/sapp/entity/BaseActionValue;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class BaseActionData {
    @Nullable
    private String action;
    @Nullable
    private BaseActionValue data;

    @Nullable
    public final String getAction() {
        return this.action;
    }

    @Nullable
    public final BaseActionValue getData() {
        return this.data;
    }

    public final void setAction(@Nullable String str) {
        this.action = str;
    }

    public final void setData(@Nullable BaseActionValue baseActionValue) {
        this.data = baseActionValue;
    }
}
