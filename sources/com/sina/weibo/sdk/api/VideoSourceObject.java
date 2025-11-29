package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.m;
import java.util.Arrays;

public class VideoSourceObject extends MediaObject {
    public static final Parcelable.Creator<VideoSourceObject> CREATOR = new Parcelable.Creator<VideoSourceObject>() {
        /* renamed from: a */
        public VideoSourceObject createFromParcel(Parcel parcel) {
            return new VideoSourceObject(parcel);
        }

        /* renamed from: b */
        public VideoSourceObject[] newArray(int i) {
            return new VideoSourceObject[i];
        }
    };
    private static final long serialVersionUID = 2745594466460840583L;
    public Uri coverPath;
    public long during;
    public Uri videoPath;

    public VideoSourceObject() {
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoSourceObject{coverPath=");
        sb.append(this.coverPath);
        sb.append(", videoPath=");
        sb.append(this.videoPath);
        sb.append(", during=");
        sb.append(this.during);
        sb.append(", actionUrl='");
        StringBuilder a2 = m.a(m.a(m.a(m.a(m.a(sb, this.actionUrl, '\'', ", schema='"), this.schema, '\'', ", identify='"), this.identify, '\'', ", title='"), this.title, '\'', ", description='"), this.description, '\'', ", thumbData=");
        a2.append(Arrays.toString(this.thumbData));
        a2.append('}');
        return a2.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.coverPath, i);
        parcel.writeParcelable(this.videoPath, i);
        parcel.writeLong(this.during);
    }

    public VideoSourceObject(Parcel parcel) {
        super(parcel);
        Class<Uri> cls = Uri.class;
        this.coverPath = (Uri) parcel.readParcelable(cls.getClassLoader());
        this.videoPath = (Uri) parcel.readParcelable(cls.getClassLoader());
        this.during = parcel.readLong();
    }
}
