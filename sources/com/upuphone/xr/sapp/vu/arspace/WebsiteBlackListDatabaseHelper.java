package com.upuphone.xr.sapp.vu.arspace;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 \u00112\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\fJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\fJ\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\fJ\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001bJ)\u0010\u001f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0012H\u0002¢\u0006\u0004\b$\u0010#J\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0012H\u0002¢\u0006\u0004\b&\u0010#J'\u0010'\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0014H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0012H\u0002¢\u0006\u0004\b)\u0010*R#\u0010/\u001a\n +*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010,\u001a\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/upuphone/xr/sapp/vu/arspace/WebsiteBlackListDatabaseHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/database/sqlite/SQLiteDatabase;", "db", "", "onCreate", "(Landroid/database/sqlite/SQLiteDatabase;)V", "n", "()V", "i", "j", "c", "a", "b", "", "url", "", "g", "(Ljava/lang/String;)I", "Lorg/json/JSONArray;", "urls", "type", "u", "(Lorg/json/JSONArray;I)V", "v", "oldVersion", "newVersion", "onUpgrade", "(Landroid/database/sqlite/SQLiteDatabase;II)V", "tableName", "d", "(Ljava/lang/String;)V", "o", "table", "r", "w", "(Lorg/json/JSONArray;Ljava/lang/String;I)V", "z", "(Ljava/lang/String;Ljava/lang/String;)I", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "s", "()Landroid/database/sqlite/SQLiteDatabase;", "database", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WebsiteBlackListDatabaseHelper extends SQLiteOpenHelper {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f8055a = LazyKt.lazy(new WebsiteBlackListDatabaseHelper$database$2(this));

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/vu/arspace/WebsiteBlackListDatabaseHelper$Companion;", "", "()V", "COLUMN_HASHCODE", "", "COLUMN_TYPE", "COLUMN_URL", "TABLE_COMPLETE_BLACK", "TABLE_COMPLETE_DANGER", "TABLE_INCREMENT", "TEMP_TABLE_SUFFIX", "TYPE_BLACK", "", "TYPE_DANGER", "TYPE_SAFE", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebsiteBlackListDatabaseHelper(Context context) {
        super(context, "blacklist", (SQLiteDatabase.CursorFactory) null, 1);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        d("complete_black");
    }

    public final void b() {
        d("complete_danger");
    }

    public final void c() {
        d("increment");
    }

    public final void d(String str) {
        s().beginTransaction();
        r(str);
        SQLiteDatabase s = s();
        s.execSQL("ALTER TABLE " + str + "_temp RENAME TO " + str);
        s().setTransactionSuccessful();
        s().endTransaction();
    }

    public final int g(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        int z = z(str, "increment");
        if (z != -1) {
            return z;
        }
        int z2 = z(str, "complete_black");
        return z2 != -1 ? z2 : z(str, "complete_danger");
    }

    public final void i() {
        r("complete_black_temp");
        o("complete_black_temp");
    }

    public final void j() {
        r("complete_danger_temp");
        o("complete_danger_temp");
    }

    public final void n() {
        r("increment_temp");
        o("increment_temp");
    }

    public final void o(String str) {
        SQLiteDatabase s = s();
        s.execSQL("CREATE TABLE IF NOT EXISTS " + str + " (url TEXT, hashcode INTEGER, type INTEGER)");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "db");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void r(String str) {
        SQLiteDatabase s = s();
        s.execSQL("DROP TABLE IF EXISTS " + str);
    }

    public final SQLiteDatabase s() {
        return (SQLiteDatabase) this.f8055a.getValue();
    }

    public final void u(JSONArray jSONArray, int i) {
        Intrinsics.checkNotNullParameter(jSONArray, "urls");
        if (i == 0) {
            w(jSONArray, "complete_black_temp", i);
        } else if (i == 1) {
            w(jSONArray, "complete_danger_temp", i);
        }
    }

    public final void v(JSONArray jSONArray, int i) {
        Intrinsics.checkNotNullParameter(jSONArray, "urls");
        w(jSONArray, "increment_temp", i);
    }

    public final void w(JSONArray jSONArray, String str, int i) {
        ContentValues contentValues = new ContentValues();
        s().beginTransaction();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            String string = jSONArray.getString(i2);
            contentValues.put("url", string);
            contentValues.put("hashcode", Integer.valueOf(string.hashCode()));
            contentValues.put("type", Integer.valueOf(i));
            s().insert(str, (String) null, contentValues);
        }
        s().setTransactionSuccessful();
        s().endTransaction();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006f, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int z(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            android.database.sqlite.SQLiteDatabase r4 = r4.s()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SELECT * FROM "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = " WHERE hashcode = ?"
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String[] r0 = new java.lang.String[]{r0}
            android.database.Cursor r4 = r4.rawQuery(r6, r0)
            r6 = r4
            java.io.Closeable r6 = (java.io.Closeable) r6
            r0 = r6
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x0062 }
            int r0 = r4.getCount()     // Catch:{ all -> 0x0062 }
            r1 = -1
            r2 = 0
            if (r0 != 0) goto L_0x003c
            kotlin.io.CloseableKt.closeFinally(r6, r2)
            return r1
        L_0x003c:
            boolean r0 = r4.moveToNext()     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0064
            java.lang.String r0 = "url"
            int r0 = r4.getColumnIndex(r0)     // Catch:{ all -> 0x0062 }
            java.lang.String r3 = "type"
            int r3 = r4.getColumnIndex(r3)     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = r4.getString(r0)     // Catch:{ all -> 0x0062 }
            int r3 = r4.getInt(r3)     // Catch:{ all -> 0x0062 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x003c
            kotlin.io.CloseableKt.closeFinally(r6, r2)
            return r3
        L_0x0062:
            r4 = move-exception
            goto L_0x006a
        L_0x0064:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0062 }
            kotlin.io.CloseableKt.closeFinally(r6, r2)
            return r1
        L_0x006a:
            throw r4     // Catch:{ all -> 0x006b }
        L_0x006b:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.arspace.WebsiteBlackListDatabaseHelper.z(java.lang.String, java.lang.String):int");
    }
}
