package com.here.services.positioning.consent.internal;

import com.here.services.internal.Manager;
import com.here.services.internal.ServiceController;
import com.here.services.positioning.consent.ConsentServices;

public class ConsentServicesController implements ServiceController {
    private final ConsentClient mClient;

    public ConsentServicesController(ConsentClient consentClient) {
        this.mClient = consentClient;
    }

    public void connect(final ServiceController.ConnectionListener connectionListener) {
        this.mClient.connect(new Manager.ConnectionListener() {
            public void onConnected() {
                connectionListener.onServiceConnected(ConsentServices.API);
            }

            public void onConnectionFailed() {
                connectionListener.onServiceConnectionFailed(ConsentServices.API);
            }

            public void onDisconnected() {
                connectionListener.onServiceDisconnect(ConsentServices.API);
            }
        });
    }

    public void disconnect() {
        this.mClient.disconnect();
    }

    public ConsentClient getConsentClient() {
        return this.mClient;
    }
}
