package com.upuphone.xr.sapp.datatrack;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/DataTrackRuleConfig;", "", "dataTrackRules", "", "Lcom/upuphone/xr/sapp/datatrack/DataTrackRule;", "(Ljava/util/List;)V", "getDataTrackRules", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class DataTrackRuleConfig {
    @Nullable
    private final List<DataTrackRule> dataTrackRules;

    public DataTrackRuleConfig(@Nullable List<DataTrackRule> list) {
        this.dataTrackRules = list;
    }

    public static /* synthetic */ DataTrackRuleConfig copy$default(DataTrackRuleConfig dataTrackRuleConfig, List<DataTrackRule> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = dataTrackRuleConfig.dataTrackRules;
        }
        return dataTrackRuleConfig.copy(list);
    }

    @Nullable
    public final List<DataTrackRule> component1() {
        return this.dataTrackRules;
    }

    @NotNull
    public final DataTrackRuleConfig copy(@Nullable List<DataTrackRule> list) {
        return new DataTrackRuleConfig(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DataTrackRuleConfig) && Intrinsics.areEqual((Object) this.dataTrackRules, (Object) ((DataTrackRuleConfig) obj).dataTrackRules);
    }

    @Nullable
    public final List<DataTrackRule> getDataTrackRules() {
        return this.dataTrackRules;
    }

    public int hashCode() {
        List<DataTrackRule> list = this.dataTrackRules;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        List<DataTrackRule> list = this.dataTrackRules;
        return "DataTrackRuleConfig(dataTrackRules=" + list + ")";
    }
}
