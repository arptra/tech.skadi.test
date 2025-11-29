package androidx.room.paging;

import androidx.paging.PagingSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u00020\u0005H@"}, d2 = {"<anonymous>", "Landroidx/paging/PagingSource$LoadResult;", "", "Value", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.paging.LimitOffsetPagingSource$load$2", f = "LimitOffsetPagingSource.kt", i = {}, l = {76, 78}, m = "invokeSuspend", n = {}, s = {})
public final class LimitOffsetPagingSource$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PagingSource.LoadResult<Integer, Object>>, Object> {
    final /* synthetic */ PagingSource.LoadParams<Integer> $params;
    int label;
    final /* synthetic */ LimitOffsetPagingSource<Object> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LimitOffsetPagingSource$load$2(LimitOffsetPagingSource<Object> limitOffsetPagingSource, PagingSource.LoadParams<Integer> loadParams, Continuation<? super LimitOffsetPagingSource$load$2> continuation) {
        super(2, continuation);
        this.this$0 = limitOffsetPagingSource;
        this.$params = loadParams;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LimitOffsetPagingSource$load$2(this.this$0, this.$params, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.e.d(this.this$0.c);
            int i2 = this.this$0.o().get();
            if (i2 == -1) {
                LimitOffsetPagingSource<Object> limitOffsetPagingSource = this.this$0;
                PagingSource.LoadParams<Integer> loadParams = this.$params;
                this.label = 1;
                obj = limitOffsetPagingSource.q(loadParams, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                LimitOffsetPagingSource<Object> limitOffsetPagingSource2 = this.this$0;
                PagingSource.LoadParams<Integer> loadParams2 = this.$params;
                this.label = 2;
                obj = limitOffsetPagingSource2.s(loadParams2, i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (PagingSource.LoadResult) obj;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            try {
                ResultKt.throwOnFailure(obj);
                return (PagingSource.LoadResult) obj;
            } catch (Exception e) {
                return new PagingSource.LoadResult.Error(e);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (PagingSource.LoadResult) obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super PagingSource.LoadResult<Integer, Object>> continuation) {
        return ((LimitOffsetPagingSource$load$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
