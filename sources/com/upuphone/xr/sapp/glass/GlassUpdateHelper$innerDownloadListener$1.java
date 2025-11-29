package com.upuphone.xr.sapp.glass;

import com.upuphone.star.download.manager.DownloadListener;
import com.upuphone.star.download.manager.DownloadTask;
import com.upuphone.xr.sapp.entity.DownloadingUpdateConfig;
import com.upuphone.xr.sapp.entity.GlassUpdateDownloadProgress;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"com/upuphone/xr/sapp/glass/GlassUpdateHelper$innerDownloadListener$1", "Lcom/upuphone/star/download/manager/DownloadListener;", "Lcom/upuphone/star/download/manager/DownloadTask;", "task", "", "c", "(Lcom/upuphone/star/download/manager/DownloadTask;)V", "a", "", "exception", "b", "(Lcom/upuphone/star/download/manager/DownloadTask;Ljava/lang/Throwable;)V", "", "currentSize", "totalSize", "d", "(Lcom/upuphone/star/download/manager/DownloadTask;JJ)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GlassUpdateHelper$innerDownloadListener$1 implements DownloadListener {
    public void a(DownloadTask downloadTask) {
        DownloadingUpdateConfig ifMatch;
        Intrinsics.checkNotNullParameter(downloadTask, "task");
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        glassUpdateHelper.d1("download-completed: " + downloadTask);
        DownloadingUpdateConfig m = GlassUpdateHelper.r;
        if (m == null || (ifMatch = m.ifMatch(downloadTask)) == null) {
            String d = downloadTask.d();
            glassUpdateHelper.d1("download-completed, no glassUpdateConfig for: " + d);
            return;
        }
        if (!ifMatch.getSilent()) {
            glassUpdateHelper.v1(new GlassUpdateState.DownloadSuccess(ifMatch.getGlassUpdateInfo()));
        }
        glassUpdateHelper.m1(ifMatch.getGlassUpdateInfo().getDigest(), downloadTask.a(), 1.0f);
        glassUpdateHelper.n0(downloadTask.a(), ifMatch.getGlassUpdateInfo(), ifMatch.getInstallRequired(), ifMatch.getSilent());
    }

    public void b(DownloadTask downloadTask, Throwable th) {
        DownloadingUpdateConfig ifMatch;
        Intrinsics.checkNotNullParameter(downloadTask, "task");
        Intrinsics.checkNotNullParameter(th, "exception");
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        glassUpdateHelper.d1("download-error: " + th + ", task: " + downloadTask);
        DownloadingUpdateConfig m = GlassUpdateHelper.r;
        if (m == null || (ifMatch = m.ifMatch(downloadTask)) == null) {
            String d = downloadTask.d();
            glassUpdateHelper.d1("download-error, no glassUpdateConfig for: " + d);
            return;
        }
        GlassUpdateDownloadProgress G0 = glassUpdateHelper.G0(ifMatch.getGlassUpdateInfo().getDigest());
        float percent = G0 != null ? G0.getPercent() : 0.0f;
        if (!ifMatch.getSilent()) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            glassUpdateHelper.v1(new GlassUpdateState.DownloadFail(uuid, ifMatch.getGlassUpdateInfo(), percent));
        }
    }

    public void c(DownloadTask downloadTask) {
        DownloadingUpdateConfig ifMatch;
        String absolutePath;
        Intrinsics.checkNotNullParameter(downloadTask, "task");
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        glassUpdateHelper.d1("download-started: " + downloadTask);
        DownloadingUpdateConfig m = GlassUpdateHelper.r;
        if (m == null || (ifMatch = m.ifMatch(downloadTask)) == null) {
            String d = downloadTask.d();
            glassUpdateHelper.d1("download-started, no glassUpdateConfig for: " + d);
            return;
        }
        GlassUpdateDownloadProgress G0 = glassUpdateHelper.G0(ifMatch.getGlassUpdateInfo().getDigest());
        float percent = G0 != null ? G0.getPercent() : 0.0f;
        if (!ifMatch.getSilent()) {
            glassUpdateHelper.v1(new GlassUpdateState.Downloading(ifMatch.getGlassUpdateInfo(), percent));
        }
        File parentFile = downloadTask.a().getParentFile();
        if (parentFile != null && (absolutePath = parentFile.getAbsolutePath()) != null) {
            glassUpdateHelper.V(absolutePath);
        }
    }

    public void d(DownloadTask downloadTask, long j, long j2) {
        DownloadingUpdateConfig ifMatch;
        Intrinsics.checkNotNullParameter(downloadTask, "task");
        DownloadingUpdateConfig m = GlassUpdateHelper.r;
        if (m == null || (ifMatch = m.ifMatch(downloadTask)) == null) {
            GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
            String d = downloadTask.d();
            glassUpdateHelper.d1("download-progress, no glassUpdateConfig for: " + d);
            return;
        }
        float f = (j2 <= 0 || j <= 0) ? 0.0f : j == j2 ? 1.0f : (float) (((double) j) / ((double) j2));
        GlassUpdateHelper glassUpdateHelper2 = GlassUpdateHelper.b;
        glassUpdateHelper2.d1("download-progress, percent: " + f + ", task: " + downloadTask);
        if (!ifMatch.getSilent()) {
            glassUpdateHelper2.v1(new GlassUpdateState.Downloading(ifMatch.getGlassUpdateInfo(), f));
        }
        glassUpdateHelper2.m1(ifMatch.getGlassUpdateInfo().getDigest(), downloadTask.a(), f);
    }
}
