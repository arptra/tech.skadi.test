package com.upuphone.starrynet.strategy.discovery;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.here.odnp.config.OdnpConfigStatic;
import com.upuphone.starrynet.api.IStarryDiscoveryCallback;
import com.upuphone.starrynet.api.StConfiguration;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.DiscoverySettings;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.ReLog;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.core.car.CarBaseManager;
import com.upuphone.starrynet.core.car.CarManager;
import com.upuphone.starrynet.core.car.CarManager371;
import com.upuphone.starrynet.core.car.ICarManagerCallback;
import com.upuphone.starrynet.strategy.StarryNetController;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.config.CarConfigs;
import com.upuphone.starrynet.strategy.connector.IStarryNetConnector;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.AbsStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.discovery.advertiser.CarAdvertiserManager;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvertisePackUtil;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairManager;
import com.upuphone.starrynet.strategy.discovery.fastpair.IFastPairCallback;
import com.upuphone.starrynet.strategy.message.ISendMessageListener;
import com.upuphone.starrynet.strategy.message.MessageManager;
import com.upuphone.starrynet.strategy.message.StarryMessage;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class CarStarryNetDiscoverer extends AbsStarryNetDiscoverer implements IFastPairCallback, ICarManagerCallback {
    private static final String TAG = "CarStarryNetDiscoverer";
    private boolean isAdvEnable = true;
    private boolean isMultiDeviceFound;
    private boolean isReconnectEnable = true;
    private final boolean isSupportCarWithPad;
    private CarBaseManager mCarManager;
    private long mConnectTimeoutMillis;
    private byte[] mRequestConnectId;
    private boolean mRequestRecord;
    private final List<String> mSetActiveDisconnect = new Vector();
    private final List<String> mSetRemoveBond = new Vector();

    public CarStarryNetDiscoverer() {
        new FastPairManager(this.mContext, this);
        initCarManager();
        initAdvEnableMode();
        this.isSupportCarWithPad = supportCarWithPad();
    }

    private boolean checkCanStartReconnectAdv() {
        if (this.isMultiDeviceFound) {
            StLog.d(TAG, "checkCanStartReconnectAdv isMultiDeviceFound = true");
            return false;
        } else if (!this.isReconnectEnable) {
            StLog.d(TAG, "checkCanStartReconnectAdv isReconnectEnable = false");
            return false;
        } else {
            StConnectDevice curBondInfo = StarryDeviceManager.getInstance().getCurBondInfo();
            if (curBondInfo == null) {
                StLog.d(TAG, "checkCanStartReconnectAdv bondInfo is null");
                return false;
            } else if (curBondInfo.getBleBondStatus() < 2) {
                StLog.d(TAG, "checkCanStartReconnectAdv ble bond status less than 2");
                return false;
            } else if (curBondInfo.isBleConnected()) {
                StLog.d(TAG, "checkCanStartReconnectAdv isBleConnected");
                return false;
            } else if (curBondInfo.isP2pConnected() && curBondInfo.getConnectVersion() >= 3) {
                StLog.d(TAG, "checkCanStartReconnectAdv isP2pConnected & v3");
                return false;
            } else if (this.mSetActiveDisconnect.contains(curBondInfo.getIdentifier2String())) {
                StLog.d(TAG, "checkCanStartReconnectAdv Active Disconnect");
                return false;
            } else {
                List<StConnectDevice> connectedDeviceByTerminal = StarryDeviceManager.getInstance().getConnectedDeviceByTerminal(9);
                if (connectedDeviceByTerminal == null || connectedDeviceByTerminal.isEmpty() || connectedDeviceByTerminal.get(0).getConnectVersion() <= curBondInfo.getConnectVersion()) {
                    return true;
                }
                StLog.d(TAG, "checkCanStartReconnectAdv connected pad list size=" + connectedDeviceByTerminal.size());
                return false;
            }
        }
    }

    private void checkStartActiveAdv(boolean z) {
        int advState = this.mStateMachine.getAdvState();
        StLog.i(TAG, "checkStartActiveAdv state = " + advState);
        if ((advState & 4) > 0) {
            Message obtainMessage = this.mStateMachine.obtainMessage(13);
            obtainMessage.arg1 = 4;
            this.mStateMachine.sendMessage(obtainMessage);
        }
        if ((advState & 8) > 0) {
            Message obtainMessage2 = this.mStateMachine.obtainMessage(13);
            obtainMessage2.arg1 = 8;
            this.mStateMachine.sendMessage(obtainMessage2);
        }
        if ((advState & 1) == 0) {
            startActiveAdv(z);
        }
    }

    private boolean hasDevicePairing() {
        if (this.mListBleChannel.isEmpty()) {
            return false;
        }
        Iterator<String> it = this.mListBleChannel.iterator();
        while (it.hasNext()) {
            StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(it.next());
            if (connectDeviceByBleMac != null && connectDeviceByBleMac.getBleBondStatus() != 4) {
                StLog.d(TAG, "pairing device = " + connectDeviceByBleMac);
                return true;
            }
        }
        return false;
    }

    private void removeBondIncompatibleDevice() {
        IStarryNetConnector connectManager = StarryNetController.getConnectManager();
        List<StConnectDevice> bondInfoByTerminal = StarryDeviceManager.getInstance().getBondInfoByTerminal(1);
        List<StConnectDevice> bondInfoByTerminal2 = StarryDeviceManager.getInstance().getBondInfoByTerminal(9);
        if (bondInfoByTerminal != null && !bondInfoByTerminal.isEmpty()) {
            StConnectDevice stConnectDevice = bondInfoByTerminal.get(0);
            setRemoveBond(stConnectDevice.getIdentifier2String());
            connectManager.removeBond(stConnectDevice.getDevice());
        } else if (bondInfoByTerminal2 != null && !bondInfoByTerminal2.isEmpty()) {
            StConnectDevice stConnectDevice2 = bondInfoByTerminal2.get(0);
            setRemoveBond(stConnectDevice2.getIdentifier2String());
            connectManager.removeBond(stConnectDevice2.getDevice());
        }
    }

    private void sendMsg(StDevice stDevice, final int i, byte[] bArr) {
        MessageManager.getInstance().sendInnerBleServerMultipleMessage(stDevice, false, i, bArr, new ISendMessageListener() {
            public void onSendFail(StarryMessage starryMessage, int i, String str) {
                StLog.d(CarStarryNetDiscoverer.TAG, "sendMsg fail onResponse code = " + i + ",msg=" + str + ", ctrPacketType=" + i);
            }

            public void onSendSuccess(StarryMessage starryMessage) {
                StLog.d(CarStarryNetDiscoverer.TAG, "sendMsg success ,ctrPacketType= %d", Integer.valueOf(i));
            }
        });
    }

    private void setRemoveBond(String str) {
        if (str != null && !this.mSetRemoveBond.contains(str)) {
            this.mSetRemoveBond.add(str);
        }
    }

    public void callbackForTimeOut() {
        for (DiscoveryClient next : this.mListDiscovery) {
            if ((next.getFilter().getDeviceType() & 1) > 0) {
                next.getCallback().onDiscoveryError(StErrorCode.DISCOVERY_STRATEGY_REQUEST_CONNECT_TIMEOUT);
            }
        }
    }

    public int disableFastConnect() {
        StLog.d(TAG, "disableFastConnect");
        AbsStarryNetDiscoverer.DiscoverHanddler discoverHanddler = this.mDiscoverHandler;
        if (discoverHanddler != null && discoverHanddler.hasMessages(1)) {
            this.mDiscoverHandler.removeMessages(1);
        }
        stopStarryAdv();
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public int enableFastConnect() {
        super.enableFastConnect();
        if (isStrPowerMode()) {
            StLog.e(TAG, "enter str mode, return");
            return StErrorCode.DISCOVERY_STRATEGY_ENTER_STR_MODE_FAIL;
        } else if (this.mRequestRecord) {
            this.mRequestRecord = false;
            requestConnect(this.mRequestConnectId, this.mConnectTimeoutMillis);
            return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
        } else {
            if (checkCanStartReconnectAdv()) {
                byte[] identifier = StarryDeviceManager.getInstance().getCurBondInfo().getIdentifier();
                StLog.d(TAG, "enableFastConnect  startReconnectAdv " + Utils.bytes2HexString(identifier));
                startReConnectAdv(identifier);
            } else {
                startActiveAdv(true);
            }
            return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
        }
    }

    public boolean getReconnectEnable() {
        return this.isReconnectEnable;
    }

    public void initAdvEnableMode() {
        if (!CarConfigs.ADV_DEFAULT_DISABLE_LIST.contains(StarryNetData.getInstance().getOwnDevice().getModelName())) {
            enableFastConnect();
            return;
        }
        this.isAdvEnable = false;
        this.mStateMachine.sendMessage(31, 0);
    }

    public void initAdvertiseManager() {
        if (this.mAdvertiseManager == null) {
            this.mAdvertiseManager = new CarAdvertiserManager();
        }
    }

    public void initCarManager() {
        try {
            Class.forName("android.car.Car");
            StLog.d(TAG, "initCarManager");
            if (StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_E371) || StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_E371_MX)) {
                this.mCarManager = new CarManager371(this.mContext, this);
            } else {
                this.mCarManager = new CarManager(this.mContext, this);
            }
        } catch (Exception e) {
            StLog.e(TAG, "Exception ", (Throwable) e);
        }
    }

    public boolean isAdvEnable() {
        return this.isAdvEnable;
    }

    public boolean isCarActiveDisconnect(String str) {
        if (str == null) {
            return false;
        }
        return this.mSetActiveDisconnect.contains(str);
    }

    public boolean isCarActiveDisconnectPad() {
        if (this.mSetActiveDisconnect.size() == 0) {
            return false;
        }
        for (String connectDevice : this.mSetActiveDisconnect) {
            StConnectDevice connectDevice2 = StarryDeviceManager.getInstance().getConnectDevice(connectDevice);
            if (connectDevice2 != null && connectDevice2.getTerminalType() == 9) {
                return true;
            }
        }
        return false;
    }

    public boolean isStrPowerMode() {
        CarBaseManager carBaseManager = this.mCarManager;
        if (carBaseManager == null) {
            return false;
        }
        return carBaseManager.isStrMode();
    }

    public void onBleConnected(String str, boolean z) {
        super.onBleConnected(str, z);
        if (z) {
            this.mStateMachine.sendMessage(10);
            StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(str);
            if (connectDeviceByBleMac != null) {
                this.mSetActiveDisconnect.remove(connectDeviceByBleMac.getIdentifier2String());
                return;
            }
            return;
        }
        this.mStateMachine.sendMessage(9);
        enableFastConnect();
    }

    public void onBleDisconnected(String str) {
        StLog.d(TAG, "onBleDisconnected, mac = " + str);
        this.mStateMachine.sendMessage(9);
        if (!TextUtils.isEmpty(str)) {
            this.mListBleChannel.remove(str);
            StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(str);
            if (connectDeviceByBleMac != null) {
                if (connectDeviceByBleMac.getBleBondStatus() == 1) {
                    StLog.d(TAG, "auth state, restart adv by bondStateChange");
                    StarryDeviceManager.getInstance().updateBondInfo(connectDeviceByBleMac, 0);
                } else if (this.mSetRemoveBond.isEmpty() && !hasDevicePairing()) {
                    disableFastConnect();
                    enableFastConnect();
                }
            }
        }
    }

    public void onBluetoothNameChange(String str) {
        StLog.d(TAG, "onBluetoothNameChange");
        if (StarryDeviceManager.getInstance().getBleConnectedDevices().size() <= 0) {
            disableFastConnect();
            enableFastConnect();
        }
    }

    public void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2) {
        super.onBondStateChanged(stConnectDevice, i, i2);
        if (i == 1) {
            StarryDeviceManager.getInstance().addDelayLoseDevice(stConnectDevice.getIdentifier2String());
        } else if (i == 0 || i == 4) {
            StarryDeviceManager.getInstance().removeDelayLoseDevice(stConnectDevice.getIdentifier2String());
        }
        if (!stConnectDevice.isBleConnected() && i == 0) {
            this.mSetActiveDisconnect.remove(stConnectDevice.getIdentifier2String());
            this.mSetRemoveBond.remove(stConnectDevice.getIdentifier2String());
            if (this.mSetRemoveBond.isEmpty() && !hasDevicePairing()) {
                disableFastConnect();
                enableFastConnect();
            }
        }
    }

    public void onDeviceConnectRequest(StDevice stDevice, byte[] bArr) {
        StLog.d(TAG, "onDeviceConnectRequest: " + stDevice);
        for (DiscoveryClient next : this.mListDiscovery) {
            if (next.getFilter().matches(stDevice)) {
                next.getCallback().onDeviceConnectRequest(stDevice.clone(), bArr);
            }
        }
    }

    public void onDiscovered(StDiscoveryDevice stDiscoveryDevice) {
        if (stDiscoveryDevice.getTerminalType() != 9 || this.isSupportCarWithPad) {
            super.onDiscovered(stDiscoveryDevice);
        } else {
            ReLog.v(TAG, "Not support pad");
        }
    }

    public void onFastJudgment(StDiscoveryDevice stDiscoveryDevice, int i) {
    }

    public void onP2pGoDisconnected(StConnectDevice stConnectDevice) {
        if (stConnectDevice != null && stConnectDevice.getTerminalType() == 1 && this.mSetRemoveBond.isEmpty() && !hasDevicePairing()) {
            disableFastConnect();
            enableFastConnect();
        }
    }

    public void onStrModeChanged(boolean z) {
        StLog.d(TAG, "onStrModeChanged, enter = " + z);
        this.mStateMachine.sendMessage(32, (Object) Boolean.valueOf(z));
        if (z) {
            disableFastConnect();
            return;
        }
        this.mSetActiveDisconnect.clear();
        enableFastConnect();
    }

    public int requestConnect(byte[] bArr, long j) {
        if (bArr == null || bArr.length > 7) {
            StringBuilder sb = new StringBuilder();
            sb.append("requestConnect params length not match, length =");
            sb.append(bArr == null ? 0 : bArr.length);
            StLog.e(TAG, sb.toString());
            return StErrorCode.DISCOVERY_STRATEGY_INVALID_PARAM;
        }
        byte[] deviceId = AdvertisePackUtil.getDeviceId(bArr);
        StDevice device = StarryDeviceManager.getInstance().getDevice(deviceId);
        this.mSetActiveDisconnect.remove(Utils.bytes2HexString(deviceId));
        if (device == null) {
            StLog.e(TAG, "requestConnect not find StDevice");
            return StErrorCode.DISCOVERY_STRATEGY_UNKNOWN_DEVICE;
        } else if (device.isBleConnected() || device.isP2pConnected()) {
            StLog.d(TAG, "already connected cur device!");
            return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
        } else {
            StLog.d(TAG, "requestConnect start = " + device.getIdentifier2String());
            this.mConnectTimeoutMillis = j;
            int deviceConnectable = StarryNetController.getConnectManager().getDeviceConnectable(device);
            if (deviceConnectable == 102000 || deviceConnectable == 102001 || j == 0) {
                if (j == 0) {
                    this.mConnectTimeoutMillis = OdnpConfigStatic.OEM_MAX_HIGH_POWER_INTERVAL;
                }
                StLog.d(TAG, "requestConnect:" + Utils.bytes2HexString(bArr));
                this.mStateMachine.sendMessage(10);
                stopStarryAdv();
                this.mStateMachine.sendMessage(40);
                startConnectAdv(bArr);
                if (this.mDiscoverHandler == null) {
                    this.mDiscoverHandler = new AbsStarryNetDiscoverer.DiscoverHanddler(Looper.getMainLooper());
                }
                if (this.mDiscoverHandler.hasMessages(1)) {
                    this.mDiscoverHandler.removeMessages(1);
                }
                this.mDiscoverHandler.sendEmptyMessageDelayed(1, this.mConnectTimeoutMillis);
                return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
            }
            this.mRequestRecord = true;
            this.mRequestConnectId = bArr;
            removeBondIncompatibleDevice();
            return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
        }
    }

    public int setAdvertiseEnableMode(int i) {
        this.mStateMachine.sendMessage(31, i);
        if (i == 0) {
            this.isAdvEnable = false;
            disableFastConnect();
            return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
        } else if (i != 1) {
            return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
        } else {
            this.isAdvEnable = true;
            enableFastConnect();
            return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
        }
    }

    public void setCarActiveDisconnect(String str) {
        if (str != null && this.isAdvEnable) {
            StLog.d(TAG, "setCarActiveDisconnect, device = " + str);
            if (!this.mSetActiveDisconnect.contains(str)) {
                this.mSetActiveDisconnect.add(str);
            }
        }
    }

    public int setReconnectEnable(boolean z) {
        this.isReconnectEnable = z;
        enableFastConnect();
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback) {
        int startDiscovery = super.startDiscovery(discoveryFilter, discoverySettings, iStarryDiscoveryCallback);
        if (discoverySettings == null || discoverySettings.getScanMode() != 1) {
            this.mStateMachine.sendMessage(7);
        } else {
            this.mStateMachine.sendMessage(8);
        }
        return startDiscovery;
    }

    public int startMultiDeviceFound() {
        this.isMultiDeviceFound = true;
        if (hasDevicePairing()) {
            return 0;
        }
        StLog.d(TAG, "startMultiDeviceFound!");
        checkStartActiveAdv(true);
        return 0;
    }

    public int startPassiveAdv(boolean z) {
        if ((this.mStateMachine.getAdvState() & 1) > 0) {
            StLog.d(TAG, "already start active adv, not start passive!");
            return 0;
        }
        Message obtainMessage = this.mStateMachine.obtainMessage(12);
        obtainMessage.arg1 = 2;
        obtainMessage.arg2 = z ? 1 : 0;
        this.mStateMachine.sendMessage(obtainMessage);
        return 0;
    }

    public int stopDiscovery(String str) {
        int stopDiscovery = super.stopDiscovery(str);
        this.mStateMachine.sendMessage(10);
        return stopDiscovery;
    }

    public int stopMultiDeviceFound(boolean z) {
        StLog.d(TAG, "stopMultiDeviceFound! , reAdv = " + z);
        this.isMultiDeviceFound = false;
        stopStarryAdv();
        if (hasDevicePairing()) {
            return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
        }
        enableFastConnect();
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public boolean supportCarWithPad() {
        return StConfiguration.getCarWithPadList().contains(StarryNetData.getInstance().getOwnDevice().getModelID());
    }
}
