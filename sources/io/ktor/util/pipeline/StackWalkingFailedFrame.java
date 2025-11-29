package io.ktor.util.pipeline;

import io.ktor.util.StackFramesJvmKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0016J\u001e\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u001c\u0010\u0006\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lio/ktor/util/pipeline/StackWalkingFailedFrame;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lio/ktor/util/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "", "()V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lio/ktor/util/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StackWalkingFailedFrame implements CoroutineStackFrame, Continuation<?> {

    /* renamed from: a  reason: collision with root package name */
    public static final StackWalkingFailedFrame f9073a = new StackWalkingFailedFrame();

    public CoroutineStackFrame getCallerFrame() {
        return null;
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public StackTraceElement getStackTraceElement() {
        return StackFramesJvmKt.a(Reflection.getOrCreateKotlinClass(StackWalkingFailed.class), "failedToCaptureStackFrame", "StackWalkingFailed.kt", 8);
    }

    public void resumeWith(Object obj) {
        StackWalkingFailed.f9072a.a();
    }
}
