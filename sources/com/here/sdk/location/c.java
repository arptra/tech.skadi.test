package com.here.sdk.location;

import android.content.Context;
import com.here.sdk.consent.ConsentInternal;
import com.here.sdk.location.PositioningClientAndroid;

public final /* synthetic */ class c implements PositioningClientAndroid.PositionClientFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConsentInternal f9164a;

    public /* synthetic */ c(ConsentInternal consentInternal) {
        this.f9164a = consentInternal;
    }

    public final PositioningClientAndroid apply(Context context, FeatureChecker featureChecker, NetworkHolder networkHolder, String str) {
        return HerePositioningClient.lambda$fromSdkNativeEngine$0(this.f9164a, context, featureChecker, networkHolder, str);
    }
}
