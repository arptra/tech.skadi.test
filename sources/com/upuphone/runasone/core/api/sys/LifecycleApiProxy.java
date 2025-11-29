package com.upuphone.runasone.core.api.sys;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.gson.Gson;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.hub.Hub;
import com.upuphone.hub.HubRemoteException;
import com.upuphone.hub.HubTargetException;
import com.upuphone.runasone.core.api.ApiConstant;

public final class LifecycleApiProxy implements LifecycleApi {
    private final Gson gson = new Gson();
    private Hub hub;

    public void registerLifecycleObserver(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "registerLifecycleObserver");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_LIFECYCLE);
        bundle.putString(AccountConstantKt.REQUEST_HEADER_PKG, str);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }

    public void setHub(Hub hub2) {
        this.hub = hub2;
    }

    public void unRegisterLifecycleObserver(String str) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle.putString("method", "unRegisterLifecycleObserver");
        bundle.putString("component", ApiConstant.COMPONENT);
        bundle.putString("ability", ApiConstant.ABILITY_LIFECYCLE);
        bundle.putString(AccountConstantKt.REQUEST_HEADER_PKG, str);
        try {
            this.hub.transfer(bundle, bundle2);
        } catch (RemoteException e) {
            throw new HubRemoteException(e);
        } catch (UnsupportedOperationException e2) {
            if ("target method not found".equals(e2.getMessage())) {
                throw new HubTargetException("target method not found");
            }
            throw e2;
        }
    }
}
