package com.upuphone.starrynet.strategy.connector.manager;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.core.bredr.BrEdrDeviceManager;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.channel.IMessageCallback;
import com.upuphone.starrynet.strategy.channel.bredr.BrEdrChannel;
import com.upuphone.starrynet.strategy.config.CarConfigs;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.IStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import com.upuphone.starrynet.strategy.protocol.IProtocol;
import com.upuphone.starrynet.strategy.protocol.ProtocolManager;
import com.upuphone.starrynet.strategy.protocol.iccoa.IccoaProtocol;
import com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocol;
import com.upuphone.starrynet.strategy.protocol.uupshare.UupShareProtocol;
import com.upuphone.starrynet.strategy.utils.AppUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiresApi
public class PhoneStarryNetConnector extends StarryNetConnector {
    private static final String TAG = "PhoneStarryNetConnector";
    private final IccoaProtocol mIccoaProtocol;
    private final UupShareProtocol mUupShareProtocol;
    /* access modifiers changed from: private */
    public final Set<StDevice> mWaitConnectP2pDevices = new HashSet();

    public PhoneStarryNetConnector() {
        StLog.d(TAG, "PhoneStarryNetConnector init");
        this.mUupShareProtocol = ProtocolManager.getInstance().getUupShareProtocol();
        IccoaProtocol iccoaProtocol = new IccoaProtocol(this.mContext);
        this.mIccoaProtocol = iccoaProtocol;
        iccoaProtocol.setProtocolCallback(this);
    }

    private boolean needAsGCRole(StConnectDevice stConnectDevice) {
        return stConnectDevice.getConnectVersion() >= 3 || CarConfigs.GC_ROLE_MODELS_4_PHONE.contains(stConnectDevice.getModelName());
    }

    public void connectAp(StDevice stDevice) {
        if (stDevice == null) {
            StLog.d(TAG, "connectAp StDevice is null");
        } else {
            this.mStarryNetProtocol.connect(stDevice, 13);
        }
    }

    public void connectBle(StDevice stDevice) {
        IStarryNetDiscoverer discoveryManager = StarryNetData.getInstance().getDiscoveryManager();
        StLog.d(TAG, "connectBle stopScan");
        discoveryManager.stopBleScan();
        discoveryManager.disableFastConnect();
        StDevice clone = stDevice.clone();
        if (clone.getDeviceType() == 2) {
            this.mUupShareProtocol.connect(clone);
            return;
        }
        StDiscoveryDevice discoveryDevice = StarryDeviceManager.getInstance().getDiscoveryDevice(stDevice.getIdentifier());
        if (discoveryDevice == null || discoveryDevice.getDeviceType() != 3) {
            int connect = clone.getTerminalType() == 5 ? this.mStarryNetProtocol.connect(clone, 25) : this.mStarryNetProtocol.connect(clone, 1);
            if (connect != 0) {
                StLog.w(TAG, "connect just fail: " + connect);
                StarryDeviceManager.getInstance().connectFail(stDevice, connect, 1);
                return;
            }
            return;
        }
        this.mIccoaProtocol.connect(discoveryDevice, 1);
    }

    public void connectBrEdr(StDevice stDevice) {
        if (stDevice == null || !SysActionManager.getInstance().isBtOn()) {
            StLog.e(TAG, "connectBrEdr: device is null or bt is off");
            return;
        }
        StLog.d(TAG, "connectBrEdr");
        this.mStarryNetProtocol.connect(stDevice, 20);
    }

