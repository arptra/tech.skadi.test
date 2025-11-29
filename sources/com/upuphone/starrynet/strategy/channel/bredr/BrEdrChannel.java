package com.upuphone.starrynet.strategy.channel.bredr;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.core.bredr.BrEdrDeviceManager;
import com.upuphone.starrynet.core.bredr.listener.IBrEdrActionStateCallback;
import com.upuphone.starrynet.core.bredr.listener.IBrEdrConnectStateCallback;
import com.upuphone.starrynet.core.bredr.manager.BrEdrManager;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IChannelCallback;
import com.upuphone.starrynet.strategy.channel.IConnectChannel;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import java.util.Map;

public abstract class BrEdrChannel implements IConnectChannel, IBrEdrActionStateCallback, IBrEdrConnectStateCallback {
    private static final int MAX_BREDR_RETRY_TIME = 1;
    private static final String TAG = "BrEdrChannel";
    protected IBrEdrActionStateCallback mActionCallback;
    protected IChannelCallback mCallback;
    protected Context mContext = StarryNetData.getInstance().getApplicationContext();
    protected BrEdrManager mManager;
    private int mRetryTimes;

    private int getBondState(int i) {
        if (i == 10) {
            return 16;
        }
        if (i == 11) {
            return 32;
        }
        if (i == 12) {
            return 48;
        }
        return i;
    }

    public static int getBrEdrBondState(StDevice stDevice) {
        StLog.d(TAG, "getBrEdrBondState");
        BluetoothDevice bluetoothDevice = StarryDeviceManager.getInstance().getBluetoothDevice(stDevice);
        if (bluetoothDevice == null) {
            return 10;
        }
        return bluetoothDevice.getBondState();
    }

    public static boolean removeBondBrEdr(StDevice stDevice) {
        if (stDevice == null || !SysActionManager.getInstance().isBtOn()) {
            StLog.e(TAG, "removeBrEdrBond: device is null or bt is off");
            return false;
        }
        StLog.d(TAG, "removeBrEdrBond");
        BluetoothDevice bluetoothDevice = StarryDeviceManager.getInstance().getBluetoothDevice(stDevice);
        if (bluetoothDevice != null) {
            return BrEdrDeviceManager.removeBrEdrBond(bluetoothDevice);
        }
        StLog.d(TAG, "device null");
        return false;
    }

    private void retryConnectBrEdr(StConnectDevice stConnectDevice) {
        connect(stConnectDevice.getDevice());
        this.mRetryTimes++;
    }

    private void sendMsg(StDevice stDevice, byte[] bArr) {
        IMessageChannel messageChannel = StarryNetChannelManager.getInstance().getMessageChannel(stDevice, 1);
        if (messageChannel == null) {
            StLog.i(TAG, "sendMsg channel is null");
        } else {
            messageChannel.sendMsg(stDevice, bArr, 10);
        }
    }

    private void trackConnect(StDevice stDevice) {
        TrackerManager.getInstance().getBluetoothConnectionTracker().startConnectBt(stDevice.getTerminalType(), stDevice.getIdentifier2String());
    }

    public void clearPhoneBook() {
        this.mManager.clearPhoneBook();
    }

    public int connect(StDevice stDevice) {
        BluetoothDevice bluetoothDevice = StarryDeviceManager.getInstance().getBluetoothDevice(stDevice);
        if (bluetoothDevice == null) {
            StLog.d(TAG, "device null");
            return -1;
        }
        if (stDevice.getTerminalType() == 6 && this.mRetryTimes == 0) {
            this.mRetryTimes = 1;
        }
        try {
            trackConnect(stDevice);
            this.mManager.connectBrEdr(bluetoothDevice);
            return 0;
        } catch (Exception e) {
            StLog.w(TAG, "connect", (Throwable) e);
            return -2;
        }
    }

    public void dial(BluetoothDevice bluetoothDevice, String str) {
        this.mManager.dial(bluetoothDevice, str);
    }

    public int disconnect(StDevice stDevice) {
        BluetoothDevice bluetoothDevice = StarryDeviceManager.getInstance().getBluetoothDevice(stDevice);
        if (bluetoothDevice == null || !stDevice.isBrEdrConnected()) {
            StLog.d(TAG, "device null or bredr is disconnect");
            return 0;
        }
        this.mManager.disconnectBrEdr(bluetoothDevice);
        return 1;
    }

    public BluetoothDevice getActiveDevice() {
        return this.mManager.getActiveDevice();
    }

