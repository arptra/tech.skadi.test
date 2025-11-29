package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PlugInBean[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f9503a;
    public final String b;
    public final String c;

    public PlugInBean(String str, String str2, String str3) {
        this.f9503a = str;
        this.b = str2;
        this.c = str3;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f9503a + " plV:" + this.b + " plUUID:" + this.c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9503a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    public PlugInBean(Parcel parcel) {
        this.f9503a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }
}
