package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.here.posclient.PositionEstimate;
import com.upuphone.runasone.uupcast.CaptureType;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001:\u0005#$%&'BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\fHÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lcom/upuphone/xr/sapp/entity/WeatherResponse;", "", "aqi", "Lcom/upuphone/xr/sapp/entity/WeatherResponse$Aqi;", "futureDays", "", "Lcom/upuphone/xr/sapp/entity/WeatherResponse$FutureDay;", "hourly", "Lcom/upuphone/xr/sapp/entity/WeatherResponse$Hourly;", "liveindices", "Lcom/upuphone/xr/sapp/entity/WeatherResponse$Liveindice;", "weather", "Lcom/upuphone/xr/sapp/entity/WeatherResponse$Weather;", "(Lcom/upuphone/xr/sapp/entity/WeatherResponse$Aqi;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/upuphone/xr/sapp/entity/WeatherResponse$Weather;)V", "getAqi", "()Lcom/upuphone/xr/sapp/entity/WeatherResponse$Aqi;", "getFutureDays", "()Ljava/util/List;", "getHourly", "getLiveindices", "getWeather", "()Lcom/upuphone/xr/sapp/entity/WeatherResponse$Weather;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Aqi", "FutureDay", "Hourly", "Liveindice", "Weather", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class WeatherResponse {
    @Nullable
    private final Aqi aqi;
    @NotNull
    private final List<FutureDay> futureDays;
    @NotNull
    private final List<Hourly> hourly;
    @NotNull
    private final List<Liveindice> liveindices;
    @NotNull
    private final Weather weather;

    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006("}, d2 = {"Lcom/upuphone/xr/sapp/entity/WeatherResponse$Aqi;", "", "aqi", "", "co", "", "lastUpdate", "no2", "o3", "pm10", "pm25", "quality", "so2", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAqi", "()I", "getCo", "()Ljava/lang/String;", "getLastUpdate", "getNo2", "getO3", "getPm10", "getPm25", "getQuality", "getSo2", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Aqi {
        private final int aqi;
        @NotNull
        private final String co;
        @NotNull
        private final String lastUpdate;
        @NotNull
        private final String no2;
        @NotNull
        private final String o3;
        @NotNull
        private final String pm10;
        @NotNull
        private final String pm25;
        @NotNull
        private final String quality;
        @NotNull
        private final String so2;

        public Aqi(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
            Intrinsics.checkNotNullParameter(str, "co");
            Intrinsics.checkNotNullParameter(str2, "lastUpdate");
            Intrinsics.checkNotNullParameter(str3, "no2");
            Intrinsics.checkNotNullParameter(str4, "o3");
            Intrinsics.checkNotNullParameter(str5, "pm10");
            Intrinsics.checkNotNullParameter(str6, "pm25");
            Intrinsics.checkNotNullParameter(str7, "quality");
            Intrinsics.checkNotNullParameter(str8, "so2");
            this.aqi = i;
            this.co = str;
            this.lastUpdate = str2;
            this.no2 = str3;
            this.o3 = str4;
            this.pm10 = str5;
            this.pm25 = str6;
            this.quality = str7;
            this.so2 = str8;
        }

        public static /* synthetic */ Aqi copy$default(Aqi aqi2, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, Object obj) {
            Aqi aqi3 = aqi2;
            int i3 = i2;
            return aqi2.copy((i3 & 1) != 0 ? aqi3.aqi : i, (i3 & 2) != 0 ? aqi3.co : str, (i3 & 4) != 0 ? aqi3.lastUpdate : str2, (i3 & 8) != 0 ? aqi3.no2 : str3, (i3 & 16) != 0 ? aqi3.o3 : str4, (i3 & 32) != 0 ? aqi3.pm10 : str5, (i3 & 64) != 0 ? aqi3.pm25 : str6, (i3 & 128) != 0 ? aqi3.quality : str7, (i3 & 256) != 0 ? aqi3.so2 : str8);
        }

        public final int component1() {
            return this.aqi;
        }

        @NotNull
        public final String component2() {
            return this.co;
        }

        @NotNull
        public final String component3() {
            return this.lastUpdate;
        }

        @NotNull
        public final String component4() {
            return this.no2;
        }

        @NotNull
        public final String component5() {
            return this.o3;
        }

        @NotNull
        public final String component6() {
            return this.pm10;
        }

        @NotNull
        public final String component7() {
            return this.pm25;
        }

        @NotNull
        public final String component8() {
            return this.quality;
        }

        @NotNull
        public final String component9() {
            return this.so2;
        }

        @NotNull
        public final Aqi copy(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
            Intrinsics.checkNotNullParameter(str, "co");
            Intrinsics.checkNotNullParameter(str2, "lastUpdate");
            Intrinsics.checkNotNullParameter(str3, "no2");
            String str9 = str4;
            Intrinsics.checkNotNullParameter(str9, "o3");
            String str10 = str5;
            Intrinsics.checkNotNullParameter(str10, "pm10");
            String str11 = str6;
            Intrinsics.checkNotNullParameter(str11, "pm25");
            String str12 = str7;
            Intrinsics.checkNotNullParameter(str12, "quality");
            String str13 = str8;
            Intrinsics.checkNotNullParameter(str13, "so2");
            return new Aqi(i, str, str2, str3, str9, str10, str11, str12, str13);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Aqi)) {
                return false;
            }
            Aqi aqi2 = (Aqi) obj;
            return this.aqi == aqi2.aqi && Intrinsics.areEqual((Object) this.co, (Object) aqi2.co) && Intrinsics.areEqual((Object) this.lastUpdate, (Object) aqi2.lastUpdate) && Intrinsics.areEqual((Object) this.no2, (Object) aqi2.no2) && Intrinsics.areEqual((Object) this.o3, (Object) aqi2.o3) && Intrinsics.areEqual((Object) this.pm10, (Object) aqi2.pm10) && Intrinsics.areEqual((Object) this.pm25, (Object) aqi2.pm25) && Intrinsics.areEqual((Object) this.quality, (Object) aqi2.quality) && Intrinsics.areEqual((Object) this.so2, (Object) aqi2.so2);
        }

        public final int getAqi() {
            return this.aqi;
        }

        @NotNull
        public final String getCo() {
            return this.co;
        }

        @NotNull
        public final String getLastUpdate() {
            return this.lastUpdate;
        }

        @NotNull
        public final String getNo2() {
            return this.no2;
        }

        @NotNull
        public final String getO3() {
            return this.o3;
        }

        @NotNull
        public final String getPm10() {
            return this.pm10;
        }

        @NotNull
        public final String getPm25() {
            return this.pm25;
        }

        @NotNull
        public final String getQuality() {
            return this.quality;
        }

        @NotNull
        public final String getSo2() {
            return this.so2;
        }

        public int hashCode() {
            return (((((((((((((((Integer.hashCode(this.aqi) * 31) + this.co.hashCode()) * 31) + this.lastUpdate.hashCode()) * 31) + this.no2.hashCode()) * 31) + this.o3.hashCode()) * 31) + this.pm10.hashCode()) * 31) + this.pm25.hashCode()) * 31) + this.quality.hashCode()) * 31) + this.so2.hashCode();
        }

        @NotNull
        public String toString() {
            int i = this.aqi;
            String str = this.co;
            String str2 = this.lastUpdate;
            String str3 = this.no2;
            String str4 = this.o3;
            String str5 = this.pm10;
            String str6 = this.pm25;
            String str7 = this.quality;
            String str8 = this.so2;
            return "Aqi(aqi=" + i + ", co=" + str + ", lastUpdate=" + str2 + ", no2=" + str3 + ", o3=" + str4 + ", pm10=" + str5 + ", pm25=" + str6 + ", quality=" + str7 + ", so2=" + str8 + ")";
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b_\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bý\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\u0006¢\u0006\u0002\u0010#J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0006HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0006HÆ\u0003J\t\u0010Z\u001a\u00020\u0006HÆ\u0003J\t\u0010[\u001a\u00020\u0006HÆ\u0003J\t\u0010\\\u001a\u00020\u0006HÆ\u0003J\t\u0010]\u001a\u00020\u0006HÆ\u0003J\t\u0010^\u001a\u00020\u0006HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0006HÆ\u0003J\t\u0010a\u001a\u00020\u0006HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J¿\u0002\u0010d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u0006HÆ\u0001J\u0013\u0010e\u001a\u00020f2\b\u0010g\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010h\u001a\u00020\u0006HÖ\u0001J\t\u0010i\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010%R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010%R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010%R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010%R\u0011\u0010\u001f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bA\u0010(R\u0011\u0010 \u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bB\u0010(R\u0011\u0010!\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bC\u0010(R\u0011\u0010\"\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bD\u0010(¨\u0006j"}, d2 = {"Lcom/upuphone/xr/sapp/entity/WeatherResponse$FutureDay;", "", "airPressure", "", "airPressureDesc", "aqi", "", "cloud", "date", "dayTemp", "humidity", "moonphase", "nightTemp", "nightWeather", "nightWeatherCode", "nightWeatherIconCode", "precipitation", "quality", "sunriseTime", "sunsetTime", "uvi", "uviDesc", "visibility", "visibilityDesc", "weather", "weatherCode", "weatherIconCode", "windDegreesDay", "windDegreesNight", "windDirDay", "windDirNight", "windLevelDay", "windLevelNight", "windSpeedDay", "windSpeedNight", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIII)V", "getAirPressure", "()Ljava/lang/String;", "getAirPressureDesc", "getAqi", "()I", "getCloud", "getDate", "getDayTemp", "getHumidity", "getMoonphase", "getNightTemp", "getNightWeather", "getNightWeatherCode", "getNightWeatherIconCode", "getPrecipitation", "getQuality", "getSunriseTime", "getSunsetTime", "getUvi", "getUviDesc", "getVisibility", "getVisibilityDesc", "getWeather", "getWeatherCode", "getWeatherIconCode", "getWindDegreesDay", "getWindDegreesNight", "getWindDirDay", "getWindDirNight", "getWindLevelDay", "getWindLevelNight", "getWindSpeedDay", "getWindSpeedNight", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FutureDay {
        @NotNull
        private final String airPressure;
        @NotNull
        private final String airPressureDesc;
        private final int aqi;
        private final int cloud;
        @NotNull
        private final String date;
        private final int dayTemp;
        private final int humidity;
        @NotNull
        private final String moonphase;
        @NotNull
        private final String nightTemp;
        @NotNull
        private final String nightWeather;
        @NotNull
        private final String nightWeatherCode;
        @NotNull
        private final String nightWeatherIconCode;
        @NotNull
        private final String precipitation;
        @NotNull
        private final String quality;
        @NotNull
        private final String sunriseTime;
        @NotNull
        private final String sunsetTime;
        private final int uvi;
        @NotNull
        private final String uviDesc;
        @NotNull
        private final String visibility;
        @NotNull
        private final String visibilityDesc;
        @NotNull
        private final String weather;
        @NotNull
        private final String weatherCode;
        @NotNull
        private final String weatherIconCode;
        @NotNull
        private final String windDegreesDay;
        @NotNull
        private final String windDegreesNight;
        @NotNull
        private final String windDirDay;
        @NotNull
        private final String windDirNight;
        private final int windLevelDay;
        private final int windLevelNight;
        private final int windSpeedDay;
        private final int windSpeedNight;

        public FutureDay(@NotNull String str, @NotNull String str2, int i, int i2, @NotNull String str3, int i3, int i4, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, int i5, @NotNull String str13, @NotNull String str14, @NotNull String str15, @NotNull String str16, @NotNull String str17, @NotNull String str18, @NotNull String str19, @NotNull String str20, @NotNull String str21, @NotNull String str22, int i6, int i7, int i8, int i9) {
            String str23 = str;
            String str24 = str2;
            String str25 = str3;
            String str26 = str4;
            String str27 = str5;
            String str28 = str6;
            String str29 = str7;
            String str30 = str8;
            String str31 = str9;
            String str32 = str10;
            String str33 = str11;
            String str34 = str12;
            String str35 = str13;
            String str36 = str14;
            String str37 = str16;
            Intrinsics.checkNotNullParameter(str23, "airPressure");
            Intrinsics.checkNotNullParameter(str24, "airPressureDesc");
            Intrinsics.checkNotNullParameter(str25, "date");
            Intrinsics.checkNotNullParameter(str26, "moonphase");
            Intrinsics.checkNotNullParameter(str27, "nightTemp");
            Intrinsics.checkNotNullParameter(str28, "nightWeather");
            Intrinsics.checkNotNullParameter(str29, "nightWeatherCode");
            Intrinsics.checkNotNullParameter(str30, "nightWeatherIconCode");
            Intrinsics.checkNotNullParameter(str31, "precipitation");
            Intrinsics.checkNotNullParameter(str32, "quality");
            Intrinsics.checkNotNullParameter(str33, "sunriseTime");
            Intrinsics.checkNotNullParameter(str34, "sunsetTime");
            Intrinsics.checkNotNullParameter(str35, "uviDesc");
            Intrinsics.checkNotNullParameter(str36, "visibility");
            Intrinsics.checkNotNullParameter(str15, "visibilityDesc");
            Intrinsics.checkNotNullParameter(str16, VuiModelType.WEATHER);
            Intrinsics.checkNotNullParameter(str17, "weatherCode");
            Intrinsics.checkNotNullParameter(str18, "weatherIconCode");
            Intrinsics.checkNotNullParameter(str19, "windDegreesDay");
            Intrinsics.checkNotNullParameter(str20, "windDegreesNight");
            Intrinsics.checkNotNullParameter(str21, "windDirDay");
            Intrinsics.checkNotNullParameter(str22, "windDirNight");
            this.airPressure = str23;
            this.airPressureDesc = str24;
            this.aqi = i;
            this.cloud = i2;
            this.date = str25;
            this.dayTemp = i3;
            this.humidity = i4;
            this.moonphase = str26;
            this.nightTemp = str27;
            this.nightWeather = str28;
            this.nightWeatherCode = str29;
            this.nightWeatherIconCode = str30;
            this.precipitation = str31;
            this.quality = str32;
            this.sunriseTime = str33;
            this.sunsetTime = str34;
            this.uvi = i5;
            this.uviDesc = str35;
            this.visibility = str36;
            this.visibilityDesc = str15;
            this.weather = str16;
            this.weatherCode = str17;
            this.weatherIconCode = str18;
            this.windDegreesDay = str19;
            this.windDegreesNight = str20;
            this.windDirDay = str21;
            this.windDirNight = str22;
            this.windLevelDay = i6;
            this.windLevelNight = i7;
            this.windSpeedDay = i8;
            this.windSpeedNight = i9;
        }

        public static /* synthetic */ FutureDay copy$default(FutureDay futureDay, String str, String str2, int i, int i2, String str3, int i3, int i4, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i5, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, int i6, int i7, int i8, int i9, int i10, Object obj) {
            FutureDay futureDay2 = futureDay;
            int i11 = i10;
            return futureDay.copy((i11 & 1) != 0 ? futureDay2.airPressure : str, (i11 & 2) != 0 ? futureDay2.airPressureDesc : str2, (i11 & 4) != 0 ? futureDay2.aqi : i, (i11 & 8) != 0 ? futureDay2.cloud : i2, (i11 & 16) != 0 ? futureDay2.date : str3, (i11 & 32) != 0 ? futureDay2.dayTemp : i3, (i11 & 64) != 0 ? futureDay2.humidity : i4, (i11 & 128) != 0 ? futureDay2.moonphase : str4, (i11 & 256) != 0 ? futureDay2.nightTemp : str5, (i11 & 512) != 0 ? futureDay2.nightWeather : str6, (i11 & 1024) != 0 ? futureDay2.nightWeatherCode : str7, (i11 & 2048) != 0 ? futureDay2.nightWeatherIconCode : str8, (i11 & 4096) != 0 ? futureDay2.precipitation : str9, (i11 & 8192) != 0 ? futureDay2.quality : str10, (i11 & 16384) != 0 ? futureDay2.sunriseTime : str11, (i11 & 32768) != 0 ? futureDay2.sunsetTime : str12, (i11 & 65536) != 0 ? futureDay2.uvi : i5, (i11 & 131072) != 0 ? futureDay2.uviDesc : str13, (i11 & PositionEstimate.Value.BUILDING_NAME) != 0 ? futureDay2.visibility : str14, (i11 & PositionEstimate.Value.TIME_SINCE_BOOT) != 0 ? futureDay2.visibilityDesc : str15, (i11 & PositionEstimate.Value.SITUATION) != 0 ? futureDay2.weather : str16, (i11 & PositionEstimate.Value.WLAN_AP_COUNT) != 0 ? futureDay2.weatherCode : str17, (i11 & PositionEstimate.Value.WLAN_AP_TIMESTAMPS) != 0 ? futureDay2.weatherIconCode : str18, (i11 & PositionEstimate.Value.ACTIVITY) != 0 ? futureDay2.windDegreesDay : str19, (i11 & 16777216) != 0 ? futureDay2.windDegreesNight : str20, (i11 & PositionEstimate.Value.GNSS_TIME) != 0 ? futureDay2.windDirDay : str21, (i11 & CaptureType.CAPTURE_TYPE_ICCOA) != 0 ? futureDay2.windDirNight : str22, (i11 & CaptureType.CAPTURE_VIRTUAL_DISPLAY_ENABLE_MAGIC_WINDOW) != 0 ? futureDay2.windLevelDay : i6, (i11 & CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED) != 0 ? futureDay2.windLevelNight : i7, (i11 & 536870912) != 0 ? futureDay2.windSpeedDay : i8, (i11 & 1073741824) != 0 ? futureDay2.windSpeedNight : i9);
        }

        @NotNull
        public final String component1() {
            return this.airPressure;
        }

        @NotNull
        public final String component10() {
            return this.nightWeather;
        }

        @NotNull
        public final String component11() {
            return this.nightWeatherCode;
        }

        @NotNull
        public final String component12() {
            return this.nightWeatherIconCode;
        }

        @NotNull
        public final String component13() {
            return this.precipitation;
        }

        @NotNull
        public final String component14() {
            return this.quality;
        }

        @NotNull
        public final String component15() {
            return this.sunriseTime;
        }

        @NotNull
        public final String component16() {
            return this.sunsetTime;
        }

        public final int component17() {
            return this.uvi;
        }

        @NotNull
        public final String component18() {
            return this.uviDesc;
        }

        @NotNull
        public final String component19() {
            return this.visibility;
        }

        @NotNull
        public final String component2() {
            return this.airPressureDesc;
        }

        @NotNull
        public final String component20() {
            return this.visibilityDesc;
        }

        @NotNull
        public final String component21() {
            return this.weather;
        }

        @NotNull
        public final String component22() {
            return this.weatherCode;
        }

        @NotNull
        public final String component23() {
            return this.weatherIconCode;
        }

        @NotNull
        public final String component24() {
            return this.windDegreesDay;
        }

        @NotNull
        public final String component25() {
            return this.windDegreesNight;
        }

        @NotNull
        public final String component26() {
            return this.windDirDay;
        }

        @NotNull
        public final String component27() {
            return this.windDirNight;
        }

        public final int component28() {
            return this.windLevelDay;
        }

        public final int component29() {
            return this.windLevelNight;
        }

        public final int component3() {
            return this.aqi;
        }

        public final int component30() {
            return this.windSpeedDay;
        }

        public final int component31() {
            return this.windSpeedNight;
        }

        public final int component4() {
            return this.cloud;
        }

        @NotNull
        public final String component5() {
            return this.date;
        }

        public final int component6() {
            return this.dayTemp;
        }

        public final int component7() {
            return this.humidity;
        }

        @NotNull
        public final String component8() {
            return this.moonphase;
        }

        @NotNull
        public final String component9() {
            return this.nightTemp;
        }

        @NotNull
        public final FutureDay copy(@NotNull String str, @NotNull String str2, int i, int i2, @NotNull String str3, int i3, int i4, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, int i5, @NotNull String str13, @NotNull String str14, @NotNull String str15, @NotNull String str16, @NotNull String str17, @NotNull String str18, @NotNull String str19, @NotNull String str20, @NotNull String str21, @NotNull String str22, int i6, int i7, int i8, int i9) {
            String str23 = str;
            Intrinsics.checkNotNullParameter(str23, "airPressure");
            Intrinsics.checkNotNullParameter(str2, "airPressureDesc");
            Intrinsics.checkNotNullParameter(str3, "date");
            Intrinsics.checkNotNullParameter(str4, "moonphase");
            Intrinsics.checkNotNullParameter(str5, "nightTemp");
            Intrinsics.checkNotNullParameter(str6, "nightWeather");
            Intrinsics.checkNotNullParameter(str7, "nightWeatherCode");
            Intrinsics.checkNotNullParameter(str8, "nightWeatherIconCode");
            Intrinsics.checkNotNullParameter(str9, "precipitation");
            Intrinsics.checkNotNullParameter(str10, "quality");
            Intrinsics.checkNotNullParameter(str11, "sunriseTime");
            Intrinsics.checkNotNullParameter(str12, "sunsetTime");
            Intrinsics.checkNotNullParameter(str13, "uviDesc");
            Intrinsics.checkNotNullParameter(str14, "visibility");
            Intrinsics.checkNotNullParameter(str15, "visibilityDesc");
            Intrinsics.checkNotNullParameter(str16, VuiModelType.WEATHER);
            Intrinsics.checkNotNullParameter(str17, "weatherCode");
            Intrinsics.checkNotNullParameter(str18, "weatherIconCode");
            Intrinsics.checkNotNullParameter(str19, "windDegreesDay");
            Intrinsics.checkNotNullParameter(str20, "windDegreesNight");
            Intrinsics.checkNotNullParameter(str21, "windDirDay");
            Intrinsics.checkNotNullParameter(str22, "windDirNight");
            return new FutureDay(str23, str2, i, i2, str3, i3, i4, str4, str5, str6, str7, str8, str9, str10, str11, str12, i5, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, i6, i7, i8, i9);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FutureDay)) {
                return false;
            }
            FutureDay futureDay = (FutureDay) obj;
            return Intrinsics.areEqual((Object) this.airPressure, (Object) futureDay.airPressure) && Intrinsics.areEqual((Object) this.airPressureDesc, (Object) futureDay.airPressureDesc) && this.aqi == futureDay.aqi && this.cloud == futureDay.cloud && Intrinsics.areEqual((Object) this.date, (Object) futureDay.date) && this.dayTemp == futureDay.dayTemp && this.humidity == futureDay.humidity && Intrinsics.areEqual((Object) this.moonphase, (Object) futureDay.moonphase) && Intrinsics.areEqual((Object) this.nightTemp, (Object) futureDay.nightTemp) && Intrinsics.areEqual((Object) this.nightWeather, (Object) futureDay.nightWeather) && Intrinsics.areEqual((Object) this.nightWeatherCode, (Object) futureDay.nightWeatherCode) && Intrinsics.areEqual((Object) this.nightWeatherIconCode, (Object) futureDay.nightWeatherIconCode) && Intrinsics.areEqual((Object) this.precipitation, (Object) futureDay.precipitation) && Intrinsics.areEqual((Object) this.quality, (Object) futureDay.quality) && Intrinsics.areEqual((Object) this.sunriseTime, (Object) futureDay.sunriseTime) && Intrinsics.areEqual((Object) this.sunsetTime, (Object) futureDay.sunsetTime) && this.uvi == futureDay.uvi && Intrinsics.areEqual((Object) this.uviDesc, (Object) futureDay.uviDesc) && Intrinsics.areEqual((Object) this.visibility, (Object) futureDay.visibility) && Intrinsics.areEqual((Object) this.visibilityDesc, (Object) futureDay.visibilityDesc) && Intrinsics.areEqual((Object) this.weather, (Object) futureDay.weather) && Intrinsics.areEqual((Object) this.weatherCode, (Object) futureDay.weatherCode) && Intrinsics.areEqual((Object) this.weatherIconCode, (Object) futureDay.weatherIconCode) && Intrinsics.areEqual((Object) this.windDegreesDay, (Object) futureDay.windDegreesDay) && Intrinsics.areEqual((Object) this.windDegreesNight, (Object) futureDay.windDegreesNight) && Intrinsics.areEqual((Object) this.windDirDay, (Object) futureDay.windDirDay) && Intrinsics.areEqual((Object) this.windDirNight, (Object) futureDay.windDirNight) && this.windLevelDay == futureDay.windLevelDay && this.windLevelNight == futureDay.windLevelNight && this.windSpeedDay == futureDay.windSpeedDay && this.windSpeedNight == futureDay.windSpeedNight;
        }

        @NotNull
        public final String getAirPressure() {
            return this.airPressure;
        }

        @NotNull
        public final String getAirPressureDesc() {
            return this.airPressureDesc;
        }

        public final int getAqi() {
            return this.aqi;
        }

        public final int getCloud() {
            return this.cloud;
        }

        @NotNull
        public final String getDate() {
            return this.date;
        }

        public final int getDayTemp() {
            return this.dayTemp;
        }

        public final int getHumidity() {
            return this.humidity;
        }

        @NotNull
        public final String getMoonphase() {
            return this.moonphase;
        }

        @NotNull
        public final String getNightTemp() {
            return this.nightTemp;
        }

        @NotNull
        public final String getNightWeather() {
            return this.nightWeather;
        }

        @NotNull
        public final String getNightWeatherCode() {
            return this.nightWeatherCode;
        }

        @NotNull
        public final String getNightWeatherIconCode() {
            return this.nightWeatherIconCode;
        }

        @NotNull
        public final String getPrecipitation() {
            return this.precipitation;
        }

        @NotNull
        public final String getQuality() {
            return this.quality;
        }

        @NotNull
        public final String getSunriseTime() {
            return this.sunriseTime;
        }

        @NotNull
        public final String getSunsetTime() {
            return this.sunsetTime;
        }

        public final int getUvi() {
            return this.uvi;
        }

        @NotNull
        public final String getUviDesc() {
            return this.uviDesc;
        }

        @NotNull
        public final String getVisibility() {
            return this.visibility;
        }

        @NotNull
        public final String getVisibilityDesc() {
            return this.visibilityDesc;
        }

        @NotNull
        public final String getWeather() {
            return this.weather;
        }

        @NotNull
        public final String getWeatherCode() {
            return this.weatherCode;
        }

        @NotNull
        public final String getWeatherIconCode() {
            return this.weatherIconCode;
        }

        @NotNull
        public final String getWindDegreesDay() {
            return this.windDegreesDay;
        }

        @NotNull
        public final String getWindDegreesNight() {
            return this.windDegreesNight;
        }

        @NotNull
        public final String getWindDirDay() {
            return this.windDirDay;
        }

        @NotNull
        public final String getWindDirNight() {
            return this.windDirNight;
        }

        public final int getWindLevelDay() {
            return this.windLevelDay;
        }

        public final int getWindLevelNight() {
            return this.windLevelNight;
        }

        public final int getWindSpeedDay() {
            return this.windSpeedDay;
        }

        public final int getWindSpeedNight() {
            return this.windSpeedNight;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.airPressure.hashCode() * 31) + this.airPressureDesc.hashCode()) * 31) + Integer.hashCode(this.aqi)) * 31) + Integer.hashCode(this.cloud)) * 31) + this.date.hashCode()) * 31) + Integer.hashCode(this.dayTemp)) * 31) + Integer.hashCode(this.humidity)) * 31) + this.moonphase.hashCode()) * 31) + this.nightTemp.hashCode()) * 31) + this.nightWeather.hashCode()) * 31) + this.nightWeatherCode.hashCode()) * 31) + this.nightWeatherIconCode.hashCode()) * 31) + this.precipitation.hashCode()) * 31) + this.quality.hashCode()) * 31) + this.sunriseTime.hashCode()) * 31) + this.sunsetTime.hashCode()) * 31) + Integer.hashCode(this.uvi)) * 31) + this.uviDesc.hashCode()) * 31) + this.visibility.hashCode()) * 31) + this.visibilityDesc.hashCode()) * 31) + this.weather.hashCode()) * 31) + this.weatherCode.hashCode()) * 31) + this.weatherIconCode.hashCode()) * 31) + this.windDegreesDay.hashCode()) * 31) + this.windDegreesNight.hashCode()) * 31) + this.windDirDay.hashCode()) * 31) + this.windDirNight.hashCode()) * 31) + Integer.hashCode(this.windLevelDay)) * 31) + Integer.hashCode(this.windLevelNight)) * 31) + Integer.hashCode(this.windSpeedDay)) * 31) + Integer.hashCode(this.windSpeedNight);
        }

        @NotNull
        public String toString() {
            String str = this.airPressure;
            String str2 = this.airPressureDesc;
            int i = this.aqi;
            int i2 = this.cloud;
            String str3 = this.date;
            int i3 = this.dayTemp;
            int i4 = this.humidity;
            String str4 = this.moonphase;
            String str5 = this.nightTemp;
            String str6 = this.nightWeather;
            String str7 = this.nightWeatherCode;
            String str8 = this.nightWeatherIconCode;
            String str9 = this.precipitation;
            String str10 = this.quality;
            String str11 = this.sunriseTime;
            String str12 = this.sunsetTime;
            int i5 = this.uvi;
            String str13 = this.uviDesc;
            String str14 = this.visibility;
            String str15 = this.visibilityDesc;
            String str16 = this.weather;
            String str17 = this.weatherCode;
            String str18 = this.weatherIconCode;
            String str19 = this.windDegreesDay;
            String str20 = this.windDegreesNight;
            String str21 = this.windDirDay;
            String str22 = this.windDirNight;
            int i6 = this.windLevelDay;
            int i7 = this.windLevelNight;
            int i8 = this.windSpeedDay;
            int i9 = this.windSpeedNight;
            return "FutureDay(airPressure=" + str + ", airPressureDesc=" + str2 + ", aqi=" + i + ", cloud=" + i2 + ", date=" + str3 + ", dayTemp=" + i3 + ", humidity=" + i4 + ", moonphase=" + str4 + ", nightTemp=" + str5 + ", nightWeather=" + str6 + ", nightWeatherCode=" + str7 + ", nightWeatherIconCode=" + str8 + ", precipitation=" + str9 + ", quality=" + str10 + ", sunriseTime=" + str11 + ", sunsetTime=" + str12 + ", uvi=" + i5 + ", uviDesc=" + str13 + ", visibility=" + str14 + ", visibilityDesc=" + str15 + ", weather=" + str16 + ", weatherCode=" + str17 + ", weatherIconCode=" + str18 + ", windDegreesDay=" + str19 + ", windDegreesNight=" + str20 + ", windDirDay=" + str21 + ", windDirNight=" + str22 + ", windLevelDay=" + i6 + ", windLevelNight=" + i7 + ", windSpeedDay=" + i8 + ", windSpeedNight=" + i9 + ")";
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/entity/WeatherResponse$Hourly;", "", "date", "", "hour", "temp", "", "weather", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getHour", "getTemp", "()I", "getWeather", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Hourly {
        @NotNull
        private final String date;
        @NotNull
        private final String hour;
        private final int temp;
        @NotNull
        private final String weather;

        public Hourly(@NotNull String str, @NotNull String str2, int i, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "date");
            Intrinsics.checkNotNullParameter(str2, "hour");
            Intrinsics.checkNotNullParameter(str3, VuiModelType.WEATHER);
            this.date = str;
            this.hour = str2;
            this.temp = i;
            this.weather = str3;
        }

        public static /* synthetic */ Hourly copy$default(Hourly hourly, String str, String str2, int i, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = hourly.date;
            }
            if ((i2 & 2) != 0) {
                str2 = hourly.hour;
            }
            if ((i2 & 4) != 0) {
                i = hourly.temp;
            }
            if ((i2 & 8) != 0) {
                str3 = hourly.weather;
            }
            return hourly.copy(str, str2, i, str3);
        }

        @NotNull
        public final String component1() {
            return this.date;
        }

        @NotNull
        public final String component2() {
            return this.hour;
        }

        public final int component3() {
            return this.temp;
        }

        @NotNull
        public final String component4() {
            return this.weather;
        }

        @NotNull
        public final Hourly copy(@NotNull String str, @NotNull String str2, int i, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "date");
            Intrinsics.checkNotNullParameter(str2, "hour");
            Intrinsics.checkNotNullParameter(str3, VuiModelType.WEATHER);
            return new Hourly(str, str2, i, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Hourly)) {
                return false;
            }
            Hourly hourly = (Hourly) obj;
            return Intrinsics.areEqual((Object) this.date, (Object) hourly.date) && Intrinsics.areEqual((Object) this.hour, (Object) hourly.hour) && this.temp == hourly.temp && Intrinsics.areEqual((Object) this.weather, (Object) hourly.weather);
        }

        @NotNull
        public final String getDate() {
            return this.date;
        }

        @NotNull
        public final String getHour() {
            return this.hour;
        }

        public final int getTemp() {
            return this.temp;
        }

        @NotNull
        public final String getWeather() {
            return this.weather;
        }

        public int hashCode() {
            return (((((this.date.hashCode() * 31) + this.hour.hashCode()) * 31) + Integer.hashCode(this.temp)) * 31) + this.weather.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.date;
            String str2 = this.hour;
            int i = this.temp;
            String str3 = this.weather;
            return "Hourly(date=" + str + ", hour=" + str2 + ", temp=" + i + ", weather=" + str3 + ")";
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/entity/WeatherResponse$Liveindice;", "", "day", "", "desc", "name", "status", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDay", "()Ljava/lang/String;", "getDesc", "getName", "getStatus", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Liveindice {
        @NotNull
        private final String day;
        @NotNull
        private final String desc;
        @NotNull
        private final String name;
        @NotNull
        private final String status;

        public Liveindice(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "day");
            Intrinsics.checkNotNullParameter(str2, "desc");
            Intrinsics.checkNotNullParameter(str3, "name");
            Intrinsics.checkNotNullParameter(str4, "status");
            this.day = str;
            this.desc = str2;
            this.name = str3;
            this.status = str4;
        }

        public static /* synthetic */ Liveindice copy$default(Liveindice liveindice, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = liveindice.day;
            }
            if ((i & 2) != 0) {
                str2 = liveindice.desc;
            }
            if ((i & 4) != 0) {
                str3 = liveindice.name;
            }
            if ((i & 8) != 0) {
                str4 = liveindice.status;
            }
            return liveindice.copy(str, str2, str3, str4);
        }

        @NotNull
        public final String component1() {
            return this.day;
        }

        @NotNull
        public final String component2() {
            return this.desc;
        }

        @NotNull
        public final String component3() {
            return this.name;
        }

        @NotNull
        public final String component4() {
            return this.status;
        }

        @NotNull
        public final Liveindice copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "day");
            Intrinsics.checkNotNullParameter(str2, "desc");
            Intrinsics.checkNotNullParameter(str3, "name");
            Intrinsics.checkNotNullParameter(str4, "status");
            return new Liveindice(str, str2, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Liveindice)) {
                return false;
            }
            Liveindice liveindice = (Liveindice) obj;
            return Intrinsics.areEqual((Object) this.day, (Object) liveindice.day) && Intrinsics.areEqual((Object) this.desc, (Object) liveindice.desc) && Intrinsics.areEqual((Object) this.name, (Object) liveindice.name) && Intrinsics.areEqual((Object) this.status, (Object) liveindice.status);
        }

        @NotNull
        public final String getDay() {
            return this.day;
        }

        @NotNull
        public final String getDesc() {
            return this.desc;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        public int hashCode() {
            return (((((this.day.hashCode() * 31) + this.desc.hashCode()) * 31) + this.name.hashCode()) * 31) + this.status.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.day;
            String str2 = this.desc;
            String str3 = this.name;
            String str4 = this.status;
            return "Liveindice(day=" + str + ", desc=" + str2 + ", name=" + str3 + ", status=" + str4 + ")";
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0007HÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0007HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001a¨\u0006:"}, d2 = {"Lcom/upuphone/xr/sapp/entity/WeatherResponse$Weather;", "", "areaName", "", "city", "lastUpdate", "pressure", "", "province", "sensibleTemp", "sunriseTime", "sunsetTime", "temp", "weather", "weatherCode", "iconCode", "wind", "windLevel", "windSpeed", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;II)V", "getAreaName", "()Ljava/lang/String;", "getCity", "getIconCode", "getLastUpdate", "getPressure", "()I", "getProvince", "getSensibleTemp", "getSunriseTime", "getSunsetTime", "getTemp", "getWeather", "getWeatherCode", "getWind", "getWindLevel", "getWindSpeed", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Weather {
        @NotNull
        private final String areaName;
        @NotNull
        private final String city;
        @NotNull
        private final String iconCode;
        @NotNull
        private final String lastUpdate;
        private final int pressure;
        @NotNull
        private final String province;
        private final int sensibleTemp;
        @NotNull
        private final String sunriseTime;
        @NotNull
        private final String sunsetTime;
        private final int temp;
        @NotNull
        private final String weather;
        private final int weatherCode;
        @NotNull
        private final String wind;
        private final int windLevel;
        private final int windSpeed;

        public Weather(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull String str4, int i2, @NotNull String str5, @NotNull String str6, int i3, @NotNull String str7, int i4, @NotNull String str8, @NotNull String str9, int i5, int i6) {
            String str10 = str4;
            String str11 = str5;
            String str12 = str6;
            String str13 = str7;
            String str14 = str8;
            String str15 = str9;
            Intrinsics.checkNotNullParameter(str, "areaName");
            Intrinsics.checkNotNullParameter(str2, "city");
            Intrinsics.checkNotNullParameter(str3, "lastUpdate");
            Intrinsics.checkNotNullParameter(str10, "province");
            Intrinsics.checkNotNullParameter(str11, "sunriseTime");
            Intrinsics.checkNotNullParameter(str12, "sunsetTime");
            Intrinsics.checkNotNullParameter(str13, VuiModelType.WEATHER);
            Intrinsics.checkNotNullParameter(str14, "iconCode");
            Intrinsics.checkNotNullParameter(str15, "wind");
            this.areaName = str;
            this.city = str2;
            this.lastUpdate = str3;
            this.pressure = i;
            this.province = str10;
            this.sensibleTemp = i2;
            this.sunriseTime = str11;
            this.sunsetTime = str12;
            this.temp = i3;
            this.weather = str13;
            this.weatherCode = i4;
            this.iconCode = str14;
            this.wind = str15;
            this.windLevel = i5;
            this.windSpeed = i6;
        }

        public static /* synthetic */ Weather copy$default(Weather weather2, String str, String str2, String str3, int i, String str4, int i2, String str5, String str6, int i3, String str7, int i4, String str8, String str9, int i5, int i6, int i7, Object obj) {
            Weather weather3 = weather2;
            int i8 = i7;
            return weather2.copy((i8 & 1) != 0 ? weather3.areaName : str, (i8 & 2) != 0 ? weather3.city : str2, (i8 & 4) != 0 ? weather3.lastUpdate : str3, (i8 & 8) != 0 ? weather3.pressure : i, (i8 & 16) != 0 ? weather3.province : str4, (i8 & 32) != 0 ? weather3.sensibleTemp : i2, (i8 & 64) != 0 ? weather3.sunriseTime : str5, (i8 & 128) != 0 ? weather3.sunsetTime : str6, (i8 & 256) != 0 ? weather3.temp : i3, (i8 & 512) != 0 ? weather3.weather : str7, (i8 & 1024) != 0 ? weather3.weatherCode : i4, (i8 & 2048) != 0 ? weather3.iconCode : str8, (i8 & 4096) != 0 ? weather3.wind : str9, (i8 & 8192) != 0 ? weather3.windLevel : i5, (i8 & 16384) != 0 ? weather3.windSpeed : i6);
        }

        @NotNull
        public final String component1() {
            return this.areaName;
        }

        @NotNull
        public final String component10() {
            return this.weather;
        }

        public final int component11() {
            return this.weatherCode;
        }

        @NotNull
        public final String component12() {
            return this.iconCode;
        }

        @NotNull
        public final String component13() {
            return this.wind;
        }

        public final int component14() {
            return this.windLevel;
        }

        public final int component15() {
            return this.windSpeed;
        }

        @NotNull
        public final String component2() {
            return this.city;
        }

        @NotNull
        public final String component3() {
            return this.lastUpdate;
        }

        public final int component4() {
            return this.pressure;
        }

        @NotNull
        public final String component5() {
            return this.province;
        }

        public final int component6() {
            return this.sensibleTemp;
        }

        @NotNull
        public final String component7() {
            return this.sunriseTime;
        }

        @NotNull
        public final String component8() {
            return this.sunsetTime;
        }

        public final int component9() {
            return this.temp;
        }

        @NotNull
        public final Weather copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull String str4, int i2, @NotNull String str5, @NotNull String str6, int i3, @NotNull String str7, int i4, @NotNull String str8, @NotNull String str9, int i5, int i6) {
            String str10 = str;
            Intrinsics.checkNotNullParameter(str10, "areaName");
            String str11 = str2;
            Intrinsics.checkNotNullParameter(str11, "city");
            String str12 = str3;
            Intrinsics.checkNotNullParameter(str12, "lastUpdate");
            String str13 = str4;
            Intrinsics.checkNotNullParameter(str13, "province");
            String str14 = str5;
            Intrinsics.checkNotNullParameter(str14, "sunriseTime");
            String str15 = str6;
            Intrinsics.checkNotNullParameter(str15, "sunsetTime");
            String str16 = str7;
            Intrinsics.checkNotNullParameter(str16, VuiModelType.WEATHER);
            String str17 = str8;
            Intrinsics.checkNotNullParameter(str17, "iconCode");
            String str18 = str9;
            Intrinsics.checkNotNullParameter(str18, "wind");
            return new Weather(str10, str11, str12, i, str13, i2, str14, str15, i3, str16, i4, str17, str18, i5, i6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Weather)) {
                return false;
            }
            Weather weather2 = (Weather) obj;
            return Intrinsics.areEqual((Object) this.areaName, (Object) weather2.areaName) && Intrinsics.areEqual((Object) this.city, (Object) weather2.city) && Intrinsics.areEqual((Object) this.lastUpdate, (Object) weather2.lastUpdate) && this.pressure == weather2.pressure && Intrinsics.areEqual((Object) this.province, (Object) weather2.province) && this.sensibleTemp == weather2.sensibleTemp && Intrinsics.areEqual((Object) this.sunriseTime, (Object) weather2.sunriseTime) && Intrinsics.areEqual((Object) this.sunsetTime, (Object) weather2.sunsetTime) && this.temp == weather2.temp && Intrinsics.areEqual((Object) this.weather, (Object) weather2.weather) && this.weatherCode == weather2.weatherCode && Intrinsics.areEqual((Object) this.iconCode, (Object) weather2.iconCode) && Intrinsics.areEqual((Object) this.wind, (Object) weather2.wind) && this.windLevel == weather2.windLevel && this.windSpeed == weather2.windSpeed;
        }

        @NotNull
        public final String getAreaName() {
            return this.areaName;
        }

        @NotNull
        public final String getCity() {
            return this.city;
        }

        @NotNull
        public final String getIconCode() {
            return this.iconCode;
        }

        @NotNull
        public final String getLastUpdate() {
            return this.lastUpdate;
        }

        public final int getPressure() {
            return this.pressure;
        }

        @NotNull
        public final String getProvince() {
            return this.province;
        }

        public final int getSensibleTemp() {
            return this.sensibleTemp;
        }

        @NotNull
        public final String getSunriseTime() {
            return this.sunriseTime;
        }

        @NotNull
        public final String getSunsetTime() {
            return this.sunsetTime;
        }

        public final int getTemp() {
            return this.temp;
        }

        @NotNull
        public final String getWeather() {
            return this.weather;
        }

        public final int getWeatherCode() {
            return this.weatherCode;
        }

        @NotNull
        public final String getWind() {
            return this.wind;
        }

        public final int getWindLevel() {
            return this.windLevel;
        }

        public final int getWindSpeed() {
            return this.windSpeed;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((this.areaName.hashCode() * 31) + this.city.hashCode()) * 31) + this.lastUpdate.hashCode()) * 31) + Integer.hashCode(this.pressure)) * 31) + this.province.hashCode()) * 31) + Integer.hashCode(this.sensibleTemp)) * 31) + this.sunriseTime.hashCode()) * 31) + this.sunsetTime.hashCode()) * 31) + Integer.hashCode(this.temp)) * 31) + this.weather.hashCode()) * 31) + Integer.hashCode(this.weatherCode)) * 31) + this.iconCode.hashCode()) * 31) + this.wind.hashCode()) * 31) + Integer.hashCode(this.windLevel)) * 31) + Integer.hashCode(this.windSpeed);
        }

        @NotNull
        public String toString() {
            String str = this.areaName;
            String str2 = this.city;
            String str3 = this.lastUpdate;
            int i = this.pressure;
            String str4 = this.province;
            int i2 = this.sensibleTemp;
            String str5 = this.sunriseTime;
            String str6 = this.sunsetTime;
            int i3 = this.temp;
            String str7 = this.weather;
            int i4 = this.weatherCode;
            String str8 = this.iconCode;
            String str9 = this.wind;
            int i5 = this.windLevel;
            int i6 = this.windSpeed;
            return "Weather(areaName=" + str + ", city=" + str2 + ", lastUpdate=" + str3 + ", pressure=" + i + ", province=" + str4 + ", sensibleTemp=" + i2 + ", sunriseTime=" + str5 + ", sunsetTime=" + str6 + ", temp=" + i3 + ", weather=" + str7 + ", weatherCode=" + i4 + ", iconCode=" + str8 + ", wind=" + str9 + ", windLevel=" + i5 + ", windSpeed=" + i6 + ")";
        }
    }

    public WeatherResponse(@Nullable Aqi aqi2, @NotNull List<FutureDay> list, @NotNull List<Hourly> list2, @NotNull List<Liveindice> list3, @NotNull Weather weather2) {
        Intrinsics.checkNotNullParameter(list, "futureDays");
        Intrinsics.checkNotNullParameter(list2, "hourly");
        Intrinsics.checkNotNullParameter(list3, "liveindices");
        Intrinsics.checkNotNullParameter(weather2, VuiModelType.WEATHER);
        this.aqi = aqi2;
        this.futureDays = list;
        this.hourly = list2;
        this.liveindices = list3;
        this.weather = weather2;
    }

    public static /* synthetic */ WeatherResponse copy$default(WeatherResponse weatherResponse, Aqi aqi2, List<FutureDay> list, List<Hourly> list2, List<Liveindice> list3, Weather weather2, int i, Object obj) {
        if ((i & 1) != 0) {
            aqi2 = weatherResponse.aqi;
        }
        if ((i & 2) != 0) {
            list = weatherResponse.futureDays;
        }
        List<FutureDay> list4 = list;
        if ((i & 4) != 0) {
            list2 = weatherResponse.hourly;
        }
        List<Hourly> list5 = list2;
        if ((i & 8) != 0) {
            list3 = weatherResponse.liveindices;
        }
        List<Liveindice> list6 = list3;
        if ((i & 16) != 0) {
            weather2 = weatherResponse.weather;
        }
        return weatherResponse.copy(aqi2, list4, list5, list6, weather2);
    }

    @Nullable
    public final Aqi component1() {
        return this.aqi;
    }

    @NotNull
    public final List<FutureDay> component2() {
        return this.futureDays;
    }

    @NotNull
    public final List<Hourly> component3() {
        return this.hourly;
    }

    @NotNull
    public final List<Liveindice> component4() {
        return this.liveindices;
    }

    @NotNull
    public final Weather component5() {
        return this.weather;
    }

    @NotNull
    public final WeatherResponse copy(@Nullable Aqi aqi2, @NotNull List<FutureDay> list, @NotNull List<Hourly> list2, @NotNull List<Liveindice> list3, @NotNull Weather weather2) {
        Intrinsics.checkNotNullParameter(list, "futureDays");
        Intrinsics.checkNotNullParameter(list2, "hourly");
        Intrinsics.checkNotNullParameter(list3, "liveindices");
        Intrinsics.checkNotNullParameter(weather2, VuiModelType.WEATHER);
        return new WeatherResponse(aqi2, list, list2, list3, weather2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WeatherResponse)) {
            return false;
        }
        WeatherResponse weatherResponse = (WeatherResponse) obj;
        return Intrinsics.areEqual((Object) this.aqi, (Object) weatherResponse.aqi) && Intrinsics.areEqual((Object) this.futureDays, (Object) weatherResponse.futureDays) && Intrinsics.areEqual((Object) this.hourly, (Object) weatherResponse.hourly) && Intrinsics.areEqual((Object) this.liveindices, (Object) weatherResponse.liveindices) && Intrinsics.areEqual((Object) this.weather, (Object) weatherResponse.weather);
    }

    @Nullable
    public final Aqi getAqi() {
        return this.aqi;
    }

    @NotNull
    public final List<FutureDay> getFutureDays() {
        return this.futureDays;
    }

    @NotNull
    public final List<Hourly> getHourly() {
        return this.hourly;
    }

    @NotNull
    public final List<Liveindice> getLiveindices() {
        return this.liveindices;
    }

    @NotNull
    public final Weather getWeather() {
        return this.weather;
    }

    public int hashCode() {
        Aqi aqi2 = this.aqi;
        return ((((((((aqi2 == null ? 0 : aqi2.hashCode()) * 31) + this.futureDays.hashCode()) * 31) + this.hourly.hashCode()) * 31) + this.liveindices.hashCode()) * 31) + this.weather.hashCode();
    }

    @NotNull
    public String toString() {
        Aqi aqi2 = this.aqi;
        List<FutureDay> list = this.futureDays;
        List<Hourly> list2 = this.hourly;
        List<Liveindice> list3 = this.liveindices;
        Weather weather2 = this.weather;
        return "WeatherResponse(aqi=" + aqi2 + ", futureDays=" + list + ", hourly=" + list2 + ", liveindices=" + list3 + ", weather=" + weather2 + ")";
    }
}
