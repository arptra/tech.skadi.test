package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.upuphone.starrynetsdk.ability.cast.CastConst;

public class StarryNetDisplayConfig implements Parcelable {
    public static final int CAPTURE_AUDIO_WITHOUT_ENCODE = 256;
    public static final int CAPTURE_OPEN_STATISTICS_MODE = 1073741824;
    public static final int CAPTURE_TYPE_AUDIO = 32;
    public static final int CAPTURE_TYPE_CAMERA = 8;
    public static final int CAPTURE_TYPE_CAMERA_VIDEO = 16;
    public static final int CAPTURE_TYPE_VIRTUAL_DISPLAY = 1;
    public static final int CAPTURE_TYPE_VIRTUAL_DISPLAY_FULL_RATE = 128;
    public static final int CAPTURE_TYPE_VIRTUAL_DISPLAY_SOURCE_SIZE = 64;
    public static final int CAPTURE_TYPE_VIRTUAL_DISPLAY_VIDEO = 4;
    public static final int CAPTURE_WITH_MULTI_VIDEO = 536870912;
    public static final Parcelable.Creator<StarryNetDisplayConfig> CREATOR = new Parcelable.Creator<StarryNetDisplayConfig>() {
        public StarryNetDisplayConfig createFromParcel(Parcel parcel) {
            return new StarryNetDisplayConfig(parcel);
        }

        public StarryNetDisplayConfig[] newArray(int i) {
            return new StarryNetDisplayConfig[i];
        }
    };
    private final int captureType;
    private final int densityDpi;
    private final String displayTag;
    private final int virtualFlag;

    public StarryNetDisplayConfig(int i, int i2, int i3, String str) {
        this.captureType = i;
        this.virtualFlag = i2;
        this.densityDpi = i3;
        this.displayTag = str;
    }

    public int describeContents() {
        return 0;
    }

    public int getCaptureType() {
        return this.captureType;
    }

    public int getDensityDpi() {
        return this.densityDpi;
    }

    public String getDisplayTag() {
        return this.displayTag;
    }

    public int getVirtualFlag() {
        return this.virtualFlag;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.captureType);
        parcel.writeInt(this.virtualFlag);
        parcel.writeInt(this.densityDpi);
        parcel.writeString(this.displayTag);
    }

    public StarryNetDisplayConfig(int i, int i2, int i3) {
        this(i, i2, i3, CastConst.DEFAULT_TAG);
    }

    public StarryNetDisplayConfig(Parcel parcel) {
        this.captureType = parcel.readInt();
        this.virtualFlag = parcel.readInt();
        this.densityDpi = parcel.readInt();
        this.displayTag = parcel.readString();
    }
}
