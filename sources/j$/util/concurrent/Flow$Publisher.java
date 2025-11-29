package j$.util.concurrent;

public interface Flow$Publisher<T> {
    void subscribe(Flow$Subscriber<? super T> flow$Subscriber);
}
