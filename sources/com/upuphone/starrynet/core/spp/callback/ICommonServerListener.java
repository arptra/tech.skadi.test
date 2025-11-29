package com.upuphone.starrynet.core.spp.callback;

import android.bluetooth.BluetoothSocket;
import java.util.UUID;

public interface ICommonServerListener {
    void onAdvertiseFail(UUID uuid);

    void onAdvertiseSuccess(UUID uuid);

    void onConnectionAccepted(String str, BluetoothSocket bluetoothSocket);
}
