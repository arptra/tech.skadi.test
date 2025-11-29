package com.upuphone.starrynet.strategy.connector.manager;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;
import com.upuphone.starrynet.api.IPublisher;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.StTestConstant;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.core.ble.SystemActionObserver;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.OpenGattServerEvent;
import com.upuphone.starrynet.core.ble.server.BleServerManager;
import com.upuphone.starrynet.core.ble.server.GattServerConfig;
import com.upuphone.starrynet.core.ble.server.reponse.OpenServerResponse;
import com.upuphone.starrynet.core.ble.utils.BluetoothLog;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.core.bredr.BrEdrDeviceManager;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.bredr.BrEdrChannel;
import com.upuphone.starrynet.strategy.connector.ConnectStateChecker;
import com.upuphone.starrynet.strategy.connector.IStarryNetConnector;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import com.upuphone.starrynet.strategy.message.channelmanager.ClientChannelManager;
import com.upuphone.starrynet.strategy.protocol.IProtocol;
import com.upuphone.starrynet.strategy.protocol.IProtocolCallback;
import com.upuphone.starrynet.strategy.protocol.ProtocolManager;
import com.upuphone.starrynet.strategy.protocol.simpleble.MyvuRingBleProtocol;
import com.upuphone.starrynet.strategy.protocol.simpleble.SimpleBleProtocol;
import com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocol;
import java.nio.charset.StandardCharsets;
import java.util.List;

@SuppressLint({"MissingPermission"})
public abstract class StarryNetConnector extends SysActionManager.StateChangeSimpleCallback implements IStarryNetConnector, IProtocolCallback {
    protected static final int DELAY_TIME_CONNECT_P2P_WIFI_ENABLE = 200;
    protected static final int PROTOCOL_SYNC_DELAY = 5000;
    private static final String TAG = "StarryNetConnector";
    protected final ConnectStateChecker mChecker;
    protected Context mContext = StarryNetData.getInstance().getApplicationContext();
    protected MyvuRingBleProtocol mMyvuRingBleProtocol;
    private int mOwnDeviceTerminalType;
    protected boolean mReConnectBle = true;
    protected SimpleBleProtocol mSimpleBleProtocol;
    protected StarryNetProtocol mStarryNetProtocol;

    public StarryNetConnector() {
        StarryNetProtocol starryNetProtocol = ProtocolManager.getInstance().getStarryNetProtocol();
        this.mStarryNetProtocol = starryNetProtocol;
        starryNetProtocol.setProtocolCallback(this);
        this.mStarryNetProtocol.regRemoveDeviceBroadcast(this.mContext);
        this.mChecker = new ConnectStateChecker();
        initBleGattServer();
        syncBluetoothBondInfo();
        SysActionManager.getInstance().registerSysAction(this);
        this.mOwnDeviceTerminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
    }

    private boolean checkIfOwnTypeIsXr() {
        boolean z = this.mOwnDeviceTerminalType == 2;
        if (z && this.mSimpleBleProtocol == null) {
            SimpleBleProtocol simpleProtocol = ProtocolManager.getInstance().getSimpleProtocol();
            this.mSimpleBleProtocol = simpleProtocol;
            if (simpleProtocol == null) {
                StLog.w(TAG, "is ring device ,but cannot find SimpleBleProtocol object");
                return false;
            }
        }
        return z;
    }

