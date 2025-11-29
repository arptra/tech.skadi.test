package com.upuphone.starrynet.strategy.encrypt;

import Starry.StarryLinkEncrypt;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.upuphone.starrynet.common.StLog;

public class StarryLinkProtocolDataParseHelper {
    private static final String TAG = "StarryLinkProtocolDataParseHelper";

    private StarryLinkProtocolDataParseHelper() {
    }

    public static StarryLinkEncrypt.DeviceInfo parseDeviceInfo(byte[] bArr) {
        StLog.d(TAG, "parseDeviceInfo");
        try {
            return StarryLinkEncrypt.DeviceInfo.parseFrom(bArr);
        } catch (InvalidProtocolBufferException e) {
            StLog.w(TAG, "parseDeviceInfo", (Throwable) e);
            return null;
        }
    }

    public static StarryLinkEncrypt.IOSConnectBt parseIOSConnectBt(ByteString byteString) {
        StLog.d(TAG, "parseIOSConnectBt");
        try {
            return StarryLinkEncrypt.IOSConnectBt.parseFrom(byteString);
        } catch (InvalidProtocolBufferException e) {
            StLog.w(TAG, "parseIOSConnectBt", (Throwable) e);
            return null;
        }
    }

    public static StarryLinkEncrypt.LinkProtocol parseLinkProtocolData(byte[] bArr) {
        try {
            return StarryLinkEncrypt.LinkProtocol.parseFrom(bArr);
        } catch (InvalidProtocolBufferException e) {
            StLog.w(TAG, "parseLinkProtocolData", (Throwable) e);
            return null;
        }
    }

    public static StarryLinkEncrypt.ReadSwitchInfo parseReadSwitchInfoData(ByteString byteString) {
        StLog.d(TAG, "parseReadSwitchInfoData");
        try {
            return StarryLinkEncrypt.ReadSwitchInfo.parseFrom(byteString);
        } catch (InvalidProtocolBufferException e) {
            StLog.w(TAG, "parseReadSwitchInfoData", (Throwable) e);
            return null;
        }
    }

    public static StarryLinkEncrypt.ReadSwitchKey parseReadSwitchKeyData(ByteString byteString) {
        StLog.d(TAG, "parseReadSwitchKeyData");
        try {
            return StarryLinkEncrypt.ReadSwitchKey.parseFrom(byteString);
        } catch (InvalidProtocolBufferException e) {
            StLog.w(TAG, "parseReadSwitchKeyData", (Throwable) e);
            return null;
        }
    }

    public static StarryLinkEncrypt.WifiApInfo parseWifiApInfo(byte[] bArr) {
        StLog.d(TAG, "parseWifiApInfo");
        try {
            return StarryLinkEncrypt.WifiApInfo.parseFrom(bArr);
        } catch (InvalidProtocolBufferException e) {
            StLog.w(TAG, "parseWifiApInfo", (Throwable) e);
            return null;
        }
    }

    public static StarryLinkEncrypt.WifiGcInfo parseWifiGcInfoData(ByteString byteString) {
        StarryLinkEncrypt.WifiGcInfo wifiGcInfo;
        StLog.d(TAG, "parseWifiGcInfoData");
        try {
            wifiGcInfo = StarryLinkEncrypt.WifiGcInfo.parseFrom(byteString);
            try {
                StLog.d(TAG, "wifiGcInfo:" + wifiGcInfo.getMac());
            } catch (InvalidProtocolBufferException e) {
                e = e;
            }
        } catch (InvalidProtocolBufferException e2) {
            e = e2;
            wifiGcInfo = null;
            StLog.w(TAG, "parseWifiGcInfoData", (Throwable) e);
            return wifiGcInfo;
        }
        return wifiGcInfo;
    }

    public static StarryLinkEncrypt.WifiGoInfo parseWifiGoInfoData(ByteString byteString) {
        StarryLinkEncrypt.WifiGoInfo wifiGoInfo;
        StLog.d(TAG, "parseWifiGoInfoData");
        try {
            wifiGoInfo = StarryLinkEncrypt.WifiGoInfo.parseFrom(byteString);
            try {
                StLog.d(TAG, "wifiGoInfo:" + wifiGoInfo.getMac());
            } catch (InvalidProtocolBufferException e) {
                e = e;
            }
        } catch (InvalidProtocolBufferException e2) {
            e = e2;
            wifiGoInfo = null;
            StLog.w(TAG, "parseWifiGoInfoData", (Throwable) e);
            return wifiGoInfo;
        }
        return wifiGoInfo;
    }

