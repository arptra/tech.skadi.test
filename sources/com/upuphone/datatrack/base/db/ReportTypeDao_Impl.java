package com.upuphone.datatrack.base.db;

import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class ReportTypeDao_Impl implements ReportTypeDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f6390a;
    public final EntityInsertionAdapter b;
    public final SharedSQLiteStatement c;

    public ReportTypeDao_Impl(RoomDatabase roomDatabase) {
        this.f6390a = roomDatabase;
        this.b = new EntityInsertionAdapter<ReportType>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `report_type` (`id`,`name`,`type`) VALUES (nullif(?, 0),?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ReportType reportType) {
                supportSQLiteStatement.F(1, reportType.getId());
                if (reportType.getName() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, reportType.getName());
                }
                supportSQLiteStatement.F(3, (long) reportType.getType());
            }
        };
        this.c = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "delete from report_type";
            }
        };
    }

    public static List g() {
        return Collections.emptyList();
    }

    public Object a(Continuation continuation) {
        return CoroutinesRoom.c(this.f6390a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                SupportSQLiteStatement acquire = ReportTypeDao_Impl.this.c.acquire();
                try {
                    ReportTypeDao_Impl.this.f6390a.beginTransaction();
                    acquire.k();
                    ReportTypeDao_Impl.this.f6390a.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    ReportTypeDao_Impl.this.f6390a.endTransaction();
                    ReportTypeDao_Impl.this.c.release(acquire);
                    return unit;
                } catch (Throwable th) {
                    ReportTypeDao_Impl.this.c.release(acquire);
                    throw th;
                }
            }
        }, continuation);
    }

    public Object b(final List list, Continuation continuation) {
        return CoroutinesRoom.c(this.f6390a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                ReportTypeDao_Impl.this.f6390a.beginTransaction();
                try {
                    ReportTypeDao_Impl.this.b.insert(list);
                    ReportTypeDao_Impl.this.f6390a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ReportTypeDao_Impl.this.f6390a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object c(String str, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from report_type where name=? limit 1", 1);
        if (str == null) {
            c2.L(1);
        } else {
            c2.B(1, str);
        }
        return CoroutinesRoom.b(this.f6390a, false, DBUtil.a(), new Callable<ReportType>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.upuphone.datatrack.base.db.ReportType} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
            /* JADX WARNING: type inference failed for: r3v0 */
            /* JADX WARNING: type inference failed for: r3v3 */
            /* JADX WARNING: type inference failed for: r3v5 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.upuphone.datatrack.base.db.ReportType call() {
                /*
                    r7 = this;
                    com.upuphone.datatrack.base.db.ReportTypeDao_Impl r0 = com.upuphone.datatrack.base.db.ReportTypeDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.f6390a
                    androidx.room.RoomSQLiteQuery r1 = r0
                    r2 = 0
                    r3 = 0
                    android.database.Cursor r0 = androidx.room.util.DBUtil.c(r0, r1, r2, r3)
                    java.lang.String r1 = "id"
                    int r1 = androidx.room.util.CursorUtil.d(r0, r1)     // Catch:{ all -> 0x0041 }
                    java.lang.String r2 = "name"
                    int r2 = androidx.room.util.CursorUtil.d(r0, r2)     // Catch:{ all -> 0x0041 }
                    java.lang.String r4 = "type"
                    int r4 = androidx.room.util.CursorUtil.d(r0, r4)     // Catch:{ all -> 0x0041 }
                    boolean r5 = r0.moveToFirst()     // Catch:{ all -> 0x0041 }
                    if (r5 == 0) goto L_0x0043
                    long r5 = r0.getLong(r1)     // Catch:{ all -> 0x0041 }
                    boolean r1 = r0.isNull(r2)     // Catch:{ all -> 0x0041 }
                    if (r1 == 0) goto L_0x0032
                    goto L_0x0036
                L_0x0032:
                    java.lang.String r3 = r0.getString(r2)     // Catch:{ all -> 0x0041 }
                L_0x0036:
                    int r1 = r0.getInt(r4)     // Catch:{ all -> 0x0041 }
                    com.upuphone.datatrack.base.db.ReportType r2 = new com.upuphone.datatrack.base.db.ReportType     // Catch:{ all -> 0x0041 }
                    r2.<init>(r5, r3, r1)     // Catch:{ all -> 0x0041 }
                    r3 = r2
                    goto L_0x0043
                L_0x0041:
                    r1 = move-exception
                    goto L_0x004c
                L_0x0043:
                    r0.close()
                    androidx.room.RoomSQLiteQuery r7 = r0
                    r7.release()
                    return r3
                L_0x004c:
                    r0.close()
                    androidx.room.RoomSQLiteQuery r7 = r0
                    r7.release()
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.upuphone.datatrack.base.db.ReportTypeDao_Impl.AnonymousClass5.call():com.upuphone.datatrack.base.db.ReportType");
            }
        }, continuation);
    }
}
