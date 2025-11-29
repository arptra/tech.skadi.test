package com.bun.miitmdid.provider;

import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.InnerIdProvider;
import com.netease.nis.sdkwrapper.Utils;

public abstract class BaseProvider implements InnerIdProvider {
    public String AAID = "";
    public String OAID = "";
    public String VAID = "";
    public boolean isSupport = false;
    public IIdentifierListener mcallback;

    public abstract void doStart();

    public String getAAID() {
        return (String) Utils.rL(new Object[]{this, 32, 1606976968504L});
    }

    public String getOAID() {
        return (String) Utils.rL(new Object[]{this, 33, 1606976968505L});
    }

    public String getVAID() {
        return (String) Utils.rL(new Object[]{this, 34, 1606976968506L});
    }

    public boolean isSync() {
        return ((Boolean) Utils.rL(new Object[]{this, 35, 1606976968507L})).booleanValue();
    }

    public void returnCallResult() {
        Utils.rL(new Object[]{this, 36, 1606976968508L});
    }

    public void shutDown() {
        Utils.rL(new Object[]{this, 37, 1606976968509L});
    }

    public void startAction(IIdentifierListener iIdentifierListener) {
        Utils.rL(new Object[]{this, iIdentifierListener, 38, 1606976968510L});
    }
}
