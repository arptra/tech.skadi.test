package androidx.room;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.InvalidationTracker;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"androidx/room/RoomTrackingLiveData$observer$1", "Landroidx/room/InvalidationTracker$Observer;", "", "", "tables", "", "c", "(Ljava/util/Set;)V", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class RoomTrackingLiveData$observer$1 extends InvalidationTracker.Observer {
    public final /* synthetic */ RoomTrackingLiveData b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomTrackingLiveData$observer$1(String[] strArr, RoomTrackingLiveData roomTrackingLiveData) {
        super(strArr);
        this.b = roomTrackingLiveData;
    }

    public void c(Set set) {
        Intrinsics.checkNotNullParameter(set, "tables");
        ArchTaskExecutor.h().b(this.b.e());
    }
}
