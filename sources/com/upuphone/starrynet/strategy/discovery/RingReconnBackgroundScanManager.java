package com.upuphone.starrynet.strategy.discovery;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.channel.Timer;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.core.ble.event.RingBackgroundStateChangeEvent;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"MissingPermission"})
public class RingReconnBackgroundScanManager implements EventReceiver {
    public static final int DISCONNECT_TYPE_ACTIVE = 1;
    public static final int DISCONNECT_TYPE_PASSIVE = 2;
    private final int OP_BACKGROUND_SCAN_STATUS_CHANGE_START;
    private final int OP_BACKGROUND_SCAN_STATUS_CHANGE_STOP;
    private final int OP_BACKGROUND_SCAN_STATUS_CHECK;
    private final int OP_SCREEN_STATE_CHANGE_OFF;
    private final int OP_SCREEN_STATE_CHANGE_ON;
    private final int OP_SCREEN_STATE_CHECK;
    private final int SCAN_TIMEOUT;
    private final String TAG;
    private StConnectDevice mBondedRing;
    private final StarryDeviceManager mDeviceManager;
    private boolean mIsBackgroundScanning;
    private boolean mIsDisconnectByUser;
    private boolean mIsScreenOn;
    private final List<ScanFilter> mLstScanFilter;
    private ScanFilter mRingEmptyFilter;
    private BackgroundScanCallback mRingScanCallback;
    private ScanSettings mRingScanSettingsBalanced;
    private Timer mScanTimer;
    private BluetoothLeScanner mScanner;
    private boolean ringACLConnected;

    public class BackgroundScanCallback extends ScanCallback {
        private BackgroundScanCallback() {
        }

        public void onScanFailed(int i) {
            StLog.e("RingReconnBackgroundScanManager", "scan failed!!");
        }
    }

    public static class Holder {
        /* access modifiers changed from: private */
        public static final RingReconnBackgroundScanManager INSTANCE = new RingReconnBackgroundScanManager();

        private Holder() {
        }
    }

    public class SystemActionChanged extends SysActionManager.StateChangeSimpleCallback {
        private SystemActionChanged() {
        }

        public void onBluetoothDisabled() {
            RingReconnBackgroundScanManager.this.onBluetoothStateChange(false);
        }

        public void onBluetoothEnabled() {
            RingReconnBackgroundScanManager.this.onBluetoothStateChange(true);
        }

        public void onScreenOff() {
            RingReconnBackgroundScanManager.this.onScreenStateChange(false);
        }

        public void onScreenOn() {
            RingReconnBackgroundScanManager.this.onScreenStateChange(true);
        }
    }

    public class scanTimerCallback extends Timer.TimerCallback {
        public scanTimerCallback(String str) {
            super(str);
        }

        public void onTimerCallback() {
            StLog.d("RingReconnBackgroundScanManager", "Terminate background scan timeout");
            RingReconnBackgroundScanManager.this.stopBackgroundScan();
        }

        public void resetCallback() {
        }
    }

    private void disconnectInd(int i) {
        this.ringACLConnected = false;
        if (i == 1) {
            this.mIsDisconnectByUser = true;
        } else if (i == 2 && this.mBondedRing != null) {
            StLog.d("RingReconnBackgroundScanManager", "ring disconnected ind...");
            if (!this.mIsDisconnectByUser) {
                startBackgroundScan();
                if (!opScreenState(0)) {
                    StLog.d("RingReconnBackgroundScanManager", "screen off, start a scan timer");
                    startTimer();
                }
                this.mIsDisconnectByUser = false;
                return;
            }
            StLog.d("RingReconnBackgroundScanManager", "disconnect by user, no need to start background scan");
        }
    }

    public static RingReconnBackgroundScanManager getInstance() {
        return Holder.INSTANCE;
    }

