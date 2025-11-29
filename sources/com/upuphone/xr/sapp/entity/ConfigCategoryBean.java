package com.upuphone.xr.sapp.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

@Keep
public class ConfigCategoryBean implements Parcelable {
    public static final Parcelable.Creator<ConfigCategoryBean> CREATOR = new Parcelable.Creator<ConfigCategoryBean>() {
        public ConfigCategoryBean createFromParcel(Parcel parcel) {
            return new ConfigCategoryBean(parcel);
        }

        public ConfigCategoryBean[] newArray(int i) {
            return new ConfigCategoryBean[i];
        }
    };
    private String categoryId;
    private String categoryImgUrl;
    private String categoryName;

    public ConfigCategoryBean(Parcel parcel) {
        this.categoryId = parcel.readString();
        this.categoryName = parcel.readString();
        this.categoryImgUrl = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryImgUrl() {
        return this.categoryImgUrl;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCategoryImgUrl(String str) {
        this.categoryImgUrl = str;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public String toString() {
        return "ConfigCategoryBean{categoryId='" + this.categoryId + '\'' + ", categoryName='" + this.categoryName + '\'' + ", categoryImgUrl='" + this.categoryImgUrl + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.categoryId);
        parcel.writeString(this.categoryName);
        parcel.writeString(this.categoryImgUrl);
    }
}
