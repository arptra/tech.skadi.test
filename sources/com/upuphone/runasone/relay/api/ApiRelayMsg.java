package com.upuphone.runasone.relay.api;

import com.upuphone.hub.annotation.Callback;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.Parcelable;
import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import java.util.List;

@Hub
public interface ApiRelayMsg {
    List<StarryDevice> getRelayDeviceList(String str);

    void removeRelayListener(String str, String str2);

    void sendMessageQos(@Parcelable StarryTag starryTag, @Parcelable ArrayData arrayData, int i, StarryParam starryParam, @Callback SendRelayMessageCallBack sendRelayMessageCallBack);

    void setRelayListener(String str, String str2, @Callback RelayCallback relayCallback);

    void startRemote(@Parcelable StarryTag starryTag, String str, @Parcelable ArrayData arrayData, int i, StarryParam starryParam);

    void stopRemote(@Parcelable StarryTag starryTag, StarryParam starryParam);
}
