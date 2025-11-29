package rxhttp;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rxhttp.wrapper.coroutines.Await;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H@"}, d2 = {"<anonymous>", "T"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "rxhttp.AwaitTransformKt$startDelay$1", f = "AwaitTransform.kt", i = {}, l = {186, 187}, m = "invokeSuspend", n = {}, s = {})
final class AwaitTransformKt$startDelay$1 extends SuspendLambda implements Function1<Continuation<Object>, Object> {
    final /* synthetic */ Await<Object> $this_startDelay;
    final /* synthetic */ long $timeMillis;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitTransformKt$startDelay$1(long j, Await<Object> await, Continuation<? super AwaitTransformKt$startDelay$1> continuation) {
        super(1, continuation);
        this.$timeMillis = j;
        this.$this_startDelay = await;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new AwaitTransformKt$startDelay$1(this.$timeMillis, this.$this_startDelay, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j = this.$timeMillis;
            this.label = 1;
            if (DelayKt.b(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Await<Object> await = this.$this_startDelay;
        this.label = 2;
        obj = await.c(this);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<Object> continuation) {
        return ((AwaitTransformKt$startDelay$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
