package com.here.services.internal;

import android.os.IBinder;

public interface IBoundService extends IBinder {
    public static final String ACTION_BIND_AUTH_SERVICE = "com.here.services.Auth";
    public static final String ACTION_BIND_CONSENT_SERVICE = "com.here.services.Consent";
    public static final String ACTION_BIND_CONTROLLER = "com.here.services.Controller";
    public static final String ACTION_BIND_CROWDSOURCE_SERVICE = "com.here.services.Crowdsource";
    public static final String ACTION_BIND_LOCATION_SERVICE = "com.here.services.Location";
    public static final String ACTION_BIND_LOCATION_TEST_SERVICE = "com.here.services.LocationTest";
    public static final String ACTION_BIND_MEASUREMENT_PLAYBACK_SERVICE = "com.here.services.MeasurementPlayback";
    public static final String ACTION_BIND_RADIOMAP_MANAGER_SERVICE = "com.here.services.RadioMapManager";
    public static final String ACTION_BIND_UPLOAD_SERVICE = "com.here.services.Upload";
    public static final String ACTION_BIND_USAGE_TRACKING_SERVICE = "com.here.services.UsageTracking";

    void unBind();
}
