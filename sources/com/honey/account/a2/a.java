package com.honey.account.a2;

import com.here.sdk.core.threading.Runnable;
import com.here.sdk.location.LocationEngine;
import java.util.ArrayList;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationEngine f9175a;
    public final /* synthetic */ ArrayList b;

    public /* synthetic */ a(LocationEngine locationEngine, ArrayList arrayList) {
        this.f9175a = locationEngine;
        this.b = arrayList;
    }

    public final void run() {
        this.f9175a.lambda$updateFeatureStatus$1(this.b);
    }
}
