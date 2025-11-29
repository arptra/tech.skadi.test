package androidx.room.paging.util;

import androidx.annotation.RestrictTo;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/room/paging/util/ThreadSafeInvalidationObserver;", "Landroidx/room/InvalidationTracker$Observer;", "", "", "tables", "", "c", "(Ljava/util/Set;)V", "Landroidx/room/RoomDatabase;", "db", "d", "(Landroidx/room/RoomDatabase;)V", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", "getOnInvalidated", "()Lkotlin/jvm/functions/Function0;", "onInvalidated", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "registered", "room-paging_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo
public final class ThreadSafeInvalidationObserver extends InvalidationTracker.Observer {
    public final Function0 b;
    public final AtomicBoolean c;

    public void c(Set set) {
        Intrinsics.checkNotNullParameter(set, "tables");
        this.b.invoke();
    }

    public final void d(RoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(roomDatabase, "db");
        if (this.c.compareAndSet(false, true)) {
            roomDatabase.getInvalidationTracker().d(this);
        }
    }
}
