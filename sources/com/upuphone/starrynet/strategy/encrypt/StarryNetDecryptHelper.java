package com.upuphone.starrynet.strategy.encrypt;

import Starry.StarryLinkEncrypt;
import com.google.protobuf.ByteString;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import com.upuphone.starrynet.strategy.utils.BleUtil;

public final class StarryNetDecryptHelper {
    private static final String TAG = "StarryNetServerHelper";
    private final StarryLinkEncrypt.COMMAND mCommand;
    private final ByteString mData;
    private final byte[] mIdentifier;

    private StarryNetDecryptHelper(ByteString byteString, StarryLinkEncrypt.COMMAND command, ByteString byteString2) {
        this.mIdentifier = BleUtil.dealDeviceId(byteString.toByteArray());
        this.mCommand = command;
        this.mData = byteString2;
    }

    public static byte[] decryptInfo(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2 == null) {
            return bArr;
        }
        return EncryptionUtil.decrypt(bArr, ByteUtils.subArray(bArr2, 0, bArr2.length - 16), ByteUtils.subArray(bArr2, bArr2.length - 16), i);
    }

    public static StarryNetDecryptHelper parse(byte[] bArr) {
        StarryLinkEncrypt.LinkProtocol parseLinkProtocolData;
        ByteString deviceId;
        if (bArr == null || (parseLinkProtocolData = StarryLinkProtocolDataParseHelper.parseLinkProtocolData(bArr)) == null || (deviceId = parseLinkProtocolData.getDeviceId()) == null) {
            return null;
        }
        return new StarryNetDecryptHelper(deviceId, parseLinkProtocolData.getCmd(), parseLinkProtocolData.getData());
    }

    public StarryLinkEncrypt.WifiApInfo getApInfo(byte[] bArr, int i) {
        return StarryLinkProtocolDataParseHelper.parseWifiApInfo(getData(bArr, i));
    }

    public StarryLinkEncrypt.COMMAND getCommand() {
        return this.mCommand;
    }

    public byte[] getData() {
        ByteString byteString = this.mData;
        if (byteString == null) {
            return new byte[0];
        }
        return byteString.toByteArray();
    }

    public StarryLinkEncrypt.WifiGcInfo getGcInfo(byte[] bArr, int i) {
        if (this.mCommand != StarryLinkEncrypt.COMMAND.CONNECT_GC) {
            return null;
        }
        return StarryLinkProtocolDataParseHelper.parseWifiGcInfoData(getData(bArr, i));
    }

    public StarryLinkEncrypt.WifiGoInfo getGoInfo(byte[] bArr, int i) {
        if (this.mCommand != StarryLinkEncrypt.COMMAND.CONNECT_GO) {
            return null;
        }
        return StarryLinkProtocolDataParseHelper.parseWifiGoInfoData(getData(bArr, i));
    }

    public StarryLinkEncrypt.IOSConnectBt getIOSConnectBt() {
        if (this.mCommand != StarryLinkEncrypt.COMMAND.IOS_CONNECT_BT) {
            return null;
        }
        return StarryLinkProtocolDataParseHelper.parseIOSConnectBt(this.mData);
    }

    public byte[] getIdentifier() {
        return this.mIdentifier;
    }

    public StarryLinkEncrypt.ReadSwitchInfo getReadInfo(byte[] bArr, int i) {
        byte[] data;
        if (this.mCommand != StarryLinkEncrypt.COMMAND.READ_SWITCH_INFO || (data = getData(bArr, i)) == null || data.length == 0) {
            return null;
        }
        return StarryLinkProtocolDataParseHelper.parseReadSwitchInfoData(data);
    }

    public StarryLinkEncrypt.ReadSwitchKey getReadKey() {
        if (this.mCommand != StarryLinkEncrypt.COMMAND.READ_SWITCH_KEY) {
            return null;
        }
        return StarryLinkProtocolDataParseHelper.parseReadSwitchKeyData(this.mData);
    }

    public StarryLinkEncrypt.WifiStaInfo getStaInfo(byte[] bArr, int i) {
        return StarryLinkProtocolDataParseHelper.parseWifiStaInfo(getData(bArr, i));
    }

    public StarryLinkEncrypt.WriteSwitchInfo getWriteInfo(byte[] bArr, int i) {
        byte[] data;
        if (this.mCommand != StarryLinkEncrypt.COMMAND.WRITE_SWITCH_INFO || (data = getData(bArr, i)) == null || data.length == 0) {
            return null;
        }
        return StarryLinkProtocolDataParseHelper.parseWriteSwitchInfoData(data);
    }

    public StarryLinkEncrypt.WriteSwitchKey getWriteKey() {
        if (this.mCommand != StarryLinkEncrypt.COMMAND.WRITE_SWITCH_KEY) {
            return null;
        }
        return StarryLinkProtocolDataParseHelper.parseWriteSwitchKeyData(this.mData);
    }

    public byte[] getData(byte[] bArr, int i) {
        byte[] data = getData();
        if (bArr == null) {
            return null;
        }
        return decryptInfo(data, bArr, i);
    }
}