    private void initScanner() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            this.mScanner = defaultAdapter.getBluetoothLeScanner();
        }
    }

    /* access modifiers changed from: private */
    public void onScreenStateChange(boolean z) {
        StLog.d("RingReconnBackgroundScanManager", "current screen state: " + z);
        opScreenState(z ? 1 : 2);
        if (this.mBondedRing == null || this.ringACLConnected) {
            StLog.d("RingReconnBackgroundScanManager", "no bonded ring or ring is connected, (" + this.ringACLConnected + ")no need to care about the screen state");
        } else if (z) {
            if (opBackgroundScanStatus(0)) {
                StLog.d("RingReconnBackgroundScanManager", "remove timer, do not stop scan after 5 minutes");
                stopTimer();
            } else if (!SysActionManager.getInstance().isBtOn()) {
                StLog.d("RingReconnBackgroundScanManager", "BT off, no need to do anything");
            } else if (!this.mIsDisconnectByUser) {
                StLog.d("RingReconnBackgroundScanManager", "start background scan");
                startTimer();
                startBackgroundScan();
            }
        } else if (opBackgroundScanStatus(0)) {
            StLog.d("RingReconnBackgroundScanManager", "screen off, background scan will be terminated after 5 minutes");
            startTimer();
        }
    }

    private synchronized boolean opBackgroundScanStatus(int i) {
        if (i == 1) {
            try {
                StLog.d("RingReconnBackgroundScanManager", "change background scan status: true");
                this.mIsBackgroundScanning = true;
            } catch (Throwable th) {
                throw th;
            }
        } else if (i == 2) {
            StLog.d("RingReconnBackgroundScanManager", "change background scan status: false");
            this.mIsBackgroundScanning = false;
        }
        return this.mIsBackgroundScanning;
    }

    private synchronized boolean opScreenState(int i) {
        if (i == 1) {
            try {
                StLog.d("RingReconnBackgroundScanManager", "change screen status: on");
                this.mIsScreenOn = true;
            } catch (Throwable th) {
                throw th;
            }
        } else if (i == 2) {
            StLog.d("RingReconnBackgroundScanManager", "change screen status: false");
            this.mIsScreenOn = false;
        }
        return this.mIsScreenOn;
    }

    private void startBackgroundScan() {
        if (this.mBondedRing == null || !SysActionManager.getInstance().isBtOn()) {
            StLog.d("RingReconnBackgroundScanManager", "no bonded ring or BT is off, no need to start background scan");
        } else if (!opBackgroundScanStatus(0)) {
            opBackgroundScanStatus(1);
            if (this.mScanner != null) {
                try {
                    StLog.d("RingReconnBackgroundScanManager", "startBackgroundScan done");
                    this.mScanner.startScan(this.mLstScanFilter, this.mRingScanSettingsBalanced, this.mRingScanCallback);
                } catch (IllegalStateException e) {
                    StLog.w("RingReconnBackgroundScanManager", "startBackgroundScan", (Throwable) e);
                }
            }
        } else {
            StLog.d("RingReconnBackgroundScanManager", "background scan IS ongoing");
        }
    }

    private synchronized void startTimer() {
        this.mScanTimer.stop();
        this.mScanTimer.start(new scanTimerCallback("backgroundScanTimer"), 300000);
    }

    /* access modifiers changed from: private */
    public void stopBackgroundScan() {
        if (opBackgroundScanStatus(0)) {
            opBackgroundScanStatus(2);
            BluetoothLeScanner bluetoothLeScanner = this.mScanner;
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.stopScan(this.mRingScanCallback);
            }
            StLog.d("RingReconnBackgroundScanManager", "stopBackgroundScan done");
            return;
        }
        StLog.d("RingReconnBackgroundScanManager", "background scan NOT ongoing");
    }

    private synchronized void stopTimer() {
        this.mScanTimer.stop();
    }

    public void bondedInd(String str) {
        this.ringACLConnected = true;
        stopBackgroundScan();
        List<StConnectDevice> bondInfoByTerminal = this.mDeviceManager.getBondInfoByTerminal(5);
        if (!(bondInfoByTerminal == null || bondInfoByTerminal.size() == 0)) {
            this.mBondedRing = bondInfoByTerminal.get(0);
        }
        StConnectDevice stConnectDevice = this.mBondedRing;
        if (stConnectDevice != null) {
            StLog.d("RingReconnBackgroundScanManager", "bonded ring: ", stConnectDevice.getAddress());
        } else {
            StLog.e("RingReconnBackgroundScanManager", "bonded ring cannot be found");
        }
    }

    public synchronized void connectInd(String str) {
        this.ringACLConnected = true;
        StConnectDevice stConnectDevice = this.mBondedRing;
        if (stConnectDevice == null) {
            StLog.w("RingReconnBackgroundScanManager", "only acl connected");
            return;
        }
        this.mIsDisconnectByUser = false;
        if (!stConnectDevice.getBleMac().equals(str)) {
            StLog.d("RingReconnBackgroundScanManager", "update bonded ring info");
            this.mBondedRing = this.mDeviceManager.getConnectDeviceByBleMac(str);
        }
        if (!opBackgroundScanStatus(0)) {
            StLog.d("RingReconnBackgroundScanManager", "Not Scanning, do noting");
            return;
        }
        StLog.d("RingReconnBackgroundScanManager", "ring connected ind, background Scan going, stop it");
        stopTimer();
        stopBackgroundScan();
    }

    public void disconnectLinkLoss() {
        disconnectInd(2);
    }

    public void onBluetoothStateChange(boolean z) {
        StLog.d("RingReconnBackgroundScanManager", "BT state: " + z);
        if (z) {
            initScanner();
            if (this.mBondedRing != null && !this.ringACLConnected) {
                startBackgroundScan();
                if (!opScreenState(0)) {
                    startTimer();
                    return;
                }
                return;
            }
            return;
        }
        opBackgroundScanStatus(2);
        stopTimer();
        this.mIsDisconnectByUser = false;
        this.ringACLConnected = false;
    }

    public void onEvent(Object obj) {
        if ((obj instanceof RingBackgroundStateChangeEvent) && ((RingBackgroundStateChangeEvent) obj).getState() == 6) {
            disconnectInd(1);
        }
    }

    public void unbindInd() {
        stopBackgroundScan();
        StLog.d("RingReconnBackgroundScanManager", "ring is unbonded");
        this.mBondedRing = null;
    }

    private RingReconnBackgroundScanManager() {
        this.TAG = "RingReconnBackgroundScanManager";
        ArrayList arrayList = new ArrayList();
        this.mLstScanFilter = arrayList;
        this.SCAN_TIMEOUT = 300000;
        this.OP_SCREEN_STATE_CHECK = 0;
        this.OP_SCREEN_STATE_CHANGE_ON = 1;
        this.OP_SCREEN_STATE_CHANGE_OFF = 2;
        this.OP_BACKGROUND_SCAN_STATUS_CHECK = 0;
        this.OP_BACKGROUND_SCAN_STATUS_CHANGE_START = 1;
        this.OP_BACKGROUND_SCAN_STATUS_CHANGE_STOP = 2;
        this.mIsBackgroundScanning = false;
        this.mIsDisconnectByUser = false;
        this.ringACLConnected = false;
        this.mScanTimer = Timer.newInstance();
        this.mIsScreenOn = SysActionManager.getInstance().isScreenOn();
        StarryDeviceManager instance = StarryDeviceManager.getInstance();
        this.mDeviceManager = instance;
        initScanner();
        ScanFilter build = new ScanFilter.Builder().setDeviceName("notReport").build();
        this.mRingEmptyFilter = build;
        arrayList.add(build);
        this.mRingScanSettingsBalanced = new ScanSettings.Builder().setScanMode(1).setCallbackType(2).setMatchMode(1).build();
        this.mRingScanCallback = new BackgroundScanCallback();
        BleEventBus.get().register(RingBackgroundStateChangeEvent.class, this);
        List<StConnectDevice> bondInfoByTerminal = instance.getBondInfoByTerminal(5);
        if (!(bondInfoByTerminal == null || bondInfoByTerminal.size() == 0)) {
            this.mBondedRing = bondInfoByTerminal.get(0);
        }
        if (SysActionManager.getInstance().isBtOn() && this.mBondedRing != null && !this.ringACLConnected) {
            StLog.d("RingReconnBackgroundScanManager", "there is a bonded ring waiting for reconnect, start background scan...");
            startBackgroundScan();
            if (!this.mIsScreenOn) {
                startTimer();
                StLog.d("RingReconnBackgroundScanManager", "background scan will be terminated after 5 minutes");
            }
        }
        SysActionManager.getInstance().registerSysAction(new SystemActionChanged());
    }
}
