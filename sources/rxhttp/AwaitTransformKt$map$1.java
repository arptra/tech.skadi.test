package rxhttp;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rxhttp.wrapper.coroutines.Await;

@SourceDebugExtension({"SMAP\nAwaitTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AwaitTransform.kt\nrxhttp/AwaitTransformKt$map$1\n*L\n1#1,243:1\n*E\n"})
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001H@"}, d2 = {"<anonymous>", "R", "T"}, k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "rxhttp.AwaitTransformKt$map$1", f = "AwaitTransform.kt", i = {}, l = {162, 162}, m = "invokeSuspend", n = {}, s = {})
public final class AwaitTransformKt$map$1 extends SuspendLambda implements Function1<Continuation<Object>, Object> {
    final /* synthetic */ Function2<Object, Continuation<Object>, Object> $map;
    final /* synthetic */ Await<Object> $this_map;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitTransformKt$map$1(Function2<Object, ? super Continuation<Object>, ? extends Object> function2, Await<Object> await, Continuation<? super AwaitTransformKt$map$1> continuation) {
        super(1, continuation);
        this.$map = function2;
        this.$this_map = await;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new AwaitTransformKt$map$1(this.$map, this.$this_map, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Function2<Object, Continuation<Object>, Object> function2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            function2 = this.$map;
            Await<Object> await = this.$this_map;
            this.L$0 = function2;
            this.label = 1;
            obj = await.c(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            function2 = (Function2) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.L$0 = null;
        this.label = 2;
        obj = function2.invoke(obj, this);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        Function2<Object, Continuation<Object>, Object> function2 = this.$map;
        Await<Object> await = this.$this_map;
        InlineMarker.mark(0);
        Object c = await.c(this);
        InlineMarker.mark(1);
        return function2.invoke(c, this);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<Object> continuation) {
        return ((AwaitTransformKt$map$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
