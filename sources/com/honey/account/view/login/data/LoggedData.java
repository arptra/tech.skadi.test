package com.honey.account.view.login.data;

import com.google.gson.annotations.SerializedName;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.upuphone.xr.sapp.contract.ProtocolCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/honey/account/view/login/data/LoggedData;", "", "userId", "", "userName", "phone", "icon", "flyme", "rememberMe", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFlyme", "()Ljava/lang/String;", "getIcon", "getPhone", "getRememberMe", "getUserId", "getUserName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LoggedData {
    @SerializedName("flyme")
    @NotNull

    /* renamed from: flyme  reason: collision with root package name */
    private final String f9231flyme;
    @SerializedName("icon")
    @NotNull
    private final String icon;
    @SerializedName("phone")
    @NotNull
    private final String phone;
    @SerializedName("user_rememberme")
    @NotNull
    private final String rememberMe;
    @SerializedName("user_id")
    @NotNull
    private final String userId;
    @SerializedName("user_name")
    @NotNull
    private final String userName;

    public LoggedData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, Oauth2AccessToken.KEY_SCREEN_NAME);
        Intrinsics.checkNotNullParameter(str3, "phone");
        Intrinsics.checkNotNullParameter(str4, "icon");
        Intrinsics.checkNotNullParameter(str5, ProtocolCategory.FLYME);
        Intrinsics.checkNotNullParameter(str6, "rememberMe");
        this.userId = str;
        this.userName = str2;
        this.phone = str3;
        this.icon = str4;
        this.f9231flyme = str5;
        this.rememberMe = str6;
    }

    public static /* synthetic */ LoggedData copy$default(LoggedData loggedData, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loggedData.userId;
        }
        if ((i & 2) != 0) {
            str2 = loggedData.userName;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = loggedData.phone;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = loggedData.icon;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = loggedData.f9231flyme;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = loggedData.rememberMe;
        }
        return loggedData.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.userId;
    }

    @NotNull
    public final String component2() {
        return this.userName;
    }

    @NotNull
    public final String component3() {
        return this.phone;
    }

    @NotNull
    public final String component4() {
        return this.icon;
    }

    @NotNull
    public final String component5() {
        return this.f9231flyme;
    }

    @NotNull
    public final String component6() {
        return this.rememberMe;
    }

    @NotNull
    public final LoggedData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, Oauth2AccessToken.KEY_SCREEN_NAME);
        Intrinsics.checkNotNullParameter(str3, "phone");
        Intrinsics.checkNotNullParameter(str4, "icon");
        Intrinsics.checkNotNullParameter(str5, ProtocolCategory.FLYME);
        Intrinsics.checkNotNullParameter(str6, "rememberMe");
        return new LoggedData(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoggedData)) {
            return false;
        }
        LoggedData loggedData = (LoggedData) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) loggedData.userId) && Intrinsics.areEqual((Object) this.userName, (Object) loggedData.userName) && Intrinsics.areEqual((Object) this.phone, (Object) loggedData.phone) && Intrinsics.areEqual((Object) this.icon, (Object) loggedData.icon) && Intrinsics.areEqual((Object) this.f9231flyme, (Object) loggedData.f9231flyme) && Intrinsics.areEqual((Object) this.rememberMe, (Object) loggedData.rememberMe);
    }

    @NotNull
    public final String getFlyme() {
        return this.f9231flyme;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getPhone() {
        return this.phone;
    }

    @NotNull
    public final String getRememberMe() {
        return this.rememberMe;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        return (((((((((this.userId.hashCode() * 31) + this.userName.hashCode()) * 31) + this.phone.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.f9231flyme.hashCode()) * 31) + this.rememberMe.hashCode();
    }

    @NotNull
    public String toString() {
        return "LoggedData(userId=" + this.userId + ", userName=" + this.userName + ", phone=" + this.phone + ", icon=" + this.icon + ", flyme=" + this.f9231flyme + ", rememberMe=" + this.rememberMe + ')';
    }
}
