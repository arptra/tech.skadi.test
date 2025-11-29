package com.upuphone.xr.sapp.monitor.schedule.model;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003Jc\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006'"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/RefreshTokenRespModel;", "", "accessToken", "", "appAccessToken", "corpId", "expireIn", "expiresIn", "refreshExpiresIn", "refreshToken", "scope", "tokenType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getAppAccessToken", "getCorpId", "getExpireIn", "getExpiresIn", "getRefreshExpiresIn", "getRefreshToken", "getScope", "getTokenType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class RefreshTokenRespModel {
    @NotNull
    private final String accessToken;
    @NotNull
    private final String appAccessToken;
    @NotNull
    private final String corpId;
    @NotNull
    private final String expireIn;
    @NotNull
    private final String expiresIn;
    @NotNull
    private final String refreshExpiresIn;
    @NotNull
    private final String refreshToken;
    @NotNull
    private final String scope;
    @NotNull
    private final String tokenType;

    public RefreshTokenRespModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str2, "appAccessToken");
        Intrinsics.checkNotNullParameter(str3, "corpId");
        Intrinsics.checkNotNullParameter(str4, "expireIn");
        Intrinsics.checkNotNullParameter(str5, "expiresIn");
        Intrinsics.checkNotNullParameter(str6, "refreshExpiresIn");
        Intrinsics.checkNotNullParameter(str7, "refreshToken");
        Intrinsics.checkNotNullParameter(str8, "scope");
        Intrinsics.checkNotNullParameter(str9, "tokenType");
        this.accessToken = str;
        this.appAccessToken = str2;
        this.corpId = str3;
        this.expireIn = str4;
        this.expiresIn = str5;
        this.refreshExpiresIn = str6;
        this.refreshToken = str7;
        this.scope = str8;
        this.tokenType = str9;
    }

    public static /* synthetic */ RefreshTokenRespModel copy$default(RefreshTokenRespModel refreshTokenRespModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        RefreshTokenRespModel refreshTokenRespModel2 = refreshTokenRespModel;
        int i2 = i;
        return refreshTokenRespModel.copy((i2 & 1) != 0 ? refreshTokenRespModel2.accessToken : str, (i2 & 2) != 0 ? refreshTokenRespModel2.appAccessToken : str2, (i2 & 4) != 0 ? refreshTokenRespModel2.corpId : str3, (i2 & 8) != 0 ? refreshTokenRespModel2.expireIn : str4, (i2 & 16) != 0 ? refreshTokenRespModel2.expiresIn : str5, (i2 & 32) != 0 ? refreshTokenRespModel2.refreshExpiresIn : str6, (i2 & 64) != 0 ? refreshTokenRespModel2.refreshToken : str7, (i2 & 128) != 0 ? refreshTokenRespModel2.scope : str8, (i2 & 256) != 0 ? refreshTokenRespModel2.tokenType : str9);
    }

    @NotNull
    public final String component1() {
        return this.accessToken;
    }

    @NotNull
    public final String component2() {
        return this.appAccessToken;
    }

    @NotNull
    public final String component3() {
        return this.corpId;
    }

    @NotNull
    public final String component4() {
        return this.expireIn;
    }

    @NotNull
    public final String component5() {
        return this.expiresIn;
    }

    @NotNull
    public final String component6() {
        return this.refreshExpiresIn;
    }

    @NotNull
    public final String component7() {
        return this.refreshToken;
    }

    @NotNull
    public final String component8() {
        return this.scope;
    }

    @NotNull
    public final String component9() {
        return this.tokenType;
    }

    @NotNull
    public final RefreshTokenRespModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str2, "appAccessToken");
        Intrinsics.checkNotNullParameter(str3, "corpId");
        Intrinsics.checkNotNullParameter(str4, "expireIn");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "expiresIn");
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, "refreshExpiresIn");
        String str12 = str7;
        Intrinsics.checkNotNullParameter(str12, "refreshToken");
        String str13 = str8;
        Intrinsics.checkNotNullParameter(str13, "scope");
        String str14 = str9;
        Intrinsics.checkNotNullParameter(str14, "tokenType");
        return new RefreshTokenRespModel(str, str2, str3, str4, str10, str11, str12, str13, str14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RefreshTokenRespModel)) {
            return false;
        }
        RefreshTokenRespModel refreshTokenRespModel = (RefreshTokenRespModel) obj;
        return Intrinsics.areEqual((Object) this.accessToken, (Object) refreshTokenRespModel.accessToken) && Intrinsics.areEqual((Object) this.appAccessToken, (Object) refreshTokenRespModel.appAccessToken) && Intrinsics.areEqual((Object) this.corpId, (Object) refreshTokenRespModel.corpId) && Intrinsics.areEqual((Object) this.expireIn, (Object) refreshTokenRespModel.expireIn) && Intrinsics.areEqual((Object) this.expiresIn, (Object) refreshTokenRespModel.expiresIn) && Intrinsics.areEqual((Object) this.refreshExpiresIn, (Object) refreshTokenRespModel.refreshExpiresIn) && Intrinsics.areEqual((Object) this.refreshToken, (Object) refreshTokenRespModel.refreshToken) && Intrinsics.areEqual((Object) this.scope, (Object) refreshTokenRespModel.scope) && Intrinsics.areEqual((Object) this.tokenType, (Object) refreshTokenRespModel.tokenType);
    }

    @NotNull
    public final String getAccessToken() {
        return this.accessToken;
    }

    @NotNull
    public final String getAppAccessToken() {
        return this.appAccessToken;
    }

    @NotNull
    public final String getCorpId() {
        return this.corpId;
    }

    @NotNull
    public final String getExpireIn() {
        return this.expireIn;
    }

    @NotNull
    public final String getExpiresIn() {
        return this.expiresIn;
    }

    @NotNull
    public final String getRefreshExpiresIn() {
        return this.refreshExpiresIn;
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

    public int hashCode() {
        return (((((((((((((((this.accessToken.hashCode() * 31) + this.appAccessToken.hashCode()) * 31) + this.corpId.hashCode()) * 31) + this.expireIn.hashCode()) * 31) + this.expiresIn.hashCode()) * 31) + this.refreshExpiresIn.hashCode()) * 31) + this.refreshToken.hashCode()) * 31) + this.scope.hashCode()) * 31) + this.tokenType.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.accessToken;
        String str2 = this.appAccessToken;
        String str3 = this.corpId;
        String str4 = this.expireIn;
        String str5 = this.expiresIn;
        String str6 = this.refreshExpiresIn;
        String str7 = this.refreshToken;
        String str8 = this.scope;
        String str9 = this.tokenType;
        return "RefreshTokenRespModel(accessToken=" + str + ", appAccessToken=" + str2 + ", corpId=" + str3 + ", expireIn=" + str4 + ", expiresIn=" + str5 + ", refreshExpiresIn=" + str6 + ", refreshToken=" + str7 + ", scope=" + str8 + ", tokenType=" + str9 + ")";
    }
}
