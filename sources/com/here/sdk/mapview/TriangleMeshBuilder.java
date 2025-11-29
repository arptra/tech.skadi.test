package com.here.sdk.mapview;

import androidx.annotation.NonNull;
import com.here.sdk.core.Anchor2D;

public final class TriangleMeshBuilder extends MeshBuilder {
    public TriangleMeshBuilder(long j, Object obj) {
        super(j, obj);
    }

    @NonNull
    public native MeshBuilder withTextureCoordinates(@NonNull Anchor2D anchor2D, @NonNull Anchor2D anchor2D2, @NonNull Anchor2D anchor2D3);
}
