package com.honey.account.a2;

import com.here.sdk.core.threading.Runnable;
import com.here.sdk.location.LocationEngine;
import com.here.sdk.location.LocationEngineStatus;
import java.util.ArrayList;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationEngine f9176a;
    public final /* synthetic */ LocationEngineStatus b;
    public final /* synthetic */ ArrayList c;

    public /* synthetic */ b(LocationEngine locationEngine, LocationEngineStatus locationEngineStatus, ArrayList arrayList) {
        this.f9176a = locationEngine;
        this.b = locationEngineStatus;
        this.c = arrayList;
    }

    public final void run() {
        this.f9176a.lambda$updateStatus$0(this.b, this.c);
    }
}
