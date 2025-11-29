package com.here.sdk.location;

import com.here.services.positioning.auth.AuthApi;

public final /* synthetic */ class b implements AuthApi.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HerePositioningClient f9163a;

    public /* synthetic */ b(HerePositioningClient herePositioningClient) {
        this.f9163a = herePositioningClient;
    }

    public final void onAuthDataRequested() {
        this.f9163a.lambda$subscribeForAuthenticationRequests$1();
    }
}
