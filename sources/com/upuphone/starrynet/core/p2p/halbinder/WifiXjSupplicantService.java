package com.upuphone.starrynet.core.p2p.halbinder;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.upuphone.starrynet.common.StLog;

public class WifiXjSupplicantService {
    private static final String INTERFACE_WLAN0 = "wlan0";
    private static final int SCC_DFS_DISABLE = 0;
    private static final int SCC_DFS_ENABLE = 2;
    private static final String STRING_SET_GO_FORCE_SCC = "SET_GO_FORCE_SCC ";
    private static final String STRING_SET_STA_SAP_SCC_DFS = "SET_STA_SAP_SCC_DFS ";
    private static final String TAG = "WifiXjSupplicantService";
    private boolean isInitIfal;
    private final IXjSupplicantStaIfaceHal mSupplicantStaIfaceHal = new XjSupplicantStaIfaceHalAidlImpl();
    private final WifiManager mWifiManager;

    public WifiXjSupplicantService(Context context) {
        this.mWifiManager = (WifiManager) context.getSystemService("wifi");
    }

    public void enableGoForceScc(boolean z) {
        if (this.mWifiManager.isWifiEnabled()) {
            if (z && !this.isInitIfal) {
                initSupplicantStaIfaceHal();
            }
            if (this.isInitIfal) {
                StLog.d(TAG, "enableGoForceScc, enable = " + z);
                IXjSupplicantStaIfaceHal iXjSupplicantStaIfaceHal = this.mSupplicantStaIfaceHal;
                iXjSupplicantStaIfaceHal.doXjSupplicantCmd(INTERFACE_WLAN0, STRING_SET_GO_FORCE_SCC + z);
            }
        }
    }

    public void enableGoSccDfs(boolean z) {
        if (this.mWifiManager.isWifiEnabled() && this.isInitIfal) {
            StLog.d(TAG, "enableGoSccDfs, enable = " + z);
            int i = z ? 2 : 0;
            IXjSupplicantStaIfaceHal iXjSupplicantStaIfaceHal = this.mSupplicantStaIfaceHal;
            iXjSupplicantStaIfaceHal.doXjSupplicantCmd(INTERFACE_WLAN0, STRING_SET_STA_SAP_SCC_DFS + i);
        }
    }

    public void initSupplicantStaIfaceHal() {
        StLog.d(TAG, "initSupplicantStaIfaceHal");
        if (this.mSupplicantStaIfaceHal.initialize()) {
            this.isInitIfal = true;
        }
    }

    public void resetSupplicantStaIfaceHal() {
        StLog.d(TAG, "resetSupplicantStaIfaceHal");
        this.isInitIfal = false;
    }
}
