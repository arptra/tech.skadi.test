package com.meizu.account.oauth;

import org.json.JSONObject;

public interface OnUserInfoListener {
    void onFailed(int i, String str);

    void onSuccess(JSONObject jSONObject);
}
