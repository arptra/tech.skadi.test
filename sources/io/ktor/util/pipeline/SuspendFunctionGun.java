package io.ktor.util.pipeline;

import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004Ba\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012H\u0010\f\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000b0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001d\u001a\u00020\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\u0010J\u001d\u0010!\u001a\u00020\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b!\u0010\"RV\u0010\f\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000b0\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010%R\"\u0010\u0013\u001a\u00028\u00008\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u001eR\"\u0010-\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0+8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010/R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010/R\u0014\u00105\u001a\u0002028VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lio/ktor/util/pipeline/SuspendFunctionGun;", "", "TSubject", "TContext", "Lio/ktor/util/pipeline/PipelineContext;", "initial", "context", "", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/util/pipeline/PipelineInterceptorFunction;", "blocks", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/List;)V", "c", "()V", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subject", "g", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "", "direct", "p", "(Z)Z", "Lkotlin/Result;", "result", "q", "(Ljava/lang/Object;)V", "n", "continuation", "m", "(Lkotlin/coroutines/Continuation;)V", "b", "Ljava/util/List;", "Lkotlin/coroutines/Continuation;", "d", "Ljava/lang/Object;", "e", "()Ljava/lang/Object;", "r", "", "[Lkotlin/coroutines/Continuation;", "suspensions", "", "I", "lastSuspensionIndex", "index", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final class SuspendFunctionGun<TSubject, TContext> extends PipelineContext<TSubject, TContext> {
    public final List b;
    public final Continuation c = new SuspendFunctionGun$continuation$1(this);
    public Object d;
    public final Continuation[] e;
    public int f;
    public int g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuspendFunctionGun(Object obj, Object obj2, List list) {
        super(obj2);
        Intrinsics.checkNotNullParameter(obj, "initial");
        Intrinsics.checkNotNullParameter(obj2, "context");
        Intrinsics.checkNotNullParameter(list, "blocks");
        this.b = list;
        this.d = obj;
        this.e = new Continuation[list.size()];
        this.f = -1;
    }

    public Object a(Object obj, Continuation continuation) {
        this.g = 0;
        if (this.b.size() == 0) {
            return obj;
        }
        r(obj);
        if (this.f < 0) {
            return f(continuation);
        }
        throw new IllegalStateException("Already started");
    }

    public void c() {
        this.g = this.b.size();
    }

    public Object e() {
        return this.d;
    }

    public Object f(Continuation continuation) {
        Object obj;
        if (this.g == this.b.size()) {
            obj = e();
        } else {
            m(IntrinsicsKt.intercepted(continuation));
            if (p(true)) {
                n();
                obj = e();
            } else {
                obj = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
        }
        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return obj;
    }

    public Object g(Object obj, Continuation continuation) {
        r(obj);
        return f(continuation);
    }

    public CoroutineContext getCoroutineContext() {
        return this.c.getContext();
    }

    public final void m(Continuation continuation) {
        Continuation[] continuationArr = this.e;
        int i = this.f + 1;
        this.f = i;
        continuationArr[i] = continuation;
    }

    public final void n() {
        int i = this.f;
        if (i >= 0) {
            Continuation[] continuationArr = this.e;
            this.f = i - 1;
            continuationArr[i] = null;
            return;
        }
        throw new IllegalStateException("No more continuations to resume");
    }

    public final boolean p(boolean z) {
        int i;
        do {
            i = this.g;
            if (i != this.b.size()) {
                this.g = i + 1;
                try {
                } catch (Throwable th) {
                    Result.Companion companion = Result.Companion;
                    q(Result.m20constructorimpl(ResultKt.createFailure(th)));
                    return false;
                }
            } else if (z) {
                return true;
            } else {
                Result.Companion companion2 = Result.Companion;
                q(Result.m20constructorimpl(e()));
                return false;
            }
        } while (((Function3) this.b.get(i)).invoke(this, e(), this.c) != IntrinsicsKt.getCOROUTINE_SUSPENDED());
        return false;
    }

    public final void q(Object obj) {
        int i = this.f;
        if (i >= 0) {
            Continuation continuation = this.e[i];
            Intrinsics.checkNotNull(continuation);
            Continuation[] continuationArr = this.e;
            int i2 = this.f;
            this.f = i2 - 1;
            continuationArr[i2] = null;
            if (!Result.m26isFailureimpl(obj)) {
                continuation.resumeWith(obj);
                return;
            }
            Throwable r4 = Result.m23exceptionOrNullimpl(obj);
            Intrinsics.checkNotNull(r4);
            continuation.resumeWith(Result.m20constructorimpl(ResultKt.createFailure(StackTraceRecoverKt.a(r4, continuation))));
            return;
        }
        throw new IllegalStateException("No more continuations to resume".toString());
    }

    public void r(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.d = obj;
    }
}
