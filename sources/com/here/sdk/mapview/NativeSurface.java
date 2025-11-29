package com.here.sdk.mapview;

import android.view.Surface;

class NativeSurface {
    public static native long getNativeSurface(Surface surface);

    public static native void releaseNativeSurface(long j);
}
