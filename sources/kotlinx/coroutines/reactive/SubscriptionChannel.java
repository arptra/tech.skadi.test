package kotlinx.coroutines.reactive;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferedChannel;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\nJ\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u000b\u0010\u001c\u001a\u00020\u001b8\u0002X\u0004R\u0013\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001d8\u0002X\u0004¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/reactive/SubscriptionChannel;", "T", "Lkotlinx/coroutines/channels/BufferedChannel;", "Lorg/reactivestreams/Subscriber;", "", "request", "<init>", "(I)V", "", "B0", "()V", "A0", "t0", "Lorg/reactivestreams/Subscription;", "s", "onSubscribe", "(Lorg/reactivestreams/Subscription;)V", "t", "onNext", "(Ljava/lang/Object;)V", "onComplete", "", "e", "onError", "(Ljava/lang/Throwable;)V", "m", "I", "Lkotlinx/atomicfu/AtomicInt;", "_requested", "Lkotlinx/atomicfu/AtomicRef;", "_subscription", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channel.kt\nkotlinx/coroutines/reactive/SubscriptionChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n1#2:112\n*E\n"})
final class SubscriptionChannel<T> extends BufferedChannel<T> implements Subscriber<T> {
    public static final AtomicReferenceFieldUpdater n;
    public static final AtomicIntegerFieldUpdater o;
    @Volatile
    private volatile int _requested;
    @Volatile
    @Nullable
    private volatile Object _subscription;
    public final int m;

    static {
        Class<SubscriptionChannel> cls = SubscriptionChannel.class;
        n = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_subscription");
        o = AtomicIntegerFieldUpdater.newUpdater(cls, "_requested");
    }

    public SubscriptionChannel(int i) {
        super(Integer.MAX_VALUE, (Function1) null, 2, (DefaultConstructorMarker) null);
        this.m = i;
        if (i < 0) {
            throw new IllegalArgumentException(("Invalid request size: " + i).toString());
        }
    }

    public void A0() {
        o.incrementAndGet(this);
    }

    public void B0() {
        Subscription subscription;
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = o;
        while (true) {
            int i2 = atomicIntegerFieldUpdater.get(this);
            subscription = (Subscription) n.get(this);
            i = i2 - 1;
            if (subscription != null && i < 0) {
                int i3 = this.m;
                if (i2 == i3 || o.compareAndSet(this, i2, i3)) {
                    subscription.request((long) (this.m - i));
                }
            } else if (o.compareAndSet(this, i2, i)) {
                return;
            }
        }
        subscription.request((long) (this.m - i));
    }

    public void onComplete() {
        h((Throwable) null);
    }

    public void onError(Throwable th) {
        h(th);
    }

    public void onNext(Object obj) {
        o.decrementAndGet(this);
        q(obj);
    }

    public void onSubscribe(Subscription subscription) {
        n.set(this, subscription);
        while (!A()) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = o;
            int i = atomicIntegerFieldUpdater.get(this);
            int i2 = this.m;
            if (i < i2) {
                if (atomicIntegerFieldUpdater.compareAndSet(this, i, i2)) {
                    subscription.request((long) (this.m - i));
                    return;
                }
            } else {
                return;
            }
        }
        subscription.cancel();
    }

    public void t0() {
        Subscription subscription = (Subscription) n.getAndSet(this, (Object) null);
        if (subscription != null) {
            subscription.cancel();
        }
    }
}
