package com.upuphone.xr.sapp.monitor.weather.model;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0012J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b&\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018¨\u0006;"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/weather/model/ArWeatherModel;", "", "temp", "", "weather", "", "dayTempMax", "dayTempMin", "areaName", "iconCode", "lastUpdate", "sunriseTime", "sunsetTime", "aqi", "quality", "futureDay", "", "Lcom/upuphone/xr/sapp/monitor/weather/model/ArFutureDay;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "getAqi", "()I", "setAqi", "(I)V", "getAreaName", "()Ljava/lang/String;", "getDayTempMax", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDayTempMin", "getFutureDay", "()Ljava/util/List;", "getIconCode", "getLastUpdate", "getQuality", "setQuality", "(Ljava/lang/String;)V", "getSunriseTime", "getSunsetTime", "getTemp", "getWeather", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)Lcom/upuphone/xr/sapp/monitor/weather/model/ArWeatherModel;", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class ArWeatherModel {
    private int aqi;
    @Nullable
    private final String areaName;
    @Nullable
    private final Integer dayTempMax;
    @Nullable
    private final Integer dayTempMin;
    @NotNull
    private final List<ArFutureDay> futureDay;
    @NotNull
    private final String iconCode;
    @Nullable
    private final String lastUpdate;
    @NotNull
    private String quality;
    @Nullable
    private final String sunriseTime;
    @Nullable
    private final String sunsetTime;
    @Nullable
    private final Integer temp;
    @Nullable
    private final String weather;

    public ArWeatherModel(@Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, int i, @NotNull String str7, @NotNull List<ArFutureDay> list) {
        Intrinsics.checkNotNullParameter(str3, "iconCode");
        Intrinsics.checkNotNullParameter(str7, "quality");
        Intrinsics.checkNotNullParameter(list, "futureDay");
        this.temp = num;
        this.weather = str;
        this.dayTempMax = num2;
        this.dayTempMin = num3;
        this.areaName = str2;
        this.iconCode = str3;
        this.lastUpdate = str4;
        this.sunriseTime = str5;
        this.sunsetTime = str6;
        this.aqi = i;
        this.quality = str7;
        this.futureDay = list;
    }

    public static /* synthetic */ ArWeatherModel copy$default(ArWeatherModel arWeatherModel, Integer num, String str, Integer num2, Integer num3, String str2, String str3, String str4, String str5, String str6, int i, String str7, List list, int i2, Object obj) {
        ArWeatherModel arWeatherModel2 = arWeatherModel;
        int i3 = i2;
        return arWeatherModel.copy((i3 & 1) != 0 ? arWeatherModel2.temp : num, (i3 & 2) != 0 ? arWeatherModel2.weather : str, (i3 & 4) != 0 ? arWeatherModel2.dayTempMax : num2, (i3 & 8) != 0 ? arWeatherModel2.dayTempMin : num3, (i3 & 16) != 0 ? arWeatherModel2.areaName : str2, (i3 & 32) != 0 ? arWeatherModel2.iconCode : str3, (i3 & 64) != 0 ? arWeatherModel2.lastUpdate : str4, (i3 & 128) != 0 ? arWeatherModel2.sunriseTime : str5, (i3 & 256) != 0 ? arWeatherModel2.sunsetTime : str6, (i3 & 512) != 0 ? arWeatherModel2.aqi : i, (i3 & 1024) != 0 ? arWeatherModel2.quality : str7, (i3 & 2048) != 0 ? arWeatherModel2.futureDay : list);
    }

    @Nullable
    public final Integer component1() {
        return this.temp;
    }

    public final int component10() {
        return this.aqi;
    }

    @NotNull
    public final String component11() {
        return this.quality;
    }

    @NotNull
    public final List<ArFutureDay> component12() {
        return this.futureDay;
    }

    @Nullable
    public final String component2() {
        return this.weather;
    }

    @Nullable
    public final Integer component3() {
        return this.dayTempMax;
    }

    @Nullable
    public final Integer component4() {
        return this.dayTempMin;
    }

    @Nullable
    public final String component5() {
        return this.areaName;
    }

    @NotNull
    public final String component6() {
        return this.iconCode;
    }

    @Nullable
    public final String component7() {
        return this.lastUpdate;
    }

    @Nullable
    public final String component8() {
        return this.sunriseTime;
    }

    @Nullable
    public final String component9() {
        return this.sunsetTime;
    }

    @NotNull
    public final ArWeatherModel copy(@Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, int i, @NotNull String str7, @NotNull List<ArFutureDay> list) {
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "iconCode");
        String str9 = str7;
        Intrinsics.checkNotNullParameter(str9, "quality");
        List<ArFutureDay> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "futureDay");
        return new ArWeatherModel(num, str, num2, num3, str2, str8, str4, str5, str6, i, str9, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArWeatherModel)) {
            return false;
        }
        ArWeatherModel arWeatherModel = (ArWeatherModel) obj;
        return Intrinsics.areEqual((Object) this.temp, (Object) arWeatherModel.temp) && Intrinsics.areEqual((Object) this.weather, (Object) arWeatherModel.weather) && Intrinsics.areEqual((Object) this.dayTempMax, (Object) arWeatherModel.dayTempMax) && Intrinsics.areEqual((Object) this.dayTempMin, (Object) arWeatherModel.dayTempMin) && Intrinsics.areEqual((Object) this.areaName, (Object) arWeatherModel.areaName) && Intrinsics.areEqual((Object) this.iconCode, (Object) arWeatherModel.iconCode) && Intrinsics.areEqual((Object) this.lastUpdate, (Object) arWeatherModel.lastUpdate) && Intrinsics.areEqual((Object) this.sunriseTime, (Object) arWeatherModel.sunriseTime) && Intrinsics.areEqual((Object) this.sunsetTime, (Object) arWeatherModel.sunsetTime) && this.aqi == arWeatherModel.aqi && Intrinsics.areEqual((Object) this.quality, (Object) arWeatherModel.quality) && Intrinsics.areEqual((Object) this.futureDay, (Object) arWeatherModel.futureDay);
    }

    public final int getAqi() {
        return this.aqi;
    }

    @Nullable
    public final String getAreaName() {
        return this.areaName;
    }

    @Nullable
    public final Integer getDayTempMax() {
        return this.dayTempMax;
    }

    @Nullable
    public final Integer getDayTempMin() {
        return this.dayTempMin;
    }

    @NotNull
    public final List<ArFutureDay> getFutureDay() {
        return this.futureDay;
    }

    @NotNull
    public final String getIconCode() {
        return this.iconCode;
    }

    @Nullable
    public final String getLastUpdate() {
        return this.lastUpdate;
    }

    @NotNull
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    public final String getSunriseTime() {
        return this.sunriseTime;
    }

    @Nullable
    public final String getSunsetTime() {
        return this.sunsetTime;
    }

    @Nullable
    public final Integer getTemp() {
        return this.temp;
    }

    @Nullable
    public final String getWeather() {
        return this.weather;
    }

    public int hashCode() {
        Integer num = this.temp;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.weather;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.dayTempMax;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.dayTempMin;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.areaName;
        int hashCode5 = (((hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.iconCode.hashCode()) * 31;
        String str3 = this.lastUpdate;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sunriseTime;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.sunsetTime;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return ((((((hashCode7 + i) * 31) + Integer.hashCode(this.aqi)) * 31) + this.quality.hashCode()) * 31) + this.futureDay.hashCode();
    }

    public final void setAqi(int i) {
        this.aqi = i;
    }

    public final void setQuality(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.quality = str;
    }

    @NotNull
    public String toString() {
        Integer num = this.temp;
        String str = this.weather;
        Integer num2 = this.dayTempMax;
        Integer num3 = this.dayTempMin;
        String str2 = this.areaName;
        String str3 = this.iconCode;
        String str4 = this.lastUpdate;
        String str5 = this.sunriseTime;
        String str6 = this.sunsetTime;
        int i = this.aqi;
        String str7 = this.quality;
        List<ArFutureDay> list = this.futureDay;
        return "ArWeatherModel(temp=" + num + ", weather=" + str + ", dayTempMax=" + num2 + ", dayTempMin=" + num3 + ", areaName=" + str2 + ", iconCode=" + str3 + ", lastUpdate=" + str4 + ", sunriseTime=" + str5 + ", sunsetTime=" + str6 + ", aqi=" + i + ", quality=" + str7 + ", futureDay=" + list + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ArWeatherModel(java.lang.Integer r16, java.lang.String r17, java.lang.Integer r18, java.lang.Integer r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, int r25, java.lang.String r26, java.util.List r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r12 = r1
            goto L_0x000b
        L_0x0009:
            r12 = r25
        L_0x000b:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = ""
            r13 = r0
            goto L_0x0015
        L_0x0013:
            r13 = r26
        L_0x0015:
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r14 = r27
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.weather.model.ArWeatherModel.<init>(java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
