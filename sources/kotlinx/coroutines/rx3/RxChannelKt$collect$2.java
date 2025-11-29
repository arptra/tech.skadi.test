package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.ObservableSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nRxChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxChannel.kt\nkotlinx/coroutines/rx3/RxChannelKt$collect$2\n*L\n1#1,91:1\n*E\n"})
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.rx3.RxChannelKt", f = "RxChannel.kt", i = {0, 0}, l = {99}, m = "collect", n = {"action", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
public final class RxChannelKt$collect$2<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public RxChannelKt$collect$2(Continuation<? super RxChannelKt$collect$2> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RxChannelKt.b((ObservableSource) null, (Function1) null, this);
    }
}
