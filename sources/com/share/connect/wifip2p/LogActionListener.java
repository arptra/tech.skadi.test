package com.share.connect.wifip2p;

import android.net.wifi.p2p.WifiP2pManager;
import com.easy.logger.EasyLog;

public class LogActionListener implements WifiP2pManager.ActionListener {

    /* renamed from: a  reason: collision with root package name */
    public String f9939a;
    public String b;

    public LogActionListener(String str, String str2) {
        this.f9939a = str;
        this.b = str2;
    }

    public void onFailure(int i) {
        String str = this.f9939a;
        EasyLog.i(str, this.b + " onFailure with reason: " + i);
    }

    public void onSuccess() {
        String str = this.f9939a;
        EasyLog.e(str, this.b + " onSuccess.");
    }
}
