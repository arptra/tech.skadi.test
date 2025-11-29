package com.xjsd.xr.sapp.asr.dao;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "", "src", "Lcom/xjsd/xr/sapp/asr/dao/Src;", "dst", "Lcom/xjsd/xr/sapp/asr/dao/Dst;", "ext", "Lcom/xjsd/xr/sapp/asr/dao/ResultExt;", "(Lcom/xjsd/xr/sapp/asr/dao/Src;Lcom/xjsd/xr/sapp/asr/dao/Dst;Lcom/xjsd/xr/sapp/asr/dao/ResultExt;)V", "getDst", "()Lcom/xjsd/xr/sapp/asr/dao/Dst;", "getExt", "()Lcom/xjsd/xr/sapp/asr/dao/ResultExt;", "getSrc", "()Lcom/xjsd/xr/sapp/asr/dao/Src;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AsrResult {
    @SerializedName("dst")
    @Nullable
    private final Dst dst;
    @Nullable
    private final ResultExt ext;
    @SerializedName("src")
    @Nullable
    private final Src src;

    public AsrResult() {
        this((Src) null, (Dst) null, (ResultExt) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AsrResult copy$default(AsrResult asrResult, Src src2, Dst dst2, ResultExt resultExt, int i, Object obj) {
        if ((i & 1) != 0) {
            src2 = asrResult.src;
        }
        if ((i & 2) != 0) {
            dst2 = asrResult.dst;
        }
        if ((i & 4) != 0) {
            resultExt = asrResult.ext;
        }
        return asrResult.copy(src2, dst2, resultExt);
    }

    @Nullable
    public final Src component1() {
        return this.src;
    }

    @Nullable
    public final Dst component2() {
        return this.dst;
    }

    @Nullable
    public final ResultExt component3() {
        return this.ext;
    }

    @NotNull
    public final AsrResult copy(@Nullable Src src2, @Nullable Dst dst2, @Nullable ResultExt resultExt) {
        return new AsrResult(src2, dst2, resultExt);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrResult)) {
            return false;
        }
        AsrResult asrResult = (AsrResult) obj;
        return Intrinsics.areEqual((Object) this.src, (Object) asrResult.src) && Intrinsics.areEqual((Object) this.dst, (Object) asrResult.dst) && Intrinsics.areEqual((Object) this.ext, (Object) asrResult.ext);
    }

    @Nullable
    public final Dst getDst() {
        return this.dst;
    }

    @Nullable
    public final ResultExt getExt() {
        return this.ext;
    }

    @Nullable
    public final Src getSrc() {
        return this.src;
    }

    public int hashCode() {
        Src src2 = this.src;
        int i = 0;
        int hashCode = (src2 == null ? 0 : src2.hashCode()) * 31;
        Dst dst2 = this.dst;
        int hashCode2 = (hashCode + (dst2 == null ? 0 : dst2.hashCode())) * 31;
        ResultExt resultExt = this.ext;
        if (resultExt != null) {
            i = resultExt.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "AsrResult[" + this.src + ", " + this.dst + "], ext[" + this.ext + ']';
    }

    public AsrResult(@Nullable Src src2, @Nullable Dst dst2, @Nullable ResultExt resultExt) {
        this.src = src2;
        this.dst = dst2;
        this.ext = resultExt;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AsrResult(Src src2, Dst dst2, ResultExt resultExt, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : src2, (i & 2) != 0 ? null : dst2, (i & 4) != 0 ? null : resultExt);
    }
}
