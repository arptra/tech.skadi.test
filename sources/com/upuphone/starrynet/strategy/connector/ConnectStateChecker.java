package com.upuphone.starrynet.strategy.connector;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.bredr.BrEdrDeviceManager;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.utils.BleUtil;

@SuppressLint({"MissingPermission"})
public class ConnectStateChecker {
    private static final int DELAY_TIME_CHECK_BR = 5000;
    private static final int MSG_CHECK_BR_BOND = 0;
    private static final int MSG_CREATE_BR_BOND = 1;
    private static final String TAG = "ConnectStateChecker";
    private static final int TIMES_CHECK_BR_BOND = 3;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(@NonNull Message message) {
            ConnectStateChecker.this.dealMessage(message);
            return false;
        }
    });
    private final int mOwnType = StarryNetData.getInstance().getOwnDevice().getTerminalType();

    private void checkBrBond(StConnectDevice stConnectDevice, int i) {
        StLog.d(TAG, "checkBrBond " + stConnectDevice);
        BluetoothDevice bluetoothDevice = getBluetoothDevice(stConnectDevice.getBrEdrMac());
        if (bluetoothDevice == null) {
            StLog.w(TAG, "bluetoothDevice is null");
            return;
        }
        int bondState = bluetoothDevice.getBondState();
        if (bondState != 12) {
            if (i <= 0) {
                StLog.w(TAG, "create bond fail");
                return;
            }
            if (bondState == 10) {
                if (stConnectDevice.getTerminalType() == 2 ? BrEdrDeviceManager.invokeCreateBrEdrBond(bluetoothDevice) : BrEdrDeviceManager.createBrEdrBond(bluetoothDevice)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("create bond times = ");
                    i--;
                    sb.append(i);
                    StLog.d(TAG, sb.toString());
                } else {
                    StLog.d(TAG, "create bond false");
                }
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, i, 0, stConnectDevice), 5000);
        }
    }

    private void createBrBond(StConnectDevice stConnectDevice) {
        BluetoothDevice bluetoothDevice = StarryDeviceManager.getInstance().getBluetoothDevice(stConnectDevice.getDevice());
        if (bluetoothDevice == null) {
            StLog.w(TAG, "bluetoothDevice is null");
        } else if (bluetoothDevice.getBondState() == 10) {
            boolean invokeCreateBrEdrBond = stConnectDevice.getTerminalType() == 2 ? BrEdrDeviceManager.invokeCreateBrEdrBond(bluetoothDevice) : BrEdrDeviceManager.createBrEdrBond(bluetoothDevice);
            StLog.d(TAG, "create bond times ret = " + invokeCreateBrEdrBond);
        }
    }

    /* access modifiers changed from: private */
    public void dealMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            checkBrBond((StConnectDevice) message.obj, message.arg1);
        } else if (i == 1) {
            createBrBond((StConnectDevice) message.obj);
        }
    }

    private BluetoothDevice getBluetoothDevice(String str) {
        return BleUtil.getBluetoothDevice(str);
    }

    public void cancelBRCheck(StConnectDevice stConnectDevice) {
        if (stConnectDevice.getTerminalType() == 2) {
            StLog.d(TAG, "cancelBRCheck " + stConnectDevice);
            this.mHandler.removeMessages(0);
            BluetoothDevice bluetoothDevice = getBluetoothDevice(stConnectDevice.getBrEdrMac());
            if (bluetoothDevice == null) {
                StLog.w(TAG, "bluetoothDevice is null");
            } else if (bluetoothDevice.getBondState() == 11) {
                BrEdrDeviceManager.cancelBondProcess(bluetoothDevice);
            }
        }
    }

    public void checkBRState(StConnectDevice stConnectDevice) {
        if (stConnectDevice.getTerminalType() != 2) {
            return;
        }
        if (this.mOwnType == 1) {
            Message.obtain(this.mHandler, 0, 3, 0, stConnectDevice).sendToTarget();
        } else {
            Message.obtain(this.mHandler, 1, stConnectDevice).sendToTarget();
        }
    }

    public void executeConnectDelay(Runnable runnable, int i) {
        this.mHandler.postDelayed(runnable, (long) i);
    }
}
