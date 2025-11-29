package com.upuphone.xr.sapp.unicron;

import com.upuphone.star.download.manager.DownloadListener;
import com.upuphone.star.download.manager.DownloadTask;
import com.upuphone.xr.sapp.entity.DownloadingUpdateConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"com/upuphone/xr/sapp/unicron/UnicronUpdateHelper$innerDownloadListener$1", "Lcom/upuphone/star/download/manager/DownloadListener;", "Lcom/upuphone/star/download/manager/DownloadTask;", "task", "", "c", "(Lcom/upuphone/star/download/manager/DownloadTask;)V", "a", "", "exception", "b", "(Lcom/upuphone/star/download/manager/DownloadTask;Ljava/lang/Throwable;)V", "", "currentSize", "totalSize", "d", "(Lcom/upuphone/star/download/manager/DownloadTask;JJ)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class UnicronUpdateHelper$innerDownloadListener$1 implements DownloadListener {
    public void a(DownloadTask downloadTask) {
        DownloadingUpdateConfig ifMatch;
        Intrinsics.checkNotNullParameter(downloadTask, "task");
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        unicronUpdateHelper.L("download-completed: " + downloadTask);
        DownloadingUpdateConfig j = UnicronUpdateHelper.g;
        if (j == null || (ifMatch = j.ifMatch(downloadTask)) == null) {
            String d = downloadTask.d();
            unicronUpdateHelper.L("download-completed, no updateConfig for: " + d);
            return;
        }
        unicronUpdateHelper.F(downloadTask.a(), ifMatch.getGlassUpdateInfo());
    }

    public void b(DownloadTask downloadTask, Throwable th) {
        DownloadingUpdateConfig ifMatch;
        Intrinsics.checkNotNullParameter(downloadTask, "task");
        Intrinsics.checkNotNullParameter(th, "exception");
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        unicronUpdateHelper.L("download-error: " + th + ", task: " + downloadTask);
        DownloadingUpdateConfig j = UnicronUpdateHelper.g;
        if (j == null || (ifMatch = j.ifMatch(downloadTask)) == null) {
            String d = downloadTask.d();
            unicronUpdateHelper.L("download-error, no updateConfig for: " + d);
            return;
        }
        UnicronUpdateHelper.W(unicronUpdateHelper, ifMatch.getGlassUpdateInfo(), 0, 2, (Object) null);
    }

    public void c(DownloadTask downloadTask) {
        Intrinsics.checkNotNullParameter(downloadTask, "task");
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        unicronUpdateHelper.L("download-started: " + downloadTask);
    }

    public void d(DownloadTask downloadTask, long j, long j2) {
        float f;
        Intrinsics.checkNotNullParameter(downloadTask, "task");
        if (j2 <= 0 || j <= 0) {
            f = 0.0f;
        } else if (j == j2) {
            UnicronUpdateHelper.b.L("download-progress, percent: 100%, fake 99%");
            f = 0.99f;
        } else {
            f = (float) (((double) j) / ((double) j2));
        }
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        unicronUpdateHelper.L("download-progress, percent: " + f + ", task: " + downloadTask);
    }
}
