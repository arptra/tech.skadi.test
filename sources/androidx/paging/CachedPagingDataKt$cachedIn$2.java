package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H@"}, d2 = {"<anonymous>", "Landroidx/paging/MulticastedPagingData;", "T", "", "prev", "next"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.CachedPagingDataKt$cachedIn$2", f = "CachedPagingData.kt", i = {0}, l = {104}, m = "invokeSuspend", n = {"next"}, s = {"L$0"})
final class CachedPagingDataKt$cachedIn$2 extends SuspendLambda implements Function3<MulticastedPagingData<Object>, MulticastedPagingData<Object>, Continuation<? super MulticastedPagingData<Object>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public CachedPagingDataKt$cachedIn$2(Continuation<? super CachedPagingDataKt$cachedIn$2> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull MulticastedPagingData<Object> multicastedPagingData, @NotNull MulticastedPagingData<Object> multicastedPagingData2, @Nullable Continuation<? super MulticastedPagingData<Object>> continuation) {
        CachedPagingDataKt$cachedIn$2 cachedPagingDataKt$cachedIn$2 = new CachedPagingDataKt$cachedIn$2(continuation);
        cachedPagingDataKt$cachedIn$2.L$0 = multicastedPagingData;
        cachedPagingDataKt$cachedIn$2.L$1 = multicastedPagingData2;
        return cachedPagingDataKt$cachedIn$2.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MulticastedPagingData multicastedPagingData = (MulticastedPagingData) this.L$1;
            this.L$0 = multicastedPagingData;
            this.label = 1;
            return ((MulticastedPagingData) this.L$0).c(this) == coroutine_suspended ? coroutine_suspended : multicastedPagingData;
        } else if (i == 1) {
            MulticastedPagingData multicastedPagingData2 = (MulticastedPagingData) this.L$0;
            ResultKt.throwOnFailure(obj);
            return multicastedPagingData2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
