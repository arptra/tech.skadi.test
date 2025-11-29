package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;

public final class FlowableLastStageSubscriber<T> extends FlowableStageSubscriber<T> {
    final T defaultItem;
    final boolean hasDefault;

    public FlowableLastStageSubscriber(boolean z, T t) {
        this.hasDefault = z;
        this.defaultItem = t;
    }

    public void afterSubscribe(Subscription subscription) {
        subscription.request(LongCompanionObject.MAX_VALUE);
    }

    public void onComplete() {
        if (!isDone()) {
            T t = this.value;
            clear();
            if (t != null) {
                complete(t);
            } else if (this.hasDefault) {
                complete(this.defaultItem);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    public void onNext(T t) {
        this.value = t;
    }
}
