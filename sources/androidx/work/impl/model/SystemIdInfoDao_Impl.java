package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.model.SystemIdInfoDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f2171a;
    public final EntityInsertionAdapter b;
    public final SharedSQLiteStatement c;
    public final SharedSQLiteStatement d;

    public SystemIdInfoDao_Impl(RoomDatabase roomDatabase) {
        this.f2171a = roomDatabase;
        this.b = new EntityInsertionAdapter<SystemIdInfo>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SystemIdInfo systemIdInfo) {
                String str = systemIdInfo.f2170a;
                if (str == null) {
                    supportSQLiteStatement.L(1);
                } else {
                    supportSQLiteStatement.B(1, str);
                }
                supportSQLiteStatement.F(2, (long) systemIdInfo.a());
                supportSQLiteStatement.F(3, (long) systemIdInfo.c);
            }
        };
        this.c = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?";
            }
        };
        this.d = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }
        };
    }

    public static List j() {
        return Collections.emptyList();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: androidx.work.impl.model.SystemIdInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.work.impl.model.SystemIdInfo b(java.lang.String r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?"
            r1 = 2
            androidx.room.RoomSQLiteQuery r0 = androidx.room.RoomSQLiteQuery.c(r0, r1)
            r2 = 1
            if (r5 != 0) goto L_0x000e
            r0.L(r2)
            goto L_0x0011
        L_0x000e:
            r0.B(r2, r5)
        L_0x0011:
            long r5 = (long) r6
            r0.F(r1, r5)
            androidx.room.RoomDatabase r5 = r4.f2171a
            r5.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r4 = r4.f2171a
            r5 = 0
            r6 = 0
            android.database.Cursor r4 = androidx.room.util.DBUtil.c(r4, r0, r5, r6)
            java.lang.String r5 = "work_spec_id"
            int r5 = androidx.room.util.CursorUtil.d(r4, r5)     // Catch:{ all -> 0x0054 }
            java.lang.String r1 = "generation"
            int r1 = androidx.room.util.CursorUtil.d(r4, r1)     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = "system_id"
            int r2 = androidx.room.util.CursorUtil.d(r4, r2)     // Catch:{ all -> 0x0054 }
            boolean r3 = r4.moveToFirst()     // Catch:{ all -> 0x0054 }
            if (r3 == 0) goto L_0x0056
            boolean r3 = r4.isNull(r5)     // Catch:{ all -> 0x0054 }
            if (r3 == 0) goto L_0x0041
            goto L_0x0045
        L_0x0041:
            java.lang.String r6 = r4.getString(r5)     // Catch:{ all -> 0x0054 }
        L_0x0045:
            int r5 = r4.getInt(r1)     // Catch:{ all -> 0x0054 }
            int r1 = r4.getInt(r2)     // Catch:{ all -> 0x0054 }
            androidx.work.impl.model.SystemIdInfo r2 = new androidx.work.impl.model.SystemIdInfo     // Catch:{ all -> 0x0054 }
            r2.<init>(r6, r5, r1)     // Catch:{ all -> 0x0054 }
            r6 = r2
            goto L_0x0056
        L_0x0054:
            r5 = move-exception
            goto L_0x005d
        L_0x0056:
            r4.close()
            r0.release()
            return r6
        L_0x005d:
            r4.close()
            r0.release()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.SystemIdInfoDao_Impl.b(java.lang.String, int):androidx.work.impl.model.SystemIdInfo");
    }

    public void c(WorkGenerationalId workGenerationalId) {
        SystemIdInfoDao.DefaultImpls.b(this, workGenerationalId);
    }

    public void d(SystemIdInfo systemIdInfo) {
        this.f2171a.assertNotSuspendingTransaction();
        this.f2171a.beginTransaction();
        try {
            this.b.insert(systemIdInfo);
            this.f2171a.setTransactionSuccessful();
        } finally {
            this.f2171a.endTransaction();
        }
    }

    public SystemIdInfo e(WorkGenerationalId workGenerationalId) {
        return SystemIdInfoDao.DefaultImpls.a(this, workGenerationalId);
    }

    public List f() {
        RoomSQLiteQuery c2 = RoomSQLiteQuery.c("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.f2171a.assertNotSuspendingTransaction();
        Cursor c3 = DBUtil.c(this.f2171a, c2, false, (CancellationSignal) null);
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

    public void g(String str, int i) {
        this.f2171a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.c.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        acquire.F(2, (long) i);
        this.f2171a.beginTransaction();
        try {
            acquire.k();
            this.f2171a.setTransactionSuccessful();
        } finally {
            this.f2171a.endTransaction();
            this.c.release(acquire);
        }
    }

    public void i(String str) {
        this.f2171a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.d.acquire();
        if (str == null) {
            acquire.L(1);
        } else {
            acquire.B(1, str);
        }
        this.f2171a.beginTransaction();
        try {
            acquire.k();
            this.f2171a.setTransactionSuccessful();
        } finally {
            this.f2171a.endTransaction();
            this.d.release(acquire);
        }
    }
}
