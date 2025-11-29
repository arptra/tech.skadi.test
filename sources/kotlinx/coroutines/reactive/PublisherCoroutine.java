package kotlinx.coroutines.reactive;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@SourceDebugExtension({"SMAP\nPublish.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Publish.kt\nkotlinx/coroutines/reactive/PublisherCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,339:1\n1#2:340\n*E\n"})
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005J%\u0010\n\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\t\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000H@ø\u0001\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u000eH\u0014¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0003H\u0016¢\u0006\u0004\b%\u0010&J%\u0010(\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010'\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010+\u001a\u0004\u0018\u00010\f2\u0006\u0010*\u001a\u00028\u0000H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0003H\u0002¢\u0006\u0004\b-\u0010&J!\u0010.\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b.\u0010$J!\u0010/\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b/\u0010$R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000008\bX\u0004¢\u0006\u0006\n\u0004\b1\u00102R&\u00108\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u0003048\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020;8\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000?8VX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u000b\u0010G\u001a\u00020F8\u0002X\u0004\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006H"}, d2 = {"Lkotlinx/coroutines/reactive/PublisherCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lorg/reactivestreams/Subscription;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "", "element", "A1", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "", "cause", "", "h", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "handler", "", "x1", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "Lkotlinx/coroutines/channels/ChannelResult;", "q", "(Ljava/lang/Object;)Ljava/lang/Object;", "L", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "n", "request", "(J)V", "value", "y1", "(Lkotlin/Unit;)V", "handled", "p1", "(Ljava/lang/Throwable;Z)V", "cancel", "()V", "selectResult", "z1", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "elem", "v1", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "C1", "w1", "B1", "Lorg/reactivestreams/Subscriber;", "d", "Lorg/reactivestreams/Subscriber;", "subscriber", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "e", "Lkotlin/jvm/functions/Function2;", "exceptionOnCancelHandler", "cancelled", "Z", "Lkotlinx/coroutines/sync/Mutex;", "f", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/channels/SendChannel;", "b", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "A", "()Z", "isClosedForSend", "Lkotlinx/atomicfu/AtomicLong;", "_nRequested", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 8, 0})
@InternalCoroutinesApi
public final class PublisherCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T>, Subscription {
    public static final AtomicLongFieldUpdater g = AtomicLongFieldUpdater.newUpdater(PublisherCoroutine.class, "_nRequested");
    @Volatile
    private volatile long _nRequested;
    private volatile boolean cancelled;
    public final Subscriber d;
    public final Function2 e;
    public final Mutex f;

    /* access modifiers changed from: private */
    public final void A1(SelectInstance selectInstance, Object obj) {
        if (Mutex.DefaultImpls.b(this.f, (Object) null, 1, (Object) null)) {
            selectInstance.c(Unit.INSTANCE);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new PublisherCoroutine$registerSelectForSend$1(this, selectInstance, (Continuation<? super PublisherCoroutine$registerSelectForSend$1>) null), 3, (Object) null);
    }

    public boolean A() {
        return !isActive();
    }

    public final void B1(Throwable th, boolean z) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        int i;
        do {
            atomicLongFieldUpdater = g;
            j = atomicLongFieldUpdater.get(this);
            if (j != -2) {
                i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, -1));
        if (i == 0) {
            w1(th, z);
        } else if (Mutex.DefaultImpls.b(this.f, (Object) null, 1, (Object) null)) {
            w1(th, z);
        }
    }

    public final void C1() {
        Mutex.DefaultImpls.c(this.f, (Object) null, 1, (Object) null);
        if (isCompleted() && Mutex.DefaultImpls.b(this.f, (Object) null, 1, (Object) null)) {
            w1(v0(), w0());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object L(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.reactive.PublisherCoroutine$send$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.reactive.PublisherCoroutine$send$1 r0 = (kotlinx.coroutines.reactive.PublisherCoroutine$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.reactive.PublisherCoroutine$send$1 r0 = new kotlinx.coroutines.reactive.PublisherCoroutine$send$1
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
            kotlinx.coroutines.reactive.PublisherCoroutine r4 = (kotlinx.coroutines.reactive.PublisherCoroutine) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = r4.f
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.PublisherCoroutine.L(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public SendChannel b() {
        return this;
    }

    public void cancel() {
        this.cancelled = true;
        super.a((CancellationException) null);
    }

    public boolean h(Throwable th) {
        return a0(th);
    }

    public void p1(Throwable th, boolean z) {
        B1(th, z);
    }

    public Object q(Object obj) {
        if (!Mutex.DefaultImpls.b(this.f, (Object) null, 1, (Object) null)) {
            return ChannelResult.b.b();
        }
        Throwable v1 = v1(obj);
        return v1 == null ? ChannelResult.b.c(Unit.INSTANCE) : ChannelResult.b.a(v1);
    }

    public void request(long j) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        int i;
        long j3;
        if (j <= 0) {
            a0(new IllegalArgumentException("non-positive subscription request " + j));
            return;
        }
        do {
            atomicLongFieldUpdater = g;
            j2 = atomicLongFieldUpdater.get(this);
            i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i >= 0) {
                j3 = j2 + j;
                if (j3 < 0 || j == LongCompanionObject.MAX_VALUE) {
                    j3 = Long.MAX_VALUE;
                }
                if (j2 == j3) {
                    return;
                }
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, j3));
        if (i == 0) {
            C1();
        }
    }

    public final Throwable v1(Object obj) {
        if (obj == null) {
            C1();
            throw new NullPointerException("Attempted to emit `null` inside a reactive publisher");
        } else if (!isActive()) {
            C1();
            return U();
        } else {
            try {
                this.d.onNext(obj);
                while (true) {
                    AtomicLongFieldUpdater atomicLongFieldUpdater = g;
                    long j = atomicLongFieldUpdater.get(this);
                    if (j < 0 || j == LongCompanionObject.MAX_VALUE) {
                        break;
                    }
                    long j2 = j - 1;
                    if (atomicLongFieldUpdater.compareAndSet(this, j, j2)) {
                        if (j2 == 0) {
                            return null;
                        }
                    }
                }
                C1();
                return null;
            } catch (Throwable th) {
                this.cancelled = true;
                boolean h = h(th);
                C1();
                if (h) {
                    return th;
                }
                this.e.invoke(th, getContext());
                return U();
            }
        }
    }

    public final void w1(Throwable th, boolean z) {
        try {
            AtomicLongFieldUpdater atomicLongFieldUpdater = g;
            if (atomicLongFieldUpdater.get(this) != -2) {
                atomicLongFieldUpdater.set(this, -2);
                if (!this.cancelled) {
                    if (th == null) {
                        this.d.onComplete();
                    } else {
                        try {
                            this.d.onError(th);
                        } catch (Throwable th2) {
                            if (th2 != th) {
                                ExceptionsKt.addSuppressed(th, th2);
                            }
                            CoroutineExceptionHandlerKt.a(getContext(), th);
                        }
                    }
                    Mutex.DefaultImpls.c(this.f, (Object) null, 1, (Object) null);
                    return;
                } else if (th != null && !z) {
                    this.e.invoke(th, getContext());
                }
            }
            Mutex.DefaultImpls.c(this.f, (Object) null, 1, (Object) null);
        } catch (Throwable th3) {
            Mutex.DefaultImpls.c(this.f, (Object) null, 1, (Object) null);
            throw th3;
        }
    }

    /* renamed from: x1 */
    public Void p(Function1 function1) {
        throw new UnsupportedOperationException("PublisherCoroutine doesn't support invokeOnClose");
    }

    /* renamed from: y1 */
    public void q1(Unit unit) {
        B1((Throwable) null, false);
    }

    public final Object z1(Object obj, Object obj2) {
        Throwable v1 = v1(obj);
        if (v1 == null) {
            return this;
        }
        throw v1;
    }
}
