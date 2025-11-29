package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferedChannel;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u00032\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\b\u00028\u0000H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\r\u001a\u0004\b\u00028\u0000H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00168\u0002X\u0004ø\u0001\u0000\u0002\u0004\n\u0002\b9¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/rx3/SubscriptionChannel;", "T", "Lkotlinx/coroutines/channels/BufferedChannel;", "Lio/reactivex/rxjava3/core/Observer;", "Lio/reactivex/rxjava3/core/MaybeObserver;", "<init>", "()V", "", "t0", "Lio/reactivex/rxjava3/disposables/Disposable;", "sub", "onSubscribe", "(Lio/reactivex/rxjava3/disposables/Disposable;)V", "t", "onSuccess", "(Ljava/lang/Object;)V", "onNext", "onComplete", "", "e", "onError", "(Ljava/lang/Throwable;)V", "Lkotlinx/atomicfu/AtomicRef;", "_subscription", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0})
final class SubscriptionChannel<T> extends BufferedChannel<T> implements Observer<T>, MaybeObserver<T> {
    public static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(SubscriptionChannel.class, Object.class, "_subscription");
    @Volatile
    @Nullable
    private volatile Object _subscription;

    public SubscriptionChannel() {
        super(Integer.MAX_VALUE, (Function1) null, 2, (DefaultConstructorMarker) null);
    }

    public void onComplete() {
        h((Throwable) null);
    }

    public void onError(Throwable th) {
        h(th);
    }

    public void onNext(Object obj) {
        q(obj);
    }

    public void onSubscribe(Disposable disposable) {
        m.set(this, disposable);
    }

    public void onSuccess(Object obj) {
        q(obj);
        h((Throwable) null);
    }

    public void t0() {
        Disposable disposable = (Disposable) m.getAndSet(this, (Object) null);
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
