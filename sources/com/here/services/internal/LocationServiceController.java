package com.here.services.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.here.annotations.SuppressFBWarnings;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.posclient.PosClientManager;
import com.here.odnp.util.AssetCopyTask;
import com.here.odnp.util.DeviceMonitor;
import com.here.odnp.util.Log;
import com.here.posclient.InitOptions;
import com.here.posclient.PosClientLib;
import com.here.posclient.PositioningFeature;
import com.here.services.internal.ILocationServiceController;

class LocationServiceController extends ILocationServiceController.Stub implements IBoundService, DeviceMonitor.Listener {
    private static final long ASSET_COPY_TASK_MAX_WAIT_TIME = 10000;
    private static final String TAG = "here.services.internal.LocationServiceController";
    @SuppressFBWarnings({"UUF_UNUSED_FIELD"})
    private IBoundService mAuthClientService;
    @SuppressFBWarnings({"UUF_UNUSED_FIELD"})
    private IBoundService mConsentClientService;
    @SuppressFBWarnings({"UUF_UNUSED_FIELD"})
    private IBoundService mCrowdsourceService;
    private boolean mIsActiveStorageFeatureAllowed;
    private boolean mIsCollectorFeatureAllowed;
    private boolean mIsHdWifiCollectorFeatureAllowed;
    private boolean mIsUserConsentGranted = false;
    private IBoundService mLocationClientService;
    @SuppressFBWarnings({"UUF_UNUSED_FIELD"})
    private IBoundService mLocationTestClientService;
    @SuppressFBWarnings({"UUF_UNUSED_FIELD"})
    private IBoundService mMeasurementPlaybackClientService;
    private final DeviceMonitor mMonitor;
    private volatile IPosClientManager mPosClientManager;
    @SuppressFBWarnings({"UUF_UNUSED_FIELD"})
    private IBoundService mRadioMapManagerClientService;
    private final LocationService mService;
    @SuppressFBWarnings({"UUF_UNUSED_FIELD"})
    private IBoundService mUploadClientService;
    @SuppressFBWarnings({"UUF_UNUSED_FIELD"})
    private IBoundService mUsageTrackingClientService;

