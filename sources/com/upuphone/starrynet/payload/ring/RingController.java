package com.upuphone.starrynet.payload.ring;

import com.upuphone.starrynet.payload.MessageUtil;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.starrynet.payload.PayloadProtocolMessage;
import com.upuphone.starrynet.payload.Plog;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import org.json.JSONException;
import org.json.JSONObject;

public class RingController {
    public static final int ERROR_OK = 0;
    public static final int ERROR_PARAM_LOST = 1;
    private static final String TAG = "RingController";
    private IRingOutputListener mOutputListener;

    public RingController(IRingOutputListener iRingOutputListener) {
        this.mOutputListener = iRingOutputListener;
    }

    private MessageContent buildMessageInfo(byte[] bArr) {
        MessageContent messageContent = new MessageContent();
        messageContent.setMsgType(1);
        messageContent.setData(bArr);
        return messageContent;
    }

    private void dealRingAlgoState(PayloadProtocolMessage payloadProtocolMessage) {
        JSONObject params = payloadProtocolMessage.getParams();
        int i = 0;
        if (params == null) {
            Plog.w(TAG, "dealRingAlgoState error", new Object[0]);
            return;
        }
        int optInt = params.optInt("state", -1);
        if (optInt == -1) {
            i = 1;
        }
        IRingOutputListener iRingOutputListener = this.mOutputListener;
        if (iRingOutputListener != null) {
            iRingOutputListener.ringNotifyAlgoState(i, optInt);
        }
    }

    private void dealRingModel(PayloadProtocolMessage payloadProtocolMessage) {
        JSONObject params = payloadProtocolMessage.getParams();
        int i = 0;
        if (params == null) {
            Plog.w(TAG, "dealRingModel error", new Object[0]);
            return;
        }
        String optString = params.optString("model", (String) null);
        if (optString == null) {
            i = 1;
        }
        IRingOutputListener iRingOutputListener = this.mOutputListener;
        if (iRingOutputListener != null) {
            iRingOutputListener.ringResponseRingModel(i, optString);
        }
    }

    private void dealRingNotifyOtaStatus(PayloadProtocolMessage payloadProtocolMessage) {
        JSONObject params = payloadProtocolMessage.getParams();
        int i = 0;
        if (params == null) {
            Plog.w(TAG, "dealRingNotifyOtaStatus error", new Object[0]);
            return;
        }
        int optInt = params.optInt(PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS, -1);
        int optInt2 = params.optInt(PayloadConstant.PARAMS_KEY_INT_OTA_STATE, -1);
        if (optInt == -1 || optInt2 == -1) {
            i = 1;
        }
        IRingOutputListener iRingOutputListener = this.mOutputListener;
        if (iRingOutputListener != null) {
            iRingOutputListener.ringNotifyUpdateOtaStatus(i, optInt2, optInt);
        }
    }

    private void dealRingResponseDeviceInfo(PayloadProtocolMessage payloadProtocolMessage) {
        JSONObject params = payloadProtocolMessage.getParams();
        int i = 0;
        if (params == null) {
            Plog.w(TAG, "dealRingResponseDeviceInfo error", new Object[0]);
            return;
        }
        int optInt = params.optInt(PayloadConstant.PARAMS_KEY_INT_BATTERY, -1);
        String optString = params.optString("device_id", (String) null);
        int optInt2 = params.optInt(PayloadConstant.PARAMS_KEY_INT_HARD_VERSION, 0);
        if (optInt == -1 || optString == null || optInt2 == 0) {
            i = 1;
        }
        IRingOutputListener iRingOutputListener = this.mOutputListener;
        if (iRingOutputListener != null) {
            iRingOutputListener.ringResponseDeviceInfo(i, optInt, optString, optInt2);
        }
    }

    private void dealRingResponseDeviceName(PayloadProtocolMessage payloadProtocolMessage) {
        JSONObject params = payloadProtocolMessage.getParams();
        int i = 0;
        if (params == null) {
            Plog.w(TAG, "dealRingResponseDeviceName error", new Object[0]);
            return;
        }
        String optString = params.optString("name", (String) null);
        if (optString == null || optString.length() == 0) {
            i = 1;
        }
        IRingOutputListener iRingOutputListener = this.mOutputListener;
        if (iRingOutputListener != null) {
            iRingOutputListener.ringResponseRingName(i, optString);
        }
    }

    private void dealRingResponseRemoteMouseStatus(PayloadProtocolMessage payloadProtocolMessage) {
        JSONObject params = payloadProtocolMessage.getParams();
        if (params == null) {
            Plog.w(TAG, "dealRingResponseRemoteMouseStatus error", new Object[0]);
            return;
        }
        int optInt = params.optInt(PayloadConstant.PARAMS_KEY_WORK_MODE, -1);
        IRingOutputListener iRingOutputListener = this.mOutputListener;
        if (iRingOutputListener != null) {
            iRingOutputListener.ringResponseRemoteMouseWorkMode(0, optInt);
        }
    }

