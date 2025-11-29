package com.honey.account.view.oauth.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/honey/account/view/oauth/data/OAuthTokenData;", "Lcom/honey/account/view/oauth/data/TokenData;", "accessToken", "", "tokenType", "refreshToken", "scope", "userId", "phone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getPhone", "getRefreshToken", "getScope", "getTokenType", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OAuthTokenData implements TokenData {
    @SerializedName("access_token")
    @NotNull
    private final String accessToken;
    @SerializedName("phone")
    @NotNull
    private final String phone;
    @SerializedName("refresh_token")
    @NotNull
    private final String refreshToken;
    @SerializedName("scope")
    @NotNull
    private final String scope;
    @SerializedName("token_type")
    @NotNull
    private final String tokenType;
    @SerializedName("user_id")
    @NotNull
    private final String userId;

    public OAuthTokenData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str2, "tokenType");
        Intrinsics.checkNotNullParameter(str3, "refreshToken");
        Intrinsics.checkNotNullParameter(str4, "scope");
        Intrinsics.checkNotNullParameter(str5, "userId");
        Intrinsics.checkNotNullParameter(str6, "phone");
        this.accessToken = str;
        this.tokenType = str2;
        this.refreshToken = str3;
        this.scope = str4;
        this.userId = str5;
        this.phone = str6;
    }

    public static /* synthetic */ OAuthTokenData copy$default(OAuthTokenData oAuthTokenData, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oAuthTokenData.accessToken;
        }
        if ((i & 2) != 0) {
            str2 = oAuthTokenData.tokenType;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = oAuthTokenData.refreshToken;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = oAuthTokenData.scope;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = oAuthTokenData.userId;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = oAuthTokenData.phone;
        }
        return oAuthTokenData.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.accessToken;
    }

    @NotNull
    public final String component2() {
        return this.tokenType;
    }

    @NotNull
    public final String component3() {
        return this.refreshToken;
    }

    @NotNull
    public final String component4() {
        return this.scope;
    }

    @NotNull
    public final String component5() {
        return this.userId;
    }

    @NotNull
    public final String component6() {
        return this.phone;
    }

    @NotNull
    public final OAuthTokenData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str2, "tokenType");
        Intrinsics.checkNotNullParameter(str3, "refreshToken");
        Intrinsics.checkNotNullParameter(str4, "scope");
        Intrinsics.checkNotNullParameter(str5, "userId");
        Intrinsics.checkNotNullParameter(str6, "phone");
        return new OAuthTokenData(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OAuthTokenData)) {
            return false;
        }
        OAuthTokenData oAuthTokenData = (OAuthTokenData) obj;
        return Intrinsics.areEqual((Object) this.accessToken, (Object) oAuthTokenData.accessToken) && Intrinsics.areEqual((Object) this.tokenType, (Object) oAuthTokenData.tokenType) && Intrinsics.areEqual((Object) this.refreshToken, (Object) oAuthTokenData.refreshToken) && Intrinsics.areEqual((Object) this.scope, (Object) oAuthTokenData.scope) && Intrinsics.areEqual((Object) this.userId, (Object) oAuthTokenData.userId) && Intrinsics.areEqual((Object) this.phone, (Object) oAuthTokenData.phone);
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    public final String getPhone() {
        return this.phone;
    }

    @NotNull
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @NotNull
    public final String getScope() {
        return this.scope;
    }

    @NotNull
    public final String getTokenType() {
        return this.tokenType;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((((((((this.accessToken.hashCode() * 31) + this.tokenType.hashCode()) * 31) + this.refreshToken.hashCode()) * 31) + this.scope.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.phone.hashCode();
    }

    @NotNull
    public String toString() {
        return "OAuthTokenData(accessToken=" + this.accessToken + ", tokenType=" + this.tokenType + ", refreshToken=" + this.refreshToken + ", scope=" + this.scope + ", userId=" + this.userId + ", phone=" + this.phone + ')';
    }
}
