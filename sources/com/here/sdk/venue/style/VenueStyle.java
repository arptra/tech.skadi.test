package com.here.sdk.venue.style;

import androidx.annotation.NonNull;
import com.here.NativeBase;
import com.here.sdk.venue.data.Shapes;
import com.here.sdk.venue.data.VenueGeometry;
import java.util.List;

public final class VenueStyle extends NativeBase {
    public VenueStyle(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                VenueStyle.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    public native void addThemeOverride(@NonNull Theme theme);

    @NonNull
    public native LabelName findLabelName(@NonNull VenueGeometry venueGeometry);

    @NonNull
    public native IconInfo getIcon(@NonNull String str);

    @NonNull
    public native VenueLabelStyle getLabelStyle(@NonNull String str);

    @NonNull
    public native List<String> getLanguages();

    @NonNull
    public native VenueGeometryStyle getStyle(@NonNull String str);

    @NonNull
    public native String getStyleNameForShape(@NonNull Shapes shapes);
}
