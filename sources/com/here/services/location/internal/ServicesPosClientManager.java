package com.here.services.location.internal;

import android.location.Location;
import android.os.Handler;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.posclient.pos.IPositioningSession;
import com.here.odnp.util.DeviceMonitor;
import com.here.odnp.util.Log;
import com.here.odnp.util.MasterThread;
import com.here.posclient.PositioningFeature;
import com.here.posclient.Status;
import com.here.posclient.UpdateOptions;
import com.here.posclient.sensors.GeneralActivityResult;
import com.here.services.common.PositioningError;
import com.here.services.common.Types;
import com.here.services.location.util.LocationHelper;
import com.here.services.util.HereServicesUtil;
import java.util.concurrent.atomic.AtomicInteger;

public class ServicesPosClientManager implements ISdkPosClientManager {
    private static final long MONITOR_CHANGE_BATCH_DELAY = 1000;
    private static final String TAG = "services.location.internal.ServicesPosClientManager";
    private final ListenerProxy mListenerProxy;
    /* access modifiers changed from: private */
    public final IPosClientManager mPosClientManager;
    /* access modifiers changed from: private */
    public IPositioningSession mPositioning;

    public class ListenerProxy implements IPositioningSession.ILocationListener, DeviceMonitor.Listener {
        UpdateOptions mEffectiveOptions;
        final Handler mHandler;
        final IPositioningSession.ILocationListener mListener;
        DeviceMonitor mMonitor;
        Runnable mOnCompletedCallback = new Runnable() {
            public void run() {
            }
        };
        Runnable mOptionsChangedTask;
        UpdateOptions mReducedRequestedOptions;
        UpdateOptions mRequestedOptions;

        public class OptionsChangedTask implements Runnable {
            UpdateOptions mPreviousEffectiveOptions;
            UpdateOptions mPreviousReducedRequestOptions;

            public OptionsChangedTask() {
            }

            public void run() {
                IPositioningSession access$000;
                Log.v(ServicesPosClientManager.TAG, "OptionsChangedTask.run", new Object[0]);
                if (!ListenerProxy.this.mEffectiveOptions.isEqual(this.mPreviousEffectiveOptions)) {
                    this.mPreviousEffectiveOptions = new UpdateOptions(ListenerProxy.this.mEffectiveOptions);
                    ListenerProxy listenerProxy = ListenerProxy.this;
                    listenerProxy.onOptionsChanged(listenerProxy.mRequestedOptions, listenerProxy.mEffectiveOptions);
                } else {
                    Log.v(ServicesPosClientManager.TAG, "OptionsChangedTask.run: No change in effective options", new Object[0]);
                }
                if (!ListenerProxy.this.mReducedRequestedOptions.isEqual(this.mPreviousReducedRequestOptions)) {
                    this.mPreviousReducedRequestOptions = new UpdateOptions(ListenerProxy.this.mReducedRequestedOptions);
                    synchronized (ServicesPosClientManager.this) {
                        access$000 = ServicesPosClientManager.this.mPositioning;
                    }
                    ListenerProxy listenerProxy2 = ListenerProxy.this;
                    ServicesPosClientManager.this.onSetUpdateOptions(access$000, listenerProxy2.mReducedRequestedOptions);
                    return;
                }
                Log.v(ServicesPosClientManager.TAG, "OptionsChangedTask.run: No change in request options", new Object[0]);
            }
        }

        public ListenerProxy(IPositioningSession.ILocationListener iLocationListener) {
            this.mListener = iLocationListener;
            this.mHandler = new Handler(MasterThread.getInstance().getLooper());
            this.mOptionsChangedTask = new OptionsChangedTask();
        }

        private UpdateOptions buildEffectiveOptions(UpdateOptions updateOptions) {
            UpdateOptions updateOptions2 = new UpdateOptions(updateOptions);
            if (!HereServicesUtil.isNetworkLocationEnabled(ServicesPosClientManager.this.mPosClientManager.getContext())) {
                updateOptions2.disableSources(22);
                updateOptions2.disableOptions(15);
            }
            if (!HereServicesUtil.isGpsLocationEnabled(ServicesPosClientManager.this.mPosClientManager.getContext())) {
                updateOptions2.disableSources(64);
                updateOptions2.disableSources(1024);
                updateOptions2.disableTechnologies(1);
            }
            if (!HereServicesUtil.isPhoneEnabled(ServicesPosClientManager.this.mPosClientManager.getContext())) {
                updateOptions2.disableTechnologies(12);
            }
            if (!HereServicesUtil.isWifiScanEnabled(ServicesPosClientManager.this.mPosClientManager.getContext())) {
                updateOptions2.disableTechnologies(2);
            }
            return updateOptions2;
        }

