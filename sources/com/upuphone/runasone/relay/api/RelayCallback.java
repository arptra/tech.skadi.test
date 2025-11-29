package com.upuphone.runasone.relay.api;

import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.Parcelable;
import com.upuphone.hub.annotation.ThrowException;
import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import java.util.List;

@Hub
public interface RelayCallback {
    void onDeviceListChanged(String str, List<StarryDevice> list);

    @ThrowException
    void onReceiveMessage(@Parcelable StarryTag starryTag, @Parcelable ArrayData arrayData, StarryParam starryParam);

    void onRemoteError(@Parcelable StarryTag starryTag, int i, String str, StarryParam starryParam);

    void onRemoteStart(@Parcelable StarryTag starryTag, StarryParam starryParam);

    void onRemoteStop(@Parcelable StarryTag starryTag, StarryParam starryParam);
}
