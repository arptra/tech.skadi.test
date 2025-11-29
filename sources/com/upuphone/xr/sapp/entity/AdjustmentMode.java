package com.upuphone.xr.sapp.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AdjustmentMode;", "", "hor_bias", "", "rotate", "ver_bias", "(DDD)V", "getHor_bias", "()D", "setHor_bias", "(D)V", "getRotate", "setRotate", "getVer_bias", "setVer_bias", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AdjustmentMode {
    private double hor_bias;
    private double rotate;
    private double ver_bias;

    public AdjustmentMode() {
        this(0.0d, 0.0d, 0.0d, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdjustmentMode copy$default(AdjustmentMode adjustmentMode, double d, double d2, double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            d = adjustmentMode.hor_bias;
        }
        double d4 = d;
        if ((i & 2) != 0) {
            d2 = adjustmentMode.rotate;
        }
        double d5 = d2;
        if ((i & 4) != 0) {
            d3 = adjustmentMode.ver_bias;
        }
        return adjustmentMode.copy(d4, d5, d3);
    }

    public final double component1() {
        return this.hor_bias;
    }

    public final double component2() {
        return this.rotate;
    }

    public final double component3() {
        return this.ver_bias;
    }

    @NotNull
    public final AdjustmentMode copy(double d, double d2, double d3) {
        return new AdjustmentMode(d, d2, d3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdjustmentMode)) {
            return false;
        }
        AdjustmentMode adjustmentMode = (AdjustmentMode) obj;
        return Double.compare(this.hor_bias, adjustmentMode.hor_bias) == 0 && Double.compare(this.rotate, adjustmentMode.rotate) == 0 && Double.compare(this.ver_bias, adjustmentMode.ver_bias) == 0;
    }

    public final double getHor_bias() {
        return this.hor_bias;
    }

    public final double getRotate() {
        return this.rotate;
    }

    public final double getVer_bias() {
        return this.ver_bias;
    }

    public int hashCode() {
        return (((Double.hashCode(this.hor_bias) * 31) + Double.hashCode(this.rotate)) * 31) + Double.hashCode(this.ver_bias);
    }

    public final void setHor_bias(double d) {
        this.hor_bias = d;
    }

    public final void setRotate(double d) {
        this.rotate = d;
    }

    public final void setVer_bias(double d) {
        this.ver_bias = d;
    }

    @NotNull
    public String toString() {
        double d = this.hor_bias;
        double d2 = this.rotate;
        double d3 = this.ver_bias;
        return "AdjustmentMode(hor_bias=" + d + ", rotate=" + d2 + ", ver_bias=" + d3 + ")";
    }

    public AdjustmentMode(double d, double d2, double d3) {
        this.hor_bias = d;
        this.rotate = d2;
        this.ver_bias = d3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdjustmentMode(double d, double d2, double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2, (i & 4) != 0 ? 0.0d : d3);
    }
}
