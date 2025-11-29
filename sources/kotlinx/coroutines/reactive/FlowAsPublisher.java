package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.Flow;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003J!\u0010\u0007\u001a\u00020\u00062\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0000\u0012\u00028\u0000\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/reactive/FlowAsPublisher;", "", "T", "Lorg/reactivestreams/Publisher;", "Lorg/reactivestreams/Subscriber;", "subscriber", "", "subscribe", "(Lorg/reactivestreams/Subscriber;)V", "Lkotlinx/coroutines/flow/Flow;", "a", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lkotlin/coroutines/CoroutineContext;", "b", "Lkotlin/coroutines/CoroutineContext;", "context", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 8, 0})
final class FlowAsPublisher<T> implements Publisher<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Flow f3940a;
    public final CoroutineContext b;

    public void subscribe(Subscriber subscriber) {
        subscriber.getClass();
        subscriber.onSubscribe(new FlowSubscription(this.f3940a, subscriber, this.b));
    }
}
