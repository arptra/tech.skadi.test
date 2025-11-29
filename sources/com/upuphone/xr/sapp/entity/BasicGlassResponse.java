package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0017\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;", "", "code", "", "msg", "", "(ILjava/lang/String;)V", "getCode", "()I", "isSuccess", "", "()Z", "getMsg", "()Ljava/lang/String;", "toString", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public class BasicGlassResponse {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int code;
    @Nullable
    private final String msg;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/BasicGlassResponse$Companion;", "", "()V", "fail", "Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;", "msg", "", "success", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ BasicGlassResponse fail$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.fail(str);
        }

        @NotNull
        public final BasicGlassResponse fail(@Nullable String str) {
            if (str == null) {
                str = "fail";
            }
            return new BasicGlassResponse(1, str);
        }

        @NotNull
        public final BasicGlassResponse success() {
            return new BasicGlassResponse(0, "success");
        }

        private Companion() {
        }
    }

    public BasicGlassResponse(int i, @Nullable String str) {
        this.code = i;
        this.msg = str;
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public final boolean isSuccess() {
        return this.code == 0;
    }

    @NotNull
    public String toString() {
        int i = this.code;
        String str = this.msg;
        return "BasicGlassResponse(code=" + i + ", msg=" + str + ")";
    }
}
