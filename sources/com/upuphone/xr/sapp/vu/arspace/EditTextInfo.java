package com.upuphone.xr.sapp.vu.arspace;

import android.os.Parcel;
import android.os.Parcelable;

public class EditTextInfo implements Parcelable {
    public static final Parcelable.Creator<EditTextInfo> CREATOR = new Parcelable.Creator<EditTextInfo>() {
        /* renamed from: a */
        public EditTextInfo createFromParcel(Parcel parcel) {
            return new EditTextInfo(parcel);
        }

        /* renamed from: b */
        public EditTextInfo[] newArray(int i) {
            return new EditTextInfo[i];
        }
    };
    public static final int IME_ACTION_DONE = 6;
    public static final int IME_ACTION_GO = 2;
    public static final int IME_ACTION_NEXT = 5;
    public static final int IME_ACTION_NONE = 1;
    public static final int IME_ACTION_PREVIOUS = 7;
    public static final int IME_ACTION_SEARCH = 3;
    public static final int IME_ACTION_SEND = 4;
    public static final int IME_ACTION_UNSPECIFIED = 0;
    public String hint;
    public String id;
    public int imeAction;
    public int selectionEnd = -1;
    public int selectionStart = -1;
    public String text;

    public EditTextInfo() {
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.id = parcel.readString();
        this.hint = parcel.readString();
        this.text = parcel.readString();
        this.imeAction = parcel.readInt();
        this.selectionStart = parcel.readInt();
        this.selectionEnd = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.hint);
        parcel.writeString(this.text);
        parcel.writeInt(this.imeAction);
        parcel.writeInt(this.selectionStart);
        parcel.writeInt(this.selectionEnd);
    }

    public EditTextInfo(Parcel parcel) {
        this.id = parcel.readString();
        this.hint = parcel.readString();
        this.text = parcel.readString();
        this.imeAction = parcel.readInt();
        this.selectionStart = parcel.readInt();
        this.selectionEnd = parcel.readInt();
    }
}
