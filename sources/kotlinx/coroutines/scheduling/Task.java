package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.PublishedApi;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b!\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0010¢\u0006\u0004\b\u0007\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/scheduling/Task;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "submissionTime", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "<init>", "(JLkotlinx/coroutines/scheduling/TaskContext;)V", "()V", "a", "J", "b", "Lkotlinx/coroutines/scheduling/TaskContext;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@PublishedApi
public abstract class Task implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public long f3962a;
    public TaskContext b;

    public Task(long j, TaskContext taskContext) {
        this.f3962a = j;
        this.b = taskContext;
    }

    public Task() {
        this(0, TasksKt.g);
    }
}
