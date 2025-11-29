package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\" \u0010\n\u001a\u00020\u00008\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0001\u0010\u0007\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0002¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/Delay;", "b", "()Lkotlinx/coroutines/Delay;", "", "a", "Z", "defaultMainDelayOptIn", "Lkotlinx/coroutines/Delay;", "getDefaultDelay$annotations", "()V", "DefaultDelay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0})
public final class DefaultExecutorKt {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3722a = SystemPropsKt.f("kotlinx.coroutines.main.delay", false);
    public static final Delay b = b();

    public static final Delay a() {
        return b;
    }

    public static final Delay b() {
        if (!f3722a) {
            return DefaultExecutor.g;
        }
        MainCoroutineDispatcher c = Dispatchers.c();
        return (MainDispatchersKt.c(c) || !(c instanceof Delay)) ? DefaultExecutor.g : (Delay) c;
    }
}
