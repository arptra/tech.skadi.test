package com.here.services.crowdsource.hd.internal;

import com.here.services.crowdsource.CrowdsourceServices;
import com.here.services.internal.Manager;
import com.here.services.internal.ServiceController;

public class HdWifiCollectionServicesController implements ServiceController {
    private final HdWifiCollectionClient mClient;

    public HdWifiCollectionServicesController(HdWifiCollectionClient hdWifiCollectionClient) {
        this.mClient = hdWifiCollectionClient;
    }

    public void connect(final ServiceController.ConnectionListener connectionListener) {
        this.mClient.connect(new Manager.ConnectionListener() {
            public void onConnected() {
                connectionListener.onServiceConnected(CrowdsourceServices.API);
            }

            public void onConnectionFailed() {
                connectionListener.onServiceConnectionFailed(CrowdsourceServices.API);
            }

            public void onDisconnected() {
                connectionListener.onServiceDisconnect(CrowdsourceServices.API);
            }
        });
    }

    public void disconnect() {
        this.mClient.disconnect();
    }

    public HdWifiCollectionClient getHdWifiCollectionClient() {
        return this.mClient;
    }
}
