package com.upuphone.starrynet.strategy.discovery;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.upuphone.starrynet.common.ReLog;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.config.CarConfigs;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.advertiser.AdvertiserManager;
import com.upuphone.starrynet.strategy.discovery.scanner.ScanManager;
import com.upuphone.starrynet.strategy.statemachine.State;
import com.upuphone.starrynet.strategy.statemachine.StateMachine;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.security.SecureRandom;
import java.util.List;

public class DiscoveryStateMachine extends StateMachine {
    static final int GATT_SERVER_STATE_OFF = 0;
    static final int GATT_SERVER_STATE_ON = 1;
    static final String KEY_CONNECT_ID = "identifier";
    static final int MSG_ACTIVE_ADV_TIMEOUT = 21;
    static final int MSG_ADD_BEACON_ID = 40;
    static final int MSG_ADV_ENABLE_MODE_CHANGE = 31;
    static final int MSG_ADV_STATE_CHANGE = 30;
    static final int MSG_ADV_STR_MODE_CHANGE = 32;
    static final int MSG_BOND_STATE_CHANGE_SERVER = 11;
    static final int MSG_BT_OFF = 2;
    static final int MSG_BT_ON = 1;
    static final int MSG_CONNECT_ADV_TIMEOUT = 23;
    static final int MSG_GATT_SERVER_STATE_CHANGE = 3;
    static final int MSG_NOTIFY_ADV_TIMEOUT = 24;
    static final int MSG_PASSIVE_ADV_TIMEOUT = 22;
    static final int MSG_RECONNECT_ADV_TIMEOUT = 25;
    static final int MSG_RESTART_SCAN = 9;
    static final int MSG_RESTART_STARRY_ADV = 14;
    static final int MSG_RETRY_START_ADV = 15;
    static final int MSG_SCREEN_OFF = 6;
    static final int MSG_SCREEN_ON = 5;
    static final int MSG_START_ADV = 12;
    static final int MSG_START_SCAN = 7;
    static final int MSG_START_SCAN_LOW_POWER = 8;
    static final int MSG_STOP_ADV = 13;
    static final int MSG_STOP_SCAN = 10;
    static final int MSG_UUP_SHARE_ADV_TIMEOUT = 26;
    static final int MSG_UUP_SHARE_RSP_ADV_TIMEOUT = 27;
    private static final String TAG = "DiscoveryStateMachine";
    static final int TIMES_RETRY_ADV = 10;
    static final int TIME_INTERVAL_ADV_LONG = 120000;
    static final int TIME_INTERVAL_ADV_SHORT = 20000;
    static final int TIME_RESTART_ADV_DELAY = 1000;
    static final int TIME_RETRY_ADV_DELAY = 2000;
    boolean isAdvModeEnable = true;
    boolean isGattServerReady;
    boolean isStrModeEnter = false;
    /* access modifiers changed from: private */
    public ActiveState mActiveState;
    protected int mAdvRetryTimes = 10;
    /* access modifiers changed from: private */
    public volatile int mAdvState = 0;
    /* access modifiers changed from: private */
    public AdvertiserManager mAdvertiserManager;
    private int mBeaconId;
    protected boolean mIsLowPowerScanning;
    protected boolean mIsScanning;
    /* access modifiers changed from: private */
    public boolean mLimitScanFreq = false;
    /* access modifiers changed from: private */
    public byte[] mNeedReconnectId = null;
    /* access modifiers changed from: private */
    public boolean mNeedRepeatActiveAdv;
    /* access modifiers changed from: private */
    public boolean mNeedRepeatPassiveAdv;
    /* access modifiers changed from: private */
    public boolean mNeedRepeatReconnectAdv;
    protected boolean mNeedScan;
    private boolean mNeedUupShareAdv;
    /* access modifiers changed from: private */
    public long mPassiveAdvTime = 0;
    /* access modifiers changed from: private */
    public ScanManager mScanManager;
    /* access modifiers changed from: private */
    public ScreenOffState mScreenOffState;
    /* access modifiers changed from: private */
    public StandbyState mStandbyState;
    protected int recordScanMode = -1;

    public class ActiveState extends State {
        public ActiveState() {
        }

        public void enter() {
            super.enter();
            StLog.d(DiscoveryStateMachine.TAG, "ActiveState state enter: ");
            DiscoveryStateMachine discoveryStateMachine = DiscoveryStateMachine.this;
            if (discoveryStateMachine.mIsLowPowerScanning) {
                discoveryStateMachine.stopLowScan();
            }
            DiscoveryStateMachine discoveryStateMachine2 = DiscoveryStateMachine.this;
            if (discoveryStateMachine2.mNeedScan) {
                if (discoveryStateMachine2.mLimitScanFreq) {
                    DiscoveryStateMachine.this.sendMessageAtFrontOfQueue(8);
                } else {
                    DiscoveryStateMachine.this.sendMessageAtFrontOfQueue(7);
                }
            }
            DiscoveryStateMachine.this.checkAndStartAdv();
        }

        public void exit() {
            super.exit();
            StLog.d(DiscoveryStateMachine.TAG, "ActiveState state exit");
        }

