package com.here.services.radiomap.internal;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.here.odnp.util.Log;
import com.here.odnp.util.OdnpContext;
import com.here.posclient.RadioMapManager;
import com.here.services.internal.IBoundService;
import com.here.services.internal.Manager;
import com.here.services.internal.ServiceUtil;
import com.here.services.radiomap.common.GeoArea;
import com.here.services.radiomap.internal.IRadioMapManager;
import com.here.services.radiomap.internal.IRadioMapManagerClient;
import com.here.services.radiomap.internal.RadioMapActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadioMapManagerClient implements IRadioMapManager {
    private static final String TAG = "services.radiomap.internal.RadioMapManagerClient";
    private IRadioMapManagerClient mClient;
    /* access modifiers changed from: private */
    public Connection mConnection;
    /* access modifiers changed from: private */
    public final Context mContext;
    private final HandlerThread mHandlerThread;
    private final Map<IRadioMapManager.IRadioMapActionListener, RadioMapActionRequest> mRequests = new HashMap();

    public class Connection implements ServiceConnection {
        private final Manager.ConnectionListener mListener;
        private IRadioMapManagerClient mService;
        private BroadcastReceiver mUserSwitchListener;

        public Connection(Manager.ConnectionListener connectionListener) {
            this.mListener = connectionListener;
        }

        private synchronized void startUserSwitchListener() {
            if (this.mUserSwitchListener == null) {
                this.mUserSwitchListener = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        Connection.this.onDisconnect();
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.USER_BACKGROUND");
                RadioMapManagerClient.this.mContext.registerReceiver(this.mUserSwitchListener, intentFilter);
            }
        }

        /* access modifiers changed from: private */
        public synchronized void stopUserSwitchListener() {
            if (this.mUserSwitchListener != null) {
                try {
                    RadioMapManagerClient.this.mContext.unregisterReceiver(this.mUserSwitchListener);
                } catch (IllegalArgumentException e) {
                    Log.w(RadioMapManagerClient.TAG, "stopUserSwitchListener: Could not unregister user switch listener: %s", Log.getStackTraceString(e));
                }
                this.mUserSwitchListener = null;
            }
        }

        public void onDisconnect() {
            if (this.mService != null) {
                stopUserSwitchListener();
                RadioMapManagerClient.this.handleServiceDisconnected(this.mService);
                this.mService = null;
                Manager.ConnectionListener connectionListener = this.mListener;
                if (connectionListener != null) {
                    connectionListener.onDisconnected();
                }
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (!ServiceUtil.isServiceNotAvailableBinder(iBinder)) {
                    this.mService = IRadioMapManagerClient.Stub.asInterface(iBinder);
                    startUserSwitchListener();
                    RadioMapManagerClient.this.handleServiceConnected(this.mService);
                    Manager.ConnectionListener connectionListener = this.mListener;
                    if (connectionListener != null) {
                        connectionListener.onConnected();
                        return;
                    }
                    return;
                }
                throw new RemoteException("Service is not available");
            } catch (RemoteException unused) {
                synchronized (RadioMapManagerClient.this) {
                    if (RadioMapManagerClient.this.mConnection != null) {
                        RadioMapManagerClient.this.mContext.unbindService(this);
                        Connection unused2 = RadioMapManagerClient.this.mConnection = null;
                    }
                    Manager.ConnectionListener connectionListener2 = this.mListener;
                    if (connectionListener2 != null) {
                        connectionListener2.onConnectionFailed();
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.v(RadioMapManagerClient.TAG, "onServiceDisconnected: %s", this.mService);
            onDisconnect();
        }
    }

    public abstract class RadioMapActionRequest {
        protected final GeoArea[] mGeoAreas;
        protected final IRadioMapManager.IRadioMapActionListener mListener;
        final Handler mListenerHandler;
        protected final RadioMapActionListener mRemoteListener = new RadioMapActionListener.Stub() {
            public void onRadioMapActionProgress(final int i) throws RemoteException {
                Log.d(RadioMapManagerClient.TAG, "onRadioMapActionProgress", new Object[0]);
                if (!RadioMapActionRequest.this.mListenerHandler.post(new Runnable() {
                    public void run() {
                        RadioMapActionRequest.this.mListener.onRadioMapActionProgress(i);
                    }
                })) {
                    Log.e(RadioMapManagerClient.TAG, "onRadioMapActionProgress: Handler.post failed", new Object[0]);
                }
            }

            public void onRadioMapQueryActionComplete(final int i, final long j) throws RemoteException {
                Log.d(RadioMapManagerClient.TAG, "onRadioMapQueryActionComplete", new Object[0]);
                if (!RadioMapActionRequest.this.mListenerHandler.post(new Runnable() {
                    public void run() {
                        RadioMapActionRequest.this.mListener.onRadioMapQueryActionComplete(i, j);
                    }
                })) {
                    Log.e(RadioMapManagerClient.TAG, "onRadioMapQueryActionComplete: Handler.post failed", new Object[0]);
                }
            }

            public void onRadioMapStorageActionComplete(final int i) throws RemoteException {
                Log.d(RadioMapManagerClient.TAG, "onRadioMapStorageActionComplete", new Object[0]);
                if (!RadioMapActionRequest.this.mListenerHandler.post(new Runnable() {
                    public void run() {
                        RadioMapActionRequest.this.mListener.onRadioMapStorageActionComplete(i);
                    }
                })) {
                    Log.e(RadioMapManagerClient.TAG, "onRadioMapStorageActionComplete: Handler.post failed", new Object[0]);
                }
            }

            public void onSessionClosed() throws RemoteException {
                Log.d(RadioMapManagerClient.TAG, "onSessionClosed", new Object[0]);
                if (!RadioMapActionRequest.this.mListenerHandler.post(new Runnable() {
                    public void run() {
                        RadioMapActionRequest.this.mListener.onSessionClosed();
                    }
                })) {
                    Log.e(RadioMapManagerClient.TAG, "onSessionClosed: Handler.post failed", new Object[0]);
                }
            }
        };
        private boolean mRequested;
        protected final int mTechnologies;

        public RadioMapActionRequest(List<GeoArea> list, int i, IRadioMapManager.IRadioMapActionListener iRadioMapActionListener) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            this.mListenerHandler = new Handler(Looper.myLooper());
            this.mGeoAreas = (GeoArea[]) list.toArray(new GeoArea[0]);
            this.mTechnologies = i;
            this.mListener = iRadioMapActionListener;
        }

        public abstract void onActionComplete(int i);

        public void onServiceDisconnected() {
            this.mRequested = false;
        }

        public abstract boolean onStartUpdates(IRadioMapManagerClient iRadioMapManagerClient);

        public boolean startUpdates(IRadioMapManagerClient iRadioMapManagerClient) {
            if (iRadioMapManagerClient == null) {
                return false;
            }
            if (this.mRequested) {
                return true;
            }
            boolean onStartUpdates = onStartUpdates(iRadioMapManagerClient);
            this.mRequested = onStartUpdates;
            if (!onStartUpdates) {
                onActionComplete(1);
            }
            return this.mRequested;
        }

        public void stopUpdates(IRadioMapManagerClient iRadioMapManagerClient) {
            if (this.mRequested) {
                this.mRequested = false;
                if (iRadioMapManagerClient != null) {
                    try {
                        iRadioMapManagerClient.stopRadioMapAction(this.mRemoteListener);
                    } catch (RemoteException unused) {
                    }
                }
            }
        }
    }

    public class RadioMapQueryActionRequest extends RadioMapActionRequest {
        private final String mAction;

        public RadioMapQueryActionRequest(List<GeoArea> list, int i, RadioMapManager.RadioMapQueryAction radioMapQueryAction, IRadioMapManager.IRadioMapActionListener iRadioMapActionListener) {
            super(list, i, iRadioMapActionListener);
            this.mAction = radioMapQueryAction.name();
        }

        public void onActionComplete(int i) {
            this.mListener.onRadioMapQueryActionComplete(i, 0);
        }

        public boolean onStartUpdates(IRadioMapManagerClient iRadioMapManagerClient) {
            try {
                Log.v(RadioMapManagerClient.TAG, "onStartUpdates: sending query action: %s technologies: %d", this.mAction, Integer.valueOf(this.mTechnologies));
                return iRadioMapManagerClient.startRadioMapQuery(this.mGeoAreas, this.mTechnologies, this.mAction, this.mRemoteListener);
            } catch (RemoteException unused) {
                return false;
            }
        }
    }

    public class RadioMapStorageActionRequest extends RadioMapActionRequest {
        private final String mAction;
        private final Bundle mOptions;

        public RadioMapStorageActionRequest(List<GeoArea> list, RadioMapManager.RadioMapStorageAction radioMapStorageAction, Bundle bundle, IRadioMapManager.IRadioMapActionListener iRadioMapActionListener) {
            super(list, 0, iRadioMapActionListener);
            this.mAction = radioMapStorageAction.name();
            this.mOptions = bundle;
        }

        public void onActionComplete(int i) {
            this.mListener.onRadioMapStorageActionComplete(i);
        }

        public boolean onStartUpdates(IRadioMapManagerClient iRadioMapManagerClient) {
            try {
                Log.v(RadioMapManagerClient.TAG, "onStartUpdates: sending update action: %s", this.mAction);
                return iRadioMapManagerClient.startRadioMapUpdate(this.mGeoAreas, this.mAction, this.mOptions, this.mRemoteListener);
            } catch (RemoteException unused) {
                return false;
            }
        }
    }

    private RadioMapManagerClient(Context context) {
        HandlerThread handlerThread = new HandlerThread("IRadioMapManagerClient");
        this.mHandlerThread = handlerThread;
        this.mContext = context;
        handlerThread.start();
        if (handlerThread.getLooper() == null) {
            throw new NullPointerException("looper is null");
        }
    }

    private synchronized void bindService(Manager.ConnectionListener connectionListener) {
        Log.v(TAG, "bindService", new Object[0]);
        if (this.mConnection == null) {
            try {
                ServiceUtil.ServiceInfo serviceInfo = ServiceUtil.getServiceInfo(this.mContext);
                Intent intent = serviceInfo.getIntent();
                intent.setAction(IBoundService.ACTION_BIND_RADIOMAP_MANAGER_SERVICE);
                Connection connection = new Connection(connectionListener);
                this.mConnection = connection;
                if (!OdnpContext.bindService(this.mContext, intent, connection, 64, serviceInfo.isMultiUser())) {
                    throw new RuntimeException();
                }
            } catch (Exception unused) {
                this.mConnection = null;
                connectionListener.onConnectionFailed();
            }
        } else {
            connectionListener.onConnected();
        }
    }

    private synchronized boolean handleAddRequest(IRadioMapManager.IRadioMapActionListener iRadioMapActionListener, RadioMapActionRequest radioMapActionRequest) {
        Log.i(TAG, "handleAddRequest: listener: %s", iRadioMapActionListener);
        handleRemoveRequest(iRadioMapActionListener);
        this.mRequests.put(iRadioMapActionListener, radioMapActionRequest);
        IRadioMapManagerClient iRadioMapManagerClient = this.mClient;
        if (iRadioMapManagerClient == null) {
            return true;
        }
        return radioMapActionRequest.startUpdates(iRadioMapManagerClient);
    }

    private synchronized void handleRemoveRequest(IRadioMapManager.IRadioMapActionListener iRadioMapActionListener) {
        Log.i(TAG, "handleRemoveRequest: listener: %s", iRadioMapActionListener);
        RadioMapActionRequest remove = this.mRequests.remove(iRadioMapActionListener);
        if (remove == null) {
            Log.w(TAG, "handleRemoveRequest: listener not found from requests", new Object[0]);
        } else {
            remove.stopUpdates(this.mClient);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void handleServiceConnected(IRadioMapManagerClient iRadioMapManagerClient) {
        this.mClient = iRadioMapManagerClient;
        if (iRadioMapManagerClient == null) {
            Log.w(TAG, "handleServiceConnected: mClient is null -> ignored", new Object[0]);
            return;
        }
        for (Map.Entry<IRadioMapManager.IRadioMapActionListener, RadioMapActionRequest> value : this.mRequests.entrySet()) {
            ((RadioMapActionRequest) value.getValue()).startUpdates(iRadioMapManagerClient);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void handleServiceDisconnected(IRadioMapManagerClient iRadioMapManagerClient) {
        if (iRadioMapManagerClient != null) {
            try {
                if (iRadioMapManagerClient.equals(this.mClient)) {
                    this.mClient = null;
                    for (Map.Entry<IRadioMapManager.IRadioMapActionListener, RadioMapActionRequest> value : this.mRequests.entrySet()) {
                        ((RadioMapActionRequest) value.getValue()).onServiceDisconnected();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        disconnect();
    }

    public static IRadioMapManager open(Context context) {
        Log.v(TAG, "open", new Object[0]);
        if (context != null) {
            return new RadioMapManagerClient(context);
        }
        throw new IllegalArgumentException("context is null");
    }

    public synchronized void close() {
        try {
            Log.v(TAG, "close", new Object[0]);
            this.mRequests.clear();
            Connection connection = this.mConnection;
            if (connection != null) {
                this.mContext.unbindService(connection);
                this.mConnection.stopUserSwitchListener();
                this.mConnection = null;
            }
            this.mClient = null;
            this.mHandlerThread.quit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void connect(Manager.ConnectionListener connectionListener) {
        bindService(connectionListener);
    }

    public void disconnect() {
        close();
    }

    public boolean startRadioMapQuery(List<GeoArea> list, int i, RadioMapManager.RadioMapQueryAction radioMapQueryAction, IRadioMapManager.IRadioMapActionListener iRadioMapActionListener) {
        if (list == null) {
            throw new IllegalArgumentException("area is null");
        } else if (radioMapQueryAction == null) {
            throw new IllegalArgumentException("action is null");
        } else if (iRadioMapActionListener != null) {
            return handleAddRequest(iRadioMapActionListener, new RadioMapQueryActionRequest(list, i, radioMapQueryAction, iRadioMapActionListener));
        } else {
            throw new IllegalArgumentException("listener is null");
        }
    }

    public boolean startRadioMapUpdate(List<GeoArea> list, RadioMapManager.RadioMapStorageAction radioMapStorageAction, Bundle bundle, IRadioMapManager.IRadioMapActionListener iRadioMapActionListener) {
        if (list == null) {
            throw new IllegalArgumentException("area is null");
        } else if (radioMapStorageAction == null) {
            throw new IllegalArgumentException("action is null");
        } else if (iRadioMapActionListener != null) {
            return handleAddRequest(iRadioMapActionListener, new RadioMapStorageActionRequest(list, radioMapStorageAction, bundle, iRadioMapActionListener));
        } else {
            throw new IllegalArgumentException("listener is null");
        }
    }

    public void stopRadioMapAction(IRadioMapManager.IRadioMapActionListener iRadioMapActionListener) {
        handleRemoveRequest(iRadioMapActionListener);
    }
}
