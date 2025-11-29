package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.entity.StarryNetApp;
import com.upuphone.xr.interconnect.listener.StarryNetAppDockMenuClickListener;

public interface StarryNetAppOperator {
    void registerMenuClickListener(StarryNetAppDockMenuClickListener starryNetAppDockMenuClickListener);

    void unregisterMenuClickListener(StarryNetAppDockMenuClickListener starryNetAppDockMenuClickListener);

    void updateApp(StarryNetApp starryNetApp);
}
