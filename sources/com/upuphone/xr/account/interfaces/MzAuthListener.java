package com.upuphone.xr.account.interfaces;

import android.content.Intent;

public interface MzAuthListener {
    void onHandleIntent(Intent intent);

    void onOriginalError(int i, int i2, String str);

    void onSuccess(String str);
}
