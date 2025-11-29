package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/entity/SubPolicyInfo;", "", "module", "", "isForeground", "", "(IZ)V", "()Z", "getModule", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class SubPolicyInfo {
    private final boolean isForeground;
    private final int module;

    public SubPolicyInfo(int i, boolean z) {
        this.module = i;
        this.isForeground = z;
    }

    public static /* synthetic */ SubPolicyInfo copy$default(SubPolicyInfo subPolicyInfo, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = subPolicyInfo.module;
        }
        if ((i2 & 2) != 0) {
            z = subPolicyInfo.isForeground;
        }
        return subPolicyInfo.copy(i, z);
    }

    public final int component1() {
        return this.module;
    }

    public final boolean component2() {
        return this.isForeground;
    }

    @NotNull
    public final SubPolicyInfo copy(int i, boolean z) {
        return new SubPolicyInfo(i, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubPolicyInfo)) {
            return false;
        }
        SubPolicyInfo subPolicyInfo = (SubPolicyInfo) obj;
        return this.module == subPolicyInfo.module && this.isForeground == subPolicyInfo.isForeground;
    }

    public final int getModule() {
        return this.module;
    }

    public int hashCode() {
        return (Integer.hashCode(this.module) * 31) + Boolean.hashCode(this.isForeground);
    }

    public final boolean isForeground() {
        return this.isForeground;
    }

    @NotNull
    public String toString() {
        int i = this.module;
        boolean z = this.isForeground;
        return "SubPolicyInfo(module=" + i + ", isForeground=" + z + ")";
    }
}
