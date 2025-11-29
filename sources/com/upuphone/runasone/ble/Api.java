package com.upuphone.runasone.ble;

import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.Parcelable;
import java.util.ArrayList;

@Hub
public interface Api extends DeviceApi, SessionApi {
    @Parcelable
    ArrayList<BleRawDevice> getFoundDeviceList(String str);
}
