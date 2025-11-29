package com.upuphone.starrynet.common.utils.tracker;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.OSUtils;
import com.upuphone.starrynet.common.utils.tracker.detail.BluetoothConnectionTracker;
import com.upuphone.starrynet.common.utils.tracker.detail.BluetoothDisconnectTracker;
import com.upuphone.starrynet.common.utils.tracker.detail.BluetoothSwtchStateTracker;
import com.upuphone.starrynet.common.utils.tracker.detail.MyvuRing2BleTracker;
import com.upuphone.starrynet.common.utils.tracker.detail.P2PConnectionTracker;
import com.upuphone.starrynet.common.utils.tracker.detail.UnpairDeviceTracker;
import com.upuphone.starrynet.tracker.StTracker;
import com.upuphone.starrynet.tracker.TrackerConfig;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class TrackerManager implements ReportTracker {
    private static final String TAG = "TrackerManager";
    private BluetoothDisconnectTracker bluetoothDisconnectTracker;
    private BluetoothConnectionTracker connectionTracker;
    private boolean isInit;
    private MyvuRing2BleTracker myvuRingBleTracker;
    private String ownDeviceID;
    private int ownTerminalType;
    private P2PConnectionTracker p2PConnectionTracker;
    private String romVersion;
    private BluetoothSwtchStateTracker switchStateTracker;
    private UnpairDeviceTracker unpairDeviceTracker;
    private String versionName;

    public static final class Holder {
        static final TrackerManager INSTANCE = new TrackerManager();

        private Holder() {
        }
    }

    private static String formatJson(String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder(str);
        if (str == null || str.equals("")) {
            return null;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (charAt == '{' || charAt == '[') {
                i = i4 + 4;
                sb.insert(i5 + i3 + 1, StringUtils.LF + generateBlank(i));
                i2 = i4 + 5;
            } else {
                if (charAt == ',') {
                    sb.insert(i5 + i3 + 1, StringUtils.LF + generateBlank(i4));
                    i3 += i4 + 1;
                } else if (charAt == '}' || charAt == ']') {
                    i = i4 - 4;
                    sb.insert(i5 + i3, StringUtils.LF + generateBlank(i));
                    i2 = i4 + -3;
                }
            }
            i3 += i2;
            i4 = i;
        }
        return sb.toString();
    }

    private static String generateBlank(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static TrackerManager getInstance() {
        return Holder.INSTANCE;
    }

    public BluetoothConnectionTracker getBluetoothConnectionTracker() {
        if (this.connectionTracker == null) {
            BluetoothConnectionTracker bluetoothConnectionTracker = new BluetoothConnectionTracker(this, this.ownTerminalType, this.ownDeviceID);
            this.connectionTracker = bluetoothConnectionTracker;
            bluetoothConnectionTracker.setStarryNetVersion(this.versionName);
            this.connectionTracker.romVersion(this.romVersion);
        }
        return this.connectionTracker;
    }

    public BluetoothDisconnectTracker getBluetoothDisconnectTracker() {
        if (this.bluetoothDisconnectTracker == null) {
            BluetoothDisconnectTracker bluetoothDisconnectTracker2 = new BluetoothDisconnectTracker(this, this.ownTerminalType, this.ownDeviceID);
            this.bluetoothDisconnectTracker = bluetoothDisconnectTracker2;
            bluetoothDisconnectTracker2.setStarryNetVersion(this.versionName);
            this.bluetoothDisconnectTracker.romVersion(this.romVersion);
        }
        return this.bluetoothDisconnectTracker;
    }

    public BluetoothSwtchStateTracker getDeviceSwitchStateTracker() {
        if (this.switchStateTracker == null) {
            BluetoothSwtchStateTracker bluetoothSwtchStateTracker = new BluetoothSwtchStateTracker(this, this.ownTerminalType, this.ownDeviceID);
            this.switchStateTracker = bluetoothSwtchStateTracker;
            bluetoothSwtchStateTracker.setStarryNetVersion(this.versionName);
            this.switchStateTracker.romVersion(this.romVersion);
        }
        return this.switchStateTracker;
    }

    public MyvuRing2BleTracker getMyvuRingBleTracker() {
        if (this.myvuRingBleTracker == null) {
            MyvuRing2BleTracker myvuRing2BleTracker = new MyvuRing2BleTracker(this, this.ownTerminalType, this.ownDeviceID);
            this.myvuRingBleTracker = myvuRing2BleTracker;
            myvuRing2BleTracker.setStarryNetVersion(this.versionName);
            this.myvuRingBleTracker.romVersion(this.romVersion);
        }
        return this.myvuRingBleTracker;
    }

    public P2PConnectionTracker getP2PConnectionTracker() {
        if (this.p2PConnectionTracker == null) {
            this.p2PConnectionTracker = new P2PConnectionTracker(this, this.ownTerminalType, this.ownDeviceID);
        }
        return this.p2PConnectionTracker;
    }

    public UnpairDeviceTracker getUnpairDeviceTracker() {
        if (this.unpairDeviceTracker == null) {
            UnpairDeviceTracker unpairDeviceTracker2 = new UnpairDeviceTracker(this, this.ownTerminalType, this.ownDeviceID);
            this.unpairDeviceTracker = unpairDeviceTracker2;
            unpairDeviceTracker2.setStarryNetVersion(this.versionName);
            this.unpairDeviceTracker.romVersion(this.romVersion);
        }
        return this.unpairDeviceTracker;
    }

    public void init(Context context, int i, String str) {
        this.ownTerminalType = i;
        this.ownDeviceID = str;
        if (context != null) {
            try {
                this.versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (i != 1 && i != 4) {
            StLog.w(TAG, "not support terminal type=%d init StTracker!", Integer.valueOf(i));
        } else if (!this.isInit) {
            TrackerConfig trackerConfig = new TrackerConfig();
            trackerConfig.setOwnDeviceId(str).setDebug(false);
            this.isInit = StTracker.getInstance().init(context, i, trackerConfig);
        }
    }

    public void report3rdEvent(String str, int i, Map<String, Object> map, String str2, String str3, String str4) {
        if (!this.isInit) {
            StLog.w(TAG, "StTracker not init, cannot report tracker!");
            return;
        }
        StLog.d(TAG, "report3rdEvent, eventName =" + str + ",peer terminal type =" + i);
        try {
            StTracker.getInstance().report3rdEvent(str, map, str2, str3, str4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reportMap(String str, int i, Map<String, Object> map) {
        if (!this.isInit) {
            StLog.w(TAG, "StTracker not init, cannot report tracker!");
            return;
        }
        StLog.d(TAG, "reportMap, eventName =" + str + ",peer terminal type =" + i);
        StTracker.getInstance().reportEvent(str, map);
    }

    private TrackerManager() {
        this.versionName = "none";
        this.connectionTracker = null;
        this.myvuRingBleTracker = null;
        this.unpairDeviceTracker = null;
        this.switchStateTracker = null;
        this.p2PConnectionTracker = null;
        this.bluetoothDisconnectTracker = null;
        this.isInit = false;
        String str = Build.BRAND;
        String customOS = OSUtils.getCustomOS(str);
        String customOSVersion = OSUtils.getCustomOSVersion(str);
        this.romVersion = customOS + " " + customOSVersion;
    }
}
