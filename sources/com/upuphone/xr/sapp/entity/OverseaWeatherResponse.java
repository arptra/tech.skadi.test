package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/entity/OverseaWeatherResponse;", "", "code", "", "data", "Lcom/upuphone/xr/sapp/entity/OverseaWeatherResponse$Data;", "message", "", "(ILcom/upuphone/xr/sapp/entity/OverseaWeatherResponse$Data;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Lcom/upuphone/xr/sapp/entity/OverseaWeatherResponse$Data;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Data", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class OverseaWeatherResponse {
    private final int code;
    @Nullable
    private final Data data;
    @NotNull
    private final String message;

    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/OverseaWeatherResponse$Data;", "", "iconCode", "", "lastUpdate", "", "qweather", "sunriseTime", "sunsetTime", "temp", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIconCode", "()I", "getLastUpdate", "()Ljava/lang/String;", "getQweather", "getSunriseTime", "getSunsetTime", "getTemp", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Data {
        private final int iconCode;
        @NotNull
        private final String lastUpdate;
        @NotNull
        private final String qweather;
        @NotNull
        private final String sunriseTime;
        @NotNull
        private final String sunsetTime;
        @NotNull
        private final String temp;

        public Data(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(str, "lastUpdate");
            Intrinsics.checkNotNullParameter(str2, "qweather");
            Intrinsics.checkNotNullParameter(str3, "sunriseTime");
            Intrinsics.checkNotNullParameter(str4, "sunsetTime");
            Intrinsics.checkNotNullParameter(str5, "temp");
            this.iconCode = i;
            this.lastUpdate = str;
            this.qweather = str2;
            this.sunriseTime = str3;
            this.sunsetTime = str4;
            this.temp = str5;
        }

        public static /* synthetic */ Data copy$default(Data data, int i, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = data.iconCode;
            }
            if ((i2 & 2) != 0) {
                str = data.lastUpdate;
            }
            String str6 = str;
            if ((i2 & 4) != 0) {
                str2 = data.qweather;
            }
            String str7 = str2;
            if ((i2 & 8) != 0) {
                str3 = data.sunriseTime;
            }
            String str8 = str3;
            if ((i2 & 16) != 0) {
                str4 = data.sunsetTime;
            }
            String str9 = str4;
            if ((i2 & 32) != 0) {
                str5 = data.temp;
            }
            return data.copy(i, str6, str7, str8, str9, str5);
        }

        public final int component1() {
            return this.iconCode;
        }

        @NotNull
        public final String component2() {
            return this.lastUpdate;
        }

        @NotNull
        public final String component3() {
            return this.qweather;
        }

        @NotNull
        public final String component4() {
            return this.sunriseTime;
        }

        @NotNull
        public final String component5() {
            return this.sunsetTime;
        }

        @NotNull
        public final String component6() {
            return this.temp;
        }

        @NotNull
        public final Data copy(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(str, "lastUpdate");
            Intrinsics.checkNotNullParameter(str2, "qweather");
            Intrinsics.checkNotNullParameter(str3, "sunriseTime");
            Intrinsics.checkNotNullParameter(str4, "sunsetTime");
            Intrinsics.checkNotNullParameter(str5, "temp");
            return new Data(i, str, str2, str3, str4, str5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return this.iconCode == data.iconCode && Intrinsics.areEqual((Object) this.lastUpdate, (Object) data.lastUpdate) && Intrinsics.areEqual((Object) this.qweather, (Object) data.qweather) && Intrinsics.areEqual((Object) this.sunriseTime, (Object) data.sunriseTime) && Intrinsics.areEqual((Object) this.sunsetTime, (Object) data.sunsetTime) && Intrinsics.areEqual((Object) this.temp, (Object) data.temp);
        }

        public final int getIconCode() {
            return this.iconCode;
        }

        @NotNull
        public final String getLastUpdate() {
            return this.lastUpdate;
        }

        @NotNull
        public final String getQweather() {
            return this.qweather;
        }

        @NotNull
        public final String getSunriseTime() {
            return this.sunriseTime;
        }

        @NotNull
        public final String getSunsetTime() {
            return this.sunsetTime;
        }

        @NotNull
        public final String getTemp() {
            return this.temp;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.iconCode) * 31) + this.lastUpdate.hashCode()) * 31) + this.qweather.hashCode()) * 31) + this.sunriseTime.hashCode()) * 31) + this.sunsetTime.hashCode()) * 31) + this.temp.hashCode();
        }

        @NotNull
        public String toString() {
            int i = this.iconCode;
            String str = this.lastUpdate;
            String str2 = this.qweather;
            String str3 = this.sunriseTime;
            String str4 = this.sunsetTime;
            String str5 = this.temp;
            return "Data(iconCode=" + i + ", lastUpdate=" + str + ", qweather=" + str2 + ", sunriseTime=" + str3 + ", sunsetTime=" + str4 + ", temp=" + str5 + ")";
        }
    }

    public OverseaWeatherResponse(int i, @Nullable Data data2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.code = i;
        this.data = data2;
        this.message = str;
    }

    public static /* synthetic */ OverseaWeatherResponse copy$default(OverseaWeatherResponse overseaWeatherResponse, int i, Data data2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = overseaWeatherResponse.code;
        }
        if ((i2 & 2) != 0) {
            data2 = overseaWeatherResponse.data;
        }
        if ((i2 & 4) != 0) {
            str = overseaWeatherResponse.message;
        }
        return overseaWeatherResponse.copy(i, data2, str);
    }

    public final int component1() {
        return this.code;
    }

    @Nullable
    public final Data component2() {
        return this.data;
    }

    @NotNull
    public final String component3() {
        return this.message;
    }

    @NotNull
    public final OverseaWeatherResponse copy(int i, @Nullable Data data2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new OverseaWeatherResponse(i, data2, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OverseaWeatherResponse)) {
            return false;
        }
        OverseaWeatherResponse overseaWeatherResponse = (OverseaWeatherResponse) obj;
        return this.code == overseaWeatherResponse.code && Intrinsics.areEqual((Object) this.data, (Object) overseaWeatherResponse.data) && Intrinsics.areEqual((Object) this.message, (Object) overseaWeatherResponse.message);
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final Data getData() {
        return this.data;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.code) * 31;
        Data data2 = this.data;
        return ((hashCode + (data2 == null ? 0 : data2.hashCode())) * 31) + this.message.hashCode();
    }

    @NotNull
    public String toString() {
        int i = this.code;
        Data data2 = this.data;
        String str = this.message;
        return "OverseaWeatherResponse(code=" + i + ", data=" + data2 + ", message=" + str + ")";
    }
}
