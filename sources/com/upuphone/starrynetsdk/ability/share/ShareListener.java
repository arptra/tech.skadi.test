package com.upuphone.starrynetsdk.ability.share;

import android.net.Uri;

public interface ShareListener {
    void onError(String str, int i);

    void onFinish(String str);

    void onProgress(String str, Uri uri, int i);

    void onStart(String str);

    void onSuccess(String str, Uri uri, Uri uri2);
}
