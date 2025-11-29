package com.upuphone.starrynet.core.ble.client.response;

import android.os.Bundle;
import com.upuphone.starrynet.core.ble.BluetoothConstants;

public class BleResponser implements BleResponse<Bundle> {
    private BleResponse mResponse;

    private BleResponser(BleResponse bleResponse) {
        this.mResponse = bleResponse;
    }

    public static BleResponser newInstance(BleResponse bleResponse) {
        return new BleResponser(bleResponse);
    }

    public void onResponse(int i, Bundle bundle) {
        BleResponse bleResponse = this.mResponse;
        if (bleResponse != null) {
            if (bleResponse instanceof BleConnectResponse) {
                bleResponse.onResponse(i, bundle);
                return;
            }
            byte[] bArr = null;
            if (bleResponse instanceof BleReadResponse) {
                if (bundle != null) {
                    bArr = bundle.getByteArray(BluetoothConstants.KEY_BYTES);
                }
                bleResponse.onResponse(i, bArr);
            } else if (bleResponse instanceof BleWriteResponse) {
                if (bundle != null) {
                    bArr = bundle.getByteArray(BluetoothConstants.KEY_CHARACTER_VALUE);
                }
                bleResponse.onResponse(i, bArr);
            } else if (bleResponse instanceof BleRequestMtuResponse) {
                bleResponse.onResponse(i, Integer.valueOf(bundle != null ? bundle.getInt(BluetoothConstants.KEY_MTU) : 23));
            } else {
                bleResponse.onResponse(i, null);
            }
        }
    }
}
