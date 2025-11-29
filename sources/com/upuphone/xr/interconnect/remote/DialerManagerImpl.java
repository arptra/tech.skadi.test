package com.upuphone.xr.interconnect.remote;

import android.os.Binder;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDialerManager;
import com.upuphone.xr.interconnect.common.IDialerListener;
import com.upuphone.xr.interconnect.common.IDialerManager;
import com.upuphone.xr.interconnect.util.DeDuplicateArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DialerManagerImpl extends IDialerManager.Stub implements BinderClientDiedCallback {
    private static final String TAG = "DialerManagerImpl";
    private Map<Integer, List<IDialerListener>> mDialerListenersMap = new HashMap();

    public void dial(int i, String str) throws RemoteException {
        if (!InterconnectManager.getInstance().getStarryNetDialerManager().dial(i, str)) {
            List<IDialerListener> list = this.mDialerListenersMap.get(Integer.valueOf(Binder.getCallingPid()));
            if (list != null) {
                for (IDialerListener onDialerStateChanged : list) {
                    onDialerStateChanged.onDialerStateChanged(str, -1);
                }
            }
        }
    }

    public void onClientDied(BinderClient binderClient) {
        List<IDialerListener> list = this.mDialerListenersMap.get(Integer.valueOf(binderClient.getId()));
        if (list != null) {
            StarryNetDialerManager starryNetDialerManager = InterconnectManager.getInstance().getStarryNetDialerManager();
            for (IDialerListener unregisterDialerListener : list) {
                starryNetDialerManager.unregisterDialerListener(unregisterDialerListener);
            }
        }
    }

    public void registerDialerListener(IDialerListener iDialerListener) throws RemoteException {
        if (iDialerListener != null) {
            int callingPid = Binder.getCallingPid();
            List list = this.mDialerListenersMap.get(Integer.valueOf(callingPid));
            if (list == null) {
                list = new DeDuplicateArrayList();
                this.mDialerListenersMap.put(Integer.valueOf(callingPid), list);
            }
            list.add(iDialerListener);
            InterconnectManager.getInstance().getStarryNetDialerManager().registerDialerListener(iDialerListener);
        }
    }

    public void syncPhoneBook() throws RemoteException {
        if (!InterconnectManager.getInstance().getStarryNetDialerManager().syncPhoneBook()) {
            List<IDialerListener> list = this.mDialerListenersMap.get(Integer.valueOf(Binder.getCallingPid()));
            if (list != null) {
                for (IDialerListener onSyncPhoneBookStateChanged : list) {
                    onSyncPhoneBookStateChanged.onSyncPhoneBookStateChanged(2);
                }
            }
        }
    }

    public void unregisterDialerListener(IDialerListener iDialerListener) throws RemoteException {
        if (iDialerListener != null) {
            List list = this.mDialerListenersMap.get(Integer.valueOf(Binder.getCallingPid()));
            if (list != null) {
                list.remove(iDialerListener);
            }
            InterconnectManager.getInstance().getStarryNetDialerManager().unregisterDialerListener(iDialerListener);
        }
    }
}
