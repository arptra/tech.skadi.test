package com.honey.account.view.oauth.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/honey/account/view/oauth/data/ErrorTokenData;", "Lcom/honey/account/view/oauth/data/TokenData;", "error", "", "description", "(Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getError", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ErrorTokenData implements TokenData {
    @NotNull
    private final String description;
    @NotNull
    private final String error;

    public ErrorTokenData(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "error");
        Intrinsics.checkNotNullParameter(str2, "description");
        this.error = str;
        this.description = str2;
    }

    public static /* synthetic */ ErrorTokenData copy$default(ErrorTokenData errorTokenData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = errorTokenData.error;
        }
        if ((i & 2) != 0) {
            str2 = errorTokenData.description;
        }
        return errorTokenData.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.error;
    }

    @NotNull
    public final String component2() {
        return this.description;
    }

    @NotNull
    public final ErrorTokenData copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "error");
        Intrinsics.checkNotNullParameter(str2, "description");
        return new ErrorTokenData(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorTokenData)) {
            return false;
        }
        ErrorTokenData errorTokenData = (ErrorTokenData) obj;
        return Intrinsics.areEqual((Object) this.error, (Object) errorTokenData.error) && Intrinsics.areEqual((Object) this.description, (Object) errorTokenData.description);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getError() {
        return this.error;
    }

    public int hashCode() {
        return (this.error.hashCode() * 31) + this.description.hashCode();
    }

    @NotNull
    public String toString() {
        return "ErrorTokenData(error=" + this.error + ", description=" + this.description + ')';
    }
}
