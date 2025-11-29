package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.android.gms.actions.SearchIntents;
import com.honey.account.e0.a;
import com.honey.account.e0.b;
import com.meizu.common.widget.MzContactsContract;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 i2\u00020\u0001:\u0002jkB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010 H\u0017¢\u0006\u0004\b\"\u0010#J'\u0010)\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J5\u0010/\u001a\u00020%2\u0006\u0010$\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0012\u0010.\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010-\u0018\u00010,H\u0016¢\u0006\u0004\b/\u00100JE\u00101\u001a\u00020%2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0012\u0010.\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010-\u0018\u00010,H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u00104J)\u00106\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0010\u00105\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0,H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00112\u0006\u00108\u001a\u00020%H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020%H\u0016¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u0011H\u0017¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u000bH\u0016¢\u0006\u0004\bE\u0010\rJ\u0015\u0010G\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u0002¢\u0006\u0004\bG\u0010HR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0013R$\u0010Q\u001a\u00020%2\u0006\u0010M\u001a\u00020%8V@VX\u000e¢\u0006\f\u001a\u0004\bN\u0010O\"\u0004\bP\u0010AR$\u0010V\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00158V@VX\u000e¢\u0006\f\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR$\u0010Y\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00158V@VX\u000e¢\u0006\f\u001a\u0004\bW\u0010S\"\u0004\bX\u0010UR\u0014\u0010[\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010\u0013R\u0014\u0010\\\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\u0013R\u0016\u0010_\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0014\u0010a\u001a\u00020\u00118WX\u0004¢\u0006\u0006\u001a\u0004\b`\u0010\u0013R(\u0010f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060c\u0018\u00010b8VX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0014\u0010h\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\bg\u0010\u0013¨\u0006l"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "Landroid/database/sqlite/SQLiteDatabase;", "delegate", "<init>", "(Landroid/database/sqlite/SQLiteDatabase;)V", "", "sql", "Landroidx/sqlite/db/SupportSQLiteStatement;", "g0", "(Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteStatement;", "", "f", "()V", "m", "Z", "V", "", "s0", "()Z", "m0", "", "numBytes", "X", "(J)J", "query", "Landroid/database/Cursor;", "n0", "(Ljava/lang/String;)Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "t", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Landroid/database/Cursor;", "Landroid/os/CancellationSignal;", "cancellationSignal", "l", "(Landroidx/sqlite/db/SupportSQLiteQuery;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "table", "", "conflictAlgorithm", "Landroid/content/ContentValues;", "values", "K", "(Ljava/lang/String;ILandroid/content/ContentValues;)J", "whereClause", "", "", "whereArgs", "e", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "k0", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "P", "(Ljava/lang/String;)V", "bindArgs", "W", "(Ljava/lang/String;[Ljava/lang/Object;)V", "newVersion", "q", "(I)Z", "Ljava/util/Locale;", "locale", "setLocale", "(Ljava/util/Locale;)V", "cacheSize", "v0", "(I)V", "enabled", "E", "(Z)V", "close", "sqLiteDatabase", "c", "(Landroid/database/sqlite/SQLiteDatabase;)Z", "a", "Landroid/database/sqlite/SQLiteDatabase;", "p", "isDbLockedByCurrentThread", "value", "getVersion", "()I", "setVersion", "version", "G", "()J", "setMaximumSize", "(J)V", "maximumSize", "getPageSize", "w0", "pageSize", "j0", "isReadOnly", "isOpen", "getPath", "()Ljava/lang/String;", "path", "u0", "isWriteAheadLoggingEnabled", "", "Landroid/util/Pair;", "h", "()Ljava/util/List;", "attachedDbs", "Q", "isDatabaseIntegrityOk", "b", "Api30Impl", "Companion", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFrameworkSQLiteDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FrameworkSQLiteDatabase.kt\nandroidx/sqlite/db/framework/FrameworkSQLiteDatabase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,336:1\n1#2:337\n*E\n"})
public final class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static final String[] c = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final String[] d = new String[0];

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f1799a;

    @RequiresApi
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase$Api30Impl;", "", "<init>", "()V", "Landroid/database/sqlite/SQLiteDatabase;", "sQLiteDatabase", "", "sql", "", "bindArgs", "", "a", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Object;)V", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0})
    public static final class Api30Impl {

        /* renamed from: a  reason: collision with root package name */
        public static final Api30Impl f1800a = new Api30Impl();

        @DoNotInline
        public final void a(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, @Nullable Object[] objArr) {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, "sQLiteDatabase");
            Intrinsics.checkNotNullParameter(str, "sql");
            sQLiteDatabase.execPerConnectionSQL(str, objArr);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase$Companion;", "", "()V", "CONFLICT_VALUES", "", "", "[Ljava/lang/String;", "EMPTY_STRING_ARRAY", "sqlite-framework_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "delegate");
        this.f1799a = sQLiteDatabase;
    }

    public static final Cursor d(Function4 function4, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        Intrinsics.checkNotNullParameter(function4, "$tmp0");
        return (Cursor) function4.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    public static final Cursor g(SupportSQLiteQuery supportSQLiteQuery, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, "$query");
        Intrinsics.checkNotNull(sQLiteQuery);
        supportSQLiteQuery.b(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public void E(boolean z) {
        SupportSQLiteCompat.Api16Impl.f(this.f1799a, z);
    }

    public long G() {
        return this.f1799a.getMaximumSize();
    }

    public long K(String str, int i, ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(contentValues, "values");
        return this.f1799a.insertWithOnConflict(str, (String) null, contentValues, i);
    }

    public void P(String str) {
        Intrinsics.checkNotNullParameter(str, "sql");
        this.f1799a.execSQL(str);
    }

    public boolean Q() {
        return this.f1799a.isDatabaseIntegrityOk();
    }

    public void V() {
        this.f1799a.setTransactionSuccessful();
    }

    public void W(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "sql");
        Intrinsics.checkNotNullParameter(objArr, "bindArgs");
        this.f1799a.execSQL(str, objArr);
    }

    public long X(long j) {
        this.f1799a.setMaximumSize(j);
        return this.f1799a.getMaximumSize();
    }

    public void Z() {
        this.f1799a.endTransaction();
    }

    public final boolean c(SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
        return Intrinsics.areEqual((Object) this.f1799a, (Object) sQLiteDatabase);
    }

    public void close() {
        this.f1799a.close();
    }

    public int e(String str, String str2, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "table");
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(str);
        if (!(str2 == null || str2.length() == 0)) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        SupportSQLiteStatement g0 = g0(sb2);
        SimpleSQLiteQuery.c.b(g0, objArr);
        return g0.k();
    }

    public void f() {
        this.f1799a.beginTransaction();
    }

    public SupportSQLiteStatement g0(String str) {
        Intrinsics.checkNotNullParameter(str, "sql");
        SQLiteStatement compileStatement = this.f1799a.compileStatement(str);
        Intrinsics.checkNotNullExpressionValue(compileStatement, "delegate.compileStatement(sql)");
        return new FrameworkSQLiteStatement(compileStatement);
    }

    public long getPageSize() {
        return this.f1799a.getPageSize();
    }

    public String getPath() {
        return this.f1799a.getPath();
    }

    public int getVersion() {
        return this.f1799a.getVersion();
    }

    public List h() {
        return this.f1799a.getAttachedDbs();
    }

    public boolean isOpen() {
        return this.f1799a.isOpen();
    }

    public boolean j0() {
        return this.f1799a.isReadOnly();
    }

    public int k0(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(contentValues, "values");
        if (contentValues.size() != 0) {
            int size = contentValues.size();
            int length = objArr == null ? size : objArr.length + size;
            Object[] objArr2 = new Object[length];
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ");
            sb.append(c[i]);
            sb.append(str);
            sb.append(" SET ");
            int i2 = 0;
            for (String next : contentValues.keySet()) {
                sb.append(i2 > 0 ? MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA : "");
                sb.append(next);
                objArr2[i2] = contentValues.get(next);
                sb.append("=?");
                i2++;
            }
            if (objArr != null) {
                for (int i3 = size; i3 < length; i3++) {
                    objArr2[i3] = objArr[i3 - size];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" WHERE ");
                sb.append(str2);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            SupportSQLiteStatement g0 = g0(sb2);
            SimpleSQLiteQuery.c.b(g0, objArr2);
            return g0.k();
        }
        throw new IllegalArgumentException("Empty values".toString());
    }

    public Cursor l(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, SearchIntents.EXTRA_QUERY);
        SQLiteDatabase sQLiteDatabase = this.f1799a;
        String a2 = supportSQLiteQuery.a();
        String[] strArr = d;
        Intrinsics.checkNotNull(cancellationSignal);
        return SupportSQLiteCompat.Api16Impl.e(sQLiteDatabase, a2, strArr, (String) null, cancellationSignal, new a(supportSQLiteQuery));
    }

    public void m() {
        this.f1799a.beginTransactionNonExclusive();
    }

    public boolean m0() {
        return this.f1799a.yieldIfContendedSafely();
    }

    public Cursor n0(String str) {
        Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
        return t(new SimpleSQLiteQuery(str));
    }

    public boolean p() {
        return this.f1799a.isDbLockedByCurrentThread();
    }

    public boolean q(int i) {
        return this.f1799a.needUpgrade(i);
    }

    public boolean s0() {
        return this.f1799a.inTransaction();
    }

    public void setLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.f1799a.setLocale(locale);
    }

    public void setVersion(int i) {
        this.f1799a.setVersion(i);
    }

    public Cursor t(SupportSQLiteQuery supportSQLiteQuery) {
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, SearchIntents.EXTRA_QUERY);
        Cursor rawQueryWithFactory = this.f1799a.rawQueryWithFactory(new b(new FrameworkSQLiteDatabase$query$cursorFactory$1(supportSQLiteQuery)), supportSQLiteQuery.a(), d, (String) null);
        Intrinsics.checkNotNullExpressionValue(rawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return rawQueryWithFactory;
    }

    public boolean u0() {
        return SupportSQLiteCompat.Api16Impl.d(this.f1799a);
    }

    public void v0(int i) {
        this.f1799a.setMaxSqlCacheSize(i);
    }

    public void w0(long j) {
        this.f1799a.setPageSize(j);
    }
}
