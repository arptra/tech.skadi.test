package com.here.services.test.location;

import android.content.Context;
import com.here.odnp.util.Log;
import com.here.posclient.ClientConfiguration;
import com.here.posclient.PositioningFeature;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.test.internal.ILocationTest;
import com.here.services.test.internal.LocationTestServicesController;

public class LocationTestTestProvider implements LocationTestApi {
    private static final String TAG = "services.test.location.LocationTestTestProvider";
    final ServiceController.Provider<LocationTestServicesController> mProvider;

    public LocationTestTestProvider(Context context, ServiceController.Provider<LocationTestServicesController> provider) {
        this.mProvider = provider;
    }

    private ILocationTest getPositioningTest(HereLocationApiClient hereLocationApiClient) {
        LocationTestServicesController controller = this.mProvider.getController(hereLocationApiClient);
        if (controller != null) {
            return controller.getLocationTest();
        }
        Log.e(TAG, "getManager: controller is null, radio map manager instance not available", new Object[0]);
        return null;
    }

    public int availableFeatures(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest != null) {
            return positioningTest.availableFeatures();
        }
        Log.e(TAG, "availableFeatures: locationTest is null", new Object[0]);
        return 0;
    }

    public void clearData(HereLocationApiClient hereLocationApiClient, int i) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest == null) {
            Log.e(TAG, "clearData: locationTest is null", new Object[0]);
        } else {
            positioningTest.clearData(i);
        }
    }

    public void dumpCachedData(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest == null) {
            Log.e(TAG, "dumpCachedData: locationTest is null", new Object[0]);
        } else {
            positioningTest.dumpCachedData();
        }
    }

    public void dumpData(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest == null) {
            Log.e(TAG, "dumpData: locationTest is null", new Object[0]);
        } else {
            positioningTest.dumpData();
        }
    }

    public void dumpHeapData(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest == null) {
            Log.e(TAG, "dumpHeapData: locationTest is null", new Object[0]);
        } else {
            positioningTest.dumpHeapData();
        }
    }

    public void dumpRemoteConfiguration(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest == null) {
            Log.e(TAG, "dumpRemoteConfiguration: locationTest is null", new Object[0]);
        } else {
            positioningTest.dumpRemoteConfiguration();
        }
    }

    public int enabledFeatures(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest != null) {
            return positioningTest.enabledFeatures();
        }
        Log.e(TAG, "enabledFeatures: locationTest is null", new Object[0]);
        return 0;
    }

    public int enabledTechnologies(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest != null) {
            return positioningTest.enabledTechnologies();
        }
        Log.e(TAG, "enabledTechnologies: locationTest is null", new Object[0]);
        return 0;
    }

    public ClientConfiguration getClientConfiguration(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest != null) {
            return positioningTest.getClientConfiguration();
        }
        Log.e(TAG, "getClientConfiguration: locationTest is null", new Object[0]);
        return null;
    }

    public void logLta(HereLocationApiClient hereLocationApiClient, String str) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest == null) {
            Log.e(TAG, "logLta: locationTest is null", new Object[0]);
        } else {
            positioningTest.logLta(str);
        }
    }

    public void refreshRemoteConfiguration(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest == null) {
            Log.e(TAG, "refreshRemoteConfiguration: locationTest is null", new Object[0]);
        } else {
            positioningTest.refreshRemoteConfiguration();
        }
    }

    public void toggleFeature(HereLocationApiClient hereLocationApiClient, PositioningFeature positioningFeature, boolean z) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest == null) {
            Log.e(TAG, "toggleFeature: locationTest is null", new Object[0]);
        } else {
            positioningTest.toggleFeature(positioningFeature, z);
        }
    }

    public void toggleTechnology(HereLocationApiClient hereLocationApiClient, int i, boolean z) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest == null) {
            Log.e(TAG, "toggleTechnology: locationTest is null", new Object[0]);
        } else {
            positioningTest.toggleTechnology(i, z);
        }
    }
}
