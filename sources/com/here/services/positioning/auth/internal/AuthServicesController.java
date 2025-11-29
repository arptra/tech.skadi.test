package com.here.services.positioning.auth.internal;

import com.here.services.internal.Manager;
import com.here.services.internal.ServiceController;
import com.here.services.positioning.auth.AuthServices;

public class AuthServicesController implements ServiceController {
    private final AuthClient mClient;

    public AuthServicesController(AuthClient authClient) {
        this.mClient = authClient;
    }

    public void connect(final ServiceController.ConnectionListener connectionListener) {
        this.mClient.connect(new Manager.ConnectionListener() {
            public void onConnected() {
                connectionListener.onServiceConnected(AuthServices.API);
            }

            public void onConnectionFailed() {
                connectionListener.onServiceConnectionFailed(AuthServices.API);
            }

            public void onDisconnected() {
                connectionListener.onServiceDisconnect(AuthServices.API);
            }
        });
    }

    public void disconnect() {
        this.mClient.disconnect();
    }

    public AuthClient getAuthClient() {
        return this.mClient;
    }
}
