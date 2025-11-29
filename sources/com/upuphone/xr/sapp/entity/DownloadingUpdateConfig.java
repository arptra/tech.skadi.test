package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.upuphone.star.download.manager.DownloadTask;
import com.upuphone.star.fota.phone.GlassUpdateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/entity/DownloadingUpdateConfig;", "", "downloadTask", "Lcom/upuphone/star/download/manager/DownloadTask;", "glassUpdateInfo", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "installRequired", "", "silent", "(Lcom/upuphone/star/download/manager/DownloadTask;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;ZZ)V", "getDownloadTask", "()Lcom/upuphone/star/download/manager/DownloadTask;", "getGlassUpdateInfo", "()Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "getInstallRequired", "()Z", "getSilent", "ifMatch", "task", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class DownloadingUpdateConfig {
    @NotNull
    private final DownloadTask downloadTask;
    @NotNull
    private final GlassUpdateInfo glassUpdateInfo;
    private final boolean installRequired;
    private final boolean silent;

    public DownloadingUpdateConfig(@NotNull DownloadTask downloadTask2, @NotNull GlassUpdateInfo glassUpdateInfo2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(downloadTask2, "downloadTask");
        Intrinsics.checkNotNullParameter(glassUpdateInfo2, "glassUpdateInfo");
        this.downloadTask = downloadTask2;
        this.glassUpdateInfo = glassUpdateInfo2;
        this.installRequired = z;
        this.silent = z2;
    }

    @NotNull
    public final DownloadTask getDownloadTask() {
        return this.downloadTask;
    }

    @NotNull
    public final GlassUpdateInfo getGlassUpdateInfo() {
        return this.glassUpdateInfo;
    }

    public final boolean getInstallRequired() {
        return this.installRequired;
    }

    public final boolean getSilent() {
        return this.silent;
    }

    @Nullable
    public final DownloadingUpdateConfig ifMatch(@NotNull DownloadTask downloadTask2) {
        Intrinsics.checkNotNullParameter(downloadTask2, "task");
        if (Intrinsics.areEqual((Object) downloadTask2, (Object) this.downloadTask)) {
            return this;
        }
        return null;
    }
}
