package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/sapp/entity/WeatherAIDLContent;", "", "aqi", "", "img", "quality", "cityName", "temp", "weather", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAqi", "()Ljava/lang/String;", "getCityName", "getImg", "getQuality", "getTemp", "getWeather", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class WeatherAIDLContent {
    @NotNull
    private final String aqi;
    @NotNull
    private final String cityName;
    @NotNull
    private final String img;
    @NotNull
    private final String quality;
    @NotNull
    private final String temp;
    @NotNull
    private final String weather;

    public WeatherAIDLContent(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "aqi");
        Intrinsics.checkNotNullParameter(str2, "img");
        Intrinsics.checkNotNullParameter(str3, "quality");
        Intrinsics.checkNotNullParameter(str4, "cityName");
        Intrinsics.checkNotNullParameter(str5, "temp");
        Intrinsics.checkNotNullParameter(str6, VuiModelType.WEATHER);
        this.aqi = str;
        this.img = str2;
        this.quality = str3;
        this.cityName = str4;
        this.temp = str5;
        this.weather = str6;
    }

    public static /* synthetic */ WeatherAIDLContent copy$default(WeatherAIDLContent weatherAIDLContent, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = weatherAIDLContent.aqi;
        }
        if ((i & 2) != 0) {
            str2 = weatherAIDLContent.img;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = weatherAIDLContent.quality;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = weatherAIDLContent.cityName;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = weatherAIDLContent.temp;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = weatherAIDLContent.weather;
        }
        return weatherAIDLContent.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.aqi;
    }

    @NotNull
    public final String component2() {
        return this.img;
    }

    @NotNull
    public final String component3() {
        return this.quality;
    }

    @NotNull
    public final String component4() {
        return this.cityName;
    }

    @NotNull
    public final String component5() {
        return this.temp;
    }

    @NotNull
    public final String component6() {
        return this.weather;
    }

    @NotNull
    public final WeatherAIDLContent copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "aqi");
        Intrinsics.checkNotNullParameter(str2, "img");
        Intrinsics.checkNotNullParameter(str3, "quality");
        Intrinsics.checkNotNullParameter(str4, "cityName");
        Intrinsics.checkNotNullParameter(str5, "temp");
        Intrinsics.checkNotNullParameter(str6, VuiModelType.WEATHER);
        return new WeatherAIDLContent(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeatherAIDLContent)) {
            return false;
        }
        WeatherAIDLContent weatherAIDLContent = (WeatherAIDLContent) obj;
        return Intrinsics.areEqual((Object) this.aqi, (Object) weatherAIDLContent.aqi) && Intrinsics.areEqual((Object) this.img, (Object) weatherAIDLContent.img) && Intrinsics.areEqual((Object) this.quality, (Object) weatherAIDLContent.quality) && Intrinsics.areEqual((Object) this.cityName, (Object) weatherAIDLContent.cityName) && Intrinsics.areEqual((Object) this.temp, (Object) weatherAIDLContent.temp) && Intrinsics.areEqual((Object) this.weather, (Object) weatherAIDLContent.weather);
    }

    @NotNull
    public final String getAqi() {
        return this.aqi;
    }

    @NotNull
    public final String getCityName() {
        return this.cityName;
    }

    @NotNull
    public final String getImg() {
        return this.img;
    }

    @NotNull
    public final String getQuality() {
        return this.quality;
    }

    @NotNull
    public final String getTemp() {
        return this.temp;
    }

    @NotNull
    public final String getWeather() {
        return this.weather;
    }

    public int hashCode() {
        return (((((((((this.aqi.hashCode() * 31) + this.img.hashCode()) * 31) + this.quality.hashCode()) * 31) + this.cityName.hashCode()) * 31) + this.temp.hashCode()) * 31) + this.weather.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.aqi;
        String str2 = this.img;
        String str3 = this.quality;
        String str4 = this.cityName;
        String str5 = this.temp;
        String str6 = this.weather;
        return "WeatherAIDLContent(aqi=" + str + ", img=" + str2 + ", quality=" + str3 + ", cityName=" + str4 + ", temp=" + str5 + ", weather=" + str6 + ")";
    }
}