        private UpdateOptions buildReducedOptions(UpdateOptions updateOptions) {
            UpdateOptions updateOptions2 = new UpdateOptions(updateOptions);
            if (!HereServicesUtil.isNetworkLocationEnabled(ServicesPosClientManager.this.mPosClientManager.getContext())) {
                updateOptions2.disableSources(22);
                updateOptions2.disableOptions(15);
            }
            if (!HereServicesUtil.isGpsLocationEnabled(ServicesPosClientManager.this.mPosClientManager.getContext())) {
                updateOptions2.disableSources(64);
                updateOptions2.disableSources(1024);
                updateOptions2.disableTechnologies(1);
            }
            return updateOptions2;
        }

        private DeviceMonitor createDeviceMonitor(UpdateOptions updateOptions) {
            DeviceMonitor.Builder builder = new DeviceMonitor.Builder(ServicesPosClientManager.this.mPosClientManager.getContext(), this);
            if (updateOptions.isSourceAllowed(2) || updateOptions.isSourceAllowed(4) || updateOptions.isSourceAllowed(16)) {
                builder.setMonitorNetworkLocation(true);
                builder.setMonitorWifi(updateOptions.isTechnologyAllowed(2));
            }
            if (updateOptions.isSourceAllowed(2) || updateOptions.isSourceAllowed(4) || updateOptions.isSourceAllowed(16)) {
                builder.setMonitorCell(updateOptions.isTechnologyAllowed(12));
            }
            if (updateOptions.isSourceAllowed(64) || updateOptions.isSourceAllowed(1024)) {
                builder.setMonitorGps(updateOptions.isTechnologyAllowed(1));
            }
            return builder.build();
        }

        private void reportRequestCompleted() {
            Log.v(ServicesPosClientManager.TAG, "reportRequestCompleted", new Object[0]);
            Runnable runnable = this.mOnCompletedCallback;
            this.mOnCompletedCallback = null;
            if (runnable != null) {
                runnable.run();
            }
        }

        private void startMonitoring() {
            DeviceMonitor deviceMonitor = this.mMonitor;
            if (deviceMonitor != null) {
                deviceMonitor.startMonitoring();
            }
        }

        private void stopMonitoring() {
            DeviceMonitor deviceMonitor = this.mMonitor;
            if (deviceMonitor != null) {
                deviceMonitor.stopMonitoring();
                this.mMonitor = null;
            }
        }

        public void close() {
            this.mHandler.removeCallbacks(this.mOptionsChangedTask);
            this.mOptionsChangedTask = null;
            stopMonitoring();
        }

        public UpdateOptions getEffectiveOptions() {
            return this.mEffectiveOptions;
        }

        public UpdateOptions getRequestedOptions() {
            UpdateOptions updateOptions = this.mRequestedOptions;
            return (updateOptions == null || !updateOptions.alwaysUseRequestedOptions) ? this.mReducedRequestedOptions : updateOptions;
        }

        public void onClosed() {
            synchronized (ServicesPosClientManager.this) {
                IPositioningSession unused = ServicesPosClientManager.this.mPositioning = null;
            }
            this.mListener.onClosed();
        }

        public void onLocationChanged(Location location) {
            this.mListener.onLocationChanged(location);
            reportRequestCompleted();
        }

        public void onLocationInfoChanged(PositioningError positioningError) {
            this.mListener.onLocationInfoChanged(positioningError);
        }

        public void onLocationResolvingFailed(PositioningError positioningError) {
            this.mListener.onLocationResolvingFailed(positioningError);
            reportRequestCompleted();
        }

