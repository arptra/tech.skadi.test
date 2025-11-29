package com.here.services.location.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.here.odnp.util.Log;
import com.here.odnp.util.SafeHandler;
import com.here.posclient.PositioningFeature;
import com.here.posclient.Status;
import com.here.posclient.UpdateOptions;
import com.here.posclient.sensors.GeneralActivityResult;
import com.here.services.common.PositioningError;
import com.here.services.common.Types;
import com.here.services.internal.IBoundService;
import com.here.services.internal.Manager;
import com.here.services.internal.ServiceUtil;
import com.here.services.location.internal.IPositioning;
import com.here.services.location.internal.IPositioningClient;
import com.here.services.location.internal.PositionListener;
import com.here.services.location.util.LocationHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;

public class PositioningClient implements IPositioning {
    private static final long HD_GNSS_JITTER_PERCENTAGE = 50;
    private static final long JITTER_PERCENTAGE = 10;
    private static final long MAX_JITTER = TimeUnit.SECONDS.toMillis(1);
    private static final String TAG = "services.location.internal.PositioningClient";
    private IPositioningClient mClient;
    private Options mCombinedOptions;
    /* access modifiers changed from: private */
    public Connection mConnection;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final SafeHandler mHandler;
    private final HandlerThread mHandlerThread;
    private final PositionListener.Stub mListener = new PositionListener.Stub() {
        public void onOptionsChanged(UpdateOptions updateOptions, UpdateOptions updateOptions2) throws RemoteException {
            PositioningClient.this.handleOptionsChanged(updateOptions, updateOptions2);
        }

        public void onPositionInfoChanged(PositioningError positioningError) throws RemoteException {
            PositioningClient.this.handlePositionInfo(positioningError);
        }

        public void onPositionResolvingFailed(PositioningError positioningError) throws RemoteException {
            PositioningClient.this.handlePositionResolvingFailed(positioningError);
        }

        public void onPositionUpdate(Location location) throws RemoteException {
            PositioningClient.this.handlePositionUpdate(location);
        }
    };
    /* access modifiers changed from: private */
    public final Map<IPositioning.IPositionListener, PositionRequest> mPositionRequests = new HashMap();

    public class Connection implements ServiceConnection {
        final Manager.ConnectionListener mListener;
        private IPositioningClient mService;

