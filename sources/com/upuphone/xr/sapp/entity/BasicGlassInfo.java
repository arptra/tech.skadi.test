package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\nR\u0012\u0010\u0012\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\u0012\u0010\u0014\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\nR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\n\u0001\u0002\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "", "()V", "battery", "", "getBattery", "()I", "buildType", "", "getBuildType", "()Ljava/lang/String;", "displayName", "getDisplayName", "isCharging", "", "()Z", "model", "getModel", "romVersion", "getRomVersion", "serial", "getSerial", "subModel", "getSubModel", "Lcom/upuphone/xr/sapp/entity/AirGlassInfo;", "Lcom/upuphone/xr/sapp/entity/StarGlassInfo;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public abstract class BasicGlassInfo {
    public /* synthetic */ BasicGlassInfo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getBattery();

    @Nullable
    public abstract String getBuildType();

    @Nullable
    public abstract String getDisplayName();

    @NotNull
    public abstract String getModel();

    @NotNull
    public abstract String getRomVersion();

    @NotNull
    public abstract String getSerial();

    @Nullable
    public abstract String getSubModel();

    public abstract boolean isCharging();

    private BasicGlassInfo() {
    }
}
