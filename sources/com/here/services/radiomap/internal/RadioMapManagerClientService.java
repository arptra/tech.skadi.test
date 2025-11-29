package com.here.services.radiomap.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.util.DeviceMonitor;
import com.here.odnp.util.Log;
import com.here.odnp.util.MasterThread;
import com.here.odnp.util.SafeHandler;
import com.here.odnp.util.SyncHandlerTask;
import com.here.posclient.RadioMapManager;
import com.here.posclient.Status;
import com.here.services.internal.IBoundService;
import com.here.services.radiomap.common.GeoArea;
import com.here.services.radiomap.internal.IRadioMapManagerClient;
import com.here.services.radiomap.manager.RadioMapManagerApi;
import java.util.HashMap;
import java.util.Map;

public class RadioMapManagerClientService extends IRadioMapManagerClient.Stub implements IBoundService, DeviceMonitor.Listener {
    private static final String TAG = "services.radiomap.internal.RadioMapManagerClientService";
    /* access modifiers changed from: private */
    public final DeviceMonitor mDeviceMonitor;
    private final SafeHandler mHandler = new SafeHandler(MasterThread.getInstance().getLooper());
    /* access modifiers changed from: private */
    public final Map<IBinder, BoundListener> mListeners = new HashMap();
    private boolean mNetworkLocationEnabled;
    /* access modifiers changed from: private */
    public final IRmmPosClientManager mRmmPosClientManager;

    public class BoundListener implements RadioMapManager.IRadioMapStorageActionListener, IBinder.DeathRecipient {
        final IBinder mBinder;
        final RadioMapActionListener mListener;
        boolean mUpdateAction;

        public BoundListener(IBinder iBinder, RadioMapActionListener radioMapActionListener) {
            if (iBinder != null) {
                this.mBinder = iBinder;
                if (radioMapActionListener != null) {
                    this.mListener = radioMapActionListener;
                    return;
                }
                throw new IllegalArgumentException("listener is null");
            }
            throw new IllegalArgumentException("binder is null");
        }

        public void binderDied() {
            RadioMapManagerClientService.this.onConnectionDied(this.mListener);
        }

        public boolean link() {
            try {
                this.mBinder.linkToDeath(this, 0);
                return true;
            } catch (RemoteException unused) {
                return false;
            }
        }

        public void onCancelled() {
            try {
                if (this.mUpdateAction) {
                    this.mListener.onRadioMapStorageActionComplete(Status.CancelError.toInt());
                } else {
                    this.mListener.onRadioMapQueryActionComplete(Status.CancelError.toInt(), 0);
                }
            } catch (RemoteException unused) {
            }
        }

        public void onClosed() {
            try {
                this.mListener.onSessionClosed();
            } catch (RemoteException unused) {
                RadioMapManagerClientService.this.onConnectionDied(this.mListener);
            }
        }

        public void onRadioMapActionProgress(int i) {
            try {
                this.mListener.onRadioMapActionProgress(i);
            } catch (RemoteException unused) {
                RadioMapManagerClientService.this.onConnectionDied(this.mListener);
            }
        }

        public void onRadioMapQueryActionComplete(int i, long j) {
            try {
                this.mListener.onRadioMapQueryActionComplete(i, j);
            } catch (RemoteException unused) {
                RadioMapManagerClientService.this.onConnectionDied(this.mListener);
            }
        }

        public void onRadioMapStorageActionComplete(int i) {
            try {
                this.mListener.onRadioMapStorageActionComplete(i);
            } catch (RemoteException unused) {
                RadioMapManagerClientService.this.onConnectionDied(this.mListener);
            }
        }

        public BoundListener setIsUpdateAction(boolean z) {
            this.mUpdateAction = z;
            return this;
        }

        public void unlink() {
            this.mBinder.unlinkToDeath(this, 0);
        }
    }

    public RadioMapManagerClientService(IPosClientManager iPosClientManager, Intent intent) {
        Log.v(TAG, "RadioMapManagerClientService", new Object[0]);
        if (iPosClientManager != null) {
            this.mRmmPosClientManager = RmmPosClientManager.create(iPosClientManager);
            DeviceMonitor build = new DeviceMonitor.Builder(iPosClientManager.getContext(), this).setMonitorNetworkLocation(true).build();
            this.mDeviceMonitor = build;
            build.startMonitoring();
            return;
        }
        throw new IllegalArgumentException("posClientManager is null");
    }

    /* access modifiers changed from: private */
    public static long allowedConnections() {
        return 3;
    }

    /* access modifiers changed from: private */
    public RadioMapManager.IRadioMapStorageActionListener bindListener(RadioMapActionListener radioMapActionListener, boolean z) {
        IBinder asBinder = radioMapActionListener.asBinder();
        BoundListener boundListener = this.mListeners.get(asBinder);
        if (boundListener == null) {
            boundListener = new BoundListener(asBinder, radioMapActionListener);
            if (!boundListener.link()) {
                Log.e(TAG, "bindListener: linkToDeath failed", new Object[0]);
                return null;
            }
            this.mListeners.put(asBinder, boundListener);
        }
        return boundListener.setIsUpdateAction(z);
    }

    /* access modifiers changed from: private */
    public void onConnectionDied(final RadioMapActionListener radioMapActionListener) {
        Log.v(TAG, "onConnectionDied", new Object[0]);
        this.mHandler.post(new Runnable() {
            public void run() {
                BoundListener boundListener = (BoundListener) RadioMapManagerClientService.this.mListeners.remove(radioMapActionListener.asBinder());
                if (boundListener != null) {
                    boundListener.unlink();
                }
            }
        });
    }

