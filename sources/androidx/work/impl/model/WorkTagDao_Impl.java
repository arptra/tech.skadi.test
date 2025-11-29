package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.WorkTagDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class WorkTagDao_Impl implements WorkTagDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f2218a;
    public final EntityInsertionAdapter b;
    public final SharedSQLiteStatement c;

    public WorkTagDao_Impl(RoomDatabase roomDatabase) {
        this.f2218a = roomDatabase;
        this.b = new EntityInsertionAdapter<WorkTag>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkTag workTag) {
                if (workTag.a() == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.B(1, workTag.a());
                }
                if (workTag.b() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, workTag.b());
                }
            }
        };
        this.c = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM worktag WHERE work_spec_id=?";
            }
        };
    }

    public static List e() {
        return Collections.emptyList();
    }

    public void b(String str, Set set) {
        WorkTagDao.DefaultImpls.a(this, str, set);
    }

    public List c(String str) {
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            c2.L(1);
        } else {
            c2.B(1, str);
        }
        this.f2218a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2218a, c2, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(c3.getCount());
            while (c3.moveToNext()) {
                arrayList.add(c3.isNull(0) ? null : c3.getString(0));
            }
            return arrayList;
        } finally {
            c3.close();
            c2.release();
        }
    }

    public void d(WorkTag workTag) {
        this.f2218a.assertNotSuspendingTransaction();
        this.f2218a.beginTransaction();
        try {
            this.b.insert(workTag);
            this.f2218a.setTransactionSuccessful();
        } finally {
            this.f2218a.endTransaction();
        }
    }
}
