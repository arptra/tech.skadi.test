package com.here.services.radiomap.internal;

import com.here.services.internal.Manager;
import com.here.services.internal.ServiceController;
import com.here.services.radiomap.RadioMapServices;

public class RadioMapServicesController implements ServiceController {
    private final IRadioMapManager mRadioMapManager;

    public RadioMapServicesController(IRadioMapManager iRadioMapManager) {
        this.mRadioMapManager = iRadioMapManager;
    }

    public void connect(final ServiceController.ConnectionListener connectionListener) {
        this.mRadioMapManager.connect(new Manager.ConnectionListener() {
            public void onConnected() {
                connectionListener.onServiceConnected(RadioMapServices.API);
            }

            public void onConnectionFailed() {
                connectionListener.onServiceConnectionFailed(RadioMapServices.API);
            }

            public void onDisconnected() {
                connectionListener.onServiceDisconnect(RadioMapServices.API);
            }
        });
    }

    public void disconnect() {
        this.mRadioMapManager.disconnect();
    }

    public IRadioMapManager getRadioMapManager() {
        return this.mRadioMapManager;
    }
}