    private boolean checkIfOwnTypeIsfPhone() {
        int i = this.mOwnDeviceTerminalType;
        boolean z = true;
        if (!(i == 1 || i == 4)) {
            z = false;
        }
        if (z && this.mMyvuRingBleProtocol == null) {
            MyvuRingBleProtocol myvuRingBleProtocol = ProtocolManager.getInstance().getMyvuRingBleProtocol();
            this.mMyvuRingBleProtocol = myvuRingBleProtocol;
            if (myvuRingBleProtocol == null) {
                StLog.w(TAG, "is ring device ,but cannot find MyvuRingBleProtocol object");
                return false;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public void rebootBluetooth() {
        final BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            defaultAdapter.disable();
            SystemActionObserver.getInstance().registerSystemActionCallback(new SystemActionObserver.SystemActionChangedCallback() {
                public boolean onBluetoothStateChange(boolean z) {
                    if (z) {
                        return true;
                    }
                    StLog.d(StarryNetConnector.TAG, "get bluetooth disable event, then reopen bluetooth");
                    defaultAdapter.enable();
                    SystemActionObserver.getInstance().unregisterSystemActionCallback(this);
                    return true;
                }
            });
        }
    }

    private void trackRemoveBond(StDevice stDevice) {
        TrackerManager.getInstance().getUnpairDeviceTracker().startUnpair(stDevice.getTerminalType(), stDevice.getIdentifier2String()).way(2);
    }

    public void cancelAuth(StDevice stDevice) {
        this.mStarryNetProtocol.cancelAuth(stDevice);
    }

    public void connectBle(StDevice stDevice) {
        if (!isRingDevice(stDevice)) {
            StLog.d(TAG, "no support connectBle");
            this.mStarryNetProtocol.connect(stDevice, 2);
        } else if (checkIfOwnTypeIsXr()) {
            StLog.d(TAG, "start connect ble 2 RingDevice");
            this.mSimpleBleProtocol.connect(stDevice, 22);
        } else if (checkIfOwnTypeIsfPhone()) {
            this.mMyvuRingBleProtocol.connect(stDevice, 25);
        }
    }

    public void connectBrEdr(StDevice stDevice) {
        if (stDevice == null || !SysActionManager.getInstance().isBtOn()) {
            StLog.e(TAG, "connectBrEdr: device is null or bt is off");
            return;
        }
        StLog.d(TAG, "connectBrEdr");
        this.mStarryNetProtocol.connect(stDevice, 21);
    }

    public void connectSpp(StDevice stDevice) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice.isSppClient()) {
            this.mStarryNetProtocol.connect(stDevice, 23);
        } else if (connectDevice.isSppServer()) {
            this.mStarryNetProtocol.connect(stDevice, 24);
        } else {
            StarryDeviceManager.getInstance().connectFail(stDevice, StErrorCode.CONNECT_CORE_SPP_ROLE_NOT_RECOGNIZED, 32);
        }
    }

    public void connectUsb(StDevice stDevice) {
    }

    public void createBond(StDevice stDevice) {
        if (isRingDevice(stDevice)) {
            StLog.d(TAG, "start createBond  is not support for RingDevice");
        } else {
            this.mStarryNetProtocol.createBond(stDevice);
        }
    }

    public void createBondBrEdr(StDevice stDevice) {
        if (stDevice == null || !SysActionManager.getInstance().isBtOn()) {
            StLog.e(TAG, "createBrEdrBond: device is null or bt is off");
            return;
        }
        StLog.d(TAG, "createBrEdrBond");
        BluetoothDevice bluetoothDevice = StarryDeviceManager.getInstance().getBluetoothDevice(stDevice);
        if (bluetoothDevice == null) {
            StLog.d(TAG, "device null");
        } else if (stDevice.getTerminalType() == 2) {
            BrEdrDeviceManager.invokeCreateBrEdrBond(bluetoothDevice);
        } else {
            BrEdrDeviceManager.createBrEdrBond(bluetoothDevice);
        }
    }

    public void dealBluetoothDisconnect(final StConnectDevice stConnectDevice) {
        StLog.d(TAG, "dealBluetoothDisconnect");
        if (stConnectDevice != null) {
            final StDevice device = stConnectDevice.getDevice();
            if (device.isP2pConnected()) {
                this.mChecker.executeConnectDelay(new Runnable() {
                    public void run() {
                        if ((!stConnectDevice.isProtocolConnected(64) || !stConnectDevice.isBleConnected()) && stConnectDevice.isP2pConnected()) {
                            StarryNetConnector.this.disconnectP2p(device);
                        }
                    }
                }, 5000);
            }
        }
    }

