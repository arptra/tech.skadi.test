package com.upuphone.starrynet.strategy.discovery;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.here.odnp.config.OdnpConfigStatic;
import com.upuphone.starrynet.api.IStarryDiscoveryCallback;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.StErrorTips;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.DiscoverySettings;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.core.ble.event.OpenGattServerEvent;
import com.upuphone.starrynet.core.ble.server.BleServerCache;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.data.IDiscoveryConnectCallback;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.advertiser.AdvertiserManager;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackManager;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairRecord;
import com.upuphone.starrynet.strategy.discovery.scanner.IDiscoveryListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class AbsStarryNetDiscoverer implements IStarryNetDiscoverer, EventReceiver, IDiscoveryListener, AdvertiserManager.IAdvStartCallback, IDiscoveryConnectCallback {
    public static final int MSG_REQUEST_CONNECT_TIMEOUT = 1;
    public static final int MSG_XR_ADV_TIMEOUT = 2;
    public static final int RSSI_ICCOA_PAIR_MIN = -70;
    private static final String TAG = "AbsStarryNetDiscoverer";
    protected AdvertiserManager mAdvertiseManager;
    protected Context mContext;
    protected DiscoverHanddler mDiscoverHandler;
    protected CopyOnWriteArraySet<String> mListBleChannel = new CopyOnWriteArraySet<>();
    protected final List<DiscoveryClient> mListDiscovery = new CopyOnWriteArrayList();
    SysActionManager.StateChangeSimpleCallback mStateChangeSimpleCallback = new SysActionManager.StateChangeSimpleCallback() {
        public void onBluetoothDisabled() {
            AbsStarryNetDiscoverer.this.onBluetoothDisabled();
        }

        public void onBluetoothEnabled() {
            AbsStarryNetDiscoverer.this.onBluetoothEnabled();
        }

        public void onBluetoothNameChange(String str) {
            AbsStarryNetDiscoverer.this.onBluetoothNameChange(str);
        }

        public void onScreenOff() {
            AbsStarryNetDiscoverer.this.onScreenOff();
        }

        public void onScreenOn() {
            AbsStarryNetDiscoverer.this.onScreenOn();
        }

        public void onUupShareDisabled() {
            AbsStarryNetDiscoverer.this.onUupShareDisabled();
        }

        public void onUupShareEnabled() {
            AbsStarryNetDiscoverer.this.onUupShareEnabled();
        }
    };
    protected final DiscoveryStateMachine mStateMachine;
    protected HandlerThread mStateMachineThread;

    public class DiscoverHanddler extends Handler {
        public DiscoverHanddler(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            StLog.d(AbsStarryNetDiscoverer.TAG, "handleMessage : " + message.what);
            int i = message.what;
            if (i == 1) {
                if (FastPairRecord.getInstance().getNotifyLabel()) {
                    FastPairRecord.getInstance().setNotifyLabel(false);
                }
                AbsStarryNetDiscoverer.this.stopConnectAdv();
                AbsStarryNetDiscoverer.this.enableFastConnect();
                AbsStarryNetDiscoverer.this.mStateMachine.sendMessage(9);
                AbsStarryNetDiscoverer.this.callbackForTimeOut();
            } else if (i == 2) {
                AbsStarryNetDiscoverer.this.callbackForTimeOut();
            }
        }
    }

    public class DiscoveryDeathRecipient implements IBinder.DeathRecipient {
        public DiscoveryDeathRecipient() {
        }

        public synchronized void binderDied() {
            StLog.d(AbsStarryNetDiscoverer.TAG, "Binder is dead - unregistering discover");
            for (DiscoveryClient remove : AbsStarryNetDiscoverer.this.mListDiscovery) {
                AbsStarryNetDiscoverer.this.mListDiscovery.remove(remove);
            }
        }
    }

    public AbsStarryNetDiscoverer() {
        initAdvertiseManager();
        this.mAdvertiseManager.registerAdvStartCallback(this);
        BleEventBus.get().register(OpenGattServerEvent.class, this);
        StarryDeviceManager.getInstance().addDiscoveryListener(this);
        StarryDeviceManager.getInstance().setDiscoveryConnectCallback(this);
        this.mContext = StarryNetData.getInstance().getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("DiscoveryService.StateMachine");
        this.mStateMachineThread = handlerThread;
        handlerThread.start();
        this.mStateMachine = DiscoveryStateMachine.make(this.mContext, this.mStateMachineThread.getLooper(), this.mAdvertiseManager);
        SysActionManager.getInstance().registerSysAction(this.mStateChangeSimpleCallback);
        if (SysActionManager.getInstance().isUupShareOn()) {
            startUupShareAdv();
        } else {
            stopUupShareAdv();
        }
    }

    public void callbackForTimeOut() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkAndResponseDeviceFoundAdv(com.upuphone.starrynet.strategy.bean.StDiscoveryDevice r4) {
        /*
            r3 = this;
            com.upuphone.starrynet.strategy.SysActionManager r0 = com.upuphone.starrynet.strategy.SysActionManager.getInstance()
            boolean r0 = r0.isBtOn()
            if (r0 != 0) goto L_0x0012
            java.lang.String r3 = "AbsStarryNetDiscoverer"
            java.lang.String r4 = "Only response on and bt on"
            com.upuphone.starrynet.common.StLog.d(r3, r4)
            return
        L_0x0012:
            byte r0 = r4.getDeviceType()
            r1 = 1
            r2 = 2
            if (r0 != r1) goto L_0x0075
            byte r0 = r4.getVersion()
            r1 = 0
            if (r0 != r2) goto L_0x0044
            java.util.HashMap r4 = r4.getDeviceDetail()
            java.lang.Byte r0 = java.lang.Byte.valueOf(r2)
            java.lang.Object r4 = r4.get(r0)
            byte[] r4 = (byte[]) r4
            if (r4 == 0) goto L_0x006e
            byte r4 = r4[r1]
            com.upuphone.starrynet.strategy.StarryNetData r0 = com.upuphone.starrynet.strategy.StarryNetData.getInstance()
            com.upuphone.starrynet.api.bean.StDevice r0 = r0.getOwnDevice()
            byte r0 = r0.getTerminalType()
            boolean r4 = com.upuphone.starrynet.strategy.utils.BleUtil.checkTypeNeedRsp(r0, r4)
            goto L_0x006f
        L_0x0044:
            byte r0 = r4.getVersion()
            r2 = 3
            if (r0 != r2) goto L_0x006e
            java.util.HashMap r4 = r4.getDeviceDetail()
            r0 = 16
            java.lang.Byte r0 = java.lang.Byte.valueOf(r0)
            java.lang.Object r4 = r4.get(r0)
            byte[] r4 = (byte[]) r4
            if (r4 == 0) goto L_0x006e
            com.upuphone.starrynet.strategy.StarryNetData r0 = com.upuphone.starrynet.strategy.StarryNetData.getInstance()
            com.upuphone.starrynet.api.bean.StDevice r0 = r0.getOwnDevice()
            byte r0 = r0.getTerminalType()
            boolean r4 = com.upuphone.starrynet.strategy.utils.BleUtil.checkTypeNeedRspV3(r0, r4)
            goto L_0x006f
        L_0x006e:
            r4 = r1
        L_0x006f:
            if (r4 == 0) goto L_0x007e
            r3.startPassiveAdv(r1)
            goto L_0x007e
        L_0x0075:
            byte r4 = r4.getDeviceType()
            if (r4 != r2) goto L_0x007e
            r3.startUupShareRspAdv()
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.discovery.AbsStarryNetDiscoverer.checkAndResponseDeviceFoundAdv(com.upuphone.starrynet.strategy.bean.StDiscoveryDevice):void");
    }

    public int disableFastConnect() {
        StLog.d(TAG, "disableFastConnect do nothing");
        return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
    }

    public int enableFastConnect() {
        StLog.d(TAG, "enableFastConnect add beaconId");
        this.mStateMachine.sendMessage(40);
        return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
    }

    public int enableFastConnectWithTimeOut(long j) {
        return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
    }

    public boolean getReconnectEnable() {
        return true;
    }

    public abstract void initAdvertiseManager();

    public boolean isAdvEnable() {
        return true;
    }

    public boolean isCarActiveDisconnect(String str) {
        return false;
    }

    public boolean isCarActiveDisconnectPad() {
        return false;
    }

    public boolean isStarryAdvertising() {
        int advState = this.mStateMachine.getAdvState();
        return advState > 0 && advState <= 16;
    }

    public void onAdvStatus(int i, int i2) {
        Message obtainMessage = this.mStateMachine.obtainMessage(30);
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i2;
        this.mStateMachine.sendMessage(obtainMessage);
    }

    public void onBatchDiscovered(List<StDevice> list) {
        StLog.d(TAG, "onBatchDiscovered");
    }

    public void onBleConnected(String str, boolean z) {
        StLog.d(TAG, "onBleConnected, mac = " + str + ", isChannel = " + z);
        if (!TextUtils.isEmpty(str) && z) {
            this.mListBleChannel.add(str);
            disableFastConnect();
            StConnectDevice curIosDevice = StarryDeviceManager.getInstance().getCurIosDevice();
            if (curIosDevice != null && curIosDevice.isPreConnect()) {
                curIosDevice.setPreConnect(false);
            }
        }
    }

    public void onBleDisconnected(String str) {
        StLog.d(TAG, "onBleDisconnected, mac = " + str);
        if (!TextUtils.isEmpty(str)) {
            this.mListBleChannel.remove(str);
            StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(str);
            if (connectDeviceByBleMac != null && connectDeviceByBleMac.getBleBondStatus() == 1) {
                StLog.d(TAG, "auth state, restart adv by bondStateChange");
                StarryDeviceManager.getInstance().updateBondInfo(connectDeviceByBleMac, 0);
            } else if (connectDeviceByBleMac == null || connectDeviceByBleMac.getTerminalType() != 6 || !connectDeviceByBleMac.isPreConnect() || connectDeviceByBleMac.getBleBondStatus() != 0) {
                stopStarryAdv();
                enableFastConnect();
            } else {
                enableFastConnectWithTimeOut(OdnpConfigStatic.OEM_MAX_HIGH_POWER_INTERVAL);
            }
        }
    }

    public void onBluetoothDisabled() {
        StLog.d(TAG, "onBluetoothDisabled");
        this.mStateMachine.sendMessage(2);
        for (StDiscoveryDevice next : StarryDeviceManager.getInstance().getDiscoveryDevices()) {
            if (next.getDeviceType() == 3 && (next.getDiscoveryType() & 1) != 0) {
                StarryDeviceManager.getInstance().loseDevice(next.getIdentifier2String());
            }
        }
        this.mListBleChannel.clear();
    }

    public void onBluetoothEnabled() {
        StLog.d(TAG, "onBluetoothEnabled");
        this.mStateMachine.sendMessage(1);
    }

    public void onBluetoothNameChange(String str) {
    }

    public void onBondStateChanged(StConnectDevice stConnectDevice, int i, int i2) {
        StLog.d(TAG, "onBondStateChanged: status = " + i + " old = " + i2);
    }

    public void onConnectFail(StDevice stDevice, int i, int i2) {
        StLog.v(TAG, "onConnectFail do nothing, code = " + i);
    }

    public void onDiscovered(StDiscoveryDevice stDiscoveryDevice) {
        checkAndResponseDeviceFoundAdv(stDiscoveryDevice);
        for (DiscoveryClient next : this.mListDiscovery) {
            if (next.getFilter().matches(stDiscoveryDevice)) {
                byte[] userData = stDiscoveryDevice.getUserData();
                byte[] bArr = stDiscoveryDevice.getDeviceDetail().get((byte) 4);
                byte b = bArr != null ? bArr[0] : -1;
                Bundle bundle = new Bundle();
                bundle.putByteArray(StConstant.DEVICE_FOUND_BUNDLE_USER_DATA, userData);
                bundle.putByte(StConstant.DEVICE_FOUND_BUNDLE_CONNECT_STATUS, b);
                next.getCallback().onDeviceFound(stDiscoveryDevice.clone(), userData, bundle, next.getFilter());
            }
        }
    }

    public void onDiscoveredFail(int i) {
        StLog.d(TAG, "onDiscoveredFail");
    }

    public void onEvent(Object obj) {
        if (obj instanceof OpenGattServerEvent) {
            StringBuilder sb = new StringBuilder();
            sb.append("receive event OpenGattServerEvent, isReady=");
            OpenGattServerEvent openGattServerEvent = (OpenGattServerEvent) obj;
            sb.append(openGattServerEvent.isReady());
            StLog.d(TAG, sb.toString());
            if (openGattServerEvent.isReady()) {
                BleServerCache.getInstance().updateOpenServerDone(true);
                Message obtainMessage = this.mStateMachine.obtainMessage(3);
                obtainMessage.arg1 = 1;
                this.mStateMachine.sendMessage(obtainMessage);
                return;
            }
            StErrorTips.showErrorTips(StErrorTips.ErrorTips.BLE_GATT_SERVER_NOT_OPEN);
            BleServerCache.getInstance().updateOpenServerDone(false);
            Message obtainMessage2 = this.mStateMachine.obtainMessage(3);
            obtainMessage2.arg1 = 0;
            this.mStateMachine.sendMessage(obtainMessage2);
        }
    }

    public void onLost(StDiscoveryDevice stDiscoveryDevice) {
        if (stDiscoveryDevice.getDeviceType() == 3) {
            StLog.d(TAG, "onLost：" + stDiscoveryDevice + " getDiscoveryType：" + stDiscoveryDevice.getDiscoveryType());
        }
        for (DiscoveryClient next : this.mListDiscovery) {
            if (next.getFilter().matches(stDiscoveryDevice)) {
                next.getCallback().onDeviceLose(stDiscoveryDevice.clone());
            }
        }
    }

    public void onP2pGoConnected(StConnectDevice stConnectDevice) {
    }

    public void onP2pGoDisconnected(StConnectDevice stConnectDevice) {
    }

    public void onScreenOff() {
        this.mStateMachine.sendMessage(6);
    }

    public void onScreenOn() {
        this.mStateMachine.sendMessage(5);
    }

    public void onUupShareDisabled() {
        StLog.d(TAG, "onUupShareDisabled");
        stopUupShareAdv();
    }

    public void onUupShareEnabled() {
        StLog.d(TAG, "onUupShareDisabled");
        startUupShareAdv();
    }

    public int requestConnect(byte[] bArr, long j) {
        return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
    }

    public int reset() {
        SysActionManager.getInstance().unRegisterSysAction(this.mStateChangeSimpleCallback);
        this.mStateMachine.doQuit();
        this.mStateMachine.cleanup();
        this.mStateMachineThread.quitSafely();
        this.mStateMachineThread = null;
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public void restartStarryAdv() {
        this.mStateMachine.sendMessage(14);
    }

    public int setAdvertiseEnableMode(int i) {
        return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
    }

    public void setCarActiveDisconnect(String str) {
    }

    public int setDeviceConnectable(boolean z, int i, String str) {
        StLog.d(TAG, "setDeviceConnectable do nothing");
        return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
    }

    public int setFastConnectProcess(int i) {
        return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
    }

    public int setReconnectEnable(boolean z) {
        return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
    }

    public int startActiveAdv(boolean z) {
        StLog.d(TAG, "startActiveAdv");
        Message obtainMessage = this.mStateMachine.obtainMessage(12);
        obtainMessage.arg1 = 1;
        obtainMessage.arg2 = z ? 1 : 0;
        this.mStateMachine.sendMessage(obtainMessage);
        return 0;
    }

    public int startConnectAdv(byte[] bArr) {
        Message obtainMessage = this.mStateMachine.obtainMessage(12);
        obtainMessage.arg1 = 4;
        Bundle bundle = new Bundle();
        bundle.putByteArray("identifier", bArr);
        obtainMessage.setData(bundle);
        this.mStateMachine.sendMessage(obtainMessage);
        return 0;
    }

    public int startDiscovery(DiscoveryFilter discoveryFilter, DiscoverySettings discoverySettings, IStarryDiscoveryCallback iStarryDiscoveryCallback) {
        StLog.d(TAG, "startDiscovery filter = " + discoveryFilter.getDeviceType() + " callback : " + System.identityHashCode(iStarryDiscoveryCallback));
        if (!SysActionManager.getInstance().isBtOn()) {
            StLog.d(TAG, "Bluetooth off return");
            return StErrorCode.DISCOVERY_STRATEGY_BLUETOOTH_OFF;
        }
        if (discoveryFilter.getDeviceType() == 2) {
            if (SysActionManager.getInstance().isUupShareOn()) {
                startUupShareAdv();
            } else {
                StLog.d(TAG, "Uup Share off return");
                return StErrorCode.DISCOVERY_STRATEGY_UUP_SHARE_OFF;
            }
        }
        DiscoveryClient discoveryClient = new DiscoveryClient(discoveryFilter, iStarryDiscoveryCallback);
        if (this.mListDiscovery.contains(discoveryClient)) {
            StLog.d(TAG, "startDiscovery callback exist");
            return StErrorCode.DISCOVERY_STRATEGY_CALLBACK_EXIST;
        }
        this.mListDiscovery.add(discoveryClient);
        iStarryDiscoveryCallback.onDiscoveryRegistered(discoveryClient.getDiscoveryID());
        StLog.d(TAG, "onDiscoveryRegistered : " + discoveryClient.getDiscoveryID());
        return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
    }

    public int startMultiDeviceFound() {
        StLog.d(TAG, "startMultiDeviceFound do nothing");
        return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
    }

    public int startNotifyAdv(byte[] bArr) {
        Message obtainMessage = this.mStateMachine.obtainMessage(12);
        obtainMessage.arg1 = 16;
        Bundle bundle = new Bundle();
        bundle.putByteArray("identifier", bArr);
        obtainMessage.setData(bundle);
        this.mStateMachine.sendMessage(obtainMessage);
        return 0;
    }

    public int startPassiveAdv(boolean z) {
        Message obtainMessage = this.mStateMachine.obtainMessage(12);
        obtainMessage.arg1 = 2;
        obtainMessage.arg2 = z ? 1 : 0;
        this.mStateMachine.sendMessage(obtainMessage);
        return 0;
    }

    public int startReConnectAdv(byte[] bArr) {
        Message obtainMessage = this.mStateMachine.obtainMessage(12);
        obtainMessage.arg1 = 8;
        obtainMessage.arg2 = 1;
        Bundle bundle = new Bundle();
        bundle.putByteArray("identifier", bArr);
        obtainMessage.setData(bundle);
        this.mStateMachine.sendMessage(obtainMessage);
        return 0;
    }

    public int startScan(DiscoveryFilter discoveryFilter, IStarryDiscoveryCallback iStarryDiscoveryCallback) {
        this.mStateMachine.sendMessage(7);
        return 0;
    }

    public void startUp(short s) {
        StLog.d(TAG, "startUp");
        this.mAdvertiseManager.startUp(s);
    }

    public void startUupShareAdv() {
        Message obtainMessage = this.mStateMachine.obtainMessage(12);
        obtainMessage.arg1 = 32;
        this.mStateMachine.sendMessage(obtainMessage);
    }

    public void startUupShareRspAdv() {
        Message obtainMessage = this.mStateMachine.obtainMessage(12);
        obtainMessage.arg1 = 64;
        this.mStateMachine.sendMessage(obtainMessage);
    }

    public int stopActiveAdv() {
        Message obtainMessage = this.mStateMachine.obtainMessage(13);
        obtainMessage.arg1 = 1;
        this.mStateMachine.sendMessage(obtainMessage);
        return 0;
    }

    public void stopBleScan() {
    }

    public void stopConnectAdv() {
        Message obtainMessage = this.mStateMachine.obtainMessage(13);
        obtainMessage.arg1 = 4;
        this.mStateMachine.sendMessage(obtainMessage);
    }

    public int stopDiscovery(String str) {
        StLog.d(TAG, "stopDiscovery discoveryID: " + str);
        for (DiscoveryClient next : this.mListDiscovery) {
            if (str.equals(next.getDiscoveryID())) {
                this.mListDiscovery.remove(next);
                return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
            }
        }
        return StErrorCode.DISCOVERY_STRATEGY_NOT_TARGET;
    }

    public int stopMultiDeviceFound(boolean z) {
        StLog.d(TAG, "stopMultiDeviceFound do nothing");
        return StErrorCode.DISCOVERY_STRATEGY_UNSUPPORTED_OPERATION;
    }

    public void stopNotifyAdv() {
        Message obtainMessage = this.mStateMachine.obtainMessage(13);
        obtainMessage.arg1 = 16;
        this.mStateMachine.sendMessage(obtainMessage);
    }

    public void stopPassiveAdv() {
        Message obtainMessage = this.mStateMachine.obtainMessage(13);
        obtainMessage.arg1 = 2;
        this.mStateMachine.sendMessage(obtainMessage);
    }

    public void stopReConnectAdv() {
        Message obtainMessage = this.mStateMachine.obtainMessage(13);
        obtainMessage.arg1 = 8;
        this.mStateMachine.sendMessage(obtainMessage);
    }

    public int stopScan(String str) {
        return 0;
    }

    public void stopStarryAdv() {
        int advState = this.mStateMachine.getAdvState();
        StLog.i(TAG, "stopStarryAdv state = " + advState);
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
        if ((advState & 2) > 0) {
            Message obtainMessage3 = this.mStateMachine.obtainMessage(13);
            obtainMessage3.arg1 = 2;
            this.mStateMachine.sendMessage(obtainMessage3);
        }
        if ((advState & 1) > 0) {
            Message obtainMessage4 = this.mStateMachine.obtainMessage(13);
            obtainMessage4.arg1 = 1;
            this.mStateMachine.sendMessage(obtainMessage4);
        }
    }

    public void stopUupShareAdv() {
        Message obtainMessage = this.mStateMachine.obtainMessage(13);
        obtainMessage.arg1 = 32;
        this.mStateMachine.sendMessage(obtainMessage);
    }

    public void stopUupShareRspAdv() {
        Message obtainMessage = this.mStateMachine.obtainMessage(13);
        obtainMessage.arg1 = 64;
        this.mStateMachine.sendMessage(obtainMessage);
    }

    public int upDataAdvParams(byte[] bArr) {
        StLog.d(TAG, "upDataAdvParams");
        if (bArr == null || bArr.length > 7) {
            StLog.e(TAG, "upDataAdvParams data length fail");
            return -1;
        } else if (!AdvPackManager.getPackHelper().initUserId(bArr)) {
            return -1;
        } else {
            restartStarryAdv();
            return StErrorCode.DISCOVERY_STRATEGY_SUCCESS;
        }
    }
}
