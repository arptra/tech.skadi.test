package com.upuphone.starrynet.strategy.discovery.fastpair;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.ByteUtils;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.core.ap.WiFiApInfo;
import com.upuphone.starrynet.core.p2p.bean.GoInfo;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.data.IConnectCallback;
import com.upuphone.starrynet.strategy.data.IDiscoveryInterceptor;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.advertiser.codec.AdvCodes;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvertisePackUtil;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairBaseController;
import com.upuphone.starrynet.strategy.discovery.fastpair.appfastpair.FastPairApp;
import com.upuphone.starrynet.strategy.discovery.fastpair.judgment.FastPairJudgment;
import com.upuphone.starrynet.strategy.discovery.fastpair.judgment.IJudgmentCallback;
import com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.FastPairStar;
import java.util.List;

public class FastPairManager implements IConnectCallback, IDiscoveryInterceptor, IJudgmentCallback {
    public static final String TAG = "FastPairManager";
    protected DiscoveryConnectConfig mDiscoveryConnectConfig = null;
    private final FastPairApp mFastPairApp;
    protected final IFastPairCallback mFastPairCallback;
    protected final FastPairJudgment mFastPairJudgment;
    protected FastPairStar mFastPairStar;
    protected int mProcessType = 0;

    public class DiscoveryConnectConfig {
        private boolean enable;
        private String modelID;
        private int terminalType;

        public DiscoveryConnectConfig(boolean z, int i, String str) {
            this.enable = z;
            this.terminalType = i;
            this.modelID = str;
        }

        public boolean isConnectable(StDiscoveryDevice stDiscoveryDevice) {
            if (this.enable) {
                return true;
            }
            if (TextUtils.isEmpty(this.modelID)) {
                if (stDiscoveryDevice.getTerminalType() != this.terminalType) {
                    return true;
                }
                StLog.v(FastPairManager.TAG, "device is not connectable, " + stDiscoveryDevice);
                return false;
            } else if (!stDiscoveryDevice.getModelID().equals(this.modelID)) {
                return true;
            } else {
                StLog.v(FastPairManager.TAG, "the device is not connectable, " + stDiscoveryDevice);
                return false;
            }
        }
    }

    public FastPairManager(Context context, IFastPairCallback iFastPairCallback) {
        this.mFastPairCallback = iFastPairCallback;
        StarryDeviceManager instance = StarryDeviceManager.getInstance();
        instance.addDiscoveryInterceptor(this);
        instance.addConnectCallback(this);
        this.mFastPairJudgment = new FastPairJudgment(this);
        this.mFastPairApp = new FastPairApp(context, iFastPairCallback);
        this.mFastPairStar = new FastPairStar(context);
    }

    private int checkRspType(StDiscoveryDevice stDiscoveryDevice) {
        byte b;
        byte b2;
        byte[] bArr = stDiscoveryDevice.getDeviceDetail().get((byte) 16);
        byte v2TypeLength = AdvCodes.getV2TypeLength((byte) 16);
        if (bArr == null || bArr.length < v2TypeLength) {
            return -1;
        }
        byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
        if (terminalType != 1) {
            if (terminalType == 2) {
                b = bArr[1];
                b2 = AdvPackConstants.ADV_RSP_XR_DISPATCH[1];
            } else if (terminalType == 3) {
                b = bArr[1];
                b2 = AdvPackConstants.ADV_RSP_CAR_DISPATCH[1];
            } else if (!(terminalType == 4 || terminalType == 9)) {
                return -2;
            }
            return b & b2;
        }
        b = bArr[1];
        b2 = AdvPackConstants.ADV_RSP_PHONE_DISPATCH[1];
        return b & b2;
    }

    private boolean isConnectable(StDiscoveryDevice stDiscoveryDevice) {
        DiscoveryConnectConfig discoveryConnectConfig = this.mDiscoveryConnectConfig;
        if (discoveryConnectConfig != null) {
            return discoveryConnectConfig.isConnectable(stDiscoveryDevice);
        }
        return true;
    }

