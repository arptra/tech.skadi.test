package com.here.posclient.sensors;

import android.os.Parcel;
import android.os.Parcelable;
import com.here.posclient.ActivityType;

public class GeneralActivityResult extends ActivityResult implements Parcelable {
    public static final Parcelable.Creator<GeneralActivityResult> CREATOR = new Parcelable.Creator<GeneralActivityResult>() {
        public GeneralActivityResult createFromParcel(Parcel parcel) {
            return new GeneralActivityResult(parcel.readInt(), parcel.readInt(), parcel.readLong());
        }

        public GeneralActivityResult[] newArray(int i) {
            return new GeneralActivityResult[i];
        }
    };

    public GeneralActivityResult(ActivityType activityType, float f, long j) {
        super(activityType.value, clampConfidence(f), j);
    }

    private static int clampConfidence(float f) {
        double d = (double) f;
        if (d < 0.0d) {
            return 0;
        }
        if (d > 1.0d) {
            return 100;
        }
        return (int) (f * 100.0f);
    }

    public int describeContents() {
        return 0;
    }

    public int getTypeValue() {
        return getRawType();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getRawType());
        parcel.writeInt(getConfidence());
        parcel.writeLong(getElapsedRealtimeMillis());
    }

    public GeneralActivityResult(int i, int i2, long j) {
        super(i, i2, j);
    }
}
