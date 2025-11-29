package com.here.services.location.internal;

import com.here.services.internal.Manager;
import com.here.services.internal.ServiceController;
import com.here.services.location.LocationServices;

public class LocationServicesController implements ServiceController {
    private final IPositioning mPositioning;

    public LocationServicesController(IPositioning iPositioning) {
        this.mPositioning = iPositioning;
    }

    public void connect(final ServiceController.ConnectionListener connectionListener) {
        this.mPositioning.connect(new Manager.ConnectionListener() {
            public void onConnected() {
                connectionListener.onServiceConnected(LocationServices.API);
            }

            public void onConnectionFailed() {
                connectionListener.onServiceConnectionFailed(LocationServices.API);
            }

            public void onDisconnected() {
                connectionListener.onServiceDisconnect(LocationServices.API);
            }
        });
    }

    public void disconnect() {
        this.mPositioning.disconnect();
    }

    public IPositioning getPositioning() {
        return this.mPositioning;
    }
}
