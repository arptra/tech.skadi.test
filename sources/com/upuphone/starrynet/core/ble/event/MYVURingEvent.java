package com.upuphone.starrynet.core.ble.event;

import android.bluetooth.BluetoothDevice;

public class MYVURingEvent {
    public static final int STATE_ACL_CONNECTED = 3;
    public static final int STATE_ACL_DISCONNECTED = 4;
    public static final int STATE_BONDED = 1;
    public static final int STATE_BONDING = 7;
    public static final int STATE_BT_STATE_CHANGE_OFF = 8;
    public static final int STATE_BT_STATE_CHANGE_ON = 9;
    public static final int STATE_HID_HOST_CONNECTED = 5;
    public static final int STATE_HID_HOST_DISCONNECTED = 6;
    public static final int STATE_RING_OFFLINE_REMOVE_BOND = 10;
    public static final int STATE_UNBOND = 2;
    private String bleMac;
    private BluetoothDevice device;
    private int state;

    public MYVURingEvent(String str, int i) {
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

    public MYVURingEvent(String str, int i, BluetoothDevice bluetoothDevice) {
        this.bleMac = str;
        this.state = i;
        this.device = bluetoothDevice;
    }
}
