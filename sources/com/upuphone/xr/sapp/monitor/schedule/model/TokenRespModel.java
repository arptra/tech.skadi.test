package com.upuphone.xr.sapp.monitor.schedule.model;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/TokenRespModel;", "", "userDdAccessTokenPO", "Lcom/upuphone/xr/sapp/monitor/schedule/model/TokenRespModel$UserDdAccessTokenPO;", "userFsAccessTokenPO", "Lcom/upuphone/xr/sapp/monitor/schedule/model/TokenRespModel$UserFsAccessTokenPO;", "(Lcom/upuphone/xr/sapp/monitor/schedule/model/TokenRespModel$UserDdAccessTokenPO;Lcom/upuphone/xr/sapp/monitor/schedule/model/TokenRespModel$UserFsAccessTokenPO;)V", "getUserDdAccessTokenPO", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/TokenRespModel$UserDdAccessTokenPO;", "getUserFsAccessTokenPO", "()Lcom/upuphone/xr/sapp/monitor/schedule/model/TokenRespModel$UserFsAccessTokenPO;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "UserDdAccessTokenPO", "UserFsAccessTokenPO", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class TokenRespModel {
    @Nullable
    private final UserDdAccessTokenPO userDdAccessTokenPO;
    @Nullable
    private final UserFsAccessTokenPO userFsAccessTokenPO;

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/TokenRespModel$UserDdAccessTokenPO;", "", "accessToken", "", "corpId", "expireIn", "refreshToken", "unionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getCorpId", "getExpireIn", "getRefreshToken", "getUnionId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UserDdAccessTokenPO {
        @NotNull
        private final String accessToken;
        @NotNull
        private final String corpId;
        @NotNull
        private final String expireIn;
        @NotNull
        private final String refreshToken;
        @NotNull
        private final String unionId;

        public UserDdAccessTokenPO(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(str, "accessToken");
            Intrinsics.checkNotNullParameter(str2, "corpId");
            Intrinsics.checkNotNullParameter(str3, "expireIn");
            Intrinsics.checkNotNullParameter(str4, "refreshToken");
            Intrinsics.checkNotNullParameter(str5, "unionId");
            this.accessToken = str;
            this.corpId = str2;
            this.expireIn = str3;
            this.refreshToken = str4;
            this.unionId = str5;
        }

        public static /* synthetic */ UserDdAccessTokenPO copy$default(UserDdAccessTokenPO userDdAccessTokenPO, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userDdAccessTokenPO.accessToken;
            }
            if ((i & 2) != 0) {
                str2 = userDdAccessTokenPO.corpId;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = userDdAccessTokenPO.expireIn;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = userDdAccessTokenPO.refreshToken;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = userDdAccessTokenPO.unionId;
            }
            return userDdAccessTokenPO.copy(str, str6, str7, str8, str5);
        }

        @NotNull
        public final String component1() {
            return this.accessToken;
        }

        @NotNull
        public final String component2() {
            return this.corpId;
        }

        @NotNull
        public final String component3() {
            return this.expireIn;
        }

        @NotNull
        public final String component4() {
            return this.refreshToken;
        }

        @NotNull
        public final String component5() {
            return this.unionId;
        }

        @NotNull
        public final UserDdAccessTokenPO copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(str, "accessToken");
            Intrinsics.checkNotNullParameter(str2, "corpId");
            Intrinsics.checkNotNullParameter(str3, "expireIn");
            Intrinsics.checkNotNullParameter(str4, "refreshToken");
            Intrinsics.checkNotNullParameter(str5, "unionId");
            return new UserDdAccessTokenPO(str, str2, str3, str4, str5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserDdAccessTokenPO)) {
                return false;
            }
            UserDdAccessTokenPO userDdAccessTokenPO = (UserDdAccessTokenPO) obj;
            return Intrinsics.areEqual((Object) this.accessToken, (Object) userDdAccessTokenPO.accessToken) && Intrinsics.areEqual((Object) this.corpId, (Object) userDdAccessTokenPO.corpId) && Intrinsics.areEqual((Object) this.expireIn, (Object) userDdAccessTokenPO.expireIn) && Intrinsics.areEqual((Object) this.refreshToken, (Object) userDdAccessTokenPO.refreshToken) && Intrinsics.areEqual((Object) this.unionId, (Object) userDdAccessTokenPO.unionId);
        }

        @NotNull
        public final String getAccessToken() {
            return this.accessToken;
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
        public final String getRefreshToken() {
            return this.refreshToken;
        }

        @NotNull
        public final String getUnionId() {
            return this.unionId;
        }

        public int hashCode() {
            return (((((((this.accessToken.hashCode() * 31) + this.corpId.hashCode()) * 31) + this.expireIn.hashCode()) * 31) + this.refreshToken.hashCode()) * 31) + this.unionId.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.accessToken;
            String str2 = this.corpId;
            String str3 = this.expireIn;
            String str4 = this.refreshToken;
            String str5 = this.unionId;
            return "UserDdAccessTokenPO(accessToken=" + str + ", corpId=" + str2 + ", expireIn=" + str3 + ", refreshToken=" + str4 + ", unionId=" + str5 + ")";
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/model/TokenRespModel$UserFsAccessTokenPO;", "", "accessToken", "", "refreshExpiresIn", "", "refreshToken", "tokenType", "expiresIn", "scope", "userId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getExpiresIn", "()I", "getRefreshExpiresIn", "getRefreshToken", "getScope", "getTokenType", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UserFsAccessTokenPO {
        @NotNull
        private final String accessToken;
        private final int expiresIn;
        private final int refreshExpiresIn;
        @NotNull
        private final String refreshToken;
        @NotNull
        private final String scope;
        @NotNull
        private final String tokenType;
        @NotNull
        private final String userId;

        public UserFsAccessTokenPO(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, int i2, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(str, "accessToken");
            Intrinsics.checkNotNullParameter(str2, "refreshToken");
            Intrinsics.checkNotNullParameter(str3, "tokenType");
            Intrinsics.checkNotNullParameter(str4, "scope");
            Intrinsics.checkNotNullParameter(str5, "userId");
            this.accessToken = str;
            this.refreshExpiresIn = i;
            this.refreshToken = str2;
            this.tokenType = str3;
            this.expiresIn = i2;
            this.scope = str4;
            this.userId = str5;
        }

        public static /* synthetic */ UserFsAccessTokenPO copy$default(UserFsAccessTokenPO userFsAccessTokenPO, String str, int i, String str2, String str3, int i2, String str4, String str5, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = userFsAccessTokenPO.accessToken;
            }
            if ((i3 & 2) != 0) {
                i = userFsAccessTokenPO.refreshExpiresIn;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                str2 = userFsAccessTokenPO.refreshToken;
            }
            String str6 = str2;
            if ((i3 & 8) != 0) {
                str3 = userFsAccessTokenPO.tokenType;
            }
            String str7 = str3;
            if ((i3 & 16) != 0) {
                i2 = userFsAccessTokenPO.expiresIn;
            }
            int i5 = i2;
            if ((i3 & 32) != 0) {
                str4 = userFsAccessTokenPO.scope;
            }
            String str8 = str4;
            if ((i3 & 64) != 0) {
                str5 = userFsAccessTokenPO.userId;
            }
            return userFsAccessTokenPO.copy(str, i4, str6, str7, i5, str8, str5);
        }

        @NotNull
        public final String component1() {
            return this.accessToken;
        }

        public final int component2() {
            return this.refreshExpiresIn;
        }

        @NotNull
        public final String component3() {
            return this.refreshToken;
        }

        @NotNull
        public final String component4() {
            return this.tokenType;
        }

        public final int component5() {
            return this.expiresIn;
        }

        @NotNull
        public final String component6() {
            return this.scope;
        }

        @NotNull
        public final String component7() {
            return this.userId;
        }

        @NotNull
        public final UserFsAccessTokenPO copy(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, int i2, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(str, "accessToken");
            Intrinsics.checkNotNullParameter(str2, "refreshToken");
            Intrinsics.checkNotNullParameter(str3, "tokenType");
            Intrinsics.checkNotNullParameter(str4, "scope");
            Intrinsics.checkNotNullParameter(str5, "userId");
            return new UserFsAccessTokenPO(str, i, str2, str3, i2, str4, str5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserFsAccessTokenPO)) {
                return false;
            }
            UserFsAccessTokenPO userFsAccessTokenPO = (UserFsAccessTokenPO) obj;
            return Intrinsics.areEqual((Object) this.accessToken, (Object) userFsAccessTokenPO.accessToken) && this.refreshExpiresIn == userFsAccessTokenPO.refreshExpiresIn && Intrinsics.areEqual((Object) this.refreshToken, (Object) userFsAccessTokenPO.refreshToken) && Intrinsics.areEqual((Object) this.tokenType, (Object) userFsAccessTokenPO.tokenType) && this.expiresIn == userFsAccessTokenPO.expiresIn && Intrinsics.areEqual((Object) this.scope, (Object) userFsAccessTokenPO.scope) && Intrinsics.areEqual((Object) this.userId, (Object) userFsAccessTokenPO.userId);
        }

        @NotNull
        public final String getAccessToken() {
            return this.accessToken;
        }

        public final int getExpiresIn() {
            return this.expiresIn;
        }

        public final int getRefreshExpiresIn() {
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

        @NotNull
        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return (((((((((((this.accessToken.hashCode() * 31) + Integer.hashCode(this.refreshExpiresIn)) * 31) + this.refreshToken.hashCode()) * 31) + this.tokenType.hashCode()) * 31) + Integer.hashCode(this.expiresIn)) * 31) + this.scope.hashCode()) * 31) + this.userId.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.accessToken;
            int i = this.refreshExpiresIn;
            String str2 = this.refreshToken;
            String str3 = this.tokenType;
            int i2 = this.expiresIn;
            String str4 = this.scope;
            String str5 = this.userId;
            return "UserFsAccessTokenPO(accessToken=" + str + ", refreshExpiresIn=" + i + ", refreshToken=" + str2 + ", tokenType=" + str3 + ", expiresIn=" + i2 + ", scope=" + str4 + ", userId=" + str5 + ")";
        }
    }

    public TokenRespModel(@Nullable UserDdAccessTokenPO userDdAccessTokenPO2, @Nullable UserFsAccessTokenPO userFsAccessTokenPO2) {
        this.userDdAccessTokenPO = userDdAccessTokenPO2;
        this.userFsAccessTokenPO = userFsAccessTokenPO2;
    }

    public static /* synthetic */ TokenRespModel copy$default(TokenRespModel tokenRespModel, UserDdAccessTokenPO userDdAccessTokenPO2, UserFsAccessTokenPO userFsAccessTokenPO2, int i, Object obj) {
        if ((i & 1) != 0) {
            userDdAccessTokenPO2 = tokenRespModel.userDdAccessTokenPO;
        }
        if ((i & 2) != 0) {
            userFsAccessTokenPO2 = tokenRespModel.userFsAccessTokenPO;
        }
        return tokenRespModel.copy(userDdAccessTokenPO2, userFsAccessTokenPO2);
    }

    @Nullable
    public final UserDdAccessTokenPO component1() {
        return this.userDdAccessTokenPO;
    }

    @Nullable
    public final UserFsAccessTokenPO component2() {
        return this.userFsAccessTokenPO;
    }

    @NotNull
    public final TokenRespModel copy(@Nullable UserDdAccessTokenPO userDdAccessTokenPO2, @Nullable UserFsAccessTokenPO userFsAccessTokenPO2) {
        return new TokenRespModel(userDdAccessTokenPO2, userFsAccessTokenPO2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenRespModel)) {
            return false;
        }
        TokenRespModel tokenRespModel = (TokenRespModel) obj;
        return Intrinsics.areEqual((Object) this.userDdAccessTokenPO, (Object) tokenRespModel.userDdAccessTokenPO) && Intrinsics.areEqual((Object) this.userFsAccessTokenPO, (Object) tokenRespModel.userFsAccessTokenPO);
    }

    @Nullable
    public final UserDdAccessTokenPO getUserDdAccessTokenPO() {
        return this.userDdAccessTokenPO;
    }

    @Nullable
    public final UserFsAccessTokenPO getUserFsAccessTokenPO() {
        return this.userFsAccessTokenPO;
    }

    public int hashCode() {
        UserDdAccessTokenPO userDdAccessTokenPO2 = this.userDdAccessTokenPO;
        int i = 0;
        int hashCode = (userDdAccessTokenPO2 == null ? 0 : userDdAccessTokenPO2.hashCode()) * 31;
        UserFsAccessTokenPO userFsAccessTokenPO2 = this.userFsAccessTokenPO;
        if (userFsAccessTokenPO2 != null) {
            i = userFsAccessTokenPO2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        UserDdAccessTokenPO userDdAccessTokenPO2 = this.userDdAccessTokenPO;
        UserFsAccessTokenPO userFsAccessTokenPO2 = this.userFsAccessTokenPO;
        return "TokenRespModel(userDdAccessTokenPO=" + userDdAccessTokenPO2 + ", userFsAccessTokenPO=" + userFsAccessTokenPO2 + ")";
    }
}
