package com.here.sdk.location;

import com.here.sdk.core.AuthenticationCallback;
import com.here.sdk.core.AuthenticationData;
import com.here.sdk.core.AuthenticationError;
import com.here.sdk.location.LocationEngine;
import com.here.sdk.location.PositioningClientListener;

public final /* synthetic */ class g implements AuthenticationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationEngine.HerePositioningClientCallbacks f9168a;
    public final /* synthetic */ PositioningClientListener.OnAuthDataReceivedListener b;

    public /* synthetic */ g(LocationEngine.HerePositioningClientCallbacks herePositioningClientCallbacks, PositioningClientListener.OnAuthDataReceivedListener onAuthDataReceivedListener) {
        this.f9168a = herePositioningClientCallbacks;
        this.b = onAuthDataReceivedListener;
    }

    public final void onTokenReceived(AuthenticationError authenticationError, AuthenticationData authenticationData) {
        this.f9168a.lambda$updateAuthentication$2(this.b, authenticationError, authenticationData);
    }
}
