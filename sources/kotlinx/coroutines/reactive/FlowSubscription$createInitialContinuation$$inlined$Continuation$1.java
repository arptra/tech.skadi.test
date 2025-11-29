package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.intrinsics.CancellableKt;

@SourceDebugExtension({"SMAP\nContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Continuation.kt\nkotlin/coroutines/ContinuationKt$Continuation$1\n+ 2 ReactiveFlow.kt\nkotlinx/coroutines/reactive/FlowSubscription\n*L\n1#1,161:1\n204#2,2:162\n*E\n"})
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\nR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b¸\u0006\u0000"}, d2 = {"kotlin/coroutines/ContinuationKt$Continuation$1", "Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlowSubscription$createInitialContinuation$$inlined$Continuation$1 implements Continuation<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f3941a;
    public final /* synthetic */ FlowSubscription b;

    public FlowSubscription$createInitialContinuation$$inlined$Continuation$1(CoroutineContext coroutineContext, FlowSubscription flowSubscription) {
        this.f3941a = coroutineContext;
        this.b = flowSubscription;
    }

    public CoroutineContext getContext() {
        return this.f3941a;
    }

    public void resumeWith(Object obj) {
        CancellableKt.c(new FlowSubscription$createInitialContinuation$1$1(this.b), this.b);
    }
}
