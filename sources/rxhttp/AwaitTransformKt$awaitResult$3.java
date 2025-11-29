package rxhttp;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rxhttp.wrapper.coroutines.Await;

@SourceDebugExtension({"SMAP\nAwaitTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AwaitTransform.kt\nrxhttp/AwaitTransformKt$awaitResult$3\n*L\n1#1,243:1\n*E\n"})
@Metadata(k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "rxhttp.AwaitTransformKt", f = "AwaitTransform.kt", i = {0}, l = {244}, m = "awaitResult", n = {"onSuccess"}, s = {"L$0"})
public final class AwaitTransformKt$awaitResult$3<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public AwaitTransformKt$awaitResult$3(Continuation<? super AwaitTransformKt$awaitResult$3> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object d = AwaitTransformKt.d((Await) null, (Function1) null, this);
        return d == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? d : Result.m19boximpl(d);
    }
}
