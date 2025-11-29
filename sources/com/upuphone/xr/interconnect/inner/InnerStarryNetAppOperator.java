package com.upuphone.xr.interconnect.inner;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetAppManager;
import com.upuphone.xr.interconnect.api.StarryNetAppOperator;
import com.upuphone.xr.interconnect.entity.StarryNetApp;
import com.upuphone.xr.interconnect.listener.StarryNetAppDockMenuClickListener;

public class InnerStarryNetAppOperator implements StarryNetAppOperator {
    private StarryNetAppManager mStarryNetAppManager = InterconnectManager.getInstance().getStarryNetAppManager();
    private String pkgName;

    public InnerStarryNetAppOperator(String str) {
        this.pkgName = str;
    }

    public void registerMenuClickListener(StarryNetAppDockMenuClickListener starryNetAppDockMenuClickListener) {
        this.mStarryNetAppManager.registerMenuClickListener(this.pkgName, starryNetAppDockMenuClickListener);
    }

    public void unregisterMenuClickListener(StarryNetAppDockMenuClickListener starryNetAppDockMenuClickListener) {
        this.mStarryNetAppManager.unregisterMenuClickListener(this.pkgName, starryNetAppDockMenuClickListener);
    }

    public void updateApp(StarryNetApp starryNetApp) {
        this.mStarryNetAppManager.dynamicUpdateStarryNetApp(starryNetApp);
    }
}
