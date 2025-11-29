package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.m;
import java.io.Serializable;
import java.util.Arrays;

public class MediaObject implements Parcelable, Serializable {
    public static final Parcelable.Creator<MediaObject> CREATOR = new Parcelable.Creator<MediaObject>() {
        /* renamed from: a */
        public MediaObject createFromParcel(Parcel parcel) {
            return new MediaObject(parcel);
        }

        /* renamed from: b */
        public MediaObject[] newArray(int i) {
            return new MediaObject[i];
        }
    };
    private static final long serialVersionUID = -5562495969515901397L;
    public String actionUrl;
    public String description;
    public String identify;
    public String schema;
    public byte[] thumbData;
    public String title;

    public MediaObject() {
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediaObject{actionUrl='");
        StringBuilder a2 = m.a(m.a(m.a(m.a(m.a(sb, this.actionUrl, '\'', ", schema='"), this.schema, '\'', ", identify='"), this.identify, '\'', ", title='"), this.title, '\'', ", description='"), this.description, '\'', ", thumbData=");
        a2.append(Arrays.toString(this.thumbData));
        a2.append('}');
        return a2.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.schema);
        parcel.writeString(this.identify);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.thumbData);
    }

    public MediaObject(Parcel parcel) {
        this.actionUrl = parcel.readString();
        this.schema = parcel.readString();
        this.identify = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.thumbData = parcel.createByteArray();
    }
}
