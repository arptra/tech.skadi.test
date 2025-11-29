package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.NativeBase;

public final class MapLayerPriorityBuilder extends NativeBase {
    public MapLayerPriorityBuilder() {
        this(create(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    private static native long create();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    @NonNull
    public native MapLayerPriority build();

    @NonNull
    public native MapLayerPriorityBuilder renderedAfterLayer(@NonNull String str);

    @NonNull
    public native MapLayerPriorityBuilder renderedAfterLayer(@NonNull String str, @NonNull String str2);

    @NonNull
    public native MapLayerPriorityBuilder renderedBeforeLayer(@NonNull String str);

    @NonNull
    public native MapLayerPriorityBuilder renderedBeforeLayer(@NonNull String str, @NonNull String str2);

    @NonNull
    public native MapLayerPriorityBuilder renderedFirst();

    @NonNull
    public native MapLayerPriorityBuilder renderedLast();

    @NonNull
    public native MapLayerPriorityBuilder withCategory(@NonNull String str);

    public MapLayerPriorityBuilder(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MapLayerPriorityBuilder.disposeNativeHandle(j);
            }
        });
    }
}
