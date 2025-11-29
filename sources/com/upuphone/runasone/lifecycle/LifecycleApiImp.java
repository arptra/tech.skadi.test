package com.upuphone.runasone.lifecycle;

import com.upuphone.runasone.core.api.sys.LifecycleApi;
import com.upuphone.runasone.lifecycle.manager.LifecycleManager;

public class LifecycleApiImp implements LifecycleApi {
    public void registerLifecycleObserver(String str) {
        LifecycleManager.getInstance().onAppRegistered(str);
    }

    public void unRegisterLifecycleObserver(String str) {
        LifecycleManager.getInstance().onAppUnregistered(str);
    }
}
