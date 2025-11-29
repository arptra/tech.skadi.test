package com.upuphone.ar.translation.statemachine.bean;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/translation/statemachine/bean/AsrTtsResult;", "", "asrJson", "", "ttsBytes", "", "(Ljava/lang/String;[B)V", "getAsrJson", "()Ljava/lang/String;", "getTtsBytes", "()[B", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AsrTtsResult {
    @NotNull
    private final String asrJson;
    @Nullable
    private final byte[] ttsBytes;

    public AsrTtsResult() {
        this((String) null, (byte[]) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AsrTtsResult copy$default(AsrTtsResult asrTtsResult, String str, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = asrTtsResult.asrJson;
        }
        if ((i & 2) != 0) {
            bArr = asrTtsResult.ttsBytes;
        }
        return asrTtsResult.copy(str, bArr);
    }

    @NotNull
    public final String component1() {
        return this.asrJson;
    }

    @Nullable
    public final byte[] component2() {
        return this.ttsBytes;
    }

    @NotNull
    public final AsrTtsResult copy(@NotNull String str, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "asrJson");
        return new AsrTtsResult(str, bArr);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) AsrTtsResult.class, (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ar.translation.statemachine.bean.AsrTtsResult");
        AsrTtsResult asrTtsResult = (AsrTtsResult) obj;
        if (!Intrinsics.areEqual((Object) this.asrJson, (Object) asrTtsResult.asrJson)) {
            return false;
        }
        byte[] bArr = this.ttsBytes;
        if (bArr != null) {
            byte[] bArr2 = asrTtsResult.ttsBytes;
            return bArr2 != null && Arrays.equals(bArr, bArr2);
        } else if (asrTtsResult.ttsBytes != null) {
            return false;
        }
    }

    @NotNull
    public final String getAsrJson() {
        return this.asrJson;
    }

    @Nullable
    public final byte[] getTtsBytes() {
        return this.ttsBytes;
    }

    public int hashCode() {
        int hashCode = this.asrJson.hashCode() * 31;
        byte[] bArr = this.ttsBytes;
        return hashCode + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    @NotNull
    public String toString() {
        String str = this.asrJson;
        String arrays = Arrays.toString(this.ttsBytes);
        return "AsrTtsResult(asrJson=" + str + ", ttsBytes=" + arrays + ")";
    }

    public AsrTtsResult(@NotNull String str, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "asrJson");
        this.asrJson = str;
        this.ttsBytes = bArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AsrTtsResult(String str, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : bArr);
    }
}
