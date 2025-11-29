package com.here.services.positioning.analytics.internal;

import com.here.services.internal.Manager;
import com.here.services.internal.ServiceController;
import com.here.services.positioning.analytics.UsageTrackingServices;

public class UsageTrackingServicesController implements ServiceController {
    private final UsageTrackingClient mClient;

    public UsageTrackingServicesController(UsageTrackingClient usageTrackingClient) {
        this.mClient = usageTrackingClient;
    }

    public void connect(final ServiceController.ConnectionListener connectionListener) {
        this.mClient.connect(new Manager.ConnectionListener() {
            public void onConnected() {
                connectionListener.onServiceConnected(UsageTrackingServices.API);
            }

            public void onConnectionFailed() {
                connectionListener.onServiceConnectionFailed(UsageTrackingServices.API);
            }

            public void onDisconnected() {
                connectionListener.onServiceDisconnect(UsageTrackingServices.API);
            }
        });
    }

    public void disconnect() {
        this.mClient.disconnect();
    }

    public UsageTrackingClient getUsageTrackingClient() {
        return this.mClient;
    }
}
