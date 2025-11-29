package androidx.paging;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\n\u001a\u00028\u0002\"\u0004\b\u0002\u0010\u00062\u001e\u0010\t\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00178F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/paging/AccessorStateHolder;", "", "Key", "Value", "<init>", "()V", "R", "Lkotlin/Function1;", "Landroidx/paging/AccessorState;", "block", "b", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Ljava/util/concurrent/locks/ReentrantLock;", "a", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/paging/LoadStates;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_loadStates", "c", "Landroidx/paging/AccessorState;", "internalState", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "loadStates", "paging-common"}, k = 1, mv = {1, 8, 0})
final class AccessorStateHolder<Key, Value> {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f1512a = new ReentrantLock();
    public final MutableStateFlow b = StateFlowKt.a(LoadStates.d.a());
    public final AccessorState c = new AccessorState();

    public final StateFlow a() {
        return this.b;
    }

    public final Object b(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        ReentrantLock reentrantLock = this.f1512a;
        reentrantLock.lock();
        try {
            Object invoke = function1.invoke(this.c);
            this.b.setValue(this.c.e());
            return invoke;
        } finally {
            reentrantLock.unlock();
        }
    }
}
