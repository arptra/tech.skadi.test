package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/entity/WeatherAIDLInfo;", "", "widget", "Lcom/upuphone/xr/sapp/entity/WeatherAIDLContent;", "local_update_time", "", "(Lcom/upuphone/xr/sapp/entity/WeatherAIDLContent;Ljava/lang/String;)V", "getLocal_update_time", "()Ljava/lang/String;", "getWidget", "()Lcom/upuphone/xr/sapp/entity/WeatherAIDLContent;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class WeatherAIDLInfo {
    @NotNull
    private final String local_update_time;
    @NotNull
    private final WeatherAIDLContent widget;

    public WeatherAIDLInfo(@NotNull WeatherAIDLContent weatherAIDLContent, @NotNull String str) {
        Intrinsics.checkNotNullParameter(weatherAIDLContent, "widget");
        Intrinsics.checkNotNullParameter(str, "local_update_time");
        this.widget = weatherAIDLContent;
        this.local_update_time = str;
    }

    public static /* synthetic */ WeatherAIDLInfo copy$default(WeatherAIDLInfo weatherAIDLInfo, WeatherAIDLContent weatherAIDLContent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            weatherAIDLContent = weatherAIDLInfo.widget;
        }
        if ((i & 2) != 0) {
            str = weatherAIDLInfo.local_update_time;
        }
        return weatherAIDLInfo.copy(weatherAIDLContent, str);
    }

    @NotNull
    public final WeatherAIDLContent component1() {
        return this.widget;
    }

    @NotNull
    public final String component2() {
        return this.local_update_time;
    }

    @NotNull
    public final WeatherAIDLInfo copy(@NotNull WeatherAIDLContent weatherAIDLContent, @NotNull String str) {
        Intrinsics.checkNotNullParameter(weatherAIDLContent, "widget");
        Intrinsics.checkNotNullParameter(str, "local_update_time");
        return new WeatherAIDLInfo(weatherAIDLContent, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeatherAIDLInfo)) {
            return false;
        }
        WeatherAIDLInfo weatherAIDLInfo = (WeatherAIDLInfo) obj;
        return Intrinsics.areEqual((Object) this.widget, (Object) weatherAIDLInfo.widget) && Intrinsics.areEqual((Object) this.local_update_time, (Object) weatherAIDLInfo.local_update_time);
    }

    @NotNull
    public final String getLocal_update_time() {
        return this.local_update_time;
    }

    @NotNull
    public final WeatherAIDLContent getWidget() {
        return this.widget;
    }

    public int hashCode() {
        return (this.widget.hashCode() * 31) + this.local_update_time.hashCode();
    }

    @NotNull
    public String toString() {
        WeatherAIDLContent weatherAIDLContent = this.widget;
        String str = this.local_update_time;
        return "WeatherAIDLInfo(widget=" + weatherAIDLContent + ", local_update_time=" + str + ")";
    }
}
