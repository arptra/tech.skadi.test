package com.upuphone.starrynet.third.manager;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;
import com.meizu.common.widget.CircularProgressButton;
import com.upuphone.starrynet.api.IPublisher;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.core.bredr.BrEdrDeviceManager;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.bredr.BrEdrChannel;
import com.upuphone.starrynet.strategy.connector.IStarryNetConnector;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import com.upuphone.starrynet.strategy.message.channelmanager.ClientChannelManager;
import com.upuphone.starrynet.strategy.protocol.IProtocol;
import com.upuphone.starrynet.strategy.protocol.IProtocolCallback;
import com.upuphone.starrynet.strategy.protocol.simpleble.MyvuRingBleProtocol;
import com.upuphone.starrynet.strategy.protocol.starrynet.PhoneStarryNetProtocol;
import com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocol;
import com.upuphone.starrynet.strategy.utils.AppUtil;
import com.upuphone.starrynet.strategy.utils.BleUtil;
import com.upuphone.starrynet.strategy.utils.Ring2TrackUtils;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ThirdStarryNetConnector implements IStarryNetConnector, IProtocolCallback {
    private static final String TAG = "3rdNetConnector";
    private final Context mContext = StarryNetData.getInstance().getApplicationContext();
    private final MyvuRingBleProtocol mMyvuRingBleProtocol;
    /* access modifiers changed from: private */
    public final StarryNetProtocol mProtocol;
    SysActionManager.StateChangeSimpleCallback mStateChangeSimpleCallback = new SysActionManager.StateChangeSimpleCallback() {
        public void onBluetoothEnabled() {
            StLog.d(ThirdStarryNetConnector.TAG, "onBluetoothEnabled");
            ThirdStarryNetConnector.this.syncBluetoothBondInfo();
        }

        public void onBluetoothNameChange(String str) {
            StLog.d(ThirdStarryNetConnector.TAG, "onBluetoothNameChange, name = " + str);
            List<StConnectDevice> bleConnectedDevices = StarryDeviceManager.getInstance().getBleConnectedDevices();
            if (bleConnectedDevices.size() > 0) {
                for (StConnectDevice device : bleConnectedDevices) {
                    ThirdStarryNetConnector.this.mProtocol.sendStarryNetMsg(device.getDevice(), StarryNetEncryptHelper.generateAdapterNameChange(str.getBytes(StandardCharsets.UTF_8)));
                }
            }
        }

        public void onWiFiDisabled() {
            for (StConnectDevice next : StarryDeviceManager.getInstance().getConnectedDevices()) {
                if (next != null) {
                    StDevice device = next.getDevice();
                    if (device.isBleConnected()) {
                        ThirdStarryNetConnector.this.mProtocol.sendStarryNetMsg(device, StarryNetEncryptHelper.generateNotifyWifiDisable());
                    }
                }
            }
        }
    };

    public ThirdStarryNetConnector() {
        PhoneStarryNetProtocol phoneStarryNetProtocol = new PhoneStarryNetProtocol();
        this.mProtocol = phoneStarryNetProtocol;
        this.mMyvuRingBleProtocol = new MyvuRingBleProtocol();
        phoneStarryNetProtocol.setProtocolCallback(this);
        ClientChannelManager.getInstance();
        SysActionManager.getInstance().registerSysAction(this.mStateChangeSimpleCallback);
        syncBluetoothBondInfo();
    }

    private void trackRemoveBond(StDevice stDevice) {
        TrackerManager.getInstance().getUnpairDeviceTracker().startUnpair(stDevice.getTerminalType(), stDevice.getIdentifier2String()).way(2);
    }

    public void cancelAuth(StDevice stDevice) {
    }

    public void connectAp(StDevice stDevice) {
    }

    public void connectBle(StDevice stDevice) {
        int connect = this.mProtocol.connect(stDevice.clone(), stDevice.getTerminalType() == 5 ? 25 : 1);
        if (connect != 0) {
            StarryDeviceManager.getInstance().connectFail(stDevice, connect, 1);
        }
    }

    @SuppressLint({"MissingPermission"})
    public void connectBrEdr(StDevice stDevice) {
        BluetoothDevice bluetoothDevice = StarryDeviceManager.getInstance().getBluetoothDevice(stDevice);
        if (bluetoothDevice == null) {
            StLog.d(TAG, "connectBrEdr fail");
        } else if (bluetoothDevice.getBondState() == 12) {
            StLog.d(TAG, "connectBrEdr(bonded), do protocol connect");
            this.mProtocol.connect(stDevice, 20);
        } else if (2 == stDevice.getTerminalType()) {
            StLog.d(TAG, "connectBrEdr ->invoke createBond");
            BrEdrDeviceManager.invokeCreateBrEdrBond(bluetoothDevice);
        } else {
            StLog.d(TAG, "connectBrEdr ->createBond");
            bluetoothDevice.createBond();
        }
    }

    public void connectP2p(StDevice stDevice) {
        if (stDevice == null) {
            StLog.d(TAG, "connectP2p StDevice is null");
            return;
        }
        boolean isWlanOn = SysActionManager.getInstance().isWlanOn();
        boolean isLocServiceEnable = AppUtil.isLocServiceEnable(this.mContext);
        StLog.d(TAG, "createP2pGroup, wifi open=" + isWlanOn + ",location service open=" + isLocServiceEnable);
        if (isLocServiceEnable && isWlanOn) {
            this.mProtocol.connect(stDevice, 10);
        }
    }

    public void connectSpp(StDevice stDevice) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice.isSppClient()) {
            this.mProtocol.connect(stDevice, 23);
        } else if (connectDevice.isSppServer()) {
            this.mProtocol.connect(stDevice, 24);
        }
    }

    public void connectUsb(StDevice stDevice) {
    }

    public void createBond(StDevice stDevice) {
        this.mProtocol.createBond(stDevice);
    }

    public void createBondBrEdr(StDevice stDevice) {
    }

    public void dealBluetoothConnect(StConnectDevice stConnectDevice) {
        StLog.d(TAG, "dealBluetoothConnect");
        if (stConnectDevice == null) {
            StLog.w(TAG, "dealBluetoothConnect, device is null return!");
            return;
        }
        StDevice device = stConnectDevice.getDevice();
        if (device == null || device.getTerminalType() != 2) {
            StLog.w(TAG, "dealBluetoothConnect, terminal type not xr, return!");
        } else if (!device.isBrEdrConnected()) {
            connectBrEdr(device);
        } else {
            String brEdrMac = StarryNetData.getInstance().getOwnDevice().getBrEdrMac();
            StLog.d(TAG, "getBrEdrMac = " + brEdrMac);
            if (BleUtil.DEFAULT_ADDRESS.equals(brEdrMac)) {
                this.mProtocol.sendStarryNetMsg(device, StarryNetEncryptHelper.generate3rdBrEdrMac(new byte[0]));
            }
        }
    }

    public void dealConnectP2P(StConnectDevice stConnectDevice, IProtocol iProtocol) {
        StLog.d(TAG, "dealConnectP2P:" + stConnectDevice);
        if (iProtocol instanceof StarryNetProtocol) {
            connectP2p(stConnectDevice.getDevice());
        }
    }

    public void disconnectAp(StDevice stDevice) {
    }

    public void disconnectBle(StDevice stDevice, boolean z) {
        this.mProtocol.disconnect(stDevice, 1);
    }

    public void disconnectBrEdr(StDevice stDevice) {
    }

    public void disconnectP2p(StDevice stDevice, boolean z) {
    }

    public void disconnectSpp(StDevice stDevice) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice.isSppClient()) {
            this.mProtocol.disconnect(stDevice, 23);
        } else if (connectDevice.isSppServer()) {
            this.mProtocol.disconnect(stDevice, 24);
        } else {
            StarryDeviceManager.getInstance().connectFail(stDevice, StErrorCode.CONNECT_CORE_SPP_ROLE_NOT_RECOGNIZED, 32);
        }
    }

    public void disconnectUsb(StDevice stDevice) {
    }

    public int getDeviceConnectable(StDevice stDevice) {
        return StErrorCode.CONNECT_APP_SUCCESS;
    }

    public void onConnected(StConnectDevice stConnectDevice, int i, IProtocol iProtocol) {
        if (i == 2 || i == 64) {
            dealBluetoothConnect(stConnectDevice);
        }
    }

    public void onDisconnected(StConnectDevice stConnectDevice, int i, IProtocol iProtocol) {
        if (i == 2) {
            this.mProtocol.stopSppChannel(stConnectDevice, 23);
        }
    }

    public IPublisher.IHandler registerPublisher(IPublisher iPublisher) {
        return null;
    }

    public void removeBond(StDevice stDevice) {
        StLog.d(TAG, "removeBond");
        trackRemoveBond(stDevice);
        this.mProtocol.removeBond(stDevice);
    }

    public void removeBondBrEdr(StDevice stDevice) {
    }

    public void requestAuth(StDevice stDevice, byte[] bArr) {
    }

    public void setDefaultPort(int i) {
        this.mProtocol.setDefaultPort(i);
    }

    public boolean starryNetStackActionCmd(int i, Bundle bundle, StDevice stDevice) {
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public void syncBluetoothBondInfo() {
        BluetoothAdapter defaultAdapter;
        if (BluetoothUtils.isBluetoothEnabled()) {
            List<StConnectDevice> connectDeviceByTerminal = StarryDeviceManager.getInstance().getConnectDeviceByTerminal(2);
            List<StConnectDevice> connectDeviceByTerminal2 = StarryDeviceManager.getInstance().getConnectDeviceByTerminal(5);
            if (connectDeviceByTerminal == null && connectDeviceByTerminal2 == null) {
                StLog.d(TAG, "syncBluetoothBondInfo bondedDeviceList is null");
                return;
            }
            StLog.d(TAG, "syncBluetoothBondInfo v2");
            if (connectDeviceByTerminal != null) {
                for (StConnectDevice next : connectDeviceByTerminal) {
                    int brEdrBondState = BrEdrChannel.getBrEdrBondState(next.getDevice());
                    int bleBondStatus = next.getBleBondStatus();
                    int status = next.getStatus() & CircularProgressButton.MorphingAnimation.DURATION_NORMAL;
                    StLog.d(TAG, next.getDeviceName() + " st ble state=" + bleBondStatus + ",st br state=" + status + ",BluetoothDevice br state=" + brEdrBondState);
                    if (bleBondStatus == 4 && status == 32) {
                        if (brEdrBondState == 12) {
                            StLog.d(TAG, "syncBluetoothBondInfo ble bonded, br bonding, bluetoothDevice br bonded, then sync StConnectDevice to br bonded ");
                            StarryDeviceManager.getInstance().updateBondInfo(next, 48);
                        } else if (brEdrBondState == 10) {
                            StLog.d(TAG, "syncBluetoothBondInfo ble bonded, br bonding, bluetoothDevice br not bonded, then sync StConnectDevice to unbonded ");
                            StarryDeviceManager.getInstance().updateBondInfo(next, 0);
                        }
                    } else if (bleBondStatus == 4 && brEdrBondState == 10) {
                        StarryDeviceManager.getInstance().updateBondInfo(next, 16);
                    } else if (bleBondStatus == 0 && brEdrBondState == 12) {
                        BrEdrChannel.removeBondBrEdr(next.getDevice());
                    }
                }
            }
            if (connectDeviceByTerminal2 != null && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null && defaultAdapter.isEnabled()) {
                for (StConnectDevice next2 : connectDeviceByTerminal2) {
                    if (BluetoothAdapter.checkBluetoothAddress(next2.getBleMac())) {
                        BluetoothDevice remoteDevice = defaultAdapter.getRemoteDevice(next2.getBleMac());
                        if (next2.getBleBondStatus() == 4 && remoteDevice.getBondState() == 10) {
                            StLog.d(TAG, "ring " + next2.getDeviceName() + " is already been removed bond");
                            Ring2TrackUtils.trackStartRemoveBond(next2.getDevice(), 4);
                            StarryDeviceManager.getInstance().updateBondInfo(next2, 0);
                        }
                    }
                }
            }
        }
    }

    public void disconnectP2p(StDevice stDevice) {
        this.mProtocol.disconnect(stDevice, 10);
    }
}
