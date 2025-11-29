package com.here.services.positioning.upload.internal;

import com.here.services.internal.Manager;
import com.here.services.internal.ServiceController;
import com.here.services.positioning.upload.UploadServices;

public class UploadServicesController implements ServiceController {
    private final UploadClient mClient;

    public UploadServicesController(UploadClient uploadClient) {
        this.mClient = uploadClient;
    }

    public void connect(final ServiceController.ConnectionListener connectionListener) {
        this.mClient.connect(new Manager.ConnectionListener() {
            public void onConnected() {
                connectionListener.onServiceConnected(UploadServices.API);
            }

            public void onConnectionFailed() {
                connectionListener.onServiceConnectionFailed(UploadServices.API);
            }

            public void onDisconnected() {
                connectionListener.onServiceDisconnect(UploadServices.API);
            }
        });
    }

    public void disconnect() {
        this.mClient.disconnect();
    }

    public UploadClient getUploadClient() {
        return this.mClient;
    }
}