        public boolean processMessage(Message message) {
            int i = message.what;
            if (i != 2) {
                boolean z = false;
                if (i == 3) {
                    StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_GATT_SERVER_STATE_CHANGE");
                    DiscoveryStateMachine discoveryStateMachine = DiscoveryStateMachine.this;
                    if (message.arg1 == 1) {
                        z = true;
                    }
                    discoveryStateMachine.isGattServerReady = z;
                    discoveryStateMachine.checkAndStartAdv();
                } else if (i != 40) {
                    switch (i) {
                        case 6:
                            StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_SCREEN_OFF");
                            DiscoveryStateMachine discoveryStateMachine2 = DiscoveryStateMachine.this;
                            discoveryStateMachine2.transitionTo(discoveryStateMachine2.mScreenOffState);
                            break;
                        case 7:
                            StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_START_SCAN");
                            DiscoveryStateMachine discoveryStateMachine3 = DiscoveryStateMachine.this;
                            discoveryStateMachine3.mNeedScan = true;
                            if (!discoveryStateMachine3.mIsScanning && !discoveryStateMachine3.mLimitScanFreq) {
                                DiscoveryStateMachine discoveryStateMachine4 = DiscoveryStateMachine.this;
                                if (discoveryStateMachine4.mIsLowPowerScanning) {
                                    discoveryStateMachine4.stopLowScan();
                                }
                                DiscoveryStateMachine.this.startHighScan();
                                DiscoveryStateMachine.this.recordScanMode = 0;
                                break;
                            }
                        case 8:
                            StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_START_SCAN_LOW_POWER");
                            DiscoveryStateMachine discoveryStateMachine5 = DiscoveryStateMachine.this;
                            discoveryStateMachine5.mNeedScan = true;
                            if (!discoveryStateMachine5.mIsLowPowerScanning) {
                                if (discoveryStateMachine5.mIsScanning) {
                                    discoveryStateMachine5.stopHighScan();
                                }
                                DiscoveryStateMachine.this.startLowScan();
                                DiscoveryStateMachine.this.recordScanMode = 1;
                                break;
                            }
                            break;
                        case 9:
                            StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_RESTART_SCAN");
                            DiscoveryStateMachine discoveryStateMachine6 = DiscoveryStateMachine.this;
                            int i2 = discoveryStateMachine6.recordScanMode;
                            if (i2 != 0) {
                                if (i2 == 1) {
                                    discoveryStateMachine6.sendMessage(8);
                                    break;
                                }
                            } else {
                                discoveryStateMachine6.sendMessage(7);
                                break;
                            }
                            break;
                        case 10:
                            StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_STOP_SCAN");
                            DiscoveryStateMachine discoveryStateMachine7 = DiscoveryStateMachine.this;
                            discoveryStateMachine7.mNeedScan = false;
                            if (discoveryStateMachine7.mIsScanning) {
                                discoveryStateMachine7.stopHighScan();
                            }
                            DiscoveryStateMachine discoveryStateMachine8 = DiscoveryStateMachine.this;
                            if (discoveryStateMachine8.mIsLowPowerScanning) {
                                discoveryStateMachine8.stopLowScan();
                            }
                            DiscoveryStateMachine.this.resetScanRecord();
                            break;
                        case 11:
                            StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_BOND_STATE_CHANGE_SERVER");
                            byte[] unused = DiscoveryStateMachine.this.mNeedReconnectId = message.getData().getByteArray("identifier");
                            break;
                        case 12:
                            int i3 = message.arg1;
                            int i4 = message.arg2;
                            byte[] byteArray = message.getData().getByteArray("identifier");
                            if (i4 == 1) {
                                DiscoveryStateMachine.this.recordAdvDemand(i3, byteArray);
                            }
                            if (DiscoveryStateMachine.this.isAdvEnable()) {
                                DiscoveryStateMachine.this.startAdv(i3, byteArray);
                            }
                            DiscoveryStateMachine.this.cleanRetryAdv();
                            break;
                        case 13:
                            StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_STOP_ADV");
                            int i5 = message.arg1;
                            DiscoveryStateMachine.this.deleteAdvDemand(i5);
                            DiscoveryStateMachine.this.mAdvertiserManager.stopAdv(i5);
                            DiscoveryStateMachine discoveryStateMachine9 = DiscoveryStateMachine.this;
                            discoveryStateMachine9.setAdvState((~i5) & discoveryStateMachine9.mAdvState);
                            DiscoveryStateMachine.this.cleanRetryAdv();
                            break;
                        case 14:
                            StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_RESTART_STARRY_ADV");
                            if ((DiscoveryStateMachine.this.mAdvState & 1) <= 0) {
                                if ((DiscoveryStateMachine.this.mAdvState & 2) <= 0) {
                                    if ((DiscoveryStateMachine.this.mAdvState & 8) > 0) {
                                        DiscoveryStateMachine.this.mAdvertiserManager.stopAdv(8);
                                        DiscoveryStateMachine discoveryStateMachine10 = DiscoveryStateMachine.this;
                                        discoveryStateMachine10.setAdvState(discoveryStateMachine10.mAdvState & -9);
                                        DiscoveryStateMachine discoveryStateMachine11 = DiscoveryStateMachine.this;
                                        discoveryStateMachine11.startAdv(8, discoveryStateMachine11.mNeedReconnectId);
                                        break;
                                    }
                                } else {
                                    DiscoveryStateMachine.this.mAdvertiserManager.stopAdv(2);
                                    DiscoveryStateMachine discoveryStateMachine12 = DiscoveryStateMachine.this;
                                    discoveryStateMachine12.setAdvState(discoveryStateMachine12.mAdvState & -3);
                                    DiscoveryStateMachine.this.startAdv(2, (byte[]) null);
                                    break;
                                }
                            } else {
                                DiscoveryStateMachine.this.mAdvertiserManager.stopAdv(1);
                                DiscoveryStateMachine discoveryStateMachine13 = DiscoveryStateMachine.this;
                                discoveryStateMachine13.setAdvState(discoveryStateMachine13.mAdvState & -2);
                                DiscoveryStateMachine discoveryStateMachine14 = DiscoveryStateMachine.this;
                                discoveryStateMachine14.startAdv(1, discoveryStateMachine14.mNeedReconnectId);
                                break;
                            }
                            break;
                        case 15:
                            StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_RETRY_START_ADV");
                            int i6 = message.arg1;
                            int i7 = message.arg2;
                            byte[] byteArray2 = message.getData().getByteArray("identifier");
                            if (i7 == 1) {
                                DiscoveryStateMachine.this.recordAdvDemand(i6, byteArray2);
                            }
                            if (DiscoveryStateMachine.this.isAdvEnable()) {
                                DiscoveryStateMachine.this.startAdv(i6, byteArray2);
                                break;
                            }
                            break;
                        default:
                            switch (i) {
                                case 21:
                                    StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_ACTIVE_ADV_TIMEOUT");
                                    DiscoveryStateMachine discoveryStateMachine15 = DiscoveryStateMachine.this;
                                    discoveryStateMachine15.setAdvState(discoveryStateMachine15.mAdvState & -2);
                                    if (DiscoveryStateMachine.this.mNeedRepeatActiveAdv && DiscoveryStateMachine.this.isAdvEnable()) {
                                        DiscoveryStateMachine.this.startAdv(1, (byte[]) null);
                                        break;
                                    }
                                case 22:
                                    StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_PASSIVE_ADV_TIMEOUT");
                                    DiscoveryStateMachine discoveryStateMachine16 = DiscoveryStateMachine.this;
                                    discoveryStateMachine16.setAdvState(discoveryStateMachine16.mAdvState & -3);
                                    DiscoveryStateMachine.this.mAdvertiserManager.stopAdv(2);
                                    if (DiscoveryStateMachine.this.mNeedRepeatPassiveAdv && DiscoveryStateMachine.this.isAdvEnable()) {
                                        DiscoveryStateMachine discoveryStateMachine17 = DiscoveryStateMachine.this;
                                        discoveryStateMachine17.startAdv(2, discoveryStateMachine17.mNeedReconnectId);
                                        break;
                                    }
                                case 23:
                                    StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_CONNECT_ADV_TIMEOUT");
                                    DiscoveryStateMachine discoveryStateMachine18 = DiscoveryStateMachine.this;
                                    discoveryStateMachine18.setAdvState(discoveryStateMachine18.mAdvState & -5);
                                    break;
                                case 24:
                                    StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_NOTIFY_ADV_TIMEOUT");
                                    DiscoveryStateMachine discoveryStateMachine19 = DiscoveryStateMachine.this;
                                    discoveryStateMachine19.setAdvState(discoveryStateMachine19.mAdvState & -17);
                                    break;
                                case 25:
                                    StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_RECONNECT_ADV_TIMEOUT");
                                    DiscoveryStateMachine discoveryStateMachine20 = DiscoveryStateMachine.this;
                                    discoveryStateMachine20.setAdvState(discoveryStateMachine20.mAdvState & -9);
                                    if (DiscoveryStateMachine.this.mNeedRepeatReconnectAdv && DiscoveryStateMachine.this.isAdvEnable()) {
                                        DiscoveryStateMachine discoveryStateMachine21 = DiscoveryStateMachine.this;
                                        discoveryStateMachine21.startAdv(8, discoveryStateMachine21.mNeedReconnectId);
                                        break;
                                    }
                                case 26:
                                    StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_UUP_SHARE_ADV_TIMEOUT");
                                    DiscoveryStateMachine discoveryStateMachine22 = DiscoveryStateMachine.this;
                                    discoveryStateMachine22.setAdvState(discoveryStateMachine22.mAdvState & -33);
                                    break;
                                case 27:
                                    StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_UUP_SHARE_RSP_ADV_TIMEOUT");
                                    DiscoveryStateMachine discoveryStateMachine23 = DiscoveryStateMachine.this;
                                    discoveryStateMachine23.setAdvState(discoveryStateMachine23.mAdvState & -65);
                                    break;
                                default:
                                    switch (i) {
                                        case 30:
                                            StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_ADV_STATE_CHANGE");
                                            int i8 = message.arg1;
                                            int i9 = message.arg2;
                                            if (i9 != 0 && i9 != 3) {
                                                DiscoveryStateMachine discoveryStateMachine24 = DiscoveryStateMachine.this;
                                                discoveryStateMachine24.retryStartAdv(i8, discoveryStateMachine24.mNeedReconnectId);
                                                DiscoveryStateMachine.this.deleteAdvDemand(i8);
                                                DiscoveryStateMachine.this.mAdvertiserManager.stopAdv(i8);
                                                break;
                                            } else {
                                                DiscoveryStateMachine discoveryStateMachine25 = DiscoveryStateMachine.this;
                                                discoveryStateMachine25.setAdvState(i8 | discoveryStateMachine25.mAdvState);
                                                break;
                                            }
                                        case 31:
                                            StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_ADV_ENABLE_MODE_CHANGE");
                                            DiscoveryStateMachine discoveryStateMachine26 = DiscoveryStateMachine.this;
                                            if (message.arg1 == 1) {
                                                z = true;
                                            }
                                            discoveryStateMachine26.isAdvModeEnable = z;
                                            break;
                                        case 32:
                                            StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_ADV_STR_MODE_CHANGE");
                                            DiscoveryStateMachine.this.isStrModeEnter = ((Boolean) message.obj).booleanValue();
                                            break;
                                    }
                            }
                            break;
                    }
                } else {
                    StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_ADD_BEACON_ID");
                    DiscoveryStateMachine.this.addBeaconId();
                }
            } else {
                StLog.d(DiscoveryStateMachine.TAG, "ActiveState processMessage : MSG_BT_OFF");
                DiscoveryStateMachine discoveryStateMachine27 = DiscoveryStateMachine.this;
                discoveryStateMachine27.transitionTo(discoveryStateMachine27.mStandbyState);
            }
            return super.processMessage(message);
        }
    }

