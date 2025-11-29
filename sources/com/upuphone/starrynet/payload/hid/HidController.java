package com.upuphone.starrynet.payload.hid;

import com.upuphone.starrynet.payload.MessageUtil;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.starrynet.payload.PayloadProtocolMessage;
import com.upuphone.starrynet.payload.Plog;
import org.json.JSONException;
import org.json.JSONObject;

public class HidController {
    private static final String TAG = "HidController";
    private IHidOutputListener mOutputListener;
    private TouchPadProxy touchPadProxy;

    public HidController(IHidOutputListener iHidOutputListener) {
        this.mOutputListener = iHidOutputListener;
    }

    private void handleReceiveProtocolMessage(PayloadProtocolMessage payloadProtocolMessage) {
        IHidOutputListener iHidOutputListener;
        if (payloadProtocolMessage.getDeviceType() != 2) {
            Plog.w(TAG, "handleReceiveProtocolMessage receive device type is not hid device.", new Object[0]);
        } else if (payloadProtocolMessage.getOpCode() != 51) {
            Plog.w(TAG, "handleReceiveProtocolMessage not support opcode: %d", Integer.valueOf(payloadProtocolMessage.getOpCode()));
        } else {
            JSONObject params = payloadProtocolMessage.getParams();
            if (params == null) {
                Plog.w(TAG, "handleReceiveProtocolMessage receive open hid callback, params is null", new Object[0]);
                return;
            }
            int optInt = params.optInt("code", -1);
            String optString = params.optString(PayloadConstant.PARAMS_KEY_CALLBACK_MSG, (String) null);
            if (optInt > 0 && (iHidOutputListener = this.mOutputListener) != null) {
                iHidOutputListener.openHidCallBack(optInt, optString);
            }
        }
    }

    private void output(int i, byte[] bArr) {
        IHidOutputListener iHidOutputListener = this.mOutputListener;
        if (iHidOutputListener != null) {
            iHidOutputListener.output(i, bArr);
        }
    }

    public void closeHid() {
        output(1, MessageUtil.buildProtocolMessage2Bytes(2, 52, new Object[0]));
    }

    public TouchPadProxy getTouchPad(int i, int i2) {
        if (this.touchPadProxy == null) {
            TouchPadProxy touchPadProxy2 = new TouchPadProxy(i, i2);
            this.touchPadProxy = touchPadProxy2;
            touchPadProxy2.setIPayloadMessageOutputListener(this.mOutputListener);
        }
        this.touchPadProxy.updateSize(i, i2);
        return this.touchPadProxy;
    }

    public void openHid(int i) {
        output(1, MessageUtil.buildProtocolMessage2Bytes(2, 50, PayloadConstant.PARAMS_KEY_HID_TYPE, Integer.valueOf(i)));
    }

    public void receiveData(int i, byte[] bArr) throws JSONException {
        if (i == 1) {
            handleReceiveProtocolMessage(new PayloadProtocolMessage(bArr));
        } else {
            Plog.w(TAG, "receiveData not support msgType=%d", Integer.valueOf(i));
        }
    }
}
