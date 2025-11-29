package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.NativeBase;
import com.here.sdk.core.Point3D;

public class MeshBuilder extends NativeBase {
    public MeshBuilder() {
        this(make(), (Object) null);
        cacheThisInstance();
    }

    private native void cacheThisInstance();

    /* access modifiers changed from: private */
    public static native void disposeNativeHandle(long j);

    private static native long make();

    @Nullable
    public native Mesh build();

    @NonNull
    public native QuadMeshBuilder quad(@NonNull Point3D point3D, @NonNull Point3D point3D2, @NonNull Point3D point3D3, @NonNull Point3D point3D4);

    @NonNull
    public native TriangleMeshBuilder triangle(@NonNull Point3D point3D, @NonNull Point3D point3D2, @NonNull Point3D point3D3);

    public MeshBuilder(long j, Object obj) {
        super(j, new NativeBase.Disposer() {
            public void disposeNative(long j) {
                MeshBuilder.disposeNativeHandle(j);
            }
        });
    }
}
