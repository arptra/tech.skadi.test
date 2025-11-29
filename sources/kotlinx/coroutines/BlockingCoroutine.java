package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168TX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Ljava/lang/Thread;", "blockedThread", "Lkotlinx/coroutines/EventLoop;", "eventLoop", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "", "state", "", "X", "(Ljava/lang/Object;)V", "s1", "()Ljava/lang/Object;", "d", "Ljava/lang/Thread;", "e", "Lkotlinx/coroutines/EventLoop;", "", "J0", "()Z", "isScopedCoroutine", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/BlockingCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    public final Thread d;
    public final EventLoop e;

    public BlockingCoroutine(CoroutineContext coroutineContext, Thread thread, EventLoop eventLoop) {
        super(coroutineContext, true, true);
        this.d = thread;
        this.e = eventLoop;
    }

    public boolean J0() {
        return true;
    }

    public void X(Object obj) {
        Unit unit;
        if (!Intrinsics.areEqual((Object) Thread.currentThread(), (Object) this.d)) {
            Thread thread = this.d;
            AbstractTimeSource a2 = AbstractTimeSourceKt.a();
            if (a2 != null) {
                a2.f(thread);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                LockSupport.unpark(thread);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: kotlinx.coroutines.CompletedExceptionally} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object s1() {
        /*
            r6 = this;
            kotlinx.coroutines.AbstractTimeSource r0 = kotlinx.coroutines.AbstractTimeSourceKt.a()
            if (r0 == 0) goto L_0x0009
            r0.c()
        L_0x0009:
            kotlinx.coroutines.EventLoop r0 = r6.e     // Catch:{ all -> 0x0014 }
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x0016
            kotlinx.coroutines.EventLoop.A0(r0, r2, r1, r3)     // Catch:{ all -> 0x0014 }
            goto L_0x0016
        L_0x0014:
            r6 = move-exception
            goto L_0x007b
        L_0x0016:
            boolean r0 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x006a
            kotlinx.coroutines.EventLoop r0 = r6.e     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0027
            long r4 = r0.D0()     // Catch:{ all -> 0x0025 }
            goto L_0x002c
        L_0x0025:
            r0 = move-exception
            goto L_0x0073
        L_0x0027:
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x002c:
            boolean r0 = r6.isCompleted()     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0045
            kotlinx.coroutines.AbstractTimeSource r0 = kotlinx.coroutines.AbstractTimeSourceKt.a()     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x003e
            r0.b(r6, r4)     // Catch:{ all -> 0x0025 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0025 }
            goto L_0x003f
        L_0x003e:
            r0 = r3
        L_0x003f:
            if (r0 != 0) goto L_0x0016
            java.util.concurrent.locks.LockSupport.parkNanos(r6, r4)     // Catch:{ all -> 0x0025 }
            goto L_0x0016
        L_0x0045:
            kotlinx.coroutines.EventLoop r0 = r6.e     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x004c
            kotlinx.coroutines.EventLoop.f0(r0, r2, r1, r3)     // Catch:{ all -> 0x0014 }
        L_0x004c:
            kotlinx.coroutines.AbstractTimeSource r0 = kotlinx.coroutines.AbstractTimeSourceKt.a()
            if (r0 == 0) goto L_0x0055
            r0.g()
        L_0x0055:
            java.lang.Object r6 = r6.F0()
            java.lang.Object r6 = kotlinx.coroutines.JobSupportKt.h(r6)
            boolean r0 = r6 instanceof kotlinx.coroutines.CompletedExceptionally
            if (r0 == 0) goto L_0x0064
            r3 = r6
            kotlinx.coroutines.CompletedExceptionally r3 = (kotlinx.coroutines.CompletedExceptionally) r3
        L_0x0064:
            if (r3 != 0) goto L_0x0067
            return r6
        L_0x0067:
            java.lang.Throwable r6 = r3.f3715a
            throw r6
        L_0x006a:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException     // Catch:{ all -> 0x0025 }
            r0.<init>()     // Catch:{ all -> 0x0025 }
            r6.a0(r0)     // Catch:{ all -> 0x0025 }
            throw r0     // Catch:{ all -> 0x0025 }
        L_0x0073:
            kotlinx.coroutines.EventLoop r6 = r6.e     // Catch:{ all -> 0x0014 }
            if (r6 == 0) goto L_0x007a
            kotlinx.coroutines.EventLoop.f0(r6, r2, r1, r3)     // Catch:{ all -> 0x0014 }
        L_0x007a:
            throw r0     // Catch:{ all -> 0x0014 }
        L_0x007b:
            kotlinx.coroutines.AbstractTimeSource r0 = kotlinx.coroutines.AbstractTimeSourceKt.a()
            if (r0 == 0) goto L_0x0084
            r0.g()
        L_0x0084:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.BlockingCoroutine.s1():java.lang.Object");
    }
}