    public void disconnectBle(StDevice stDevice, boolean z) {
        if (!isRingDevice(stDevice)) {
            StLog.d(TAG, "disconnectBle");
            this.mStarryNetProtocol.disconnect(stDevice, 2);
        } else if (checkIfOwnTypeIsXr()) {
            StLog.d(TAG, "start disconnectBle ble 2 RingDevice");
            this.mSimpleBleProtocol.disconnect(stDevice, 22);
        } else if (checkIfOwnTypeIsfPhone()) {
            this.mMyvuRingBleProtocol.disconnect(stDevice, 25);
        }
    }

    public void disconnectBrEdr(StDevice stDevice) {
        if (stDevice == null || !SysActionManager.getInstance().isBtOn()) {
            StLog.e(TAG, "disconnectBrEdr: device is null or bt is off");
            return;
        }
        StLog.d(TAG, "disconnectBrEdr");
        if (StarryDeviceManager.getInstance().getBluetoothDevice(stDevice) == null || !stDevice.isBrEdrConnected()) {
            StLog.d(TAG, "device null or bredr is disconnect");
            return;
        }
        if (stDevice.isBleConnected()) {
            disconnectBle(stDevice, false);
        }
        this.mStarryNetProtocol.disconnect(stDevice, 21);
    }

    public void disconnectP2p(StDevice stDevice, boolean z) {
    }

