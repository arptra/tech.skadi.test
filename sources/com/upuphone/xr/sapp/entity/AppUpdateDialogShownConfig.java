package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/entity/AppUpdateDialogShownConfig;", "", "version", "", "count", "", "(Ljava/lang/String;I)V", "getCount", "()I", "getVersion", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AppUpdateDialogShownConfig {
    private final int count;
    @NotNull
    private final String version;

    public AppUpdateDialogShownConfig(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "version");
        this.version = str;
        this.count = i;
    }

    public static /* synthetic */ AppUpdateDialogShownConfig copy$default(AppUpdateDialogShownConfig appUpdateDialogShownConfig, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = appUpdateDialogShownConfig.version;
        }
        if ((i2 & 2) != 0) {
            i = appUpdateDialogShownConfig.count;
        }
        return appUpdateDialogShownConfig.copy(str, i);
    }

    @NotNull
    public final String component1() {
        return this.version;
    }

    public final int component2() {
        return this.count;
    }

    @NotNull
    public final AppUpdateDialogShownConfig copy(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "version");
        return new AppUpdateDialogShownConfig(str, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppUpdateDialogShownConfig)) {
            return false;
        }
        AppUpdateDialogShownConfig appUpdateDialogShownConfig = (AppUpdateDialogShownConfig) obj;
        return Intrinsics.areEqual((Object) this.version, (Object) appUpdateDialogShownConfig.version) && this.count == appUpdateDialogShownConfig.count;
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (this.version.hashCode() * 31) + Integer.hashCode(this.count);
    }

    @NotNull
    public String toString() {
        String str = this.version;
        int i = this.count;
        return "AppUpdateDialogShownConfig(version=" + str + ", count=" + i + ")";
    }
}
