package com.here.services.positioning.consent.internal;

import android.content.Intent;
import com.here.odnp.posclient.IPosClientManager;
import com.here.odnp.posclient.consent.IConsentSession;
import com.here.odnp.util.Log;
import com.here.posclient.ConsentState;
import com.here.services.internal.IBoundService;
import com.here.services.positioning.consent.internal.IConsentClient;

public class ConsentClientService extends IConsentClient.Stub implements IBoundService {
    private static final String TAG = "services.positioning.consent.internal.ConsentClientService";
    private final IConsentSession mSession;

    public ConsentClientService(IPosClientManager iPosClientManager, Intent intent) {
        Log.i(TAG, "ConsentClientService", new Object[0]);
        if (iPosClientManager != null) {
            this.mSession = iPosClientManager.createConsentSession();
            return;
        }
        throw new IllegalArgumentException("posClientManager is null");
    }

    public void onConsentUpdated(int i) {
        Log.i(TAG, "onConsentUpdated", new Object[0]);
        this.mSession.onConsentUpdated(ConsentState.fromInt(i));
    }

    public void unBind() {
    }
}
