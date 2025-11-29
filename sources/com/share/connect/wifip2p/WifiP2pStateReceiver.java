package com.share.connect.wifip2p;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import com.easy.logger.EasyLog;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

class WifiP2pStateReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9959a = false;
    public OnPeersChangedListener b;
    public OnConnectionChangedListener c;
    public OnThisDeviceChangedListener d;

    public interface OnConnectionChangedListener {
        void a(WifiP2pInfo wifiP2pInfo, WifiP2pGroup wifiP2pGroup, NetworkInfo networkInfo);
    }

    public interface OnPeersChangedListener {
        void a(WifiP2pDeviceList wifiP2pDeviceList);
    }

    public interface OnThisDeviceChangedListener {
        void a(WifiP2pDevice wifiP2pDevice);
    }

    public final IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.p2p.STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.p2p.PEERS_CHANGED");
        intentFilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.p2p.THIS_DEVICE_CHANGED");
        return intentFilter;
    }

    public final String b(Collection collection) {
        StringBuilder sb = new StringBuilder();
        if (collection != null && !collection.isEmpty()) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) it.next();
                sb.append(wifiP2pDevice.deviceName);
                sb.append(", ");
                sb.append(wifiP2pDevice.deviceAddress);
                sb.append(", ");
                sb.append(wifiP2pDevice.status);
                sb.append(StringUtils.LF);
            }
        }
        return sb.toString();
    }

    public synchronized void c(Context context, boolean z) {
        if (z) {
            if (this.f9959a) {
                try {
                    context.getApplicationContext().unregisterReceiver(this);
                } catch (IllegalArgumentException e) {
                    EasyLog.c("WifiP2pStateReceiver", e.toString());
                }
            }
            context.getApplicationContext().registerReceiver(this, a());
        } else {
            try {
                context.getApplicationContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                EasyLog.c("WifiP2pStateReceiver", e2.toString());
            }
        }
        this.f9959a = z;
    }

    public void d(OnConnectionChangedListener onConnectionChangedListener) {
        this.c = onConnectionChangedListener;
    }

    public void e(OnPeersChangedListener onPeersChangedListener) {
        this.b = onPeersChangedListener;
    }

    public void f(OnThisDeviceChangedListener onThisDeviceChangedListener) {
        this.d = onThisDeviceChangedListener;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        EasyLog.e("WifiP2pStateReceiver", "WifiP2pStateReceiver: action:" + action + ", isInitialStickyBroadcast=" + isInitialStickyBroadcast());
        if ("android.net.wifi.p2p.STATE_CHANGED".equals(action)) {
            EasyLog.e("WifiP2pStateReceiver", "onReceive: STATE_CHANGED " + intent.getIntExtra("wifi_p2p_state", -1));
        } else if ("android.net.wifi.p2p.PEERS_CHANGED".equals(action)) {
            WifiP2pDeviceList wifiP2pDeviceList = (WifiP2pDeviceList) intent.getParcelableExtra("wifiP2pDeviceList");
            if (wifiP2pDeviceList != null) {
                StringBuilder sb = new StringBuilder("Peers changed: ");
                for (WifiP2pDevice next : wifiP2pDeviceList.getDeviceList()) {
                    sb.append(StringUtils.LF);
                    sb.append(next.deviceAddress);
                    sb.append(" ");
                    sb.append(next.deviceName);
                }
                EasyLog.e("WifiP2pStateReceiver", sb.toString());
                OnPeersChangedListener onPeersChangedListener = this.b;
                if (onPeersChangedListener != null) {
                    onPeersChangedListener.a(wifiP2pDeviceList);
                    return;
                }
                return;
            }
            EasyLog.e("WifiP2pStateReceiver", "onReceive: WIFI_P2P_PEERS_CHANGED_ACTION deviceList is null ");
        } else if ("android.net.wifi.p2p.CONNECTION_STATE_CHANGE".equals(action)) {
            WifiP2pInfo wifiP2pInfo = (WifiP2pInfo) intent.getParcelableExtra("wifiP2pInfo");
            WifiP2pGroup wifiP2pGroup = (WifiP2pGroup) intent.getParcelableExtra("p2pGroupInfo");
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Null check: p2pInfo: ");
            boolean z = false;
            sb2.append(wifiP2pInfo != null);
            sb2.append(", wifiP2pGroup: ");
            sb2.append(wifiP2pGroup != null);
            sb2.append(", networkInfo: ");
            if (networkInfo != null) {
                z = true;
            }
            sb2.append(z);
            EasyLog.e("WifiP2pStateReceiver", sb2.toString());
            if (wifiP2pInfo != null) {
                EasyLog.e("WifiP2pStateReceiver", "p2pInfo: groupFormed: " + wifiP2pInfo.groupFormed + ", isGroupOwner: " + wifiP2pInfo.isGroupOwner);
            }
            if (wifiP2pGroup != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("networkInfo: ");
                sb3.append(networkInfo);
                sb3.append("\nwifiP2pGroup: ");
                sb3.append(wifiP2pGroup.getNetworkName());
                sb3.append(", ");
                sb3.append(wifiP2pGroup.getOwner() != null ? wifiP2pGroup.getOwner().deviceAddress : "null");
                sb3.append("\nClient: ");
                sb3.append(b(wifiP2pGroup.getClientList()));
                EasyLog.e("WifiP2pStateReceiver", sb3.toString());
            }
            OnConnectionChangedListener onConnectionChangedListener = this.c;
            if (onConnectionChangedListener != null) {
                onConnectionChangedListener.a(wifiP2pInfo, wifiP2pGroup, networkInfo);
            }
        } else if ("android.net.wifi.p2p.THIS_DEVICE_CHANGED".equals(action)) {
            WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) intent.getParcelableExtra("wifiP2pDevice");
            if (wifiP2pDevice != null) {
                OnThisDeviceChangedListener onThisDeviceChangedListener = this.d;
                if (onThisDeviceChangedListener != null) {
                    onThisDeviceChangedListener.a(wifiP2pDevice);
                    return;
                }
                return;
            }
            EasyLog.a("WifiP2pStateReceiver", "wifiP2pDevice is null");
        }
    }
}
