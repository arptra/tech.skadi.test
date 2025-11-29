package j$.util.concurrent;

public interface Flow$Subscription {
    void cancel();

    void request(long j);
}
