package com.upuphone.starrynet.strategy.message.payload.handler;

import androidx.core.util.Consumer;
import com.upuphone.starrynet.api.ICommonCallback;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.message.IMessageResponseListener;
import com.upuphone.starrynet.api.message.IReceivePayloadMessageListener;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.starrynet.payload.PayloadProtocolMessage;
import com.upuphone.starrynet.strategy.message.payload.PayloadMessage;
import com.upuphone.starrynet.strategy.service.StarryHidManager;
import java.util.UUID;
import org.json.JSONObject;

public class HidProtocolHandler implements IProtocolHandler {
    private static final String TAG = "HidProtocolHandler";
    private IReceivePayloadMessageListener receiveMessageListener;

    private void closeHid() {
        StarryHidManager.getInstance().closeHid();
    }

    private void openHid(final PayloadMessage payloadMessage, JSONObject jSONObject) {
        if (jSONObject == null) {
            callbackError(payloadMessage.getInnerListener(), StErrorCode.PAYLOAD_MESSAGE_INVALID_PARAMS, "JSONObject params is null");
            return;
        }
        int optInt = jSONObject.optInt(PayloadConstant.PARAMS_KEY_HID_TYPE, -1);
        if (optInt < 0) {
            callbackError(payloadMessage.getInnerListener(), StErrorCode.PAYLOAD_MESSAGE_INVALID_PARAMS, "cannot find hid_type in params(json)");
        } else if (optInt != 5) {
            callbackError(payloadMessage.getInnerListener(), StErrorCode.PAYLOAD_MESSAGE_INVALID_PARAMS, String.format("cannot support hid type:%d, expect hid type is %d", new Object[]{Integer.valueOf(optInt), (byte) 5}));
        } else {
            StLog.d(TAG, "openHID, ble mac =%s", payloadMessage.getBleMac());
            StarryHidManager.getInstance().openHid(ByteUtils.fromHexString(payloadMessage.getBleMac()), (byte) optInt, new ICommonCallback() {
                public void onResult(int i, String str) {
                    HidProtocolHandler.this.callbackError(payloadMessage.getInnerListener(), i, str);
                }
            });
        }
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
        return PayloadConstant.STARRY_NET_PAYLOAD_HID_CHARACTER_UUID;
    }

    public int getDeviceType() {
        return 2;
    }

    public UUID getServiceUUID() {
        return PayloadConstant.STARRY_NET_PAYLOAD_HID_SERVICE_UUID;
    }

    public boolean handleCommonService(String str, UUID uuid, UUID uuid2, byte[] bArr) {
        return false;
    }

    public void handleMessage(PayloadMessage payloadMessage) {
        StarryHidManager.getInstance().getTouchPadWrapper().sendBytes(payloadMessage.getContent());
    }

    public void handleProtocolMessage(PayloadMessage payloadMessage, PayloadProtocolMessage payloadProtocolMessage) {
        switch (payloadProtocolMessage.getOpCode()) {
            case 50:
                openHid(payloadMessage, payloadProtocolMessage.getParams());
                return;
            case 51:
                return;
            case 52:
                closeHid();
                return;
            default:
                StLog.w(TAG, "not support opcode =%d, for hid device", Integer.valueOf(payloadProtocolMessage.getOpCode()));
                return;
        }
    }

    public boolean isSupportCommonService() {
        return false;
    }

    public void receiveData(String str, byte[] bArr) {
    }

    public void registerReceiveMessageListener(IReceivePayloadMessageListener iReceivePayloadMessageListener) {
        this.receiveMessageListener = iReceivePayloadMessageListener;
    }

    public void sendInternalMessage(String str, byte b, byte[] bArr, Consumer<byte[]> consumer) {
    }
}
