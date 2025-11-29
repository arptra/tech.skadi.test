package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.MaybeSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx3.RxAwaitKt", f = "RxAwait.kt", i = {0}, l = {109}, m = "awaitOrDefault", n = {"default"}, s = {"L$0"})
public final class RxAwaitKt$awaitOrDefault$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public RxAwaitKt$awaitOrDefault$1(Continuation<? super RxAwaitKt$awaitOrDefault$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RxAwaitKt.f((MaybeSource) null, (Object) null, this);
    }
}
