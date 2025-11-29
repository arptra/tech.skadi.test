package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/sapp/entity/UserCancelInfo;", "", "userId", "", "deleted", "", "createTime", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getCreateTime", "()Ljava/lang/String;", "setCreateTime", "(Ljava/lang/String;)V", "getDeleted", "()Ljava/lang/Boolean;", "setDeleted", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getUserId", "setUserId", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/upuphone/xr/sapp/entity/UserCancelInfo;", "equals", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class UserCancelInfo {
    @Nullable
    private String createTime;
    @Nullable
    private Boolean deleted;
    @Nullable
    private String userId;

    public UserCancelInfo() {
        this((String) null, (Boolean) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserCancelInfo copy$default(UserCancelInfo userCancelInfo, String str, Boolean bool, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userCancelInfo.userId;
        }
        if ((i & 2) != 0) {
            bool = userCancelInfo.deleted;
        }
        if ((i & 4) != 0) {
            str2 = userCancelInfo.createTime;
        }
        return userCancelInfo.copy(str, bool, str2);
    }

    @Nullable
    public final String component1() {
        return this.userId;
    }

    @Nullable
    public final Boolean component2() {
        return this.deleted;
    }

    @Nullable
    public final String component3() {
        return this.createTime;
    }

    @NotNull
    public final UserCancelInfo copy(@Nullable String str, @Nullable Boolean bool, @Nullable String str2) {
        return new UserCancelInfo(str, bool, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserCancelInfo)) {
            return false;
        }
        UserCancelInfo userCancelInfo = (UserCancelInfo) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) userCancelInfo.userId) && Intrinsics.areEqual((Object) this.deleted, (Object) userCancelInfo.deleted) && Intrinsics.areEqual((Object) this.createTime, (Object) userCancelInfo.createTime);
    }

    @Nullable
    public final String getCreateTime() {
        return this.createTime;
    }

    @Nullable
    public final Boolean getDeleted() {
        return this.deleted;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.deleted;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.createTime;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setCreateTime(@Nullable String str) {
        this.createTime = str;
    }

    public final void setDeleted(@Nullable Boolean bool) {
        this.deleted = bool;
    }

    public final void setUserId(@Nullable String str) {
        this.userId = str;
    }

    @NotNull
    public String toString() {
        String str = this.userId;
        Boolean bool = this.deleted;
        String str2 = this.createTime;
        return "UserCancelInfo(userId=" + str + ", deleted=" + bool + ", createTime=" + str2 + ")";
    }

    public UserCancelInfo(@Nullable String str, @Nullable Boolean bool, @Nullable String str2) {
        this.userId = str;
        this.deleted = bool;
        this.createTime = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserCancelInfo(String str, Boolean bool, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? Boolean.FALSE : bool, (i & 4) != 0 ? null : str2);
    }
}
