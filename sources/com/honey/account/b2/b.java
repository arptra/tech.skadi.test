package com.honey.account.b2;

import com.here.sdk.mapview.MapSurface;
import com.here.sdk.mapview.MapView;
import com.here.sdk.mapview.MapViewInternalHsdk;

public final /* synthetic */ class b implements MapViewInternalHsdk.TakeScreenshotCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MapView.TakeScreenshotCallback f9180a;

    public /* synthetic */ b(MapView.TakeScreenshotCallback takeScreenshotCallback) {
        this.f9180a = takeScreenshotCallback;
    }

    public final void onScreenshotTaken(byte[] bArr) {
        MapSurface.lambda$takeScreenshot$3(this.f9180a, bArr);
    }
}
