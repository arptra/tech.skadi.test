package com.here.services.test.internal;

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
import android.os.RemoteException;
import com.here.odnp.util.Log;
import com.here.odnp.util.OdnpContext;
import com.here.odnp.util.SyncHandlerTask;
import com.here.posclient.ClientConfiguration;
import com.here.posclient.FingerprintStats;
import com.here.posclient.PositioningFeature;
import com.here.posclient.Status;
import com.here.services.internal.IBoundService;
import com.here.services.internal.Manager;
import com.here.services.internal.ServiceNotFoundException;
import com.here.services.internal.ServiceUtil;
import com.here.services.test.fingerprint.FingerprintCollectionTestApi;
import com.here.services.test.fingerprint.HdWifiCollectionTestApi;
import com.here.services.test.internal.FingerprintStatsListener;
import com.here.services.test.internal.HdWifiStateListener;
import com.here.services.test.internal.ILocationTestClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationTestClient implements ILocationTest {
    private static final String TAG = "services.test.internal.LocationTestClient";
    /* access modifiers changed from: private */
    public volatile ILocationTestClient mClient;
    /* access modifiers changed from: private */
    public Connection mConnection;
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final Map<HdWifiCollectionTestApi.StateListener, HdWifiStateListener.Stub> mHdWifiStateListeners = new HashMap();
    private final List<Runnable> mPendingTasks = new ArrayList();
    private BroadcastReceiver mUserSwitchListener;

    public class Connection implements ServiceConnection {
        final Manager.ConnectionListener mListener;
        private ILocationTestClient mService;

        public Connection(Manager.ConnectionListener connectionListener) {
            this.mListener = connectionListener;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (!ServiceUtil.isServiceNotAvailableBinder(iBinder)) {
                    ILocationTestClient asInterface = ILocationTestClient.Stub.asInterface(iBinder);
                    this.mService = asInterface;
                    LocationTestClient.this.handleServiceConnected(asInterface);
                    Manager.ConnectionListener connectionListener = this.mListener;
                    if (connectionListener != null) {
                        connectionListener.onConnected();
                        return;
                    }
                    return;
                }
                throw new RemoteException("Service is not available");
            } catch (RemoteException unused) {
                synchronized (LocationTestClient.this) {
                    if (LocationTestClient.this.mConnection != null) {
                        LocationTestClient.this.mContext.unbindService(this);
                        Connection unused2 = LocationTestClient.this.mConnection = null;
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
            Log.v(LocationTestClient.TAG, "onServiceDisconnected: %s", this.mService);
            ILocationTestClient iLocationTestClient = this.mService;
            if (iLocationTestClient != null) {
                LocationTestClient.this.handleServiceDisconnected(iLocationTestClient);
                this.mService = null;
                Manager.ConnectionListener connectionListener = this.mListener;
                if (connectionListener != null) {
                    connectionListener.onDisconnected();
                }
            }
        }
    }

    public LocationTestClient(Context context) throws ServiceNotFoundException {
        HandlerThread handlerThread = new HandlerThread("LocationTestClient");
        this.mHandlerThread = handlerThread;
        Log.v(TAG, "PositioningTestClient", new Object[0]);
        this.mContext = context;
        handlerThread.start();
        if (handlerThread.getLooper() != null) {
            this.mHandler = new Handler(handlerThread.getLooper());
            return;
        }
        throw new NullPointerException("HandlerThread's looper is null");
    }

    private synchronized void bindService(Manager.ConnectionListener connectionListener) {
        Log.v(TAG, "bindService", new Object[0]);
        if (this.mConnection == null) {
            try {
                ServiceUtil.ServiceInfo serviceInfo = ServiceUtil.getServiceInfo(this.mContext);
                Intent intent = serviceInfo.getIntent();
                intent.setAction(IBoundService.ACTION_BIND_LOCATION_TEST_SERVICE);
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

    /* access modifiers changed from: private */
    public synchronized void handleServiceConnected(ILocationTestClient iLocationTestClient) {
        this.mClient = iLocationTestClient;
        if (this.mClient == null) {
            Log.w(TAG, "handleServiceConnected: client is null", new Object[0]);
            return;
        }
        for (Runnable post : this.mPendingTasks) {
            if (!this.mHandler.post(post)) {
                Log.e(TAG, "handleServiceConnected: Handler.post failed", new Object[0]);
            }
        }
        this.mPendingTasks.clear();
    }

    /* access modifiers changed from: private */
    public synchronized void handleServiceDisconnected(ILocationTestClient iLocationTestClient) {
        if (iLocationTestClient != null) {
            try {
                if (iLocationTestClient.equals(this.mClient)) {
                    this.mClient = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        disconnect();
    }

    /* access modifiers changed from: private */
    public boolean isBinderAlive() {
        return this.mClient != null && this.mClient.asBinder().isBinderAlive();
    }

    private synchronized boolean postTask(Runnable runnable) {
        if (this.mClient == null) {
            this.mPendingTasks.add(runnable);
            return true;
        } else if (this.mHandler.post(runnable)) {
            return true;
        } else {
            Log.e(TAG, "postTask: Handler.post failed", new Object[0]);
            return false;
        }
    }

    private void startUserSwitchListener() {
        if (this.mUserSwitchListener == null) {
            this.mUserSwitchListener = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    synchronized (LocationTestClient.this) {
                        try {
                            if (LocationTestClient.this.mConnection != null) {
                                LocationTestClient.this.mContext.unbindService(LocationTestClient.this.mConnection);
                                Connection unused = LocationTestClient.this.mConnection = null;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_BACKGROUND");
            this.mContext.registerReceiver(this.mUserSwitchListener, intentFilter);
        }
    }

    private void stopUserSwitchListener() {
        BroadcastReceiver broadcastReceiver = this.mUserSwitchListener;
        if (broadcastReceiver != null) {
            this.mContext.unregisterReceiver(broadcastReceiver);
            this.mUserSwitchListener = null;
        }
    }

    public synchronized int availableFeatures() {
        Log.v(TAG, "availableFeatures", new Object[0]);
        AnonymousClass2 r1 = new SyncHandlerTask<Integer>() {
            public void onException(Exception exc) {
                setResult(0);
            }

            public Integer onRun() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (LocationTestClient.this.isBinderAlive()) {
                            Integer valueOf = Integer.valueOf(LocationTestClient.this.mClient.availableFeatures());
                            return valueOf;
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
                return 0;
            }
        };
        if (postTask(r1)) {
            return ((Integer) r1.getResult()).intValue();
        }
        Log.e(TAG, "availableFeatures: postTask failed", new Object[0]);
        return 0;
    }

    public void clearData(final int i) {
        Log.v(TAG, "clearData", new Object[0]);
        if (!postTask(new Runnable() {
            public void run() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (!LocationTestClient.this.isBinderAlive()) {
                            Log.w(LocationTestClient.TAG, "clearData: Service was disconnected -> ignored.", new Object[0]);
                        } else {
                            LocationTestClient.this.mClient.clearData(i);
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }
        })) {
            Log.e(TAG, "clearData: postTask failed", new Object[0]);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void close() {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x001d }
            java.lang.String r1 = "services.test.internal.LocationTestClient"
            java.lang.String r2 = "close"
            com.here.odnp.util.Log.v(r1, r2, r0)     // Catch:{ all -> 0x001d }
            java.util.List<java.lang.Runnable> r0 = r3.mPendingTasks     // Catch:{ all -> 0x001d }
            r0.clear()     // Catch:{ all -> 0x001d }
            com.here.services.test.internal.LocationTestClient$Connection r0 = r3.mConnection     // Catch:{ all -> 0x001d }
            r1 = 0
            if (r0 == 0) goto L_0x001f
            android.content.Context r2 = r3.mContext     // Catch:{ all -> 0x001d }
            r2.unbindService(r0)     // Catch:{ all -> 0x001d }
            r3.mConnection = r1     // Catch:{ all -> 0x001d }
            goto L_0x001f
        L_0x001d:
            r0 = move-exception
            goto L_0x0036
        L_0x001f:
            com.here.services.test.internal.ILocationTestClient r0 = r3.mClient     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x002f
            com.here.services.test.internal.ILocationTestClient r0 = r3.mClient     // Catch:{ RemoteException -> 0x0028, all -> 0x002b }
            r0.unBind()     // Catch:{ RemoteException -> 0x0028, all -> 0x002b }
        L_0x0028:
            r3.mClient = r1     // Catch:{ all -> 0x001d }
            goto L_0x002f
        L_0x002b:
            r0 = move-exception
            r3.mClient = r1     // Catch:{ all -> 0x001d }
            throw r0     // Catch:{ all -> 0x001d }
        L_0x002f:
            android.os.HandlerThread r0 = r3.mHandlerThread     // Catch:{ all -> 0x001d }
            r0.quit()     // Catch:{ all -> 0x001d }
            monitor-exit(r3)
            return
        L_0x0036:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.services.test.internal.LocationTestClient.close():void");
    }

    public void connect(Manager.ConnectionListener connectionListener) {
        Log.v(TAG, "connect", new Object[0]);
        startUserSwitchListener();
        bindService(connectionListener);
    }

    public void disconnect() {
        Log.v(TAG, "disconnect", new Object[0]);
        stopUserSwitchListener();
        close();
    }

    public synchronized void dumpCachedData() {
        Log.v(TAG, "dumpCachedData", new Object[0]);
        if (!postTask(new Runnable() {
            public void run() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (!LocationTestClient.this.isBinderAlive()) {
                            Log.w(LocationTestClient.TAG, "dumpCachedData: Service was disconnected -> ignored.", new Object[0]);
                        } else {
                            LocationTestClient.this.mClient.dumpCachedData();
                        }
                    }
                } catch (RemoteException e) {
                    Log.e(LocationTestClient.TAG, "dumpCachedData: Error: %s", Log.getStackTraceString(e));
                } catch (Throwable th) {
                    throw th;
                }
            }
        })) {
            Log.e(TAG, "dumpCachedData: postTask failed", new Object[0]);
        }
    }

    public synchronized void dumpData() {
        Log.v(TAG, "dumpData", new Object[0]);
        if (!postTask(new Runnable() {
            public void run() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (!LocationTestClient.this.isBinderAlive()) {
                            Log.w(LocationTestClient.TAG, "dumpData: Service was disconnected -> ignored.", new Object[0]);
                        } else {
                            LocationTestClient.this.mClient.dumpData();
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }
        })) {
            Log.e(TAG, "dumpData: postTask failed", new Object[0]);
        }
    }

    public void dumpFingerprints() {
        Log.v(TAG, "dumpFingerprints", new Object[0]);
        if (!postTask(new Runnable() {
            public void run() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (!LocationTestClient.this.isBinderAlive()) {
                            Log.w(LocationTestClient.TAG, "dumpFingerprints: Service was disconnected -> ignored.", new Object[0]);
                        } else {
                            LocationTestClient.this.mClient.dumpFingerprints();
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }
        })) {
            Log.e(TAG, "dumpFingerprints: postTask failed", new Object[0]);
        }
    }

    public synchronized void dumpHeapData() {
        Log.v(TAG, "dumpHeapData", new Object[0]);
        if (!postTask(new Runnable() {
            public void run() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (!LocationTestClient.this.isBinderAlive()) {
                            Log.w(LocationTestClient.TAG, "dumpHeapData: Service was disconnected -> ignored.", new Object[0]);
                        } else {
                            LocationTestClient.this.mClient.dumpHeapData();
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }
        })) {
            Log.e(TAG, "dumpHeapData: postTask failed", new Object[0]);
        }
    }

    public synchronized void dumpRemoteConfiguration() {
        if (!isBinderAlive()) {
            Log.v(TAG, "dumpRemoteConfiguration: Binder is not alive", new Object[0]);
            return;
        }
        try {
            this.mClient.dumpRemoteConfiguration();
        } catch (RemoteException unused) {
        }
    }

    public synchronized int enabledFeatures() {
        Log.v(TAG, "enabledFeatures", new Object[0]);
        AnonymousClass3 r1 = new SyncHandlerTask<Integer>() {
            public void onException(Exception exc) {
                setResult(0);
            }

            public Integer onRun() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (LocationTestClient.this.isBinderAlive()) {
                            Integer valueOf = Integer.valueOf(LocationTestClient.this.mClient.enabledFeatures());
                            return valueOf;
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
                return 0;
            }
        };
        if (postTask(r1)) {
            return ((Integer) r1.getResult()).intValue();
        }
        Log.e(TAG, "enabledFeatures: postTask failed", new Object[0]);
        return 0;
    }

    public int enabledTechnologies() {
        Log.v(TAG, "enabledTechnologies", new Object[0]);
        return 0;
    }

    public boolean getActiveCollection() {
        Log.v(TAG, "getActiveCollection", new Object[0]);
        if (!isBinderAlive()) {
            Log.v(TAG, "getActiveCollection: Binder is not alive", new Object[0]);
            return false;
        }
        AnonymousClass14 r1 = new SyncHandlerTask<Boolean>() {
            public void onException(Exception exc) {
                setResult(Boolean.FALSE);
            }

            public Boolean onRun() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (LocationTestClient.this.isBinderAlive()) {
                            Boolean valueOf = Boolean.valueOf(LocationTestClient.this.mClient.getActiveCollection());
                            return valueOf;
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
                return Boolean.FALSE;
            }
        };
        if (postTask(r1)) {
            Boolean bool = (Boolean) r1.getResult();
            boolean booleanValue = bool.booleanValue();
            Log.v(TAG, "getActiveCollection: result: %b", bool);
            return booleanValue;
        }
        Log.e(TAG, "getActiveCollection: postTask failed", new Object[0]);
        return false;
    }

    public boolean getAutoUpload() {
        Log.v(TAG, "getAutoUpload", new Object[0]);
        if (!isBinderAlive()) {
            Log.v(TAG, "getAutoUpload: Binder is not alive", new Object[0]);
            return false;
        }
        AnonymousClass16 r1 = new SyncHandlerTask<Boolean>() {
            public void onException(Exception exc) {
                setResult(Boolean.FALSE);
            }

            public Boolean onRun() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (LocationTestClient.this.isBinderAlive()) {
                            Boolean valueOf = Boolean.valueOf(LocationTestClient.this.mClient.getAutoUpload());
                            return valueOf;
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
                return Boolean.FALSE;
            }
        };
        if (postTask(r1)) {
            Boolean bool = (Boolean) r1.getResult();
            boolean booleanValue = bool.booleanValue();
            Log.v(TAG, "getAutoUpload: result: %b", bool);
            return booleanValue;
        }
        Log.e(TAG, "getAutoUpload: postTask failed", new Object[0]);
        return false;
    }

    public ClientConfiguration getClientConfiguration() {
        Log.v(TAG, "getClientConfiguration", new Object[0]);
        if (!isBinderAlive()) {
            Log.v(TAG, "getClientConfiguration: Binder is not alive", new Object[0]);
            return null;
        }
        AnonymousClass20 r1 = new SyncHandlerTask<ClientConfiguration>() {
            public ClientConfiguration onRun() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (!LocationTestClient.this.isBinderAlive()) {
                            return null;
                        }
                        ClientConfiguration clientConfiguration = LocationTestClient.this.mClient.getClientConfiguration();
                        return clientConfiguration;
                    }
                } catch (RemoteException unused) {
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        };
        if (postTask(r1)) {
            return (ClientConfiguration) r1.getResult();
        }
        Log.e(TAG, "getClientConfiguration: postTask failed", new Object[0]);
        return null;
    }

    public Status getCollectionStats(final FingerprintCollectionTestApi.StatsListener statsListener) {
        Log.v(TAG, "getCollectionStats", new Object[0]);
        if (!isBinderAlive()) {
            Log.v(TAG, "getCollectionStats: Binder is not alive", new Object[0]);
            return Status.InternalError;
        }
        AnonymousClass10 r0 = new SyncHandlerTask<Status>() {
            public void onException(Exception exc) {
                setResult(Status.GeneralError);
            }

            public Status onRun() {
                try {
                    ILocationTestClient access$500 = LocationTestClient.this.mClient;
                    if (access$500 != null) {
                        return Status.fromInt(access$500.getCollectionStats(new FingerprintStatsListener.Stub() {
                            public void onGetStatsCompleted(int i, Bundle bundle) throws RemoteException {
                                statsListener.onGetStatsCompleted(Status.fromInt(i), FingerprintStats.fromBundle(bundle));
                            }
                        }));
                    }
                } catch (RemoteException unused) {
                }
                return Status.GeneralError;
            }
        };
        return !this.mHandler.post(r0) ? Status.GeneralError : (Status) r0.getResult();
    }

    public boolean getCollectionStatus() {
        Log.v(TAG, "getCollectionStatus", new Object[0]);
        if (!isBinderAlive()) {
            Log.v(TAG, "getCollectionStatus: Binder is not alive", new Object[0]);
            return false;
        }
        AnonymousClass11 r1 = new SyncHandlerTask<Boolean>() {
            public void onException(Exception exc) {
                setResult(Boolean.FALSE);
            }

            public Boolean onRun() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (LocationTestClient.this.isBinderAlive()) {
                            Boolean valueOf = Boolean.valueOf(LocationTestClient.this.mClient.getCollectionStatus());
                            return valueOf;
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
                return Boolean.FALSE;
            }
        };
        if (postTask(r1)) {
            Boolean bool = (Boolean) r1.getResult();
            boolean booleanValue = bool.booleanValue();
            Log.v(TAG, "getCollectionStatus: result: %b", bool);
            return booleanValue;
        }
        Log.e(TAG, "getCollectionStatus: postTask failed", new Object[0]);
        return false;
    }

    public long getGnssFingerprintCount() {
        Log.v(TAG, "getGnssFingerprintCount", new Object[0]);
        if (!isBinderAlive()) {
            Log.v(TAG, "getGnssFingerprintCount: Binder is not alive", new Object[0]);
            return 0;
        }
        AnonymousClass18 r1 = new SyncHandlerTask<Long>() {
            public void onException(Exception exc) {
                setResult(0L);
            }

            public Long onRun() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (LocationTestClient.this.isBinderAlive()) {
                            Long valueOf = Long.valueOf(LocationTestClient.this.mClient.getGnssFingerprintCount());
                            return valueOf;
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
                return 0L;
            }
        };
        if (postTask(r1)) {
            Long l = (Long) r1.getResult();
            long longValue = l.longValue();
            Log.v(TAG, "getGnssFingerprintCount: count: %d", l);
            return longValue;
        }
        Log.e(TAG, "getGnssFingerprintCount: postTask failed", new Object[0]);
        return 0;
    }

    public long getNonGnssFingerprintCount() {
        Log.v(TAG, "getNonGnssFingerprintCount", new Object[0]);
        if (!isBinderAlive()) {
            Log.v(TAG, "getNonGnssFingerprintCount: Binder is not alive", new Object[0]);
            return 0;
        }
        AnonymousClass19 r1 = new SyncHandlerTask<Long>() {
            public void onException(Exception exc) {
                setResult(0L);
            }

            public Long onRun() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (LocationTestClient.this.isBinderAlive()) {
                            Long valueOf = Long.valueOf(LocationTestClient.this.mClient.getNonGnssFingerprintCount());
                            return valueOf;
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
                return 0L;
            }
        };
        if (postTask(r1)) {
            Long l = (Long) r1.getResult();
            long longValue = l.longValue();
            Log.v(TAG, "getNonGnssFingerprintCount: count: %d", l);
            return longValue;
        }
        Log.e(TAG, "getNonGnssFingerprintCount: postTask failed", new Object[0]);
        return 0;
    }

    public synchronized void logLta(String str) {
        if (!isBinderAlive()) {
            Log.v(TAG, "logLta: Binder is not alive", new Object[0]);
            return;
        }
        try {
            this.mClient.logLta(str);
        } catch (RemoteException unused) {
        }
    }

    public void overrideConfiguration(final String str) {
        Log.v(TAG, "overrideConfiguration: '%s'", str);
        if (!postTask(new Runnable() {
            public void run() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (!LocationTestClient.this.isBinderAlive()) {
                            Log.w(LocationTestClient.TAG, "overrideConfiguration: Service was disconnected -> ignored.", new Object[0]);
                        } else {
                            LocationTestClient.this.mClient.overrideConfiguration(str);
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }
        })) {
            Log.e(TAG, "overrideConfiguration: postTask failed", new Object[0]);
        }
    }

    public synchronized void refreshRemoteConfiguration() {
        if (!isBinderAlive()) {
            Log.v(TAG, "refreshRemoteConfiguration: Binder is not alive", new Object[0]);
            return;
        }
        try {
            this.mClient.refreshRemoteConfiguration();
        } catch (RemoteException unused) {
        }
    }

    public boolean registerHdWifiStateListener(final HdWifiCollectionTestApi.StateListener stateListener) {
        if (!isBinderAlive()) {
            Log.v(TAG, "registerHdWifiStateListener: Binder is not alive", new Object[0]);
            return false;
        }
        try {
            if (this.mHdWifiStateListeners.containsKey(stateListener)) {
                Log.w(TAG, "registerHdWifiStateListener: listener already registered", new Object[0]);
                return true;
            }
            AnonymousClass21 r0 = new HdWifiStateListener.Stub() {
                public void onStateUpdate(String str) throws RemoteException {
                    try {
                        stateListener.onHdWifiStateUpdate(new JSONObject(str));
                    } catch (JSONException e) {
                        Log.e(LocationTestClient.TAG, "registerHdWifiStateListener: onStateUpdate: failed to parse json", e);
                        stateListener.onHdWifiStateUpdate(new JSONObject());
                    }
                }
            };
            if (this.mClient.registerHdWifiStateListener(r0)) {
                this.mHdWifiStateListeners.put(stateListener, r0);
            }
            return false;
        } catch (RemoteException unused) {
        }
    }

    public void sendFingerprints() {
        Log.v(TAG, "sendFingerprints", new Object[0]);
        if (!postTask(new Runnable() {
            public void run() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (!LocationTestClient.this.isBinderAlive()) {
                            Log.w(LocationTestClient.TAG, "sendFingerprints: Service was disconnected -> ignored.", new Object[0]);
                        } else {
                            LocationTestClient.this.mClient.sendFingerprints();
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }
        })) {
            Log.e(TAG, "sendFingerprints: postTask failed", new Object[0]);
        }
    }

    public boolean setActiveCollection(final boolean z) {
        Log.v(TAG, "setActiveCollection: enabled: %b", Boolean.valueOf(z));
        AnonymousClass15 r0 = new SyncHandlerTask<Boolean>() {
            public void onException(Exception exc) {
                setResult(Boolean.FALSE);
            }

            public Boolean onRun() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (LocationTestClient.this.isBinderAlive()) {
                            Boolean valueOf = Boolean.valueOf(LocationTestClient.this.mClient.setActiveCollection(z));
                            return valueOf;
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
                return Boolean.FALSE;
            }
        };
        if (postTask(r0)) {
            Boolean bool = (Boolean) r0.getResult();
            boolean booleanValue = bool.booleanValue();
            Log.v(TAG, "setActiveCollection: result: %b", bool);
            return booleanValue;
        }
        Log.e(TAG, "setActiveCollection: postTask failed", new Object[0]);
        return false;
    }

    public boolean setAutoUpload(final boolean z) {
        Log.v(TAG, "setAutoUpload: enabled: %b", Boolean.valueOf(z));
        AnonymousClass17 r0 = new SyncHandlerTask<Boolean>() {
            public void onException(Exception exc) {
                setResult(Boolean.FALSE);
            }

            public Boolean onRun() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (LocationTestClient.this.isBinderAlive()) {
                            Boolean valueOf = Boolean.valueOf(LocationTestClient.this.mClient.setAutoUpload(z));
                            return valueOf;
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
                return Boolean.FALSE;
            }
        };
        if (postTask(r0)) {
            Boolean bool = (Boolean) r0.getResult();
            boolean booleanValue = bool.booleanValue();
            Log.v(TAG, "setAutoUpload: result: %b", bool);
            return booleanValue;
        }
        Log.e(TAG, "setAutoUpload: postTask failed", new Object[0]);
        return false;
    }

    public void setUsername(final String str) {
        Log.v(TAG, "setUsername: '%s'", str);
        if (!postTask(new Runnable() {
            public void run() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (!LocationTestClient.this.isBinderAlive()) {
                            Log.w(LocationTestClient.TAG, "setUsername: Service was disconnected -> ignored.", new Object[0]);
                        } else {
                            LocationTestClient.this.mClient.setUsername(str);
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }
        })) {
            Log.e(TAG, "setUsername: postTask failed", new Object[0]);
        }
    }

    public synchronized void toggleFeature(final PositioningFeature positioningFeature, final boolean z) {
        if (!postTask(new Runnable() {
            public void run() {
                try {
                    synchronized (LocationTestClient.this) {
                        if (LocationTestClient.this.isBinderAlive()) {
                            LocationTestClient.this.mClient.toggleFeature(positioningFeature.name(), z);
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }
        })) {
            Log.e(TAG, "toggleFeature: postTask failed", new Object[0]);
        }
    }

    public void toggleTechnology(int i, boolean z) {
        Log.v(TAG, "toggleTechnology technology: %b", Boolean.valueOf(z));
    }

    public void unregisterHdWifiStateListener(HdWifiCollectionTestApi.StateListener stateListener) {
        if (!isBinderAlive()) {
            Log.v(TAG, "unregisterHdWifiStateListener: Binder is not alive", new Object[0]);
            return;
        }
        try {
            HdWifiStateListener.Stub remove = this.mHdWifiStateListeners.remove(stateListener);
            if (remove == null) {
                Log.w(TAG, "unregisterHdWifiStateListener: listener not registered", new Object[0]);
            } else {
                this.mClient.unregisterHdWifiStateListener(remove);
            }
        } catch (RemoteException unused) {
        }
    }
}
