package com.xjsd.ai.assistant.net.http;

import androidx.annotation.Keep;
import com.honey.account.constant.AccountConstantKt;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/xjsd/ai/assistant/net/http/TokenReqBody;", "", "appid", "", "ukey", "authType", "", "time", "sign", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAppid", "()Ljava/lang/String;", "getAuthType", "()I", "getSign", "getTime", "getUkey", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "lib_assistant_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class TokenReqBody {
    @NotNull
    private final String appid;
    private final int authType;
    @NotNull
    private final String sign;
    @NotNull
    private final String time;
    @NotNull
    private final String ukey;

    public TokenReqBody(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_APP_ID);
        Intrinsics.checkNotNullParameter(str2, "ukey");
        Intrinsics.checkNotNullParameter(str3, RtspHeaders.Values.TIME);
        Intrinsics.checkNotNullParameter(str4, AccountConstantKt.REQUEST_HEADER_SIGN);
        this.appid = str;
        this.ukey = str2;
        this.authType = i;
        this.time = str3;
        this.sign = str4;
    }

    public static /* synthetic */ TokenReqBody copy$default(TokenReqBody tokenReqBody, String str, String str2, int i, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tokenReqBody.appid;
        }
        if ((i2 & 2) != 0) {
            str2 = tokenReqBody.ukey;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            i = tokenReqBody.authType;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = tokenReqBody.time;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = tokenReqBody.sign;
        }
        return tokenReqBody.copy(str, str5, i3, str6, str4);
    }

    @NotNull
    public final String component1() {
        return this.appid;
    }

    @NotNull
    public final String component2() {
        return this.ukey;
    }

    public final int component3() {
        return this.authType;
    }

    @NotNull
    public final String component4() {
        return this.time;
    }

    @NotNull
    public final String component5() {
        return this.sign;
    }

    @NotNull
    public final TokenReqBody copy(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.REQUEST_HEADER_APP_ID);
        Intrinsics.checkNotNullParameter(str2, "ukey");
        Intrinsics.checkNotNullParameter(str3, RtspHeaders.Values.TIME);
        Intrinsics.checkNotNullParameter(str4, AccountConstantKt.REQUEST_HEADER_SIGN);
        return new TokenReqBody(str, str2, i, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenReqBody)) {
            return false;
        }
        TokenReqBody tokenReqBody = (TokenReqBody) obj;
        return Intrinsics.areEqual((Object) this.appid, (Object) tokenReqBody.appid) && Intrinsics.areEqual((Object) this.ukey, (Object) tokenReqBody.ukey) && this.authType == tokenReqBody.authType && Intrinsics.areEqual((Object) this.time, (Object) tokenReqBody.time) && Intrinsics.areEqual((Object) this.sign, (Object) tokenReqBody.sign);
    }

    @NotNull
    public final String getAppid() {
        return this.appid;
    }

    public final int getAuthType() {
        return this.authType;
    }

    @NotNull
    public final String getSign() {
        return this.sign;
    }

    @NotNull
    public final String getTime() {
        return this.time;
    }

    @NotNull
    public final String getUkey() {
        return this.ukey;
    }

    public int hashCode() {
        return (((((((this.appid.hashCode() * 31) + this.ukey.hashCode()) * 31) + Integer.hashCode(this.authType)) * 31) + this.time.hashCode()) * 31) + this.sign.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.appid;
        String str2 = this.ukey;
        int i = this.authType;
        String str3 = this.time;
        String str4 = this.sign;
        return "TokenReqBody(appid=" + str + ", ukey=" + str2 + ", authType=" + i + ", time=" + str3 + ", sign=" + str4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TokenReqBody(String str, String str2, int i, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? 3 : i, str3, str4);
    }
}
