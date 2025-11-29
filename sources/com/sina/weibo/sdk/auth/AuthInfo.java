package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.d0;
import java.io.Serializable;

public final class AuthInfo implements Serializable, Parcelable {
    public static final Parcelable.Creator<AuthInfo> CREATOR = new a();
    private static final long serialVersionUID = 6421253895937667193L;
    private String app_key;
    private String hash;
    private String package_name;
    private String redirect_url;
    private String scope;

    public class a implements Parcelable.Creator<AuthInfo> {
        public final Object createFromParcel(Parcel parcel) {
            return new AuthInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new AuthInfo[i];
        }
    }

    public AuthInfo(Context context, String str, String str2, String str3) {
        this.app_key = str;
        this.redirect_url = str2;
        this.scope = str3;
        String packageName = context.getPackageName();
        this.package_name = packageName;
        this.hash = d0.a(context, packageName);
    }

    public int describeContents() {
        return 0;
    }

    public String getAppKey() {
        return this.app_key;
    }

    public String getHash() {
        return this.hash;
    }

    public String getPackageName() {
        return this.package_name;
    }

    public String getRedirectUrl() {
        return this.redirect_url;
    }

    public String getScope() {
        return this.scope;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.app_key);
        parcel.writeString(this.redirect_url);
        parcel.writeString(this.scope);
        parcel.writeString(this.package_name);
        parcel.writeString(this.hash);
    }

    public AuthInfo(Parcel parcel) {
        this.app_key = parcel.readString();
        this.redirect_url = parcel.readString();
        this.scope = parcel.readString();
        this.package_name = parcel.readString();
        this.hash = parcel.readString();
    }
}
