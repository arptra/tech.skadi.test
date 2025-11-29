package rxhttp;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rxhttp.wrapper.coroutines.Await;

@SourceDebugExtension({"SMAP\nAwaitTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AwaitTransform.kt\nrxhttp/AwaitTransformKt$delay$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,243:1\n1#2:244\n*E\n"})
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H@"}, d2 = {"<anonymous>", "T"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "rxhttp.AwaitTransformKt$delay$1", f = "AwaitTransform.kt", i = {}, l = {177, 177}, m = "invokeSuspend", n = {}, s = {})
final class AwaitTransformKt$delay$1 extends SuspendLambda implements Function1<Continuation<Object>, Object> {
    final /* synthetic */ Await<Object> $this_delay;
    final /* synthetic */ long $timeMillis;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitTransformKt$delay$1(Await<Object> await, long j, Continuation<? super AwaitTransformKt$delay$1> continuation) {
        super(1, continuation);
        this.$this_delay = await;
        this.$timeMillis = j;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new AwaitTransformKt$delay$1(this.$this_delay, this.$timeMillis, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Await<Object> await = this.$this_delay;
            this.label = 1;
            obj = await.c(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            Object obj2 = this.L$0;
            ResultKt.throwOnFailure(obj);
            return obj2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long j = this.$timeMillis;
        this.L$0 = obj;
        this.label = 2;
        return DelayKt.b(j, this) == coroutine_suspended ? coroutine_suspended : obj;
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<Object> continuation) {
        return ((AwaitTransformKt$delay$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
