package com.upuphone.star.download.manager.db;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/star/download/manager/db/DownloadStatus;", "", "a", "(Lcom/upuphone/star/download/manager/db/DownloadStatus;)Z", "isComplete", "lib_download_manager_release"}, k = 2, mv = {1, 9, 0})
public final class DownloadStatusKt {
    public static final boolean a(DownloadStatus downloadStatus) {
        Intrinsics.checkNotNullParameter(downloadStatus, "<this>");
        if (downloadStatus.getProgress() < 1.0f) {
            return false;
        }
        File file = new File(downloadStatus.getFilePath());
        return file.exists() && file.length() == downloadStatus.getFileSize();
    }
}