        public Connection(Manager.ConnectionListener connectionListener) {
            this.mListener = connectionListener;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (!ServiceUtil.isServiceNotAvailableBinder(iBinder)) {
                    IPositioningClient asInterface = IPositioningClient.Stub.asInterface(iBinder);
                    this.mService = asInterface;
                    PositioningClient.this.handleServiceConnected(asInterface);
                    Manager.ConnectionListener connectionListener = this.mListener;
                    if (connectionListener != null) {
                        connectionListener.onConnected();
                        return;
                    }
                    return;
                }
                throw new RemoteException("service is not available");
            } catch (RemoteException unused) {
                synchronized (PositioningClient.this) {
                    if (PositioningClient.this.mConnection != null) {
                        PositioningClient.this.mContext.unbindService(this);
                        Connection unused2 = PositioningClient.this.mConnection = null;
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
            Log.v(PositioningClient.TAG, "onServiceDisconnected: %s", this.mService);
            IPositioningClient iPositioningClient = this.mService;
            if (iPositioningClient != null) {
                PositioningClient.this.handleServiceDisconnected(iPositioningClient);
                this.mService = null;
                Manager.ConnectionListener connectionListener = this.mListener;
                if (connectionListener != null) {
                    connectionListener.onDisconnected();
                }
            }
        }
    }

    public static class InjectPositionRequest implements PositionRequest {
        private final IPositioning.IPositionListener mListener;

        public InjectPositionRequest(IPositioning.IPositionListener iPositionListener) {
            this.mListener = iPositionListener;
        }

        public Options getOptions() {
            return null;
        }

        public void offerPositionUpdate(Location location) {
            this.mListener.onPositionUpdate(location);
        }

        public void optionsChanged(UpdateOptions updateOptions, UpdateOptions updateOptions2) {
            this.mListener.onOptionsChanged(updateOptions, updateOptions2);
        }

        public void positionInfoChanged(PositioningError positioningError) {
            this.mListener.onPositionInfoChanged(positioningError);
        }

        public void positionResolvingFailed(PositioningError positioningError) {
            this.mListener.onPositionResolvingFailed(positioningError);
        }

        public void sessionClosed() {
            this.mListener.onSessionClosed();
        }

        public void update(Options options) {
        }
    }

    public static class NlpPositionRequest implements PositionRequest {
        private final IPositioning.IPositionListener mListener;
        private long mNextUpdateTime;
        private Options mOptions;

        public NlpPositionRequest(Options options, IPositioning.IPositionListener iPositionListener) {
            this.mListener = iPositionListener;
            update(options);
        }

        public Options getOptions() {
            return this.mOptions;
        }

        public void offerPositionUpdate(Location location) {
            if (this.mNextUpdateTime <= SystemClock.elapsedRealtime()) {
                this.mNextUpdateTime = PositioningClient.getJitterAdjustedUpdateTime(this.mOptions.getSmallestUpdateInterval(), (location == null || !LocationHelper.getSources(location).contains(Types.Source.HDGnss)) ? PositioningClient.JITTER_PERCENTAGE : PositioningClient.HD_GNSS_JITTER_PERCENTAGE);
                this.mListener.onPositionUpdate(location);
                return;
            }
            Log.v(PositioningClient.TAG, "offerPositionUpdate: update rejected", new Object[0]);
        }

        public void optionsChanged(UpdateOptions updateOptions, UpdateOptions updateOptions2) {
            this.mListener.onOptionsChanged(updateOptions, updateOptions2);
        }

        public void positionInfoChanged(PositioningError positioningError) {
            this.mListener.onPositionInfoChanged(positioningError);
        }

        public void positionResolvingFailed(PositioningError positioningError) {
            this.mListener.onPositionResolvingFailed(positioningError);
        }

        public void sessionClosed() {
            this.mListener.onSessionClosed();
        }

        public void update(Options options) {
            this.mOptions = options;
            this.mNextUpdateTime = SystemClock.elapsedRealtime();
        }
    }

    public interface PositionRequest {
        Options getOptions();

        void offerPositionUpdate(Location location);

        void optionsChanged(UpdateOptions updateOptions, UpdateOptions updateOptions2);

        void positionInfoChanged(PositioningError positioningError);

        void positionResolvingFailed(PositioningError positioningError);

        void sessionClosed();

        void update(Options options);
    }

    private PositioningClient(Context context) {
        HandlerThread handlerThread = new HandlerThread("PosCln@" + hashCode());
        this.mHandlerThread = handlerThread;
        Log.v(TAG, "PositioningClient", new Object[0]);
        if (context != null) {
            this.mContext = context;
            handlerThread.start();
            this.mHandler = new SafeHandler(handlerThread.getLooper());
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    private void addInjectPositionRequest(IPositioning.IPositionListener iPositionListener) {
        if (this.mPositionRequests.get(iPositionListener) == null) {
            this.mPositionRequests.put(iPositionListener, new InjectPositionRequest(iPositionListener));
        }
    }

    private Options addNlpPositionRequest(Options options, IPositioning.IPositionListener iPositionListener) {
        PositionRequest positionRequest = this.mPositionRequests.get(iPositionListener);
        if (positionRequest == null) {
            this.mPositionRequests.put(iPositionListener, new NlpPositionRequest(options, iPositionListener));
        } else {
            positionRequest.update(options);
        }
        return getCombinedRequestOptions();
    }

    private synchronized void bindService(Manager.ConnectionListener connectionListener) {
        Log.v(TAG, "bindService", new Object[0]);
        if (this.mConnection == null) {
            try {
                Intent intent = ServiceUtil.getServiceInfo(this.mContext).getIntent();
                intent.setAction(IBoundService.ACTION_BIND_LOCATION_SERVICE);
                Connection connection = new Connection(connectionListener);
                this.mConnection = connection;
                if (!this.mContext.bindService(intent, connection, 64)) {
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

    private Options getCombinedRequestOptions() {
        Options options = new Options();
        if (this.mPositionRequests.isEmpty()) {
            return options;
        }
        long j = LongCompanionObject.MAX_VALUE;
        Long l = null;
        Long l2 = null;
        Long l3 = null;
        long j2 = Long.MAX_VALUE;
        for (PositionRequest next : this.mPositionRequests.values()) {
            if (next.getOptions() != null) {
                UpdateOptions updateOptions = next.getOptions().getUpdateOptions();
                options.getUpdateOptions().setAlwaysUseRequestedOptions(updateOptions.alwaysUseRequestedOptions);
                options.getUpdateOptions().setIgnoredFreeTechnologies(updateOptions.ignoredFreeTechnologies);
                if (updateOptions.clearDataItems != 0) {
                    options.getUpdateOptions().setClearDataItems(updateOptions.clearDataItems);
                }
                long j3 = updateOptions.desiredUpdateInterval;
                if (j3 < j) {
                    j = j3;
                }
                long j4 = updateOptions.smallestUpdateInterval;
                if (j4 < j2) {
                    j2 = j4;
                }
                if (updateOptions.allowedSourcesSet) {
                    l = l == null ? Long.valueOf(updateOptions.allowedSources) : Long.valueOf(l.longValue() | updateOptions.allowedSources);
                }
                if (updateOptions.allowedTechnologiesSet) {
                    l2 = l2 == null ? Long.valueOf(updateOptions.allowedTechnologies) : Long.valueOf(l2.longValue() | updateOptions.allowedTechnologies);
                }
                if (updateOptions.optionsSet) {
                    l3 = l3 == null ? Long.valueOf(updateOptions.options) : Long.valueOf(updateOptions.options | l3.longValue());
                }
            }
        }
        options.setDesiredUpdateInterval(j);
        options.setSmallestUpdateInterval(j2);
        if (l != null) {
            options.setAllowedSources(l.longValue());
        }
        if (l2 != null) {
            options.setAllowedTechnologies(l2.longValue());
        }
        if (l3 != null) {
            options.setOptions(l3.longValue());
        }
        return options;
    }

    /* access modifiers changed from: private */
    public static long getJitterAdjustedUpdateTime(long j, long j2) {
        long min = Math.min((j2 * j) / 100, MAX_JITTER);
        Log.v(TAG, "getJitterAdjustedUpdateTime: jitter: %d ms", Long.valueOf(min));
        return Math.max(0, (SystemClock.elapsedRealtime() + j) - min);
    }

    /* access modifiers changed from: private */
    public void handleOptionsChanged(final UpdateOptions updateOptions, final UpdateOptions updateOptions2) {
        Log.v(TAG, "handleOptionsChanged", new Object[0]);
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                synchronized (PositioningClient.this) {
                    try {
                        for (PositionRequest optionsChanged : PositioningClient.this.mPositionRequests.values()) {
                            optionsChanged.optionsChanged(updateOptions, updateOptions2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        })) {
            Log.e(TAG, "handleOptionsChanged: Handler.post() failed", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void handlePositionInfo(final PositioningError positioningError) {
        Log.v(TAG, "handlePositionInfo: %s", positioningError);
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                synchronized (PositioningClient.this) {
                    try {
                        for (PositionRequest positionInfoChanged : PositioningClient.this.mPositionRequests.values()) {
                            positionInfoChanged.positionInfoChanged(positioningError);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        })) {
            Log.e(TAG, "handlePositionInfo: Handler.post() failed", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void handlePositionResolvingFailed(final PositioningError positioningError) {
        if (!this.mHandler.post(new Runnable() {
            public void run() {
                synchronized (PositioningClient.this) {
                    try {
                        for (PositionRequest positionResolvingFailed : PositioningClient.this.mPositionRequests.values()) {
                            positionResolvingFailed.positionResolvingFailed(positioningError);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        })) {
            Log.e(TAG, "handlePositionUpdate: Handler.post() failed", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void handlePositionUpdate(final Location location) {
        if (location == null) {
            Log.w(TAG, "handlePositionUpdate: null position -> update ignored", new Object[0]);
        } else if (!location.hasAccuracy()) {
            Log.w(TAG, "handlePositionUpdate: position has no accuracy -> update ignored", new Object[0]);
        } else {
            if (!this.mHandler.post(new Runnable() {
                public void run() {
                    synchronized (PositioningClient.this) {
                        try {
                            for (PositionRequest offerPositionUpdate : PositioningClient.this.mPositionRequests.values()) {
                                offerPositionUpdate.offerPositionUpdate(location);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            })) {
                Log.e(TAG, "handlePositionUpdate: Handler.post() failed", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void handleServiceConnected(IPositioningClient iPositioningClient) {
        Log.v(TAG, "handleServiceConnected", new Object[0]);
        this.mClient = iPositioningClient;
        if (iPositioningClient != null) {
            if (!this.mPositionRequests.isEmpty()) {
                try {
                    Log.v(TAG, "handleServiceConnected: scheduling pending requests to service", new Object[0]);
                    this.mClient.startPositionUpdates(this.mCombinedOptions.getUpdateOptionsAsBundle(), this.mListener);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void handleServiceDisconnected(IPositioningClient iPositioningClient) {
        if (iPositioningClient != null) {
            try {
                if (iPositioningClient.equals(this.mClient)) {
                    this.mClient = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        disconnect();
    }

    public static IPositioning open(Context context) {
        Log.v(TAG, "open", new Object[0]);
        return new PositioningClient(context);
    }

    private Options removePositionRequest(IPositioning.IPositionListener iPositionListener) {
        this.mPositionRequests.remove(iPositionListener);
        return getCombinedRequestOptions();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:14|15|16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        return (int) com.here.posclient.PositioningFeature.None.value;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int availableFeatures() {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0016 }
            java.lang.String r1 = "services.location.internal.PositioningClient"
            java.lang.String r2 = "availableFeatures"
            com.here.odnp.util.Log.v(r1, r2, r0)     // Catch:{ all -> 0x0016 }
            com.here.services.location.internal.IPositioningClient r0 = r3.mClient     // Catch:{ all -> 0x0016 }
            if (r0 != 0) goto L_0x0018
            com.here.posclient.PositioningFeature r0 = com.here.posclient.PositioningFeature.None     // Catch:{ all -> 0x0016 }
            long r0 = r0.value     // Catch:{ all -> 0x0016 }
            int r0 = (int) r0
            monitor-exit(r3)
            return r0
        L_0x0016:
            r0 = move-exception
            goto L_0x0025
        L_0x0018:
            int r0 = r0.availableFeatures()     // Catch:{ RemoteException -> 0x001e }
            monitor-exit(r3)
            return r0
        L_0x001e:
            com.here.posclient.PositioningFeature r0 = com.here.posclient.PositioningFeature.None     // Catch:{ all -> 0x0016 }
            long r0 = r0.value     // Catch:{ all -> 0x0016 }
            int r0 = (int) r0
            monitor-exit(r3)
            return r0
        L_0x0025:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.services.location.internal.PositioningClient.availableFeatures():int");
    }

    public synchronized void clearPositioningData() {
        IPositioningClient iPositioningClient = this.mClient;
        if (iPositioningClient != null) {
            try {
                iPositioningClient.clearPositioningData();
            } catch (RemoteException unused) {
            }
        }
    }

    public synchronized void close() {
        try {
            Log.v(TAG, "close", new Object[0]);
            Connection connection = this.mConnection;
            if (connection != null) {
                this.mContext.unbindService(connection);
                this.mConnection = null;
            }
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

    /* JADX WARNING: Can't wrap try/catch for region: R(5:14|15|16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        return (int) com.here.posclient.PositioningFeature.None.value;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int enabledFeatures() {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0016 }
            java.lang.String r1 = "services.location.internal.PositioningClient"
            java.lang.String r2 = "enabledFeatures"
            com.here.odnp.util.Log.v(r1, r2, r0)     // Catch:{ all -> 0x0016 }
            com.here.services.location.internal.IPositioningClient r0 = r3.mClient     // Catch:{ all -> 0x0016 }
            if (r0 != 0) goto L_0x0018
            com.here.posclient.PositioningFeature r0 = com.here.posclient.PositioningFeature.None     // Catch:{ all -> 0x0016 }
            long r0 = r0.value     // Catch:{ all -> 0x0016 }
            int r0 = (int) r0
            monitor-exit(r3)
            return r0
        L_0x0016:
            r0 = move-exception
            goto L_0x0025
        L_0x0018:
            int r0 = r0.enabledFeatures()     // Catch:{ RemoteException -> 0x001e }
            monitor-exit(r3)
            return r0
        L_0x001e:
            com.here.posclient.PositioningFeature r0 = com.here.posclient.PositioningFeature.None     // Catch:{ all -> 0x0016 }
            long r0 = r0.value     // Catch:{ all -> 0x0016 }
            int r0 = (int) r0
            monitor-exit(r3)
            return r0
        L_0x0025:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.services.location.internal.PositioningClient.enabledFeatures():int");
    }

    public synchronized Location getLastPosition() {
        Log.v(TAG, "getLastPosition", new Object[0]);
        IPositioningClient iPositioningClient = this.mClient;
        if (iPositioningClient == null) {
            return null;
        }
        try {
            return iPositioningClient.getLastPosition();
        } catch (RemoteException | SecurityException unused) {
            return null;
        }
    }

    public synchronized boolean injectActivity(GeneralActivityResult generalActivityResult) {
        Log.v(TAG, "injectActivity", new Object[0]);
        IPositioningClient iPositioningClient = this.mClient;
        if (iPositioningClient != null) {
            try {
                iPositioningClient.injectActivity(generalActivityResult);
                return true;
            } catch (RemoteException unused) {
                return false;
            }
        }
    }

    public synchronized boolean injectLocation(Location location) {
        Log.v(TAG, "injectLocation", new Object[0]);
        IPositioningClient iPositioningClient = this.mClient;
        if (iPositioningClient != null) {
            try {
                iPositioningClient.injectLocation(location);
                return true;
            } catch (RemoteException unused) {
                return false;
            }
        }
    }

    public synchronized boolean requestSingleUpdate(Options options, final IPositioning.IPositionListener iPositionListener) {
        Log.v(TAG, "requestSingleUpdate", new Object[0]);
        IPositioningClient iPositioningClient = this.mClient;
        if (iPositioningClient != null) {
            try {
                iPositioningClient.requestSingleUpdate(options.getUpdateOptionsAsBundle(), new PositionListener.Stub() {
                    public void onOptionsChanged(final UpdateOptions updateOptions, final UpdateOptions updateOptions2) throws RemoteException {
                        Log.v(PositioningClient.TAG, "requestSingleUpdate.onOptionsChanged", new Object[0]);
                        if (!PositioningClient.this.mHandler.post(new Runnable() {
                            public void run() {
                                iPositionListener.onOptionsChanged(updateOptions, updateOptions2);
                            }
                        })) {
                            Log.w(PositioningClient.TAG, "requestSingleUpdate.onOptionsChanged: handler post failed, calling directly", new Object[0]);
                            iPositionListener.onOptionsChanged(updateOptions, updateOptions2);
                        }
                    }

                    public void onPositionInfoChanged(final PositioningError positioningError) throws RemoteException {
                        Log.v(PositioningClient.TAG, "requestSingleUpdate.onPositionInfoChanged: %s", positioningError);
                        if (!PositioningClient.this.mHandler.post(new Runnable() {
                            public void run() {
                                iPositionListener.onPositionInfoChanged(positioningError);
                            }
                        })) {
                            Log.w(PositioningClient.TAG, "requestSingleUpdate.onPositionInfoChanged: handler post failed, calling directly", new Object[0]);
                            iPositionListener.onPositionInfoChanged(positioningError);
                        }
                    }

                    public void onPositionResolvingFailed(final PositioningError positioningError) throws RemoteException {
                        Log.v(PositioningClient.TAG, "requestSingleUpdate.onPositionResolvingFailed: %s", positioningError);
                        if (!PositioningClient.this.mHandler.post(new Runnable() {
                            public void run() {
                                iPositionListener.onPositionResolvingFailed(positioningError);
                            }
                        })) {
                            Log.w(PositioningClient.TAG, "requestSingleUpdate.onPositionResolvingFailed: handler post failed, calling directly", new Object[0]);
                            iPositionListener.onPositionResolvingFailed(positioningError);
                        }
                    }

                    public void onPositionUpdate(final Location location) throws RemoteException {
                        Log.v(PositioningClient.TAG, "requestSingleUpdate.onPositionUpdate", new Object[0]);
                        if (location == null) {
                            onPositionResolvingFailed(new PositioningError(Status.GeneralError));
                        } else if (!location.hasAccuracy()) {
                            onPositionResolvingFailed(new PositioningError(Status.GeneralError));
                        } else {
                            if (!PositioningClient.this.mHandler.post(new Runnable() {
                                public void run() {
                                    iPositionListener.onPositionUpdate(location);
                                }
                            })) {
                                Log.w(PositioningClient.TAG, "requestSingleUpdate.onPositionUpdate: handler post failed, calling directly", new Object[0]);
                                iPositionListener.onPositionUpdate(location);
                            }
                        }
                    }
                });
            } catch (RemoteException unused) {
                return false;
            }
        }
        return true;
    }

    public synchronized boolean startInjectionUpdates(IPositioning.IPositionListener iPositionListener) {
        Log.v(TAG, "startInjectionUpdates", new Object[0]);
        addInjectPositionRequest(iPositionListener);
        IPositioningClient iPositioningClient = this.mClient;
        if (iPositioningClient != null) {
            try {
                iPositioningClient.startInjectionUpdates(this.mListener);
                return true;
            } catch (RemoteException unused) {
                return false;
            }
        }
    }

    public synchronized boolean startPositionUpdates(Options options, IPositioning.IPositionListener iPositionListener) {
        try {
            Log.v(TAG, "startPositionUpdates", new Object[0]);
            boolean isEmpty = this.mPositionRequests.isEmpty();
            Options addNlpPositionRequest = addNlpPositionRequest(options, iPositionListener);
            if (!isEmpty) {
                if (!addNlpPositionRequest.isEqual(this.mCombinedOptions)) {
                }
            }
            this.mCombinedOptions = addNlpPositionRequest;
            IPositioningClient iPositioningClient = this.mClient;
            if (iPositioningClient != null) {
                try {
                    iPositioningClient.startPositionUpdates(addNlpPositionRequest.getUpdateOptionsAsBundle(), this.mListener);
                } catch (RemoteException unused) {
                    return false;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }

    public synchronized void stopPositionUpdates(IPositioning.IPositionListener iPositionListener) {
        Log.v(TAG, "stopPositionUpdates", new Object[0]);
        Options removePositionRequest = removePositionRequest(iPositionListener);
        if (this.mClient != null) {
            if (this.mPositionRequests.isEmpty()) {
                try {
                    Log.i(TAG, "stopPositionUpdates: last client -> stopping all updates", new Object[0]);
                    this.mClient.stopPositionUpdates(this.mListener);
                } catch (RemoteException unused) {
                }
            } else if (!removePositionRequest.isEqual(this.mCombinedOptions)) {
                try {
                    Log.i(TAG, "stopPositionUpdates: clients left -> updating options", new Object[0]);
                    this.mClient.startPositionUpdates(this.mCombinedOptions.getUpdateOptionsAsBundle(), this.mListener);
                } catch (RemoteException e) {
                    Log.e(TAG, "startPositionUpdates: error: %s", Log.getStackTraceString(e));
                }
            }
        }
        this.mCombinedOptions = removePositionRequest;
    }

    public synchronized void toggleFeature(PositioningFeature positioningFeature, boolean z) {
        IPositioningClient iPositioningClient = this.mClient;
        if (iPositioningClient != null) {
            try {
                iPositioningClient.toggleFeature(positioningFeature.name(), z);
            } catch (RemoteException unused) {
            }
        }
    }
}
