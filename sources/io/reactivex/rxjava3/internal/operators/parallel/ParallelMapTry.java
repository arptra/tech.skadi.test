package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMapTry<T, R> extends ParallelFlowable<R> {
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Function<? super T, ? extends R> mapper;
    final ParallelFlowable<T> source;

    /* renamed from: io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class ParallelMapTryConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final ConditionalSubscriber<? super R> downstream;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Function<? super T, ? extends R> mapper;
        Subscription upstream;

        public ParallelMapTryConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.downstream = conditionalSubscriber;
            this.mapper = function;
            this.errorHandler = biFunction;
        }

        public void cancel() {
            this.upstream.cancel();
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

        public void onNext(T t) {
            if (!tryOnNext(t) && !this.done) {
                this.upstream.request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public void request(long j) {
            this.upstream.request(j);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r8) {
            /*
                r7 = this;
                boolean r0 = r7.done
                r1 = 0
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                r2 = 0
            L_0x0008:
                io.reactivex.rxjava3.functions.Function<? super T, ? extends R> r0 = r7.mapper     // Catch:{ all -> 0x001a }
                java.lang.Object r0 = r0.apply(r8)     // Catch:{ all -> 0x001a }
                java.lang.String r4 = "The mapper returned a null value"
                java.util.Objects.requireNonNull(r0, r4)     // Catch:{ all -> 0x001a }
                io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber<? super R> r7 = r7.downstream
                boolean r7 = r7.tryOnNext(r0)
                return r7
            L_0x001a:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r4 = r7.errorHandler     // Catch:{ all -> 0x0051 }
                r5 = 1
                long r2 = r2 + r5
                java.lang.Long r5 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0051 }
                java.lang.Object r4 = r4.apply(r5, r0)     // Catch:{ all -> 0x0051 }
                java.lang.String r5 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r4, r5)     // Catch:{ all -> 0x0051 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r4 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r4     // Catch:{ all -> 0x0051 }
                int[] r5 = io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.AnonymousClass1.$SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling
                int r4 = r4.ordinal()
                r4 = r5[r4]
                r5 = 1
                if (r4 == r5) goto L_0x0008
                r8 = 2
                if (r4 == r8) goto L_0x0050
                r8 = 3
                if (r4 == r8) goto L_0x004a
                r7.cancel()
                r7.onError(r0)
                return r1
            L_0x004a:
                r7.cancel()
                r7.onComplete()
            L_0x0050:
                return r1
            L_0x0051:
                r8 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r8)
                r7.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r2 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r8 = new java.lang.Throwable[]{r0, r8}
                r2.<init>((java.lang.Throwable[]) r8)
                r7.onError(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.ParallelMapTryConditionalSubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public static final class ParallelMapTrySubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super R> downstream;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Function<? super T, ? extends R> mapper;
        Subscription upstream;

        public ParallelMapTrySubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.downstream = subscriber;
            this.mapper = function;
            this.errorHandler = biFunction;
        }

        public void cancel() {
            this.upstream.cancel();
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

        public void onNext(T t) {
            if (!tryOnNext(t) && !this.done) {
                this.upstream.request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public void request(long j) {
            this.upstream.request(j);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(T r9) {
            /*
                r8 = this;
                boolean r0 = r8.done
                r1 = 0
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                r2 = 0
            L_0x0008:
                r0 = 1
                io.reactivex.rxjava3.functions.Function<? super T, ? extends R> r4 = r8.mapper     // Catch:{ all -> 0x001a }
                java.lang.Object r4 = r4.apply(r9)     // Catch:{ all -> 0x001a }
                java.lang.String r5 = "The mapper returned a null value"
                java.util.Objects.requireNonNull(r4, r5)     // Catch:{ all -> 0x001a }
                org.reactivestreams.Subscriber<? super R> r8 = r8.downstream
                r8.onNext(r4)
                return r0
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
                int[] r6 = io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.AnonymousClass1.$SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling
                int r5 = r5.ordinal()
                r5 = r6[r5]
                if (r5 == r0) goto L_0x0008
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
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.ParallelMapTrySubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public ParallelMapTry(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.source = parallelFlowable;
        this.mapper = function;
        this.errorHandler = biFunction;
    }

    public int parallelism() {
        return this.source.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                ConditionalSubscriber conditionalSubscriber = subscriberArr[i];
                if (conditionalSubscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i] = new ParallelMapTryConditionalSubscriber(conditionalSubscriber, this.mapper, this.errorHandler);
                } else {
                    subscriberArr2[i] = new ParallelMapTrySubscriber(conditionalSubscriber, this.mapper, this.errorHandler);
                }
            }
            this.source.subscribe(subscriberArr2);
        }
    }
}