    private boolean refuseReconnectAdv(StDiscoveryDevice stDiscoveryDevice) {
        if (!StarryDeviceManager.getInstance().getBondingDeviceByTerminal(stDiscoveryDevice.getTerminalType()).isEmpty()) {
            StLog.d(TAG, "bonding car, not handle reconnect adv");
            return true;
        }
        List<StConnectDevice> connectedDeviceByTerminal = StarryDeviceManager.getInstance().getConnectedDeviceByTerminal(stDiscoveryDevice.getTerminalType());
        if (connectedDeviceByTerminal.isEmpty()) {
            return false;
        }
        for (StConnectDevice identifier2String : connectedDeviceByTerminal) {
            if (identifier2String.getIdentifier2String().equals(stDiscoveryDevice.getIdentifier2String())) {
                return false;
            }
        }
        return StarryNetData.getInstance().getOwnDevice().getTerminalType() != 9;
    }

    public void clearBeacon() {
        this.mFastPairJudgment.clearPairRecord();
    }

    public int fastPairStatus(StDiscoveryDevice stDiscoveryDevice) {
        if (this.mProcessType == 1) {
            return 2;
        }
        return isPairing(stDiscoveryDevice) ? 1 : 0;
    }

    public boolean handleActiveAdv(StDiscoveryDevice stDiscoveryDevice) {
        if (checkRspType(stDiscoveryDevice) <= 0) {
            return true;
        }
        byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
        if (terminalType == 1) {
            return this.mFastPairJudgment.startAppFastPair(stDiscoveryDevice);
        }
        if (terminalType != 9) {
            return false;
        }
        return this.mFastPairApp.startFastPair(stDiscoveryDevice);
    }

    public boolean handleNotify(StDiscoveryDevice stDiscoveryDevice) {
        return this.mFastPairJudgment.handleNotify(stDiscoveryDevice);
    }

    public boolean isPairing(StDevice stDevice) {
        return stDevice.getTerminalType() == 2 ? this.mFastPairStar.getPairing() : this.mFastPairApp.getPairing();
    }

    public void onApCreated(WiFiApInfo wiFiApInfo) {
    }

    public void onApRemoved() {
    }

    public void onBleConnectFail(StDevice stDevice, int i) {
        FastPairBaseController.FastPairHandler fastPairHandler = stDevice.getTerminalType() == 2 ? this.mFastPairStar.mHandler : this.mFastPairApp.mHandler;
        Message obtainMessage = fastPairHandler.obtainMessage(12, stDevice);
        obtainMessage.arg1 = i;
        fastPairHandler.sendMessage(obtainMessage);
    }

    public void onBleConnected(StDevice stDevice) {
        if (stDevice.getTerminalType() != 5) {
            if (stDevice.getTerminalType() == 2) {
                this.mFastPairStar.onBleConnected(stDevice);
                return;
            }
            FastPairBaseController.FastPairHandler fastPairHandler = this.mFastPairApp.mHandler;
            fastPairHandler.sendMessage(fastPairHandler.obtainMessage(5, stDevice));
        }
    }

