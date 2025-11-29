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
import com.upuphone.ar.navi.lite.base.NaviRecord;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class NaviRecordDao_Impl implements NaviRecordDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f5680a;
    public final EntityInsertionAdapter b;
    public final EntityDeletionOrUpdateAdapter c;
    public final EntityDeletionOrUpdateAdapter d;
    public final SharedSQLiteStatement e;

    public NaviRecordDao_Impl(RoomDatabase roomDatabase) {
        this.f5680a = roomDatabase;
        this.b = new EntityInsertionAdapter<NaviRecord>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR ABORT INTO `navi_record` (`id`,`accountId`,`name`,`address`,`acode`,`city`,`distance`,`lng`,`lat`,`mode`,`alias`,`count`,`time`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NaviRecord naviRecord) {
                supportSQLiteStatement.F(1, (long) naviRecord.h());
                if (naviRecord.a() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, naviRecord.a());
                }
                if (naviRecord.l() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, naviRecord.l());
                }
                if (naviRecord.c() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, naviRecord.c());
                }
                if (naviRecord.b() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, naviRecord.b());
                }
                if (naviRecord.e() == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.B(6, naviRecord.e());
                }
                supportSQLiteStatement.F(7, (long) naviRecord.g());
                supportSQLiteStatement.R(8, naviRecord.j());
                supportSQLiteStatement.R(9, naviRecord.i());
                supportSQLiteStatement.F(10, (long) naviRecord.k());
                if (naviRecord.d() == null) {
                    supportSQLiteStatement.L(11);
                } else {
                    supportSQLiteStatement.B(11, naviRecord.d());
                }
                supportSQLiteStatement.F(12, (long) naviRecord.f());
                supportSQLiteStatement.F(13, naviRecord.m());
            }
        };
        this.c = new EntityDeletionOrUpdateAdapter<NaviRecord>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `navi_record` WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NaviRecord naviRecord) {
                supportSQLiteStatement.F(1, (long) naviRecord.h());
            }
        };
        this.d = new EntityDeletionOrUpdateAdapter<NaviRecord>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `navi_record` SET `id` = ?,`accountId` = ?,`name` = ?,`address` = ?,`acode` = ?,`city` = ?,`distance` = ?,`lng` = ?,`lat` = ?,`mode` = ?,`alias` = ?,`count` = ?,`time` = ? WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, NaviRecord naviRecord) {
                supportSQLiteStatement.F(1, (long) naviRecord.h());
                if (naviRecord.a() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, naviRecord.a());
                }
                if (naviRecord.l() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, naviRecord.l());
                }
                if (naviRecord.c() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, naviRecord.c());
                }
                if (naviRecord.b() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, naviRecord.b());
                }
                if (naviRecord.e() == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.B(6, naviRecord.e());
                }
                supportSQLiteStatement.F(7, (long) naviRecord.g());
                supportSQLiteStatement.R(8, naviRecord.j());
                supportSQLiteStatement.R(9, naviRecord.i());
                supportSQLiteStatement.F(10, (long) naviRecord.k());
                if (naviRecord.d() == null) {
                    supportSQLiteStatement.L(11);
                } else {
                    supportSQLiteStatement.B(11, naviRecord.d());
                }
                supportSQLiteStatement.F(12, (long) naviRecord.f());
                supportSQLiteStatement.F(13, naviRecord.m());
                supportSQLiteStatement.F(14, (long) naviRecord.h());
            }
        };
        this.e = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete from navi_record where accountId = ?";
            }
        };
    }

    public static List k() {
        return Collections.emptyList();
    }

    public List a(String str, String str2, double d2, double d3) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str3 = str;
        String str4 = str2;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from navi_record where accountId = ? AND name = ? AND lat = ? AND lng = ? ", 4);
        if (str3 == null) {
            c2.L(1);
        } else {
            c2.B(1, str3);
        }
        if (str4 == null) {
            c2.L(2);
        } else {
            c2.B(2, str4);
        }
        c2.R(3, d2);
        c2.R(4, d3);
        this.f5680a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f5680a, c2, false, (CancellationSignal) null);
        try {
            int d4 = CursorUtil.d(c3, "id");
            int d5 = CursorUtil.d(c3, "accountId");
            int d6 = CursorUtil.d(c3, "name");
            int d7 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.ADDRESS);
            int d8 = CursorUtil.d(c3, "acode");
            int d9 = CursorUtil.d(c3, "city");
            int d10 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.DISTANCE);
            int d11 = CursorUtil.d(c3, "lng");
            int d12 = CursorUtil.d(c3, "lat");
            int d13 = CursorUtil.d(c3, RtspHeaders.Values.MODE);
            int d14 = CursorUtil.d(c3, "alias");
            int d15 = CursorUtil.d(c3, "count");
            int d16 = CursorUtil.d(c3, RtspHeaders.Values.TIME);
            roomSQLiteQuery = c2;
            try {
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    NaviRecord naviRecord = new NaviRecord();
                    ArrayList arrayList2 = arrayList;
                    naviRecord.u(c3.getInt(d4));
                    naviRecord.n(c3.isNull(d5) ? null : c3.getString(d5));
                    naviRecord.y(c3.isNull(d6) ? null : c3.getString(d6));
                    naviRecord.p(c3.isNull(d7) ? null : c3.getString(d7));
                    naviRecord.o(c3.isNull(d8) ? null : c3.getString(d8));
                    naviRecord.r(c3.isNull(d9) ? null : c3.getString(d9));
                    naviRecord.t(c3.getInt(d10));
                    int i = d5;
                    int i2 = d6;
                    naviRecord.w(c3.getDouble(d11));
                    naviRecord.v(c3.getDouble(d12));
                    naviRecord.x(c3.getInt(d13));
                    naviRecord.q(c3.isNull(d14) ? null : c3.getString(d14));
                    naviRecord.s(c3.getInt(d15));
                    naviRecord.z(c3.getLong(d16));
                    arrayList = arrayList2;
                    arrayList.add(naviRecord);
                    d5 = i;
                    d6 = i2;
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

    public List b(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str2 = str;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from navi_record where accountId = ? ORDER BY time DESC", 1);
        if (str2 == null) {
            c2.L(1);
        } else {
            c2.B(1, str2);
        }
        this.f5680a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f5680a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "accountId");
            int d4 = CursorUtil.d(c3, "name");
            int d5 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.ADDRESS);
            int d6 = CursorUtil.d(c3, "acode");
            int d7 = CursorUtil.d(c3, "city");
            int d8 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.DISTANCE);
            int d9 = CursorUtil.d(c3, "lng");
            int d10 = CursorUtil.d(c3, "lat");
            int d11 = CursorUtil.d(c3, RtspHeaders.Values.MODE);
            int d12 = CursorUtil.d(c3, "alias");
            int d13 = CursorUtil.d(c3, "count");
            int d14 = CursorUtil.d(c3, RtspHeaders.Values.TIME);
            roomSQLiteQuery = c2;
            try {
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    NaviRecord naviRecord = new NaviRecord();
                    ArrayList arrayList2 = arrayList;
                    naviRecord.u(c3.getInt(d2));
                    naviRecord.n(c3.isNull(d3) ? null : c3.getString(d3));
                    naviRecord.y(c3.isNull(d4) ? null : c3.getString(d4));
                    naviRecord.p(c3.isNull(d5) ? null : c3.getString(d5));
                    naviRecord.o(c3.isNull(d6) ? null : c3.getString(d6));
                    naviRecord.r(c3.isNull(d7) ? null : c3.getString(d7));
                    naviRecord.t(c3.getInt(d8));
                    int i = d3;
                    naviRecord.w(c3.getDouble(d9));
                    naviRecord.v(c3.getDouble(d10));
                    naviRecord.x(c3.getInt(d11));
                    naviRecord.q(c3.isNull(d12) ? null : c3.getString(d12));
                    naviRecord.s(c3.getInt(d13));
                    naviRecord.z(c3.getLong(d14));
                    arrayList = arrayList2;
                    arrayList.add(naviRecord);
                    d3 = i;
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

    public List c(String str, int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str2 = str;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from navi_record  where accountId = ? AND count = ? ORDER BY time DESC", 2);
        if (str2 == null) {
            c2.L(1);
        } else {
            c2.B(1, str2);
        }
        c2.F(2, (long) i);
        this.f5680a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f5680a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "accountId");
            int d4 = CursorUtil.d(c3, "name");
            int d5 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.ADDRESS);
            int d6 = CursorUtil.d(c3, "acode");
            int d7 = CursorUtil.d(c3, "city");
            int d8 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.DISTANCE);
            int d9 = CursorUtil.d(c3, "lng");
            int d10 = CursorUtil.d(c3, "lat");
            int d11 = CursorUtil.d(c3, RtspHeaders.Values.MODE);
            int d12 = CursorUtil.d(c3, "alias");
            int d13 = CursorUtil.d(c3, "count");
            int d14 = CursorUtil.d(c3, RtspHeaders.Values.TIME);
            roomSQLiteQuery = c2;
            try {
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    NaviRecord naviRecord = new NaviRecord();
                    ArrayList arrayList2 = arrayList;
                    naviRecord.u(c3.getInt(d2));
                    naviRecord.n(c3.isNull(d3) ? null : c3.getString(d3));
                    naviRecord.y(c3.isNull(d4) ? null : c3.getString(d4));
                    naviRecord.p(c3.isNull(d5) ? null : c3.getString(d5));
                    naviRecord.o(c3.isNull(d6) ? null : c3.getString(d6));
                    naviRecord.r(c3.isNull(d7) ? null : c3.getString(d7));
                    naviRecord.t(c3.getInt(d8));
                    int i2 = d3;
                    naviRecord.w(c3.getDouble(d9));
                    naviRecord.v(c3.getDouble(d10));
                    naviRecord.x(c3.getInt(d11));
                    naviRecord.q(c3.isNull(d12) ? null : c3.getString(d12));
                    naviRecord.s(c3.getInt(d13));
                    naviRecord.z(c3.getLong(d14));
                    arrayList = arrayList2;
                    arrayList.add(naviRecord);
                    d3 = i2;
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

    public List d() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from navi_record", 0);
        this.f5680a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f5680a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "accountId");
            int d4 = CursorUtil.d(c3, "name");
            int d5 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.ADDRESS);
            int d6 = CursorUtil.d(c3, "acode");
            int d7 = CursorUtil.d(c3, "city");
            int d8 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.DISTANCE);
            int d9 = CursorUtil.d(c3, "lng");
            int d10 = CursorUtil.d(c3, "lat");
            int d11 = CursorUtil.d(c3, RtspHeaders.Values.MODE);
            int d12 = CursorUtil.d(c3, "alias");
            int d13 = CursorUtil.d(c3, "count");
            int d14 = CursorUtil.d(c3, RtspHeaders.Values.TIME);
            roomSQLiteQuery = c2;
            try {
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    NaviRecord naviRecord = new NaviRecord();
                    ArrayList arrayList2 = arrayList;
                    naviRecord.u(c3.getInt(d2));
                    naviRecord.n(c3.isNull(d3) ? null : c3.getString(d3));
                    naviRecord.y(c3.isNull(d4) ? null : c3.getString(d4));
                    naviRecord.p(c3.isNull(d5) ? null : c3.getString(d5));
                    naviRecord.o(c3.isNull(d6) ? null : c3.getString(d6));
                    naviRecord.r(c3.isNull(d7) ? null : c3.getString(d7));
                    naviRecord.t(c3.getInt(d8));
                    int i = d3;
                    naviRecord.w(c3.getDouble(d9));
                    naviRecord.v(c3.getDouble(d10));
                    naviRecord.x(c3.getInt(d11));
                    naviRecord.q(c3.isNull(d12) ? null : c3.getString(d12));
                    naviRecord.s(c3.getInt(d13));
                    naviRecord.z(c3.getLong(d14));
                    arrayList = arrayList2;
                    arrayList.add(naviRecord);
                    d3 = i;
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

    public void e(NaviRecord... naviRecordArr) {
        this.f5680a.assertNotSuspendingTransaction();
        this.f5680a.beginTransaction();
        try {
            this.c.handleMultiple((T[]) naviRecordArr);
            this.f5680a.setTransactionSuccessful();
        } finally {
            this.f5680a.endTransaction();
        }
    }

    public void f(NaviRecord... naviRecordArr) {
        this.f5680a.assertNotSuspendingTransaction();
        this.f5680a.beginTransaction();
        try {
            this.d.handleMultiple((T[]) naviRecordArr);
            this.f5680a.setTransactionSuccessful();
        } finally {
            this.f5680a.endTransaction();
        }
    }

    public List g(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str2 = str;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from navi_record where accountId = ? ORDER BY count DESC LIMIT 6", 1);
        if (str2 == null) {
            c2.L(1);
        } else {
            c2.B(1, str2);
        }
        this.f5680a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f5680a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "accountId");
            int d4 = CursorUtil.d(c3, "name");
            int d5 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.ADDRESS);
            int d6 = CursorUtil.d(c3, "acode");
            int d7 = CursorUtil.d(c3, "city");
            int d8 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.DISTANCE);
            int d9 = CursorUtil.d(c3, "lng");
            int d10 = CursorUtil.d(c3, "lat");
            int d11 = CursorUtil.d(c3, RtspHeaders.Values.MODE);
            int d12 = CursorUtil.d(c3, "alias");
            int d13 = CursorUtil.d(c3, "count");
            int d14 = CursorUtil.d(c3, RtspHeaders.Values.TIME);
            roomSQLiteQuery = c2;
            try {
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    NaviRecord naviRecord = new NaviRecord();
                    ArrayList arrayList2 = arrayList;
                    naviRecord.u(c3.getInt(d2));
                    naviRecord.n(c3.isNull(d3) ? null : c3.getString(d3));
                    naviRecord.y(c3.isNull(d4) ? null : c3.getString(d4));
                    naviRecord.p(c3.isNull(d5) ? null : c3.getString(d5));
                    naviRecord.o(c3.isNull(d6) ? null : c3.getString(d6));
                    naviRecord.r(c3.isNull(d7) ? null : c3.getString(d7));
                    naviRecord.t(c3.getInt(d8));
                    int i = d3;
                    naviRecord.w(c3.getDouble(d9));
                    naviRecord.v(c3.getDouble(d10));
                    naviRecord.x(c3.getInt(d11));
                    naviRecord.q(c3.isNull(d12) ? null : c3.getString(d12));
                    naviRecord.s(c3.getInt(d13));
                    naviRecord.z(c3.getLong(d14));
                    arrayList = arrayList2;
                    arrayList.add(naviRecord);
                    d3 = i;
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

    public List h(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str2 = str;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from navi_record where accountId = ? ORDER BY count DESC", 1);
        if (str2 == null) {
            c2.L(1);
        } else {
            c2.B(1, str2);
        }
        this.f5680a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f5680a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "id");
            int d3 = CursorUtil.d(c3, "accountId");
            int d4 = CursorUtil.d(c3, "name");
            int d5 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.ADDRESS);
            int d6 = CursorUtil.d(c3, "acode");
            int d7 = CursorUtil.d(c3, "city");
            int d8 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.DISTANCE);
            int d9 = CursorUtil.d(c3, "lng");
            int d10 = CursorUtil.d(c3, "lat");
            int d11 = CursorUtil.d(c3, RtspHeaders.Values.MODE);
            int d12 = CursorUtil.d(c3, "alias");
            int d13 = CursorUtil.d(c3, "count");
            int d14 = CursorUtil.d(c3, RtspHeaders.Values.TIME);
            roomSQLiteQuery = c2;
            try {
                ArrayList arrayList = new ArrayList(c3.getCount());
                while (c3.moveToNext()) {
                    NaviRecord naviRecord = new NaviRecord();
                    ArrayList arrayList2 = arrayList;
                    naviRecord.u(c3.getInt(d2));
                    naviRecord.n(c3.isNull(d3) ? null : c3.getString(d3));
                    naviRecord.y(c3.isNull(d4) ? null : c3.getString(d4));
                    naviRecord.p(c3.isNull(d5) ? null : c3.getString(d5));
                    naviRecord.o(c3.isNull(d6) ? null : c3.getString(d6));
                    naviRecord.r(c3.isNull(d7) ? null : c3.getString(d7));
                    naviRecord.t(c3.getInt(d8));
                    int i = d3;
                    naviRecord.w(c3.getDouble(d9));
                    naviRecord.v(c3.getDouble(d10));
                    naviRecord.x(c3.getInt(d11));
                    naviRecord.q(c3.isNull(d12) ? null : c3.getString(d12));
                    naviRecord.s(c3.getInt(d13));
                    naviRecord.z(c3.getLong(d14));
                    arrayList = arrayList2;
                    arrayList.add(naviRecord);
                    d3 = i;
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

    public void i(String str) {
        this.f5680a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        try {
            this.f5680a.beginTransaction();
            acquire.k();
            this.f5680a.setTransactionSuccessful();
            this.f5680a.endTransaction();
            this.e.release(acquire);
        } catch (Throwable th) {
            this.e.release(acquire);
            throw th;
        }
    }

    public void j(NaviRecord... naviRecordArr) {
        this.f5680a.assertNotSuspendingTransaction();
        this.f5680a.beginTransaction();
        try {
            this.b.insert((T[]) naviRecordArr);
            this.f5680a.setTransactionSuccessful();
        } finally {
            this.f5680a.endTransaction();
        }
    }
}
