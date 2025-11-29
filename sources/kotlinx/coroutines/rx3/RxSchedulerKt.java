package kotlinx.coroutines.rx3;

import com.honey.account.ob.a;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001aX\u0010\u0010\u001a\u00020\u000f*\u00020\u00042\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\b2,\u0010\u000e\u001a(\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n\u0012\b\u0012\u00060\u0005j\u0002`\u00060\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011*8\b\u0002\u0010\u0012\"\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n2\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lio/reactivex/rxjava3/core/Scheduler;", "Lkotlinx/coroutines/rx3/SchedulerCoroutineDispatcher;", "d", "(Lio/reactivex/rxjava3/core/Scheduler;)Lkotlinx/coroutines/rx3/SchedulerCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "delayMillis", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "adaptForScheduling", "Lio/reactivex/rxjava3/disposables/Disposable;", "e", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Runnable;JLkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/disposables/Disposable;", "Task", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRxScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxScheduler.kt\nkotlinx/coroutines/rx3/RxSchedulerKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,182:1\n1#2:183\n*E\n"})
public final class RxSchedulerKt {
    public static final /* synthetic */ SchedulerCoroutineDispatcher d(Scheduler scheduler) {
        return new SchedulerCoroutineDispatcher(scheduler);
    }

    public static final Disposable e(CoroutineScope coroutineScope, Runnable runnable, long j, Function1 function1) {
        CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Disposable fromRunnable = Disposable.fromRunnable(new a(objectRef));
        Runnable runnable2 = (Runnable) function1.invoke(new RxSchedulerKt$scheduleTask$toSchedule$1(fromRunnable, coroutineContext, RxJavaPlugins.onSchedule(runnable)));
        if (!CoroutineScopeKt.h(coroutineScope)) {
            return Disposable.disposed();
        }
        if (j <= 0) {
            runnable2.run();
        } else {
            objectRef.element = DelayKt.c(coroutineContext).invokeOnTimeout(j, runnable2, coroutineContext);
        }
        return fromRunnable;
    }

    public static final void f(Ref.ObjectRef objectRef) {
        DisposableHandle disposableHandle = (DisposableHandle) objectRef.element;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: kotlin.coroutines.CoroutineContext} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object g(io.reactivex.rxjava3.disposables.Disposable r4, kotlin.coroutines.CoroutineContext r5, java.lang.Runnable r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$1 r0 = (kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$1 r0 = new kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r4 = r0.L$0
            r5 = r4
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x002e }
            goto L_0x0058
        L_0x002e:
            r4 = move-exception
            goto L_0x0055
        L_0x0030:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r4 = r4.isDisposed()
            if (r4 == 0) goto L_0x0044
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0044:
            kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$2 r4 = new kotlinx.coroutines.rx3.RxSchedulerKt$scheduleTask$task$2     // Catch:{ all -> 0x002e }
            r4.<init>(r6)     // Catch:{ all -> 0x002e }
            r0.L$0 = r5     // Catch:{ all -> 0x002e }
            r0.label = r3     // Catch:{ all -> 0x002e }
            r6 = 0
            java.lang.Object r4 = kotlinx.coroutines.InterruptibleKt.c(r6, r4, r0, r3, r6)     // Catch:{ all -> 0x002e }
            if (r4 != r1) goto L_0x0058
            return r1
        L_0x0055:
            kotlinx.coroutines.rx3.RxCancellableKt.a(r4, r5)
        L_0x0058:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxSchedulerKt.g(io.reactivex.rxjava3.disposables.Disposable, kotlin.coroutines.CoroutineContext, java.lang.Runnable, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
