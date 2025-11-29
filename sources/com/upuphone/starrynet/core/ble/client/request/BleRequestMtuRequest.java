package com.upuphone.starrynet.core.ble.client.request;

import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.client.listener.RequestMtuListener;
import com.upuphone.starrynet.core.ble.client.response.BleResponser;

public class BleRequestMtuRequest extends BleRequest implements RequestMtuListener {
    private int mtu;

    public BleRequestMtuRequest(int i, BleResponser bleResponser) {
        super(bleResponser);
        this.mtu = i;
    }

    private void startRequestMtu(int i) {
        if (!requestMtu(i)) {
            onRequestCompleted(-1);
        } else {
            startRequestTiming();
        }
    }

    public long getTimeoutInMillis() {
        return 5000;
    }

    public void onMtuChanged(int i, int i2) {
        stopRequestTiming();
        if (i2 == 0) {
            putIntExtra(BluetoothConstants.KEY_MTU, i);
            onRequestCompleted(0);
            return;
        }
        onRequestCompleted(-1);
    }

    public void processRequest() {
        int currentStatus = getCurrentStatus();
        if (currentStatus == 0) {
            onRequestCompleted(-1);
        } else if (currentStatus == 2) {
            startRequestMtu(this.mtu);
        } else if (currentStatus != 19) {
            onRequestCompleted(-1);
        } else {
            startRequestMtu(this.mtu);
        }
    }
}
