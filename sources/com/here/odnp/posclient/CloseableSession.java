package com.here.odnp.posclient;

import com.here.odnp.util.Log;

public abstract class CloseableSession implements ICloseableSession {
    private static final String TAG = "odnp.posclient.CloseableSession";
    private volatile boolean mOpened;
    protected final PosClientManager mPosClientManager;

    public CloseableSession(PosClientManager posClientManager) {
        this.mPosClientManager = posClientManager;
    }

    public void close() {
        Log.v(TAG, "close", new Object[0]);
        if (this.mOpened) {
            this.mOpened = false;
            onClose();
        }
    }

    public abstract void onClose();

    public abstract void onOpen();

    public boolean open() {
        Log.v(TAG, "open", new Object[0]);
        if (this.mOpened) {
            return true;
        }
        onOpen();
        this.mOpened = true;
        return this.mOpened;
    }
}
