package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateDialogResult;", "", "needInstallUpdate", "", "(Ljava/lang/Boolean;)V", "getNeedInstallUpdate", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/upuphone/xr/sapp/entity/GlassUpdateDialogResult;", "equals", "other", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GlassUpdateDialogResult {
    @Nullable
    private final Boolean needInstallUpdate;

    public GlassUpdateDialogResult(@Nullable Boolean bool) {
        this.needInstallUpdate = bool;
    }

    public static /* synthetic */ GlassUpdateDialogResult copy$default(GlassUpdateDialogResult glassUpdateDialogResult, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = glassUpdateDialogResult.needInstallUpdate;
        }
        return glassUpdateDialogResult.copy(bool);
    }

    @Nullable
    public final Boolean component1() {
        return this.needInstallUpdate;
    }

    @NotNull
    public final GlassUpdateDialogResult copy(@Nullable Boolean bool) {
        return new GlassUpdateDialogResult(bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GlassUpdateDialogResult) && Intrinsics.areEqual((Object) this.needInstallUpdate, (Object) ((GlassUpdateDialogResult) obj).needInstallUpdate);
    }

    @Nullable
    public final Boolean getNeedInstallUpdate() {
        return this.needInstallUpdate;
    }

    public int hashCode() {
        Boolean bool = this.needInstallUpdate;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    @NotNull
    public String toString() {
        Boolean bool = this.needInstallUpdate;
        return "GlassUpdateDialogResult(needInstallUpdate=" + bool + ")";
    }
}
