package com.upuphone.xr.sapp.audio;

import androidx.annotation.Keep;
import com.upuphone.xr.sapp.entity.ReqGlassData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/audio/VolumeData;", "Lcom/upuphone/xr/sapp/entity/ReqGlassData$Data;", "streamType", "", "(I)V", "getStreamType", "()I", "setStreamType", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class VolumeData extends ReqGlassData.Data {
    private int streamType;

    public VolumeData() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ VolumeData copy$default(VolumeData volumeData, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = volumeData.streamType;
        }
        return volumeData.copy(i);
    }

    public final int component1() {
        return this.streamType;
    }

    @NotNull
    public final VolumeData copy(int i) {
        return new VolumeData(i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VolumeData) && this.streamType == ((VolumeData) obj).streamType;
    }

    public final int getStreamType() {
        return this.streamType;
    }

    public int hashCode() {
        return Integer.hashCode(this.streamType);
    }

    public final void setStreamType(int i) {
        this.streamType = i;
    }

    @NotNull
    public String toString() {
        int i = this.streamType;
        return "VolumeData(streamType=" + i + ")";
    }

    public VolumeData(int i) {
        this.streamType = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VolumeData(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 3 : i);
    }
}
