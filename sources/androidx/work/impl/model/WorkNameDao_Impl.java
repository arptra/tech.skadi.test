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

public final class WorkNameDao_Impl implements WorkNameDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f2177a;
    public final EntityInsertionAdapter b;

    public WorkNameDao_Impl(RoomDatabase roomDatabase) {
        this.f2177a = roomDatabase;
        this.b = new EntityInsertionAdapter<WorkName>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkName workName) {
                if (workName.a() == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.B(1, workName.a());
                }
                if (workName.b() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, workName.b());
                }
            }
        };
    }

    public static List c() {
        return Collections.emptyList();
    }

    public void a(WorkName workName) {
        this.f2177a.assertNotSuspendingTransaction();
        this.f2177a.beginTransaction();
        try {
            this.b.insert(workName);
            this.f2177a.setTransactionSuccessful();
        } finally {
            this.f2177a.endTransaction();
        }
    }

    public List b(String str) {
        RoomSQLiteQuery c = RoomSQLiteQuery.c("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (str == null) {
            c.L(1);
        } else {
            c.B(1, str);
        }
        this.f2177a.assertNotSuspendingTransaction();
        Cursor c2 = DBUtil.c(this.f2177a, c, false, (CancellationSignal) null);
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
}