        public void onMonitorStateChanged(DeviceMonitor.Listener.MonitorType monitorType, boolean z) {
            UpdateOptions buildEffectiveOptions = buildEffectiveOptions(this.mRequestedOptions);
            UpdateOptions buildReducedOptions = buildReducedOptions(this.mRequestedOptions);
            if (!buildEffectiveOptions.isEqual(this.mEffectiveOptions) || !buildReducedOptions.isEqual(this.mReducedRequestedOptions)) {
                this.mHandler.removeCallbacks(this.mOptionsChangedTask);
                this.mEffectiveOptions = buildEffectiveOptions;
                this.mReducedRequestedOptions = buildReducedOptions;
                this.mHandler.postDelayed(this.mOptionsChangedTask, 1000);
                return;
            }
            Log.v(ServicesPosClientManager.TAG, "onMonitorStateChanged: No change in effective or reduced request options -> ignored", new Object[0]);
        }

        public void onMonitoringStarted(DeviceMonitor.Listener.MonitorType monitorType, boolean z) {
        }

        public void onMonitoringStopped(DeviceMonitor.Listener.MonitorType monitorType) {
        }

        public void onOptionsChanged(UpdateOptions updateOptions, UpdateOptions updateOptions2) {
            this.mListener.onOptionsChanged(updateOptions, updateOptions2);
        }

        public void setOnCompletedCallback(Runnable runnable) {
            this.mOnCompletedCallback = runnable;
        }

        public void setRequestedOptions(UpdateOptions updateOptions) {
            stopMonitoring();
            this.mOptionsChangedTask = new OptionsChangedTask();
            UpdateOptions updateOptions2 = new UpdateOptions(updateOptions);
            this.mRequestedOptions = updateOptions2;
            this.mReducedRequestedOptions = buildReducedOptions(updateOptions2);
            this.mEffectiveOptions = buildEffectiveOptions(this.mRequestedOptions);
            this.mMonitor = createDeviceMonitor(this.mRequestedOptions);
            startMonitoring();
            if (!this.mRequestedOptions.isEqual(this.mEffectiveOptions)) {
                onOptionsChanged(this.mRequestedOptions, this.mEffectiveOptions);
            }
        }
    }

    public static class Request implements IPositioningSession.StatusListener {
        private static final AtomicInteger mLatestRequestId = new AtomicInteger();

        private Request() {
        }

        public synchronized boolean make(IPositioningSession iPositioningSession, UpdateOptions updateOptions) {
            int updateOptions2 = iPositioningSession.setUpdateOptions(updateOptions, this);
            if (updateOptions2 == Integer.MIN_VALUE) {
                return false;
            }
            mLatestRequestId.set(updateOptions2);
            return true;
        }

