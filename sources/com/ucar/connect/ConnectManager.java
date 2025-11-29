package com.ucar.connect;

import com.easy.logger.EasyLog;
import com.share.connect.ConnectState;
import com.ucar.connect.aoa.AOAConnectManager;

public class ConnectManager {

    /* renamed from: a  reason: collision with root package name */
    public static final ConnectManager f9618a = new ConnectManager();

    public static ConnectManager a() {
        return f9618a;
    }

    public void b(int i, boolean z) {
        String a2 = ConnectState.b().a();
        if (a2.equals("usb_connected")) {
            AOAConnectManager.h().u(i, z);
        } else if (a2.equals("wifi_connected")) {
            EasyLog.a("ConnectManager", "Not need register socket , because the current connect type is " + a2);
        } else {
            EasyLog.c("ConnectManager", "The current connect state is " + a2 + " , is not allowed register server socket");
        }
    }
}
