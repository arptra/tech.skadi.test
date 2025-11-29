package com.upuphone.starrynet.strategy.connector.manager;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.channel.IMessageCallback;
import com.upuphone.starrynet.strategy.config.CarConfigs;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairRecord;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import com.upuphone.starrynet.strategy.protocol.IProtocol;
import com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocol;
import com.upuphone.starrynet.strategy.utils.AppUtil;
import java.util.HashSet;
import java.util.Set;

@RequiresApi
public class PadStarryNetConnector extends StarryNetConnector {
    private static final int DELAY_TIME_CONNECT_P2P_WIFI_ENABLE = 200;
    private static final String TAG = "PadStarryNetConnector";
    /* access modifiers changed from: private */
    public final Set<StDevice> mWaitConnectP2pDevices = new HashSet();

    public PadStarryNetConnector() {
        StLog.d(TAG, "PadStarryNetConnector init");
    }

    private boolean needAsGCRole(StConnectDevice stConnectDevice) {
        return CarConfigs.MODEL_NAME_CAR_EX11.equals(stConnectDevice.getModelName()) || CarConfigs.MODEL_NAME_CAR_145.equals(stConnectDevice.getModelName()) || stConnectDevice.getConnectVersion() >= 3;
    }

    public void connectAp(StDevice stDevice) {
        if (stDevice == null) {
            StLog.d(TAG, "connectAp StDevice is null");
        } else {
            this.mStarryNetProtocol.connect(stDevice, 13);
        }
    }

    public void connectBle(StDevice stDevice) {
        StarryNetData.getInstance().getDiscoveryManager().disableFastConnect();
        int connect = this.mStarryNetProtocol.connect(stDevice.clone(), 1);
        if (connect != 0) {
            StarryDeviceManager.getInstance().connectFail(stDevice, connect, 1);
        }
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

    public void disconnectAp(StDevice stDevice) {
        if (stDevice == null) {
            StLog.d(TAG, "disconnectAp StDevice is null");
        } else {
            this.mStarryNetProtocol.disconnect(stDevice, 13);
        }
    }

    public void disconnectBle(final StDevice stDevice, boolean z) {
        StConnectDevice connectDevice;
        StLog.d(TAG, "disconnectBle");
        if (stDevice != null && SysActionManager.getInstance().isBtOn() && (connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier())) != null && connectDevice.isBleConnected()) {
            if (z) {
                this.mStarryNetProtocol.sendStarryNetMsg(stDevice, StarryNetEncryptHelper.generateDisconnectBle(), new IMessageCallback() {
                    public void onResult(int i) {
                        PadStarryNetConnector.this.mStarryNetProtocol.disconnect(stDevice, 1);
                        FastPairRecord.getInstance().setActiveDisconnectPad(stDevice.getIdentifier2String());
                    }
                });
                return;
            }
            this.mStarryNetProtocol.disconnect(stDevice, 1);
        }
    }

    public void disconnectP2p(StDevice stDevice) {
        if (StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier2String()) != null) {
            this.mStarryNetProtocol.disconnect(stDevice, 11);
        }
    }

    public void initProtocol() {
        super.initProtocol();
    }

    public boolean isSupportRingDevice() {
        return true;
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
                            if ((PadStarryNetConnector.this.mWaitConnectP2pDevices.remove(device) || device.getTerminalType() == 3) && device.getDeviceType() == 1) {
                                PadStarryNetConnector.this.connectP2p(device);
                            }
                        }
                    }
                }
                PadStarryNetConnector.this.mWaitConnectP2pDevices.clear();
            }
        }, 200);
    }

    public void removeBond(StDevice stDevice) {
        StConnectDevice connectDevice;
        StLog.d(TAG, "removeBond");
        if (stDevice != null && stDevice.getTerminalType() == 3 && (connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier())) != null) {
            boolean isBleConnected = stDevice.isBleConnected();
            super.removeBond(stDevice);
            if ((isBleConnected && (connectDevice.isP2pConnected() || StarryDeviceManager.getInstance().getP2pConnectedDevices().isEmpty())) || !connectDevice.isP2pPublish()) {
                disconnectP2p(stDevice);
            }
        }
    }

    public void disconnectP2p(StDevice stDevice, boolean z) {
        StConnectDevice connectDevice;
        if (stDevice != null && (connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier2String())) != null) {
            if (!z || !SysActionManager.getInstance().isBtOn() || !SysActionManager.getInstance().isWlanOn() || !connectDevice.isP2pPublish()) {
                this.mStarryNetProtocol.disconnect(stDevice, 11);
                return;
            }
            disconnectP2pByUser(stDevice);
            FastPairRecord.getInstance().setActiveDisconnectPad(stDevice.getIdentifier2String());
        }
    }
}
