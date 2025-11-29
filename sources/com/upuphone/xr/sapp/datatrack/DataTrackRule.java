package com.upuphone.xr.sapp.datatrack;

import androidx.annotation.Keep;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/DataTrackRule;", "", "ruleId", "", "deviceType", "", "eventName", "eventUseType", "(ILjava/lang/String;Ljava/lang/String;I)V", "getDeviceType", "()Ljava/lang/String;", "getEventName", "getEventUseType", "()I", "getRuleId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class DataTrackRule {
    @NotNull
    private final String deviceType;
    @NotNull
    private final String eventName;
    private final int eventUseType;
    @PrimaryKey
    private final int ruleId;

    public DataTrackRule(int i, @NotNull String str, @NotNull String str2, int i2) {
        Intrinsics.checkNotNullParameter(str, "deviceType");
        Intrinsics.checkNotNullParameter(str2, "eventName");
        this.ruleId = i;
        this.deviceType = str;
        this.eventName = str2;
        this.eventUseType = i2;
    }

    public static /* synthetic */ DataTrackRule copy$default(DataTrackRule dataTrackRule, int i, String str, String str2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = dataTrackRule.ruleId;
        }
        if ((i3 & 2) != 0) {
            str = dataTrackRule.deviceType;
        }
        if ((i3 & 4) != 0) {
            str2 = dataTrackRule.eventName;
        }
        if ((i3 & 8) != 0) {
            i2 = dataTrackRule.eventUseType;
        }
        return dataTrackRule.copy(i, str, str2, i2);
    }

    public final int component1() {
        return this.ruleId;
    }

    @NotNull
    public final String component2() {
        return this.deviceType;
    }

    @NotNull
    public final String component3() {
        return this.eventName;
    }

    public final int component4() {
        return this.eventUseType;
    }

    @NotNull
    public final DataTrackRule copy(int i, @NotNull String str, @NotNull String str2, int i2) {
        Intrinsics.checkNotNullParameter(str, "deviceType");
        Intrinsics.checkNotNullParameter(str2, "eventName");
        return new DataTrackRule(i, str, str2, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataTrackRule)) {
            return false;
        }
        DataTrackRule dataTrackRule = (DataTrackRule) obj;
        return this.ruleId == dataTrackRule.ruleId && Intrinsics.areEqual((Object) this.deviceType, (Object) dataTrackRule.deviceType) && Intrinsics.areEqual((Object) this.eventName, (Object) dataTrackRule.eventName) && this.eventUseType == dataTrackRule.eventUseType;
    }

    @NotNull
    public final String getDeviceType() {
        return this.deviceType;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    public final int getEventUseType() {
        return this.eventUseType;
    }

    public final int getRuleId() {
        return this.ruleId;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.ruleId) * 31) + this.deviceType.hashCode()) * 31) + this.eventName.hashCode()) * 31) + Integer.hashCode(this.eventUseType);
    }

    @NotNull
    public String toString() {
        int i = this.ruleId;
        String str = this.deviceType;
        String str2 = this.eventName;
        int i2 = this.eventUseType;
        return "DataTrackRule(ruleId=" + i + ", deviceType=" + str + ", eventName=" + str2 + ", eventUseType=" + i2 + ")";
    }
}
