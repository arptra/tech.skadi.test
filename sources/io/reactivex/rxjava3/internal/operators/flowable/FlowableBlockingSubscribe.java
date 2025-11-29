package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.subscribers.BoundedSubscriber;
import io.reactivex.rxjava3.internal.subscribers.LambdaSubscriber;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.BlockingIgnoringReceiver;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Objects;
import org.reactivestreams.Publisher;

public final class FlowableBlockingSubscribe {
    private FlowableBlockingSubscribe() {
        throw new IllegalStateException("No instances!");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0013 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0014 A[Catch:{ InterruptedException -> 0x0029 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void subscribe(org.reactivestreams.Publisher<? extends T> r3, org.reactivestreams.Subscriber<? super T> r4) {
        /*
            java.util.concurrent.LinkedBlockingQueue r0 = new java.util.concurrent.LinkedBlockingQueue
            r0.<init>()
            io.reactivex.rxjava3.internal.subscribers.BlockingSubscriber r1 = new io.reactivex.rxjava3.internal.subscribers.BlockingSubscriber
            r1.<init>(r0)
            r3.subscribe(r1)
        L_0x000d:
            boolean r3 = r1.isCancelled()     // Catch:{ InterruptedException -> 0x0029 }
            if (r3 == 0) goto L_0x0014
            goto L_0x0043
        L_0x0014:
            java.lang.Object r3 = r0.poll()     // Catch:{ InterruptedException -> 0x0029 }
            if (r3 != 0) goto L_0x002b
            boolean r3 = r1.isCancelled()     // Catch:{ InterruptedException -> 0x0029 }
            if (r3 == 0) goto L_0x0021
            goto L_0x0043
        L_0x0021:
            io.reactivex.rxjava3.internal.util.BlockingHelper.verifyNonBlocking()     // Catch:{ InterruptedException -> 0x0029 }
            java.lang.Object r3 = r0.take()     // Catch:{ InterruptedException -> 0x0029 }
            goto L_0x002b
        L_0x0029:
            r3 = move-exception
            goto L_0x003d
        L_0x002b:
            boolean r2 = r1.isCancelled()     // Catch:{ InterruptedException -> 0x0029 }
            if (r2 == 0) goto L_0x0032
            goto L_0x0043
        L_0x0032:
            java.lang.Object r2 = io.reactivex.rxjava3.internal.subscribers.BlockingSubscriber.TERMINATED     // Catch:{ InterruptedException -> 0x0029 }
            if (r3 == r2) goto L_0x0043
            boolean r3 = io.reactivex.rxjava3.internal.util.NotificationLite.acceptFull((java.lang.Object) r3, r4)     // Catch:{ InterruptedException -> 0x0029 }
            if (r3 == 0) goto L_0x000d
            goto L_0x0043
        L_0x003d:
            r1.cancel()
            r4.onError(r3)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableBlockingSubscribe.subscribe(org.reactivestreams.Publisher, org.reactivestreams.Subscriber):void");
    }

    public static <T> void subscribe(Publisher<? extends T> publisher) {
        BlockingIgnoringReceiver blockingIgnoringReceiver = new BlockingIgnoringReceiver();
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(Functions.emptyConsumer(), blockingIgnoringReceiver, blockingIgnoringReceiver, Functions.REQUEST_MAX);
        publisher.subscribe(lambdaSubscriber);
        BlockingHelper.awaitForComplete(blockingIgnoringReceiver, lambdaSubscriber);
        Throwable th = blockingIgnoringReceiver.error;
        if (th != null) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static <T> void subscribe(Publisher<? extends T> publisher, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        subscribe(publisher, new LambdaSubscriber(consumer, consumer2, action, Functions.REQUEST_MAX));
    }

    public static <T> void subscribe(Publisher<? extends T> publisher, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, int i) {
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        ObjectHelper.verifyPositive(i, "number > 0 required");
        subscribe(publisher, new BoundedSubscriber(consumer, consumer2, action, Functions.boundedConsumer(i), i));
    }
}
