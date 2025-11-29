package com.crazecoder.flutterbugly.utils;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    public static String a(Map map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
