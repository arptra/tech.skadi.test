package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0014X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/BlockingEventLoop;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Thread;", "thread", "<init>", "(Ljava/lang/Thread;)V", "g", "Ljava/lang/Thread;", "G0", "()Ljava/lang/Thread;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
public final class BlockingEventLoop extends EventLoopImplBase {
    public final Thread g;

    public BlockingEventLoop(Thread thread) {
        this.g = thread;
    }

    public Thread G0() {
        return this.g;
    }
}
