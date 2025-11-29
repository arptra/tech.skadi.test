package com.xjsd.ai.assistant.common.bean.weather;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u001c\u001a\u00020\rH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\rH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000b¨\u0006!"}, d2 = {"Lcom/xjsd/ai/assistant/common/bean/weather/WeatherItemBean;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "dayTempMax", "", "getDayTempMax", "()Ljava/lang/Integer;", "setDayTempMax", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "dayTempMin", "getDayTempMin", "setDayTempMin", "iconCode", "getIconCode", "setIconCode", "weather", "getWeather", "setWeather", "describeContents", "writeToParcel", "", "flags", "CREATOR", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WeatherItemBean implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    @Nullable
    private String date;
    @Nullable
    private Integer dayTempMax;
    @Nullable
    private Integer dayTempMin;
    @Nullable
    private String iconCode;
    @Nullable
    private String weather;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xjsd/ai/assistant/common/bean/weather/WeatherItemBean$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/xjsd/ai/assistant/common/bean/weather/WeatherItemBean;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/xjsd/ai/assistant/common/bean/weather/WeatherItemBean;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<WeatherItemBean> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @NotNull
        public WeatherItemBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WeatherItemBean(parcel);
        }

        @NotNull
        public WeatherItemBean[] newArray(int i) {
            return new WeatherItemBean[i];
        }
    }

    public WeatherItemBean() {
    }

    public int describeContents() {
        return 0;
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

    public final void setDate(@Nullable String str) {
        this.date = str;
    }

    public final void setDayTempMax(@Nullable Integer num) {
        this.dayTempMax = num;
    }

    public final void setDayTempMin(@Nullable Integer num) {
        this.dayTempMin = num;
    }

    public final void setIconCode(@Nullable String str) {
        this.iconCode = str;
    }

    public final void setWeather(@Nullable String str) {
        this.weather = str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.date);
        Integer num = this.dayTempMax;
        int i2 = 0;
        parcel.writeInt(num != null ? num.intValue() : 0);
        Integer num2 = this.dayTempMin;
        if (num2 != null) {
            i2 = num2.intValue();
        }
        parcel.writeInt(i2);
        parcel.writeString(this.weather);
        parcel.writeString(this.iconCode);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WeatherItemBean(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = "";
        this.date = readString == null ? str : readString;
        this.dayTempMax = Integer.valueOf(parcel.readInt());
        this.dayTempMin = Integer.valueOf(parcel.readInt());
        String readString2 = parcel.readString();
        this.weather = readString2 == null ? str : readString2;
        String readString3 = parcel.readString();
        this.iconCode = readString3 != null ? readString3 : str;
    }
}
