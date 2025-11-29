package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Optional;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMapTryOptional<T, R> extends ParallelFlowable<R> {
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Function<? super T, Optional<? extends R>> mapper;
    final ParallelFlowable<T> source;

    /* renamed from: io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class ParallelMapTryConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final ConditionalSubscriber<? super R> downstream;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Function<? super T, Optional<? extends R>> mapper;
        Subscription upstream;

        public ParallelMapTryConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, Optional<? extends R>> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
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

        /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
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
                io.reactivex.rxjava3.functions.Function<? super T, java.util.Optional<? extends R>> r4 = r8.mapper     // Catch:{ all -> 0x002a }
                java.lang.Object r4 = r4.apply(r9)     // Catch:{ all -> 0x002a }
                java.lang.String r5 = "The mapper returned a null Optional"
                java.util.Objects.requireNonNull(r4, r5)     // Catch:{ all -> 0x002a }
                java.util.Optional r4 = (java.util.Optional) r4     // Catch:{ all -> 0x002a }
                boolean r9 = r4.isPresent()
                if (r9 == 0) goto L_0x0029
                io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber<? super R> r8 = r8.downstream
                java.lang.Object r9 = r4.get()
                boolean r8 = r8.tryOnNext(r9)
                if (r8 == 0) goto L_0x0029
                r1 = r0
            L_0x0029:
                return r1
            L_0x002a:
                r4 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r5 = r8.errorHandler     // Catch:{ all -> 0x0060 }
                r6 = 1
                long r2 = r2 + r6
                java.lang.Long r6 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0060 }
                java.lang.Object r5 = r5.apply(r6, r4)     // Catch:{ all -> 0x0060 }
                java.lang.String r6 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r5, r6)     // Catch:{ all -> 0x0060 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r5 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r5     // Catch:{ all -> 0x0060 }
                int[] r6 = io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional.AnonymousClass1.$SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling
                int r5 = r5.ordinal()
                r5 = r6[r5]
                if (r5 == r0) goto L_0x0008
                r9 = 2
                if (r5 == r9) goto L_0x005f
                r9 = 3
                if (r5 == r9) goto L_0x0059
                r8.cancel()
                r8.onError(r4)
                return r1
            L_0x0059:
                r8.cancel()
                r8.onComplete()
            L_0x005f:
                return r1
            L_0x0060:
                r9 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r9)
                r8.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r0 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r9 = new java.lang.Throwable[]{r4, r9}
                r0.<init>((java.lang.Throwable[]) r9)
                r8.onError(r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional.ParallelMapTryConditionalSubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public static final class ParallelMapTrySubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super R> downstream;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Function<? super T, Optional<? extends R>> mapper;
        Subscription upstream;

        public ParallelMapTrySubscriber(Subscriber<? super R> subscriber, Function<? super T, Optional<? extends R>> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
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

        /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
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
                io.reactivex.rxjava3.functions.Function<? super T, java.util.Optional<? extends R>> r4 = r8.mapper     // Catch:{ all -> 0x0027 }
                java.lang.Object r4 = r4.apply(r9)     // Catch:{ all -> 0x0027 }
                java.lang.String r5 = "The mapper returned a null Optional"
                java.util.Objects.requireNonNull(r4, r5)     // Catch:{ all -> 0x0027 }
                java.util.Optional r4 = (java.util.Optional) r4     // Catch:{ all -> 0x0027 }
                boolean r9 = r4.isPresent()
                if (r9 == 0) goto L_0x0026
                org.reactivestreams.Subscriber<? super R> r8 = r8.downstream
                java.lang.Object r9 = r4.get()
                r8.onNext(r9)
                return r0
            L_0x0026:
                return r1
            L_0x0027:
                r4 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r5 = r8.errorHandler     // Catch:{ all -> 0x005d }
                r6 = 1
                long r2 = r2 + r6
                java.lang.Long r6 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x005d }
                java.lang.Object r5 = r5.apply(r6, r4)     // Catch:{ all -> 0x005d }
                java.lang.String r6 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r5, r6)     // Catch:{ all -> 0x005d }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r5 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r5     // Catch:{ all -> 0x005d }
                int[] r6 = io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional.AnonymousClass1.$SwitchMap$io$reactivex$rxjava3$parallel$ParallelFailureHandling
                int r5 = r5.ordinal()
                r5 = r6[r5]
                if (r5 == r0) goto L_0x0008
                r9 = 2
                if (r5 == r9) goto L_0x005c
                r9 = 3
                if (r5 == r9) goto L_0x0056
                r8.cancel()
                r8.onError(r4)
                return r1
            L_0x0056:
                r8.cancel()
                r8.onComplete()
            L_0x005c:
                return r1
            L_0x005d:
                r9 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r9)
                r8.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r0 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r9 = new java.lang.Throwable[]{r4, r9}
                r0.<init>((java.lang.Throwable[]) r9)
                r8.onError(r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional.ParallelMapTrySubscriber.tryOnNext(java.lang.Object):boolean");
        }
    }

    public ParallelMapTryOptional(ParallelFlowable<T> parallelFlowable, Function<? super T, Optional<? extends R>> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
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
