package com.upuphone.star.download.manager.db;

import androidx.room.Dao;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Dao
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\ba\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H§@¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/star/download/manager/db/DownloadDao;", "", "Lcom/upuphone/star/download/manager/db/DownloadStatus;", "downloadStatus", "", "b", "(Lcom/upuphone/star/download/manager/db/DownloadStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "url", "filePath", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib_download_manager_release"}, k = 1, mv = {1, 9, 0})
public interface DownloadDao {
    Object a(String str, String str2, Continuation continuation);

    Object b(DownloadStatus downloadStatus, Continuation continuation);
}
