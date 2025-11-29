package com.upuphone.ar.navi.lite.dao;

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
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.ar.navi.lite.base.Record;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecordDao_Impl extends RecordDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f5685a;
    public final EntityInsertionAdapter b;
    public final EntityDeletionOrUpdateAdapter c;
    public final EntityDeletionOrUpdateAdapter d;
    public final SharedSQLiteStatement e;
    public final SharedSQLiteStatement f;

    public RecordDao_Impl(RoomDatabase roomDatabase) {
        this.f5685a = roomDatabase;
        this.b = new EntityInsertionAdapter<Record>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `history_record` (`id`,`accountId`,`name`,`acode`,`address`,`country`,`province`,`city`,`district`,`distance`,`lng`,`lat`,`lastUseTime`,`count`,`alias`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Record record) {
                supportSQLiteStatement.F(1, (long) record.l());
                if (record.a() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, record.a());
                }
                if (record.getName() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, record.getName());
                }
                if (record.c() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, record.c());
                }
                if (record.e() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, record.e());
                }
                if (record.i() == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.B(6, record.i());
                }
                if (record.q() == null) {
                    supportSQLiteStatement.L(7);
                } else {
                    supportSQLiteStatement.B(7, record.q());
                }
                if (record.g() == null) {
                    supportSQLiteStatement.L(8);
                } else {
                    supportSQLiteStatement.B(8, record.g());
                }
                if (record.k() == null) {
                    supportSQLiteStatement.L(9);
                } else {
                    supportSQLiteStatement.B(9, record.k());
                }
                supportSQLiteStatement.F(10, (long) record.j());
                supportSQLiteStatement.R(11, record.p());
                supportSQLiteStatement.R(12, record.n());
                if (record.m() == null) {
                    supportSQLiteStatement.L(13);
                } else {
                    supportSQLiteStatement.B(13, record.m());
                }
                supportSQLiteStatement.F(14, (long) record.h());
                if (record.f() == null) {
                    supportSQLiteStatement.L(15);
                } else {
                    supportSQLiteStatement.B(15, record.f());
                }
            }
        };
        this.c = new EntityDeletionOrUpdateAdapter<Record>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `history_record` WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Record record) {
                supportSQLiteStatement.F(1, (long) record.l());
            }
        };
        this.d = new EntityDeletionOrUpdateAdapter<Record>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `history_record` SET `id` = ?,`accountId` = ?,`name` = ?,`acode` = ?,`address` = ?,`country` = ?,`province` = ?,`city` = ?,`district` = ?,`distance` = ?,`lng` = ?,`lat` = ?,`lastUseTime` = ?,`count` = ?,`alias` = ? WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Record record) {
                supportSQLiteStatement.F(1, (long) record.l());
                if (record.a() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, record.a());
                }
                if (record.getName() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, record.getName());
                }
                if (record.c() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, record.c());
                }
                if (record.e() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, record.e());
                }
                if (record.i() == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.B(6, record.i());
                }
                if (record.q() == null) {
                    supportSQLiteStatement.L(7);
                } else {
                    supportSQLiteStatement.B(7, record.q());
                }
                if (record.g() == null) {
                    supportSQLiteStatement.L(8);
                } else {
                    supportSQLiteStatement.B(8, record.g());
                }
                if (record.k() == null) {
                    supportSQLiteStatement.L(9);
                } else {
                    supportSQLiteStatement.B(9, record.k());
                }
                supportSQLiteStatement.F(10, (long) record.j());
                supportSQLiteStatement.R(11, record.p());
                supportSQLiteStatement.R(12, record.n());
                if (record.m() == null) {
                    supportSQLiteStatement.L(13);
                } else {
                    supportSQLiteStatement.B(13, record.m());
                }
                supportSQLiteStatement.F(14, (long) record.h());
                if (record.f() == null) {
                    supportSQLiteStatement.L(15);
                } else {
                    supportSQLiteStatement.B(15, record.f());
                }
                supportSQLiteStatement.F(16, (long) record.l());
            }
        };
        this.e = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete from history_record where accountId = ? AND id in (select id from history_record order by id asc limit(?))";
            }
        };
        this.f = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete from history_record where accountId = ?";
            }
        };
    }

    public static List l() {
        return Collections.emptyList();
    }

    public int a() {
        int i = 0;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select count(0) from history_record", 0);
        this.f5685a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f5685a, c2, false, (CancellationSignal) null);
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

    public int b(Record... recordArr) {
        this.f5685a.assertNotSuspendingTransaction();
        this.f5685a.beginTransaction();
        try {
            int handleMultiple = this.c.handleMultiple((T[]) recordArr);
            this.f5685a.setTransactionSuccessful();
            return handleMultiple;
        } finally {
            this.f5685a.endTransaction();
        }
    }

    public void c(String str) {
        this.f5685a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        try {
            this.f5685a.beginTransaction();
            acquire.k();
            this.f5685a.setTransactionSuccessful();
            this.f5685a.endTransaction();
            this.f.release(acquire);
        } catch (Throwable th) {
            this.f.release(acquire);
            throw th;
        }
    }

    public void d(String str, int i) {
        this.f5685a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        acquire.F(2, (long) i);
        try {
            this.f5685a.beginTransaction();
            acquire.k();
            this.f5685a.setTransactionSuccessful();
            this.f5685a.endTransaction();
            this.e.release(acquire);
        } catch (Throwable th) {
            this.e.release(acquire);
            throw th;
        }
    }

    public void e(Record record) {
        this.f5685a.beginTransaction();
        try {
            super.e(record);
            this.f5685a.setTransactionSuccessful();
        } finally {
            this.f5685a.endTransaction();
        }
    }

    public void f(Record... recordArr) {
        this.f5685a.assertNotSuspendingTransaction();
        this.f5685a.beginTransaction();
        try {
            this.b.insert((T[]) recordArr);
            this.f5685a.setTransactionSuccessful();
        } finally {
            this.f5685a.endTransaction();
        }
    }

    public List g(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        String str2;
        String str3 = str;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM history_record where accountId = ?", 1);
        if (str3 == null) {
            c2.L(1);
        } else {
            c2.B(1, str3);
        }
        this.f5685a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f5685a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "accountId");
            int d4 = CursorUtil.d(c3, "name");
            int d5 = CursorUtil.d(c3, "acode");
            int d6 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.ADDRESS);
            int d7 = CursorUtil.d(c3, "country");
            int d8 = CursorUtil.d(c3, "province");
            int d9 = CursorUtil.d(c3, "city");
            int d10 = CursorUtil.d(c3, "district");
            int d11 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.DISTANCE);
            int d12 = CursorUtil.d(c3, "lng");
            int d13 = CursorUtil.d(c3, "lat");
            int d14 = CursorUtil.d(c3, "lastUseTime");
            int d15 = CursorUtil.d(c3, "count");
            roomSQLiteQuery = c2;
            try {
                int d16 = CursorUtil.d(c3, "alias");
                int i2 = d15;
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    Record record = new Record();
                    ArrayList arrayList2 = arrayList;
                    record.A(c3.getInt(d2));
                    record.r(c3.isNull(d3) ? null : c3.getString(d3));
                    record.E(c3.isNull(d4) ? null : c3.getString(d4));
                    record.s(c3.isNull(d5) ? null : c3.getString(d5));
                    record.t(c3.isNull(d6) ? null : c3.getString(d6));
                    record.x(c3.isNull(d7) ? null : c3.getString(d7));
                    record.F(c3.isNull(d8) ? null : c3.getString(d8));
                    record.v(c3.isNull(d9) ? null : c3.getString(d9));
                    record.z(c3.isNull(d10) ? null : c3.getString(d10));
                    record.y(c3.getInt(d11));
                    int i3 = d3;
                    int i4 = d4;
                    record.D(c3.getDouble(d12));
                    record.C(c3.getDouble(d13));
                    record.B(c3.isNull(d14) ? null : c3.getString(d14));
                    int i5 = i2;
                    record.w(c3.getInt(i5));
                    int i6 = d16;
                    if (c3.isNull(i6)) {
                        i = d2;
                        str2 = null;
                    } else {
                        i = d2;
                        str2 = c3.getString(i6);
                    }
                    record.u(str2);
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(record);
                    i2 = i5;
                    d3 = i3;
                    arrayList = arrayList3;
                    d2 = i;
                    d16 = i6;
                    d4 = i4;
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

    public List h() {
        RoomSQLiteQuery roomSQLiteQuery;
        String str;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT * FROM history_record", 0);
        this.f5685a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f5685a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "accountId");
            int d4 = CursorUtil.d(c3, "name");
            int d5 = CursorUtil.d(c3, "acode");
            int d6 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.ADDRESS);
            int d7 = CursorUtil.d(c3, "country");
            int d8 = CursorUtil.d(c3, "province");
            int d9 = CursorUtil.d(c3, "city");
            int d10 = CursorUtil.d(c3, "district");
            int d11 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.DISTANCE);
            int d12 = CursorUtil.d(c3, "lng");
            int d13 = CursorUtil.d(c3, "lat");
            int d14 = CursorUtil.d(c3, "lastUseTime");
            int d15 = CursorUtil.d(c3, "count");
            roomSQLiteQuery = c2;
            try {
                int d16 = CursorUtil.d(c3, "alias");
                int i = d15;
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    Record record = new Record();
                    ArrayList arrayList2 = arrayList;
                    record.A(c3.getInt(d2));
                    record.r(c3.isNull(d3) ? null : c3.getString(d3));
                    record.E(c3.isNull(d4) ? null : c3.getString(d4));
                    record.s(c3.isNull(d5) ? null : c3.getString(d5));
                    record.t(c3.isNull(d6) ? null : c3.getString(d6));
                    record.x(c3.isNull(d7) ? null : c3.getString(d7));
                    record.F(c3.isNull(d8) ? null : c3.getString(d8));
                    record.v(c3.isNull(d9) ? null : c3.getString(d9));
                    record.z(c3.isNull(d10) ? null : c3.getString(d10));
                    record.y(c3.getInt(d11));
                    int i2 = d2;
                    record.D(c3.getDouble(d12));
                    record.C(c3.getDouble(d13));
                    record.B(c3.isNull(d14) ? null : c3.getString(d14));
                    int i3 = i;
                    record.w(c3.getInt(i3));
                    int i4 = d16;
                    if (c3.isNull(i4)) {
                        i = i3;
                        str = null;
                    } else {
                        i = i3;
                        str = c3.getString(i4);
                    }
                    record.u(str);
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(record);
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

    public List i(String str, int i, int i2) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i3;
        String str2;
        String str3 = str;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from history_record  where accountId = ? order by id desc limit(?) offset ((?-1)*?)", 4);
        if (str3 == null) {
            c2.L(1);
        } else {
            c2.B(1, str3);
        }
        long j = (long) i2;
        c2.F(2, j);
        c2.F(3, (long) i);
        c2.F(4, j);
        this.f5685a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f5685a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "accountId");
            int d4 = CursorUtil.d(c3, "name");
            int d5 = CursorUtil.d(c3, "acode");
            int d6 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.ADDRESS);
            int d7 = CursorUtil.d(c3, "country");
            int d8 = CursorUtil.d(c3, "province");
            int d9 = CursorUtil.d(c3, "city");
            int d10 = CursorUtil.d(c3, "district");
            int d11 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.DISTANCE);
            int d12 = CursorUtil.d(c3, "lng");
            int d13 = CursorUtil.d(c3, "lat");
            int d14 = CursorUtil.d(c3, "lastUseTime");
            int d15 = CursorUtil.d(c3, "count");
            roomSQLiteQuery = c2;
            try {
                int d16 = CursorUtil.d(c3, "alias");
                int i4 = d15;
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    Record record = new Record();
                    ArrayList arrayList2 = arrayList;
                    record.A(c3.getInt(d2));
                    record.r(c3.isNull(d3) ? null : c3.getString(d3));
                    record.E(c3.isNull(d4) ? null : c3.getString(d4));
                    record.s(c3.isNull(d5) ? null : c3.getString(d5));
                    record.t(c3.isNull(d6) ? null : c3.getString(d6));
                    record.x(c3.isNull(d7) ? null : c3.getString(d7));
                    record.F(c3.isNull(d8) ? null : c3.getString(d8));
                    record.v(c3.isNull(d9) ? null : c3.getString(d9));
                    record.z(c3.isNull(d10) ? null : c3.getString(d10));
                    record.y(c3.getInt(d11));
                    int i5 = d3;
                    int i6 = d4;
                    record.D(c3.getDouble(d12));
                    record.C(c3.getDouble(d13));
                    record.B(c3.isNull(d14) ? null : c3.getString(d14));
                    int i7 = i4;
                    record.w(c3.getInt(i7));
                    int i8 = d16;
                    if (c3.isNull(i8)) {
                        i3 = d2;
                        str2 = null;
                    } else {
                        i3 = d2;
                        str2 = c3.getString(i8);
                    }
                    record.u(str2);
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(record);
                    i4 = i7;
                    d3 = i5;
                    arrayList = arrayList3;
                    d2 = i3;
                    d16 = i8;
                    d4 = i6;
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

    public void j(Record... recordArr) {
        this.f5685a.assertNotSuspendingTransaction();
        this.f5685a.beginTransaction();
        try {
            this.d.handleMultiple((T[]) recordArr);
            this.f5685a.setTransactionSuccessful();
        } finally {
            this.f5685a.endTransaction();
        }
    }
}
