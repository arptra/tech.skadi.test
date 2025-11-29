package com.upuphone.starrynet.core.bredr.manager;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.upuphone.starrynet.core.bredr.BrEdrDeviceManager;
import com.upuphone.starrynet.core.bredr.profile.BrEdrA2dpManager;
import com.upuphone.starrynet.core.bredr.profile.BrEdrHfpManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrEdrMasterManager extends BrEdrManager {
    private BrEdrA2dpManager mBrEdrA2dpManager = new BrEdrA2dpManager(this.mContext, this.mHandler);
    private BrEdrHfpManager mBrEdrHfpManager = new BrEdrHfpManager(this.mContext, this.mHandler);

    public BrEdrMasterManager(Context context) {
        super(context);
    }

    public void connectBrEdr(BluetoothDevice bluetoothDevice) {
        this.mBrEdrHfpManager.connectHfp(bluetoothDevice);
        this.mBrEdrA2dpManager.connectA2dp(bluetoothDevice);
    }

    public void disconnectBrEdr(BluetoothDevice bluetoothDevice) {
        this.mBrEdrHfpManager.disconnectHfp(bluetoothDevice);
        this.mBrEdrA2dpManager.disconnectA2dp(bluetoothDevice);
    }

    public BluetoothDevice getActiveDevice() {
        return this.mBrEdrA2dpManager.getA2dpActiveDevice();
    }

    public Map<BluetoothDevice, Integer> getBrEdrConnectedDeviceList() {
        List<BluetoothDevice> bondDeviceList = BrEdrDeviceManager.getBondDeviceList();
        if (bondDeviceList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (BluetoothDevice next : bondDeviceList) {
            int type = next.getType();
            if ((type == 1 || type == 3) && next.isConnected()) {
                int i = this.mBrEdrHfpManager.checkHfpConnectionState(next) ? 1024 : 0;
                if (this.mBrEdrA2dpManager.checkA2dpConnectionState(next)) {
                    i |= 2048;
                }
                if (i != 0) {
                    i |= 512;
                }
                hashMap.put(next, Integer.valueOf(i));
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    public int removeAudioActiveDevice() {
        return this.mAdapter.removeActiveDevice(2) ? 0 : -1;
    }

    public int switchAudioPlayDevice(BluetoothDevice bluetoothDevice) {
        if (!this.mBrEdrA2dpManager.setA2dpActiveDevice(bluetoothDevice)) {
            return -1;
        }
        this.mBrEdrHfpManager.setHfpActiveDevice(bluetoothDevice);
        return 0;
    }
}
