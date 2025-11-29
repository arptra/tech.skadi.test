package com.upuphone.starryiccoaproto.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class PhoneState implements Parcelable {
    public static final Parcelable.Creator<PhoneState> CREATOR = new Parcelable.Creator<PhoneState>() {
        /* renamed from: a */
        public PhoneState createFromParcel(Parcel parcel) {
            return new PhoneState(parcel);
        }

        /* renamed from: b */
        public PhoneState[] newArray(int i) {
            return new PhoneState[i];
        }
    };
    public static final int PHONE_CALL_IDLE = 1;
    public static final int PHONE_CALL_OFFHOOK = 3;
    public static final int PHONE_CALL_RINGING = 2;
    public int mCs;
    public boolean mIsScreenLocked = false;
    public boolean mIsVoiceAssistantActive = false;
    public boolean mIsWechatQqCall = false;

    public PhoneState(PhoneState phoneState) {
        this.mCs = phoneState.mCs;
        this.mIsScreenLocked = phoneState.mIsScreenLocked;
        this.mIsWechatQqCall = phoneState.mIsWechatQqCall;
        this.mIsVoiceAssistantActive = phoneState.mIsVoiceAssistantActive;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCs);
        parcel.writeByte(this.mIsScreenLocked ? (byte) 1 : 0);
        parcel.writeByte(this.mIsWechatQqCall ? (byte) 1 : 0);
        parcel.writeByte(this.mIsVoiceAssistantActive ? (byte) 1 : 0);
    }

    public PhoneState(int i) {
        this.mCs = i;
    }

    public PhoneState(Parcel parcel) {
        boolean z = false;
        this.mCs = parcel.readInt();
        this.mIsScreenLocked = parcel.readByte() != 0;
        this.mIsWechatQqCall = parcel.readByte() != 0;
        this.mIsVoiceAssistantActive = parcel.readByte() != 0 ? true : z;
    }
}
