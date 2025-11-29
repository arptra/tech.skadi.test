package com.upuphone.ar.tici.phone.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.upuphone.ar.tici.phone.data.TiciHistory;
import com.upuphone.ar.tici.phone.db.entity.TiciContentPart;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class TiciDao_Impl implements TiciDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f5926a;
    public final EntityInsertionAdapter b;
    public final ParagraphItemConverter c = new ParagraphItemConverter();
    public final EntityInsertionAdapter d;
    public final EntityDeletionOrUpdateAdapter e;
    public final SharedSQLiteStatement f;
    public final SharedSQLiteStatement g;
    public final SharedSQLiteStatement h;
    public final SharedSQLiteStatement i;
    public final SharedSQLiteStatement j;
    public final SharedSQLiteStatement k;
    public final SharedSQLiteStatement l;

    /* renamed from: com.upuphone.ar.tici.phone.db.TiciDao_Impl$17  reason: invalid class name */
    class AnonymousClass17 implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f5935a;
        public final /* synthetic */ long b;
        public final /* synthetic */ TiciDao_Impl c;

        /* renamed from: a */
        public Integer call() {
            SupportSQLiteStatement acquire = this.c.h.acquire();
            acquire.F(1, (long) this.f5935a);
            acquire.F(2, this.b);
            try {
                this.c.f5926a.beginTransaction();
                Integer valueOf = Integer.valueOf(acquire.k());
                this.c.f5926a.setTransactionSuccessful();
                this.c.f5926a.endTransaction();
                this.c.h.release(acquire);
                return valueOf;
            } catch (Throwable th) {
                this.c.h.release(acquire);
                throw th;
            }
        }
    }

    public TiciDao_Impl(RoomDatabase roomDatabase) {
        this.f5926a = roomDatabase;
        this.b = new EntityInsertionAdapter<TiciEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `TiciEntity` (`id`,`fileName`,`sourceText`,`paragraphIndexes`,`index`,`fileSize`,`lastShowTime`,`lastModified`,`fileType`,`fileStatus`,`userId`,`currentPage`,`totalPage`,`totalTextLength`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, TiciEntity ticiEntity) {
                supportSQLiteStatement.F(1, ticiEntity.getId());
                supportSQLiteStatement.B(2, ticiEntity.getFileName());
                supportSQLiteStatement.B(3, ticiEntity.getSourceText());
                supportSQLiteStatement.B(4, TiciDao_Impl.this.c.b(ticiEntity.getParagraphIndexes()));
                supportSQLiteStatement.F(5, (long) ticiEntity.getIndex());
                supportSQLiteStatement.F(6, ticiEntity.getFileSize());
                supportSQLiteStatement.F(7, ticiEntity.getLastShowTime());
                supportSQLiteStatement.F(8, ticiEntity.getLastModified());
                if (ticiEntity.getFileType() == null) {
                    supportSQLiteStatement.L(9);
                } else {
                    supportSQLiteStatement.F(9, (long) ticiEntity.getFileType().intValue());
                }
                supportSQLiteStatement.F(10, (long) ticiEntity.getFileStatus());
                if (ticiEntity.getUserId() == null) {
                    supportSQLiteStatement.L(11);
                } else {
                    supportSQLiteStatement.B(11, ticiEntity.getUserId());
                }
                supportSQLiteStatement.F(12, (long) ticiEntity.getCurrentPage());
                supportSQLiteStatement.F(13, (long) ticiEntity.getTotalPage());
                supportSQLiteStatement.F(14, (long) ticiEntity.getTotalTextLength());
            }
        };
        this.d = new EntityInsertionAdapter<TiciContentPart>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `TiciContentPart` (`id`,`ticiId`,`contentText`,`paragraphIndexes`,`highlightIndex`,`partSize`,`partIndex`,`contentOffsetStart`,`contentOffsetEnd`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, TiciContentPart ticiContentPart) {
                supportSQLiteStatement.F(1, ticiContentPart.getId());
                supportSQLiteStatement.F(2, ticiContentPart.getTiciId());
                supportSQLiteStatement.B(3, ticiContentPart.getContentText());
                supportSQLiteStatement.B(4, TiciDao_Impl.this.c.b(ticiContentPart.getParagraphIndexes()));
                supportSQLiteStatement.F(5, (long) ticiContentPart.getHighlightIndex());
                supportSQLiteStatement.F(6, ticiContentPart.getPartSize());
                supportSQLiteStatement.F(7, (long) ticiContentPart.getPartIndex());
                supportSQLiteStatement.F(8, (long) ticiContentPart.getContentOffsetStart());
                supportSQLiteStatement.F(9, (long) ticiContentPart.getContentOffsetEnd());
            }
        };
        this.e = new EntityDeletionOrUpdateAdapter<TiciEntity>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `TiciEntity` SET `id` = ?,`fileName` = ?,`sourceText` = ?,`paragraphIndexes` = ?,`index` = ?,`fileSize` = ?,`lastShowTime` = ?,`lastModified` = ?,`fileType` = ?,`fileStatus` = ?,`userId` = ?,`currentPage` = ?,`totalPage` = ?,`totalTextLength` = ? WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, TiciEntity ticiEntity) {
                supportSQLiteStatement.F(1, ticiEntity.getId());
                supportSQLiteStatement.B(2, ticiEntity.getFileName());
                supportSQLiteStatement.B(3, ticiEntity.getSourceText());
                supportSQLiteStatement.B(4, TiciDao_Impl.this.c.b(ticiEntity.getParagraphIndexes()));
                supportSQLiteStatement.F(5, (long) ticiEntity.getIndex());
                supportSQLiteStatement.F(6, ticiEntity.getFileSize());
                supportSQLiteStatement.F(7, ticiEntity.getLastShowTime());
                supportSQLiteStatement.F(8, ticiEntity.getLastModified());
                if (ticiEntity.getFileType() == null) {
                    supportSQLiteStatement.L(9);
                } else {
                    supportSQLiteStatement.F(9, (long) ticiEntity.getFileType().intValue());
                }
                supportSQLiteStatement.F(10, (long) ticiEntity.getFileStatus());
                if (ticiEntity.getUserId() == null) {
                    supportSQLiteStatement.L(11);
                } else {
                    supportSQLiteStatement.B(11, ticiEntity.getUserId());
                }
                supportSQLiteStatement.F(12, (long) ticiEntity.getCurrentPage());
                supportSQLiteStatement.F(13, (long) ticiEntity.getTotalPage());
                supportSQLiteStatement.F(14, (long) ticiEntity.getTotalTextLength());
                supportSQLiteStatement.F(15, ticiEntity.getId());
            }
        };
        this.f = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "update ticientity set `index`=? where id=?";
            }
        };
        this.g = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "update ticientity set currentPage=? , `index`=? where id=?";
            }
        };
        this.h = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "update ticientity set currentPage=? where id=?";
            }
        };
        this.i = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "update ticientity set userId=? where userId is null";
            }
        };
        this.j = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM ticientity where id=?";
            }
        };
        this.k = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete from ticicontentpart where ticiId=?";
            }
        };
        this.l = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "update ticicontentpart set paragraphIndexes=? where ticiId=? and partIndex=?";
            }
        };
    }

    public static List P() {
        return Collections.emptyList();
    }

    public Object A(long j2, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from ticientity where id>? ORDER BY id ASC LIMIT 1", 1);
        c2.F(1, j2);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<TiciEntity>() {
            /* renamed from: a */
            public TiciEntity call() {
                TiciEntity ticiEntity;
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "fileName");
                    int d3 = CursorUtil.d(c, "sourceText");
                    int d4 = CursorUtil.d(c, "paragraphIndexes");
                    int d5 = CursorUtil.d(c, "index");
                    int d6 = CursorUtil.d(c, "fileSize");
                    int d7 = CursorUtil.d(c, "lastShowTime");
                    int d8 = CursorUtil.d(c, "lastModified");
                    int d9 = CursorUtil.d(c, "fileType");
                    int d10 = CursorUtil.d(c, "fileStatus");
                    int d11 = CursorUtil.d(c, "userId");
                    int d12 = CursorUtil.d(c, "currentPage");
                    int d13 = CursorUtil.d(c, "totalPage");
                    int d14 = CursorUtil.d(c, "totalTextLength");
                    if (c.moveToFirst()) {
                        ticiEntity = new TiciEntity(c.getLong(d), c.getString(d2), c.getString(d3), TiciDao_Impl.this.c.a(c.getString(d4)), c.getInt(d5), c.getLong(d6), c.getLong(d7), c.getLong(d8), c.isNull(d9) ? null : Integer.valueOf(c.getInt(d9)), c.getInt(d10), c.isNull(d11) ? null : c.getString(d11), c.getInt(d12), c.getInt(d13), c.getInt(d14));
                    } else {
                        ticiEntity = null;
                    }
                    return ticiEntity;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object B(final long j2, Continuation continuation) {
        return CoroutinesRoom.c(this.f5926a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                SupportSQLiteStatement acquire = TiciDao_Impl.this.j.acquire();
                acquire.F(1, j2);
                try {
                    TiciDao_Impl.this.f5926a.beginTransaction();
                    acquire.k();
                    TiciDao_Impl.this.f5926a.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    TiciDao_Impl.this.f5926a.endTransaction();
                    TiciDao_Impl.this.j.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    TiciDao_Impl.this.j.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object C(String str, long j2, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM ticientity where userId=? and id=?", 2);
        c2.B(1, str);
        c2.F(2, j2);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<TiciEntity>() {
            /* renamed from: a */
            public TiciEntity call() {
                TiciEntity ticiEntity;
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "fileName");
                    int d3 = CursorUtil.d(c, "sourceText");
                    int d4 = CursorUtil.d(c, "paragraphIndexes");
                    int d5 = CursorUtil.d(c, "index");
                    int d6 = CursorUtil.d(c, "fileSize");
                    int d7 = CursorUtil.d(c, "lastShowTime");
                    int d8 = CursorUtil.d(c, "lastModified");
                    int d9 = CursorUtil.d(c, "fileType");
                    int d10 = CursorUtil.d(c, "fileStatus");
                    int d11 = CursorUtil.d(c, "userId");
                    int d12 = CursorUtil.d(c, "currentPage");
                    int d13 = CursorUtil.d(c, "totalPage");
                    int d14 = CursorUtil.d(c, "totalTextLength");
                    if (c.moveToFirst()) {
                        ticiEntity = new TiciEntity(c.getLong(d), c.getString(d2), c.getString(d3), TiciDao_Impl.this.c.a(c.getString(d4)), c.getInt(d5), c.getLong(d6), c.getLong(d7), c.getLong(d8), c.isNull(d9) ? null : Integer.valueOf(c.getInt(d9)), c.getInt(d10), c.isNull(d11) ? null : c.getString(d11), c.getInt(d12), c.getInt(d13), c.getInt(d14));
                    } else {
                        ticiEntity = null;
                    }
                    return ticiEntity;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object a(long j2, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from ticicontentpart where ticiId=? ORDER BY partIndex", 1);
        c2.F(1, j2);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<List<TiciContentPart>>() {
            /* renamed from: a */
            public List call() {
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "ticiId");
                    int d3 = CursorUtil.d(c, "contentText");
                    int d4 = CursorUtil.d(c, "paragraphIndexes");
                    int d5 = CursorUtil.d(c, "highlightIndex");
                    int d6 = CursorUtil.d(c, "partSize");
                    int d7 = CursorUtil.d(c, "partIndex");
                    int d8 = CursorUtil.d(c, "contentOffsetStart");
                    int d9 = CursorUtil.d(c, "contentOffsetEnd");
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(new TiciContentPart(c.getLong(d), c.getLong(d2), c.getString(d3), TiciDao_Impl.this.c.a(c.getString(d4)), c.getInt(d5), c.getLong(d6), c.getInt(d7), c.getInt(d8), c.getInt(d9)));
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object b(long j2, int i2, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from ticicontentpart where ticiId=? and partIndex=?", 2);
        c2.F(1, j2);
        c2.F(2, (long) i2);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<TiciContentPart>() {
            /* renamed from: a */
            public TiciContentPart call() {
                TiciContentPart ticiContentPart = null;
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "ticiId");
                    int d3 = CursorUtil.d(c, "contentText");
                    int d4 = CursorUtil.d(c, "paragraphIndexes");
                    int d5 = CursorUtil.d(c, "highlightIndex");
                    int d6 = CursorUtil.d(c, "partSize");
                    int d7 = CursorUtil.d(c, "partIndex");
                    int d8 = CursorUtil.d(c, "contentOffsetStart");
                    int d9 = CursorUtil.d(c, "contentOffsetEnd");
                    if (c.moveToFirst()) {
                        ticiContentPart = new TiciContentPart(c.getLong(d), c.getLong(d2), c.getString(d3), TiciDao_Impl.this.c.a(c.getString(d4)), c.getInt(d5), c.getLong(d6), c.getInt(d7), c.getInt(d8), c.getInt(d9));
                    }
                    return ticiContentPart;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object c(String str, int i2, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT id, fileName, lastModified, fileType, fileSize, totalTextLength FROM ticientity where userId=? ORDER BY lastModified DESC limit ?", 2);
        c2.B(1, str);
        c2.F(2, (long) i2);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<List<TiciHistory>>() {
            /* renamed from: a */
            public List call() {
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(new TiciHistory(c.getLong(0), c.getString(1), c.getLong(2), c.isNull(3) ? null : Integer.valueOf(c.getInt(3)), c.getLong(4), c.getInt(5)));
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object d(String str, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM ticientity where userId=? and fileStatus=1 ORDER BY lastShowTime DESC LIMIT 1", 1);
        c2.B(1, str);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<TiciEntity>() {
            /* renamed from: a */
            public TiciEntity call() {
                TiciEntity ticiEntity;
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "fileName");
                    int d3 = CursorUtil.d(c, "sourceText");
                    int d4 = CursorUtil.d(c, "paragraphIndexes");
                    int d5 = CursorUtil.d(c, "index");
                    int d6 = CursorUtil.d(c, "fileSize");
                    int d7 = CursorUtil.d(c, "lastShowTime");
                    int d8 = CursorUtil.d(c, "lastModified");
                    int d9 = CursorUtil.d(c, "fileType");
                    int d10 = CursorUtil.d(c, "fileStatus");
                    int d11 = CursorUtil.d(c, "userId");
                    int d12 = CursorUtil.d(c, "currentPage");
                    int d13 = CursorUtil.d(c, "totalPage");
                    int d14 = CursorUtil.d(c, "totalTextLength");
                    if (c.moveToFirst()) {
                        ticiEntity = new TiciEntity(c.getLong(d), c.getString(d2), c.getString(d3), TiciDao_Impl.this.c.a(c.getString(d4)), c.getInt(d5), c.getLong(d6), c.getLong(d7), c.getLong(d8), c.isNull(d9) ? null : Integer.valueOf(c.getInt(d9)), c.getInt(d10), c.isNull(d11) ? null : c.getString(d11), c.getInt(d12), c.getInt(d13), c.getInt(d14));
                    } else {
                        ticiEntity = null;
                    }
                    return ticiEntity;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object e(long j2, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select count(*) from ticicontentpart where ticiId=?", 1);
        c2.F(1, j2);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<Integer>() {
            /* renamed from: a */
            public Integer call() {
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    return c.moveToFirst() ? Integer.valueOf(c.getInt(0)) : 0;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object f(final long j2, Continuation continuation) {
        return CoroutinesRoom.c(this.f5926a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                SupportSQLiteStatement acquire = TiciDao_Impl.this.k.acquire();
                acquire.F(1, j2);
                try {
                    TiciDao_Impl.this.f5926a.beginTransaction();
                    acquire.k();
                    TiciDao_Impl.this.f5926a.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    TiciDao_Impl.this.f5926a.endTransaction();
                    TiciDao_Impl.this.k.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    TiciDao_Impl.this.k.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object g(long j2, int i2, String str, Continuation continuation) {
        final String str2 = str;
        final long j3 = j2;
        final int i3 = i2;
        return CoroutinesRoom.c(this.f5926a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                SupportSQLiteStatement acquire = TiciDao_Impl.this.l.acquire();
                acquire.B(1, str2);
                acquire.F(2, j3);
                acquire.F(3, (long) i3);
                try {
                    TiciDao_Impl.this.f5926a.beginTransaction();
                    acquire.k();
                    TiciDao_Impl.this.f5926a.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    TiciDao_Impl.this.f5926a.endTransaction();
                    TiciDao_Impl.this.l.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    TiciDao_Impl.this.l.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object h(final String str, Continuation continuation) {
        return CoroutinesRoom.c(this.f5926a, true, new Callable<Integer>() {
            /* renamed from: a */
            public Integer call() {
                SupportSQLiteStatement acquire = TiciDao_Impl.this.i.acquire();
                acquire.B(1, str);
                try {
                    TiciDao_Impl.this.f5926a.beginTransaction();
                    Integer valueOf = Integer.valueOf(acquire.k());
                    TiciDao_Impl.this.f5926a.setTransactionSuccessful();
                    TiciDao_Impl.this.f5926a.endTransaction();
                    TiciDao_Impl.this.i.release(acquire);
                    return valueOf;
                } catch (Throwable th) {
                    TiciDao_Impl.this.i.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object i(String str, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select id FROM ticientity where userId=?", 1);
        c2.B(1, str);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<List<Long>>() {
            /* renamed from: a */
            public List call() {
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(Long.valueOf(c.getLong(0)));
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object j(long j2, int i2, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select paragraphIndexes from ticicontentpart where ticiId=? and partIndex<? ORDER BY partIndex", 2);
        c2.F(1, j2);
        c2.F(2, (long) i2);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<List<String>>() {
            /* renamed from: a */
            public List call() {
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(c.getString(0));
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object k(String str, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM ticientity where userId=? ORDER BY lastModified DESC LIMIT 1", 1);
        c2.B(1, str);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<TiciEntity>() {
            /* renamed from: a */
            public TiciEntity call() {
                TiciEntity ticiEntity;
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "fileName");
                    int d3 = CursorUtil.d(c, "sourceText");
                    int d4 = CursorUtil.d(c, "paragraphIndexes");
                    int d5 = CursorUtil.d(c, "index");
                    int d6 = CursorUtil.d(c, "fileSize");
                    int d7 = CursorUtil.d(c, "lastShowTime");
                    int d8 = CursorUtil.d(c, "lastModified");
                    int d9 = CursorUtil.d(c, "fileType");
                    int d10 = CursorUtil.d(c, "fileStatus");
                    int d11 = CursorUtil.d(c, "userId");
                    int d12 = CursorUtil.d(c, "currentPage");
                    int d13 = CursorUtil.d(c, "totalPage");
                    int d14 = CursorUtil.d(c, "totalTextLength");
                    if (c.moveToFirst()) {
                        ticiEntity = new TiciEntity(c.getLong(d), c.getString(d2), c.getString(d3), TiciDao_Impl.this.c.a(c.getString(d4)), c.getInt(d5), c.getLong(d6), c.getLong(d7), c.getLong(d8), c.isNull(d9) ? null : Integer.valueOf(c.getInt(d9)), c.getInt(d10), c.isNull(d11) ? null : c.getString(d11), c.getInt(d12), c.getInt(d13), c.getInt(d14));
                    } else {
                        ticiEntity = null;
                    }
                    return ticiEntity;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object l(long j2, int i2, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select partSize from ticicontentpart where ticiId=? and partIndex=?", 2);
        c2.F(1, j2);
        c2.F(2, (long) i2);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<Long>() {
            /* renamed from: a */
            public Long call() {
                Long l = null;
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    if (c.moveToFirst()) {
                        if (!c.isNull(0)) {
                            l = Long.valueOf(c.getLong(0));
                        }
                    }
                    return l;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object m(String str, List list, Continuation continuation) {
        StringBuilder b2 = StringUtil.b();
        b2.append("select id FROM ticientity where userId=");
        b2.append("?");
        b2.append(" and fileType is not null and fileType in (");
        int size = list.size();
        StringUtil.a(b2, size);
        b2.append(")");
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c(b2.toString(), size + 1);
        c2.B(1, str);
        Iterator it = list.iterator();
        int i2 = 2;
        while (it.hasNext()) {
            c2.F(i2, (long) ((Integer) it.next()).intValue());
            i2++;
        }
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<List<Long>>() {
            /* renamed from: a */
            public List call() {
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(Long.valueOf(c.getLong(0)));
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object n(final TiciEntity ticiEntity, Continuation continuation) {
        return CoroutinesRoom.c(this.f5926a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                TiciDao_Impl.this.f5926a.beginTransaction();
                try {
                    TiciDao_Impl.this.e.handle(ticiEntity);
                    TiciDao_Impl.this.f5926a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    TiciDao_Impl.this.f5926a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object o(long j2, int i2, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select paragraphIndexes from ticicontentpart where ticiId=? and partIndex>? ORDER BY partIndex", 2);
        c2.F(1, j2);
        c2.F(2, (long) i2);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<List<String>>() {
            /* renamed from: a */
            public List call() {
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(c.getString(0));
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object p(final List list, Continuation continuation) {
        return CoroutinesRoom.c(this.f5926a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                TiciDao_Impl.this.f5926a.beginTransaction();
                try {
                    TiciDao_Impl.this.d.insert(list);
                    TiciDao_Impl.this.f5926a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    TiciDao_Impl.this.f5926a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object q(long j2, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM ticientity where id=?", 1);
        c2.F(1, j2);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<TiciEntity>() {
            /* renamed from: a */
            public TiciEntity call() {
                TiciEntity ticiEntity;
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "fileName");
                    int d3 = CursorUtil.d(c, "sourceText");
                    int d4 = CursorUtil.d(c, "paragraphIndexes");
                    int d5 = CursorUtil.d(c, "index");
                    int d6 = CursorUtil.d(c, "fileSize");
                    int d7 = CursorUtil.d(c, "lastShowTime");
                    int d8 = CursorUtil.d(c, "lastModified");
                    int d9 = CursorUtil.d(c, "fileType");
                    int d10 = CursorUtil.d(c, "fileStatus");
                    int d11 = CursorUtil.d(c, "userId");
                    int d12 = CursorUtil.d(c, "currentPage");
                    int d13 = CursorUtil.d(c, "totalPage");
                    int d14 = CursorUtil.d(c, "totalTextLength");
                    if (c.moveToFirst()) {
                        ticiEntity = new TiciEntity(c.getLong(d), c.getString(d2), c.getString(d3), TiciDao_Impl.this.c.a(c.getString(d4)), c.getInt(d5), c.getLong(d6), c.getLong(d7), c.getLong(d8), c.isNull(d9) ? null : Integer.valueOf(c.getInt(d9)), c.getInt(d10), c.isNull(d11) ? null : c.getString(d11), c.getInt(d12), c.getInt(d13), c.getInt(d14));
                    } else {
                        ticiEntity = null;
                    }
                    return ticiEntity;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object r(Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from ticientity ORDER BY id ASC LIMIT 1", 0);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<TiciEntity>() {
            /* renamed from: a */
            public TiciEntity call() {
                TiciEntity ticiEntity;
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, "fileName");
                    int d3 = CursorUtil.d(c, "sourceText");
                    int d4 = CursorUtil.d(c, "paragraphIndexes");
                    int d5 = CursorUtil.d(c, "index");
                    int d6 = CursorUtil.d(c, "fileSize");
                    int d7 = CursorUtil.d(c, "lastShowTime");
                    int d8 = CursorUtil.d(c, "lastModified");
                    int d9 = CursorUtil.d(c, "fileType");
                    int d10 = CursorUtil.d(c, "fileStatus");
                    int d11 = CursorUtil.d(c, "userId");
                    int d12 = CursorUtil.d(c, "currentPage");
                    int d13 = CursorUtil.d(c, "totalPage");
                    int d14 = CursorUtil.d(c, "totalTextLength");
                    if (c.moveToFirst()) {
                        ticiEntity = new TiciEntity(c.getLong(d), c.getString(d2), c.getString(d3), TiciDao_Impl.this.c.a(c.getString(d4)), c.getInt(d5), c.getLong(d6), c.getLong(d7), c.getLong(d8), c.isNull(d9) ? null : Integer.valueOf(c.getInt(d9)), c.getInt(d10), c.isNull(d11) ? null : c.getString(d11), c.getInt(d12), c.getInt(d13), c.getInt(d14));
                    } else {
                        ticiEntity = null;
                    }
                    return ticiEntity;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object s(final TiciEntity ticiEntity, Continuation continuation) {
        return CoroutinesRoom.c(this.f5926a, true, new Callable<Long>() {
            /* renamed from: a */
            public Long call() {
                TiciDao_Impl.this.f5926a.beginTransaction();
                try {
                    Long valueOf = Long.valueOf(TiciDao_Impl.this.b.insertAndReturnId(ticiEntity));
                    TiciDao_Impl.this.f5926a.setTransactionSuccessful();
                    return valueOf;
                } finally {
                    TiciDao_Impl.this.f5926a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object t(final TiciContentPart ticiContentPart, Continuation continuation) {
        return CoroutinesRoom.c(this.f5926a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                TiciDao_Impl.this.f5926a.beginTransaction();
                try {
                    TiciDao_Impl.this.d.insert(ticiContentPart);
                    TiciDao_Impl.this.f5926a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    TiciDao_Impl.this.f5926a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object u(String str, long j2, int i2, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT id, fileName, lastModified, fileType, fileSize, totalTextLength FROM ticientity where userId=? and lastModified<? ORDER BY lastModified DESC limit ?", 3);
        c2.B(1, str);
        c2.F(2, j2);
        c2.F(3, (long) i2);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<List<TiciHistory>>() {
            /* renamed from: a */
            public List call() {
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(new TiciHistory(c.getLong(0), c.getString(1), c.getLong(2), c.isNull(3) ? null : Integer.valueOf(c.getInt(3)), c.getLong(4), c.getInt(5)));
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object v(final List list, Continuation continuation) {
        return CoroutinesRoom.c(this.f5926a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                StringBuilder b2 = StringUtil.b();
                b2.append("delete from ticicontentpart where ticiId in (");
                StringUtil.a(b2, list.size());
                b2.append(")");
                SupportSQLiteStatement compileStatement = TiciDao_Impl.this.f5926a.compileStatement(b2.toString());
                int i = 1;
                for (Long longValue : list) {
                    compileStatement.F(i, longValue.longValue());
                    i++;
                }
                TiciDao_Impl.this.f5926a.beginTransaction();
                try {
                    compileStatement.k();
                    TiciDao_Impl.this.f5926a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    TiciDao_Impl.this.f5926a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object w(int i2, int i3, long j2, Continuation continuation) {
        final int i4 = i2;
        final int i5 = i3;
        final long j3 = j2;
        return CoroutinesRoom.c(this.f5926a, true, new Callable<Integer>() {
            /* renamed from: a */
            public Integer call() {
                SupportSQLiteStatement acquire = TiciDao_Impl.this.g.acquire();
                acquire.F(1, (long) i4);
                acquire.F(2, (long) i5);
                acquire.F(3, j3);
                try {
                    TiciDao_Impl.this.f5926a.beginTransaction();
                    Integer valueOf = Integer.valueOf(acquire.k());
                    TiciDao_Impl.this.f5926a.setTransactionSuccessful();
                    TiciDao_Impl.this.f5926a.endTransaction();
                    TiciDao_Impl.this.g.release(acquire);
                    return valueOf;
                } catch (Throwable th) {
                    TiciDao_Impl.this.g.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object x(final int i2, final long j2, Continuation continuation) {
        return CoroutinesRoom.c(this.f5926a, true, new Callable<Integer>() {
            /* renamed from: a */
            public Integer call() {
                SupportSQLiteStatement acquire = TiciDao_Impl.this.f.acquire();
                acquire.F(1, (long) i2);
                acquire.F(2, j2);
                try {
                    TiciDao_Impl.this.f5926a.beginTransaction();
                    Integer valueOf = Integer.valueOf(acquire.k());
                    TiciDao_Impl.this.f5926a.setTransactionSuccessful();
                    TiciDao_Impl.this.f5926a.endTransaction();
                    TiciDao_Impl.this.f.release(acquire);
                    return valueOf;
                } catch (Throwable th) {
                    TiciDao_Impl.this.f.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object y(final List list, Continuation continuation) {
        return CoroutinesRoom.c(this.f5926a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                StringBuilder b2 = StringUtil.b();
                b2.append("DELETE FROM ticientity where id in (");
                StringUtil.a(b2, list.size());
                b2.append(")");
                SupportSQLiteStatement compileStatement = TiciDao_Impl.this.f5926a.compileStatement(b2.toString());
                int i = 1;
                for (Long longValue : list) {
                    compileStatement.F(i, longValue.longValue());
                    i++;
                }
                TiciDao_Impl.this.f5926a.beginTransaction();
                try {
                    compileStatement.k();
                    TiciDao_Impl.this.f5926a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    TiciDao_Impl.this.f5926a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object z(long j2, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select paragraphIndexes from ticicontentpart where ticiId=? ORDER BY partIndex", 1);
        c2.F(1, j2);
        return CoroutinesRoom.b(this.f5926a, false, DBUtil.a(), new Callable<List<String>>() {
            /* renamed from: a */
            public List call() {
                Cursor c = DBUtil.c(TiciDao_Impl.this.f5926a, c2, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(c.getString(0));
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }
}
