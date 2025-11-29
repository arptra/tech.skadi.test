package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.android.gms.actions.SearchIntents;
import com.honey.account.constant.AccountConstantKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0003#$%B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00018\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8WX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8WX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001f¨\u0006&"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/room/DelegatingOpenHelper;", "delegate", "Landroidx/room/AutoCloser;", "autoCloser", "<init>", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;Landroidx/room/AutoCloser;)V", "", "enabled", "", "setWriteAheadLoggingEnabled", "(Z)V", "close", "()V", "a", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "getDelegate", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "b", "Landroidx/room/AutoCloser;", "Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "c", "Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "autoClosingDb", "", "getDatabaseName", "()Ljava/lang/String;", "databaseName", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "I", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "l0", "readableDatabase", "AutoClosingSupportSQLiteDatabase", "AutoClosingSupportSqliteStatement", "KeepAliveCursor", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public final SupportSQLiteOpenHelper f1724a;
    public final AutoCloser b;
    public final AutoClosingSupportSQLiteDatabase c;

    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010#\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0017¢\u0006\u0004\b#\u0010$J'\u0010*\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\t2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J5\u00100\u001a\u00020&2\u0006\u0010%\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\t2\u0012\u0010/\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010.\u0018\u00010-H\u0016¢\u0006\u0004\b0\u00101JE\u00102\u001a\u00020&2\u0006\u0010%\u001a\u00020\t2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010\t2\u0012\u0010/\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010.\u0018\u00010-H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b4\u00105J)\u00107\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0010\u00106\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010.0-H\u0016¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\u00122\u0006\u00109\u001a\u00020&H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020&H\u0016¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u0012H\u0017¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0006H\u0016¢\u0006\u0004\bF\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010GR\u0014\u0010I\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0014R$\u0010J\u001a\u00020&2\u0006\u0010J\u001a\u00020&8V@VX\u000e¢\u0006\f\u001a\u0004\bK\u0010L\"\u0004\bM\u0010BR\u0014\u0010P\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR$\u0010T\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168V@VX\u000e¢\u0006\f\u001a\u0004\bQ\u0010O\"\u0004\bR\u0010SR\u0014\u0010V\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\bU\u0010\u0014R\u0014\u0010W\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u0014R\u0016\u0010Z\u001a\u0004\u0018\u00010\t8VX\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010\\\u001a\u00020\u00128WX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0014R(\u0010a\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0^\u0018\u00010]8VX\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\bb\u0010\u0014¨\u0006d"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "Landroidx/room/AutoCloser;", "autoCloser", "<init>", "(Landroidx/room/AutoCloser;)V", "", "a", "()V", "", "sql", "Landroidx/sqlite/db/SupportSQLiteStatement;", "g0", "(Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteStatement;", "f", "m", "Z", "V", "", "s0", "()Z", "m0", "", "numBytes", "X", "(J)J", "query", "Landroid/database/Cursor;", "n0", "(Ljava/lang/String;)Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "t", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Landroid/database/Cursor;", "Landroid/os/CancellationSignal;", "cancellationSignal", "l", "(Landroidx/sqlite/db/SupportSQLiteQuery;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "table", "", "conflictAlgorithm", "Landroid/content/ContentValues;", "values", "K", "(Ljava/lang/String;ILandroid/content/ContentValues;)J", "whereClause", "", "", "whereArgs", "e", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "k0", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "P", "(Ljava/lang/String;)V", "bindArgs", "W", "(Ljava/lang/String;[Ljava/lang/Object;)V", "newVersion", "q", "(I)Z", "Ljava/util/Locale;", "locale", "setLocale", "(Ljava/util/Locale;)V", "cacheSize", "v0", "(I)V", "enabled", "E", "(Z)V", "close", "Landroidx/room/AutoCloser;", "p", "isDbLockedByCurrentThread", "version", "getVersion", "()I", "setVersion", "G", "()J", "maximumSize", "getPageSize", "w0", "(J)V", "pageSize", "j0", "isReadOnly", "isOpen", "getPath", "()Ljava/lang/String;", "path", "u0", "isWriteAheadLoggingEnabled", "", "Landroid/util/Pair;", "h", "()Ljava/util/List;", "attachedDbs", "Q", "isDatabaseIntegrityOk", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {

        /* renamed from: a  reason: collision with root package name */
        public final AutoCloser f1725a;

        public AutoClosingSupportSQLiteDatabase(AutoCloser autoCloser) {
            Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
            this.f1725a = autoCloser;
        }

        public void E(boolean z) {
            this.f1725a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setForeignKeyConstraintsEnabled$1(z));
        }

        public long G() {
            return ((Number) this.f1725a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1.INSTANCE)).longValue();
        }

        public long K(String str, int i, ContentValues contentValues) {
            Intrinsics.checkNotNullParameter(str, "table");
            Intrinsics.checkNotNullParameter(contentValues, "values");
            return ((Number) this.f1725a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$insert$1(str, i, contentValues))).longValue();
        }

        public void P(String str) {
            Intrinsics.checkNotNullParameter(str, "sql");
            this.f1725a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1(str));
        }

        public boolean Q() {
            return ((Boolean) this.f1725a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDatabaseIntegrityOk$1.INSTANCE)).booleanValue();
        }

        public void V() {
            Unit unit;
            SupportSQLiteDatabase h = this.f1725a.h();
            if (h != null) {
                h.V();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null".toString());
            }
        }

        public void W(String str, Object[] objArr) {
            Intrinsics.checkNotNullParameter(str, "sql");
            Intrinsics.checkNotNullParameter(objArr, "bindArgs");
            this.f1725a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$2(str, objArr));
        }

        public long X(long j) {
            return ((Number) this.f1725a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1(j))).longValue();
        }

        public void Z() {
            if (this.f1725a.h() != null) {
                try {
                    SupportSQLiteDatabase h = this.f1725a.h();
                    Intrinsics.checkNotNull(h);
                    h.Z();
                } finally {
                    this.f1725a.e();
                }
            } else {
                throw new IllegalStateException("End transaction called but delegateDb is null".toString());
            }
        }

        public final void a() {
            this.f1725a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pokeOpen$1.INSTANCE);
        }

        public void close() {
            this.f1725a.d();
        }

        public int e(String str, String str2, Object[] objArr) {
            Intrinsics.checkNotNullParameter(str, "table");
            return ((Number) this.f1725a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$delete$1(str, str2, objArr))).intValue();
        }

        public void f() {
            try {
                this.f1725a.j().f();
            } catch (Throwable th) {
                this.f1725a.e();
                throw th;
            }
        }

        public SupportSQLiteStatement g0(String str) {
            Intrinsics.checkNotNullParameter(str, "sql");
            return new AutoClosingSupportSqliteStatement(str, this.f1725a);
        }

        public long getPageSize() {
            return ((Number) this.f1725a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1.INSTANCE)).longValue();
        }

        public String getPath() {
            return (String) this.f1725a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1.INSTANCE);
        }

        public int getVersion() {
            return ((Number) this.f1725a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1.INSTANCE)).intValue();
        }

        public List h() {
            return (List) this.f1725a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1.INSTANCE);
        }

        public boolean isOpen() {
            SupportSQLiteDatabase h = this.f1725a.h();
            if (h == null) {
                return false;
            }
            return h.isOpen();
        }

        public boolean j0() {
            return ((Boolean) this.f1725a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1.INSTANCE)).booleanValue();
        }

        public int k0(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
            Intrinsics.checkNotNullParameter(str, "table");
            Intrinsics.checkNotNullParameter(contentValues, "values");
            return ((Number) this.f1725a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$update$1(str, i, contentValues, str2, objArr))).intValue();
        }

        public Cursor l(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter(supportSQLiteQuery, SearchIntents.EXTRA_QUERY);
            try {
                return new KeepAliveCursor(this.f1725a.j().l(supportSQLiteQuery, cancellationSignal), this.f1725a);
            } catch (Throwable th) {
                this.f1725a.e();
                throw th;
            }
        }

        public void m() {
            try {
                this.f1725a.j().m();
            } catch (Throwable th) {
                this.f1725a.e();
                throw th;
            }
        }

        public boolean m0() {
            return ((Boolean) this.f1725a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1.INSTANCE)).booleanValue();
        }

        public Cursor n0(String str) {
            Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
            try {
                return new KeepAliveCursor(this.f1725a.j().n0(str), this.f1725a);
            } catch (Throwable th) {
                this.f1725a.e();
                throw th;
            }
        }

        public boolean p() {
            if (this.f1725a.h() == null) {
                return false;
            }
            return ((Boolean) this.f1725a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDbLockedByCurrentThread$1.INSTANCE)).booleanValue();
        }

        public boolean q(int i) {
            return ((Boolean) this.f1725a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1(i))).booleanValue();
        }

        public boolean s0() {
            if (this.f1725a.h() == null) {
                return false;
            }
            return ((Boolean) this.f1725a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.INSTANCE)).booleanValue();
        }

        public void setLocale(Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            this.f1725a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1(locale));
        }

        public void setVersion(int i) {
            this.f1725a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$2(i));
        }

        public Cursor t(SupportSQLiteQuery supportSQLiteQuery) {
            Intrinsics.checkNotNullParameter(supportSQLiteQuery, SearchIntents.EXTRA_QUERY);
            try {
                return new KeepAliveCursor(this.f1725a.j().t(supportSQLiteQuery), this.f1725a);
            } catch (Throwable th) {
                this.f1725a.e();
                throw th;
            }
        }

        public boolean u0() {
            return ((Boolean) this.f1725a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1.INSTANCE)).booleanValue();
        }

        public void v0(int i) {
            this.f1725a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaxSqlCacheSize$1(i));
        }

        public void w0(long j) {
            this.f1725a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$2(j));
        }
    }

    @SourceDebugExtension({"SMAP\nAutoClosingRoomOpenHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoClosingRoomOpenHelper.kt\nandroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,571:1\n1864#2,3:572\n*S KotlinDebug\n*F\n+ 1 AutoClosingRoomOpenHelper.kt\nandroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement\n*L\n478#1:572,3\n*E\n"})
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J)\u0010&\u001a\u00028\u0000\"\u0004\b\u0000\u0010#2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0001H\u0002¢\u0006\u0004\b)\u0010*J!\u0010-\u001a\u00020\b2\u0006\u0010+\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b-\u0010.R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R(\u00106\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010,03j\n\u0012\u0006\u0012\u0004\u0018\u00010,`48\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u00105¨\u00067"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement;", "Landroidx/sqlite/db/SupportSQLiteStatement;", "", "sql", "Landroidx/room/AutoCloser;", "autoCloser", "<init>", "(Ljava/lang/String;Landroidx/room/AutoCloser;)V", "", "close", "()V", "execute", "", "k", "()I", "", "e0", "()J", "A", "Y", "()Ljava/lang/String;", "index", "L", "(I)V", "value", "F", "(IJ)V", "", "R", "(ID)V", "B", "(ILjava/lang/String;)V", "", "H", "(I[B)V", "T", "Lkotlin/Function1;", "block", "d", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "supportSQLiteStatement", "c", "(Landroidx/sqlite/db/SupportSQLiteStatement;)V", "bindIndex", "", "g", "(ILjava/lang/Object;)V", "a", "Ljava/lang/String;", "b", "Landroidx/room/AutoCloser;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "binds", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {

        /* renamed from: a  reason: collision with root package name */
        public final String f1726a;
        public final AutoCloser b;
        public final ArrayList c = new ArrayList();

        public AutoClosingSupportSqliteStatement(String str, AutoCloser autoCloser) {
            Intrinsics.checkNotNullParameter(str, "sql");
            Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
            this.f1726a = str;
            this.b = autoCloser;
        }

        public long A() {
            return ((Number) d(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForLong$1.INSTANCE)).longValue();
        }

        public void B(int i, String str) {
            Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
            g(i, str);
        }

        public void F(int i, long j) {
            g(i, Long.valueOf(j));
        }

        public void H(int i, byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, AccountConstantKt.RESPONSE_VALUE);
            g(i, bArr);
        }

        public void L(int i) {
            g(i, (Object) null);
        }

        public void R(int i, double d) {
            g(i, Double.valueOf(d));
        }

        public String Y() {
            return (String) d(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1.INSTANCE);
        }

        public final void c(SupportSQLiteStatement supportSQLiteStatement) {
            Iterator it = this.c.iterator();
            int i = 0;
            while (it.hasNext()) {
                it.next();
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object obj = this.c.get(i);
                if (obj == null) {
                    supportSQLiteStatement.L(i2);
                } else if (obj instanceof Long) {
                    supportSQLiteStatement.F(i2, ((Number) obj).longValue());
                } else if (obj instanceof Double) {
                    supportSQLiteStatement.R(i2, ((Number) obj).doubleValue());
                } else if (obj instanceof String) {
                    supportSQLiteStatement.B(i2, (String) obj);
                } else if (obj instanceof byte[]) {
                    supportSQLiteStatement.H(i2, (byte[]) obj);
                }
                i = i2;
            }
        }

        public void close() {
        }

        public final Object d(Function1 function1) {
            return this.b.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1(this, function1));
        }

        public long e0() {
            return ((Number) d(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1.INSTANCE)).longValue();
        }

        public void execute() {
            d(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1.INSTANCE);
        }

        public final void g(int i, Object obj) {
            int size;
            int i2 = i - 1;
            if (i2 >= this.c.size() && (size = this.c.size()) <= i2) {
                while (true) {
                    this.c.add((Object) null);
                    if (size == i2) {
                        break;
                    }
                    size++;
                }
            }
            this.c.set(i2, obj);
        }

        public int k() {
            return ((Number) d(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1.INSTANCE)).intValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\t0\tH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0012\u001a\n \n*\u0004\u0018\u00010\u00110\u00112\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0017\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\u00160\u0016H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u0019\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\u00160\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u0018J \u0010\u001a\u001a\n \n*\u0004\u0018\u00010\u00160\u00162\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ6\u0010\u001d\u001a(\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00160\u0016 \n*\u0014\u0012\u000e\b\u0001\u0012\n \n*\u0004\u0018\u00010\u00160\u0016\u0018\u00010\u001c0\u001cH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u001f\u0010\u0015J\u0018\u0010!\u001a\u00020 2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b!\u0010\"J\u0018\u0010$\u001a\n \n*\u0004\u0018\u00010#0#H\u0001¢\u0006\u0004\b$\u0010%J\u0018\u0010'\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b)\u0010*J\u0018\u0010,\u001a\u00020+2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0007H\u0001¢\u0006\u0004\b.\u0010\u0015J\u0018\u00100\u001a\u00020/2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b0\u00101J \u00102\u001a\n \n*\u0004\u0018\u00010\u00160\u00162\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b2\u0010\u001bJ\u0018\u00103\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b3\u0010*J\u0010\u00105\u001a\u000204H\u0001¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u000204H\u0001¢\u0006\u0004\b7\u00106J\u0010\u00108\u001a\u000204H\u0001¢\u0006\u0004\b8\u00106J\u0010\u00109\u001a\u000204H\u0001¢\u0006\u0004\b9\u00106J\u0010\u0010:\u001a\u000204H\u0001¢\u0006\u0004\b:\u00106J\u0010\u0010;\u001a\u000204H\u0001¢\u0006\u0004\b;\u00106J\u0018\u0010<\u001a\u0002042\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b<\u0010=J\u0018\u0010>\u001a\u0002042\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b>\u0010=J\u0010\u0010?\u001a\u000204H\u0001¢\u0006\u0004\b?\u00106J\u0010\u0010@\u001a\u000204H\u0001¢\u0006\u0004\b@\u00106J\u0010\u0010A\u001a\u000204H\u0001¢\u0006\u0004\bA\u00106J\u0018\u0010B\u001a\u0002042\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\bB\u0010=J\u0010\u0010C\u001a\u000204H\u0001¢\u0006\u0004\bC\u00106J \u0010E\u001a\u00020\f2\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010D0DH\u0001¢\u0006\u0004\bE\u0010FJ \u0010H\u001a\u00020\f2\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010G0GH\u0001¢\u0006\u0004\bH\u0010IJ\u0010\u0010J\u001a\u000204H\u0001¢\u0006\u0004\bJ\u00106J(\u0010K\u001a\n \n*\u0004\u0018\u00010#0#2\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010#0#H\u0001¢\u0006\u0004\bK\u0010LJ0\u0010O\u001a\u00020\f2\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010M0M2\u000e\u0010\u000b\u001a\n \n*\u0004\u0018\u00010N0NH\u0001¢\u0006\u0004\bO\u0010PJ \u0010Q\u001a\u00020\f2\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010D0DH\u0001¢\u0006\u0004\bQ\u0010FJ \u0010R\u001a\u00020\f2\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010G0GH\u0001¢\u0006\u0004\bR\u0010IJ\u000f\u0010S\u001a\u00020\fH\u0016¢\u0006\u0004\bS\u0010\u0010J%\u0010W\u001a\u00020\f2\u0006\u0010T\u001a\u00020M2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020N0UH\u0017¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020NH\u0017¢\u0006\u0004\bY\u0010ZJ\u0015\u0010[\u001a\b\u0012\u0004\u0012\u00020N0UH\u0017¢\u0006\u0004\b[\u0010\\J\u0017\u0010^\u001a\u00020\f2\u0006\u0010]\u001a\u00020#H\u0017¢\u0006\u0004\b^\u0010_R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010c¨\u0006d"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper$KeepAliveCursor;", "Landroid/database/Cursor;", "delegate", "Landroidx/room/AutoCloser;", "autoCloser", "<init>", "(Landroid/database/Cursor;Landroidx/room/AutoCloser;)V", "", "p0", "Landroid/database/CharArrayBuffer;", "kotlin.jvm.PlatformType", "p1", "", "copyStringToBuffer", "(ILandroid/database/CharArrayBuffer;)V", "deactivate", "()V", "", "getBlob", "(I)[B", "getColumnCount", "()I", "", "getColumnIndex", "(Ljava/lang/String;)I", "getColumnIndexOrThrow", "getColumnName", "(I)Ljava/lang/String;", "", "getColumnNames", "()[Ljava/lang/String;", "getCount", "", "getDouble", "(I)D", "Landroid/os/Bundle;", "getExtras", "()Landroid/os/Bundle;", "", "getFloat", "(I)F", "getInt", "(I)I", "", "getLong", "(I)J", "getPosition", "", "getShort", "(I)S", "getString", "getType", "", "getWantsAllOnMoveCalls", "()Z", "isAfterLast", "isBeforeFirst", "isClosed", "isFirst", "isLast", "isNull", "(I)Z", "move", "moveToFirst", "moveToLast", "moveToNext", "moveToPosition", "moveToPrevious", "Landroid/database/ContentObserver;", "registerContentObserver", "(Landroid/database/ContentObserver;)V", "Landroid/database/DataSetObserver;", "registerDataSetObserver", "(Landroid/database/DataSetObserver;)V", "requery", "respond", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "Landroid/content/ContentResolver;", "Landroid/net/Uri;", "setNotificationUri", "(Landroid/content/ContentResolver;Landroid/net/Uri;)V", "unregisterContentObserver", "unregisterDataSetObserver", "close", "cr", "", "uris", "setNotificationUris", "(Landroid/content/ContentResolver;Ljava/util/List;)V", "getNotificationUri", "()Landroid/net/Uri;", "getNotificationUris", "()Ljava/util/List;", "extras", "setExtras", "(Landroid/os/Bundle;)V", "a", "Landroid/database/Cursor;", "b", "Landroidx/room/AutoCloser;", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class KeepAliveCursor implements Cursor {

        /* renamed from: a  reason: collision with root package name */
        public final Cursor f1727a;
        public final AutoCloser b;

        public KeepAliveCursor(Cursor cursor, AutoCloser autoCloser) {
            Intrinsics.checkNotNullParameter(cursor, "delegate");
            Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
            this.f1727a = cursor;
            this.b = autoCloser;
        }

        public void close() {
            this.f1727a.close();
            this.b.e();
        }

        public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
            this.f1727a.copyStringToBuffer(i, charArrayBuffer);
        }

        public void deactivate() {
            this.f1727a.deactivate();
        }

        public byte[] getBlob(int i) {
            return this.f1727a.getBlob(i);
        }

        public int getColumnCount() {
            return this.f1727a.getColumnCount();
        }

        public int getColumnIndex(String str) {
            return this.f1727a.getColumnIndex(str);
        }

        public int getColumnIndexOrThrow(String str) {
            return this.f1727a.getColumnIndexOrThrow(str);
        }

        public String getColumnName(int i) {
            return this.f1727a.getColumnName(i);
        }

        public String[] getColumnNames() {
            return this.f1727a.getColumnNames();
        }

        public int getCount() {
            return this.f1727a.getCount();
        }

        public double getDouble(int i) {
            return this.f1727a.getDouble(i);
        }

        public Bundle getExtras() {
            return this.f1727a.getExtras();
        }

        public float getFloat(int i) {
            return this.f1727a.getFloat(i);
        }

        public int getInt(int i) {
            return this.f1727a.getInt(i);
        }

        public long getLong(int i) {
            return this.f1727a.getLong(i);
        }

        public Uri getNotificationUri() {
            return SupportSQLiteCompat.Api19Impl.a(this.f1727a);
        }

        public List getNotificationUris() {
            return SupportSQLiteCompat.Api29Impl.a(this.f1727a);
        }

        public int getPosition() {
            return this.f1727a.getPosition();
        }

        public short getShort(int i) {
            return this.f1727a.getShort(i);
        }

        public String getString(int i) {
            return this.f1727a.getString(i);
        }

        public int getType(int i) {
            return this.f1727a.getType(i);
        }

        public boolean getWantsAllOnMoveCalls() {
            return this.f1727a.getWantsAllOnMoveCalls();
        }

        public boolean isAfterLast() {
            return this.f1727a.isAfterLast();
        }

        public boolean isBeforeFirst() {
            return this.f1727a.isBeforeFirst();
        }

        public boolean isClosed() {
            return this.f1727a.isClosed();
        }

        public boolean isFirst() {
            return this.f1727a.isFirst();
        }

        public boolean isLast() {
            return this.f1727a.isLast();
        }

        public boolean isNull(int i) {
            return this.f1727a.isNull(i);
        }

        public boolean move(int i) {
            return this.f1727a.move(i);
        }

        public boolean moveToFirst() {
            return this.f1727a.moveToFirst();
        }

        public boolean moveToLast() {
            return this.f1727a.moveToLast();
        }

        public boolean moveToNext() {
            return this.f1727a.moveToNext();
        }

        public boolean moveToPosition(int i) {
            return this.f1727a.moveToPosition(i);
        }

        public boolean moveToPrevious() {
            return this.f1727a.moveToPrevious();
        }

        public void registerContentObserver(ContentObserver contentObserver) {
            this.f1727a.registerContentObserver(contentObserver);
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f1727a.registerDataSetObserver(dataSetObserver);
        }

        public boolean requery() {
            return this.f1727a.requery();
        }

        public Bundle respond(Bundle bundle) {
            return this.f1727a.respond(bundle);
        }

        public void setExtras(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "extras");
            SupportSQLiteCompat.Api23Impl.a(this.f1727a, bundle);
        }

        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.f1727a.setNotificationUri(contentResolver, uri);
        }

        public void setNotificationUris(ContentResolver contentResolver, List list) {
            Intrinsics.checkNotNullParameter(contentResolver, "cr");
            Intrinsics.checkNotNullParameter(list, "uris");
            SupportSQLiteCompat.Api29Impl.b(this.f1727a, contentResolver, list);
        }

        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.f1727a.unregisterContentObserver(contentObserver);
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f1727a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public AutoClosingRoomOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper, AutoCloser autoCloser) {
        Intrinsics.checkNotNullParameter(supportSQLiteOpenHelper, "delegate");
        Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
        this.f1724a = supportSQLiteOpenHelper;
        this.b = autoCloser;
        autoCloser.k(getDelegate());
        this.c = new AutoClosingSupportSQLiteDatabase(autoCloser);
    }

    public SupportSQLiteDatabase I() {
        this.c.a();
        return this.c;
    }

    public void close() {
        this.c.close();
    }

    public String getDatabaseName() {
        return this.f1724a.getDatabaseName();
    }

    public SupportSQLiteOpenHelper getDelegate() {
        return this.f1724a;
    }

    public SupportSQLiteDatabase l0() {
        this.c.a();
        return this.c;
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        this.f1724a.setWriteAheadLoggingEnabled(z);
    }
}
