package kotlinx.coroutines.rx3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 RxScheduler.kt\nkotlinx/coroutines/rx3/DispatcherScheduler$scheduleDirect$1\n*L\n1#1,18:1\n60#2:19\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DispatcherScheduler$scheduleDirect$1$invoke$$inlined$Runnable$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DispatcherScheduler f3948a;
    public final /* synthetic */ Function1 b;

    public DispatcherScheduler$scheduleDirect$1$invoke$$inlined$Runnable$1(DispatcherScheduler dispatcherScheduler, Function1 function1) {
        this.f3948a = dispatcherScheduler;
        this.b = function1;
    }

    public final void run() {
        Job unused = BuildersKt__Builders_commonKt.d(this.f3948a.c, (CoroutineContext) null, (CoroutineStart) null, new DispatcherScheduler$scheduleDirect$1$1$1(this.b, (Continuation<? super DispatcherScheduler$scheduleDirect$1$1$1>) null), 3, (Object) null);
    }
}
