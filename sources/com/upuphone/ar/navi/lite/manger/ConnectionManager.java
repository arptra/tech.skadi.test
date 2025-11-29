package com.upuphone.ar.navi.lite.manger;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import androidx.annotation.RequiresApi;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.upuphone.ar.navi.lite.model.IConnection;
import com.upuphone.ar.navi.lite.model.IConnectionManager;
import com.upuphone.ar.navi.lite.navi.NaviControlManager;
import com.upuphone.ar.navi.lite.offlinemap.OfflineMapManager;
import com.upuphone.ar.navi.lite.util.CLog;
import com.upuphone.ar.navi.lite.util.NaviUtil;
import java.util.List;

public final class ConnectionManager {
    private static final String ACTION_DISCOVERY_DEVICE = "action_discovery_device";
    private static final String ASSISTANT_WAKEUP_STATUS = "com.ai.voice.assistant.WAKEUP_STATUS";
    private static final String DATA_DEVICE_ONLINE = "device_online";
    private static final String GPS_ACTION = "android.location.PROVIDERS_CHANGED";
    public static final boolean IS_CAR_NAVI = false;
    private static final String IS_WAKEUP = "isWakeup";
    /* access modifiers changed from: private */
    public static final String TAG = ("NAVI-" + ConnectionManager.class.getSimpleName());
    private static ConnectionManager instance = null;
    private AirPlaneMode airPlaneMode = null;
    /* access modifiers changed from: private */
    public boolean assistantWakeup = false;
    private AssistantWakeupReceiver assistantWakeupReceiver = null;
    private BleBroadcastReceiver bleBroadcastReceiver = null;
    private boolean callStateIdle = true;
    private Context context;
    private DeviceDisconnectBroadcast deviceDisconnectBroadcast = null;
    private GpsStatusReceiver gpsStatusReceiver = null;
    private boolean hasRegister = false;
    private NetConnectionReceiver netConnectivityReceiver = null;
    private CPhoneStateListener phoneStateListener = null;
    private CTelephonyCallback telephonyCallback = null;

