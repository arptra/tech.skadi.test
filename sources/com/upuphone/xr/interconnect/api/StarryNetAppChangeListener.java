package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.entity.StarryNetApp;
import java.util.List;

public interface StarryNetAppChangeListener {
    void onLocalStarryNetAppChange(StarryNetApp starryNetApp);

    void onLocalStarryNetAppListChange(List<StarryNetApp> list);

    void onPeerAppInstalled() {
    }

    void onPeerAppRemoved() {
    }

    void onRemoteStarryNetAppChange(StarryNetApp starryNetApp);

    void onRemoteStarryNetAppListChange(List<StarryNetApp> list);
}
