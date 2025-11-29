package com.here.services.positioning.consent;

import com.here.posclient.ConsentState;
import com.here.services.HereLocationApiClient;

public interface ConsentApi {
    void onConsentUpdated(HereLocationApiClient hereLocationApiClient, ConsentState consentState);
}