    public class ScreenOffState extends State {
        public ScreenOffState() {
        }

        public void enter() {
            super.enter();
            StLog.d(DiscoveryStateMachine.TAG, "ScreenOffState state enter");
            DiscoveryStateMachine discoveryStateMachine = DiscoveryStateMachine.this;
            if (discoveryStateMachine.mIsScanning) {
                discoveryStateMachine.stopHighScan();
            }
            DiscoveryStateMachine discoveryStateMachine2 = DiscoveryStateMachine.this;
            if (discoveryStateMachine2.mNeedScan) {
                discoveryStateMachine2.sendMessageAtFrontOfQueue(8);
            }
        }

        public void exit() {
            super.exit();
            StLog.d(DiscoveryStateMachine.TAG, "ScreenOffState state exit");
        }

        public boolean processMessage(Message message) {
            StLog.d(DiscoveryStateMachine.TAG, "ScreenOffState processMessage : " + message.what);
            int i = message.what;
            if (i != 2) {
                boolean z = false;
                if (i == 3) {
                    DiscoveryStateMachine discoveryStateMachine = DiscoveryStateMachine.this;
                    if (message.arg1 == 1) {
                        z = true;
                    }
                    discoveryStateMachine.isGattServerReady = z;
                    if (!discoveryStateMachine.mNeedRepeatReconnectAdv) {
                        StLog.d(DiscoveryStateMachine.TAG, "MSG_GATT_SERVER_STATE_CHANGE no need start reconnect adv");
                    } else if (DiscoveryStateMachine.this.isAdvEnable()) {
                        DiscoveryStateMachine discoveryStateMachine2 = DiscoveryStateMachine.this;
                        discoveryStateMachine2.startAdv(8, discoveryStateMachine2.mNeedReconnectId);
                    }
                } else if (i == 5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (DiscoveryStateMachine.this.hasMessages(22) && currentTimeMillis - DiscoveryStateMachine.this.mPassiveAdvTime > 121000) {
                        StLog.d(DiscoveryStateMachine.TAG, "trigger passive adv timeout");
                        DiscoveryStateMachine.this.removeMessages(22);
                        DiscoveryStateMachine discoveryStateMachine3 = DiscoveryStateMachine.this;
                        discoveryStateMachine3.setAdvState(discoveryStateMachine3.mAdvState & -3);
                        DiscoveryStateMachine.this.mAdvertiserManager.stopAdv(2);
                    }
                    DiscoveryStateMachine discoveryStateMachine4 = DiscoveryStateMachine.this;
                    discoveryStateMachine4.transitionTo(discoveryStateMachine4.mActiveState);
                } else if (i == 15) {
                    int i2 = message.arg1;
                    int i3 = message.arg2;
                    byte[] byteArray = message.getData().getByteArray("identifier");
                    if (i3 == 1) {
                        DiscoveryStateMachine.this.recordAdvDemand(i2, byteArray);
                    }
                    if (DiscoveryStateMachine.this.isAdvEnable()) {
                        DiscoveryStateMachine.this.startAdv(i2, byteArray);
                    }
                } else if (i == 40) {
                    DiscoveryStateMachine.this.addBeaconId();
                } else if (i == 12) {
                    int i4 = message.arg1;
                    int i5 = message.arg2;
                    byte[] byteArray2 = message.getData().getByteArray("identifier");
                    if (i5 == 1) {
                        DiscoveryStateMachine.this.recordAdvDemand(i4, byteArray2);
                    }
                    if (i4 != 8) {
                        ReLog.d(DiscoveryStateMachine.TAG, "screen off state only support reconnect adv");
                    } else if (DiscoveryStateMachine.this.isAdvEnable()) {
                        DiscoveryStateMachine.this.startAdv(i4, byteArray2);
                    }
                    DiscoveryStateMachine.this.cleanRetryAdv();
                } else if (i != 13) {
                    switch (i) {
                        case 7:
                        case 8:
                        case 9:
                            DiscoveryStateMachine discoveryStateMachine5 = DiscoveryStateMachine.this;
                            discoveryStateMachine5.mNeedScan = true;
                            if (!discoveryStateMachine5.mIsLowPowerScanning) {
                                if (StarryDeviceManager.getInstance().getCurBondInfo() == null) {
                                    StLog.d(DiscoveryStateMachine.TAG, "no BondInfo, no need to startLowPowerBackgroundScan!");
                                    break;
                                } else {
                                    DiscoveryStateMachine.this.startLowScan();
                                    break;
                                }
                            } else if (StarryDeviceManager.getInstance().getCurBondInfo() != null) {
                                if (!DiscoveryStateMachine.this.mLimitScanFreq) {
                                    StLog.d(DiscoveryStateMachine.TAG, "LowPowerScanning, no need to startLowPowerBackgroundScan!");
                                    break;
                                } else {
                                    DiscoveryStateMachine.this.startLowScan();
                                    break;
                                }
                            } else {
                                DiscoveryStateMachine.this.stopLowScan();
                                break;
                            }
                        case 10:
                            DiscoveryStateMachine discoveryStateMachine6 = DiscoveryStateMachine.this;
                            discoveryStateMachine6.mNeedScan = false;
                            if (discoveryStateMachine6.mIsLowPowerScanning) {
                                discoveryStateMachine6.stopLowScan();
                            }
                            DiscoveryStateMachine discoveryStateMachine7 = DiscoveryStateMachine.this;
                            if (discoveryStateMachine7.mIsScanning) {
                                discoveryStateMachine7.stopHighScan();
                            }
                            DiscoveryStateMachine.this.resetScanRecord();
                            break;
                        default:
                            switch (i) {
                                case 21:
                                    DiscoveryStateMachine discoveryStateMachine8 = DiscoveryStateMachine.this;
                                    discoveryStateMachine8.setAdvState(discoveryStateMachine8.mAdvState & -2);
                                    break;
                                case 22:
                                    DiscoveryStateMachine discoveryStateMachine9 = DiscoveryStateMachine.this;
                                    discoveryStateMachine9.setAdvState(discoveryStateMachine9.mAdvState & -3);
                                    DiscoveryStateMachine.this.mAdvertiserManager.stopAdv(2);
                                    break;
                                case 23:
                                    DiscoveryStateMachine discoveryStateMachine10 = DiscoveryStateMachine.this;
                                    discoveryStateMachine10.setAdvState(discoveryStateMachine10.mAdvState & -5);
                                    break;
                                case 24:
                                    DiscoveryStateMachine discoveryStateMachine11 = DiscoveryStateMachine.this;
                                    discoveryStateMachine11.setAdvState(discoveryStateMachine11.mAdvState & -17);
                                    break;
                                case 25:
                                    DiscoveryStateMachine discoveryStateMachine12 = DiscoveryStateMachine.this;
                                    discoveryStateMachine12.setAdvState(discoveryStateMachine12.mAdvState & -9);
                                    if (DiscoveryStateMachine.this.mNeedRepeatReconnectAdv && DiscoveryStateMachine.this.isAdvEnable()) {
                                        DiscoveryStateMachine discoveryStateMachine13 = DiscoveryStateMachine.this;
                                        discoveryStateMachine13.startAdv(8, discoveryStateMachine13.mNeedReconnectId);
                                        break;
                                    }
                                case 26:
                                    DiscoveryStateMachine discoveryStateMachine14 = DiscoveryStateMachine.this;
                                    discoveryStateMachine14.setAdvState(discoveryStateMachine14.mAdvState & -33);
                                    break;
                                case 27:
                                    DiscoveryStateMachine discoveryStateMachine15 = DiscoveryStateMachine.this;
                                    discoveryStateMachine15.setAdvState(discoveryStateMachine15.mAdvState & -65);
                                    break;
                                default:
                                    switch (i) {
                                        case 30:
                                            int i6 = message.arg1;
                                            int i7 = message.arg2;
                                            if (i7 != 0 && i7 != 3) {
                                                DiscoveryStateMachine discoveryStateMachine16 = DiscoveryStateMachine.this;
                                                discoveryStateMachine16.retryStartAdv(i6, discoveryStateMachine16.mNeedReconnectId);
                                                DiscoveryStateMachine.this.deleteAdvDemand(i6);
                                                DiscoveryStateMachine.this.mAdvertiserManager.stopAdv(i6);
                                                break;
                                            } else {
                                                DiscoveryStateMachine discoveryStateMachine17 = DiscoveryStateMachine.this;
                                                discoveryStateMachine17.setAdvState(i6 | discoveryStateMachine17.mAdvState);
                                                break;
                                            }
                                        case 31:
                                            StLog.d(DiscoveryStateMachine.TAG, "ScreenOffState processMessage : MSG_ADV_ENABLE_MODE_CHANGE");
                                            DiscoveryStateMachine discoveryStateMachine18 = DiscoveryStateMachine.this;
                                            if (message.arg1 == 1) {
                                                z = true;
                                            }
                                            discoveryStateMachine18.isAdvModeEnable = z;
                                            break;
                                        case 32:
                                            StLog.d(DiscoveryStateMachine.TAG, "ScreenOffState processMessage : MSG_ADV_STR_MODE_CHANGE");
                                            DiscoveryStateMachine.this.isStrModeEnter = ((Boolean) message.obj).booleanValue();
                                            break;
                                    }
                            }
                            break;
                    }
                } else {
                    int i8 = message.arg1;
                    DiscoveryStateMachine.this.deleteAdvDemand(i8);
                    DiscoveryStateMachine.this.mAdvertiserManager.stopAdv(i8);
                    DiscoveryStateMachine discoveryStateMachine19 = DiscoveryStateMachine.this;
                    discoveryStateMachine19.setAdvState((~i8) & discoveryStateMachine19.mAdvState);
                    DiscoveryStateMachine.this.cleanRetryAdv();
                }
            } else {
                DiscoveryStateMachine discoveryStateMachine20 = DiscoveryStateMachine.this;
                discoveryStateMachine20.transitionTo(discoveryStateMachine20.mStandbyState);
            }
            return super.processMessage(message);
        }
    }

