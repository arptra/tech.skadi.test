package com.upuphone.starrynet.strategy.message;

import android.text.TextUtils;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.api.bean.StMessage;
import com.upuphone.starrynet.api.message.IMessageResponseListener;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;

public class StarryMessage {
    public static final String KEY_BYTES = "bytes";
    public static final String KEY_IDENTIFIER = "identifier";
    public static final String KEY_SEND_AT_ONCE = "sendAtOnce";
    private static final String TAG = "StarryMessage";
    private byte[] content;
    private byte[] id;
    private String identifier;
    private boolean isInternalMessage;
    private boolean isNeedSendAtOnce;
    private boolean isSync;
    private boolean isUrgentMessage;
    private IMessageResponseListener listener;
    private ISendMessageListener mInnerMessageListener;
    private boolean needEncrypt;
    private int opCode;
    private int packetType;
    private String peerBleMac;
    private String peerBtMac;
    private int sizeStatus;
    private byte sppMsgType;
    private long startTime;
    private int terminalType;

    public StarryMessage(byte[] bArr, byte[] bArr2, int i, IMessageResponseListener iMessageResponseListener) {
        this.sizeStatus = -1;
        this.terminalType = -1;
        this.opCode = 3;
        this.sppMsgType = 0;
        this.needEncrypt = false;
        this.isSync = false;
        this.isUrgentMessage = false;
        this.isInternalMessage = false;
        this.mInnerMessageListener = null;
        this.content = bArr;
        this.id = bArr2;
        this.packetType = i;
        this.listener = iMessageResponseListener;
        this.identifier = Utils.bytesToHexString(bArr2);
        this.startTime = System.currentTimeMillis();
    }

    public static StarryMessage buildInnerBleClientMultipleMessage(StDevice stDevice, int i, int i2, byte[] bArr, ISendMessageListener iSendMessageListener) {
        StarryMessage starryMessage = new StarryMessage(i, i2, bArr, iSendMessageListener);
        starryMessage.terminalType = 0;
        starryMessage.sizeStatus = 1;
        starryMessage.id = stDevice.getIdentifier();
        starryMessage.peerBleMac = stDevice.getBleMac();
        starryMessage.identifier = Utils.bytesToHexString(starryMessage.id);
        return starryMessage;
    }

    public static StarryMessage buildInnerBleServerMultipleMessage(StDevice stDevice, int i, int i2, byte[] bArr, ISendMessageListener iSendMessageListener) {
        StarryMessage starryMessage = new StarryMessage(i, i2, bArr, iSendMessageListener);
        starryMessage.terminalType = 1;
        starryMessage.sizeStatus = 1;
        starryMessage.id = stDevice.getIdentifier();
        starryMessage.peerBleMac = stDevice.getBleMac();
        starryMessage.identifier = Utils.bytesToHexString(starryMessage.id);
        return starryMessage;
    }

    public byte[] getContent() {
        return this.content;
    }

    public byte[] getId() {
        return this.id;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public ISendMessageListener getInnerMessageListener() {
        return this.mInnerMessageListener;
    }

    public IMessageResponseListener getListener() {
        return this.listener;
    }

    public int getOpCode() {
        int i = this.opCode;
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 6;
        }
        if (i != 4) {
            return i != 5 ? 8 : 9;
        }
        return 2;
    }

    public int getPacketType() {
        return this.packetType;
    }

    public String getPeerBleMac() {
        return this.peerBleMac;
    }

    public String getPeerBtMac() {
        return this.peerBtMac;
    }

    public int getSizeStatus() {
        return this.sizeStatus;
    }

    public byte getSppMsgType() {
        return this.sppMsgType;
    }

    public int getTerminalType() {
        return this.terminalType;
    }

    public long getWaitTime() {
        return System.currentTimeMillis() - this.startTime;
    }

    public boolean isInternalMessage() {
        return this.isInternalMessage;
    }

    public boolean isLongMessage() {
        return this.sizeStatus == 1;
    }

    public boolean isMessageFromServer() {
        return this.terminalType == 1;
    }

    public boolean isNeedEncrypt() {
        return this.needEncrypt;
    }

    public boolean isNeedSendAtOnce() {
        return this.isNeedSendAtOnce;
    }

    public boolean isShortMessage() {
        return this.sizeStatus == 0;
    }

    public boolean isUrgentMessage() {
        return this.isUrgentMessage;
    }

    public void setContent(byte[] bArr) {
        this.content = bArr;
    }

    public void setId(byte[] bArr) {
        this.id = bArr;
    }

    public void setNeedEncrypt(boolean z) {
        this.needEncrypt = z;
    }

    public void setNeedSendAtOnce(boolean z) {
        this.isNeedSendAtOnce = z;
    }

    public void setOpCode(int i) {
        this.opCode = i;
    }

    public void setPeerBleMac(String str) {
        this.peerBleMac = str;
    }

    public void setSizeStatus(int i) {
        this.sizeStatus = i;
    }

    public void setSppMsgType(byte b) {
        this.sppMsgType = (byte) (b | this.sppMsgType);
    }

    public void setTerminalType(int i) {
        this.terminalType = i;
    }

    public StarryMessage(int i, int i2, byte[] bArr, ISendMessageListener iSendMessageListener) {
        this.sizeStatus = -1;
        this.terminalType = -1;
        this.sppMsgType = 0;
        this.needEncrypt = false;
        this.isSync = false;
        this.isUrgentMessage = false;
        this.isInternalMessage = false;
        this.content = bArr;
        this.opCode = i;
        this.packetType = i2;
        this.mInnerMessageListener = iSendMessageListener;
        this.startTime = System.currentTimeMillis();
        this.isInternalMessage = true;
    }

    public StarryMessage(StMessage stMessage) {
        this.sizeStatus = -1;
        this.terminalType = -1;
        this.opCode = 3;
        this.packetType = 0;
        this.sppMsgType = 0;
        this.needEncrypt = false;
        this.isSync = false;
        this.isUrgentMessage = false;
        this.isInternalMessage = false;
        this.mInnerMessageListener = null;
        this.content = stMessage.getContent();
        this.id = stMessage.getIdentifier();
        this.isSync = true;
        this.sizeStatus = 1;
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(this.id);
        if (!TextUtils.isEmpty(stMessage.getBleMac())) {
            this.peerBleMac = stMessage.getBleMac();
        } else if (connectDevice != null) {
            this.peerBleMac = connectDevice.getBleMac();
            stMessage.setBleMac(connectDevice.getBleMac());
        }
        if (stMessage.getTargetChannel() == 32 && connectDevice != null) {
            this.peerBtMac = connectDevice.getBrEdrMac();
        }
        this.identifier = Utils.bytesToHexString(this.id);
        this.startTime = System.currentTimeMillis();
        this.isUrgentMessage = stMessage.isUrgentMessage();
    }
}
