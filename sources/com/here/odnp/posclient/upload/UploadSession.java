package com.here.odnp.posclient.upload;

import android.util.Log;
import com.here.odnp.posclient.CloseableSession;
import com.here.odnp.posclient.PosClientManager;

public abstract class UploadSession extends CloseableSession implements IUploadSession {
    private static final String TAG = "odnp.posclient.upload.UploadSession";

    public UploadSession(PosClientManager posClientManager) {
        super(posClientManager);
    }

    public void onClose() {
        if (!this.mPosClientManager.removeUploadSession(this)) {
            Log.w(TAG, "UploadSession.onClose: session not in set.");
        }
    }

    public void onOpen() {
        this.mPosClientManager.addUploadSession(this);
    }
}
