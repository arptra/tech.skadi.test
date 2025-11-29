package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.MaybeSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx3.RxAwaitKt", f = "RxAwait.kt", i = {}, l = {63}, m = "awaitSingle", n = {}, s = {})
public final class RxAwaitKt$awaitSingle$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public RxAwaitKt$awaitSingle$1(Continuation<? super RxAwaitKt$awaitSingle$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RxAwaitKt.g((MaybeSource) null, this);
    }
}