    public Map<BluetoothDevice, Integer> getBrEdrConnectedDeviceList() {
        return this.mManager.getBrEdrConnectedDeviceList();
    }

    public Map<String, Integer> getCallList() {
        return this.mManager.getCallList();
    }

    public void initListener() {
        this.mManager.registerActionStateListener(this);
        this.mManager.registerConnectStateListener(this);
    }

    public void onActiveDeviceChanged(BluetoothDevice bluetoothDevice, int i) {
        IBrEdrActionStateCallback iBrEdrActionStateCallback = this.mActionCallback;
        if (iBrEdrActionStateCallback != null) {
            iBrEdrActionStateCallback.onActiveDeviceChanged(bluetoothDevice, i);
        }
    }

    public void onBrEdrBondStateChanged(BluetoothDevice bluetoothDevice, int i, int i2) {
        StConnectDevice connectDeviceByBrEdrMac = StarryDeviceManager.getInstance().getConnectDeviceByBrEdrMac(bluetoothDevice.getAddress());
        if (connectDeviceByBrEdrMac == null) {
            connectDeviceByBrEdrMac = StarryDeviceManager.getInstance().getCurIosDevice();
            String name = bluetoothDevice.getName();
            if (connectDeviceByBrEdrMac == null || !connectDeviceByBrEdrMac.isPreConnect()) {
                StLog.i(TAG, "onBrEdrBondStateChanged bond info is null");
                return;
            }
            StLog.d(TAG, "onBrEdrBondStateChanged, ios preConnect identifier = " + connectDeviceByBrEdrMac.getIdentifier2String() + ", bredr mac = " + bluetoothDevice.getAddress());
            if (TextUtils.isEmpty(connectDeviceByBrEdrMac.getDeviceName()) || !name.equals(connectDeviceByBrEdrMac.getDeviceName())) {
                StLog.w(TAG, "during ios preConnect, other bt device (%s), trigger bond state changed ", name);
                return;
            }
            connectDeviceByBrEdrMac.setBrEdrMac(bluetoothDevice.getAddress());
        }
        if (StarryNetData.getInstance().getOwnDevice().getTerminalType() != 3 && connectDeviceByBrEdrMac.getTerminalType() != 3) {
            int bondState = getBondState(i);
            int bondState2 = getBondState(i2);
            int type = bluetoothDevice.getType();
            connectDeviceByBrEdrMac.setBluetoothDeviceType(type);
            if (connectDeviceByBrEdrMac.getTerminalType() == 6 && type == 2) {
                StLog.d(TAG, "is ios device & is ble device ,will not update bond state");
            } else {
                StarryDeviceManager.getInstance().updateBrEdrBondState(connectDeviceByBrEdrMac, bondState, bondState2);
            }
            IChannelCallback iChannelCallback = this.mCallback;
            if (iChannelCallback != null) {
                iChannelCallback.onBrEdrBondStateChange(connectDeviceByBrEdrMac, bondState, bondState2);
            }
        }
    }

