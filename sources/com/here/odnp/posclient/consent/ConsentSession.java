package com.here.odnp.posclient.consent;

import android.util.Log;
import com.here.odnp.posclient.CloseableSession;
import com.here.odnp.posclient.PosClientManager;

public abstract class ConsentSession extends CloseableSession implements IConsentSession {
    private static final String TAG = "odnp.posclient.consent.ConsentSession";

    public ConsentSession(PosClientManager posClientManager) {
        super(posClientManager);
    }

    public void onClose() {
        if (!this.mPosClientManager.removeConsentSession(this)) {
            Log.w(TAG, "ConsentSession.onClose: session not in set.");
        }
    }

    public void onOpen() {
        this.mPosClientManager.addConsentSession(this);
    }
}
