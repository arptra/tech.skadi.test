package com.upuphone.ai.ttsengine.engines.cache.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.upuphone.ai.ttsengine.engines.cache.db.PCMCacheDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

public final class PCMCacheDao_Impl implements PCMCacheDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f5543a;
    public final EntityInsertionAdapter b;
    public final SharedSQLiteStatement c;

    public PCMCacheDao_Impl(RoomDatabase roomDatabase) {
        this.f5543a = roomDatabase;
        this.b = new EntityInsertionAdapter<CacheEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `pcmCache` (`word`,`path`,`updateTime`,`count`) VALUES (?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, CacheEntity cacheEntity) {
                supportSQLiteStatement.B(1, cacheEntity.getWord());
                supportSQLiteStatement.B(2, cacheEntity.getPath());
                supportSQLiteStatement.F(3, cacheEntity.getUpdateTime());
                supportSQLiteStatement.F(4, (long) cacheEntity.getCount());
            }
        };
        this.c = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM pcmCache WHERE word = ?";
            }
        };
    }

    public static List f() {
        return Collections.emptyList();
    }

    public int a(String str) {
        this.f5543a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.c.acquire();
        acquire.B(1, str);
        try {
            this.f5543a.beginTransaction();
            int k = acquire.k();
            this.f5543a.setTransactionSuccessful();
            this.f5543a.endTransaction();
            this.c.release(acquire);
            return k;
        } catch (Throwable th) {
            this.c.release(acquire);
            throw th;
        }
    }

    public long b(CacheEntity cacheEntity) {
        this.f5543a.assertNotSuspendingTransaction();
        this.f5543a.beginTransaction();
        try {
            long insertAndReturnId = this.b.insertAndReturnId(cacheEntity);
            this.f5543a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.f5543a.endTransaction();
        }
    }

    public Flow c() {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM pcmCache ORDER BY count DESC, updateTime DESC", 0);
        return CoroutinesRoom.a(this.f5543a, false, new String[]{"pcmCache"}, new Callable<List<CacheEntity>>() {
            /* renamed from: a */
            public List call() {
                Cursor c = DBUtil.c(PCMCacheDao_Impl.this.f5543a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "word");
                    int d2 = CursorUtil.d(c, "path");
                    int d3 = CursorUtil.d(c, "updateTime");
                    int d4 = CursorUtil.d(c, "count");
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(new CacheEntity(c.getString(d), c.getString(d2), c.getLong(d3), c.getInt(d4)));
                    }
                    return arrayList;
                } finally {
                    c.close();
                }
            }

            public void finalize() {
                c2.release();
            }
        });
    }

    public void d(CacheEntity cacheEntity, String str) {
        this.f5543a.beginTransaction();
        try {
            PCMCacheDao.DefaultImpls.a(this, cacheEntity, str);
            this.f5543a.setTransactionSuccessful();
        } finally {
            this.f5543a.endTransaction();
        }
    }
}
