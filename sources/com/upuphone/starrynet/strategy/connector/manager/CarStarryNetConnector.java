package com.upuphone.starrynet.strategy.connector.manager;

import android.os.Build;
import com.honey.account.e7.a;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.config.CarConfigs;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.IStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import com.upuphone.starrynet.strategy.protocol.IProtocol;
import com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocol;
import com.upuphone.starrynet.strategy.utils.AppUtil;
import com.upuphone.starrynet.strategy.utils.ThreadUtils;
import java.util.List;
import org.apache.commons.lang3.BooleanUtils;

public class CarStarryNetConnector extends StarryNetConnector {
    private static final int CAR_DELAY_TIME_CONNECT_P2P_WIFI_ENABLE = 50;
    private static final int MAX_WAIT_P2P_ENABLE_DURATION = 1500;
    private static final String TAG = "CarStarryNetConnector";

    private boolean needAsGoRole(StConnectDevice stConnectDevice) {
        return needAsGoRoleLite() || stConnectDevice.getConnectVersion() >= 3;
    }

    private boolean needAsGoRoleLite() {
        for (String isMatchModel : CarConfigs.GO_ROLE_MODELS_4_CAR) {
            if (StarryNetData.getInstance().isMatchModel(isMatchModel)) {
                return true;
            }
        }
        return false;
    }

    public void connectAp(StDevice stDevice) {
        if (stDevice == null) {
            StLog.d(TAG, "connectAp StDevice is null");
        } else {
            this.mStarryNetProtocol.connect(stDevice, 12);
        }
    }

