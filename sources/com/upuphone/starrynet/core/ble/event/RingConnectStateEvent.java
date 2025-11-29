package com.upuphone.starrynet.core.ble.event;

import android.bluetooth.BluetoothDevice;

public class RingConnectStateEvent {
    public static final int STATE_ACL_CONNECTED = 2;
    public static final int STATE_ACL_DISCONNECTED = 3;
    public static final int STATE_BLE_CONNECTED = 5;
    public static final int STATE_BONDED = 1;
    public static final int STATE_BT_OFF = 6;
    public static final int STATE_HID_HOST_CONNECTED = 4;
    public static final int STATE_RING_ACL_CONNECTED = 9;
    public static final int STATE_RING_ACL_DISCONNECTED = 10;
    public static final int STATE_RING_BONDED = 7;
    public static final int STATE_RING_UNBONDED = 8;
    private String bleMac;
    public BluetoothDevice device;
    private int state;

    public RingConnectStateEvent(String str, int i) {
        this.bleMac = str;
        this.state = i;
    }

    public String getBleMac() {
        return this.bleMac;
    }

    public BluetoothDevice getDevice() {
        return this.device;
    }

    public int getState() {
        return this.state;
    }

    public RingConnectStateEvent(String str, int i, BluetoothDevice bluetoothDevice) {
        this.bleMac = str;
        this.state = i;
        this.device = bluetoothDevice;
    }
}
