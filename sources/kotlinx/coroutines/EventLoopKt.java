package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.LongCompanionObject;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u000f\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/EventLoop;", "a", "()Lkotlinx/coroutines/EventLoop;", "", "b", "()J", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0})
public final class EventLoopKt {
    public static final EventLoop a() {
        return new BlockingEventLoop(Thread.currentThread());
    }

    public static final long b() {
        EventLoop a2 = ThreadLocalEventLoop.f3744a.a();
        return a2 != null ? a2.D0() : LongCompanionObject.MAX_VALUE;
    }
}
