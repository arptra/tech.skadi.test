package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.m;
import java.util.ArrayList;
import java.util.Arrays;

public class MultiImageObject extends MediaObject {
    public static final Parcelable.Creator<MultiImageObject> CREATOR = new Parcelable.Creator<MultiImageObject>() {
        /* renamed from: a */
        public MultiImageObject createFromParcel(Parcel parcel) {
            return new MultiImageObject(parcel);
        }

        /* renamed from: b */
        public MultiImageObject[] newArray(int i) {
            return new MultiImageObject[i];
        }
    };
    private static final long serialVersionUID = 4858450022450986236L;
    public ArrayList<Uri> imageList;

    public MultiImageObject() {
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<Uri> getImageList() {
        return this.imageList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiImageObject{imageList=");
        sb.append(this.imageList);
        sb.append(", actionUrl='");
        StringBuilder a2 = m.a(m.a(m.a(m.a(m.a(sb, this.actionUrl, '\'', ", schema='"), this.schema, '\'', ", identify='"), this.identify, '\'', ", title='"), this.title, '\'', ", description='"), this.description, '\'', ", thumbData=");
        a2.append(Arrays.toString(this.thumbData));
        a2.append('}');
        return a2.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.imageList);
    }

    public MultiImageObject(Parcel parcel) {
        super(parcel);
        this.imageList = parcel.createTypedArrayList(Uri.CREATOR);
    }
}
