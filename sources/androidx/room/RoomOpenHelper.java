package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nRoomOpenHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomOpenHelper.kt\nandroidx/room/RoomOpenHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 CursorUtil.kt\nandroidx/room/util/CursorUtil\n*L\n1#1,245:1\n1855#2,2:246\n145#3,7:248\n*S KotlinDebug\n*F\n+ 1 RoomOpenHelper.kt\nandroidx/room/RoomOpenHelper\n*L\n90#1:246,2\n137#1:248,7\n*E\n"})
@RestrictTo
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\b\u0017\u0018\u0000 \u00142\u00020\u0001:\u0003\u001f !B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ'\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u000fJ\u0017\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u000fJ\u0017\u0010\u0019\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u000fJ\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001eR\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001e¨\u0006\""}, d2 = {"Landroidx/room/RoomOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "Landroidx/room/DatabaseConfiguration;", "configuration", "Landroidx/room/RoomOpenHelper$Delegate;", "delegate", "", "identityHash", "legacyHash", "<init>", "(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenHelper$Delegate;Ljava/lang/String;Ljava/lang/String;)V", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "", "b", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "d", "", "oldVersion", "newVersion", "g", "(Landroidx/sqlite/db/SupportSQLiteDatabase;II)V", "e", "f", "h", "j", "i", "c", "Landroidx/room/DatabaseConfiguration;", "Landroidx/room/RoomOpenHelper$Delegate;", "Ljava/lang/String;", "Companion", "Delegate", "ValidationResult", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public DatabaseConfiguration c;
    public final Delegate d;
    public final String e;
    public final String f;

    @SourceDebugExtension({"SMAP\nRoomOpenHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomOpenHelper.kt\nandroidx/room/RoomOpenHelper$Companion\n+ 2 CursorUtil.kt\nandroidx/room/util/CursorUtil\n*L\n1#1,245:1\n145#2,7:246\n145#2,7:253\n*S KotlinDebug\n*F\n+ 1 RoomOpenHelper.kt\nandroidx/room/RoomOpenHelper$Companion\n*L\n231#1:246,7\n239#1:253,7\n*E\n"})
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Landroidx/room/RoomOpenHelper$Companion;", "", "<init>", "()V", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "", "b", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)Z", "a", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
            kotlin.io.CloseableKt.closeFinally(r2, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(androidx.sqlite.db.SupportSQLiteDatabase r3) {
            /*
                r2 = this;
                java.lang.String r2 = "db"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
                java.lang.String r2 = "SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"
                android.database.Cursor r2 = r3.n0(r2)
                java.io.Closeable r2 = (java.io.Closeable) r2
                r3 = r2
                android.database.Cursor r3 = (android.database.Cursor) r3     // Catch:{ all -> 0x001f }
                boolean r0 = r3.moveToFirst()     // Catch:{ all -> 0x001f }
                r1 = 0
                if (r0 == 0) goto L_0x0021
                int r3 = r3.getInt(r1)     // Catch:{ all -> 0x001f }
                if (r3 != 0) goto L_0x0021
                r1 = 1
                goto L_0x0021
            L_0x001f:
                r3 = move-exception
                goto L_0x0026
            L_0x0021:
                r3 = 0
                kotlin.io.CloseableKt.closeFinally(r2, r3)
                return r1
            L_0x0026:
                throw r3     // Catch:{ all -> 0x0027 }
            L_0x0027:
                r0 = move-exception
                kotlin.io.CloseableKt.closeFinally(r2, r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.Companion.a(androidx.sqlite.db.SupportSQLiteDatabase):boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
            kotlin.io.CloseableKt.closeFinally(r2, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean b(androidx.sqlite.db.SupportSQLiteDatabase r3) {
            /*
                r2 = this;
                java.lang.String r2 = "db"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
                java.lang.String r2 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
                android.database.Cursor r2 = r3.n0(r2)
                java.io.Closeable r2 = (java.io.Closeable) r2
                r3 = r2
                android.database.Cursor r3 = (android.database.Cursor) r3     // Catch:{ all -> 0x001f }
                boolean r0 = r3.moveToFirst()     // Catch:{ all -> 0x001f }
                r1 = 0
                if (r0 == 0) goto L_0x0021
                int r3 = r3.getInt(r1)     // Catch:{ all -> 0x001f }
                if (r3 == 0) goto L_0x0021
                r1 = 1
                goto L_0x0021
            L_0x001f:
                r3 = move-exception
                goto L_0x0026
            L_0x0021:
                r3 = 0
                kotlin.io.CloseableKt.closeFinally(r2, r3)
                return r1
            L_0x0026:
                throw r3     // Catch:{ all -> 0x0027 }
            L_0x0027:
                r0 = move-exception
                kotlin.io.CloseableKt.closeFinally(r2, r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.Companion.b(androidx.sqlite.db.SupportSQLiteDatabase):boolean");
        }

        public Companion() {
        }
    }

    @RestrictTo
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0015R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/room/RoomOpenHelper$Delegate;", "", "version", "", "(I)V", "createAllTables", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "dropAllTables", "onCreate", "onOpen", "onPostMigrate", "onPreMigrate", "onValidateSchema", "Landroidx/room/RoomOpenHelper$ValidationResult;", "validateMigration", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class Delegate {
        @JvmField
        public final int version;

        public Delegate(int i) {
            this.version = i;
        }

        public abstract void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onOpen(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        }

        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        }

        public ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
            validateMigration(supportSQLiteDatabase);
            return new ValidationResult(true, (String) null);
        }

        @Deprecated(message = "Use [onValidateSchema(SupportSQLiteDatabase)]")
        public void validateMigration(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @RestrictTo
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/room/RoomOpenHelper$ValidationResult;", "", "", "isValid", "", "expectedFoundMsg", "<init>", "(ZLjava/lang/String;)V", "a", "Z", "b", "Ljava/lang/String;", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static class ValidationResult {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f1755a;
        public final String b;

        public ValidationResult(boolean z, String str) {
            this.f1755a = z;
            this.b = str;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate, String str, String str2) {
        super(delegate.version);
        Intrinsics.checkNotNullParameter(databaseConfiguration, "configuration");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(str, "identityHash");
        Intrinsics.checkNotNullParameter(str2, "legacyHash");
        this.c = databaseConfiguration;
        this.d = delegate;
        this.e = str;
        this.f = str2;
    }

    public void b(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        super.b(supportSQLiteDatabase);
    }

    public void d(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        boolean a2 = g.a(supportSQLiteDatabase);
        this.d.createAllTables(supportSQLiteDatabase);
        if (!a2) {
            ValidationResult onValidateSchema = this.d.onValidateSchema(supportSQLiteDatabase);
            if (!onValidateSchema.f1755a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.b);
            }
        }
        j(supportSQLiteDatabase);
        this.d.onCreate(supportSQLiteDatabase);
    }

    public void e(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        g(supportSQLiteDatabase, i, i2);
    }

    public void f(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        super.f(supportSQLiteDatabase);
        h(supportSQLiteDatabase);
        this.d.onOpen(supportSQLiteDatabase);
        this.c = null;
    }

    public void g(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        List<Migration> d2;
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        DatabaseConfiguration databaseConfiguration = this.c;
        if (databaseConfiguration == null || (d2 = databaseConfiguration.d.d(i, i2)) == null) {
            DatabaseConfiguration databaseConfiguration2 = this.c;
            if (databaseConfiguration2 == null || databaseConfiguration2.a(i, i2)) {
                throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            }
            this.d.dropAllTables(supportSQLiteDatabase);
            this.d.createAllTables(supportSQLiteDatabase);
            return;
        }
        this.d.onPreMigrate(supportSQLiteDatabase);
        for (Migration migrate : d2) {
            migrate.migrate(supportSQLiteDatabase);
        }
        ValidationResult onValidateSchema = this.d.onValidateSchema(supportSQLiteDatabase);
        if (onValidateSchema.f1755a) {
            this.d.onPostMigrate(supportSQLiteDatabase);
            j(supportSQLiteDatabase);
            return;
        }
        throw new IllegalStateException("Migration didn't properly handle: " + onValidateSchema.b);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(androidx.sqlite.db.SupportSQLiteDatabase r4) {
        /*
            r3 = this;
            androidx.room.RoomOpenHelper$Companion r0 = g
            boolean r0 = r0.b(r4)
            if (r0 == 0) goto L_0x0063
            androidx.sqlite.db.SimpleSQLiteQuery r0 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.String r1 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r0.<init>(r1)
            android.database.Cursor r4 = r4.t(r0)
            java.io.Closeable r4 = (java.io.Closeable) r4
            r0 = r4
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x0025 }
            boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x0025 }
            r2 = 0
            if (r1 == 0) goto L_0x0027
            r1 = 0
            java.lang.String r0 = r0.getString(r1)     // Catch:{ all -> 0x0025 }
            goto L_0x0028
        L_0x0025:
            r3 = move-exception
            goto L_0x005d
        L_0x0027:
            r0 = r2
        L_0x0028:
            kotlin.io.CloseableKt.closeFinally(r4, r2)
            java.lang.String r4 = r3.e
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r0)
            if (r4 != 0) goto L_0x0075
            java.lang.String r4 = r3.f
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r0)
            if (r4 == 0) goto L_0x003c
            goto L_0x0075
        L_0x003c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "
            r1.append(r2)
            java.lang.String r3 = r3.e
            r1.append(r3)
            java.lang.String r3 = ", found: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r3 = r1.toString()
            r4.<init>(r3)
            throw r4
        L_0x005d:
            throw r3     // Catch:{ all -> 0x005e }
        L_0x005e:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r3)
            throw r0
        L_0x0063:
            androidx.room.RoomOpenHelper$Delegate r0 = r3.d
            androidx.room.RoomOpenHelper$ValidationResult r0 = r0.onValidateSchema(r4)
            boolean r1 = r0.f1755a
            if (r1 == 0) goto L_0x0076
            androidx.room.RoomOpenHelper$Delegate r0 = r3.d
            r0.onPostMigrate(r4)
            r3.j(r4)
        L_0x0075:
            return
        L_0x0076:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "Pre-packaged database has an invalid schema: "
            r4.append(r1)
            java.lang.String r0 = r0.b
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.h(androidx.sqlite.db.SupportSQLiteDatabase):void");
    }

    public final void i(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.P("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    public final void j(SupportSQLiteDatabase supportSQLiteDatabase) {
        i(supportSQLiteDatabase);
        supportSQLiteDatabase.P(RoomMasterTable.a(this.e));
    }
}
