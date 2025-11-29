package com.upuphone.starrynet.strategy.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.here.odnp.config.OdnpConfigStatic;
import com.upuphone.starrynet.api.IDirectConnectCallBack;
import com.upuphone.starrynet.api.IPublisher;
import com.upuphone.starrynet.api.IStarryConnectCallback;
import com.upuphone.starrynet.api.StBroadcast;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.StTestConstant;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.api.manager.IStarryConnectManager;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.TrackManagerUtils;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.common.utils.tracker.detail.BluetoothConnectionTracker;
import com.upuphone.starrynet.core.ap.WiFiApInfo;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.bredr.BrEdrDeviceManager;
import com.upuphone.starrynet.core.p2p.bean.GoInfo;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.connector.IStarryNetConnector;
import com.upuphone.starrynet.strategy.data.IAuthCallback;
import com.upuphone.starrynet.strategy.data.IConnectCallback;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.IStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.discovery.mdns.DirectConnector;
import com.upuphone.starrynet.strategy.operater.StarryNetOperator;

public class StarryConnectManager implements IConnectCallback, IAuthCallback, IStarryConnectManager {
    private static final int DELAY_TIME_BLE_UN_BOND = 500;
    private static final int DELAY_TIME_DISCONNECT_BR_EDR = 500;
    private static final String TAG = "StarryConnectManager";
    private IStarryConnectCallback mConnectCallback;
    private final IStarryNetConnector mConnectManager;
    private GoInfo mGoInfo;

    public StarryConnectManager(IStarryNetConnector iStarryNetConnector) {
        this.mConnectManager = iStarryNetConnector;
        StarryNetData.getInstance().setConnectMgr(iStarryNetConnector);
        StarryDeviceManager.getInstance().addConnectCallback(this);
        StarryDeviceManager.getInstance().addAuthCallback(this);
    }

