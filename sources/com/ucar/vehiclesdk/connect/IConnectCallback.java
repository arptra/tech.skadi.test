package com.ucar.vehiclesdk.connect;

import com.share.connect.WifiOwnerConfig;

public interface IConnectCallback {
    void a(String str, String str2);

    void b();

    void c(String str, boolean z);

    void d();

    void e(String str, String str2);

    void f(String str, int i);

    void g(String str, int i);

    void h(String str);

    void i(String str);

    void onConnected();

    void onReceivedClientBleMac(String str);

    void onReconfigureWifi(WifiOwnerConfig wifiOwnerConfig);

    int onSelectWorkMode(int i);

    void onUserInterventionNeeded(boolean z);
}
