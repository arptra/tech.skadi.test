package com.here.sdk.consent;

import androidx.annotation.NonNull;

public interface ConsentListener {
    void onConsentUpdated(@NonNull ConsentFeature consentFeature, @NonNull ConsentState consentState);
}
