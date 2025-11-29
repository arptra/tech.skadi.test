package com.honey.account.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014¨\u0006 "}, d2 = {"Lcom/honey/account/data/RememberMeToPasswordData;", "", "code", "", "message", "", "isNew", "", "rememberMe", "(ILjava/lang/String;ZLjava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "()Z", "setNew", "(Z)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getRememberMe", "setRememberMe", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RememberMeToPasswordData {
    private int code;
    private boolean isNew;
    @NotNull
    private String message;
    @Nullable
    private String rememberMe;

    public RememberMeToPasswordData(int i, @NotNull String str, boolean z, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.code = i;
        this.message = str;
        this.isNew = z;
        this.rememberMe = str2;
    }

    public static /* synthetic */ RememberMeToPasswordData copy$default(RememberMeToPasswordData rememberMeToPasswordData, int i, String str, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = rememberMeToPasswordData.code;
        }
        if ((i2 & 2) != 0) {
            str = rememberMeToPasswordData.message;
        }
        if ((i2 & 4) != 0) {
            z = rememberMeToPasswordData.isNew;
        }
        if ((i2 & 8) != 0) {
            str2 = rememberMeToPasswordData.rememberMe;
        }
        return rememberMeToPasswordData.copy(i, str, z, str2);
    }

    public final int component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    public final boolean component3() {
        return this.isNew;
    }

    @Nullable
    public final String component4() {
        return this.rememberMe;
    }

    @NotNull
    public final RememberMeToPasswordData copy(int i, @NotNull String str, boolean z, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new RememberMeToPasswordData(i, str, z, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RememberMeToPasswordData)) {
            return false;
        }
        RememberMeToPasswordData rememberMeToPasswordData = (RememberMeToPasswordData) obj;
        return this.code == rememberMeToPasswordData.code && Intrinsics.areEqual((Object) this.message, (Object) rememberMeToPasswordData.message) && this.isNew == rememberMeToPasswordData.isNew && Intrinsics.areEqual((Object) this.rememberMe, (Object) rememberMeToPasswordData.rememberMe);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getRememberMe() {
        return this.rememberMe;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31;
        boolean z = this.isNew;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        String str = this.rememberMe;
        return i + (str == null ? 0 : str.hashCode());
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final void setNew(boolean z) {
        this.isNew = z;
    }

    public final void setRememberMe(@Nullable String str) {
        this.rememberMe = str;
    }

    @NotNull
    public String toString() {
        return "RememberMeToPasswordData(code=" + this.code + ", message=" + this.message + ", isNew=" + this.isNew + ", rememberMe=" + this.rememberMe + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RememberMeToPasswordData(int i, String str, boolean z, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : str2);
    }
}
