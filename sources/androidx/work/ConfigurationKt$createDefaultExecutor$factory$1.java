package androidx.work;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"androidx/work/ConfigurationKt$createDefaultExecutor$factory$1", "Ljava/util/concurrent/ThreadFactory;", "Ljava/lang/Runnable;", "runnable", "Ljava/lang/Thread;", "newThread", "(Ljava/lang/Runnable;)Ljava/lang/Thread;", "Ljava/util/concurrent/atomic/AtomicInteger;", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadCount", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class ConfigurationKt$createDefaultExecutor$factory$1 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f2050a = new AtomicInteger(0);
    public final /* synthetic */ boolean b;

    public ConfigurationKt$createDefaultExecutor$factory$1(boolean z) {
        this.b = z;
    }

    public Thread newThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        String str = this.b ? "WM.task-" : "androidx.work-";
        return new Thread(runnable, str + this.f2050a.incrementAndGet());
    }
}
