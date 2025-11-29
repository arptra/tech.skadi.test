package com.xjsd.xr.sapp.asr.dao;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/TtsData;", "", "tts", "", "time", "", "([BJ)V", "getTime", "()J", "getTts", "()[B", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TtsData {
    private final long time;
    @NotNull
    private final byte[] tts;

    public TtsData() {
        this((byte[]) null, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TtsData copy$default(TtsData ttsData, byte[] bArr, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = ttsData.tts;
        }
        if ((i & 2) != 0) {
            j = ttsData.time;
        }
        return ttsData.copy(bArr, j);
    }

    @NotNull
    public final byte[] component1() {
        return this.tts;
    }

    public final long component2() {
        return this.time;
    }

    @NotNull
    public final TtsData copy(@NotNull byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(bArr, "tts");
        return new TtsData(bArr, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) TtsData.class, (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.xjsd.xr.sapp.asr.dao.TtsData");
        TtsData ttsData = (TtsData) obj;
        if (!Arrays.equals(this.tts, ttsData.tts)) {
            return false;
        }
        return this.time == ttsData.time;
    }

    public final long getTime() {
        return this.time;
    }

    @NotNull
    public final byte[] getTts() {
        return this.tts;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.tts) * 31) + Long.hashCode(this.time);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TtsData(tts=");
        String arrays = Arrays.toString(this.tts);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb.append(arrays);
        sb.append(", time=");
        sb.append(this.time);
        sb.append(')');
        return sb.toString();
    }

    public TtsData(@NotNull byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(bArr, "tts");
        this.tts = bArr;
        this.time = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TtsData(byte[] bArr, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new byte[0] : bArr, (i & 2) != 0 ? 0 : j);
    }
}
