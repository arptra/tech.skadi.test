package com.upuphone.ar.transcribe.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/bean/TempStorageTransResult;", "", "ownerType", "", "content", "", "isFirstTemp", "", "recognizeId", "(ILjava/lang/String;ZLjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "()Z", "setFirstTemp", "(Z)V", "getOwnerType", "()I", "getRecognizeId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TempStorageTransResult {
    @NotNull
    private final String content;
    private boolean isFirstTemp;
    private final int ownerType;
    @NotNull
    private final String recognizeId;

    public TempStorageTransResult(int i, @NotNull String str, boolean z, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "recognizeId");
        this.ownerType = i;
        this.content = str;
        this.isFirstTemp = z;
        this.recognizeId = str2;
    }

    public static /* synthetic */ TempStorageTransResult copy$default(TempStorageTransResult tempStorageTransResult, int i, String str, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tempStorageTransResult.ownerType;
        }
        if ((i2 & 2) != 0) {
            str = tempStorageTransResult.content;
        }
        if ((i2 & 4) != 0) {
            z = tempStorageTransResult.isFirstTemp;
        }
        if ((i2 & 8) != 0) {
            str2 = tempStorageTransResult.recognizeId;
        }
        return tempStorageTransResult.copy(i, str, z, str2);
    }

    public final int component1() {
        return this.ownerType;
    }

    @NotNull
    public final String component2() {
        return this.content;
    }

    public final boolean component3() {
        return this.isFirstTemp;
    }

    @NotNull
    public final String component4() {
        return this.recognizeId;
    }

    @NotNull
    public final TempStorageTransResult copy(int i, @NotNull String str, boolean z, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "recognizeId");
        return new TempStorageTransResult(i, str, z, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TempStorageTransResult)) {
            return false;
        }
        TempStorageTransResult tempStorageTransResult = (TempStorageTransResult) obj;
        return this.ownerType == tempStorageTransResult.ownerType && Intrinsics.areEqual((Object) this.content, (Object) tempStorageTransResult.content) && this.isFirstTemp == tempStorageTransResult.isFirstTemp && Intrinsics.areEqual((Object) this.recognizeId, (Object) tempStorageTransResult.recognizeId);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getOwnerType() {
        return this.ownerType;
    }

    @NotNull
    public final String getRecognizeId() {
        return this.recognizeId;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.ownerType) * 31) + this.content.hashCode()) * 31) + Boolean.hashCode(this.isFirstTemp)) * 31) + this.recognizeId.hashCode();
    }

    public final boolean isFirstTemp() {
        return this.isFirstTemp;
    }

    public final void setFirstTemp(boolean z) {
        this.isFirstTemp = z;
    }

    @NotNull
    public String toString() {
        int i = this.ownerType;
        String str = this.content;
        boolean z = this.isFirstTemp;
        String str2 = this.recognizeId;
        return "TempStorageTransResult(ownerType=" + i + ", content=" + str + ", isFirstTemp=" + z + ", recognizeId=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TempStorageTransResult(int i, String str, boolean z, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? false : z, str2);
    }
}
