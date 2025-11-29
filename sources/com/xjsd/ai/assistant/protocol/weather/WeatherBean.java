package com.xjsd.ai.assistant.protocol.weather;

import android.os.Parcel;
import android.os.Parcelable;
import com.xjsd.ai.assistant.common.bean.weather.WeatherItemBean;
import java.util.List;

public class WeatherBean implements Parcelable {
    public static final Parcelable.Creator<WeatherBean> CREATOR = new Parcelable.Creator<WeatherBean>() {
        public WeatherBean createFromParcel(Parcel parcel) {
            return new WeatherBean(parcel);
        }

        public WeatherBean[] newArray(int i) {
            return new WeatherBean[i];
        }
    };
    private String location;
    private List<WeatherItemBean> weatherItemBeans;
    private int weatherType;

    public WeatherBean() {
    }

    public int describeContents() {
        return 0;
    }

    public String getLocation() {
        return this.location;
    }

    public List<WeatherItemBean> getWeatherItemBeans() {
        return this.weatherItemBeans;
    }

    public int getWeatherType() {
        return this.weatherType;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setWeatherItemBeans(List<WeatherItemBean> list) {
        this.weatherItemBeans = list;
    }

    public void setWeatherType(int i) {
        this.weatherType = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.location);
        parcel.writeTypedList(this.weatherItemBeans);
        parcel.writeInt(this.weatherType);
    }

    public WeatherBean(Parcel parcel) {
        this.location = parcel.readString();
        this.weatherItemBeans = parcel.createTypedArrayList(WeatherItemBean.CREATOR);
        this.weatherType = parcel.readInt();
    }
}
