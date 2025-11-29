package androidx.sqlite.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.CancellationSignal;
import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH'¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010%\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&J5\u0010+\u001a\u00020!2\u0006\u0010 \u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00022\u0012\u0010*\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010)\u0018\u00010(H&¢\u0006\u0004\b+\u0010,JE\u0010-\u001a\u00020!2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010\u00022\u0012\u0010*\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010)\u0018\u00010(H&¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b/\u00100J)\u00102\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010)0(H&¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\r2\u0006\u00104\u001a\u00020!H&¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\u00072\u0006\u00108\u001a\u000207H&¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\u00072\u0006\u0010;\u001a\u00020!H&¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\rH'¢\u0006\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u000fR\u001c\u0010F\u001a\u00020!8&@&X¦\u000e¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010=R\u0014\u0010I\u001a\u00020\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u001c\u0010M\u001a\u00020\u00118&@&X¦\u000e¢\u0006\f\u001a\u0004\bJ\u0010H\"\u0004\bK\u0010LR\u0014\u0010O\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\u000fR\u0014\u0010P\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u000fR\u0016\u0010S\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020\r8gX¦\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\u000fR(\u0010Z\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020W\u0018\u00010V8fX¦\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010\\\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u000fø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006]À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteDatabase;", "Ljava/io/Closeable;", "", "sql", "Landroidx/sqlite/db/SupportSQLiteStatement;", "g0", "(Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteStatement;", "", "f", "()V", "m", "Z", "V", "", "s0", "()Z", "m0", "", "numBytes", "X", "(J)J", "query", "Landroid/database/Cursor;", "n0", "(Ljava/lang/String;)Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "t", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Landroid/database/Cursor;", "Landroid/os/CancellationSignal;", "cancellationSignal", "l", "(Landroidx/sqlite/db/SupportSQLiteQuery;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "table", "", "conflictAlgorithm", "Landroid/content/ContentValues;", "values", "K", "(Ljava/lang/String;ILandroid/content/ContentValues;)J", "whereClause", "", "", "whereArgs", "e", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "k0", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "P", "(Ljava/lang/String;)V", "bindArgs", "W", "(Ljava/lang/String;[Ljava/lang/Object;)V", "newVersion", "q", "(I)Z", "Ljava/util/Locale;", "locale", "setLocale", "(Ljava/util/Locale;)V", "cacheSize", "v0", "(I)V", "enabled", "E", "(Z)V", "p", "isDbLockedByCurrentThread", "getVersion", "()I", "setVersion", "version", "G", "()J", "maximumSize", "getPageSize", "w0", "(J)V", "pageSize", "j0", "isReadOnly", "isOpen", "getPath", "()Ljava/lang/String;", "path", "u0", "isWriteAheadLoggingEnabled", "", "Landroid/util/Pair;", "h", "()Ljava/util/List;", "attachedDbs", "Q", "isDatabaseIntegrityOk", "sqlite_release"}, k = 1, mv = {1, 8, 0})
public interface SupportSQLiteDatabase extends Closeable {
    void E(boolean z);

    long G();

    long K(String str, int i, ContentValues contentValues);

    void P(String str);

    boolean Q();

    void V();

    void W(String str, Object[] objArr);

    long X(long j);

    void Z();

    int e(String str, String str2, Object[] objArr);

    void f();

    SupportSQLiteStatement g0(String str);

    long getPageSize();

    String getPath();

    int getVersion();

    List h();

    boolean isOpen();

    boolean j0();

    int k0(String str, int i, ContentValues contentValues, String str2, Object[] objArr);

    Cursor l(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal);

    void m();

    boolean m0();

    Cursor n0(String str);

    boolean p();

    boolean q(int i);

    boolean s0();

    void setLocale(Locale locale);

    void setVersion(int i);

    Cursor t(SupportSQLiteQuery supportSQLiteQuery);

    boolean u0();

    void v0(int i);

    void w0(long j);
}
