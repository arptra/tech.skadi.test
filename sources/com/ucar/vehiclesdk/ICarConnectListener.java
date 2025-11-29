package com.ucar.vehiclesdk;

import com.share.connect.WifiOwnerConfig;
import com.ucar.vehiclesdk.UCarCommon;

public interface ICarConnectListener {
    void a(String str, String str2);

    UCarCommon.WorkMode b(String str, UCarCommon.WorkMode workMode);

    void c(WifiOwnerConfig wifiOwnerConfig) {
    }

    void d(String str, int i, int i2);

    void e(boolean z) {
    }

    void f(String str, int i);
}
