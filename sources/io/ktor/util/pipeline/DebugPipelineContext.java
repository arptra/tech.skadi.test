package io.ktor.util.pipeline;

import io.ktor.util.KtorDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004Bi\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012H\u0010\u000b\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\n0\u0006\u0012\u0006\u0010\f\u001a\u00028\u0000\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0014J\u0013\u0010\u0019\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0016RV\u0010\u000b\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\n0\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\f\u001a\u00028\u00008\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010&\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lio/ktor/util/pipeline/DebugPipelineContext;", "", "TSubject", "TContext", "Lio/ktor/util/pipeline/PipelineContext;", "context", "", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/util/pipeline/PipelineInterceptorFunction;", "interceptors", "subject", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Ljava/lang/Object;Ljava/util/List;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "c", "()V", "g", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initial", "a", "j", "b", "Ljava/util/List;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "d", "Ljava/lang/Object;", "e", "()Ljava/lang/Object;", "k", "(Ljava/lang/Object;)V", "", "I", "index", "ktor-utils"}, k = 1, mv = {1, 8, 0})
@KtorDsl
public final class DebugPipelineContext<TSubject, TContext> extends PipelineContext<TSubject, TContext> {
    public final List b;
    public final CoroutineContext c;
    public Object d;
    public int e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DebugPipelineContext(Object obj, List list, Object obj2, CoroutineContext coroutineContext) {
        super(obj);
        Intrinsics.checkNotNullParameter(obj, "context");
        Intrinsics.checkNotNullParameter(list, "interceptors");
        Intrinsics.checkNotNullParameter(obj2, "subject");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.b = list;
        this.c = coroutineContext;
        this.d = obj2;
    }

    public Object a(Object obj, Continuation continuation) {
        this.e = 0;
        k(obj);
        return f(continuation);
    }

    public void c() {
        this.e = -1;
    }

    public Object e() {
        return this.d;
    }

    public Object f(Continuation continuation) {
        int i = this.e;
        if (i < 0) {
            return e();
        }
        if (i < this.b.size()) {
            return j(continuation);
        }
        c();
        return e();
    }

    public Object g(Object obj, Continuation continuation) {
        k(obj);
        return f(continuation);
    }

    public CoroutineContext getCoroutineContext() {
        return this.c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0046 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1 r0 = (io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1 r0 = new io.ktor.util.pipeline.DebugPipelineContext$proceedLoop$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            java.lang.Object r5 = r0.L$0
            io.ktor.util.pipeline.DebugPipelineContext r5 = (io.ktor.util.pipeline.DebugPipelineContext) r5
            goto L_0x0032
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
        L_0x0035:
            int r6 = r5.e
            r2 = -1
            if (r6 != r2) goto L_0x003b
            goto L_0x0046
        L_0x003b:
            java.util.List r2 = r5.b
            int r4 = r2.size()
            if (r6 < r4) goto L_0x004b
            r5.c()
        L_0x0046:
            java.lang.Object r5 = r5.e()
            return r5
        L_0x004b:
            java.lang.Object r2 = r2.get(r6)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            int r6 = r6 + 1
            r5.e = r6
            java.lang.String r6 = "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.DebugPipelineContext, TContext of io.ktor.util.pipeline.DebugPipelineContext>, TSubject of io.ktor.util.pipeline.DebugPipelineContext, kotlin.Unit>{ io.ktor.util.pipeline.PipelineKt.PipelineInterceptor<TSubject of io.ktor.util.pipeline.DebugPipelineContext, TContext of io.ktor.util.pipeline.DebugPipelineContext> }"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r6)
            java.lang.Object r6 = r5.e()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r2.invoke(r5, r6, r0)
            if (r6 != r1) goto L_0x0035
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.pipeline.DebugPipelineContext.j(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void k(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.d = obj;
    }
}
