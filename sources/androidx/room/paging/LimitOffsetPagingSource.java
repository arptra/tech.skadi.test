package androidx.room.paging;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.room.CoroutinesRoomKt;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.util.RoomPagingUtilKt;
import androidx.room.paging.util.ThreadSafeInvalidationObserver;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003J-\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000b\u001a\u00020\nH%¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\tJ5\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\u0006\u0010\u0014\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010$\u001a\u00020\u001f8\u0000X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010*\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Landroidx/room/paging/LimitOffsetPagingSource;", "", "Value", "Landroidx/paging/PagingSource;", "", "Landroidx/paging/PagingSource$LoadParams;", "params", "Landroidx/paging/PagingSource$LoadResult;", "f", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/database/Cursor;", "cursor", "", "n", "(Landroid/database/Cursor;)Ljava/util/List;", "Landroidx/paging/PagingState;", "state", "p", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "q", "tempCount", "s", "(Landroidx/paging/PagingSource$LoadParams;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/room/RoomSQLiteQuery;", "b", "Landroidx/room/RoomSQLiteQuery;", "sourceQuery", "Landroidx/room/RoomDatabase;", "c", "Landroidx/room/RoomDatabase;", "db", "Ljava/util/concurrent/atomic/AtomicInteger;", "d", "Ljava/util/concurrent/atomic/AtomicInteger;", "o", "()Ljava/util/concurrent/atomic/AtomicInteger;", "itemCount", "Landroidx/room/paging/util/ThreadSafeInvalidationObserver;", "e", "Landroidx/room/paging/util/ThreadSafeInvalidationObserver;", "observer", "", "()Z", "jumpingSupported", "room-paging_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo
public abstract class LimitOffsetPagingSource<Value> extends PagingSource<Integer, Value> {
    public final RoomSQLiteQuery b;
    public final RoomDatabase c;
    public final AtomicInteger d;
    public final ThreadSafeInvalidationObserver e;

    public boolean b() {
        return true;
    }

    public Object f(PagingSource.LoadParams loadParams, Continuation continuation) {
        return BuildersKt.g(CoroutinesRoomKt.a(this.c), new LimitOffsetPagingSource$load$2(this, loadParams, (Continuation<? super LimitOffsetPagingSource$load$2>) null), continuation);
    }

    public abstract List n(Cursor cursor);

    public final AtomicInteger o() {
        return this.d;
    }

    /* renamed from: p */
    public Integer d(PagingState pagingState) {
        Intrinsics.checkNotNullParameter(pagingState, "state");
        return RoomPagingUtilKt.a(pagingState);
    }

    public final Object q(PagingSource.LoadParams loadParams, Continuation continuation) {
        return RoomDatabaseKt.d(this.c, new LimitOffsetPagingSource$initialLoad$2(this, loadParams, (Continuation<? super LimitOffsetPagingSource$initialLoad$2>) null), continuation);
    }

    public final Object s(PagingSource.LoadParams loadParams, int i, Continuation continuation) {
        PagingSource.LoadResult f = RoomPagingUtilKt.f(loadParams, this.b, this.c, i, (CancellationSignal) null, new LimitOffsetPagingSource$nonInitialLoad$loadResult$1(this), 16, (Object) null);
        this.c.getInvalidationTracker().p();
        if (!a()) {
            return f;
        }
        PagingSource.LoadResult.Invalid b2 = RoomPagingUtilKt.b();
        Intrinsics.checkNotNull(b2, "null cannot be cast to non-null type androidx.paging.PagingSource.LoadResult.Invalid<kotlin.Int, Value of androidx.room.paging.LimitOffsetPagingSource>");
        return b2;
    }
}
