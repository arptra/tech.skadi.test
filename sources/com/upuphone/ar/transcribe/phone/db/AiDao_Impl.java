package com.upuphone.ar.transcribe.phone.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AiDao_Impl implements AiDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f6079a;
    public final EntityInsertionAdapter b;
    public final EntityInsertionAdapter c;
    public final EntityDeletionOrUpdateAdapter d;
    public final EntityDeletionOrUpdateAdapter e;
    public final SharedSQLiteStatement f;
    public final SharedSQLiteStatement g;

    public AiDao_Impl(RoomDatabase roomDatabase) {
        this.f6079a = roomDatabase;
        this.b = new EntityInsertionAdapter<AiSummaryEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `summary` (`id`,`accountId`,`recognizeId`,`summary`,`src`,`deleted`,`requestId`,`reported`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AiSummaryEntity aiSummaryEntity) {
                supportSQLiteStatement.F(1, aiSummaryEntity.getId());
                supportSQLiteStatement.B(2, aiSummaryEntity.getAccountId());
                supportSQLiteStatement.B(3, aiSummaryEntity.getRecognizeId());
                supportSQLiteStatement.B(4, aiSummaryEntity.getSummary());
                if (aiSummaryEntity.getSrc() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, aiSummaryEntity.getSrc());
                }
                if (aiSummaryEntity.getDeleted() == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.F(6, (long) aiSummaryEntity.getDeleted().intValue());
                }
                if (aiSummaryEntity.getRequestId() == null) {
                    supportSQLiteStatement.L(7);
                } else {
                    supportSQLiteStatement.B(7, aiSummaryEntity.getRequestId());
                }
                if (aiSummaryEntity.getReported() == null) {
                    supportSQLiteStatement.L(8);
                } else {
                    supportSQLiteStatement.F(8, (long) aiSummaryEntity.getReported().intValue());
                }
            }
        };
        this.c = new EntityInsertionAdapter<AiTodoEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `todo_list` (`title`,`id`,`content`,`startTime`,`endTime`,`accountId`,`recognizeId`,`calendarId`,`calendarEventId`,`src`,`deleted`,`requestId`,`reported`,`isIsDone`) VALUES (?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AiTodoEntity aiTodoEntity) {
                supportSQLiteStatement.B(1, aiTodoEntity.getTitle());
                supportSQLiteStatement.F(2, aiTodoEntity.getId());
                supportSQLiteStatement.B(3, aiTodoEntity.getContent());
                supportSQLiteStatement.B(4, aiTodoEntity.getStartTime());
                supportSQLiteStatement.B(5, aiTodoEntity.getEndTime());
                supportSQLiteStatement.B(6, aiTodoEntity.getAccountId());
                supportSQLiteStatement.B(7, aiTodoEntity.getRecognizeId());
                supportSQLiteStatement.F(8, aiTodoEntity.getCalendarId());
                supportSQLiteStatement.F(9, aiTodoEntity.getCalendarEventId());
                if (aiTodoEntity.getSrc() == null) {
                    supportSQLiteStatement.L(10);
                } else {
                    supportSQLiteStatement.B(10, aiTodoEntity.getSrc());
                }
                if (aiTodoEntity.getDeleted() == null) {
                    supportSQLiteStatement.L(11);
                } else {
                    supportSQLiteStatement.F(11, (long) aiTodoEntity.getDeleted().intValue());
                }
                if (aiTodoEntity.getRequestId() == null) {
                    supportSQLiteStatement.L(12);
                } else {
                    supportSQLiteStatement.B(12, aiTodoEntity.getRequestId());
                }
                if (aiTodoEntity.getReported() == null) {
                    supportSQLiteStatement.L(13);
                } else {
                    supportSQLiteStatement.F(13, (long) aiTodoEntity.getReported().intValue());
                }
                supportSQLiteStatement.F(14, aiTodoEntity.isIsDone() ? 1 : 0);
            }
        };
        this.d = new EntityDeletionOrUpdateAdapter<AiSummaryEntity>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `summary` WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AiSummaryEntity aiSummaryEntity) {
                supportSQLiteStatement.F(1, aiSummaryEntity.getId());
            }
        };
        this.e = new EntityDeletionOrUpdateAdapter<AiTodoEntity>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `todo_list` WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AiTodoEntity aiTodoEntity) {
                supportSQLiteStatement.F(1, aiTodoEntity.getId());
            }
        };
        this.f = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE summary SET reported = 1 WHERE recognizeId = ?";
            }
        };
        this.g = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE todo_list SET reported = 1 WHERE recognizeId = ?";
            }
        };
    }

    public static List k() {
        return Collections.emptyList();
    }

    public void a(String str) {
        this.f6079a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.g.acquire();
        acquire.B(1, str);
        try {
            this.f6079a.beginTransaction();
            acquire.k();
            this.f6079a.setTransactionSuccessful();
            this.f6079a.endTransaction();
            this.g.release(acquire);
        } catch (Throwable th) {
            this.g.release(acquire);
            throw th;
        }
    }

    public int b(AiSummaryEntity aiSummaryEntity) {
        this.f6079a.assertNotSuspendingTransaction();
        this.f6079a.beginTransaction();
        try {
            int handle = this.d.handle(aiSummaryEntity);
            this.f6079a.setTransactionSuccessful();
            return handle;
        } finally {
            this.f6079a.endTransaction();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity} */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity c(java.lang.String r23) {
        /*
            r22 = this;
            r0 = r22
            java.lang.String r1 = "SELECT * FROM summary WHERE recognizeId = ? AND deleted = 0"
            r2 = 1
            androidx.room.RoomSQLiteQuery r1 = androidx.room.RoomSQLiteQuery.c(r1, r2)
            r3 = r23
            r1.B(r2, r3)
            androidx.room.RoomDatabase r2 = r0.f6079a
            r2.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r0.f6079a
            r2 = 0
            r3 = 0
            android.database.Cursor r2 = androidx.room.util.DBUtil.c(r0, r1, r2, r3)
            java.lang.String r0 = "id"
            int r0 = androidx.room.util.CursorUtil.d(r2, r0)     // Catch:{ all -> 0x00ab }
            java.lang.String r4 = "accountId"
            int r4 = androidx.room.util.CursorUtil.d(r2, r4)     // Catch:{ all -> 0x00ab }
            java.lang.String r5 = "recognizeId"
            int r5 = androidx.room.util.CursorUtil.d(r2, r5)     // Catch:{ all -> 0x00ab }
            java.lang.String r6 = "summary"
            int r6 = androidx.room.util.CursorUtil.d(r2, r6)     // Catch:{ all -> 0x00ab }
            java.lang.String r7 = "src"
            int r7 = androidx.room.util.CursorUtil.d(r2, r7)     // Catch:{ all -> 0x00ab }
            java.lang.String r8 = "deleted"
            int r8 = androidx.room.util.CursorUtil.d(r2, r8)     // Catch:{ all -> 0x00ab }
            java.lang.String r9 = "requestId"
            int r9 = androidx.room.util.CursorUtil.d(r2, r9)     // Catch:{ all -> 0x00ab }
            java.lang.String r10 = "reported"
            int r10 = androidx.room.util.CursorUtil.d(r2, r10)     // Catch:{ all -> 0x00ab }
            boolean r11 = r2.moveToFirst()     // Catch:{ all -> 0x00ab }
            if (r11 == 0) goto L_0x00ad
            long r13 = r2.getLong(r0)     // Catch:{ all -> 0x00ab }
            java.lang.String r15 = r2.getString(r4)     // Catch:{ all -> 0x00ab }
            java.lang.String r16 = r2.getString(r5)     // Catch:{ all -> 0x00ab }
            java.lang.String r17 = r2.getString(r6)     // Catch:{ all -> 0x00ab }
            boolean r0 = r2.isNull(r7)     // Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x006a
            r18 = r3
            goto L_0x0070
        L_0x006a:
            java.lang.String r0 = r2.getString(r7)     // Catch:{ all -> 0x00ab }
            r18 = r0
        L_0x0070:
            boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x0079
            r19 = r3
            goto L_0x0083
        L_0x0079:
            int r0 = r2.getInt(r8)     // Catch:{ all -> 0x00ab }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00ab }
            r19 = r0
        L_0x0083:
            boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x008c
            r20 = r3
            goto L_0x0092
        L_0x008c:
            java.lang.String r0 = r2.getString(r9)     // Catch:{ all -> 0x00ab }
            r20 = r0
        L_0x0092:
            boolean r0 = r2.isNull(r10)     // Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x009b
        L_0x0098:
            r21 = r3
            goto L_0x00a4
        L_0x009b:
            int r0 = r2.getInt(r10)     // Catch:{ all -> 0x00ab }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00ab }
            goto L_0x0098
        L_0x00a4:
            com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity r3 = new com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity     // Catch:{ all -> 0x00ab }
            r12 = r3
            r12.<init>(r13, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x00ab }
            goto L_0x00ad
        L_0x00ab:
            r0 = move-exception
            goto L_0x00b4
        L_0x00ad:
            r2.close()
            r1.release()
            return r3
        L_0x00b4:
            r2.close()
            r1.release()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.db.AiDao_Impl.c(java.lang.String):com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity");
    }

    public List d(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM todo_list WHERE recognizeId = ?", 1);
        c2.B(1, str);
        this.f6079a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f6079a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "title");
            int d3 = CursorUtil.d(c3, "id");
            int d4 = CursorUtil.d(c3, "content");
            int d5 = CursorUtil.d(c3, "startTime");
            int d6 = CursorUtil.d(c3, "endTime");
            int d7 = CursorUtil.d(c3, "accountId");
            int d8 = CursorUtil.d(c3, "recognizeId");
            int d9 = CursorUtil.d(c3, "calendarId");
            int d10 = CursorUtil.d(c3, "calendarEventId");
            int d11 = CursorUtil.d(c3, "src");
            int d12 = CursorUtil.d(c3, "deleted");
            int d13 = CursorUtil.d(c3, "requestId");
            int d14 = CursorUtil.d(c3, "reported");
            roomSQLiteQuery = c2;
            try {
                int d15 = CursorUtil.d(c3, "isIsDone");
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    AiTodoEntity aiTodoEntity = new AiTodoEntity();
                    ArrayList arrayList2 = arrayList;
                    aiTodoEntity.setTitle(c3.getString(d2));
                    int i = d2;
                    aiTodoEntity.setId(c3.getLong(d3));
                    aiTodoEntity.setContent(c3.getString(d4));
                    aiTodoEntity.setStartTime(c3.getString(d5));
                    aiTodoEntity.setEndTime(c3.getString(d6));
                    aiTodoEntity.setAccountId(c3.getString(d7));
                    aiTodoEntity.setRecognizeId(c3.getString(d8));
                    aiTodoEntity.setCalendarId(c3.getLong(d9));
                    aiTodoEntity.setCalendarEventId(c3.getLong(d10));
                    aiTodoEntity.setSrc(c3.isNull(d11) ? null : c3.getString(d11));
                    aiTodoEntity.setDeleted(c3.isNull(d12) ? null : Integer.valueOf(c3.getInt(d12)));
                    aiTodoEntity.setRequestId(c3.isNull(d13) ? null : c3.getString(d13));
                    aiTodoEntity.setReported(c3.isNull(d14) ? null : Integer.valueOf(c3.getInt(d14)));
                    int i2 = d15;
                    aiTodoEntity.setIsDone(c3.getInt(i2) != 0);
                    arrayList = arrayList2;
                    arrayList.add(aiTodoEntity);
                    d15 = i2;
                    d2 = i;
                }
                c3.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c3.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = c2;
            c3.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public Long[] e(List list) {
        this.f6079a.assertNotSuspendingTransaction();
        this.f6079a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.c.insertAndReturnIdsArrayBox(list);
            this.f6079a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.f6079a.endTransaction();
        }
    }

    public void f(String str) {
        this.f6079a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f.acquire();
        acquire.B(1, str);
        try {
            this.f6079a.beginTransaction();
            acquire.k();
            this.f6079a.setTransactionSuccessful();
            this.f6079a.endTransaction();
            this.f.release(acquire);
        } catch (Throwable th) {
            this.f.release(acquire);
            throw th;
        }
    }

    public List g(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM todo_list WHERE recognizeId = ? AND deleted = 0", 1);
        c2.B(1, str);
        this.f6079a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f6079a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "title");
            int d3 = CursorUtil.d(c3, "id");
            int d4 = CursorUtil.d(c3, "content");
            int d5 = CursorUtil.d(c3, "startTime");
            int d6 = CursorUtil.d(c3, "endTime");
            int d7 = CursorUtil.d(c3, "accountId");
            int d8 = CursorUtil.d(c3, "recognizeId");
            int d9 = CursorUtil.d(c3, "calendarId");
            int d10 = CursorUtil.d(c3, "calendarEventId");
            int d11 = CursorUtil.d(c3, "src");
            int d12 = CursorUtil.d(c3, "deleted");
            int d13 = CursorUtil.d(c3, "requestId");
            int d14 = CursorUtil.d(c3, "reported");
            roomSQLiteQuery = c2;
            try {
                int d15 = CursorUtil.d(c3, "isIsDone");
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    AiTodoEntity aiTodoEntity = new AiTodoEntity();
                    ArrayList arrayList2 = arrayList;
                    aiTodoEntity.setTitle(c3.getString(d2));
                    int i = d2;
                    aiTodoEntity.setId(c3.getLong(d3));
                    aiTodoEntity.setContent(c3.getString(d4));
                    aiTodoEntity.setStartTime(c3.getString(d5));
                    aiTodoEntity.setEndTime(c3.getString(d6));
                    aiTodoEntity.setAccountId(c3.getString(d7));
                    aiTodoEntity.setRecognizeId(c3.getString(d8));
                    aiTodoEntity.setCalendarId(c3.getLong(d9));
                    aiTodoEntity.setCalendarEventId(c3.getLong(d10));
                    aiTodoEntity.setSrc(c3.isNull(d11) ? null : c3.getString(d11));
                    aiTodoEntity.setDeleted(c3.isNull(d12) ? null : Integer.valueOf(c3.getInt(d12)));
                    aiTodoEntity.setRequestId(c3.isNull(d13) ? null : c3.getString(d13));
                    aiTodoEntity.setReported(c3.isNull(d14) ? null : Integer.valueOf(c3.getInt(d14)));
                    int i2 = d15;
                    aiTodoEntity.setIsDone(c3.getInt(i2) != 0);
                    arrayList = arrayList2;
                    arrayList.add(aiTodoEntity);
                    d15 = i2;
                    d2 = i;
                }
                c3.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c3.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = c2;
            c3.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public long h(AiSummaryEntity aiSummaryEntity) {
        this.f6079a.assertNotSuspendingTransaction();
        this.f6079a.beginTransaction();
        try {
            long insertAndReturnId = this.b.insertAndReturnId(aiSummaryEntity);
            this.f6079a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.f6079a.endTransaction();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity} */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity i(java.lang.String r23) {
        /*
            r22 = this;
            r0 = r22
            java.lang.String r1 = "SELECT * FROM summary WHERE recognizeId = ?"
            r2 = 1
            androidx.room.RoomSQLiteQuery r1 = androidx.room.RoomSQLiteQuery.c(r1, r2)
            r3 = r23
            r1.B(r2, r3)
            androidx.room.RoomDatabase r2 = r0.f6079a
            r2.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r0.f6079a
            r2 = 0
            r3 = 0
            android.database.Cursor r2 = androidx.room.util.DBUtil.c(r0, r1, r2, r3)
            java.lang.String r0 = "id"
            int r0 = androidx.room.util.CursorUtil.d(r2, r0)     // Catch:{ all -> 0x00ab }
            java.lang.String r4 = "accountId"
            int r4 = androidx.room.util.CursorUtil.d(r2, r4)     // Catch:{ all -> 0x00ab }
            java.lang.String r5 = "recognizeId"
            int r5 = androidx.room.util.CursorUtil.d(r2, r5)     // Catch:{ all -> 0x00ab }
            java.lang.String r6 = "summary"
            int r6 = androidx.room.util.CursorUtil.d(r2, r6)     // Catch:{ all -> 0x00ab }
            java.lang.String r7 = "src"
            int r7 = androidx.room.util.CursorUtil.d(r2, r7)     // Catch:{ all -> 0x00ab }
            java.lang.String r8 = "deleted"
            int r8 = androidx.room.util.CursorUtil.d(r2, r8)     // Catch:{ all -> 0x00ab }
            java.lang.String r9 = "requestId"
            int r9 = androidx.room.util.CursorUtil.d(r2, r9)     // Catch:{ all -> 0x00ab }
            java.lang.String r10 = "reported"
            int r10 = androidx.room.util.CursorUtil.d(r2, r10)     // Catch:{ all -> 0x00ab }
            boolean r11 = r2.moveToFirst()     // Catch:{ all -> 0x00ab }
            if (r11 == 0) goto L_0x00ad
            long r13 = r2.getLong(r0)     // Catch:{ all -> 0x00ab }
            java.lang.String r15 = r2.getString(r4)     // Catch:{ all -> 0x00ab }
            java.lang.String r16 = r2.getString(r5)     // Catch:{ all -> 0x00ab }
            java.lang.String r17 = r2.getString(r6)     // Catch:{ all -> 0x00ab }
            boolean r0 = r2.isNull(r7)     // Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x006a
            r18 = r3
            goto L_0x0070
        L_0x006a:
            java.lang.String r0 = r2.getString(r7)     // Catch:{ all -> 0x00ab }
            r18 = r0
        L_0x0070:
            boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x0079
            r19 = r3
            goto L_0x0083
        L_0x0079:
            int r0 = r2.getInt(r8)     // Catch:{ all -> 0x00ab }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00ab }
            r19 = r0
        L_0x0083:
            boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x008c
            r20 = r3
            goto L_0x0092
        L_0x008c:
            java.lang.String r0 = r2.getString(r9)     // Catch:{ all -> 0x00ab }
            r20 = r0
        L_0x0092:
            boolean r0 = r2.isNull(r10)     // Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x009b
        L_0x0098:
            r21 = r3
            goto L_0x00a4
        L_0x009b:
            int r0 = r2.getInt(r10)     // Catch:{ all -> 0x00ab }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00ab }
            goto L_0x0098
        L_0x00a4:
            com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity r3 = new com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity     // Catch:{ all -> 0x00ab }
            r12 = r3
            r12.<init>(r13, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x00ab }
            goto L_0x00ad
        L_0x00ab:
            r0 = move-exception
            goto L_0x00b4
        L_0x00ad:
            r2.close()
            r1.release()
            return r3
        L_0x00b4:
            r2.close()
            r1.release()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.transcribe.phone.db.AiDao_Impl.i(java.lang.String):com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity");
    }

    public int j(List list) {
        this.f6079a.assertNotSuspendingTransaction();
        this.f6079a.beginTransaction();
        try {
            int handleMultiple = this.e.handleMultiple(list);
            this.f6079a.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.f6079a.endTransaction();
        }
    }
}
