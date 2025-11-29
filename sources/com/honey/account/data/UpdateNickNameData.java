package com.honey.account.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/honey/account/data/UpdateNickNameData;", "", "code", "", "message", "", "success", "", "(ILjava/lang/String;Z)V", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getSuccess", "()Z", "setSuccess", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UpdateNickNameData {
    private int code;
    @NotNull
    private String message;
    private boolean success;

    public UpdateNickNameData(int i, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.code = i;
        this.message = str;
        this.success = z;
    }

    public static /* synthetic */ UpdateNickNameData copy$default(UpdateNickNameData updateNickNameData, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = updateNickNameData.code;
        }
        if ((i2 & 2) != 0) {
            str = updateNickNameData.message;
        }
        if ((i2 & 4) != 0) {
            z = updateNickNameData.success;
        }
        return updateNickNameData.copy(i, str, z);
    }

    public final int component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    public final boolean component3() {
        return this.success;
    }

    @NotNull
    public final UpdateNickNameData copy(int i, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new UpdateNickNameData(i, str, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateNickNameData)) {
            return false;
        }
        UpdateNickNameData updateNickNameData = (UpdateNickNameData) obj;
        return this.code == updateNickNameData.code && Intrinsics.areEqual((Object) this.message, (Object) updateNickNameData.message) && this.success == updateNickNameData.success;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31;
        boolean z = this.success;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    @NotNull
    public String toString() {
        return "UpdateNickNameData(code=" + this.code + ", message=" + this.message + ", success=" + this.success + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UpdateNickNameData(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? false : z);
    }
}
