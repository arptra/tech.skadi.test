package com.upuphone.starrynet.strategy.connector.manager;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.common.utils.WifiUtil;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.core.bredr.BrEdrDeviceManager;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.channel.bredr.BrEdrChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.protocol.IProtocol;
import com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocol;
import com.upuphone.starrynet.strategy.utils.AppUtil;
import java.util.List;
import java.util.Objects;

@RequiresApi
public class XRStarryNetConnector extends StarryNetConnector {
    private static final int DELAY_TIME_RECONNECT_BR_EDR = 3000;
    private static final String TAG = "XRStarryNetConnector";
    /* access modifiers changed from: private */
    public byte[] mCacheDeviceId;

    private void dealBluetoothConnect(StConnectDevice stConnectDevice) {
        StLog.d(TAG, "dealBluetoothConnect for ios");
        if (stConnectDevice == null || stConnectDevice.getBrEdrMac() == null) {
            StLog.w(TAG, "deal ios BluetoothConnect, bredr mac is null");
        } else if (stConnectDevice.getBrEdrBondStatus() == 48 && !stConnectDevice.getDevice().isBrEdrConnected()) {
            BrEdrChannel brEdrChannel = (BrEdrChannel) StarryNetChannelManager.getInstance().getConnectChannel(21);
            BluetoothDevice activeDevice = brEdrChannel.getActiveDevice();
            if (activeDevice != null && !Objects.equals(stConnectDevice.getBrEdrMac(), activeDevice.getAddress())) {
                StLog.i(TAG, "deal ios BluetoothConnect, bredr mac difference!");
                brEdrChannel.disconnect(activeDevice);
            }
            connectBrEdr(stConnectDevice.getDevice());
        }
    }

    private void dealBondState(StConnectDevice stConnectDevice) {
        if (stConnectDevice.getTerminalType() != 6) {
            if (stConnectDevice.getBrEdrBondStatus() == 16 && stConnectDevice.getBleBondStatus() == 4) {
                StLog.i(TAG, "dealBondState br bond none, ble bond");
                if (stConnectDevice.getTerminalType() == 4) {
                    StLog.i(TAG, "third device, removeBond");
                    removeBond(stConnectDevice.getDevice());
                }
            } else if (stConnectDevice.getBleBondStatus() == 0 && stConnectDevice.getBrEdrBondStatus() == 48) {
                StLog.i(TAG, "dealBondState br bond, ble bond none");
                removeBondBrEdr(stConnectDevice.getDevice());
            }
        }
    }

    public void connectAp(StDevice stDevice) {
        if (stDevice == null) {
            StLog.d(TAG, "connectAp StDevice is null");
        } else {
            this.mStarryNetProtocol.connect(stDevice, 13);
        }
    }

    public void connectP2p(StDevice stDevice) {
        if (!AppUtil.isLocServiceEnable(this.mContext)) {
            StLog.w(TAG, "connectP2P, location service not open ,then return!!!");
        } else if (!SysActionManager.getInstance().isWlanOn()) {
            StLog.d(TAG, "connectP2P, but wlan not open, open wifi!!!");
            this.mCacheDeviceId = stDevice.getIdentifier();
            SysActionManager.getInstance().enableWiFi();
        } else {
            this.mStarryNetProtocol.connect(stDevice, 11);
        }
    }

    public void dealConnectP2P(StConnectDevice stConnectDevice, IProtocol iProtocol) {
        if (iProtocol instanceof StarryNetProtocol) {
            if (!AppUtil.isLocServiceEnable(this.mContext)) {
                StLog.w(TAG, "connectP2P networkName(%s,%d),location service not open ,then return!!!", stConnectDevice.getSsid(), Integer.valueOf(stConnectDevice.getFreq()));
            } else if (!SysActionManager.getInstance().isWlanOn()) {
                StLog.d(TAG, "connectP2P networkName(%s,%d), but wlan not open, open wifi!!!", stConnectDevice.getSsid(), Integer.valueOf(stConnectDevice.getFreq()));
                this.mCacheDeviceId = stConnectDevice.getIdentifier();
                SysActionManager.getInstance().enableWiFi();
            } else {
                this.mStarryNetProtocol.connectP2p(stConnectDevice);
            }
        }
    }

    public void disconnectAp(StDevice stDevice) {
        if (stDevice == null) {
            StLog.d(TAG, "connectAp StDevice is null");
        } else {
            this.mStarryNetProtocol.disconnect(stDevice, 13);
        }
    }

