package com.upuphone.starrynet.core.bredr.profile;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothProfile;

public class BrEdrBaseProfile {
    static final String TAG = "BrEdrBaseProfile";
    BluetoothProfile.ServiceListener listener = new BluetoothProfile.ServiceListener() {
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            BrEdrBaseProfile.this.serviceConnected(i, bluetoothProfile);
        }

        public void onServiceDisconnected(int i) {
            BrEdrBaseProfile.this.serviceDisconnected(i);
        }
    };
    BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();

    public void serviceConnected(int i, BluetoothProfile bluetoothProfile) {
    }

    public void serviceDisconnected(int i) {
    }
}
