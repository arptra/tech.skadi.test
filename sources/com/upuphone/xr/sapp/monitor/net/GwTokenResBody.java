package com.upuphone.xr.sapp.monitor.net;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001\"B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014JF\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\b\u0010!\u001a\u00020\u0006H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/net/GwTokenResBody;", "", "status", "", "code", "msg", "", "data", "Lcom/upuphone/xr/sapp/monitor/net/GwTokenResBody$GwTokenData;", "tstamp", "", "(IILjava/lang/String;Lcom/upuphone/xr/sapp/monitor/net/GwTokenResBody$GwTokenData;Ljava/lang/Long;)V", "getCode", "()I", "getData", "()Lcom/upuphone/xr/sapp/monitor/net/GwTokenResBody$GwTokenData;", "getMsg", "()Ljava/lang/String;", "getStatus", "getTstamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(IILjava/lang/String;Lcom/upuphone/xr/sapp/monitor/net/GwTokenResBody$GwTokenData;Ljava/lang/Long;)Lcom/upuphone/xr/sapp/monitor/net/GwTokenResBody;", "equals", "", "other", "hashCode", "toString", "GwTokenData", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GwTokenResBody {
    private final int code;
    @Nullable
    private final GwTokenData data;
    @Nullable
    private final String msg;
    private final int status;
    @Nullable
    private final Long tstamp;

    @Keep
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/net/GwTokenResBody$GwTokenData;", "", "accessToken", "", "refreshToken", "tokenType", "expiresIn", "", "tstamp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getAccessToken", "()Ljava/lang/String;", "getExpiresIn", "()J", "getRefreshToken", "getTokenType", "getTstamp", "setTstamp", "(J)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GwTokenData {
        @NotNull
        private final String accessToken;
        private final long expiresIn;
        @NotNull
        private final String refreshToken;
        @NotNull
        private final String tokenType;
        private long tstamp;

        public GwTokenData(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, long j2) {
            Intrinsics.checkNotNullParameter(str, "accessToken");
            Intrinsics.checkNotNullParameter(str2, "refreshToken");
            Intrinsics.checkNotNullParameter(str3, "tokenType");
            this.accessToken = str;
            this.refreshToken = str2;
            this.tokenType = str3;
            this.expiresIn = j;
            this.tstamp = j2;
        }

        public static /* synthetic */ GwTokenData copy$default(GwTokenData gwTokenData, String str, String str2, String str3, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gwTokenData.accessToken;
            }
            if ((i & 2) != 0) {
                str2 = gwTokenData.refreshToken;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                str3 = gwTokenData.tokenType;
            }
            String str5 = str3;
            if ((i & 8) != 0) {
                j = gwTokenData.expiresIn;
            }
            long j3 = j;
            if ((i & 16) != 0) {
                j2 = gwTokenData.tstamp;
            }
            return gwTokenData.copy(str, str4, str5, j3, j2);
        }

        @NotNull
        public final String component1() {
            return this.accessToken;
        }

        @NotNull
        public final String component2() {
            return this.refreshToken;
        }

        @NotNull
        public final String component3() {
            return this.tokenType;
        }

        public final long component4() {
            return this.expiresIn;
        }

        public final long component5() {
            return this.tstamp;
        }

        @NotNull
        public final GwTokenData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, long j2) {
            Intrinsics.checkNotNullParameter(str, "accessToken");
            Intrinsics.checkNotNullParameter(str2, "refreshToken");
            Intrinsics.checkNotNullParameter(str3, "tokenType");
            return new GwTokenData(str, str2, str3, j, j2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GwTokenData)) {
                return false;
            }
            GwTokenData gwTokenData = (GwTokenData) obj;
            return Intrinsics.areEqual((Object) this.accessToken, (Object) gwTokenData.accessToken) && Intrinsics.areEqual((Object) this.refreshToken, (Object) gwTokenData.refreshToken) && Intrinsics.areEqual((Object) this.tokenType, (Object) gwTokenData.tokenType) && this.expiresIn == gwTokenData.expiresIn && this.tstamp == gwTokenData.tstamp;
        }

        @NotNull
        public final String getAccessToken() {
            return this.accessToken;
        }

        public final long getExpiresIn() {
            return this.expiresIn;
        }

        @NotNull
        public final String getRefreshToken() {
            return this.refreshToken;
        }

        @NotNull
        public final String getTokenType() {
            return this.tokenType;
        }

        public final long getTstamp() {
            return this.tstamp;
        }

        public int hashCode() {
            return (((((((this.accessToken.hashCode() * 31) + this.refreshToken.hashCode()) * 31) + this.tokenType.hashCode()) * 31) + Long.hashCode(this.expiresIn)) * 31) + Long.hashCode(this.tstamp);
        }

        public final void setTstamp(long j) {
            this.tstamp = j;
        }

        @NotNull
        public String toString() {
            String str = this.accessToken;
            String str2 = this.refreshToken;
            String str3 = this.tokenType;
            long j = this.expiresIn;
            long j2 = this.tstamp;
            return "GwTokenData(accessToken='" + str + "', refreshToken='" + str2 + "', tokenType='" + str3 + "', expiresIn=" + j + ", tstamp=" + j2 + ")";
        }
    }

    public GwTokenResBody(int i, int i2, @Nullable String str, @Nullable GwTokenData gwTokenData, @Nullable Long l) {
        this.status = i;
        this.code = i2;
        this.msg = str;
        this.data = gwTokenData;
        this.tstamp = l;
    }

    public static /* synthetic */ GwTokenResBody copy$default(GwTokenResBody gwTokenResBody, int i, int i2, String str, GwTokenData gwTokenData, Long l, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = gwTokenResBody.status;
        }
        if ((i3 & 2) != 0) {
            i2 = gwTokenResBody.code;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            str = gwTokenResBody.msg;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            gwTokenData = gwTokenResBody.data;
        }
        GwTokenData gwTokenData2 = gwTokenData;
        if ((i3 & 16) != 0) {
            l = gwTokenResBody.tstamp;
        }
        return gwTokenResBody.copy(i, i4, str2, gwTokenData2, l);
    }

    public final int component1() {
        return this.status;
    }

    public final int component2() {
        return this.code;
    }

    @Nullable
    public final String component3() {
        return this.msg;
    }

    @Nullable
    public final GwTokenData component4() {
        return this.data;
    }

    @Nullable
    public final Long component5() {
        return this.tstamp;
    }

    @NotNull
    public final GwTokenResBody copy(int i, int i2, @Nullable String str, @Nullable GwTokenData gwTokenData, @Nullable Long l) {
        return new GwTokenResBody(i, i2, str, gwTokenData, l);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GwTokenResBody)) {
            return false;
        }
        GwTokenResBody gwTokenResBody = (GwTokenResBody) obj;
        return this.status == gwTokenResBody.status && this.code == gwTokenResBody.code && Intrinsics.areEqual((Object) this.msg, (Object) gwTokenResBody.msg) && Intrinsics.areEqual((Object) this.data, (Object) gwTokenResBody.data) && Intrinsics.areEqual((Object) this.tstamp, (Object) gwTokenResBody.tstamp);
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final GwTokenData getData() {
        return this.data;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public final int getStatus() {
        return this.status;
    }

    @Nullable
    public final Long getTstamp() {
        return this.tstamp;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.status) * 31) + Integer.hashCode(this.code)) * 31;
        String str = this.msg;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        GwTokenData gwTokenData = this.data;
        int hashCode3 = (hashCode2 + (gwTokenData == null ? 0 : gwTokenData.hashCode())) * 31;
        Long l = this.tstamp;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        int i = this.status;
        int i2 = this.code;
        String str = this.msg;
        GwTokenData gwTokenData = this.data;
        Long l = this.tstamp;
        return "GwTokenResBody(status=" + i + ", code=" + i2 + ", msg=" + str + ", data=" + gwTokenData + ", tstamp=" + l + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GwTokenResBody(int i, int i2, String str, GwTokenData gwTokenData, Long l, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : gwTokenData, (i3 & 16) != 0 ? null : l);
    }
}
