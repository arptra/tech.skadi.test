package com.sina.weibo.sdk.web;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.io.Serializable;

public class WebData implements Parcelable, Serializable {
    public static final Parcelable.Creator<WebData> CREATOR = new a();
    private static final long serialVersionUID = -4038177938155795889L;

    /* renamed from: a  reason: collision with root package name */
    public AuthInfo f9999a;
    public int b;
    public String c;
    public String d;

    public class a implements Parcelable.Creator<WebData> {
        public final Object createFromParcel(Parcel parcel) {
            return new WebData(parcel);
        }

        public final Object[] newArray(int i) {
            return new WebData[i];
        }
    }

    public WebData(AuthInfo authInfo, int i, String str, String str2) {
        this.f9999a = authInfo;
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f9999a, i);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }

    public WebData(Parcel parcel) {
        this.f9999a = (AuthInfo) parcel.readParcelable(AuthInfo.class.getClassLoader());
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.d = parcel.readString();
    }
}
