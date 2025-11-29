package com.upuphone.xr.sapp.audio;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/sapp/audio/GlassVolInfo;", "", "streamType", "", "max", "min", "current", "(IIII)V", "getCurrent", "()I", "setCurrent", "(I)V", "getMax", "setMax", "getMin", "setMin", "getStreamType", "setStreamType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GlassVolInfo {
    private int current;
    private int max;
    private int min;
    private int streamType;

    public GlassVolInfo() {
        this(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GlassVolInfo copy$default(GlassVolInfo glassVolInfo, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = glassVolInfo.streamType;
        }
        if ((i5 & 2) != 0) {
            i2 = glassVolInfo.max;
        }
        if ((i5 & 4) != 0) {
            i3 = glassVolInfo.min;
        }
        if ((i5 & 8) != 0) {
            i4 = glassVolInfo.current;
        }
        return glassVolInfo.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.streamType;
    }

    public final int component2() {
        return this.max;
    }

    public final int component3() {
        return this.min;
    }

    public final int component4() {
        return this.current;
    }

    @NotNull
    public final GlassVolInfo copy(int i, int i2, int i3, int i4) {
        return new GlassVolInfo(i, i2, i3, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassVolInfo)) {
            return false;
        }
        GlassVolInfo glassVolInfo = (GlassVolInfo) obj;
        return this.streamType == glassVolInfo.streamType && this.max == glassVolInfo.max && this.min == glassVolInfo.min && this.current == glassVolInfo.current;
    }

    public final int getCurrent() {
        return this.current;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    public final int getStreamType() {
        return this.streamType;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.streamType) * 31) + Integer.hashCode(this.max)) * 31) + Integer.hashCode(this.min)) * 31) + Integer.hashCode(this.current);
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    public final void setMax(int i) {
        this.max = i;
    }

    public final void setMin(int i) {
        this.min = i;
    }

    public final void setStreamType(int i) {
        this.streamType = i;
    }

    @NotNull
    public String toString() {
        int i = this.streamType;
        int i2 = this.max;
        int i3 = this.min;
        int i4 = this.current;
        return "GlassVolInfo(streamType=" + i + ", max=" + i2 + ", min=" + i3 + ", current=" + i4 + ")";
    }

    public GlassVolInfo(int i, int i2, int i3, int i4) {
        this.streamType = i;
        this.max = i2;
        this.min = i3;
        this.current = i4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlassVolInfo(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 3 : i, (i5 & 2) != 0 ? 15 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 4 : i4);
    }
}
