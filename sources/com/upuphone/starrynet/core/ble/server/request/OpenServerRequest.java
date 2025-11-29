package com.upuphone.starrynet.core.ble.server.request;

import com.upuphone.starrynet.core.ble.server.listener.OpenServerListener;
import com.upuphone.starrynet.core.ble.server.reponse.BleServerResponser;

public class OpenServerRequest extends BleServerRequest implements OpenServerListener {
    public OpenServerRequest(BleServerResponser bleServerResponser) {
        super((String) null, bleServerResponser);
    }

    public long getTimeoutInMillis() {
        return 11000;
    }

    public void onResult(int i) {
        stopRequestTiming();
        onRequestCompleted(i);
    }

    public void processRequest() {
        if (!isServerOpened()) {
            openServer();
            startRequestTiming();
            return;
        }
        onRequestCompleted(0);
    }
}