    public void disconnectP2p(StDevice stDevice) {
        this.mStarryNetProtocol.disconnect(stDevice, 11);
    }

    public boolean isSupportRingDevice() {
        return true;
    }

    public void onBleServerConnected(StConnectDevice stConnectDevice) {
        if (stConnectDevice.getTerminalType() == 6) {
            dealBluetoothConnect(stConnectDevice);
        }
        this.mStarryNetProtocol.startSppServerListen(stConnectDevice);
        if (SysActionManager.getInstance().isWlanOn()) {
            this.mStarryNetProtocol.sysP2pMacAddress(stConnectDevice, "");
        }
    }

    public void onBleServerDisconnected(StConnectDevice stConnectDevice) {
        super.onBleServerDisconnected(stConnectDevice);
        dealBondState(stConnectDevice);
        if (stConnectDevice.getTerminalType() == 6) {
            final StDevice device = stConnectDevice.getDevice();
            if (device.isApConnected()) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        if (!device.isBleConnected() && device.isApConnected()) {
                            XRStarryNetConnector.this.disconnectAp(device);
                        }
                    }
                }, 5000);
            }
        }
        this.mStarryNetProtocol.stopSppChannel(stConnectDevice, 24);
    }

    public void onConnected(StConnectDevice stConnectDevice, int i, IProtocol iProtocol) {
        super.onConnected(stConnectDevice, i, iProtocol);
        if (i == 8) {
            WifiUtil.disconnectWifi(this.mContext);
        }
    }

    public void onDisconnected(final StConnectDevice stConnectDevice, int i, IProtocol iProtocol) {
        super.onDisconnected(stConnectDevice, i, iProtocol);
        if (stConnectDevice.getTerminalType() == 6) {
            StLog.v(TAG, "ios do not need next operate!");
        } else if (i == 64) {
            dealBondState(stConnectDevice);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    if (stConnectDevice.isBleConnected() && stConnectDevice.getBrEdrBondStatus() == 48 && stConnectDevice.getBleBondStatus() == 4) {
                        XRStarryNetConnector.this.connectBrEdr(stConnectDevice.getDevice());
                    }
                }
            }, 3000);
        }
    }

    public void onWiFiDisabled() {
        super.onWiFiDisabled();
        this.mCacheDeviceId = null;
    }

    public void onWiFiEnabled() {
        super.onWiFiEnabled();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                StLog.d(XRStarryNetConnector.TAG, "when wifi enabled, delay 500ms operate p2p");
                byte[] access$000 = XRStarryNetConnector.this.mCacheDeviceId;
                byte[] unused = XRStarryNetConnector.this.mCacheDeviceId = null;
                for (StConnectDevice next : StarryDeviceManager.getInstance().getConnectedDevices()) {
                    if (next.isBleConnected() && !next.isP2pConnected() && next.getTerminalType() != 5) {
                        if (ByteUtils.equals(access$000, next.getIdentifier())) {
                            XRStarryNetConnector.this.mStarryNetProtocol.connect(next.getDevice(), 11);
                        } else {
                            XRStarryNetConnector.this.mStarryNetProtocol.sysP2pMacAddress(next, "");
                        }
                    }
                }
            }
        }, 500);
    }

    public void syncBluetoothBondInfo() {
        if (BluetoothUtils.isBluetoothEnabled()) {
            StLog.d(TAG, "syncBluetoothBondInfo");
            List<BluetoothDevice> bondDeviceList = BrEdrDeviceManager.getBondDeviceList();
            if (bondDeviceList != null) {
                for (BluetoothDevice address : bondDeviceList) {
                    StConnectDevice connectDeviceByBrEdrMac = StarryDeviceManager.getInstance().getConnectDeviceByBrEdrMac(address.getAddress());
                    if (!(connectDeviceByBrEdrMac == null || connectDeviceByBrEdrMac.getBleBondStatus() == 4)) {
                        StDevice device = connectDeviceByBrEdrMac.getDevice();
                        if (device.getTerminalType() == 6) {
                            disconnectBrEdr(device);
                            StarryDeviceManager.getInstance().updateBondInfo(connectDeviceByBrEdrMac, 0);
                        } else {
                            BrEdrChannel.removeBondBrEdr(device);
                        }
                    }
                }
            }
        }
    }
}
