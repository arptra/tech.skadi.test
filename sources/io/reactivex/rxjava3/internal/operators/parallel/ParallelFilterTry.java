package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFilterTry<T> extends ParallelFlowable<T> {
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Predicate<? super T> predicate;
    final ParallelFlowable<T> source;

    /* renamed from: io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.reactivex.rxjava3.parallel.ParallelFailureHandling[] r0 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling = r0
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.RETRY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.SKIP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.STOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Predicate<? super T> predicate;
        Subscription upstream;

        public BaseFilterSubscriber(Predicate<? super T> predicate2, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.predicate = predicate2;
            this.errorHandler = biFunction;
        }

        public final void cancel() {
            this.upstream.cancel();
        }

        public abstract /* synthetic */ void onComplete();

        public abstract /* synthetic */ void onError(Throwable th);

        public final void onNext(T t) {
            if (!tryOnNext(t) && !this.done) {
                this.upstream.request(1);
            }
        }

        public final void request(long j) {
            this.upstream.request(j);
        }
    }

    public static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {
        final ConditionalSubscriber<? super T> downstream;

        public ParallelFilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            super(predicate, biFunction);
            this.downstream = conditionalSubscriber;
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x003f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r9) {
            /*
                r8 = this;
                boolean r0 = r8.done
                r1 = 0
                if (r0 != 0) goto L_0x0063
                r2 = 0
            L_0x0007:
                r0 = 1
                io.reactivex.rxjava3.functions.Predicate<? super T> r4 = r8.predicate     // Catch:{ all -> 0x001a }
                boolean r2 = r4.test(r9)     // Catch:{ all -> 0x001a }
                if (r2 == 0) goto L_0x0019
                io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber<? super T> r8 = r8.downstream
                boolean r8 = r8.tryOnNext(r9)
                if (r8 == 0) goto L_0x0019
                r1 = r0
            L_0x0019:
                return r1
            L_0x001a:
                r4 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r5 = r8.errorHandler     // Catch:{ all -> 0x0050 }
                r6 = 1
                long r2 = r2 + r6
                java.lang.Long r6 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0050 }
                java.lang.Object r5 = r5.apply(r6, r4)     // Catch:{ all -> 0x0050 }
                java.lang.String r6 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r5, r6)     // Catch:{ all -> 0x0050 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r5 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r5     // Catch:{ all -> 0x0050 }
                int[] r6 = io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.AnonymousClass1.$SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling
                int r5 = r5.ordinal()
                r5 = r6[r5]
                if (r5 == r0) goto L_0x0007
                r9 = 2
                if (r5 == r9) goto L_0x004f
                r9 = 3
                if (r5 == r9) goto L_0x0049
                r8.cancel()
                r8.onError(r4)
                return r1
            L_0x0049:
                r8.cancel()
                r8.onComplete()
            L_0x004f:
                return r1
            L_0x0050:
                r9 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r9)
                r8.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r0 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r9 = new java.lang.Throwable[]{r4, r9}
                r0.<init>((java.lang.Throwable[]) r9)
                r8.onError(r0)
            L_0x0063:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.ParallelFilterConditionalSubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public static final class ParallelFilterSubscriber<T> extends BaseFilterSubscriber<T> {
        final Subscriber<? super T> downstream;

        public ParallelFilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            super(predicate, biFunction);
            this.downstream = subscriber;
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r9) {
            /*
                r8 = this;
                boolean r0 = r8.done
                r1 = 0
                if (r0 != 0) goto L_0x0060
                r2 = 0
            L_0x0007:
                r0 = 1
                io.reactivex.rxjava3.functions.Predicate<? super T> r4 = r8.predicate     // Catch:{ all -> 0x0017 }
                boolean r2 = r4.test(r9)     // Catch:{ all -> 0x0017 }
                if (r2 == 0) goto L_0x0016
                org.reactivestreams.Subscriber<? super T> r8 = r8.downstream
                r8.onNext(r9)
                return r0
            L_0x0016:
                return r1
            L_0x0017:
                r4 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r5 = r8.errorHandler     // Catch:{ all -> 0x004d }
                r6 = 1
                long r2 = r2 + r6
                java.lang.Long r6 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x004d }
                java.lang.Object r5 = r5.apply(r6, r4)     // Catch:{ all -> 0x004d }
                java.lang.String r6 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r5, r6)     // Catch:{ all -> 0x004d }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r5 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r5     // Catch:{ all -> 0x004d }
                int[] r6 = io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.AnonymousClass1.$SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling
                int r5 = r5.ordinal()
                r5 = r6[r5]
                if (r5 == r0) goto L_0x0007
                r9 = 2
                if (r5 == r9) goto L_0x004c
                r9 = 3
                if (r5 == r9) goto L_0x0046
                r8.cancel()
                r8.onError(r4)
                return r1
            L_0x0046:
                r8.cancel()
                r8.onComplete()
            L_0x004c:
                return r1
            L_0x004d:
                r9 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r9)
                r8.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r0 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r9 = new java.lang.Throwable[]{r4, r9}
                r0.<init>((java.lang.Throwable[]) r9)
                r8.onError(r0)
            L_0x0060:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.ParallelFilterSubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public ParallelFilterTry(ParallelFlowable<T> parallelFlowable, Predicate<? super T> predicate2, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.source = parallelFlowable;
        this.predicate = predicate2;
        this.errorHandler = biFunction;
    }

    public int parallelism() {
        return this.source.parallelism();
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                ConditionalSubscriber conditionalSubscriber = subscriberArr[i];
                if (conditionalSubscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i] = new ParallelFilterConditionalSubscriber(conditionalSubscriber, this.predicate, this.errorHandler);
                } else {
                    subscriberArr2[i] = new ParallelFilterSubscriber(conditionalSubscriber, this.predicate, this.errorHandler);
                }
            }
            this.source.subscribe(subscriberArr2);
        }
    }
}