    /* renamed from: com.here.services.internal.LocationServiceController$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$here$odnp$util$DeviceMonitor$Listener$MonitorType;

        static {
            int[] iArr = new int[DeviceMonitor.Listener.MonitorType.values().length];
            $SwitchMap$com$here$odnp$util$DeviceMonitor$Listener$MonitorType = iArr;
            try {
                iArr[DeviceMonitor.Listener.MonitorType.NetworkLocation.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public LocationServiceController(LocationService locationService) {
        Log.v(TAG, "LocationServiceController", new Object[0]);
        this.mService = locationService;
        DeviceMonitor.Builder builder = new DeviceMonitor.Builder(locationService, this);
        builder.setMonitorNetworkLocation(true);
        this.mMonitor = builder.build();
    }

    private void checkIfAllBindingsClosed() {
        boolean z = false;
        boolean z2 = (this.mLocationClientService == null) & (this.mRadioMapManagerClientService == null) & (this.mMeasurementPlaybackClientService == null) & (this.mAuthClientService == null) & (this.mConsentClientService == null) & (this.mCrowdsourceService == null);
        if (this.mUploadClientService == null) {
            z = true;
        }
        if (z2 && z) {
            this.mMonitor.stopMonitoring();
            if (this.mPosClientManager != null) {
                this.mPosClientManager.close();
                this.mPosClientManager = null;
            }
            this.mService.onAllBindingsClosed();
        }
    }

    private void handleMonitorState(DeviceMonitor.Listener.MonitorType monitorType, boolean z) {
        if (this.mPosClientManager == null) {
            Log.v(TAG, "handleMonitorState: posclient manager is null -> ignored", new Object[0]);
            return;
        }
        Log.v(TAG, "handleMonitorState: monitor change: " + monitorType.toString() + " enabled: " + z, new Object[0]);
        boolean z2 = true;
        if (AnonymousClass1.$SwitchMap$com$here$odnp$util$DeviceMonitor$Listener$MonitorType[monitorType.ordinal()] != 1) {
            Log.w(TAG, "handleMonitorState: unhandled monitor change: " + monitorType.toString(), new Object[0]);
            return;
        }
        this.mPosClientManager.toggleFeature(PositioningFeature.Collector, z && this.mIsCollectorFeatureAllowed);
        this.mPosClientManager.toggleFeature(PositioningFeature.ActiveStorage, z && this.mIsActiveStorageFeatureAllowed);
        IPosClientManager iPosClientManager = this.mPosClientManager;
        PositioningFeature positioningFeature = PositioningFeature.HDWifiCollector;
        if (!z || !this.mIsHdWifiCollectorFeatureAllowed) {
            z2 = false;
        }
        iPosClientManager.toggleFeature(positioningFeature, z2);
        if (!z) {
            Log.v(TAG, "handleMonitorState: clearing persistent data", new Object[0]);
            PosClientLib.clearData(6303);
        }
    }

    private void unbindServices() {
        try {
            IBoundService iBoundService = this.mLocationClientService;
            if (iBoundService != null) {
                iBoundService.unBind();
                this.mLocationClientService = null;
            }
            IBoundService iBoundService2 = this.mRadioMapManagerClientService;
            if (iBoundService2 != null) {
                iBoundService2.unBind();
                this.mRadioMapManagerClientService = null;
            }
            IBoundService iBoundService3 = this.mMeasurementPlaybackClientService;
            if (iBoundService3 != null) {
                iBoundService3.unBind();
                this.mMeasurementPlaybackClientService = null;
            }
            IBoundService iBoundService4 = this.mAuthClientService;
            if (iBoundService4 != null) {
                iBoundService4.unBind();
                this.mAuthClientService = null;
            }
            IBoundService iBoundService5 = this.mConsentClientService;
            if (iBoundService5 != null) {
                iBoundService5.unBind();
                this.mConsentClientService = null;
            }
            IBoundService iBoundService6 = this.mUploadClientService;
            if (iBoundService6 != null) {
                iBoundService6.unBind();
                this.mUploadClientService = null;
            }
            IBoundService iBoundService7 = this.mCrowdsourceService;
            if (iBoundService7 != null) {
                iBoundService7.unBind();
                this.mCrowdsourceService = null;
            }
            checkIfAllBindingsClosed();
        } catch (Throwable th) {
            checkIfAllBindingsClosed();
            throw th;
        }
    }

    public void onMonitorStateChanged(DeviceMonitor.Listener.MonitorType monitorType, boolean z) {
        handleMonitorState(monitorType, z);
    }

    public void onMonitoringStarted(DeviceMonitor.Listener.MonitorType monitorType, boolean z) {
        handleMonitorState(monitorType, z);
    }

    public void onMonitoringStopped(DeviceMonitor.Listener.MonitorType monitorType) {
    }

    public IBinder onServiceBind(Intent intent) {
        if (!this.mIsUserConsentGranted) {
            Log.e(TAG, "onServiceBind: no service allowed without user consent", new Object[0]);
            return this.mService.serviceNotAvailable();
        } else if (this.mService.isLocationServiceAction(intent)) {
            if (this.mLocationClientService == null) {
                this.mLocationClientService = this.mService.createLocationService(this.mPosClientManager, intent);
            }
            return this.mLocationClientService;
        } else if (this.mService.isRadiomapManagerServiceAction(intent)) {
            if (this.mRadioMapManagerClientService == null) {
                this.mRadioMapManagerClientService = this.mService.createRadioMapManagerService(this.mPosClientManager, intent);
            }
            return this.mRadioMapManagerClientService;
        } else if (this.mService.isMeasurementPlaybackServiceAction(intent)) {
            if (this.mMeasurementPlaybackClientService == null) {
                this.mMeasurementPlaybackClientService = this.mService.createMeasurementPlaybackService(this.mPosClientManager, intent);
            }
            return this.mMeasurementPlaybackClientService;
        } else if (this.mService.isAuthServiceAction(intent)) {
            if (this.mAuthClientService == null) {
                this.mAuthClientService = this.mService.createAuthService(this.mPosClientManager, intent);
            }
            return this.mAuthClientService;
        } else if (this.mService.isConsentServiceAction(intent)) {
            if (this.mConsentClientService == null) {
                this.mConsentClientService = this.mService.createConsentService(this.mPosClientManager, intent);
            }
            return this.mConsentClientService;
        } else if (!this.mService.isUploadServiceAction(intent)) {
            return this.mService.serviceNotAvailable();
        } else {
            if (this.mUploadClientService == null) {
                this.mUploadClientService = this.mService.createUploadService(this.mPosClientManager, intent);
            }
            return this.mUploadClientService;
        }
    }

    public boolean onServiceUnbind(Intent intent) {
        try {
            if (this.mService.isLocationServiceAction(intent)) {
                IBoundService iBoundService = this.mLocationClientService;
                if (iBoundService != null) {
                    iBoundService.unBind();
                    this.mLocationClientService = null;
                }
                return false;
            } else if (this.mService.isRadiomapManagerServiceAction(intent)) {
                IBoundService iBoundService2 = this.mRadioMapManagerClientService;
                if (iBoundService2 != null) {
                    iBoundService2.unBind();
                    this.mRadioMapManagerClientService = null;
                }
                checkIfAllBindingsClosed();
                return false;
            } else if (this.mService.isAuthServiceAction(intent)) {
                IBoundService iBoundService3 = this.mAuthClientService;
                if (iBoundService3 != null) {
                    iBoundService3.unBind();
                    this.mAuthClientService = null;
                }
                checkIfAllBindingsClosed();
                return false;
            } else if (this.mService.isConsentServiceAction(intent)) {
                IBoundService iBoundService4 = this.mConsentClientService;
                if (iBoundService4 != null) {
                    iBoundService4.unBind();
                    this.mConsentClientService = null;
                }
                checkIfAllBindingsClosed();
                return false;
            } else if (this.mService.isUploadServiceAction(intent)) {
                IBoundService iBoundService5 = this.mUploadClientService;
                if (iBoundService5 != null) {
                    iBoundService5.unBind();
                    this.mUploadClientService = null;
                }
                checkIfAllBindingsClosed();
                return false;
            } else if (this.mService.isCrowdsourceServiceAction(intent)) {
                IBoundService iBoundService6 = this.mCrowdsourceService;
                if (iBoundService6 != null) {
                    iBoundService6.unBind();
                    this.mCrowdsourceService = null;
                }
                checkIfAllBindingsClosed();
                return false;
            } else if (this.mService.isMeasurementPlaybackServiceAction(intent)) {
                IBoundService iBoundService7 = this.mMeasurementPlaybackClientService;
                if (iBoundService7 != null) {
                    iBoundService7.unBind();
                    this.mMeasurementPlaybackClientService = null;
                }
                checkIfAllBindingsClosed();
                return false;
            } else {
                Log.w(TAG, "onUnbind: Unknown action '%s'", intent.getAction());
                checkIfAllBindingsClosed();
                return false;
            }
        } finally {
            checkIfAllBindingsClosed();
        }
    }

    public LocationServiceController openController(AssetCopyTask assetCopyTask, Bundle bundle) {
        if (!assetCopyTask.waitForCompletion(ASSET_COPY_TASK_MAX_WAIT_TIME)) {
            return null;
        }
        boolean isGranted = UserConsent.isGranted(this.mService);
        this.mIsUserConsentGranted = isGranted;
        boolean z = false;
        if (!isGranted) {
            Log.e(TAG, "openController: user consent missing", new Object[0]);
            bundle.putBoolean(InitOptions.KEY_OPTION_WITHOUT_CONSENT, true);
        }
        this.mPosClientManager = PosClientManager.open(this.mService.getApplicationContext(), bundle);
        if (!this.mIsUserConsentGranted && this.mPosClientManager != null) {
            this.mPosClientManager.positioningConsentRevoked();
        }
        if (bundle == null || !bundle.containsKey(InitOptions.KEY_OPTION_FEATURES)) {
            this.mIsCollectorFeatureAllowed = true;
            this.mIsHdWifiCollectorFeatureAllowed = true;
            this.mIsActiveStorageFeatureAllowed = true;
        } else {
            long j = bundle.getLong(InitOptions.KEY_OPTION_FEATURES, 0);
            this.mIsCollectorFeatureAllowed = (PositioningFeature.Collector.value & j) != 0;
            this.mIsHdWifiCollectorFeatureAllowed = (PositioningFeature.HDWifiCollector.value & j) != 0;
            if ((j & PositioningFeature.ActiveStorage.value) != 0) {
                z = true;
            }
            this.mIsActiveStorageFeatureAllowed = z;
        }
        Log.v(TAG, "openController: isCollectorFeatureAllowed: %b", Boolean.valueOf(this.mIsCollectorFeatureAllowed));
        Log.v(TAG, "openController: isHdWifiCollectorFeatureAllowed: %b", Boolean.valueOf(this.mIsHdWifiCollectorFeatureAllowed));
        Log.v(TAG, "openController: isActiveStorageFeatureAllowed: %b", Boolean.valueOf(this.mIsActiveStorageFeatureAllowed));
        this.mMonitor.startMonitoring();
        return this;
    }

    public void unBind() {
        unbindServices();
    }

    public boolean updateOptions(Bundle bundle) throws RemoteException {
        if (this.mPosClientManager != null) {
            return this.mPosClientManager.updateOptions(bundle);
        }
        Log.e(TAG, "updateOptions: posclient manager is null -> ignored", new Object[0]);
        return false;
    }

    public boolean updateUserConsentState(boolean z) throws RemoteException {
        if (this.mPosClientManager == null) {
            Log.e(TAG, "updateOptions: posclient manager is null -> ignored", new Object[0]);
            return false;
        } else if (z) {
            return true;
        } else {
            this.mPosClientManager.positioningConsentRevoked();
            return true;
        }
    }
}
