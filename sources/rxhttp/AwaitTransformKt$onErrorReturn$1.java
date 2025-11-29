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

@SourceDebugExtension({"SMAP\nAwaitTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AwaitTransform.kt\nrxhttp/AwaitTransformKt$onErrorReturn$1\n*L\n1#1,243:1\n*E\n"})
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H@"}, d2 = {"<anonymous>", "T"}, k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "rxhttp.AwaitTransformKt$onErrorReturn$1", f = "AwaitTransform.kt", i = {}, l = {150, 152}, m = "invokeSuspend", n = {}, s = {})
public final class AwaitTransformKt$onErrorReturn$1 extends SuspendLambda implements Function1<Continuation<Object>, Object> {
    final /* synthetic */ Function2<Throwable, Continuation<Object>, Object> $map;
    final /* synthetic */ Await<Object> $this_onErrorReturn;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitTransformKt$onErrorReturn$1(Await<Object> await, Function2<? super Throwable, ? super Continuation<Object>, ? extends Object> function2, Continuation<? super AwaitTransformKt$onErrorReturn$1> continuation) {
        super(1, continuation);
        this.$this_onErrorReturn = await;
        this.$map = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new AwaitTransformKt$onErrorReturn$1(this.$this_onErrorReturn, this.$map, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Await<Object> await = this.$this_onErrorReturn;
            this.label = 1;
            obj = await.c(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Function2<Throwable, Continuation<Object>, Object> function2 = this.$map;
                this.label = 2;
                obj = function2.invoke(th, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        try {
            Await<Object> await = this.$this_onErrorReturn;
            InlineMarker.mark(0);
            Object c = await.c(this);
            InlineMarker.mark(1);
            return c;
        } catch (Throwable th) {
            return this.$map.invoke(th, this);
        }
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<Object> continuation) {
        return ((AwaitTransformKt$onErrorReturn$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
