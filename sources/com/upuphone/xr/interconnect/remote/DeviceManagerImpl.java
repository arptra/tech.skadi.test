package com.upuphone.xr.interconnect.remote;

import android.os.Binder;
import android.os.RemoteException;
import com.honey.account.z7.c;
import com.honey.account.z7.d;
import com.honey.account.z7.e;
import com.honey.account.z7.f;
import com.honey.account.z7.g;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceManagerImpl;
import com.upuphone.xr.interconnect.api.connection.ConnectionLevel;
import com.upuphone.xr.interconnect.common.IDeviceBondStateListener;
import com.upuphone.xr.interconnect.common.IDeviceConnectionListener;
import com.upuphone.xr.interconnect.common.IDeviceManager;
import com.upuphone.xr.interconnect.common.IP2pAcquireCallback;
import com.upuphone.xr.interconnect.common.IP2pStateListener;
import com.upuphone.xr.interconnect.common.IRequestCallback;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.ipc.IpcClientManager;
import com.upuphone.xr.interconnect.util.DeDuplicateArrayList;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;

public class DeviceManagerImpl extends IDeviceManager.Stub implements BinderClientDiedCallback {
    private Map<Integer, List<IDeviceBondStateListener>> mDeviceBondStateListenersMap = new HashMap();
    private Map<Integer, List<IDeviceConnectionListener>> mDeviceConnectionListenersMap = new HashMap();
    private Map<Integer, List<IP2pStateListener>> mP2pStateListenersMap = new HashMap();
    private String tag = PrettyPrintExtKt.stringify(this);

    public DeviceManagerImpl() {
        IpcClientManager.INSTANCE.addListener(this);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$requestConnectionLevel$3(IRequestCallback iRequestCallback) {
        try {
            iRequestCallback.onFail(3, (String) null);
        } catch (RemoteException unused) {
        }
        return Unit.INSTANCE;
    }

    public void abandonConnectionLevel(String str, String str2, int i) throws RemoteException {
        ((StarryNetDeviceManagerImpl) InterconnectManager.getInstance().getStarryNetDeviceManager()).connectManager.manageDeviceConnectionLevel(str2, new g(str, i == 2 ? ConnectionLevel.ENHANCE : ConnectionLevel.BALANCE));
    }

    public List<StarryNetDevice> getBondedDevices() throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getBondedDevices();
    }

