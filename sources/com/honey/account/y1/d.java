package com.honey.account.y1;

import com.here.sdk.consent.ConsentActivity;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConsentActivity f9235a;

    public /* synthetic */ d(ConsentActivity consentActivity) {
        this.f9235a = consentActivity;
    }

    public final void run() {
        this.f9235a.onConsentDenied();
    }
}
