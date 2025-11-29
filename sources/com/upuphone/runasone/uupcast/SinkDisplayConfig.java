package com.upuphone.runasone.uupcast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.upuphone.starrynetsdk.ability.cast.CastConst;

public class SinkDisplayConfig implements Parcelable {
    public static final Parcelable.Creator<SinkDisplayConfig> CREATOR = new Parcelable.Creator<SinkDisplayConfig>() {
        public SinkDisplayConfig createFromParcel(Parcel parcel) {
            return new SinkDisplayConfig(parcel);
        }

        public SinkDisplayConfig[] newArray(int i) {
            return new SinkDisplayConfig[i];
        }
    };
    /* access modifiers changed from: private */
    public int mAlphaDirection;
    /* access modifiers changed from: private */
    public int mAlphaRatio;
    /* access modifiers changed from: private */
    public int mBiteRate;
    /* access modifiers changed from: private */
    public final int mCaptureType;
    private byte[] mData;
    /* access modifiers changed from: private */
    public final int mDensityDpi;
    /* access modifiers changed from: private */
    public final int mDisplayFlag;
    /* access modifiers changed from: private */
    public int mEnabledAudioTypeMask;
    /* access modifiers changed from: private */
    public final int mHeight;
    /* access modifiers changed from: private */
    public boolean mPreferSoftDecoder;
    /* access modifiers changed from: private */
    public final String mTagName;
    /* access modifiers changed from: private */
    public int mVideoFps;
    /* access modifiers changed from: private */
    public String mVideoMimeType;
    /* access modifiers changed from: private */
    public final int mWidth;
    /* access modifiers changed from: private */
    public int mZoomSize;

    public int describeContents() {
        return 0;
    }

    public int getAlphaDirection() {
        return this.mAlphaDirection;
    }

    public int getAlphaRatio() {
        return this.mAlphaRatio;
    }

    public int getBiteRate() {
        return this.mBiteRate;
    }

    public int getCaptureType() {
        return this.mCaptureType;
    }

    public byte[] getData() {
        return this.mData;
    }

    public int getDensityDpi() {
        return this.mDensityDpi;
    }

    public int getDisplayFlag() {
        return this.mDisplayFlag;
    }

