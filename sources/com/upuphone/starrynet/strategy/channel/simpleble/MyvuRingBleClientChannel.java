package com.upuphone.starrynet.strategy.channel.simpleble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHidHost;
import android.bluetooth.BluetoothProfile;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.honey.account.b7.a;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant;
import com.upuphone.starrynet.core.ble.client.BleClientCache;
import com.upuphone.starrynet.core.ble.client.BleConnectConfig;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.ble.client.response.BleConnectResponse;
import com.upuphone.starrynet.core.ble.client.response.BleNotifyResponse;
import com.upuphone.starrynet.core.ble.client.response.BleWriteNoRespResponse;
import com.upuphone.starrynet.core.ble.event.BleEventBus;
import com.upuphone.starrynet.core.ble.event.CharacterChangedEvent;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.core.ble.event.MYVURingEvent;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.channel.IChannelCallback;
import com.upuphone.starrynet.strategy.channel.IConnectChannel;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;
import com.upuphone.starrynet.strategy.utils.Ring2TrackUtils;
import com.upuphone.xr.interconnect.Constants;
import flyme.support.v7.widget.AnimationUtils;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang3.BooleanUtils;

@SuppressLint({"MissingPermission"})
public class MyvuRingBleClientChannel implements IConnectChannel, EventReceiver {
    private static final UUID DATA_Characteristic = UUID.fromString(Constants.DATA_Characteristic);
    private static final boolean ENABLE_ENCRYPTION_MODE = true;
    private static final int MSG_CHECK_BLE_ACL_TIMEOUT = 7;
    private static final int MSG_CHECK_BLE_BOND_TIMEOUT = 10;
    private static final int MSG_CHECK_BLE_HID_TIMEOUT = 9;
    private static final int MSG_CHECK_BLE_SERVICE_READY_TIMEOUT = 8;
    private static final int MSG_CHECK_REMOVE_BOND_TIMEOUT = 14;
    private static final int MSG_CHECK_STARRY_BOND_TIMEOUT = 1;
    private static final int MSG_CMD_CONNECT_BLE_PROFILE = 2;
    private static final int MSG_CMD_ENCRYPTION_MODE_RING_CONFIRM = 16;
    private static final int MSG_CMD_GET_FW_VER_CONFIRM = 18;
    private static final int MSG_CMD_GET_SN_CONFIRM = 17;
    private static final int MSG_CMD_OPEN_NOTIFY = 4;
    private static final int MSG_CMD_RECOVER_BLE_PROFILE = 19;
    private static final int MSG_CMD_REMOVE_BLE_BOND = 13;
    private static final int MSG_CMD_REMOVE_BLE_BOND_BY_RING = 15;
    private static final int MSG_CMD_SET_STARRY_BOND_STATUS = 12;
    private static final int MSG_RECV_STARRY_INTERNAL_MSG = 11;
    private static final int MSG_RING_EVENT_HANDLER = 3;
    private static final int MSG_STATUS_HID_INIT_DONE = 20;
    private static final int MSG_STATUS_HID_READY = 6;
    private static final int MSG_STATUS_SERVICE_READY = 5;
    private static final UUID NOTIY_Characteristic = UUID.fromString(Constants.NOTIY_Characteristic);
    private static final UUID SERVICE_DATA = UUID.fromString(Constants.SERVICE_DATA);
    private static final int STATE_BLE_ACL_CONNECTED = 1;
    private static final int STATE_BLE_ACL_CONNECTING = 16;
    private static final int STATE_BLE_BONDED = 4;
    private static final int STATE_BLE_BONDING = 32;
    private static final int STATE_BLE_SERVICE_READY = 8;
    private static final int STATE_BONDED_WAIT_FOR_ENCRYPTION_CONFIRM = 1024;
    private static final int STATE_ENCRYPTION_CONFIRMED = 4096;
    private static final int STATE_FW_VERSION_CONFIRMED = 16384;
    private static final int STATE_HID_HOST_CONNECT = 2;
    private static final int STATE_MASK_BLE_CONNECTED = 15;
    private static final int STATE_MASK_STARRY_BONDED_CONNECTED = 399;
    private static final int STATE_PROFILE_RECOVER_GOING = 32768;
    private static final int STATE_RECONNECT_WAIT_FOR_ENCRYPTION_CONFIRM = 2048;
    private static final int STATE_RING_OFFLINE_REMOVE_BONDING = 65536;
    private static final int STATE_SN_CONFIRMED = 8192;
    private static final int STATE_STARRY_AUTHED = 128;
    private static final int STATE_STARRY_AUTHING = 64;
    private static final int STATE_STARRY_BONDED = 256;
    private static final int STATE_STARRY_REMOVE_BOND_WAIT_CONFIRM = 512;
    private static final String TAG = "MyvuRingBleClientChannel";
    private static final int TIMEOUT_BLE_ACL = 18000;
    private static final int TIMEOUT_BLE_BOND = 25000;
    private static final int TIMEOUT_CHECK_REMOVE_BOND = 3000;
    private static final int TIMEOUT_HID = 8000;
    private static final int TIMEOUT_SERVICE_READY = 5000;
    private static final int TIMEOUT_STARRY_BOND = 43000;
    private static byte[] mBondedRingIdentifier;
    private static final int[] mEventConnectionChange = {3, 5, 6, 12, 16};
    private static final int[] mEventRemoveMap = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 16};
    private static int mStatusRecord;
    /* access modifiers changed from: private */
    public BluetoothAdapter mAdapter;
    /* access modifiers changed from: private */
    public BluetoothDevice mBluetoothDevice;
    /* access modifiers changed from: private */
    public StDevice mCacheStDevice;
    protected IChannelCallback mChannelCallback;
    private Handler mHandler;
    /* access modifiers changed from: private */
    public BluetoothHidHost mHidHost;
    private HashMap<UUID, UUID> mNotifyMap;
    SysActionManager.StateChangeSimpleCallback mStateChangeSimpleCallback;
    private int notifyCounter;

    public MyvuRingBleClientChannel() {
        this.mHidHost = null;
        this.mAdapter = null;
        this.mHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(@NonNull Message message) {
                StLog.d(MyvuRingBleClientChannel.TAG, "handleMessage (" + message.what + "):" + MyvuRingBleClientChannel.this.getMsgTypeInfo(message.what));
                boolean z = false;
                switch (message.what) {
                    case 1:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        StLog.w(MyvuRingBleClientChannel.TAG, "handleMessage , check ready timeout: " + MyvuRingBleClientChannel.this.getMsgTypeInfo(message.what));
                        MyvuRingBleClientChannel.this.debugStatusRecord();
                        MyvuRingBleClientChannel.this.dealStarryConnectFailMsg((String) message.obj, message.what);
                        MyvuRingBleClientChannel.this.terminateUnusedAction(message.what);
                        break;
                    case 2:
                    case 19:
                        if (!MyvuRingBleClientChannel.this.checkStatusRecordContains(65536)) {
                            MyvuRingBleClientChannel myvuRingBleClientChannel = MyvuRingBleClientChannel.this;
                            StDevice stDevice = (StDevice) message.obj;
                            if (message.arg1 == 1) {
                                z = true;
                            }
                            if (myvuRingBleClientChannel.connectImmediately(stDevice, z) == 0) {
                                MyvuRingBleClientChannel.this.recordStatus(32768);
                                break;
                            }
                        } else {
                            StLog.d(MyvuRingBleClientChannel.TAG, "already offline remove bond, do not connect");
                            return;
                        }
                        break;
                    case 3:
                        MyvuRingBleClientChannel.this.eventHandler((MYVURingEvent) message.obj);
                        StConnectDevice access$200 = MyvuRingBleClientChannel.this.getConnectRingDevice(((MYVURingEvent) message.obj).getBleMac());
                        if (access$200 != null) {
                            MyvuRingBleClientChannel.this.dealConnectResult(access$200);
                            break;
                        }
                        break;
                    case 4:
                        int i = message.arg1;
                        if (i == 0) {
                            if (!MyvuRingBleClientChannel.this.checkStatusRecordContainsAll(4)) {
                                if (!MyvuRingBleClientChannel.this.checkIfDuringStarryBonding()) {
                                    StLog.d(MyvuRingBleClientChannel.TAG, "reconnecting while ble not bonded, do nothing");
                                    break;
                                } else {
                                    StLog.d(MyvuRingBleClientChannel.TAG, "device not bonded, wait");
                                    MyvuRingBleClientChannel myvuRingBleClientChannel2 = MyvuRingBleClientChannel.this;
                                    boolean unused = myvuRingBleClientChannel2.createBond(myvuRingBleClientChannel2.mCacheStDevice);
                                    break;
                                }
                            } else {
                                MyvuRingBleClientChannel myvuRingBleClientChannel3 = MyvuRingBleClientChannel.this;
                                myvuRingBleClientChannel3.checkAndOpenNotify(myvuRingBleClientChannel3.mCacheStDevice);
                                break;
                            }
                        } else {
                            StLog.d(MyvuRingBleClientChannel.TAG, "open notify fail: %d, no need to go on", Integer.valueOf(i));
                            MyvuRingBleClientChannel.this.terminateUnusedAction(message.what);
                            break;
                        }
                    case 5:
                        Object obj = message.obj;
                        StDevice stDevice2 = (StDevice) obj;
                        if (obj != null && MyvuRingBleClientChannel.this.dealConnectGattResult(stDevice2, message.arg1)) {
                            if (MyvuRingBleClientChannel.this.checkStatusRecordContainsAll(16)) {
                                MyvuRingBleClientChannel.this.removeCheckConnectTimeout(7);
                                MyvuRingBleClientChannel.this.recordStatus(1);
                            }
                            MyvuRingBleClientChannel.this.removeCheckConnectTimeout(8);
                            MyvuRingBleClientChannel myvuRingBleClientChannel4 = MyvuRingBleClientChannel.this;
                            myvuRingBleClientChannel4.dealConnectResult(myvuRingBleClientChannel4.getConnectRingDevice(stDevice2.getBleMac()));
                            break;
                        } else {
                            MyvuRingBleClientChannel.this.terminateUnusedAction(message.what);
                            return;
                        }
                        break;
                    case 6:
                        String str = (String) message.obj;
                        if (MyvuRingBleClientChannel.this.checkMacValid(str)) {
                            MyvuRingBleClientChannel.this.removeCheckConnectTimeout(9);
                            MyvuRingBleClientChannel.this.recordStatus(2);
                            MyvuRingBleClientChannel myvuRingBleClientChannel5 = MyvuRingBleClientChannel.this;
                            myvuRingBleClientChannel5.dealConnectResult(myvuRingBleClientChannel5.getConnectRingDevice(str));
                            break;
                        } else {
                            return;
                        }
                    case 11:
                        byte[] bArr = (byte[]) message.obj;
                        if (MyvuRingBleClientChannel.this.mCacheStDevice != null) {
                            MyvuRingBleClientChannel myvuRingBleClientChannel6 = MyvuRingBleClientChannel.this;
                            myvuRingBleClientChannel6.mChannelCallback.onRecv(myvuRingBleClientChannel6.getConnectRingDevice(myvuRingBleClientChannel6.mCacheStDevice.getBleMac()), bArr, 1, (IStarryNetChannel) null);
                            break;
                        }
                        break;
                    case 12:
                        StDevice stDevice3 = (StDevice) message.obj;
                        StLog.w(MyvuRingBleClientChannel.TAG, "Starry bonded result: " + message.arg1);
                        int i2 = message.arg1;
                        if (i2 == 1) {
                            Ring2TrackUtils.trackAuthResult(stDevice3, 1);
                            Ring2TrackUtils.trackSecurityState(stDevice3, 1);
                            MyvuRingBleClientChannel.this.recordStatus(256);
                            MyvuRingBleClientChannel.this.recordStatus(128);
                            if (!MyvuRingBleClientChannel.this.checkIfDuringStarryBonding()) {
                                StLog.d(MyvuRingBleClientChannel.TAG, "reconnect auth success !!!");
                                MyvuRingBleClientChannel.this.removeStatus(64);
                                MyvuRingBleClientChannel myvuRingBleClientChannel7 = MyvuRingBleClientChannel.this;
                                boolean unused2 = myvuRingBleClientChannel7.dealReconnectDone(myvuRingBleClientChannel7.getConnectRingDevice(stDevice3.getBleMac()));
                            }
                        } else if (i2 == -1) {
                            StLog.e(MyvuRingBleClientChannel.TAG, "deal starrynet bond protocol fail");
                            Ring2TrackUtils.trackAuthResult(stDevice3, 2);
                            Ring2TrackUtils.trackSecurityState(stDevice3, 2);
                            if (MyvuRingBleClientChannel.this.checkIfDuringStarryBonding()) {
                                MyvuRingBleClientChannel.this.dealStarryConnectFailMsg(stDevice3.getBleMac(), message.what);
                            } else {
                                StLog.w(MyvuRingBleClientChannel.TAG, "reconnect auth fail !!!");
                                MyvuRingBleClientChannel.this.removeBond(stDevice3);
                            }
                        }
                        MyvuRingBleClientChannel.this.removeStatus(64);
                        break;
                    case 13:
                    case 14:
                    case 15:
                        StConnectDevice access$2002 = MyvuRingBleClientChannel.this.getConnectRingDevice((String) message.obj);
                        if (MyvuRingBleClientChannel.this.checkStatusRecordContains(4) || access$2002 == null) {
                            if (!MyvuRingBleClientChannel.this.checkTimeout(14) && MyvuRingBleClientChannel.this.checkStatusRecordContains(1) && !MyvuRingBleClientChannel.this.checkStatusRecordContains(512) && message.what != 15) {
                                MyvuRingBleClientChannel.this.recordStatus(512);
                                StLog.d(MyvuRingBleClientChannel.TAG, "wait for ring receive remove bond cmd");
                                RingSecurityPair.getInstance().sendRemoveBondCmd(access$2002);
                                boolean unused3 = MyvuRingBleClientChannel.this.addCheckConnectTimeoutByTime(access$2002.getBleMac(), 14, 3000);
                                break;
                            } else {
                                MyvuRingBleClientChannel.this.debugStatusRecord();
                                StringBuilder sb = new StringBuilder();
                                sb.append("execute remove bond cmd: ");
                                sb.append(message.what == 14 ? RtspHeaders.Values.TIMEOUT : "just call");
                                StLog.d(MyvuRingBleClientChannel.TAG, sb.toString());
                                if (MyvuRingBleClientChannel.this.mAdapter == null || !MyvuRingBleClientChannel.this.mAdapter.isEnabled()) {
                                    StLog.d(MyvuRingBleClientChannel.TAG, "bt off, just clear bond status");
                                    MyvuRingBleClientChannel.this.removeStatus(4);
                                } else {
                                    MyvuRingBleClientChannel myvuRingBleClientChannel8 = MyvuRingBleClientChannel.this;
                                    boolean unused4 = myvuRingBleClientChannel8.createOrRemoveBond(false, myvuRingBleClientChannel8.mBluetoothDevice);
                                }
                                StLog.d(MyvuRingBleClientChannel.TAG, "update unbond event");
                                StarryDeviceManager.getInstance().updateBondInfo(access$2002, 0);
                                MyvuRingBleClientChannel.this.removeStatusExceptFor(5);
                                MyvuRingBleClientChannel.this.terminateAction(message.what, 14);
                                Ring2TrackUtils.clearIotDeviceInfo();
                                break;
                            }
                        } else {
                            StLog.w(MyvuRingBleClientChannel.TAG, "not bonded. no need to remove bond. just make sure can recover from FATAL error");
                            MyvuRingBleClientChannel.this.debugStatusRecord();
                            Ring2TrackUtils.trackStartRemoveBond(access$2002.getDevice(), 5);
                            StarryDeviceManager.getInstance().updateBondInfo(access$2002, 0);
                            MyvuRingBleClientChannel.this.removeStatus(0);
                            Ring2TrackUtils.clearIotDeviceInfo();
                            return;
                        }
                        break;
                    case 16:
                        if (!MyvuRingBleClientChannel.this.checkStatusRecordContains(4096)) {
                            MyvuRingBleClientChannel myvuRingBleClientChannel9 = MyvuRingBleClientChannel.this;
                            boolean unused5 = myvuRingBleClientChannel9.dealReconnectDone(myvuRingBleClientChannel9.getConnectRingDevice(((StDevice) message.obj).getBleMac()));
                            break;
                        }
                        break;
                    case 17:
                        MyvuRingBleClientChannel.this.recordStatus(8192);
                        break;
                    case 18:
                        MyvuRingBleClientChannel.this.recordStatus(16384);
                        break;
                    case 20:
                        if (MyvuRingBleClientChannel.this.mBluetoothDevice != null && MyvuRingBleClientChannel.this.mHidHost != null) {
                            if (MyvuRingBleClientChannel.this.mHidHost.getConnectionState(MyvuRingBleClientChannel.this.mBluetoothDevice) == 2 && !MyvuRingBleClientChannel.this.checkStatusRecordContains(2)) {
                                StLog.d(MyvuRingBleClientChannel.TAG, "init HID: ring ble connected, recover starry connection");
                                BleEventBus.get().post(new MYVURingEvent(MyvuRingBleClientChannel.this.mBluetoothDevice.getAddress(), 5));
                                break;
                            }
                        } else {
                            return;
                        }
                        break;
                }
                if (MyvuRingBleClientChannel.this.checkIfConnectionEvent(message.what) && MyvuRingBleClientChannel.this.checkIfDuringStarryBonding() && !MyvuRingBleClientChannel.this.checkStatusRecordContains(4096)) {
                    MyvuRingBleClientChannel.this.debugStatusRecord();
                    MyvuRingBleClientChannel.this.checkIfBondSuccessAndNotify(message.what);
                }
            }
        };
        this.mStateChangeSimpleCallback = new SysActionManager.StateChangeSimpleCallback() {
            public void onBluetoothDisabled() {
                StLog.d(MyvuRingBleClientChannel.TAG, "mStateChangeSimpleCallback: onBluetoothDisabled");
                BleEventBus.get().post(new MYVURingEvent("None", 8));
            }

            public void onBluetoothEnabled() {
                StLog.d(MyvuRingBleClientChannel.TAG, "mStateChangeSimpleCallback: onBluetoothEnabled");
                BleEventBus.get().post(new MYVURingEvent("None", 9));
            }
        };
        this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        BleEventBus.get().register(MYVURingEvent.class, this);
        mStatusRecord = 0;
        this.mBluetoothDevice = null;
        HashMap<UUID, UUID> hashMap = new HashMap<>();
        this.mNotifyMap = hashMap;
        hashMap.put(SERVICE_DATA, NOTIY_Characteristic);
        this.notifyCounter = 0;
        if (checkBtAdapterValid() && initBondedRingCache().booleanValue()) {
            initHidHost();
        }
        SysActionManager.getInstance().registerSysAction(this.mStateChangeSimpleCallback);
        StLog.d(TAG, "init done");
    }

    private void RemovePairDataChannel() {
        BleEventBus.get().unregister(CharacterChangedEvent.class, this);
    }

    /* access modifiers changed from: private */
    public boolean addCheckConnectTimeoutByTime(String str, int i, int i2) {
        if (!sendInternalMessageDelayedUnique(i, str, 0, 0, i2)) {
            return false;
        }
        StLog.d(TAG, "add checking connect procedure..." + getMsgTypeInfo(i));
        return true;
    }

    private void changeEncryptionMode(boolean z) {
        byte b;
        if (z) {
            StLog.w(TAG, "enable encryption");
            b = 35;
        } else {
            StLog.w(TAG, "disable encryption");
            b = 34;
        }
        this.mChannelCallback.onRecv(getConnectRingDevice(this.mCacheStDevice.getBleMac()), new byte[]{b}, 2, (IStarryNetChannel) null);
    }

    /* access modifiers changed from: private */
    public void checkAndOpenNotify(StDevice stDevice) {
        this.notifyCounter = 0;
        if (checkStatusRecordContains(8)) {
            StLog.d(TAG, "service already ready");
        } else if (this.mNotifyMap.size() == 0) {
            StLog.d(TAG, "no need to open notify: mNotifyMap = " + this.mNotifyMap.size());
            onConnectGattResult(stDevice, 0);
        } else {
            for (Map.Entry next : this.mNotifyMap.entrySet()) {
                UUID uuid = (UUID) next.getValue();
                StLog.d(TAG, "open notify: " + uuid.toString());
                addCheckConnectTimeoutByTime(stDevice.getBleMac(), 8, 5000);
                openNotify(stDevice, (UUID) next.getKey(), uuid, new a(this, stDevice));
            }
        }
    }

    private boolean checkBtAdapterValid() {
        BluetoothAdapter bluetoothAdapter = this.mAdapter;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("BT adapter check invalid, BT state ");
        BluetoothAdapter bluetoothAdapter2 = this.mAdapter;
        sb.append(bluetoothAdapter2 != null ? Integer.toString(bluetoothAdapter2.getState()) : BooleanUtils.OFF);
        StLog.d(TAG, sb.toString());
        return false;
    }

    private boolean checkDeviceInfoAllConfirmed(boolean z) {
        if (!z && !checkStatusRecordContainsAll(24576)) {
            return false;
        }
        this.mChannelCallback.onRecv(getConnectRingDevice(this.mCacheStDevice.getBleMac()), new byte[]{39}, 2, (IStarryNetChannel) null);
        return true;
    }

    private static boolean checkDiscoveryDeviceIsSelfBonded(StDiscoveryDevice stDiscoveryDevice) {
        return mBondedRingIdentifier != null && stDiscoveryDevice != null && stDiscoveryDevice.getTerminalType() == 5 && (mStatusRecord & 256) > 0 && Arrays.equals(mBondedRingIdentifier, stDiscoveryDevice.getIdentifier());
    }

    /* access modifiers changed from: private */
    public void checkIfBondSuccessAndNotify(int i) {
        if (this.mCacheStDevice == null) {
            StLog.e(TAG, "mCacheStDevice is null");
            return;
        }
        StLog.w(TAG, "checkIfBondSuccessAndNotify: " + getMsgTypeInfo(i));
        if (checkStatusRecordContainsAll(STATE_MASK_STARRY_BONDED_CONNECTED)) {
            StLog.d(TAG, "starry bond success..." + getMsgTypeInfo(i));
            if (!checkStatusRecordContains(5120)) {
                recordStatus(1024);
                StLog.w(TAG, "wait ring encryption mode confirm...");
                changeEncryptionMode(true);
            } else if (!checkStatusRecordContains(4096)) {
                StLog.w(TAG, "bond success! upload bonded status");
                Ring2TrackUtils.trackConnected(this.mCacheStDevice);
                mBondedRingIdentifier = this.mCacheStDevice.getIdentifier();
                StarryDeviceManager.getInstance().updateBondInfo(getConnectRingDevice(this.mCacheStDevice.getBleMac()), 4);
                removeCheckConnectTimeout(1);
                removeStatus(1024);
                recordStatus(4096);
                if (!checkStatusRecordContainsAll(24576)) {
                    StLog.w(TAG, "get sn or fw version fail");
                    recordStatus(24576);
                }
                checkDeviceInfoAllConfirmed(false);
            }
        } else if (checkStatusRecordContainsAll(15) && !checkStatusRecordContains(64)) {
            startAuth();
        }
    }

    /* access modifiers changed from: private */
    public boolean checkIfConnectionEvent(int i) {
        for (int i2 : mEventConnectionChange) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfDuringConnecting() {
        return checkStatusRecordContains(32768);
    }

    /* access modifiers changed from: private */
    public boolean checkIfDuringStarryBonding() {
        return checkTimeout(1);
    }

    private boolean checkIfWaitRemoveBond() {
        return checkTimeout(13) || checkTimeout(14);
    }

    /* access modifiers changed from: private */
    public boolean checkMacValid(String str) {
        StDevice stDevice = this.mCacheStDevice;
        if (stDevice != null && str.equals(stDevice.getBleMac())) {
            return true;
        }
        StLog.d(TAG, "mac not match, ignore");
        return false;
    }

    /* access modifiers changed from: private */
    public synchronized boolean checkStatusRecordContains(int i) {
        return (i & mStatusRecord) > 0;
    }

    /* access modifiers changed from: private */
    public synchronized boolean checkStatusRecordContainsAll(int i) {
        return (mStatusRecord & i) == i;
    }

    /* access modifiers changed from: private */
    public boolean checkTimeout(int i) {
        return this.mHandler.hasMessages(i);
    }

    /* access modifiers changed from: private */
    public int connectImmediately(final StDevice stDevice, boolean z) {
        if (!checkBtAdapterValid()) {
            StLog.w(TAG, "BT off, cannot start connect");
            return -1;
        }
        this.mCacheStDevice = stDevice;
        recordStatus(16);
        BleClientCache.getInstance().markExternalDevice(stDevice.getBleMac(), true);
        BleConnectConfig connectConfig = getConnectConfig(stDevice);
        StarryDeviceManager.getInstance().updateBondInfo(getOrAddNewRingStConnectDevice(this.mCacheStDevice));
        if (!z) {
            addCheckConnectTimeoutByTime(stDevice.getBleMac(), 7, TIMEOUT_BLE_ACL);
        } else {
            recordStatus(1);
        }
        Ring2TrackUtils.trackStartMatchConnection(stDevice, !checkStatusRecordContains(4));
        BleConnectManager.getInstance().connect(connectConfig, (BleConnectResponse) new BleConnectResponse() {
            public void onResponse(int i, Bundle bundle) {
                if (i == 0) {
                    StLog.d(MyvuRingBleClientChannel.TAG, "connect ble success");
                    MyvuRingBleClientChannel.this.sendInternalMessage(4, (Object) null, i, 0);
                    return;
                }
                StLog.d(MyvuRingBleClientChannel.TAG, "connect ble fail");
                MyvuRingBleClientChannel.this.onConnectGattResult(stDevice, StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_FAIL);
            }
        });
        return 0;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public boolean createBond(StDevice stDevice) {
        BluetoothDevice bluetoothDevice;
        StLog.d(TAG, "try create bond... ");
        if (stDevice == null || (bluetoothDevice = this.mBluetoothDevice) == null || bluetoothDevice.getBondState() == 11) {
            StringBuilder sb = new StringBuilder();
            sb.append("cannot create bond: ");
            BluetoothDevice bluetoothDevice2 = this.mBluetoothDevice;
            sb.append(bluetoothDevice2 == null ? "null" : Integer.valueOf(bluetoothDevice2.getBondState()));
            StLog.w(TAG, sb.toString());
            return false;
        }
        StLog.d(TAG, "target device: " + stDevice.getBleMac());
        if (this.mBluetoothDevice.getBondState() != 12) {
            StLog.d(TAG, "start createBond");
            return createOrRemoveBond(true, this.mBluetoothDevice);
        }
        StLog.w(TAG, "bluetooth device(%s,%s)  ,  Already bonded. bond state =%d", this.mBluetoothDevice.getName(), this.mBluetoothDevice.getAddress(), Integer.valueOf(this.mBluetoothDevice.getBondState()));
        return false;
    }

    /* access modifiers changed from: private */
    public boolean createOrRemoveBond(boolean z, BluetoothDevice bluetoothDevice) {
        StLog.d(TAG, "createOrRemoveBond: " + z);
        if (bluetoothDevice == null) {
            StLog.w(TAG, "BluetoothDevice is null ");
            return false;
        }
        try {
            BluetoothDevice.class.getMethod(z ? "createBond" : "removeBond", (Class[]) null).invoke(bluetoothDevice, (Object[]) null);
            return true;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    private void dealBondFail(StConnectDevice stConnectDevice, Ring2TrackerConstant.EnumConnectState enumConnectState) {
        boolean z = true;
        if (stConnectDevice != null) {
            if (enumConnectState == null) {
                enumConnectState = Ring2TrackerConstant.EnumConnectState.MSG_CHECK_STARRY_BOND_TIMEOUT;
            }
            Ring2TrackUtils.trackConnectFail(stConnectDevice.getDevice(), enumConnectState.msgCode, enumConnectState.msg, !checkStatusRecordContains(4), mStatusRecord);
        }
        Ring2TrackUtils.clearIotDeviceInfo();
        if (enumConnectState != Ring2TrackerConstant.EnumConnectState.MSG_STATE_ACL_DISCONNECTED) {
            z = false;
        }
        dealBondFail(stConnectDevice, z);
    }

    /* access modifiers changed from: private */
    public boolean dealConnectGattResult(StDevice stDevice, int i) {
        StLog.d(TAG, "onConnectResult error: " + i);
        if (i != 0) {
            removeStatus(8);
            if (!checkIfDuringStarryBonding()) {
                return false;
            }
            dealBondFail(getConnectRingDevice(stDevice.getBleMac()), Ring2TrackerConstant.EnumConnectState.MSG_STATE_STATE_GATT_FAIL);
            return false;
        }
        recordStatus(8);
        if (checkIfDuringStarryBonding()) {
            getSN();
            getFwVer();
        }
        if (checkStatusRecordContains(4)) {
            initPairDataChannel();
            expectForHidHostConnection(this.mBluetoothDevice);
        }
        if (checkStatusRecordContains(36) || !createBond(stDevice)) {
            return true;
        }
        StLog.d(TAG, "set bonding, wait for bond result...");
        StarryDeviceManager.getInstance().updateBondInfo(getOrAddNewRingStConnectDevice(stDevice), 3);
        return true;
    }

    /* access modifiers changed from: private */
    public void dealConnectResult(StConnectDevice stConnectDevice) {
        if (!dealReconnectDone(stConnectDevice)) {
            dealFirstConnectDone(stConnectDevice);
        }
    }

    private void dealDisconnect(StConnectDevice stConnectDevice, Ring2TrackerConstant.EnumConnectState enumConnectState) {
        if (stConnectDevice != null) {
            if (enumConnectState == null) {
                enumConnectState = Ring2TrackerConstant.EnumConnectState.MSG_CONNECT_TIMEOUT;
            }
            Ring2TrackUtils.trackDisConnect(stConnectDevice, enumConnectState.msgCode, enumConnectState.msg, checkStatusRecordContains(4), mStatusRecord);
        }
        dealDisconnect(stConnectDevice, enumConnectState == Ring2TrackerConstant.EnumConnectState.MSG_STATE_HID_HOST_DISCONNECTED);
    }

    private boolean dealFirstConnectDone(StConnectDevice stConnectDevice) {
        if (checkIfDuringStarryBonding() && checkStatusRecordContainsAll(15)) {
            if (stConnectDevice == null || this.mChannelCallback == null) {
                StLog.e(TAG, "device or callback is null");
            } else {
                StLog.d(TAG, "firs connect done，upload connect event");
                removeStatus(32768);
                this.mChannelCallback.onConnected(stConnectDevice, this);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean dealReconnectDone(StConnectDevice stConnectDevice) {
        if (!checkIfDuringStarryBonding() && checkStatusRecordContainsAll(15)) {
            if (stConnectDevice == null || this.mChannelCallback == null) {
                StLog.e(TAG, "device or callback is null");
            } else if (!checkStatusRecordContains(192)) {
                StLog.w(TAG, "not authed, need to start auth");
                startAuth();
                return true;
            } else if (!checkStatusRecordContains(128)) {
                if (checkStatusRecordContains(64)) {
                    StLog.w(TAG, "wait auth done: authing...");
                } else {
                    StLog.w(TAG, "wait auth done: unknown error, should not happen");
                    debugStatusRecord();
                }
                return true;
            } else {
                StLog.d(TAG, "Reconnect done...");
                removeStatus(32768);
                if (!checkStatusRecordContains(6144)) {
                    StLog.d(TAG, "wait ring confirm encryption mode");
                    changeEncryptionMode(true);
                    recordStatus(2048);
                } else if (!checkStatusRecordContains(4096)) {
                    StLog.d(TAG, "ring encryption mode confirmed, upload connect event");
                    checkDeviceInfoAllConfirmed(true);
                    removeStatus(2048);
                    recordStatus(4096);
                    Ring2TrackUtils.trackConnected(this.mCacheStDevice);
                    this.mChannelCallback.onConnected(stConnectDevice, this);
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void dealStarryConnectFailMsg(String str, int i) {
        StLog.d(TAG, "dealStarryConnectFailMsg: terminate connection");
        StConnectDevice connectRingDevice = getConnectRingDevice(str);
        BleConnectManager.getInstance().disconnect(str);
        if (checkIfDuringStarryBonding() || i == 1) {
            dealBondFail(connectRingDevice, Ring2TrackerConstant.EnumConnectState.MSG_CHECK_STARRY_BOND_TIMEOUT);
        } else {
            dealDisconnect(connectRingDevice, getTrackerTypeInfo(i));
        }
        removeBondedRingCache();
    }

    private String debugByteArray(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            StLog.w(TAG, "empty payload");
            return null;
        }
        String str = "";
        String str2 = str;
        for (byte b : bArr) {
            String str3 = str + Integer.toHexString(b & 255);
            if (str2.equals("")) {
                str2 = ", ";
            }
            str = str3 + str2;
        }
        return str;
    }

    /* access modifiers changed from: private */
    public void debugStatusRecord() {
        StLog.w(TAG, "check stats record: \n STATE_BLE_ACL_CONNECTED: " + checkStatusRecordContains(1) + ", STATE_BLE_BONDED: " + checkStatusRecordContains(4) + ", STATE_BLE_SERVICE_READY: " + checkStatusRecordContains(8) + ", STATE_HID_HOST_CONNECT: " + checkStatusRecordContains(2) + ", STATE_STARRY_BONDED: " + checkStatusRecordContains(256) + ", \nSTATE_STARRY_AUTHING: " + checkStatusRecordContains(64) + ", STATE_PROFILE_RECOVER_GOING: " + checkStatusRecordContains(32768) + ", STATE_STARRY_AUTHED: " + checkStatusRecordContains(128) + ", STATE_STARRY_REMOVE_BOND_WAIT_CONFIRM: " + checkStatusRecordContains(512) + ", STATE_ENCRYPTION_CONFIRMED: " + checkStatusRecordContains(4096));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void eventHandler(com.upuphone.starrynet.core.ble.event.MYVURingEvent r13) {
        /*
            r12 = this;
            java.lang.String r0 = r13.getBleMac()
            com.upuphone.starrynet.strategy.bean.StConnectDevice r0 = r12.getConnectRingDevice(r0)
            r1 = 8
            r2 = 9
            java.lang.String r3 = "MyvuRingBleClientChannel"
            if (r0 != 0) goto L_0x0023
            int r4 = r13.getState()
            if (r4 == r2) goto L_0x0023
            int r4 = r13.getState()
            if (r4 == r1) goto L_0x0023
            java.lang.String r12 = "非已互联配对设备，暂时不处理"
            com.upuphone.starrynet.common.StLog.d(r3, r12)
            return
        L_0x0023:
            r4 = 16
            boolean r5 = r12.checkStatusRecordContainsAll(r4)
            if (r5 == 0) goto L_0x0033
            java.lang.String r5 = "remove STATE_BLE_ACL_CONNECTING"
            com.upuphone.starrynet.common.StLog.d(r3, r5)
            r12.removeStatus(r4)
        L_0x0033:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "MYVU ring Bluetooth state: "
            r4.append(r5)
            int r5 = r13.getState()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.upuphone.starrynet.common.StLog.d(r3, r4)
            int r4 = r13.getState()
            r5 = 32
            r6 = 0
            r7 = 2
            r8 = 256(0x100, float:3.59E-43)
            r9 = 4
            r10 = 3
            r11 = 1
            switch(r4) {
                case 1: goto L_0x01c8;
                case 2: goto L_0x0183;
                case 3: goto L_0x0143;
                case 4: goto L_0x0109;
                case 5: goto L_0x00f8;
                case 6: goto L_0x00e1;
                case 7: goto L_0x00d9;
                case 8: goto L_0x008d;
                case 9: goto L_0x007a;
                case 10: goto L_0x005d;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x01e9
        L_0x005d:
            com.upuphone.starrynet.api.bean.StDevice r13 = r12.mCacheStDevice
            if (r13 == 0) goto L_0x01e9
            boolean r13 = r12.checkStatusRecordContains(r8)
            if (r13 == 0) goto L_0x01e9
            java.lang.String r13 = "offline remove bond"
            com.upuphone.starrynet.common.StLog.d(r3, r13)
            com.upuphone.starrynet.api.bean.StDevice r13 = r12.mCacheStDevice
            com.upuphone.starrynet.strategy.utils.Ring2TrackUtils.trackStartRemoveBond(r13, r7)
            com.upuphone.starrynet.api.bean.StDevice r13 = r12.mCacheStDevice
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r12.removeBond(r13, r0)
            goto L_0x01e9
        L_0x007a:
            java.lang.String r13 = "onBluetoothEnabled"
            com.upuphone.starrynet.common.StLog.d(r3, r13)
            android.bluetooth.BluetoothAdapter r13 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()
            r12.mAdapter = r13
            r12.initBondedRingCache()
            r12.initHidHost()
            goto L_0x01e9
        L_0x008d:
            java.lang.String r13 = "onBluetoothDisabled"
            com.upuphone.starrynet.common.StLog.d(r3, r13)
            r13 = 0
            r12.mAdapter = r13
            r12.mHidHost = r13
            com.upuphone.starrynet.api.bean.StDevice r13 = r12.mCacheStDevice
            if (r13 == 0) goto L_0x01e9
            r13 = 17
            boolean r13 = r12.checkStatusRecordContains(r13)
            if (r13 == 0) goto L_0x00b7
            java.lang.String r13 = "BT off trigger disconnect"
            com.upuphone.starrynet.common.StLog.d(r3, r13)
            com.upuphone.starrynet.api.bean.StDevice r13 = r12.mCacheStDevice
            java.lang.String r13 = r13.getBleMac()
            com.upuphone.starrynet.strategy.bean.StConnectDevice r13 = r12.getConnectRingDevice(r13)
            com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant$EnumConnectState r0 = com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant.EnumConnectState.MSG_STATE_BT_STATE_CHANGE_OFF
            r12.dealDisconnect((com.upuphone.starrynet.strategy.bean.StConnectDevice) r13, (com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant.EnumConnectState) r0)
        L_0x00b7:
            boolean r13 = r12.checkIfDuringStarryBonding()
            if (r13 == 0) goto L_0x00d4
            java.lang.String r13 = "BT off trigger bond fail"
            com.upuphone.starrynet.common.StLog.d(r3, r13)
            com.upuphone.starrynet.api.bean.StDevice r13 = r12.mCacheStDevice
            java.lang.String r13 = r13.getBleMac()
            com.upuphone.starrynet.strategy.bean.StConnectDevice r13 = r12.getConnectRingDevice(r13)
            com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant$EnumConnectState r0 = com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant.EnumConnectState.MSG_BT_OFF
            r12.dealBondFail((com.upuphone.starrynet.strategy.bean.StConnectDevice) r13, (com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant.EnumConnectState) r0)
            r12.terminateUnusedAction(r10)
        L_0x00d4:
            r12.removeBondedRingCache()
            goto L_0x01e9
        L_0x00d9:
            r12.removeStatus(r9)
            r12.recordStatus(r5)
            goto L_0x01e9
        L_0x00e1:
            r12.removeStatus(r7)
            boolean r13 = r12.checkIfDuringStarryBonding()
            if (r13 != 0) goto L_0x01e9
            java.lang.String r13 = "hid reconnect fail"
            com.upuphone.starrynet.common.StLog.d(r3, r13)
            java.lang.String r13 = r0.getBleMac()
            r12.dealStarryConnectFailMsg(r13, r10)
            goto L_0x01e9
        L_0x00f8:
            r12.recordStatus(r7)
            boolean r13 = r12.checkStatusRecordContains(r1)
            if (r13 != 0) goto L_0x0104
            r12.tryRecoverConnection()
        L_0x0104:
            r12.removeCheckConnectTimeout(r2)
            goto L_0x01e9
        L_0x0109:
            java.lang.String r13 = "Ring BLE acl 断开"
            com.upuphone.starrynet.common.StLog.d(r3, r13)
            r13 = 512(0x200, float:7.175E-43)
            boolean r13 = r12.checkStatusRecordContains(r13)
            if (r13 == 0) goto L_0x0120
            java.lang.String r13 = "need to remove bond"
            com.upuphone.starrynet.common.StLog.d(r3, r13)
            android.bluetooth.BluetoothDevice r13 = r12.mBluetoothDevice
            r12.createOrRemoveBond(r6, r13)
        L_0x0120:
            com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant$EnumConnectState r13 = com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant.EnumConnectState.MSG_STATE_ACL_DISCONNECTED
            r12.dealDisconnect((com.upuphone.starrynet.strategy.bean.StConnectDevice) r0, (com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant.EnumConnectState) r13)
            boolean r1 = r12.checkIfDuringStarryBonding()
            if (r1 == 0) goto L_0x012e
            r12.dealBondFail((com.upuphone.starrynet.strategy.bean.StConnectDevice) r0, (com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant.EnumConnectState) r13)
        L_0x012e:
            r12.removeBondedRingCache()
            boolean r13 = r12.checkStatusRecordContains(r9)
            if (r13 != 0) goto L_0x013c
            r12.terminateUnusedAction(r10)
            goto L_0x01e9
        L_0x013c:
            java.lang.String r12 = "BLE still bonded, wait unbond done..."
            com.upuphone.starrynet.common.StLog.d(r3, r12)
            goto L_0x01e9
        L_0x0143:
            boolean r0 = r12.checkStatusRecordContainsAll(r11)
            r1 = 7
            if (r0 == 0) goto L_0x0153
            java.lang.String r13 = "ignore repeated ACL connect event"
            com.upuphone.starrynet.common.StLog.d(r3, r13)
            r12.removeCheckConnectTimeout(r1)
            return
        L_0x0153:
            r12.recordStatus(r11)
            android.bluetooth.BluetoothDevice r13 = r13.getDevice()
            r12.mBluetoothDevice = r13
            boolean r13 = r12.checkStatusRecordContains(r8)
            if (r13 == 0) goto L_0x017f
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "reconnect: "
            r13.append(r0)
            boolean r0 = r12.checkStatusRecordContains(r9)
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            com.upuphone.starrynet.common.StLog.d(r3, r13)
            android.bluetooth.BluetoothDevice r13 = r12.mBluetoothDevice
            r12.expectForHidHostConnection(r13)
        L_0x017f:
            r12.removeCheckConnectTimeout(r1)
            goto L_0x01e9
        L_0x0183:
            boolean r13 = r12.checkIfDuringStarryBonding()
            if (r13 == 0) goto L_0x019b
            boolean r13 = r12.checkStatusRecordContains(r11)
            if (r13 != 0) goto L_0x0195
            com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant$EnumConnectState r13 = com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant.EnumConnectState.MSG_STATE_STATE_UN_BOND
            r12.dealBondFail((com.upuphone.starrynet.strategy.bean.StConnectDevice) r0, (com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant.EnumConnectState) r13)
            goto L_0x01be
        L_0x0195:
            java.lang.String r13 = "ACL still connected, wait acl disconnect and then upload bond fail"
            com.upuphone.starrynet.common.StLog.d(r3, r13)
            goto L_0x01bf
        L_0x019b:
            com.upuphone.starrynet.strategy.data.StarryDeviceManager r13 = com.upuphone.starrynet.strategy.data.StarryDeviceManager.getInstance()
            r13.updateBondInfo(r0, r6)
            boolean r13 = r12.checkStatusRecordContains(r8)
            if (r13 == 0) goto L_0x01bb
            java.lang.String r13 = "system remove bond"
            com.upuphone.starrynet.common.StLog.d(r3, r13)
            com.upuphone.starrynet.api.bean.StDevice r13 = r12.mCacheStDevice
            com.upuphone.starrynet.strategy.utils.Ring2TrackUtils.trackStartRemoveBond(r13, r10)
            com.upuphone.starrynet.api.bean.StDevice r13 = r0.getDevice()
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r12.removeBond(r13, r0)
        L_0x01bb:
            r12.removeStatusExceptFor(r11)
        L_0x01be:
            r6 = r11
        L_0x01bf:
            r12.removeBondedRingCache()
            if (r6 == 0) goto L_0x01e9
            r12.terminateUnusedAction(r10)
            goto L_0x01e9
        L_0x01c8:
            boolean r13 = r12.checkStatusRecordContains(r11)
            if (r13 == 0) goto L_0x01de
            boolean r13 = r12.checkIfDuringStarryBonding()
            if (r13 == 0) goto L_0x01de
            com.upuphone.starrynet.api.bean.StDevice r13 = r12.mCacheStDevice
            r12.checkAndOpenNotify(r13)
            android.bluetooth.BluetoothDevice r13 = r12.mBluetoothDevice
            r12.expectForHidHostConnection(r13)
        L_0x01de:
            r12.removeStatus(r5)
            r12.recordStatus(r9)
            r13 = 10
            r12.removeCheckConnectTimeout(r13)
        L_0x01e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.channel.simpleble.MyvuRingBleClientChannel.eventHandler(com.upuphone.starrynet.core.ble.event.MYVURingEvent):void");
    }

    private void expectForHidHostConnection(BluetoothDevice bluetoothDevice) {
        if (!checkBtAdapterValid() || this.mBluetoothDevice == null || checkStatusRecordContains(2)) {
            StLog.d(TAG, "hid status: " + checkStatusRecordContains(2));
            return;
        }
        BluetoothHidHost bluetoothHidHost = this.mHidHost;
        if (bluetoothHidHost == null) {
            StLog.d(TAG, "HID not init");
            initHidHost();
        } else if (bluetoothHidHost.getConnectionState(bluetoothDevice) != 2) {
            StLog.d(TAG, "just wait auto connect hid ");
            addCheckConnectTimeoutByTime(this.mBluetoothDevice.getAddress(), 9, 8000);
        } else {
            StLog.d(TAG, "Hid already connected");
            sendInternalMessage(6, bluetoothDevice.getAddress(), 0, 0);
        }
    }

    /* access modifiers changed from: private */
    public StConnectDevice getConnectRingDevice(String str) {
        StConnectDevice connectDeviceByBleMac = StarryDeviceManager.getInstance().getConnectDeviceByBleMac(str);
        if (connectDeviceByBleMac == null || connectDeviceByBleMac.getTerminalType() != 5) {
            StLog.e(TAG, "get Ring device info error: " + connectDeviceByBleMac);
        }
        return connectDeviceByBleMac;
    }

    private StDevice getCurrentBondedBluetoothDevice() {
        if (!checkBtAdapterValid()) {
            return null;
        }
        List<StConnectDevice> bondInfoByTerminal = StarryDeviceManager.getInstance().getBondInfoByTerminal(5);
        if (bondInfoByTerminal == null || bondInfoByTerminal.size() == 0) {
            StLog.d(TAG, "no bonded ring device");
            return null;
        }
        recordStatus(256);
        StConnectDevice stConnectDevice = bondInfoByTerminal.get(0);
        StLog.d(TAG, "cache bonded ring device: " + stConnectDevice.getDeviceName());
        ArrayList arrayList = new ArrayList(this.mAdapter.getBondedDevices());
        if (arrayList.size() > 0) {
            ListIterator listIterator = arrayList.listIterator();
            while (true) {
                if (listIterator.hasNext()) {
                    if (stConnectDevice.getBleMac().equals(((BluetoothDevice) listIterator.next()).getAddress())) {
                        recordStatus(4);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return stConnectDevice.getDevice();
    }

    private void getFwVer() {
        StLog.d(TAG, "get FW ver..");
        this.mChannelCallback.onRecv(getConnectRingDevice(this.mCacheStDevice.getBleMac()), new byte[]{38}, 2, (IStarryNetChannel) null);
    }

    /* access modifiers changed from: private */
    public String getMsgTypeInfo(int i) {
        switch (i) {
            case 1:
                return "MSG_CHECK_STARRY_BOND_TIMEOUT";
            case 2:
                return "MSG_CMD_CONNECT_BLE_PROFILE";
            case 3:
                return "MSG_RING_EVENT_HANDLER";
            case 4:
                return "MSG_CMD_OPEN_NOTIFY";
            case 5:
                return "MSG_STATUS_SERVICE_READY";
            case 6:
                return "MSG_STATUS_HID_READY";
            case 7:
                return "MSG_CHECK_BLE_ACL_TIMEOUT";
            case 8:
                return "MSG_CHECK_BLE_SERVICE_READY_TIMEOUT";
            case 9:
                return "MSG_CHECK_BLE_HID_TIMEOUT";
            case 10:
                return "MSG_CHECK_BLE_BOND_TIMEOUT";
            case 11:
                return "MSG_RECV_STARRY_INTERNAL_MSG";
            case 12:
                return "MSG_CMD_SET_STARRY_BOND_STATUS";
            case 13:
                return "MSG_CMD_REMOVE_BLE_BOND";
            case 14:
                return "MSG_CHECK_REMOVE_BOND_TIMEOUT";
            case 15:
                return "MSG_CMD_REMOVE_BLE_BOND_BY_RING";
            case 16:
                return "MSG_CMD_ENCRYPTION_MODE_RING_CONFIRM";
            case 17:
                return "MSG_CMD_GET_SN_CONFIRM";
            case 18:
                return "MSG_CMD_GET_FW_VER_CONFIRM";
            case 19:
                return "MSG_CMD_RECOVER_BLE_PROFILE";
            case 20:
                return "MSG_STATUS_HID_INIT_DONE";
            default:
                return "unknown type";
        }
    }

    private StConnectDevice getOrAddNewRingStConnectDevice(StDevice stDevice) {
        if (stDevice == null) {
            StLog.w(TAG, "cacheConnectedDevice null");
            return null;
        }
        StLog.d(TAG, "cacheConnectedDevice: " + stDevice.getBleMac() + "(" + stDevice.getDeviceName() + ")");
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null) {
            connectDevice = new StConnectDevice();
            connectDevice.setDevice(stDevice);
        }
        connectDevice.setBleMac(stDevice.getBleMac());
        connectDevice.setDeviceType((byte) 5);
        return connectDevice;
    }

    private void getSN() {
        StLog.d(TAG, "get SN..");
        this.mChannelCallback.onRecv(getConnectRingDevice(this.mCacheStDevice.getBleMac()), new byte[]{37}, 2, (IStarryNetChannel) null);
    }

    private Ring2TrackerConstant.EnumConnectState getTrackerTypeInfo(int i) {
        if (i == 1) {
            return Ring2TrackerConstant.EnumConnectState.MSG_CHECK_STARRY_BOND_TIMEOUT;
        }
        if (i == 3) {
            return Ring2TrackerConstant.EnumConnectState.MSG_RING_EVENT_HANDLER;
        }
        switch (i) {
            case 7:
                return Ring2TrackerConstant.EnumConnectState.MSG_CHECK_BLE_ACL_TIMEOUT;
            case 8:
                return Ring2TrackerConstant.EnumConnectState.MSG_CHECK_BLE_SERVICE_READY_TIMEOUT;
            case 9:
                return Ring2TrackerConstant.EnumConnectState.MSG_CHECK_BLE_HID_TIMEOUT;
            case 10:
                return Ring2TrackerConstant.EnumConnectState.MSG_CHECK_BLE_BOND_TIMEOUT;
            default:
                return Ring2TrackerConstant.EnumConnectState.MSG_CONNECT_TIMEOUT;
        }
    }

    private Boolean initBondedRingCache() {
        this.mCacheStDevice = getCurrentBondedBluetoothDevice();
        StLog.d(TAG, "get bonded cache: " + this.mCacheStDevice);
        if (this.mCacheStDevice == null || !checkStatusRecordContains(4)) {
            return Boolean.FALSE;
        }
        mBondedRingIdentifier = this.mCacheStDevice.getIdentifier();
        this.mBluetoothDevice = BluetoothUtils.getRemoteDevice(this.mCacheStDevice.getBleMac());
        return Boolean.TRUE;
    }

    private void initHidHost() {
        if (this.mHidHost != null || !checkBtAdapterValid()) {
            StringBuilder sb = new StringBuilder();
            sb.append("not init HID now..: ");
            sb.append(this.mAdapter == null);
            StLog.d(TAG, sb.toString());
            return;
        }
        StLog.d(TAG, "try get hid proxy..");
        this.mAdapter.getProfileProxy(StarryNetData.getInstance().getApplicationContext(), new BluetoothProfile.ServiceListener() {
            public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                StLog.d(MyvuRingBleClientChannel.TAG, "bt service connected.." + i);
                if (i == 4) {
                    StLog.d(MyvuRingBleClientChannel.TAG, "hid service connected");
                    BluetoothHidHost unused = MyvuRingBleClientChannel.this.mHidHost = (BluetoothHidHost) bluetoothProfile;
                    MyvuRingBleClientChannel.this.sendInternalMessage(20, (Object) null, 0, 0);
                }
            }

            public void onServiceDisconnected(int i) {
                BluetoothHidHost unused = MyvuRingBleClientChannel.this.mHidHost = null;
                StLog.d(MyvuRingBleClientChannel.TAG, "invokeDisconnect onServiceDisconnected profile=" + i);
            }
        }, 4);
    }

    private void initPairDataChannel() {
        BleEventBus.get().register(CharacterChangedEvent.class, this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAndOpenNotify$0(StDevice stDevice, Boolean bool) {
        if (!bool.booleanValue()) {
            onConnectGattResult(stDevice, -9);
            return;
        }
        int i = this.notifyCounter + 1;
        this.notifyCounter = i;
        if (i == this.mNotifyMap.size()) {
            onConnectGattResult(stDevice, 0);
        }
    }

    public static void notifyDiscoveryRing(StDiscoveryDevice stDiscoveryDevice) {
        if ((mStatusRecord & 65536) <= 0 && checkDiscoveryDeviceIsSelfBonded(stDiscoveryDevice) && Byte.toUnsignedInt(stDiscoveryDevice.getAdvType()) == 160) {
            mStatusRecord |= 65536;
            StLog.w(TAG, "ring already offline remove bond " + stDiscoveryDevice.getBleMac());
            BleEventBus.get().post(new MYVURingEvent(stDiscoveryDevice.getBleMac(), 10, stDiscoveryDevice.getBluetoothDevice()));
        }
    }

    /* access modifiers changed from: private */
    public void onConnectGattResult(StDevice stDevice, int i) {
        sendInternalMessage(5, stDevice, i, 0);
    }

    private void openNotify(StDevice stDevice, final UUID uuid, final UUID uuid2, final Consumer<Boolean> consumer) {
        BleConnectManager.getInstance().notify(stDevice.getBleMac(), uuid, uuid2, new BleNotifyResponse() {
            public void onResponse(int i, Void voidR) {
                if (i == 0) {
                    StLog.d(MyvuRingBleClientChannel.TAG, "open notify(%s) success, service =%s, character = %s", MyvuRingBleClientChannel.this.mBluetoothDevice.getAddress(), uuid.toString(), uuid2.toString());
                } else {
                    StLog.d(MyvuRingBleClientChannel.TAG, "open notify(%s) fail, service =%s, character = %s", MyvuRingBleClientChannel.this.mBluetoothDevice.getAddress(), uuid.toString(), uuid2.toString());
                }
                Consumer consumer = consumer;
                if (consumer != null) {
                    consumer.accept(Boolean.valueOf(i == 0));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public synchronized void recordStatus(int i) {
        mStatusRecord = i | mStatusRecord;
    }

    private void removeBondedRingCache() {
        if (checkStatusRecordContains(37)) {
            StLog.d(TAG, "remove cache: wait clear after remove bond done");
            debugStatusRecord();
        } else if (!checkStatusRecordContains(256)) {
            StLog.d(TAG, "remove cache: " + debugByteArray(mBondedRingIdentifier));
            this.mCacheStDevice = null;
            this.mBluetoothDevice = null;
            mBondedRingIdentifier = null;
        }
    }

    /* access modifiers changed from: private */
    public void removeCheckConnectTimeout(int i) {
        StLog.d(TAG, "connect check procedure (%s) done", getMsgTypeInfo(i));
        this.mHandler.removeMessages(i);
    }

    /* access modifiers changed from: private */
    public synchronized void removeStatus(int i) {
        try {
            StLog.d(TAG, "removeStatus: " + Integer.toString(i));
            if (i == 0) {
                mStatusRecord = 0;
            } else {
                mStatusRecord = (~i) & mStatusRecord;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void removeStatusButSet(int i) {
        StLog.d(TAG, "removeStatusButKeep: " + Integer.toString(i));
        removeStatus(0);
        recordStatus(i);
    }

    /* access modifiers changed from: private */
    public synchronized void removeStatusExceptFor(int i) {
        StLog.d(TAG, "removeStatusExceptFor: " + Integer.toString(i));
        int i2 = i & mStatusRecord;
        mStatusRecord = i2;
        if (i2 > 0) {
            StLog.d(TAG, "keep status: " + Integer.toString(mStatusRecord));
        }
    }

    private boolean sendInternalConnectCmd(StDevice stDevice, int i) {
        if (checkStatusRecordContains(65536)) {
            StLog.d(TAG, "already offline remove bond, do not connect");
            return false;
        } else if (i != 2 && i != 19) {
            StLog.e(TAG, "sendInternalConnectCmd PARAM ERROR");
            return false;
        } else if (!checkIfDuringConnecting()) {
            sendInternalMessage(i, stDevice, checkStatusRecordContains(3) ? 1 : 0, 0);
            return true;
        } else {
            StLog.w(TAG, "connect cmd ongoing");
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void sendInternalMessage(int i, Object obj, int i2, int i3) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(i, i2, i3, obj));
    }

    private void sendInternalMessageDelayed(int i, Object obj, int i2, int i3, int i4) {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(i, i2, i3, obj), (long) i4);
    }

    private boolean sendInternalMessageDelayedUnique(int i, Object obj, int i2, int i3, int i4) {
        if (this.mHandler.hasMessages(i)) {
            return false;
        }
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(i, i2, i3, obj), (long) i4);
        return true;
    }

    private boolean sendInternalMessageUnique(int i, Object obj, int i2, int i3) {
        if (this.mHandler.hasMessages(i)) {
            return false;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(i, i2, i3, obj));
        return true;
    }

    private void startAuth() {
        if (checkStatusRecordContains(192)) {
            StLog.w(TAG, "no need to auth again");
            return;
        }
        StLog.w(TAG, "startAuth...");
        recordStatus(64);
        this.mChannelCallback.onRecv(getConnectRingDevice(this.mCacheStDevice.getBleMac()), new byte[]{33}, 2, (IStarryNetChannel) null);
    }

    /* access modifiers changed from: private */
    public void terminateAction(int i, int i2) {
        StLog.d(TAG, "remove " + getMsgTypeInfo(i2) + " by " + getMsgTypeInfo(i));
        int[] iArr = mEventRemoveMap;
        int length = iArr.length;
        int i3 = 0;
        while (i3 < length) {
            if (i2 != iArr[i3]) {
                i3++;
            } else {
                return;
            }
        }
        this.mHandler.removeMessages(i2);
    }

    /* access modifiers changed from: private */
    public void terminateUnusedAction(int i) {
        StLog.d(TAG, "remove all messages left by " + getMsgTypeInfo(i));
        for (int removeMessages : mEventRemoveMap) {
            this.mHandler.removeMessages(removeMessages);
        }
    }

    private void tryRecoverConnection() {
        if (this.mCacheStDevice != null || initBondedRingCache().booleanValue()) {
            StLog.d(TAG, "Has ring bonded, recover connection");
            sendInternalConnectCmd(this.mCacheStDevice, 19);
        }
    }

    public int connect(StDevice stDevice) {
        if (stDevice == null || stDevice.getStatus() == 5) {
            StLog.w(TAG, "connect , device is null or status is not connectable");
            return StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_PARAM_ERROR;
        } else if (checkStatusRecordContains(1) || checkStatusRecordContains(16)) {
            StLog.w(TAG, "connect method is going ,so ignore this connect request!STATE_BLE_ACL_CONNECTED: " + checkStatusRecordContains(1) + ", STATE_BLE_ACL_CONNECTING: " + checkStatusRecordContains(16));
            return StErrorCode.CONNECT_STRATEGY_BLE_CONNECTING;
        } else {
            addCheckConnectTimeoutByTime(stDevice.getBleMac(), 1, TIMEOUT_STARRY_BOND);
            sendInternalConnectCmd(stDevice, 2);
            return 0;
        }
    }

    public int disconnect(StDevice stDevice) {
        BleConnectManager.getInstance().disconnect(stDevice.getBleMac());
        return 0;
    }

    public BleConnectConfig getConnectConfig(StDevice stDevice) {
        BleConnectConfig bleConnectConfig = new BleConnectConfig(stDevice.getBleMac());
        bleConnectConfig.openHighSpeed(false);
        bleConnectConfig.checkDestCharacterUUID(DATA_Characteristic);
        bleConnectConfig.setMaxRetryTimes(0);
        return bleConnectConfig;
    }

    public StConnectDevice getConnectDevice(String str) {
        return getConnectRingDevice(str);
    }

    public int getProfile() {
        return 25;
    }

    public void notifyStarryBond(StDevice stDevice, int i, int i2) {
        Log.d(TAG, "notify bond: " + i + ", state: " + i2);
        if (i == 0) {
            sendInternalMessage(12, stDevice, i2, 0);
        }
    }

    public void onEncryptionModeChangeConfirm(StDevice stDevice, int i) {
        if (checkStatusRecordContainsAll(STATE_MASK_STARRY_BONDED_CONNECTED)) {
            sendInternalMessage(16, stDevice, i, 0);
        }
    }

    public void onEvent(Object obj) {
        if (obj instanceof MYVURingEvent) {
            MYVURingEvent mYVURingEvent = (MYVURingEvent) obj;
            StLog.d(TAG, "got a MYVU ring event: " + mYVURingEvent.getState());
            if (mYVURingEvent.getState() == 9 || mYVURingEvent.getState() == 8 || mYVURingEvent.getState() == 10 || checkMacValid(mYVURingEvent.getBleMac())) {
                sendInternalMessage(3, mYVURingEvent, 0, 0);
            }
        } else if (obj instanceof CharacterChangedEvent) {
            CharacterChangedEvent characterChangedEvent = (CharacterChangedEvent) obj;
            if (characterChangedEvent.getCharacter().equals(NOTIY_Characteristic)) {
                StLog.d(TAG, "got a MYVU ring internal message(len: " + characterChangedEvent.getValue().length + "), type: " + (characterChangedEvent.getValue()[0] & 255));
                sendInternalMessage(11, characterChangedEvent.getValue(), 0, 0);
            }
        }
    }

    public void onGetFWVerCmdConfirm(StDevice stDevice, int i) {
        sendInternalMessage(18, stDevice, i, 0);
    }

    public void onGetSNCmdConfirm(StDevice stDevice, int i) {
        sendInternalMessage(17, stDevice, i, 0);
    }

    public boolean removeBond(StDevice stDevice) {
        removeBond(stDevice, Boolean.TRUE);
        return false;
    }

    public void sendMessage(StDevice stDevice, byte[] bArr) {
        BleConnectManager.getInstance().writeNoRsp(stDevice.getBleMac(), SERVICE_DATA, DATA_Characteristic, bArr, new BleWriteNoRespResponse() {
            public void onResponse(int i, Void voidR) {
                if (i == 0) {
                    Log.d(MyvuRingBleClientChannel.TAG, "ring channel send message success ");
                    return;
                }
                Log.d(MyvuRingBleClientChannel.TAG, "ring channel send message fail: " + i);
            }
        });
    }

    public void setCallback(IChannelCallback iChannelCallback) {
        this.mChannelCallback = iChannelCallback;
    }

    public boolean removeBond(StDevice stDevice, Boolean bool) {
        StringBuilder sb = new StringBuilder();
        sb.append("call remove bond ");
        StDevice stDevice2 = this.mCacheStDevice;
        sb.append(stDevice2 == null ? "null" : stDevice2.getBleMac());
        sb.append(", ");
        sb.append(stDevice.getBleMac());
        StLog.d(TAG, sb.toString());
        sendInternalMessage(13, stDevice.getBleMac(), 0, 0);
        return false;
    }

    private void dealBondFail(StConnectDevice stConnectDevice, boolean z) {
        if (stConnectDevice == null) {
            StLog.e(TAG, "device is null");
            return;
        }
        StLog.d(TAG, "upload bond fail event, isCalledByAclDisconnect: " + z);
        removeStatus(32880);
        if (this.mBluetoothDevice != null) {
            if (z || !checkStatusRecordContainsAll(5)) {
                createOrRemoveBond(false, this.mBluetoothDevice);
                removeStatusExceptFor(1);
            } else {
                StLog.d(TAG, "set remove bond task in line");
                removeBond(stConnectDevice.getDevice());
            }
        }
        StarryDeviceManager.getInstance().connectFail(stConnectDevice.getDevice(), StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_FAIL, 1);
        StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice, 0);
        RemovePairDataChannel();
    }

    private void dealDisconnect(StConnectDevice stConnectDevice, boolean z) {
        int i;
        if (stConnectDevice == null || this.mChannelCallback == null) {
            StLog.e(TAG, "device or callback is null, starry bond state: " + checkStatusRecordContainsAll(STATE_MASK_STARRY_BONDED_CONNECTED));
            debugStatusRecord();
            return;
        }
        StLog.d(TAG, "upload disconnect event");
        if (z) {
            StLog.d(TAG, "HID disconnect, maybe keep acl for now");
            i = 261;
        } else {
            i = AnimationUtils.ANIMATION_DURATION_TRANSLATION;
        }
        if (checkStatusRecordContains(1)) {
            this.mChannelCallback.onDisconnected(stConnectDevice, this);
        }
        removeStatusExceptFor(i);
        RemovePairDataChannel();
    }
}