    private void onNetworkLocationDisabled() {
        Log.v(TAG, "onNetworkLocationDisabled", new Object[0]);
        this.mHandler.post(new Runnable() {
            public void run() {
                for (Map.Entry value : RadioMapManagerClientService.this.mListeners.entrySet()) {
                    BoundListener boundListener = (BoundListener) value.getValue();
                    RadioMapManagerClientService.this.mRmmPosClientManager.stopRadioMapActions(boundListener);
                    boundListener.onCancelled();
                }
            }
        });
    }

    public void close() throws RemoteException {
        Log.v(TAG, "close", new Object[0]);
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                RadioMapManagerClientService.this.mDeviceMonitor.stopMonitoring();
                for (BoundListener boundListener : RadioMapManagerClientService.this.mListeners.values()) {
                    if (boundListener != null) {
                        boundListener.unlink();
                    }
                }
                RadioMapManagerClientService.this.mListeners.clear();
                RadioMapManagerClientService.this.mRmmPosClientManager.close();
            }
        })) {
            Log.e(TAG, "close: Handler.post failed", new Object[0]);
        }
    }

    public void onMonitorStateChanged(DeviceMonitor.Listener.MonitorType monitorType, boolean z) {
        Log.v(TAG, "onMonitorStateChanged: %s state: %b", monitorType, Boolean.valueOf(z));
        if (this.mNetworkLocationEnabled != z) {
            this.mNetworkLocationEnabled = z;
            if (!z) {
                onNetworkLocationDisabled();
            }
        }
    }

    public void onMonitoringStarted(DeviceMonitor.Listener.MonitorType monitorType, boolean z) {
        Log.v(TAG, "onMonitoringStarted: %s state: %b", monitorType, Boolean.valueOf(z));
        this.mNetworkLocationEnabled = z;
    }

    public void onMonitoringStopped(DeviceMonitor.Listener.MonitorType monitorType) {
    }

    public boolean startRadioMapQuery(GeoArea[] geoAreaArr, int i, String str, RadioMapActionListener radioMapActionListener) throws RemoteException {
        if (!this.mNetworkLocationEnabled) {
            Log.w(TAG, "startRadioMapQuery: Network location disabled -> return failure", new Object[0]);
            return false;
        }
        Log.v(TAG, "startRadioMapQuery", new Object[0]);
        final String str2 = str;
        final GeoArea[] geoAreaArr2 = geoAreaArr;
        final int i2 = i;
        final RadioMapActionListener radioMapActionListener2 = radioMapActionListener;
        AnonymousClass2 r4 = new SyncHandlerTask<Boolean>() {
            public void onException(Exception exc) {
                setResult(Boolean.FALSE);
            }

            public Boolean onRun() {
                return Boolean.valueOf(RadioMapManagerClientService.this.mRmmPosClientManager.startRadioMapQuery(RadioMapManager.RadioMapQueryAction.valueOf(str2), RadioMapManagerClientService.allowedConnections(), geoAreaArr2, i2, RadioMapManagerClientService.this.bindListener(radioMapActionListener2, false)));
            }
        };
        if (this.mHandler.post(r4)) {
            return ((Boolean) r4.getResult()).booleanValue();
        }
        Log.e(TAG, "startRadioMapQuery: Handler.post failed", new Object[0]);
        return false;
    }

    public boolean startRadioMapUpdate(GeoArea[] geoAreaArr, String str, Bundle bundle, RadioMapActionListener radioMapActionListener) throws RemoteException {
        if (!this.mNetworkLocationEnabled) {
            Log.w(TAG, "startRadioMapUpdate: Network location disabled -> return failure", new Object[0]);
            return false;
        }
        Log.v(TAG, "startRadioMapUpdate", new Object[0]);
        final String str2 = str;
        final GeoArea[] geoAreaArr2 = geoAreaArr;
        final Bundle bundle2 = bundle;
        final RadioMapActionListener radioMapActionListener2 = radioMapActionListener;
        AnonymousClass1 r4 = new SyncHandlerTask<Boolean>() {
            public void onException(Exception exc) {
                setResult(Boolean.FALSE);
            }

            public Boolean onRun() {
                return Boolean.valueOf(RadioMapManagerClientService.this.mRmmPosClientManager.startRadioMapUpdate(RadioMapManager.RadioMapStorageAction.valueOf(str2), RadioMapManagerClientService.allowedConnections(), geoAreaArr2, RadioMapManagerApi.Options.getTechnologies(bundle2), RadioMapManagerApi.Options.getFlags(bundle2), RadioMapManagerClientService.this.bindListener(radioMapActionListener2, true)));
            }
        };
        if (this.mHandler.post(r4)) {
            return ((Boolean) r4.getResult()).booleanValue();
        }
        Log.e(TAG, "startRadioMapUpdate: Handler.post failed. Could not start radio map update.", new Object[0]);
        return false;
    }

    public void stopRadioMapAction(final RadioMapActionListener radioMapActionListener) throws RemoteException {
        Log.v(TAG, "stopRadioMapAction", new Object[0]);
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                RadioMapManager.IRadioMapStorageActionListener iRadioMapStorageActionListener = (RadioMapManager.IRadioMapStorageActionListener) RadioMapManagerClientService.this.mListeners.remove(radioMapActionListener.asBinder());
                if (iRadioMapStorageActionListener == null) {
                    Log.w(RadioMapManagerClientService.TAG, "stopRadioMapAction: listener not found", new Object[0]);
                } else {
                    RadioMapManagerClientService.this.mRmmPosClientManager.stopRadioMapActions(iRadioMapStorageActionListener);
                }
            }
        })) {
            Log.e(TAG, "stopRadioMapAction: Handler.post failed", new Object[0]);
        }
    }

    public void unBind() {
        Log.v(TAG, "unBind", new Object[0]);
        try {
            close();
        } catch (RemoteException unused) {
        }
    }
}
