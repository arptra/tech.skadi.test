package com.upuphone.ar.translation.iflytek.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/entity/TranscribedData;", "", "cn", "Lcom/upuphone/ar/translation/iflytek/entity/Cn;", "ls", "", "segId", "", "(Lcom/upuphone/ar/translation/iflytek/entity/Cn;ZI)V", "getCn", "()Lcom/upuphone/ar/translation/iflytek/entity/Cn;", "getLs", "()Z", "getSegId", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribedData {
    @SerializedName("cn")
    @NotNull
    private final Cn cn;
    @SerializedName("ls")
    private final boolean ls;
    @SerializedName("seg_id")
    private final int segId;

    public TranscribedData() {
        this((Cn) null, false, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TranscribedData copy$default(TranscribedData transcribedData, Cn cn2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cn2 = transcribedData.cn;
        }
        if ((i2 & 2) != 0) {
            z = transcribedData.ls;
        }
        if ((i2 & 4) != 0) {
            i = transcribedData.segId;
        }
        return transcribedData.copy(cn2, z, i);
    }

    @NotNull
    public final Cn component1() {
        return this.cn;
    }

    public final boolean component2() {
        return this.ls;
    }

    public final int component3() {
        return this.segId;
    }

    @NotNull
    public final TranscribedData copy(@NotNull Cn cn2, boolean z, int i) {
        Intrinsics.checkNotNullParameter(cn2, "cn");
        return new TranscribedData(cn2, z, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TranscribedData)) {
            return false;
        }
        TranscribedData transcribedData = (TranscribedData) obj;
        return Intrinsics.areEqual((Object) this.cn, (Object) transcribedData.cn) && this.ls == transcribedData.ls && this.segId == transcribedData.segId;
    }

    @NotNull
    public final Cn getCn() {
        return this.cn;
    }

    public final boolean getLs() {
        return this.ls;
    }

    public final int getSegId() {
        return this.segId;
    }

    public int hashCode() {
        return (((this.cn.hashCode() * 31) + Boolean.hashCode(this.ls)) * 31) + Integer.hashCode(this.segId);
    }

    @NotNull
    public String toString() {
        Cn cn2 = this.cn;
        boolean z = this.ls;
        int i = this.segId;
        return "TranscribedData(cn=" + cn2 + ", ls=" + z + ", segId=" + i + ")";
    }

    public TranscribedData(@NotNull Cn cn2, boolean z, int i) {
        Intrinsics.checkNotNullParameter(cn2, "cn");
        this.cn = cn2;
        this.ls = z;
        this.segId = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TranscribedData(Cn cn2, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new Cn((St) null, 1, (DefaultConstructorMarker) null) : cn2, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? 0 : i);
    }
}
