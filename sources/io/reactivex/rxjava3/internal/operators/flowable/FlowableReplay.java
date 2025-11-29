package io.reactivex.rxjava3.internal.operators.flowable;

import com.honey.account.x.c;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
    static final Supplier DEFAULT_UNBOUNDED_FACTORY = new DefaultUnboundedFactory();
    final Supplier<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final Flowable<T> source;

    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        final boolean eagerTruncate;
        long index;
        int size;
        Node tail;

        public BoundedReplayBuffer(boolean z) {
            this.eagerTruncate = z;
            Node node = new Node((Object) null, 0);
            this.tail = node;
            set(node);
        }

        public final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        public final void collect(Collection<? super T> collection) {
            Node head = getHead();
            while (true) {
                head = (Node) head.get();
                if (head != null) {
                    Object leaveTransform = leaveTransform(head.value);
                    if (!NotificationLite.isComplete(leaveTransform) && !NotificationLite.isError(leaveTransform)) {
                        collection.add(NotificationLite.getValue(leaveTransform));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.complete(), true);
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        public Object enterTransform(Object obj, boolean z) {
            return obj;
        }

        public final void error(Throwable th) {
            Object enterTransform = enterTransform(NotificationLite.error(th), true);
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        public Node getHead() {
            return (Node) get();
        }

        public boolean hasCompleted() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isComplete(leaveTransform(obj));
        }

        public boolean hasError() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isError(leaveTransform(obj));
        }

        public Object leaveTransform(Object obj) {
            return obj;
        }

        public final void next(T t) {
            Object enterTransform = enterTransform(NotificationLite.next(t), false);
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncate();
        }

        public final void removeFirst() {
            Node node = (Node) ((Node) get()).get();
            if (node != null) {
                this.size--;
                setFirst(node);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        public final void removeSome(int i) {
            Node node = (Node) get();
            while (i > 0) {
                node = (Node) node.get();
                i--;
                this.size--;
            }
            setFirst(node);
            Node node2 = (Node) get();
            if (node2.get() == null) {
                this.tail = node2;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
            r2 = r14.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
            if (r2 != kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x0020;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
            r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r14.index();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
            if (r5 != null) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
            r5 = getHead();
            r14.index = r5;
            io.reactivex.rxjava3.internal.util.BackpressureHelper.add(r14.totalRequested, r5.index);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
            r8 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            r10 = (r2 > 0 ? 1 : (r2 == 0 ? 0 : -1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
            if (r10 == 0) goto L_0x0086;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
            if (r14.isDisposed() == false) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
            r14.index = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
            r12 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r5.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004d, code lost:
            if (r12 == null) goto L_0x0086;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004f, code lost:
            r5 = leaveTransform(r12.value);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005b, code lost:
            if (io.reactivex.rxjava3.internal.util.NotificationLite.accept(r5, r14.child) == false) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005d, code lost:
            r14.index = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
            r13 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0062, code lost:
            r8 = r8 + 1;
            r2 = r2 - 1;
            r5 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0068, code lost:
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r13);
            r14.index = null;
            r14.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0074, code lost:
            if (io.reactivex.rxjava3.internal.util.NotificationLite.isError(r5) != false) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x007c, code lost:
            r14.child.onError(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0082, code lost:
            io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0086, code lost:
            if (r10 != 0) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x008c, code lost:
            if (r14.isDisposed() == false) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x008e, code lost:
            r14.index = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0090, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0093, code lost:
            if (r8 == 0) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0095, code lost:
            r14.index = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0097, code lost:
            if (r0 != false) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0099, code lost:
            r14.produced(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x009c, code lost:
            monitor-enter(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009f, code lost:
            if (r14.missed != false) goto L_0x00a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a1, code lost:
            r14.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a3, code lost:
            monitor-exit(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a4, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a5, code lost:
            r13 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00a7, code lost:
            r14.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a9, code lost:
            monitor-exit(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ad, code lost:
            throw r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void replay(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r14) {
            /*
                r13 = this;
                monitor-enter(r14)
                boolean r0 = r14.emitting     // Catch:{ all -> 0x000a }
                r1 = 1
                if (r0 == 0) goto L_0x000d
                r14.missed = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r14)     // Catch:{ all -> 0x000a }
                return
            L_0x000a:
                r13 = move-exception
                goto L_0x00ae
            L_0x000d:
                r14.emitting = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r14)     // Catch:{ all -> 0x000a }
            L_0x0010:
                long r2 = r14.get()
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                r4 = 0
                if (r0 != 0) goto L_0x0020
                r0 = r1
                goto L_0x0021
            L_0x0020:
                r0 = r4
            L_0x0021:
                java.lang.Object r5 = r14.index()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r5
                r6 = 0
                if (r5 != 0) goto L_0x0038
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r5 = r13.getHead()
                r14.index = r5
                java.util.concurrent.atomic.AtomicLong r8 = r14.totalRequested
                long r9 = r5.index
                io.reactivex.rxjava3.internal.util.BackpressureHelper.add(r8, r9)
            L_0x0038:
                r8 = r6
            L_0x0039:
                int r10 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                r11 = 0
                if (r10 == 0) goto L_0x0086
                boolean r12 = r14.isDisposed()
                if (r12 == 0) goto L_0x0047
                r14.index = r11
                return
            L_0x0047:
                java.lang.Object r12 = r5.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r12 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r12
                if (r12 == 0) goto L_0x0086
                java.lang.Object r5 = r12.value
                java.lang.Object r5 = r13.leaveTransform(r5)
                org.reactivestreams.Subscriber<? super T> r10 = r14.child     // Catch:{ all -> 0x0060 }
                boolean r10 = io.reactivex.rxjava3.internal.util.NotificationLite.accept((java.lang.Object) r5, r10)     // Catch:{ all -> 0x0060 }
                if (r10 == 0) goto L_0x0062
                r14.index = r11     // Catch:{ all -> 0x0060 }
                return
            L_0x0060:
                r13 = move-exception
                goto L_0x0068
            L_0x0062:
                r10 = 1
                long r8 = r8 + r10
                long r2 = r2 - r10
                r5 = r12
                goto L_0x0039
            L_0x0068:
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r13)
                r14.index = r11
                r14.dispose()
                boolean r0 = io.reactivex.rxjava3.internal.util.NotificationLite.isError(r5)
                if (r0 != 0) goto L_0x0082
                boolean r0 = io.reactivex.rxjava3.internal.util.NotificationLite.isComplete(r5)
                if (r0 != 0) goto L_0x0082
                org.reactivestreams.Subscriber<? super T> r14 = r14.child
                r14.onError(r13)
                goto L_0x0085
            L_0x0082:
                io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r13)
            L_0x0085:
                return
            L_0x0086:
                if (r10 != 0) goto L_0x0091
                boolean r2 = r14.isDisposed()
                if (r2 == 0) goto L_0x0091
                r14.index = r11
                return
            L_0x0091:
                int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r2 == 0) goto L_0x009c
                r14.index = r5
                if (r0 != 0) goto L_0x009c
                r14.produced(r8)
            L_0x009c:
                monitor-enter(r14)
                boolean r0 = r14.missed     // Catch:{ all -> 0x00a5 }
                if (r0 != 0) goto L_0x00a7
                r14.emitting = r4     // Catch:{ all -> 0x00a5 }
                monitor-exit(r14)     // Catch:{ all -> 0x00a5 }
                return
            L_0x00a5:
                r13 = move-exception
                goto L_0x00ac
            L_0x00a7:
                r14.missed = r4     // Catch:{ all -> 0x00a5 }
                monitor-exit(r14)     // Catch:{ all -> 0x00a5 }
                goto L_0x0010
            L_0x00ac:
                monitor-exit(r14)     // Catch:{ all -> 0x00a5 }
                throw r13
            L_0x00ae:
                monitor-exit(r14)     // Catch:{ all -> 0x000a }
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer.replay(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }

        public final void setFirst(Node node) {
            if (this.eagerTruncate) {
                Node node2 = new Node((Object) null, node.index);
                node2.lazySet(node.get());
                node = node2;
            }
            set(node);
        }

        public final void trimHead() {
            Node node = (Node) get();
            if (node.value != null) {
                Node node2 = new Node((Object) null, 0);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        public abstract void truncate();

        public void truncateFinal() {
            trimHead();
        }
    }

    public static final class DefaultUnboundedFactory implements Supplier<Object> {
        public Object get() {
            return new UnboundedReplayBuffer(16);
        }
    }

    public static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        public InnerSubscription(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.parent = replaySubscriber;
            this.child = subscriber;
        }

        public void cancel() {
            dispose();
        }

        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.manageRequests();
                this.index = null;
            }
        }

        public <U> U index() {
            return this.index;
        }

        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        public long produced(long j) {
            return BackpressureHelper.producedCancel(this, j);
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.addCancel(this, j) != Long.MIN_VALUE) {
                BackpressureHelper.add(this.totalRequested, j);
                this.parent.manageRequests();
                this.parent.buffer.replay(this);
            }
        }
    }

    public static final class MulticastFlowable<R, U> extends Flowable<R> {
        private final Supplier<? extends ConnectableFlowable<U>> connectableFactory;
        private final Function<? super Flowable<U>, ? extends Publisher<R>> selector;

        public final class DisposableConsumer implements Consumer<Disposable> {
            private final SubscriberResourceWrapper<R> srw;

            public DisposableConsumer(SubscriberResourceWrapper<R> subscriberResourceWrapper) {
                this.srw = subscriberResourceWrapper;
            }

            public void accept(Disposable disposable) {
                this.srw.setResource(disposable);
            }
        }

        public MulticastFlowable(Supplier<? extends ConnectableFlowable<U>> supplier, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
            this.connectableFactory = supplier;
            this.selector = function;
        }

        public void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                ConnectableFlowable connectableFlowable = (ConnectableFlowable) ExceptionHelper.nullCheck(this.connectableFactory.get(), "The connectableFactory returned a null ConnectableFlowable.");
                try {
                    Publisher publisher = (Publisher) ExceptionHelper.nullCheck(this.selector.apply(connectableFlowable), "The selector returned a null Publisher.");
                    SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(subscriber);
                    publisher.subscribe(subscriberResourceWrapper);
                    connectableFlowable.connect(new DisposableConsumer(subscriberResourceWrapper));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, subscriber);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
            }
        }
    }

    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        public Node(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerSubscription<T> innerSubscription);
    }

    public static final class ReplayBufferSupplier<T> implements Supplier<ReplayBuffer<T>> {
        final int bufferSize;
        final boolean eagerTruncate;

        public ReplayBufferSupplier(int i, boolean z) {
            this.bufferSize = i;
            this.eagerTruncate = z;
        }

        public ReplayBuffer<T> get() {
            return new SizeBoundReplayBuffer(this.bufferSize, this.eagerTruncate);
        }
    }

    public static final class ReplayPublisher<T> implements Publisher<T> {
        private final Supplier<? extends ReplayBuffer<T>> bufferFactory;
        private final AtomicReference<ReplaySubscriber<T>> curr;

        public ReplayPublisher(AtomicReference<ReplaySubscriber<T>> atomicReference, Supplier<? extends ReplayBuffer<T>> supplier) {
            this.curr = atomicReference;
            this.bufferFactory = supplier;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void subscribe(org.reactivestreams.Subscriber<? super T> r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r0 = r3.curr
                java.lang.Object r0 = r0.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplaySubscriber) r0
                if (r0 != 0) goto L_0x002d
                io.reactivex.rxjava3.functions.Supplier<? extends io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer<T>> r0 = r3.bufferFactory     // Catch:{ all -> 0x0025 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0025 }
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer) r0     // Catch:{ all -> 0x0025 }
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber r1 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r2 = r3.curr
                r1.<init>(r0, r2)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r0 = r3.curr
                r2 = 0
                boolean r0 = com.honey.account.x.c.a(r0, r2, r1)
                if (r0 != 0) goto L_0x0023
                goto L_0x0000
            L_0x0023:
                r0 = r1
                goto L_0x002d
            L_0x0025:
                r3 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r3)
                io.reactivex.rxjava3.internal.subscriptions.EmptySubscription.error(r3, r4)
                return
            L_0x002d:
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription r3 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription
                r3.<init>(r0, r4)
                r4.onSubscribe(r3)
                r0.add(r3)
                boolean r4 = r3.isDisposed()
                if (r4 == 0) goto L_0x0042
                r0.remove(r3)
                return
            L_0x0042:
                r0.manageRequests()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer<T> r4 = r0.buffer
                r4.replay(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayPublisher.subscribe(org.reactivestreams.Subscriber):void");
        }
    }

    public static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] EMPTY = new InnerSubscription[0];
        static final InnerSubscription[] TERMINATED = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;
        final ReplayBuffer<T> buffer;
        final AtomicReference<ReplaySubscriber<T>> current;
        boolean done;
        final AtomicInteger management = new AtomicInteger();
        long requestedFromUpstream;
        final AtomicBoolean shouldConnect = new AtomicBoolean();
        final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);

        public ReplaySubscriber(ReplayBuffer<T> replayBuffer, AtomicReference<ReplaySubscriber<T>> atomicReference) {
            this.buffer = replayBuffer;
            this.current = atomicReference;
        }

        public boolean add(InnerSubscription<T> innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.subscribers.get();
                if (innerSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[(length + 1)];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!c.a(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        public void dispose() {
            this.subscribers.set(TERMINATED);
            c.a(this.current, this, (Object) null);
            SubscriptionHelper.cancel(this);
        }

        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        public void manageRequests() {
            AtomicInteger atomicInteger = this.management;
            if (atomicInteger.getAndIncrement() == 0) {
                int i = 1;
                while (!isDisposed()) {
                    Subscription subscription = (Subscription) get();
                    if (subscription != null) {
                        long j = this.requestedFromUpstream;
                        long j2 = j;
                        for (InnerSubscription innerSubscription : (InnerSubscription[]) this.subscribers.get()) {
                            j2 = Math.max(j2, innerSubscription.totalRequested.get());
                        }
                        long j3 = j2 - j;
                        if (j3 != 0) {
                            this.requestedFromUpstream = j2;
                            subscription.request(j3);
                        }
                    }
                    i = atomicInteger.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.buffer.complete();
                for (InnerSubscription replay : (InnerSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(replay);
                }
            }
        }

        public void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                this.buffer.error(th);
                for (InnerSubscription replay : (InnerSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                    this.buffer.replay(replay);
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                for (InnerSubscription replay : (InnerSubscription[]) this.subscribers.get()) {
                    this.buffer.replay(replay);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                manageRequests();
                for (InnerSubscription replay : (InnerSubscription[]) this.subscribers.get()) {
                    this.buffer.replay(replay);
                }
            }
        }

        public void remove(InnerSubscription<T> innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length != 0) {
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        } else if (innerSubscriptionArr[i].equals(innerSubscription)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerSubscriptionArr2 = EMPTY;
                        } else {
                            InnerSubscription[] innerSubscriptionArr3 = new InnerSubscription[(length - 1)];
                            System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i);
                            System.arraycopy(innerSubscriptionArr, i + 1, innerSubscriptionArr3, i, (length - i) - 1);
                            innerSubscriptionArr2 = innerSubscriptionArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!c.a(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
        }
    }

    public static final class ScheduledReplayBufferSupplier<T> implements Supplier<ReplayBuffer<T>> {
        private final int bufferSize;
        final boolean eagerTruncate;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        public ScheduledReplayBufferSupplier(int i, long j, TimeUnit timeUnit, Scheduler scheduler2, boolean z) {
            this.bufferSize = i;
            this.maxAge = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.eagerTruncate = z;
        }

        public ReplayBuffer<T> get() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler, this.eagerTruncate);
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final Scheduler scheduler;
        final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler2, boolean z) {
            super(z);
            this.scheduler = scheduler2;
            this.limit = i;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        public Object enterTransform(Object obj, boolean z) {
            return new Timed(obj, z ? LongCompanionObject.MAX_VALUE : this.scheduler.now(this.unit), this.unit);
        }

        public Node getHead() {
            Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node2 = (Node) get();
            Object obj = node2.get();
            while (true) {
                Node node3 = (Node) obj;
                node = node2;
                node2 = node3;
                if (node2 != null) {
                    Timed timed = (Timed) node2.value;
                    if (NotificationLite.isComplete(timed.value()) || NotificationLite.isError(timed.value()) || timed.time() > now) {
                        break;
                    }
                    obj = node2.get();
                } else {
                    break;
                }
            }
            return node;
        }

        public Object leaveTransform(Object obj) {
            return ((Timed) obj).value();
        }

        public void truncate() {
            Node node;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Node node2 = (Node) get();
            Node node3 = (Node) node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                int i2 = this.size;
                if (i2 > 1) {
                    if (i2 <= this.limit) {
                        if (((Timed) node2.value).time() > now) {
                            break;
                        }
                        i++;
                        this.size--;
                        node3 = (Node) node2.get();
                    } else {
                        i++;
                        this.size = i2 - 1;
                        node3 = (Node) node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                setFirst(node);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void truncateFinal() {
            /*
                r10 = this;
                io.reactivex.rxjava3.core.Scheduler r0 = r10.scheduler
                java.util.concurrent.TimeUnit r1 = r10.unit
                long r0 = r0.now(r1)
                long r2 = r10.maxAge
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r2 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r2
                java.lang.Object r3 = r2.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r3 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r3
                r4 = 0
            L_0x0018:
                r9 = r3
                r3 = r2
                r2 = r9
                int r5 = r10.size
                r6 = 1
                if (r5 <= r6) goto L_0x003a
                java.lang.Object r5 = r2.value
                io.reactivex.rxjava3.schedulers.Timed r5 = (io.reactivex.rxjava3.schedulers.Timed) r5
                long r7 = r5.time()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L_0x003a
                int r4 = r4 + 1
                int r3 = r10.size
                int r3 = r3 - r6
                r10.size = r3
                java.lang.Object r3 = r2.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$Node r3 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.Node) r3
                goto L_0x0018
            L_0x003a:
                if (r4 == 0) goto L_0x003f
                r10.setFirst(r3)
            L_0x003f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.SizeAndTimeBoundReplayBuffer.truncateFinal():void");
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        public SizeBoundReplayBuffer(int i, boolean z) {
            super(z);
            this.limit = i;
        }

        public void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        public UnboundedReplayBuffer(int i) {
            super(i);
        }

        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        public void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        public void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
            r0 = r15.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
            if (r15.isDisposed() == false) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0019, code lost:
            r1 = r14.size;
            r2 = (java.lang.Integer) r15.index();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
            if (r2 == null) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0024, code lost:
            r2 = r2.intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
            r4 = r15.get();
            r8 = r4;
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
            if (r8 == 0) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
            if (r2 >= r1) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0038, code lost:
            r12 = get(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
            if (io.reactivex.rxjava3.internal.util.NotificationLite.accept(r12, r0) == false) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0042, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
            if (r15.isDisposed() == false) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0049, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x004a, code lost:
            r2 = r2 + 1;
            r8 = r8 - 1;
            r10 = r10 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0051, code lost:
            r14 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0052, code lost:
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r14);
            r15.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005c, code lost:
            if (io.reactivex.rxjava3.internal.util.NotificationLite.isError(r12) != false) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0064, code lost:
            r0.onError(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0068, code lost:
            io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x006e, code lost:
            if (r10 == 0) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0070, code lost:
            r15.index = java.lang.Integer.valueOf(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x007d, code lost:
            if (r4 == kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x007f, code lost:
            r15.produced(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0082, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0085, code lost:
            if (r15.missed != false) goto L_0x008d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0087, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0089, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x008a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x008b, code lost:
            r14 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x008d, code lost:
            r15.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x008f, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0092, code lost:
            throw r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.InnerSubscription<T> r15) {
            /*
                r14 = this;
                monitor-enter(r15)
                boolean r0 = r15.emitting     // Catch:{ all -> 0x000a }
                r1 = 1
                if (r0 == 0) goto L_0x000d
                r15.missed = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r15)     // Catch:{ all -> 0x000a }
                return
            L_0x000a:
                r14 = move-exception
                goto L_0x0093
            L_0x000d:
                r15.emitting = r1     // Catch:{ all -> 0x000a }
                monitor-exit(r15)     // Catch:{ all -> 0x000a }
                org.reactivestreams.Subscriber<? super T> r0 = r15.child
            L_0x0012:
                boolean r1 = r15.isDisposed()
                if (r1 == 0) goto L_0x0019
                return
            L_0x0019:
                int r1 = r14.size
                java.lang.Object r2 = r15.index()
                java.lang.Integer r2 = (java.lang.Integer) r2
                r3 = 0
                if (r2 == 0) goto L_0x0029
                int r2 = r2.intValue()
                goto L_0x002a
            L_0x0029:
                r2 = r3
            L_0x002a:
                long r4 = r15.get()
                r6 = 0
                r8 = r4
                r10 = r6
            L_0x0032:
                int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r12 == 0) goto L_0x006c
                if (r2 >= r1) goto L_0x006c
                java.lang.Object r12 = r14.get(r2)
                boolean r12 = io.reactivex.rxjava3.internal.util.NotificationLite.accept((java.lang.Object) r12, r0)     // Catch:{ all -> 0x0051 }
                if (r12 == 0) goto L_0x0043
                return
            L_0x0043:
                boolean r12 = r15.isDisposed()
                if (r12 == 0) goto L_0x004a
                return
            L_0x004a:
                int r2 = r2 + 1
                r12 = 1
                long r8 = r8 - r12
                long r10 = r10 + r12
                goto L_0x0032
            L_0x0051:
                r14 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r14)
                r15.dispose()
                boolean r15 = io.reactivex.rxjava3.internal.util.NotificationLite.isError(r12)
                if (r15 != 0) goto L_0x0068
                boolean r15 = io.reactivex.rxjava3.internal.util.NotificationLite.isComplete(r12)
                if (r15 != 0) goto L_0x0068
                r0.onError(r14)
                goto L_0x006b
            L_0x0068:
                io.reactivex.rxjava3.plugins.RxJavaPlugins.onError(r14)
            L_0x006b:
                return
            L_0x006c:
                int r1 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r1 == 0) goto L_0x0082
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r15.index = r1
                r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                if (r1 == 0) goto L_0x0082
                r15.produced(r10)
            L_0x0082:
                monitor-enter(r15)
                boolean r1 = r15.missed     // Catch:{ all -> 0x008b }
                if (r1 != 0) goto L_0x008d
                r15.emitting = r3     // Catch:{ all -> 0x008b }
                monitor-exit(r15)     // Catch:{ all -> 0x008b }
                return
            L_0x008b:
                r14 = move-exception
                goto L_0x0091
            L_0x008d:
                r15.missed = r3     // Catch:{ all -> 0x008b }
                monitor-exit(r15)     // Catch:{ all -> 0x008b }
                goto L_0x0012
            L_0x0091:
                monitor-exit(r15)     // Catch:{ all -> 0x008b }
                throw r14
            L_0x0093:
                monitor-exit(r15)     // Catch:{ all -> 0x000a }
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.UnboundedReplayBuffer.replay(io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
        }
    }

    private FlowableReplay(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<ReplaySubscriber<T>> atomicReference, Supplier<? extends ReplayBuffer<T>> supplier) {
        this.onSubscribe = publisher;
        this.source = flowable;
        this.current = atomicReference;
        this.bufferFactory = supplier;
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int i, boolean z) {
        if (i == Integer.MAX_VALUE) {
            return createFrom(flowable);
        }
        return create(flowable, new ReplayBufferSupplier(i, z));
    }

    public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> flowable) {
        return create(flowable, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <U, R> Flowable<R> multicastSelector(Supplier<? extends ConnectableFlowable<U>> supplier, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
        return new MulticastFlowable(supplier, function);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(io.reactivex.rxjava3.functions.Consumer<? super io.reactivex.rxjava3.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r0 = r4.current
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber r0 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplaySubscriber) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0029
        L_0x0010:
            io.reactivex.rxjava3.functions.Supplier<? extends io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer<T>> r1 = r4.bufferFactory     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x005c }
            io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplayBuffer r1 = (io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.ReplayBuffer) r1     // Catch:{ all -> 0x005c }
            io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber r2 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r3 = r4.current
            r2.<init>(r1, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay$ReplaySubscriber<T>> r1 = r4.current
            boolean r0 = com.honey.account.x.c.a(r1, r0, r2)
            if (r0 != 0) goto L_0x0028
            goto L_0x0000
        L_0x0028:
            r0 = r2
        L_0x0029:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.shouldConnect
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x003d
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.shouldConnect
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x003d
            r1 = r2
            goto L_0x003e
        L_0x003d:
            r1 = r3
        L_0x003e:
            r5.accept(r0)     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0048
            io.reactivex.rxjava3.core.Flowable<T> r4 = r4.source
            r4.subscribe(r0)
        L_0x0048:
            return
        L_0x0049:
            r4 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
            if (r1 == 0) goto L_0x0054
            java.util.concurrent.atomic.AtomicBoolean r5 = r0.shouldConnect
            r5.compareAndSet(r2, r3)
        L_0x0054:
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
            java.lang.RuntimeException r4 = io.reactivex.rxjava3.internal.util.ExceptionHelper.wrapOrThrow(r4)
            throw r4
        L_0x005c:
            r4 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r4)
            java.lang.RuntimeException r4 = io.reactivex.rxjava3.internal.util.ExceptionHelper.wrapOrThrow(r4)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay.connect(io.reactivex.rxjava3.functions.Consumer):void");
    }

    public void reset() {
        ReplaySubscriber replaySubscriber = this.current.get();
        if (replaySubscriber != null && replaySubscriber.isDisposed()) {
            c.a(this.current, replaySubscriber, (Object) null);
        }
    }

    public Publisher<T> source() {
        return this.source;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.onSubscribe.subscribe(subscriber);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return create(flowable, j, timeUnit, scheduler, Integer.MAX_VALUE, z);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        return create(flowable, new ScheduledReplayBufferSupplier(i, j, timeUnit, scheduler, z));
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, Supplier<? extends ReplayBuffer<T>> supplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly(new FlowableReplay(new ReplayPublisher(atomicReference, supplier), flowable, atomicReference, supplier));
    }
}
