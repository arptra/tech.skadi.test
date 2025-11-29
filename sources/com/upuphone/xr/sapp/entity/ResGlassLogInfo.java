package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/entity/ResGlassLogInfo;", "", "()V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "changechannel", "getChangechannel", "setChangechannel", "filesize", "getFilesize", "setFilesize", "value", "getValue", "setValue", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ResGlassLogInfo {
    public String action;
    public String changechannel;
    public String filesize;
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
    public final String getChangechannel() {
        String str = this.changechannel;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("changechannel");
        return null;
    }

    @NotNull
    public final String getFilesize() {
        String str = this.filesize;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("filesize");
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

    public final void setChangechannel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.changechannel = str;
    }

    public final void setFilesize(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.filesize = str;
    }

    public final void setValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.value = str;
    }

    @NotNull
    public String toString() {
        String action2 = getAction();
        String value2 = getValue();
        String filesize2 = getFilesize();
        String changechannel2 = getChangechannel();
        return "ResGlassLogInfo(action='" + action2 + "', value='" + value2 + "', filesize='" + filesize2 + "', changechannel='" + changechannel2 + "')";
    }
}