    public void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2) {
        if (stConnectDevice == null) {
            StLog.i(TAG, "onBondStateChanged bondInfo is null");
            return;
        }
        StDevice device = stConnectDevice.getDevice();
        if (device == null) {
            StLog.i(TAG, "onBondStateChanged device is null");
            return;
        }
        StLog.d(TAG, "onBondStateChanged, status =%d, old =%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 32) {
            TrackerManager.getInstance().getBluetoothConnectionTracker().startConnectBt(device.getTerminalType(), stConnectDevice.getIdentifier2String());
        }
        if (!isPairing(device)) {
            StLog.i(TAG, "onBondStateChanged device not in pairing");
        } else if (i == 0) {
            FastPairBaseController.FastPairHandler fastPairHandler = device.getTerminalType() == 2 ? this.mFastPairStar.mHandler : this.mFastPairApp.mHandler;
            fastPairHandler.sendMessage(fastPairHandler.obtainMessage(6, device));
        }
    }

    public void onBrConnectFail(StDevice stDevice, int i) {
        if (stDevice.getTerminalType() != 2) {
            FastPairBaseController.FastPairHandler fastPairHandler = this.mFastPairApp.mHandler;
            Message obtainMessage = fastPairHandler.obtainMessage(12, stDevice);
            obtainMessage.arg1 = i;
            fastPairHandler.sendMessage(obtainMessage);
        }
    }

    public void onBrEdrConnected(StDevice stDevice) {
        if (stDevice.getTerminalType() == 2) {
            this.mFastPairStar.onBrEdrConnected(stDevice);
        }
    }

    public void onConnectFail(StDevice stDevice, int i, int i2) {
        if (i2 == 1) {
            onBleConnectFail(stDevice, i);
        } else if (i2 == 8) {
            onBrConnectFail(stDevice, i);
        }
    }

    public void onConnected(StConnectDevice stConnectDevice, int i) {
        if (stConnectDevice == null) {
            StLog.i(TAG, "onConnected device is null");
            return;
        }
        StDevice device = stConnectDevice.getDevice();
        if (i == 1 || i == 2) {
            onBleConnected(device);
        } else if (i == 64) {
            onBrEdrConnected(device);
        }
    }

    public void onDisconnected(StConnectDevice stConnectDevice, int i) {
        StDiscoveryDevice discoveryDevice;
        if (stConnectDevice != null && i == 2 && (discoveryDevice = StarryDeviceManager.getInstance().getDiscoveryDevice(stConnectDevice.getIdentifier())) != null) {
            this.mFastPairJudgment.removePairRecord(discoveryDevice.getIdentifier2String());
        }
    }

    public boolean onDiscovery(StDiscoveryDevice stDiscoveryDevice) {
        if (!SysActionManager.getInstance().isBtOn()) {
            StLog.i(TAG, "Only check on bt on");
            return false;
        } else if (stDiscoveryDevice == null) {
            StLog.w(TAG, "startFastPair: device is null");
            return false;
        } else if (stDiscoveryDevice.getVersion() < 3) {
            StLog.df(TAG, "startFastPair: device version is invalid, version = " + stDiscoveryDevice.getVersion());
            return false;
        } else if (!isConnectable(stDiscoveryDevice)) {
            return true;
        } else {
            int unsignedInt = Byte.toUnsignedInt(stDiscoveryDevice.getAdvType());
            if (stDiscoveryDevice.getStatus() == 5) {
                return false;
            }
            if (unsignedInt == 0) {
                return handleNotify(stDiscoveryDevice);
            }
            if (unsignedInt == 64) {
                return startFastPair(stDiscoveryDevice);
            }
            if (unsignedInt == 128) {
                return false;
            }
            if (unsignedInt == 144) {
                return handleActiveAdv(stDiscoveryDevice);
            }
            if (unsignedInt == 160) {
                return startLocalFastPair(stDiscoveryDevice);
            }
            if (unsignedInt == 176) {
                return startAppFastPair(stDiscoveryDevice);
            }
            if (unsignedInt == 208) {
                return startRequestConnect(stDiscoveryDevice);
            }
            StLog.d(TAG, "onDiscovery with unknown adv mode:" + unsignedInt);
            return false;
        }
    }

    public void onFastJudgment(StDiscoveryDevice stDiscoveryDevice, int i) {
        StLog.i(TAG, "onFastJudgment, device = " + stDiscoveryDevice + ", result = " + i + ", process type = " + this.mProcessType);
        int i2 = this.mProcessType;
        if (i2 == 0) {
            if ((stDiscoveryDevice.getTerminalType() != 2 || stDiscoveryDevice.getRegion() == 1 || stDiscoveryDevice.getRegion() == 0) && stDiscoveryDevice.getTerminalType() != 5) {
                starPair(stDiscoveryDevice, i, this.mProcessType);
                return;
            }
            StLog.d(TAG, "device region illegal: " + stDiscoveryDevice.getRegion() + "terminal type: " + stDiscoveryDevice.getTerminalType());
        } else if (i2 == 1) {
            if (i == 4 || i == 1 || i == 7 || i == 0) {
                starPair(stDiscoveryDevice, i, i2);
            }
            if (this.mFastPairJudgment != null) {
                this.mFastPairCallback.onFastJudgment(stDiscoveryDevice, i);
            }
        }
    }

    public void onP2pGoCreated(GoInfo goInfo) {
    }

    public void onP2pGoRemoved() {
    }

    public void setDeviceConnectable(boolean z, int i, String str) {
        this.mDiscoveryConnectConfig = new DiscoveryConnectConfig(z, i, str);
    }

    public void setFastConnectProcess(int i) {
        StLog.i(TAG, "setFastConnectProcess type = " + i + " default = " + this.mProcessType);
        if (i == 10) {
            clearBeacon();
        } else {
            this.mProcessType = i;
        }
    }

    public void starPair(StDiscoveryDevice stDiscoveryDevice, int i, int i2) {
        boolean isPopOrConnect = this.mFastPairStar.isPopOrConnect(stDiscoveryDevice, i, i2);
        StLog.d(TAG, "onFastJudgment, isProcessed = " + isPopOrConnect);
        if (i == 4) {
            this.mFastPairJudgment.removePairRecord(stDiscoveryDevice.getIdentifier2String());
        } else if (!isPopOrConnect && !this.mFastPairStar.isPairingDevice(stDiscoveryDevice)) {
            this.mFastPairJudgment.removePairRecord(stDiscoveryDevice.getIdentifier2String());
        }
    }

    public boolean startAppFastPair(StDiscoveryDevice stDiscoveryDevice) {
        if (checkRspType(stDiscoveryDevice) <= 0) {
            return true;
        }
        return this.mFastPairJudgment.startAppFastPair(stDiscoveryDevice);
    }

    public boolean startFastPair(StDiscoveryDevice stDiscoveryDevice) {
        if (stDiscoveryDevice.getTerminalType() != 3 || stDiscoveryDevice.getDeviceDetail() == null) {
            return this.mFastPairJudgment.startFastPair(stDiscoveryDevice);
        }
        if (StarryNetData.getInstance().getOwnDevice().getTerminalType() == 3) {
            return true;
        }
        if (stDiscoveryDevice.getDeviceDetail().get((byte) 15) == null) {
            StLog.i(TAG, "fast pair onDiscovery error connect adv");
            return true;
        } else if (refuseReconnectAdv(stDiscoveryDevice)) {
            return true;
        } else {
            return this.mFastPairApp.startFastPair(stDiscoveryDevice);
        }
    }

    public boolean startLocalFastPair(StDiscoveryDevice stDiscoveryDevice) {
        if (checkRspType(stDiscoveryDevice) <= 0) {
            return true;
        }
        return this.mFastPairJudgment.startLocalFastPair(stDiscoveryDevice);
    }

    public boolean startRequestConnect(StDiscoveryDevice stDiscoveryDevice) {
        if (stDiscoveryDevice.getTerminalType() != 3 || stDiscoveryDevice.getDeviceDetail() == null) {
            return false;
        }
        if (!ByteUtils.equals(StarryNetData.getInstance().getIdentifier(), AdvertisePackUtil.getPeerMac(stDiscoveryDevice))) {
            return true;
        }
        return this.mFastPairApp.startFastPair(stDiscoveryDevice);
    }
}
