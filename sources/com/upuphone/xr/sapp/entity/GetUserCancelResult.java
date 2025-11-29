package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/upuphone/xr/sapp/entity/GetUserCancelResult;", "", "code", "", "msg", "", "data", "Lcom/upuphone/xr/sapp/entity/UserCancelInfo;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/upuphone/xr/sapp/entity/UserCancelInfo;)V", "getCode", "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getData", "()Lcom/upuphone/xr/sapp/entity/UserCancelInfo;", "setData", "(Lcom/upuphone/xr/sapp/entity/UserCancelInfo;)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/upuphone/xr/sapp/entity/UserCancelInfo;)Lcom/upuphone/xr/sapp/entity/GetUserCancelResult;", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GetUserCancelResult {
    @Nullable
    private Integer code;
    @Nullable
    private UserCancelInfo data;
    @Nullable
    private String msg;

    public GetUserCancelResult() {
        this((Integer) null, (String) null, (UserCancelInfo) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GetUserCancelResult copy$default(GetUserCancelResult getUserCancelResult, Integer num, String str, UserCancelInfo userCancelInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            num = getUserCancelResult.code;
        }
        if ((i & 2) != 0) {
            str = getUserCancelResult.msg;
        }
        if ((i & 4) != 0) {
            userCancelInfo = getUserCancelResult.data;
        }
        return getUserCancelResult.copy(num, str, userCancelInfo);
    }

    @Nullable
    public final Integer component1() {
        return this.code;
    }

    @Nullable
    public final String component2() {
        return this.msg;
    }

    @Nullable
    public final UserCancelInfo component3() {
        return this.data;
    }

    @NotNull
    public final GetUserCancelResult copy(@Nullable Integer num, @Nullable String str, @Nullable UserCancelInfo userCancelInfo) {
        return new GetUserCancelResult(num, str, userCancelInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetUserCancelResult)) {
            return false;
        }
        GetUserCancelResult getUserCancelResult = (GetUserCancelResult) obj;
        return Intrinsics.areEqual((Object) this.code, (Object) getUserCancelResult.code) && Intrinsics.areEqual((Object) this.msg, (Object) getUserCancelResult.msg) && Intrinsics.areEqual((Object) this.data, (Object) getUserCancelResult.data);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final UserCancelInfo getData() {
        return this.data;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        Integer num = this.code;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.msg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        UserCancelInfo userCancelInfo = this.data;
        if (userCancelInfo != null) {
            i = userCancelInfo.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setCode(@Nullable Integer num) {
        this.code = num;
    }

    public final void setData(@Nullable UserCancelInfo userCancelInfo) {
        this.data = userCancelInfo;
    }

    public final void setMsg(@Nullable String str) {
        this.msg = str;
    }

    @NotNull
    public String toString() {
        Integer num = this.code;
        String str = this.msg;
        UserCancelInfo userCancelInfo = this.data;
        return "GetUserCancelResult(code=" + num + ", msg=" + str + ", data=" + userCancelInfo + ")";
    }

    public GetUserCancelResult(@Nullable Integer num, @Nullable String str, @Nullable UserCancelInfo userCancelInfo) {
        this.code = num;
        this.msg = str;
        this.data = userCancelInfo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetUserCancelResult(Integer num, String str, UserCancelInfo userCancelInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : userCancelInfo);
    }
}
