package com.here.sdk.location;

import com.here.sdk.core.threading.Runnable;
import com.here.sdk.location.LocationEngine;
import java.util.ArrayList;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationEngine.HerePositioningClientCallbacks f9167a;
    public final /* synthetic */ ArrayList b;

    public /* synthetic */ f(LocationEngine.HerePositioningClientCallbacks herePositioningClientCallbacks, ArrayList arrayList) {
        this.f9167a = herePositioningClientCallbacks;
        this.b = arrayList;
    }

    public final void run() {
        this.f9167a.lambda$onFeaturesNotAvailable$3(this.b);
    }
}
