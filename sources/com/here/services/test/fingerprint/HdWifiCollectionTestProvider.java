package com.here.services.test.fingerprint;

import android.content.Context;
import com.here.odnp.util.Log;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.test.fingerprint.HdWifiCollectionTestApi;
import com.here.services.test.internal.ILocationTest;
import com.here.services.test.internal.LocationTestServicesController;

public class HdWifiCollectionTestProvider implements HdWifiCollectionTestApi {
    private static final String TAG = "services.test.fingerprint.HdWifiCollectionTestProvider";
    final ServiceController.Provider<LocationTestServicesController> mProvider;

    public HdWifiCollectionTestProvider(Context context, ServiceController.Provider<LocationTestServicesController> provider) {
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

    public void overrideConfiguration(HereLocationApiClient hereLocationApiClient, String str) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest == null) {
            Log.e(TAG, "overrideConfiguration: positioningTest is null", new Object[0]);
        } else {
            positioningTest.overrideConfiguration(str);
        }
    }

    public boolean registerStateListener(HereLocationApiClient hereLocationApiClient, HdWifiCollectionTestApi.StateListener stateListener) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest != null) {
            return positioningTest.registerHdWifiStateListener(stateListener);
        }
        Log.e(TAG, "registerStateListener: positioningTest is null", new Object[0]);
        return false;
    }

    public void setUsername(HereLocationApiClient hereLocationApiClient, String str) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest == null) {
            Log.e(TAG, "setUsername: positioningTest is null", new Object[0]);
        } else {
            positioningTest.setUsername(str);
        }
    }

    public void unregisterStateListener(HereLocationApiClient hereLocationApiClient, HdWifiCollectionTestApi.StateListener stateListener) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest == null) {
            Log.e(TAG, "unregisterStateListener: positioningTest is null", new Object[0]);
        } else {
            positioningTest.unregisterHdWifiStateListener(stateListener);
        }
    }
}
