package com.here.odnp.posclient.auth;

import android.util.Log;
import com.here.odnp.posclient.CloseableSession;
import com.here.odnp.posclient.PosClientManager;

public abstract class AuthSession extends CloseableSession implements IAuthSession {
    private static final String TAG = "odnp.posclient.auth.AuthSession";

    public AuthSession(PosClientManager posClientManager) {
        super(posClientManager);
    }

    public void onClose() {
        if (!this.mPosClientManager.removeAuthSession(this)) {
            Log.w(TAG, "AuthSession.onClose: session not in set.");
        }
    }

    public void onOpen() {
        this.mPosClientManager.addAuthSession(this);
    }
}
