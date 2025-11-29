package com.ucar.vehiclesdk;

import com.ucar.vehiclesdk.UCarCommon;
import com.ucar.vehiclesdk.common.UCarNotification;
import java.util.List;

public interface IPhoneDataListener {
    void a(String str, UCarCommon.POIAddress pOIAddress);

    UCarCommon.AudioAttributes b(UCarCommon.AudioType audioType);

    void c(String str, UCarCommon.CallInfo callInfo);

    void d(String str, List list);

    void e(String str, List list, UCarCommon.AppListState appListState);

    void f(String str, UCarCommon.PhoneStateInfo phoneStateInfo);

    void g(String str, UCarNotification uCarNotification);

    void h(String str, UCarCommon.MusicInfo musicInfo);

    void i(String str, int i, boolean z, int i2, int i3, UCarCommon.AppState appState, UCarCommon.DisplayMode displayMode);

    void j(String str, UCarCommon.NavigationInfo navigationInfo);
}
