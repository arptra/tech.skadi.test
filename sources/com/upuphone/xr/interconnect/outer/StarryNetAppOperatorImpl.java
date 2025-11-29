package com.upuphone.xr.interconnect.outer;

import android.os.RemoteException;
import android.util.Log;
import com.upuphone.xr.interconnect.api.StarryNetAppOperator;
import com.upuphone.xr.interconnect.common.IAppManager;
import com.upuphone.xr.interconnect.entity.StarryNetApp;
import com.upuphone.xr.interconnect.listener.StarryNetAppDockMenuClickListener;
import com.upuphone.xr.interconnect.util.DeDuplicateArrayList;
import java.util.List;

public class StarryNetAppOperatorImpl implements StarryNetAppOperator, SuperServiceStateListener {
    private static final String TAG = "StarryNetAppOperatorImpl";
    private SuperServiceProvider mProvider;
    private List<StarryNetAppDockMenuClickListener> mStarryNetAppDockMenuClickListeners = new DeDuplicateArrayList();

    private void doRegisterMenuClickListener(StarryNetAppDockMenuClickListener starryNetAppDockMenuClickListener) {
        IAppManager appManager = this.mProvider.getAppManager();
        if (appManager != null) {
            try {
                appManager.registerMenuClickListener(starryNetAppDockMenuClickListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void onServiceConnected() {
        for (StarryNetAppDockMenuClickListener doRegisterMenuClickListener : this.mStarryNetAppDockMenuClickListeners) {
            doRegisterMenuClickListener(doRegisterMenuClickListener);
        }
    }

    public void onServiceDied() {
    }

    public void registerMenuClickListener(StarryNetAppDockMenuClickListener starryNetAppDockMenuClickListener) {
        if (starryNetAppDockMenuClickListener == null) {
            Log.d(TAG, "registerMenuClickListener param listener is null");
            return;
        }
        this.mStarryNetAppDockMenuClickListeners.add(starryNetAppDockMenuClickListener);
        doRegisterMenuClickListener(starryNetAppDockMenuClickListener);
    }

    public void setProvider(SuperServiceProvider superServiceProvider) {
        this.mProvider = superServiceProvider;
    }

    public void unregisterMenuClickListener(StarryNetAppDockMenuClickListener starryNetAppDockMenuClickListener) {
        if (starryNetAppDockMenuClickListener == null) {
            Log.d(TAG, "unregisterMenuClickListener param listener is null");
            return;
        }
        this.mStarryNetAppDockMenuClickListeners.remove(starryNetAppDockMenuClickListener);
        IAppManager appManager = this.mProvider.getAppManager();
        if (appManager != null) {
            try {
                appManager.unregisterMenuClickListener(starryNetAppDockMenuClickListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateApp(StarryNetApp starryNetApp) {
        IAppManager appManager = this.mProvider.getAppManager();
        if (appManager != null) {
            try {
                appManager.updateApp(starryNetApp);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
