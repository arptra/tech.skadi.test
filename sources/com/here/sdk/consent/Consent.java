package com.here.sdk.consent;

import androidx.annotation.NonNull;

public interface Consent {

    public enum UserReply {
        GRANTED(0),
        DENIED(1),
        NOT_HANDLED(2),
        REQUESTING(3);
        
        public final int value;

        private UserReply(int i) {
            this.value = i;
        }
    }

    @NonNull
    ConsentStatus denyUserConsent();

    @NonNull
    UserReply getUserConsentState();

    @NonNull
    ConsentStatus grantUserConsent();

    @NonNull
    ConsentStatus requestUserConsent();
}
