package com.upuphone.starrynet.payload;

import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageUtil {
    private static final String TAG = "MessageUtil";

    public static byte[] buildProtocolMessage2Bytes(int i, int i2, Object... objArr) {
        return buildProtocolMessage2Json(i, i2, objArr).toString().getBytes(StandardCharsets.UTF_8);
    }

    public static JSONObject buildProtocolMessage2Json(int i, int i2, Object... objArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PayloadConstant.KEY_DEVICE_TYPE, i);
            jSONObject.put(PayloadConstant.KEY_OPCODE, i2);
            if (objArr != null) {
                if (objArr.length != 0) {
                    if (objArr.length % 2 == 0) {
                        int length = objArr.length / 2;
                        JSONObject jSONObject2 = new JSONObject();
                        for (int i3 = 0; i3 < length; i3++) {
                            int i4 = i3 * 2;
                            String str = objArr[i4];
                            String str2 = objArr[i4 + 1];
                            if (str2 instanceof String) {
                                jSONObject2.put(str, str2);
                            } else if (str2 instanceof Integer) {
                                jSONObject2.put(str, ((Integer) str2).intValue());
                            } else if (str2 instanceof Boolean) {
                                jSONObject2.put(str, ((Boolean) str2).booleanValue());
                            } else if (str2 instanceof Short) {
                                jSONObject2.put(str, ((Short) str2).shortValue());
                            } else if (str2 instanceof Float) {
                                jSONObject2.put(str, (double) ((Float) str2).floatValue());
                            } else if (str2 instanceof Long) {
                                jSONObject2.put(str, ((Long) str2).longValue());
                            } else if (str2 instanceof Byte) {
                                jSONObject2.put(str, ((Byte) str2).byteValue());
                            }
                        }
                        jSONObject.put(PayloadConstant.KEY_PARAMS, jSONObject2);
                    } else {
                        Plog.e(TAG, "buildProtocolMessage keyValuePair length must be even number,current length=" + objArr.length, new Object[0]);
                    }
                    return jSONObject;
                }
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
