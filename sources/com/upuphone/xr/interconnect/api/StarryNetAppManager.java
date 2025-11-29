package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.common.IAppDockMenuClickListener;
import com.upuphone.xr.interconnect.entity.StarryNetApp;
import com.upuphone.xr.interconnect.entity.StarryNetAppDockMenu;
import java.util.List;

public interface StarryNetAppManager {
    void dynamicUpdateStarryNetApp(StarryNetApp starryNetApp);

    void onLocalStarryNetAppDockMenuClick(String str, String str2);

    void openRemoteStarryNetApp(String str, String str2, OpenRemoteStarryNetAppCallback openRemoteStarryNetAppCallback);

    List<StarryNetApp> queryLocalStarryNetApp(String str);

    List<StarryNetAppDockMenu> queryLocalStarryNetAppDockMenuList(String str);

    List<StarryNetApp> queryLocalStarryNetAppList();

    List<StarryNetApp> queryRemoteStarryNetAppList();

    void registerMenuClickListener(String str, IAppDockMenuClickListener iAppDockMenuClickListener);

    void registerStarryNetAppChangeListener(StarryNetAppChangeListener starryNetAppChangeListener);

    void unregisterMenuClickListener(String str, IAppDockMenuClickListener iAppDockMenuClickListener);

    void unregisterStarryNetAppChangeListener(StarryNetAppChangeListener starryNetAppChangeListener);
}
