package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n*L\n1#1,18:1\n57#2,2:19\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class OnTimeout$register$$inlined$Runnable$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SelectInstance f3968a;
    public final /* synthetic */ OnTimeout b;

    public OnTimeout$register$$inlined$Runnable$1(SelectInstance selectInstance, OnTimeout onTimeout) {
        this.f3968a = selectInstance;
        this.b = onTimeout;
    }

    public final void run() {
        this.f3968a.e(this.b, Unit.INSTANCE);
    }
}
