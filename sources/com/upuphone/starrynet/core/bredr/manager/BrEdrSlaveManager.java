package com.upuphone.starrynet.core.bredr.manager;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.bredr.BrEdrDeviceManager;
import com.upuphone.starrynet.core.bredr.BrEdrEventManager;
import com.upuphone.starrynet.core.bredr.profile.BrEdrA2dpSinkManager;
import com.upuphone.starrynet.core.bredr.profile.BrEdrHfpClientManager;
import com.upuphone.starrynet.core.bredr.profile.BrEdrPbapManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrEdrSlaveManager extends BrEdrManager {
    private BrEdrA2dpSinkManager mBrEdrA2dpSinkManager = new BrEdrA2dpSinkManager(this.mContext, this.mHandler);
    private BrEdrHfpClientManager mBrEdrHfpClientManager = new BrEdrHfpClientManager(this.mContext, this.mHandler);
    private BrEdrPbapManager mBrEdrPbapManager = new BrEdrPbapManager(this.mHandler);

    public BrEdrSlaveManager(Context context) {
        super(context);
    }

    public void connectBrEdr(BluetoothDevice bluetoothDevice) {
        StLog.d("BrEdrManager", "connectBrEdr by sink!");
        this.mBrEdrHfpClientManager.conncetHfp(bluetoothDevice);
        this.mBrEdrA2dpSinkManager.connectA2dp(bluetoothDevice);
    }

    public void dial(BluetoothDevice bluetoothDevice, String str) {
        this.mBrEdrHfpClientManager.dial(bluetoothDevice, str);
    }

    public void disconnectBrEdr(BluetoothDevice bluetoothDevice) {
        StLog.d("BrEdrManager", "disconnectBrEdr by sink!");
        BluetoothAdapter bluetoothAdapter = this.mAdapter;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.disconnectAllEnabledProfiles(bluetoothDevice);
        } else {
            StLog.w("BrEdrManager", "disconnectBrEdr, mAdapter is null!");
        }
    }

    public BluetoothDevice getActiveDevice() {
        Map<BluetoothDevice, Integer> brEdrConnectedDeviceList = getBrEdrConnectedDeviceList();
        if (brEdrConnectedDeviceList == null || brEdrConnectedDeviceList.size() <= 0) {
            StLog.d("BrEdrManager", "none connected device!");
            return null;
        }
        if (brEdrConnectedDeviceList.size() > 1) {
            StLog.i("BrEdrManager", "getActiveDevice from slave, has " + brEdrConnectedDeviceList.size() + " connected device!");
        }
        for (Map.Entry next : brEdrConnectedDeviceList.entrySet()) {
            int intValue = ((Integer) next.getValue()).intValue();
            if (intValue != 0) {
                if ((intValue & 1024) == 0 || (intValue & 2048) == 0) {
                    StLog.i("BrEdrManager", "getActiveDevice from slave, protoState = " + intValue);
                }
                return (BluetoothDevice) next.getKey();
            }
        }
        return null;
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
                int i = this.mBrEdrHfpClientManager.checkHfpConnectionState(next) ? 1024 : 0;
                if (this.mBrEdrA2dpSinkManager.checkA2dpSinkConnectionState(next)) {
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

    public void operateCallAction(BluetoothDevice bluetoothDevice, int i) {
        StLog.d("BrEdrManager", "operateCallAction");
        if (i == 0) {
            this.mBrEdrHfpClientManager.acceptCall(bluetoothDevice);
        } else if (i == 1) {
            this.mBrEdrHfpClientManager.rejectCall(bluetoothDevice);
        } else if (i == 2) {
            this.mBrEdrHfpClientManager.holdCall(bluetoothDevice);
        } else if (i == 3) {
            this.mBrEdrHfpClientManager.terminateCall(bluetoothDevice);
        }
    }

    public void pullPhoneBook(BluetoothDevice bluetoothDevice) {
        if (this.mBrEdrPbapManager.pullPhoneBook(bluetoothDevice)) {
            BrEdrEventManager.getInstance(this.mContext).pullPhoneBookChange(0);
        }
    }

    public void resetPhoneBookRecord() {
        this.mBrEdrPbapManager.resetPhoneBookRecord();
    }
}
