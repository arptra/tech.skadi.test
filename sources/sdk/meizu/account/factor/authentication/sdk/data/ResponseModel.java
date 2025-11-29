package sdk.meizu.account.factor.authentication.sdk.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000eJ>\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/data/ResponseModel;", "T", "", "code", "", "message", "redirect", "value", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getCode", "()Ljava/lang/String;", "getMessage", "getRedirect", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lsdk/meizu/account/factor/authentication/sdk/data/ResponseModel;", "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ResponseModel<T> {
    @NotNull
    private final String code;
    @NotNull
    private final String message;
    @NotNull
    private final String redirect;
    @Nullable
    private final T value;

    public ResponseModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable T t) {
        Intrinsics.checkNotNullParameter(str, "code");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "redirect");
        this.code = str;
        this.message = str2;
        this.redirect = str3;
        this.value = t;
    }

    public static /* synthetic */ ResponseModel copy$default(ResponseModel responseModel, String str, String str2, String str3, T t, int i, Object obj) {
        if ((i & 1) != 0) {
            str = responseModel.code;
        }
        if ((i & 2) != 0) {
            str2 = responseModel.message;
        }
        if ((i & 4) != 0) {
            str3 = responseModel.redirect;
        }
        if ((i & 8) != 0) {
            t = responseModel.value;
        }
        return responseModel.copy(str, str2, str3, t);
    }

    @NotNull
    public final String component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    @NotNull
    public final String component3() {
        return this.redirect;
    }

    @Nullable
    public final T component4() {
        return this.value;
    }

    @NotNull
    public final ResponseModel<T> copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable T t) {
        Intrinsics.checkNotNullParameter(str, "code");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "redirect");
        return new ResponseModel<>(str, str2, str3, t);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseModel)) {
            return false;
        }
        ResponseModel responseModel = (ResponseModel) obj;
        return Intrinsics.areEqual((Object) this.code, (Object) responseModel.code) && Intrinsics.areEqual((Object) this.message, (Object) responseModel.message) && Intrinsics.areEqual((Object) this.redirect, (Object) responseModel.redirect) && Intrinsics.areEqual((Object) this.value, (Object) responseModel.value);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getRedirect() {
        return this.redirect;
    }

    @Nullable
    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = ((((this.code.hashCode() * 31) + this.message.hashCode()) * 31) + this.redirect.hashCode()) * 31;
        T t = this.value;
        return hashCode + (t == null ? 0 : t.hashCode());
    }

    @NotNull
    public String toString() {
        return "ResponseModel(code=" + this.code + ", message=" + this.message + ", redirect=" + this.redirect + ", value=" + this.value + ')';
    }
}
