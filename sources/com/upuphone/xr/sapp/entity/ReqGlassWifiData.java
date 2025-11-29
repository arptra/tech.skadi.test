package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/entity/ReqGlassWifiData;", "", "()V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "data", "Lcom/upuphone/xr/sapp/entity/ReqGlassWifiData$Data;", "getData", "()Lcom/upuphone/xr/sapp/entity/ReqGlassWifiData$Data;", "setData", "(Lcom/upuphone/xr/sapp/entity/ReqGlassWifiData$Data;)V", "Data", "Value", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ReqGlassWifiData {
    public String action;
    public Data data;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/ReqGlassWifiData$Data;", "", "()V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "value", "Lcom/upuphone/xr/sapp/entity/ReqGlassWifiData$Value;", "getValue", "()Lcom/upuphone/xr/sapp/entity/ReqGlassWifiData$Value;", "setValue", "(Lcom/upuphone/xr/sapp/entity/ReqGlassWifiData$Value;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Data {
        public String action;
        public Value value;

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
        public final Value getValue() {
            Value value2 = this.value;
            if (value2 != null) {
                return value2;
            }
            Intrinsics.throwUninitializedPropertyAccessException(AccountConstantKt.RESPONSE_VALUE);
            return null;
        }

        public final void setAction(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.action = str;
        }

        public final void setValue(@NotNull Value value2) {
            Intrinsics.checkNotNullParameter(value2, "<set-?>");
            this.value = value2;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/ReqGlassWifiData$Value;", "", "()V", "change", "", "getChange", "()Ljava/lang/String;", "setChange", "(Ljava/lang/String;)V", "password", "getPassword", "setPassword", "ssid", "getSsid", "setSsid", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Value {
        public String change;
        public String password;
        public String ssid;

        @NotNull
        public final String getChange() {
            String str = this.change;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("change");
            return null;
        }

        @NotNull
        public final String getPassword() {
            String str = this.password;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException(AccountConstantKt.INTENT_PARAM_PASSWORD);
            return null;
        }

        @NotNull
        public final String getSsid() {
            String str = this.ssid;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("ssid");
            return null;
        }

        public final void setChange(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.change = str;
        }

        public final void setPassword(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.password = str;
        }

        public final void setSsid(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ssid = str;
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
