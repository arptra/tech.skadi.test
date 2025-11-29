package com.xjmz.myvu.account;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015JJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/xjmz/myvu/account/GetUserProfileResponse;", "", "status", "", "code", "msg", "", "data", "Lcom/xjmz/myvu/account/UserProfileData;", "tstamp", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/xjmz/myvu/account/UserProfileData;Ljava/lang/Long;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Lcom/xjmz/myvu/account/UserProfileData;", "getMsg", "()Ljava/lang/String;", "getStatus", "getTstamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/xjmz/myvu/account/UserProfileData;Ljava/lang/Long;)Lcom/xjmz/myvu/account/GetUserProfileResponse;", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GetUserProfileResponse {
    @Nullable
    private final Integer code;
    @Nullable
    private final UserProfileData data;
    @Nullable
    private final String msg;
    @Nullable
    private final Integer status;
    @Nullable
    private final Long tstamp;

    public GetUserProfileResponse() {
        this((Integer) null, (Integer) null, (String) null, (UserProfileData) null, (Long) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GetUserProfileResponse copy$default(GetUserProfileResponse getUserProfileResponse, Integer num, Integer num2, String str, UserProfileData userProfileData, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            num = getUserProfileResponse.status;
        }
        if ((i & 2) != 0) {
            num2 = getUserProfileResponse.code;
        }
        Integer num3 = num2;
        if ((i & 4) != 0) {
            str = getUserProfileResponse.msg;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            userProfileData = getUserProfileResponse.data;
        }
        UserProfileData userProfileData2 = userProfileData;
        if ((i & 16) != 0) {
            l = getUserProfileResponse.tstamp;
        }
        return getUserProfileResponse.copy(num, num3, str2, userProfileData2, l);
    }

    @Nullable
    public final Integer component1() {
        return this.status;
    }

    @Nullable
    public final Integer component2() {
        return this.code;
    }

    @Nullable
    public final String component3() {
        return this.msg;
    }

    @Nullable
    public final UserProfileData component4() {
        return this.data;
    }

    @Nullable
    public final Long component5() {
        return this.tstamp;
    }

    @NotNull
    public final GetUserProfileResponse copy(@Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable UserProfileData userProfileData, @Nullable Long l) {
        return new GetUserProfileResponse(num, num2, str, userProfileData, l);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetUserProfileResponse)) {
            return false;
        }
        GetUserProfileResponse getUserProfileResponse = (GetUserProfileResponse) obj;
        return Intrinsics.areEqual((Object) this.status, (Object) getUserProfileResponse.status) && Intrinsics.areEqual((Object) this.code, (Object) getUserProfileResponse.code) && Intrinsics.areEqual((Object) this.msg, (Object) getUserProfileResponse.msg) && Intrinsics.areEqual((Object) this.data, (Object) getUserProfileResponse.data) && Intrinsics.areEqual((Object) this.tstamp, (Object) getUserProfileResponse.tstamp);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @Nullable
    public final UserProfileData getData() {
        return this.data;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    public final Long getTstamp() {
        return this.tstamp;
    }

    public int hashCode() {
        Integer num = this.status;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.code;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.msg;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        UserProfileData userProfileData = this.data;
        int hashCode4 = (hashCode3 + (userProfileData == null ? 0 : userProfileData.hashCode())) * 31;
        Long l = this.tstamp;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        Integer num = this.status;
        Integer num2 = this.code;
        String str = this.msg;
        UserProfileData userProfileData = this.data;
        Long l = this.tstamp;
        return "GetUserProfileResponse(status=" + num + ", code=" + num2 + ", msg=" + str + ", data=" + userProfileData + ", tstamp=" + l + ")";
    }

    public GetUserProfileResponse(@Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable UserProfileData userProfileData, @Nullable Long l) {
        this.status = num;
        this.code = num2;
        this.msg = str;
        this.data = userProfileData;
        this.tstamp = l;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetUserProfileResponse(Integer num, Integer num2, String str, UserProfileData userProfileData, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : userProfileData, (i & 16) != 0 ? null : l);
    }
}
