package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3749a;
    public final /* synthetic */ String b;
    public final /* synthetic */ AtomicInteger c;

    public /* synthetic */ a(int i, String str, AtomicInteger atomicInteger) {
        this.f3749a = i;
        this.b = str;
        this.c = atomicInteger;
    }

    public final Thread newThread(Runnable runnable) {
        return ThreadPoolDispatcherKt__ThreadPoolDispatcherKt.c(this.f3749a, this.b, this.c, runnable);
    }
}
