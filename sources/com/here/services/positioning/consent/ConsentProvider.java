package com.here.services.positioning.consent;

import android.content.Context;
import com.here.odnp.util.Log;
import com.here.posclient.ConsentState;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.positioning.consent.internal.ConsentClient;
import com.here.services.positioning.consent.internal.ConsentServicesController;

public class ConsentProvider implements ConsentApi {
    private static final String TAG = "services.positioning.consent.ConsentProvider";
    private final ServiceController.Provider<ConsentServicesController> mProvider;

    public ConsentProvider(Context context, ServiceController.Provider<ConsentServicesController> provider) {
        if (provider != null) {
            this.mProvider = provider;
            return;
        }
        throw new IllegalArgumentException("provider is null");
    }

    public ConsentClient getClient(HereLocationApiClient hereLocationApiClient) {
        ConsentServicesController controller = this.mProvider.getController(hereLocationApiClient);
        if (controller != null) {
            return controller.getConsentClient();
        }
        Log.e(TAG, "getClient: controller is null, consent client instance not available", new Object[0]);
        return null;
    }

    public void onConsentUpdated(HereLocationApiClient hereLocationApiClient, ConsentState consentState) {
        ConsentClient client = getClient(hereLocationApiClient);
        if (client != null) {
            client.onConsentUpdated(consentState);
        }
    }
}
