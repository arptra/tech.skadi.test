package kotlinx.coroutines.rx3;

import com.honey.account.x.c;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0015\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"kotlinx/coroutines/rx3/RxConvertKt$asFlow$1$observer$1", "Lio/reactivex/rxjava3/core/Observer;", "onComplete", "", "onError", "e", "", "onNext", "t", "(Ljava/lang/Object;)V", "onSubscribe", "d", "Lio/reactivex/rxjava3/disposables/Disposable;", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RxConvertKt$asFlow$1$observer$1 implements Observer<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProducerScope f3955a;
    public final /* synthetic */ AtomicReference b;

    public RxConvertKt$asFlow$1$observer$1(ProducerScope producerScope, AtomicReference atomicReference) {
        this.f3955a = producerScope;
        this.b = atomicReference;
    }

    public void onComplete() {
        SendChannel.DefaultImpls.a(this.f3955a, (Throwable) null, 1, (Object) null);
    }

    public void onError(Throwable th) {
        this.f3955a.h(th);
    }

    public void onNext(Object obj) {
        try {
            ChannelsKt.w(this.f3955a, obj);
        } catch (InterruptedException unused) {
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!c.a(this.b, (Object) null, disposable)) {
            disposable.dispose();
        }
    }
}