    public void connectP2p(StDevice stDevice) {
        if (stDevice == null) {
            StLog.d(TAG, "connectP2p StDevice is null");
            return;
        }
        boolean isWlanOn = SysActionManager.getInstance().isWlanOn();
        boolean isLocServiceEnable = AppUtil.isLocServiceEnable(this.mContext);
        StLog.d(TAG, "connectP2p, wifi open=" + isWlanOn + ",location service open=" + isLocServiceEnable);
        if (!isLocServiceEnable && Build.VERSION.SDK_INT < 32) {
            return;
        }
        if (!isWlanOn) {
            SysActionManager.getInstance().enableWiFi();
            this.mWaitConnectP2pDevices.add(stDevice);
            return;
        }
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier2String());
        if (connectDevice != null) {
            if (needAsGCRole(connectDevice)) {
                int connect = this.mStarryNetProtocol.connect(stDevice, 11);
                if (connect != 0) {
                    StarryDeviceManager.getInstance().connectFail(stDevice, connect, 2);
                    return;
                }
                return;
            }
            int connect2 = this.mStarryNetProtocol.connect(stDevice, 10);
            if (connect2 != 0) {
                StarryDeviceManager.getInstance().connectFail(stDevice, connect2, 2);
            }
        }
    }

    public void connectUsb(StDevice stDevice) {
        StarryNetData.getInstance().getDiscoveryManager().disableFastConnect();
        StDevice clone = stDevice.clone();
        int connect = this.mIccoaProtocol.connect(clone, 3);
        if (connect != 112301) {
            StarryDeviceManager.getInstance().connectFail(clone, connect, 16);
        }
        StLog.i(TAG, "connectUsb iccoa not support");
    }

    @SuppressLint({"MissingPermission"})
    public void dealBluetoothConnect(StConnectDevice stConnectDevice) {
        StDevice device;
        if (stConnectDevice != null && (device = stConnectDevice.getDevice()) != null && device.getTerminalType() == 2 && !device.isBrEdrConnected()) {
            StLog.d(TAG, "dealBluetoothConnect, connect br edr");
            BluetoothDevice bluetoothDevice = StarryDeviceManager.getInstance().getBluetoothDevice(device);
            if (bluetoothDevice == null) {
                StLog.w(TAG, "bluetoothDevice is null");
            } else if (bluetoothDevice.getBondState() == 12) {
                connectBrEdr(device);
            } else {
                this.mChecker.checkBRState(stConnectDevice);
            }
        }
    }

    public void dealConnectP2P(StConnectDevice stConnectDevice, IProtocol iProtocol) {
        if (iProtocol instanceof StarryNetProtocol) {
            if (!needAsGCRole(stConnectDevice)) {
                connectP2p(stConnectDevice.getDevice());
            } else if (!AppUtil.isLocServiceEnable(this.mContext) && Build.VERSION.SDK_INT < 32) {
                StLog.d(TAG, "connectP2P networkName(%s,%d),location service not open ,then return!!!", stConnectDevice.getSsid(), Integer.valueOf(stConnectDevice.getFreq()));
            } else if (!SysActionManager.getInstance().isWlanOn()) {
                StLog.d(TAG, "connectP2P networkName(%s,%d),but wlan not open ,then return!!!", stConnectDevice.getSsid(), Integer.valueOf(stConnectDevice.getFreq()));
                SysActionManager.getInstance().enableWiFi();
            } else {
                this.mStarryNetProtocol.connectP2p(stConnectDevice);
            }
        }
    }

    public void disconnectAllConnection() {
        List<StConnectDevice> connectedDevices = StarryDeviceManager.getInstance().getConnectedDevices();
        StLog.d(TAG, "disconnectAllConnection, devices size =" + connectedDevices.size());
        for (StConnectDevice next : connectedDevices) {
            StDevice device = next.getDevice();
            if (next.isP2pConnected()) {
                disconnectP2p(device);
            }
            if (next.isSoftApConnected()) {
                disconnectAp(device);
            }
            if (next.isBleConnected()) {
                disconnectBle(device, false);
            }
        }
    }

    public void disconnectAp(StDevice stDevice) {
        if (stDevice == null) {
            StLog.d(TAG, "disconnectAp StDevice is null");
        } else {
            this.mStarryNetProtocol.disconnect(stDevice, 13);
        }
    }

    public void disconnectBle(final StDevice stDevice, boolean z) {
        StLog.d(TAG, "disconnectBle");
        if (stDevice != null && SysActionManager.getInstance().isBtOn()) {
            if (stDevice.getDeviceType() == 3) {
                this.mIccoaProtocol.disconnect(stDevice, 1);
                return;
            }
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
            if (connectDevice != null && connectDevice.isBleConnected()) {
                if (z) {
                    this.mStarryNetProtocol.sendStarryNetMsg(stDevice, StarryNetEncryptHelper.generateDisconnectBle(), new IMessageCallback() {
                        public void onResult(int i) {
                            PhoneStarryNetConnector.this.mStarryNetProtocol.disconnect(stDevice, 1);
                        }
                    });
                    return;
                }
                this.mStarryNetProtocol.disconnect(stDevice, 1);
            }
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
        } else {
            this.mStarryNetProtocol.disconnect(stDevice, 20);
        }
    }

    public void disconnectP2p(StDevice stDevice) {
        if (stDevice.getDeviceType() == 3) {
            this.mIccoaProtocol.disconnect(stDevice, 11);
            return;
        }
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier2String());
        if (connectDevice != null) {
            if (needAsGCRole(connectDevice)) {
                this.mStarryNetProtocol.disconnect(stDevice, 11);
            } else {
                this.mStarryNetProtocol.disconnect(stDevice, 10);
            }
        }
    }

    public void disconnectUsb(StDevice stDevice) {
        this.mIccoaProtocol.disconnect(stDevice, 3);
        StLog.i(TAG, "disconnectUsb iccoa not support");
    }

    public void initProtocol() {
        super.initProtocol();
        if (this.mUupShareProtocol != null && SysActionManager.getInstance().isUupShareOn()) {
            this.mUupShareProtocol.init();
        }
    }

    public boolean isSupportRingDevice() {
        return true;
    }

    public void onConnected(StConnectDevice stConnectDevice, int i, IProtocol iProtocol) {
        if (iProtocol instanceof StarryNetProtocol) {
            if (i == 2 || i == 64) {
                StLog.d(TAG, "onConnected : profile %d identifier = %s bleMac = %s name = %s", Integer.valueOf(i), stConnectDevice.getIdentifier2String(), stConnectDevice.getBleMac(), stConnectDevice.getDeviceName());
                dealBluetoothConnect(stConnectDevice);
            } else if (i != 1) {
            } else {
                if (stConnectDevice.getDeviceType() == 2) {
                    this.mUupShareProtocol.connectP2p(stConnectDevice.getSsid(), stConnectDevice.getPwd(), stConnectDevice.getFreq(), stConnectDevice.getPort(), stConnectDevice.getIdentifier());
                } else {
                    onBleServerConnected(stConnectDevice);
                }
            }
        }
    }

    public void onDisconnected(StConnectDevice stConnectDevice, int i, IProtocol iProtocol) {
        if (iProtocol instanceof StarryNetProtocol) {
            if (i == 2) {
                this.mChecker.cancelBRCheck(stConnectDevice);
                this.mStarryNetProtocol.stopSppChannel(stConnectDevice, 23);
            } else if (i == 1) {
                onBleServerDisconnected(stConnectDevice);
            }
        }
    }

    public void onUupShareDisabled() {
        UupShareProtocol uupShareProtocol = this.mUupShareProtocol;
        if (uupShareProtocol != null) {
            uupShareProtocol.disconnect();
        }
    }

    public void onWiFiDisabled() {
        for (StConnectDevice next : StarryDeviceManager.getInstance().getConnectedDevices()) {
            if (next != null) {
                StDevice device = next.getDevice();
                if (device.isBleConnected()) {
                    this.mStarryNetProtocol.sendStarryNetMsg(device, StarryNetEncryptHelper.generateNotifyWifiDisable());
                }
            }
        }
    }

    public void onWiFiEnabled() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                for (StConnectDevice next : StarryDeviceManager.getInstance().getConnectedDevices()) {
                    if (next != null) {
                        StDevice device = next.getDevice();
                        if (device.isBleConnected() && !device.isP2pConnected()) {
                            if ((PhoneStarryNetConnector.this.mWaitConnectP2pDevices.remove(device) || device.getTerminalType() == 3) && device.getDeviceType() == 1) {
                                PhoneStarryNetConnector.this.connectP2p(device);
                            }
                        }
                    }
                }
                PhoneStarryNetConnector.this.mWaitConnectP2pDevices.clear();
            }
        }, 200);
    }

    public void removeBond(StDevice stDevice) {
        StLog.d(TAG, "removeBond");
        super.removeBond(stDevice);
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice != null && connectDevice.getDevice().getTerminalType() == 3) {
            boolean isP2pConnected = connectDevice.isP2pConnected();
            boolean isEmpty = StarryDeviceManager.getInstance().getP2pConnectedDevices().isEmpty();
            StLog.d(TAG, "deviceConnected = " + isP2pConnected + ", connectedListEmpty = " + isEmpty);
            if (!isP2pConnected && !isEmpty) {
                return;
            }
            if (connectDevice.getConnectVersion() < 3 || !connectDevice.isP2pPublish()) {
                disconnectP2p(stDevice);
            }
        }
    }

    public void syncBluetoothBondInfo() {
        if (BluetoothUtils.isBluetoothEnabled()) {
            StLog.d(TAG, "syncBluetoothBondInfo");
            List<BluetoothDevice> bondDeviceList = BrEdrDeviceManager.getBondDeviceList();
            if (bondDeviceList != null) {
                for (BluetoothDevice address : bondDeviceList) {
                    StConnectDevice connectDeviceByBrEdrMac = StarryDeviceManager.getInstance().getConnectDeviceByBrEdrMac(address.getAddress());
                    if (!(connectDeviceByBrEdrMac == null || connectDeviceByBrEdrMac.getTerminalType() != 2 || connectDeviceByBrEdrMac.getBleBondStatus() == 4)) {
                        BrEdrChannel.removeBondBrEdr(connectDeviceByBrEdrMac.getDevice());
                    }
                }
            }
        }
    }

    public void disconnectP2p(StDevice stDevice, boolean z) {
        if (stDevice != null) {
            if (stDevice.getDeviceType() == 3) {
                this.mIccoaProtocol.disconnect(stDevice, 11);
                return;
            }
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier2String());
            if (connectDevice != null) {
                if (z && SysActionManager.getInstance().isBtOn() && SysActionManager.getInstance().isWlanOn() && connectDevice.getConnectVersion() > 2 && connectDevice.isP2pPublish()) {
                    disconnectP2pByUser(stDevice);
                } else if (needAsGCRole(connectDevice)) {
                    this.mStarryNetProtocol.disconnect(stDevice, 11);
                } else {
                    this.mStarryNetProtocol.disconnect(stDevice, 10);
                }
            }
        }
    }
}