    private int getDeviceConnectVersion(byte[] bArr) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bArr);
        if (connectDevice != null) {
            return connectDevice.getConnectVersion();
        }
        StDiscoveryDevice discoveryDevice = StarryDeviceManager.getInstance().getDiscoveryDevice(bArr);
        if (discoveryDevice != null) {
            return discoveryDevice.getConnectVersion();
        }
        return 2;
    }

    private void notifyConnectedDevice() {
        for (StConnectDevice next : StarryDeviceManager.getInstance().getConnectedDevices()) {
            StDevice device = next.getDevice();
            if (next.isProtocolConnected(1)) {
                onBleServerConnected(device);
            }
            if (next.isProtocolConnected(2)) {
                onBleConnected(device);
            }
            if (next.isProtocolConnected(4)) {
                onP2pGoConnected(device);
            }
            if (next.isProtocolConnected(8)) {
                onP2pGcConnected(next.getPort(), next.getAddress(), device);
            }
            if (device.isBrEdrConnected()) {
                onConnected(512, device);
            }
        }
    }

    private void notifyGoInfo() {
        IStarryConnectCallback iStarryConnectCallback;
        GoInfo goInfo = this.mGoInfo;
        if (goInfo != null && (iStarryConnectCallback = this.mConnectCallback) != null) {
            iStarryConnectCallback.onP2pGoCreated(goInfo.getPort(), this.mGoInfo.getAddress());
        }
    }

    private void onApConnected(StDevice stDevice, String str) {
        StLog.d(TAG, "onApConnected device = " + stDevice + " ip = " + str);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onApConnected callback is null");
        } else {
            iStarryConnectCallback.onApConnected(stDevice, str);
        }
    }

    private void onApDisconnected(StDevice stDevice) {
        StLog.d(TAG, "onApDisconnected " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onApDisconnected callback is null");
        } else {
            iStarryConnectCallback.onApDisconnected(stDevice);
        }
    }

    private void onBleConnected(StDevice stDevice) {
        StLog.d(TAG, StTestConstant.POINT_BLE_CONNECT_END);
        StLog.d(TAG, "onBleConnected device = " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onBleConnected callback is null");
            return;
        }
        iStarryConnectCallback.onBleConnected(stDevice);
        TrackManagerUtils.trackBleConnectEndSuccess();
    }

    private void onBleDisconnected(StDevice stDevice) {
        StLog.d(TAG, "onBleDisconnected device = " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onBleDisconnected callback is null");
        } else {
            iStarryConnectCallback.onBleDisconnected(stDevice);
        }
    }

    private void onBleServerConnected(StDevice stDevice) {
        StLog.d(TAG, "onBleServerConnected, point_ble_connect_end device = " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onBleServerConnected callback is null");
        } else {
            iStarryConnectCallback.onBleServerConnected(stDevice);
        }
    }

    private void onBleServerDisconnected(StDevice stDevice) {
        StLog.d(TAG, "onBleServerDisconnected device = " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onBleServerDisconnected callback is null");
        } else {
            iStarryConnectCallback.onBleServerDisconnected(stDevice);
        }
    }

    private void onP2pGcConnected(int i, String str, StDevice stDevice) {
        StLog.d(TAG, "onP2pGcConnected device = " + stDevice + " ip = " + str + " port = " + i);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onP2pGcConnected callback is null");
        } else {
            iStarryConnectCallback.onP2pGcConnected(i, str, stDevice);
        }
    }

    private void onP2pGcDisconnected(StDevice stDevice) {
        StLog.d(TAG, "onP2pGcDisconnected device = " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onP2pGcDisconnected callback is null");
        } else {
            iStarryConnectCallback.onP2pGcDisconnected(stDevice);
        }
    }

    private void onP2pGoConnected(StDevice stDevice) {
        StLog.d(TAG, "onP2pGoConnected device = " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onP2pGoConnected callback is null");
            return;
        }
        iStarryConnectCallback.onP2pGoConnected(stDevice);
        TrackManagerUtils.trackP2pConnectTime(false);
        TrackManagerUtils.trackP2pConnectSuccessRateSuccess();
    }

    private void onP2pGoDisconnected(StDevice stDevice) {
        StLog.d(TAG, "onP2pGoDisconnected device = " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onP2pGoDisconnected callback is null");
        } else {
            iStarryConnectCallback.onP2pGoDisconnected(stDevice);
        }
    }

    private void onSppClientConnected(StDevice stDevice) {
        StLog.d(TAG, "onSppClientConnected device = " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onSppClientConnected callback is null");
        } else {
            iStarryConnectCallback.onSppClientConnected(stDevice);
        }
    }

    private void onSppClientDisconnected(StDevice stDevice) {
        StLog.d(TAG, "onSppClientDisconnected device = " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onSppClientDisconnected callback is null");
        } else {
            iStarryConnectCallback.onSppClientDisconnected(stDevice);
        }
    }

    private void onSppServerConnected(StDevice stDevice) {
        StLog.d(TAG, "onSppServerConnected device = " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onSppServerConnected callback is null");
        } else {
            iStarryConnectCallback.onSppServerConnected(stDevice);
        }
    }

    private void onSppServerDisconnected(StDevice stDevice) {
        StLog.d(TAG, "onSppServerDisconnected device = " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onSppServerDisconnected callback is null");
        } else {
            iStarryConnectCallback.onSppServerDisconnected(stDevice);
        }
    }

    private void onStaConnected(StDevice stDevice, String str, int i) {
        StLog.d(TAG, "onStaConnected device = " + stDevice + "ip = " + str);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onStaConnected callback is null");
        } else {
            iStarryConnectCallback.onStaConnected(i, str, stDevice);
        }
    }

    private void onStaDisconnected(StDevice stDevice) {
        StLog.d(TAG, "onStaDisconnected " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onStaDisconnected callback is null");
        } else {
            iStarryConnectCallback.onStaDisconnected(stDevice);
        }
    }

    private void sendConnectionStateBroadcast(StConnectDevice stConnectDevice, int i, boolean z) {
        Intent intent = new Intent();
        intent.setAction(StBroadcast.ACTION_STARRY_NET_CONNECTION_STATE_CHANGED);
        intent.putExtra(StBroadcast.EXTRA_DEVICE_ID, stConnectDevice.getIdentifier2String());
        intent.putExtra(StBroadcast.EXTRA_TERMINAL_TYPE, stConnectDevice.getTerminalType());
        intent.putExtra(StBroadcast.EXTRA_CONNECT_CHANNEL, i);
        intent.putExtra(StBroadcast.EXTRA_CONNECT_STATE, z);
        StarryNetData.getInstance().getApplicationContext().sendBroadcast(intent);
    }

    private void trackDeviceMatchConnection(StDevice stDevice) {
        byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null || connectDevice.getBleBondStatus() != 4) {
            boolean z = true;
            BluetoothConnectionTracker start = TrackerManager.getInstance().getBluetoothConnectionTracker().start(true, stDevice.getTerminalType(), stDevice.getIdentifier2String());
            if (terminalType == 2) {
                z = false;
            }
            start.isPhone(z);
        }
    }

    public int cancelAuth(byte[] bArr) {
        StDevice device = StarryDeviceManager.getInstance().getDevice(bArr);
        if (device == null) {
            StLog.d(TAG, "cancelAuth, no bondInfo for address = " + Utils.bytesToHexString(bArr));
            return StErrorCode.CONNECT_APP_DEVICE_NULL;
        }
        StLog.i(TAG, "cancelAuth " + device);
        try {
            this.mConnectManager.cancelAuth(device);
            return StErrorCode.CONNECT_APP_SUCCESS;
        } catch (Exception e) {
            StLog.e(TAG, "cancelAuth error : " + e);
            return StErrorCode.CONNECT_APP_SUCCESS;
        }
    }

    public int connect(StDevice stDevice, int i) {
        byte b;
        StLog.i(TAG, "connect " + stDevice + ", type = " + i);
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        StDiscoveryDevice discoveryDevice = StarryDeviceManager.getInstance().getDiscoveryDevice(stDevice.getIdentifier());
        if (discoveryDevice != null && ownDevice.getTerminalType() == 1 && getDeviceConnectVersion(stDevice.getIdentifier()) < 3) {
            byte[] bArr = discoveryDevice.getDeviceDetail().get((byte) 15);
            byte[] bArr2 = discoveryDevice.getDeviceDetail().get((byte) 4);
            byte b2 = -1;
            if (bArr != null) {
                StLog.d(TAG, "peer bond state is not null");
                b = bArr[0];
            } else {
                b = -1;
            }
            if (bArr2 != null) {
                StLog.d(TAG, "peer connect state is not null");
                b2 = bArr2[0];
            }
            if (Byte.toUnsignedInt(discoveryDevice.getAdvType()) != 64 && b2 == 2 && b == 4) {
                IStarryNetDiscoverer discoveryManager = StarryNetData.getInstance().getDiscoveryManager();
                if (discoveryManager == null) {
                    return StErrorCode.CONNECT_APP_ONGOING;
                }
                discoveryManager.requestConnect(stDevice.getIdentifier(), OdnpConfigStatic.OEM_MAX_HIGH_POWER_INTERVAL);
                return StErrorCode.CONNECT_APP_ONGOING;
            }
        }
        if ((i & 1) != 0) {
            StLog.d(TAG, StTestConstant.POINT_BLE_CONNECT_START);
            trackDeviceMatchConnection(stDevice);
            this.mConnectManager.connectBle(stDevice);
        }
        if ((i & 16) != 0) {
            this.mConnectManager.connectUsb(stDevice);
        }
        if ((i & 2) != 0) {
            this.mConnectManager.connectP2p(stDevice);
        }
        if ((i & 4) != 0) {
            this.mConnectManager.connectAp(stDevice);
        }
        if ((i & 8) != 0) {
            this.mConnectManager.connectBrEdr(stDevice);
        }
        if ((i & 32) == 0) {
            return StErrorCode.CONNECT_APP_SUCCESS;
        }
        this.mConnectManager.connectSpp(stDevice);
        return StErrorCode.CONNECT_APP_SUCCESS;
    }

    public int createBond(byte[] bArr) {
        StDevice device = StarryDeviceManager.getInstance().getDevice(bArr);
        if (device == null) {
            StLog.d(TAG, "createBond, no bondInfo for address = " + Utils.bytesToHexString(bArr));
            return StErrorCode.CONNECT_APP_DEVICE_NULL;
        }
        StLog.i(TAG, "createBond " + device);
        try {
            this.mConnectManager.createBond(device);
            return StErrorCode.CONNECT_APP_SUCCESS;
        } catch (Exception e) {
            StLog.e(TAG, "createBond error : " + e);
            return StErrorCode.CONNECT_APP_SUCCESS;
        }
    }

    public int disconnect(StDevice stDevice, int i) {
        StLog.i(TAG, "disconnect " + stDevice + ", type = " + i);
        if (i == 2) {
            this.mConnectManager.disconnectP2p(stDevice);
        } else if ((i & 2) != 0) {
            this.mConnectManager.disconnectP2p(stDevice, true);
        }
        if ((i & 4) != 0) {
            this.mConnectManager.disconnectAp(stDevice);
        }
        if ((i & 1) != 0) {
            this.mConnectManager.disconnectBle(stDevice, true);
        }
        if ((i & 16) != 0) {
            this.mConnectManager.disconnectUsb(stDevice);
            StLog.i(TAG, "disconnectUsb iccoa not support");
        }
        if ((i & 8) != 0) {
            StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
            if ((i == -1 && (ownDevice.getTerminalType() == 3 || stDevice.getTerminalType() == 3)) || stDevice.getTerminalType() == 2) {
                return StErrorCode.CONNECT_APP_SUCCESS;
            }
            this.mConnectManager.disconnectBrEdr(stDevice);
        }
        if ((i & 32) != 0) {
            this.mConnectManager.disconnectSpp(stDevice);
        }
        return StErrorCode.CONNECT_APP_SUCCESS;
    }

    public int getDeviceConnectable(byte[] bArr) {
        StDevice device = StarryDeviceManager.getInstance().getDevice(bArr);
        if (device == null) {
            StLog.d(TAG, "getDeviceConnectable device null, id = " + Utils.bytesToHexString(bArr));
            return StErrorCode.CONNECT_APP_DEVICE_NULL;
        }
        StLog.i(TAG, "getDeviceConnectable, deviceId = " + Utils.bytes2HexString(bArr));
        return this.mConnectManager.getDeviceConnectable(device);
    }

    public void onApCreated(WiFiApInfo wiFiApInfo) {
        StLog.d(TAG, "onApCreated " + wiFiApInfo);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onApCreated callback is null");
        } else {
            iStarryConnectCallback.onApCreated(wiFiApInfo.getPort());
        }
    }

    public void onApRemoved() {
        StLog.d(TAG, "onApRemoved");
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onApRemoved callback is null");
        } else {
            iStarryConnectCallback.onApRemoved();
        }
    }

    public void onAuth(StDevice stDevice) {
        StLog.d(TAG, "onAuth " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onAuth callback is null");
        } else {
            iStarryConnectCallback.onAuth(stDevice);
        }
    }

    public void onAuthMessage(StDevice stDevice, byte[] bArr) {
        int deviceConnectable = getDeviceConnectable(stDevice.getIdentifier());
        StLog.d(TAG, "onAuthMessage " + stDevice + ", authCode = " + deviceConnectable);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onAuthMessage callback is null");
        } else {
            iStarryConnectCallback.onAuthMessage(stDevice, bArr, deviceConnectable);
        }
    }

    public void onBondStateChanged(StConnectDevice stConnectDevice, final int i, final int i2) {
        StarryNetOperator operateManager;
        if (stConnectDevice == null) {
            StLog.d(TAG, "onDisconnected device is null");
            return;
        }
        byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
        if (i < 16 || terminalType == 2 || stConnectDevice.getTerminalType() == 2) {
            final StDevice device = stConnectDevice.getDevice();
            if (i == 0) {
                if (terminalType == 2 && (operateManager = StarryNetData.getInstance().getOperateManager()) != null) {
                    operateManager.clearPhoneBook();
                }
                byte terminalType2 = device.getTerminalType();
                if (terminalType2 == 6) {
                    if (BrEdrDeviceManager.removeBrEdrBond(StarryDeviceManager.getInstance().getBluetoothDevice(device))) {
                        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
                            public void run() {
                                StarryConnectManager.this.onBondStateChanged(device, i, i2);
                            }
                        }, 500);
                        return;
                    }
                    StLog.d(TAG, "removeBrEdrBond result is false");
                }
                if (terminalType == 2 || terminalType2 == 2) {
                    StLog.d(TAG, "removeBrEdrBond");
                    if (BrEdrDeviceManager.removeBrEdrBond(StarryDeviceManager.getInstance().getBluetoothDevice(device))) {
                        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
                            public void run() {
                                StarryConnectManager.this.onBondStateChanged(device, i, i2);
                            }
                        }, 500);
                        return;
                    }
                }
            }
            onBondStateChanged(device, i, i2);
        }
    }

    public void onConnectFail(StDevice stDevice, int i, int i2) {
        StLog.d(TAG, "onConnectFail device = " + stDevice + " code = " + i + " profile = " + i2);
        if (i < 0) {
            StLog.d(TAG, "onConnectFail internal, not callback");
            return;
        }
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onConnectFail callback is null");
            return;
        }
        iStarryConnectCallback.onConnectFail(i2, stDevice, i);
        if (StarryNetData.getInstance().getOwnDevice().getTerminalType() != 1) {
            return;
        }
        if (i2 == 1) {
            TrackManagerUtils.trackBleConnectEndFail(String.valueOf(i));
        } else if (i2 == 2) {
            TrackManagerUtils.trackP2pConnectSuccessRateFail(String.valueOf(i));
        }
    }

    public void onConnected(StConnectDevice stConnectDevice, int i) {
        if (stConnectDevice == null) {
            StLog.d(TAG, "onConnected device is null");
            return;
        }
        sendConnectionStateBroadcast(stConnectDevice, i, true);
        StDevice device = stConnectDevice.getDevice();
        if (i == 1) {
            onBleServerConnected(device);
        } else if (i == 2) {
            onBleConnected(device);
        } else if (i == 4) {
            onP2pGoConnected(device);
        } else if (i == 8) {
            onP2pGcConnected(stConnectDevice.getPort(), stConnectDevice.getAddress(), device);
        } else if (i == 16) {
            onApConnected(device, stConnectDevice.getAddress());
        } else if (i == 32) {
            onStaConnected(device, stConnectDevice.getAddress(), stConnectDevice.getPort());
        } else if (i == 64) {
            onConnected(512, device);
        } else if (i == 128) {
            onConnected(1024, device);
        } else if (i == 256) {
            onConnected(2048, device);
        } else if (i == 512) {
            onConnected(16, device);
        } else if (i == 1024) {
            onSppServerConnected(device);
        } else if (i == 2048) {
            onSppClientConnected(device);
        }
    }

    public void onDisconnected(StConnectDevice stConnectDevice, int i) {
        if (stConnectDevice == null) {
            StLog.d(TAG, "onDisconnected device is null");
            return;
        }
        sendConnectionStateBroadcast(stConnectDevice, i, false);
        StDevice device = stConnectDevice.getDevice();
        if (i == 1) {
            onBleServerDisconnected(device);
        } else if (i == 2) {
            onBleDisconnected(device);
        } else if (i == 4) {
            onP2pGoDisconnected(device);
        } else if (i == 8) {
            onP2pGcDisconnected(device);
        } else if (i == 16) {
            onApDisconnected(device);
        } else if (i == 32) {
            onStaDisconnected(device);
        } else if (i == 64) {
            onDisconnected(512, device);
        } else if (i == 128) {
            onDisconnected(1024, device);
        } else if (i == 256) {
            onDisconnected(2048, device);
        } else if (i == 512) {
            onDisconnected(16, device);
        } else if (i == 1024) {
            onSppServerDisconnected(device);
        } else if (i != 2048) {
            StLog.d(TAG, "onDisconnected profile param error");
        } else {
            onSppClientDisconnected(device);
        }
    }

    public void onP2pGoCreated(GoInfo goInfo) {
        StLog.d(TAG, "onP2pGoCreated");
        this.mGoInfo = goInfo;
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onP2pGoCreated callback is null");
        } else {
            iStarryConnectCallback.onP2pGoCreated(goInfo.getPort(), goInfo.getAddress());
        }
    }

    public void onP2pGoRemoved() {
        StLog.d(TAG, "onP2pGoRemoved");
        this.mGoInfo = null;
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onP2pGoRemoved callback is null");
        } else {
            iStarryConnectCallback.onP2pGoRemoved();
        }
    }

    public IPublisher.IHandler registerPublisher(IPublisher iPublisher) {
        StLog.i(TAG, "registerPublisher ");
        return this.mConnectManager.registerPublisher(iPublisher);
    }

    public int removeBond(byte[] bArr) {
        StDevice device = StarryDeviceManager.getInstance().getDevice(bArr);
        if (device == null) {
            StLog.d(TAG, "removeBond, no device for address = " + Utils.bytesToHexString(bArr));
            return StErrorCode.CONNECT_APP_DEVICE_NULL;
        }
        StLog.i(TAG, "removeBond " + device);
        try {
            if (device.getTerminalType() == 2 && !StarryDeviceManager.getInstance().clearDiscoveryDevice() && !device.isBleConnected()) {
                StLog.w(TAG, "reconnecting may already happen, try disconnect: %s", device.getDeviceName());
                BleConnectManager.getInstance().disconnect(device.getBleMac());
            }
            this.mConnectManager.removeBond(device);
            return StErrorCode.CONNECT_APP_SUCCESS;
        } catch (Exception e) {
            StLog.e(TAG, "removeBond error : " + e);
            return StErrorCode.CONNECT_APP_SUCCESS;
        }
    }

    public void removeConnectionStateChangeCallback() {
        StLog.d(TAG, "removeConnectionStateChangeCallback");
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback != null) {
            iStarryConnectCallback.onUnRegister();
            this.mConnectCallback = null;
        }
    }

    public void removeDirectConnectCallBack() {
        DirectConnector.getInstance().setCallBack((IDirectConnectCallBack) null);
    }

    public int requestAuth(byte[] bArr, byte[] bArr2) {
        StDevice device = StarryDeviceManager.getInstance().getDevice(bArr);
        if (device == null) {
            StLog.d(TAG, "requestAuth, no bondInfo for address = " + Utils.bytesToHexString(bArr));
            return StErrorCode.CONNECT_APP_DEVICE_NULL;
        }
        StLog.i(TAG, "requestAuth " + device);
        try {
            this.mConnectManager.requestAuth(device, bArr2);
            return StErrorCode.CONNECT_APP_SUCCESS;
        } catch (Exception e) {
            StLog.e(TAG, "requestAuth error : " + e);
            return StErrorCode.CONNECT_APP_SUCCESS;
        }
    }

    public void setConnectionStateChangeCallback(IStarryConnectCallback iStarryConnectCallback) {
        StLog.d(TAG, "setConnectionStateChangeCallback call = " + iStarryConnectCallback);
        if (iStarryConnectCallback != null) {
            this.mConnectCallback = iStarryConnectCallback;
            iStarryConnectCallback.onRegister();
            this.mConnectCallback.reportOwnDevice(StarryNetData.getInstance().getOwnDevice());
            notifyGoInfo();
            notifyConnectedDevice();
        }
    }

    public void setDefaultPort(int i) {
        StLog.i(TAG, "setDefaultPort " + i);
        this.mConnectManager.setDefaultPort(i);
    }

    public void setDirectConnectCallBack(IDirectConnectCallBack iDirectConnectCallBack) {
        DirectConnector.getInstance().setCallBack(iDirectConnectCallBack);
    }

    public boolean starryNetStackActionCmd(int i, Bundle bundle, StDevice stDevice) {
        return this.mConnectManager.starryNetStackActionCmd(i, bundle, stDevice);
    }

    /* access modifiers changed from: private */
    public void onBondStateChanged(StDevice stDevice, int i, int i2) {
        StLog.d(TAG, "onBondStateChanged device = " + stDevice + " state = " + Integer.toHexString(i));
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onBondStateChanged callback is null");
        } else {
            iStarryConnectCallback.onBondStateChanged(i, i2, stDevice);
        }
    }

    private void onConnected(int i, StDevice stDevice) {
        StLog.d(TAG, "onConnected, type = " + i + " device = " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onConnected callback is null");
        } else {
            iStarryConnectCallback.onConnected(i, stDevice);
        }
    }

    private void onDisconnected(int i, StDevice stDevice) {
        StLog.d(TAG, "onDisconnected type = " + i + " device = " + stDevice);
        IStarryConnectCallback iStarryConnectCallback = this.mConnectCallback;
        if (iStarryConnectCallback == null) {
            StLog.d(TAG, "onConnected callback is null");
        } else {
            iStarryConnectCallback.onDisconnected(i, stDevice);
        }
    }
}
