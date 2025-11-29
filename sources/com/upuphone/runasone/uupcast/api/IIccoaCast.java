package com.upuphone.runasone.uupcast.api;

import android.os.Bundle;
import com.upuphone.hub.annotation.Callback;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.Parcelable;
import com.upuphone.runasone.uupcast.SinkDisplayConfig;
import com.upuphone.starryiccoaproto.UCarMessage;

@Hub
public interface IIccoaCast {
    void buildVirtualAfterBleConnected();

    void destroyVirtualDisplayWhenConnectFail();

    void initPhoneState();

    void initSession(SinkDisplayConfig sinkDisplayConfig);

    boolean isCarInCache(byte[] bArr);

    void reAuth(boolean z);

    void removeCarCache();

    void removeCarCache(byte[] bArr);

    void sendCarMessage(@Parcelable UCarMessage uCarMessage);

    void sendCastMessage(int i, @Parcelable Bundle bundle);

    void sendMessage(int i);

    void setIHandleReceiverCarMessageListener(@Callback IHandleReceiverCarMessageListener iHandleReceiverCarMessageListener);

    void setIccoaConnectListener(@Callback IccoaConnectListener iccoaConnectListener);

    void setUibcDisplayId(int i);

    void startCast(int i, @Parcelable Bundle bundle);

    void stopPlay();

    void updatePincode(String str);
}
