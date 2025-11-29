package com.upuphone.xr.sapp.monitor.weather.model;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/weather/model/ArFutureDay;", "", "date", "", "dayTempMax", "", "dayTempMin", "weather", "iconCode", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getDayTempMax", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDayTempMin", "getIconCode", "getWeather", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/upuphone/xr/sapp/monitor/weather/model/ArFutureDay;", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ArFutureDay {
    @Nullable
    private final String date;
    @Nullable
    private final Integer dayTempMax;
    @Nullable
    private final Integer dayTempMin;
    @Nullable
    private final String iconCode;
    @Nullable
    private final String weather;

    public ArFutureDay(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable String str2, @Nullable String str3) {
        this.date = str;
        this.dayTempMax = num;
        this.dayTempMin = num2;
        this.weather = str2;
        this.iconCode = str3;
    }

    public static /* synthetic */ ArFutureDay copy$default(ArFutureDay arFutureDay, String str, Integer num, Integer num2, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = arFutureDay.date;
        }
        if ((i & 2) != 0) {
            num = arFutureDay.dayTempMax;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            num2 = arFutureDay.dayTempMin;
        }
        Integer num4 = num2;
        if ((i & 8) != 0) {
            str2 = arFutureDay.weather;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            str3 = arFutureDay.iconCode;
        }
        return arFutureDay.copy(str, num3, num4, str4, str3);
    }

    @Nullable
    public final String component1() {
        return this.date;
    }

    @Nullable
    public final Integer component2() {
        return this.dayTempMax;
    }

    @Nullable
    public final Integer component3() {
        return this.dayTempMin;
    }

    @Nullable
    public final String component4() {
        return this.weather;
    }

    @Nullable
    public final String component5() {
        return this.iconCode;
    }

    @NotNull
    public final ArFutureDay copy(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable String str2, @Nullable String str3) {
        return new ArFutureDay(str, num, num2, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArFutureDay)) {
            return false;
        }
        ArFutureDay arFutureDay = (ArFutureDay) obj;
        return Intrinsics.areEqual((Object) this.date, (Object) arFutureDay.date) && Intrinsics.areEqual((Object) this.dayTempMax, (Object) arFutureDay.dayTempMax) && Intrinsics.areEqual((Object) this.dayTempMin, (Object) arFutureDay.dayTempMin) && Intrinsics.areEqual((Object) this.weather, (Object) arFutureDay.weather) && Intrinsics.areEqual((Object) this.iconCode, (Object) arFutureDay.iconCode);
    }

    @Nullable
    public final String getDate() {
        return this.date;
    }

    @Nullable
    public final Integer getDayTempMax() {
        return this.dayTempMax;
    }

    @Nullable
    public final Integer getDayTempMin() {
        return this.dayTempMin;
    }

    @Nullable
    public final String getIconCode() {
        return this.iconCode;
    }

    @Nullable
    public final String getWeather() {
        return this.weather;
    }

    public int hashCode() {
        String str = this.date;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.dayTempMax;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.dayTempMin;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.weather;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconCode;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        String str = this.date;
        Integer num = this.dayTempMax;
        Integer num2 = this.dayTempMin;
        String str2 = this.weather;
        String str3 = this.iconCode;
        return "ArFutureDay(date=" + str + ", dayTempMax=" + num + ", dayTempMin=" + num2 + ", weather=" + str2 + ", iconCode=" + str3 + ")";
    }
}