    public StarryNetDevice getConnectedDevice() throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDeviceWrapper();
    }

    public int getDeviceBondState(String str) throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getDeviceBondState(str);
    }

    public int getP2pState() throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getP2pState();
    }

    public StarryNetDevice getSelfDevice() throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().getSelfDevice();
    }

    public void onClientDied(BinderClient binderClient) {
        int id = binderClient.getId();
        List<IDeviceConnectionListener> list = this.mDeviceConnectionListenersMap.get(Integer.valueOf(id));
        if (list != null) {
            for (IDeviceConnectionListener unregisterDeviceConnectionListener : list) {
                InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceConnectionListener(unregisterDeviceConnectionListener);
            }
        }
        List<IP2pStateListener> list2 = this.mP2pStateListenersMap.get(Integer.valueOf(id));
        if (list2 != null) {
            for (IP2pStateListener unregisterP2pSateListener : list2) {
                InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterP2pSateListener(unregisterP2pSateListener);
            }
        }
        List<IDeviceBondStateListener> list3 = this.mDeviceBondStateListenersMap.get(Integer.valueOf(id));
        if (list3 != null) {
            for (IDeviceBondStateListener unregisterDeviceBondStateListener : list3) {
                InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceBondStateListener(unregisterDeviceBondStateListener);
            }
        }
        InterconnectManager.getInstance().getStarryNetDeviceManager().tryReleaseP2p(binderClient.getPackageName());
    }

    public void registerDeviceBondStateListener(IDeviceBondStateListener iDeviceBondStateListener) throws RemoteException {
        if (iDeviceBondStateListener != null) {
            int callingPid = Binder.getCallingPid();
            List list = this.mDeviceBondStateListenersMap.get(Integer.valueOf(callingPid));
            if (list == null) {
                list = new DeDuplicateArrayList();
                this.mDeviceBondStateListenersMap.put(Integer.valueOf(callingPid), list);
            }
            list.add(iDeviceBondStateListener);
            InterconnectManager.getInstance().getStarryNetDeviceManager().registerDeviceBondStateListener(iDeviceBondStateListener);
        }
    }

    public void registerDeviceConnectionListener(IDeviceConnectionListener iDeviceConnectionListener) throws RemoteException {
        String str = this.tag;
        ILog.i(str, "Handling connection listener " + iDeviceConnectionListener + " registration request from process " + Binder.getCallingPid());
        if (iDeviceConnectionListener != null) {
            int callingPid = Binder.getCallingPid();
            List list = this.mDeviceConnectionListenersMap.get(Integer.valueOf(callingPid));
            if (list == null) {
                list = new DeDuplicateArrayList();
                this.mDeviceConnectionListenersMap.put(Integer.valueOf(callingPid), list);
            }
            list.add(iDeviceConnectionListener);
            InterconnectManager.getInstance().getStarryNetDeviceManager().registerDeviceConnectionListener(iDeviceConnectionListener);
        }
    }

    public void registerP2pStateListener(IP2pStateListener iP2pStateListener) throws RemoteException {
        int callingPid = Binder.getCallingPid();
        if (this.mP2pStateListenersMap.get(Integer.valueOf(callingPid)) == null) {
            this.mP2pStateListenersMap.put(Integer.valueOf(callingPid), new DeDuplicateArrayList());
        }
        InterconnectManager.getInstance().getStarryNetDeviceManager().registerP2pStateListener(iP2pStateListener);
    }

    public void requestConnectionLevel(String str, String str2, int i, IRequestCallback iRequestCallback) throws RemoteException {
        ((StarryNetDeviceManagerImpl) InterconnectManager.getInstance().getStarryNetDeviceManager()).connectManager.manageDeviceConnectionLevel(str2, new e(str, i == 2 ? ConnectionLevel.ENHANCE : ConnectionLevel.BALANCE, iRequestCallback), new f(iRequestCallback));
    }

    public void tryAcquireP2p(IP2pAcquireCallback iP2pAcquireCallback) throws RemoteException {
        IpcClientManager.INSTANCE.useAppId(Binder.getCallingPid(), new d(iP2pAcquireCallback));
    }

    public void tryReleaseP2p() throws RemoteException {
        IpcClientManager.INSTANCE.useAppId(Binder.getCallingPid(), new c());
    }

    public boolean unBondDevice(String str) throws RemoteException {
        return InterconnectManager.getInstance().getStarryNetDeviceManager().unBondDevice(str);
    }

    public void unregisterDeviceBondStateListener(IDeviceBondStateListener iDeviceBondStateListener) throws RemoteException {
        if (iDeviceBondStateListener != null) {
            List list = this.mDeviceBondStateListenersMap.get(Integer.valueOf(Binder.getCallingPid()));
            if (list != null) {
                list.remove(iDeviceBondStateListener);
            }
            InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceBondStateListener(iDeviceBondStateListener);
        }
    }

    public void unregisterDeviceConnectionListener(IDeviceConnectionListener iDeviceConnectionListener) throws RemoteException {
        if (iDeviceConnectionListener != null) {
            List list = this.mDeviceConnectionListenersMap.get(Integer.valueOf(Binder.getCallingPid()));
            if (list != null) {
                list.remove(iDeviceConnectionListener);
            }
            InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceConnectionListener(iDeviceConnectionListener);
        }
    }

    public void unregisterP2pStateListener(IP2pStateListener iP2pStateListener) throws RemoteException {
        List list = this.mP2pStateListenersMap.get(Integer.valueOf(Binder.getCallingPid()));
        if (list != null) {
            list.remove(iP2pStateListener);
        }
        InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterP2pSateListener(iP2pStateListener);
    }
}
