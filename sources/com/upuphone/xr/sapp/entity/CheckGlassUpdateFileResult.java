package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\u0005H\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/entity/CheckGlassUpdateFileResult;", "Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;", "code", "", "msg", "", "exist", "", "(ILjava/lang/String;Ljava/lang/Boolean;)V", "getExist", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class CheckGlassUpdateFileResult extends BasicGlassResponse {
    @Nullable
    private final Boolean exist;

    public CheckGlassUpdateFileResult(int i, @Nullable String str, @Nullable Boolean bool) {
        super(i, str);
        this.exist = bool;
    }

    @Nullable
    public final Boolean getExist() {
        return this.exist;
    }

    @NotNull
    public String toString() {
        int code = getCode();
        String msg = getMsg();
        Boolean bool = this.exist;
        return "GlassUpdateResult(code=" + code + ", msg=" + msg + ", exist=" + bool + ")";
    }
}
