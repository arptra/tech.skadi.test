package androidx.room;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.Closeable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$refreshRunnable$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 CursorUtil.kt\nandroidx/room/util/CursorUtil\n*L\n1#1,840:1\n1855#2,2:841\n145#3,7:843\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/InvalidationTracker$refreshRunnable$1\n*L\n399#1:841,2\n408#1:843,7\n*E\n"})
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"androidx/room/InvalidationTracker$refreshRunnable$1", "Ljava/lang/Runnable;", "", "run", "()V", "", "", "a", "()Ljava/util/Set;", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class InvalidationTracker$refreshRunnable$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InvalidationTracker f1739a;

    public InvalidationTracker$refreshRunnable$1(InvalidationTracker invalidationTracker) {
        this.f1739a = invalidationTracker;
    }

    public final Set a() {
        InvalidationTracker invalidationTracker = this.f1739a;
        Set createSetBuilder = SetsKt.createSetBuilder();
        Closeable query$default = RoomDatabase.query$default(invalidationTracker.h(), new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), (CancellationSignal) null, 2, (Object) null);
        try {
            Cursor cursor = (Cursor) query$default;
            while (cursor.moveToNext()) {
                createSetBuilder.add(Integer.valueOf(cursor.getInt(0)));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query$default, (Throwable) null);
            Set build = SetsKt.build(createSetBuilder);
            if (!build.isEmpty()) {
                if (this.f1739a.g() != null) {
                    SupportSQLiteStatement g = this.f1739a.g();
                    if (g != null) {
                        g.k();
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
            return build;
        } catch (Throwable th) {
            CloseableKt.closeFinally(query$default, th);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0080, code lost:
        if (r0 != null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
        r0.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
        if (r0 == null) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bd, code lost:
        if (r0 == null) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c5, code lost:
        if ((!r3.isEmpty()) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c7, code lost:
        r0 = r5.f1739a.i();
        r5 = r5.f1739a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cf, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r5 = r5.i().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00dc, code lost:
        if (r5.hasNext() == false) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00de, code lost:
        ((androidx.room.InvalidationTracker.ObserverWrapper) ((java.util.Map.Entry) r5.next()).getValue()).b(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ee, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f0, code lost:
        r5 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f2, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f5, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            androidx.room.InvalidationTracker r0 = r5.f1739a
            androidx.room.RoomDatabase r0 = r0.h()
            java.util.concurrent.locks.Lock r0 = r0.getCloseLock$room_runtime_release()
            r0.lock()
            r1 = 1
            androidx.room.InvalidationTracker r2 = r5.f1739a     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            boolean r2 = r2.f()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            if (r2 != 0) goto L_0x0025
            r0.unlock()
            androidx.room.InvalidationTracker r5 = r5.f1739a
            androidx.room.AutoCloser r5 = r5.f
            if (r5 == 0) goto L_0x0024
            r5.e()
        L_0x0024:
            return
        L_0x0025:
            androidx.room.InvalidationTracker r2 = r5.f1739a     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            java.util.concurrent.atomic.AtomicBoolean r2 = r2.j()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            r3 = 0
            boolean r2 = r2.compareAndSet(r1, r3)     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            if (r2 != 0) goto L_0x0041
            r0.unlock()
            androidx.room.InvalidationTracker r5 = r5.f1739a
            androidx.room.AutoCloser r5 = r5.f
            if (r5 == 0) goto L_0x0040
            r5.e()
        L_0x0040:
            return
        L_0x0041:
            androidx.room.InvalidationTracker r2 = r5.f1739a     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            androidx.room.RoomDatabase r2 = r2.h()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            boolean r2 = r2.inTransaction()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            if (r2 == 0) goto L_0x005c
            r0.unlock()
            androidx.room.InvalidationTracker r5 = r5.f1739a
            androidx.room.AutoCloser r5 = r5.f
            if (r5 == 0) goto L_0x005b
            r5.e()
        L_0x005b:
            return
        L_0x005c:
            androidx.room.InvalidationTracker r2 = r5.f1739a     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            androidx.room.RoomDatabase r2 = r2.h()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            androidx.sqlite.db.SupportSQLiteOpenHelper r2 = r2.getOpenHelper()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            androidx.sqlite.db.SupportSQLiteDatabase r2 = r2.I()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            r2.m()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            java.util.Set r3 = r5.a()     // Catch:{ all -> 0x008d }
            r2.V()     // Catch:{ all -> 0x008d }
            r2.Z()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.f1739a
            androidx.room.AutoCloser r0 = r0.f
            if (r0 == 0) goto L_0x00c0
        L_0x0082:
            r0.e()
            goto L_0x00c0
        L_0x0086:
            r1 = move-exception
            goto L_0x00f7
        L_0x0089:
            r2 = move-exception
            goto L_0x0092
        L_0x008b:
            r2 = move-exception
            goto L_0x00a9
        L_0x008d:
            r3 = move-exception
            r2.Z()     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
            throw r3     // Catch:{ IllegalStateException -> 0x008b, SQLiteException -> 0x0089 }
        L_0x0092:
            java.lang.String r3 = "ROOM"
            java.lang.String r4 = "Cannot run invalidation tracker. Is the db closed?"
            android.util.Log.e(r3, r4, r2)     // Catch:{ all -> 0x0086 }
            java.util.Set r3 = kotlin.collections.SetsKt.emptySet()     // Catch:{ all -> 0x0086 }
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.f1739a
            androidx.room.AutoCloser r0 = r0.f
            if (r0 == 0) goto L_0x00c0
            goto L_0x0082
        L_0x00a9:
            java.lang.String r3 = "ROOM"
            java.lang.String r4 = "Cannot run invalidation tracker. Is the db closed?"
            android.util.Log.e(r3, r4, r2)     // Catch:{ all -> 0x0086 }
            java.util.Set r3 = kotlin.collections.SetsKt.emptySet()     // Catch:{ all -> 0x0086 }
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.f1739a
            androidx.room.AutoCloser r0 = r0.f
            if (r0 == 0) goto L_0x00c0
            goto L_0x0082
        L_0x00c0:
            boolean r0 = r3.isEmpty()
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x00f6
            androidx.room.InvalidationTracker r0 = r5.f1739a
            androidx.arch.core.internal.SafeIterableMap r0 = r0.i()
            androidx.room.InvalidationTracker r5 = r5.f1739a
            monitor-enter(r0)
            androidx.arch.core.internal.SafeIterableMap r5 = r5.i()     // Catch:{ all -> 0x00ee }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x00ee }
        L_0x00d8:
            boolean r1 = r5.hasNext()     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x00f0
            java.lang.Object r1 = r5.next()     // Catch:{ all -> 0x00ee }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x00ee }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x00ee }
            androidx.room.InvalidationTracker$ObserverWrapper r1 = (androidx.room.InvalidationTracker.ObserverWrapper) r1     // Catch:{ all -> 0x00ee }
            r1.b(r3)     // Catch:{ all -> 0x00ee }
            goto L_0x00d8
        L_0x00ee:
            r5 = move-exception
            goto L_0x00f4
        L_0x00f0:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00ee }
            monitor-exit(r0)
            goto L_0x00f6
        L_0x00f4:
            monitor-exit(r0)
            throw r5
        L_0x00f6:
            return
        L_0x00f7:
            r0.unlock()
            androidx.room.InvalidationTracker r5 = r5.f1739a
            androidx.room.AutoCloser r5 = r5.f
            if (r5 == 0) goto L_0x0105
            r5.e()
        L_0x0105:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker$refreshRunnable$1.run():void");
    }
}
