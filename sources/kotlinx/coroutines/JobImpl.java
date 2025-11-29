package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000b\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u000e\u0010\tR\u001a\u0010\u0012\u001a\u00020\u00078\u0010X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0014\u0010\u0014\u001a\u00020\u00078PX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "complete", "()Z", "", "exception", "d", "(Ljava/lang/Throwable;)Z", "o1", "c", "Z", "B0", "handlesException", "C0", "onCancelComplete", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@PublishedApi
public class JobImpl extends JobSupport implements CompletableJob {
    public final boolean c = o1();

    public JobImpl(Job job) {
        super(true);
        I0(job);
    }

    public boolean B0() {
        return this.c;
    }

    public boolean C0() {
        return true;
    }

    public boolean complete() {
        return N0(Unit.INSTANCE);
    }

    public boolean d(Throwable th) {
        return N0(new CompletedExceptionally(th, false, 2, (DefaultConstructorMarker) null));
    }

    public final boolean o1() {
        JobSupport t;
        ChildHandle E0 = E0();
        ChildHandleNode childHandleNode = E0 instanceof ChildHandleNode ? (ChildHandleNode) E0 : null;
        if (!(childHandleNode == null || (t = childHandleNode.t()) == null)) {
            while (!t.B0()) {
                ChildHandle E02 = t.E0();
                ChildHandleNode childHandleNode2 = E02 instanceof ChildHandleNode ? (ChildHandleNode) E02 : null;
                if (childHandleNode2 != null) {
                    t = childHandleNode2.t();
                    if (t == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }
}
