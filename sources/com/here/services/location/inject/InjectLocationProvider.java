package com.here.services.location.inject;

import android.content.Context;
import android.location.Location;
import androidx.annotation.NonNull;
import com.here.odnp.util.Log;
import com.here.posclient.PositioningFeature;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.location.LocationListener;
import com.here.services.location.LocationServices;
import com.here.services.location.internal.IPositioning;
import com.here.services.location.internal.ListenerProxy;
import com.here.services.location.internal.LocationServicesController;
import java.util.HashMap;
import java.util.Map;

public class InjectLocationProvider implements InjectLocationApi {
    private static final String TAG = "services.location.inject.InjectLocationProvider";
    private final Map<LocationListener, ListenerProxy> mListenerProxies = new HashMap();
    private final ServiceController.Provider<LocationServicesController> mProvider = new ServiceController.Provider<LocationServicesController>() {
        public LocationServicesController getController(HereLocationApiClient hereLocationApiClient) {
            try {
                return (LocationServicesController) hereLocationApiClient.getServiceController(LocationServices.API);
            } catch (Exception unused) {
                return null;
            }
        }
    };

    public InjectLocationProvider(@NonNull Context context) {
    }

    public int availableFeatures(@NonNull HereLocationApiClient hereLocationApiClient) {
        Log.v(TAG, "availableFeatures", new Object[0]);
        return (int) PositioningFeature.None.value;
    }

    public int enabledFeatures(@NonNull HereLocationApiClient hereLocationApiClient) {
        Log.v(TAG, "enabledFeatures", new Object[0]);
        return (int) PositioningFeature.None.value;
    }

    public Location getLastLocation(@NonNull HereLocationApiClient hereLocationApiClient) {
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

    public boolean injectLocation(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull Location location) {
        IPositioning positioning = getPositioning(hereLocationApiClient);
        if (positioning != null) {
            return positioning.injectLocation(location);
        }
        Log.e(TAG, "injectLocation: IPositioning is null", new Object[0]);
        return false;
    }

    public boolean startInjectionUpdates(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull LocationListener locationListener) {
        IPositioning positioning = getPositioning(hereLocationApiClient);
        if (positioning == null) {
            Log.e(TAG, "startInjectionUpdates: IPositioning is null", new Object[0]);
            return false;
        }
        ListenerProxy listenerProxy = this.mListenerProxies.get(locationListener);
        if (listenerProxy == null) {
            listenerProxy = new ListenerProxy(locationListener);
            this.mListenerProxies.put(locationListener, listenerProxy);
        }
        if (positioning.startInjectionUpdates(listenerProxy)) {
            return true;
        }
        this.mListenerProxies.remove(locationListener);
        return false;
    }

    public void stopInjectionUpdates(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull LocationListener locationListener) {
        IPositioning positioning = getPositioning(hereLocationApiClient);
        if (positioning == null) {
            Log.e(TAG, "stopInjectionUpdates: IPositioning is null", new Object[0]);
            return;
        }
        ListenerProxy remove = this.mListenerProxies.remove(locationListener);
        if (remove == null) {
            Log.e(TAG, "stopInjectionUpdates: Listener proxy is null, are location updates started for this listener?", new Object[0]);
        } else {
            positioning.stopPositionUpdates(remove);
        }
    }

    public void stopLocationUpdates(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull LocationListener locationListener) {
    }

    public void toggleFeature(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull PositioningFeature positioningFeature, boolean z) {
    }
}
