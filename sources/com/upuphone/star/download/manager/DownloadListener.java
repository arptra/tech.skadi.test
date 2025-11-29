package com.upuphone.star.download.manager;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/upuphone/star/download/manager/DownloadListener;", "", "Lcom/upuphone/star/download/manager/DownloadTask;", "task", "", "currentSize", "totalSize", "", "d", "(Lcom/upuphone/star/download/manager/DownloadTask;JJ)V", "c", "(Lcom/upuphone/star/download/manager/DownloadTask;)V", "a", "", "exception", "b", "(Lcom/upuphone/star/download/manager/DownloadTask;Ljava/lang/Throwable;)V", "lib_download_manager_release"}, k = 1, mv = {1, 9, 0})
public interface DownloadListener {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    void a(DownloadTask downloadTask);

    void b(DownloadTask downloadTask, Throwable th);

    void c(DownloadTask downloadTask);

    void d(DownloadTask downloadTask, long j, long j2);
}
