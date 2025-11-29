package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;

public class WebpageObject extends MediaObject {
    public static final Parcelable.Creator<WebpageObject> CREATOR = new Parcelable.Creator<WebpageObject>() {
        /* renamed from: a */
        public WebpageObject createFromParcel(Parcel parcel) {
            return new WebpageObject(parcel);
        }

        /* renamed from: b */
        public WebpageObject[] newArray(int i) {
            return new WebpageObject[i];
        }
    };
    private static final long serialVersionUID = 7142128794153927442L;
    public String defaultText;

    public WebpageObject() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public WebpageObject(Parcel parcel) {
        super(parcel);
    }
}