    public class StandbyState extends State {
        public StandbyState() {
        }

        public void enter() {
            super.enter();
            StLog.d(DiscoveryStateMachine.TAG, "StandbyState state enter");
            DiscoveryStateMachine.this.mScanManager.onBluetoothDisabled();
            DiscoveryStateMachine discoveryStateMachine = DiscoveryStateMachine.this;
            discoveryStateMachine.mIsScanning = false;
            discoveryStateMachine.mIsLowPowerScanning = false;
            discoveryStateMachine.isGattServerReady = false;
            boolean unused = discoveryStateMachine.mLimitScanFreq = false;
            DiscoveryStateMachine.this.setAdvState(0);
            DiscoveryStateMachine.this.removeAllDeferredMessages();
            DiscoveryStateMachine.this.addBeaconId();
            DiscoveryStateMachine.this.cleanRetryAdv();
        }

        public void exit() {
            super.exit();
            StLog.d(DiscoveryStateMachine.TAG, "StandbyState state exit");
        }

        public boolean processMessage(Message message) {
            StLog.d(DiscoveryStateMachine.TAG, "StandbyState processMessage : " + message.what);
            int i = message.what;
            boolean z = true;
            if (i == 1) {
                DiscoveryStateMachine.this.mScanManager.onBluetoothEnabled();
                DiscoveryStateMachine.this.mAdvertiserManager.initAdvertiser();
                if (SysActionManager.getInstance().isScreenOn()) {
                    DiscoveryStateMachine discoveryStateMachine = DiscoveryStateMachine.this;
                    discoveryStateMachine.transitionTo(discoveryStateMachine.mActiveState);
                } else {
                    DiscoveryStateMachine discoveryStateMachine2 = DiscoveryStateMachine.this;
                    discoveryStateMachine2.transitionTo(discoveryStateMachine2.mScreenOffState);
                }
            } else if (i == 12) {
                int i2 = message.arg1;
                int i3 = message.arg2;
                byte[] byteArray = message.getData().getByteArray("identifier");
                if (i3 == 1) {
                    DiscoveryStateMachine.this.recordAdvDemand(i2, byteArray);
                }
            } else if (i == 13) {
                DiscoveryStateMachine.this.deleteAdvDemand(message.arg1);
            } else if (i == 31) {
                DiscoveryStateMachine discoveryStateMachine3 = DiscoveryStateMachine.this;
                if (message.arg1 != 1) {
                    z = false;
                }
                discoveryStateMachine3.isAdvModeEnable = z;
            } else if (i != 32) {
                switch (i) {
                    case 7:
                    case 8:
                    case 9:
                        DiscoveryStateMachine.this.mNeedScan = true;
                        break;
                    case 10:
                        DiscoveryStateMachine discoveryStateMachine4 = DiscoveryStateMachine.this;
                        discoveryStateMachine4.mNeedScan = false;
                        discoveryStateMachine4.resetScanRecord();
                        break;
                }
            } else {
                StLog.d(DiscoveryStateMachine.TAG, "StandbyState processMessage : MSG_ADV_STR_MODE_CHANGE");
                DiscoveryStateMachine.this.isStrModeEnter = ((Boolean) message.obj).booleanValue();
            }
            return super.processMessage(message);
        }
    }

