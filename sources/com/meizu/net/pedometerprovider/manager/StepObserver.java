package com.meizu.net.pedometerprovider.manager;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

class StepObserver extends ContentObserver {
    private static final String TAG = "Pedo_StepObserver_";
    PedoManager manager;

    public StepObserver(Handler handler, PedoManager pedoManager) {
        super(handler);
        this.manager = pedoManager;
    }

    public boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    public void onChange(boolean z) {
        super.onChange(z);
    }

    public void onChange(boolean z, Uri uri) {
        super.onChange(z, uri);
        this.manager.notifyListener();
    }
}