    public int getEnabledAudioTypeMask() {
        return this.mEnabledAudioTypeMask;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean getPreferSoftDecoder() {
        return this.mPreferSoftDecoder;
    }

    public String getTag() {
        return this.mTagName;
    }

    public int getVideoFps() {
        return this.mVideoFps;
    }

    @Nullable
    public String getVideoMime() {
        return this.mVideoMimeType;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getZoomSize() {
        return this.mZoomSize;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCaptureType);
        parcel.writeInt(this.mDisplayFlag);
        parcel.writeInt(this.mDensityDpi);
        parcel.writeString(this.mTagName);
        parcel.writeInt(this.mWidth);
        parcel.writeInt(this.mHeight);
        byte[] bArr = this.mData;
        if (bArr == null || bArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(this.mData);
        }
        String str = this.mVideoMimeType;
        if (str == null) {
            str = "";
        }
        parcel.writeString(str);
        parcel.writeInt(this.mVideoFps);
        parcel.writeInt(this.mZoomSize);
        parcel.writeByte(this.mPreferSoftDecoder ? (byte) 1 : 0);
        parcel.writeInt(this.mAlphaDirection);
        parcel.writeInt(this.mAlphaRatio);
        parcel.writeInt(this.mBiteRate);
        parcel.writeInt(this.mEnabledAudioTypeMask);
    }

    private SinkDisplayConfig(int i, int i2, int i3, String str, int i4, int i5, byte[] bArr, String str2, int i6, int i7, boolean z, int i8, int i9, int i10, int i11) {
        this.mCaptureType = i;
        this.mDisplayFlag = i2;
        this.mDensityDpi = i3;
        this.mTagName = str;
        this.mWidth = i4;
        this.mHeight = i5;
        this.mData = bArr;
        this.mVideoMimeType = str2;
        this.mVideoFps = i6;
        this.mZoomSize = i7;
        this.mPreferSoftDecoder = z;
        this.mAlphaDirection = i8;
        this.mAlphaRatio = i9;
        this.mBiteRate = i10;
        this.mEnabledAudioTypeMask = i11;
    }

    public static class Builder {
        private int mAlphaDirection;
        private int mAlphaRatio;
        private int mBiteRate = 3;
        private int mCaptureType;
        private byte[] mData;
        private int mDensityDpi;
        private int mDisplayFlag;
        private int mEnabledAudioTypeMask = 35;
        private int mHeight;
        private boolean mPreferSoftDecoder;
        private String mTagName = CastConst.DEFAULT_TAG;
        private int mVideoFps;
        private String mVideoMimeType;
        private int mWidth;
        private int mZoomSize;

        public Builder() {
        }

        public SinkDisplayConfig build() {
            return new SinkDisplayConfig(this.mCaptureType, this.mDisplayFlag, this.mDensityDpi, this.mTagName, this.mWidth, this.mHeight, this.mData, this.mVideoMimeType, this.mVideoFps, this.mZoomSize, this.mPreferSoftDecoder, this.mAlphaDirection, this.mAlphaRatio, this.mBiteRate, this.mEnabledAudioTypeMask);
        }

        public Builder enableAudioTypes(int i) {
            int i2 = i & 35;
            if (i2 != 0) {
                this.mEnabledAudioTypeMask = i2;
                return this;
            }
            throw new IllegalArgumentException("invalid audio type mask " + i);
        }

        public Builder setAlphaDirection(int i) {
            this.mAlphaDirection = i;
            return this;
        }

        public Builder setAlphaRatio(int i) {
            this.mAlphaRatio = i;
            return this;
        }

        public Builder setBiteRate(@BitRateType int i) {
            this.mBiteRate = i;
            return this;
        }

        public Builder setCaptureType(int i) {
            this.mCaptureType = i;
            return this;
        }

        public Builder setData(byte[] bArr) {
            this.mData = bArr;
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

        public Builder setHeight(int i) {
            this.mHeight = i;
            return this;
        }

        public Builder setPreferSoftDecoder(boolean z) {
            this.mPreferSoftDecoder = z;
            return this;
        }

        public Builder setTag(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.mTagName = str;
                return this;
            }
            throw new NullPointerException("tag is null or empty");
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

        public Builder setWidth(int i) {
            this.mWidth = i;
            return this;
        }

        public Builder setZoomSize(int i) {
            if (i < 0) {
                i = 0;
            }
            this.mZoomSize = i;
            return this;
        }

        public Builder(SinkDisplayConfig sinkDisplayConfig) {
            if (sinkDisplayConfig != null) {
                this.mCaptureType = sinkDisplayConfig.mCaptureType;
                this.mDisplayFlag = sinkDisplayConfig.mDisplayFlag;
                this.mDensityDpi = sinkDisplayConfig.mDensityDpi;
                this.mTagName = sinkDisplayConfig.mTagName;
                this.mWidth = sinkDisplayConfig.mWidth;
                this.mHeight = sinkDisplayConfig.mHeight;
                this.mData = sinkDisplayConfig.getData();
                this.mVideoMimeType = sinkDisplayConfig.mVideoMimeType;
                this.mVideoFps = sinkDisplayConfig.mVideoFps;
                this.mZoomSize = sinkDisplayConfig.mZoomSize;
                this.mPreferSoftDecoder = sinkDisplayConfig.mPreferSoftDecoder;
                this.mAlphaDirection = sinkDisplayConfig.mAlphaDirection;
                this.mAlphaRatio = sinkDisplayConfig.mAlphaRatio;
                this.mBiteRate = sinkDisplayConfig.mBiteRate;
                this.mEnabledAudioTypeMask = sinkDisplayConfig.mEnabledAudioTypeMask;
            }
        }
    }

    public SinkDisplayConfig(Parcel parcel) {
        this.mCaptureType = parcel.readInt();
        this.mDisplayFlag = parcel.readInt();
        this.mDensityDpi = parcel.readInt();
        this.mTagName = parcel.readString();
        this.mWidth = parcel.readInt();
        this.mHeight = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            byte[] bArr = new byte[readInt];
            this.mData = bArr;
            parcel.readByteArray(bArr);
        }
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
            if (parcel.dataAvail() > 0) {
                this.mAlphaDirection = parcel.readInt();
            }
            if (parcel.dataAvail() > 0) {
                this.mAlphaRatio = parcel.readInt();
            }
            if (parcel.dataAvail() > 0) {
                this.mBiteRate = parcel.readInt();
            }
            if (parcel.dataAvail() > 0) {
                this.mEnabledAudioTypeMask = parcel.readInt();
            }
        }
    }
}
