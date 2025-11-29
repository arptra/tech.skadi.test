package com.xjmz.myvu.account;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\u000e¨\u0006\""}, d2 = {"Lcom/xjmz/myvu/account/UserInfoData;", "", "id", "", "mzUid", "nickname", "phone", "icon", "accountToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountToken", "()Ljava/lang/String;", "getIcon", "setIcon", "(Ljava/lang/String;)V", "getId", "getMzUid", "getNickname", "setNickname", "getPhone", "setPhone", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class UserInfoData {
    @Nullable
    private final String accountToken;
    @Nullable
    private String icon;
    @Nullable
    private final String id;
    @Nullable
    private final String mzUid;
    @Nullable
    private String nickname;
    @Nullable
    private String phone;

    public UserInfoData() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserInfoData copy$default(UserInfoData userInfoData, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInfoData.id;
        }
        if ((i & 2) != 0) {
            str2 = userInfoData.mzUid;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = userInfoData.nickname;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = userInfoData.phone;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = userInfoData.icon;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = userInfoData.accountToken;
        }
        return userInfoData.copy(str, str7, str8, str9, str10, str6);
    }

    @Nullable
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.mzUid;
    }

    @Nullable
    public final String component3() {
        return this.nickname;
    }

    @Nullable
    public final String component4() {
        return this.phone;
    }

    @Nullable
    public final String component5() {
        return this.icon;
    }

    @Nullable
    public final String component6() {
        return this.accountToken;
    }

    @NotNull
    public final UserInfoData copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        return new UserInfoData(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInfoData)) {
            return false;
        }
        UserInfoData userInfoData = (UserInfoData) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) userInfoData.id) && Intrinsics.areEqual((Object) this.mzUid, (Object) userInfoData.mzUid) && Intrinsics.areEqual((Object) this.nickname, (Object) userInfoData.nickname) && Intrinsics.areEqual((Object) this.phone, (Object) userInfoData.phone) && Intrinsics.areEqual((Object) this.icon, (Object) userInfoData.icon) && Intrinsics.areEqual((Object) this.accountToken, (Object) userInfoData.accountToken);
    }

    @Nullable
    public final String getAccountToken() {
        return this.accountToken;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getMzUid() {
        return this.mzUid;
    }

    @Nullable
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    public final String getPhone() {
        return this.phone;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.mzUid;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.nickname;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.phone;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.icon;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.accountToken;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public final void setIcon(@Nullable String str) {
        this.icon = str;
    }

    public final void setNickname(@Nullable String str) {
        this.nickname = str;
    }

    public final void setPhone(@Nullable String str) {
        this.phone = str;
    }

    @NotNull
    public String toString() {
        String str = this.id;
        String str2 = this.mzUid;
        String str3 = this.nickname;
        String str4 = this.phone;
        String str5 = this.icon;
        String str6 = this.accountToken;
        return "UserInfoData(id=" + str + ", mzUid=" + str2 + ", nickname=" + str3 + ", phone=" + str4 + ", icon=" + str5 + ", accountToken=" + str6 + ")";
    }

    public UserInfoData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.id = str;
        this.mzUid = str2;
        this.nickname = str3;
        this.phone = str4;
        this.icon = str5;
        this.accountToken = str6;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserInfoData(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }
}
