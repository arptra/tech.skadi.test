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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rxhttp.wrapper.coroutines.Await;

@SourceDebugExtension({"SMAP\nAwaitTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AwaitTransform.kt\nrxhttp/AwaitTransformKt$onErrorReturn$1\n+ 2 AwaitTransform.kt\nrxhttp/AwaitTransformKt\n*L\n1#1,243:1\n141#2:244\n*E\n"})
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H@¨\u0006\u0002"}, d2 = {"<anonymous>", "T", "rxhttp/AwaitTransformKt$onErrorReturn$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "rxhttp.AwaitTransformKt$onErrorReturnItem$$inlined$onErrorReturn$1", f = "AwaitTransform.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
public final class AwaitTransformKt$onErrorReturnItem$$inlined$onErrorReturn$1 extends SuspendLambda implements Function1<Continuation<Object>, Object> {
    final /* synthetic */ Object $t$inlined;
    final /* synthetic */ Await $this_onErrorReturn;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitTransformKt$onErrorReturnItem$$inlined$onErrorReturn$1(Await await, Continuation continuation, Object obj) {
        super(1, continuation);
        this.$this_onErrorReturn = await;
        this.$t$inlined = obj;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new AwaitTransformKt$onErrorReturnItem$$inlined$onErrorReturn$1(this.$this_onErrorReturn, continuation, this.$t$inlined);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Await await = this.$this_onErrorReturn;
            this.label = 1;
            Object c = await.c(this);
            return c == coroutine_suspended ? coroutine_suspended : c;
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
                return obj;
            } catch (Throwable unused) {
                return this.$t$inlined;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<Object> continuation) {
        return ((AwaitTransformKt$onErrorReturnItem$$inlined$onErrorReturn$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
