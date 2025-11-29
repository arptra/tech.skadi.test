package com.upuphone.star.download.manager.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class DownloadDao_Impl implements DownloadDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f6463a;
    public final EntityInsertionAdapter b;
    public final EntityDeletionOrUpdateAdapter c;

    /* renamed from: com.upuphone.star.download.manager.db.DownloadDao_Impl$4  reason: invalid class name */
    class AnonymousClass4 implements Callable<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DownloadStatus f6467a;
        public final /* synthetic */ DownloadDao_Impl b;

        /* renamed from: a */
        public Unit call() {
            this.b.f6463a.beginTransaction();
            try {
                this.b.c.handle(this.f6467a);
                this.b.f6463a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                this.b.f6463a.endTransaction();
            }
        }
    }

    public DownloadDao_Impl(RoomDatabase roomDatabase) {
        this.f6463a = roomDatabase;
        this.b = new EntityInsertionAdapter<DownloadStatus>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `DownloadStatus` (`url`,`filePath`,`fileSize`,`progress`) VALUES (?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DownloadStatus downloadStatus) {
                supportSQLiteStatement.B(1, downloadStatus.getUrl());
                supportSQLiteStatement.B(2, downloadStatus.getFilePath());
                supportSQLiteStatement.F(3, downloadStatus.getFileSize());
                supportSQLiteStatement.R(4, (double) downloadStatus.getProgress());
            }
        };
        this.c = new EntityDeletionOrUpdateAdapter<DownloadStatus>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `DownloadStatus` WHERE `url` = ? AND `filePath` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DownloadStatus downloadStatus) {
                supportSQLiteStatement.B(1, downloadStatus.getUrl());
                supportSQLiteStatement.B(2, downloadStatus.getFilePath());
            }
        };
    }

    public static List f() {
        return Collections.emptyList();
    }

    public Object a(String str, String str2, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from downloadstatus where url=? and filePath=? limit 1", 2);
        c2.B(1, str);
        c2.B(2, str2);
        return CoroutinesRoom.b(this.f6463a, false, DBUtil.a(), new Callable<DownloadStatus>() {
            /* renamed from: a */
            public DownloadStatus call() {
                DownloadStatus downloadStatus = null;
                Cursor c = DBUtil.c(DownloadDao_Impl.this.f6463a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "url");
                    int d2 = CursorUtil.d(c, "filePath");
                    int d3 = CursorUtil.d(c, "fileSize");
                    int d4 = CursorUtil.d(c, PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS);
                    if (c.moveToFirst()) {
                        downloadStatus = new DownloadStatus(c.getString(d), c.getString(d2), c.getLong(d3), c.getFloat(d4));
                    }
                    return downloadStatus;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object b(final DownloadStatus downloadStatus, Continuation continuation) {
        return CoroutinesRoom.c(this.f6463a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                DownloadDao_Impl.this.f6463a.beginTransaction();
                try {
                    DownloadDao_Impl.this.b.insert(downloadStatus);
                    DownloadDao_Impl.this.f6463a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    DownloadDao_Impl.this.f6463a.endTransaction();
                }
            }
        }, continuation);
    }
}
