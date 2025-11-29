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

@SourceDebugExtension({"SMAP\nAwaitTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AwaitTransform.kt\nrxhttp/AwaitTransformKt$onEach$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,243:1\n1#2:244\n*E\n"})
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H@"}, d2 = {"<anonymous>", "T"}, k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "rxhttp.AwaitTransformKt$onEach$1", f = "AwaitTransform.kt", i = {}, l = {168, 168}, m = "invokeSuspend", n = {}, s = {})
public final class AwaitTransformKt$onEach$1 extends SuspendLambda implements Function1<Continuation<Object>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Unit>, Object> $each;
    final /* synthetic */ Await<Object> $this_onEach;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitTransformKt$onEach$1(Await<Object> await, Function2<Object, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AwaitTransformKt$onEach$1> continuation) {
        super(1, continuation);
        this.$this_onEach = await;
        this.$each = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new AwaitTransformKt$onEach$1(this.$this_onEach, this.$each, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Await<Object> await = this.$this_onEach;
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
        Function2<Object, Continuation<? super Unit>, Object> function2 = this.$each;
        this.L$0 = obj;
        this.label = 2;
        return function2.invoke(obj, this) == coroutine_suspended ? coroutine_suspended : obj;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        Await<Object> await = this.$this_onEach;
        InlineMarker.mark(0);
        Object c = await.c(this);
        InlineMarker.mark(1);
        Function2<Object, Continuation<? super Unit>, Object> function2 = this.$each;
        InlineMarker.mark(3);
        function2.invoke(c, null);
        Unit unit = Unit.INSTANCE;
        return c;
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<Object> continuation) {
        return ((AwaitTransformKt$onEach$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
