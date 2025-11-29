package com.upuphone.starrynet.strategy.channel.bredr;

import android.bluetooth.BluetoothDevice;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.bredr.BrEdrDeviceManager;
import com.upuphone.starrynet.core.bredr.manager.BrEdrSlaveManager;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import java.util.Iterator;
import java.util.List;

public class BrEdrSlaveChannel extends BrEdrChannel {
    private static final String FILE_PREFS = "bonded_bt_ios_prefs";
    private static final String KEY_MAC = "mac";
    private static final int LENGTH_MAC_RECORD = 18;
    private static final int MAX_BONDED_SIZE = 8;
    private static final String TAG = "BrEdrSlaveChannel";

    public BrEdrSlaveChannel() {
        this.mManager = new BrEdrSlaveManager(this.mContext);
        initListener();
    }

    private String checkAndRemove(String str) {
        String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        if (split.length <= 8) {
            return str;
        }
        int i = 0;
        int i2 = 0;
        while (i < split.length - 8) {
            int i3 = i * 18;
            i++;
            int i4 = i * 18;
            BluetoothDevice bluetoothDevice = BleUtil.getBluetoothDevice(str.substring(i3, i4 - 1));
            if (bluetoothDevice != null) {
                StLog.d(TAG, "updateLRUBondRecord, ios removeBrEdrBond mac : " + bluetoothDevice.getAddress());
                BrEdrDeviceManager.removeBrEdrBond(bluetoothDevice);
            } else {
                StLog.i(TAG, "updateLRUBondRecord, ios removeBrEdrBond exception for wrong mac!");
            }
            i2 = i4;
        }
        return str.substring(i2);
    }

    private String compareAndAdjust(String str, String str2, int i) {
        List<BluetoothDevice> bondDeviceList = BrEdrDeviceManager.getBondDeviceList();
        if (!(bondDeviceList == null || bondDeviceList.size() == 0)) {
            StringBuilder sb = new StringBuilder();
            String[] split = str.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
            boolean[] zArr = new boolean[split.length];
            Iterator<BluetoothDevice> it = bondDeviceList.iterator();
            while (true) {
                int i2 = 0;
                if (!it.hasNext()) {
                    break;
                }
                String address = it.next().getAddress();
                while (true) {
                    if (i2 < split.length) {
                        if (address.equals(split[i2]) && !address.equals(str2)) {
                            zArr[i2] = true;
                            break;
                        }
                        i2++;
                    } else if (!address.equals(str2)) {
                        sb.append(address);
                        sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                    }
                }
            }
            for (int i3 = 0; i3 < split.length; i3++) {
                if (zArr[i3]) {
                    sb.append(split[i3]);
                    sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
                }
            }
            if (i == 12) {
                sb.append(str2);
                sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
            }
            if (sb.length() > 0) {
                return sb.substring(0, sb.length() - 1);
            }
        }
        return "";
    }

    public int getProfile() {
        return 21;
    }

    public void onBrEdrBondStateChanged(BluetoothDevice bluetoothDevice, int i, int i2) {
        super.onBrEdrBondStateChanged(bluetoothDevice, i, i2);
    }
}
