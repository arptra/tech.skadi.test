package com.honey.account.a2;

import com.here.sdk.core.threading.Runnable;
import com.here.sdk.location.LocationEngine;
import java.util.ArrayList;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationEngine f9177a;
    public final /* synthetic */ ArrayList b;

    public /* synthetic */ c(LocationEngine locationEngine, ArrayList arrayList) {
        this.f9177a = locationEngine;
        this.b = arrayList;
    }

    public final void run() {
        this.f9177a.lambda$addLocationIssue$2(this.b);
    }
}
