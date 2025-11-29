package com.xjmz.myvu.account;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/xjmz/myvu/account/GetUserInfoResponse;", "", "code", "", "message", "data", "Lcom/xjmz/myvu/account/UserInfoData;", "(Ljava/lang/String;Ljava/lang/Object;Lcom/xjmz/myvu/account/UserInfoData;)V", "getCode", "()Ljava/lang/String;", "getData", "()Lcom/xjmz/myvu/account/UserInfoData;", "getMessage", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GetUserInfoResponse {
    @Nullable
    private final String code;
    @SerializedName("data")
    @Nullable
    private final UserInfoData data;
    @Nullable
    private final Object message;

    public GetUserInfoResponse() {
        this((String) null, (Object) null, (UserInfoData) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GetUserInfoResponse copy$default(GetUserInfoResponse getUserInfoResponse, String str, Object obj, UserInfoData userInfoData, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = getUserInfoResponse.code;
        }
        if ((i & 2) != 0) {
            obj = getUserInfoResponse.message;
        }
        if ((i & 4) != 0) {
            userInfoData = getUserInfoResponse.data;
        }
        return getUserInfoResponse.copy(str, obj, userInfoData);
    }

    @Nullable
    public final String component1() {
        return this.code;
    }

    @Nullable
    public final Object component2() {
        return this.message;
    }

    @Nullable
    public final UserInfoData component3() {
        return this.data;
    }

    @NotNull
    public final GetUserInfoResponse copy(@Nullable String str, @Nullable Object obj, @Nullable UserInfoData userInfoData) {
        return new GetUserInfoResponse(str, obj, userInfoData);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetUserInfoResponse)) {
            return false;
        }
        GetUserInfoResponse getUserInfoResponse = (GetUserInfoResponse) obj;
        return Intrinsics.areEqual((Object) this.code, (Object) getUserInfoResponse.code) && Intrinsics.areEqual(this.message, getUserInfoResponse.message) && Intrinsics.areEqual((Object) this.data, (Object) getUserInfoResponse.data);
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final UserInfoData getData() {
        return this.data;
    }

    @Nullable
    public final Object getMessage() {
        return this.message;
    }

    public int hashCode() {
        String str = this.code;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Object obj = this.message;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        UserInfoData userInfoData = this.data;
        if (userInfoData != null) {
            i = userInfoData.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        String str = this.code;
        Object obj = this.message;
        UserInfoData userInfoData = this.data;
        return "GetUserInfoResponse(code=" + str + ", message=" + obj + ", data=" + userInfoData + ")";
    }

    public GetUserInfoResponse(@Nullable String str, @Nullable Object obj, @Nullable UserInfoData userInfoData) {
        this.code = str;
        this.message = obj;
        this.data = userInfoData;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetUserInfoResponse(String str, Object obj, UserInfoData userInfoData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : userInfoData);
    }
}
