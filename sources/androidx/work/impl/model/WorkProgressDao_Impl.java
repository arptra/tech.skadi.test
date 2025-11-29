package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Data;
import java.util.Collections;
import java.util.List;

public final class WorkProgressDao_Impl implements WorkProgressDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f2180a;
    public final EntityInsertionAdapter b;
    public final SharedSQLiteStatement c;
    public final SharedSQLiteStatement d;

    public WorkProgressDao_Impl(RoomDatabase roomDatabase) {
        this.f2180a = roomDatabase;
        this.b = new EntityInsertionAdapter<WorkProgress>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkProgress workProgress) {
                if (workProgress.b() == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.B(1, workProgress.b());
                }
                byte[] k = Data.k(workProgress.a());
                if (k == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.H(2, k);
                }
            }
        };
        this.c = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE from WorkProgress where work_spec_id=?";
            }
        };
        this.d = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM WorkProgress";
            }
        };
    }

    public static List d() {
        return Collections.emptyList();
    }

    public void a(String str) {
        this.f2180a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.c.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        this.f2180a.beginTransaction();
        try {
            acquire.k();
            this.f2180a.setTransactionSuccessful();
        } finally {
            this.f2180a.endTransaction();
            this.c.release(acquire);
        }
    }

    public void b() {
        this.f2180a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.d.acquire();
        this.f2180a.beginTransaction();
        try {
            acquire.k();
            this.f2180a.setTransactionSuccessful();
        } finally {
            this.f2180a.endTransaction();
            this.d.release(acquire);
        }
    }

    public void c(WorkProgress workProgress) {
        this.f2180a.assertNotSuspendingTransaction();
        this.f2180a.beginTransaction();
        try {
            this.b.insert(workProgress);
            this.f2180a.setTransactionSuccessful();
        } finally {
            this.f2180a.endTransaction();
        }
    }
}
