package com.here.sdk.venue.control;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.venue.data.VenueDrawing;
import com.here.sdk.venue.data.VenueGeometry;
import com.here.sdk.venue.data.VenueLevel;
import com.here.sdk.venue.data.VenueModel;
import com.here.sdk.venue.style.VenueGeometryStyle;
import com.here.sdk.venue.style.VenueLabelStyle;
import com.here.sdk.venue.style.VenueStyle;
import java.util.List;

public final class Venue extends NativeBase {
    public Venue(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                Venue.disposeNativeHandle(j);
            }
        });
    }

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native VenueDrawing getSelectedDrawing();

    @NonNull
    public native VenueLevel getSelectedLevel();

    public native int getSelectedLevelIndex();

    public native int getSelectedLevelZIndex();

    @NonNull
    public native VenueModel getVenueModel();

    @NonNull
    public native VenueStyle getVenueStyle();

    public native boolean isTopologyVisible();

    public native void setCustomStyle(@NonNull List<VenueGeometry> list, @Nullable VenueGeometryStyle venueGeometryStyle, @Nullable VenueLabelStyle venueLabelStyle);

    public native void setSelectedDrawing(@NonNull VenueDrawing venueDrawing);

    public native void setSelectedLevel(@NonNull VenueLevel venueLevel);

    public native void setSelectedLevelIndex(int i);

    public native void setSelectedLevelZIndex(int i);

    public native void setTopologyVisible(boolean z);
}
