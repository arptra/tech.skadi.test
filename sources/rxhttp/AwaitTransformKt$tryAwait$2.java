package rxhttp;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rxhttp.wrapper.coroutines.Await;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "rxhttp.AwaitTransformKt", f = "AwaitTransform.kt", i = {0}, l = {223}, m = "tryAwait", n = {"onCatch"}, s = {"L$0"})
public final class AwaitTransformKt$tryAwait$2<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public AwaitTransformKt$tryAwait$2(Continuation<? super AwaitTransformKt$tryAwait$2> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwaitTransformKt.h((Await) null, (Function1) null, this);
    }
}
