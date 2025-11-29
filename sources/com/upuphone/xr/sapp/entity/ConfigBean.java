package com.upuphone.xr.sapp.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

@Keep
public class ConfigBean implements Parcelable {
    public static final Parcelable.Creator<ConfigBean> CREATOR = new Parcelable.Creator<ConfigBean>() {
        public ConfigBean createFromParcel(Parcel parcel) {
            return new ConfigBean(parcel);
        }

        public ConfigBean[] newArray(int i) {
            return new ConfigBean[i];
        }
    };
    private int code;
    private ConfigDataBean data;
    private String msg;

    public ConfigBean(Parcel parcel) {
        this.code = parcel.readInt();
        this.msg = parcel.readString();
        this.data = (ConfigDataBean) parcel.readParcelable(ConfigDataBean.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public ConfigDataBean getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(ConfigDataBean configDataBean) {
        this.data = configDataBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.code);
        parcel.writeString(this.msg);
        parcel.writeParcelable(this.data, i);
    }
}
