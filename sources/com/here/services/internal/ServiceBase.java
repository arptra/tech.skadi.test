package com.here.services.internal;

import android.app.Service;
import android.content.Intent;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.util.Log;
import com.here.services.internal.IServiceNotAvailable;

public abstract class ServiceBase extends Service {
    private static final String AUTH_SERVICE_CLASS = "com.here.services.positioning.auth.internal.AuthClientService";
    private static final String CONSENT_SERVICE_CLASS = "com.here.services.positioning.consent.internal.ConsentClientService";
    private static final String CROWDSOURCE_SERVICE_CLASS = "com.here.services.crowdsource.internal.CrowdsourceClientService";
    private static final String FINGERPRINT_COLLECTION_TEST_SERVICE_CLASS = "com.here.services.test.internal.FingerprintCollectionTestClientService";
    private static final String LOCATION_SERVICE_CLASS = "com.here.services.location.internal.LocationClientService";
    private static final String LOCATION_TEST_SERVICE_CLASS = "com.here.services.test.internal.LocationTestClientService";
    private static final String MEASUREMENT_PLAYBACK_SERVICE_CLASS = "com.here.services.playback.internal.MeasurementPlaybackClientService";
    private static final String RADIOMAP_MANAGER_SERVICE_CLASS = "com.here.services.radiomap.internal.RadioMapManagerClientService";
    private static final String TAG = "here.services.internal.ServiceBase";
    private static final String UPLOAD_SERVICE_CLASS = "com.here.services.positioning.upload.internal.UploadClientService";
    private static final String USAGE_TRACKING_SERVICE_CLASS = "com.here.services.positioning.analytics.internal.UsageTrackingClientService";
    private static final IBoundService mServiceNotAvailable = new ServiceNotAvailable();

    public static class ServiceNotAvailable extends IServiceNotAvailable.Stub implements IBoundService {
        public void unBind() {
        }
    }

    private IBoundService createBoundService(IPosClientManager iPosClientManager, Intent intent, String str) {
        Log.v(TAG, "createBoundService: %s", str);
        try {
            return (IBoundService) Class.forName(str).getConstructor(new Class[]{IPosClientManager.class, Intent.class}).newInstance(new Object[]{iPosClientManager, intent});
        } catch (Exception unused) {
            return mServiceNotAvailable;
        }
    }

    public IBoundService createAuthService(IPosClientManager iPosClientManager, Intent intent) {
        return createBoundService(iPosClientManager, intent, AUTH_SERVICE_CLASS);
    }

    public IBoundService createConsentService(IPosClientManager iPosClientManager, Intent intent) {
        return createBoundService(iPosClientManager, intent, CONSENT_SERVICE_CLASS);
    }

    public IBoundService createCrowdsourceService(IPosClientManager iPosClientManager, Intent intent) {
        return createBoundService(iPosClientManager, intent, CROWDSOURCE_SERVICE_CLASS);
    }

    public IBoundService createFingerprintCollectionTestService(IPosClientManager iPosClientManager, Intent intent) {
        return createBoundService(iPosClientManager, intent, FINGERPRINT_COLLECTION_TEST_SERVICE_CLASS);
    }

    public IBoundService createLocationService(IPosClientManager iPosClientManager, Intent intent) {
        return createBoundService(iPosClientManager, intent, LOCATION_SERVICE_CLASS);
    }

    public IBoundService createLocationTestService(IPosClientManager iPosClientManager, Intent intent) {
        return createBoundService(iPosClientManager, intent, LOCATION_TEST_SERVICE_CLASS);
    }

    public IBoundService createMeasurementPlaybackService(IPosClientManager iPosClientManager, Intent intent) {
        return createBoundService(iPosClientManager, intent, MEASUREMENT_PLAYBACK_SERVICE_CLASS);
    }

    public IBoundService createRadioMapManagerService(IPosClientManager iPosClientManager, Intent intent) {
        return createBoundService(iPosClientManager, intent, RADIOMAP_MANAGER_SERVICE_CLASS);
    }

    public IBoundService createUploadService(IPosClientManager iPosClientManager, Intent intent) {
        return createBoundService(iPosClientManager, intent, UPLOAD_SERVICE_CLASS);
    }

    public IBoundService createUsageTrackingService(IPosClientManager iPosClientManager, Intent intent) {
        return createBoundService(iPosClientManager, intent, USAGE_TRACKING_SERVICE_CLASS);
    }

    public boolean isAuthServiceAction(Intent intent) {
        return IBoundService.ACTION_BIND_AUTH_SERVICE.equals(intent.getAction());
    }

    public boolean isConsentServiceAction(Intent intent) {
        return IBoundService.ACTION_BIND_CONSENT_SERVICE.equals(intent.getAction());
    }

    public boolean isCrowdsourceServiceAction(Intent intent) {
        return IBoundService.ACTION_BIND_CROWDSOURCE_SERVICE.equals(intent.getAction());
    }

    public boolean isLocationServiceAction(Intent intent) {
        return IBoundService.ACTION_BIND_LOCATION_SERVICE.equals(intent.getAction());
    }

    public boolean isLocationServiceControllerAction(Intent intent) {
        return IBoundService.ACTION_BIND_CONTROLLER.equals(intent.getAction());
    }

    public boolean isLocationTestServiceAction(Intent intent) {
        return IBoundService.ACTION_BIND_LOCATION_TEST_SERVICE.equals(intent.getAction());
    }

    public boolean isMeasurementPlaybackServiceAction(Intent intent) {
        return IBoundService.ACTION_BIND_MEASUREMENT_PLAYBACK_SERVICE.equals(intent.getAction());
    }

    public boolean isRadiomapManagerServiceAction(Intent intent) {
        return IBoundService.ACTION_BIND_RADIOMAP_MANAGER_SERVICE.equals(intent.getAction());
    }

    public boolean isUploadServiceAction(Intent intent) {
        return IBoundService.ACTION_BIND_UPLOAD_SERVICE.equals(intent.getAction());
    }

    public boolean isUsageTrackingServiceAction(Intent intent) {
        return IBoundService.ACTION_BIND_USAGE_TRACKING_SERVICE.equals(intent.getAction());
    }

    public IBoundService serviceNotAvailable() {
        return mServiceNotAvailable;
    }
}