    public DiscoveryStateMachine(Context context, Looper looper, AdvertiserManager advertiserManager) {
        super(TAG, looper);
        this.mScanManager = new ScanManager(context.getApplicationContext());
        this.mAdvertiserManager = advertiserManager;
        this.mBeaconId = new SecureRandom().nextInt(127);
        this.mScreenOffState = new ScreenOffState();
        this.mActiveState = new ActiveState();
        this.mStandbyState = new StandbyState();
        addState(this.mScreenOffState);
        addState(this.mActiveState);
        addState(this.mStandbyState);
        if (!SysActionManager.getInstance().isBtOn()) {
            setInitialState(this.mStandbyState);
        } else if (SysActionManager.getInstance().isScreenOn()) {
            setInitialState(this.mActiveState);
        } else {
            setInitialState(this.mScreenOffState);
        }
    }

    /* access modifiers changed from: private */
    public void checkAndStartAdv() {
        dealNeedReconnectAdv();
        StLog.d(TAG, "checkAndStartAdv: mNeedReconnect = " + this.mNeedRepeatReconnectAdv + " mNeedRepeatPassiveAdv = " + this.mNeedRepeatPassiveAdv + " mNeedRepeatActiveAdv = " + this.mNeedRepeatActiveAdv + " mNeedUupShareAdv = " + this.mNeedUupShareAdv);
        if (!isAdvEnable()) {
            return;
        }
        if (this.mNeedRepeatReconnectAdv) {
            startAdv(8, this.mNeedReconnectId);
        } else if (this.mNeedRepeatPassiveAdv) {
            startAdv(2, (byte[]) null);
        } else if (this.mNeedRepeatActiveAdv) {
            startAdv(1, (byte[]) null);
        } else if (this.mNeedUupShareAdv) {
            startAdv(32, (byte[]) null);
        }
    }

