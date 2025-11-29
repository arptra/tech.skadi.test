package com.upuphone.xr.sapp.utils;

import com.upuphone.star.core.log.ULog;
import com.upuphone.star.download.manager.DownloadListener;
import com.upuphone.star.download.manager.DownloadTask;
import com.upuphone.xr.sapp.entity.AppUpdateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"com/upuphone/xr/sapp/utils/AppUpdateHelper$downloadListener$1", "Lcom/upuphone/star/download/manager/DownloadListener;", "Lcom/upuphone/star/download/manager/DownloadTask;", "task", "", "currentSize", "totalSize", "", "d", "(Lcom/upuphone/star/download/manager/DownloadTask;JJ)V", "c", "(Lcom/upuphone/star/download/manager/DownloadTask;)V", "a", "", "exception", "b", "(Lcom/upuphone/star/download/manager/DownloadTask;Ljava/lang/Throwable;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AppUpdateHelper$downloadListener$1 implements DownloadListener {
    public void a(DownloadTask downloadTask) {
        Intrinsics.checkNotNullParameter(downloadTask, "task");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AppUpdateHelper", "Download-completed, task: " + downloadTask);
        AppUpdateInfo d = AppUpdateHelper.d;
        if (d == null) {
            delegate.c("AppUpdateHelper", "Download-completed, appUpdateInfo is null");
            return;
        }
        d.setDownloadProgress(1.0f);
        AppUpdateHelper appUpdateHelper = AppUpdateHelper.f7841a;
        appUpdateHelper.Q(d);
        if (!Intrinsics.areEqual((Object) AppUpdateHelper.j, (Object) downloadTask)) {
            delegate.c("AppUpdateHelper", "Download-completed, downloadTask not match");
        } else {
            appUpdateHelper.x(d, downloadTask.a());
        }
    }

    public void b(DownloadTask downloadTask, Throwable th) {
        Intrinsics.checkNotNullParameter(downloadTask, "task");
        Intrinsics.checkNotNullParameter(th, "exception");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("AppUpdateHelper", "Download-error, task: " + downloadTask + ", exception: " + th);
        AppUpdateHelper.l = true;
    }

    public void c(DownloadTask downloadTask) {
        Intrinsics.checkNotNullParameter(downloadTask, "task");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AppUpdateHelper", "Download-started, task: " + downloadTask);
        AppUpdateHelper.l = false;
    }

    public void d(DownloadTask downloadTask, long j, long j2) {
        Intrinsics.checkNotNullParameter(downloadTask, "task");
        float f = ((float) j) / ((float) j2);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AppUpdateHelper", "Download-progress, downloadProgress: " + f);
        AppUpdateInfo d = AppUpdateHelper.d;
        if (d == null) {
            delegate.c("AppUpdateHelper", "Download-progress, appUpdateInfo is null");
            return;
        }
        d.setDownloadProgress(f);
        AppUpdateHelper.f7841a.Q(d);
    }
}
