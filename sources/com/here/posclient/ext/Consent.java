package com.here.posclient.ext;

public class Consent {
    private Consent() {
    }

    public static native void onConsentUpdated(int i);
}
