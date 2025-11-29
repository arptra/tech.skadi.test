package com.upuphone.ar.navi.lite.model;

import com.upuphone.ar.navi.lite.base.SearchModel;
import com.upuphone.xr.interconnect.common.INaviActionResult;

public interface INavigation {
    void E();

    void changeNavi(int i, INaviActionResult iNaviActionResult);

    void changeRoute(int i, INaviActionResult iNaviActionResult);

    String getNaviDestination();

    boolean isTrafficEnabled();

    boolean readTrafficInfo(int i);

    boolean refreshNavi();

    void restartNaviTask(SearchModel searchModel, int i, boolean z);

    void setNaviSpeak(boolean z);

    void setTrafficEnabled(boolean z);

    void stopNavi();
}
