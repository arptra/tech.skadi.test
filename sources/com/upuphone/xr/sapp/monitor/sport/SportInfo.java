package com.upuphone.xr.sapp.monitor.sport;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/sport/SportInfo;", "", "stepCount", "", "calories", "", "targetStep", "errorCode", "(IDII)V", "getCalories", "()D", "getErrorCode", "()I", "setErrorCode", "(I)V", "getStepCount", "setStepCount", "getTargetStep", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class SportInfo {
    private final double calories;
    private int errorCode;
    private int stepCount;
    private final int targetStep;

    public SportInfo(int i, double d, int i2, int i3) {
        this.stepCount = i;
        this.calories = d;
        this.targetStep = i2;
        this.errorCode = i3;
    }

    public static /* synthetic */ SportInfo copy$default(SportInfo sportInfo, int i, double d, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = sportInfo.stepCount;
        }
        if ((i4 & 2) != 0) {
            d = sportInfo.calories;
        }
        double d2 = d;
        if ((i4 & 4) != 0) {
            i2 = sportInfo.targetStep;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = sportInfo.errorCode;
        }
        return sportInfo.copy(i, d2, i5, i3);
    }

    public final int component1() {
        return this.stepCount;
    }

    public final double component2() {
        return this.calories;
    }

    public final int component3() {
        return this.targetStep;
    }

    public final int component4() {
        return this.errorCode;
    }

    @NotNull
    public final SportInfo copy(int i, double d, int i2, int i3) {
        return new SportInfo(i, d, i2, i3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SportInfo)) {
            return false;
        }
        SportInfo sportInfo = (SportInfo) obj;
        return this.stepCount == sportInfo.stepCount && Double.compare(this.calories, sportInfo.calories) == 0 && this.targetStep == sportInfo.targetStep && this.errorCode == sportInfo.errorCode;
    }

    public final double getCalories() {
        return this.calories;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final int getStepCount() {
        return this.stepCount;
    }

    public final int getTargetStep() {
        return this.targetStep;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.stepCount) * 31) + Double.hashCode(this.calories)) * 31) + Integer.hashCode(this.targetStep)) * 31) + Integer.hashCode(this.errorCode);
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final void setStepCount(int i) {
        this.stepCount = i;
    }

    @NotNull
    public String toString() {
        int i = this.stepCount;
        double d = this.calories;
        int i2 = this.targetStep;
        int i3 = this.errorCode;
        return "SportInfo(stepCount=" + i + ", calories=" + d + ", targetStep=" + i2 + ", errorCode=" + i3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SportInfo(int i, double d, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, d, i2, (i4 & 8) != 0 ? 0 : i3);
    }
}
