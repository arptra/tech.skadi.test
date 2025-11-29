package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AirSilentUpdateVersion;", "", "major", "", "minor", "(II)V", "getMajor", "()I", "getMinor", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AirSilentUpdateVersion {
    private final int major;
    private final int minor;

    public AirSilentUpdateVersion(int i, int i2) {
        this.major = i;
        this.minor = i2;
    }

    public static /* synthetic */ AirSilentUpdateVersion copy$default(AirSilentUpdateVersion airSilentUpdateVersion, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = airSilentUpdateVersion.major;
        }
        if ((i3 & 2) != 0) {
            i2 = airSilentUpdateVersion.minor;
        }
        return airSilentUpdateVersion.copy(i, i2);
    }

    public final int component1() {
        return this.major;
    }

    public final int component2() {
        return this.minor;
    }

    @NotNull
    public final AirSilentUpdateVersion copy(int i, int i2) {
        return new AirSilentUpdateVersion(i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AirSilentUpdateVersion)) {
            return false;
        }
        AirSilentUpdateVersion airSilentUpdateVersion = (AirSilentUpdateVersion) obj;
        return this.major == airSilentUpdateVersion.major && this.minor == airSilentUpdateVersion.minor;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public int hashCode() {
        return (Integer.hashCode(this.major) * 31) + Integer.hashCode(this.minor);
    }

    @NotNull
    public String toString() {
        int i = this.major;
        int i2 = this.minor;
        return "AirSilentUpdateVersion(major=" + i + ", minor=" + i2 + ")";
    }
}
