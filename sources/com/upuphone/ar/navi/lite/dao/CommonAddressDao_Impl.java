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
import com.upuphone.ar.navi.lite.base.CommonAddress;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CommonAddressDao_Impl implements CommonAddressDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f5671a;
    public final EntityInsertionAdapter b;
    public final EntityDeletionOrUpdateAdapter c;
    public final EntityDeletionOrUpdateAdapter d;
    public final SharedSQLiteStatement e;
    public final SharedSQLiteStatement f;
    public final SharedSQLiteStatement g;

    public CommonAddressDao_Impl(RoomDatabase roomDatabase) {
        this.f5671a = roomDatabase;
        this.b = new EntityInsertionAdapter<CommonAddress>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `common_address` (`alias`,`accountId`,`name`,`acode`,`address`,`country`,`province`,`city`,`district`,`lng`,`lat`,`time`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, CommonAddress commonAddress) {
                if (commonAddress.d() == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.B(1, commonAddress.d());
                }
                if (commonAddress.a() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, commonAddress.a());
                }
                if (commonAddress.j() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, commonAddress.j());
                }
                if (commonAddress.b() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, commonAddress.b());
                }
                if (commonAddress.c() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, commonAddress.c());
                }
                if (commonAddress.f() == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.B(6, commonAddress.f());
                }
                if (commonAddress.k() == null) {
                    supportSQLiteStatement.L(7);
                } else {
                    supportSQLiteStatement.B(7, commonAddress.k());
                }
                if (commonAddress.e() == null) {
                    supportSQLiteStatement.L(8);
                } else {
                    supportSQLiteStatement.B(8, commonAddress.e());
                }
                if (commonAddress.g() == null) {
                    supportSQLiteStatement.L(9);
                } else {
                    supportSQLiteStatement.B(9, commonAddress.g());
                }
                supportSQLiteStatement.R(10, commonAddress.i());
                supportSQLiteStatement.R(11, commonAddress.h());
                supportSQLiteStatement.F(12, commonAddress.l());
            }
        };
        this.c = new EntityDeletionOrUpdateAdapter<CommonAddress>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `common_address` WHERE `alias` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, CommonAddress commonAddress) {
                if (commonAddress.d() == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.B(1, commonAddress.d());
                }
            }
        };
        this.d = new EntityDeletionOrUpdateAdapter<CommonAddress>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `common_address` SET `alias` = ?,`accountId` = ?,`name` = ?,`acode` = ?,`address` = ?,`country` = ?,`province` = ?,`city` = ?,`district` = ?,`lng` = ?,`lat` = ?,`time` = ? WHERE `alias` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, CommonAddress commonAddress) {
                if (commonAddress.d() == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.B(1, commonAddress.d());
                }
                if (commonAddress.a() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, commonAddress.a());
                }
                if (commonAddress.j() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, commonAddress.j());
                }
                if (commonAddress.b() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, commonAddress.b());
                }
                if (commonAddress.c() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, commonAddress.c());
                }
                if (commonAddress.f() == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.B(6, commonAddress.f());
                }
                if (commonAddress.k() == null) {
                    supportSQLiteStatement.L(7);
                } else {
                    supportSQLiteStatement.B(7, commonAddress.k());
                }
                if (commonAddress.e() == null) {
                    supportSQLiteStatement.L(8);
                } else {
                    supportSQLiteStatement.B(8, commonAddress.e());
                }
                if (commonAddress.g() == null) {
                    supportSQLiteStatement.L(9);
                } else {
                    supportSQLiteStatement.B(9, commonAddress.g());
                }
                supportSQLiteStatement.R(10, commonAddress.i());
                supportSQLiteStatement.R(11, commonAddress.h());
                supportSQLiteStatement.F(12, commonAddress.l());
                if (commonAddress.d() == null) {
                    supportSQLiteStatement.L(13);
                } else {
                    supportSQLiteStatement.B(13, commonAddress.d());
                }
            }
        };
        this.e = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete from common_address where accountId = ? AND alias=?";
            }
        };
        this.f = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete from common_address where  accountId = ? AND name=?";
            }
        };
        this.g = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete from common_address where  accountId = ? AND name=? AND address=?";
            }
        };
    }

    public static List j() {
        return Collections.emptyList();
    }

    public void a(String str, String str2) {
        this.f5671a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        if (str2 == null) {
            acquire.L(2);
        } else {
            acquire.B(2, str2);
        }
        try {
            this.f5671a.beginTransaction();
            acquire.k();
            this.f5671a.setTransactionSuccessful();
            this.f5671a.endTransaction();
            this.e.release(acquire);
        } catch (Throwable th) {
            this.e.release(acquire);
            throw th;
        }
    }

    public void b(CommonAddress... commonAddressArr) {
        this.f5671a.assertNotSuspendingTransaction();
        this.f5671a.beginTransaction();
        try {
            this.c.handleMultiple((T[]) commonAddressArr);
            this.f5671a.setTransactionSuccessful();
        } finally {
            this.f5671a.endTransaction();
        }
    }

    public void c(CommonAddress... commonAddressArr) {
        this.f5671a.assertNotSuspendingTransaction();
        this.f5671a.beginTransaction();
        try {
            this.b.insert((T[]) commonAddressArr);
            this.f5671a.setTransactionSuccessful();
        } finally {
            this.f5671a.endTransaction();
        }
    }

    public List d(String str) {
        int i;
        String str2;
        String str3 = str;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from common_address where accountId = ?", 1);
        if (str3 == null) {
            c2.L(1);
        } else {
            c2.B(1, str3);
        }
        this.f5671a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f5671a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "alias");
            int d3 = CursorUtil.d(c3, "accountId");
            int d4 = CursorUtil.d(c3, "name");
            int d5 = CursorUtil.d(c3, "acode");
            int d6 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.ADDRESS);
            int d7 = CursorUtil.d(c3, "country");
            int d8 = CursorUtil.d(c3, "province");
            int d9 = CursorUtil.d(c3, "city");
            int d10 = CursorUtil.d(c3, "district");
            int d11 = CursorUtil.d(c3, "lng");
            int d12 = CursorUtil.d(c3, "lat");
            int d13 = CursorUtil.d(c3, RtspHeaders.Values.TIME);
            ArrayList arrayList = new ArrayList(c3.getCount());
            while (c3.moveToNext()) {
                CommonAddress commonAddress = new CommonAddress();
                if (c3.isNull(d2)) {
                    i = d2;
                    str2 = null;
                } else {
                    i = d2;
                    str2 = c3.getString(d2);
                }
                commonAddress.p(str2);
                commonAddress.m(c3.isNull(d3) ? null : c3.getString(d3));
                commonAddress.v(c3.isNull(d4) ? null : c3.getString(d4));
                commonAddress.n(c3.isNull(d5) ? null : c3.getString(d5));
                commonAddress.o(c3.isNull(d6) ? null : c3.getString(d6));
                commonAddress.r(c3.isNull(d7) ? null : c3.getString(d7));
                commonAddress.w(c3.isNull(d8) ? null : c3.getString(d8));
                commonAddress.q(c3.isNull(d9) ? null : c3.getString(d9));
                commonAddress.s(c3.isNull(d10) ? null : c3.getString(d10));
                int i2 = d3;
                int i3 = d4;
                commonAddress.u(c3.getDouble(d11));
                commonAddress.t(c3.getDouble(d12));
                commonAddress.x(c3.getLong(d13));
                arrayList.add(commonAddress);
                d3 = i2;
                d4 = i3;
                d2 = i;
            }
            return arrayList;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public void e(CommonAddress... commonAddressArr) {
        this.f5671a.assertNotSuspendingTransaction();
        this.f5671a.beginTransaction();
        try {
            this.d.handleMultiple((T[]) commonAddressArr);
            this.f5671a.setTransactionSuccessful();
        } finally {
            this.f5671a.endTransaction();
        }
    }

    public List f(String str, String str2) {
        int i;
        String str3;
        String str4 = str;
        String str5 = str2;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from common_address where accountId = ? AND alias = ?", 2);
        if (str4 == null) {
            c2.L(1);
        } else {
            c2.B(1, str4);
        }
        if (str5 == null) {
            c2.L(2);
        } else {
            c2.B(2, str5);
        }
        this.f5671a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f5671a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "alias");
            int d3 = CursorUtil.d(c3, "accountId");
            int d4 = CursorUtil.d(c3, "name");
            int d5 = CursorUtil.d(c3, "acode");
            int d6 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.ADDRESS);
            int d7 = CursorUtil.d(c3, "country");
            int d8 = CursorUtil.d(c3, "province");
            int d9 = CursorUtil.d(c3, "city");
            int d10 = CursorUtil.d(c3, "district");
            int d11 = CursorUtil.d(c3, "lng");
            int d12 = CursorUtil.d(c3, "lat");
            int d13 = CursorUtil.d(c3, RtspHeaders.Values.TIME);
            ArrayList arrayList = new ArrayList(c3.getCount());
            while (c3.moveToNext()) {
                CommonAddress commonAddress = new CommonAddress();
                if (c3.isNull(d2)) {
                    i = d2;
                    str3 = null;
                } else {
                    i = d2;
                    str3 = c3.getString(d2);
                }
                commonAddress.p(str3);
                commonAddress.m(c3.isNull(d3) ? null : c3.getString(d3));
                commonAddress.v(c3.isNull(d4) ? null : c3.getString(d4));
                commonAddress.n(c3.isNull(d5) ? null : c3.getString(d5));
                commonAddress.o(c3.isNull(d6) ? null : c3.getString(d6));
                commonAddress.r(c3.isNull(d7) ? null : c3.getString(d7));
                commonAddress.w(c3.isNull(d8) ? null : c3.getString(d8));
                commonAddress.q(c3.isNull(d9) ? null : c3.getString(d9));
                commonAddress.s(c3.isNull(d10) ? null : c3.getString(d10));
                int i2 = d3;
                int i3 = d4;
                commonAddress.u(c3.getDouble(d11));
                commonAddress.t(c3.getDouble(d12));
                commonAddress.x(c3.getLong(d13));
                arrayList.add(commonAddress);
                d3 = i2;
                d4 = i3;
                d2 = i;
            }
            return arrayList;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public List g() {
        int i;
        String str;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from common_address", 0);
        this.f5671a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f5671a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "alias");
            int d3 = CursorUtil.d(c3, "accountId");
            int d4 = CursorUtil.d(c3, "name");
            int d5 = CursorUtil.d(c3, "acode");
            int d6 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.ADDRESS);
            int d7 = CursorUtil.d(c3, "country");
            int d8 = CursorUtil.d(c3, "province");
            int d9 = CursorUtil.d(c3, "city");
            int d10 = CursorUtil.d(c3, "district");
            int d11 = CursorUtil.d(c3, "lng");
            int d12 = CursorUtil.d(c3, "lat");
            int d13 = CursorUtil.d(c3, RtspHeaders.Values.TIME);
            ArrayList arrayList = new ArrayList(c3.getCount());
            while (c3.moveToNext()) {
                CommonAddress commonAddress = new CommonAddress();
                if (c3.isNull(d2)) {
                    i = d2;
                    str = null;
                } else {
                    i = d2;
                    str = c3.getString(d2);
                }
                commonAddress.p(str);
                commonAddress.m(c3.isNull(d3) ? null : c3.getString(d3));
                commonAddress.v(c3.isNull(d4) ? null : c3.getString(d4));
                commonAddress.n(c3.isNull(d5) ? null : c3.getString(d5));
                commonAddress.o(c3.isNull(d6) ? null : c3.getString(d6));
                commonAddress.r(c3.isNull(d7) ? null : c3.getString(d7));
                commonAddress.w(c3.isNull(d8) ? null : c3.getString(d8));
                commonAddress.q(c3.isNull(d9) ? null : c3.getString(d9));
                commonAddress.s(c3.isNull(d10) ? null : c3.getString(d10));
                int i2 = d3;
                int i3 = d4;
                commonAddress.u(c3.getDouble(d11));
                commonAddress.t(c3.getDouble(d12));
                commonAddress.x(c3.getLong(d13));
                arrayList.add(commonAddress);
                d3 = i2;
                d4 = i3;
                d2 = i;
            }
            return arrayList;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public void h(String str, String str2, String str3) {
        this.f5671a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.g.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        if (str2 == null) {
            acquire.L(2);
        } else {
            acquire.B(2, str2);
        }
        if (str3 == null) {
            acquire.L(3);
        } else {
            acquire.B(3, str3);
        }
        try {
            this.f5671a.beginTransaction();
            acquire.k();
            this.f5671a.setTransactionSuccessful();
            this.f5671a.endTransaction();
            this.g.release(acquire);
        } catch (Throwable th) {
            this.g.release(acquire);
            throw th;
        }
    }

    public List i(String str) {
        int i;
        String str2;
        String str3 = str;
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from common_address where  accountId = ? AND alias LIKE 'custom%' ORDER BY time ASC", 1);
        if (str3 == null) {
            c2.L(1);
        } else {
            c2.B(1, str3);
        }
        this.f5671a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f5671a, c2, false, (CancellationSignal) null);
        try {
            int d2 = CursorUtil.d(c3, "alias");
            int d3 = CursorUtil.d(c3, "accountId");
            int d4 = CursorUtil.d(c3, "name");
            int d5 = CursorUtil.d(c3, "acode");
            int d6 = CursorUtil.d(c3, MzContactsContract.MzContactColumns.ADDRESS);
            int d7 = CursorUtil.d(c3, "country");
            int d8 = CursorUtil.d(c3, "province");
            int d9 = CursorUtil.d(c3, "city");
            int d10 = CursorUtil.d(c3, "district");
            int d11 = CursorUtil.d(c3, "lng");
            int d12 = CursorUtil.d(c3, "lat");
            int d13 = CursorUtil.d(c3, RtspHeaders.Values.TIME);
            ArrayList arrayList = new ArrayList(c3.getCount());
            while (c3.moveToNext()) {
                CommonAddress commonAddress = new CommonAddress();
                if (c3.isNull(d2)) {
                    i = d2;
                    str2 = null;
                } else {
                    i = d2;
                    str2 = c3.getString(d2);
                }
                commonAddress.p(str2);
                commonAddress.m(c3.isNull(d3) ? null : c3.getString(d3));
                commonAddress.v(c3.isNull(d4) ? null : c3.getString(d4));
                commonAddress.n(c3.isNull(d5) ? null : c3.getString(d5));
                commonAddress.o(c3.isNull(d6) ? null : c3.getString(d6));
                commonAddress.r(c3.isNull(d7) ? null : c3.getString(d7));
                commonAddress.w(c3.isNull(d8) ? null : c3.getString(d8));
                commonAddress.q(c3.isNull(d9) ? null : c3.getString(d9));
                commonAddress.s(c3.isNull(d10) ? null : c3.getString(d10));
                int i2 = d3;
                int i3 = d4;
                commonAddress.u(c3.getDouble(d11));
                commonAddress.t(c3.getDouble(d12));
                commonAddress.x(c3.getLong(d13));
                arrayList.add(commonAddress);
                d3 = i2;
                d4 = i3;
                d2 = i;
            }
            return arrayList;
        } finally {
            c3.close();
            c2.release();
        }
    }
}
