package com.upuphone.xr.sapp.entity;

import com.upuphone.xr.sapp.entity.GlassUpdateState;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0017\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, d2 = {"isUpdating", "", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "(Lcom/upuphone/xr/sapp/entity/GlassUpdateState;)Z", "app_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class GlassUpdateStateKt {
    public static final boolean isUpdating(@Nullable GlassUpdateState glassUpdateState) {
        if (glassUpdateState instanceof GlassUpdateState.StarTransferring ? true : glassUpdateState instanceof GlassUpdateState.AirTransferring) {
            return true;
        }
        return glassUpdateState instanceof GlassUpdateState.Installing;
    }
}
