package com.upuphone.runasone.uupcast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;

public class SourceDisplayConfig implements Parcelable {
    public static final Parcelable.Creator<SourceDisplayConfig> CREATOR = new Parcelable.Creator<SourceDisplayConfig>() {
        public SourceDisplayConfig createFromParcel(Parcel parcel) {
            return new SourceDisplayConfig(parcel);
        }

        public SourceDisplayConfig[] newArray(int i) {
            return new SourceDisplayConfig[i];
        }
    };
    /* access modifiers changed from: private */
    public final int mCaptureType;
    /* access modifiers changed from: private */
    public final int mDensityDpi;
    /* access modifiers changed from: private */
    public final int mDisplayFlag;
    /* access modifiers changed from: private */
    public byte[] mExtraData;
    /* access modifiers changed from: private */
    public boolean mPreferSoftDecoder;
    /* access modifiers changed from: private */
    public int mVideoFps;
    /* access modifiers changed from: private */
    public String mVideoMimeType;
    /* access modifiers changed from: private */
    public int mZoomSize;

    public static class Builder {
        private int mCaptureType;
        private int mDensityDpi;
        private int mDisplayFlag;
        private byte[] mExtraData;
        private boolean mPreferSoftDecoder;
        private int mVideoFps;
        private String mVideoMimeType;
        private int mZoomSize;

        public Builder() {
        }

        public SourceDisplayConfig build() {
            return new SourceDisplayConfig(this.mCaptureType, this.mDisplayFlag, this.mDensityDpi, this.mVideoMimeType, this.mVideoFps, this.mZoomSize, this.mPreferSoftDecoder, this.mExtraData);
        }

        public Builder setCaptureType(int i) {
            this.mCaptureType = i;
            return this;
        }

        public Builder setDensityDpi(int i) {
            this.mDensityDpi = i;
            return this;
        }

        public Builder setDisplayFlag(int i) {
            this.mDisplayFlag = i;
            return this;
        }

        public Builder setExtraData(byte[] bArr) {
            if (!(bArr == null || bArr.length == 0)) {
                this.mExtraData = bArr;
            }
            return this;
        }

        public Builder setPreferSoftDecoder(boolean z) {
            this.mPreferSoftDecoder = z;
            return this;
        }

        public Builder setVideoFps(int i) {
            if (i < 0 || i > 60) {
                i = 0;
            }
            this.mVideoFps = i;
            return this;
        }

        public Builder setVideoMime(String str) {
            this.mVideoMimeType = str;
            return this;
        }

        public Builder setZoomSize(int i) {
            if (i < 0) {
                i = 0;
            }
            this.mZoomSize = i;
            return this;
        }

        public Builder(SourceDisplayConfig sourceDisplayConfig) {
            if (sourceDisplayConfig != null) {
                this.mCaptureType = sourceDisplayConfig.mCaptureType;
                this.mDisplayFlag = sourceDisplayConfig.mDisplayFlag;
                this.mDensityDpi = sourceDisplayConfig.mDensityDpi;
                this.mVideoMimeType = sourceDisplayConfig.mVideoMimeType;
                this.mVideoFps = sourceDisplayConfig.mVideoFps;
                this.mZoomSize = sourceDisplayConfig.mZoomSize;
                this.mPreferSoftDecoder = sourceDisplayConfig.mPreferSoftDecoder;
                this.mExtraData = sourceDisplayConfig.mExtraData;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getCaptureType() {
        return this.mCaptureType;
    }

    public int getDensityDpi() {
        return this.mDensityDpi;
    }

    public int getDisplayFlag() {
        return this.mDisplayFlag;
    }

    @Nullable
    public byte[] getExtraData() {
        return this.mExtraData;
    }

    public boolean getPreferSoftDecoder() {
        return this.mPreferSoftDecoder;
    }

    public int getVideoFps() {
        return this.mVideoFps;
    }

    @Nullable
    public String getVideoMime() {
        return this.mVideoMimeType;
    }

    public int getZoomSize() {
        return this.mZoomSize;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCaptureType);
        parcel.writeInt(this.mDisplayFlag);
        parcel.writeInt(this.mDensityDpi);
        String str = this.mVideoMimeType;
        if (str == null) {
            str = "";
        }
        parcel.writeString(str);
        parcel.writeInt(this.mVideoFps);
        parcel.writeInt(this.mZoomSize);
        parcel.writeByte(this.mPreferSoftDecoder ? (byte) 1 : 0);
        byte[] bArr = this.mExtraData;
        int length = bArr == null ? 0 : bArr.length;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(this.mExtraData);
        }
    }

    private SourceDisplayConfig(int i, int i2, int i3, String str, int i4, int i5, boolean z, byte[] bArr) {
        this.mCaptureType = i;
        this.mDisplayFlag = i2;
        this.mDensityDpi = i3;
        this.mVideoMimeType = str;
        this.mVideoFps = i4;
        this.mZoomSize = i5;
        this.mPreferSoftDecoder = z;
        this.mExtraData = bArr;
    }

    public SourceDisplayConfig(Parcel parcel) {
        int readInt;
        this.mCaptureType = parcel.readInt();
        this.mDisplayFlag = parcel.readInt();
        this.mDensityDpi = parcel.readInt();
        if (parcel.dataAvail() > 0) {
            String readString = parcel.readString();
            this.mVideoMimeType = readString;
            if (TextUtils.isEmpty(readString)) {
                this.mVideoMimeType = null;
            }
            this.mVideoFps = parcel.readInt();
            if (parcel.dataAvail() > 0) {
                this.mZoomSize = parcel.readInt();
            }
            if (parcel.dataAvail() > 0) {
                this.mPreferSoftDecoder = parcel.readByte() != 0;
            }
        }
        if (parcel.dataAvail() > 0 && (readInt = parcel.readInt()) > 0) {
            byte[] bArr = new byte[readInt];
            this.mExtraData = bArr;
            parcel.readByteArray(bArr);
        }
    }
}
