package com.upuphone.starrynet.payload;

import org.json.JSONException;
import org.json.JSONObject;

public class PayloadProtocolMessage {
    private static final String TAG = "PayloadProtocolMessage";
    private int deviceType;
    private int opCode;
    private JSONObject params;

    public PayloadProtocolMessage(byte[] bArr) throws JSONException {
        JSONObject jSONObject = new JSONObject(new String(bArr));
        this.deviceType = jSONObject.optInt(PayloadConstant.KEY_DEVICE_TYPE, -1);
        this.opCode = jSONObject.optInt(PayloadConstant.KEY_OPCODE, -1);
        this.params = jSONObject.optJSONObject(PayloadConstant.KEY_PARAMS);
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getOpCode() {
        return this.opCode;
    }

    public JSONObject getParams() {
        return this.params;
    }
}
