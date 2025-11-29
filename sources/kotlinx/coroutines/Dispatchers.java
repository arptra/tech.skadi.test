package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR \u0010\u000e\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\f\u0010\bR \u0010\u0010\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0005\u0010\bR\u001a\u0010\u0014\u001a\u00020\u00118FX\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u000b\u0010\u0012¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/Dispatchers;", "", "<init>", "()V", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault$annotations", "Default", "c", "d", "getUnconfined$annotations", "Unconfined", "getIO$annotations", "IO", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain$annotations", "Main", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
public final class Dispatchers {

    /* renamed from: a  reason: collision with root package name */
    public static final Dispatchers f3724a = new Dispatchers();
    public static final CoroutineDispatcher b = DefaultScheduler.g;
    public static final CoroutineDispatcher c = Unconfined.f3746a;
    public static final CoroutineDispatcher d = DefaultIoScheduler.b;

    public static final CoroutineDispatcher a() {
        return b;
    }

    public static final CoroutineDispatcher b() {
        return d;
    }

    public static final MainCoroutineDispatcher c() {
        return MainDispatcherLoader.b;
    }

    public static final CoroutineDispatcher d() {
        return c;
    }
}
