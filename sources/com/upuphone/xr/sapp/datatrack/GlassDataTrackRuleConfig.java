package com.upuphone.xr.sapp.datatrack;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/GlassDataTrackRuleConfig;", "", "ueSwitch", "", "faultTrackRulesV2", "", "", "errorTrackRules", "(ZLjava/util/List;Ljava/util/List;)V", "getErrorTrackRules", "()Ljava/util/List;", "getFaultTrackRulesV2", "getUeSwitch", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GlassDataTrackRuleConfig {
    @NotNull
    private final List<Integer> errorTrackRules;
    @NotNull
    private final List<Integer> faultTrackRulesV2;
    private final boolean ueSwitch;

    public GlassDataTrackRuleConfig(boolean z, @NotNull List<Integer> list, @NotNull List<Integer> list2) {
        Intrinsics.checkNotNullParameter(list, "faultTrackRulesV2");
        Intrinsics.checkNotNullParameter(list2, "errorTrackRules");
        this.ueSwitch = z;
        this.faultTrackRulesV2 = list;
        this.errorTrackRules = list2;
    }

    public static /* synthetic */ GlassDataTrackRuleConfig copy$default(GlassDataTrackRuleConfig glassDataTrackRuleConfig, boolean z, List<Integer> list, List<Integer> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = glassDataTrackRuleConfig.ueSwitch;
        }
        if ((i & 2) != 0) {
            list = glassDataTrackRuleConfig.faultTrackRulesV2;
        }
        if ((i & 4) != 0) {
            list2 = glassDataTrackRuleConfig.errorTrackRules;
        }
        return glassDataTrackRuleConfig.copy(z, list, list2);
    }

    public final boolean component1() {
        return this.ueSwitch;
    }

    @NotNull
    public final List<Integer> component2() {
        return this.faultTrackRulesV2;
    }

    @NotNull
    public final List<Integer> component3() {
        return this.errorTrackRules;
    }

    @NotNull
    public final GlassDataTrackRuleConfig copy(boolean z, @NotNull List<Integer> list, @NotNull List<Integer> list2) {
        Intrinsics.checkNotNullParameter(list, "faultTrackRulesV2");
        Intrinsics.checkNotNullParameter(list2, "errorTrackRules");
        return new GlassDataTrackRuleConfig(z, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassDataTrackRuleConfig)) {
            return false;
        }
        GlassDataTrackRuleConfig glassDataTrackRuleConfig = (GlassDataTrackRuleConfig) obj;
        return this.ueSwitch == glassDataTrackRuleConfig.ueSwitch && Intrinsics.areEqual((Object) this.faultTrackRulesV2, (Object) glassDataTrackRuleConfig.faultTrackRulesV2) && Intrinsics.areEqual((Object) this.errorTrackRules, (Object) glassDataTrackRuleConfig.errorTrackRules);
    }

    @NotNull
    public final List<Integer> getErrorTrackRules() {
        return this.errorTrackRules;
    }

    @NotNull
    public final List<Integer> getFaultTrackRulesV2() {
        return this.faultTrackRulesV2;
    }

    public final boolean getUeSwitch() {
        return this.ueSwitch;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.ueSwitch) * 31) + this.faultTrackRulesV2.hashCode()) * 31) + this.errorTrackRules.hashCode();
    }

    @NotNull
    public String toString() {
        boolean z = this.ueSwitch;
        List<Integer> list = this.faultTrackRulesV2;
        List<Integer> list2 = this.errorTrackRules;
        return "GlassDataTrackRuleConfig(ueSwitch=" + z + ", faultTrackRulesV2=" + list + ", errorTrackRules=" + list2 + ")";
    }
}
