package com.upuphone.ar.navi.lite.model;

import com.upuphone.ar.navi.lite.base.NaviLaneInfo;
import com.upuphone.ar.navi.lite.protocol.NaviInfoBean;

public interface INaviEvent {
    void D(int i, String str);

    void G();

    void U();

    void f(boolean z);

    void h(int i);

    void l();

    void m(NaviLaneInfo naviLaneInfo);

    void s(int i);

    void v();

    void x(NaviInfoBean naviInfoBean, boolean z);
}
