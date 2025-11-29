package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.android.gms.actions.SearchIntents;
import com.honey.account.c0.g;
import com.honey.account.c0.h;
import com.honey.account.c0.i;
import com.honey.account.c0.j;
import com.honey.account.c0.k;
import com.honey.account.c0.l;
import com.honey.account.c0.m;
import com.honey.account.c0.n;
import com.honey.account.c0.o;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0011\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\"\u0010#J\u0018\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b&\u0010'J\u0018\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0012H\u0001¢\u0006\u0004\b)\u0010*J\u0018\u0010,\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001bH\u0001¢\u0006\u0004\b,\u0010-JF\u0010.\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0011\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0015H\u0001¢\u0006\u0004\b0\u0010\u0017J\u0017\u00103\u001a\u0002022\u0006\u00101\u001a\u00020\fH\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\tH\u0016¢\u0006\u0004\b5\u0010\u000bJ\u000f\u00106\u001a\u00020\tH\u0016¢\u0006\u0004\b6\u0010\u000bJ\u000f\u00107\u001a\u00020\tH\u0016¢\u0006\u0004\b7\u0010\u000bJ\u000f\u00108\u001a\u00020\tH\u0016¢\u0006\u0004\b8\u0010\u000bJ\u0017\u0010;\u001a\u00020:2\u0006\u00109\u001a\u00020\fH\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020:2\u0006\u00109\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J!\u0010B\u001a\u00020:2\u0006\u00109\u001a\u00020=2\b\u0010A\u001a\u0004\u0018\u00010@H\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\t2\u0006\u00101\u001a\u00020\fH\u0016¢\u0006\u0004\bD\u0010EJ)\u0010G\u001a\u00020\t2\u0006\u00101\u001a\u00020\f2\u0010\u0010F\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000fH\u0016¢\u0006\u0004\bG\u0010HR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR(\u0010S\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0P\u0018\u00010O8VX\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020\u00158\u0016X\u0005¢\u0006\u0006\u001a\u0004\bT\u0010\u0017R\u0014\u0010W\u001a\u00020\u00158\u0016X\u0005¢\u0006\u0006\u001a\u0004\bV\u0010\u0017R\u0014\u0010X\u001a\u00020\u00158\u0016X\u0005¢\u0006\u0006\u001a\u0004\bX\u0010\u0017R\u0014\u0010Z\u001a\u00020\u00158\u0016X\u0005¢\u0006\u0006\u001a\u0004\bY\u0010\u0017R\u0014\u0010\\\u001a\u00020\u00158WX\u0005¢\u0006\u0006\u001a\u0004\b[\u0010\u0017R\u0014\u0010_\u001a\u00020\u001b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b]\u0010^R\u001c\u0010c\u001a\u00020\u001b8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b`\u0010^\"\u0004\ba\u0010bR\u0016\u0010f\u001a\u0004\u0018\u00010\f8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bd\u0010eR\u001c\u0010j\u001a\u00020\u00128\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010*¨\u0006k"}, d2 = {"Landroidx/room/QueryInterceptorDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "delegate", "Ljava/util/concurrent/Executor;", "queryCallbackExecutor", "Landroidx/room/RoomDatabase$QueryCallback;", "queryCallback", "<init>", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$QueryCallback;)V", "", "close", "()V", "", "table", "whereClause", "", "", "whereArgs", "", "e", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "", "s0", "()Z", "conflictAlgorithm", "Landroid/content/ContentValues;", "values", "", "K", "(Ljava/lang/String;ILandroid/content/ContentValues;)J", "newVersion", "q", "(I)Z", "enabled", "E", "(Z)V", "Ljava/util/Locale;", "locale", "setLocale", "(Ljava/util/Locale;)V", "cacheSize", "v0", "(I)V", "numBytes", "X", "(J)J", "k0", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "m0", "sql", "Landroidx/sqlite/db/SupportSQLiteStatement;", "g0", "(Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteStatement;", "f", "m", "Z", "V", "query", "Landroid/database/Cursor;", "n0", "(Ljava/lang/String;)Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "t", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Landroid/database/Cursor;", "Landroid/os/CancellationSignal;", "cancellationSignal", "l", "(Landroidx/sqlite/db/SupportSQLiteQuery;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "P", "(Ljava/lang/String;)V", "bindArgs", "W", "(Ljava/lang/String;[Ljava/lang/Object;)V", "a", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "b", "Ljava/util/concurrent/Executor;", "c", "Landroidx/room/RoomDatabase$QueryCallback;", "", "Landroid/util/Pair;", "h", "()Ljava/util/List;", "attachedDbs", "Q", "isDatabaseIntegrityOk", "p", "isDbLockedByCurrentThread", "isOpen", "j0", "isReadOnly", "u0", "isWriteAheadLoggingEnabled", "G", "()J", "maximumSize", "getPageSize", "w0", "(J)V", "pageSize", "getPath", "()Ljava/lang/String;", "path", "getVersion", "()I", "setVersion", "version", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nQueryInterceptorDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QueryInterceptorDatabase.kt\nandroidx/room/QueryInterceptorDatabase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,146:1\n1#2:147\n37#3,2:148\n*S KotlinDebug\n*F\n+ 1 QueryInterceptorDatabase.kt\nandroidx/room/QueryInterceptorDatabase\n*L\n143#1:148,2\n*E\n"})
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {

    /* renamed from: a  reason: collision with root package name */
    public final SupportSQLiteDatabase f1745a;
    public final Executor b;
    public final RoomDatabase.QueryCallback c;

    public QueryInterceptorDatabase(SupportSQLiteDatabase supportSQLiteDatabase, Executor executor, RoomDatabase.QueryCallback queryCallback) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "delegate");
        Intrinsics.checkNotNullParameter(executor, "queryCallbackExecutor");
        Intrinsics.checkNotNullParameter(queryCallback, "queryCallback");
        this.f1745a = supportSQLiteDatabase;
        this.b = executor;
        this.c = queryCallback;
    }

    public static final void J(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, "$query");
        Intrinsics.checkNotNullParameter(queryInterceptorProgram, "$queryInterceptorProgram");
        queryInterceptorDatabase.c.a(supportSQLiteQuery.a(), queryInterceptorProgram.a());
    }

    public static final void N(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, "$query");
        Intrinsics.checkNotNullParameter(queryInterceptorProgram, "$queryInterceptorProgram");
        queryInterceptorDatabase.c.a(supportSQLiteQuery.a(), queryInterceptorProgram.a());
    }

    public static final void S(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.c.a("TRANSACTION SUCCESSFUL", CollectionsKt.emptyList());
    }

    public static final void r(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.c.a("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt.emptyList());
    }

    public static final void s(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.c.a("BEGIN DEFERRED TRANSACTION", CollectionsKt.emptyList());
    }

    public static final void u(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.c.a("END TRANSACTION", CollectionsKt.emptyList());
    }

    public static final void v(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        Intrinsics.checkNotNullParameter(str, "$sql");
        queryInterceptorDatabase.c.a(str, CollectionsKt.emptyList());
    }

    public static final void w(QueryInterceptorDatabase queryInterceptorDatabase, String str, List list) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        Intrinsics.checkNotNullParameter(str, "$sql");
        Intrinsics.checkNotNullParameter(list, "$inputArguments");
        queryInterceptorDatabase.c.a(str, list);
    }

    public static final void z(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        queryInterceptorDatabase.c.a(str, CollectionsKt.emptyList());
    }

    public void E(boolean z) {
        this.f1745a.E(z);
    }

    public long G() {
        return this.f1745a.G();
    }

    public long K(String str, int i, ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(contentValues, "values");
        return this.f1745a.K(str, i, contentValues);
    }

    public void P(String str) {
        Intrinsics.checkNotNullParameter(str, "sql");
        this.b.execute(new h(this, str));
        this.f1745a.P(str);
    }

    public boolean Q() {
        return this.f1745a.Q();
    }

    public void V() {
        this.b.execute(new j(this));
        this.f1745a.V();
    }

    public void W(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "sql");
        Intrinsics.checkNotNullParameter(objArr, "bindArgs");
        List createListBuilder = CollectionsKt.createListBuilder();
        CollectionsKt.addAll(createListBuilder, (T[]) objArr);
        List build = CollectionsKt.build(createListBuilder);
        this.b.execute(new l(this, str, build));
        this.f1745a.W(str, build.toArray(new Object[0]));
    }

    public long X(long j) {
        return this.f1745a.X(j);
    }

    public void Z() {
        this.b.execute(new g(this));
        this.f1745a.Z();
    }

    public void close() {
        this.f1745a.close();
    }

    public int e(String str, String str2, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "table");
        return this.f1745a.e(str, str2, objArr);
    }

    public void f() {
        this.b.execute(new i(this));
        this.f1745a.f();
    }

    public SupportSQLiteStatement g0(String str) {
        Intrinsics.checkNotNullParameter(str, "sql");
        return new QueryInterceptorStatement(this.f1745a.g0(str), str, this.b, this.c);
    }

    public long getPageSize() {
        return this.f1745a.getPageSize();
    }

    public String getPath() {
        return this.f1745a.getPath();
    }

    public int getVersion() {
        return this.f1745a.getVersion();
    }

    public List h() {
        return this.f1745a.h();
    }

    public boolean isOpen() {
        return this.f1745a.isOpen();
    }

    public boolean j0() {
        return this.f1745a.j0();
    }

    public int k0(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(contentValues, "values");
        return this.f1745a.k0(str, i, contentValues, str2, objArr);
    }

    public Cursor l(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, SearchIntents.EXTRA_QUERY);
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.b(queryInterceptorProgram);
        this.b.execute(new n(this, supportSQLiteQuery, queryInterceptorProgram));
        return this.f1745a.t(supportSQLiteQuery);
    }

    public void m() {
        this.b.execute(new k(this));
        this.f1745a.m();
    }

    public boolean m0() {
        return this.f1745a.m0();
    }

    public Cursor n0(String str) {
        Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
        this.b.execute(new o(this, str));
        return this.f1745a.n0(str);
    }

    public boolean p() {
        return this.f1745a.p();
    }

    public boolean q(int i) {
        return this.f1745a.q(i);
    }

    public boolean s0() {
        return this.f1745a.s0();
    }

    public void setLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.f1745a.setLocale(locale);
    }

    public void setVersion(int i) {
        this.f1745a.setVersion(i);
    }

    public Cursor t(SupportSQLiteQuery supportSQLiteQuery) {
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, SearchIntents.EXTRA_QUERY);
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.b(queryInterceptorProgram);
        this.b.execute(new m(this, supportSQLiteQuery, queryInterceptorProgram));
        return this.f1745a.t(supportSQLiteQuery);
    }

    public boolean u0() {
        return this.f1745a.u0();
    }

    public void v0(int i) {
        this.f1745a.v0(i);
    }

    public void w0(long j) {
        this.f1745a.w0(j);
    }
}
