package com.upuphone.xr.sapp.datatrack;

import androidx.annotation.Keep;
import androidx.room.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/SimpleDataTrackRule;", "", "eventName", "", "eventUseType", "", "(Ljava/lang/String;I)V", "getEventName", "()Ljava/lang/String;", "getEventUseType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class SimpleDataTrackRule {
    @NotNull
    private final String eventName;
    private final int eventUseType;

    public SimpleDataTrackRule(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        this.eventName = str;
        this.eventUseType = i;
    }

    public static /* synthetic */ SimpleDataTrackRule copy$default(SimpleDataTrackRule simpleDataTrackRule, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = simpleDataTrackRule.eventName;
        }
        if ((i2 & 2) != 0) {
            i = simpleDataTrackRule.eventUseType;
        }
        return simpleDataTrackRule.copy(str, i);
    }

    @NotNull
    public final String component1() {
        return this.eventName;
    }

    public final int component2() {
        return this.eventUseType;
    }

    @NotNull
    public final SimpleDataTrackRule copy(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        return new SimpleDataTrackRule(str, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleDataTrackRule)) {
            return false;
        }
        SimpleDataTrackRule simpleDataTrackRule = (SimpleDataTrackRule) obj;
        return Intrinsics.areEqual((Object) this.eventName, (Object) simpleDataTrackRule.eventName) && this.eventUseType == simpleDataTrackRule.eventUseType;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    public final int getEventUseType() {
        return this.eventUseType;
    }

    public int hashCode() {
        return (this.eventName.hashCode() * 31) + Integer.hashCode(this.eventUseType);
    }

    @NotNull
    public String toString() {
        String str = this.eventName;
        int i = this.eventUseType;
        return "SimpleDataTrackRule(eventName=" + str + ", eventUseType=" + i + ")";
    }
}
