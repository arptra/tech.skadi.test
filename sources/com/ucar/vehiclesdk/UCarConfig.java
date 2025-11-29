package com.ucar.vehiclesdk;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.ucar.vehiclesdk.UCarCommon;
import java.security.InvalidParameterException;
import java.util.Arrays;

public class UCarConfig implements Parcelable {
    private static final int BR_MAC_SIZE = 6;
    private static final int CAR_CUSTOM_FIELD_SIZE = 2;
    public static final Parcelable.Creator<UCarConfig> CREATOR = new Parcelable.Creator<UCarConfig>() {
        /* renamed from: a */
        public UCarConfig createFromParcel(Parcel parcel) {
            return new UCarConfig(parcel);
        }

        /* renamed from: b */
        public UCarConfig[] newArray(int i) {
            return new UCarConfig[i];
        }
    };
    private static final int DEFAULT_ADVERTISING_RSSI_THRESHOLD = -60;
    private static final int DEFAULT_DPI = 320;
    private static final int DEFAULT_FPS = 30;
    private static final int MAX_5G_CHANNEL = 165;
    private static final int MAX_DPI = 640;
    private static final int MAX_FPS = 60;
    private static final int MAX_PASSWORD_BYTES = 63;
    private static final float MAX_SMALL_WINDOW_SUPPORT_RATIO = 0.625f;
    private static final int MAX_SSID_BYTES = 32;
    private static final int MIN_5G_CHANNEL = 36;
    private static final int MIN_ADVERTISING_RSSI_THRESHOLD = -80;
    private static final int MIN_DPI = 120;
    private static final int MIN_FPS = 15;
    private static final int MIN_PASSWORD_BYTES = 8;
    private static final float MIN_SMALL_WINDOW_SUPPORT_RATIO = 0.4375f;
    private static final int MIN_SSID_BYTES = 9;
    private static final String TAG = "UCarConfig";
    public static final int ZERO = 0;
    /* access modifiers changed from: private */
    public int[] mAllowed5gChannels;
    /* access modifiers changed from: private */
    public int mAudioLatency;
    /* access modifiers changed from: private */
    public int mBleRSSIThreshold;
    /* access modifiers changed from: private */
    public byte[] mCarBrMac;
    /* access modifiers changed from: private */
    public byte[] mCarCustomField;
    /* access modifiers changed from: private */
    public String mCcdFilePath;
    /* access modifiers changed from: private */
    public int mDpi;
    /* access modifiers changed from: private */
    public int mFps;
    /* access modifiers changed from: private */
    public boolean mIsApStaCoexist;
    private boolean mIsReconfigureWifi;
    /* access modifiers changed from: private */
    public boolean mIsSupportAvRawPacket;
    /* access modifiers changed from: private */
    public boolean mIsSupportBackKey;
    /* access modifiers changed from: private */
    public boolean mIsSupportCamera;
    /* access modifiers changed from: private */
    public boolean mIsSupportHevc;
    /* access modifiers changed from: private */
    public boolean mIsSupportHomeKey;
    /* access modifiers changed from: private */
    public boolean mIsSupportLowLatencyDecodingMode;
    /* access modifiers changed from: private */
    public boolean mIsSupportMic;
    /* access modifiers changed from: private */
    public boolean mIsSupportP2P;
    /* access modifiers changed from: private */
    public boolean mIsSupportPOINav;
    private boolean mIsSupportRealWifiAddress;
    /* access modifiers changed from: private */
    public boolean mIsSupportRotation;
    /* access modifiers changed from: private */
    public boolean mIsSupportSoftAP;
    /* access modifiers changed from: private */
    public boolean mIsSupportStereoRecord;
    private boolean mIsSupportVoiceWaken;
    /* access modifiers changed from: private */
    public boolean mIsUseCustomAudioRecord;
    /* access modifiers changed from: private */
    public String mPassword;
    /* access modifiers changed from: private */
    public int mRealDpi;
    /* access modifiers changed from: private */
    public int mScreenHeight;
    /* access modifiers changed from: private */
    public int mScreenWidth;
    /* access modifiers changed from: private */
    public int mSmallWindowDisplayHeight;
    /* access modifiers changed from: private */
    public int mSmallWindowDisplayWidth;
    /* access modifiers changed from: private */
    public String mSsid;
    /* access modifiers changed from: private */
    public UCarCommon.WorkMode mSupportWorkModes;
    /* access modifiers changed from: private */
    public int mVideoDisplayHeight;
    /* access modifiers changed from: private */
    public int mVideoDisplayWidth;