    /* access modifiers changed from: private */
    public void cleanRetryAdv() {
        this.mAdvRetryTimes = 10;
        if (hasMessages(15)) {
            removeMessages(15);
        }
    }

    private void dealNeedReconnectAdv() {
        StConnectDevice curBondInfo = StarryDeviceManager.getInstance().getCurBondInfo();
        byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
        IStarryNetDiscoverer discoveryManager = StarryNetData.getInstance().getDiscoveryManager();
        if (curBondInfo == null || curBondInfo.getBleBondStatus() != 4 || curBondInfo.isBleConnected() || curBondInfo.isP2pConnected() || terminalType == 1 || terminalType == 9 || discoveryManager.isCarActiveDisconnect(curBondInfo.getIdentifier2String()) || !discoveryManager.getReconnectEnable()) {
            this.mNeedRepeatReconnectAdv = false;
            this.mNeedReconnectId = null;
            return;
        }
        List<StConnectDevice> connectedDevice = StarryDeviceManager.getInstance().getConnectedDevice();
        if (connectedDevice == null || connectedDevice.isEmpty()) {
            this.mNeedRepeatReconnectAdv = true;
            this.mNeedReconnectId = curBondInfo.getIdentifier();
        } else {
            StConnectDevice stConnectDevice = connectedDevice.get(0);
            if (stConnectDevice.getTerminalType() == 1 || stConnectDevice.getConnectVersion() > curBondInfo.getConnectVersion()) {
                this.mNeedRepeatReconnectAdv = false;
                this.mNeedReconnectId = null;
            } else {
                this.mNeedRepeatReconnectAdv = true;
                this.mNeedReconnectId = curBondInfo.getIdentifier();
            }
        }
        StLog.d(TAG, "dealNeedReconnectAdv: getIdentifier2String = " + curBondInfo.getIdentifier2String() + " isCarActiveDisconnect = " + discoveryManager.isCarActiveDisconnect(curBondInfo.getIdentifier2String()) + " isBleConnected = " + curBondInfo.isBleConnected() + " isP2pConnected = " + curBondInfo.isP2pConnected() + " getBleBondStatus = " + curBondInfo.getBleBondStatus() + " getConnectVersion = " + curBondInfo.getConnectVersion());
    }

