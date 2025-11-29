package com.here.services.test;

import android.content.Context;
import com.here.annotations.SuppressFBWarnings;
import com.here.services.Api;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.internal.ServiceNotFoundException;
import com.here.services.test.fingerprint.FingerprintCollectionTestApi;
import com.here.services.test.fingerprint.FingerprintCollectionTestProvider;
import com.here.services.test.fingerprint.HdWifiCollectionTestApi;
import com.here.services.test.fingerprint.HdWifiCollectionTestProvider;
import com.here.services.test.internal.ILocationTest;
import com.here.services.test.internal.LocationTestFactory;
import com.here.services.test.internal.LocationTestServicesController;
import com.here.services.test.location.LocationTestApi;
import com.here.services.test.location.LocationTestTestProvider;

public class LocationTestServices {
    public static final Api<Api.Options.None> API = new Api<Api.Options.None>() {
        public ServiceController createController(Context context, Api.Options options) {
            try {
                ILocationTest open = LocationTestFactory.open(context);
                if (open != null) {
                    LocationTestServicesController locationTestServicesController = new LocationTestServicesController(open);
                    LocationTestServices.LocationTest = new LocationTestTestProvider(context, new ServiceController.Provider<LocationTestServicesController>() {
                        public LocationTestServicesController getController(HereLocationApiClient hereLocationApiClient) {
                            try {
                                return (LocationTestServicesController) hereLocationApiClient.getServiceController(LocationTestServices.API);
                            } catch (Exception unused) {
                                return null;
                            }
                        }
                    });
                    LocationTestServices.FingerprintCollectionTest = new FingerprintCollectionTestProvider(context, new ServiceController.Provider<LocationTestServicesController>() {
                        public LocationTestServicesController getController(HereLocationApiClient hereLocationApiClient) {
                            try {
                                return (LocationTestServicesController) hereLocationApiClient.getServiceController(LocationTestServices.API);
                            } catch (Exception unused) {
                                return null;
                            }
                        }
                    });
                    LocationTestServices.HDWifiCollectionTest = new HdWifiCollectionTestProvider(context, new ServiceController.Provider<LocationTestServicesController>() {
                        public LocationTestServicesController getController(HereLocationApiClient hereLocationApiClient) {
                            try {
                                return (LocationTestServicesController) hereLocationApiClient.getServiceController(LocationTestServices.API);
                            } catch (Exception unused) {
                                return null;
                            }
                        }
                    });
                    return locationTestServicesController;
                }
                throw new ServiceNotFoundException("LocationTestFactory.open: returned null");
            } catch (Exception unused) {
                return null;
            }
        }
    };
    @SuppressFBWarnings({"NM_FIELD_NAMING_CONVENTION"})
    public static FingerprintCollectionTestApi FingerprintCollectionTest = null;
    @SuppressFBWarnings({"NM_FIELD_NAMING_CONVENTION"})
    public static HdWifiCollectionTestApi HDWifiCollectionTest = null;
    @SuppressFBWarnings({"NM_FIELD_NAMING_CONVENTION"})
    public static LocationTestApi LocationTest = null;
    private static final String TAG = "services.test.LocationTestServices";
}
