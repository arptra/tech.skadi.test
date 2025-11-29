package com.upuphone.xr.sapp.glass.db;

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
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class GlassUpdateResultDao_Impl implements GlassUpdateResultDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f7075a;
    public final EntityInsertionAdapter b;
    public final EntityDeletionOrUpdateAdapter c;

    public GlassUpdateResultDao_Impl(RoomDatabase roomDatabase) {
        this.f7075a = roomDatabase;
        this.b = new EntityInsertionAdapter<GlassUpdateResultEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `GlassUpdateResultEntity` (`id`,`content`,`time`) VALUES (nullif(?, 0),?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, GlassUpdateResultEntity glassUpdateResultEntity) {
                supportSQLiteStatement.F(1, glassUpdateResultEntity.getId());
                supportSQLiteStatement.B(2, glassUpdateResultEntity.getContent());
                supportSQLiteStatement.F(3, glassUpdateResultEntity.getTime());
            }
        };
        this.c = new EntityDeletionOrUpdateAdapter<GlassUpdateResultEntity>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `GlassUpdateResultEntity` WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, GlassUpdateResultEntity glassUpdateResultEntity) {
                supportSQLiteStatement.F(1, glassUpdateResultEntity.getId());
            }
        };
    }

    public static List h() {
        return Collections.emptyList();
    }

    public Object a(final GlassUpdateResultEntity glassUpdateResultEntity, Continuation continuation) {
        return CoroutinesRoom.c(this.f7075a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                GlassUpdateResultDao_Impl.this.f7075a.beginTransaction();
                try {
                    GlassUpdateResultDao_Impl.this.b.insert(glassUpdateResultEntity);
                    GlassUpdateResultDao_Impl.this.f7075a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    GlassUpdateResultDao_Impl.this.f7075a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object b(Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM glassupdateresultentity ORDER BY id ASC LIMIT 1", 0);
        return CoroutinesRoom.b(this.f7075a, false, DBUtil.a(), new Callable<GlassUpdateResultEntity>() {
            /* renamed from: a */
            public GlassUpdateResultEntity call() {
                GlassUpdateResultEntity glassUpdateResultEntity = null;
                Cursor c = DBUtil.c(GlassUpdateResultDao_Impl.this.f7075a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "content");
                    int d3 = CursorUtil.d(c, RtspHeaders.Values.TIME);
                    if (c.moveToFirst()) {
                        glassUpdateResultEntity = new GlassUpdateResultEntity(c.getLong(d), c.getString(d2), c.getLong(d3));
                    }
                    return glassUpdateResultEntity;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object c(final GlassUpdateResultEntity glassUpdateResultEntity, Continuation continuation) {
        return CoroutinesRoom.c(this.f7075a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                GlassUpdateResultDao_Impl.this.f7075a.beginTransaction();
                try {
                    GlassUpdateResultDao_Impl.this.c.handle(glassUpdateResultEntity);
                    GlassUpdateResultDao_Impl.this.f7075a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    GlassUpdateResultDao_Impl.this.f7075a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object d(long j, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM glassupdateresultentity where id > ? ORDER BY id ASC LIMIT 1", 1);
        c2.F(1, j);
        return CoroutinesRoom.b(this.f7075a, false, DBUtil.a(), new Callable<GlassUpdateResultEntity>() {
            /* renamed from: a */
            public GlassUpdateResultEntity call() {
                GlassUpdateResultEntity glassUpdateResultEntity = null;
                Cursor c = DBUtil.c(GlassUpdateResultDao_Impl.this.f7075a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "content");
                    int d3 = CursorUtil.d(c, RtspHeaders.Values.TIME);
                    if (c.moveToFirst()) {
                        glassUpdateResultEntity = new GlassUpdateResultEntity(c.getLong(d), c.getString(d2), c.getLong(d3));
                    }
                    return glassUpdateResultEntity;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }
}
