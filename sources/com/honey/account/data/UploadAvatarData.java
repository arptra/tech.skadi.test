package com.honey.account.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/honey/account/data/UploadAvatarData;", "", "code", "", "message", "", "icon", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getMessage", "setMessage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UploadAvatarData {
    private int code;
    @Nullable
    private String icon;
    @NotNull
    private String message;

    public UploadAvatarData(int i, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.code = i;
        this.message = str;
        this.icon = str2;
    }

    public static /* synthetic */ UploadAvatarData copy$default(UploadAvatarData uploadAvatarData, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = uploadAvatarData.code;
        }
        if ((i2 & 2) != 0) {
            str = uploadAvatarData.message;
        }
        if ((i2 & 4) != 0) {
            str2 = uploadAvatarData.icon;
        }
        return uploadAvatarData.copy(i, str, str2);
    }

    public final int component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    @Nullable
    public final String component3() {
        return this.icon;
    }

    @NotNull
    public final UploadAvatarData copy(int i, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new UploadAvatarData(i, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadAvatarData)) {
            return false;
        }
        UploadAvatarData uploadAvatarData = (UploadAvatarData) obj;
        return this.code == uploadAvatarData.code && Intrinsics.areEqual((Object) this.message, (Object) uploadAvatarData.message) && Intrinsics.areEqual((Object) this.icon, (Object) uploadAvatarData.icon);
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31;
        String str = this.icon;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setIcon(@Nullable String str) {
        this.icon = str;
    }

    public final void setMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    @NotNull
    public String toString() {
        return "UploadAvatarData(code=" + this.code + ", message=" + this.message + ", icon=" + this.icon + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadAvatarData(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : str2);
    }
}
