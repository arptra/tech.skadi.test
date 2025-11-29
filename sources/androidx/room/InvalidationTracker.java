package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.honey.account.c0.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 /2\u00020\u0001:\u0005stuvwBX\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001d\u0010\t\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\b0\u0004\u0012\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J'\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n2\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\nH\u0002¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0011H\u0000¢\u0006\u0004\b \u0010!J'\u0010'\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0000¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000eH\u0000¢\u0006\u0004\b)\u0010\u0010J\u0017\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*H\u0017¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*H\u0017¢\u0006\u0004\b.\u0010-J\u0017\u0010/\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*H\u0017¢\u0006\u0004\b/\u0010-J\u000f\u00101\u001a\u000200H\u0000¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u000eH\u0016¢\u0006\u0004\b3\u0010\u0010J\u000f\u00104\u001a\u00020\u000eH\u0017¢\u0006\u0004\b4\u0010\u0010J#\u00106\u001a\u00020\u000e2\u0012\u00105\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005H\u0007¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0011H\u0000¢\u0006\u0004\b8\u0010!J\u000f\u00109\u001a\u00020\u000eH\u0000¢\u0006\u0004\b9\u0010\u0010JC\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>\"\u0004\b\u0000\u0010:2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n2\u0006\u0010;\u001a\u0002002\u000e\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000<H\u0017¢\u0006\u0004\b?\u0010@R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR+\u0010\t\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\b0\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010FR&\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u00048\u0000X\u0004¢\u0006\f\n\u0004\b.\u0010F\u001a\u0004\bG\u0010HR\"\u0010M\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n8\u0000X\u0004¢\u0006\f\n\u0004\b?\u0010J\u001a\u0004\bK\u0010LR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010NR\u001a\u0010T\u001a\u00020O8GX\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0016\u0010V\u001a\u0002008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010UR$\u0010]\u001a\u0004\u0018\u00010W8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bP\u0010Z\"\u0004\b[\u0010\\R\u0014\u0010`\u001a\u00020^8\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010_R\u0014\u0010c\u001a\u00020a8\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010bR&\u0010h\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020e0d8\u0000X\u0004¢\u0006\f\n\u0004\b \u0010f\u001a\u0004\bX\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u0010jR\u0014\u0010m\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010lR\u0014\u0010n\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010lR\u001a\u0010r\u001a\u00020o8\u0006X\u0004¢\u0006\f\n\u0004\b4\u0010p\u0012\u0004\bq\u0010\u0010¨\u0006x"}, d2 = {"Landroidx/room/InvalidationTracker;", "", "Landroidx/room/RoomDatabase;", "database", "", "", "shadowTablesMap", "", "Lkotlin/jvm/JvmSuppressWildcards;", "viewTables", "", "tableNames", "<init>", "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;)V", "", "n", "()V", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "", "tableId", "w", "(Landroidx/sqlite/db/SupportSQLiteDatabase;I)V", "u", "z", "([Ljava/lang/String;)[Ljava/lang/String;", "names", "r", "Landroidx/room/AutoCloser;", "autoCloser", "s", "(Landroidx/room/AutoCloser;)V", "l", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "Landroid/content/Context;", "context", "name", "Landroid/content/Intent;", "serviceIntent", "t", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "v", "Landroidx/room/InvalidationTracker$Observer;", "observer", "c", "(Landroidx/room/InvalidationTracker$Observer;)V", "d", "q", "", "f", "()Z", "o", "p", "tables", "m", "([Ljava/lang/String;)V", "y", "x", "T", "inTransaction", "Ljava/util/concurrent/Callable;", "computeFunction", "Landroidx/lifecycle/LiveData;", "e", "([Ljava/lang/String;ZLjava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;", "a", "Landroidx/room/RoomDatabase;", "h", "()Landroidx/room/RoomDatabase;", "b", "Ljava/util/Map;", "k", "()Ljava/util/Map;", "tableIdLookup", "[Ljava/lang/String;", "getTablesNames$room_runtime_release", "()[Ljava/lang/String;", "tablesNames", "Landroidx/room/AutoCloser;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "j", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingRefresh", "Z", "initialized", "Landroidx/sqlite/db/SupportSQLiteStatement;", "i", "Landroidx/sqlite/db/SupportSQLiteStatement;", "()Landroidx/sqlite/db/SupportSQLiteStatement;", "setCleanupStatement$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteStatement;)V", "cleanupStatement", "Landroidx/room/InvalidationTracker$ObservedTableTracker;", "Landroidx/room/InvalidationTracker$ObservedTableTracker;", "observedTableTracker", "Landroidx/room/InvalidationLiveDataContainer;", "Landroidx/room/InvalidationLiveDataContainer;", "invalidationLiveDataContainer", "Landroidx/arch/core/internal/SafeIterableMap;", "Landroidx/room/InvalidationTracker$ObserverWrapper;", "Landroidx/arch/core/internal/SafeIterableMap;", "()Landroidx/arch/core/internal/SafeIterableMap;", "observerMap", "Landroidx/room/MultiInstanceInvalidationClient;", "Landroidx/room/MultiInstanceInvalidationClient;", "multiInstanceInvalidationClient", "Ljava/lang/Object;", "syncTriggersLock", "trackerLock", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "getRefreshRunnable$annotations", "refreshRunnable", "Companion", "ObservedTableTracker", "Observer", "ObserverWrapper", "WeakObserver", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,840:1\n215#2,2:841\n11335#3:843\n11670#3,3:844\n13579#3,2:847\n13579#3,2:849\n13674#3,3:855\n37#4,2:851\n1855#5,2:853\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker\n*L\n102#1:841,2\n250#1:843\n250#1:844,3\n271#1:847,2\n287#1:849,2\n491#1:855,3\n294#1:851,2\n467#1:853,2\n*E\n"})
public class InvalidationTracker {
    public static final Companion q = new Companion((DefaultConstructorMarker) null);
    public static final String[] r = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f1735a;
    public final Map b;
    public final Map c;
    public final Map d;
    public final String[] e;
    public AutoCloser f;
    public final AtomicBoolean g = new AtomicBoolean(false);
    public volatile boolean h;
    public volatile SupportSQLiteStatement i;
    public final ObservedTableTracker j;
    public final InvalidationLiveDataContainer k;
    public final SafeIterableMap l;
    public MultiInstanceInvalidationClient m;
    public final Object n;
    public final Object o;
    public final Runnable p;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Landroidx/room/InvalidationTracker$Companion;", "", "<init>", "()V", "", "tableName", "triggerType", "b", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database", "", "a", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "CREATE_TRACKING_TABLE_SQL", "Ljava/lang/String;", "INVALIDATED_COLUMN_NAME", "TABLE_ID_COLUMN_NAME", "", "TRIGGERS", "[Ljava/lang/String;", "UPDATE_TABLE_NAME", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
            if (supportSQLiteDatabase.u0()) {
                supportSQLiteDatabase.m();
            } else {
                supportSQLiteDatabase.f();
            }
        }

        public final String b(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "tableName");
            Intrinsics.checkNotNullParameter(str2, "triggerType");
            return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
        }

        public Companion() {
        }
    }

    @SourceDebugExtension({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$ObservedTableTracker\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,840:1\n13600#2,2:841\n13600#2,2:843\n13684#2,3:845\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$ObservedTableTracker\n*L\n711#1:841,2\n729#1:843,2\n765#1:845,3\n*E\n"})
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\r\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00020\u0006\"\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\n\u0010\u0007\u001a\u00020\u0006\"\u00020\u0002¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\"\u0010 \u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Landroidx/room/InvalidationTracker$ObservedTableTracker;", "", "", "tableCount", "<init>", "(I)V", "", "tableIds", "", "b", "([I)Z", "c", "", "d", "()V", "a", "()[I", "", "[J", "getTableObservers", "()[J", "tableObservers", "", "[Z", "triggerStates", "[I", "triggerStateChanges", "Z", "getNeedsSync", "()Z", "setNeedsSync", "(Z)V", "needsSync", "e", "Companion", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class ObservedTableTracker {
        public static final Companion e = new Companion((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public final long[] f1736a;
        public final boolean[] b;
        public final int[] c;
        public boolean d;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/room/InvalidationTracker$ObservedTableTracker$Companion;", "", "()V", "ADD", "", "NO_OP", "REMOVE", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public Companion() {
            }
        }

        public ObservedTableTracker(int i) {
            this.f1736a = new long[i];
            this.b = new boolean[i];
            this.c = new int[i];
        }

        public final int[] a() {
            synchronized (this) {
                try {
                    if (!this.d) {
                        return null;
                    }
                    long[] jArr = this.f1736a;
                    int length = jArr.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        int i3 = i2 + 1;
                        int i4 = 1;
                        boolean z = jArr[i] > 0;
                        boolean[] zArr = this.b;
                        if (z != zArr[i2]) {
                            int[] iArr = this.c;
                            if (!z) {
                                i4 = 2;
                            }
                            iArr[i2] = i4;
                        } else {
                            this.c[i2] = 0;
                        }
                        zArr[i2] = z;
                        i++;
                        i2 = i3;
                    }
                    this.d = false;
                    int[] iArr2 = (int[]) this.c.clone();
                    return iArr2;
                } finally {
                }
            }
        }

        public final boolean b(int... iArr) {
            boolean z;
            Intrinsics.checkNotNullParameter(iArr, "tableIds");
            synchronized (this) {
                try {
                    z = false;
                    for (int i : iArr) {
                        long[] jArr = this.f1736a;
                        long j = jArr[i];
                        jArr[i] = 1 + j;
                        if (j == 0) {
                            this.d = true;
                            z = true;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                }
            }
            return z;
        }

        public final boolean c(int... iArr) {
            boolean z;
            Intrinsics.checkNotNullParameter(iArr, "tableIds");
            synchronized (this) {
                try {
                    z = false;
                    for (int i : iArr) {
                        long[] jArr = this.f1736a;
                        long j = jArr[i];
                        jArr[i] = j - 1;
                        if (j == 1) {
                            this.d = true;
                            z = true;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                }
            }
            return z;
        }

        public final void d() {
            synchronized (this) {
                Arrays.fill(this.b, false);
                this.d = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @SourceDebugExtension({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$Observer\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,840:1\n37#2,2:841\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$Observer\n*L\n670#1:841,2\n*E\n"})
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8PX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/room/InvalidationTracker$Observer;", "", "", "", "tables", "<init>", "([Ljava/lang/String;)V", "", "", "c", "(Ljava/util/Set;)V", "a", "[Ljava/lang/String;", "()[Ljava/lang/String;", "", "b", "()Z", "isRemote", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static abstract class Observer {

        /* renamed from: a  reason: collision with root package name */
        public final String[] f1737a;

        public Observer(String[] strArr) {
            Intrinsics.checkNotNullParameter(strArr, "tables");
            this.f1737a = strArr;
        }

        public final String[] a() {
            return this.f1737a;
        }

        public boolean b() {
            return false;
        }

        public abstract void c(Set set);
    }

    @SourceDebugExtension({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$ObserverWrapper\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,840:1\n13674#2,3:841\n12744#2,2:844\n13579#2:846\n13579#2,2:847\n13580#2:849\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$ObserverWrapper\n*L\n612#1:841,3\n634#1:844,2\n640#1:846\n641#1:847,2\n640#1:849\n*E\n"})
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019R\u001c\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Landroidx/room/InvalidationTracker$ObserverWrapper;", "", "Landroidx/room/InvalidationTracker$Observer;", "observer", "", "tableIds", "", "", "tableNames", "<init>", "(Landroidx/room/InvalidationTracker$Observer;[I[Ljava/lang/String;)V", "", "", "invalidatedTablesIds", "", "b", "(Ljava/util/Set;)V", "tables", "c", "([Ljava/lang/String;)V", "a", "Landroidx/room/InvalidationTracker$Observer;", "getObserver$room_runtime_release", "()Landroidx/room/InvalidationTracker$Observer;", "[I", "()[I", "[Ljava/lang/String;", "d", "Ljava/util/Set;", "singleTableSet", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class ObserverWrapper {

        /* renamed from: a  reason: collision with root package name */
        public final Observer f1738a;
        public final int[] b;
        public final String[] c;
        public final Set d;

        public ObserverWrapper(Observer observer, int[] iArr, String[] strArr) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            Intrinsics.checkNotNullParameter(iArr, "tableIds");
            Intrinsics.checkNotNullParameter(strArr, "tableNames");
            this.f1738a = observer;
            this.b = iArr;
            this.c = strArr;
            this.d = (strArr.length == 0) ^ true ? SetsKt.setOf(strArr[0]) : SetsKt.emptySet();
            if (iArr.length != strArr.length) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }

        public final int[] a() {
            return this.b;
        }

        public final void b(Set set) {
            Set set2;
            Intrinsics.checkNotNullParameter(set, "invalidatedTablesIds");
            int[] iArr = this.b;
            int length = iArr.length;
            if (length != 0) {
                int i = 0;
                if (length != 1) {
                    Set createSetBuilder = SetsKt.createSetBuilder();
                    int[] iArr2 = this.b;
                    int length2 = iArr2.length;
                    int i2 = 0;
                    while (i < length2) {
                        int i3 = i2 + 1;
                        if (set.contains(Integer.valueOf(iArr2[i]))) {
                            createSetBuilder.add(this.c[i2]);
                        }
                        i++;
                        i2 = i3;
                    }
                    set2 = SetsKt.build(createSetBuilder);
                } else {
                    set2 = set.contains(Integer.valueOf(iArr[0])) ? this.d : SetsKt.emptySet();
                }
            } else {
                set2 = SetsKt.emptySet();
            }
            if (!set2.isEmpty()) {
                this.f1738a.c(set2);
            }
        }

        public final void c(String[] strArr) {
            Set set;
            Intrinsics.checkNotNullParameter(strArr, "tables");
            int length = this.c.length;
            if (length != 0) {
                if (length == 1) {
                    int length2 = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length2) {
                            set = SetsKt.emptySet();
                            break;
                        } else if (StringsKt.equals(strArr[i], this.c[0], true)) {
                            set = this.d;
                            break;
                        } else {
                            i++;
                        }
                    }
                } else {
                    Set createSetBuilder = SetsKt.createSetBuilder();
                    for (String str : strArr) {
                        for (String str2 : this.c) {
                            if (StringsKt.equals(str2, str, true)) {
                                createSetBuilder.add(str2);
                            }
                        }
                    }
                    set = SetsKt.build(createSetBuilder);
                }
            } else {
                set = SetsKt.emptySet();
            }
            if (!set.isEmpty()) {
                this.f1738a.c(set);
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/room/InvalidationTracker$WeakObserver;", "Landroidx/room/InvalidationTracker$Observer;", "Landroidx/room/InvalidationTracker;", "tracker", "delegate", "<init>", "(Landroidx/room/InvalidationTracker;Landroidx/room/InvalidationTracker$Observer;)V", "", "", "tables", "", "c", "(Ljava/util/Set;)V", "b", "Landroidx/room/InvalidationTracker;", "getTracker", "()Landroidx/room/InvalidationTracker;", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "getDelegateRef", "()Ljava/lang/ref/WeakReference;", "delegateRef", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class WeakObserver extends Observer {
        public final InvalidationTracker b;
        public final WeakReference c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WeakObserver(InvalidationTracker invalidationTracker, Observer observer) {
            super(observer.a());
            Intrinsics.checkNotNullParameter(invalidationTracker, "tracker");
            Intrinsics.checkNotNullParameter(observer, "delegate");
            this.b = invalidationTracker;
            this.c = new WeakReference(observer);
        }

        public void c(Set set) {
            Intrinsics.checkNotNullParameter(set, "tables");
            Observer observer = (Observer) this.c.get();
            if (observer == null) {
                this.b.q(this);
            } else {
                observer.c(set);
            }
        }
    }

    public InvalidationTracker(RoomDatabase roomDatabase, Map map, Map map2, String... strArr) {
        String str;
        Intrinsics.checkNotNullParameter(roomDatabase, "database");
        Intrinsics.checkNotNullParameter(map, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(map2, "viewTables");
        Intrinsics.checkNotNullParameter(strArr, "tableNames");
        this.f1735a = roomDatabase;
        this.b = map;
        this.c = map2;
        this.j = new ObservedTableTracker(strArr.length);
        this.k = new InvalidationLiveDataContainer(roomDatabase);
        this.l = new SafeIterableMap();
        this.n = new Object();
        this.o = new Object();
        this.d = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str2 = strArr[i2];
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String lowerCase = str2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            this.d.put(lowerCase, Integer.valueOf(i2));
            String str3 = (String) this.b.get(strArr[i2]);
            if (str3 != null) {
                Intrinsics.checkNotNullExpressionValue(locale, "US");
                str = str3.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr2[i2] = lowerCase;
        }
        this.e = strArr2;
        for (Map.Entry entry : this.b.entrySet()) {
            Locale locale2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale2, "US");
            String lowerCase2 = ((String) entry.getValue()).toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (this.d.containsKey(lowerCase2)) {
                Intrinsics.checkNotNullExpressionValue(locale2, "US");
                String lowerCase3 = ((String) entry.getKey()).toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                Map map3 = this.d;
                map3.put(lowerCase3, MapsKt.getValue(map3, lowerCase2));
            }
        }
        this.p = new InvalidationTracker$refreshRunnable$1(this);
    }

    public void c(Observer observer) {
        ObserverWrapper observerWrapper;
        Intrinsics.checkNotNullParameter(observer, "observer");
        String[] r2 = r(observer.a());
        ArrayList arrayList = new ArrayList(r2.length);
        int length = r2.length;
        int i2 = 0;
        while (i2 < length) {
            String str = r2[i2];
            Map map = this.d;
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = (Integer) map.get(lowerCase);
            if (num != null) {
                arrayList.add(num);
                i2++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        int[] intArray = CollectionsKt.toIntArray(arrayList);
        ObserverWrapper observerWrapper2 = new ObserverWrapper(observer, intArray, r2);
        synchronized (this.l) {
            observerWrapper = (ObserverWrapper) this.l.f(observer, observerWrapper2);
        }
        if (observerWrapper == null && this.j.b(Arrays.copyOf(intArray, intArray.length))) {
            x();
        }
    }

    public void d(Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        c(new WeakObserver(this, observer));
    }

    public LiveData e(String[] strArr, boolean z, Callable callable) {
        Intrinsics.checkNotNullParameter(strArr, "tableNames");
        Intrinsics.checkNotNullParameter(callable, "computeFunction");
        return this.k.a(z(strArr), z, callable);
    }

    public final boolean f() {
        if (!this.f1735a.isOpenInternal()) {
            return false;
        }
        if (!this.h) {
            this.f1735a.getOpenHelper().I();
        }
        if (this.h) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final SupportSQLiteStatement g() {
        return this.i;
    }

    public final RoomDatabase h() {
        return this.f1735a;
    }

    public final SafeIterableMap i() {
        return this.l;
    }

    public final AtomicBoolean j() {
        return this.g;
    }

    public final Map k() {
        return this.d;
    }

    public final void l(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        synchronized (this.o) {
            if (this.h) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            supportSQLiteDatabase.P("PRAGMA temp_store = MEMORY;");
            supportSQLiteDatabase.P("PRAGMA recursive_triggers='ON';");
            supportSQLiteDatabase.P("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            y(supportSQLiteDatabase);
            this.i = supportSQLiteDatabase.g0("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            this.h = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void m(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "tables");
        synchronized (this.l) {
            try {
                for (Map.Entry entry : this.l) {
                    Intrinsics.checkNotNullExpressionValue(entry, "(observer, wrapper)");
                    ObserverWrapper observerWrapper = (ObserverWrapper) entry.getValue();
                    if (!((Observer) entry.getKey()).b()) {
                        observerWrapper.c(strArr);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } finally {
            }
        }
    }

    public final void n() {
        synchronized (this.o) {
            this.h = false;
            this.j.d();
            SupportSQLiteStatement supportSQLiteStatement = this.i;
            if (supportSQLiteStatement != null) {
                supportSQLiteStatement.close();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void o() {
        if (this.g.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.f;
            if (autoCloser != null) {
                autoCloser.j();
            }
            this.f1735a.getQueryExecutor().execute(this.p);
        }
    }

    public void p() {
        AutoCloser autoCloser = this.f;
        if (autoCloser != null) {
            autoCloser.j();
        }
        x();
        this.p.run();
    }

    public void q(Observer observer) {
        ObserverWrapper observerWrapper;
        Intrinsics.checkNotNullParameter(observer, "observer");
        synchronized (this.l) {
            observerWrapper = (ObserverWrapper) this.l.h(observer);
        }
        if (observerWrapper != null) {
            ObservedTableTracker observedTableTracker = this.j;
            int[] a2 = observerWrapper.a();
            if (observedTableTracker.c(Arrays.copyOf(a2, a2.length))) {
                x();
            }
        }
    }

    public final String[] r(String[] strArr) {
        Set createSetBuilder = SetsKt.createSetBuilder();
        for (String str : strArr) {
            Map map = this.c;
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map map2 = this.c;
                Intrinsics.checkNotNullExpressionValue(locale, "US");
                String lowerCase2 = str.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Object obj = map2.get(lowerCase2);
                Intrinsics.checkNotNull(obj);
                createSetBuilder.addAll((Collection) obj);
            } else {
                createSetBuilder.add(str);
            }
        }
        return (String[]) SetsKt.build(createSetBuilder).toArray(new String[0]);
    }

    public final void s(AutoCloser autoCloser) {
        Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
        this.f = autoCloser;
        autoCloser.m(new c(this));
    }

    public final void t(Context context, String str, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(intent, "serviceIntent");
        this.m = new MultiInstanceInvalidationClient(context, str, intent, this, this.f1735a.getQueryExecutor());
    }

    public final void u(SupportSQLiteDatabase supportSQLiteDatabase, int i2) {
        supportSQLiteDatabase.P("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i2 + ", 0)");
        String str = this.e[i2];
        for (String str2 : r) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + q.b(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE " + "room_table_modification_log" + " SET " + "invalidated" + " = 1" + " WHERE " + "table_id" + " = " + i2 + " AND " + "invalidated" + " = 0" + "; END";
            Intrinsics.checkNotNullExpressionValue(str3, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.P(str3);
        }
    }

    public final void v() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.m;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.o();
        }
        this.m = null;
    }

    public final void w(SupportSQLiteDatabase supportSQLiteDatabase, int i2) {
        String str = this.e[i2];
        for (String str2 : r) {
            String str3 = "DROP TRIGGER IF EXISTS " + q.b(str, str2);
            Intrinsics.checkNotNullExpressionValue(str3, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.P(str3);
        }
    }

    public final void x() {
        if (this.f1735a.isOpenInternal()) {
            y(this.f1735a.getOpenHelper().I());
        }
    }

    public final void y(SupportSQLiteDatabase supportSQLiteDatabase) {
        Lock closeLock$room_runtime_release;
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        if (!supportSQLiteDatabase.s0()) {
            try {
                closeLock$room_runtime_release = this.f1735a.getCloseLock$room_runtime_release();
                closeLock$room_runtime_release.lock();
                synchronized (this.n) {
                    int[] a2 = this.j.a();
                    if (a2 == null) {
                        closeLock$room_runtime_release.unlock();
                        return;
                    }
                    q.a(supportSQLiteDatabase);
                    try {
                        int length = a2.length;
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < length) {
                            int i4 = a2[i2];
                            int i5 = i3 + 1;
                            if (i4 == 1) {
                                u(supportSQLiteDatabase, i3);
                            } else if (i4 == 2) {
                                w(supportSQLiteDatabase, i3);
                            }
                            i2++;
                            i3 = i5;
                        }
                        supportSQLiteDatabase.V();
                        supportSQLiteDatabase.Z();
                        Unit unit = Unit.INSTANCE;
                        closeLock$room_runtime_release.unlock();
                    } finally {
                        supportSQLiteDatabase.Z();
                    }
                }
            } catch (IllegalStateException e2) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
            } catch (SQLiteException e3) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e3);
            } catch (Throwable th) {
                closeLock$room_runtime_release.unlock();
                throw th;
            }
        }
    }

    public final String[] z(String[] strArr) {
        String[] r2 = r(strArr);
        int length = r2.length;
        int i2 = 0;
        while (i2 < length) {
            String str = r2[i2];
            Map map = this.d;
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                i2++;
            } else {
                throw new IllegalArgumentException(("There is no table with name " + str).toString());
            }
        }
        return r2;
    }
}
