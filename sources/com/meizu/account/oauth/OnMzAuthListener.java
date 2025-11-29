package com.meizu.account.oauth;

import android.content.Intent;

public interface OnMzAuthListener {
    void onError(int i, String str, String str2);

    void onHandleIntent(Intent intent);

    void onSuccess(String str, String str2);
}
