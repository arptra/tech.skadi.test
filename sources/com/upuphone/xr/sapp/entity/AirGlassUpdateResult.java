package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0005H\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AirGlassUpdateResult;", "Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;", "code", "", "msg", "", "romVersion", "(ILjava/lang/String;Ljava/lang/String;)V", "getRomVersion", "()Ljava/lang/String;", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AirGlassUpdateResult extends BasicGlassResponse {
    @NotNull
    private final String romVersion;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirGlassUpdateResult(int i, @Nullable String str, @NotNull String str2) {
        super(i, str);
        Intrinsics.checkNotNullParameter(str2, "romVersion");
        this.romVersion = str2;
    }

    @NotNull
    public final String getRomVersion() {
        return this.romVersion;
    }

    @NotNull
    public String toString() {
        int code = getCode();
        String msg = getMsg();
        String str = this.romVersion;
        return "AirGlassUpdateResult(code=" + code + ", msg=" + msg + ", romVersion=" + str + ")";
    }
}
