package com.here.sdk.consent;

import androidx.annotation.NonNull;
import com.here.sdk.consent.Consent;
import com.here.sdk.core.engine.SDKNativeEngine;
import com.here.sdk.core.errors.InstantiationErrorException;

public class ConsentEngine implements Consent {
    private final ConsentEngineInternal mConsentEngine;

    public ConsentEngine() throws InstantiationErrorException {
        this.mConsentEngine = new ConsentEngineInternal();
    }

    @NonNull
    public ConsentStatus denyUserConsent() {
        return this.mConsentEngine.denyUserConsent();
    }

    @NonNull
    public Consent.UserReply getUserConsentState() {
        return this.mConsentEngine.getUserConsentState();
    }

    @NonNull
    public ConsentStatus grantUserConsent() {
        return this.mConsentEngine.grantUserConsent();
    }

    @NonNull
    public ConsentStatus requestUserConsent() {
        return this.mConsentEngine.requestUserConsent();
    }

    public ConsentEngine(@NonNull SDKNativeEngine sDKNativeEngine) throws InstantiationErrorException {
        this.mConsentEngine = new ConsentEngineInternal(sDKNativeEngine);
    }
}
