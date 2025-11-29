package com.upuphone.xr.interconnect.remote;

import android.os.Binder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.honey.account.z7.a;
import com.honey.account.z7.b;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IAppDockMenuClickListener;
import com.upuphone.xr.interconnect.common.IAppManager;
import com.upuphone.xr.interconnect.entity.StarryNetApp;
import com.upuphone.xr.interconnect.ipc.IpcClientManager;
import com.upuphone.xr.interconnect.util.DeDuplicateArrayList;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.List;
import kotlin.Unit;

public class AppManagerImpl extends IAppManager.Stub implements BinderClientDiedCallback {
    private static final String TAG = "AppManagerImpl";
    private List<IAppDockMenuClickListener> mAppDockMenuClickListenerList = new DeDuplicateArrayList();

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$registerMenuClickListener$0(int i, IAppDockMenuClickListener iAppDockMenuClickListener, String str) {
        if (TextUtils.isEmpty(str)) {
            ILog.d(TAG, i + "关联的应用包名存在异常");
            return Unit.INSTANCE;
        }
        this.mAppDockMenuClickListenerList.add(iAppDockMenuClickListener);
        InterconnectManager.getInstance().getStarryNetAppManager().registerMenuClickListener(str, iAppDockMenuClickListener);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$unregisterMenuClickListener$1(int i, IAppDockMenuClickListener iAppDockMenuClickListener, String str) {
        if (TextUtils.isEmpty(str)) {
            ILog.d(TAG, i + "关联的应用包名存在异常");
            return Unit.INSTANCE;
        }
        this.mAppDockMenuClickListenerList.remove(iAppDockMenuClickListener);
        InterconnectManager.getInstance().getStarryNetAppManager().unregisterMenuClickListener(str, iAppDockMenuClickListener);
        return Unit.INSTANCE;
    }

    public void onClientDied(BinderClient binderClient) {
        String packageName = binderClient.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            ILog.d(TAG, binderClient.getId() + "关联的应用包名存在异常");
            return;
        }
        for (IAppDockMenuClickListener unregisterMenuClickListener : this.mAppDockMenuClickListenerList) {
            InterconnectManager.getInstance().getStarryNetAppManager().unregisterMenuClickListener(packageName, unregisterMenuClickListener);
        }
    }

    public void registerMenuClickListener(IAppDockMenuClickListener iAppDockMenuClickListener) throws RemoteException {
        int callingPid = Binder.getCallingPid();
        IpcClientManager.INSTANCE.useAppId(callingPid, new a(this, callingPid, iAppDockMenuClickListener));
    }

    public void unregisterMenuClickListener(IAppDockMenuClickListener iAppDockMenuClickListener) throws RemoteException {
        int callingPid = Binder.getCallingPid();
        IpcClientManager.INSTANCE.useAppId(callingPid, new b(this, callingPid, iAppDockMenuClickListener));
    }

    public void updateApp(StarryNetApp starryNetApp) throws RemoteException {
        InterconnectManager.getInstance().getStarryNetAppManager().dynamicUpdateStarryNetApp(starryNetApp);
    }
}