    public static StarryLinkEncrypt.WifiStaInfo parseWifiStaInfo(byte[] bArr) {
        StLog.d(TAG, "parseWifiStaInfo");
        try {
            return StarryLinkEncrypt.WifiStaInfo.parseFrom(bArr);
        } catch (InvalidProtocolBufferException e) {
            StLog.w(TAG, "parseWifiStaInfo", (Throwable) e);
            return null;
        }
    }

    public static StarryLinkEncrypt.WriteSwitchInfo parseWriteSwitchInfoData(ByteString byteString) {
        StLog.d(TAG, "parseWriteSwitchInfoData");
        try {
            return StarryLinkEncrypt.WriteSwitchInfo.parseFrom(byteString);
        } catch (InvalidProtocolBufferException e) {
            StLog.w(TAG, "parseWriteSwitchInfoData", (Throwable) e);
            return null;
        }
    }

    public static StarryLinkEncrypt.WriteSwitchKey parseWriteSwitchKeyData(ByteString byteString) {
        StLog.d(TAG, "parseWriteSwitchKeyData");
        try {
            return StarryLinkEncrypt.WriteSwitchKey.parseFrom(byteString);
        } catch (InvalidProtocolBufferException e) {
            StLog.w(TAG, "parseWriteSwitchKeyData", (Throwable) e);
            return null;
        }
    }

    public static StarryLinkEncrypt.ReadSwitchInfo parseReadSwitchInfoData(byte[] bArr) {
        StLog.d(TAG, "parseReadSwitchInfoData");
        try {
            return StarryLinkEncrypt.ReadSwitchInfo.parseFrom(bArr);
        } catch (InvalidProtocolBufferException e) {
            StLog.w(TAG, "parseReadSwitchInfoData", (Throwable) e);
            return null;
        }
    }

    public static StarryLinkEncrypt.WriteSwitchInfo parseWriteSwitchInfoData(byte[] bArr) {
        StLog.d(TAG, "parseWriteSwitchInfoData");
        try {
            return StarryLinkEncrypt.WriteSwitchInfo.parseFrom(bArr);
        } catch (InvalidProtocolBufferException e) {
            StLog.w(TAG, "parseWriteSwitchInfoData", (Throwable) e);
            return null;
        }
    }

    public static StarryLinkEncrypt.WifiGcInfo parseWifiGcInfoData(byte[] bArr) {
        StarryLinkEncrypt.WifiGcInfo wifiGcInfo;
        StLog.d(TAG, "parseWifiGcInfoData");
        try {
            wifiGcInfo = StarryLinkEncrypt.WifiGcInfo.parseFrom(bArr);
            try {
                StLog.d(TAG, "wifiGcInfo:" + wifiGcInfo.getMac());
            } catch (InvalidProtocolBufferException e) {
                e = e;
            }
        } catch (InvalidProtocolBufferException e2) {
            e = e2;
            wifiGcInfo = null;
            StLog.w(TAG, "parseWifiGcInfoData", (Throwable) e);
            return wifiGcInfo;
        }
        return wifiGcInfo;
    }

    public static StarryLinkEncrypt.WifiGoInfo parseWifiGoInfoData(byte[] bArr) {
        StarryLinkEncrypt.WifiGoInfo wifiGoInfo;
        StLog.d(TAG, "parseWifiGoInfoData");
        try {
            wifiGoInfo = StarryLinkEncrypt.WifiGoInfo.parseFrom(bArr);
            try {
                StLog.d(TAG, "wifiGoInfo:" + wifiGoInfo.getMac());
            } catch (InvalidProtocolBufferException e) {
                e = e;
            }
        } catch (InvalidProtocolBufferException e2) {
            e = e2;
            wifiGoInfo = null;
            StLog.w(TAG, "parseWifiGoInfoData", (Throwable) e);
            return wifiGoInfo;
        }
        return wifiGoInfo;
    }
}