    public static class Builder {
        public boolean A;
        public boolean B;
        public boolean C;
        public boolean D;
        public boolean E;
        public boolean F;
        public int G;
        public int H;
        public int I;

        /* renamed from: a  reason: collision with root package name */
        public byte[] f5392a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public boolean i;
        public boolean j;
        public boolean k;
        public String l;
        public String m;
        public boolean n;
        public int[] o;
        public boolean p;
        public boolean q;
        public boolean r;
        public boolean s;
        public boolean t;
        public byte[] u;
        public boolean v;
        public String w;
        public boolean x;
        public UCarCommon.WorkMode y;
        public int z;
    }

    public int describeContents() {
        return 0;
    }

    public int[] getAllowed5gChannels() {
        return this.mAllowed5gChannels;
    }

    public int getAudioLatency() {
        return this.mAudioLatency;
    }

    public int getBleRSSIThreshold() {
        return this.mBleRSSIThreshold;
    }

    public byte[] getCarBrMac() {
        return this.mCarBrMac;
    }

    public byte[] getCarCustomField() {
        return this.mCarCustomField;
    }

    public String getCcdFilePath() {
        return this.mCcdFilePath;
    }

    public int getDpi() {
        return this.mDpi;
    }

    public int getFps() {
        return this.mFps;
    }

    public int getRealDpi() {
        return this.mRealDpi;
    }

    public int getScreenHeight() {
        return this.mScreenHeight;
    }

    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    public int getSmallWindowDisplayHeight() {
        return this.mSmallWindowDisplayHeight;
    }

    public int getSmallWindowDisplayWidth() {
        return this.mSmallWindowDisplayWidth;
    }

    public UCarCommon.WorkMode getSupportWorkModes() {
        return this.mSupportWorkModes;
    }

    public int getSupportWorkModesInt() {
        return this.mSupportWorkModes.k();
    }

    public int getVideoDisplayHeight() {
        return this.mVideoDisplayHeight;
    }

    public int getVideoDisplayWidth() {
        return this.mVideoDisplayWidth;
    }

    public String getWifiPassword() {
        return this.mPassword;
    }

    public String getWifiSsid() {
        return this.mSsid;
    }

    public boolean isApStaCoexist() {
        return this.mIsApStaCoexist;
    }

    public boolean isIsSupportPOINav() {
        return this.mIsSupportPOINav;
    }

    public boolean isReconfigureWifi() {
        return this.mIsReconfigureWifi;
    }

    public boolean isSupportAvRawPacket() {
        return this.mIsSupportAvRawPacket;
    }

    public boolean isSupportBackKey() {
        return this.mIsSupportBackKey;
    }

    public boolean isSupportCamera() {
        return this.mIsSupportCamera;
    }

    public boolean isSupportHevc() {
        return this.mIsSupportHevc;
    }

    public boolean isSupportHomeKey() {
        return this.mIsSupportHomeKey;
    }

    public boolean isSupportLowLatencyDecodingMode() {
        return this.mIsSupportLowLatencyDecodingMode;
    }

    public boolean isSupportMic() {
        return this.mIsSupportMic;
    }

    public boolean isSupportP2P() {
        return this.mIsSupportP2P;
    }

    public boolean isSupportRealWifiAddress() {
        return this.mIsSupportRealWifiAddress;
    }

    public boolean isSupportRotation() {
        return this.mIsSupportRotation;
    }

    public boolean isSupportSoftAP() {
        return this.mIsSupportSoftAP;
    }

    public boolean isSupportStereoRecord() {
        return this.mIsSupportStereoRecord;
    }

    public boolean isSupportVoiceWaken() {
        return this.mIsSupportVoiceWaken;
    }

    public boolean isUseCustomAudioRecord() {
        return this.mIsUseCustomAudioRecord;
    }

