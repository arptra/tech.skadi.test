package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a*\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0005H@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a(\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0005H@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u0007\u001a0\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u00052\u0006\u0010\t\u001a\u00028\u0000H@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a(\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\fH@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a6\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0017\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a>\u0010\u0016\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u000f2\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0000H@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u001b\u0002\b\n\u0002\b\u0019\n\u0002\b9¨\u0006\u001c"}, d2 = {"Lio/reactivex/rxjava3/core/CompletableSource;", "", "a", "(Lio/reactivex/rxjava3/core/CompletableSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lio/reactivex/rxjava3/core/MaybeSource;", "h", "(Lio/reactivex/rxjava3/core/MaybeSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "default", "f", "(Lio/reactivex/rxjava3/core/MaybeSource;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/rxjava3/core/SingleSource;", "b", "(Lio/reactivex/rxjava3/core/SingleSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/rxjava3/core/ObservableSource;", "Lkotlin/Function0;", "defaultValue", "c", "(Lio/reactivex/rxjava3/core/ObservableSource;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuation;", "Lio/reactivex/rxjava3/disposables/Disposable;", "d", "i", "(Lkotlinx/coroutines/CancellableContinuation;Lio/reactivex/rxjava3/disposables/Disposable;)V", "Lkotlinx/coroutines/rx3/Mode;", "mode", "(Lio/reactivex/rxjava3/core/ObservableSource;Lkotlinx/coroutines/rx3/Mode;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRxAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxAwait.kt\nkotlinx/coroutines/rx3/RxAwaitKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,278:1\n314#2,11:279\n314#2,11:290\n314#2,11:301\n314#2,11:312\n*S KotlinDebug\n*F\n+ 1 RxAwait.kt\nkotlinx/coroutines/rx3/RxAwaitKt\n*L\n25#1:279,11\n44#1:290,11\n121#1:301,11\n223#1:312,11\n*E\n"})
public final class RxAwaitKt {
    public static final Object a(CompletableSource completableSource, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        completableSource.subscribe(new RxAwaitKt$await$2$1(cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? u : Unit.INSTANCE;
    }

    public static final Object b(SingleSource singleSource, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        singleSource.subscribe(new RxAwaitKt$await$5$1(cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(io.reactivex.rxjava3.core.ObservableSource r7, kotlin.jvm.functions.Function0 r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.rx3.RxAwaitKt$awaitFirstOrElse$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            kotlinx.coroutines.rx3.RxAwaitKt$awaitFirstOrElse$1 r0 = (kotlinx.coroutines.rx3.RxAwaitKt$awaitFirstOrElse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.label = r1
        L_0x0012:
            r4 = r0
            goto L_0x001a
        L_0x0014:
            kotlinx.coroutines.rx3.RxAwaitKt$awaitFirstOrElse$1 r0 = new kotlinx.coroutines.rx3.RxAwaitKt$awaitFirstOrElse$1
            r0.<init>(r9)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 != r2) goto L_0x0030
            java.lang.Object r7 = r4.L$0
            r8 = r7
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x004d
        L_0x0030:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.rx3.Mode r9 = kotlinx.coroutines.rx3.Mode.FIRST_OR_DEFAULT
            r4.L$0 = r8
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r1 = r7
            r2 = r9
            java.lang.Object r9 = e(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x004d
            return r0
        L_0x004d:
            if (r9 != 0) goto L_0x0053
            java.lang.Object r9 = r8.invoke()
        L_0x0053:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxAwaitKt.c(io.reactivex.rxjava3.core.ObservableSource, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object d(ObservableSource observableSource, Mode mode, Object obj, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        observableSource.subscribe(new RxAwaitKt$awaitOne$2$1(cancellableContinuationImpl, mode, obj));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public static /* synthetic */ Object e(ObservableSource observableSource, Mode mode, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return d(observableSource, mode, obj, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.Object f(io.reactivex.rxjava3.core.MaybeSource r4, java.lang.Object r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.rx3.RxAwaitKt$awaitOrDefault$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.rx3.RxAwaitKt$awaitOrDefault$1 r0 = (kotlinx.coroutines.rx3.RxAwaitKt$awaitOrDefault$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx3.RxAwaitKt$awaitOrDefault$1 r0 = new kotlinx.coroutines.rx3.RxAwaitKt$awaitOrDefault$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            java.lang.Object r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0041
        L_0x002b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = h(r4, r0)
            if (r6 != r1) goto L_0x0041
            return r1
        L_0x0041:
            if (r6 != 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r5 = r6
        L_0x0045:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxAwaitKt.f(io.reactivex.rxjava3.core.MaybeSource, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object g(io.reactivex.rxjava3.core.MaybeSource r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.rx3.RxAwaitKt$awaitSingle$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.rx3.RxAwaitKt$awaitSingle$1 r0 = (kotlinx.coroutines.rx3.RxAwaitKt$awaitSingle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx3.RxAwaitKt$awaitSingle$1 r0 = new kotlinx.coroutines.rx3.RxAwaitKt$awaitSingle$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = h(r4, r0)
            if (r5 != r1) goto L_0x003d
            return r1
        L_0x003d:
            if (r5 == 0) goto L_0x0040
            return r5
        L_0x0040:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxAwaitKt.g(io.reactivex.rxjava3.core.MaybeSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object h(MaybeSource maybeSource, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        maybeSource.subscribe(new RxAwaitKt$awaitSingleOrNull$2$1(cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public static final void i(CancellableContinuation cancellableContinuation, Disposable disposable) {
        cancellableContinuation.E(new RxAwaitKt$disposeOnCancellation$1(disposable));
    }
}
