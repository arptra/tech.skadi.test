package j$.util.concurrent;

public interface Flow$Subscriber<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(Flow$Subscription flow$Subscription);
}
