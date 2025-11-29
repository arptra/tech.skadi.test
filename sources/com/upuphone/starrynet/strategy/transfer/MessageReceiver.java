package com.upuphone.starrynet.strategy.transfer;

import Starry.StarryLinkEncrypt;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.upuphone.starrynet.api.bean.StMessage;
import com.upuphone.starrynet.api.message.IReceiveMessageListener;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.listener.IReceiveBleDataListener;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryLinkProtocolDataParseHelper;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.util.HashMap;
import java.util.Map;

public class MessageReceiver implements IReceiveBleDataListener {
    private static final String ACTION_NO_MESSAGE_RECEIVER = "action.starry.net.no.msg.receiver";
    private static final String TAG = "MessageReceiver";
    private ArrayMap<String, DeviceTag> bleMac2DeviceTag = new ArrayMap<>();
    private Map<String, IReceiveMessageListener> mReceiveClientMessageListenerMap = new HashMap();

    public static class DeviceTag {
        /* access modifiers changed from: private */
        public String deviceId;
        /* access modifiers changed from: private */
        public byte[] identifier;

        public DeviceTag(String str, byte[] bArr) {
            this.deviceId = str;
            this.identifier = bArr;
        }

        public String getDeviceId() {
            return this.deviceId;
        }

        public byte[] getIdentifier() {
            return this.identifier;
        }
    }

    private byte[] parseV1Data(byte[] bArr) {
        StarryLinkEncrypt.LinkProtocol parseLinkProtocolData = StarryLinkProtocolDataParseHelper.parseLinkProtocolData(bArr);
        if (parseLinkProtocolData == null) {
            StLog.w(TAG, "parseLinkProtocolData fail, protocol is null!");
            return null;
        }
        StarryLinkEncrypt.COMMAND cmd = parseLinkProtocolData.getCmd();
        byte[] byteArray = parseLinkProtocolData.getData().toByteArray();
        if (cmd == StarryLinkEncrypt.COMMAND.EXTERNAL_MESSAGE_NORMAL) {
            return byteArray;
        }
        if (cmd == StarryLinkEncrypt.COMMAND.EXTERNAL_MESSAGE_ENCRYPT) {
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(BleUtil.dealDeviceId(parseLinkProtocolData.getDeviceId().toByteArray()));
            if (connectDevice == null) {
                StLog.e(TAG, "receiveMessage(encrypt),but get decrypt key pair is null!!!");
                return null;
            }
            byte[] decrypt = EncryptionUtil.decrypt(byteArray, connectDevice.getSecret(), connectDevice.getParam(), connectDevice.getEncrypt());
            if (decrypt != null) {
                return decrypt;
            }
            StLog.e(TAG, "receiveMessage(encrypt), decrypt it fail");
            return null;
        }
        StLog.e(TAG, "receiveMessage ,unexpect cmd");
        return null;
    }

    public void onReceivePacketMessage(StMessage stMessage) {
        if (this.mReceiveClientMessageListenerMap.size() > 0) {
            for (Map.Entry<String, IReceiveMessageListener> value : this.mReceiveClientMessageListenerMap.entrySet()) {
                IReceiveMessageListener iReceiveMessageListener = (IReceiveMessageListener) value.getValue();
                if (iReceiveMessageListener != null) {
                    iReceiveMessageListener.receiveMessage(stMessage);
                }
            }
            return;
        }
        StLog.e(TAG, "onReceivePacketMessage,but mReceiveClientMessageListenerMap size is 0");
    }

    public void receiveData(byte[] bArr) {
    }

    public void receiveStMessage(StMessage stMessage) {
        if (stMessage == null) {
            StLog.w(TAG, "receiveStMessage is null!");
        } else if (stMessage.getContent() == null || stMessage.getContent().length == 0) {
            StLog.w(TAG, "receiveStMessage content is empty!");
        } else {
            String bleMac = stMessage.getBleMac();
            DeviceTag deviceTag = (DeviceTag) this.bleMac2DeviceTag.get(bleMac);
            if (deviceTag == null) {
                StConnectDevice connectDeviceByBrEdrMac = stMessage.getTargetChannel() == 32 ? StarryDeviceManager.getInstance().getConnectDeviceByBrEdrMac(bleMac) : StarryDeviceManager.getInstance().getConnectDeviceByBleMac(bleMac);
                if (connectDeviceByBrEdrMac != null) {
                    DeviceTag deviceTag2 = new DeviceTag(connectDeviceByBrEdrMac.getIdentifier2String(), connectDeviceByBrEdrMac.getIdentifier());
                    this.bleMac2DeviceTag.put(bleMac, deviceTag2);
                    deviceTag = deviceTag2;
                } else {
                    StLog.w(TAG, "receiveStMessage ,cannot find ConnectDevice object by bleMac =" + bleMac);
                    return;
                }
            }
            stMessage.setDeviceId(deviceTag.deviceId);
            stMessage.setIdentifier(deviceTag.identifier);
            if (stMessage.getCharacterCategory() == 0) {
                byte[] parseV1Data = parseV1Data(stMessage.getContent());
                if (parseV1Data != null) {
                    stMessage.setContent(parseV1Data);
                } else {
                    return;
                }
            } else if (stMessage.getCharacterCategory() == 3) {
                stMessage.setCharacterCategory(0);
            }
            onReceivePacketMessage(stMessage);
        }
    }

    public void receiveTlvData(boolean z, byte[] bArr) {
    }

    public void receiveV2Data(boolean z, byte[] bArr) {
    }

    public void registerReceiveMessageListener(String str, IReceiveMessageListener iReceiveMessageListener) {
        if (TextUtils.isEmpty(str) || iReceiveMessageListener == null) {
            if (TextUtils.isEmpty(str)) {
                str = "null";
            }
            StLog.e(TAG, "registerReceiveMessageListener wrong use,,checked pkgName(%s) or IReceiveMessageListener is null(%s)", str, String.valueOf(iReceiveMessageListener == null));
            return;
        }
        this.mReceiveClientMessageListenerMap.put(str, iReceiveMessageListener);
    }

    public void unregisterReceiveMessageListener(String str) {
        StLog.d(TAG, "unregisterReceiveMessageListener pkgName =" + str);
        if (!TextUtils.isEmpty(str)) {
            this.mReceiveClientMessageListenerMap.remove(str);
        }
    }
}