    private void dealRingResponseRingVersion(PayloadProtocolMessage payloadProtocolMessage) {
        JSONObject params = payloadProtocolMessage.getParams();
        int i = 0;
        if (params == null) {
            Plog.w(TAG, "dealRingResponseRingVersion error", new Object[0]);
            return;
        }
        int optInt = params.optInt(PayloadConstant.PARAMS_KEY_INT_HARD_VERSION, 0);
        String optString = params.optString(PayloadConstant.PARAMS_KEY_STR_FW_VERSION, (String) null);
        String optString2 = params.optString(PayloadConstant.PARAMS_KEY_STR_SN, "");
        if (optInt == 0 || optString == null) {
            i = 1;
        }
        IRingOutputListener iRingOutputListener = this.mOutputListener;
        if (iRingOutputListener != null) {
            iRingOutputListener.ringResponseRingVersionV2(i, optInt, optString, optString2);
        }
    }

    private void handleReceiveProtocolMessage(PayloadProtocolMessage payloadProtocolMessage) {
        if (payloadProtocolMessage.getDeviceType() != 1) {
            Plog.w(TAG, "handleReceiveProtocolMessage receive device type is not ring device.", new Object[0]);
            return;
        }
        int opCode = payloadProtocolMessage.getOpCode();
        if (opCode == 2) {
            dealRingResponseDeviceInfo(payloadProtocolMessage);
        } else if (opCode == 4) {
            dealRingNotifyOtaStatus(payloadProtocolMessage);
        } else if (opCode == 6) {
            dealRingResponseRemoteMouseStatus(payloadProtocolMessage);
        } else if (opCode == 14) {
            dealRingResponseRingVersion(payloadProtocolMessage);
        } else if (opCode == 20) {
            dealRingResponseDeviceName(payloadProtocolMessage);
        } else if (opCode == 22) {
            dealRingAlgoState(payloadProtocolMessage);
        } else if (opCode != 23) {
            Plog.w(TAG, "handleReceiveProtocolMessage not support opcode: %d", Integer.valueOf(payloadProtocolMessage.getOpCode()));
        } else {
            dealRingModel(payloadProtocolMessage);
        }
    }

    public void receiveData(int i, byte[] bArr) throws JSONException {
        if (i == 1) {
            handleReceiveProtocolMessage(new PayloadProtocolMessage(bArr));
        } else {
            Plog.w(TAG, "receiveData not support msgType=%d", Integer.valueOf(i));
        }
    }

    @Deprecated
    public MessageContent ringControlWorkMode(boolean z) {
        return buildMessageInfo(MessageUtil.buildProtocolMessage2Bytes(1, 15, PayloadConstant.PARAMS_KEY_INT_IMU_OPERATION, Integer.valueOf(z ? 1 : 2)));
    }

    public MessageContent ringIndicateStartOta(int i, String str) {
        return buildMessageInfo(MessageUtil.buildProtocolMessage2Bytes(1, 3, PayloadConstant.PARAMS_KEY_INT_HARD_VERSION, Integer.valueOf(i), PayloadConstant.PARAMS_KEY_STR_OTA_FILE_URL, str));
    }

    public MessageContent ringRequestDeviceInfo() {
        return buildMessageInfo(MessageUtil.buildProtocolMessage2Bytes(1, 1, new Object[0]));
    }

    public MessageContent ringRequestName() {
        return buildMessageInfo(MessageUtil.buildProtocolMessage2Bytes(1, 19, new Object[0]));
    }

    public MessageContent ringRequestRemoteMouseStatus() {
        return buildMessageInfo(MessageUtil.buildProtocolMessage2Bytes(1, 5, new Object[0]));
    }

    public MessageContent ringRequestRingAlgoState() {
        return buildMessageInfo(MessageUtil.buildProtocolMessage2Bytes(1, 21, new Object[0]));
    }

    public MessageContent ringRequestRingModel() {
        return buildMessageInfo(MessageUtil.buildProtocolMessage2Bytes(1, 23, new Object[0]));
    }

    public MessageContent ringRequestRingVersion() {
        return buildMessageInfo(MessageUtil.buildProtocolMessage2Bytes(1, 13, new Object[0]));
    }

    public MessageContent ringSetBleDisconnect() {
        return buildMessageInfo(MessageUtil.buildProtocolMessage2Bytes(1, 11, new Object[0]));
    }

    public MessageContent ringSetImuOperation(int i) {
        return buildMessageInfo(MessageUtil.buildProtocolMessage2Bytes(1, 7, PayloadConstant.PARAMS_KEY_INT_IMU_OPERATION, Integer.valueOf(i)));
    }

    public MessageContent ringSetName(String str) throws InvalidParameterException {
        if (str == null || str.length() == 0) {
            throw new InvalidParameterException("name cannot be empty");
        } else if (str.getBytes(StandardCharsets.UTF_8).length <= 30) {
            return buildMessageInfo(MessageUtil.buildProtocolMessage2Bytes(1, 17, "name", str));
        } else {
            throw new InvalidParameterException("name bytes length cannot more than 30");
        }
    }

    public MessageContent ringSetWorkMode(int i) {
        if (i == 1 || i == 2 || i == 3) {
            return buildMessageInfo(MessageUtil.buildProtocolMessage2Bytes(1, 15, PayloadConstant.PARAMS_KEY_INT_IMU_OPERATION, Integer.valueOf(i)));
        }
        Plog.e(TAG, "unsupported ring work mode " + i, new Object[0]);
        return null;
    }
}
