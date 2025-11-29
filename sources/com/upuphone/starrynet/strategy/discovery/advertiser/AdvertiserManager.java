package com.upuphone.starrynet.strategy.discovery.advertiser;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.SysActionManager;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackManager;
import com.upuphone.starrynet.strategy.utils.BleUtil;

@SuppressLint({"MissingPermission"})
public abstract class AdvertiserManager {
    public static final int ADV_STATE_SUCCESS = 0;
    public static final int ADV_TYPE_ACTIVE = 1;
    public static final int ADV_TYPE_CONNECT = 4;
    public static final int ADV_TYPE_NOTIFY = 16;
    public static final int ADV_TYPE_PASSIVE = 2;
    public static final int ADV_TYPE_RECONNECT = 8;
    public static final int ADV_TYPE_UUP_SHARE = 32;
    public static final int ADV_TYPE_UUP_SHARE_RSP = 64;
    private static final String TAG = "AdvertiserManager";
    protected AdvertiseCallback mActiveAdvCallback;
    protected BluetoothAdapter mAdapter;
    protected IAdvStartCallback mAdvStartCallback;
    protected BluetoothLeAdvertiser mAdvertiser;
    protected AdvertiseCallback mConnectAdvCallback;
    private AdvertiseSettings mConnectableAdvSettings;
    private AdvertiseSettings mConnectableRspAdvSettings;
    protected AdvertiseCallback mNotifyAdvCallback;
    protected AdvertiseCallback mPassiveAdvCallback;
    protected AdvertiseCallback mReConnectAdvCallback;
    private AdvertiseSettings mUnConnectableAdvSettings;
    private AdvertiseCallback mUupShareAdvCallback;

    public interface IAdvStartCallback {
        void onAdvStatus(int i, int i2);
    }

    public AdvertiserManager() {
        initAdvertiser();
    }

