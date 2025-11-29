package androidx.room.paging;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.paging.PagingSource;
import androidx.room.paging.util.RoomPagingUtilKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource$LoadResult;", "", "Value", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.paging.LimitOffsetPagingSource$initialLoad$2", f = "LimitOffsetPagingSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LimitOffsetPagingSource$initialLoad$2 extends SuspendLambda implements Function1<Continuation<? super PagingSource.LoadResult<Integer, Value>>, Object> {
    final /* synthetic */ PagingSource.LoadParams<Integer> $params;
    int label;
    final /* synthetic */ LimitOffsetPagingSource<Value> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LimitOffsetPagingSource$initialLoad$2(LimitOffsetPagingSource<Value> limitOffsetPagingSource, PagingSource.LoadParams<Integer> loadParams, Continuation<? super LimitOffsetPagingSource$initialLoad$2> continuation) {
        super(1, continuation);
        this.this$0 = limitOffsetPagingSource;
        this.$params = loadParams;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new LimitOffsetPagingSource$initialLoad$2(this.this$0, this.$params, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int g = RoomPagingUtilKt.g(this.this$0.b, this.this$0.c);
            this.this$0.o().set(g);
            return RoomPagingUtilKt.f(this.$params, this.this$0.b, this.this$0.c, g, (CancellationSignal) null, new Function1<Cursor, List<? extends Value>>(this.this$0) {
                @NotNull
                public final List<Value> invoke(@NotNull Cursor cursor) {
                    Intrinsics.checkNotNullParameter(cursor, "p0");
                    return ((LimitOffsetPagingSource) this.receiver).n(cursor);
                }
            }, 16, (Object) null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super PagingSource.LoadResult<Integer, Value>> continuation) {
        return ((LimitOffsetPagingSource$initialLoad$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
