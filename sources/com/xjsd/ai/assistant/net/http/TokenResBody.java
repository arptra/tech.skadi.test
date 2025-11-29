package com.xjsd.ai.assistant.net.http;

import androidx.annotation.Keep;
import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/xjsd/ai/assistant/net/http/TokenResBody;", "", "code", "", "msg", "", "data", "Lcom/xjsd/ai/assistant/net/http/TokenResBody$Data;", "(ILjava/lang/String;Lcom/xjsd/ai/assistant/net/http/TokenResBody$Data;)V", "getCode", "()I", "getData", "()Lcom/xjsd/ai/assistant/net/http/TokenResBody$Data;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Data", "lib_assistant_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class TokenResBody {
    private final int code;
    @Nullable
    private final Data data;
    @NotNull
    private final String msg;

    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/xjsd/ai/assistant/net/http/TokenResBody$Data;", "", "accessToken", "", "exp", "", "(Ljava/lang/String;I)V", "getAccessToken", "()Ljava/lang/String;", "getExp", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "lib_assistant_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Data {
        @NotNull
        private final String accessToken;
        private final int exp;

        public Data(@NotNull String str, int i) {
            Intrinsics.checkNotNullParameter(str, "accessToken");
            this.accessToken = str;
            this.exp = i;
        }

        public static /* synthetic */ Data copy$default(Data data, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = data.accessToken;
            }
            if ((i2 & 2) != 0) {
                i = data.exp;
            }
            return data.copy(str, i);
        }

        @NotNull
        public final String component1() {
            return this.accessToken;
        }

        public final int component2() {
            return this.exp;
        }

        @NotNull
        public final Data copy(@NotNull String str, int i) {
            Intrinsics.checkNotNullParameter(str, "accessToken");
            return new Data(str, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual((Object) this.accessToken, (Object) data.accessToken) && this.exp == data.exp;
        }

        @NotNull
        public final String getAccessToken() {
            return this.accessToken;
        }

        public final int getExp() {
            return this.exp;
        }

        public int hashCode() {
            return (this.accessToken.hashCode() * 31) + Integer.hashCode(this.exp);
        }

        @NotNull
        public String toString() {
            String str = this.accessToken;
            int i = this.exp;
            return "Data(accessToken='" + str + "', exp=" + i + ")";
        }
    }

    public TokenResBody(int i, @NotNull String str, @Nullable Data data2) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        this.code = i;
        this.msg = str;
        this.data = data2;
    }

    public static /* synthetic */ TokenResBody copy$default(TokenResBody tokenResBody, int i, String str, Data data2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tokenResBody.code;
        }
        if ((i2 & 2) != 0) {
            str = tokenResBody.msg;
        }
        if ((i2 & 4) != 0) {
            data2 = tokenResBody.data;
        }
        return tokenResBody.copy(i, str, data2);
    }

    public final int component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.msg;
    }

    @Nullable
    public final Data component3() {
        return this.data;
    }

    @NotNull
    public final TokenResBody copy(int i, @NotNull String str, @Nullable Data data2) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        return new TokenResBody(i, str, data2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenResBody)) {
            return false;
        }
        TokenResBody tokenResBody = (TokenResBody) obj;
        return this.code == tokenResBody.code && Intrinsics.areEqual((Object) this.msg, (Object) tokenResBody.msg) && Intrinsics.areEqual((Object) this.data, (Object) tokenResBody.data);
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final Data getData() {
        return this.data;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.code) * 31) + this.msg.hashCode()) * 31;
        Data data2 = this.data;
        return hashCode + (data2 == null ? 0 : data2.hashCode());
    }

    @NotNull
    public String toString() {
        int i = this.code;
        String str = this.msg;
        Data data2 = this.data;
        return "TokenRepBody(code=" + i + ", msg='" + str + "', data=" + data2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TokenResBody(int i, String str, Data data2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : data2);
    }
}
