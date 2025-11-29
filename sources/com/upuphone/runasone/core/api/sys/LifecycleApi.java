package com.upuphone.runasone.core.api.sys;

import com.upuphone.hub.annotation.Hub;

@Hub
public interface LifecycleApi {
    void registerLifecycleObserver(String str);

    void unRegisterLifecycleObserver(String str);
}
