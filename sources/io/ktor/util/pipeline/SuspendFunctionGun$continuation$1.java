package io.ktor.util.pipeline;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0017\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"io/ktor/util/pipeline/SuspendFunctionGun$continuation$1", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lio/ktor/util/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "Lio/ktor/util/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "a", "()Lkotlin/coroutines/Continuation;", "", "I", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "currentIndex", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final class SuspendFunctionGun$continuation$1 implements Continuation<Unit>, CoroutineStackFrame {

    /* renamed from: a  reason: collision with root package name */
    public int f9074a = Integer.MIN_VALUE;
    public final /* synthetic */ SuspendFunctionGun b;

    public SuspendFunctionGun$continuation$1(SuspendFunctionGun suspendFunctionGun) {
        this.b = suspendFunctionGun;
    }

    public final Continuation a() {
        if (this.f9074a == Integer.MIN_VALUE) {
            this.f9074a = this.b.f;
        }
        if (this.f9074a < 0) {
            this.f9074a = Integer.MIN_VALUE;
            return null;
        }
        try {
            Continuation[] j = this.b.e;
            int i = this.f9074a;
            Continuation continuation = j[i];
            if (continuation == null) {
                return StackWalkingFailedFrame.f9073a;
            }
            this.f9074a = i - 1;
            return continuation;
        } catch (Throwable unused) {
            return StackWalkingFailedFrame.f9073a;
        }
    }

    public CoroutineStackFrame getCallerFrame() {
        Continuation a2 = a();
        if (a2 instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) a2;
        }
        return null;
    }

    public CoroutineContext getContext() {
        CoroutineContext context;
        Continuation continuation = this.b.e[this.b.f];
        if (continuation != null && (context = continuation.getContext()) != null) {
            return context;
        }
        throw new IllegalStateException("Not started".toString());
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public void resumeWith(Object obj) {
        if (Result.m26isFailureimpl(obj)) {
            SuspendFunctionGun suspendFunctionGun = this.b;
            Throwable r2 = Result.m23exceptionOrNullimpl(obj);
            Intrinsics.checkNotNull(r2);
            suspendFunctionGun.q(Result.m20constructorimpl(ResultKt.createFailure(r2)));
            return;
        }
        boolean unused = this.b.p(false);
    }
}
