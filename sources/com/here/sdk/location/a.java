package com.here.sdk.location;

import com.here.posclient.auth.AuthData;
import com.here.sdk.location.PositioningClientListener;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class a implements PositioningClientListener.OnAuthDataReceivedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HerePositioningClient f9162a;
    public final /* synthetic */ AtomicBoolean b;

    public /* synthetic */ a(HerePositioningClient herePositioningClient, AtomicBoolean atomicBoolean) {
        this.f9162a = herePositioningClient;
        this.b = atomicBoolean;
    }

    public final void onAuthDataReceived(AuthData authData) {
        this.f9162a.lambda$refreshAuthenticationData$2(this.b, authData);
    }
}
