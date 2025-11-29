package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DependencyDao_Impl implements DependencyDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f2161a;
    public final EntityInsertionAdapter b;

    public DependencyDao_Impl(RoomDatabase roomDatabase) {
        this.f2161a = roomDatabase;
        this.b = new EntityInsertionAdapter<Dependency>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Dependency dependency) {
                if (dependency.b() == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.B(1, dependency.b());
                }
                if (dependency.a() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, dependency.a());
                }
            }
        };
    }

    public static List e() {
        return Collections.emptyList();
    }

    public void a(Dependency dependency) {
        this.f2161a.assertNotSuspendingTransaction();
        this.f2161a.beginTransaction();
        try {
            this.b.insert(dependency);
            this.f2161a.setTransactionSuccessful();
        } finally {
            this.f2161a.endTransaction();
        }
    }

    public List b(String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            c.L(1);
        } else {
            c.B(1, str);
        }
        this.f2161a.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.f2161a, c, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                arrayList.add(c2.isNull(0) ? null : c2.getString(0));
            }
            return arrayList;
        } finally {
            c2.close();
            c.release();
        }
    }

    public boolean c(String str) {
        boolean z = true;
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            c.L(1);
        } else {
            c.B(1, str);
        }
        this.f2161a.assertNotSuspendingTransaction();
        boolean z2 = false;
        Cursor c2 = DBUtil.c(this.f2161a, c, false, (CancellationSignal) null);
        try {
            if (c2.moveToFirst()) {
                if (c2.getInt(0) == 0) {
                    z = false;
                }
                z2 = z;
            }
            return z2;
        } finally {
            c2.close();
            c.release();
        }
    }

    public boolean d(String str) {
        boolean z = true;
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            c.L(1);
        } else {
            c.B(1, str);
        }
        this.f2161a.assertNotSuspendingTransaction();
        boolean z2 = false;
        Cursor c2 = DBUtil.c(this.f2161a, c, false, (CancellationSignal) null);
        try {
            if (c2.moveToFirst()) {
                if (c2.getInt(0) == 0) {
                    z = false;
                }
                z2 = z;
            }
            return z2;
        } finally {
            c2.close();
            c.release();
        }
    }
}
