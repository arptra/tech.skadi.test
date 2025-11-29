package com.upuphone.runasone.share.api;

import android.net.Uri;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.Parcelable;

@Hub
public interface IHubUupShareStatusCallback {
    void onFailure(String str, boolean z, int i);

    void onFinish(String str, @Parcelable Uri uri, @Parcelable Uri uri2);

    void onProgressChanged(String str, int i, @Parcelable Uri uri);

    void onStart(String str, String str2);

    void onSuccess(String str);
}
