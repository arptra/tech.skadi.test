package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.m;
import java.util.Arrays;

public class TextObject extends MediaObject {
    public static final Parcelable.Creator<TextObject> CREATOR = new Parcelable.Creator<TextObject>() {
        /* renamed from: a */
        public TextObject createFromParcel(Parcel parcel) {
            return new TextObject(parcel);
        }

        /* renamed from: b */
        public TextObject[] newArray(int i) {
            return new TextObject[i];
        }
    };
    private static final long serialVersionUID = -5610314414793811821L;
    public String text;

    public TextObject() {
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TextObject{text='");
        StringBuilder a2 = m.a(m.a(m.a(m.a(m.a(m.a(sb, this.text, '\'', ", actionUrl='"), this.actionUrl, '\'', ", schema='"), this.schema, '\'', ", identify='"), this.identify, '\'', ", title='"), this.title, '\'', ", description='"), this.description, '\'', ", thumbData=");
        a2.append(Arrays.toString(this.thumbData));
        a2.append('}');
        return a2.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
    }

    public TextObject(Parcel parcel) {
        this.text = parcel.readString();
    }
}
