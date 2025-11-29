package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.upuphone.xr.interconnect.api.AIType;

public class AIModelResult implements Parcelable {
    public static final Parcelable.Creator<AIModelResult> CREATOR = new Parcelable.Creator<AIModelResult>() {
        public AIModelResult createFromParcel(Parcel parcel) {
            return new AIModelResult(parcel);
        }

        public AIModelResult[] newArray(int i) {
            return new AIModelResult[i];
        }
    };
    private boolean requestResult;
    @AIType
    private int state;

    public AIModelResult(boolean z, int i) {
        this.requestResult = z;
        this.state = i;
    }

    public int describeContents() {
        return 0;
    }

    public int getState() {
        return this.state;
    }

    public boolean isRequestResult() {
        return this.requestResult;
    }

    public void readFromParcel(Parcel parcel) {
        this.requestResult = parcel.readByte() != 0;
        this.state = parcel.readInt();
    }

    public String toString() {
        return "AIModelResult{requestResult=" + this.requestResult + ", state=" + this.state + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.requestResult ? (byte) 1 : 0);
        parcel.writeInt(this.state);
    }

    public AIModelResult(Parcel parcel) {
        this.requestResult = parcel.readByte() != 0;
        this.state = parcel.readInt();
    }
}
