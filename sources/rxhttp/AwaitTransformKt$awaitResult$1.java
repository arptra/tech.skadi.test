package rxhttp;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rxhttp.wrapper.coroutines.Await;

@SourceDebugExtension({"SMAP\nAwaitTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AwaitTransform.kt\nrxhttp/AwaitTransformKt$awaitResult$1\n*L\n1#1,243:1\n*E\n"})
@Metadata(k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "rxhttp.AwaitTransformKt", f = "AwaitTransform.kt", i = {}, l = {201}, m = "awaitResult", n = {}, s = {})
public final class AwaitTransformKt$awaitResult$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public AwaitTransformKt$awaitResult$1(Continuation<? super AwaitTransformKt$awaitResult$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object c = AwaitTransformKt.c((Await) null, this);
        return c == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? c : Result.m19boximpl(c);
    }
}
