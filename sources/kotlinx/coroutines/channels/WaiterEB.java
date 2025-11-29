package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.Waiter;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/channels/WaiterEB;", "", "Lkotlinx/coroutines/Waiter;", "waiter", "<init>", "(Lkotlinx/coroutines/Waiter;)V", "", "toString", "()Ljava/lang/String;", "a", "Lkotlinx/coroutines/Waiter;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
final class WaiterEB {

    /* renamed from: a  reason: collision with root package name */
    public final Waiter f3760a;

    public WaiterEB(Waiter waiter) {
        this.f3760a = waiter;
    }

    public String toString() {
        return "WaiterEB(" + this.f3760a + ')';
    }
}
