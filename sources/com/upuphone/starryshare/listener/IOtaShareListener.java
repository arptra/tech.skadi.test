package com.upuphone.starryshare.listener;

import android.net.Uri;

public interface IOtaShareListener {
    void onFailure(String str, boolean z, int i);

    void onFinish(String str, Uri uri, Uri uri2);

    void onProgressChanged(String str, int i, Uri uri);

    void onSuccess(String str);
}
