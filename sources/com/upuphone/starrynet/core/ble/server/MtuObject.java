package com.upuphone.starrynet.core.ble.server;

import com.upuphone.starrynet.core.ble.utils.BluetoothLog;

class MtuObject {
    private static final String TAG = "MtuObject";
    private int actualMtu;
    private int expectedMtu;
    private int protocolMtu;

    public int getProtocolMtu() {
        int i;
        int i2 = this.protocolMtu;
        if (i2 > 0) {
            return i2;
        }
        int i3 = this.expectedMtu;
        if (i3 == 0 || (i = this.actualMtu) == 0) {
            return 23;
        }
        if (i3 <= i) {
            BluetoothLog.log(TAG, "updateProtocolMtu =" + this.expectedMtu, new Object[0]);
            this.protocolMtu = this.expectedMtu;
        } else {
            BluetoothLog.log(TAG, "updateProtocolMtu to default mtu size", new Object[0]);
            this.protocolMtu = 23;
        }
        return this.protocolMtu;
    }

    public void updateActualMtu(int i) {
        BluetoothLog.log(TAG, "updateActualMtu =" + i, new Object[0]);
        this.actualMtu = i;
    }

    public void updateExpectedMtu(int i) {
        BluetoothLog.log(TAG, "updateExpectedMtu =" + i, new Object[0]);
        this.expectedMtu = i;
    }
}
