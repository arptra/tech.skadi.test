package com.xjsd.xr.sapp.asr.dao;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/AsrResponseVad;", "", "state", "", "(Ljava/lang/String;)V", "getState", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AsrResponseVad {
    @NotNull
    private final String state;

    public AsrResponseVad(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "state");
        this.state = str;
    }

    public static /* synthetic */ AsrResponseVad copy$default(AsrResponseVad asrResponseVad, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = asrResponseVad.state;
        }
        return asrResponseVad.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.state;
    }

    @NotNull
    public final AsrResponseVad copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "state");
        return new AsrResponseVad(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AsrResponseVad) && Intrinsics.areEqual((Object) this.state, (Object) ((AsrResponseVad) obj).state);
    }

    @NotNull
    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        return this.state.hashCode();
    }

    @NotNull
    public String toString() {
        return "AsrResponseVad(state=" + this.state + ')';
    }
}
