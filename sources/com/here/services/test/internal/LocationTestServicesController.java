package com.here.services.test.internal;

import com.here.services.internal.Manager;
import com.here.services.internal.ServiceController;
import com.here.services.test.LocationTestServices;

public class LocationTestServicesController implements ServiceController {
    private final ILocationTest mLocationTest;

    public LocationTestServicesController(ILocationTest iLocationTest) {
        this.mLocationTest = iLocationTest;
    }

    public void connect(final ServiceController.ConnectionListener connectionListener) {
        this.mLocationTest.connect(new Manager.ConnectionListener() {
            public void onConnected() {
                connectionListener.onServiceConnected(LocationTestServices.API);
            }

            public void onConnectionFailed() {
                connectionListener.onServiceConnectionFailed(LocationTestServices.API);
            }

            public void onDisconnected() {
                connectionListener.onServiceDisconnect(LocationTestServices.API);
            }
        });
    }

    public void disconnect() {
        this.mLocationTest.disconnect();
    }

    public ILocationTest getLocationTest() {
        return this.mLocationTest;
    }
}
