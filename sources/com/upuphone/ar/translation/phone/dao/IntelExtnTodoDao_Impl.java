package com.upuphone.ar.translation.phone.dao;

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
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class IntelExtnTodoDao_Impl implements IntelExtnTodoDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f6229a;
    public final EntityInsertionAdapter b;
    public final EntityDeletionOrUpdateAdapter c;
    public final EntityDeletionOrUpdateAdapter d;
    public final SharedSQLiteStatement e;
    public final SharedSQLiteStatement f;

    public IntelExtnTodoDao_Impl(RoomDatabase roomDatabase) {
        this.f6229a = roomDatabase;
        this.b = new EntityInsertionAdapter<IntelExtnTodo>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `IntelExtnTodo` (`title`,`id`,`content`,`originalContent`,`startTime`,`endTime`,`accountId`,`recognizeId`,`requestId`,`calendarId`,`calendarEventId`,`isAddedSchedule`,`isIsDone`,`deleteStatus`,`isReported`) VALUES (?,nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, IntelExtnTodo intelExtnTodo) {
                supportSQLiteStatement.B(1, intelExtnTodo.getTitle());
                supportSQLiteStatement.F(2, intelExtnTodo.getId());
                supportSQLiteStatement.B(3, intelExtnTodo.getContent());
                supportSQLiteStatement.B(4, intelExtnTodo.getOriginalContent());
                supportSQLiteStatement.B(5, intelExtnTodo.getStartTime());
                supportSQLiteStatement.B(6, intelExtnTodo.getEndTime());
                supportSQLiteStatement.B(7, intelExtnTodo.getAccountId());
                supportSQLiteStatement.B(8, intelExtnTodo.getRecognizeId());
                supportSQLiteStatement.B(9, intelExtnTodo.getRequestId());
                supportSQLiteStatement.F(10, intelExtnTodo.getCalendarId());
                supportSQLiteStatement.F(11, intelExtnTodo.getCalendarEventId());
                supportSQLiteStatement.F(12, intelExtnTodo.isAddedSchedule() ? 1 : 0);
                supportSQLiteStatement.F(13, intelExtnTodo.isIsDone() ? 1 : 0);
                supportSQLiteStatement.F(14, (long) intelExtnTodo.getDeleteStatus());
                supportSQLiteStatement.F(15, intelExtnTodo.isReported() ? 1 : 0);
            }
        };
        this.c = new EntityDeletionOrUpdateAdapter<IntelExtnTodo>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `IntelExtnTodo` WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, IntelExtnTodo intelExtnTodo) {
                supportSQLiteStatement.F(1, intelExtnTodo.getId());
            }
        };
        this.d = new EntityDeletionOrUpdateAdapter<IntelExtnTodo>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `IntelExtnTodo` SET `title` = ?,`id` = ?,`content` = ?,`originalContent` = ?,`startTime` = ?,`endTime` = ?,`accountId` = ?,`recognizeId` = ?,`requestId` = ?,`calendarId` = ?,`calendarEventId` = ?,`isAddedSchedule` = ?,`isIsDone` = ?,`deleteStatus` = ?,`isReported` = ? WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, IntelExtnTodo intelExtnTodo) {
                supportSQLiteStatement.B(1, intelExtnTodo.getTitle());
                supportSQLiteStatement.F(2, intelExtnTodo.getId());
                supportSQLiteStatement.B(3, intelExtnTodo.getContent());
                supportSQLiteStatement.B(4, intelExtnTodo.getOriginalContent());
                supportSQLiteStatement.B(5, intelExtnTodo.getStartTime());
                supportSQLiteStatement.B(6, intelExtnTodo.getEndTime());
                supportSQLiteStatement.B(7, intelExtnTodo.getAccountId());
                supportSQLiteStatement.B(8, intelExtnTodo.getRecognizeId());
                supportSQLiteStatement.B(9, intelExtnTodo.getRequestId());
                supportSQLiteStatement.F(10, intelExtnTodo.getCalendarId());
                supportSQLiteStatement.F(11, intelExtnTodo.getCalendarEventId());
                supportSQLiteStatement.F(12, intelExtnTodo.isAddedSchedule() ? 1 : 0);
                supportSQLiteStatement.F(13, intelExtnTodo.isIsDone() ? 1 : 0);
                supportSQLiteStatement.F(14, (long) intelExtnTodo.getDeleteStatus());
                supportSQLiteStatement.F(15, intelExtnTodo.isReported() ? 1 : 0);
                supportSQLiteStatement.F(16, intelExtnTodo.getId());
            }
        };
        this.e = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE intelextntodo SET deleteStatus = ? WHERE accountId = ? AND recognizeId = ?";
            }
        };
        this.f = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE intelextntodo SET isReported = ? WHERE accountId = ? AND recognizeId = ?";
            }
        };
    }

    public static List i() {
        return Collections.emptyList();
    }

    public List a(List list) {
        this.f6229a.assertNotSuspendingTransaction();
        this.f6229a.beginTransaction();
        try {
            List<Long> insertAndReturnIdsList = this.b.insertAndReturnIdsList(list);
            this.f6229a.setTransactionSuccessful();
            return insertAndReturnIdsList;
        } finally {
            this.f6229a.endTransaction();
        }
    }

    public void b(String str, String str2, int i) {
        this.f6229a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
        acquire.F(1, (long) i);
        acquire.B(2, str);
        acquire.B(3, str2);
        try {
            this.f6229a.beginTransaction();
            acquire.k();
            this.f6229a.setTransactionSuccessful();
            this.f6229a.endTransaction();
            this.e.release(acquire);
        } catch (Throwable th) {
            this.e.release(acquire);
            throw th;
        }
    }

    public List c(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM intelextntodo WHERE accountId = ? AND recognizeId = ?", 2);
        c2.B(1, str);
        c2.B(2, str2);
        this.f6229a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f6229a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "title");
            int d3 = CursorUtil.d(c3, "id");
            int d4 = CursorUtil.d(c3, "content");
            int d5 = CursorUtil.d(c3, "originalContent");
            int d6 = CursorUtil.d(c3, "startTime");
            int d7 = CursorUtil.d(c3, "endTime");
            int d8 = CursorUtil.d(c3, "accountId");
            int d9 = CursorUtil.d(c3, "recognizeId");
            int d10 = CursorUtil.d(c3, "requestId");
            int d11 = CursorUtil.d(c3, "calendarId");
            int d12 = CursorUtil.d(c3, "calendarEventId");
            int d13 = CursorUtil.d(c3, "isAddedSchedule");
            int d14 = CursorUtil.d(c3, "isIsDone");
            int d15 = CursorUtil.d(c3, "deleteStatus");
            roomSQLiteQuery = c2;
            try {
                int d16 = CursorUtil.d(c3, "isReported");
                int i = d15;
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    IntelExtnTodo intelExtnTodo = new IntelExtnTodo();
                    ArrayList arrayList2 = arrayList;
                    intelExtnTodo.setTitle(c3.getString(d2));
                    int i2 = d2;
                    intelExtnTodo.setId(c3.getLong(d3));
                    intelExtnTodo.setContent(c3.getString(d4));
                    intelExtnTodo.setOriginalContent(c3.getString(d5));
                    intelExtnTodo.setStartTime(c3.getString(d6));
                    intelExtnTodo.setEndTime(c3.getString(d7));
                    intelExtnTodo.setAccountId(c3.getString(d8));
                    intelExtnTodo.setRecognizeId(c3.getString(d9));
                    intelExtnTodo.setRequestId(c3.getString(d10));
                    intelExtnTodo.setCalendarId(c3.getLong(d11));
                    intelExtnTodo.setCalendarEventId(c3.getLong(d12));
                    intelExtnTodo.setAddedSchedule(c3.getInt(d13) != 0);
                    intelExtnTodo.setIsDone(c3.getInt(d14) != 0);
                    int i3 = i;
                    intelExtnTodo.setDeleteStatus(c3.getInt(i3));
                    int i4 = d16;
                    i = i3;
                    intelExtnTodo.setReported(c3.getInt(i4) != 0);
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(intelExtnTodo);
                    d16 = i4;
                    arrayList = arrayList3;
                    d2 = i2;
                }
                ArrayList arrayList4 = arrayList;
                c3.close();
                roomSQLiteQuery.release();
                return arrayList4;
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

    public void d(List list) {
        this.f6229a.assertNotSuspendingTransaction();
        this.f6229a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.f6229a.setTransactionSuccessful();
        } finally {
            this.f6229a.endTransaction();
        }
    }

    public int e(String str, String str2) {
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT COUNT(*) FROM intelextntodo WHERE accountId = ? AND recognizeId = ?", 2);
        c2.B(1, str);
        c2.B(2, str2);
        this.f6229a.assertNotSuspendingTransaction();
        int i = 0;
        Cursor c3 = DBUtil.c(this.f6229a, c2, false, (CancellationSignal) null);
        try {
            if (c3.moveToFirst()) {
                i = c3.getInt(0);
            }
            return i;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public void f(IntelExtnTodo... intelExtnTodoArr) {
        this.f6229a.assertNotSuspendingTransaction();
        this.f6229a.beginTransaction();
        try {
            this.d.handleMultiple((T[]) intelExtnTodoArr);
            this.f6229a.setTransactionSuccessful();
        } finally {
            this.f6229a.endTransaction();
        }
    }

    public List g(String str, String str2, int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM intelextntodo WHERE accountId = ? AND recognizeId = ? AND deleteStatus = ?", 3);
        c2.B(1, str);
        c2.B(2, str2);
        c2.F(3, (long) i);
        this.f6229a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f6229a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "title");
            int d3 = CursorUtil.d(c3, "id");
            int d4 = CursorUtil.d(c3, "content");
            int d5 = CursorUtil.d(c3, "originalContent");
            int d6 = CursorUtil.d(c3, "startTime");
            int d7 = CursorUtil.d(c3, "endTime");
            int d8 = CursorUtil.d(c3, "accountId");
            int d9 = CursorUtil.d(c3, "recognizeId");
            int d10 = CursorUtil.d(c3, "requestId");
            int d11 = CursorUtil.d(c3, "calendarId");
            int d12 = CursorUtil.d(c3, "calendarEventId");
            int d13 = CursorUtil.d(c3, "isAddedSchedule");
            int d14 = CursorUtil.d(c3, "isIsDone");
            int d15 = CursorUtil.d(c3, "deleteStatus");
            roomSQLiteQuery = c2;
            try {
                int d16 = CursorUtil.d(c3, "isReported");
                int i2 = d15;
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    IntelExtnTodo intelExtnTodo = new IntelExtnTodo();
                    ArrayList arrayList2 = arrayList;
                    intelExtnTodo.setTitle(c3.getString(d2));
                    int i3 = d2;
                    intelExtnTodo.setId(c3.getLong(d3));
                    intelExtnTodo.setContent(c3.getString(d4));
                    intelExtnTodo.setOriginalContent(c3.getString(d5));
                    intelExtnTodo.setStartTime(c3.getString(d6));
                    intelExtnTodo.setEndTime(c3.getString(d7));
                    intelExtnTodo.setAccountId(c3.getString(d8));
                    intelExtnTodo.setRecognizeId(c3.getString(d9));
                    intelExtnTodo.setRequestId(c3.getString(d10));
                    intelExtnTodo.setCalendarId(c3.getLong(d11));
                    intelExtnTodo.setCalendarEventId(c3.getLong(d12));
                    intelExtnTodo.setAddedSchedule(c3.getInt(d13) != 0);
                    intelExtnTodo.setIsDone(c3.getInt(d14) != 0);
                    int i4 = i2;
                    intelExtnTodo.setDeleteStatus(c3.getInt(i4));
                    int i5 = d16;
                    i2 = i4;
                    intelExtnTodo.setReported(c3.getInt(i5) != 0);
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(intelExtnTodo);
                    d16 = i5;
                    arrayList = arrayList3;
                    d2 = i3;
                }
                ArrayList arrayList4 = arrayList;
                c3.close();
                roomSQLiteQuery.release();
                return arrayList4;
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

    public void h(String str, String str2, boolean z) {
        this.f6229a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f.acquire();
        acquire.F(1, z ? 1 : 0);
        acquire.B(2, str);
        acquire.B(3, str2);
        try {
            this.f6229a.beginTransaction();
            acquire.k();
            this.f6229a.setTransactionSuccessful();
            this.f6229a.endTransaction();
            this.f.release(acquire);
        } catch (Throwable th) {
            this.f.release(acquire);
            throw th;
        }
    }
}
