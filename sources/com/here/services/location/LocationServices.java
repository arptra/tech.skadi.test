package com.here.services.location;

import android.content.Context;
import com.here.odnp.util.Log;
import com.here.services.Api;
import com.here.services.internal.ServiceController;
import com.here.services.location.hybrid.HybridLocationApi;
import com.here.services.location.hybrid.HybridLocationProvider;
import com.here.services.location.inject.InjectLocationApi;
import com.here.services.location.inject.InjectLocationProvider;
import com.here.services.location.internal.LocationServicesController;
import com.here.services.location.internal.Positioning;
import com.here.services.location.network.NetworkLocationApi;
import com.here.services.location.network.NetworkLocationProvider;

public class LocationServices {
    public static final Api<Api.Options.None> API = new Api<Api.Options.None>() {
        public ServiceController createController(Context context, Api.Options options) {
            Log.v(LocationServices.TAG, "createController", new Object[0]);
            LocationServicesController locationServicesController = new LocationServicesController(Positioning.open(context));
            LocationServices.HybridLocationProvider = new HybridLocationProvider(context);
            LocationServices.NetworkLocationProvider = new NetworkLocationProvider(context);
            LocationServices.InjectLocationProvider = new InjectLocationProvider(context);
            return locationServicesController;
        }
    };
    public static HybridLocationApi HybridLocationProvider = null;
    public static InjectLocationApi InjectLocationProvider = null;
    public static NetworkLocationApi NetworkLocationProvider = null;
    private static final String TAG = "services.location.LocationServices";

    public static HybridLocationApi getHybridLocationProviderClient(Context context) {
        return new HybridLocationProvider(context);
    }

    public static InjectLocationApi getInjectLocationProviderClient(Context context) {
        return new InjectLocationProvider(context);
    }

    public static NetworkLocationApi getNetworkLocationProviderClient(Context context) {
        return new NetworkLocationProvider(context);
    }
}
