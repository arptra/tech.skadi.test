package com.here.sdk.navigation;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.core.Color;
import com.here.sdk.routing.SectionTransportMode;

public final class VisualNavigatorColors extends NativeBase {
    public VisualNavigatorColors(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VisualNavigatorColors.disposeNativeHandle(j);
            }
        });
    }

    @NonNull
    public static native VisualNavigatorColors dayColors();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public static native VisualNavigatorColors nightColors();

    @NonNull
    public native Color getManeuverArrowColor();

    @NonNull
    public native RouteProgressColors getRouteProgressColors(@NonNull SectionTransportMode sectionTransportMode);

    public native void setManeuverArrowColor(@NonNull Color color);

    public native void setRouteProgressColors(@NonNull SectionTransportMode sectionTransportMode, @NonNull RouteProgressColors routeProgressColors);
}
