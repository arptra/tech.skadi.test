package com.here.sdk.location;

import com.here.sdk.core.threading.Runnable;
import com.here.sdk.location.LocationEngine;
import java.util.ArrayList;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationEngine.HerePositioningClientCallbacks f9166a;
    public final /* synthetic */ ArrayList b;

    public /* synthetic */ e(LocationEngine.HerePositioningClientCallbacks herePositioningClientCallbacks, ArrayList arrayList) {
        this.f9166a = herePositioningClientCallbacks;
        this.b = arrayList;
    }

    public final void run() {
        this.f9166a.lambda$onLocationIssueChanged$4(this.b);
    }
}
