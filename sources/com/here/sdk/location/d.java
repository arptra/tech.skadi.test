package com.here.sdk.location;

import android.location.Location;
import com.here.sdk.location.HerePositioningClient;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HerePositioningClient.LocationListenerImpl f9165a;
    public final /* synthetic */ Location b;

    public /* synthetic */ d(HerePositioningClient.LocationListenerImpl locationListenerImpl, Location location) {
        this.f9165a = locationListenerImpl;
        this.b = location;
    }

    public final void run() {
        this.f9165a.lambda$onLocationChanged$0(this.b);
    }
}
