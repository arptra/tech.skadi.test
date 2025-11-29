package com.upuphone.xr.sapp.vu.monitor;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/vu/monitor/VuSportInfo;", "", "steps", "", "calories", "", "distance", "(IDD)V", "getCalories", "()D", "getDistance", "getSteps", "()I", "setSteps", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toJson", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class VuSportInfo {
    private final double calories;
    private final double distance;
    private int steps;

    public VuSportInfo(int i, double d, double d2) {
        this.steps = i;
        this.calories = d;
        this.distance = d2;
    }

    public static /* synthetic */ VuSportInfo copy$default(VuSportInfo vuSportInfo, int i, double d, double d2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = vuSportInfo.steps;
        }
        if ((i2 & 2) != 0) {
            d = vuSportInfo.calories;
        }
        double d3 = d;
        if ((i2 & 4) != 0) {
            d2 = vuSportInfo.distance;
        }
        return vuSportInfo.copy(i, d3, d2);
    }

    public final int component1() {
        return this.steps;
    }

    public final double component2() {
        return this.calories;
    }

    public final double component3() {
        return this.distance;
    }

    @NotNull
    public final VuSportInfo copy(int i, double d, double d2) {
        return new VuSportInfo(i, d, d2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VuSportInfo)) {
            return false;
        }
        VuSportInfo vuSportInfo = (VuSportInfo) obj;
        return this.steps == vuSportInfo.steps && Double.compare(this.calories, vuSportInfo.calories) == 0 && Double.compare(this.distance, vuSportInfo.distance) == 0;
    }

    public final double getCalories() {
        return this.calories;
    }

    public final double getDistance() {
        return this.distance;
    }

    public final int getSteps() {
        return this.steps;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.steps) * 31) + Double.hashCode(this.calories)) * 31) + Double.hashCode(this.distance);
    }

    public final void setSteps(int i) {
        this.steps = i;
    }

    @NotNull
    public final String toJson() {
        int i = this.steps;
        double d = this.calories;
        double d2 = this.distance;
        return "{\"steps\":" + i + ",\"calories\":" + d + ",\"distance\":" + d2 + "}";
    }

    @NotNull
    public String toString() {
        int i = this.steps;
        double d = this.calories;
        double d2 = this.distance;
        return "VuSportInfo(steps=" + i + ", calories=" + d + ", distance=" + d2 + ")";
    }
}
