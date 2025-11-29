package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"androidx/room/RoomDatabaseKt$invalidationTrackerFlow$1$observer$1", "Landroidx/room/InvalidationTracker$Observer;", "", "", "tables", "", "c", "(Ljava/util/Set;)V", "room-ktx_release"}, k = 1, mv = {1, 8, 0})
public final class RoomDatabaseKt$invalidationTrackerFlow$1$observer$1 extends InvalidationTracker.Observer {
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ ProducerScope c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomDatabaseKt$invalidationTrackerFlow$1$observer$1(String[] strArr, AtomicBoolean atomicBoolean, ProducerScope producerScope) {
        super(strArr);
        this.b = atomicBoolean;
        this.c = producerScope;
    }

    public void c(Set set) {
        if (!this.b.get()) {
            this.c.q(set);
        }
    }
}
