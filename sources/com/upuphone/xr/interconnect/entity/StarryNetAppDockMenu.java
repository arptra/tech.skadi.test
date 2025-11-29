package com.upuphone.xr.interconnect.entity;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;

public class StarryNetAppDockMenu implements Parcelable {
    public static final Parcelable.Creator<StarryNetAppDockMenu> CREATOR = new Parcelable.Creator<StarryNetAppDockMenu>() {
        public StarryNetAppDockMenu createFromParcel(Parcel parcel) {
            return new StarryNetAppDockMenu(parcel);
        }

        public StarryNetAppDockMenu[] newArray(int i) {
            return new StarryNetAppDockMenu[i];
        }
    };
    private static final String TAG = "StarryNetAppDockMenu";
    private String appId;
    private Drawable icon;
    private String iconSrc;
    private String iconUrl;
    private String id;
    private String name;

    public static class Builder {
        /* access modifiers changed from: private */
        public final Drawable icon;
        /* access modifiers changed from: private */
        public String iconUrl;
        /* access modifiers changed from: private */
        public final String id;
        /* access modifiers changed from: private */
        public final String name;

        public Builder(String str, String str2, Drawable drawable) {
            this.id = str;
            this.name = str2;
            this.icon = drawable;
        }

        public StarryNetAppDockMenu build() {
            return new StarryNetAppDockMenu(this);
        }

        public Builder setIconUrl(String str) {
            this.iconUrl = str;
            return this;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getAppId() {
        return this.appId;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public String getIconSrc() {
        return this.iconSrc;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isValid() {
        if (TextUtils.isEmpty(this.id)) {
            Log.d(TAG, "必要属性menu id为空");
            return false;
        } else if (!TextUtils.isEmpty(this.name)) {
            return true;
        } else {
            Log.d(TAG, "必要属性menu name为空");
            return false;
        }
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setIconSrc(String str) {
        this.iconSrc = str;
    }

    public String toString() {
        return "StarryNetAppDockMenu{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", iconSrc='" + this.iconSrc + '\'' + ", iconUrl='" + this.iconUrl + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.iconSrc);
        parcel.writeString(this.iconUrl);
    }

    private StarryNetAppDockMenu() {
    }

    private StarryNetAppDockMenu(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.icon = builder.icon;
        this.iconUrl = builder.iconUrl;
    }

    public StarryNetAppDockMenu(Parcel parcel) {
        this.appId = parcel.readString();
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.iconSrc = parcel.readString();
        this.iconUrl = parcel.readString();
    }
}
