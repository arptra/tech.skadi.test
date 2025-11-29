package com.here.sdk.location;

import com.here.sdk.core.threading.Runnable;
import com.here.sdk.location.LocationEngine;
import java.util.ArrayList;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationEngine.HerePositioningClientCallbacks f9170a;
    public final /* synthetic */ ArrayList b;

    public /* synthetic */ i(LocationEngine.HerePositioningClientCallbacks herePositioningClientCallbacks, ArrayList arrayList) {
        this.f9170a = herePositioningClientCallbacks;
        this.b = arrayList;
    }

    public final void run() {
        this.f9170a.lambda$onOptionsChanged$1(this.b);
    }
}
