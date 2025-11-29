package rxhttp;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "rxhttp.AwaitTransformKt$retry$2", f = "AwaitTransform.kt", i = {0, 1, 1, 1, 2}, l = {42, 48, 50, 51}, m = "await", n = {"this", "this", "e", "remaining", "this"}, s = {"L$0", "L$0", "L$1", "J$0", "L$0"})
public final class AwaitTransformKt$retry$2$await$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AwaitTransformKt$retry$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitTransformKt$retry$2$await$1(AwaitTransformKt$retry$2 awaitTransformKt$retry$2, Continuation continuation) {
        super(continuation);
        this.this$0 = awaitTransformKt$retry$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
