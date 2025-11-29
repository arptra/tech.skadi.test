package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\u0005H\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/entity/CheckUpdateFileResp;", "Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;", "code", "", "msg", "", "exist", "", "(ILjava/lang/String;Ljava/lang/Boolean;)V", "getExist", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "toString", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class CheckUpdateFileResp extends BasicGlassResponse {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final Boolean exist;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/entity/CheckUpdateFileResp$Companion;", "", "()V", "exist", "Lcom/upuphone/xr/sapp/entity/CheckUpdateFileResp;", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CheckUpdateFileResp exist(boolean z) {
            return new CheckUpdateFileResp(0, (String) null, Boolean.valueOf(z));
        }

        private Companion() {
        }
    }

    public CheckUpdateFileResp(int i, @Nullable String str, @Nullable Boolean bool) {
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
