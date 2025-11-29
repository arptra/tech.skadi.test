package sdk.meizu.account.factor.authentication.sdk.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/data/ConfirmValue;", "", "validateCode", "", "validateMode", "(Ljava/lang/String;Ljava/lang/String;)V", "getValidateCode", "()Ljava/lang/String;", "getValidateMode", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConfirmValue {
    @NotNull
    private final String validateCode;
    @NotNull
    private final String validateMode;

    public ConfirmValue(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "validateCode");
        Intrinsics.checkNotNullParameter(str2, "validateMode");
        this.validateCode = str;
        this.validateMode = str2;
    }

    public static /* synthetic */ ConfirmValue copy$default(ConfirmValue confirmValue, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = confirmValue.validateCode;
        }
        if ((i & 2) != 0) {
            str2 = confirmValue.validateMode;
        }
        return confirmValue.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.validateCode;
    }

    @NotNull
    public final String component2() {
        return this.validateMode;
    }

    @NotNull
    public final ConfirmValue copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "validateCode");
        Intrinsics.checkNotNullParameter(str2, "validateMode");
        return new ConfirmValue(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfirmValue)) {
            return false;
        }
        ConfirmValue confirmValue = (ConfirmValue) obj;
        return Intrinsics.areEqual((Object) this.validateCode, (Object) confirmValue.validateCode) && Intrinsics.areEqual((Object) this.validateMode, (Object) confirmValue.validateMode);
    }

    @NotNull
    public final String getValidateCode() {
        return this.validateCode;
    }

    @NotNull
    public final String getValidateMode() {
        return this.validateMode;
    }

    public int hashCode() {
        return (this.validateCode.hashCode() * 31) + this.validateMode.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConfirmValue(validateCode=" + this.validateCode + ", validateMode=" + this.validateMode + ')';
    }
}
