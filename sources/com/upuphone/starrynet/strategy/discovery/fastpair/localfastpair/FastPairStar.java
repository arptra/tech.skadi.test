package com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Message;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.starrynet.api.StTestConstant;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.LocalSharePreference;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.StarryNetConstant;
import com.upuphone.starrynet.core.ble.event.EventReceiver;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.channel.bredr.BrEdrChannel;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairBaseController;
import com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.event.FastPairConnectChangeEvent;
import com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.event.FastPairEventBus;
import com.upuphone.starrynet.strategy.discovery.fastpair.localfastpair.event.FastPairOperateEvent;
import com.xjsd.ai.assistant.protocol.AssistantConstants;

public class FastPairStar extends FastPairLocal implements EventReceiver {
    private static final String KEY_INTERNATIONAL_PRIVACY_OUT_DATE = "international_privacy_out_date";
    public static final int STATE_FIND = 0;
    private static final String TAG = "FastPairStar";
    public static final int TIMEOUT_WAIT_ACTIVITY_STARTED = 2000;
    private volatile boolean isPairing = false;
    private String mCacheId;
    private Object mFastPairWindow;
    /* access modifiers changed from: private */
    public Boolean mInternationalPrivacyOutDate = null;
    /* access modifiers changed from: private */
    public LocalSharePreference mLocalSharePreference;

    public interface IDeviceStateChangeCallback {
        void onStatusChange(int i);
    }

