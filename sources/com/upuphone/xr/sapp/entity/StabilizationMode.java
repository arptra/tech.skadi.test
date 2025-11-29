package com.upuphone.xr.sapp.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/entity/StabilizationMode;", "", "globalSwitch", "", "naviSwitch", "(ZZ)V", "getGlobalSwitch", "()Z", "setGlobalSwitch", "(Z)V", "getNaviSwitch", "setNaviSwitch", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StabilizationMode {
    private boolean globalSwitch;
    private boolean naviSwitch;

    public StabilizationMode() {
        this(false, false, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StabilizationMode copy$default(StabilizationMode stabilizationMode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = stabilizationMode.globalSwitch;
        }
        if ((i & 2) != 0) {
            z2 = stabilizationMode.naviSwitch;
        }
        return stabilizationMode.copy(z, z2);
    }

    public final boolean component1() {
        return this.globalSwitch;
    }

    public final boolean component2() {
        return this.naviSwitch;
    }

    @NotNull
    public final StabilizationMode copy(boolean z, boolean z2) {
        return new StabilizationMode(z, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StabilizationMode)) {
            return false;
        }
        StabilizationMode stabilizationMode = (StabilizationMode) obj;
        return this.globalSwitch == stabilizationMode.globalSwitch && this.naviSwitch == stabilizationMode.naviSwitch;
    }

    public final boolean getGlobalSwitch() {
        return this.globalSwitch;
    }

    public final boolean getNaviSwitch() {
        return this.naviSwitch;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.globalSwitch) * 31) + Boolean.hashCode(this.naviSwitch);
    }

    public final void setGlobalSwitch(boolean z) {
        this.globalSwitch = z;
    }

    public final void setNaviSwitch(boolean z) {
        this.naviSwitch = z;
    }

    @NotNull
    public String toString() {
        boolean z = this.globalSwitch;
        boolean z2 = this.naviSwitch;
        return "StabilizationMode(globalSwitch=" + z + ", naviSwitch=" + z2 + ")";
    }

    public StabilizationMode(boolean z, boolean z2) {
        this.globalSwitch = z;
        this.naviSwitch = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StabilizationMode(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? false : z2);
    }
}
