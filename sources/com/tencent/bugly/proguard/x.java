package com.tencent.bugly.proguard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.honey.account.constant.AccountConstantKt;
import java.util.List;

public final class x extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static String f9601a = "bugly_db";
    public static int b = 16;
    protected Context c;
    private List<o> d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(Context context, List<o> list) {
        super(context, f9601a + AccountConstantKt.DEFAULT_SEGMENT, (SQLiteDatabase.CursorFactory) null, b);
        aa.a(context).getClass();
        this.c = context;
        this.d = list;
    }

    private synchronized boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            String[] strArr = {"t_lr", "t_ui", "t_pf"};
            for (int i = 0; i < 3; i++) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(strArr[i])), new String[0]);
            }
        } catch (Throwable th) {
            if (!al.b(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public final synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i = 0;
        while (sQLiteDatabase == null && i < 5) {
            i++;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                al.d("[Database] Try to get db(count: %d).", Integer.valueOf(i));
                if (i == 5) {
                    al.e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return sQLiteDatabase;
    }

    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i = 0;
        while (sQLiteDatabase == null && i < 5) {
            i++;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (Throwable unused) {
                al.d("[Database] Try to get db(count: %d).", Integer.valueOf(i));
                if (i == 5) {
                    al.e("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (sQLiteDatabase == null) {
            al.d("[Database] db error delay error record 1min.", new Object[0]);
        }
        return sQLiteDatabase;
    }

    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_ui ( _id INTEGER PRIMARY KEY , _tm int , _ut int , _tp int , _dt blob , _pc text ) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_lr ( _id INTEGER PRIMARY KEY , _tp int , _tm int , _pc text , _th text , _dt blob ) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_pf ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_cr ( _id INTEGER PRIMARY KEY , _tm int , _s1 text , _up int , _me int , _uc int , _dt blob ) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS dl_1002 (_id integer primary key autoincrement, _dUrl varchar(100), _sFile varchar(100), _sLen INTEGER, _tLen INTEGER, _MD5 varchar(100), _DLTIME INTEGER)");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append("CREATE TABLE IF NOT EXISTS ge_1002 (_id integer primary key autoincrement, _time INTEGER, _datas blob)");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS st_1002 ( _id integer , _tp text , _tm int , _dt blob,primary key(_id,_tp )) ");
            al.c(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS t_sla ( _id TEXT NOT NULL , _tm INTEGER NOT NULL , _dt TEXT NOT NULL , PRIMARY KEY(_id) ) ");
            String sb2 = sb.toString();
            al.c(sb2, new Object[0]);
            sQLiteDatabase.execSQL(sb2, new String[0]);
        } catch (Throwable th) {
            throw th;
        }
        List<o> list = this.d;
        if (list != null) {
            for (o onDbCreate : list) {
                try {
                    onDbCreate.onDbCreate(sQLiteDatabase);
                } catch (Throwable th2) {
                    if (!al.b(th2)) {
                        th2.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0066, code lost:
        return;
     */
    @android.annotation.TargetApi(11)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onDowngrade(android.database.sqlite.SQLiteDatabase r4, int r5, int r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            int r0 = com.tencent.bugly.proguard.ab.c()     // Catch:{ all -> 0x003d }
            r1 = 11
            if (r0 < r1) goto L_0x0065
            java.lang.String r0 = "[Database] Downgrade %d to %d drop tables."
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x003d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x003d }
            java.lang.Object[] r1 = new java.lang.Object[]{r1, r2}     // Catch:{ all -> 0x003d }
            com.tencent.bugly.proguard.al.d(r0, r1)     // Catch:{ all -> 0x003d }
            java.util.List<com.tencent.bugly.proguard.o> r0 = r3.d     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x003f
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x003d }
        L_0x0022:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x003f
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x003d }
            com.tencent.bugly.proguard.o r1 = (com.tencent.bugly.proguard.o) r1     // Catch:{ all -> 0x003d }
            r1.onDbDowngrade(r4, r5, r6)     // Catch:{ all -> 0x0032 }
            goto L_0x0022
        L_0x0032:
            r1 = move-exception
            boolean r2 = com.tencent.bugly.proguard.al.b(r1)     // Catch:{ all -> 0x003d }
            if (r2 != 0) goto L_0x0022
            r1.printStackTrace()     // Catch:{ all -> 0x003d }
            goto L_0x0022
        L_0x003d:
            r4 = move-exception
            goto L_0x0067
        L_0x003f:
            boolean r5 = r3.a(r4)     // Catch:{ all -> 0x003d }
            if (r5 == 0) goto L_0x004a
            r3.onCreate(r4)     // Catch:{ all -> 0x003d }
            monitor-exit(r3)
            return
        L_0x004a:
            java.lang.String r4 = "[Database] Failed to drop, delete db."
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x003d }
            com.tencent.bugly.proguard.al.d(r4, r5)     // Catch:{ all -> 0x003d }
            android.content.Context r4 = r3.c     // Catch:{ all -> 0x003d }
            java.lang.String r5 = f9601a     // Catch:{ all -> 0x003d }
            java.io.File r4 = r4.getDatabasePath(r5)     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x0065
            boolean r5 = r4.canWrite()     // Catch:{ all -> 0x003d }
            if (r5 == 0) goto L_0x0065
            r4.delete()     // Catch:{ all -> 0x003d }
        L_0x0065:
            monitor-exit(r3)
            return
        L_0x0067:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.x.onDowngrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onUpgrade(android.database.sqlite.SQLiteDatabase r4, int r5, int r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "[Database] Upgrade %d to %d , drop tables!"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0035 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0035 }
            java.lang.Object[] r1 = new java.lang.Object[]{r1, r2}     // Catch:{ all -> 0x0035 }
            com.tencent.bugly.proguard.al.d(r0, r1)     // Catch:{ all -> 0x0035 }
            java.util.List<com.tencent.bugly.proguard.o> r0 = r3.d     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0037
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0035 }
        L_0x001a:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0037
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0035 }
            com.tencent.bugly.proguard.o r1 = (com.tencent.bugly.proguard.o) r1     // Catch:{ all -> 0x0035 }
            r1.onDbUpgrade(r4, r5, r6)     // Catch:{ all -> 0x002a }
            goto L_0x001a
        L_0x002a:
            r1 = move-exception
            boolean r2 = com.tencent.bugly.proguard.al.b(r1)     // Catch:{ all -> 0x0035 }
            if (r2 != 0) goto L_0x001a
            r1.printStackTrace()     // Catch:{ all -> 0x0035 }
            goto L_0x001a
        L_0x0035:
            r4 = move-exception
            goto L_0x005f
        L_0x0037:
            boolean r5 = r3.a(r4)     // Catch:{ all -> 0x0035 }
            if (r5 == 0) goto L_0x0042
            r3.onCreate(r4)     // Catch:{ all -> 0x0035 }
            monitor-exit(r3)
            return
        L_0x0042:
            java.lang.String r4 = "[Database] Failed to drop, delete db."
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0035 }
            com.tencent.bugly.proguard.al.d(r4, r5)     // Catch:{ all -> 0x0035 }
            android.content.Context r4 = r3.c     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = f9601a     // Catch:{ all -> 0x0035 }
            java.io.File r4 = r4.getDatabasePath(r5)     // Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x005d
            boolean r5 = r4.canWrite()     // Catch:{ all -> 0x0035 }
            if (r5 == 0) goto L_0x005d
            r4.delete()     // Catch:{ all -> 0x0035 }
        L_0x005d:
            monitor-exit(r3)
            return
        L_0x005f:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.x.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }
}
