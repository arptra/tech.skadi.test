package androidx.room;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import com.honey.account.c0.u;
import com.honey.account.c0.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B?\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t\u0012\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010'\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010-\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u00100\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u0010,R\u0017\u00103\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b1\u0010*\u001a\u0004\b2\u0010,R\u0017\u00109\u001a\u0002048\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0017\u0010;\u001a\u0002048\u0006¢\u0006\f\n\u0004\b:\u00106\u001a\u0004\b#\u00108R\u0011\u0010>\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\b)\u0010=¨\u0006?"}, d2 = {"Landroidx/room/RoomTrackingLiveData;", "T", "Landroidx/lifecycle/LiveData;", "Landroidx/room/RoomDatabase;", "database", "Landroidx/room/InvalidationLiveDataContainer;", "container", "", "inTransaction", "Ljava/util/concurrent/Callable;", "computeFunction", "", "", "tableNames", "<init>", "(Landroidx/room/RoomDatabase;Landroidx/room/InvalidationLiveDataContainer;ZLjava/util/concurrent/Callable;[Ljava/lang/String;)V", "", "onActive", "()V", "onInactive", "a", "Landroidx/room/RoomDatabase;", "getDatabase", "()Landroidx/room/RoomDatabase;", "b", "Landroidx/room/InvalidationLiveDataContainer;", "c", "Z", "getInTransaction", "()Z", "d", "Ljava/util/concurrent/Callable;", "getComputeFunction", "()Ljava/util/concurrent/Callable;", "Landroidx/room/InvalidationTracker$Observer;", "e", "Landroidx/room/InvalidationTracker$Observer;", "getObserver", "()Landroidx/room/InvalidationTracker$Observer;", "observer", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInvalid", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "invalid", "g", "getComputing", "computing", "h", "getRegisteredObserver", "registeredObserver", "Ljava/lang/Runnable;", "i", "Ljava/lang/Runnable;", "getRefreshRunnable", "()Ljava/lang/Runnable;", "refreshRunnable", "j", "invalidationRunnable", "Ljava/util/concurrent/Executor;", "()Ljava/util/concurrent/Executor;", "queryExecutor", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
@SuppressLint({"RestrictedApi"})
public final class RoomTrackingLiveData<T> extends LiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f1758a;
    public final InvalidationLiveDataContainer b;
    public final boolean c;
    public final Callable d;
    public final InvalidationTracker.Observer e;
    public final AtomicBoolean f = new AtomicBoolean(true);
    public final AtomicBoolean g = new AtomicBoolean(false);
    public final AtomicBoolean h = new AtomicBoolean(false);
    public final Runnable i = new u(this);
    public final Runnable j = new v(this);

    public RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z, Callable callable, String[] strArr) {
        Intrinsics.checkNotNullParameter(roomDatabase, "database");
        Intrinsics.checkNotNullParameter(invalidationLiveDataContainer, "container");
        Intrinsics.checkNotNullParameter(callable, "computeFunction");
        Intrinsics.checkNotNullParameter(strArr, "tableNames");
        this.f1758a = roomDatabase;
        this.b = invalidationLiveDataContainer;
        this.c = z;
        this.d = callable;
        this.e = new RoomTrackingLiveData$observer$1(strArr, this);
    }

    public static final void g(RoomTrackingLiveData roomTrackingLiveData) {
        Intrinsics.checkNotNullParameter(roomTrackingLiveData, "this$0");
        boolean hasActiveObservers = roomTrackingLiveData.hasActiveObservers();
        if (roomTrackingLiveData.f.compareAndSet(false, true) && hasActiveObservers) {
            roomTrackingLiveData.f().execute(roomTrackingLiveData.i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void h(androidx.room.RoomTrackingLiveData r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.h
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x001a
            androidx.room.RoomDatabase r0 = r5.f1758a
            androidx.room.InvalidationTracker r0 = r0.getInvalidationTracker()
            androidx.room.InvalidationTracker$Observer r3 = r5.e
            r0.d(r3)
        L_0x001a:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.g
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x0050
            r0 = 0
            r3 = r1
        L_0x0024:
            java.util.concurrent.atomic.AtomicBoolean r4 = r5.f     // Catch:{ all -> 0x0034 }
            boolean r4 = r4.compareAndSet(r2, r1)     // Catch:{ all -> 0x0034 }
            if (r4 == 0) goto L_0x003f
            java.util.concurrent.Callable r0 = r5.d     // Catch:{ Exception -> 0x0036 }
            java.lang.Object r0 = r0.call()     // Catch:{ Exception -> 0x0036 }
            r3 = r2
            goto L_0x0024
        L_0x0034:
            r0 = move-exception
            goto L_0x004a
        L_0x0036:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "Exception while computing database live data."
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0034 }
            throw r2     // Catch:{ all -> 0x0034 }
        L_0x003f:
            if (r3 == 0) goto L_0x0044
            r5.postValue(r0)     // Catch:{ all -> 0x0034 }
        L_0x0044:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.g
            r0.set(r1)
            goto L_0x0051
        L_0x004a:
            java.util.concurrent.atomic.AtomicBoolean r5 = r5.g
            r5.set(r1)
            throw r0
        L_0x0050:
            r3 = r1
        L_0x0051:
            if (r3 == 0) goto L_0x005b
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.f
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x001a
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomTrackingLiveData.h(androidx.room.RoomTrackingLiveData):void");
    }

    public final Runnable e() {
        return this.j;
    }

    public final Executor f() {
        return this.c ? this.f1758a.getTransactionExecutor() : this.f1758a.getQueryExecutor();
    }

    public void onActive() {
        super.onActive();
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.b;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        invalidationLiveDataContainer.b(this);
        f().execute(this.i);
    }

    public void onInactive() {
        super.onInactive();
        InvalidationLiveDataContainer invalidationLiveDataContainer = this.b;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        invalidationLiveDataContainer.c(this);
    }
}
