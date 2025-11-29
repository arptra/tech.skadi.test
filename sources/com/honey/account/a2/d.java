package com.honey.account.a2;

import com.here.sdk.location.FeatureChecker;
import com.here.sdk.location.LocationEngine;
import com.here.sdk.location.LocationFeature;

public final /* synthetic */ class d implements FeatureChecker.AuthorizationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationEngine f9178a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ d(LocationEngine locationEngine, boolean z) {
        this.f9178a = locationEngine;
        this.b = z;
    }

    public final void apply(LocationFeature locationFeature, boolean z, int i) {
        this.f9178a.lambda$makeAuthorizationListener$3(this.b, locationFeature, z, i);
    }
}
