package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/scheduling/TaskContextImpl;", "Lkotlinx/coroutines/scheduling/TaskContext;", "", "taskMode", "<init>", "(I)V", "", "u", "()V", "a", "I", "T", "()I", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
final class TaskContextImpl implements TaskContext {

    /* renamed from: a  reason: collision with root package name */
    public final int f3963a;

    public TaskContextImpl(int i) {
        this.f3963a = i;
    }

    public int T() {
        return this.f3963a;
    }

    public void u() {
    }
}
