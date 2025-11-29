package com.upuphone.starrynet.core.ble.server.reponse;

import android.os.Bundle;

public class BleServerResponser implements IBleServerResponse<Bundle> {
    public IBleServerResponse mBleResponse;

    public BleServerResponser(IBleServerResponse iBleServerResponse) {
        this.mBleResponse = iBleServerResponse;
    }

    public void onResponse(int i, Bundle bundle) {
        IBleServerResponse iBleServerResponse = this.mBleResponse;
        if (iBleServerResponse != null) {
            iBleServerResponse.onResponse(i, null);
        }
    }
}
