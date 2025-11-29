package com.here.sdk.location;

import com.here.sdk.core.Location;
import com.here.sdk.core.threading.Runnable;
import com.here.sdk.location.LocationEngine;
import java.util.ArrayList;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationEngine.HerePositioningClientCallbacks f9169a;
    public final /* synthetic */ Location b;
    public final /* synthetic */ ArrayList c;

    public /* synthetic */ h(LocationEngine.HerePositioningClientCallbacks herePositioningClientCallbacks, Location location, ArrayList arrayList) {
        this.f9169a = herePositioningClientCallbacks;
        this.b = location;
        this.c = arrayList;
    }

    public final void run() {
        this.f9169a.lambda$onLocationChanged$0(this.b, this.c);
    }
}
