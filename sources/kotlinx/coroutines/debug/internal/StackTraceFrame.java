package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00018\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "a", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "b", "Ljava/lang/StackTraceElement;", "stackTraceElement", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@PublishedApi
public final class StackTraceFrame implements CoroutineStackFrame {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineStackFrame f3778a;
    public final StackTraceElement b;

    public CoroutineStackFrame getCallerFrame() {
        return this.f3778a;
    }

    public StackTraceElement getStackTraceElement() {
        return this.b;
    }
}
