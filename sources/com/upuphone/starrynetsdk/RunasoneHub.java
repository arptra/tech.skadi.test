package com.upuphone.starrynetsdk;

import android.os.Bundle;
import com.upuphone.hub.Hub;

public final class RunasoneHub extends Hub.Stub {
    private static RunasoneHub instance;
    private Dispatcher dispatcher;

    private RunasoneHub() {
    }

    public static RunasoneHub getInstance() {
        if (instance == null) {
            instance = new RunasoneHub();
        }
        return instance;
    }

    public void setDispatcher(Dispatcher dispatcher2) {
        this.dispatcher = dispatcher2;
    }

    public void transfer(Bundle bundle, Bundle bundle2) {
        bundle.setClassLoader(RunasoneHub.class.getClassLoader());
        Dispatcher dispatcher2 = this.dispatcher;
        if (dispatcher2 != null) {
            dispatcher2.transfer(bundle, bundle2);
        } else {
            SLog.d("transfer failed,dispatcher is null.");
        }
    }
}
