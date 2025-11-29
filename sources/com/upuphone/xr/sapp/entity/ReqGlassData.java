package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/entity/ReqGlassData;", "", "()V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "data", "Lcom/upuphone/xr/sapp/entity/ReqGlassData$Data;", "getData", "()Lcom/upuphone/xr/sapp/entity/ReqGlassData$Data;", "setData", "(Lcom/upuphone/xr/sapp/entity/ReqGlassData$Data;)V", "Data", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ReqGlassData {
    public String action;
    public Data data;

    @Keep
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/ReqGlassData$Data;", "", "()V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "ext", "getExt", "setExt", "value", "getValue", "setValue", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class Data {
        public String action;
        public String ext;
        public String value;

        @NotNull
        public final String getAction() {
            String str = this.action;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException(WebJs.ACTION);
            return null;
        }

        @NotNull
        public final String getExt() {
            String str = this.ext;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("ext");
            return null;
        }

        @NotNull
        public final String getValue() {
            String str = this.value;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException(AccountConstantKt.RESPONSE_VALUE);
            return null;
        }

        public final void setAction(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.action = str;
        }

        public final void setExt(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext = str;
        }

        public final void setValue(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.value = str;
        }
    }

    @NotNull
    public final String getAction() {
        String str = this.action;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(WebJs.ACTION);
        return null;
    }

    @NotNull
    public final Data getData() {
        Data data2 = this.data;
        if (data2 != null) {
            return data2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public final void setAction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.action = str;
    }

    public final void setData(@NotNull Data data2) {
        Intrinsics.checkNotNullParameter(data2, "<set-?>");
        this.data = data2;
    }
}
