package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/entity/SubPolicyData;", "", "()V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "data", "Lcom/upuphone/xr/sapp/entity/SubPolicyData$Data;", "getData", "()Lcom/upuphone/xr/sapp/entity/SubPolicyData$Data;", "setData", "(Lcom/upuphone/xr/sapp/entity/SubPolicyData$Data;)V", "Data", "Status", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public class SubPolicyData {
    public String action;
    public Data data;

    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/entity/SubPolicyData$Data;", "", "()V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "type", "getType", "setType", "value", "", "Lcom/upuphone/xr/sapp/entity/SubPolicyData$Status;", "getValue", "()Ljava/util/List;", "setValue", "(Ljava/util/List;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Data {
        public String action;
        public String type;
        public List<Status> value;

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
        public final String getType() {
            String str = this.type;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("type");
            return null;
        }

        @NotNull
        public final List<Status> getValue() {
            List<Status> list = this.value;
            if (list != null) {
                return list;
            }
            Intrinsics.throwUninitializedPropertyAccessException(AccountConstantKt.RESPONSE_VALUE);
            return null;
        }

        public final void setAction(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.action = str;
        }

        public final void setType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }

        public final void setValue(@NotNull List<Status> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.value = list;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/entity/SubPolicyData$Status;", "", "pkgName", "", "state", "", "(IZ)V", "pkg", "getPkg", "()I", "setPkg", "(I)V", "status", "getStatus", "()Z", "setStatus", "(Z)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Status {
        private int pkg;
        private boolean status;

        public Status(int i, boolean z) {
            this.pkg = i;
            this.status = z;
        }

        public final int getPkg() {
            return this.pkg;
        }

        public final boolean getStatus() {
            return this.status;
        }

        public final void setPkg(int i) {
            this.pkg = i;
        }

        public final void setStatus(boolean z) {
            this.status = z;
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
