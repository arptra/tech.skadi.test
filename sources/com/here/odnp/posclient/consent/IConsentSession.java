package com.here.odnp.posclient.consent;

import com.here.odnp.posclient.ICloseableSession;
import com.here.posclient.ConsentState;

public interface IConsentSession extends ICloseableSession {
    void onConsentUpdated(ConsentState consentState);
}
