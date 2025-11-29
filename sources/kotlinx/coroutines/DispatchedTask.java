package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.scheduling.Task;

@SourceDebugExtension({"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,222:1\n1#2:223\n107#3,10:224\n118#3,2:238\n220#4:234\n221#4:237\n61#5,2:235\n75#6:240\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n*L\n90#1:224,10\n90#1:238,2\n103#1:234\n103#1:237\n103#1:235,2\n142#1:240\n*E\n"})
@PublishedApi
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH ¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\fH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8 X \u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001f¨\u0006!"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "", "resumeMode", "<init>", "(I)V", "", "i", "()Ljava/lang/Object;", "takenState", "", "cause", "", "a", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "state", "g", "(Ljava/lang/Object;)Ljava/lang/Object;", "d", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "run", "()V", "exception", "finallyException", "h", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "c", "I", "Lkotlin/coroutines/Continuation;", "()Lkotlin/coroutines/Continuation;", "delegate", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
public abstract class DispatchedTask<T> extends Task {
    public int c;

    public DispatchedTask(int i) {
        this.c = i;
    }

    public void a(Object obj, Throwable th) {
    }

    public abstract Continuation c();

    public Throwable d(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.f3715a;
        }
        return null;
    }

    public Object g(Object obj) {
        return obj;
    }

    public final void h(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                ExceptionsKt.addSuppressed(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            Intrinsics.checkNotNull(th);
            CoroutineExceptionHandlerKt.a(c().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    public abstract Object i();

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008b, code lost:
        if (r4.s1() != false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b3, code lost:
        if (r4.s1() != false) goto L_0x00b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            kotlinx.coroutines.scheduling.TaskContext r0 = r10.b
            kotlin.coroutines.Continuation r1 = r10.c()     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch:{ all -> 0x0023 }
            kotlinx.coroutines.internal.DispatchedContinuation r1 = (kotlinx.coroutines.internal.DispatchedContinuation) r1     // Catch:{ all -> 0x0023 }
            kotlin.coroutines.Continuation r2 = r1.e     // Catch:{ all -> 0x0023 }
            java.lang.Object r1 = r1.g     // Catch:{ all -> 0x0023 }
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()     // Catch:{ all -> 0x0023 }
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.c(r3, r1)     // Catch:{ all -> 0x0023 }
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.internal.ThreadContextKt.f3933a     // Catch:{ all -> 0x0023 }
            r5 = 0
            if (r1 == r4) goto L_0x0026
            kotlinx.coroutines.UndispatchedCoroutine r4 = kotlinx.coroutines.CoroutineContextKt.g(r2, r3, r1)     // Catch:{ all -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r1 = move-exception
            goto L_0x00b9
        L_0x0026:
            r4 = r5
        L_0x0027:
            kotlin.coroutines.CoroutineContext r6 = r2.getContext()     // Catch:{ all -> 0x0046 }
            java.lang.Object r7 = r10.i()     // Catch:{ all -> 0x0046 }
            java.lang.Throwable r8 = r10.d(r7)     // Catch:{ all -> 0x0046 }
            if (r8 != 0) goto L_0x0048
            int r9 = r10.c     // Catch:{ all -> 0x0046 }
            boolean r9 = kotlinx.coroutines.DispatchedTaskKt.b(r9)     // Catch:{ all -> 0x0046 }
            if (r9 == 0) goto L_0x0048
            kotlinx.coroutines.Job$Key r9 = kotlinx.coroutines.Job.b0     // Catch:{ all -> 0x0046 }
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r9)     // Catch:{ all -> 0x0046 }
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6     // Catch:{ all -> 0x0046 }
            goto L_0x0049
        L_0x0046:
            r2 = move-exception
            goto L_0x00ad
        L_0x0048:
            r6 = r5
        L_0x0049:
            if (r6 == 0) goto L_0x0066
            boolean r9 = r6.isActive()     // Catch:{ all -> 0x0046 }
            if (r9 != 0) goto L_0x0066
            java.util.concurrent.CancellationException r6 = r6.U()     // Catch:{ all -> 0x0046 }
            r10.a(r7, r6)     // Catch:{ all -> 0x0046 }
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = kotlin.Result.m20constructorimpl(r6)     // Catch:{ all -> 0x0046 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x0046 }
            goto L_0x0083
        L_0x0066:
            if (r8 == 0) goto L_0x0076
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r8)     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = kotlin.Result.m20constructorimpl(r6)     // Catch:{ all -> 0x0046 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x0046 }
            goto L_0x0083
        L_0x0076:
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = r10.g(r7)     // Catch:{ all -> 0x0046 }
            java.lang.Object r6 = kotlin.Result.m20constructorimpl(r6)     // Catch:{ all -> 0x0046 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x0046 }
        L_0x0083:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0046 }
            if (r4 == 0) goto L_0x008d
            boolean r2 = r4.s1()     // Catch:{ all -> 0x0023 }
            if (r2 == 0) goto L_0x0090
        L_0x008d:
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r1)     // Catch:{ all -> 0x0023 }
        L_0x0090:
            r0.u()     // Catch:{ all -> 0x009a }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009a }
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x009a }
            goto L_0x00a5
        L_0x009a:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)
        L_0x00a5:
            java.lang.Throwable r0 = kotlin.Result.m23exceptionOrNullimpl(r0)
            r10.h(r5, r0)
            goto L_0x00d7
        L_0x00ad:
            if (r4 == 0) goto L_0x00b5
            boolean r4 = r4.s1()     // Catch:{ all -> 0x0023 }
            if (r4 == 0) goto L_0x00b8
        L_0x00b5:
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r1)     // Catch:{ all -> 0x0023 }
        L_0x00b8:
            throw r2     // Catch:{ all -> 0x0023 }
        L_0x00b9:
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x00c5 }
            r0.u()     // Catch:{ all -> 0x00c5 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c5 }
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x00c5 }
            goto L_0x00d0
        L_0x00c5:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)
        L_0x00d0:
            java.lang.Throwable r0 = kotlin.Result.m23exceptionOrNullimpl(r0)
            r10.h(r1, r0)
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DispatchedTask.run():void");
    }
}
