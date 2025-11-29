package io.reactivex.rxjava3.internal.operators.parallel;

import com.honey.account.x.c;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelSortedJoin<T> extends Flowable<T> {
    final Comparator<? super T> comparator;
    final ParallelFlowable<List<T>> source;

    public static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final SortedJoinSubscription<T> parent;

        public SortedJoinInnerSubscriber(SortedJoinSubscription<T> sortedJoinSubscription, int i) {
            this.parent = sortedJoinSubscription;
            this.index = i;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, LongCompanionObject.MAX_VALUE);
        }

        public void onNext(List<T> list) {
            this.parent.innerNext(list, this.index);
        }
    }

    public static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3481980673745556697L;
        volatile boolean cancelled;
        final Comparator<? super T> comparator;
        final Subscriber<? super T> downstream;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final int[] indexes;
        final List<T>[] lists;
        final AtomicInteger remaining = new AtomicInteger();
        final AtomicLong requested = new AtomicLong();
        final SortedJoinInnerSubscriber<T>[] subscribers;

        public SortedJoinSubscription(Subscriber<? super T> subscriber, int i, Comparator<? super T> comparator2) {
            this.downstream = subscriber;
            this.comparator = comparator2;
            SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr = new SortedJoinInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                sortedJoinInnerSubscriberArr[i2] = new SortedJoinInnerSubscriber<>(this, i2);
            }
            this.subscribers = sortedJoinInnerSubscriberArr;
            this.lists = new List[i];
            this.indexes = new int[i];
            this.remaining.lazySet(i);
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    Arrays.fill(this.lists, (Object) null);
                }
            }
        }

        public void cancelAll() {
            for (SortedJoinInnerSubscriber<T> cancel : this.subscribers) {
                cancel.cancel();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a0, code lost:
            if (r1.cancelled == false) goto L_0x00a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a2, code lost:
            java.util.Arrays.fill(r3, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a6, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a7, code lost:
            r7 = r1.error.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b0, code lost:
            if (r7 == null) goto L_0x00bc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b2, code lost:
            cancelAll();
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onError(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bb, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bc, code lost:
            if (r14 >= r4) goto L_0x00e0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c6, code lost:
            if (r0[r14] == r3[r14].size()) goto L_0x00db;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00cc, code lost:
            if (r11 == 0) goto L_0x00d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ce, code lost:
            io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r1.requested, r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d3, code lost:
            r6 = addAndGet(-r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00db, code lost:
            r14 = r14 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e0, code lost:
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e7, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
                r16 = this;
                r1 = r16
                int r0 = r16.getAndIncrement()
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                org.reactivestreams.Subscriber<? super T> r2 = r1.downstream
                java.util.List<T>[] r3 = r1.lists
                int[] r0 = r1.indexes
                int r4 = r0.length
                r6 = 1
            L_0x0011:
                java.util.concurrent.atomic.AtomicLong r7 = r1.requested
                long r7 = r7.get()
                r11 = 0
            L_0x0019:
                int r13 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
                r14 = 0
                r15 = 0
                if (r13 == 0) goto L_0x009d
                boolean r13 = r1.cancelled
                if (r13 == 0) goto L_0x0027
                java.util.Arrays.fill(r3, r15)
                return
            L_0x0027:
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r13 = r1.error
                java.lang.Object r13 = r13.get()
                java.lang.Throwable r13 = (java.lang.Throwable) r13
                if (r13 == 0) goto L_0x003b
                r16.cancelAll()
                java.util.Arrays.fill(r3, r15)
                r2.onError(r13)
                return
            L_0x003b:
                r13 = -1
                r9 = r15
            L_0x003d:
                if (r14 >= r4) goto L_0x0085
                r10 = r3[r14]
                r5 = r0[r14]
                int r15 = r10.size()
                if (r15 == r5) goto L_0x0081
                if (r9 != 0) goto L_0x0051
                java.lang.Object r9 = r10.get(r5)
            L_0x004f:
                r13 = r14
                goto L_0x0081
            L_0x0051:
                java.lang.Object r5 = r10.get(r5)
                java.util.Comparator<? super T> r10 = r1.comparator     // Catch:{ all -> 0x005f }
                int r10 = r10.compare(r9, r5)     // Catch:{ all -> 0x005f }
                if (r10 <= 0) goto L_0x0081
                r9 = r5
                goto L_0x004f
            L_0x005f:
                r0 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
                r16.cancelAll()
                r4 = 0
                java.util.Arrays.fill(r3, r4)
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r3 = r1.error
                boolean r3 = com.honey.account.x.c.a(r3, r4, r0)
                if (r3 != 0) goto L_0x0075
                io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r0)
            L_0x0075:
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r1.error
                java.lang.Object r0 = r0.get()
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                r2.onError(r0)
                return
            L_0x0081:
                int r14 = r14 + 1
                r15 = 0
                goto L_0x003d
            L_0x0085:
                if (r9 != 0) goto L_0x008f
                r5 = 0
                java.util.Arrays.fill(r3, r5)
                r2.onComplete()
                return
            L_0x008f:
                r2.onNext(r9)
                r5 = r0[r13]
                r9 = 1
                int r5 = r5 + r9
                r0[r13] = r5
                r13 = 1
                long r11 = r11 + r13
                goto L_0x0019
            L_0x009d:
                r9 = 1
                boolean r5 = r1.cancelled
                if (r5 == 0) goto L_0x00a7
                r5 = 0
                java.util.Arrays.fill(r3, r5)
                return
            L_0x00a7:
                r5 = 0
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r7 = r1.error
                java.lang.Object r7 = r7.get()
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L_0x00bc
                r16.cancelAll()
                java.util.Arrays.fill(r3, r5)
                r2.onError(r7)
                return
            L_0x00bc:
                if (r14 >= r4) goto L_0x00e0
                r5 = r0[r14]
                r7 = r3[r14]
                int r7 = r7.size()
                if (r5 == r7) goto L_0x00db
                r7 = 0
                int r5 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
                if (r5 == 0) goto L_0x00d3
                java.util.concurrent.atomic.AtomicLong r5 = r1.requested
                io.reactivex.rxjava3.internal.util.BackpressureHelper.produced(r5, r11)
            L_0x00d3:
                int r5 = -r6
                int r6 = r1.addAndGet(r5)
                if (r6 != 0) goto L_0x0011
                return
            L_0x00db:
                r7 = 0
                int r14 = r14 + 1
                goto L_0x00bc
            L_0x00e0:
                r5 = 0
                java.util.Arrays.fill(r3, r5)
                r2.onComplete()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelSortedJoin.SortedJoinSubscription.drain():void");
        }

        public void innerError(Throwable th) {
            if (c.a(this.error, (Object) null, th)) {
                drain();
            } else if (th != this.error.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        public void innerNext(List<T> list, int i) {
            this.lists[i] = list;
            if (this.remaining.decrementAndGet() == 0) {
                drain();
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                if (this.remaining.get() == 0) {
                    drain();
                }
            }
        }
    }

    public ParallelSortedJoin(ParallelFlowable<List<T>> parallelFlowable, Comparator<? super T> comparator2) {
        this.source = parallelFlowable;
        this.comparator = comparator2;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(subscriber, this.source.parallelism(), this.comparator);
        subscriber.onSubscribe(sortedJoinSubscription);
        this.source.subscribe(sortedJoinSubscription.subscribers);
    }
}
