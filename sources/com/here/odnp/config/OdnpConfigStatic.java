package com.here.odnp.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class OdnpConfigStatic {
    public static final boolean AUTH_API = true;
    public static final boolean BUILD_OEM_INTEGRATION = false;
    public static final boolean BUILD_SDK_INTEGRATION = true;
    public static final boolean CELL_USE_CDMA = true;
    public static final boolean DEBUG_EXTERNAL_PRIVATE_DATA_DIR = false;
    public static final boolean DEBUG_GPS_STATUS = false;
    public static final boolean DEBUG_LOCATION_EXTRAS = false;
    public static final boolean DEBUG_LOG_JNI_INFO = false;
    public static final boolean DEBUG_LOG_TO_FILE = false;
    public static final boolean DEBUG_TESTING_API = false;
    public static final boolean DEBUG_TRACE = false;
    public static final long GNSS_ACTIVE_MINTIME = 900;
    public static final long GNSS_PASSIVE_MINTIME = 500;
    public static final boolean HDGNSS = true;
    public static final boolean HDWIFI_CS_API = false;
    public static final boolean HUAWEI_SPECIFIC = false;
    public static final Collection<String> MCC_BLACKLIST = Collections.unmodifiableCollection(Arrays.asList(new String[]{"368", "432", "467", "634", "417"}));
    public static final boolean MEASUREMENT_PLAYBACK_API = true;
    public static final String OEM_CLIENT_CERT_ASSET_PATH = "cert/client_cert.pem";
    public static final long OEM_MAX_AGE_FOR_LAST_KNOWN = 30000;
    public static final long OEM_MAX_HIGH_POWER_INTERVAL = 120000;
    public static final long OEM_MAX_MEDIUM_POWER_INTERVAL = 1800000;
    public static final long OEM_MIN_DESIRED_INTERVAL = 30000;
    public static final long OEM_MIN_SMALLEST_INTERVAL = 0;
    public static final String OEM_PACKAGE_NAME = "com.here.odnp.service";
    public static final String OEM_SERVICE_CLASS_NAME = "com.here.odnp.service.LocationService";
    public static final boolean OPENSSL_SSL_LIBRARY = false;
    public static final String POS_LIBRARY_NAME = "";
    public static final String RADIO_MAP_DOWNLOAD_ROOT = "rmd";
    public static final boolean RADIO_MAP_MANAGER_API = true;
    public static final long SDK_ABSOLUTE_MIN_INTERVAL = 30000;
    public static final String SDK_SERVICE_CLASS_NAME = "com.here.services.internal.LocationService";
    public static final boolean SENSOR_FUSION = true;
    public static final boolean STATIC_OPENSSL = true;
    public static final String STL_LIBRARY_NAME = "";
    public static final boolean STL_LIBRARY_SHARED = false;
    public static final String SW_VERSION = "4.17.0";
    public static final int SW_VERSION_BUILD = 0;
    public static final int SW_VERSION_MAJOR = 4;
    public static final int SW_VERSION_MINOR = 17;
    public static final boolean THREADED_SERVICE = true;
    public static final int UPLOAD_LOW_PRIORITY_DURATION_MINUTES = 480;
    public static final int UPLOAD_MEDIUM_PRIORITY_DURATION_MINUTES = 960;
    public static final UploadSchedulingStrategy UPLOAD_SCHEDULING = UploadSchedulingStrategy.Timer;
    public static final boolean USAGE_TRACKING_API = false;
    public static final boolean USER_CONSENT_API = true;
    public static final boolean USER_CONSENT_FILE = false;
    public static final boolean USER_CONSENT_SECURE = false;
    public static final boolean WIFI_SCAN_THROTTLING = true;

    public enum UploadSchedulingStrategy {
        None,
        JobService,
        Timer
    }
}
