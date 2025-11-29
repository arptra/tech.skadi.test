package com.upuphone.xr.sapp.entity;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateDownloadEvent;", "", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "downloadFile", "Ljava/io/File;", "installRequired", "", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Ljava/io/File;Z)V", "getDownloadFile", "()Ljava/io/File;", "getGlassUpdateInfo", "()Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "getInstallRequired", "()Z", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassUpdateDownloadEvent {
    @NotNull
    private final File downloadFile;
    @NotNull
    private final GlassUpdateInfo glassUpdateInfo;
    private final boolean installRequired;

    public GlassUpdateDownloadEvent(@NotNull GlassUpdateInfo glassUpdateInfo2, @NotNull File file, boolean z) {
        Intrinsics.checkNotNullParameter(glassUpdateInfo2, "glassUpdateInfo");
        Intrinsics.checkNotNullParameter(file, "downloadFile");
        this.glassUpdateInfo = glassUpdateInfo2;
        this.downloadFile = file;
        this.installRequired = z;
    }

    @NotNull
    public final File getDownloadFile() {
        return this.downloadFile;
    }

    @NotNull
    public final GlassUpdateInfo getGlassUpdateInfo() {
        return this.glassUpdateInfo;
    }

    public final boolean getInstallRequired() {
        return this.installRequired;
    }
}
