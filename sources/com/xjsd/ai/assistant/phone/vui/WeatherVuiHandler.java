package com.xjsd.ai.assistant.phone.vui;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.honey.account.na.d;
import com.xjsd.ai.assistant.common.handler.VuiHandler;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.core.api.tts.TtsData;
import com.xjsd.ai.assistant.core.util.DeviceUtils;
import com.xjsd.ai.assistant.json.JsonUtil;
import com.xjsd.ai.assistant.log.ILog;
import com.xjsd.ai.assistant.phone.VoiceAssistantApi;
import com.xjsd.ai.assistant.phone.tts.TtsManager;
import com.xjsd.ai.assistant.protocol.VuiModel;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import com.xjsd.ai.assistant.protocol.vui.Utterance;
import com.xjsd.ai.assistant.template.TtsGlobalTemplate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \n2\u00020\u0001:\u0005\u0019\u001a\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J!\u0010\u0017\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler;", "Lcom/xjsd/ai/assistant/common/handler/VuiHandler;", "<init>", "()V", "", "getHandleType", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/protocol/VuiModel;", "model", "", "a", "(Lcom/xjsd/ai/assistant/protocol/VuiModel;)Z", "", "start", "end", "Lcom/alibaba/fastjson/JSONObject;", "payload", "", "d", "(JJLcom/alibaba/fastjson/JSONObject;)V", "f", "date", "format", "c", "(Ljava/lang/String;Ljava/lang/String;)J", "Companion", "DayWeather", "LocationInfo", "Result", "WeatherResponse", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nWeatherVuiHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeatherVuiHandler.kt\ncom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,162:1\n1855#2,2:163\n*S KotlinDebug\n*F\n+ 1 WeatherVuiHandler.kt\ncom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler\n*L\n91#1:163,2\n*E\n"})
public final class WeatherVuiHandler implements VuiHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8628a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler$Companion;", "", "()V", "TAG", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler$DayWeather;", "", "date", "", "dayTemp", "", "nightTemp", "uvi", "weather", "iconDay", "(Ljava/lang/String;IIILjava/lang/String;I)V", "getDate", "()Ljava/lang/String;", "getDayTemp", "()I", "getIconDay", "getNightTemp", "getUvi", "getWeather", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DayWeather {
        @Nullable
        private final String date;
        private final int dayTemp;
        private final int iconDay;
        private final int nightTemp;
        private final int uvi;
        @Nullable
        private final String weather;

        public DayWeather() {
            this((String) null, 0, 0, 0, (String) null, 0, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ DayWeather copy$default(DayWeather dayWeather, String str, int i, int i2, int i3, String str2, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = dayWeather.date;
            }
            if ((i5 & 2) != 0) {
                i = dayWeather.dayTemp;
            }
            int i6 = i;
            if ((i5 & 4) != 0) {
                i2 = dayWeather.nightTemp;
            }
            int i7 = i2;
            if ((i5 & 8) != 0) {
                i3 = dayWeather.uvi;
            }
            int i8 = i3;
            if ((i5 & 16) != 0) {
                str2 = dayWeather.weather;
            }
            String str3 = str2;
            if ((i5 & 32) != 0) {
                i4 = dayWeather.iconDay;
            }
            return dayWeather.copy(str, i6, i7, i8, str3, i4);
        }

        @Nullable
        public final String component1() {
            return this.date;
        }

        public final int component2() {
            return this.dayTemp;
        }

        public final int component3() {
            return this.nightTemp;
        }

        public final int component4() {
            return this.uvi;
        }

        @Nullable
        public final String component5() {
            return this.weather;
        }

        public final int component6() {
            return this.iconDay;
        }

        @NotNull
        public final DayWeather copy(@Nullable String str, int i, int i2, int i3, @Nullable String str2, int i4) {
            return new DayWeather(str, i, i2, i3, str2, i4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DayWeather)) {
                return false;
            }
            DayWeather dayWeather = (DayWeather) obj;
            return Intrinsics.areEqual((Object) this.date, (Object) dayWeather.date) && this.dayTemp == dayWeather.dayTemp && this.nightTemp == dayWeather.nightTemp && this.uvi == dayWeather.uvi && Intrinsics.areEqual((Object) this.weather, (Object) dayWeather.weather) && this.iconDay == dayWeather.iconDay;
        }