    public void readFromParcel(Parcel parcel) {
        parcel.readByteArray(this.mCarBrMac);
        this.mScreenWidth = parcel.readInt();
        this.mScreenHeight = parcel.readInt();
        this.mDpi = parcel.readInt();
        this.mRealDpi = parcel.readInt();
        this.mVideoDisplayWidth = parcel.readInt();
        this.mVideoDisplayHeight = parcel.readInt();
        this.mFps = parcel.readInt();
        boolean z = false;
        this.mIsSupportP2P = parcel.readInt() == 1;
        this.mIsSupportSoftAP = parcel.readInt() == 1;
        this.mIsApStaCoexist = parcel.readInt() == 1;
        this.mSsid = parcel.readString();
        this.mPassword = parcel.readString();
        this.mIsReconfigureWifi = parcel.readInt() == 1;
        parcel.readIntArray(this.mAllowed5gChannels);
        this.mIsSupportCamera = parcel.readInt() == 1;
        this.mIsSupportMic = parcel.readInt() == 1;
        this.mIsSupportLowLatencyDecodingMode = parcel.readInt() == 1;
        this.mIsSupportVoiceWaken = parcel.readInt() == 1;
        this.mIsSupportRealWifiAddress = parcel.readInt() == 1;
        parcel.readByteArray(this.mCarCustomField);
        this.mIsSupportStereoRecord = parcel.readInt() == 1;
        this.mCcdFilePath = parcel.readString();
        this.mIsSupportPOINav = parcel.readInt() == 1;
        this.mSupportWorkModes = UCarCommon.WorkMode.a(parcel.readInt());
        this.mBleRSSIThreshold = parcel.readInt();
        this.mIsSupportRotation = parcel.readInt() == 1;
        this.mIsSupportHomeKey = parcel.readInt() == 1;
        this.mIsSupportBackKey = parcel.readInt() == 1;
        this.mIsSupportHevc = parcel.readInt() == 1;
        this.mIsSupportAvRawPacket = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        }
        this.mIsUseCustomAudioRecord = z;
        this.mSmallWindowDisplayWidth = parcel.readInt();
        this.mSmallWindowDisplayHeight = parcel.readInt();
        this.mAudioLatency = parcel.readInt();
    }

    @NonNull
    public String toString() {
        return "CarID: " + Arrays.toString(this.mCarBrMac) + "\nScreen Width: " + this.mScreenWidth + "\nScreen Height: " + this.mScreenHeight + "\nDpi: " + this.mDpi + "\nRealDpi: " + this.mRealDpi + "\nVideo Display Width: " + this.mVideoDisplayWidth + "\nVideo Display Height: " + this.mVideoDisplayHeight + "\nFPS: " + this.mFps + "\nSupport P2P: " + this.mIsSupportP2P + "\nSupport SoftAP: " + this.mIsSupportSoftAP + "\nSupport Ap Sta Coexist: " + this.mIsApStaCoexist + "\nSupport Reconfigure WifiInfo: " + this.mIsReconfigureWifi + "\nSupport Camera: " + this.mIsSupportCamera + "\nSupport Mic: " + this.mIsSupportMic + "\nSupport Low Latency Decoding Mode: " + this.mIsSupportLowLatencyDecodingMode + "\nSupport Voice Waken: " + this.mIsSupportVoiceWaken + "\nSupport Real Wifi Address: " + this.mIsSupportRealWifiAddress + "\nAllowed 5g Channels: " + Arrays.toString(this.mAllowed5gChannels) + "\nCustom Field: " + Arrays.toString(this.mCarCustomField) + "\nSupport Stereo Record: " + this.mIsSupportStereoRecord + "\nCcd File Path: " + this.mCcdFilePath + "\nSupport POI Navigation: " + this.mIsSupportPOINav + "\nSupport Work Mode: " + this.mSupportWorkModes + "\nBluetooth Rssi Threshold: " + this.mBleRSSIThreshold + "\nSupport Rotation: " + this.mIsSupportRotation + "\nSupport Home Key: " + this.mIsSupportHomeKey + "\nSupport Back Key: " + this.mIsSupportBackKey + "\nSupport Hevc: " + this.mIsSupportHevc + "\nSupport AVRawPacket: " + this.mIsSupportAvRawPacket + "\nSupport Custom Audio Record: " + this.mIsUseCustomAudioRecord + "\nSmall Window Display Width: " + this.mSmallWindowDisplayWidth + "\nSmall Window Display Height: " + this.mSmallWindowDisplayHeight + "\naudio latency: " + this.mAudioLatency;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.mCarBrMac);
        parcel.writeInt(this.mScreenWidth);
        parcel.writeInt(this.mScreenHeight);
        parcel.writeInt(this.mDpi);
        parcel.writeInt(this.mRealDpi);
        parcel.writeInt(this.mVideoDisplayWidth);
        parcel.writeInt(this.mVideoDisplayHeight);
        parcel.writeInt(this.mFps);
        parcel.writeInt(this.mIsSupportP2P ? 1 : 0);
        parcel.writeInt(this.mIsSupportSoftAP ? 1 : 0);
        parcel.writeInt(this.mIsApStaCoexist ? 1 : 0);
        parcel.writeString(this.mSsid);
        parcel.writeString(this.mPassword);
        parcel.writeInt(this.mIsReconfigureWifi ? 1 : 0);
        parcel.writeIntArray(this.mAllowed5gChannels);
        parcel.writeInt(this.mIsSupportCamera ? 1 : 0);
        parcel.writeInt(this.mIsSupportMic ? 1 : 0);
        parcel.writeInt(this.mIsSupportLowLatencyDecodingMode ? 1 : 0);
        parcel.writeInt(this.mIsSupportVoiceWaken ? 1 : 0);
        parcel.writeInt(this.mIsSupportRealWifiAddress ? 1 : 0);
        parcel.writeByteArray(this.mCarCustomField);
        parcel.writeInt(this.mIsSupportStereoRecord ? 1 : 0);
        parcel.writeString(this.mCcdFilePath);
        parcel.writeInt(this.mIsSupportPOINav ? 1 : 0);
        parcel.writeInt(this.mSupportWorkModes.k());
        parcel.writeInt(this.mBleRSSIThreshold);
        parcel.writeInt(this.mIsSupportRotation ? 1 : 0);
        parcel.writeInt(this.mIsSupportHomeKey ? 1 : 0);
        parcel.writeInt(this.mIsSupportBackKey ? 1 : 0);
        parcel.writeInt(this.mIsSupportHevc ? 1 : 0);
        parcel.writeInt(this.mIsSupportAvRawPacket ? 1 : 0);
        parcel.writeInt(this.mIsUseCustomAudioRecord ? 1 : 0);
        parcel.writeInt(this.mSmallWindowDisplayWidth);
        parcel.writeInt(this.mSmallWindowDisplayHeight);
        parcel.writeInt(this.mAudioLatency);
    }

    private UCarConfig() {
        this.mCarBrMac = new byte[6];
        this.mAllowed5gChannels = new int[0];
        this.mCarCustomField = new byte[2];
        this.mIsSupportPOINav = false;
        this.mBleRSSIThreshold = DEFAULT_ADVERTISING_RSSI_THRESHOLD;
        this.mIsSupportRotation = false;
        this.mIsSupportHomeKey = false;
        this.mIsSupportBackKey = false;
        this.mIsSupportAvRawPacket = true;
        this.mSmallWindowDisplayWidth = 0;
        this.mSmallWindowDisplayHeight = 0;
        this.mAudioLatency = 0;
    }

    public UCarConfig(UCarConfig uCarConfig) {
        this.mCarBrMac = new byte[6];
        this.mAllowed5gChannels = new int[0];
        this.mCarCustomField = new byte[2];
        this.mIsSupportPOINav = false;
        this.mBleRSSIThreshold = DEFAULT_ADVERTISING_RSSI_THRESHOLD;
        this.mIsSupportRotation = false;
        this.mIsSupportHomeKey = false;
        this.mIsSupportBackKey = false;
        this.mIsSupportAvRawPacket = true;
        this.mSmallWindowDisplayWidth = 0;
        this.mSmallWindowDisplayHeight = 0;
        this.mAudioLatency = 0;
        byte[] bArr = uCarConfig.mCarBrMac;
        if (bArr != null) {
            this.mCarBrMac = Arrays.copyOf(bArr, 6);
        }
        this.mScreenWidth = uCarConfig.mScreenWidth;
        this.mScreenHeight = uCarConfig.mScreenHeight;
        this.mDpi = uCarConfig.mDpi;
        this.mRealDpi = uCarConfig.mRealDpi;
        this.mVideoDisplayWidth = uCarConfig.mVideoDisplayWidth;
        this.mVideoDisplayHeight = uCarConfig.mVideoDisplayHeight;
        this.mFps = uCarConfig.mFps;
        this.mIsSupportP2P = uCarConfig.mIsSupportP2P;
        this.mIsSupportSoftAP = uCarConfig.mIsSupportSoftAP;
        this.mIsApStaCoexist = uCarConfig.mIsApStaCoexist;
        this.mSsid = uCarConfig.mSsid;
        this.mPassword = uCarConfig.mPassword;
        this.mIsReconfigureWifi = uCarConfig.mIsReconfigureWifi;
        this.mAllowed5gChannels = uCarConfig.mAllowed5gChannels;
        this.mIsSupportCamera = uCarConfig.mIsSupportCamera;
        this.mIsSupportMic = uCarConfig.mIsSupportMic;
        this.mIsSupportLowLatencyDecodingMode = uCarConfig.mIsSupportLowLatencyDecodingMode;
        this.mIsSupportVoiceWaken = uCarConfig.mIsSupportVoiceWaken;
        this.mIsSupportRealWifiAddress = uCarConfig.mIsSupportRealWifiAddress;
        byte[] bArr2 = uCarConfig.mCarCustomField;
        if (bArr2 != null) {
            this.mCarCustomField = Arrays.copyOf(bArr2, 2);
        }
        this.mIsSupportStereoRecord = uCarConfig.mIsSupportStereoRecord;
        this.mCcdFilePath = uCarConfig.mCcdFilePath;
        this.mIsSupportPOINav = uCarConfig.mIsSupportPOINav;
        this.mSupportWorkModes = uCarConfig.mSupportWorkModes;
        this.mBleRSSIThreshold = uCarConfig.mBleRSSIThreshold;
        this.mIsSupportRotation = uCarConfig.mIsSupportRotation;
        this.mIsSupportHomeKey = uCarConfig.mIsSupportHomeKey;
        this.mIsSupportBackKey = uCarConfig.mIsSupportBackKey;
        this.mIsSupportHevc = uCarConfig.mIsSupportHevc;
        this.mIsSupportAvRawPacket = uCarConfig.mIsSupportAvRawPacket;
        this.mIsUseCustomAudioRecord = uCarConfig.mIsUseCustomAudioRecord;
        this.mSmallWindowDisplayWidth = uCarConfig.mSmallWindowDisplayWidth;
        this.mSmallWindowDisplayHeight = uCarConfig.mSmallWindowDisplayHeight;
        this.mAudioLatency = uCarConfig.mAudioLatency;
    }

    private UCarConfig(Parcel parcel) {
        this.mCarBrMac = new byte[6];
        this.mAllowed5gChannels = new int[0];
        this.mCarCustomField = new byte[2];
        this.mIsSupportPOINav = false;
        this.mBleRSSIThreshold = DEFAULT_ADVERTISING_RSSI_THRESHOLD;
        this.mIsSupportRotation = false;
        this.mIsSupportHomeKey = false;
        this.mIsSupportBackKey = false;
        this.mIsSupportAvRawPacket = true;
        this.mSmallWindowDisplayWidth = 0;
        this.mSmallWindowDisplayHeight = 0;
        this.mAudioLatency = 0;
        readFromParcel(parcel);
    }

    private UCarConfig(Builder builder) {
        this.mCarBrMac = new byte[6];
        this.mAllowed5gChannels = new int[0];
        this.mCarCustomField = new byte[2];
        this.mIsSupportPOINav = false;
        this.mBleRSSIThreshold = DEFAULT_ADVERTISING_RSSI_THRESHOLD;
        this.mIsSupportRotation = false;
        this.mIsSupportHomeKey = false;
        this.mIsSupportBackKey = false;
        this.mIsSupportAvRawPacket = true;
        this.mSmallWindowDisplayWidth = 0;
        this.mSmallWindowDisplayHeight = 0;
        this.mAudioLatency = 0;
        if (builder.f5392a != null) {
            this.mCarBrMac = Arrays.copyOf(builder.f5392a, builder.f5392a.length);
            this.mScreenWidth = builder.b;
            this.mScreenHeight = builder.c;
            this.mDpi = builder.d;
            this.mRealDpi = builder.e;
            this.mVideoDisplayWidth = builder.f;
            this.mVideoDisplayHeight = builder.g;
            this.mFps = builder.h;
            this.mIsSupportP2P = builder.i;
            this.mIsSupportSoftAP = builder.j;
            this.mIsApStaCoexist = builder.k;
            this.mSsid = builder.l;
            this.mPassword = builder.m;
            this.mIsReconfigureWifi = builder.n;
            this.mAllowed5gChannels = builder.o;
            this.mIsSupportCamera = builder.p;
            this.mIsSupportMic = builder.q;
            this.mIsSupportLowLatencyDecodingMode = builder.r;
            this.mIsSupportVoiceWaken = builder.s;
            this.mIsSupportRealWifiAddress = builder.t;
            if (builder.u != null) {
                this.mCarCustomField = Arrays.copyOf(builder.u, builder.u.length);
            }
            this.mIsSupportStereoRecord = builder.v;
            this.mCcdFilePath = builder.w;
            this.mIsSupportPOINav = builder.x;
            this.mSupportWorkModes = builder.y;
            this.mBleRSSIThreshold = builder.z;
            this.mIsSupportRotation = builder.A;
            this.mIsSupportHomeKey = builder.B;
            this.mIsSupportBackKey = builder.C;
            this.mIsSupportHevc = builder.D;
            this.mIsSupportAvRawPacket = builder.E;
            this.mIsUseCustomAudioRecord = builder.F;
            this.mSmallWindowDisplayWidth = builder.G;
            this.mSmallWindowDisplayHeight = builder.H;
            this.mAudioLatency = builder.I;
            return;
        }
        throw new InvalidParameterException("Car Br Mac is invalid");
    }
}
