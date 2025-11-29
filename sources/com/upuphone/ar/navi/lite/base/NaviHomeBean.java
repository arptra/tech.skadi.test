package com.upuphone.ar.navi.lite.base;

import com.upuphone.xr.interconnect.common.INaviActionResult;
import java.io.Serializable;

public class NaviHomeBean implements Serializable {
    private INaviActionResult changeNaviResult = null;
    private INaviActionResult changeRouteResult = null;
    private boolean deviceConnected = false;
    private boolean directNavi = false;
    private boolean isNaviModeSwitch = false;
    private int navMode = -1;
    private boolean startedNavi = false;
    private int strategy = 10;
    private int switchMode = -1;

    public INaviActionResult getChangeNaviResult() {
        return this.changeNaviResult;
    }

    public INaviActionResult getChangeRouteResult() {
        return this.changeRouteResult;
    }

    public int getNavMode() {
        return this.navMode;
    }

    public int getStrategy() {
        return this.strategy;
    }

    public int getSwitchMode() {
        return this.switchMode;
    }

    public boolean isDeviceConnected() {
        return this.deviceConnected;
    }

    public boolean isDirectNavi() {
        return this.directNavi;
    }

    public boolean isNaviModeSwitch() {
        return this.isNaviModeSwitch;
    }

    public boolean isStartedNavi() {
        return this.startedNavi;
    }

    public void setChangeNaviResult(INaviActionResult iNaviActionResult) {
        this.changeNaviResult = iNaviActionResult;
    }

    public void setChangeRouteResult(INaviActionResult iNaviActionResult) {
        this.changeRouteResult = iNaviActionResult;
    }

    public void setDeviceConnected(boolean z) {
        this.deviceConnected = z;
    }

    public void setDirectNavi(boolean z) {
        this.directNavi = z;
    }

    public void setNavMode(int i) {
        this.navMode = i;
    }

    public void setNaviModeSwitch(boolean z) {
        this.isNaviModeSwitch = z;
    }

    public void setStartedNavi(boolean z) {
        this.startedNavi = z;
    }

    public void setStrategy(int i) {
        this.strategy = i;
    }

    public void setSwitchMode(int i) {
        this.switchMode = i;
    }

    public String toString() {
        return "NaviHomeBean{changeNaviResult=" + this.changeNaviResult + ", changeRouteResult=" + this.changeRouteResult + ", directNavi=" + this.directNavi + ", navMode=" + this.navMode + ", switchMode=" + this.switchMode + ", strategy=" + this.strategy + ", startedNavi=" + this.startedNavi + ", isNaviModeSwitch=" + this.isNaviModeSwitch + ", deviceConnected=" + this.deviceConnected + '}';
    }
}
