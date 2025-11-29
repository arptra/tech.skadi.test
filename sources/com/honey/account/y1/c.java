package com.honey.account.y1;

import com.here.sdk.consent.ConsentActivity;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConsentActivity f9234a;

    public /* synthetic */ c(ConsentActivity consentActivity) {
        this.f9234a = consentActivity;
    }

    public final void run() {
        this.f9234a.onConsentGranted();
    }
}