    public synchronized AdvertiseCallback getActiveAdvCallback() {
        try {
            if (this.mActiveAdvCallback == null) {
                this.mActiveAdvCallback = new AdvertiseCallback() {
                    public void onStartFailure(int i) {
                        super.onStartFailure(i);
                        StLog.i(AdvertiserManager.TAG, "active adv onStartFailure : " + i);
                        AdvertiserManager.this.mAdvStartCallback.onAdvStatus(1, i);
                    }

                    public void onStartSuccess(AdvertiseSettings advertiseSettings) {
                        super.onStartSuccess(advertiseSettings);
                        StLog.i(AdvertiserManager.TAG, "active adv onStartSuccess");
                        AdvertiserManager.this.mAdvStartCallback.onAdvStatus(1, 0);
                    }
                };
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mActiveAdvCallback;
    }

    public synchronized AdvertiseCallback getConnectAdvCallback() {
        try {
            if (this.mConnectAdvCallback == null) {
                this.mConnectAdvCallback = new AdvertiseCallback() {
                    public void onStartFailure(int i) {
                        super.onStartFailure(i);
                        StLog.i(AdvertiserManager.TAG, "Connect adv onStartFailure : " + i);
                        AdvertiserManager.this.mAdvStartCallback.onAdvStatus(4, i);
                    }

                    public void onStartSuccess(AdvertiseSettings advertiseSettings) {
                        super.onStartSuccess(advertiseSettings);
                        StLog.i(AdvertiserManager.TAG, "Connect adv onStartSuccess");
                        AdvertiserManager.this.mAdvStartCallback.onAdvStatus(4, 0);
                    }
                };
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mConnectAdvCallback;
    }

    public synchronized AdvertiseSettings getConnectableAdvSettings(int i) {
        try {
            if (this.mConnectableAdvSettings == null) {
                this.mConnectableAdvSettings = new AdvertiseSettings.Builder().setAdvertiseMode(2).setTimeout(i).setConnectable(true).build();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mConnectableAdvSettings;
    }

    public synchronized AdvertiseSettings getConnectableRspSettings(int i) {
        try {
            if (this.mConnectableRspAdvSettings == null) {
                this.mConnectableRspAdvSettings = new AdvertiseSettings.Builder().setAdvertiseMode(2).setTimeout(i).setConnectable(true).build();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mConnectableRspAdvSettings;
    }

    public synchronized AdvertiseCallback getNotifyAdvCallback() {
        try {
            if (this.mNotifyAdvCallback == null) {
                this.mNotifyAdvCallback = new AdvertiseCallback() {
                    public void onStartFailure(int i) {
                        super.onStartFailure(i);
                        StLog.i(AdvertiserManager.TAG, "notify adv onStartFailure : " + i);
                        AdvertiserManager.this.mAdvStartCallback.onAdvStatus(16, i);
                    }

                    public void onStartSuccess(AdvertiseSettings advertiseSettings) {
                        super.onStartSuccess(advertiseSettings);
                        StLog.i(AdvertiserManager.TAG, "notify adv onStartSuccess");
                        AdvertiserManager.this.mAdvStartCallback.onAdvStatus(16, 0);
                    }
                };
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mNotifyAdvCallback;
    }

    public synchronized AdvertiseCallback getPassiveAdvCallback() {
        try {
            if (this.mPassiveAdvCallback == null) {
                this.mPassiveAdvCallback = new AdvertiseCallback() {
                    public void onStartFailure(int i) {
                        super.onStartFailure(i);
                        StLog.i(AdvertiserManager.TAG, "passive adv onStartFailure : " + i);
                        AdvertiserManager.this.mAdvStartCallback.onAdvStatus(2, i);
                    }

                    public void onStartSuccess(AdvertiseSettings advertiseSettings) {
                        super.onStartSuccess(advertiseSettings);
                        StLog.i(AdvertiserManager.TAG, "passive adv onStartSuccess point_ble_adv_start");
                        AdvertiserManager.this.mAdvStartCallback.onAdvStatus(2, 0);
                    }
                };
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mPassiveAdvCallback;
    }

    public synchronized AdvertiseCallback getReConnectAdvCallback() {
        try {
            if (this.mReConnectAdvCallback == null) {
                this.mReConnectAdvCallback = new AdvertiseCallback() {
                    public void onStartFailure(int i) {
                        StLog.i(AdvertiserManager.TAG, "reConnect adv onStartFailure : " + i);
                        AdvertiserManager.this.mAdvStartCallback.onAdvStatus(8, i);
                    }

                    public void onStartSuccess(AdvertiseSettings advertiseSettings) {
                        StLog.i(AdvertiserManager.TAG, "reConnect adv onStartSuccess point_ble_adv_start");
                        AdvertiserManager.this.mAdvStartCallback.onAdvStatus(8, 0);
                    }
                };
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mReConnectAdvCallback;
    }

    public synchronized AdvertiseSettings getUnConnectableAdvSettings(int i) {
        try {
            if (this.mUnConnectableAdvSettings == null) {
                this.mUnConnectableAdvSettings = new AdvertiseSettings.Builder().setAdvertiseMode(2).setTimeout(i).setConnectable(false).build();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mUnConnectableAdvSettings;
    }

    public AdvertiseCallback getUupShareAdvCallback() {
        if (this.mUupShareAdvCallback == null) {
            this.mUupShareAdvCallback = new AdvertiseCallback() {
                public void onStartFailure(int i) {
                    super.onStartFailure(i);
                    StLog.d(AdvertiserManager.TAG, "UupShare Discovery Start Failure : " + i);
                    AdvertiserManager.this.mAdvStartCallback.onAdvStatus(32, i);
                }

                public void onStartSuccess(AdvertiseSettings advertiseSettings) {
                    super.onStartSuccess(advertiseSettings);
                    StLog.d(AdvertiserManager.TAG, "UupShare Discovery Start Success");
                    AdvertiserManager.this.mAdvStartCallback.onAdvStatus(32, 0);
                }
            };
        }
        return this.mUupShareAdvCallback;
    }

    public AdvertiseCallback getUupShareRspAdvCallback() {
        if (this.mUupShareAdvCallback == null) {
            this.mUupShareAdvCallback = new AdvertiseCallback() {
                public void onStartFailure(int i) {
                    super.onStartFailure(i);
                    StLog.d(AdvertiserManager.TAG, "UupShare Discovery Start Failure : " + i);
                    AdvertiserManager.this.mAdvStartCallback.onAdvStatus(64, i);
                }

                public void onStartSuccess(AdvertiseSettings advertiseSettings) {
                    super.onStartSuccess(advertiseSettings);
                    StLog.d(AdvertiserManager.TAG, "UupShare Discovery Start Success");
                    AdvertiserManager.this.mAdvStartCallback.onAdvStatus(64, 0);
                }
            };
        }
        return this.mUupShareAdvCallback;
    }

    public void initAdvertiser() {
        if (this.mAdapter == null) {
            this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        BluetoothAdapter bluetoothAdapter = this.mAdapter;
        if (bluetoothAdapter != null && this.mAdvertiser == null) {
            this.mAdvertiser = bluetoothAdapter.getBluetoothLeAdvertiser();
        }
    }

    public void registerAdvStartCallback(IAdvStartCallback iAdvStartCallback) {
        this.mAdvStartCallback = iAdvStartCallback;
    }

    public synchronized void startActiveAdv(int i, int i2) {
        StLog.d(TAG, "startActiveAdv do nothing");
    }

    public synchronized void startConnectAdv(int i, byte[] bArr, int i2) {
        if (this.mAdvertiser != null && SysActionManager.getInstance().isBtOn()) {
            StLog.i(TAG, "startConnectAdv");
            try {
                this.mAdvertiser.startAdvertising(getConnectableAdvSettings(i), AdvPackManager.getPackHelper().getAdvertiseData(31, i2), AdvPackManager.getPackHelper().getRspAdvertiseData(31, bArr), getConnectAdvCallback());
            } catch (Exception e) {
                StLog.d(TAG, "startUupShareResponseAdv", (Throwable) e);
            }
        }
        return;
    }

    public synchronized void startNotifyAdv(int i, byte[] bArr, int i2) {
        if (this.mAdvertiser != null && SysActionManager.getInstance().isBtOn()) {
            StLog.i(TAG, "startNotifyAdv ");
            try {
                this.mAdvertiser.startAdvertising(getUnConnectableAdvSettings(i), AdvPackManager.getPackHelper().getAdvertiseData(42, i2), AdvPackManager.getPackHelper().getRspAdvertiseData(42, bArr), getNotifyAdvCallback());
            } catch (Exception e) {
                StLog.e(TAG, "startNotifyAdv", (Throwable) e);
            }
        }
        return;
    }

    public synchronized void startPassiveAdv(int i, byte[] bArr, int i2) {
        StLog.d(TAG, "startPassiveAdv do nothing");
    }

    public synchronized void startReconnectAdv(int i, byte[] bArr, int i2) {
        if (this.mAdvertiser != null && SysActionManager.getInstance().isBtOn()) {
            StLog.d(TAG, "startReconnectAdv point_ble_adv_set");
            try {
                this.mAdvertiser.startAdvertising(getConnectableAdvSettings(i), AdvPackManager.getPackHelper().getAdvertiseData(33, i2), AdvPackManager.getPackHelper().getRspAdvertiseData(33, bArr), getReConnectAdvCallback());
            } catch (Exception e) {
                StLog.d(TAG, "startReconnectAdv", (Throwable) e);
            }
        }
        return;
    }

    public void startUp(short s) {
        AdvPackManager.getPackHelper().setAbility(s);
    }

    public synchronized void startUupShareAdv(int i) {
        if (this.mAdvertiser != null && SysActionManager.getInstance().isBtOn()) {
            StLog.d(TAG, "startUupShareAdv");
            try {
                this.mAdvertiser.startAdvertising(getConnectableAdvSettings(i), BleUtil.getUupShareAdvData(), BleUtil.getUupShareAdvResponseData(), getUupShareAdvCallback());
            } catch (Exception e) {
                StLog.d(TAG, "startUupShareAdv", (Throwable) e);
            }
        }
        return;
    }

    public void startUupShareResponseAdv(int i) {
        if (this.mAdvertiser != null && SysActionManager.getInstance().isBtOn()) {
            StLog.d(TAG, "startUupShareResponseAdv");
            try {
                this.mAdvertiser.startAdvertising(getConnectableAdvSettings(i), BleUtil.getUupShareAdvData(), BleUtil.getUupShareAdvResponseData(), getUupShareRspAdvCallback());
            } catch (Exception e) {
                StLog.d(TAG, "startUupShareResponseAdv", (Throwable) e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007f, code lost:
        return;
     */
    @android.annotation.SuppressLint({"MissingPermission"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void stopAdv(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.bluetooth.le.BluetoothLeAdvertiser r0 = r3.mAdvertiser     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            java.lang.String r0 = "AdvertiserManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            r1.<init>()     // Catch:{ all -> 0x0041 }
            java.lang.String r2 = "stopAdv type = "
            r1.append(r2)     // Catch:{ all -> 0x0041 }
            r1.append(r4)     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0041 }
            com.upuphone.starrynet.common.StLog.d(r0, r1)     // Catch:{ all -> 0x0041 }
            r0 = 1
            if (r4 == r0) goto L_0x0075
            r0 = 2
            if (r4 == r0) goto L_0x006b
            r0 = 4
            if (r4 == r0) goto L_0x0061
            r0 = 8
            if (r4 == r0) goto L_0x0057
            r0 = 16
            if (r4 == r0) goto L_0x004d
            r0 = 32
            if (r4 == r0) goto L_0x0043
            r0 = 64
            if (r4 == r0) goto L_0x0037
            goto L_0x007e
        L_0x0037:
            android.bluetooth.le.BluetoothLeAdvertiser r4 = r3.mAdvertiser     // Catch:{ all -> 0x0041 }
            android.bluetooth.le.AdvertiseCallback r0 = r3.getUupShareRspAdvCallback()     // Catch:{ all -> 0x0041 }
            r4.stopAdvertising(r0)     // Catch:{ all -> 0x0041 }
            goto L_0x007e
        L_0x0041:
            r4 = move-exception
            goto L_0x0080
        L_0x0043:
            android.bluetooth.le.BluetoothLeAdvertiser r4 = r3.mAdvertiser     // Catch:{ all -> 0x0041 }
            android.bluetooth.le.AdvertiseCallback r0 = r3.getUupShareAdvCallback()     // Catch:{ all -> 0x0041 }
            r4.stopAdvertising(r0)     // Catch:{ all -> 0x0041 }
            goto L_0x007e
        L_0x004d:
            android.bluetooth.le.BluetoothLeAdvertiser r4 = r3.mAdvertiser     // Catch:{ all -> 0x0041 }
            android.bluetooth.le.AdvertiseCallback r0 = r3.getNotifyAdvCallback()     // Catch:{ all -> 0x0041 }
            r4.stopAdvertising(r0)     // Catch:{ all -> 0x0041 }
            goto L_0x007e
        L_0x0057:
            android.bluetooth.le.BluetoothLeAdvertiser r4 = r3.mAdvertiser     // Catch:{ all -> 0x0041 }
            android.bluetooth.le.AdvertiseCallback r0 = r3.getReConnectAdvCallback()     // Catch:{ all -> 0x0041 }
            r4.stopAdvertising(r0)     // Catch:{ all -> 0x0041 }
            goto L_0x007e
        L_0x0061:
            android.bluetooth.le.BluetoothLeAdvertiser r4 = r3.mAdvertiser     // Catch:{ all -> 0x0041 }
            android.bluetooth.le.AdvertiseCallback r0 = r3.getConnectAdvCallback()     // Catch:{ all -> 0x0041 }
            r4.stopAdvertising(r0)     // Catch:{ all -> 0x0041 }
            goto L_0x007e
        L_0x006b:
            android.bluetooth.le.BluetoothLeAdvertiser r4 = r3.mAdvertiser     // Catch:{ all -> 0x0041 }
            android.bluetooth.le.AdvertiseCallback r0 = r3.getPassiveAdvCallback()     // Catch:{ all -> 0x0041 }
            r4.stopAdvertising(r0)     // Catch:{ all -> 0x0041 }
            goto L_0x007e
        L_0x0075:
            android.bluetooth.le.BluetoothLeAdvertiser r4 = r3.mAdvertiser     // Catch:{ all -> 0x0041 }
            android.bluetooth.le.AdvertiseCallback r0 = r3.getActiveAdvCallback()     // Catch:{ all -> 0x0041 }
            r4.stopAdvertising(r0)     // Catch:{ all -> 0x0041 }
        L_0x007e:
            monitor-exit(r3)
            return
        L_0x0080:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.discovery.advertiser.AdvertiserManager.stopAdv(int):void");
    }

    public void unRegisterAdvStartCallback() {
        this.mAdvStartCallback = null;
    }
}