    public FastPairStar(Context context) {
        super(context);
        FastPairEventBus.get().register(FastPairOperateEvent.class, this);
        LocalSharePreference localSharePreference = new LocalSharePreference(context, "mv-iot");
        this.mLocalSharePreference = localSharePreference;
        localSharePreference.setRemotePreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                StLog.d(FastPairStar.TAG, "onSharedPreferenceChanged key =" + str);
                if (FastPairStar.KEY_INTERNATIONAL_PRIVACY_OUT_DATE.equals(str)) {
                    FastPairStar fastPairStar = FastPairStar.this;
                    Boolean unused = fastPairStar.mInternationalPrivacyOutDate = Boolean.valueOf(fastPairStar.mLocalSharePreference.getSharedPreferences().getBoolean(str, false));
                }
            }
        });
    }

    private void showFastPairWindow(StDevice stDevice) {
        StLog.d(TAG, "显示配对弹窗，当前的设备名称是：" + stDevice.getDeviceName() + StTestConstant.POINT_BLE_FOUND + " id = " + stDevice.getIdentifier2String());
        this.mFastPairWindow = new Object();
        StringBuilder sb = new StringBuilder();
        sb.append(stDevice.getCategoryID());
        sb.append(stDevice.getModelID());
        String sb2 = sb.toString();
        Intent intent = new Intent();
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        intent.putExtra("id", sb2);
        intent.putExtra("name", stDevice.getDeviceName());
        intent.setClass(this.mContext, FastPairStarActivity.class);
        this.mContext.startActivity(intent);
        FastPairBaseController.FastPairHandler fastPairHandler = this.mHandler;
        fastPairHandler.sendMessageDelayed(fastPairHandler.obtainMessage(2), AssistantConstants.TIMEOUT_VAD_MUTE);
    }

    public void dealBondFailMessage(Message message) {
        this.mFastPairConnectDevice = null;
        this.mHandler.removeMessages(8);
        if (this.mFastPairWindow == null) {
            setPairing(false);
            return;
        }
        FastPairConnectChangeEvent fastPairConnectChangeEvent = new FastPairConnectChangeEvent(3);
        int i = message.arg1;
        if (i == 112010 || i == 112006) {
            fastPairConnectChangeEvent.setErrorCode(2);
        } else if (i == 112003) {
            fastPairConnectChangeEvent.setErrorCode(1);
        } else {
            fastPairConnectChangeEvent.setErrorCode(i);
        }
        FastPairEventBus.get().post(fastPairConnectChangeEvent);
    }

    public void dealBondOkMessage(Message message) {
        this.mFastPairConnectDevice = null;
        this.mHandler.removeMessages(8);
        if (this.mFastPairWindow == null) {
            setPairing(false);
            return;
        }
        FastPairEventBus.get().post(new FastPairConnectChangeEvent(2));
    }

    public void dealClickConnectMessage(Message message) {
        StDevice stDevice = (StDevice) message.obj;
        if (stDevice == null) {
            StLog.i(TAG, "dealClickConnectMessage device is null");
        } else if (!StarryDeviceManager.getInstance().getConnectedDevicesBySpecialDevice(stDevice.getCategoryID()).isEmpty()) {
            StLog.e(TAG, "exit same category is connected" + stDevice.getDeviceName());
        } else {
            connectStDevice(stDevice);
            if (this.mFastPairWindow == null) {
                StLog.i(TAG, "the star fast pair window is null");
                return;
            }
            FastPairEventBus.get().post(new FastPairConnectChangeEvent(1));
            if (this.mHandler.hasMessages(2)) {
                this.mHandler.removeMessages(2);
            }
        }
    }

    public void dealConnectTimeoutMessage(Message message) {
        this.mFastPairConnectDevice = null;
        if (this.mFastPairWindow == null) {
            StLog.e(TAG, "connect device timeout ,pair window is null ,return");
            setPairing(false);
            return;
        }
        StLog.i(TAG, "connect device timeout ,dismiss window!");
        FastPairConnectChangeEvent fastPairConnectChangeEvent = new FastPairConnectChangeEvent(3);
        fastPairConnectChangeEvent.setErrorCode(1);
        FastPairEventBus.get().post(fastPairConnectChangeEvent);
    }

    public void dealDismissWindowMessage(Message message) {
        dismissWindows();
    }

    public void dealShowWindowMessage(Message message) {
        this.mFastPairShowDevice = (StDevice) message.obj;
        if (this.mFastPairShowDevice == null) {
            StLog.i(TAG, "handleMessage: showDevice is null");
            return;
        }
        StLog.i(TAG, "handleMessage: showDevice : " + this.mFastPairShowDevice.getBleMac());
        showFastPairWindow(this.mFastPairShowDevice);
    }

    public void dismissWindows() {
        this.mFastPairWindow = null;
        this.mFastPairShowDevice = null;
        if (this.mFastPairConnectDevice == null) {
            setPairing(false);
            this.mHandler.removeCallbacksAndMessages((Object) null);
        }
    }

    public boolean getPairing() {
        return this.isPairing;
    }

    public boolean isPairingDevice(StDevice stDevice) {
        return stDevice != null && this.mCacheId != null && this.isPairing && this.mCacheId.equals(stDevice.getIdentifier2String());
    }

    public boolean isPopOrConnect(StDiscoveryDevice stDiscoveryDevice, int i, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 4) {
                    if (i == 7) {
                        StLog.i(TAG, "Remove Local Bondinfo FAST_PAIR_RESULT_ADV_BOND_OTHER_SCAN_BOND");
                        FastPairBaseController.FastPairHandler fastPairHandler = this.mHandler;
                        fastPairHandler.sendMessage(fastPairHandler.obtainMessage(11, stDiscoveryDevice));
                        if (this.isPairing) {
                            return false;
                        }
                    }
                } else if (this.isPairing) {
                    return false;
                } else {
                    if (StarryNetData.getInstance().getOwnDevice().getTerminalType() == 4) {
                        if (this.mInternationalPrivacyOutDate == null) {
                            this.mInternationalPrivacyOutDate = Boolean.valueOf(this.mLocalSharePreference.getSharedPreferences().getBoolean(KEY_INTERNATIONAL_PRIVACY_OUT_DATE, false));
                        }
                        if (this.mInternationalPrivacyOutDate.booleanValue()) {
                            StLog.i(TAG, "Direct Setup Connect ,forbid, because privacy is out date! name =" + stDiscoveryDevice.getDeviceName());
                            return false;
                        }
                    }
                    StLog.i(TAG, "Direct Setup Connect: Reconnect -- %s", stDiscoveryDevice.getDeviceName());
                    setPairing(true);
                    this.mCacheId = stDiscoveryDevice.getIdentifier2String();
                    this.mHandler.obtainMessage(13, stDiscoveryDevice).sendToTarget();
                }
                return true;
            }
            StLog.i(TAG, "Remove Local Bondinfo FAST_PAIR_RESULT_ADV_UN_BOND_SCAN_BOND");
            FastPairBaseController.FastPairHandler fastPairHandler2 = this.mHandler;
            fastPairHandler2.sendMessage(fastPairHandler2.obtainMessage(11, stDiscoveryDevice));
        }
        if (BrEdrChannel.getBrEdrBondState(stDiscoveryDevice) == 12) {
            BrEdrChannel.removeBondBrEdr(stDiscoveryDevice);
        }
        if (i2 == 1) {
            return true;
        }
        if (SysActionManager.getInstance().isScreenLocked() || this.mContext.getResources().getConfiguration().orientation == 2 || this.isPairing) {
            return false;
        }
        StLog.i(TAG, "Trigger the Discovery toast");
        setPairing(true);
        this.mCacheId = stDiscoveryDevice.getIdentifier2String();
        FastPairBaseController.FastPairHandler fastPairHandler3 = this.mHandler;
        fastPairHandler3.sendMessage(fastPairHandler3.obtainMessage(1, stDiscoveryDevice));
        return true;
    }

    public void onBleConnected(StDevice stDevice) {
        super.onBleConnected(stDevice);
        if (stDevice.isBleConnected()) {
            onBluetoothConnected(stDevice);
        }
    }

    public void onBluetoothConnected(StDevice stDevice) {
        if (stDevice != null) {
            FastPairBaseController.FastPairHandler fastPairHandler = this.mHandler;
            fastPairHandler.sendMessage(fastPairHandler.obtainMessage(5, stDevice.getIdentifier()));
        }
    }

    public void onBrEdrConnected(StDevice stDevice) {
        this.mHandler.removeMessages(7);
    }

    public void onEvent(Object obj) {
        if (obj instanceof FastPairOperateEvent) {
            FastPairOperateEvent fastPairOperateEvent = (FastPairOperateEvent) obj;
            StLog.d(TAG, "event action = " + fastPairOperateEvent.getAction());
            int action = fastPairOperateEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    FastPairBaseController.FastPairHandler fastPairHandler = this.mHandler;
                    fastPairHandler.sendMessage(fastPairHandler.obtainMessage(2));
                } else if (action == 2) {
                    StLog.i(TAG, "onStartSuperApp");
                    try {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName("com.upuphone.star.launcher", StarryNetConstant.SUPER_APP_ACTIVITY));
                        intent.setAction("android.intent.action.VIEW");
                        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                        this.mContext.startActivity(intent);
                    } catch (Exception e) {
                        StLog.e(TAG, "Exception", (Throwable) e);
                    }
                } else if (action == 3) {
                    StLog.i(TAG, "onInstallSuperApp");
                } else if (action == 4 && this.mHandler.hasMessages(2)) {
                    StLog.d(TAG, "activity start, remove dismiss message");
                    this.mHandler.removeMessages(2);
                }
            } else if (this.mFastPairShowDevice == null) {
                StLog.i(TAG, "onConfirm: fastPairStDevice is null");
            } else {
                FastPairBaseController.FastPairHandler fastPairHandler2 = this.mHandler;
                fastPairHandler2.sendMessage(fastPairHandler2.obtainMessage(3, this.mFastPairShowDevice));
            }
        }
    }

    public void setPairing(boolean z) {
        StLog.i(TAG, "setPairing " + z);
        this.isPairing = z;
    }
}
