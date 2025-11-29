package com.upuphone.starrynet.strategy.message.payload.handler;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.api.message.IMessageResponseListener;
import com.upuphone.starrynet.api.message.IReceivePayloadMessageListener;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.ble.client.response.BleReadResponse;
import com.upuphone.starrynet.core.ble.client.response.BleWriteNoRespResponse;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.DisconnectRingEvent;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.core.ble.event.ExternalClientConnectionChangeEvent;
import com.upuphone.starrynet.core.ble.event.RingBackgroundStateChangeEvent;
import com.upuphone.starrynet.payload.MessageUtil;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.starrynet.payload.PayloadProtocolMessage;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.message.payload.PayloadMessage;
import com.upuphone.starrynet.strategy.message.payload.handler.RingDataUtil;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class RingProtocolHandler implements IProtocolHandler, EventReceiver {
    private static final int OTA_STATE_FRAME_DATA = 2;
    private static final int OTA_STATE_NONE = 0;
    private static final int OTA_STATE_QUERY_SS = 3;
    private static final int OTA_STATE_RESET = 1;
    private static final String TAG = "RingProtocolHandler";
    private String identifier;
    /* access modifiers changed from: private */
    public Map<InnerTag, Consumer<byte[]>> innerMessageListeners = new HashMap();
    private RingDataUtil.RingSystemState lastSystemState = null;
    private String mBleMac;
    private int mFrameSize = 0;
    private byte[] mOtaBuffer;
    /* access modifiers changed from: private */
    public int mOtaState = 0;
    private int otaBinCrc32 = -1;
    private int otaBinSize = -1;
    private int otaOffset = 0;
    private IReceivePayloadMessageListener receiveMessageListener;

    public static class InnerTag {
        private String bleMac;
        private byte opCode;

        public InnerTag(String str, byte b) {
            this.bleMac = str;
            this.opCode = b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InnerTag)) {
                return false;
            }
            InnerTag innerTag = (InnerTag) obj;
            if (this.opCode != innerTag.opCode) {
                return false;
            }
            return this.bleMac.equals(innerTag.bleMac);
        }

        public int hashCode() {
            return (this.bleMac.hashCode() * 31) + this.opCode;
        }
    }

    public RingProtocolHandler() {
        BleEventBus.get().register(ExternalClientConnectionChangeEvent.class, this);
    }

    private StConnectDevice checkIfRingDevice(String str) {
        StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(str);
        if (connectDeviceByBleMac == null || connectDeviceByBleMac.getTerminalType() != 5) {
            return null;
        }
        return connectDeviceByBleMac;
    }

    private void invokeDisconnect(String str) {
        StLog.d(TAG, "invokeDisconnect bleMac=" + str);
        BleEventBus.get().post(new RingBackgroundStateChangeEvent(6, str));
        BleEventBus.get().post(new DisconnectRingEvent(str));
    }

    /* access modifiers changed from: private */
    public void log(String str, Object... objArr) {
        StLog.d(TAG, str, objArr);
    }

    private void logWarning(String str, Object... objArr) {
        StLog.w(TAG, str, objArr);
    }

    private void notifyAlgoState(int i) {
        onReceiveMessage(MessageUtil.buildProtocolMessage2Bytes(1, 22, "state", Integer.valueOf(i)));
    }

    private void notifyBatteryInfo(int i, String str, int i2) {
        onReceiveMessage(MessageUtil.buildProtocolMessage2Bytes(1, 2, PayloadConstant.PARAMS_KEY_INT_BATTERY, Integer.valueOf(i), "device_id", str, PayloadConstant.PARAMS_KEY_INT_HARD_VERSION, Integer.valueOf(i2)));
    }

    private void notifyFirmwareVersion(String str, int i, String str2) {
        onReceiveMessage(MessageUtil.buildProtocolMessage2Bytes(1, 14, PayloadConstant.PARAMS_KEY_STR_FW_VERSION, str, PayloadConstant.PARAMS_KEY_INT_HARD_VERSION, Integer.valueOf(i), PayloadConstant.PARAMS_KEY_STR_SN, str2));
    }

    private void notifyOtaState(int i, int i2) {
        onReceiveMessage(MessageUtil.buildProtocolMessage2Bytes(1, 4, PayloadConstant.PARAMS_KEY_INT_OTA_STATE, Integer.valueOf(i), PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS, Integer.valueOf(i2)));
    }

    /* access modifiers changed from: private */
    public void notifyRingModel(String str) {
        onReceiveMessage(MessageUtil.buildProtocolMessage2Bytes(1, 23, "model", str));
    }

    private void notifyRingName(String str) {
        onReceiveMessage(MessageUtil.buildProtocolMessage2Bytes(1, 20, "name", str));
    }

    private void readDeviceModel(String str) {
        log("start read device model, bleMac =" + str, new Object[0]);
        BleConnectManager.getInstance().read(str, BluetoothConstants.DEVICE_INFORMATION_SERVICE, BluetoothConstants.MODEL_NUMBER_CHARACTER, new BleReadResponse() {
            public void onResponse(int i, byte[] bArr) {
                if (i != 0 || bArr == null || bArr.length <= 0) {
                    RingProtocolHandler.this.log("readDeviceModel onResponse ,code =%d, or data is empty!", Integer.valueOf(i));
                    return;
                }
                String str = new String(bArr);
                RingProtocolHandler.this.log("readDeviceModel onResponse ,code =%d, detail =%s,data=%s", Integer.valueOf(i), ByteUtils.byteToString(bArr), str);
                RingProtocolHandler.this.notifyRingModel(str);
            }
        });
    }

    private void releaseOtaState() {
        log("releaseOtaState", new Object[0]);
        this.mOtaState = 0;
        this.otaOffset = 0;
        this.otaBinCrc32 = -1;
        this.otaBinSize = -1;
    }

    private void startOta(String str, JSONObject jSONObject, IMessageResponseListener iMessageResponseListener) {
        String optString = jSONObject.optString(PayloadConstant.PARAMS_KEY_STR_OTA_FILE_URL, (String) null);
        if (TextUtils.isEmpty(optString)) {
            callbackError(iMessageResponseListener, StErrorCode.PAYLOAD_MESSAGE_INVALID_PARAMS, "cannot find \"file_url\" value in start ota json.");
            return;
        }
        try {
            byte[] bytesByFileDescriptor = RingDataUtil.getBytesByFileDescriptor(StarryNetData.getInstance().getApplication().getContentResolver().openFileDescriptor(Uri.parse(optString), "r").getFileDescriptor());
            this.mOtaBuffer = bytesByFileDescriptor;
            if (bytesByFileDescriptor == null) {
                callbackError(iMessageResponseListener, StErrorCode.PAYLOAD_MESSAGE_OTA_IO_EXCEPTION, "file exist,but convert to byte[] return null");
                return;
            }
            this.mBleMac = str;
            StLog.d(TAG, "start ota, send enable DFU command, file url=%s", optString);
            byte[] bArr = this.mOtaBuffer;
            this.otaBinSize = bArr.length;
            this.otaBinCrc32 = RingDataUtil.crc32(bArr);
            writeData(str, RingDataUtil.enableDfu(), iMessageResponseListener);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            callbackError(iMessageResponseListener, StErrorCode.PAYLOAD_MESSAGE_OTA_FILE_NOT_EXIST, "file:" + optString + " not exist!");
        }
    }

    private void startSendFrameData() {
        int i = this.mFrameSize - 7;
        int i2 = this.otaOffset;
        int i3 = i2 + i;
        byte[] bArr = this.mOtaBuffer;
        if (i3 > bArr.length) {
            i = bArr.length - i2;
        }
        byte[] bArr2 = new byte[i];
        int i4 = i2 + i;
        int i5 = 0;
        while (i2 < i4) {
            bArr2[i5] = this.mOtaBuffer[i2];
            i2++;
            i5++;
        }
        StLog.d(TAG, "startSendFrameData, otaOffset =%d, body size = %d", Integer.valueOf(this.otaOffset), Integer.valueOf(i));
        writeData(this.mBleMac, RingDataUtil.otaFrame(bArr2, this.otaOffset), (Consumer<Integer>) new Consumer<Integer>() {
            public void accept(Integer num) {
                StLog.d(RingProtocolHandler.TAG, "startSendFrameData write data, onResponse code =" + num);
                if (num.intValue() == 0) {
                    int unused = RingProtocolHandler.this.mOtaState = 2;
                } else {
                    StLog.w(RingProtocolHandler.TAG, "write ota frame data fail");
                }
            }
        });
    }

    private void writeData(String str, byte[] bArr, final IMessageResponseListener iMessageResponseListener) {
        writeData(str, bArr, (Consumer<Integer>) new Consumer<Integer>() {
            public void accept(Integer num) {
                if (num.intValue() == 0) {
                    RingProtocolHandler.this.callbackSuccess(iMessageResponseListener);
                } else {
                    RingProtocolHandler.this.callbackError(iMessageResponseListener, num.intValue(), "writeNoResp internal ble error!");
                }
            }
        });
    }

    public void callbackError(IMessageResponseListener iMessageResponseListener, int i, String str) {
        if (iMessageResponseListener != null) {
            iMessageResponseListener.onFail(i, str);
        }
    }

    public void callbackSuccess(IMessageResponseListener iMessageResponseListener) {
        if (iMessageResponseListener != null) {
            iMessageResponseListener.onSuccess();
        }
    }

    public UUID getCharacterUUID() {
        return PayloadConstant.STARRY_NET_PAYLOAD_RING_CHARACTER_UUID;
    }

    public int getDeviceType() {
        return 1;
    }

    public UUID getServiceUUID() {
        return PayloadConstant.STARRY_NET_PAYLOAD_RING_SERVICE_UUID;
    }

    public boolean handleCommonService(String str, UUID uuid, UUID uuid2, byte[] bArr) {
        if (bArr != null && bArr.length == 1) {
            byte b = bArr[0] & 255;
            StLog.d(TAG, "handleCommonService, data =" + b);
            if (this.lastSystemState == null) {
                RingDataUtil.RingSystemState ringSystemState = new RingDataUtil.RingSystemState();
                this.lastSystemState = ringSystemState;
                ringSystemState.hardwareVerNum = -1;
            }
            RingDataUtil.RingSystemState ringSystemState2 = this.lastSystemState;
            ringSystemState2.batteryLevel = b;
            notifyBatteryInfo(b, str, ringSystemState2.hardwareVerNum);
        }
        return true;
    }

    public void handleMessage(PayloadMessage payloadMessage) {
    }

    public void handleProtocolMessage(PayloadMessage payloadMessage, PayloadProtocolMessage payloadProtocolMessage) {
        this.identifier = payloadMessage.getBleMac();
        StDevice device = StarryDeviceManager.getInstance().getDevice(ByteUtils.fromHexString(payloadMessage.getBleMac()));
        if (device == null) {
            logWarning("handleProtocolMessage opcode = %d, stDevice is null !!!", Integer.valueOf(payloadProtocolMessage.getOpCode()));
            return;
        }
        log("handleProtocolMessage, opCode = " + payloadProtocolMessage.getOpCode(), new Object[0]);
        byte[] bArr = null;
        switch (payloadProtocolMessage.getOpCode()) {
            case 1:
                writeData(device.getBleMac(), RingDataUtil.syncTimeStamp(), payloadMessage.getInnerListener());
                return;
            case 3:
                startOta(device.getBleMac(), payloadProtocolMessage.getParams(), payloadMessage.getInnerListener());
                return;
            case 5:
                writeData(device.getBleMac(), RingDataUtil.querySysConfig(), payloadMessage.getInnerListener());
                return;
            case 7:
                JSONObject params = payloadProtocolMessage.getParams();
                if (params != null && params.has(PayloadConstant.PARAMS_KEY_INT_IMU_OPERATION)) {
                    int optInt = params.optInt(PayloadConstant.PARAMS_KEY_INT_IMU_OPERATION);
                    if (optInt == 1) {
                        bArr = RingDataUtil.openOrCloseImu(true);
                    } else if (optInt == 2) {
                        bArr = RingDataUtil.openOrCloseImu(false);
                    }
                    if (bArr != null) {
                        writeData(device.getBleMac(), bArr, payloadMessage.getInnerListener());
                        return;
                    }
                    return;
                }
                return;
            case 11:
                invokeDisconnect(device.getBleMac());
                return;
            case 13:
                writeData(device.getBleMac(), RingDataUtil.queryFwVersion(), payloadMessage.getInnerListener());
                return;
            case 15:
                JSONObject params2 = payloadProtocolMessage.getParams();
                if (params2 != null && params2.has(PayloadConstant.PARAMS_KEY_INT_IMU_OPERATION)) {
                    int optInt2 = params2.optInt(PayloadConstant.PARAMS_KEY_INT_IMU_OPERATION);
                    if (optInt2 == 1) {
                        bArr = RingDataUtil.controlWorkMode(1);
                    } else if (optInt2 == 2) {
                        bArr = RingDataUtil.controlWorkMode(0);
                    } else if (optInt2 == 3) {
                        bArr = RingDataUtil.controlWorkMode(2);
                    } else {
                        IMessageResponseListener innerListener = payloadMessage.getInnerListener();
                        callbackError(innerListener, -1, "unsupported mode for ring work mode:" + optInt2);
                    }
                    if (bArr != null) {
                        writeData(device.getBleMac(), bArr, payloadMessage.getInnerListener());
                        return;
                    }
                    return;
                }
                return;
            case 17:
                JSONObject params3 = payloadProtocolMessage.getParams();
                if (params3 == null || !params3.has("name")) {
                    StLog.w(TAG, "set ring name ,json params is invalid， detail:=" + params3);
                    return;
                }
                writeData(device.getBleMac(), RingDataUtil.setRingName(params3.optString("name")), payloadMessage.getInnerListener());
                return;
            case 19:
                writeData(device.getBleMac(), RingDataUtil.requestRingName(), payloadMessage.getInnerListener());
                return;
            case 21:
                writeData(device.getBleMac(), RingDataUtil.queryAlgoState(), payloadMessage.getInnerListener());
                return;
            case 23:
                readDeviceModel(device.getBleMac());
                return;
            default:
                StLog.w(TAG, "not support opcode, opcode =" + payloadProtocolMessage.getOpCode());
                callbackError(payloadMessage.getInnerListener(), StErrorCode.PAYLOAD_MESSAGE_NOT_SUPPORT_OPCODE, String.format("not support opcode=%d, may need to upgrade StarryNet version!", new Object[]{Integer.valueOf(payloadProtocolMessage.getOpCode())}));
                return;
        }
    }

    public boolean isSupportCommonService() {
        return true;
    }

    public void onEvent(Object obj) {
        if (obj instanceof ExternalClientConnectionChangeEvent) {
            ExternalClientConnectionChangeEvent externalClientConnectionChangeEvent = (ExternalClientConnectionChangeEvent) obj;
            String mac = externalClientConnectionChangeEvent.getMac();
            if (!externalClientConnectionChangeEvent.isConnected()) {
                Consumer remove = this.innerMessageListeners.remove(new InnerTag(mac, (byte) 38));
                if (remove != null) {
                    StLog.d(TAG, "remove bind ring not receive it's response, and receive it's disconnect event");
                    remove.accept((Object) null);
                }
                if (mac.equals(this.mBleMac)) {
                    releaseOtaState();
                    return;
                }
                String str = this.mBleMac;
                if (str == null) {
                    str = "null";
                }
                log("receive ExternalClientConnectionChangeEvent bleMac is %s, local bleMac is %s", mac, str);
            }
        }
    }

    public void onReceiveMessage(byte[] bArr) {
        Bundle buildReceiveData2Bundle = PayloadMessage.buildReceiveData2Bundle(this.identifier, getServiceUUID(), getCharacterUUID(), 1, bArr);
        IReceivePayloadMessageListener iReceivePayloadMessageListener = this.receiveMessageListener;
        if (iReceivePayloadMessageListener != null) {
            iReceivePayloadMessageListener.receivePlayloadMessage(buildReceiveData2Bundle);
        }
    }

    public void receiveData(String str, byte[] bArr) {
        int i = 0;
        if (bArr == null || bArr.length < 3) {
            if (bArr != null) {
                i = bArr.length;
            }
            logWarning("handle notify data, data invalid, it's length =%d", Integer.valueOf(i));
            return;
        }
        this.mBleMac = str;
        int crc16 = RingDataUtil.crc16(bArr);
        byte b = (byte) (crc16 & 255);
        byte b2 = (byte) ((crc16 >> 8) & 255);
        if (b == bArr[1] && b2 == bArr[2]) {
            byte b3 = bArr[0];
            StLog.d(TAG, "receiveData ,bleMac =%s, opCode=%s", str, Byte.valueOf(b3));
            if (b3 == 0) {
                RingDataUtil.RingSystemState dataConvert2SystemState = RingDataUtil.dataConvert2SystemState(bArr);
                StLog.d(TAG, "receive systemState:" + dataConvert2SystemState);
                int i2 = this.mOtaState;
                if (i2 == 0) {
                    notifyBatteryInfo(dataConvert2SystemState.batteryLevel, this.mBleMac, dataConvert2SystemState.hardwareVerNum);
                    this.lastSystemState = dataConvert2SystemState;
                } else if (i2 == 1) {
                    StLog.d(TAG, "after ota reset, start ota");
                    this.mOtaState = 2;
                    startSendFrameData();
                } else if (i2 == 3) {
                    this.mFrameSize = dataConvert2SystemState.bleMtu;
                    StLog.d(TAG, "localBinCrc32 is %d, ring crc32 is %d", Integer.valueOf(this.otaBinCrc32), Integer.valueOf(dataConvert2SystemState.otaBinCrc32));
                    int i3 = dataConvert2SystemState.otaBinCrc32;
                    int i4 = this.otaBinCrc32;
                    if (i3 == i4) {
                        this.otaOffset = dataConvert2SystemState.otaBinOffset;
                        StLog.d(TAG, "开始断点续传");
                        startSendFrameData();
                        return;
                    }
                    byte[] otaReset = RingDataUtil.otaReset(this.otaBinSize, i4);
                    this.otaOffset = 0;
                    notifyOtaState(1, 0);
                    writeData(this.mBleMac, otaReset, (Consumer<Integer>) new Consumer<Integer>() {
                        public void accept(Integer num) {
                            StLog.d(RingProtocolHandler.TAG, "resetOTA, response code =" + num);
                            if (num.intValue() == 0) {
                                int unused = RingProtocolHandler.this.mOtaState = 1;
                            } else {
                                StLog.w(RingProtocolHandler.TAG, "write reset ota fail");
                            }
                        }
                    });
                } else if (i2 == 2) {
                    int i5 = dataConvert2SystemState.otaBinOffset;
                    this.otaOffset = i5;
                    int i6 = dataConvert2SystemState.otaBinCrc32;
                    if (i6 == 0) {
                        StLog.d(TAG, "ota send file completed!");
                        notifyOtaState(3, 100);
                        releaseOtaState();
                    } else if (i6 == -1) {
                        StLog.d(TAG, "ota failure!");
                        notifyOtaState(4, 0);
                    } else {
                        int length = (i5 * 100) / this.mOtaBuffer.length;
                        StLog.d(TAG, " send ota frame, progress =" + length);
                        notifyOtaState(2, length);
                        startSendFrameData();
                    }
                }
            } else if (b3 == 3) {
                RingDataUtil.SysConfig dataConvert2SysConfig = RingDataUtil.dataConvert2SysConfig(bArr);
                StLog.d(TAG, "receive sys config :" + dataConvert2SysConfig);
                onReceiveMessage(dataConvert2SysConfig.toJsonBytes());
            } else if (b3 == 7) {
                StLog.d(TAG, "receive enable DFU response");
                if (1 == (bArr[3] & 255)) {
                    final int i7 = this.mOtaState;
                    this.mOtaState = 3;
                    writeData(this.mBleMac, RingDataUtil.queryOtaState(), (Consumer<Integer>) new Consumer<Integer>() {
                        public void accept(Integer num) {
                            StLog.d(RingProtocolHandler.TAG, "query ota state ,write response code =" + num);
                            if (num.intValue() != 0) {
                                int unused = RingProtocolHandler.this.mOtaState = i7;
                                StLog.w(RingProtocolHandler.TAG, "write query ota state fail");
                            }
                        }
                    });
                    return;
                }
                notifyOtaState(6, 0);
                releaseOtaState();
            } else if (b3 == 10) {
                StLog.d(TAG, "receive imuState %s, after parse:%s", ByteUtils.byteToString(bArr), new RingDataUtil.IMUState(bArr));
            } else if (b3 == 37) {
                RingDataUtil.FwVersion fwVersion = new RingDataUtil.FwVersion(bArr);
                StLog.d(TAG, "receive fwVersion :" + fwVersion);
                notifyFirmwareVersion(fwVersion.firmwareVersion, fwVersion.hardVersion, fwVersion.sn);
            } else if (b3 == 38) {
                Consumer remove = this.innerMessageListeners.remove(new InnerTag(str, (byte) 38));
                if (remove != null) {
                    remove.accept(bArr);
                }
            } else if (b3 == 40) {
                String responseRingName = RingDataUtil.responseRingName(bArr);
                if (!TextUtils.isEmpty(responseRingName)) {
                    notifyRingName(responseRingName);
                    StConnectDevice checkIfRingDevice = checkIfRingDevice(str);
                    if (checkIfRingDevice != null) {
                        checkIfRingDevice.setDeviceName(responseRingName);
                        StarryDeviceManager.getInstance().updateBondInfo(checkIfRingDevice);
                    }
                }
            } else if (b3 == 41) {
                byte b4 = bArr[3];
                byte b5 = bArr[4];
                StLog.d(TAG, "receive algo state ,opType=%d(0:get;1:set;2:report), state=%d(1:algo init success)", Integer.valueOf(b4), Integer.valueOf(b5));
                notifyAlgoState(b5);
            }
        } else {
            logWarning("handle notify data, crc16 not match!", new Object[0]);
        }
    }

    public void registerReceiveMessageListener(IReceivePayloadMessageListener iReceivePayloadMessageListener) {
        this.receiveMessageListener = iReceivePayloadMessageListener;
    }

    public void sendInternalMessage(final String str, final byte b, byte[] bArr, final Consumer<byte[]> consumer) {
        writeData(str, bArr, (Consumer<Integer>) new Consumer<Integer>() {
            public void accept(Integer num) {
                if (num.intValue() != 0) {
                    Consumer consumer = consumer;
                    if (consumer != null) {
                        consumer.accept((Object) null);
                    }
                } else if (consumer != null) {
                    RingProtocolHandler.this.innerMessageListeners.put(new InnerTag(str, b), consumer);
                }
            }
        });
    }

    private void writeData(String str, byte[] bArr, final Consumer<Integer> consumer) {
        BleConnectManager.getInstance().writeNoRsp(str, PayloadConstant.STARRY_NET_PAYLOAD_RING_SERVICE_UUID, PayloadConstant.STARRY_NET_PAYLOAD_RING_CHARACTER_UUID, bArr, new BleWriteNoRespResponse() {
            public void onResponse(int i, Void voidR) {
                Consumer consumer = consumer;
                if (consumer != null) {
                    consumer.accept(Integer.valueOf(i));
                }
            }
        });
    }
}