    public void connectP2p(StDevice stDevice) {
        if (stDevice == null) {
            StLog.d(TAG, "connectP2p StDevice is null");
        } else if (!AppUtil.isLocServiceEnable(this.mContext) && Build.VERSION.SDK_INT < 32) {
            StLog.w(TAG, "connectP2P networkName(%s,%d),location service not open ,then return!!!");
        } else if (!SysActionManager.getInstance().isWlanOn()) {
            StLog.d(TAG, "connectP2P networkName(%s,%d),but wlan not open ,then return!!!");
            SysActionManager.getInstance().enableWiFi();
        } else {
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier2String());
            if (connectDevice != null) {
                if (needAsGoRole(connectDevice)) {
                    SysActionManager.getInstance().enableWiFi();
                    this.mStarryNetProtocol.connect(stDevice, 10);
                    return;
                }
                this.mStarryNetProtocol.connect(stDevice, 11);
            }
        }
    }

    /* renamed from: connectP2pUntilP2pEnable */
    public void lambda$connectP2pUntilP2pEnable$0(int i, int i2) {
        if (!SysActionManager.getInstance().isWlanOn()) {
            StLog.d(TAG, "connectP2pUntilP2pEnable ,check wifi off");
        } else if (SysActionManager.getInstance().isP2pEnable() || i2 >= 1500) {
            StLog.d(TAG, "connectP2pUntilP2pEnable wifi & p2p all enable");
            for (StConnectDevice next : StarryDeviceManager.getInstance().getConnectedDevices()) {
                if (next.isBleConnected() && !next.isP2pConnected()) {
                    if (needAsGoRole(next)) {
                        connectP2p(next.getDevice());
                    } else {
                        this.mStarryNetProtocol.connect(next.getDevice(), 11);
                    }
                }
            }
        } else {
            StLog.d(TAG, "connectP2pUntilP2pEnable wait " + i + "ms, check it");
            ThreadUtils.runOnUIThreadDelay(new a(this, i, i2 + i), (long) i);
        }
    }

    public void connectUsb(StDevice stDevice) {
    }

    public void dealBluetoothDisconnect(StConnectDevice stConnectDevice) {
        StLog.d(TAG, "not support dealBluetoothDisconnect");
    }

    public void dealConnectP2P(StConnectDevice stConnectDevice, IProtocol iProtocol) {
        if (iProtocol instanceof StarryNetProtocol) {
            if (!AppUtil.isLocServiceEnable(this.mContext) && Build.VERSION.SDK_INT < 32) {
                StLog.d(TAG, "connectP2P networkName(%s,%d),location service not open ,then return!!!", stConnectDevice.getSsid(), Integer.valueOf(stConnectDevice.getFreq()));
            } else if (!SysActionManager.getInstance().isWlanOn()) {
                StLog.d(TAG, "connectP2P networkName(%s,%d),but wlan not open ,then return!!!", stConnectDevice.getSsid(), Integer.valueOf(stConnectDevice.getFreq()));
                SysActionManager.getInstance().enableWiFi();
            } else if (needAsGoRole(stConnectDevice)) {
                SysActionManager.getInstance().enableWiFi();
                connectP2p(stConnectDevice.getDevice());
            } else {
                this.mStarryNetProtocol.connectP2p(stConnectDevice);
            }
        }
    }

    public void disconnectAp(StDevice stDevice) {
        if (stDevice == null) {
            StLog.d(TAG, "disconnectAp StDevice is null");
        } else {
            this.mStarryNetProtocol.disconnect(stDevice, 12);
        }
    }

    public void disconnectBle(StDevice stDevice, boolean z) {
        StConnectDevice connectDevice;
        StLog.d(TAG, "disconnectBle");
        if (stDevice != null && SysActionManager.getInstance().isBtOn() && (connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier())) != null) {
            if (!connectDevice.isBleConnected()) {
                cancelAuth(connectDevice.getDevice());
                return;
            }
            IStarryNetDiscoverer discoveryManager = StarryNetData.getInstance().getDiscoveryManager();
            if (!z || !isUserActive()) {
                this.mStarryNetProtocol.disconnect(stDevice, 2);
                return;
            }
            discoveryManager.setCarActiveDisconnect(stDevice.getIdentifier2String());
            discoveryManager.disableFastConnect();
            discoveryManager.enableFastConnect();
            this.mStarryNetProtocol.sendStarryNetMsg(stDevice, StarryNetEncryptHelper.generateDisconnectBle());
        }
    }

    public void disconnectP2p(StDevice stDevice) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier2String());
        if (connectDevice != null) {
            if (!needAsGoRole(connectDevice)) {
                this.mStarryNetProtocol.disconnect(stDevice, 11);
            } else if (!connectDevice.isP2pConnected() && !StarryDeviceManager.getInstance().getP2pConnectedDevices().isEmpty()) {
            } else {
                if (connectDevice.isBleConnected() || !connectDevice.isP2pPublish()) {
                    this.mStarryNetProtocol.disconnect(stDevice, 10);
                } else {
                    this.mStarryNetProtocol.sendP2pMsg(connectDevice, StarryNetEncryptHelper.generateDisconnectP2p());
                }
            }
        }
    }

    public void disconnectUsb(StDevice stDevice) {
    }

    public int getDeviceConnectable(StDevice stDevice) {
        byte b;
        int i;
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null || connectDevice.getBleBondStatus() == 0) {
            StDiscoveryDevice discoveryDevice = StarryDeviceManager.getInstance().getDiscoveryDevice(stDevice.getIdentifier());
            if (discoveryDevice == null) {
                return StErrorCode.CONNECT_APP_DEVICE_NULL;
            }
            b = discoveryDevice.getTerminalType();
            i = discoveryDevice.getConnectVersion();
        } else if (connectDevice.getBleBondStatus() == 4) {
            return StErrorCode.CONNECT_APP_SUCCESS;
        } else {
            b = connectDevice.getTerminalType();
            i = connectDevice.getConnectVersion();
        }
        StLog.d(TAG, "getDeviceConnectable terminalType = " + b + " connectVersion = " + i);
        List<StConnectDevice> bondInfoByTerminal = StarryDeviceManager.getInstance().getBondInfoByTerminal(1);
        List<StConnectDevice> bondInfoByTerminal2 = StarryDeviceManager.getInstance().getBondInfoByTerminal(9);
        if (bondInfoByTerminal2 == null || bondInfoByTerminal2.isEmpty()) {
            if (bondInfoByTerminal == null || bondInfoByTerminal.isEmpty()) {
                return StErrorCode.CONNECT_APP_SUCCESS;
            }
            if (bondInfoByTerminal.get(0).getConnectVersion() >= 3) {
                StLog.d(TAG, "getDeviceConnectable bond new phone");
                if (b == 9) {
                    StLog.d(TAG, "getDeviceConnectable bond new phone and connect pad");
                    return StErrorCode.CONNECT_APP_SUCCESS;
                } else if (i < 3) {
                    StLog.d(TAG, "getDeviceConnectable bond new phone and connect old phone");
                    return StErrorCode.CONNECT_APP_PHONE_V3_TO_V2;
                } else {
                    StLog.d(TAG, "getDeviceConnectable bond new phone and connect new phone");
                    return StErrorCode.CONNECT_APP_PHONE_V3_TO_V3;
                }
            } else if (b == 9) {
                StLog.d(TAG, "getDeviceConnectable bond old phone and connect pad");
                return StErrorCode.CONNECT_APP_VERSION_INCOMPATIBLE;
            } else if (i < 3) {
                StLog.d(TAG, "getDeviceConnectable bond old phone and connect old phone");
                return StErrorCode.CONNECT_APP_PHONE_V2_TO_V2;
            } else {
                StLog.d(TAG, "getDeviceConnectable bond old phone and connect new phone");
                return StErrorCode.CONNECT_APP_PHONE_V2_TO_V3;
            }
        } else if (bondInfoByTerminal == null || bondInfoByTerminal.isEmpty()) {
            if (b == 9) {
                StLog.d(TAG, "getDeviceConnectable bond pad and connect pad");
                return StErrorCode.CONNECT_APP_SUCCESS;
            } else if (i < 3) {
                StLog.d(TAG, "getDeviceConnectable bond pad and connect old phone");
                return StErrorCode.CONNECT_APP_VERSION_INCOMPATIBLE;
            } else {
                StLog.d(TAG, "getDeviceConnectable bond pad and connect new phone");
                return StErrorCode.CONNECT_APP_SUCCESS;
            }
        } else if (b == 9) {
            StLog.d(TAG, "getDeviceConnectable bond pad and phone connect pad");
            return StErrorCode.CONNECT_APP_SUCCESS;
        } else if (i < 3) {
            StLog.d(TAG, "getDeviceConnectable bond pad and phone connect old phone");
            return StErrorCode.CONNECT_APP_VERSION_INCOMPATIBLE;
        } else {
            StLog.d(TAG, "getDeviceConnectable bond pad and phone connect new phone");
            return StErrorCode.CONNECT_APP_PHONE_V3_TO_V3;
        }
    }

    public boolean isUserActive() {
        if (!StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_E245) && !StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_E245_INT)) {
            return true;
        }
        String property = StarryNetData.getInstance().getProperty("sys.csd.onoff", BooleanUtils.ON);
        StLog.d(TAG, "csd screen state = " + property);
        return property.equals(BooleanUtils.ON);
    }

    public void onBleServerConnected(StConnectDevice stConnectDevice) {
        connectP2p(stConnectDevice.getDevice());
    }

    public void onWiFiEnabled() {
        super.onWiFiEnabled();
        lambda$connectP2pUntilP2pEnable$0(50, 0);
    }

    public void removeBond(StDevice stDevice) {
        super.removeBond(stDevice);
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice != null) {
            if (connectDevice.getConnectVersion() < 3 || !connectDevice.isP2pPublish() || connectDevice.isBleConnected()) {
                disconnectP2p(stDevice);
            }
        }
    }

    public void disconnectP2p(StDevice stDevice, boolean z) {
        StConnectDevice connectDevice;
        if (stDevice != null && (connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier2String())) != null) {
            StLog.d(TAG, "disconnectP2p app");
            IStarryNetDiscoverer discoveryManager = StarryNetData.getInstance().getDiscoveryManager();
            boolean z2 = z && SysActionManager.getInstance().isBtOn() && SysActionManager.getInstance().isWlanOn() && discoveryManager.isAdvEnable();
            if (z2 && connectDevice.isP2pConnected() && !connectDevice.isBleConnected()) {
                discoveryManager.setCarActiveDisconnect(stDevice.getIdentifier2String());
                if (stDevice.getTerminalType() == 9) {
                    discoveryManager.disableFastConnect();
                    discoveryManager.enableFastConnect();
                }
            }
            if (!needAsGoRole(connectDevice)) {
                this.mStarryNetProtocol.disconnect(stDevice, 11);
            } else if (!connectDevice.isP2pConnected() && !StarryDeviceManager.getInstance().getP2pConnectedDevices().isEmpty()) {
            } else {
                if (connectDevice.isBleConnected() || !connectDevice.isP2pPublish()) {
                    this.mStarryNetProtocol.disconnect(stDevice, 10);
                } else if (z2) {
                    this.mStarryNetProtocol.sendP2pMsg(connectDevice, StarryNetEncryptHelper.generateActiveDisconnectP2p());
                } else {
                    this.mStarryNetProtocol.sendP2pMsg(connectDevice, StarryNetEncryptHelper.generateDisconnectP2p());
                }
            }
        }
    }
}
