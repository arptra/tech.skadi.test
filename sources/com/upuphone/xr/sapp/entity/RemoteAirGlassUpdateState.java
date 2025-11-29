package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/entity/RemoteAirGlassUpdateState;", "", "isUpdating", "", "(Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/upuphone/xr/sapp/entity/RemoteAirGlassUpdateState;", "equals", "other", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class RemoteAirGlassUpdateState {
    @Nullable
    private final Boolean isUpdating;

    public RemoteAirGlassUpdateState(@Nullable Boolean bool) {
        this.isUpdating = bool;
    }

    public static /* synthetic */ RemoteAirGlassUpdateState copy$default(RemoteAirGlassUpdateState remoteAirGlassUpdateState, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = remoteAirGlassUpdateState.isUpdating;
        }
        return remoteAirGlassUpdateState.copy(bool);
    }

    @Nullable
    public final Boolean component1() {
        return this.isUpdating;
    }

    @NotNull
    public final RemoteAirGlassUpdateState copy(@Nullable Boolean bool) {
        return new RemoteAirGlassUpdateState(bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RemoteAirGlassUpdateState) && Intrinsics.areEqual((Object) this.isUpdating, (Object) ((RemoteAirGlassUpdateState) obj).isUpdating);
    }

    public int hashCode() {
        Boolean bool = this.isUpdating;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    @Nullable
    public final Boolean isUpdating() {
        return this.isUpdating;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.isUpdating;
        return "RemoteAirGlassUpdateState(isUpdating=" + bool + ")";
    }
}