    /* access modifiers changed from: private */
    public void deleteAdvDemand(int i) {
        if (i == 1) {
            this.mNeedRepeatActiveAdv = false;
            removeMessages(21);
        } else if (i == 2) {
            this.mNeedRepeatPassiveAdv = false;
            removeMessages(22);
        } else if (i == 4) {
            removeMessages(23);
        } else if (i == 8) {
            this.mNeedRepeatReconnectAdv = false;
            removeMessages(25);
        } else if (i == 16) {
            removeMessages(24);
        } else if (i == 32) {
            this.mNeedUupShareAdv = false;
            removeMessages(26);
            removeMessages(27);
        }
    }

    /* access modifiers changed from: private */
    public boolean isAdvEnable() {
        boolean z = this.isGattServerReady && this.isAdvModeEnable && !this.isStrModeEnter;
        if (!z) {
            StLog.w(TAG, "gatt server ready=" + this.isGattServerReady + ",isAdvModeEnable=" + this.isAdvModeEnable + ",isStrModeEnter=" + this.isStrModeEnter);
        }
        return z;
    }

    public static DiscoveryStateMachine make(Context context, Looper looper, AdvertiserManager advertiserManager) {
        DiscoveryStateMachine discoveryStateMachineCar417 = StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_417) ? new DiscoveryStateMachineCar417(context, looper, advertiserManager) : (StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_E371) || StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_E371_MX)) ? new DiscoveryStateMachineCar371(context, looper, advertiserManager) : StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_BX11) ? new DiscoveryStateMachineCarBx11(context, looper, advertiserManager) : new DiscoveryStateMachine(context, looper, advertiserManager);
        discoveryStateMachineCar417.start();
        return discoveryStateMachineCar417;
    }

    /* access modifiers changed from: private */
    public void recordAdvDemand(int i, byte[] bArr) {
        if (i == 1) {
            this.mNeedRepeatActiveAdv = true;
        } else if (i == 2) {
            this.mNeedRepeatPassiveAdv = true;
        } else if (i == 8) {
            this.mNeedReconnectId = bArr;
            this.mNeedRepeatReconnectAdv = true;
        } else if (i == 32) {
            this.mNeedUupShareAdv = true;
        }
    }

    /* access modifiers changed from: private */
    public void removeAllDeferredMessages() {
        if (hasMessages(21)) {
            removeMessages(21);
        }
        if (hasMessages(22)) {
            removeMessages(22);
        }
        if (hasMessages(23)) {
            removeMessages(23);
        }
        if (hasMessages(24)) {
            removeMessages(24);
        }
        if (hasMessages(25)) {
            removeMessages(25);
        }
    }

    /* access modifiers changed from: private */
    public void startHighScan() {
        this.mIsScanning = this.mScanManager.startHighFreqScan();
        StLog.d(TAG, "startHighScan ret = " + this.mIsScanning);
    }

    /* access modifiers changed from: private */
    public void startLowScan() {
        this.mIsLowPowerScanning = this.mScanManager.startLowPowerBackgroundScan();
        StLog.d(TAG, "startLowScan ret = " + this.mIsLowPowerScanning);
    }

    public void addBeaconId() {
        int i = this.mBeaconId;
        if (i == 124) {
            this.mBeaconId = 0;
        } else {
            this.mBeaconId = i + 1;
        }
    }

    public void cleanup() {
    }

    public void doQuit() {
    }

    public int getAdvDemand(int i) {
        if (i == 1) {
            return this.mNeedRepeatActiveAdv ? 1 : 0;
        }
        if (i == 2) {
            return this.mNeedRepeatPassiveAdv ? 1 : 0;
        }
        if (i == 8) {
            return this.mNeedRepeatReconnectAdv ? 1 : 0;
        }
        if (i != 32) {
            return 0;
        }
        return this.mNeedUupShareAdv ? 1 : 0;
    }

    public synchronized int getAdvState() {
        return this.mAdvState;
    }

    public void resetScanRecord() {
    }

    public void retryStartAdv(int i, byte[] bArr) {
        StLog.d(TAG, "retryStartAdv, retry time = " + this.mAdvRetryTimes);
        int i2 = this.mAdvRetryTimes + -1;
        this.mAdvRetryTimes = i2;
        if (i2 >= 0) {
            Message obtainMessage = obtainMessage(15);
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = getAdvDemand(i);
            if (i == 8) {
                Bundle bundle = new Bundle();
                bundle.putByteArray("identifier", bArr);
                obtainMessage.setData(bundle);
            }
            StLog.d(TAG, "retry advType = " + obtainMessage.arg1 + ", advDemand = " + obtainMessage.arg2);
            sendMessageDelayed(obtainMessage, (long) AssistantConstants.TIMEOUT_VAD_MUTE);
        }
    }

    public synchronized void setAdvState(int i) {
        this.mAdvState = i;
    }

    public void setLimitScanFreqFlag(boolean z) {
        this.mLimitScanFreq = z;
    }

    public void startAdv(int i, byte[] bArr) {
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8) {
                        if (i != 16) {
                            if (i != 32) {
                                if (i == 64) {
                                    if ((64 & this.mAdvState) > 0) {
                                        StLog.d(TAG, "already start, UUP_STARE_RSP_ADV");
                                        return;
                                    }
                                    StLog.d(TAG, "startAdv Type = " + i + " connectId = " + Utils.bytes2HexString(bArr));
                                    this.mAdvertiserManager.startUupShareResponseAdv(20000);
                                    removeMessages(27);
                                    sendMessageDelayed(27, 21000);
                                }
                            } else if ((32 & this.mAdvState) > 0) {
                                StLog.d(TAG, "already start, UUP_STARE_ADV");
                            } else {
                                StLog.d(TAG, "startAdv Type = " + i + " connectId = " + Utils.bytes2HexString(bArr));
                                this.mAdvertiserManager.startUupShareAdv(120000);
                                removeMessages(26);
                                sendMessageDelayed(26, 121000);
                            }
                        } else if ((16 & this.mAdvState) > 0) {
                            StLog.d(TAG, "already start, NOTIFY_ADV");
                        } else {
                            StLog.d(TAG, "startAdv Type = " + i + " connectId = " + Utils.bytes2HexString(bArr));
                            this.mAdvertiserManager.startNotifyAdv(120000, bArr, this.mBeaconId);
                            removeMessages(24);
                            sendMessageDelayed(24, 121000);
                        }
                    } else if ((8 & this.mAdvState) > 0) {
                        StLog.d(TAG, "already start, RECONNECT_ADV");
                    } else {
                        StLog.d(TAG, "startAdv Type = " + i + " connectId = " + Utils.bytes2HexString(bArr));
                        this.mAdvertiserManager.startReconnectAdv(120000, bArr, this.mBeaconId);
                        removeMessages(25);
                        sendMessageDelayed(25, 121000);
                    }
                } else if ((this.mAdvState & 4) > 0) {
                    StLog.d(TAG, "already start, restart CONNECT_ADV");
                    this.mAdvertiserManager.stopAdv(4);
                    setAdvState(this.mAdvState & -5);
                    this.mAdvertiserManager.startConnectAdv(120000, bArr, this.mBeaconId);
                } else {
                    StLog.i(TAG, "startAdv Type = " + i + " connectId = " + Utils.bytes2HexString(bArr));
                    this.mAdvertiserManager.startConnectAdv(120000, bArr, this.mBeaconId);
                    removeMessages(23);
                    sendMessageDelayed(23, 121000);
                }
            } else if ((2 & this.mAdvState) <= 0) {
                StLog.d(TAG, "startAdv Type = " + i + " connectId = " + Utils.bytes2HexString(bArr));
                this.mPassiveAdvTime = System.currentTimeMillis();
                this.mAdvertiserManager.startPassiveAdv(120000, bArr, this.mBeaconId);
                removeMessages(22);
                sendMessageDelayed(22, 121000);
            }
        } else if ((1 & this.mAdvState) <= 0) {
            StLog.d(TAG, "startAdv Type = " + i + " connectId = " + Utils.bytes2HexString(bArr));
            this.mAdvertiserManager.startActiveAdv(120000, this.mBeaconId);
            removeMessages(21);
            sendMessageDelayed(21, 121000);
        }
    }

    public void stopHighScan() {
        this.mScanManager.stopHighFreqScan();
        this.mIsScanning = false;
        StLog.d(TAG, "stopHighScan");
    }

    public void stopLowScan() {
        this.mScanManager.stopLowPowerBackgroundScan();
        this.mIsLowPowerScanning = false;
        StLog.d(TAG, "stopLowScan");
    }
}