    public void disconnectP2pByUser(StDevice stDevice) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier2String());
        if (connectDevice != null && connectDevice.isP2pPublish()) {
            StLog.d(TAG, "disconnectP2pByUser device = " + stDevice.getIdentifier2String());
            this.mStarryNetProtocol.sendP2pMsg(connectDevice, StarryNetEncryptHelper.generateActiveDisconnectP2p());
        }
    }

    public void disconnectSpp(StDevice stDevice) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice.isSppClient()) {
            this.mStarryNetProtocol.disconnect(stDevice, 23);
        } else if (connectDevice.isSppServer()) {
            this.mStarryNetProtocol.disconnect(stDevice, 24);
        }
    }

    public void disconnectUsb(StDevice stDevice) {
    }

    public int getDeviceConnectable(StDevice stDevice) {
        return StErrorCode.CONNECT_APP_SUCCESS;
    }

    public void initBleGattServer() {
        ClientChannelManager.getInstance();
        if (!BluetoothUtils.isBleSupported()) {
            StLog.e(TAG, "device not support ble function");
        } else if (!BluetoothUtils.isBluetoothEnabled()) {
            StLog.e(TAG, "bluetooth not open!!!");
        } else {
            BleServerManager.getInstance().init(new GattServerConfig());
            initProtocol();
            BleServerManager.getInstance().openServer(new OpenServerResponse() {
                public void onResponse(int i, Void voidR) {
                    boolean z = false;
                    if (i == -24) {
                        if (StarryNetData.getInstance().isBleServer()) {
                            StLog.d(StarryNetConnector.TAG, "StarryNet 重启，重启蓝牙");
                            StarryNetConnector.this.rebootBluetooth();
                        } else {
                            i = 0;
                        }
                    }
                    BluetoothLog.log(StarryNetConnector.TAG, "open gatt server success(%s), code=%d", String.valueOf(i == 0), Integer.valueOf(i));
                    BleEventBus bleEventBus = BleEventBus.get();
                    if (i == 0) {
                        z = true;
                    }
                    bleEventBus.post(new OpenGattServerEvent(z));
                }
            });
        }
    }

    public void initProtocol() {
        this.mStarryNetProtocol.init();
    }

    public boolean isRingDevice(StDevice stDevice) {
        return stDevice.getTerminalType() == 5;
    }

    public boolean isSupportRingDevice() {
        return false;
    }

    public void onBleServerConnected(StConnectDevice stConnectDevice) {
        if (stConnectDevice == null) {
            StLog.d(TAG, "onBleServerConnected info is null");
        } else {
            StLog.d(TAG, "onBleServerConnected : %s name : %s", stConnectDevice.getBleMac(), stConnectDevice.getDeviceName());
        }
    }

    public void onBleServerDisconnected(StConnectDevice stConnectDevice) {
        if (stConnectDevice == null) {
            StLog.d(TAG, "onBleServerDisconnected connectDevice is null");
            return;
        }
        StLog.d(TAG, "onBleServerDisconnected : %s name : %s", stConnectDevice.getBleMac(), stConnectDevice.getDeviceName());
        dealBluetoothDisconnect(stConnectDevice);
    }

    public void onBluetoothDisabled() {
        StLog.d(TAG, "onBluetoothDisabled");
        for (StConnectDevice next : StarryDeviceManager.getInstance().getConnectedDevices()) {
            if (next.getDevice().isBrEdrConnected()) {
                StarryDeviceManager.getInstance().deviceDisconnected(next, 64);
            }
        }
        this.mReConnectBle = true;
    }

    public void onBluetoothEnabled() {
        StLog.d(TAG, "onBluetoothEnabled");
        StLog.d(TAG, StTestConstant.POINT_BLE_BT_ENABLED);
        initBleGattServer();
        syncBluetoothBondInfo();
    }

    public void onBluetoothNameChange(String str) {
        StLog.d(TAG, "onBluetoothNameChange, name = " + str);
        List<StConnectDevice> connectedDevices = StarryDeviceManager.getInstance().getConnectedDevices();
        if (connectedDevices.size() > 0) {
            for (StConnectDevice device : connectedDevices) {
                this.mStarryNetProtocol.sendStarryNetMsg(device.getDevice(), StarryNetEncryptHelper.generateAdapterNameChange(str.getBytes(StandardCharsets.UTF_8)));
            }
        }
    }

    public void onConnected(StConnectDevice stConnectDevice, int i, IProtocol iProtocol) {
        if ((iProtocol instanceof StarryNetProtocol) && i == 1) {
            onBleServerConnected(stConnectDevice);
        }
    }

    public void onDisconnected(StConnectDevice stConnectDevice, int i, IProtocol iProtocol) {
        if ((iProtocol instanceof StarryNetProtocol) && i == 1) {
            onBleServerDisconnected(stConnectDevice);
        }
    }

    public IPublisher.IHandler registerPublisher(IPublisher iPublisher) {
        return this.mStarryNetProtocol.registerPublisher(iPublisher);
    }

    public void removeBond(StDevice stDevice) {
        StLog.d(TAG, "removeBond " + stDevice.getDeviceName());
        if (!isRingDevice(stDevice)) {
            trackRemoveBond(stDevice);
            this.mStarryNetProtocol.removeBond(stDevice);
        } else if (checkIfOwnTypeIsXr()) {
            StLog.d(TAG, "start removeBond  RingDevice");
            this.mSimpleBleProtocol.removeBond(stDevice);
        } else if (checkIfOwnTypeIsfPhone()) {
            StLog.d(TAG, "start removeBond MYVU RingDevice");
            this.mMyvuRingBleProtocol.removeBond(stDevice);
        }
    }

    public void removeBondBrEdr(StDevice stDevice) {
        if (stDevice == null || !SysActionManager.getInstance().isBtOn()) {
            StLog.e(TAG, "removeBrEdrBond: device is null or bt is off");
            return;
        }
        StLog.d(TAG, "removeBrEdrBond");
        BrEdrChannel.removeBondBrEdr(stDevice);
    }

    public void requestAuth(StDevice stDevice, byte[] bArr) {
        this.mStarryNetProtocol.requestAuth(stDevice, bArr);
    }

    public void setDefaultPort(int i) {
        this.mStarryNetProtocol.setDefaultPort(i);
    }

    public boolean starryNetStackActionCmd(int i, Bundle bundle, StDevice stDevice) {
        return this.mStarryNetProtocol.starryNetStackActionCmd(i, bundle, stDevice != null ? StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier()) : null);
    }

    public void syncBluetoothBondInfo() {
        StLog.d(TAG, "syncBluetoothBondInfo");
    }
}
