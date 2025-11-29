package com.here.services.location;

import android.location.Location;
import com.here.odnp.util.Log;
import com.here.posclient.PositioningFeature;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.location.internal.IPositioning;
import com.here.services.location.internal.ListenerProxy;
import com.here.services.location.internal.LocationServicesController;
import java.util.HashMap;
import java.util.Map;

public class LocationProviderBase implements LocationApi {
    private static final String TAG = "services.location.LocationProviderBase";
    protected final Map<LocationListener, ListenerProxy> mListenerProxies = new HashMap();
    private final ServiceController.Provider<LocationServicesController> mProvider = new ServiceController.Provider<LocationServicesController>() {
        public LocationServicesController getController(HereLocationApiClient hereLocationApiClient) {
            try {
                return (LocationServicesController) hereLocationApiClient.getServiceController(LocationServices.API);
            } catch (Exception unused) {
                return null;
            }
        }
    };

    public int availableFeatures(HereLocationApiClient hereLocationApiClient) {
        IPositioning positioning = getPositioning(hereLocationApiClient);
        if (positioning != null) {
            return positioning.availableFeatures();
        }
        Log.e(TAG, "availableFeatures: IPositioning is null", new Object[0]);
        return (int) PositioningFeature.None.value;
    }

    public int enabledFeatures(HereLocationApiClient hereLocationApiClient) {
        IPositioning positioning = getPositioning(hereLocationApiClient);
        if (positioning != null) {
            return positioning.enabledFeatures();
        }
        Log.e(TAG, "enabledFeatures: IPositioning is null", new Object[0]);
        return (int) PositioningFeature.None.value;
    }

    public Location getLastLocation(HereLocationApiClient hereLocationApiClient) {
        IPositioning positioning = getPositioning(hereLocationApiClient);
        if (positioning == null) {
            return null;
        }
        return positioning.getLastPosition();
    }

    public IPositioning getPositioning(HereLocationApiClient hereLocationApiClient) {
        LocationServicesController controller = this.mProvider.getController(hereLocationApiClient);
        if (controller != null) {
            return controller.getPositioning();
        }
        Log.e(TAG, "getPositioning: controller is null, positioning instance not available", new Object[0]);
        return null;
    }

    public synchronized void stopLocationUpdates(HereLocationApiClient hereLocationApiClient, LocationListener locationListener) {
        IPositioning positioning = getPositioning(hereLocationApiClient);
        if (positioning == null) {
            Log.e(TAG, "stopLocationUpdates: IPositioning is null", new Object[0]);
            return;
        }
        ListenerProxy remove = this.mListenerProxies.remove(locationListener);
        if (remove == null) {
            Log.e(TAG, "stopLocationUpdates: Listener proxy is null, are location updates started for this listener?", new Object[0]);
        } else {
            positioning.stopPositionUpdates(remove);
        }
    }

    public void toggleFeature(HereLocationApiClient hereLocationApiClient, PositioningFeature positioningFeature, boolean z) {
        IPositioning positioning = getPositioning(hereLocationApiClient);
        if (positioning == null) {
            Log.e(TAG, "toggleFeature: IPositioning is null", new Object[0]);
        } else {
            positioning.toggleFeature(positioningFeature, z);
        }
    }
}
