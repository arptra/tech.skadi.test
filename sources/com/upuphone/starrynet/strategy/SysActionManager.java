package com.upuphone.starrynet.strategy;

import android.app.KeyguardManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.UserHandle;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.core.ble.SystemActionObserver;
import com.upuphone.starrynet.core.ble.utils.BluetoothUtils;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SysActionManager {
    public static final String ACTION_USER_SWITCHED = "android.intent.action.USER_SWITCHED";
    public static final String EXTRA_USER_HANDLE = "android.intent.extra.user_handle";
    private static final int MSG_BLUETOOTH_STATE_CHANGE = 2;
    private static final int MSG_LOCATION_CHANGE = 3;
    private static final int MSG_UUP_SHARE_STATE_CHANGE = 4;
    private static final int MSG_WIFI_STATE_CHANGE = 1;
    private static final String TAG = "SysActionManager";
    public static final int USER_NULL = -10000;
    private static final String UUP_SHARE_STATE_URI_NAME = "uup_share_state";
    /* access modifiers changed from: private */
    public volatile boolean isLocationOn;
    /* access modifiers changed from: private */
    public volatile boolean isP2pEnable;
    /* access modifiers changed from: private */
    public volatile boolean isUserIdMisMatching;
    private volatile boolean isWiFiOn;
    private BluetoothAdapter mAdapter;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public final int mCurrentUserId;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public LocationManager mLocationManager;
    /* access modifiers changed from: private */
    public final Uri mLocationUri;
    /* access modifiers changed from: private */
    public final List<StateChangeCallback> mStateChangeCallback;
    /* access modifiers changed from: private */
    public int mUupShareState;
    /* access modifiers changed from: private */
    public final Uri mUupShareStateUri;
    private WifiManager mWifiManager;

    public static class Holder {
        /* access modifiers changed from: private */
        public static final SysActionManager INSTANCE = new SysActionManager();

        private Holder() {
        }
    }

    public class NotifyHandle extends Handler {
        public NotifyHandle(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            int i = message.what;
            boolean z = true;
            if (i == 1) {
                SysActionManager.this.notifyWiFiStateChange(message.arg1);
            } else if (i == 2) {
                SysActionManager.this.notifyBluetoothStateChange(((Boolean) message.obj).booleanValue());
            } else if (i == 3) {
                SysActionManager sysActionManager = SysActionManager.this;
                if (message.arg1 != 1) {
                    z = false;
                }
                sysActionManager.notifyLocationStateChange(z);
            } else if (i == 4) {
                SysActionManager sysActionManager2 = SysActionManager.this;
                if (message.arg1 != 1) {
                    z = false;
                }
                sysActionManager2.notifyUupShareStateChange(z);
            }
        }
    }

    public interface StateChangeCallback {
        void onBluetoothDisabled();

        void onBluetoothEnabled();

        void onBluetoothNameChange(String str);

        void onLocationDisabled();

        void onLocationEnabled();

        void onP2pDisable();

        void onP2pEnable();

        void onScreenOff();

        void onScreenOn();

        void onUupShareDisabled();

        void onUupShareEnabled();

        void onWiFiDisabled();

        void onWiFiEnabled();
    }

    public static class StateChangeSimpleCallback implements StateChangeCallback {
        public void onBluetoothDisabled() {
            StLog.v(SysActionManager.TAG, "onBluetoothDisabled");
        }

        public void onBluetoothEnabled() {
            StLog.v(SysActionManager.TAG, "onBluetoothEnabled");
        }

        public void onBluetoothNameChange(String str) {
            StLog.v(SysActionManager.TAG, "onBluetoothNameChange");
        }

        public void onLocationDisabled() {
            StLog.v(SysActionManager.TAG, "onLocationDisabled");
        }

        public void onLocationEnabled() {
            StLog.v(SysActionManager.TAG, "onLocationEnabled");
        }

        public void onP2pDisable() {
            StLog.v(SysActionManager.TAG, "onP2pDisable");
        }

        public void onP2pEnable() {
            StLog.v(SysActionManager.TAG, "onP2pEnable");
        }

        public void onScreenOff() {
            StLog.v(SysActionManager.TAG, "onScreenOff");
        }

        public void onScreenOn() {
            StLog.v(SysActionManager.TAG, "onScreenOn");
        }

        public void onUupShareDisabled() {
            StLog.v(SysActionManager.TAG, "onUupShareDisabled");
        }

        public void onUupShareEnabled() {
            StLog.v(SysActionManager.TAG, "onUupShareEnabled");
        }

        public void onWiFiDisabled() {
            StLog.v(SysActionManager.TAG, "onWiFiDisabled");
        }

        public void onWiFiEnabled() {
            StLog.v(SysActionManager.TAG, "onWiFiEnabled");
        }
    }

    public class SysActionReceiver extends BroadcastReceiver {
        private SysActionReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            StLog.d(SysActionManager.TAG, "onReceive : " + action);
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                SysActionManager.this.onWifiStateChange(intent);
            } else if ("android.bluetooth.adapter.action.LOCAL_NAME_CHANGED".equals(action)) {
                String stringExtra = intent.getStringExtra("android.bluetooth.adapter.extra.LOCAL_NAME");
                StarryNetData.getInstance().getOwnDevice().setDeviceName(stringExtra);
                if (stringExtra == null) {
                    StLog.w(SysActionManager.TAG, "local name is null");
                    return;
                }
                for (StateChangeCallback onBluetoothNameChange : SysActionManager.this.mStateChangeCallback) {
                    onBluetoothNameChange.onBluetoothNameChange(stringExtra);
                }
            } else {
                boolean z = true;
                if (SysActionManager.ACTION_USER_SWITCHED.equals(action)) {
                    int intExtra = intent.getIntExtra(SysActionManager.EXTRA_USER_HANDLE, SysActionManager.USER_NULL);
                    if (intExtra == -10000) {
                        StLog.e(SysActionManager.TAG, "received an invalid EXTRA_USER_HANDLE");
                        return;
                    }
                    StLog.d(SysActionManager.TAG, "app launch user id " + SysActionManager.this.mCurrentUserId + " system current user id " + intExtra);
                    SysActionManager sysActionManager = SysActionManager.this;
                    if (intExtra == sysActionManager.mCurrentUserId) {
                        z = false;
                    }
                    boolean unused = sysActionManager.isUserIdMisMatching = z;
                } else if ("android.net.wifi.p2p.STATE_CHANGED".equals(action)) {
                    int intExtra2 = intent.getIntExtra("wifi_p2p_state", 0);
                    SysActionManager sysActionManager2 = SysActionManager.this;
                    if (intExtra2 != 2) {
                        z = false;
                    }
                    boolean unused2 = sysActionManager2.isP2pEnable = z;
                    StLog.d(SysActionManager.TAG, "isP2pEnable=" + SysActionManager.this.isP2pEnable);
                    for (StateChangeCallback stateChangeCallback : SysActionManager.this.mStateChangeCallback) {
                        if (SysActionManager.this.isP2pEnable) {
                            stateChangeCallback.onP2pEnable();
                        } else {
                            stateChangeCallback.onP2pDisable();
                        }
                    }
                }
            }
        }
    }

    private void checkAndUpdateUupShareState() {
        if (!isUupShareOn() && this.mUupShareState == 1) {
            Settings.Global.putInt(this.mContext.getContentResolver(), UUP_SHARE_STATE_URI_NAME, 0);
        }
    }

    /* access modifiers changed from: private */
    public void disableUupShare() {
        if (this.mUupShareState == 1) {
            this.mUupShareState = 0;
            Settings.Global.putInt(this.mContext.getContentResolver(), UUP_SHARE_STATE_URI_NAME, 0);
            Message.obtain(this.mHandler, 4).sendToTarget();
        }
    }

    private void enableLocation() {
        StLog.d(TAG, "enableLocation");
        if (this.mLocationManager == null) {
            this.mLocationManager = (LocationManager) this.mContext.getSystemService("location");
        }
        if (this.mLocationManager != null) {
            setLocationEnabledForUser(true);
        } else {
            StLog.d(TAG, "Location state error");
        }
    }

    public static SysActionManager getInstance() {
        return Holder.INSTANCE;
    }

    private int getUupShareState() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), UUP_SHARE_STATE_URI_NAME, 0);
    }

    /* access modifiers changed from: private */
    public void notifyBluetoothStateChange(boolean z) {
        if (z) {
            for (StateChangeCallback onBluetoothEnabled : this.mStateChangeCallback) {
                onBluetoothEnabled.onBluetoothEnabled();
            }
            return;
        }
        for (StateChangeCallback onBluetoothDisabled : this.mStateChangeCallback) {
            onBluetoothDisabled.onBluetoothDisabled();
        }
    }

    /* access modifiers changed from: private */
    public void notifyLocationStateChange(boolean z) {
        if (z) {
            for (StateChangeCallback onLocationEnabled : this.mStateChangeCallback) {
                onLocationEnabled.onLocationEnabled();
            }
            return;
        }
        for (StateChangeCallback onLocationDisabled : this.mStateChangeCallback) {
            onLocationDisabled.onLocationDisabled();
        }
    }

    /* access modifiers changed from: private */
    public void notifyUupShareStateChange(boolean z) {
        if (z) {
            for (StateChangeCallback onUupShareEnabled : this.mStateChangeCallback) {
                onUupShareEnabled.onUupShareEnabled();
            }
            return;
        }
        for (StateChangeCallback onUupShareDisabled : this.mStateChangeCallback) {
            onUupShareDisabled.onUupShareDisabled();
        }
    }

    /* access modifiers changed from: private */
    public void notifyWiFiStateChange(int i) {
        if (i == 1) {
            for (StateChangeCallback onWiFiDisabled : this.mStateChangeCallback) {
                onWiFiDisabled.onWiFiDisabled();
            }
        } else if (i == 3) {
            for (StateChangeCallback onWiFiEnabled : this.mStateChangeCallback) {
                onWiFiEnabled.onWiFiEnabled();
            }
        } else if (i == 4) {
            for (StateChangeCallback onWiFiDisabled2 : this.mStateChangeCallback) {
                onWiFiDisabled2.onWiFiDisabled();
            }
        }
    }

    /* access modifiers changed from: private */
    public void onBtStateChange(boolean z) {
        StLog.d(TAG, "BT state change ,itBtOn =" + z);
        if (z) {
            StLog.d(TAG, "Bluetooth enabled");
            if (this.isUserIdMisMatching) {
                StLog.e(TAG, "user id mismatching");
                return;
            }
            if (isUupShareOn()) {
                Message.obtain(this.mHandler, 4, 1, 0).sendToTarget();
            }
            this.mHandler.obtainMessage(2, Boolean.TRUE).sendToTarget();
            return;
        }
        StLog.d(TAG, "Bluetooth disabled");
        disableUupShare();
        this.mHandler.obtainMessage(2, Boolean.FALSE).sendToTarget();
    }

    /* access modifiers changed from: private */
    public void onUupStateStateChange(int i) {
        this.mUupShareState = i;
        if (i == 1) {
            StLog.d(TAG, "UupShareState ON ");
            if (!isBtOn()) {
                SystemActionObserver.getInstance().enableBluetooth();
            }
            if (!this.isWiFiOn) {
                enableWiFi();
            }
            if (!this.isLocationOn) {
                enableLocation();
            }
            if (isUupShareOn()) {
                Message.obtain(this.mHandler, 4, 1, 0).sendToTarget();
                return;
            }
            return;
        }
        StLog.d(TAG, "UupShareState OFF ");
        Message.obtain(this.mHandler, 4).sendToTarget();
    }

    /* access modifiers changed from: private */
    public void onWifiStateChange(Intent intent) {
        int intExtra = intent.getIntExtra("wifi_state", 0);
        StLog.d(TAG, "Wifi state change : " + intExtra);
        if (intExtra == 3) {
            this.isWiFiOn = true;
            StLog.d(TAG, "Wifi enabled");
            if (isUupShareOn()) {
                Message.obtain(this.mHandler, 4, 1, 0).sendToTarget();
            }
            Message.obtain(this.mHandler, 1, intExtra, 0).sendToTarget();
        } else if (intExtra == 1 || intExtra == 4) {
            this.isWiFiOn = false;
            StLog.d(TAG, "Wifi disabled");
            disableUupShare();
            Message.obtain(this.mHandler, 1, intExtra, 0).sendToTarget();
        }
    }

    public void enableWiFi() {
        StLog.d(TAG, "enableWiFi");
        if (this.mWifiManager == null) {
            this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        }
        WifiManager wifiManager = this.mWifiManager;
        if (wifiManager != null) {
            wifiManager.setWifiEnabled(true);
        } else {
            StLog.d(TAG, "Wifi state error");
        }
    }

    public void init(Context context) {
        StLog.d(TAG, "Init");
        this.mContext = context;
        this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        this.mLocationManager = (LocationManager) this.mContext.getSystemService("location");
        StateObserver stateObserver = new StateObserver(new Handler());
        this.mContext.getContentResolver().registerContentObserver(this.mLocationUri, false, stateObserver);
        this.mContext.getContentResolver().registerContentObserver(this.mUupShareStateUri, false, stateObserver);
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        this.mHandler = new NotifyHandle(handlerThread.getLooper());
        SysActionReceiver sysActionReceiver = new SysActionReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.LOCAL_NAME_CHANGED");
        intentFilter.addAction(ACTION_USER_SWITCHED);
        intentFilter.addAction("android.net.wifi.p2p.STATE_CHANGED");
        SystemActionObserver.getInstance().registerSystemActionCallback(new SystemActionObserver.SystemActionChangedCallback() {
            public boolean onBluetoothStateChange(boolean z) {
                SysActionManager.this.onBtStateChange(z);
                return true;
            }

            public boolean onScreenStateChange(boolean z) {
                for (StateChangeCallback stateChangeCallback : SysActionManager.this.mStateChangeCallback) {
                    if (z) {
                        stateChangeCallback.onScreenOn();
                    } else {
                        stateChangeCallback.onScreenOff();
                    }
                }
                return true;
            }
        });
        BluetoothUtils.registerReceiverCompatApi34(context, sysActionReceiver, intentFilter);
        this.mUupShareState = getUupShareState();
        WifiManager wifiManager = this.mWifiManager;
        if (wifiManager != null) {
            this.isWiFiOn = wifiManager.isWifiEnabled();
            this.isP2pEnable = this.isWiFiOn;
        }
        LocationManager locationManager = this.mLocationManager;
        if (locationManager != null) {
            this.isLocationOn = locationManager.isLocationEnabled();
        }
        StLog.d(TAG, "Device current state Bluetooth : " + isBtOn() + " WiFi : " + this.isWiFiOn + " Location : " + this.isLocationOn + " UupShare : " + this.mUupShareState);
    }

    public boolean isBtOn() {
        return SystemActionObserver.getInstance().isBtOn();
    }

    public boolean isP2pEnable() {
        return this.isP2pEnable;
    }

    public boolean isScreenLocked() {
        if (!isScreenOn()) {
            return true;
        }
        return ((KeyguardManager) this.mContext.getSystemService("keyguard")).isKeyguardLocked();
    }

    public boolean isScreenOn() {
        return SystemActionObserver.getInstance().isScreenOn();
    }

    public boolean isUupShareOn() {
        return isBtOn() && this.isWiFiOn && this.isLocationOn && this.mUupShareState == 1;
    }

    public boolean isWlanOn() {
        return this.isWiFiOn || this.mWifiManager.isWifiEnabled();
    }

    public void registerSysAction(StateChangeCallback stateChangeCallback) {
        if (stateChangeCallback != null && !this.mStateChangeCallback.contains(stateChangeCallback)) {
            this.mStateChangeCallback.add(stateChangeCallback);
        }
    }

    public void setLocationEnabledForUser(boolean z) {
        Class<UserHandle> cls = UserHandle.class;
        try {
            Field declaredField = cls.getDeclaredField("SYSTEM");
            declaredField.setAccessible(true);
            LocationManager.class.getDeclaredMethod("setLocationEnabledForUser", new Class[]{Boolean.TYPE, cls}).invoke(this.mLocationManager, new Object[]{Boolean.valueOf(z), (UserHandle) declaredField.get(cls)});
        } catch (Exception unused) {
            StLog.e(TAG, "can not setLocationEnabledForUser:(" + z + ")");
        }
    }

    public void unRegisterSysAction(StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallback.remove(stateChangeCallback);
    }

    public class StateObserver extends ContentObserver {
        public StateObserver(Handler handler) {
            super(handler);
        }

        public boolean deliverSelfNotifications() {
            StLog.d(SysActionManager.TAG, "deliverSelfNotifications");
            return super.deliverSelfNotifications();
        }

        public void onChange(boolean z) {
            StLog.d(SysActionManager.TAG, "onChange 1 selfChange : " + z);
            super.onChange(z);
        }

        public void onChange(boolean z, @Nullable Uri uri) {
            StLog.d(SysActionManager.TAG, "onChange 2 selfChange : %s uri :  ", Boolean.valueOf(z), uri);
            if (!z && SysActionManager.this.mUupShareStateUri.equals(uri)) {
                int i = Settings.Global.getInt(SysActionManager.this.mContext.getContentResolver(), SysActionManager.UUP_SHARE_STATE_URI_NAME, 0);
                StLog.d(SysActionManager.TAG, "UupShareState Change  : " + i);
                if (i != SysActionManager.this.mUupShareState) {
                    SysActionManager.this.onUupStateStateChange(i);
                }
            } else if (!z && SysActionManager.this.mLocationUri.equals(uri)) {
                if (SysActionManager.this.mLocationManager == null) {
                    SysActionManager sysActionManager = SysActionManager.this;
                    LocationManager unused = sysActionManager.mLocationManager = (LocationManager) sysActionManager.mContext.getSystemService("location");
                }
                if (SysActionManager.this.mLocationManager != null) {
                    SysActionManager sysActionManager2 = SysActionManager.this;
                    boolean unused2 = sysActionManager2.isLocationOn = sysActionManager2.mLocationManager.isLocationEnabled();
                }
                if (!SysActionManager.this.isLocationOn) {
                    StLog.d(SysActionManager.TAG, "Location disabled");
                    SysActionManager.this.disableUupShare();
                    Message.obtain(SysActionManager.this.mHandler, 3).sendToTarget();
                } else {
                    StLog.d(SysActionManager.TAG, "Location enabled");
                    Message.obtain(SysActionManager.this.mHandler, 3, 1, 0).sendToTarget();
                }
                if (SysActionManager.this.isUupShareOn()) {
                    Message.obtain(SysActionManager.this.mHandler, 4, 1, 0).sendToTarget();
                }
            }
            super.onChange(z, uri);
        }

        public void onChange(boolean z, @Nullable Uri uri, int i) {
            StLog.d(SysActionManager.TAG, "onChange 3 selfChange : %s uri : %s flags : %s", Boolean.valueOf(z), uri, Integer.valueOf(i));
            super.onChange(z, uri, i);
        }

        public void onChange(boolean z, @NonNull Collection<Uri> collection, int i) {
            StLog.d(SysActionManager.TAG, "onChange 4 selfChange : %s uri : %s flags : %s", Boolean.valueOf(z), collection, Integer.valueOf(i));
            super.onChange(z, collection, i);
        }
    }

    private SysActionManager() {
        this.mUupShareStateUri = Settings.Global.getUriFor(UUP_SHARE_STATE_URI_NAME);
        this.mLocationUri = Settings.Secure.getUriFor("location_providers_allowed");
        this.mStateChangeCallback = new CopyOnWriteArrayList();
        this.mUupShareState = 0;
        this.isWiFiOn = false;
        this.isLocationOn = false;
        this.isUserIdMisMatching = false;
        this.isP2pEnable = true;
        this.mCurrentUserId = Process.myUid() / 100000;
    }
}
