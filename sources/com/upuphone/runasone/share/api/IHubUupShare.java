package com.upuphone.runasone.share.api;

import android.net.Uri;
import com.upuphone.hub.annotation.Callback;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.Parcelable;

@Hub
public interface IHubUupShare {
    void cancel(String str, String str2);

    void cancelReceive(String str, String str2, String str3);

    void confirmReceive(String str, String str2);

    boolean isTransferring(String str);

    String pull(String str, @Parcelable Uri[] uriArr);

    boolean reTry(String str, @Parcelable Uri[] uriArr, String str2, String str3, String str4);

    void registerReceiveCallBack(String str, @Callback IHubUupShareStatusCallback iHubUupShareStatusCallback);

    void registerSendCallBack(String str, @Callback IHubUupShareStatusCallback iHubUupShareStatusCallback);

    String sendFile(String str, @Parcelable Uri[] uriArr, String str2, String str3);

    String sendFileByBle(String str, @Parcelable Uri uri, String str2, String str3);

    void setPath(String str, String str2);

    void unRegisterReceiveCallBack(String str);

    void unRegisterSendCallBack(String str);
}