        public synchronized void makeForced(IPositioningSession iPositioningSession, UpdateOptions updateOptions) {
            mLatestRequestId.set(iPositioningSession.setUpdateOptions(updateOptions));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void onRequestCompleted(int r2, com.here.posclient.Status r3) {
            /*
                r1 = this;
                monitor-enter(r1)
                java.util.concurrent.atomic.AtomicInteger r0 = mLatestRequestId     // Catch:{ all -> 0x0013 }
                int r0 = r0.get()     // Catch:{ all -> 0x0013 }
                if (r0 == r2) goto L_0x000b
                monitor-exit(r1)
                return
            L_0x000b:
                com.here.posclient.Status r2 = com.here.posclient.Status.Ok     // Catch:{ all -> 0x0013 }
                if (r3 == r2) goto L_0x0015
                r1.onRequestFailed(r3)     // Catch:{ all -> 0x0013 }
                goto L_0x0015
            L_0x0013:
                r2 = move-exception
                goto L_0x0017
            L_0x0015:
                monitor-exit(r1)
                return
            L_0x0017:
                monitor-exit(r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.services.location.internal.ServicesPosClientManager.Request.onRequestCompleted(int, com.here.posclient.Status):void");
        }

        public void onRequestFailed(Status status) {
        }
    }

    private ServicesPosClientManager(IPosClientManager iPosClientManager, IPositioningSession.ILocationListener iLocationListener) {
        this.mListenerProxy = new ListenerProxy(iLocationListener);
        this.mPosClientManager = iPosClientManager;
    }

    public static ISdkPosClientManager create(IPosClientManager iPosClientManager, IPositioningSession.ILocationListener iLocationListener) {
        return new ServicesPosClientManager(iPosClientManager, iLocationListener);
    }

    public synchronized int availableFeatures() {
        IPositioningSession iPositioningSession = this.mPositioning;
        if (iPositioningSession == null) {
            return (int) PositioningFeature.None.value;
        }
        return iPositioningSession.availableFeatures();
    }

    public IPositioningSession createOpenedPositioningSession(IPositioningSession.ILocationListener iLocationListener) {
        Log.v(TAG, "createOpenedPositioningSession", new Object[0]);
        IPositioningSession createPositionerSession = this.mPosClientManager.createPositionerSession(iLocationListener);
        if (createPositionerSession == null) {
            Log.e(TAG, "createOpenedPositioner: Failed to create positioner", new Object[0]);
            return createPositionerSession;
        } else if (createPositionerSession.open()) {
            return createPositionerSession;
        } else {
            Log.e(TAG, "createOpenedPositioner: Failed to open positioner", new Object[0]);
            return null;
        }
    }

    public synchronized int enabledFeatures() {
        IPositioningSession iPositioningSession = this.mPositioning;
        if (iPositioningSession == null) {
            return (int) PositioningFeature.None.value;
        }
        return iPositioningSession.enabledFeatures();
    }

    public synchronized Location getLastPosition() {
        Location location;
        Location location2;
        IPositioningSession createOpenedPositioningSession;
        try {
            Log.v(TAG, "getLastPosition", new Object[0]);
            IPositioningSession iPositioningSession = this.mPositioning;
            location = null;
            if (iPositioningSession == null) {
                createOpenedPositioningSession = createOpenedPositioningSession(this.mListenerProxy);
                if (createOpenedPositioningSession != null) {
                    location2 = createOpenedPositioningSession.getLastPosition();
                    createOpenedPositioningSession.close();
                } else {
                    location2 = null;
                }
            } else {
                location2 = iPositioningSession.getLastPosition();
            }
            if (isValidLocation(location2)) {
                location = location2;
            }
        } catch (Throwable th) {
            throw th;
        }
        return location;
    }

    public synchronized boolean injectActivity(GeneralActivityResult generalActivityResult) {
        Log.v(TAG, "injectActivity: %s", generalActivityResult);
        IPositioningSession iPositioningSession = this.mPositioning;
        if (iPositioningSession == null) {
            return false;
        }
        return iPositioningSession.injectActivity(generalActivityResult);
    }

    public synchronized boolean injectLocation(Location location) {
        Log.v(TAG, "injectLocation: %s", location);
        IPositioningSession iPositioningSession = this.mPositioning;
        if (iPositioningSession == null) {
            return false;
        }
        return iPositioningSession.injectLocation(location);
    }

    public boolean isValidLocation(Location location) {
        if (location == null) {
            return false;
        }
        boolean contains = LocationHelper.getTechnologies(location).contains(Types.Technology.Gnss);
        boolean isNetworkLocationEnabled = HereServicesUtil.isNetworkLocationEnabled(this.mPosClientManager.getContext());
        boolean isGpsLocationEnabled = HereServicesUtil.isGpsLocationEnabled(this.mPosClientManager.getContext());
        if (!isGpsLocationEnabled && !isNetworkLocationEnabled) {
            return false;
        }
        if (!isNetworkLocationEnabled || contains) {
            return isGpsLocationEnabled && contains;
        }
        return true;
    }

    public void onSetUpdateOptions(final IPositioningSession iPositioningSession, UpdateOptions updateOptions) {
        if (iPositioningSession == null) {
            Log.e(TAG, "onSetUpdateOptions: unable to set new options, session is null", new Object[0]);
        } else if (!new Request() {
            public void onRequestFailed(Status status) {
                if (status == Status.InvalidArgumentError) {
                    Log.i(ServicesPosClientManager.TAG, "onRequestFailed: invalid argument error, setting disabled options", new Object[0]);
                    makeForced(iPositioningSession, new UpdateOptions().setDisabledPowerOptions());
                }
            }
        }.make(iPositioningSession, updateOptions)) {
            Log.e(TAG, "onSetUpdateOptions: request.make() failed", new Object[0]);
        }
    }

    public synchronized void positioningConsentRevoked() {
        Log.v(TAG, "positioningConsentRevoked", new Object[0]);
        IPositioningSession iPositioningSession = this.mPositioning;
        if (iPositioningSession != null) {
            iPositioningSession.positioningConsentRevoked();
            this.mPositioning = null;
        }
    }

    public boolean requestSingleUpdate(UpdateOptions updateOptions, IPositioningSession.ILocationListener iLocationListener) {
        Log.v(TAG, "requestSingleUpdate: %s", updateOptions);
        ListenerProxy listenerProxy = new ListenerProxy(iLocationListener);
        listenerProxy.setRequestedOptions(updateOptions);
        final IPositioningSession createOpenedPositioningSession = createOpenedPositioningSession(listenerProxy);
        if (createOpenedPositioningSession == null) {
            listenerProxy.onLocationResolvingFailed(new PositioningError(Status.GeneralError));
            return false;
        }
        listenerProxy.setOnCompletedCallback(new Runnable() {
            public void run() {
                Log.v(ServicesPosClientManager.TAG, "requestSingleUpdate: setOnCompletedCallback", new Object[0]);
                createOpenedPositioningSession.close();
            }
        });
        if (updateOptions.clearDataItemsSet) {
            createOpenedPositioningSession.clearData(updateOptions.clearDataItems);
        }
        return createOpenedPositioningSession.requestSingleUpdate(listenerProxy.getRequestedOptions());
    }

    public synchronized boolean startInjectionUpdates() {
        Log.v(TAG, "startInjectionUpdates", new Object[0]);
        if (this.mPositioning == null) {
            IPositioningSession createOpenedPositioningSession = createOpenedPositioningSession(this.mListenerProxy);
            this.mPositioning = createOpenedPositioningSession;
            if (createOpenedPositioningSession == null) {
                Log.e(TAG, "startLocationUpdates: Failed to create positioner", new Object[0]);
                return false;
            }
        }
        return this.mPositioning.startInjectionUpdates();
    }

    public synchronized boolean startLocationUpdates(UpdateOptions updateOptions) {
        Log.v(TAG, "startLocationUpdates: %s", updateOptions);
        if (this.mPositioning == null) {
            IPositioningSession createOpenedPositioningSession = createOpenedPositioningSession(this.mListenerProxy);
            this.mPositioning = createOpenedPositioningSession;
            if (createOpenedPositioningSession == null) {
                Log.e(TAG, "startLocationUpdates: Failed to create positioner", new Object[0]);
                return false;
            }
        }
        if (updateOptions.clearDataItemsSet) {
            Log.v(TAG, "startLocationUpdates: clear data item: %d", Integer.valueOf(updateOptions.clearDataItems));
            this.mPositioning.clearData(updateOptions.clearDataItems);
        }
        this.mListenerProxy.setRequestedOptions(updateOptions);
        onSetUpdateOptions(this.mPositioning, this.mListenerProxy.getRequestedOptions());
        return this.mPositioning.startPositionUpdates();
    }

    public synchronized void stopLocationUpdates() {
        Log.v(TAG, "stopLocationUpdates", new Object[0]);
        if (this.mPositioning != null) {
            this.mListenerProxy.close();
            this.mPositioning.stopPositionUpdates();
            new Request().makeForced(this.mPositioning, new UpdateOptions().setDisabledPowerOptions());
            this.mPositioning.close();
            this.mPositioning = null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void toggleFeature(java.lang.String r3, boolean r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.here.odnp.posclient.pos.IPositioningSession r0 = r2.mPositioning     // Catch:{ all -> 0x000f }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            com.here.posclient.PositioningFeature r1 = com.here.posclient.PositioningFeature.valueOf(r3)     // Catch:{ Exception -> 0x0011 }
            r0.toggleFeature(r1, r4)     // Catch:{ Exception -> 0x0011 }
            goto L_0x001c
        L_0x000f:
            r3 = move-exception
            goto L_0x001e
        L_0x0011:
            java.lang.Object[] r3 = new java.lang.Object[]{r3}     // Catch:{ all -> 0x000f }
            java.lang.String r4 = "services.location.internal.ServicesPosClientManager"
            java.lang.String r0 = "toggleFeature: unknown feature: '%s' -> ignored"
            com.here.odnp.util.Log.e(r4, r0, r3)     // Catch:{ all -> 0x000f }
        L_0x001c:
            monitor-exit(r2)
            return
        L_0x001e:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.services.location.internal.ServicesPosClientManager.toggleFeature(java.lang.String, boolean):void");
    }
}
