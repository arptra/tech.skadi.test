package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public interface FlowableSubscriber<T> extends Subscriber<T> {
    /* synthetic */ void onComplete();

    /* synthetic */ void onError(Throwable th);

    /* synthetic */ void onNext(Object obj);

    void onSubscribe(@NonNull Subscription subscription);
}
