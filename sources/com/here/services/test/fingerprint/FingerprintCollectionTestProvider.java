package com.here.services.test.fingerprint;

import android.content.Context;
import com.here.odnp.util.Log;
import com.here.posclient.Status;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.test.fingerprint.FingerprintCollectionTestApi;
import com.here.services.test.internal.ILocationTest;
import com.here.services.test.internal.LocationTestServicesController;

public class FingerprintCollectionTestProvider implements FingerprintCollectionTestApi {
    private static final String TAG = "services.test.fingerprint.FingerprintCollectionTestProvider";
    final ServiceController.Provider<LocationTestServicesController> mProvider;

    public FingerprintCollectionTestProvider(Context context, ServiceController.Provider<LocationTestServicesController> provider) {
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

    public void dumpFingerprints(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest == null) {
            Log.e(TAG, "dumpFingerprints: positioningTest is null", new Object[0]);
        } else {
            positioningTest.dumpFingerprints();
        }
    }

    public boolean getActiveCollection(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest != null) {
            return positioningTest.getActiveCollection();
        }
        Log.e(TAG, "getActiveCollection: positioningTest is null", new Object[0]);
        return false;
    }

    public boolean getAutoUpload(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest != null) {
            return positioningTest.getAutoUpload();
        }
        Log.e(TAG, "getAutoUpload: positioningTest is null", new Object[0]);
        return false;
    }

    public Status getCollectionStats(HereLocationApiClient hereLocationApiClient, FingerprintCollectionTestApi.StatsListener statsListener) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest != null) {
            return positioningTest.getCollectionStats(statsListener);
        }
        Log.e(TAG, "getCollectionStats: positioningTest is null", new Object[0]);
        return Status.GeneralError;
    }

    public boolean getCollectionStatus(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest != null) {
            return positioningTest.getCollectionStatus();
        }
        Log.e(TAG, "getCollectionStatus: positioningTest is null", new Object[0]);
        return false;
    }

    public long getGnssFingerprintCount(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest != null) {
            return positioningTest.getGnssFingerprintCount();
        }
        Log.e(TAG, "getGnssFingerprintCount: positioningTest is null", new Object[0]);
        return 0;
    }

    public long getNonGnssFingerprintCount(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest != null) {
            return positioningTest.getNonGnssFingerprintCount();
        }
        Log.e(TAG, "getNonGnssFingerprintCount: positioningTest is null", new Object[0]);
        return 0;
    }

    public void sendFingerprints(HereLocationApiClient hereLocationApiClient) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest == null) {
            Log.e(TAG, "sendFingerprints: positioningTest is null", new Object[0]);
        } else {
            positioningTest.sendFingerprints();
        }
    }

    public boolean setActiveCollection(HereLocationApiClient hereLocationApiClient, boolean z) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest != null) {
            return positioningTest.setActiveCollection(z);
        }
        Log.e(TAG, "setActiveCollection: positioningTest is null", new Object[0]);
        return false;
    }

    public boolean setAutoUpload(HereLocationApiClient hereLocationApiClient, boolean z) {
        ILocationTest positioningTest = getPositioningTest(hereLocationApiClient);
        if (positioningTest != null) {
            return positioningTest.setAutoUpload(z);
        }
        Log.e(TAG, "setAutoUpload: positioningTest is null", new Object[0]);
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
}
