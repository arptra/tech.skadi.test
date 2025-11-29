package rxhttp;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rxhttp.wrapper.coroutines.Await;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H@"}, d2 = {"<anonymous>", "T"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "rxhttp.AwaitTransformKt$onStart$1", f = "AwaitTransform.kt", i = {}, l = {60, 61}, m = "invokeSuspend", n = {}, s = {})
final class AwaitTransformKt$onStart$1 extends SuspendLambda implements Function1<Continuation<Object>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $action;
    final /* synthetic */ Await<Object> $this_onStart;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitTransformKt$onStart$1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Await<Object> await, Continuation<? super AwaitTransformKt$onStart$1> continuation) {
        super(1, continuation);
        this.$action = function1;
        this.$this_onStart = await;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new AwaitTransformKt$onStart$1(this.$action, this.$this_onStart, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super Unit>, Object> function1 = this.$action;
            this.label = 1;
            if (function1.invoke(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Await<Object> await = this.$this_onStart;
        this.label = 2;
        obj = await.c(this);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<Object> continuation) {
        return ((AwaitTransformKt$onStart$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
