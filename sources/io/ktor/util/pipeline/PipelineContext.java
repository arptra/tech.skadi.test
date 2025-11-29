package io.ktor.util.pipeline;

import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000H @ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\rR\u0017\u0010\u0005\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000b\u001a\u00028\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0014\"\u0004\b\u0016\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "TSubject", "TContext", "Lkotlinx/coroutines/CoroutineScope;", "context", "<init>", "(Ljava/lang/Object;)V", "", "c", "()V", "subject", "g", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initial", "a", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "e", "setSubject", "ktor-utils"}, k = 1, mv = {1, 8, 0})
@KtorDsl
public abstract class PipelineContext<TSubject, TContext> implements CoroutineScope {

    /* renamed from: a  reason: collision with root package name */
    public final Object f9066a;

    public PipelineContext(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "context");
        this.f9066a = obj;
    }

    public abstract Object a(Object obj, Continuation continuation);

    public abstract void c();

    public final Object d() {
        return this.f9066a;
    }

    public abstract Object e();

    public abstract Object f(Continuation continuation);

    public abstract Object g(Object obj, Continuation continuation);
}