    public class AirPlaneMode extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            String d = ConnectionManager.TAG;
            CLog.b(d, "AirplaneModeOn: getAction():" + intent.getAction() + " isAirModeOn=" + ConnectionManager.isAirModeOn(context) + " NaviOpened=" + NaviUtil.t0());
            if ("android.intent.action.AIRPLANE_MODE".equals(intent.getAction()) && !ConnectionManager.isAirModeOn(context) && NaviUtil.t0()) {
                NaviOperatorManager.getInstance(context.getApplicationContext()).startOnceLocation(context.getApplicationContext());
            }
        }

        private AirPlaneMode() {
        }
    }

    public class AssistantWakeupReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            String d = ConnectionManager.TAG;
            CLog.b(d, "AssistantWakeupStatusReceiver: intent.getAction():" + intent.getAction());
            if (ConnectionManager.ASSISTANT_WAKEUP_STATUS.equals(intent.getAction())) {
                ConnectionManager.this.assistantWakeup = intent.getBooleanExtra(ConnectionManager.IS_WAKEUP, false);
                String d2 = ConnectionManager.TAG;
                CLog.b(d2, "AssistantWakeupReceiver: isWakeup=" + ConnectionManager.this.assistantWakeup);
                List b = IConnectionManager.c().b();
                for (int i = 0; i < b.size(); i++) {
                    ((IConnection) b.get(i)).j(ConnectionManager.this.assistantWakeup);
                }
            }
        }

        private AssistantWakeupReceiver() {
        }
    }

    public class BleBroadcastReceiver extends BroadcastReceiver {
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x008e, code lost:
            if (r3 == 2) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0046, code lost:
            if (12 == r3) goto L_0x0092;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r4, android.content.Intent r5) {
            /*
                r3 = this;
                java.lang.String r3 = r5.getAction()
                java.lang.String r4 = com.upuphone.ar.navi.lite.manger.ConnectionManager.TAG
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "BluetoothStateReceiver: action is."
                r0.append(r1)
                r0.append(r3)
                java.lang.String r0 = r0.toString()
                com.upuphone.ar.navi.lite.util.CLog.b(r4, r0)
                java.lang.String r4 = "android.bluetooth.adapter.action.STATE_CHANGED"
                boolean r4 = r4.equals(r3)
                r0 = 1
                r1 = 0
                if (r4 == 0) goto L_0x0049
                java.lang.String r3 = "android.bluetooth.adapter.extra.STATE"
                int r3 = r5.getIntExtra(r3, r1)
                java.lang.String r4 = com.upuphone.ar.navi.lite.manger.ConnectionManager.TAG
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r2 = "BluetoothStateReceiver ACTION_STATE_CHANGED  blueState:"
                r5.append(r2)
                r5.append(r3)
                java.lang.String r5 = r5.toString()
                com.upuphone.ar.navi.lite.util.CLog.b(r4, r5)
                r4 = 12
                if (r4 != r3) goto L_0x0091
                goto L_0x0092
            L_0x0049:
                java.lang.String r4 = "android.bluetooth.device.action.ACL_DISCONNECTED"
                boolean r4 = r4.equals(r3)
                if (r4 == 0) goto L_0x005b
                java.lang.String r3 = com.upuphone.ar.navi.lite.manger.ConnectionManager.TAG
                java.lang.String r4 = "BluetoothStateReceiver ACTION_ACL_DISCONNECTED"
                com.upuphone.ar.navi.lite.util.CLog.b(r3, r4)
                goto L_0x0091
            L_0x005b:
                java.lang.String r4 = "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED"
                boolean r3 = r4.equals(r3)
                if (r3 == 0) goto L_0x0091
                java.lang.String r3 = "android.bluetooth.adapter.extra.CONNECTION_STATE"
                int r3 = r5.getIntExtra(r3, r1)
                java.lang.String r4 = com.upuphone.ar.navi.lite.manger.ConnectionManager.TAG
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r2 = "BluetoothStateReceiver ACTION_CONNECTION_STATE_CHANGED  state="
                r5.append(r2)
                r5.append(r3)
                java.lang.String r5 = r5.toString()
                com.upuphone.ar.navi.lite.util.CLog.b(r4, r5)
                if (r3 != 0) goto L_0x008d
                java.lang.String r3 = com.upuphone.ar.navi.lite.manger.ConnectionManager.TAG
                java.lang.String r4 = "BluetoothStateReceiver BluetoothAdapter.STATE_DISCONNECTED"
                com.upuphone.ar.navi.lite.util.CLog.b(r3, r4)
                goto L_0x0091
            L_0x008d:
                r4 = 2
                if (r3 != r4) goto L_0x0091
                goto L_0x0092
            L_0x0091:
                r0 = r1
            L_0x0092:
                com.upuphone.ar.navi.lite.model.IConnectionManager r3 = com.upuphone.ar.navi.lite.model.IConnectionManager.c()
                java.util.List r3 = r3.b()
                java.lang.String r4 = com.upuphone.ar.navi.lite.manger.ConnectionManager.TAG
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r2 = "BleBroadcastReceiver  bleConnected="
                r5.append(r2)
                r5.append(r0)
                java.lang.String r2 = " size()="
                r5.append(r2)
                int r2 = r3.size()
                r5.append(r2)
                java.lang.String r5 = r5.toString()
                com.upuphone.ar.navi.lite.util.CLog.b(r4, r5)
            L_0x00be:
                int r4 = r3.size()
                if (r1 >= r4) goto L_0x00d0
                java.lang.Object r4 = r3.get(r1)
                com.upuphone.ar.navi.lite.model.IConnection r4 = (com.upuphone.ar.navi.lite.model.IConnection) r4
                r4.k(r0)
                int r1 = r1 + 1
                goto L_0x00be
            L_0x00d0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.navi.lite.manger.ConnectionManager.BleBroadcastReceiver.onReceive(android.content.Context, android.content.Intent):void");
        }

        private BleBroadcastReceiver() {
        }
    }

    public class CPhoneStateListener extends PhoneStateListener {
        public CPhoneStateListener() {
        }

        public void onCallStateChanged(int i, String str) {
            super.onCallStateChanged(i, str);
            String d = ConnectionManager.TAG;
            CLog.d(d, "### CPhoneStateListener ### state=" + i);
            ConnectionManager.this.notifyCallStateChanged(i);
        }
    }

    @RequiresApi
    public class CTelephonyCallback extends TelephonyCallback implements TelephonyCallback.CallStateListener {
        public void onCallStateChanged(int i) {
            String d = ConnectionManager.TAG;
            CLog.d(d, "### CTelephonyCallback ### state=" + i);
            ConnectionManager.this.notifyCallStateChanged(i);
        }

        private CTelephonyCallback() {
        }
    }

    public class DeviceDisconnectBroadcast extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            if (ConnectionManager.ACTION_DISCOVERY_DEVICE.equals(intent.getAction())) {
                boolean booleanExtra = intent.getBooleanExtra(ConnectionManager.DATA_DEVICE_ONLINE, false);
                String d = ConnectionManager.TAG;
                CLog.b(d, "DeviceDisconnectBroadcast  isOnline=" + booleanExtra);
            }
        }

        private DeviceDisconnectBroadcast() {
        }
    }

    public class GpsStatusReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String d = ConnectionManager.TAG;
            CLog.b(d, "gpsStatusReceiver: action=" + action);
            List b = IConnectionManager.c().b();
            for (int i = 0; i < b.size(); i++) {
                ((IConnection) b.get(i)).w();
            }
        }

        private GpsStatusReceiver() {
        }
    }

    public class NetConnectionReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            boolean z;
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                OfflineMapManager.b().f(context);
                OfflineMapManager.b().e();
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    CLog.b(ConnectionManager.TAG, "NetConnectionReceiver @@@@@@ isAvailable=" + activeNetworkInfo.isAvailable() + " networkInfo.getTypeName()=" + activeNetworkInfo.getTypeName());
                    z = activeNetworkInfo.isAvailable();
                } else {
                    z = false;
                }
                Network[] allNetworks = connectivityManager.getAllNetworks();
                CLog.b(ConnectionManager.TAG, "NetConnectionReceiver &&&&&&&& networkList.length=" + allNetworks.length);
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo == null || !networkInfo.getTypeName().equals("WIFI") || allNetworks.length <= 1 || z) {
                    List b = IConnectionManager.c().b();
                    CLog.b(ConnectionManager.TAG, "NetConnectionReceiver  netAvailable=" + z + " connectionList.size()=" + b.size());
                    for (int i = 0; i < b.size(); i++) {
                        ((IConnection) b.get(i)).t(z);
                    }
                    return;
                }
                CLog.b(ConnectionManager.TAG, "NetConnectionReceiver ###### networkInfo next check");
            }
        }

        private NetConnectionReceiver() {
        }
    }

    private ConnectionManager(Context context2) {
        this.context = context2;
    }

    public static ConnectionManager getInstance(Context context2) {
        if (instance == null) {
            instance = new ConnectionManager(context2);
        }
        return instance;
    }

    public static boolean isAirModeOn(Context context2) {
        return Settings.System.getInt(context2.getContentResolver(), "airplane_mode_on", 0) == 1;
    }

    public static boolean isBleEnabled() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    public static boolean isNetAvailable(Context context2) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context2.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    /* access modifiers changed from: private */
    public void notifyCallStateChanged(int i) {
        boolean z = true;
        if (i == 1 || i == 2) {
            z = false;
        }
        setCallStateIdle(z);
        if (z) {
            NaviControlManager.k().O();
        } else {
            NaviControlManager.k().Q();
        }
    }

    private void registerAirPlaneModer() {
        this.airPlaneMode = new AirPlaneMode();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        this.context.registerReceiver(this.airPlaneMode, intentFilter, 4);
    }

    private void registerAssistantWakeupreceiver() {
        this.assistantWakeupReceiver = new AssistantWakeupReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ASSISTANT_WAKEUP_STATUS);
        LocalBroadcastManager.b(this.context).c(this.assistantWakeupReceiver, intentFilter);
    }

    private void registerBleReceiver() {
        this.bleBroadcastReceiver = new BleBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        this.context.registerReceiver(this.bleBroadcastReceiver, intentFilter, 4);
    }

    private void registerConnectionReceiver() {
        this.netConnectivityReceiver = new NetConnectionReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.ethernet.ETHERNET_STATE_CHANGED");
        intentFilter.addAction("android.net.ethernet.STATE_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        this.context.registerReceiver(this.netConnectivityReceiver, intentFilter, 4);
    }

    private void registerDeviceDisconnectBroadcast() {
        this.deviceDisconnectBroadcast = new DeviceDisconnectBroadcast();
        this.context.registerReceiver(this.deviceDisconnectBroadcast, new IntentFilter(ACTION_DISCOVERY_DEVICE), 4);
    }

    private void registerGpsStatusReceiver() {
        this.gpsStatusReceiver = new GpsStatusReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(GPS_ACTION);
        this.context.registerReceiver(this.gpsStatusReceiver, intentFilter, 4);
    }

    private void registerPhoneStateListener() {
        if (NaviUtil.s0()) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
                if (Build.VERSION.SDK_INT >= 31) {
                    this.telephonyCallback = new CTelephonyCallback();
                    telephonyManager.registerTelephonyCallback(this.context.getMainExecutor(), this.telephonyCallback);
                    return;
                }
                CPhoneStateListener cPhoneStateListener = new CPhoneStateListener();
                this.phoneStateListener = cPhoneStateListener;
                telephonyManager.listen(cPhoneStateListener, 32);
            } catch (Exception e) {
                String str = TAG;
                CLog.d(str, "### registerPhoneStateListener ### excep=" + e);
            }
        }
    }

    private void unregisterAirPlaneMode() {
        AirPlaneMode airPlaneMode2 = this.airPlaneMode;
        if (airPlaneMode2 != null) {
            this.context.unregisterReceiver(airPlaneMode2);
            this.airPlaneMode = null;
        }
    }

    private void unregisterAssistantWakeupreceiver() {
        if (this.assistantWakeupReceiver != null) {
            LocalBroadcastManager.b(this.context).e(this.assistantWakeupReceiver);
            this.assistantWakeupReceiver = null;
        }
        this.assistantWakeup = false;
    }

    private void unregisterBleReceiver() {
        BleBroadcastReceiver bleBroadcastReceiver2 = this.bleBroadcastReceiver;
        if (bleBroadcastReceiver2 != null) {
            this.context.unregisterReceiver(bleBroadcastReceiver2);
            this.bleBroadcastReceiver = null;
        }
    }

    private void unregisterConnectionReceiver() {
        NetConnectionReceiver netConnectionReceiver = this.netConnectivityReceiver;
        if (netConnectionReceiver != null) {
            this.context.unregisterReceiver(netConnectionReceiver);
            this.netConnectivityReceiver = null;
        }
    }

    private void unregisterDeviceDisconnectBroadcast() {
        DeviceDisconnectBroadcast deviceDisconnectBroadcast2 = this.deviceDisconnectBroadcast;
        if (deviceDisconnectBroadcast2 != null) {
            this.context.unregisterReceiver(deviceDisconnectBroadcast2);
            this.deviceDisconnectBroadcast = null;
        }
    }

    private void unregisterGpsStatusReceiver() {
        GpsStatusReceiver gpsStatusReceiver2 = this.gpsStatusReceiver;
        if (gpsStatusReceiver2 != null) {
            this.context.unregisterReceiver(gpsStatusReceiver2);
            this.gpsStatusReceiver = null;
        }
    }

    private void unregisterPhoneStateListener() {
        if (NaviUtil.s0()) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
                if (Build.VERSION.SDK_INT >= 31) {
                    CTelephonyCallback cTelephonyCallback = this.telephonyCallback;
                    if (cTelephonyCallback != null) {
                        telephonyManager.unregisterTelephonyCallback(cTelephonyCallback);
                        this.telephonyCallback = null;
                    }
                } else if (this.telephonyCallback != null) {
                    telephonyManager.listen((PhoneStateListener) null, 32);
                    this.phoneStateListener = null;
                }
            } catch (Exception e) {
                String str = TAG;
                CLog.d(str, "### unregisterPhoneStateListener ### excep=" + e);
            }
        }
    }

    public boolean isAssistantWakeup() {
        return this.assistantWakeup;
    }

    public boolean isCallStateIdle() {
        return this.callStateIdle;
    }

    public void registerConnectivityReceiver() {
        CLog.b(TAG, "registerConnectivityReceiver  ");
        if (!this.hasRegister) {
            registerDeviceDisconnectBroadcast();
            registerConnectionReceiver();
            registerBleReceiver();
            registerGpsStatusReceiver();
            registerAssistantWakeupreceiver();
            registerAirPlaneModer();
            registerPhoneStateListener();
            this.hasRegister = true;
        }
    }

    public void setAssistantWakeup(boolean z) {
        this.assistantWakeup = z;
    }

    public void setCallStateIdle(boolean z) {
        this.callStateIdle = z;
    }

    public void unregisterConnectivityReceiver() {
        CLog.b(TAG, "unregisterConnectivityReceiver  ");
        unregisterDeviceDisconnectBroadcast();
        unregisterConnectionReceiver();
        unregisterBleReceiver();
        unregisterGpsStatusReceiver();
        unregisterAssistantWakeupreceiver();
        unregisterAirPlaneMode();
        unregisterPhoneStateListener();
        this.hasRegister = false;
    }
}