    public void onBrEdrProfileConnectStateChanged(BluetoothDevice bluetoothDevice, int i, int i2) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bluetoothDevice);
        if (connectDevice == null) {
            StLog.d(TAG, "onBrEdrProfileConnectStateChanged device is null");
        } else if (StarryNetData.getInstance().getOwnDevice().getTerminalType() != 3 && connectDevice.getTerminalType() != 3) {
            if (i == 1) {
                i = 128;
            } else if (i == 2) {
                i = 256;
            }
            if (i2 == 2) {
                if (!connectDevice.isProtocolConnected(128) && !connectDevice.isProtocolConnected(256)) {
                    StLog.d(TAG, "Connect bredr acl : " + connectDevice.getDeviceName());
                    connectDevice.setBrEdrMac(bluetoothDevice.getAddress());
                    IChannelCallback iChannelCallback = this.mCallback;
                    if (iChannelCallback != null) {
                        iChannelCallback.onConnected(connectDevice, this);
                    }
                    if (connectDevice.getTerminalType() == 6) {
                        sendMsg(connectDevice.getDevice(), StarryNetEncryptHelper.generateBtStateChangeData(64, connectDevice));
                        this.mRetryTimes = 0;
                    }
                }
                StarryDeviceManager.getInstance().deviceConnected(connectDevice, i);
                if (connectDevice.getTerminalType() == 6) {
                    sendMsg(connectDevice.getDevice(), StarryNetEncryptHelper.generateBtStateChangeData(i, connectDevice));
                    return;
                }
                return;
            }
            StarryDeviceManager.getInstance().deviceDisconnected(connectDevice, i);
            if (!connectDevice.isProtocolConnected(128) && !connectDevice.isProtocolConnected(256)) {
                StLog.d(TAG, "Disconnect bredr acl : " + connectDevice.getDeviceName());
                IChannelCallback iChannelCallback2 = this.mCallback;
                if (iChannelCallback2 != null) {
                    iChannelCallback2.onDisconnected(connectDevice, this);
                }
                if (connectDevice.getTerminalType() == 6) {
                    StLog.d(TAG, "Disconnect ios acl: mRetryTimes = " + this.mRetryTimes + " profile = " + i);
                    int i3 = this.mRetryTimes;
                    if (i3 <= 0) {
                        sendMsg(connectDevice.getDevice(), StarryNetEncryptHelper.generateBtStateChangeData(-64, connectDevice));
                    } else if (i3 >= 1 || !connectDevice.isBleConnected() || connectDevice.getBleBondStatus() != 4 || connectDevice.getBrEdrBondStatus() != 48) {
                        sendMsg(connectDevice.getDevice(), StarryNetEncryptHelper.generateBtStateChangeData(-256, connectDevice));
                    } else {
                        retryConnectBrEdr(connectDevice);
                    }
                }
            }
        }
    }

    public void onBrEdrServiceReady() {
        StLog.d(TAG, "onBrEdrServiceReady");
        Map<BluetoothDevice, Integer> brEdrConnectedDeviceList = this.mManager.getBrEdrConnectedDeviceList();
        if (brEdrConnectedDeviceList != null) {
            for (Map.Entry next : brEdrConnectedDeviceList.entrySet()) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) next.getKey();
                StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bluetoothDevice);
                if (connectDevice != null) {
                    if (connectDevice.getTerminalType() != 3 && StarryNetData.getInstance().getOwnDevice().getTerminalType() != 3) {
                        connectDevice.setBrEdrMac(bluetoothDevice.getAddress());
                        if ((((Integer) next.getValue()).intValue() & 512) != 0) {
                            StarryDeviceManager.getInstance().deviceConnected(connectDevice, 64);
                        }
                        if ((((Integer) next.getValue()).intValue() & 1024) != 0) {
                            StarryDeviceManager.getInstance().deviceConnected(connectDevice, 128);
                        }
                        if ((((Integer) next.getValue()).intValue() & 2048) != 0) {
                            StarryDeviceManager.getInstance().deviceConnected(connectDevice, 256);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void onCallStateChanged(String str, int i) {
        IBrEdrActionStateCallback iBrEdrActionStateCallback = this.mActionCallback;
        if (iBrEdrActionStateCallback != null) {
            iBrEdrActionStateCallback.onCallStateChanged(str, i);
        }
    }

    public void onPullPhoneBookChanged(int i) {
        IBrEdrActionStateCallback iBrEdrActionStateCallback = this.mActionCallback;
        if (iBrEdrActionStateCallback != null) {
            iBrEdrActionStateCallback.onPullPhoneBookChanged(i);
        }
    }

    public void operateCallAction(BluetoothDevice bluetoothDevice, int i) {
        this.mManager.operateCallAction(bluetoothDevice, i);
    }

    public void pullPhoneBook(BluetoothDevice bluetoothDevice) {
        this.mManager.pullPhoneBook(bluetoothDevice);
    }

    public int removeAudioActiveDevice() {
        return this.mManager.removeAudioActiveDevice();
    }

    public void setActionCallback(IBrEdrActionStateCallback iBrEdrActionStateCallback) {
        this.mActionCallback = iBrEdrActionStateCallback;
    }

    public void setCallback(IChannelCallback iChannelCallback) {
        StLog.d(TAG, "setCallback" + iChannelCallback);
        this.mCallback = iChannelCallback;
    }

    public void setDiscoverableTimeout(int i) {
        StLog.d(TAG, "setDiscoverableTimeout timeout = " + i);
        BrEdrDeviceManager.setDiscoverableTimeout(i);
    }

    public void setScanMode(int i) {
        BrEdrDeviceManager.setScanMode(i);
    }

    public int switchAudioPlayDevice(BluetoothDevice bluetoothDevice) {
        return this.mManager.switchAudioPlayDevice(bluetoothDevice);
    }

    public int disconnect(BluetoothDevice bluetoothDevice) {
        this.mManager.disconnectBrEdr(bluetoothDevice);
        return 0;
    }
}
