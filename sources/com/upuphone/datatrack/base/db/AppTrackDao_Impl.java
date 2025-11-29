package com.upuphone.datatrack.base.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

public final class AppTrackDao_Impl implements AppTrackDao {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f6376a;
    public final EntityInsertionAdapter b;
    public final EntityDeletionOrUpdateAdapter c;

    /* renamed from: com.upuphone.datatrack.base.db.AppTrackDao_Impl$4  reason: invalid class name */
    class AnonymousClass4 implements Callable<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6381a;
        public final /* synthetic */ AppTrackDao_Impl b;

        /* renamed from: a */
        public Unit call() {
            this.b.f6376a.beginTransaction();
            try {
                this.b.c.handleMultiple(this.f6381a);
                this.b.f6376a.setTransactionSuccessful();
                return Unit.INSTANCE;
            } finally {
                this.b.f6376a.endTransaction();
            }
        }
    }

    public AppTrackDao_Impl(RoomDatabase roomDatabase) {
        this.f6376a = roomDatabase;
        this.b = new EntityInsertionAdapter<AppTrack>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `app_track` (`id`,`packageName`,`name`,`msg`,`iotDeviceId`,`iotDeviceRom`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AppTrack appTrack) {
                supportSQLiteStatement.F(1, appTrack.getId());
                if (appTrack.getPackageName() == null) {
                    supportSQLiteStatement.L(2);
                } else {
                    supportSQLiteStatement.B(2, appTrack.getPackageName());
                }
                if (appTrack.getName() == null) {
                    supportSQLiteStatement.L(3);
                } else {
                    supportSQLiteStatement.B(3, appTrack.getName());
                }
                if (appTrack.getMsg() == null) {
                    supportSQLiteStatement.L(4);
                } else {
                    supportSQLiteStatement.B(4, appTrack.getMsg());
                }
                if (appTrack.getIotDeviceId() == null) {
                    supportSQLiteStatement.L(5);
                } else {
                    supportSQLiteStatement.B(5, appTrack.getIotDeviceId());
                }
                if (appTrack.getIotDeviceRom() == null) {
                    supportSQLiteStatement.L(6);
                } else {
                    supportSQLiteStatement.B(6, appTrack.getIotDeviceRom());
                }
            }
        };
        this.c = new EntityDeletionOrUpdateAdapter<AppTrack>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `app_track` WHERE `id` = ?";
            }

            /* renamed from: d */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AppTrack appTrack) {
                supportSQLiteStatement.F(1, appTrack.getId());
            }
        };
    }

    public static List k() {
        return Collections.emptyList();
    }

    public Object a(String str, int i, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select id from app_track where packageName=? order by id asc limit ?", 2);
        if (str == null) {
            c2.L(1);
        } else {
            c2.B(1, str);
        }
        c2.F(2, (long) i);
        return CoroutinesRoom.b(this.f6376a, false, DBUtil.a(), new Callable<List<Long>>() {
            /* renamed from: a */
            public List call() {
                Cursor c = DBUtil.c(AppTrackDao_Impl.this.f6376a, c2, false, (CancellationSignal) null);
                try {
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(c.isNull(0) ? null : Long.valueOf(c.getLong(0)));
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object b(final AppTrack appTrack, Continuation continuation) {
        return CoroutinesRoom.c(this.f6376a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                AppTrackDao_Impl.this.f6376a.beginTransaction();
                try {
                    AppTrackDao_Impl.this.b.insert(appTrack);
                    AppTrackDao_Impl.this.f6376a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    AppTrackDao_Impl.this.f6376a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object c(int i, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from app_track limit ?", 1);
        c2.F(1, (long) i);
        return CoroutinesRoom.b(this.f6376a, false, DBUtil.a(), new Callable<List<AppTrack>>() {
            /* renamed from: a */
            public List call() {
                Cursor c = DBUtil.c(AppTrackDao_Impl.this.f6376a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
                    int d3 = CursorUtil.d(c, "name");
                    int d4 = CursorUtil.d(c, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
                    int d5 = CursorUtil.d(c, "iotDeviceId");
                    int d6 = CursorUtil.d(c, "iotDeviceRom");
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(new AppTrack(c.getLong(d), c.isNull(d2) ? null : c.getString(d2), c.isNull(d3) ? null : c.getString(d3), c.isNull(d4) ? null : c.getString(d4), c.isNull(d5) ? null : c.getString(d5), c.isNull(d6) ? null : c.getString(d6)));
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object d(Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from app_track order by id desc limit 1", 0);
        return CoroutinesRoom.b(this.f6376a, false, DBUtil.a(), new Callable<AppTrack>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.upuphone.datatrack.base.db.AppTrack} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.upuphone.datatrack.base.db.AppTrack} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.upuphone.datatrack.base.db.AppTrack} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: com.upuphone.datatrack.base.db.AppTrack} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: com.upuphone.datatrack.base.db.AppTrack} */
            /* JADX WARNING: type inference failed for: r4v2, types: [java.lang.String] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.upuphone.datatrack.base.db.AppTrack call() {
                /*
                    r18 = this;
                    r1 = r18
                    com.upuphone.datatrack.base.db.AppTrackDao_Impl r0 = com.upuphone.datatrack.base.db.AppTrackDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.f6376a
                    androidx.room.RoomSQLiteQuery r2 = r0
                    r3 = 0
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.c(r0, r2, r3, r4)
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.d(r2, r0)     // Catch:{ all -> 0x0089 }
                    java.lang.String r3 = "packageName"
                    int r3 = androidx.room.util.CursorUtil.d(r2, r3)     // Catch:{ all -> 0x0089 }
                    java.lang.String r5 = "name"
                    int r5 = androidx.room.util.CursorUtil.d(r2, r5)     // Catch:{ all -> 0x0089 }
                    java.lang.String r6 = "msg"
                    int r6 = androidx.room.util.CursorUtil.d(r2, r6)     // Catch:{ all -> 0x0089 }
                    java.lang.String r7 = "iotDeviceId"
                    int r7 = androidx.room.util.CursorUtil.d(r2, r7)     // Catch:{ all -> 0x0089 }
                    java.lang.String r8 = "iotDeviceRom"
                    int r8 = androidx.room.util.CursorUtil.d(r2, r8)     // Catch:{ all -> 0x0089 }
                    boolean r9 = r2.moveToFirst()     // Catch:{ all -> 0x0089 }
                    if (r9 == 0) goto L_0x008b
                    long r11 = r2.getLong(r0)     // Catch:{ all -> 0x0089 }
                    boolean r0 = r2.isNull(r3)     // Catch:{ all -> 0x0089 }
                    if (r0 == 0) goto L_0x0046
                    r13 = r4
                    goto L_0x004b
                L_0x0046:
                    java.lang.String r0 = r2.getString(r3)     // Catch:{ all -> 0x0089 }
                    r13 = r0
                L_0x004b:
                    boolean r0 = r2.isNull(r5)     // Catch:{ all -> 0x0089 }
                    if (r0 == 0) goto L_0x0053
                    r14 = r4
                    goto L_0x0058
                L_0x0053:
                    java.lang.String r0 = r2.getString(r5)     // Catch:{ all -> 0x0089 }
                    r14 = r0
                L_0x0058:
                    boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x0089 }
                    if (r0 == 0) goto L_0x0060
                    r15 = r4
                    goto L_0x0065
                L_0x0060:
                    java.lang.String r0 = r2.getString(r6)     // Catch:{ all -> 0x0089 }
                    r15 = r0
                L_0x0065:
                    boolean r0 = r2.isNull(r7)     // Catch:{ all -> 0x0089 }
                    if (r0 == 0) goto L_0x006e
                    r16 = r4
                    goto L_0x0074
                L_0x006e:
                    java.lang.String r0 = r2.getString(r7)     // Catch:{ all -> 0x0089 }
                    r16 = r0
                L_0x0074:
                    boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x0089 }
                    if (r0 == 0) goto L_0x007d
                L_0x007a:
                    r17 = r4
                    goto L_0x0082
                L_0x007d:
                    java.lang.String r4 = r2.getString(r8)     // Catch:{ all -> 0x0089 }
                    goto L_0x007a
                L_0x0082:
                    com.upuphone.datatrack.base.db.AppTrack r4 = new com.upuphone.datatrack.base.db.AppTrack     // Catch:{ all -> 0x0089 }
                    r10 = r4
                    r10.<init>(r11, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0089 }
                    goto L_0x008b
                L_0x0089:
                    r0 = move-exception
                    goto L_0x0094
                L_0x008b:
                    r2.close()
                    androidx.room.RoomSQLiteQuery r0 = r0
                    r0.release()
                    return r4
                L_0x0094:
                    r2.close()
                    androidx.room.RoomSQLiteQuery r1 = r0
                    r1.release()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.upuphone.datatrack.base.db.AppTrackDao_Impl.AnonymousClass8.call():com.upuphone.datatrack.base.db.AppTrack");
            }
        }, continuation);
    }

    public Object e(String str, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select count(*) from app_track where packageName=?", 1);
        if (str == null) {
            c2.L(1);
        } else {
            c2.B(1, str);
        }
        return CoroutinesRoom.b(this.f6376a, false, DBUtil.a(), new Callable<Integer>() {
            /* renamed from: a */
            public Integer call() {
                Integer num = null;
                Cursor c = DBUtil.c(AppTrackDao_Impl.this.f6376a, c2, false, (CancellationSignal) null);
                try {
                    if (c.moveToFirst()) {
                        if (!c.isNull(0)) {
                            num = Integer.valueOf(c.getInt(0));
                        }
                    }
                    return num;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }

    public Object f(final List list, Continuation continuation) {
        return CoroutinesRoom.c(this.f6376a, true, new Callable<Unit>() {
            /* renamed from: a */
            public Unit call() {
                StringBuilder b2 = StringUtil.b();
                b2.append("delete from app_track where id in(");
                StringUtil.a(b2, list.size());
                b2.append(")");
                SupportSQLiteStatement compileStatement = AppTrackDao_Impl.this.f6376a.compileStatement(b2.toString());
                int i = 1;
                for (Long l : list) {
                    if (l == null) {
                        compileStatement.L(i);
                    } else {
                        compileStatement.F(i, l.longValue());
                    }
                    i++;
                }
                AppTrackDao_Impl.this.f6376a.beginTransaction();
                try {
                    compileStatement.k();
                    AppTrackDao_Impl.this.f6376a.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    AppTrackDao_Impl.this.f6376a.endTransaction();
                }
            }
        }, continuation);
    }

    public Object g(int i, Continuation continuation) {
        final RoomSQLiteQuery c2 = RoomSQLiteQuery.c("select * from app_track where iotDeviceId is not NULL and length(iotDeviceId)>0 and iotDeviceRom is not NULL and length(iotDeviceRom)>0 limit ?", 1);
        c2.F(1, (long) i);
        return CoroutinesRoom.b(this.f6376a, false, DBUtil.a(), new Callable<List<AppTrack>>() {
            /* renamed from: a */
            public List call() {
                Cursor c = DBUtil.c(AppTrackDao_Impl.this.f6376a, c2, false, (CancellationSignal) null);
                try {
                    int d = CursorUtil.d(c, "id");
                    int d2 = CursorUtil.d(c, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
                    int d3 = CursorUtil.d(c, "name");
                    int d4 = CursorUtil.d(c, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
                    int d5 = CursorUtil.d(c, "iotDeviceId");
                    int d6 = CursorUtil.d(c, "iotDeviceRom");
                    ArrayList arrayList = new ArrayList(c.getCount());
                    while (c.moveToNext()) {
                        arrayList.add(new AppTrack(c.getLong(d), c.isNull(d2) ? null : c.getString(d2), c.isNull(d3) ? null : c.getString(d3), c.isNull(d4) ? null : c.getString(d4), c.isNull(d5) ? null : c.getString(d5), c.isNull(d6) ? null : c.getString(d6)));
                    }
                    return arrayList;
                } finally {
                    c.close();
                    c2.release();
                }
            }
        }, continuation);
    }
}