        @Nullable
        public final String getDate() {
            return this.date;
        }

        public final int getDayTemp() {
            return this.dayTemp;
        }

        public final int getIconDay() {
            return this.iconDay;
        }

        public final int getNightTemp() {
            return this.nightTemp;
        }

        public final int getUvi() {
            return this.uvi;
        }

        @Nullable
        public final String getWeather() {
            return this.weather;
        }

        public int hashCode() {
            String str = this.date;
            int i = 0;
            int hashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.dayTemp)) * 31) + Integer.hashCode(this.nightTemp)) * 31) + Integer.hashCode(this.uvi)) * 31;
            String str2 = this.weather;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return ((hashCode + i) * 31) + Integer.hashCode(this.iconDay);
        }

        @NotNull
        public String toString() {
            String str = this.date;
            int i = this.dayTemp;
            int i2 = this.nightTemp;
            int i3 = this.uvi;
            String str2 = this.weather;
            int i4 = this.iconDay;
            return "DayWeather(date=" + str + ", dayTemp=" + i + ", nightTemp=" + i2 + ", uvi=" + i3 + ", weather=" + str2 + ", iconDay=" + i4 + ")";
        }

        public DayWeather(@Nullable String str, int i, int i2, int i3, @Nullable String str2, int i4) {
            this.date = str;
            this.dayTemp = i;
            this.nightTemp = i2;
            this.uvi = i3;
            this.weather = str2;
            this.iconDay = i4;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DayWeather(String str, int i, int i2, int i3, String str2, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : str, (i5 & 2) != 0 ? 0 : i, (i5 & 4) != 0 ? 0 : i2, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? null : str2, (i5 & 32) != 0 ? 0 : i4);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler$LocationInfo;", "", "areaName", "", "city", "province", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAreaName", "()Ljava/lang/String;", "getCity", "getProvince", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class LocationInfo {
        @Nullable
        private final String areaName;
        @Nullable
        private final String city;
        @Nullable
        private final String province;

        public LocationInfo(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.areaName = str;
            this.city = str2;
            this.province = str3;
        }

        public static /* synthetic */ LocationInfo copy$default(LocationInfo locationInfo, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = locationInfo.areaName;
            }
            if ((i & 2) != 0) {
                str2 = locationInfo.city;
            }
            if ((i & 4) != 0) {
                str3 = locationInfo.province;
            }
            return locationInfo.copy(str, str2, str3);
        }

        @Nullable
        public final String component1() {
            return this.areaName;
        }

        @Nullable
        public final String component2() {
            return this.city;
        }

        @Nullable
        public final String component3() {
            return this.province;
        }

        @NotNull
        public final LocationInfo copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            return new LocationInfo(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocationInfo)) {
                return false;
            }
            LocationInfo locationInfo = (LocationInfo) obj;
            return Intrinsics.areEqual((Object) this.areaName, (Object) locationInfo.areaName) && Intrinsics.areEqual((Object) this.city, (Object) locationInfo.city) && Intrinsics.areEqual((Object) this.province, (Object) locationInfo.province);
        }

        @Nullable
        public final String getAreaName() {
            return this.areaName;
        }

        @Nullable
        public final String getCity() {
            return this.city;
        }

        @Nullable
        public final String getProvince() {
            return this.province;
        }

        public int hashCode() {
            String str = this.areaName;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.city;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.province;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            String str = this.areaName;
            String str2 = this.city;
            String str3 = this.province;
            return "LocationInfo(areaName=" + str + ", city=" + str2 + ", province=" + str3 + ")";
        }
    }

    @Keep
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler$Result;", "", "futureDays", "", "Lcom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler$DayWeather;", "weatherResponse", "Lcom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler$WeatherResponse;", "(Ljava/util/List;Lcom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler$WeatherResponse;)V", "getFutureDays", "()Ljava/util/List;", "getWeatherResponse", "()Lcom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler$WeatherResponse;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Result {
        @NotNull
        private final List<DayWeather> futureDays;
        @NotNull
        private final WeatherResponse weatherResponse;

        public Result(@NotNull List<DayWeather> list, @NotNull WeatherResponse weatherResponse2) {
            Intrinsics.checkNotNullParameter(list, "futureDays");
            Intrinsics.checkNotNullParameter(weatherResponse2, "weatherResponse");
            this.futureDays = list;
            this.weatherResponse = weatherResponse2;
        }

        public static /* synthetic */ Result copy$default(Result result, List<DayWeather> list, WeatherResponse weatherResponse2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = result.futureDays;
            }
            if ((i & 2) != 0) {
                weatherResponse2 = result.weatherResponse;
            }
            return result.copy(list, weatherResponse2);
        }

        @NotNull
        public final List<DayWeather> component1() {
            return this.futureDays;
        }

        @NotNull
        public final WeatherResponse component2() {
            return this.weatherResponse;
        }

        @NotNull
        public final Result copy(@NotNull List<DayWeather> list, @NotNull WeatherResponse weatherResponse2) {
            Intrinsics.checkNotNullParameter(list, "futureDays");
            Intrinsics.checkNotNullParameter(weatherResponse2, "weatherResponse");
            return new Result(list, weatherResponse2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return Intrinsics.areEqual((Object) this.futureDays, (Object) result.futureDays) && Intrinsics.areEqual((Object) this.weatherResponse, (Object) result.weatherResponse);
        }

        @NotNull
        public final List<DayWeather> getFutureDays() {
            return this.futureDays;
        }

        @NotNull
        public final WeatherResponse getWeatherResponse() {
            return this.weatherResponse;
        }

        public int hashCode() {
            return (this.futureDays.hashCode() * 31) + this.weatherResponse.hashCode();
        }

        @NotNull
        public String toString() {
            List<DayWeather> list = this.futureDays;
            WeatherResponse weatherResponse2 = this.weatherResponse;
            return "Result(futureDays=" + list + ", weatherResponse=" + weatherResponse2 + ")";
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler$WeatherResponse;", "", "weatherDataInfo", "Lcom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler$LocationInfo;", "(Lcom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler$LocationInfo;)V", "getWeatherDataInfo", "()Lcom/xjsd/ai/assistant/phone/vui/WeatherVuiHandler$LocationInfo;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class WeatherResponse {
        @NotNull
        private final LocationInfo weatherDataInfo;

        public WeatherResponse(@NotNull LocationInfo locationInfo) {
            Intrinsics.checkNotNullParameter(locationInfo, "weatherDataInfo");
            this.weatherDataInfo = locationInfo;
        }

        public static /* synthetic */ WeatherResponse copy$default(WeatherResponse weatherResponse, LocationInfo locationInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                locationInfo = weatherResponse.weatherDataInfo;
            }
            return weatherResponse.copy(locationInfo);
        }

        @NotNull
        public final LocationInfo component1() {
            return this.weatherDataInfo;
        }

        @NotNull
        public final WeatherResponse copy(@NotNull LocationInfo locationInfo) {
            Intrinsics.checkNotNullParameter(locationInfo, "weatherDataInfo");
            return new WeatherResponse(locationInfo);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WeatherResponse) && Intrinsics.areEqual((Object) this.weatherDataInfo, (Object) ((WeatherResponse) obj).weatherDataInfo);
        }

        @NotNull
        public final LocationInfo getWeatherDataInfo() {
            return this.weatherDataInfo;
        }

        public int hashCode() {
            return this.weatherDataInfo.hashCode();
        }

        @NotNull
        public String toString() {
            LocationInfo locationInfo = this.weatherDataInfo;
            return "WeatherResponse(weatherDataInfo=" + locationInfo + ")";
        }
    }

    public static final boolean e(WeatherVuiHandler weatherVuiHandler, long j, long j2, Object obj) {
        Intrinsics.checkNotNullParameter(weatherVuiHandler, "this$0");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
        long c = weatherVuiHandler.c(((JSONObject) obj).getString("date"), "yyyy-MM-dd");
        ILog.a("WeatherVuiHandler", "start: " + j + ", end: " + j2 + ", current: " + c);
        return c < j || c > j2;
    }

    public boolean a(VuiModel vuiModel) {
        Object obj;
        String speech;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(vuiModel, "model");
        try {
            Result.Companion companion = kotlin.Result.Companion;
            JSONObject payload = vuiModel.getPayload();
            if (payload != null && payload.containsKey("result")) {
                String string = payload.getString("time_start");
                if (string != null) {
                    Intrinsics.checkNotNull(string);
                    str = string.substring(0, 10);
                    Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                } else {
                    str = null;
                }
                long c = c(str, "yyyy-MM-dd");
                String string2 = payload.getString("time_end");
                if (string2 != null) {
                    Intrinsics.checkNotNull(string2);
                    str2 = string2.substring(0, 10);
                    Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                } else {
                    str2 = null;
                }
                long c2 = c(str2, "yyyy-MM-dd");
                if (VoiceAssistantApi.isOversea) {
                    Intrinsics.checkNotNull(payload);
                    f(c, c2, payload);
                } else {
                    Intrinsics.checkNotNull(payload);
                    d(c, c2, payload);
                }
            }
            if (DeviceUtils.d()) {
                vuiModel.setUtterance((Utterance) null);
            } else {
                JSONObject payload2 = vuiModel.getPayload();
                if (payload2 != null) {
                    payload2.remove("utterance");
                }
            }
            ILog.a("WeatherVuiHandler", "after process = " + vuiModel);
            obj = kotlin.Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.Companion;
            obj = kotlin.Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r13 = kotlin.Result.m23exceptionOrNullimpl(obj);
        if (r13 == null) {
            return false;
        }
        ILog.a("WeatherVuiHandler", "Weather exception: " + r13.getMessage());
        TtsData ttsData = new TtsData();
        Utterance utterance = vuiModel.getUtterance();
        if (!(utterance == null || (speech = utterance.getSpeech()) == null)) {
            Intrinsics.checkNotNull(speech);
            if (speech.length() > 0) {
                ttsData.setText(utterance.getSpeech());
                ttsData.setFunctionId(utterance.getId());
                TtsManager.g.f(ttsData);
                return true;
            }
        }
        TtsGlobalTemplate ttsGlobalTemplate = TtsGlobalTemplate.GLOBAL01_P06;
        ttsData.setText(ContextHelper.b(ttsGlobalTemplate.getResId(), new Object[0]));
        ttsData.setFunctionId(ttsGlobalTemplate.getFunctionId());
        TtsManager.g.f(ttsData);
        return true;
    }

    public final long c(String str, String str2) {
        if (!(str == null || str.length() == 0)) {
            try {
                return new SimpleDateFormat(str2).parse(str).getTime();
            } catch (ParseException e) {
                ILog.h("WeatherVuiHandler", "date ParseException:%s", e);
            }
        }
        return 0;
    }

    public final void d(long j, long j2, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = jSONObject2.getJSONObject("result");
        if (jSONObject3 != null) {
            jSONObject3.remove("hourly");
        }
        JSONArray jSONArray = jSONObject3 != null ? jSONObject3.getJSONArray("futureDays") : null;
        if (jSONArray == null || jSONArray.size() < 1) {
            ILog.a("WeatherVuiHandler", "null future days");
            return;
        }
        jSONArray.removeIf(new d(this, j, j2));
        jSONObject2.put("result", jSONObject3.toString());
    }

    public final void f(long j, long j2, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        JSONArray jSONArray = jSONObject2.getJSONArray("result");
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (Object next : jSONArray) {
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
                JSONObject jSONObject3 = (JSONObject) next;
                long c = c(jSONObject3.getString("fxDate"), "yyyy-MM-dd");
                if (j <= c && c <= j2) {
                    arrayList.add(new DayWeather(jSONObject3.getString("fxDate"), jSONObject3.getIntValue("tempMax"), jSONObject3.getIntValue("tempMin"), jSONObject3.getIntValue("uvIndex"), jSONObject3.getString("textDay"), jSONObject3.getIntValue("iconDay")));
                }
            }
        }
        JSONObject jSONObject4 = jSONObject2.getJSONObject("poi");
        String str = null;
        String string = jSONObject4 != null ? jSONObject4.getString("name") : null;
        String string2 = jSONObject4 != null ? jSONObject4.getString("adm2") : null;
        if (jSONObject4 != null) {
            str = jSONObject4.getString("adm1");
        }
        jSONObject2.put("result", JsonUtil.c(new Result(arrayList, new WeatherResponse(new LocationInfo(string, string2, str)))));
    }

    public String getHandleType() {
        return VuiModelType.WEATHER;
    }
}
