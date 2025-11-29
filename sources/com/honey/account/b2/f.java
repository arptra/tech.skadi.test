package com.honey.account.b2;

import com.here.sdk.mapview.MapView;
import com.here.sdk.mapview.MapViewInternalHsdk;

public final /* synthetic */ class f implements MapViewInternalHsdk.TakeScreenshotCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MapView.TakeScreenshotCallback f9184a;

    public /* synthetic */ f(MapView.TakeScreenshotCallback takeScreenshotCallback) {
        this.f9184a = takeScreenshotCallback;
    }

    public final void onScreenshotTaken(byte[] bArr) {
        MapView.lambda$takeScreenshot$1(this.f9184a, bArr);
    }
}
