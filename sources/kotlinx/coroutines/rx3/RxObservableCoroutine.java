package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.exceptions.UndeliverableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005J%\u0010\t\u001a\u00020\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001f\u001a\u00020\u001e2\u0014\u0010\u001d\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00040\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J&\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040!2\u0006\u0010\b\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u0000H@ø\u0001\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0014¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b)\u0010\u0018R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000028VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00108\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u000b\u0010:\u001a\u0002098\u0002X\u0004\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006;"}, d2 = {"Lkotlinx/coroutines/rx3/RxObservableCoroutine;", "", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "element", "A1", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "selectResult", "z1", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "elem", "", "v1", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "C1", "()V", "cause", "", "handled", "w1", "(Ljava/lang/Throwable;Z)V", "B1", "h", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "handler", "", "x1", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "Lkotlinx/coroutines/channels/ChannelResult;", "q", "(Ljava/lang/Object;)Ljava/lang/Object;", "L", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "y1", "(Lkotlin/Unit;)V", "p1", "Lio/reactivex/rxjava3/core/ObservableEmitter;", "d", "Lio/reactivex/rxjava3/core/ObservableEmitter;", "subscriber", "Lkotlinx/coroutines/sync/Mutex;", "e", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/channels/SendChannel;", "b", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "A", "()Z", "isClosedForSend", "Lkotlinx/atomicfu/AtomicInt;", "_signal", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRxObservable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxObservable.kt\nkotlinx/coroutines/rx3/RxObservableCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,211:1\n1#2:212\n163#3:213\n*S KotlinDebug\n*F\n+ 1 RxObservable.kt\nkotlinx/coroutines/rx3/RxObservableCoroutine\n*L\n169#1:213\n*E\n"})
final class RxObservableCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T> {
    public static final AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(RxObservableCoroutine.class, "_signal");
    @Volatile
    private volatile int _signal;
    public final ObservableEmitter d;
    public final Mutex e;

    /* access modifiers changed from: private */
    public final void A1(SelectInstance selectInstance, Object obj) {
        if (Mutex.DefaultImpls.b(this.e, (Object) null, 1, (Object) null)) {
            selectInstance.c(Unit.INSTANCE);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new RxObservableCoroutine$registerSelectForSend$1(this, selectInstance, (Continuation<? super RxObservableCoroutine$registerSelectForSend$1>) null), 3, (Object) null);
    }

    private final void B1(Throwable th, boolean z) {
        if (f.compareAndSet(this, 0, -1) && Mutex.DefaultImpls.b(this.e, (Object) null, 1, (Object) null)) {
            w1(th, z);
        }
    }

    private final void C1() {
        Mutex.DefaultImpls.c(this.e, (Object) null, 1, (Object) null);
        if (!isActive() && Mutex.DefaultImpls.b(this.e, (Object) null, 1, (Object) null)) {
            w1(v0(), w0());
        }
    }

    private final Throwable v1(Object obj) {
        if (!isActive()) {
            w1(v0(), w0());
            return U();
        }
        try {
            this.d.onNext(obj);
            C1();
            return null;
        } catch (Throwable th) {
            UndeliverableException undeliverableException = new UndeliverableException(th);
            boolean h = h(undeliverableException);
            C1();
            if (h) {
                return undeliverableException;
            }
            RxCancellableKt.a(undeliverableException, getContext());
            return U();
        }
    }

    private final void w1(Throwable th, boolean z) {
        try {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f;
            if (atomicIntegerFieldUpdater.get(this) == -2) {
                Mutex.DefaultImpls.c(this.e, (Object) null, 1, (Object) null);
                return;
            }
            atomicIntegerFieldUpdater.set(this, -2);
            CancellationException cancellationException = th != null ? th : null;
            if (cancellationException == null) {
                this.d.onComplete();
            } else if ((cancellationException instanceof UndeliverableException) && !z) {
                RxCancellableKt.a(th, getContext());
            } else if (cancellationException != U() || !this.d.isDisposed()) {
                try {
                    this.d.onError(th);
                } catch (Exception e2) {
                    ExceptionsKt.addSuppressed(th, e2);
                    RxCancellableKt.a(th, getContext());
                }
            }
            Mutex.DefaultImpls.c(this.e, (Object) null, 1, (Object) null);
        } catch (Exception e3) {
            RxCancellableKt.a(e3, getContext());
        } catch (Throwable th2) {
            Mutex.DefaultImpls.c(this.e, (Object) null, 1, (Object) null);
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    public final Object z1(Object obj, Object obj2) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlinx.coroutines.rx3.RxObservableCoroutine");
        Throwable v1 = v1(obj);
        if (v1 == null) {
            return this;
        }
        throw v1;
    }

    public boolean A() {
        return !isActive();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object L(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.rx3.RxObservableCoroutine$send$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.rx3.RxObservableCoroutine$send$1 r0 = (kotlinx.coroutines.rx3.RxObservableCoroutine$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.rx3.RxObservableCoroutine$send$1 r0 = new kotlinx.coroutines.rx3.RxObservableCoroutine$send$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.rx3.RxObservableCoroutine r4 = (kotlinx.coroutines.rx3.RxObservableCoroutine) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = r4.e
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            r2 = 0
            java.lang.Object r6 = kotlinx.coroutines.sync.Mutex.DefaultImpls.a(r6, r2, r0, r3, r2)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            java.lang.Throwable r4 = r4.v1(r5)
            if (r4 != 0) goto L_0x0053
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0053:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxObservableCoroutine.L(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public SendChannel b() {
        return this;
    }

    public boolean h(Throwable th) {
        return a0(th);
    }

    public void p1(Throwable th, boolean z) {
        B1(th, z);
    }

    public Object q(Object obj) {
        if (!Mutex.DefaultImpls.b(this.e, (Object) null, 1, (Object) null)) {
            return ChannelResult.b.b();
        }
        Throwable v1 = v1(obj);
        return v1 == null ? ChannelResult.b.c(Unit.INSTANCE) : ChannelResult.b.a(v1);
    }

    /* renamed from: x1 */
    public Void p(Function1 function1) {
        throw new UnsupportedOperationException("RxObservableCoroutine doesn't support invokeOnClose");
    }

    /* renamed from: y1 */
    public void q1(Unit unit) {
        B1((Throwable) null, false);
    }
}
