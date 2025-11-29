package com.here.services.playback.internal;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.here.odnp.util.Log;
import com.here.odnp.util.OdnpContext;
import com.here.posclient.Status;
import com.here.services.internal.IBoundService;
import com.here.services.internal.Manager;
import com.here.services.internal.ServiceUtil;
import com.here.services.playback.TestTrackSimulationApi;
import com.here.services.playback.internal.IMeasurementPlaybackClient;
import com.here.services.playback.internal.ITestTrackSimulationListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeasurementPlaybackClient implements Manager {
    protected static final String ACTION_PLAYBACK_BEGIN = "com.here.odnp.test.playback-begin";
    protected static final String ACTION_PLAYBACK_END = "com.here.odnp.test.playback-end";
    protected static final String EXTRA_INT_TECHNOLOGIES = "technologies";
    protected static final String EXTRA_STR_FILENAME = "filename";
    private static final String TAG = "services.playback.internal.MeasurementPlaybackClient";
    /* access modifiers changed from: private */
    public volatile IMeasurementPlaybackClient mClient;
    /* access modifiers changed from: private */
    public Connection mConnection;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private final HandlerThread mHandlerThread = new HandlerThread("MeasurementPlaybackClient");
    private final List<Runnable> mPendingTasks = new ArrayList();
    /* access modifiers changed from: private */
    public final Map<String, IPlaybackStateListener> mPlaybackListeners = new HashMap();
    private BroadcastReceiver mPlaybackReceiver;

    public class Connection implements ServiceConnection {
        final Manager.ConnectionListener mListener;
        private IMeasurementPlaybackClient mService;

        public Connection(Manager.ConnectionListener connectionListener) {
            this.mListener = connectionListener;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (!ServiceUtil.isServiceNotAvailableBinder(iBinder)) {
                    IMeasurementPlaybackClient asInterface = IMeasurementPlaybackClient.Stub.asInterface(iBinder);
                    this.mService = asInterface;
                    MeasurementPlaybackClient.this.handleServiceConnected(asInterface);
                    Manager.ConnectionListener connectionListener = this.mListener;
                    if (connectionListener != null) {
                        connectionListener.onConnected();
                        return;
                    }
                    return;
                }
                throw new RemoteException("Service is not available");
            } catch (RemoteException unused) {
                synchronized (MeasurementPlaybackClient.this) {
                    if (MeasurementPlaybackClient.this.mConnection != null) {
                        MeasurementPlaybackClient.this.mContext.unbindService(this);
                        Connection unused2 = MeasurementPlaybackClient.this.mConnection = null;
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
            Log.v(MeasurementPlaybackClient.TAG, "onServiceDisconnected: %s", this.mService);
            IMeasurementPlaybackClient iMeasurementPlaybackClient = this.mService;
            if (iMeasurementPlaybackClient != null) {
                MeasurementPlaybackClient.this.handleServiceDisconnected(iMeasurementPlaybackClient);
                this.mService = null;
                Manager.ConnectionListener connectionListener = this.mListener;
                if (connectionListener != null) {
                    connectionListener.onDisconnected();
                }
            }
        }
    }

    public interface IPlaybackStateListener {
        void onPlaybackFinished(String str);

        void onPlaybackStarted(String str);
    }

    public class PlaybackReceiver extends BroadcastReceiver {
        private PlaybackReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Log.v(MeasurementPlaybackClient.TAG, "onReceive: %s", intent);
            final String stringExtra = intent.getStringExtra(MeasurementPlaybackClient.EXTRA_STR_FILENAME);
            final String action = intent.getAction();
            MeasurementPlaybackClient.this.mHandler.post(new Runnable() {
                public void run() {
                    IPlaybackStateListener iPlaybackStateListener;
                    synchronized (MeasurementPlaybackClient.this) {
                        iPlaybackStateListener = (IPlaybackStateListener) MeasurementPlaybackClient.this.mPlaybackListeners.get(stringExtra);
                    }
                    if (iPlaybackStateListener != null) {
                        if (MeasurementPlaybackClient.ACTION_PLAYBACK_BEGIN.equals(action)) {
                            Log.v(MeasurementPlaybackClient.TAG, "onPlaybackStarted: %s", stringExtra);
                            iPlaybackStateListener.onPlaybackStarted(stringExtra);
                        } else if (MeasurementPlaybackClient.ACTION_PLAYBACK_END.equals(action)) {
                            try {
                                Log.v(MeasurementPlaybackClient.TAG, "onPlaybackFinished: %s", stringExtra);
                                iPlaybackStateListener.onPlaybackFinished(stringExtra);
                            } finally {
                                MeasurementPlaybackClient.this.mPlaybackListeners.remove(stringExtra);
                            }
                        }
                    }
                }
            });
        }
    }

    public MeasurementPlaybackClient(Context context) {
        this.mContext = context;
    }

    private synchronized void bindService(Manager.ConnectionListener connectionListener) {
        Log.v(TAG, "bindService", new Object[0]);
        if (this.mConnection == null) {
            try {
                ServiceUtil.ServiceInfo serviceInfo = ServiceUtil.getServiceInfo(this.mContext);
                Intent intent = serviceInfo.getIntent();
                intent.setAction(IBoundService.ACTION_BIND_MEASUREMENT_PLAYBACK_SERVICE);
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
    public synchronized void handleServiceConnected(IMeasurementPlaybackClient iMeasurementPlaybackClient) {
        this.mClient = iMeasurementPlaybackClient;
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
    public synchronized void handleServiceDisconnected(IMeasurementPlaybackClient iMeasurementPlaybackClient) {
        if (iMeasurementPlaybackClient != null) {
            try {
                if (iMeasurementPlaybackClient.equals(this.mClient)) {
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

    private synchronized void registerBroadcastReceiver() {
        if (this.mPlaybackReceiver == null) {
            IntentFilter intentFilter = new IntentFilter(ACTION_PLAYBACK_BEGIN);
            intentFilter.addAction(ACTION_PLAYBACK_END);
            PlaybackReceiver playbackReceiver = new PlaybackReceiver();
            this.mPlaybackReceiver = playbackReceiver;
            this.mContext.registerReceiver(playbackReceiver, intentFilter, 4);
        }
    }

    public void connect(Manager.ConnectionListener connectionListener) {
        bindService(connectionListener);
        registerBroadcastReceiver();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void disconnect() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.List<java.lang.Runnable> r0 = r3.mPendingTasks     // Catch:{ all -> 0x003b }
            r0.clear()     // Catch:{ all -> 0x003b }
            java.util.Map<java.lang.String, com.here.services.playback.internal.MeasurementPlaybackClient$IPlaybackStateListener> r0 = r3.mPlaybackListeners     // Catch:{ all -> 0x003b }
            r0.clear()     // Catch:{ all -> 0x003b }
            com.here.services.playback.internal.MeasurementPlaybackClient$Connection r0 = r3.mConnection     // Catch:{ Exception -> 0x0043, all -> 0x0018 }
            r1 = 0
            if (r0 == 0) goto L_0x001a
            android.content.Context r2 = r3.mContext     // Catch:{ Exception -> 0x0043, all -> 0x0018 }
            r2.unbindService(r0)     // Catch:{ Exception -> 0x0043, all -> 0x0018 }
            r3.mConnection = r1     // Catch:{ Exception -> 0x0043, all -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            r0 = move-exception
            goto L_0x003d
        L_0x001a:
            android.content.BroadcastReceiver r0 = r3.mPlaybackReceiver     // Catch:{ Exception -> 0x0043, all -> 0x0018 }
            if (r0 == 0) goto L_0x0025
            android.content.Context r2 = r3.mContext     // Catch:{ Exception -> 0x0043, all -> 0x0018 }
            r2.unregisterReceiver(r0)     // Catch:{ Exception -> 0x0043, all -> 0x0018 }
            r3.mPlaybackReceiver = r1     // Catch:{ Exception -> 0x0043, all -> 0x0018 }
        L_0x0025:
            com.here.services.playback.internal.IMeasurementPlaybackClient r0 = r3.mClient     // Catch:{ Exception -> 0x0043, all -> 0x0018 }
            if (r0 == 0) goto L_0x0035
            com.here.services.playback.internal.IMeasurementPlaybackClient r0 = r3.mClient     // Catch:{ RemoteException -> 0x002e, all -> 0x0031 }
            r0.unBind()     // Catch:{ RemoteException -> 0x002e, all -> 0x0031 }
        L_0x002e:
            r3.mClient = r1     // Catch:{ Exception -> 0x0043, all -> 0x0018 }
            goto L_0x0035
        L_0x0031:
            r0 = move-exception
            r3.mClient = r1     // Catch:{ Exception -> 0x0043, all -> 0x0018 }
            throw r0     // Catch:{ Exception -> 0x0043, all -> 0x0018 }
        L_0x0035:
            android.os.HandlerThread r0 = r3.mHandlerThread     // Catch:{ all -> 0x003b }
        L_0x0037:
            r0.quit()     // Catch:{ all -> 0x003b }
            goto L_0x0046
        L_0x003b:
            r0 = move-exception
            goto L_0x0048
        L_0x003d:
            android.os.HandlerThread r1 = r3.mHandlerThread     // Catch:{ all -> 0x003b }
            r1.quit()     // Catch:{ all -> 0x003b }
            throw r0     // Catch:{ all -> 0x003b }
        L_0x0043:
            android.os.HandlerThread r0 = r3.mHandlerThread     // Catch:{ all -> 0x003b }
            goto L_0x0037
        L_0x0046:
            monitor-exit(r3)
            return
        L_0x0048:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.services.playback.internal.MeasurementPlaybackClient.disconnect():void");
    }

    public boolean initialize() {
        this.mHandlerThread.start();
        if (this.mHandlerThread.getLooper() == null) {
            return false;
        }
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        return true;
    }

    public boolean startNetworkMeasurementPlayback(final IPlaybackStateListener iPlaybackStateListener, final PlaybackOptions playbackOptions) {
        Log.v(TAG, "startNetworkMeasurementPlayback options: %s", playbackOptions);
        return postTask(new Runnable() {
            public void run() {
                try {
                    synchronized (MeasurementPlaybackClient.this) {
                        if (!MeasurementPlaybackClient.this.isBinderAlive()) {
                            Log.w(MeasurementPlaybackClient.TAG, "startNetworkMeasurementPlayback: Service was disconnected -> ignored.", new Object[0]);
                            return;
                        }
                        MeasurementPlaybackClient.this.mPlaybackListeners.put(playbackOptions.getPlaybackFile().getAbsolutePath(), iPlaybackStateListener);
                        MeasurementPlaybackClient.this.mClient.startNetworkMeasurementPlayback(playbackOptions.asBundle());
                    }
                } catch (RemoteException unused) {
                    MeasurementPlaybackClient.this.mPlaybackListeners.remove(playbackOptions.getPlaybackFile().getAbsolutePath());
                } catch (Throwable th) {
                    throw th;
                }
            }
        });
    }

    public boolean startSimulation(final TestTrackSimulationApi.Listener listener, final Bundle bundle) {
        Log.v(TAG, "startSimulation options: %s", bundle);
        return postTask(new Runnable() {
            public void run() {
                try {
                    synchronized (MeasurementPlaybackClient.this) {
                        if (!MeasurementPlaybackClient.this.isBinderAlive()) {
                            Log.w(MeasurementPlaybackClient.TAG, "startSimulation: Service was disconnected -> ignored.", new Object[0]);
                        } else {
                            MeasurementPlaybackClient.this.mClient.startSimulation(new ITestTrackSimulationListener.Stub() {
                                final List<Location> mLocations = new ArrayList();

                                public void onFinished(int i, Bundle bundle, boolean z) throws RemoteException {
                                    List<Location> locations = SimulationResult.fromBundle(bundle).getLocations();
                                    if (locations != null) {
                                        this.mLocations.addAll(locations);
                                    }
                                    Log.i(MeasurementPlaybackClient.TAG, "onFinished: size: %d moreData: %s", Integer.valueOf(this.mLocations.size()), Boolean.valueOf(z));
                                    if (!z) {
                                        listener.onFinished(Status.fromInt(i), new SimulationResult().setLocations(this.mLocations));
                                    }
                                }

                                public void onProgressUpdated(int i) throws RemoteException {
                                    listener.onProgressUpdated(i);
                                }
                            }, bundle);
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }
        });
    }

    public synchronized void stopNetworkMeasurementPlayback() {
        if (!postTask(new Runnable() {
            public void run() {
                try {
                    synchronized (MeasurementPlaybackClient.this) {
                        if (!MeasurementPlaybackClient.this.isBinderAlive()) {
                            Log.w(MeasurementPlaybackClient.TAG, "stopNetworkMeasurementPlayback: Service was disconnected -> ignored.", new Object[0]);
                            return;
                        }
                        MeasurementPlaybackClient.this.mClient.stopNetworkMeasurementPlayback();
                        MeasurementPlaybackClient.this.mPlaybackListeners.clear();
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }
        })) {
            Log.e(TAG, "stopNetworkMeasurementPlayback: postTask failed", new Object[0]);
        }
    }

    public void stopSimulation() {
        Log.v(TAG, "stopSimulation", new Object[0]);
        if (!postTask(new Runnable() {
            public void run() {
                try {
                    synchronized (MeasurementPlaybackClient.this) {
                        if (!MeasurementPlaybackClient.this.isBinderAlive()) {
                            Log.w(MeasurementPlaybackClient.TAG, "stopSimulation: Service was disconnected -> ignored.", new Object[0]);
                        } else {
                            MeasurementPlaybackClient.this.mClient.stopSimulation();
                        }
                    }
                } catch (RemoteException unused) {
                } catch (Throwable th) {
                    throw th;
                }
            }
        })) {
            Log.e(TAG, "stopSimulation: post task failed", new Object[0]);
        }
    }

    public boolean startNetworkMeasurementPlayback(int i, String str) {
        Log.v(TAG, "startNetworkMeasurementPlayback technologies: %d, absoluteFilename: '%s'", Integer.valueOf(i), str);
        return startNetworkMeasurementPlayback(new IPlaybackStateListener() {
            public void onPlaybackFinished(String str) {
                Log.i(MeasurementPlaybackClient.TAG, "onPlaybackFinished: %s", str);
            }

            public void onPlaybackStarted(String str) {
                Log.i(MeasurementPlaybackClient.TAG, "onPlaybackStarted: %s", str);
            }
        }, i, str);
    }

    public synchronized boolean startNetworkMeasurementPlayback(IPlaybackStateListener iPlaybackStateListener, int i, String str) {
        PlaybackOptions playbackOptions;
        Log.v(TAG, "startNetworkMeasurementPlayback technologies: %d, absoluteFilename: '%s'", Integer.valueOf(i), str);
        playbackOptions = new PlaybackOptions();
        try {
            playbackOptions.setPlaybackFile(str).setTechnologies(i);
        } catch (FileNotFoundException unused) {
            return false;
        }
        return startNetworkMeasurementPlayback(iPlaybackStateListener, playbackOptions);
    }
}
